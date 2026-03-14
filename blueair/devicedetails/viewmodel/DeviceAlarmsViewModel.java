package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0018\u001a\u00020\u0019J&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\"R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "lvDeviceAlarms", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/blueair/core/model/HasAlarm;", "getLvDeviceAlarms", "()Landroidx/lifecycle/MutableLiveData;", "_networkAvailable", "", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "networkAvailable", "Landroidx/lifecycle/LiveData;", "getNetworkAvailable", "()Landroidx/lifecycle/LiveData;", "refreshDeviceAlarms", "", "updateAlarmSwitch", "hasAlarm", "deviceAlarm", "Lcom/blueair/core/model/DeviceAlarm;", "checked", "(Lcom/blueair/core/model/HasAlarm;Lcom/blueair/core/model/DeviceAlarm;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "alarmToDelete", "(Lcom/blueair/core/model/HasAlarm;Lcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAlarmsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceAlarmsViewModel.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)))};
   private final MutableLiveData _networkAvailable;
   private final MutableLiveData lvDeviceAlarms;
   private final Lazy networkMonitor$delegate;

   public DeviceAlarmsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.lvDeviceAlarms = new MutableLiveData();
      this._networkAvailable = new MutableLiveData();
      DIAware var3 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, NetworkMonitor.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceAlarmsViewModel this$0;

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
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Flow var4 = this.this$0.getNetworkMonitor().getConnectivityStatus();
               FlowCollector var5 = new FlowCollector(this.this$0) {
                  final DeviceAlarmsViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     this.this$0._networkAvailable.postValue(Boxing.boxBoolean(var1));
                     return Unit.INSTANCE;
                  }
               };
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var4.collect(var5, var6) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   public final Object delete(HasAlarm var1, DeviceAlarm var2, Continuation var3) {
      label47: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var14 = var5;
               break label47;
            }
         }

         var14 = new ContinuationImpl(this, var3) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final DeviceAlarmsViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.delete((HasAlarm)null, (DeviceAlarm)null, (Continuation)this);
            }
         };
      }

      Object var6 = ((<undefinedtype>)var14).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var14).label;
      HasAlarm var13;
      DeviceAlarm var17;
      if (var4 != 0) {
         if (var4 != 1) {
            if (var4 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var4 = ((<undefinedtype>)var14).I$0;
            Device var9 = (Device)((<undefinedtype>)var14).L$3;
            HasAlarm var10 = (HasAlarm)((<undefinedtype>)var14).L$2;
            DeviceAlarm var11 = (DeviceAlarm)((<undefinedtype>)var14).L$1;
            HasAlarm var12 = (HasAlarm)((<undefinedtype>)var14).L$0;
            ResultKt.throwOnFailure(var6);
            return Unit.INSTANCE;
         }

         var4 = ((<undefinedtype>)var14).I$0;
         var13 = (HasAlarm)((<undefinedtype>)var14).L$2;
         var17 = (DeviceAlarm)((<undefinedtype>)var14).L$1;
         var1 = (HasAlarm)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var6);
      } else {
         ResultKt.throwOnFailure(var6);
         var4 = var1.getAlarms().indexOf(var2);
         if (var4 == -1) {
            return Unit.INSTANCE;
         }

         DeviceManager var18 = this.getDeviceManager();
         String var19 = var1.getUid();
         ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var14).L$2 = var1;
         ((<undefinedtype>)var14).I$0 = var4;
         ((<undefinedtype>)var14).label = 1;
         var6 = var18.getDatabaseDevice(var19, (Continuation)var14);
         if (var6 == var7) {
            return var7;
         }

         var17 = var2;
         var13 = var1;
      }

      Device var8 = (Device)var6;
      if (var8 instanceof HasAlarm) {
         HasAlarm var20 = (HasAlarm)var8;
         var13 = var20;
         if ((DeviceAlarm)CollectionsKt.getOrNull(var20.getAlarms(), var4) == null) {
            return Unit.INSTANCE;
         }
      }

      DeviceManager var21 = this.getDeviceManager();
      ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
      ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var17);
      ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var13);
      ((<undefinedtype>)var14).L$3 = SpillingKt.nullOutSpilledVariable(var8);
      ((<undefinedtype>)var14).I$0 = var4;
      ((<undefinedtype>)var14).label = 2;
      if (var21.setAlarm(var13, var4 + 1, (DeviceAlarm)null, (Continuation)var14) == var7) {
         return var7;
      } else {
         return Unit.INSTANCE;
      }
   }

   public final MutableLiveData getLvDeviceAlarms() {
      return this.lvDeviceAlarms;
   }

   public final LiveData getNetworkAvailable() {
      return (LiveData)this._networkAvailable;
   }

   public final void refreshDeviceAlarms() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceAlarmsViewModel this$0;

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
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               CoroutineContext var4 = (CoroutineContext)Dispatchers.getIO();
               Function2 var6 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final DeviceAlarmsViewModel this$0;

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
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Iterable var4 = (Iterable)this.this$0.getDeviceManager().getDevices();
                        Collection var2 = (Collection)(new ArrayList());

                        for(Device var5 : var4) {
                           label23: {
                              if (var5 instanceof HasAlarm) {
                                 var6 = (HasAlarm)var5;
                                 if (!((Collection)CollectionsKt.filterNotNull((Iterable)var6.getAlarms())).isEmpty()) {
                                    break label23;
                                 }
                              }

                              var6 = null;
                           }

                           if (var6 != null) {
                              var2.add(var6);
                           }
                        }

                        List var7 = (List)var2;
                        this.this$0.getLvDeviceAlarms().postValue(var7);
                        return Unit.INSTANCE;
                     }
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (BuildersKt.withContext(var4, var6, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Object updateAlarmSwitch(HasAlarm var1, DeviceAlarm var2, boolean var3, Continuation var4) {
      DeviceAlarm var7;
      label49: {
         var7 = var2;
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var18 = (<undefinedtype>)var4;
            if ((var18.label & Integer.MIN_VALUE) != 0) {
               var18.label += Integer.MIN_VALUE;
               var22 = var18;
               break label49;
            }
         }

         var22 = new ContinuationImpl(this, var4) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            boolean Z$0;
            int label;
            Object result;
            final DeviceAlarmsViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateAlarmSwitch((HasAlarm)null, (DeviceAlarm)null, false, (Continuation)this);
            }
         };
      }

      Object var8 = ((<undefinedtype>)var22).result;
      Object var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var22).label;
      HasAlarm var6;
      DeviceAlarm var12;
      HasAlarm var19;
      if (var5 != 0) {
         if (var5 != 1) {
            if (var5 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var5 = ((<undefinedtype>)var22).I$0;
            var3 = ((<undefinedtype>)var22).Z$0;
            var12 = (DeviceAlarm)((<undefinedtype>)var22).L$4;
            Device var14 = (Device)((<undefinedtype>)var22).L$3;
            HasAlarm var15 = (HasAlarm)((<undefinedtype>)var22).L$2;
            DeviceAlarm var16 = (DeviceAlarm)((<undefinedtype>)var22).L$1;
            HasAlarm var17 = (HasAlarm)((<undefinedtype>)var22).L$0;
            ResultKt.throwOnFailure(var8);
            return Unit.INSTANCE;
         }

         var5 = ((<undefinedtype>)var22).I$0;
         var3 = ((<undefinedtype>)var22).Z$0;
         var19 = (HasAlarm)((<undefinedtype>)var22).L$2;
         var12 = (DeviceAlarm)((<undefinedtype>)var22).L$1;
         var6 = (HasAlarm)((<undefinedtype>)var22).L$0;
         ResultKt.throwOnFailure(var8);
      } else {
         ResultKt.throwOnFailure(var8);
         var5 = var1.getAlarms().indexOf(var7);
         if (var5 == -1) {
            return Unit.INSTANCE;
         }

         DeviceManager var20 = this.getDeviceManager();
         String var25 = var1.getUid();
         ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var22).L$1 = var7;
         ((<undefinedtype>)var22).L$2 = var1;
         ((<undefinedtype>)var22).Z$0 = var3;
         ((<undefinedtype>)var22).I$0 = var5;
         ((<undefinedtype>)var22).label = 1;
         var8 = var20.getDatabaseDevice(var25, (Continuation)var22);
         if (var8 == var9) {
            return var9;
         }

         var19 = var1;
         var6 = var1;
         var12 = var7;
      }

      Device var27 = (Device)var8;
      if (var27 instanceof HasAlarm) {
         var19 = (HasAlarm)var27;
         var7 = (DeviceAlarm)CollectionsKt.getOrNull(var19.getAlarms(), var5);
         if (var7 == null) {
            return Unit.INSTANCE;
         }
      } else {
         var7 = var12;
      }

      DeviceManager var10 = this.getDeviceManager();
      DeviceAlarm var11 = DeviceAlarm.copy$default(var7, (String)null, var3, 0, false, 0, 0, 0, 0, 253, (Object)null);
      ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var6);
      ((<undefinedtype>)var22).L$1 = SpillingKt.nullOutSpilledVariable(var12);
      ((<undefinedtype>)var22).L$2 = SpillingKt.nullOutSpilledVariable(var19);
      ((<undefinedtype>)var22).L$3 = SpillingKt.nullOutSpilledVariable(var27);
      ((<undefinedtype>)var22).L$4 = SpillingKt.nullOutSpilledVariable(var7);
      ((<undefinedtype>)var22).Z$0 = var3;
      ((<undefinedtype>)var22).I$0 = var5;
      ((<undefinedtype>)var22).label = 2;
      if (var10.setAlarm(var19, var5 + 1, var11, (Continuation)var22) == var9) {
         return var9;
      } else {
         return Unit.INSTANCE;
      }
   }
}
