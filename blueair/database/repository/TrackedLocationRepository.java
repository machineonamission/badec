package com.blueair.database.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.dao.AqiDataDao;
import com.blueair.database.dao.TrackedLocationDao;
import com.blueair.database.entity.AqiDataEntity;
import com.blueair.database.entity.TrackedLocationEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010'J\u000e\u0010)\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\u0007H\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010$J\u0016\u0010/\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010$J\u000e\u00100\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010*J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010$J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\f2\u0006\u0010!\u001a\u00020\"J\u000e\u00101\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000e¨\u00062"},
   d2 = {"Lcom/blueair/database/repository/TrackedLocationRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "<init>", "(Lcom/blueair/database/BlueairDatabase;)V", "trackedLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getTrackedLocations", "()Ljava/util/List;", "liveTrackedLocations", "Landroidx/lifecycle/LiveData;", "getLiveTrackedLocations", "()Landroidx/lifecycle/LiveData;", "userTrackedLocations", "getUserTrackedLocations", "liveUserTrackedLocations", "getLiveUserTrackedLocations", "currentLocation", "getCurrentLocation", "()Lcom/blueair/core/model/TrackedLocation;", "liveCurrentLocation", "getLiveCurrentLocation", "aqiData", "Lcom/blueair/core/model/AqiData;", "getAqiData", "liveAqiData", "getLiveAqiData", "setTrackedLocations", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveTrackedLocation", "locationId", "", "getTrackedLocation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrackedLocation", "trackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackedLocation", "deleteAllTrackedLocations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAqiData", "(Lcom/blueair/core/model/AqiData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAqiData", "locationIds", "deleteDeviceLocationInfo", "deleteAllAqiData", "deleteAllOutdoorData", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TrackedLocationRepository {
   private final BlueairDatabase blueairDb;
   private final LiveData liveAqiData;
   private final LiveData liveCurrentLocation;
   private final LiveData liveTrackedLocations;
   private final LiveData liveUserTrackedLocations;

   // $FF: synthetic method
   public static List $r8$lambda$8xzilVlZFwiiy_XLjD5x_Wq7OOI/* $FF was: $r8$lambda$8xzilVlZFwiiy_XLjD5x-Wq7OOI*/(List var0) {
      return liveUserTrackedLocations$lambda$5(var0);
   }

   // $FF: synthetic method
   public static TrackedLocation $r8$lambda$JI1r_mS9mFiPqAfqom18ZNwm9CE(TrackedLocationEntity var0) {
      return liveCurrentLocation$lambda$6(var0);
   }

   // $FF: synthetic method
   public static List $r8$lambda$Tu7nK1ztRud0x5gIMuXZ3VRfp28(List var0) {
      return liveAqiData$lambda$9(var0);
   }

   // $FF: synthetic method
   public static AqiData $r8$lambda$VNZN9s5AlEp2mDAnMYa1mydfoL0(AqiDataEntity var0) {
      return liveAqiData$lambda$16(var0);
   }

   // $FF: synthetic method
   public static TrackedLocation $r8$lambda$Xz1hVkwGPxdxsy6ZDgkzz2WlzO0(TrackedLocationEntity var0) {
      return getLiveTrackedLocation$lambda$14(var0);
   }

   // $FF: synthetic method
   public static List $r8$lambda$_7iD9quSIICvtwURbRc4yn8xabA(List var0) {
      return liveTrackedLocations$lambda$2(var0);
   }

   public TrackedLocationRepository(BlueairDatabase var1) {
      Intrinsics.checkNotNullParameter(var1, "blueairDb");
      super();
      this.blueairDb = var1;
      LiveData var2 = Transformations.distinctUntilChanged(Transformations.map(var1.trackedLocationDao().getLiveTrackedLocations(), new TrackedLocationRepository$$ExternalSyntheticLambda1()));
      this.liveTrackedLocations = var2;
      this.liveUserTrackedLocations = Transformations.map(var2, new TrackedLocationRepository$$ExternalSyntheticLambda2());
      this.liveCurrentLocation = Transformations.distinctUntilChanged(Transformations.map(var1.trackedLocationDao().getLiveCurrentLocation(), new TrackedLocationRepository$$ExternalSyntheticLambda3()));
      this.liveAqiData = Transformations.distinctUntilChanged(Transformations.map(var1.aqiDataDao().getLiveAqiData(), new TrackedLocationRepository$$ExternalSyntheticLambda4()));
   }

   // $FF: synthetic method
   public static final Object access$deleteAllAqiData(TrackedLocationRepository var0, Continuation var1) {
      return var0.deleteAllAqiData(var1);
   }

   // $FF: synthetic method
   public static final Object access$deleteAqiData(TrackedLocationRepository var0, String var1, Continuation var2) {
      return var0.deleteAqiData(var1, var2);
   }

   // $FF: synthetic method
   public static final Object access$deleteAqiData(TrackedLocationRepository var0, List var1, Continuation var2) {
      return var0.deleteAqiData(var1, var2);
   }

   // $FF: synthetic method
   public static final Object access$deleteDeviceLocationInfo(TrackedLocationRepository var0, String var1, Continuation var2) {
      return var0.deleteDeviceLocationInfo(var1, var2);
   }

   private final Object deleteAllAqiData(Continuation var1) {
      Object var2 = this.blueairDb.aqiDataDao().deleteAll(var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   private final Object deleteAqiData(String var1, Continuation var2) {
      Object var3 = this.blueairDb.aqiDataDao().delete(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   private final Object deleteAqiData(List var1, Continuation var2) {
      Object var3 = this.blueairDb.aqiDataDao().delete(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   private final Object deleteDeviceLocationInfo(String var1, Continuation var2) {
      Object var3 = this.blueairDb.deviceDao().deleteLocationId(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   private static final TrackedLocation getLiveTrackedLocation$lambda$14(TrackedLocationEntity var0) {
      return var0 != null ? var0.toTrackedLocation() : null;
   }

   private static final AqiData liveAqiData$lambda$16(AqiDataEntity var0) {
      return var0 != null ? var0.toAqiData() : null;
   }

   private static final List liveAqiData$lambda$9(List var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Iterable var1 = (Iterable)var0;
      Collection var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var1, 10)));
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add(((AqiDataEntity)var3.next()).toAqiData());
      }

      return (List)var2;
   }

   private static final TrackedLocation liveCurrentLocation$lambda$6(TrackedLocationEntity var0) {
      return var0 != null ? var0.toTrackedLocation() : null;
   }

   private static final List liveTrackedLocations$lambda$2(List var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Iterable var1 = (Iterable)var0;
      Collection var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var1, 10)));
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add(((TrackedLocationEntity)var3.next()).toTrackedLocation());
      }

      return (List)var2;
   }

   private static final List liveUserTrackedLocations$lambda$5(List var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Iterable var1 = (Iterable)var0;
      Collection var3 = (Collection)(new ArrayList());

      for(Object var2 : var1) {
         if (!Intrinsics.areEqual(((TrackedLocation)var2).getId(), "current")) {
            var3.add(var2);
         }
      }

      return (List)var3;
   }

   public final Object deleteAllOutdoorData(Continuation var1) {
      Object var2 = this.deleteAllTrackedLocations(var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final Object deleteAllTrackedLocations(Continuation var1) {
      label35: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label35;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final TrackedLocationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteAllTrackedLocations((Continuation)this);
            }
         };
      }

      Object var4 = ((<undefinedtype>)var5).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            ResultKt.throwOnFailure(var4);
            return Unit.INSTANCE;
         }

         ResultKt.throwOnFailure(var4);
      } else {
         ResultKt.throwOnFailure(var4);
         TrackedLocationDao var7 = this.blueairDb.trackedLocationDao();
         ((<undefinedtype>)var5).label = 1;
         if (var7.deleteAll((Continuation)var5) == var6) {
            return var6;
         }
      }

      ((<undefinedtype>)var5).label = 2;
      if (this.deleteAllAqiData((Continuation)var5) == var6) {
         return var6;
      } else {
         return Unit.INSTANCE;
      }
   }

   public final Object deleteTrackedLocation(TrackedLocation var1, Continuation var2) {
      label44: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label44;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final TrackedLocationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteTrackedLocation((TrackedLocation)null, (Continuation)this);
            }
         };
      }

      Object var9;
      label37: {
         Object var5 = ((<undefinedtype>)var8).result;
         var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var8).label;
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var1 = (TrackedLocation)((<undefinedtype>)var8).L$0;
                  ResultKt.throwOnFailure(var5);
                  return Unit.INSTANCE;
               }

               var1 = (TrackedLocation)((<undefinedtype>)var8).L$0;
               ResultKt.throwOnFailure(var5);
               break label37;
            }

            var1 = (TrackedLocation)((<undefinedtype>)var8).L$0;
            ResultKt.throwOnFailure(var5);
         } else {
            ResultKt.throwOnFailure(var5);
            TrackedLocationDao var6 = this.blueairDb.trackedLocationDao();
            String var10 = var1.getId();
            ((<undefinedtype>)var8).L$0 = var1;
            ((<undefinedtype>)var8).label = 1;
            if (var6.deleteTrackedLocation((String)var10, (Continuation)var8) == var9) {
               return var9;
            }
         }

         String var11 = var1.getId();
         ((<undefinedtype>)var8).L$0 = var1;
         ((<undefinedtype>)var8).label = 2;
         if (this.deleteAqiData((String)var11, (Continuation)var8) == var9) {
            return var9;
         }
      }

      String var12 = var1.getId();
      ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
      ((<undefinedtype>)var8).label = 3;
      if (this.deleteDeviceLocationInfo(var12, (Continuation)var8) == var9) {
         return var9;
      } else {
         return Unit.INSTANCE;
      }
   }

   public final Object getAqiData(String var1, Continuation var2) {
      label27: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var9 = var4;
               break label27;
            }
         }

         var9 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final TrackedLocationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAqiData((String)null, (Continuation)this);
            }
         };
      }

      AqiDataDao var11 = (AqiDataDao)((<undefinedtype>)var9).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var9).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var9).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var11;
      } else {
         ResultKt.throwOnFailure(var11);
         var11 = this.blueairDb.aqiDataDao();
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var9).label = 1;
         Object var10 = var11.getAqiData(var1, (Continuation)var9);
         var7 = var10;
         if (var10 == var5) {
            return var5;
         }
      }

      AqiDataEntity var8 = (AqiDataEntity)var7;
      return var8 != null ? var8.toAqiData() : null;
   }

   public final List getAqiData() {
      Iterable var2 = (Iterable)this.blueairDb.aqiDataDao().getAqiData();
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         var1.add(((AqiDataEntity)var3.next()).toAqiData());
      }

      return (List)var1;
   }

   public final TrackedLocation getCurrentLocation() {
      TrackedLocationEntity var1 = this.blueairDb.trackedLocationDao().getCurrentLocation();
      return var1 != null ? var1.toTrackedLocation() : null;
   }

   public final LiveData getLiveAqiData() {
      return this.liveAqiData;
   }

   public final LiveData getLiveCurrentLocation() {
      return this.liveCurrentLocation;
   }

   public final LiveData getLiveTrackedLocation(String var1) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      return Transformations.distinctUntilChanged(Transformations.map(this.blueairDb.trackedLocationDao().liveTrackedLocation(var1), new TrackedLocationRepository$$ExternalSyntheticLambda0()));
   }

   public final LiveData getLiveTrackedLocations() {
      return this.liveTrackedLocations;
   }

   public final LiveData getLiveUserTrackedLocations() {
      return this.liveUserTrackedLocations;
   }

   public final Object getTrackedLocation(String var1, Continuation var2) {
      label27: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var9 = var4;
               break label27;
            }
         }

         var9 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final TrackedLocationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getTrackedLocation((String)null, (Continuation)this);
            }
         };
      }

      TrackedLocationDao var11 = (TrackedLocationDao)((<undefinedtype>)var9).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var9).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var9).L$0;
         ResultKt.throwOnFailure(var11);
         var7 = var11;
      } else {
         ResultKt.throwOnFailure(var11);
         var11 = this.blueairDb.trackedLocationDao();
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var9).label = 1;
         Object var10 = var11.getTrackedLocation(var1, (Continuation)var9);
         var7 = var10;
         if (var10 == var5) {
            return var5;
         }
      }

      TrackedLocationEntity var8 = (TrackedLocationEntity)var7;
      return var8 != null ? var8.toTrackedLocation() : null;
   }

   public final List getTrackedLocations() {
      Iterable var2 = (Iterable)this.blueairDb.trackedLocationDao().getTrackedLocations();
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         var1.add(((TrackedLocationEntity)var3.next()).toTrackedLocation());
      }

      return (List)var1;
   }

   public final List getUserTrackedLocations() {
      Iterable var2 = (Iterable)this.getTrackedLocations();
      Collection var1 = (Collection)(new ArrayList());

      for(Object var4 : var2) {
         if (!Intrinsics.areEqual(((TrackedLocation)var4).getId(), "current")) {
            var1.add(var4);
         }
      }

      return (List)var1;
   }

   public final Object insertAqiData(AqiData var1, Continuation var2) {
      Object var3 = this.blueairDb.aqiDataDao().insert(AqiDataEntity.Companion.fromTrackedLocationData(var1), var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Object insertAqiData(List var1, Continuation var2) {
      AqiDataDao var3 = this.blueairDb.aqiDataDao();
      Iterable var4 = (Iterable)var1;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));

      for(AqiData var5 : var4) {
         var6.add(AqiDataEntity.Companion.fromTrackedLocationData(var5));
      }

      Object var7 = var3.insertAll((List)var6, var2);
      return var7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var7 : Unit.INSTANCE;
   }

   public final Object insertTrackedLocation(TrackedLocation var1, Continuation var2) {
      Object var3 = this.blueairDb.trackedLocationDao().insert(TrackedLocationEntity.Companion.fromTrackedLocation(var1), var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final LiveData liveAqiData(String var1) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      return Transformations.map(this.blueairDb.aqiDataDao().getLiveAqiData(var1), new TrackedLocationRepository$$ExternalSyntheticLambda5());
   }

   public final Object setTrackedLocations(List var1, Continuation var2) {
      label64: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var14 = var4;
               break label64;
            }
         }

         var14 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final TrackedLocationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setTrackedLocations((List)null, (Continuation)this);
            }
         };
      }

      Object var8 = ((<undefinedtype>)var14).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var14).label;
      List var5;
      TrackedLocationDao var6;
      List var17;
      if (var3 != 0) {
         if (var3 != 1) {
            if (var3 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var3 = ((<undefinedtype>)var14).I$0;
            var1 = (List)((<undefinedtype>)var14).L$3;
            var1 = (List)((<undefinedtype>)var14).L$2;
            TrackedLocationDao var12 = (TrackedLocationDao)((<undefinedtype>)var14).L$1;
            List var13 = (List)((<undefinedtype>)var14).L$0;
            ResultKt.throwOnFailure(var8);
            return Unit.INSTANCE;
         }

         var3 = ((<undefinedtype>)var14).I$0;
         var17 = (List)((<undefinedtype>)var14).L$3;
         var5 = (List)((<undefinedtype>)var14).L$2;
         var6 = (TrackedLocationDao)((<undefinedtype>)var14).L$1;
         var1 = (List)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var8);
      } else {
         ResultKt.throwOnFailure(var8);
         var6 = this.blueairDb.trackedLocationDao();
         Iterable var19 = (Iterable)var1;
         Collection var18 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var19, 10)));
         Iterator var20 = var19.iterator();

         while(var20.hasNext()) {
            var18.add(((TrackedLocation)var20.next()).getId());
         }

         var17 = (List)var18;
         Iterable var23 = (Iterable)this.getUserTrackedLocations();
         Collection var21 = (Collection)(new ArrayList());

         for(Object var24 : var23) {
            if (!var17.contains(((TrackedLocation)var24).getId())) {
               var21.add(var24);
            }
         }

         var23 = (Iterable)((List)var21);
         var21 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var23, 10)));
         Iterator var26 = var23.iterator();

         while(var26.hasNext()) {
            var21.add(((TrackedLocation)var26.next()).getId());
         }

         var5 = (List)var21;
         var6.deleteTrackedLocations(var5);
         ((<undefinedtype>)var14).L$0 = var1;
         ((<undefinedtype>)var14).L$1 = var6;
         ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var5);
         ((<undefinedtype>)var14).L$3 = SpillingKt.nullOutSpilledVariable(var17);
         var3 = 0;
         ((<undefinedtype>)var14).I$0 = 0;
         ((<undefinedtype>)var14).label = 1;
         if (this.deleteAqiData((List)var5, (Continuation)var14) == var7) {
            return var7;
         }
      }

      List var27 = TrackedLocationEntity.Companion.fromTrackedLocations(var1);
      ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
      ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var6);
      ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var5);
      ((<undefinedtype>)var14).L$3 = SpillingKt.nullOutSpilledVariable(var17);
      ((<undefinedtype>)var14).I$0 = var3;
      ((<undefinedtype>)var14).label = 2;
      if (var6.insert((List)var27, (Continuation)var14) == var7) {
         return var7;
      } else {
         return Unit.INSTANCE;
      }
   }
}
