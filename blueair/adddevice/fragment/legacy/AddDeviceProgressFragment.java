package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.auth.LocationService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.coroutinehelper.ApiResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutCancellationException;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002JZ\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0082@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006*"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "otaCheckTask", "Ljava/lang/Runnable;", "otaCheckInitTask", "handler", "Landroid/os/Handler;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "tryAddDeviceToBackend", "attempts", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPause", "addDeviceOnBackend", "retryWithBackoff", "T", "times", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(IJJDLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initOTAChecking", "handleOTAUpdateCheck", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class AddDeviceProgressFragment extends AddDeviceBaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceProgressFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final long OTA_CHECK_TIME_DELAY = 5000L;
   private static final long OTA_CHECK_TIME_LIMIT = 25000L;
   private static boolean backendAddingDeviceBusy;
   private Handler handler;
   private final Lazy locationService$delegate;
   private final Runnable otaCheckInitTask = new AddDeviceProgressFragment$$ExternalSyntheticLambda9(this);
   private final Runnable otaCheckTask = new AddDeviceProgressFragment$$ExternalSyntheticLambda8(this);

   // $FF: synthetic method
   public static Unit $r8$lambda$_q7_qQD18PZrce7fPqi6BWjBVoI/* $FF was: $r8$lambda$-q7-qQD18PZrce7fPqi6BWjBVoI*/(AddDeviceProgressFragment var0, AddDeviceState var1) {
      return onResume$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$48n_33WV5LpkmX2s_tBe9nSk92Q/* $FF was: $r8$lambda$48n_33WV5LpkmX2s-tBe9nSk92Q*/(Function1 var0, Object var1) {
      handleOTAUpdateCheck$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$9GcamEaZvkZp5kDAwwa2l0Lurgw(Function1 var0, Object var1) {
      onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$GQM_PN6VysEXX3gxU_MMSiIuHCI/* $FF was: $r8$lambda$GQM-PN6VysEXX3gxU_MMSiIuHCI*/(Function1 var0, Object var1) {
      handleOTAUpdateCheck$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$QFwQQDNUqISJsSX_38mD_s1YpTY(AddDeviceProgressFragment var0, Throwable var1) {
      return handleOTAUpdateCheck$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$joD1jpdCHZyCdpiszBT4kfuNtOQ(AddDeviceProgressFragment var0, Boolean var1) {
      return handleOTAUpdateCheck$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$s5cH2syvjc5A5hyJJt7oXB02p10(Throwable var0) {
      return onResume$lambda$5(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$x_IMNf9FmbNgB7GBnFUK3bQ_hLU(AddDeviceProgressFragment var0) {
      otaCheckInitTask$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zsBQ8FtimtvBJNgcj_DUEog_xN4(Function1 var0, Object var1) {
      onResume$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zyFqCecxPK6EgsxLUsNTFxFKeV4(AddDeviceProgressFragment var0) {
      otaCheckTask$lambda$0(var0);
   }

   public AddDeviceProgressFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, LocationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final void addDeviceOnBackend() {
      AddDeviceState var1 = this.getAddService().getState();
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("addDeviceOnBackend: thread = ");
      var3.append(Thread.currentThread());
      var3.append(", this = ");
      var3.append(this);
      var3.append(", backendAddingDeviceBusy = ");
      var3.append(backendAddingDeviceBusy);
      var3.append(", isReadyForBackendAdding = ");
      var3.append(var1.isReadyForBackendAdding());
      var3.append(", state = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      DeviceInformationLegacy var4 = var1.getDeviceInfo();
      if (!backendAddingDeviceBusy && var1.isReadyForBackendAdding() && var4 != null) {
         Timber.Forest.d("addDeviceOnBackend: addDevice", new Object[0]);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var4, (Continuation)null) {
            final DeviceInformationLegacy $deviceInfo;
            int label;
            final AddDeviceProgressFragment this$0;

            {
               this.this$0 = var1;
               this.$deviceInfo = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceInfo, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3;
               label77: {
                  label76: {
                     Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     var3 = null;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        try {
                           ResultKt.throwOnFailure(var1);
                        } catch (TimeoutCancellationException var9) {
                           boolean var10001 = false;
                           break label76;
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        var1 = AddDeviceProgressFragment.Companion;
                        AddDeviceProgressFragment.backendAddingDeviceBusy = true;

                        Object var23;
                        try {
                           var1 = this.this$0;
                           Function1 var4 = new Function1(this.this$0, this.$deviceInfo, (Continuation)null) {
                              final DeviceInformationLegacy $deviceInfo;
                              int label;
                              final AddDeviceProgressFragment this$0;

                              {
                                 this.this$0 = var1;
                                 this.$deviceInfo = var2;
                              }

                              public final Continuation create(Continuation var1) {
                                 return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceInfo, var1));
                              }

                              public final Object invoke(Continuation var1) {
                                 return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 int var2 = this.label;
                                 if (var2 != 0) {
                                    if (var2 == 1) {
                                       ResultKt.throwOnFailure(var1);
                                       return var1;
                                    } else {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                 } else {
                                    ResultKt.throwOnFailure(var1);
                                    AddDeviceService var5 = this.this$0.getAddService();
                                    var1 = this.$deviceInfo;
                                    Continuation var4 = (Continuation)this;
                                    this.label = 1;
                                    var1 = var5.addDeviceForActiveUser(var1, var4);
                                    return var1 == var3 ? var3 : var1;
                                 }
                              }
                           };
                           var4 = var4;
                           Continuation var6 = (Continuation)this;
                           this.label = 1;
                           var23 = AddDeviceProgressFragment.retryWithBackoff$default(var1, 0, 0L, 0L, (double)0.0F, var4, var6, 15, (Object)null);
                        } catch (TimeoutCancellationException var8) {
                           boolean var26 = false;
                           break label76;
                        }

                        var1 = (AddDeviceProgressFragment)var23;
                        if (var23 == var5) {
                           return var5;
                        }
                     }

                     try {
                        var12 = (ApiResult)var1;
                        break label77;
                     } catch (TimeoutCancellationException var7) {
                        boolean var27 = false;
                     }
                  }

                  var12 = ApiResult.Companion.fail((Throwable)(new TimeoutException("more than 2 minutes have passed ")));
               }

               if (var12.isSuccess()) {
                  Timber.Forest.d("addDevice success", new Object[0]);
                  this.this$0.getAddService().addOnbackendSuccess();
                  Handler var13 = this.this$0.handler;
                  if (var13 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("handler");
                     var13 = (Handler)var3;
                  }

                  var13.post(this.this$0.otaCheckInitTask);
                  Companion var14 = AddDeviceProgressFragment.Companion;
                  AddDeviceProgressFragment.backendAddingDeviceBusy = false;
               } else {
                  Throwable var24 = var12.exceptionOrNull();
                  if (var24 == null) {
                     return Unit.INSTANCE;
                  }

                  label58: {
                     Timber.Forest.e(var24);
                     Context var15 = this.this$0.getContext();
                     if (var15 != null) {
                        Resources var16 = var15.getResources();
                        if (var16 != null) {
                           var17 = var16.getString(R.string.add_device_information_failure);
                           if (var17 != null) {
                              break label58;
                           }
                        }
                     }

                     var17 = "Failed to add device information.";
                  }

                  String var21 = var17;
                  if (var24 instanceof DeviceUtilsLegacy.AddDeviceBackendException) {
                     DeviceUtilsLegacy.AddDeviceBackendException var25 = (DeviceUtilsLegacy.AddDeviceBackendException)var24;
                     var21 = var17;
                     if (((CharSequence)var25.getUiMessage()).length() > 0) {
                        var21 = var25.getUiMessage();
                     }
                  }

                  View var18 = this.this$0.getView();
                  if (this.this$0.isAdded() && var18 != null) {
                     FragmentActivity var19 = this.this$0.getActivity();
                     if (var19 != null) {
                        ViewUtils.INSTANCE.showError((Activity)var19, var21);
                     }
                  }

                  this.this$0.getAddService().addOnBackendFail();
                  Companion var20 = AddDeviceProgressFragment.Companion;
                  AddDeviceProgressFragment.backendAddingDeviceBusy = false;
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final void handleOTAUpdateCheck() {
      Timber.Forest.d("handleOTAUpdateCheck()", new Object[0]);
      this.getAsyncSubs().add(this.getAddService().otaUpdateRunningCheckAsync().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).timeout(25000L, TimeUnit.MILLISECONDS).subscribe(new AddDeviceProgressFragment$$ExternalSyntheticLambda1(new AddDeviceProgressFragment$$ExternalSyntheticLambda0(this)), new AddDeviceProgressFragment$$ExternalSyntheticLambda3(new AddDeviceProgressFragment$$ExternalSyntheticLambda2(this))));
   }

   private static final Unit handleOTAUpdateCheck$lambda$10(AddDeviceProgressFragment var0, Boolean var1) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("handleOTAUpdateCheck : otaUpdateRunningCheckAsync: otaCheckCompleted = ");
      var3.append(var0.getAddService().getState().getOtaCheckCompleted());
      var3.append(", isOTAUpdateRunningAsync: isRunning = ");
      var3.append(var1);
      var3.append(", otaCheckAttempts = ");
      var3.append(var0.getAddService().getState().getOtaCheckAttempt());
      var4.d(var3.toString(), new Object[0]);
      AddDeviceState var7 = var0.getAddService().getState();
      DeviceInformationLegacy var9 = var7.getDeviceInfo();
      if (var9 != null && var1) {
         var0.getAddService().updateDeviceStatusLocalToOtaUpdating(var9.getId());
      }

      boolean var2 = var7.getOtaCheckCompleted();
      Handler var5 = null;
      if (!var2) {
         Handler var8 = var0.handler;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
         } else {
            var5 = var8;
         }

         var5.postDelayed(var0.otaCheckTask, 5000L);
      } else {
         Timber.Forest.d("handleOTAUpdateCheck : otaUpdateRunningCheckAsync: state.otaCheckCompleted == true", new Object[0]);
         DeviceInformationLegacy var6 = var7.getDeviceInfo();
         if (var6 != null) {
            BuildersKt.launch$default(var0, (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, var6, var7, (Continuation)null) {
               final DeviceInformationLegacy $it;
               final AddDeviceState $state;
               Object L$0;
               Object L$1;
               int label;
               final AddDeviceProgressFragment this$0;

               {
                  this.this$0 = var1;
                  this.$it = var2;
                  this.$state = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, this.$state, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  label54: {
                     Function1 var3;
                     Function1 var4;
                     Object var5;
                     label55: {
                        var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              if (var2 != 2) {
                                 if (var2 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 var3 = (Function1)this.L$1;
                                 var3 = (Function1)this.L$0;
                                 ResultKt.throwOnFailure(var1);
                                 break label54;
                              }

                              var3 = (Function1)this.L$1;
                              var4 = (Function1)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              break label55;
                           }

                           var3 = (Function1)this.L$1;
                           var4 = (Function1)this.L$0;
                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           var4 = new Function1(this.this$0, this.$it, (Continuation)null) {
                              final DeviceInformationLegacy $it;
                              int label;
                              final AddDeviceProgressFragment this$0;

                              {
                                 this.this$0 = var1;
                                 this.$it = var2;
                              }

                              public final Continuation create(Continuation var1) {
                                 return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var1));
                              }

                              public final Object invoke(Continuation var1) {
                                 return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 int var2 = this.label;
                                 if (var2 != 0) {
                                    if (var2 == 1) {
                                       ResultKt.throwOnFailure(var1);
                                       return var1;
                                    } else {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                 } else {
                                    ResultKt.throwOnFailure(var1);
                                    var1 = this.this$0.getAddService();
                                    String var4 = this.$it.getId();
                                    Continuation var5 = (Continuation)this;
                                    this.label = 1;
                                    var1 = var1.fetchDeviceStatus(var4, var5);
                                    return var1 == var3 ? var3 : var1;
                                 }
                              }
                           };
                           var3 = new Function1(this.this$0, this.$it, (Continuation)null) {
                              final DeviceInformationLegacy $it;
                              Object L$0;
                              int label;
                              final AddDeviceProgressFragment this$0;

                              {
                                 this.this$0 = var1;
                                 this.$it = var2;
                              }

                              public final Continuation create(Continuation var1) {
                                 return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var1));
                              }

                              public final Object invoke(Continuation var1) {
                                 return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 int var2 = this.label;
                                 Object var4;
                                 DeviceManager var8;
                                 if (var2 != 0) {
                                    if (var2 != 1) {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }

                                    var8 = (DeviceManager)this.L$0;
                                    ResultKt.throwOnFailure(var1);
                                    var4 = var1;
                                 } else {
                                    ResultKt.throwOnFailure(var1);
                                    var1 = this.this$0.getDeviceManager();
                                    var4 = this.this$0.getDeviceManager();
                                    String var5 = this.$it.getId();
                                    Continuation var6 = (Continuation)this;
                                    this.L$0 = var1;
                                    this.label = 1;
                                    var4 = (DeviceManager)var4.isMigrationOtaRunning(var5, var6);
                                    if (var4 == var3) {
                                       return var3;
                                    }

                                    var8 = var1;
                                 }

                                 return Boxing.boxBoolean(var8.isProbablyInMigrationOta((ApiResult)var4));
                              }
                           };
                           var1 = this.this$0;
                           if (!(var1 instanceof AddDeviceAutoConfigProgressFragment) || var1.getLocationService().isInChina()) {
                              return Unit.INSTANCE;
                           }

                           this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                           this.L$1 = var3;
                           this.label = 1;
                           var1 = (AddDeviceProgressFragment)var4.invoke(this);
                           if (var1 == var5) {
                              return var5;
                           }
                        }

                        if ((Boolean)var1) {
                           return Unit.INSTANCE;
                        }

                        this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var3);
                        this.label = 2;
                        var1 = (AddDeviceProgressFragment)var3.invoke(this);
                        if (var1 == var5) {
                           return var5;
                        }
                     }

                     if ((Boolean)var1) {
                        return Unit.INSTANCE;
                     }

                     Timber.Forest.i("Automatic onboarding: device status is not online!", new Object[0]);
                     DeviceManager var7 = this.this$0.getDeviceManager();
                     String var9 = this.$it.getId();
                     Continuation var6 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                     this.L$1 = SpillingKt.nullOutSpilledVariable(var3);
                     this.label = 3;
                     if (var7.removeAblDeviceRemote(var9, var6) == var5) {
                        return var5;
                     }
                  }

                  if (this.$state.getDeviceType() == 3) {
                     this.this$0.getAddService().troubleshoot();
                  } else {
                     this.this$0.getAddService().autoConfigFail();
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void handleOTAUpdateCheck$lambda$11(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit handleOTAUpdateCheck$lambda$12(AddDeviceProgressFragment var0, Throwable var1) {
      Intrinsics.checkNotNullParameter(var1, "t");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("handleOTAUpdateCheck : otaUpdateRunningCheckAsync failed, otaCheckCompleted = ");
      var2.append(var0.getAddService().getState().getOtaCheckCompleted());
      var2.append(' ');
      var2.append(var1);
      var3.e(var2.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void handleOTAUpdateCheck$lambda$13(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final void initOTAChecking() {
      Timber.Forest.d("initOTAChecking()", new Object[0]);
      this.handleOTAUpdateCheck();
   }

   private static final Unit onResume$lambda$3(AddDeviceProgressFragment var0, AddDeviceState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("stateReadyForBackendObserver success, state = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      FragmentActivity var4 = var0.getActivity();
      if (var4 != null) {
         ViewUtils.INSTANCE.showSnackbar((Activity)var4, R.string.adding_device_switching_wifi_message, ViewUtils.MessageType.INFO.INSTANCE);
      }

      BuildersKt.launch$default(var0, (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, (Continuation)null) {
         int label;
         final AddDeviceProgressFragment this$0;

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
               var1 = this.this$0;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (AddDeviceProgressFragment.tryAddDeviceToBackend$default(var1, 0, var4, 1, (Object)null) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$4(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$5(Throwable var0) {
      Timber.Forest.e(var0);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final void otaCheckInitTask$lambda$1(AddDeviceProgressFragment var0) {
      var0.initOTAChecking();
   }

   private static final void otaCheckTask$lambda$0(AddDeviceProgressFragment var0) {
      var0.handleOTAUpdateCheck();
   }

   private final Object retryWithBackoff(int param1, long param2, long param4, double param6, Function1 param8, Continuation param9) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Object retryWithBackoff$default(AddDeviceProgressFragment var0, int var1, long var2, long var4, double var6, Function1 var8, Continuation var9, int var10, Object var11) {
      if (var11 == null) {
         if ((var10 & 1) != 0) {
            var1 = Integer.MAX_VALUE;
         }

         if ((var10 & 2) != 0) {
            var2 = 1000L;
         }

         if ((var10 & 4) != 0) {
            var4 = 1200000L;
         }

         if ((var10 & 8) != 0) {
            var6 = (double)1.5F;
         }

         return var0.retryWithBackoff(var1, var2, var4, var6, var8, var9);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retryWithBackoff");
      }
   }

   private final Object tryAddDeviceToBackend(int var1, Continuation var2) {
      label46: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var7 = var4;
               break label46;
            }
         }

         var7 = new ContinuationImpl(this, var2) {
            int I$0;
            int label;
            Object result;
            final AddDeviceProgressFragment this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.tryAddDeviceToBackend(0, (Continuation)this);
            }
         };
      }

      Object var8 = ((<undefinedtype>)var7).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var7).label;
      if (var3 != 0) {
         if (var3 != 1) {
            if (var3 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var1 = ((<undefinedtype>)var7).I$0;
            ResultKt.throwOnFailure(var8);
            return Unit.INSTANCE;
         }

         var1 = ((<undefinedtype>)var7).I$0;
         ResultKt.throwOnFailure(var8);
      } else {
         ResultKt.throwOnFailure(var8);
         if (var1 > 10) {
            Timber.Forest.w("tryAddDeviceToBackend : 10 attempts made, could not connect to internet.", new Object[0]);
            this.getAddService().addOnBackendFail();
            return Unit.INSTANCE;
         }

         if (NetUtil.INSTANCE.isProbablyOnline(this.getContext())) {
            this.addDeviceOnBackend();
            return Unit.INSTANCE;
         }

         ((<undefinedtype>)var7).I$0 = var1;
         ((<undefinedtype>)var7).label = 1;
         if (DelayKt.delay(2000L, (Continuation)var7) == var5) {
            return var5;
         }
      }

      ((<undefinedtype>)var7).I$0 = var1;
      ((<undefinedtype>)var7).label = 2;
      if (this.tryAddDeviceToBackend(var1 + 1, (Continuation)var7) == var5) {
         return var5;
      } else {
         return Unit.INSTANCE;
      }
   }

   // $FF: synthetic method
   static Object tryAddDeviceToBackend$default(AddDeviceProgressFragment var0, int var1, Continuation var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 1) != 0) {
            var1 = 0;
         }

         return var0.tryAddDeviceToBackend(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAddDeviceToBackend");
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.handler = new Handler();
   }

   public void onPause() {
      Timber.Forest.d("onPause", new Object[0]);
      this.hideLoading();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      AddDeviceBaseFragment var2 = this;
      Handler var1 = null;
      AddDeviceBaseFragment.showLoading$default(var2, false, 1, (Object)null);
      this.getAsyncSubs().add(this.getAddService().getPerformBackendAddObserver().observeOn(AndroidSchedulers.mainThread()).subscribe(new AddDeviceProgressFragment$$ExternalSyntheticLambda5(new AddDeviceProgressFragment$$ExternalSyntheticLambda4(this)), new AddDeviceProgressFragment$$ExternalSyntheticLambda7(new AddDeviceProgressFragment$$ExternalSyntheticLambda6())));
      if (this.getAddService().getState().isReadyForOta()) {
         Timber.Forest.d("onResume() : isReadyForOta", new Object[0]);
         Handler var3 = this.handler;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
         } else {
            var1 = var3;
         }

         var1.post(this.otaCheckInitTask);
      }

      if (!backendAddingDeviceBusy && this.getAddService().getState().isReadyForBackendAdding()) {
         this.addDeviceOnBackend();
      }

   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment$Companion;", "", "<init>", "()V", "OTA_CHECK_TIME_DELAY", "", "OTA_CHECK_TIME_LIMIT", "backendAddingDeviceBusy", "", "adddevice_otherRelease"},
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
   }
}
