package com.blueair.devicemanager;

import android.content.Context;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.database.repository.DeviceScheduleRepository;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.joda.time.format.DateTimeFormat;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010$\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010%\u001a\n &*\u0004\u0018\u00010\u00160\u00162\u0006\u0010'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"},
   d2 = {"Lcom/blueair/devicemanager/DeviceScheduleService;", "Lkotlinx/coroutines/CoroutineScope;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "deviceScheduleRepository", "Lcom/blueair/database/repository/DeviceScheduleRepository;", "<init>", "(Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/database/repository/DeviceScheduleRepository;)V", "createSchedule", "", "device", "Lcom/blueair/core/model/Device;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "editingSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceSchedule;Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedulesFor", "", "deviceId", "", "legacy", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMergedSchedule", "merged", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMergedScheduleLocally", "(Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSchedulesForDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpdatedDefaultNameIfRequired", "nuSchedule", "oldSchedule", "getDefaultScheduleName", "to12hFormat", "kotlin.jvm.PlatformType", "time", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleService implements CoroutineScope {
   private final DefaultCoroutineScope $$delegate_0;
   private final DeviceManager deviceManager;
   private final DeviceScheduleRepository deviceScheduleRepository;

   public DeviceScheduleService(DeviceManager var1, DeviceScheduleRepository var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceManager");
      Intrinsics.checkNotNullParameter(var2, "deviceScheduleRepository");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.deviceManager = var1;
      this.deviceScheduleRepository = var2;
   }

   private final Object deleteMergedScheduleLocally(DeviceScheduleMerged var1, Continuation var2) {
      label39: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var13 = var4;
               break label39;
            }
         }

         var13 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            Object result;
            final DeviceScheduleService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteMergedScheduleLocally((DeviceScheduleMerged)null, (Continuation)this);
            }
         };
      }

      Object var8 = ((<undefinedtype>)var13).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var13).label;
      Iterable var5;
      List var6;
      Iterator var16;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var13).I$1;
         var3 = ((<undefinedtype>)var13).I$0;
         String var11 = (String)((<undefinedtype>)var13).L$5;
         Object var12 = ((<undefinedtype>)var13).L$4;
         var16 = (Iterator)((<undefinedtype>)var13).L$3;
         var5 = (Iterable)((<undefinedtype>)var13).L$2;
         var6 = (List)((<undefinedtype>)var13).L$1;
         var1 = (DeviceScheduleMerged)((<undefinedtype>)var13).L$0;
         ResultKt.throwOnFailure(var8);
      } else {
         ResultKt.throwOnFailure(var8);
         var5 = (Iterable)var1.getSchedule();
         Collection var17 = (Collection)(new ArrayList());
         Iterator var19 = var5.iterator();

         while(var19.hasNext()) {
            String var20 = ((DeviceSchedule)var19.next()).getScheduleId();
            if (var20 != null) {
               var17.add(var20);
            }
         }

         var6 = (List)var17;
         var5 = (Iterable)var6;
         var16 = var5.iterator();
         var3 = 0;
      }

      while(var16.hasNext()) {
         var8 = var16.next();
         String var9 = (String)var8;
         DeviceScheduleRepository var10 = this.deviceScheduleRepository;
         ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var6);
         ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var5);
         ((<undefinedtype>)var13).L$3 = var16;
         ((<undefinedtype>)var13).L$4 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var13).L$5 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var13).I$0 = var3;
         ((<undefinedtype>)var13).I$1 = 0;
         ((<undefinedtype>)var13).label = 1;
         if (var10.delete(var9, (Continuation)var13) == var7) {
            return var7;
         }
      }

      return Unit.INSTANCE;
   }

   private final String getDefaultScheduleName(DeviceSchedule var1) {
      Object var3;
      label98: {
         var3 = null;
         if (var1 != null) {
            String var2;
            try {
               var2 = var1.getScheduleName();
            } catch (Exception var14) {
               boolean var10001 = false;
               break label98;
            }

            if (var2 != null) {
               try {
                  var15 = StringsKt.split$default((CharSequence)var2, new String[]{"-"}, false, 0, 6, (Object)null);
               } catch (Exception var13) {
                  boolean var27 = false;
                  break label98;
               }

               if (var15 != null) {
                  try {
                     var2 = (String)CollectionsKt.first(var15);
                  } catch (Exception var12) {
                     boolean var28 = false;
                     break label98;
                  }

                  if (var2 != null) {
                     try {
                        var2 = StringsKt.trim((CharSequence)var2).toString();
                     } catch (Exception var11) {
                        boolean var29 = false;
                        break label98;
                     }

                     if (var2 != null) {
                        try {
                           SimpleDateFormat var4 = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                           var4.parse(var2);
                           StringBuilder var18 = new StringBuilder();
                           var18.append(this.to12hFormat(var1.getStartTime()));
                           var18.append(" - ");
                           var18.append(this.to12hFormat(var1.getEndTime()));
                           var2 = var18.toString();
                        } catch (Exception var10) {
                           boolean var30 = false;
                           break label98;
                        }

                        if (var2 != null) {
                           return var2;
                        }
                     }
                  }
               }
            }
         }

         StringBuilder var25;
         try {
            var25 = new StringBuilder();
         } catch (Exception var9) {
            boolean var31 = false;
            break label98;
         }

         String var20;
         if (var1 != null) {
            try {
               var20 = var1.getStartTime();
            } catch (Exception var8) {
               boolean var32 = false;
               break label98;
            }
         } else {
            var20 = null;
         }

         try {
            var25.append(var20);
            var25.append(" - ");
         } catch (Exception var7) {
            boolean var33 = false;
            break label98;
         }

         if (var1 != null) {
            try {
               var20 = var1.getEndTime();
            } catch (Exception var6) {
               boolean var34 = false;
               break label98;
            }
         } else {
            var20 = null;
         }

         try {
            var25.append(var20);
            var20 = var25.toString();
            return var20;
         } catch (Exception var5) {
            boolean var35 = false;
         }
      }

      StringBuilder var26 = new StringBuilder();
      String var22;
      if (var1 != null) {
         var22 = var1.getStartTime();
      } else {
         var22 = null;
      }

      var26.append(var22);
      var26.append(" - ");
      var22 = (String)var3;
      if (var1 != null) {
         var22 = var1.getEndTime();
      }

      var26.append(var22);
      return var26.toString();
   }

   private final String getUpdatedDefaultNameIfRequired(DeviceSchedule var1, DeviceSchedule var2) {
      String var3 = this.getDefaultScheduleName(var2);
      return Intrinsics.areEqual(var1.getScheduleName(), var3) ? this.getDefaultScheduleName(var1) : var1.getScheduleName();
   }

   private final String to12hFormat(String var1) {
      return DateTimeFormat.forPattern("HH:mm").parseDateTime(var1).toLocalTime().toString("hh:mm a");
   }

   public final Object createSchedule(Device var1, DeviceSchedule var2, Continuation var3) {
      Object var4 = BuildersKt.async$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, var2, this, (Continuation)null) {
         final Device $device;
         final DeviceSchedule $schedule;
         Object L$0;
         int label;
         final DeviceScheduleService this$0;

         {
            this.$device = var1;
            this.$schedule = var2;
            this.this$0 = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, this.$schedule, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               DeviceSchedule var9 = (DeviceSchedule)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Device var4 = this.$device;
               if (var4 instanceof HasBlueCloudFunctions) {
                  var1 = this.$schedule;
                  String var10 = Device$_CC.getTimezone$default(var4, (Context)null, 1, (Object)null).getID();
                  Intrinsics.checkNotNullExpressionValue(var10, "getID(...)");
                  var1 = DeviceSchedule.copy$default(var1, (String)null, (String)null, (String)null, (String)null, (String)null, (List)null, false, (Set)null, var10, (List)null, (String)null, 1791, (Object)null);
               } else {
                  var1 = this.$schedule;
               }

               DeviceManager var11 = this.this$0.deviceManager;
               Device var6 = this.$device;
               Continuation var5 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var1);
               this.label = 1;
               if (var11.createSchedule(var6, var1, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null).await(var3);
      return var4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var4 : Unit.INSTANCE;
   }

   public final Object deleteMergedSchedule(Device var1, DeviceScheduleMerged var2, Continuation var3) {
      Timber.Forest.d("deleteMergedSchedule: start", new Object[0]);
      Object var4 = BuildersKt.async$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var2, this, var1, (Continuation)null) {
         final Device $device;
         final DeviceScheduleMerged $merged;
         int I$0;
         int I$1;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         Object L$5;
         Object L$6;
         int label;
         final DeviceScheduleService this$0;

         {
            this.$merged = var1;
            this.this$0 = var2;
            this.$device = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$merged, this.this$0, this.$device, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            DeviceScheduleService var5;
            Iterator var6;
            Iterable var7;
            List var13;
            Device var17;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var2 = this.I$0;
                  String var4 = (String)this.L$6;
                  var6 = (Iterator)this.L$4;
                  var17 = (Device)this.L$3;
                  var5 = (DeviceScheduleService)this.L$2;
                  var7 = (Iterable)this.L$1;
                  List var8 = (List)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  var13 = var8;
               } else {
                  int var3 = this.I$1;
                  var2 = this.I$0;
                  String var9 = (String)this.L$6;
                  Object var10 = this.L$5;
                  Iterator var28 = (Iterator)this.L$4;
                  Device var22 = (Device)this.L$3;
                  DeviceScheduleService var25 = (DeviceScheduleService)this.L$2;
                  Iterable var18 = (Iterable)this.L$1;
                  List var30 = (List)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  var13 = var30;
                  DeviceScheduleRepository var31 = var25.deviceScheduleRepository;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var13);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var18);
                  this.L$2 = var25;
                  this.L$3 = var22;
                  this.L$4 = var28;
                  this.L$5 = SpillingKt.nullOutSpilledVariable(var10);
                  this.L$6 = SpillingKt.nullOutSpilledVariable(var9);
                  this.I$0 = var2;
                  this.I$1 = var3;
                  this.label = 2;
                  if (var31.delete(var9, this) == var12) {
                     return var12;
                  }

                  DeviceScheduleService var36 = var25;
                  Device var26 = var22;
                  Iterable var32 = var18;
                  var5 = var36;
                  var17 = var26;
                  var6 = var28;
                  var7 = var32;
               }
            } else {
               ResultKt.throwOnFailure(var1);
               Iterable var19 = (Iterable)this.$merged.getSchedule();
               Collection var14 = (Collection)(new ArrayList());
               Iterator var23 = var19.iterator();

               while(var23.hasNext()) {
                  String var20 = ((DeviceSchedule)var23.next()).getScheduleId();
                  if (var20 != null) {
                     var14.add(var20);
                  }
               }

               var13 = (List)var14;
               var7 = (Iterable)var13;
               var5 = this.this$0;
               var17 = this.$device;
               var6 = var7.iterator();
               var2 = 0;
            }

            while(true) {
               if (!var6.hasNext()) {
                  Timber.Forest.d("deleteMergedSchedule: done", new Object[0]);
                  return Unit.INSTANCE;
               }

               Object var38 = var6.next();
               String var11 = (String)var38;
               DeviceManager var33 = var5.deviceManager;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var13);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var7);
               this.L$2 = var5;
               this.L$3 = var17;
               this.L$4 = var6;
               this.L$5 = SpillingKt.nullOutSpilledVariable(var38);
               this.L$6 = var11;
               this.I$0 = var2;
               this.I$1 = 0;
               this.label = 1;
               if (var33.deleteSchedule(var17, var11, this) == var12) {
                  break;
               }

               DeviceScheduleService var37 = var5;
               byte var16 = 0;
               Device var24 = var17;
               Iterable var21 = var7;
               Iterator var29 = var6;
               DeviceScheduleRepository var34 = var37.deviceScheduleRepository;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var13);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var21);
               this.L$2 = var37;
               this.L$3 = var24;
               this.L$4 = var6;
               this.L$5 = SpillingKt.nullOutSpilledVariable(var38);
               this.L$6 = SpillingKt.nullOutSpilledVariable(var11);
               this.I$0 = var2;
               this.I$1 = var16;
               this.label = 2;
               if (var34.delete(var11, this) == var12) {
                  break;
               }

               Device var27 = var24;
               Iterable var35 = var21;
               var5 = var37;
               var17 = var27;
               var6 = var29;
               var7 = var35;
            }

            return var12;
         }
      }, 3, (Object)null).await(var3);
      return var4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var4 : Unit.INSTANCE;
   }

   public final Object downloadSchedulesForDevice(String var1, Continuation var2) {
      label41: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label41;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final DeviceScheduleService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.downloadSchedulesForDevice((String)null, (Continuation)this);
            }
         };
      }

      DeviceManager var13;
      label44: {
         var13 = (DeviceManager)((<undefinedtype>)var11).result;
         Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var11).label;
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var3 = ((<undefinedtype>)var11).I$0;
               Device var7 = (Device)((<undefinedtype>)var11).L$1;
               String var8 = (String)((<undefinedtype>)var11).L$0;
               ResultKt.throwOnFailure(var13);
               break label44;
            }

            var1 = (String)((<undefinedtype>)var11).L$0;
            ResultKt.throwOnFailure(var13);
         } else {
            ResultKt.throwOnFailure(var13);
            Timber.Forest var14 = Timber.Forest;
            StringBuilder var5 = new StringBuilder("downloadSchedulesForDevice: deviceId = ");
            var5.append(var1);
            var14.d(var5.toString(), new Object[0]);
            DeviceManager var15 = this.deviceManager;
            ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
            ((<undefinedtype>)var11).label = 1;
            Object var17 = var15.getDatabaseDevice(var1, (Continuation)var11);
            var13 = (DeviceManager)var17;
            if (var17 == var6) {
               return var6;
            }
         }

         Device var18 = (Device)var13;
         if (var18 == null) {
            return Unit.INSTANCE;
         }

         var13 = this.deviceManager;
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var11).I$0 = 0;
         ((<undefinedtype>)var11).label = 2;
         Object var9 = var13.getSchedules(var18, (Continuation)var11);
         var13 = (DeviceManager)var9;
         if (var9 == var6) {
            return var6;
         }
      }

      List var10 = (List)var13;
      return Unit.INSTANCE;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final Object getSchedulesFor(String var1, boolean var2, Continuation var3) {
      return this.deviceScheduleRepository.getMergedSchedulesFor(var1, var2, var3);
   }

   public final Object updateSchedule(Device var1, DeviceSchedule var2, DeviceScheduleMerged var3, Continuation var4) {
      Object var8;
      label86: {
         if (var4 instanceof <undefinedtype>) {
            var8 = (<undefinedtype>)var4;
            if ((((<undefinedtype>)var8).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var8).label += Integer.MIN_VALUE;
               break label86;
            }
         }

         var8 = new ContinuationImpl(this, var4) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            Object result;
            final DeviceScheduleService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateSchedule((Device)null, (DeviceSchedule)null, (DeviceScheduleMerged)null, (Continuation)this);
            }
         };
      }

      DeviceSchedule var7;
      Object var10;
      label89: {
         label78: {
            Object var9 = ((<undefinedtype>)var8).result;
            var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var5 = ((<undefinedtype>)var8).label;
            DeviceSchedule var22;
            DeviceScheduleMerged var23;
            if (var5 != 0) {
               if (var5 != 1 && var5 != 2) {
                  if (var5 != 3) {
                     if (var5 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     DeviceSchedule var13 = (DeviceSchedule)((<undefinedtype>)var8).L$4;
                     var13 = (DeviceSchedule)((<undefinedtype>)var8).L$3;
                     DeviceScheduleMerged var15 = (DeviceScheduleMerged)((<undefinedtype>)var8).L$2;
                     DeviceSchedule var16 = (DeviceSchedule)((<undefinedtype>)var8).L$1;
                     Device var17 = (Device)((<undefinedtype>)var8).L$0;
                     ResultKt.throwOnFailure(var9);
                     return Unit.INSTANCE;
                  }

                  var7 = (DeviceSchedule)((<undefinedtype>)var8).L$4;
                  var2 = (DeviceSchedule)((<undefinedtype>)var8).L$3;
                  var3 = (DeviceScheduleMerged)((<undefinedtype>)var8).L$2;
                  var24 = (DeviceSchedule)((<undefinedtype>)var8).L$1;
                  var1 = (Device)((<undefinedtype>)var8).L$0;
                  ResultKt.throwOnFailure(var9);
                  break label89;
               }

               var5 = ((<undefinedtype>)var8).I$0;
               DeviceScheduleMerged var11 = (DeviceScheduleMerged)((<undefinedtype>)var8).L$4;
               var2 = (DeviceSchedule)((<undefinedtype>)var8).L$3;
               var23 = (DeviceScheduleMerged)((<undefinedtype>)var8).L$2;
               var22 = (DeviceSchedule)((<undefinedtype>)var8).L$1;
               var1 = (Device)((<undefinedtype>)var8).L$0;
               ResultKt.throwOnFailure(var9);
            } else {
               ResultKt.throwOnFailure(var9);
               if (var3 == null) {
                  var7 = var2;
                  var25 = var1;
                  break label78;
               }

               if (var1 instanceof HasAblCloudFunctions) {
                  ((<undefinedtype>)var8).L$0 = var1;
                  ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                  ((<undefinedtype>)var8).L$2 = var3;
                  ((<undefinedtype>)var8).L$3 = var2;
                  ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var3);
                  ((<undefinedtype>)var8).I$0 = 0;
                  ((<undefinedtype>)var8).label = 1;
                  if (this.deleteMergedSchedule(var1, var3, (Continuation)var8) == var10) {
                     return var10;
                  }
               } else {
                  ((<undefinedtype>)var8).L$0 = var1;
                  ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var2);
                  ((<undefinedtype>)var8).L$2 = var3;
                  ((<undefinedtype>)var8).L$3 = var2;
                  ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var3);
                  ((<undefinedtype>)var8).I$0 = 0;
                  ((<undefinedtype>)var8).label = 2;
                  if (this.deleteMergedScheduleLocally(var3, (Continuation)var8) == var10) {
                     return var10;
                  }
               }

               var23 = var3;
               var22 = var2;
            }

            var7 = var2;
            var2 = var22;
            var3 = var23;
            var25 = var1;
         }

         boolean var6 = var25 instanceof HasBlueCloudFunctions;
         DeviceSchedule var18 = var7;
         if (var6) {
            label63: {
               if (var3 != null) {
                  List var19 = var3.getSchedule();
                  if (var19 != null) {
                     var18 = (DeviceSchedule)CollectionsKt.first(var19);
                     break label63;
                  }
               }

               var18 = null;
            }

            String var30;
            if (var18 != null) {
               var30 = var18.getScheduleId();
            } else {
               var30 = null;
            }

            var18 = DeviceSchedule.copy$default(var7, var30, (String)null, this.getUpdatedDefaultNameIfRequired(var7, var18), (String)null, (String)null, (List)null, false, CollectionsKt.toSet((Iterable)CollectionsKt.sortedWith((Iterable)var7.getDaysOfWeek(), new Comparator() {
               public final int compare(Object var1, Object var2) {
                  return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getCompareValue(), (Comparable)((DayOfWeek)var2).getCompareValue());
               }
            })), (String)null, (List)null, (String)null, 1914, (Object)null);
         }

         Timber.Forest var28 = Timber.Forest;
         StringBuilder var31 = new StringBuilder("updateSchedule: ");
         var31.append(var18);
         var31.append(" editingSchedule = ");
         var31.append(var3);
         var28.d(var31.toString(), new Object[0]);
         if (var6) {
            String var29 = Device$_CC.getTimezone$default(var25, (Context)null, 1, (Object)null).getID();
            Intrinsics.checkNotNullExpressionValue(var29, "getID(...)");
            var7 = DeviceSchedule.copy$default(var18, (String)null, (String)null, (String)null, (String)null, (String)null, (List)null, false, (Set)null, var29, (List)null, (String)null, 1791, (Object)null);
         } else {
            var7 = var18;
         }

         DeviceScheduleRepository var32 = this.deviceScheduleRepository;
         ((<undefinedtype>)var8).L$0 = var25;
         ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var8).L$2 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var8).L$4 = var7;
         ((<undefinedtype>)var8).label = 3;
         if (var32.update(var7, (Continuation)var8) == var10) {
            return var10;
         }

         DeviceSchedule var33 = var18;
         var1 = var25;
         var24 = var2;
         var2 = var33;
      }

      DeviceManager var34 = this.deviceManager;
      ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
      ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var24);
      ((<undefinedtype>)var8).L$2 = SpillingKt.nullOutSpilledVariable(var3);
      ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var2);
      ((<undefinedtype>)var8).L$4 = SpillingKt.nullOutSpilledVariable(var7);
      ((<undefinedtype>)var8).label = 4;
      if (var34.updateSchedule(var1, var7, (Continuation)var8) == var10) {
         return var10;
      } else {
         return Unit.INSTANCE;
      }
   }
}
