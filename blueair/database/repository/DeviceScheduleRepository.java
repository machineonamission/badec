package com.blueair.database.repository;

import androidx.lifecycle.LiveData;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.dao.DeviceScheduleDao;
import com.blueair.database.entity.DeviceScheduleEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0086@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006!"},
   d2 = {"Lcom/blueair/database/repository/DeviceScheduleRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "<init>", "(Lcom/blueair/database/BlueairDatabase;)V", "liveDataScheduleList", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/database/entity/DeviceScheduleEntity;", "getLiveDataScheduleList", "()Landroidx/lifecycle/LiveData;", "getSchedules", "Lcom/blueair/core/model/DeviceSchedule;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMergedSchedulesFor", "Lcom/blueair/core/model/DeviceScheduleMerged;", "deviceId", "", "legacy", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replace", "", "deviceSchedules", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "schedule", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "scheduleId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleRepository {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final BlueairDatabase blueairDb;

   public DeviceScheduleRepository(BlueairDatabase var1) {
      Intrinsics.checkNotNullParameter(var1, "blueairDb");
      super();
      this.blueairDb = var1;
   }

   private final LiveData getLiveDataScheduleList() {
      return this.blueairDb.deviceScheduleDao().getLiveSchedules();
   }

   public final Object delete(String var1, Continuation var2) {
      Object var3 = this.blueairDb.deviceScheduleDao().delete(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Object getMergedSchedulesFor(String var1, boolean var2, Continuation var3) {
      label32: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var10 = var5;
               break label32;
            }
         }

         var10 = new ContinuationImpl(this, var3) {
            Object L$0;
            boolean Z$0;
            int label;
            Object result;
            final DeviceScheduleRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getMergedSchedulesFor((String)null, false, (Continuation)this);
            }
         };
      }

      DeviceScheduleDao var14 = (DeviceScheduleDao)((<undefinedtype>)var10).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var10).label;
      Object var8;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var10).Z$0;
         String var7 = (String)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var14);
         var8 = var14;
      } else {
         ResultKt.throwOnFailure(var14);
         var14 = this.blueairDb.deviceScheduleDao();
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).Z$0 = var2;
         ((<undefinedtype>)var10).label = 1;
         Object var11 = var14.getByDeviceId(var1, (Continuation)var10);
         var8 = var11;
         if (var11 == var6) {
            return var6;
         }
      }

      List var9 = (List)var8;
      Iterable var16 = (Iterable)var9;
      Collection var12 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
      Iterator var17 = var16.iterator();

      while(var17.hasNext()) {
         var12.add(((DeviceScheduleEntity)var17.next()).toDeviceSchedule());
      }

      List var18 = (List)var12;
      Timber.Forest var13 = Timber.Forest;
      StringBuilder var19 = new StringBuilder("After querying the db ");
      var19.append(((Collection)var9).size());
      var19.append(", converted records ");
      var19.append(((Collection)var18).size());
      var13.d(var19.toString(), new Object[0]);
      return Companion.legacyScheduleMergeIfNeeded(var18, var2);
   }

   public final Object getSchedules(Continuation var1) {
      label32: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label32;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final DeviceScheduleRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSchedules((Continuation)this);
            }
         };
      }

      DeviceScheduleDao var8 = (DeviceScheduleDao)((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var8);
         var6 = var8;
      } else {
         ResultKt.throwOnFailure(var8);
         var8 = this.blueairDb.deviceScheduleDao();
         ((<undefinedtype>)var5).label = 1;
         var8 = (DeviceScheduleDao)var8.getAll((Continuation)var5);
         var6 = var8;
         if (var8 == var4) {
            return var4;
         }
      }

      Iterable var11 = (Iterable)var6;
      Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var11, 10)));
      Iterator var12 = var11.iterator();

      while(var12.hasNext()) {
         var7.add(((DeviceScheduleEntity)var12.next()).toDeviceSchedule());
      }

      return (List)var7;
   }

   public final Object replace(List var1, String var2, Continuation var3) {
      label50: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var12 = var5;
               break label50;
            }
         }

         var12 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final DeviceScheduleRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.replace((List)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var7 = ((<undefinedtype>)var12).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var12).label;
      List var13;
      if (var4 != 0) {
         if (var4 != 1) {
            if (var4 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var1 = (List)((<undefinedtype>)var12).L$2;
            String var10 = (String)((<undefinedtype>)var12).L$1;
            List var11 = (List)((<undefinedtype>)var12).L$0;
            ResultKt.throwOnFailure(var7);
            return Unit.INSTANCE;
         }

         var13 = (List)((<undefinedtype>)var12).L$2;
         var2 = (String)((<undefinedtype>)var12).L$1;
         var1 = (List)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var7);
      } else {
         ResultKt.throwOnFailure(var7);
         Iterable var15 = (Iterable)var1;
         Collection var14 = (Collection)(new ArrayList());

         for(DeviceSchedule var8 : var15) {
            DeviceScheduleEntity var19 = DeviceScheduleEntity.Companion.fromDeviceSchedule(var8);
            if (var19 != null) {
               var14.add(var19);
            }
         }

         var13 = (List)var14;
         DeviceScheduleDao var17 = this.blueairDb.deviceScheduleDao();
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var12).L$2 = var13;
         ((<undefinedtype>)var12).label = 1;
         if (var17.deleteAllForDevice(var2, (Continuation)var12) == var6) {
            return var6;
         }
      }

      if (((Collection)var13).isEmpty()) {
         return Unit.INSTANCE;
      } else {
         DeviceScheduleDao var18 = this.blueairDb.deviceScheduleDao();
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var12).label = 2;
         if (var18.insert(var13, (Continuation)var12) == var6) {
            return var6;
         } else {
            return Unit.INSTANCE;
         }
      }
   }

   public final Object update(DeviceSchedule var1, Continuation var2) {
      DeviceScheduleEntity var3 = DeviceScheduleEntity.Companion.fromDeviceSchedule(var1);
      if (var3 != null) {
         var3 = (DeviceScheduleEntity)this.blueairDb.deviceScheduleDao().update(var3, var2);
         if (var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return var3;
         }
      }

      return Unit.INSTANCE;
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"},
      d2 = {"Lcom/blueair/database/repository/DeviceScheduleRepository$Companion;", "", "<init>", "()V", "legacyScheduleMergeIfNeeded", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "deviceScheduleList", "Lcom/blueair/core/model/DeviceSchedule;", "legacy", "", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final List legacyScheduleMergeIfNeeded(List var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "deviceScheduleList");
         List var5 = (List)(new ArrayList());
         if (var2) {
            Iterator var6 = ((Iterable)CollectionsKt.getIndices((Collection)var1)).iterator();

            while(var6.hasNext()) {
               DeviceSchedule var8 = (DeviceSchedule)var1.get(((IntIterator)var6).nextInt());
               Iterable var9 = (Iterable)var1;
               Collection var7 = (Collection)(new ArrayList());

               for(Object var21 : var9) {
                  if (var8.isSameTimeSchedule((DeviceSchedule)var21)) {
                     var7.add(var21);
                  }
               }

               List var20 = (List)var7;
               Iterator var22 = ((Iterable)var5).iterator();
               boolean var4 = true;

               while(var22.hasNext()) {
                  Iterator var23 = ((Iterable)((List)var22.next())).iterator();
                  boolean var3 = var4;

                  while(true) {
                     var4 = var3;
                     if (!var23.hasNext()) {
                        break;
                     }

                     DeviceSchedule var19 = (DeviceSchedule)var23.next();
                     Iterator var11 = ((Iterable)var20).iterator();
                     var4 = true;

                     while(var11.hasNext()) {
                        if (var19.isSameTimeSchedule((DeviceSchedule)var11.next())) {
                           var4 = false;
                        }
                     }

                     if (var4 && var3) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }
                  }
               }

               if (var4) {
                  var5.add(var20);
               }
            }
         } else {
            Iterator var12 = ((Iterable)var1).iterator();

            while(var12.hasNext()) {
               var5.add(CollectionsKt.listOf((DeviceSchedule)var12.next()));
            }
         }

         Iterable var15 = (Iterable)var5;
         Collection var13 = (Collection)(new ArrayList());

         for(List var17 : var15) {
            DeviceScheduleMerged var18 = DeviceScheduleMerged.Companion.newInstance(var17);
            if (var18 != null) {
               var13.add(var18);
            }
         }

         return (List)var13;
      }
   }
}
