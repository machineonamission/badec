package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.DeviceScheduleService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u001fJ\u001e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010&R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deviceScheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getDeviceScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceScheduleService$delegate", "Lkotlin/Lazy;", "schedules", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "getSchedules", "()Landroidx/lifecycle/MutableLiveData;", "listenToDeviceScheduleLiveData", "", "refreshDeviceSchedule", "localOnly", "", "getLatestDevice", "onResult", "Lkotlin/Function1;", "updateScheduleSwitch", "scheduleMerged", "paused", "(Lcom/blueair/core/model/DeviceScheduleMerged;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "scheduleToDelete", "(Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSchedulesViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSchedulesViewModel.class, "deviceScheduleService", "getDeviceScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0)))};
   public Device device;
   private final Lazy deviceScheduleService$delegate;
   private final MutableLiveData schedules;

   public DeviceSchedulesViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceScheduleService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceScheduleService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.schedules = new MutableLiveData();
   }

   private final DeviceScheduleService getDeviceScheduleService() {
      return (DeviceScheduleService)this.deviceScheduleService$delegate.getValue();
   }

   private final void listenToDeviceScheduleLiveData() {
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final DeviceSchedulesViewModel this$0;

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
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  List var4 = (List)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceScheduleService var6 = this.this$0.getDeviceScheduleService();
               String var10 = this.this$0.getDevice().getUid();
               boolean var3 = this.this$0.getDevice() instanceof HasBlueCloudFunctions;
               Continuation var8 = (Continuation)this;
               this.label = 1;
               Object var11 = var6.getSchedulesFor(var10, var3 ^ true, var8);
               var1 = var11;
               if (var11 == var5) {
                  return var5;
               }
            }

            List var7 = (List)var1;
            CoroutineContext var9 = CoroutineScopeKt.MainScope().getCoroutineContext();
            Function2 var13 = new Function2(this.this$0, var7, (Continuation)null) {
               final List $mergedSchedules;
               int label;
               final DeviceSchedulesViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$mergedSchedules = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$mergedSchedules, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.getSchedules().setValue(this.$mergedSchedules);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var12 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
            this.label = 2;
            if (BuildersKt.withContext(var9, var13, var12) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 3, (Object)null);
   }

   public final Object delete(DeviceScheduleMerged var1, Continuation var2) {
      Object var3 = this.getDeviceScheduleService().deleteMergedSchedule(this.getDevice(), var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public final void getLatestDevice(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onResult");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final Function1 $onResult;
         Object L$0;
         int label;
         final DeviceSchedulesViewModel this$0;

         {
            this.this$0 = var1;
            this.$onResult = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$onResult, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            DeviceSchedulesViewModel var3;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               var3 = (DeviceSchedulesViewModel)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var3 = this.this$0;
               var1 = var3.getDeviceManager();
               String var4 = this.this$0.getDevice().getUid();
               Continuation var6 = (Continuation)this;
               this.L$0 = var3;
               this.label = 1;
               Object var11 = var1.getDatabaseDevice(var4, var6);
               var1 = (Device)var11;
               if (var11 == var5) {
                  return var5;
               }
            }

            Device var12 = var1;
            var1 = var12;
            if (var12 == null) {
               var1 = this.this$0.getDevice();
            }

            var3.setDevice(var1);
            CoroutineContext var13 = (CoroutineContext)Dispatchers.getMain();
            Function2 var9 = new Function2(this.$onResult, this.this$0, (Continuation)null) {
               final Function1 $onResult;
               int label;
               final DeviceSchedulesViewModel this$0;

               {
                  this.$onResult = var1;
                  this.this$0 = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$onResult, this.this$0, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.$onResult.invoke(this.this$0.getDevice());
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var10 = (Continuation)this;
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(var13, var9, var10) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final MutableLiveData getSchedules() {
      return this.schedules;
   }

   public final void refreshDeviceSchedule(boolean var1) {
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final boolean $localOnly;
         int label;
         final DeviceSchedulesViewModel this$0;

         {
            this.$localOnly = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$localOnly, this.this$0, var2));
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

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               if (!this.$localOnly) {
                  var1 = this.this$0.getDeviceScheduleService();
                  String var4 = this.this$0.getDevice().getUid();
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (var1.downloadSchedulesForDevice(var4, var5) == var3) {
                     return var3;
                  }
               }
            }

            this.this$0.listenToDeviceScheduleLiveData();
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final Object updateScheduleSwitch(DeviceScheduleMerged var1, boolean var2, Continuation var3) {
      label45: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var14 = var5;
               break label45;
            }
         }

         var14 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            Object L$2;
            boolean Z$0;
            int label;
            Object result;
            final DeviceSchedulesViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateScheduleSwitch((DeviceScheduleMerged)null, false, (Continuation)this);
            }
         };
      }

      Object var7 = ((<undefinedtype>)var14).result;
      Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var14).label;
      DeviceSchedule var9;
      DeviceScheduleMerged var15;
      if (var4 != 0) {
         if (var4 != 1) {
            if (var4 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = ((<undefinedtype>)var14).Z$0;
            Device var10 = (Device)((<undefinedtype>)var14).L$2;
            DeviceSchedule var11 = (DeviceSchedule)((<undefinedtype>)var14).L$1;
            DeviceScheduleMerged var12 = (DeviceScheduleMerged)((<undefinedtype>)var14).L$0;
            ResultKt.throwOnFailure(var7);
            return Unit.INSTANCE;
         }

         var2 = ((<undefinedtype>)var14).Z$0;
         var9 = (DeviceSchedule)((<undefinedtype>)var14).L$1;
         var15 = (DeviceScheduleMerged)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var7);
      } else {
         ResultKt.throwOnFailure(var7);
         if (var1.getSchedule().isEmpty()) {
            return Unit.INSTANCE;
         }

         DeviceSchedule var16 = (DeviceSchedule)CollectionsKt.first(var1.getSchedule());
         DeviceSchedule var6 = DeviceSchedule.copy$default(var16, (String)null, (String)null, (String)null, (String)null, (String)null, (List)null, var2, (Set)null, (String)null, (List)null, (String)null, 1983, (Object)null);
         DeviceManager var17 = this.getDeviceManager();
         String var19 = this.getDevice().getUid();
         ((<undefinedtype>)var14).L$0 = var1;
         ((<undefinedtype>)var14).L$1 = var6;
         ((<undefinedtype>)var14).Z$0 = var2;
         ((<undefinedtype>)var14).label = 1;
         var7 = var17.getDatabaseDevice(var19, (Continuation)var14);
         if (var7 == var8) {
            return var8;
         }

         var15 = var1;
         var9 = var6;
      }

      Device var20 = (Device)var7;
      Device var18 = var20;
      if (var20 == null) {
         var18 = this.getDevice();
      }

      DeviceScheduleService var21 = this.getDeviceScheduleService();
      ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var15);
      ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var9);
      ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var18);
      ((<undefinedtype>)var14).Z$0 = var2;
      ((<undefinedtype>)var14).label = 2;
      if (var21.updateSchedule(var18, var9, var15, (Continuation)var14) == var8) {
         return var8;
      } else {
         return Unit.INSTANCE;
      }
   }
}
