package com.blueair.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build.VERSION;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.UserInfoItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003*\u0001\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u0018"},
   d2 = {"Lcom/blueair/core/util/NetworkMonitor;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connManager", "Landroid/net/ConnectivityManager;", "_connectivityStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "connectivityStatus", "Lkotlinx/coroutines/flow/Flow;", "getConnectivityStatus", "()Lkotlinx/coroutines/flow/Flow;", "currentConnectivityStatus", "getCurrentConnectivityStatus", "()Z", "_wifiStatus", "wifiStatus", "getWifiStatus", "networkCallback", "com/blueair/core/util/NetworkMonitor$networkCallback$1", "Lcom/blueair/core/util/NetworkMonitor$networkCallback$1;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NetworkMonitor {
   private final MutableStateFlow _connectivityStatus;
   private final MutableStateFlow _wifiStatus;
   private final ConnectivityManager connManager;
   private final <undefinedtype> networkCallback;

   public NetworkMonitor(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "appContext");
      super();
      Object var3 = var1.getSystemService("connectivity");
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.net.ConnectivityManager");
      ConnectivityManager var4 = (ConnectivityManager)var3;
      this.connManager = var4;
      Boolean var2 = false;
      this._connectivityStatus = StateFlowKt.MutableStateFlow(var2);
      this._wifiStatus = StateFlowKt.MutableStateFlow(var2);
      ConnectivityManager.NetworkCallback var5 = new ConnectivityManager.NetworkCallback(this) {
         final NetworkMonitor this$0;

         {
            this.this$0 = var1;
         }

         public void onAvailable(Network var1) {
            Intrinsics.checkNotNullParameter(var1, "network");
            this.this$0._connectivityStatus.tryEmit(true);
         }

         public void onLost(Network var1) {
            Intrinsics.checkNotNullParameter(var1, "network");
            this.this$0._connectivityStatus.tryEmit(false);
         }
      };
      this.networkCallback = var5;
      if (VERSION.SDK_INT >= 24) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var4, var5);
      } else {
         var4.registerNetworkCallback((new NetworkRequest.Builder()).addCapability(12).build(), var5);
      }

      var4.registerNetworkCallback((new NetworkRequest.Builder()).addTransportType(1).build(), new ConnectivityManager.NetworkCallback(this) {
         final NetworkMonitor this$0;

         {
            this.this$0 = var1;
         }

         public void onAvailable(Network var1) {
            Intrinsics.checkNotNullParameter(var1, "network");
            this.this$0._wifiStatus.tryEmit(true);
         }

         public void onLost(Network var1) {
            Intrinsics.checkNotNullParameter(var1, "network");
            this.this$0._wifiStatus.tryEmit(false);
         }
      });
   }

   public final Flow getConnectivityStatus() {
      return FlowKt.onEach(new Flow(new Flow(FlowKt.withIndex((Flow)this._connectivityStatus)) {
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
                           var11 = var4;
                           break label30;
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
                     IndexedValue var15 = (IndexedValue)var1;
                     if (var15.getIndex() != 0 || !(Boolean)var15.getValue()) {
                        ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                        ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                        ((<undefinedtype>)var11).I$0 = 0;
                        ((<undefinedtype>)var11).label = 1;
                        if (var14.emit(var1, (Continuation)var11) == var5) {
                           return var5;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }) {
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
                     Object var15 = ((IndexedValue)var1).getValue();
                     ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                     ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var11).I$0 = 0;
                     ((<undefinedtype>)var11).label = 1;
                     if (var14.emit(var15, (Continuation)var11) == var5) {
                        return var5;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, new Function2((Continuation)null) {
         boolean Z$0;
         int label;

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(var2);
            var3.Z$0 = (Boolean)var1;
            return (Continuation)var3;
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var2 = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               Timber.Forest var4 = Timber.Forest;
               StringBuilder var3 = new StringBuilder("Connectivity status: ");
               var3.append(var2);
               var4.i(var3.toString(), new Object[0]);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
   }

   public final boolean getCurrentConnectivityStatus() {
      return (Boolean)this._connectivityStatus.getValue();
   }

   public final Flow getWifiStatus() {
      return FlowKt.onEach(FlowKt.debounce((Flow)this._wifiStatus, 250L), new Function2((Continuation)null) {
         boolean Z$0;
         int label;

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(var2);
            var3.Z$0 = (Boolean)var1;
            return (Continuation)var3;
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var2 = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               Timber.Forest var3 = Timber.Forest;
               StringBuilder var4 = new StringBuilder("Wifi status: ");
               var4.append(var2);
               var3.i(var4.toString(), new Object[0]);
               UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.PHONE_WIFI_STATE, String.valueOf(var2), false, 4, (Object)null);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
   }
}
