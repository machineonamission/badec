package com.blueair.livestream;

import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.HasBleFunctions;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.util.NetworkMonitor;
import io.flatcircle.ble.BleEvent;
import io.flatcircle.ble.BleService;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.mqtt.MqttEvent;
import io.flatcircle.mqtt.MqttService;
import io.flatcircle.stomp.StompEvent;
import io.flatcircle.stomp.StompService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u0014\u0010*\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"},
   d2 = {"Lcom/blueair/livestream/StreamService;", "Lkotlinx/coroutines/CoroutineScope;", "mqttService", "Lio/flatcircle/mqtt/MqttService;", "stompService", "Lio/flatcircle/stomp/StompService;", "bleService", "Lio/flatcircle/ble/BleService;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "<init>", "(Lio/flatcircle/mqtt/MqttService;Lio/flatcircle/stomp/StompService;Lio/flatcircle/ble/BleService;Lcom/blueair/core/util/NetworkMonitor;)V", "getBleService", "()Lio/flatcircle/ble/BleService;", "_mainObservable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/blueair/livestream/StreamEvent;", "mainObservable", "Lkotlinx/coroutines/flow/SharedFlow;", "getMainObservable", "()Lkotlinx/coroutines/flow/SharedFlow;", "mqttReconnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "getMqttReconnected", "()Lkotlinx/coroutines/flow/StateFlow;", "mqttMutex", "Lkotlinx/coroutines/sync/Mutex;", "setAllListeners", "", "restartStomp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resubscribeMqttRt5s", "deviceId", "", "lastRegisteredDevices", "", "Lcom/blueair/core/model/Device;", "getLastRegisteredDevices", "()Ljava/util/List;", "setLastRegisteredDevices", "(Ljava/util/List;)V", "registerDevices", "devices", "unregisterBleDevice", "uuid", "clear", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "livestream_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StreamService implements CoroutineScope {
   private final DefaultCoroutineScope $$delegate_0;
   private final MutableSharedFlow _mainObservable;
   private final BleService bleService;
   private List lastRegisteredDevices;
   private final SharedFlow mainObservable;
   private final Mutex mqttMutex;
   private final StateFlow mqttReconnected;
   private final MqttService mqttService;
   private final StompService stompService;

   public StreamService(MqttService var1, StompService var2, BleService var3, NetworkMonitor var4) {
      Intrinsics.checkNotNullParameter(var1, "mqttService");
      Intrinsics.checkNotNullParameter(var2, "stompService");
      Intrinsics.checkNotNullParameter(var3, "bleService");
      Intrinsics.checkNotNullParameter(var4, "networkMonitor");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.mqttService = var1;
      this.stompService = var2;
      this.bleService = var3;
      MutableSharedFlow var5 = SharedFlowKt.MutableSharedFlow$default(0, 64, (BufferOverflow)null, 5, (Object)null);
      this._mainObservable = var5;
      this.mainObservable = (SharedFlow)var5;
      this.mqttReconnected = var1.getMqttReconnected();
      this.mqttMutex = MutexKt.Mutex$default(false, 1, (Object)null);
      this.setAllListeners();
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(var4, this, (Continuation)null) {
         final NetworkMonitor $networkMonitor;
         int label;
         final StreamService this$0;

         {
            this.$networkMonitor = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$networkMonitor, this.this$0, var2));
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
               Flow var4 = this.$networkMonitor.getConnectivityStatus();
               FlowCollector var5 = new FlowCollector(this.this$0) {
                  final StreamService this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     label77: {
                        if (var2 instanceof <undefinedtype>) {
                           <undefinedtype> var4 = (<undefinedtype>)var2;
                           if ((var4.label & Integer.MIN_VALUE) != 0) {
                              var4.label += Integer.MIN_VALUE;
                              var12 = var4;
                              break label77;
                           }
                        }

                        var12 = new ContinuationImpl(this, var2) {
                           int I$0;
                           Object L$0;
                           Object L$1;
                           boolean Z$0;
                           int label;
                           Object result;
                           final <undefinedtype> this$0;

                           {
                              this.this$0 = var1;
                           }

                           public final Object invokeSuspend(Object var1) {
                              this.result = var1;
                              this.label |= Integer.MIN_VALUE;
                              return this.this$0.emit(false, (Continuation)this);
                           }
                        };
                     }

                     Object var5 = ((<undefinedtype>)var12).result;
                     Object var15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var3 = ((<undefinedtype>)var12).label;
                     if (var3 != 0) {
                        if (var3 != 1) {
                           if (var3 == 2) {
                              var3 = ((<undefinedtype>)var12).I$0;
                              var1 = ((<undefinedtype>)var12).Z$0;
                              List var16 = (List)((<undefinedtype>)var12).L$1;
                              List var13 = (List)((<undefinedtype>)var12).L$0;
                              ResultKt.throwOnFailure(var5);
                              return Unit.INSTANCE;
                           }

                           if (var3 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var1 = ((<undefinedtype>)var12).Z$0;
                           ResultKt.throwOnFailure(var5);
                           return Unit.INSTANCE;
                        }

                        var1 = ((<undefinedtype>)var12).Z$0;
                        ResultKt.throwOnFailure(var5);
                     } else {
                        ResultKt.throwOnFailure(var5);
                        if (!var1) {
                           StompService var19 = this.this$0.stompService;
                           ((<undefinedtype>)var12).Z$0 = var1;
                           ((<undefinedtype>)var12).label = 3;
                           if (var19.goOffline((Continuation)var12) == var15) {
                              return var15;
                           }

                           return Unit.INSTANCE;
                        }

                        StompService var17 = this.this$0.stompService;
                        ((<undefinedtype>)var12).Z$0 = var1;
                        ((<undefinedtype>)var12).label = 1;
                        if (var17.goOnline((Continuation)var12) == var15) {
                           return var15;
                        }
                     }

                     List var18 = this.this$0.getLastRegisteredDevices();
                     if (var18 == null) {
                        return Unit.INSTANCE;
                     } else {
                        StreamService var6 = this.this$0;
                        Iterable var8 = (Iterable)var18;
                        Collection var7 = (Collection)(new ArrayList());

                        for(Object var9 : var8) {
                           if (var9 instanceof HasAblCloudFunctions) {
                              var7.add(var9);
                           }
                        }

                        var8 = (Iterable)((List)var7);
                        var7 = (Collection)(new ArrayList());

                        for(Object var25 : var8) {
                           if (((HasAblCloudFunctions)var25).getTypeIndex() != DeviceType.Icp.INSTANCE.getIndex()) {
                              var7.add(var25);
                           }
                        }

                        List var22 = (List)var7;
                        if (((Collection)var22).isEmpty()) {
                           return Unit.INSTANCE;
                        } else {
                           StompService var20 = var6.stompService;
                           ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var18);
                           ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var22);
                           ((<undefinedtype>)var12).Z$0 = var1;
                           ((<undefinedtype>)var12).I$0 = 0;
                           ((<undefinedtype>)var12).label = 2;
                           if (var20.registerDevices(var22, (Continuation)var12) != var15) {
                              return Unit.INSTANCE;
                           } else {
                              return var15;
                           }
                        }
                     }
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

   private final void setAllListeners() {
      CoroutineScope var1 = this;
      BuildersKt.launch$default(var1, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final StreamService this$0;

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
               Flow var5 = FlowKt.distinctUntilChanged((Flow)this.this$0.mqttService.getEventObservable());
               FlowCollector var6 = new FlowCollector(this.this$0) {
                  final StreamService this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(MqttEvent var1, Continuation var2) {
                     label28: {
                        if (var2 instanceof <undefinedtype>) {
                           <undefinedtype> var4 = (<undefinedtype>)var2;
                           if ((var4.label & Integer.MIN_VALUE) != 0) {
                              var4.label += Integer.MIN_VALUE;
                              var14 = var4;
                              break label28;
                           }
                        }

                        var14 = new ContinuationImpl(this, var2) {
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
                           final <undefinedtype> this$0;

                           {
                              this.this$0 = var1;
                           }

                           public final Object invokeSuspend(Object var1) {
                              this.result = var1;
                              this.label |= Integer.MIN_VALUE;
                              return this.this$0.emit((MqttEvent)null, (Continuation)this);
                           }
                        };
                     }

                     Object var7 = ((<undefinedtype>)var14).result;
                     Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var3 = ((<undefinedtype>)var14).label;
                     MqttEvent var5;
                     Iterable var6;
                     StreamService var13;
                     Iterator var17;
                     if (var3 != 0) {
                        if (var3 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var3 = ((<undefinedtype>)var14).I$1;
                        var3 = ((<undefinedtype>)var14).I$0;
                        StreamEvent var11 = (StreamEvent)((<undefinedtype>)var14).L$5;
                        var11 = (StreamEvent)((<undefinedtype>)var14).L$4;
                        var17 = (Iterator)((<undefinedtype>)var14).L$3;
                        var13 = (StreamService)((<undefinedtype>)var14).L$2;
                        var6 = (Iterable)((<undefinedtype>)var14).L$1;
                        var5 = (MqttEvent)((<undefinedtype>)var14).L$0;
                        ResultKt.throwOnFailure(var7);
                     } else {
                        ResultKt.throwOnFailure(var7);
                        Timber.Forest var18 = Timber.Forest;
                        StringBuilder var19 = new StringBuilder("MQTT Payload received with details, ");
                        var19.append(var1);
                        var18.d(var19.toString(), new Object[0]);
                        var6 = (Iterable)StreamEvent.Companion.fromMqtt(var1);
                        StreamService var20 = this.this$0;
                        var17 = var6.iterator();
                        var3 = 0;
                        var5 = var1;
                        var13 = var20;
                     }

                     while(var17.hasNext()) {
                        var7 = var17.next();
                        StreamEvent var9 = (StreamEvent)var7;
                        MutableSharedFlow var10 = var13._mainObservable;
                        ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var5);
                        ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var6);
                        ((<undefinedtype>)var14).L$2 = var13;
                        ((<undefinedtype>)var14).L$3 = var17;
                        ((<undefinedtype>)var14).L$4 = SpillingKt.nullOutSpilledVariable(var7);
                        ((<undefinedtype>)var14).L$5 = SpillingKt.nullOutSpilledVariable(var9);
                        ((<undefinedtype>)var14).I$0 = var3;
                        ((<undefinedtype>)var14).I$1 = 0;
                        ((<undefinedtype>)var14).label = 1;
                        if (var10.emit(var9, (Continuation)var14) == var8) {
                           return var8;
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.collect(var6, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      BuildersKt.launch$default(var1, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final StreamService this$0;

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
               Flow var4 = FlowKt.distinctUntilChanged((Flow)this.this$0.stompService.getEventObservable());
               FlowCollector var6 = new FlowCollector(this.this$0) {
                  final StreamService this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(StompEvent var1, Continuation var2) {
                     Timber.Forest var4 = Timber.Forest;
                     StringBuilder var3 = new StringBuilder("STOMP Payload received with details, ");
                     var3.append(var1);
                     var4.d(var3.toString(), new Object[0]);
                     Object var5 = this.this$0._mainObservable.emit(StreamEvent.Companion.fromStomp(var1), var2);
                     return var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var5 : Unit.INSTANCE;
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.collect(var6, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      BuildersKt.launch$default(var1, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final StreamService this$0;

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
               Flow var5 = FlowKt.distinctUntilChanged((Flow)this.this$0.getBleService().getEventObservable());
               FlowCollector var4 = new FlowCollector(this.this$0) {
                  final StreamService this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(BleEvent var1, Continuation var2) {
                     Timber.Forest var4 = Timber.Forest;
                     StringBuilder var3 = new StringBuilder("BLE Payload received with details, ");
                     var3.append(var1);
                     var4.d(var3.toString(), new Object[0]);
                     Object var5 = this.this$0._mainObservable.emit(StreamEvent.Companion.fromBle(var1), var2);
                     return var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var5 : Unit.INSTANCE;
                  }
               };
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var5.collect(var4, var6) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Object clear(Continuation var1) {
      this.lastRegisteredDevices = CollectionsKt.emptyList();
      this.mqttService.clear();
      Object var2 = this.stompService.clear(var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final BleService getBleService() {
      return this.bleService;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final List getLastRegisteredDevices() {
      return this.lastRegisteredDevices;
   }

   public final SharedFlow getMainObservable() {
      return this.mainObservable;
   }

   public final StateFlow getMqttReconnected() {
      return this.mqttReconnected;
   }

   public final void registerDevices(List var1) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Registering devices for StreamService, devices = ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      this.lastRegisteredDevices = var1;
      CoroutineScope var4 = this;
      BuildersKt.launch$default(var4, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final List $devices;
         int I$0;
         Object L$0;
         Object L$1;
         Object L$2;
         int label;
         final StreamService this$0;

         {
            this.this$0 = var1;
            this.$devices = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$devices, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            StreamService var3;
            List var4;
            Mutex var27;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var3 = (StreamService)this.L$2;
               var4 = (List)this.L$1;
               Mutex var33 = (Mutex)this.L$0;
               ResultKt.throwOnFailure(var1);
               var27 = var33;
            } else {
               ResultKt.throwOnFailure(var1);
               var27 = this.this$0.mqttMutex;
               var4 = this.$devices;
               var3 = this.this$0;
               Continuation var6 = (Continuation)this;
               this.L$0 = var27;
               this.L$1 = var4;
               this.L$2 = var3;
               this.I$0 = 0;
               this.label = 1;
               if (var27.lock((Object)null, var6) == var5) {
                  return var5;
               }
            }

            label285: {
               Throwable var10000;
               label284: {
                  Iterator var36;
                  try {
                     Iterable var34 = (Iterable)var4;
                     ArrayList var30 = new ArrayList();
                     var31 = (Collection)var30;
                     var36 = var34.iterator();
                  } catch (Throwable var25) {
                     var10000 = var25;
                     boolean var10001 = false;
                     break label284;
                  }

                  while(true) {
                     try {
                        while(var36.hasNext()) {
                           var5 = var36.next();
                           if (var5 instanceof HasBlueCloudFunctions) {
                              var31.add(var5);
                           }
                        }
                     } catch (Throwable var26) {
                        var10000 = var26;
                        boolean var37 = false;
                        break;
                     }

                     try {
                        var4 = (List)var31;
                        if (!((Collection)var4).isEmpty()) {
                           var3.mqttService.registerDevices(var4);
                        }
                     } catch (Throwable var24) {
                        var10000 = var24;
                        boolean var38 = false;
                        break;
                     }

                     try {
                        Unit var29 = Unit.INSTANCE;
                        break label285;
                     } catch (Throwable var23) {
                        var10000 = var23;
                        boolean var39 = false;
                        break;
                     }
                  }
               }

               Throwable var28 = var10000;
               var27.unlock((Object)null);
               throw var28;
            }

            var27.unlock((Object)null);
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      BuildersKt.launch$default(var4, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final List $devices;
         Object L$0;
         int label;
         final StreamService this$0;

         {
            this.$devices = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$devices, this.this$0, var2));
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

               List var9 = (List)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Iterable var4 = (Iterable)this.$devices;
               Collection var6 = (Collection)(new ArrayList());

               for(Object var10 : var4) {
                  if (var10 instanceof HasAblCloudFunctions) {
                     var6.add(var10);
                  }
               }

               var4 = (Iterable)((List)var6);
               var6 = (Collection)(new ArrayList());

               for(Object var12 : var4) {
                  if (((HasAblCloudFunctions)var12).getTypeIndex() != DeviceType.Icp.INSTANCE.getIndex()) {
                     var6.add(var12);
                  }
               }

               List var8 = (List)var6;
               if (!((Collection)var8).isEmpty()) {
                  StompService var13 = this.this$0.stompService;
                  Continuation var15 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var8);
                  this.label = 1;
                  if (var13.registerDevices(var8, var15) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      BuildersKt.launch$default(var4, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final List $devices;
         int label;
         final StreamService this$0;

         {
            this.$devices = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$devices, this.this$0, var2));
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
               Iterable var2 = (Iterable)this.$devices;
               Collection var4 = (Collection)(new ArrayList());

               for(Object var7 : var2) {
                  if (var7 instanceof HasBleFunctions) {
                     var4.add(var7);
                  }
               }

               List var5 = (List)var4;
               if (!((Collection)var5).isEmpty()) {
                  for(HasBleFunctions var8 : var5) {
                     this.this$0.getBleService().register(var8.getUid(), var8.getMac());
                  }

                  this.this$0.getBleService().onResume();
               }

               return Unit.INSTANCE;
            }
         }
      }, 3, (Object)null);
   }

   public final Object restartStomp(Continuation var1) {
      Object var2 = this.stompService.restart(var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final void resubscribeMqttRt5s(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      this.mqttService.resubscribeRt5s(var1);
   }

   public final void setLastRegisteredDevices(List var1) {
      this.lastRegisteredDevices = var1;
   }

   public final void unregisterBleDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      this.bleService.unregister(var1);
   }
}
