package com.blueair.database.repository;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.blueair.auth.LocationService;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceOnBlueServer;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.DeviceAlarmListConverter;
import com.blueair.database.DeviceField;
import com.blueair.database.DoubleArrayConverter;
import com.blueair.database.dao.DeviceDao;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.database.entity.DeviceEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00142\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J.\u00100\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u000205J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u00104\u001a\u000205J\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002080\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0018\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002080:0\u001aJ\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u00142\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0010J\u000e\u0010=\u001a\u00020)2\u0006\u0010?\u001a\u00020@J\u000e\u0010=\u001a\u00020)2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020EH\u0002J2\u0010F\u001a\u00020)\"\u0004\b\u0000\u0010G2\u0006\u0010\u001f\u001a\u00020 2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030I2\b\u0010J\u001a\u0004\u0018\u0001HGH\u0086@¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0010H\u0007J\u001e\u0010M\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010N\u001a\u000202H\u0086@¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u000205J\b\u0010R\u001a\u00020)H\u0007J\u0010\u0010S\u001a\u0002022\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c¨\u0006T"},
   d2 = {"Lcom/blueair/database/repository/DeviceRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "locationRepository", "Lcom/blueair/database/repository/TrackedLocationRepository;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lcom/blueair/database/BlueairDatabase;Lcom/blueair/database/repository/TrackedLocationRepository;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/core/service/AnalyticsService;Lcom/blueair/auth/LocationService;)V", "devices", "", "Lcom/blueair/core/model/Device;", "getDevices", "()Ljava/util/List;", "liveDevices", "Landroidx/lifecycle/LiveData;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "liveDevices$delegate", "Lkotlin/Lazy;", "flowDevices", "Lkotlinx/coroutines/flow/Flow;", "getFlowDevices", "()Lkotlinx/coroutines/flow/Flow;", "flowDevices$delegate", "liveDevice", "deviceId", "", "getDevice", "getFlowHasSensorDevice", "Lcom/blueair/core/model/HasSensorData;", "getFlowHasWelcomeHomeDevice", "Lcom/blueair/core/model/HasWelcomeHome;", "getAllDevices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDeviceData", "", "deviceData", "Lcom/blueair/core/model/DeviceData;", "dataTrend", "Lcom/blueair/core/model/DataTrend;", "(Lcom/blueair/core/model/DeviceData;Lcom/blueair/core/model/DataTrend;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAndReplaceDeviceData", "getFlowDeviceDataBetween", "startInclusive", "", "endInclusive", "allowRealTime", "", "getFlowLatestDatapointAsDeviceData", "getFlowLatestDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getFlowLatestDatapointForAllDevices", "", "getFlowRealTimeDeviceData", "getLiveLatestDeviceData", "updateDevice", "device", "deviceAbl", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "deviceBlue", "Lcom/blueair/core/model/DeviceOnBlueServer;", "updateDeviceEntity", "deviceEntity", "Lcom/blueair/database/entity/DeviceEntity;", "updateDeviceField", "T", "field", "Lcom/blueair/database/DeviceField;", "newValue", "(Ljava/lang/String;Lcom/blueair/database/DeviceField;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "deleteOldDeviceData", "monthAgoSeconds", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllDevicesBackground", "isAblDevice", "deleteAllDevices", "getLatestHistoricalDataTime", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceRepository {
   private final AnalyticsService analyticsService;
   private final BlueairDatabase blueairDb;
   private final Lazy flowDevices$delegate;
   private final Lazy liveDevices$delegate;
   private final TrackedLocationRepository locationRepository;
   private final LocationService locationService;
   private final UnsecurePrefs prefs;

   // $FF: synthetic method
   public static Device $r8$lambda$_XGolboK5uZdxb1dtGywjkCkgJc/* $FF was: $r8$lambda$-XGolboK5uZdxb1dtGywjkCkgJc*/(DeviceEntity var0) {
      return liveDevice$lambda$5(var0);
   }

   // $FF: synthetic method
   public static DeviceData $r8$lambda$M35j8Oyif5l3Iv3Jh_88bq_wr0g(DeviceRepository var0, DeviceDataEntity var1) {
      return getLiveLatestDeviceData$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Flow $r8$lambda$OLCC1mNBsNEAUr0yv_kMxjVuIoI/* $FF was: $r8$lambda$OLCC1mNBsNEAUr0yv-kMxjVuIoI*/(DeviceRepository var0) {
      return flowDevices_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static LiveData $r8$lambda$zNvnkn8ST7oqgknIPogHXrWQpkc(DeviceRepository var0) {
      return liveDevices_delegate$lambda$1(var0);
   }

   public DeviceRepository(BlueairDatabase var1, TrackedLocationRepository var2, UnsecurePrefs var3, AnalyticsService var4, LocationService var5) {
      Intrinsics.checkNotNullParameter(var1, "blueairDb");
      Intrinsics.checkNotNullParameter(var2, "locationRepository");
      Intrinsics.checkNotNullParameter(var3, "prefs");
      Intrinsics.checkNotNullParameter(var4, "analyticsService");
      Intrinsics.checkNotNullParameter(var5, "locationService");
      super();
      this.blueairDb = var1;
      this.locationRepository = var2;
      this.prefs = var3;
      this.analyticsService = var4;
      this.locationService = var5;
      this.liveDevices$delegate = LazyKt.lazy(new DeviceRepository$$ExternalSyntheticLambda0(this));
      this.flowDevices$delegate = LazyKt.lazy(new DeviceRepository$$ExternalSyntheticLambda1(this));
   }

   private static final Flow flowDevices_delegate$lambda$4(DeviceRepository var0) {
      return new Flow(FlowKt.distinctUntilChanged(var0.blueairDb.deviceDao().getFlowDevices())) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label32: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var12 = var4;
                           break label32;
                        }
                     }

                     var12 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var5 = ((<undefinedtype>)var12).result;
                  Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var12).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var12).I$0;
                     FlowCollector var8 = (FlowCollector)((<undefinedtype>)var12).L$3;
                     Object var9 = ((<undefinedtype>)var12).L$2;
                     <undefinedtype> var10 = (<undefinedtype>)((<undefinedtype>)var12).L$1;
                     Object var11 = ((<undefinedtype>)var12).L$0;
                     ResultKt.throwOnFailure(var5);
                  } else {
                     ResultKt.throwOnFailure(var5);
                     FlowCollector var15 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var12;
                     Iterable var7 = (Iterable)((List)var1);
                     Collection var16 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
                     Iterator var18 = var7.iterator();

                     while(var18.hasNext()) {
                        var16.add(((DeviceEntity)var18.next()).toDevice());
                     }

                     List var17 = (List)var16;
                     ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var12);
                     ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var15);
                     ((<undefinedtype>)var12).I$0 = 0;
                     ((<undefinedtype>)var12).label = 1;
                     if (var15.emit(var17, (Continuation)var12) == var14) {
                        return var14;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   // $FF: synthetic method
   public static Flow getFlowDeviceDataBetween$default(DeviceRepository var0, String var1, long var2, long var4, boolean var6, int var7, Object var8) {
      if ((var7 & 8) != 0) {
         var6 = true;
      }

      return var0.getFlowDeviceDataBetween(var1, var2, var4, var6);
   }

   // $FF: synthetic method
   public static Flow getFlowLatestDatapointAsDeviceData$default(DeviceRepository var0, String var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = true;
      }

      return var0.getFlowLatestDatapointAsDeviceData(var1, var2);
   }

   private static final DeviceData getLiveLatestDeviceData$lambda$14(DeviceRepository var0, DeviceDataEntity var1) {
      return var1 != null ? var1.toDeviceData(var0.prefs.isTempCelsius()) : null;
   }

   private static final Device liveDevice$lambda$5(DeviceEntity var0) {
      return var0 != null ? var0.toDevice() : null;
   }

   private static final LiveData liveDevices_delegate$lambda$1(DeviceRepository var0) {
      return FlowLiveDataConversions.asLiveData$default(var0.getFlowDevices(), GlobalScope.INSTANCE.getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   private final void updateDeviceEntity(DeviceEntity var1) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("updateDeviceEntity ");
      var3.append(var1.getUid());
      var4.v(var3.toString(), new Object[0]);
      if (((CharSequence)var1.getUid()).length() != 0) {
         if (this.blueairDb.deviceDao().device(var1.getUid()) != null) {
            int var2 = this.blueairDb.deviceDao().update(var1);
            var4 = Timber.Forest;
            var3 = new StringBuilder("updateDeviceEntity: update ");
            var3.append(var1.getUid());
            var3.append(", response = ");
            var3.append(var2);
            var4.d(var3.toString(), new Object[0]);
         } else {
            var4 = Timber.Forest;
            var3 = new StringBuilder("updateDeviceEntity: insert ");
            var3.append(var1.getUid());
            var4.d(var3.toString(), new Object[0]);
            this.blueairDb.deviceDao().insert(var1);
         }
      }
   }

   public final void deleteAllDevices() {
      this.blueairDb.clearAllTables();
   }

   public final void deleteAllDevicesBackground(boolean var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("deleteAllDevicesBackground: isAblDevice = ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final boolean $isAblDevice;
         int label;
         final DeviceRepository this$0;

         {
            this.this$0 = var1;
            this.$isAblDevice = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$isAblDevice, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.blueairDb.deviceDao().deleteAll(this.$isAblDevice);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, 2, (Object)null);
   }

   public final void deleteDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("deleteDevice, uid = ");
      var2.append(var1.getUid());
      var3.v(var2.toString(), new Object[0]);
      if (((CharSequence)var1.getUid()).length() > 0) {
         this.blueairDb.deviceDao().delete(var1.getUid());
         this.blueairDb.deviceDataDao().deleteAllForDevice(var1.getUid());
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public final Object deleteOldDeviceData(String var1, long var2, Continuation var4) {
      Object var5 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(var1, var2, this, (Continuation)null) {
         final String $deviceId;
         final long $monthAgoSeconds;
         int label;
         final DeviceRepository this$0;

         {
            this.$deviceId = var1;
            this.$monthAgoSeconds = var2;
            this.this$0 = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$deviceId, this.$monthAgoSeconds, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               Timber.Forest var3 = Timber.Forest;
               StringBuilder var2 = new StringBuilder("deleteOldDeviceData: deviceId = ");
               var2.append(this.$deviceId);
               var2.append(", monthAgoSeconds = ");
               var2.append(this.$monthAgoSeconds);
               var3.v(var2.toString(), new Object[0]);
               this.this$0.blueairDb.deviceDataDao().deleteOldDeviceData(this.$deviceId, this.$monthAgoSeconds);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, var4);
      return var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var5 : Unit.INSTANCE;
   }

   public final Object getAllDevices(Continuation var1) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, (Continuation)null) {
         int label;
         final DeviceRepository this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.blueairDb.deviceDao();
               Continuation var3 = (Continuation)this;
               this.label = 1;
               Object var7 = var1.getDevices(var3);
               var1 = (DeviceDao)var7;
               if (var7 == var4) {
                  return var4;
               }
            }

            Iterable var8 = (Iterable)var1;
            Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
            Iterator var9 = var8.iterator();

            while(var9.hasNext()) {
               var6.add(((DeviceEntity)var9.next()).toDevice());
            }

            return (List)var6;
         }
      }, var1);
   }

   public final Device getDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      DeviceEntity var2 = this.blueairDb.deviceDao().device(var1);
      return var2 != null ? var2.toDevice() : null;
   }

   public final List getDevices() {
      Iterable var2 = (Iterable)this.blueairDb.deviceDao().getDevices();
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         var1.add(((DeviceEntity)var3.next()).toDevice());
      }

      return (List)var1;
   }

   public final Flow getFlowDeviceDataBetween(String var1, long var2, long var4, boolean var6) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Flow var7;
      if (var6) {
         var7 = this.blueairDb.deviceDataDao().getFlowDeviceDataBetween(var1, var2, var4);
      } else {
         var7 = this.blueairDb.deviceDataDao().getFlowDeviceNonRealTimeDataBetween(var1, var2, var4);
      }

      return new Flow(var7, this) {
         final Flow $this_unsafeTransform$inlined;
         final DeviceRepository this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final DeviceRepository this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label23: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var11 = var4;
                           break label23;
                        }
                     }

                     var11 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var13 = ((<undefinedtype>)var11).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var11).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var11).I$0;
                     FlowCollector var7 = (FlowCollector)((<undefinedtype>)var11).L$3;
                     Object var8 = ((<undefinedtype>)var11).L$2;
                     <undefinedtype> var9 = (<undefinedtype>)((<undefinedtype>)var11).L$1;
                     Object var10 = ((<undefinedtype>)var11).L$0;
                     ResultKt.throwOnFailure(var13);
                  } else {
                     ResultKt.throwOnFailure(var13);
                     FlowCollector var14 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var11;
                     List var15 = (List)var1;
                     DeviceData var16 = DeviceDataEntity.Companion.toDeviceData(var15, this.this$0.prefs.isTempCelsius());
                     ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                     ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var11).I$0 = 0;
                     ((<undefinedtype>)var11).label = 1;
                     if (var14.emit(var16, (Continuation)var11) == var5) {
                        return var5;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   public final Flow getFlowDevices() {
      return (Flow)this.flowDevices$delegate.getValue();
   }

   public final Flow getFlowHasSensorDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return new Flow(this.blueairDb.deviceDao().getFlowDevice(var1)) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label34: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var13 = var4;
                           break label34;
                        }
                     }

                     var13 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var15 = ((<undefinedtype>)var13).result;
                  Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var13).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var13).I$0;
                     var1 = (HasSensorData)((<undefinedtype>)var13).L$4;
                     FlowCollector var9 = (FlowCollector)((<undefinedtype>)var13).L$3;
                     Object var10 = ((<undefinedtype>)var13).L$2;
                     <undefinedtype> var11 = (<undefinedtype>)((<undefinedtype>)var13).L$1;
                     Object var12 = ((<undefinedtype>)var13).L$0;
                     ResultKt.throwOnFailure(var15);
                  } else {
                     ResultKt.throwOnFailure(var15);
                     FlowCollector var7 = this.$this_unsafeFlow;
                     Continuation var16 = (Continuation)var13;
                     DeviceEntity var17 = (DeviceEntity)var1;
                     HasSensorData var5 = null;
                     Device var18;
                     if (var17 != null) {
                        var18 = var17.toDevice();
                     } else {
                        var18 = null;
                     }

                     if (var18 instanceof HasSensorData) {
                        var5 = (HasSensorData)var18;
                     }

                     if (var5 != null) {
                        ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var13);
                        ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var13).L$3 = SpillingKt.nullOutSpilledVariable(var7);
                        ((<undefinedtype>)var13).L$4 = SpillingKt.nullOutSpilledVariable(var5);
                        ((<undefinedtype>)var13).I$0 = 0;
                        ((<undefinedtype>)var13).label = 1;
                        if (var7.emit(var5, (Continuation)var13) == var6) {
                           return var6;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   public final Flow getFlowHasWelcomeHomeDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return new Flow(this.blueairDb.deviceDao().getFlowDevice(var1)) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label34: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var13 = var4;
                           break label34;
                        }
                     }

                     var13 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var15 = ((<undefinedtype>)var13).result;
                  Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var13).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var13).I$0;
                     var1 = (HasWelcomeHome)((<undefinedtype>)var13).L$4;
                     FlowCollector var9 = (FlowCollector)((<undefinedtype>)var13).L$3;
                     Object var10 = ((<undefinedtype>)var13).L$2;
                     <undefinedtype> var11 = (<undefinedtype>)((<undefinedtype>)var13).L$1;
                     Object var12 = ((<undefinedtype>)var13).L$0;
                     ResultKt.throwOnFailure(var15);
                  } else {
                     ResultKt.throwOnFailure(var15);
                     FlowCollector var7 = this.$this_unsafeFlow;
                     Continuation var16 = (Continuation)var13;
                     DeviceEntity var17 = (DeviceEntity)var1;
                     HasWelcomeHome var5 = null;
                     Device var18;
                     if (var17 != null) {
                        var18 = var17.toDevice();
                     } else {
                        var18 = null;
                     }

                     if (var18 instanceof HasWelcomeHome) {
                        var5 = (HasWelcomeHome)var18;
                     }

                     if (var5 != null) {
                        ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var13);
                        ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var13).L$3 = SpillingKt.nullOutSpilledVariable(var7);
                        ((<undefinedtype>)var13).L$4 = SpillingKt.nullOutSpilledVariable(var5);
                        ((<undefinedtype>)var13).I$0 = 0;
                        ((<undefinedtype>)var13).label = 1;
                        if (var7.emit(var5, (Continuation)var13) == var6) {
                           return var6;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   public final Flow getFlowLatestDatapoint(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return FlowKt.distinctUntilChanged(new Flow(this.blueairDb.deviceDataDao().latestFlowDeviceData(var1)) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label30: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var12 = var4;
                           break label30;
                        }
                     }

                     var12 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var14 = ((<undefinedtype>)var12).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var12).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var12).I$0;
                     var1 = (IndoorDatapoint)((<undefinedtype>)var12).L$4;
                     FlowCollector var8 = (FlowCollector)((<undefinedtype>)var12).L$3;
                     Object var9 = ((<undefinedtype>)var12).L$2;
                     <undefinedtype> var10 = (<undefinedtype>)((<undefinedtype>)var12).L$1;
                     Object var11 = ((<undefinedtype>)var12).L$0;
                     ResultKt.throwOnFailure(var14);
                  } else {
                     ResultKt.throwOnFailure(var14);
                     FlowCollector var6 = this.$this_unsafeFlow;
                     Continuation var15 = (Continuation)var12;
                     DeviceDataEntity var16 = (DeviceDataEntity)var1;
                     IndoorDatapoint var17;
                     if (var16 != null) {
                        var17 = var16.toIndoorDatapoint();
                     } else {
                        var17 = null;
                     }

                     if (var17 != null) {
                        ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var12);
                        ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var6);
                        ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var17);
                        ((<undefinedtype>)var12).I$0 = 0;
                        ((<undefinedtype>)var12).label = 1;
                        if (var6.emit(var17, (Continuation)var12) == var5) {
                           return var5;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      });
   }

   public final Flow getFlowLatestDatapointAsDeviceData(String var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Flow var3;
      if (var2) {
         var3 = this.blueairDb.deviceDataDao().latestFlowDeviceData(var1);
      } else {
         var3 = this.blueairDb.deviceDataDao().latestFlowNonRealTimeDeviceData(var1);
      }

      return new Flow(var3, this) {
         final Flow $this_unsafeTransform$inlined;
         final DeviceRepository this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final DeviceRepository this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label30: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var12 = var4;
                           break label30;
                        }
                     }

                     var12 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var14 = ((<undefinedtype>)var12).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var12).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var12).I$0;
                     var1 = (DeviceData)((<undefinedtype>)var12).L$4;
                     FlowCollector var8 = (FlowCollector)((<undefinedtype>)var12).L$3;
                     Object var9 = ((<undefinedtype>)var12).L$2;
                     <undefinedtype> var10 = (<undefinedtype>)((<undefinedtype>)var12).L$1;
                     Object var11 = ((<undefinedtype>)var12).L$0;
                     ResultKt.throwOnFailure(var14);
                  } else {
                     ResultKt.throwOnFailure(var14);
                     FlowCollector var6 = this.$this_unsafeFlow;
                     Continuation var15 = (Continuation)var12;
                     DeviceDataEntity var16 = (DeviceDataEntity)var1;
                     DeviceData var17;
                     if (var16 != null) {
                        var17 = var16.toDeviceData(this.this$0.prefs.isTempCelsius());
                     } else {
                        var17 = null;
                     }

                     if (var17 != null) {
                        ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var12);
                        ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var6);
                        ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var17);
                        ((<undefinedtype>)var12).I$0 = 0;
                        ((<undefinedtype>)var12).label = 1;
                        if (var6.emit(var17, (Continuation)var12) == var5) {
                           return var5;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   public final Flow getFlowLatestDatapointForAllDevices() {
      return FlowKt.distinctUntilChanged(new Flow(this.blueairDb.deviceDataDao().latestFlowDeviceDataForAllDevices()) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label32: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var14 = var4;
                           break label32;
                        }
                     }

                     var14 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var5 = ((<undefinedtype>)var14).result;
                  Object var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var14).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var14).I$0;
                     Map var9 = (Map)((<undefinedtype>)var14).L$4;
                     FlowCollector var10 = (FlowCollector)((<undefinedtype>)var14).L$3;
                     Object var11 = ((<undefinedtype>)var14).L$2;
                     <undefinedtype> var12 = (<undefinedtype>)((<undefinedtype>)var14).L$1;
                     Object var13 = ((<undefinedtype>)var14).L$0;
                     ResultKt.throwOnFailure(var5);
                  } else {
                     ResultKt.throwOnFailure(var5);
                     FlowCollector var17 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var14;
                     Iterable var7 = (Iterable)((List)var1);
                     Map var18 = (Map)(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var7, 10)), 16)));

                     for(DeviceDataEntity var8 : var7) {
                        Pair var20 = TuplesKt.to(var8.getDeviceId(), var8.toIndoorDatapoint());
                        var18.put(var20.getFirst(), var20.getSecond());
                     }

                     ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var14).L$3 = SpillingKt.nullOutSpilledVariable(var17);
                     ((<undefinedtype>)var14).L$4 = SpillingKt.nullOutSpilledVariable(var18);
                     ((<undefinedtype>)var14).I$0 = 0;
                     ((<undefinedtype>)var14).label = 1;
                     if (var17.emit(var18, (Continuation)var14) == var16) {
                        return var16;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      });
   }

   public final Flow getFlowRealTimeDeviceData(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return new Flow(this.blueairDb.deviceDataDao().getFlowRealTimeDeviceData(var1), this) {
         final Flow $this_unsafeTransform$inlined;
         final DeviceRepository this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final DeviceRepository this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label23: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var11 = var4;
                           break label23;
                        }
                     }

                     var11 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var13 = ((<undefinedtype>)var11).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var11).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var11).I$0;
                     FlowCollector var7 = (FlowCollector)((<undefinedtype>)var11).L$3;
                     Object var8 = ((<undefinedtype>)var11).L$2;
                     <undefinedtype> var9 = (<undefinedtype>)((<undefinedtype>)var11).L$1;
                     Object var10 = ((<undefinedtype>)var11).L$0;
                     ResultKt.throwOnFailure(var13);
                  } else {
                     ResultKt.throwOnFailure(var13);
                     FlowCollector var14 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var11;
                     List var15 = (List)var1;
                     DeviceData var16 = DeviceDataEntity.Companion.toDeviceData(var15, this.this$0.prefs.isTempCelsius());
                     ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                     ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var11).I$0 = 0;
                     ((<undefinedtype>)var11).label = 1;
                     if (var14.emit(var16, (Continuation)var11) == var5) {
                        return var5;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      };
   }

   public final long getLatestHistoricalDataTime(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Long var4 = this.blueairDb.deviceDataDao().getLatestHistoricalDataTime(var1);
      long var2;
      if (var4 != null) {
         var2 = var4;
      } else {
         var2 = 0L;
      }

      return var2 * (long)1000;
   }

   public final LiveData getLiveDevices() {
      return (LiveData)this.liveDevices$delegate.getValue();
   }

   public final LiveData getLiveLatestDeviceData(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return Transformations.map(this.blueairDb.deviceDataDao().latestLiveDeviceData(var1), new DeviceRepository$$ExternalSyntheticLambda2(this));
   }

   public final Object insertAndReplaceDeviceData(DeviceData var1, DataTrend var2, Continuation var3) {
      Object var4 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, var1, var2, (Continuation)null) {
         final DataTrend $dataTrend;
         final DeviceData $deviceData;
         int label;
         final DeviceRepository this$0;

         {
            this.this$0 = var1;
            this.$deviceData = var2;
            this.$dataTrend = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceData, this.$dataTrend, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
               ResultKt.throwOnFailure(var1);
               if (this.this$0.blueairDb.deviceDao().device(this.$deviceData.getDeviceId()) != null) {
                  try {
                     List var7 = DeviceDataEntity.Companion.fromDeviceData(this.$deviceData, this.$dataTrend);
                     this.this$0.blueairDb.deviceDataDao().insertAllAndReplace(this.$deviceData.getDeviceId(), var7);
                  } catch (Throwable var5) {
                     Timber.Forest var2 = Timber.Forest;
                     StringBuilder var6 = new StringBuilder("insertAndReplaceDeviceData: runtime exception: ");
                     var6.append(var5.getMessage());
                     var2.e(var5, var6.toString(), new Object[0]);
                     return Unit.INSTANCE;
                  }
               } else {
                  Timber.Forest var8 = Timber.Forest;
                  StringBuilder var9 = new StringBuilder("insertAndReplaceDeviceData: IGNORED since device ");
                  var9.append(this.$deviceData.getDeviceId());
                  var9.append(" does not exist");
                  var8.w(var9.toString(), new Object[0]);
               }

               return Unit.INSTANCE;
            }
         }
      }, var3);
      return var4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var4 : Unit.INSTANCE;
   }

   public final Object insertDeviceData(DeviceData var1, DataTrend var2, Continuation var3) {
      Object var4 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, var1, var2, (Continuation)null) {
         final DataTrend $dataTrend;
         final DeviceData $deviceData;
         int label;
         final DeviceRepository this$0;

         {
            this.this$0 = var1;
            this.$deviceData = var2;
            this.$dataTrend = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceData, this.$dataTrend, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               if (this.this$0.blueairDb.deviceDao().device(this.$deviceData.getDeviceId()) != null) {
                  List var2 = DeviceDataEntity.Companion.fromDeviceData(this.$deviceData, this.$dataTrend);
                  Timber.Forest var4 = Timber.Forest;
                  StringBuilder var3 = new StringBuilder("insertDeviceData: Attempting to save ");
                  var3.append(var2);
                  var4.v(var3.toString(), new Object[0]);
                  this.this$0.blueairDb.deviceDataDao().insertAll(var2);
               } else {
                  Timber.Forest var5 = Timber.Forest;
                  StringBuilder var6 = new StringBuilder("insertDeviceData: IGNORED since device ");
                  var6.append(this.$deviceData.getDeviceId());
                  var6.append(" does not exist");
                  var5.w(var6.toString(), new Object[0]);
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, var3);
      return var4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var4 : Unit.INSTANCE;
   }

   public final LiveData liveDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return Transformations.map(this.blueairDb.deviceDao().liveDevice(var1), new DeviceRepository$$ExternalSyntheticLambda3());
   }

   public final void updateDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("updateDevice: uid = ");
      var3.append(var1.getUid());
      var2.v(var3.toString(), new Object[0]);
      if (((CharSequence)var1.getUid()).length() != 0) {
         DeviceEntity var4 = this.blueairDb.deviceDao().device(var1.getUid());
         this.updateDeviceEntity(DeviceEntity.Companion.fromDevice(var1, var4));
      }
   }

   public final void updateDevice(DeviceDetailsOnAblServer var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceAbl");
      Timber.Forest.v("updateDevice: deviceAbl", new Object[0]);
      if (((CharSequence)var1.getUuid()).length() > 0) {
         DeviceEntity var2 = this.blueairDb.deviceDao().device(var1.getUuid());
         this.updateDeviceEntity(DeviceEntity.Companion.fromDeviceOnAblServer(var1, var2));
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public final void updateDevice(DeviceOnBlueServer var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceBlue");
      Timber.Forest.v("updateDevice: deviceBlue", new Object[0]);
      if (((CharSequence)var1.getUuid()).length() > 0) {
         DeviceEntity var2 = this.blueairDb.deviceDao().device(var1.getUuid());

         try {
            Result.Companion var3 = Result.Companion;
            this.updateDeviceEntity(DeviceEntity.Companion.fromDeviceOnBlueServer(var1, var2, this.locationService.isInG4ProtectRegion()));
            Result.constructor-impl(Unit.INSTANCE);
         } catch (Throwable var5) {
            Result.Companion var6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(var5));
            return;
         }
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public final Object updateDeviceField(String var1, DeviceField var2, Object var3, Continuation var4) {
      Object var21;
      label1165: {
         if (var4 instanceof <undefinedtype>) {
            var21 = (<undefinedtype>)var4;
            if ((((<undefinedtype>)var21).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var21).label += Integer.MIN_VALUE;
               break label1165;
            }
         }

         var21 = new ContinuationImpl(this, var4) {
            double D$0;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            boolean Z$0;
            int label;
            Object result;
            final DeviceRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateDeviceField((String)null, (DeviceField)null, (Object)null, (Continuation)this);
            }
         };
      }

      Object var87;
      label1518: {
         label1519: {
            label1202: {
               label1126: {
                  Object var86;
                  int var146;
                  label1168: {
                     int var8;
                     String var240;
                     DeviceField var339;
                     label1124: {
                        var87 = ((<undefinedtype>)var21).result;
                        var86 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        var146 = ((<undefinedtype>)var21).label;
                        Object var84 = null;
                        Object var53 = null;
                        Object var33 = null;
                        Object var67 = null;
                        Object var54 = null;
                        Object var60 = null;
                        Object var27 = null;
                        Object var42 = null;
                        Object var38 = null;
                        Object var48 = null;
                        Object var62 = null;
                        Object var64 = null;
                        Object var29 = null;
                        Object var66 = null;
                        Object var81 = null;
                        Object var32 = null;
                        Object var65 = null;
                        Object var55 = null;
                        Object var58 = null;
                        Object var83 = null;
                        Object var37 = null;
                        Object var50 = null;
                        Object var44 = null;
                        Object var75 = null;
                        Object var59 = null;
                        Object var68 = null;
                        Object var85 = null;
                        Object var47 = null;
                        Object var71 = null;
                        Object var77 = null;
                        Object var61 = null;
                        Object var43 = null;
                        Integer var22 = null;
                        Object var46 = null;
                        Object var28 = null;
                        Object var72 = null;
                        Object var45 = null;
                        Object var73 = null;
                        Object var57 = null;
                        Object var70 = null;
                        Object var69 = null;
                        Object var76 = null;
                        Object var24 = null;
                        Object var51 = null;
                        Object var25 = null;
                        Object var80 = null;
                        Object var31 = null;
                        var339 = null;
                        Object var56 = null;
                        Object var39 = null;
                        Object var36 = null;
                        Object var79 = null;
                        Object var49 = null;
                        Object var30 = null;
                        Object var52 = null;
                        Object var40 = null;
                        Object var74 = null;
                        Object var41 = null;
                        Object var26 = null;
                        Object var34 = null;
                        Object var63 = null;
                        Object var35 = null;
                        Object var82 = null;
                        Object var78 = null;
                        WelcomeHomeLocation var239;
                        switch (var146) {
                           case 0:
                              ResultKt.throwOnFailure(var87);
                              var125 = this.blueairDb.deviceDao();
                              if (Intrinsics.areEqual(var2, DeviceField.Name.INSTANCE)) {
                                 String var338 = (String)var3;
                                 if (var338 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var338;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var338);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 1;
                                    if (var125.updateName(var1, var338, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.LatestSensorDataPoint.INSTANCE)) {
                                 IndoorDatapoint var359 = (IndoorDatapoint)var3;
                                 if (var359 == null) {
                                    return Unit.INSTANCE;
                                 }

                                 long var216 = var359.getTimeInSeconds();
                                 Float var363 = var359.getPm1();
                                 Float var337 = var359.getPm10();
                                 Float var373 = var359.getPm25();
                                 Float var379 = var359.getVoc();
                                 Float var378 = var359.getHcho();
                                 Float var369 = var359.getTmp();
                                 Float var376 = var359.getHum();
                                 Float var377 = var359.getFan();
                                 ((<undefinedtype>)var21).L$0 = var1;
                                 ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                 ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                 ((<undefinedtype>)var21).L$3 = var125;
                                 ((<undefinedtype>)var21).L$4 = var359;
                                 ((<undefinedtype>)var21).L$5 = var359;
                                 ((<undefinedtype>)var21).I$0 = 0;
                                 ((<undefinedtype>)var21).I$1 = 0;
                                 ((<undefinedtype>)var21).label = 2;
                                 if (var125.updateLatestSensorDataPoint(var1, var216, var363, var337, var373, var379, var378, var369, var376, var377, (Continuation)var21) == var86) {
                                    return var86;
                                 }

                                 var240 = var1;
                                 var114 = var359;
                                 IndoorDatapoint var364 = var359;
                                 var8 = 0;
                                 var146 = 0;
                                 var339 = var2;
                                 var124 = var125;
                                 var126 = var364;
                                 break label1124;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.SelectedSensor.INSTANCE)) {
                                 Integer var358 = (Integer)var3;
                                 if (var358 != null) {
                                    var146 = ((Number)var358).intValue();
                                    Integer var336 = Boxing.boxInt(var146);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var358;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 4;
                                    if (var125.updateLastSelectedSensorType(var1, var336, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.FanSpeed.INSTANCE)) {
                                 Integer var357 = (Integer)var3;
                                 if (var357 != null) {
                                    var146 = ((Number)var357).intValue();
                                    Integer var335 = Boxing.boxInt(var146);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var357;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 5;
                                    if (var125.updateFanSpeed(var1, var335, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.FanSpeedAndAutoMode.INSTANCE)) {
                                 Integer var334 = (Integer)var3;
                                 if (var334 != null) {
                                    var146 = ((Number)var334).intValue();
                                    Integer var356 = Boxing.boxInt(var146);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var334;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 6;
                                    if (var125.updateFanSpeedAndAutoMode(var1, var356, "manual", (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.AutoMode.INSTANCE)) {
                                 String var333 = (String)var3;
                                 if (var333 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var333;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var333);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 7;
                                    if (var125.updateAutoMode(var1, var333, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.Brightness.INSTANCE)) {
                                 Integer var332 = (Integer)var3;
                                 if (var332 != null) {
                                    var146 = ((Number)var332).intValue();
                                    Integer var355 = Boxing.boxInt(var146);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var332;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 8;
                                    if (var125.updateBrightness(var1, var355, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.ChildLock.INSTANCE)) {
                                 Boolean var331 = (Boolean)var3;
                                 if (var331 != null) {
                                    boolean var238 = var331;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var331;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var238;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 9;
                                    if (var125.updateChildLock(var1, var238, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.LinkedDeviceUid.INSTANCE)) {
                                 String var330 = (String)var3;
                                 if (var330 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var330;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var330);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 10;
                                    if (var125.updateLinkedDeviceUid(var1, var330, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.ConnectivityStatus.INSTANCE)) {
                                 Integer var329 = (Integer)var3;
                                 if (var329 != null) {
                                    var146 = ((Number)var329).intValue();
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var329;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 11;
                                    if (var125.updateConnectivityStatus(var1, var146, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.UpdateProgress.INSTANCE)) {
                                 Integer var328 = (Integer)var3;
                                 if (var328 != null) {
                                    var146 = ((Number)var328).intValue();
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var328;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 12;
                                    if (var125.updateProgress(var1, var146, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.FilterLife.INSTANCE)) {
                                 Integer var327 = (Integer)var3;
                                 if (var327 != null) {
                                    var146 = ((Number)var327).intValue();
                                    Integer var354 = Boxing.boxInt(var146);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var327;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 13;
                                    if (var125.updateFilterLife(var1, var354, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.SensorRange.INSTANCE)) {
                                 DeviceField.SensorRanges var375 = (DeviceField.SensorRanges)var3;
                                 if (var375 != null) {
                                    String var326 = DoubleArrayConverter.Companion.fromDoubleArray(var375.getPm1Ranges());
                                    String var372 = DoubleArrayConverter.Companion.fromDoubleArray(var375.getPm10Ranges());
                                    String var362 = DoubleArrayConverter.Companion.fromDoubleArray(var375.getPm25Ranges());
                                    String var353 = DoubleArrayConverter.Companion.fromDoubleArray(var375.getVocRanges());
                                    String var368 = DoubleArrayConverter.Companion.fromDoubleArray(var375.getHchoRanges());
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var375;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var375);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 14;
                                    if (var125.updateSensorRange(var1, var326, var372, var362, var353, var368, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.WifiFirmware.INSTANCE)) {
                                 String var325 = (String)var3;
                                 if (var325 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var325;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var325);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 15;
                                    if (var125.updateWifiFirmware(var1, var325, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.McuFirmware.INSTANCE)) {
                                 String var324 = (String)var3;
                                 if (var324 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var324;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var324);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 16;
                                    if (var125.updateMcuFirmware(var1, var324, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.Hardware.INSTANCE)) {
                                 String var323 = (String)var3;
                                 if (var323 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var323;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var323);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 17;
                                    if (var125.updateHardware(var1, var323, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.StandbyMode.INSTANCE)) {
                                 Boolean var322 = (Boolean)var3;
                                 if (var322 != null) {
                                    boolean var237 = var322;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var322;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var237;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 18;
                                    if (var125.updateStandByMode(var1, var237, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.EcoMode.INSTANCE)) {
                                 Boolean var321 = (Boolean)var3;
                                 if (var321 != null) {
                                    boolean var236 = var321;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var321;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var236;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 19;
                                    if (var125.updateEcoMode(var1, var236, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.HinsMode.INSTANCE)) {
                                 Boolean var320 = (Boolean)var3;
                                 if (var320 != null) {
                                    boolean var235 = var320;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var320;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var235;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 20;
                                    if (var125.updateHinsMode(var1, var235, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.HinsNightMode.INSTANCE)) {
                                 Boolean var319 = (Boolean)var3;
                                 if (var319 != null) {
                                    boolean var234 = var319;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var319;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var234;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 21;
                                    if (var125.updateHinsNightMode(var1, var234, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.G4NightMode.INSTANCE)) {
                                 Boolean var318 = (Boolean)var3;
                                 if (var318 != null) {
                                    boolean var233 = var318;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var318;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var233;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 22;
                                    if (var125.updateG4NightMode(var1, var233, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.GermShieldMode.INSTANCE)) {
                                 Boolean var317 = (Boolean)var3;
                                 if (var317 != null) {
                                    boolean var232 = var317;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var317;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var232;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 23;
                                    if (var125.updateGermShieldMode(var1, var232, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.GermShieldNightMode.INSTANCE)) {
                                 Boolean var352 = (Boolean)var3;
                                 if (var352 != null) {
                                    boolean var231 = var352;
                                    Boolean var316 = Boxing.boxBoolean(var231);
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var352;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var231;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 24;
                                    if (var125.updateGermShieldNightMode(var1, var316, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.SerialNumber.INSTANCE)) {
                                 String var315 = (String)var3;
                                 if (var315 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var315;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var315);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 25;
                                    if (var125.updateSerialNumber(var1, var315, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.FilterTrigger.INSTANCE)) {
                                 String var314 = (String)var3;
                                 if (var314 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var314;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var314);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 26;
                                    if (var125.updateFilterTrigger(var1, var314, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.G4NightModeFilterTrigger.INSTANCE)) {
                                 String var313 = (String)var3;
                                 if (var313 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var313;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var313);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 27;
                                    if (var125.updateG4NightModeFilterTrigger(var1, var313, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.SafetySwitch.INSTANCE)) {
                                 Boolean var312 = (Boolean)var3;
                                 if (var312 != null) {
                                    boolean var230 = var312;
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var312;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).Z$0 = var230;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 28;
                                    if (var125.updateSafetySwitch(var1, var230, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.MacAddress.INSTANCE)) {
                                 String var311 = (String)var3;
                                 if (var311 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var311;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var311);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 29;
                                    if (var125.updateMacAddress(var1, var311, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.ModelName.INSTANCE)) {
                                 String var310 = (String)var3;
                                 if (var310 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var310;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var310);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 30;
                                    if (var125.updateModelName(var1, var310, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.FilterType.INSTANCE)) {
                                 String var309 = (String)var3;
                                 if (var309 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var309;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var309);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 31;
                                    if (var125.updateFilterType(var1, var309, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.DeviceType.INSTANCE)) {
                                 Integer var308 = (Integer)var3;
                                 if (var308 != null) {
                                    var146 = ((Number)var308).intValue();
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var308;
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = var146;
                                    ((<undefinedtype>)var21).I$2 = 0;
                                    ((<undefinedtype>)var21).label = 32;
                                    if (var125.updateDeviceType(var1, var146, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.DeviceSKU.INSTANCE)) {
                                 String var307 = (String)var3;
                                 if (var307 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var307;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var307);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 33;
                                    if (var125.updateSku(var1, var307, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (Intrinsics.areEqual(var2, DeviceField.DeviceCompatibility.INSTANCE)) {
                                 String var306 = (String)var3;
                                 if (var306 != null) {
                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var306;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var306);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 34;
                                    if (var125.updateCompatibility(var1, var306, (Continuation)var21) == var86) {
                                       return var86;
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }

                              if (!Intrinsics.areEqual(var2, DeviceField.DeviceWelcomeHome.INSTANCE)) {
                                 if (Intrinsics.areEqual(var2, DeviceField.Disinfection.INSTANCE)) {
                                    Boolean var241 = (Boolean)var3;
                                    if (var241 != null) {
                                       boolean var217 = var241;
                                       Boolean var341 = Boxing.boxBoolean(var217);
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var241;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var217;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 37;
                                       if (var125.updateDisinfection(var1, var341, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.DisinfectLeftTime.INSTANCE)) {
                                    Pair var242 = (Pair)var78;
                                    if (var3 instanceof Pair) {
                                       var242 = (Pair)var3;
                                    }

                                    if (var242 != null && var242.getFirst() != null && var242.getSecond() != null) {
                                       Integer var342 = (Integer)var242.getFirst();
                                       Long var361 = (Long)var242.getSecond();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var242;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var242);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 38;
                                       if (var125.updateDisinfectLeftTime(var1, var342, var361, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.DeviceTimezone.INSTANCE)) {
                                    String var343 = (String)var3;
                                    String var243 = var343;
                                    if (var343 == null) {
                                       var243 = "";
                                    }

                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).label = 39;
                                    if (var125.updateTimezone(var1, var243, (Continuation)var21) == var86) {
                                       return var86;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickdryEnabled.INSTANCE)) {
                                    Boolean var244 = (Boolean)var84;
                                    if (var3 instanceof Boolean) {
                                       var244 = (Boolean)var3;
                                    }

                                    if (var244 != null) {
                                       boolean var218 = var244;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var244;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var218;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 40;
                                       if (var125.updateWickdryEnabled(var1, var218, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickdryOn.INSTANCE)) {
                                    Boolean var245 = (Boolean)var53;
                                    if (var3 instanceof Boolean) {
                                       var245 = (Boolean)var3;
                                    }

                                    if (var245 != null) {
                                       boolean var219 = var245;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var245;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var219;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 41;
                                       if (var125.updateWickdryOn(var1, var219, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickdryLeftTime.INSTANCE)) {
                                    Pair var246 = (Pair)var33;
                                    if (var3 instanceof Pair) {
                                       var246 = (Pair)var3;
                                    }

                                    if (var246 != null && var246.getFirst() != null && var246.getSecond() != null) {
                                       var339 = (DeviceField)var246.getFirst();
                                       Intrinsics.checkNotNull(var339);
                                       var146 = ((Number)var339).intValue();
                                       var339 = (DeviceField)var246.getSecond();
                                       Intrinsics.checkNotNull(var339);
                                       long var213 = ((Number)var339).longValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var246;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var246);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 42;
                                       if (var125.updateWickdryLeftTime(var1, var146, var213, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickdryDuration.INSTANCE)) {
                                    Integer var247 = (Integer)var67;
                                    if (var3 instanceof Integer) {
                                       var247 = (Integer)var3;
                                    }

                                    if (var247 != null) {
                                       var146 = ((Number)var247).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var247;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 43;
                                       if (var125.updateWickdryDuration(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickdryDone.INSTANCE)) {
                                    Boolean var248 = (Boolean)var54;
                                    if (var3 instanceof Boolean) {
                                       var248 = (Boolean)var3;
                                    }

                                    if (var248 != null) {
                                       boolean var220 = var248;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var248;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var220;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 44;
                                       if (var125.updateWickdryDone(var1, var220, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WickUsage.INSTANCE)) {
                                    Integer var249 = (Integer)var60;
                                    if (var3 instanceof Integer) {
                                       var249 = (Integer)var3;
                                    }

                                    if (var249 != null) {
                                       var146 = ((Number)var249).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var249;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 45;
                                       if (var125.updateWickUsage(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WaterShortage.INSTANCE)) {
                                    Boolean var250 = (Boolean)var27;
                                    if (var3 instanceof Boolean) {
                                       var250 = (Boolean)var3;
                                    }

                                    if (var250 != null) {
                                       boolean var221 = var250;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var250;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var221;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 46;
                                       if (var125.updateWaterShortage(var1, var221, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AutoRh.INSTANCE)) {
                                    Integer var251 = (Integer)var42;
                                    if (var3 instanceof Integer) {
                                       var251 = (Integer)var3;
                                    }

                                    if (var251 != null) {
                                       var146 = ((Number)var251).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var251;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 47;
                                       if (var125.updateAutoRh(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.TimerStatus.INSTANCE)) {
                                    Integer var252 = (Integer)var38;
                                    if (var3 instanceof Integer) {
                                       var252 = (Integer)var3;
                                    }

                                    if (var252 != null) {
                                       var146 = ((Number)var252).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var252;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 48;
                                       if (var125.updateTimerStatus(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.TimerDuration.INSTANCE)) {
                                    Integer var253 = (Integer)var48;
                                    if (var3 instanceof Integer) {
                                       var253 = (Integer)var3;
                                    }

                                    if (var253 != null) {
                                       var146 = ((Number)var253).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var253;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 49;
                                       if (var125.updateTimerDuration(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.TimerLeftTime.INSTANCE)) {
                                    Pair var254 = (Pair)var62;
                                    if (var3 instanceof Pair) {
                                       var254 = (Pair)var3;
                                    }

                                    if (var254 != null && var254.getFirst() != null && var254.getSecond() != null) {
                                       var339 = (DeviceField)var254.getFirst();
                                       Intrinsics.checkNotNull(var339);
                                       var146 = ((Number)var339).intValue();
                                       var339 = (DeviceField)var254.getSecond();
                                       Intrinsics.checkNotNull(var339);
                                       long var214 = ((Number)var339).longValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var254;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var254);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 50;
                                       if (var125.updateTimerLeftTime(var1, var146, var214, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.TemperatureUnit.INSTANCE)) {
                                    Integer var255 = (Integer)var64;
                                    if (var3 instanceof Integer) {
                                       var255 = (Integer)var3;
                                    }

                                    if (var255 != null) {
                                       var146 = ((Number)var255).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var255;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 51;
                                       if (var125.updateTemperatureUnit(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.OscillationState.INSTANCE)) {
                                    Integer var256 = (Integer)var29;
                                    if (var3 instanceof Integer) {
                                       var256 = (Integer)var3;
                                    }

                                    if (var256 != null) {
                                       var146 = ((Number)var256).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var256;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 52;
                                       if (var125.updateOscillationState(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.OscillationAngle.INSTANCE)) {
                                    Integer var257 = (Integer)var66;
                                    if (var3 instanceof Integer) {
                                       var257 = (Integer)var3;
                                    }

                                    if (var257 != null) {
                                       var146 = ((Number)var257).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var257;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 53;
                                       if (var125.updateOscillationAngle(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.OscillationDirection.INSTANCE)) {
                                    Integer var258 = (Integer)var81;
                                    if (var3 instanceof Integer) {
                                       var258 = (Integer)var3;
                                    }

                                    if (var258 != null) {
                                       var146 = ((Number)var258).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var258;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 54;
                                       if (var125.updateOscillationDirection(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.OscillationFanSpeed.INSTANCE)) {
                                    Integer var259 = (Integer)var32;
                                    if (var3 instanceof Integer) {
                                       var259 = (Integer)var3;
                                    }

                                    if (var259 != null) {
                                       var146 = ((Number)var259).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var259;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 55;
                                       if (var125.updateOscillationFanSpeed(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.MainMode.INSTANCE)) {
                                    Integer var260 = (Integer)var65;
                                    if (var3 instanceof Integer) {
                                       var260 = (Integer)var3;
                                    }

                                    if (var260 != null) {
                                       var146 = ((Number)var260).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var260;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 56;
                                       if (var125.updateMainMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.ApSubMode.INSTANCE)) {
                                    Integer var261 = (Integer)var55;
                                    if (var3 instanceof Integer) {
                                       var261 = (Integer)var3;
                                    }

                                    if (var261 != null) {
                                       var146 = ((Number)var261).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var261;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 57;
                                       if (var125.updateApSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.ApFanSpeed.INSTANCE)) {
                                    Integer var262 = (Integer)var58;
                                    if (var3 instanceof Integer) {
                                       var262 = (Integer)var3;
                                    }

                                    if (var262 != null) {
                                       var146 = ((Number)var262).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var262;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 58;
                                       if (var125.updateApFanSpeed(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HeatSubMode.INSTANCE)) {
                                    Integer var263 = (Integer)var83;
                                    if (var3 instanceof Integer) {
                                       var263 = (Integer)var3;
                                    }

                                    if (var263 != null) {
                                       var146 = ((Number)var263).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var263;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 59;
                                       if (var125.updateHeatSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HeatFanSpeed.INSTANCE)) {
                                    Integer var264 = (Integer)var37;
                                    if (var3 instanceof Integer) {
                                       var264 = (Integer)var3;
                                    }

                                    if (var264 != null) {
                                       var146 = ((Number)var264).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var264;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 60;
                                       if (var125.updateHeatFanSpeed(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HeatAutoTmp.INSTANCE)) {
                                    Double var265 = (Double)var50;
                                    if (var3 instanceof Double) {
                                       var265 = (Double)var3;
                                    }

                                    if (var265 != null) {
                                       double var127 = ((Number)var265).doubleValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var265;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).D$0 = var127;
                                       ((<undefinedtype>)var21).label = 61;
                                       if (var125.updateHeatAutoTmp(var1, var127, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HeatEcoTmp.INSTANCE)) {
                                    Double var266 = (Double)var44;
                                    if (var3 instanceof Double) {
                                       var266 = (Double)var3;
                                    }

                                    if (var266 != null) {
                                       double var128 = ((Number)var266).doubleValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var266;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).D$0 = var128;
                                       ((<undefinedtype>)var21).label = 62;
                                       if (var125.updateHeatEcoTmp(var1, var128, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolSubMode.INSTANCE)) {
                                    Integer var267 = (Integer)var75;
                                    if (var3 instanceof Integer) {
                                       var267 = (Integer)var3;
                                    }

                                    if (var267 != null) {
                                       var146 = ((Number)var267).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var267;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 63;
                                       if (var125.updateCoolSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolFanSpeed.INSTANCE)) {
                                    Integer var268 = (Integer)var59;
                                    if (var3 instanceof Integer) {
                                       var268 = (Integer)var3;
                                    }

                                    if (var268 != null) {
                                       var146 = ((Number)var268).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var268;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 64;
                                       if (var125.updateCoolFanSpeed(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolAutoTag.INSTANCE)) {
                                    Integer var269 = (Integer)var68;
                                    if (var3 instanceof Integer) {
                                       var269 = (Integer)var3;
                                    }

                                    if (var269 != null) {
                                       var146 = ((Number)var269).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var269;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 65;
                                       if (var125.updateCoolAutoTag(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolAutoPresets.INSTANCE)) {
                                    double[] var270 = (double[])var85;
                                    if (var3 instanceof double[]) {
                                       var270 = (double[])var3;
                                    }

                                    if (var270 != null) {
                                       String var348 = DoubleArrayConverter.Companion.fromDoubleArray(var270);
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var270;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var270);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 66;
                                       if (var125.updateCoolAutoPresets(var1, var348, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolEcoTag.INSTANCE)) {
                                    Integer var271 = (Integer)var47;
                                    if (var3 instanceof Integer) {
                                       var271 = (Integer)var3;
                                    }

                                    if (var271 != null) {
                                       var146 = ((Number)var271).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var271;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 67;
                                       if (var125.updateCoolEcoTag(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolEcoPresets.INSTANCE)) {
                                    double[] var272 = (double[])var71;
                                    if (var3 instanceof double[]) {
                                       var272 = (double[])var3;
                                    }

                                    if (var272 != null) {
                                       String var349 = DoubleArrayConverter.Companion.fromDoubleArray(var272);
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var272;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var272);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 68;
                                       if (var125.updateCoolEcoPresets(var1, var349, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.LocationId.INSTANCE)) {
                                    String var273 = (String)var77;
                                    if (var3 instanceof String) {
                                       var273 = (String)var3;
                                    }

                                    if (var273 != null) {
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var273;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var273);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 69;
                                       if (var125.updateLocationId(var1, var273, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.Mode.INSTANCE)) {
                                    Integer var274 = (Integer)var61;
                                    if (var3 instanceof Integer) {
                                       var274 = (Integer)var3;
                                    }

                                    if (var274 != null) {
                                       var146 = ((Number)var274).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var274;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 70;
                                       if (var125.updateMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HumMode.INSTANCE)) {
                                    Boolean var275 = (Boolean)var43;
                                    if (var3 instanceof Boolean) {
                                       var275 = (Boolean)var3;
                                    }

                                    if (var275 != null) {
                                       boolean var222 = var275;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var275;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var222;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 71;
                                       if (var125.updateHumMode(var1, var222, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WaterLevel.INSTANCE)) {
                                    if (var3 instanceof Integer) {
                                       var22 = (Integer)var3;
                                    }

                                    if (var22 != null) {
                                       var146 = ((Number)var22).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var22;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 72;
                                       if (var125.updateWaterLevel(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.DehSubMode.INSTANCE)) {
                                    Integer var276 = (Integer)var46;
                                    if (var3 instanceof Integer) {
                                       var276 = (Integer)var3;
                                    }

                                    if (var276 != null) {
                                       var146 = ((Number)var276).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var276;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 73;
                                       if (var125.updateDehSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WaterTankFailure.INSTANCE)) {
                                    Boolean var277 = (Boolean)var28;
                                    if (var3 instanceof Boolean) {
                                       var277 = (Boolean)var3;
                                    }

                                    if (var277 != null) {
                                       boolean var223 = var277;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var277;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var223;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 74;
                                       if (var125.updateWaterTankFailure(var1, var223, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.SmartSubMode.INSTANCE)) {
                                    Integer var278 = (Integer)var72;
                                    if (var3 instanceof Integer) {
                                       var278 = (Integer)var3;
                                    }

                                    if (var278 != null) {
                                       var146 = ((Number)var278).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var278;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 75;
                                       if (var125.updateSmartSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.DetectCat.INSTANCE)) {
                                    Boolean var279 = (Boolean)var45;
                                    if (var3 instanceof Boolean) {
                                       var279 = (Boolean)var3;
                                    }

                                    if (var279 != null) {
                                       boolean var224 = var279;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var279;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var224;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 76;
                                       if (var125.updateDetectCat(var1, var224, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.BodyMounted.INSTANCE)) {
                                    Boolean var280 = (Boolean)var73;
                                    if (var3 instanceof Boolean) {
                                       var280 = (Boolean)var3;
                                    }

                                    if (var280 != null) {
                                       boolean var225 = var280;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var280;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var225;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 77;
                                       if (var125.updateBodyMounted(var1, var225, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CleanAirEta.INSTANCE)) {
                                    Integer var281 = (Integer)var57;
                                    if (var3 instanceof Integer) {
                                       var281 = (Integer)var3;
                                    }

                                    if (var281 != null) {
                                       var146 = ((Number)var281).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var281;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 78;
                                       if (var125.updateCleanAirEta(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.PanelDisplayMode.INSTANCE)) {
                                    Integer var282 = (Integer)var70;
                                    if (var3 instanceof Integer) {
                                       var282 = (Integer)var3;
                                    }

                                    if (var282 != null) {
                                       var146 = ((Number)var282).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var282;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 79;
                                       if (var125.updatePanelDisplayMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HoverEnabled.INSTANCE)) {
                                    Boolean var283 = (Boolean)var69;
                                    if (var3 instanceof Boolean) {
                                       var283 = (Boolean)var3;
                                    }

                                    if (var283 != null) {
                                       boolean var226 = var283;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var283;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var226;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 80;
                                       if (var125.updateHoverEnabled(var1, var226, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshEnabled.INSTANCE)) {
                                    Boolean var284 = (Boolean)var76;
                                    if (var3 instanceof Boolean) {
                                       var284 = (Boolean)var3;
                                    }

                                    if (var284 != null) {
                                       boolean var227 = var284;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var284;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var227;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 81;
                                       if (var125.updateAirRefreshEnabled(var1, var227, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshStatus.INSTANCE)) {
                                    Integer var285 = (Integer)var24;
                                    if (var3 instanceof Integer) {
                                       var285 = (Integer)var3;
                                    }

                                    if (var285 != null) {
                                       var146 = ((Number)var285).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var285;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 82;
                                       if (var125.updateAirRefreshStatus(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshDuration.INSTANCE)) {
                                    Integer var286 = (Integer)var51;
                                    if (var3 instanceof Integer) {
                                       var286 = (Integer)var3;
                                    }

                                    if (var286 != null) {
                                       var146 = ((Number)var286).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var286;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 83;
                                       if (var125.updateAirRefreshDuration(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshTimeStamp.INSTANCE)) {
                                    Integer var287 = (Integer)var25;
                                    if (var3 instanceof Integer) {
                                       var287 = (Integer)var3;
                                    }

                                    if (var287 != null) {
                                       var146 = ((Number)var287).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var287;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 84;
                                       if (var125.updateAirRefreshTimeStamp(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshStartTimeStamp.INSTANCE)) {
                                    Integer var288 = (Integer)var80;
                                    if (var3 instanceof Integer) {
                                       var288 = (Integer)var3;
                                    }

                                    if (var288 != null) {
                                       var146 = ((Number)var288).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var288;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 85;
                                       if (var125.updateAirRefreshStartTimeStamp(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.AirRefreshEndTimeStamp.INSTANCE)) {
                                    Integer var289 = (Integer)var31;
                                    if (var3 instanceof Integer) {
                                       var289 = (Integer)var3;
                                    }

                                    if (var289 != null) {
                                       var146 = ((Number)var289).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var289;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 86;
                                       if (var125.updateAirRefreshEndTimeStamp(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.RoomType.INSTANCE)) {
                                    Integer var290 = var339;
                                    if (var3 instanceof Integer) {
                                       var290 = (Integer)var3;
                                    }

                                    if (var290 != null) {
                                       var146 = ((Number)var290).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var290;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 87;
                                       if (var125.updateRoomType(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.NightLampBrightness.INSTANCE)) {
                                    Integer var291 = (Integer)var56;
                                    if (var3 instanceof Integer) {
                                       var291 = (Integer)var3;
                                    }

                                    if (var291 != null) {
                                       var146 = ((Number)var291).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var291;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 88;
                                       if (var125.updateNightLampBrightness(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.NightLampSteplessBrightness.INSTANCE)) {
                                    Integer var292 = (Integer)var39;
                                    if (var3 instanceof Integer) {
                                       var292 = (Integer)var3;
                                    }

                                    if (var292 != null) {
                                       var146 = ((Number)var292).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var292;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 89;
                                       if (var125.updateNightLampSteplessBrightness(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.YwrmEnabled.INSTANCE)) {
                                    Boolean var293 = (Boolean)var36;
                                    if (var3 instanceof Boolean) {
                                       var293 = (Boolean)var3;
                                    }

                                    ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                    ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                    ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                    ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                    ((<undefinedtype>)var21).L$4 = var293;
                                    ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var293);
                                    ((<undefinedtype>)var21).I$0 = 0;
                                    ((<undefinedtype>)var21).I$1 = 0;
                                    ((<undefinedtype>)var21).label = 90;
                                    if (var125.updateYwrmEnabled(var1, var293, (Continuation)var21) == var86) {
                                       return var86;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.YwrmUsage.INSTANCE)) {
                                    Integer var294 = (Integer)var79;
                                    if (var3 instanceof Integer) {
                                       var294 = (Integer)var3;
                                    }

                                    if (var294 != null) {
                                       var146 = ((Number)var294).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var294;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 91;
                                       if (var125.updateYwrmUsage(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.Alarms.INSTANCE)) {
                                    List var295 = (List)var49;
                                    if (var3 instanceof List) {
                                       var295 = (List)var3;
                                    }

                                    if (var295 != null) {
                                       String var350 = DeviceAlarmListConverter.Companion.fromDeviceAlarmList(var295);
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var295;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var295);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 92;
                                       if (var125.updateAlarms(var1, var350, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.HumSubMode.INSTANCE)) {
                                    Integer var296 = (Integer)var30;
                                    if (var3 instanceof Integer) {
                                       var296 = (Integer)var3;
                                    }

                                    if (var296 != null) {
                                       var146 = ((Number)var296).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var296;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 93;
                                       if (var125.updateHumSubMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.Use24Hour.INSTANCE)) {
                                    Boolean var297 = (Boolean)var52;
                                    if (var3 instanceof Boolean) {
                                       var297 = (Boolean)var3;
                                    }

                                    if (var297 != null) {
                                       boolean var228 = var297;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var297;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var228;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 94;
                                       if (var125.updateUse24Hour(var1, var228, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.WaterInfill.INSTANCE)) {
                                    Boolean var298 = (Boolean)var40;
                                    if (var3 instanceof Boolean) {
                                       var298 = (Boolean)var3;
                                    }

                                    if (var298 != null) {
                                       boolean var229 = var298;
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var298;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).Z$0 = var229;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 95;
                                       if (var125.updatWaterInfill(var1, var229, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.SensorMode.INSTANCE)) {
                                    Integer var299 = (Integer)var74;
                                    if (var3 instanceof Integer) {
                                       var299 = (Integer)var3;
                                    }

                                    if (var299 != null) {
                                       var146 = ((Number)var299).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var299;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 96;
                                       if (var125.updateSensorMode(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolAutoLevel.INSTANCE)) {
                                    Integer var300 = (Integer)var41;
                                    if (var3 instanceof Integer) {
                                       var300 = (Integer)var3;
                                    }

                                    if (var300 != null) {
                                       var146 = ((Number)var300).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var300;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 97;
                                       if (var125.updateCoolAutoLevel(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.CoolFanSpeedLevel.INSTANCE)) {
                                    Integer var301 = (Integer)var26;
                                    if (var3 instanceof Integer) {
                                       var301 = (Integer)var3;
                                    }

                                    if (var301 != null) {
                                       var146 = ((Number)var301).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var301;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 98;
                                       if (var125.updateCoolFanSpeedLevel(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.NightModeStartTime.INSTANCE)) {
                                    Long var302 = (Long)var34;
                                    if (var3 instanceof Long) {
                                       var302 = (Long)var3;
                                    }

                                    if (var302 != null) {
                                       long var215 = ((Number)var302).longValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var302;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).J$0 = var215;
                                       ((<undefinedtype>)var21).label = 99;
                                       if (var125.updateNightModeStartTime(var1, var215, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.DualOscillationConfig.INSTANCE)) {
                                    DualOscillationConfig var303 = (DualOscillationConfig)var63;
                                    if (var3 instanceof DualOscillationConfig) {
                                       var303 = (DualOscillationConfig)var3;
                                    }

                                    if (var303 != null) {
                                       int var13 = var303.getOscillationMode();
                                       var8 = var303.getHorizontalOscillationState();
                                       int var11 = var303.getHorizontalOscillationFixAngle();
                                       int var12 = var303.getHorizontalOscillationMinAngle();
                                       int var17 = var303.getHorizontalOscillationMaxAngle();
                                       int var15 = var303.getVerticalOscillationState();
                                       int var10 = var303.getVerticalOscillationFixAngle();
                                       int var14 = var303.getVerticalOscillationMinAngle();
                                       int var16 = var303.getVerticalOscillationMaxAngle();
                                       int var9 = var303.getHorizontalCalibrationState();
                                       var146 = var303.getVerticalCalibrationState();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var303;
                                       ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var303);
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = 0;
                                       ((<undefinedtype>)var21).label = 100;
                                       if (var125.updateDualOscillationConfig(var1, var13, var8, var11, var12, var17, var15, var10, var14, var16, var9, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else if (Intrinsics.areEqual(var2, DeviceField.Rpm.INSTANCE)) {
                                    Integer var304 = (Integer)var35;
                                    if (var3 instanceof Integer) {
                                       var304 = (Integer)var3;
                                    }

                                    if (var304 != null) {
                                       var146 = ((Number)var304).intValue();
                                       ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                       ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                       ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                       ((<undefinedtype>)var21).L$4 = var304;
                                       ((<undefinedtype>)var21).I$0 = 0;
                                       ((<undefinedtype>)var21).I$1 = var146;
                                       ((<undefinedtype>)var21).I$2 = 0;
                                       ((<undefinedtype>)var21).label = 101;
                                       if (var125.updateRpm(var1, var146, (Continuation)var21) == var86) {
                                          return var86;
                                       }

                                       return Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 } else {
                                    if (Intrinsics.areEqual(var2, DeviceField.NightPeriods.INSTANCE)) {
                                       double[] var305 = (double[])var82;
                                       if (var3 instanceof double[]) {
                                          var305 = (double[])var3;
                                       }

                                       if (var305 != null) {
                                          String var351 = DoubleArrayConverter.Companion.fromDoubleArray(var305);
                                          ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                          ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                                          ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                                          ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                                          ((<undefinedtype>)var21).L$4 = var305;
                                          ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var305);
                                          ((<undefinedtype>)var21).I$0 = 0;
                                          ((<undefinedtype>)var21).I$1 = 0;
                                          ((<undefinedtype>)var21).label = 102;
                                          if (var125.updateNightPeriods(var1, var351, (Continuation)var21) == var86) {
                                             return var86;
                                          }

                                          return Unit.INSTANCE;
                                       }
                                    } else {
                                       if (!Intrinsics.areEqual(var2, DeviceField.Unknown.INSTANCE)) {
                                          throw new NoWhenBranchMatchedException();
                                       }

                                       Unit var122 = Unit.INSTANCE;
                                    }

                                    return Unit.INSTANCE;
                                 }
                              }

                              var239 = (WelcomeHomeLocation)var3;
                              if (var239 == null) {
                                 var146 = 0;
                                 break label1168;
                              }

                              Double var360 = Boxing.boxDouble(var239.getLat());
                              Double var367 = Boxing.boxDouble(var239.getLng());
                              Integer var340 = Boxing.boxInt(var239.getRadius());
                              String var374 = var239.getTextValue();
                              Boolean var371 = Boxing.boxBoolean(var239.isEnabled());
                              ((<undefinedtype>)var21).L$0 = var1;
                              ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                              ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                              ((<undefinedtype>)var21).L$3 = var125;
                              ((<undefinedtype>)var21).L$4 = var239;
                              ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var239);
                              ((<undefinedtype>)var21).I$0 = 0;
                              ((<undefinedtype>)var21).I$1 = 0;
                              ((<undefinedtype>)var21).label = 35;
                              if (var125.updateWelcomeHome(var1, var360, var367, var340, var374, var371, (Continuation)var21) == var86) {
                                 return var86;
                              }

                              var146 = 0;
                              break;
                           case 1:
                           case 7:
                           case 10:
                           case 15:
                           case 16:
                           case 17:
                           case 25:
                           case 26:
                           case 27:
                           case 29:
                           case 30:
                           case 31:
                           case 33:
                           case 34:
                           case 69:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              var1 = (String)((<undefinedtype>)var21).L$5;
                              var1 = (String)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 2:
                              var8 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              var114 = (IndoorDatapoint)((<undefinedtype>)var21).L$5;
                              var126 = (IndoorDatapoint)((<undefinedtype>)var21).L$4;
                              var124 = (DeviceDao)((<undefinedtype>)var21).L$3;
                              var3 = ((<undefinedtype>)var21).L$2;
                              var339 = (DeviceField)((<undefinedtype>)var21).L$1;
                              var240 = (String)((<undefinedtype>)var21).L$0;
                              ResultKt.throwOnFailure(var87);
                              break label1124;
                           case 3:
                              var146 = ((<undefinedtype>)var21).I$3;
                              var146 = ((<undefinedtype>)var21).I$2;
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              IndoorDatapoint var108 = (IndoorDatapoint)((<undefinedtype>)var21).L$5;
                              var108 = (IndoorDatapoint)((<undefinedtype>)var21).L$4;
                              DeviceDao var110 = (DeviceDao)((<undefinedtype>)var21).L$3;
                              var110 = (DeviceDao)((<undefinedtype>)var21).L$2;
                              DeviceField var112 = (DeviceField)((<undefinedtype>)var21).L$1;
                              String var113 = (String)((<undefinedtype>)var21).L$0;
                              ResultKt.throwOnFailure(var87);
                              break label1519;
                           case 4:
                           case 5:
                           case 6:
                           case 8:
                           case 11:
                           case 12:
                           case 13:
                           case 32:
                           case 43:
                           case 45:
                           case 47:
                           case 48:
                           case 49:
                           case 51:
                           case 52:
                           case 53:
                           case 54:
                           case 55:
                           case 56:
                           case 57:
                           case 58:
                           case 59:
                           case 60:
                           case 63:
                           case 64:
                           case 65:
                           case 67:
                           case 70:
                           case 72:
                           case 73:
                           case 75:
                           case 78:
                           case 79:
                           case 82:
                           case 83:
                           case 84:
                           case 85:
                           case 86:
                           case 87:
                           case 88:
                           case 89:
                           case 91:
                           case 93:
                           case 96:
                           case 97:
                           case 98:
                           case 101:
                              var146 = ((<undefinedtype>)var21).I$2;
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              Integer var107 = (Integer)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 9:
                           case 18:
                           case 19:
                           case 20:
                           case 21:
                           case 22:
                           case 23:
                           case 24:
                           case 28:
                           case 37:
                           case 40:
                           case 41:
                           case 44:
                           case 46:
                           case 71:
                           case 74:
                           case 76:
                           case 77:
                           case 80:
                           case 81:
                           case 94:
                           case 95:
                              var146 = ((<undefinedtype>)var21).I$1;
                              boolean var20 = ((<undefinedtype>)var21).Z$0;
                              var146 = ((<undefinedtype>)var21).I$0;
                              break label1126;
                           case 14:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              DeviceField.SensorRanges var104 = (DeviceField.SensorRanges)((<undefinedtype>)var21).L$5;
                              var104 = (DeviceField.SensorRanges)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 35:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              WelcomeHomeLocation var103 = (WelcomeHomeLocation)((<undefinedtype>)var21).L$5;
                              var239 = (WelcomeHomeLocation)((<undefinedtype>)var21).L$4;
                              var125 = (DeviceDao)((<undefinedtype>)var21).L$3;
                              var3 = ((<undefinedtype>)var21).L$2;
                              var2 = (DeviceField)((<undefinedtype>)var21).L$1;
                              var1 = (String)((<undefinedtype>)var21).L$0;
                              ResultKt.throwOnFailure(var87);
                              break;
                           case 36:
                              var146 = ((<undefinedtype>)var21).I$0;
                              DeviceDao var99 = (DeviceDao)((<undefinedtype>)var21).L$3;
                              var99 = (DeviceDao)((<undefinedtype>)var21).L$2;
                              DeviceField var101 = (DeviceField)((<undefinedtype>)var21).L$1;
                              String var102 = (String)((<undefinedtype>)var21).L$0;
                              ResultKt.throwOnFailure(var87);
                              break label1202;
                           case 38:
                           case 42:
                           case 50:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              Pair var97 = (Pair)((<undefinedtype>)var21).L$5;
                              var97 = (Pair)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 39:
                              var146 = ((<undefinedtype>)var21).I$0;
                              break label1518;
                           case 61:
                           case 62:
                              double var5 = ((<undefinedtype>)var21).D$0;
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              Double var96 = (Double)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 66:
                           case 68:
                           case 102:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              double[] var94 = (double[])((<undefinedtype>)var21).L$5;
                              var94 = (double[])((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 90:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              Boolean var93 = (Boolean)((<undefinedtype>)var21).L$5;
                              break label1126;
                           case 92:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              List var91 = (List)((<undefinedtype>)var21).L$5;
                              var91 = (List)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 99:
                              long var18 = ((<undefinedtype>)var21).J$0;
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              Long var90 = (Long)((<undefinedtype>)var21).L$4;
                              break label1518;
                           case 100:
                              var146 = ((<undefinedtype>)var21).I$1;
                              var146 = ((<undefinedtype>)var21).I$0;
                              DualOscillationConfig var88 = (DualOscillationConfig)((<undefinedtype>)var21).L$5;
                              var88 = (DualOscillationConfig)((<undefinedtype>)var21).L$4;
                              break label1518;
                           default:
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        if (var239 != null) {
                           return Unit.INSTANCE;
                        }
                        break label1168;
                     }

                     Integer var365 = var114.getDisinftime();
                     if (var365 == null) {
                        return Unit.INSTANCE;
                     }

                     int var212 = ((Number)var365).intValue();
                     if (var212 > 0) {
                        Integer var370 = Boxing.boxInt(var212);
                        Long var366 = Boxing.boxLong(var114.getTimeInSeconds());
                        ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var240);
                        ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var339);
                        ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                        ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var124);
                        ((<undefinedtype>)var21).L$4 = var126;
                        ((<undefinedtype>)var21).L$5 = SpillingKt.nullOutSpilledVariable(var114);
                        ((<undefinedtype>)var21).I$0 = var146;
                        ((<undefinedtype>)var21).I$1 = var8;
                        ((<undefinedtype>)var21).I$2 = var212;
                        ((<undefinedtype>)var21).I$3 = 0;
                        ((<undefinedtype>)var21).label = 3;
                        if (var124.updateDisinfectLeftTime(var240, var370, var366, (Continuation)var21) == var86) {
                           return var86;
                        }
                     }
                     break label1519;
                  }

                  ((<undefinedtype>)var21).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                  ((<undefinedtype>)var21).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                  ((<undefinedtype>)var21).L$2 = SpillingKt.nullOutSpilledVariable(var3);
                  ((<undefinedtype>)var21).L$3 = SpillingKt.nullOutSpilledVariable(var125);
                  ((<undefinedtype>)var21).L$4 = null;
                  ((<undefinedtype>)var21).L$5 = null;
                  ((<undefinedtype>)var21).I$0 = var146;
                  ((<undefinedtype>)var21).label = 36;
                  if (var125.updateWelcomeHome(var1, (Double)null, (Double)null, (Integer)null, (String)null, (Boolean)null, (Continuation)var21) == var86) {
                     return var86;
                  }
                  break label1202;
               }

               Boolean var106 = (Boolean)((<undefinedtype>)var21).L$4;
               break label1518;
            }

            Unit var121 = Unit.INSTANCE;
            return Unit.INSTANCE;
         }

         Unit var123 = Unit.INSTANCE;
         return Unit.INSTANCE;
      }

      DeviceDao var117 = (DeviceDao)((<undefinedtype>)var21).L$3;
      var117 = (DeviceDao)((<undefinedtype>)var21).L$2;
      DeviceField var119 = (DeviceField)((<undefinedtype>)var21).L$1;
      String var120 = (String)((<undefinedtype>)var21).L$0;
      ResultKt.throwOnFailure(var87);
      return Unit.INSTANCE;
   }
}
