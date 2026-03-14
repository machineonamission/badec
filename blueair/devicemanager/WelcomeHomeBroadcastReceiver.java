package com.blueair.devicemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.WelcomeHomeEnterEvent;
import com.blueair.core.model.WelcomeHomeLeaveEvent;
import com.blueair.core.service.AnalyticsService;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.LazyDelegate;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/devicemanager/WelcomeHomeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "setDi", "(Lorg/kodein/di/DI;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "devicemanager_otherRelease", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomeBroadcastReceiver extends BroadcastReceiver implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(WelcomeHomeBroadcastReceiver.class, "deviceManager", "<v#0>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(WelcomeHomeBroadcastReceiver.class, "analyticsService", "<v#1>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(WelcomeHomeBroadcastReceiver.class, "scheduleService", "<v#2>", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public DI di;

   private static final DeviceManager onReceive$lambda$0(Lazy var0) {
      return (DeviceManager)var0.getValue();
   }

   private static final AnalyticsService onReceive$lambda$1(Lazy var0) {
      return (AnalyticsService)var0.getValue();
   }

   private static final DeviceScheduleService onReceive$lambda$2(Lazy var0) {
      return (DeviceScheduleService)var0.getValue();
   }

   public DI getDi() {
      DI var1 = this.di;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("di");
         return null;
      }
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public void onReceive(Context var1, Intent var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "intent");
      GeofencingEvent var13 = GeofencingEvent.fromIntent(var2);
      if (var13 != null) {
         if (var13.hasError()) {
            String var12 = GeofenceStatusCodes.getStatusCodeString(var13.getErrorCode());
            Intrinsics.checkNotNullExpressionValue(var12, "getStatusCodeString(...)");
            Timber.Forest.d(var12, new Object[0]);
            return;
         }

         int var3 = var13.getGeofenceTransition();
         boolean var4;
         if (var3 != 1) {
            if (var3 != 2) {
               return;
            }

            var4 = false;
         } else {
            var4 = true;
         }

         List var14 = var13.getTriggeringGeofences();
         if (var14 != null) {
            var1 = var1.getApplicationContext();
            Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.di.DIAware");
            this.setDi(((DIAware)var1).getDi());
            DIAware var10 = this;
            JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
            }).getSuperType());
            Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            LazyDelegate var15 = DIAwareKt.Instance(var10, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, DeviceManager.class)), (Object)null);
            KProperty[] var6 = $$delegatedProperties;
            Lazy var16 = var15.provideDelegate((Object)null, var6[0]);
            JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
            }).getSuperType());
            Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy var17 = DIAwareKt.Instance(var10, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, AnalyticsService.class)), (Object)null).provideDelegate((Object)null, var6[1]);
            JVMTypeToken var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
            }).getSuperType());
            Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy var11 = DIAwareKt.Instance(var10, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, DeviceScheduleService.class)), (Object)null).provideDelegate((Object)null, var6[2]);
            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var14, var4, var16, var17, var11, (Continuation)null) {
               final Lazy $analyticsService$delegate;
               final Lazy $deviceManager$delegate;
               final boolean $isEnter;
               final Lazy $scheduleService$delegate;
               final List $triggeringGeofenceList;
               int I$0;
               int I$1;
               Object L$0;
               Object L$1;
               Object L$2;
               Object L$3;
               Object L$4;
               Object L$5;
               Object L$6;
               Object L$7;
               boolean Z$0;
               boolean Z$1;
               int label;

               {
                  this.$triggeringGeofenceList = var1;
                  this.$isEnter = var2;
                  this.$deviceManager$delegate = var3;
                  this.$analyticsService$delegate = var4;
                  this.$scheduleService$delegate = var5;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$triggeringGeofenceList, this.$isEnter, this.$deviceManager$delegate, this.$analyticsService$delegate, this.$scheduleService$delegate, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  boolean var3;
                  Lazy var7;
                  Lazy var8;
                  Iterator var9;
                  Iterable var18;
                  Lazy var21;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var2 = this.I$0;
                     boolean var4 = this.Z$0;
                     String var6 = (String)this.L$7;
                     Geofence var20 = (Geofence)this.L$6;
                     var9 = (Iterator)this.L$4;
                     var8 = (Lazy)this.L$3;
                     var7 = (Lazy)this.L$2;
                     var21 = (Lazy)this.L$1;
                     Iterable var10 = (Iterable)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     var18 = var10;
                     var3 = var4;
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var18 = (Iterable)this.$triggeringGeofenceList;
                     var3 = this.$isEnter;
                     var21 = this.$deviceManager$delegate;
                     var7 = this.$analyticsService$delegate;
                     var8 = this.$scheduleService$delegate;
                     var9 = var18.iterator();
                     var2 = 0;
                  }

                  while(var9.hasNext()) {
                     Object var16 = var9.next();
                     Geofence var17 = (Geofence)var16;
                     String var22 = var17.getRequestId();
                     Intrinsics.checkNotNullExpressionValue(var22, "getRequestId(...)");
                     var22 = StringsKt.removeSuffix(var22, (CharSequence)"-min_radius");
                     String var12 = var17.getRequestId();
                     Intrinsics.checkNotNullExpressionValue(var12, "getRequestId(...)");
                     boolean var5 = StringsKt.endsWith$default(var12, "-min_radius", false, 2, (Object)null);
                     Companion var15 = WelcomeHomeBroadcastReceiver.Companion;
                     DeviceManager var13 = WelcomeHomeBroadcastReceiver.onReceive$lambda$0(var21);
                     AnalyticsService var14 = WelcomeHomeBroadcastReceiver.onReceive$lambda$1(var7);
                     DeviceScheduleService var24 = WelcomeHomeBroadcastReceiver.onReceive$lambda$2(var8);
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var18);
                     this.L$1 = var21;
                     this.L$2 = var7;
                     this.L$3 = var8;
                     this.L$4 = var9;
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var16);
                     this.L$6 = SpillingKt.nullOutSpilledVariable(var17);
                     this.L$7 = SpillingKt.nullOutSpilledVariable(var22);
                     this.Z$0 = var3;
                     this.I$0 = var2;
                     this.I$1 = 0;
                     this.Z$1 = var5;
                     this.label = 1;
                     if (var15.handleWelcomeHome(var13, var14, var24, var22, var5, var3, this) == var11) {
                        return var11;
                     }

                     var3 = var3;
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
            return;
         }
      }

   }

   public void setDi(DI var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.di = var1;
   }

   @Metadata(
      d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J>\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"},
      d2 = {"Lcom/blueair/devicemanager/WelcomeHomeBroadcastReceiver$Companion;", "", "<init>", "()V", "shouldSetNightMode", "", "hoursAndMinutesToday", "Lorg/joda/time/DateTime;", "time", "", "inScheduleTime", "schedules", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "handleWelcomeHome", "", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceId", "isMinRadius", "isEnter", "(Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/core/service/AnalyticsService;Lcom/blueair/devicemanager/DeviceScheduleService;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicemanager_otherRelease"},
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

      private final DateTime hoursAndMinutesToday(String var1) {
         DateTime var2 = DateTime.parse(var1, DateTimeFormat.forPattern("HH:mm"));
         var2 = (new DateTime()).withHourOfDay(var2.getHourOfDay()).withMinuteOfHour(var2.getMinuteOfHour());
         Intrinsics.checkNotNullExpressionValue(var2, "withMinuteOfHour(...)");
         return var2;
      }

      private final boolean inScheduleTime(List var1) {
         DateTime var7 = new DateTime();
         Iterator var8 = ((Iterable)var1).iterator();

         boolean var3;
         while(true) {
            boolean var4 = var8.hasNext();
            var3 = false;
            var16 = null;
            Object var6 = null;
            if (!var4) {
               break;
            }

            Object var5 = var8.next();
            DeviceScheduleMerged var9 = (DeviceScheduleMerged)var5;
            if (!var9.getPaused()) {
               label85: {
                  boolean var2;
                  label76: {
                     Exception var10000;
                     label75: {
                        Iterator var10;
                        try {
                           var10 = ((Iterable)var9.getDaysOfWeek()).iterator();
                        } catch (Exception var14) {
                           var10000 = var14;
                           boolean var10001 = false;
                           break label75;
                        }

                        while(true) {
                           Object var17 = var6;

                           try {
                              if (var10.hasNext()) {
                                 var17 = var10.next();
                                 if (((DayOfWeek)var17).getCompareValue() != var7.getDayOfWeek()) {
                                    continue;
                                 }
                              }
                           } catch (Exception var15) {
                              var10000 = var15;
                              boolean var24 = false;
                              break;
                           }

                           if (var17 != null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           try {
                              var23 = WelcomeHomeBroadcastReceiver.Companion.hoursAndMinutesToday(var9.getStartTime());
                              var21 = WelcomeHomeBroadcastReceiver.Companion.hoursAndMinutesToday(var9.getEndTime());
                           } catch (Exception var13) {
                              var10000 = var13;
                              boolean var25 = false;
                              break;
                           }

                           DateTime var18 = var21;

                           try {
                              if (var23.isAfter((ReadableInstant)var21)) {
                                 var18 = var21.plusDays(1);
                                 Intrinsics.checkNotNullExpressionValue(var18, "plusDays(...)");
                              }
                           } catch (Exception var12) {
                              var10000 = var12;
                              boolean var26 = false;
                              break;
                           }

                           try {
                              Interval var22 = new Interval((ReadableInstant)var23, (ReadableInstant)var18);
                              var4 = var22.contains((ReadableInstant)var7);
                              break label76;
                           } catch (Exception var11) {
                              var10000 = var11;
                              boolean var27 = false;
                              break;
                           }
                        }
                     }

                     Exception var19 = var10000;
                     var19.printStackTrace();
                     break label85;
                  }

                  if (!var2 || !var4) {
                     continue;
                  }
               }

               var16 = var5;
               break;
            }
         }

         if (var16 != null) {
            var3 = true;
         }

         return var3;
      }

      private final boolean shouldSetNightMode() {
         int var3 = (new DateTime()).getHourOfDay();
         boolean var2 = false;
         boolean var1 = var2;
         if (8 <= var3) {
            var1 = var2;
            if (var3 < 21) {
               var1 = true;
            }
         }

         return var1 ^ true;
      }

      public final Object handleWelcomeHome(DeviceManager var1, AnalyticsService var2, DeviceScheduleService var3, String var4, boolean var5, boolean var6, Continuation var7) {
         boolean var9;
         label85: {
            var9 = var5;
            var5 = var6;
            if (var7 instanceof <undefinedtype>) {
               <undefinedtype> var11 = (<undefinedtype>)var7;
               if ((var11.label & Integer.MIN_VALUE) != 0) {
                  var11.label += Integer.MIN_VALUE;
                  var44 = var11;
                  break label85;
               }
            }

            var44 = new ContinuationImpl(this, var7) {
               Object L$0;
               Object L$1;
               Object L$2;
               Object L$3;
               Object L$4;
               boolean Z$0;
               boolean Z$1;
               boolean Z$2;
               int label;
               Object result;
               final Companion this$0;

               {
                  this.this$0 = var1;
               }

               public final Object invokeSuspend(Object var1) {
                  this.result = var1;
                  this.label |= Integer.MIN_VALUE;
                  return this.this$0.handleWelcomeHome((DeviceManager)null, (AnalyticsService)null, (DeviceScheduleService)null, (String)null, false, false, (Continuation)this);
               }
            };
         }

         Object var13;
         DeviceManager var47;
         label88: {
            var47 = (DeviceManager)((<undefinedtype>)var44).result;
            var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var8 = ((<undefinedtype>)var44).label;
            if (var8 != 0) {
               if (var8 != 1) {
                  if (var8 != 2) {
                     if (var8 == 3) {
                        var5 = ((<undefinedtype>)var44).Z$2;
                        var5 = ((<undefinedtype>)var44).Z$1;
                        var5 = ((<undefinedtype>)var44).Z$0;
                        List var25 = (List)((<undefinedtype>)var44).L$4;
                        String var26 = (String)((<undefinedtype>)var44).L$3;
                        DeviceScheduleService var27 = (DeviceScheduleService)((<undefinedtype>)var44).L$2;
                        AnalyticsService var28 = (AnalyticsService)((<undefinedtype>)var44).L$1;
                        DeviceManager var29 = (DeviceManager)((<undefinedtype>)var44).L$0;
                        ResultKt.throwOnFailure(var47);
                        return Unit.INSTANCE;
                     }

                     if (var8 == 4) {
                        var5 = ((<undefinedtype>)var44).Z$2;
                        var5 = ((<undefinedtype>)var44).Z$1;
                        var5 = ((<undefinedtype>)var44).Z$0;
                        List var20 = (List)((<undefinedtype>)var44).L$4;
                        String var21 = (String)((<undefinedtype>)var44).L$3;
                        DeviceScheduleService var22 = (DeviceScheduleService)((<undefinedtype>)var44).L$2;
                        AnalyticsService var23 = (AnalyticsService)((<undefinedtype>)var44).L$1;
                        DeviceManager var24 = (DeviceManager)((<undefinedtype>)var44).L$0;
                        ResultKt.throwOnFailure(var47);
                        return Unit.INSTANCE;
                     }

                     if (var8 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var5 = ((<undefinedtype>)var44).Z$2;
                     var5 = ((<undefinedtype>)var44).Z$1;
                     var5 = ((<undefinedtype>)var44).Z$0;
                     List var15 = (List)((<undefinedtype>)var44).L$4;
                     String var16 = (String)((<undefinedtype>)var44).L$3;
                     DeviceScheduleService var17 = (DeviceScheduleService)((<undefinedtype>)var44).L$2;
                     AnalyticsService var18 = (AnalyticsService)((<undefinedtype>)var44).L$1;
                     DeviceManager var19 = (DeviceManager)((<undefinedtype>)var44).L$0;
                     ResultKt.throwOnFailure(var47);
                     return Unit.INSTANCE;
                  }

                  var9 = ((<undefinedtype>)var44).Z$2;
                  var6 = ((<undefinedtype>)var44).Z$1;
                  var5 = ((<undefinedtype>)var44).Z$0;
                  var30 = (List)((<undefinedtype>)var44).L$4;
                  var4 = (String)((<undefinedtype>)var44).L$3;
                  var3 = (DeviceScheduleService)((<undefinedtype>)var44).L$2;
                  var14 = (AnalyticsService)((<undefinedtype>)var44).L$1;
                  DeviceManager var12 = (DeviceManager)((<undefinedtype>)var44).L$0;
                  ResultKt.throwOnFailure(var47);
                  var47 = var12;
                  break label88;
               }

               var5 = ((<undefinedtype>)var44).Z$1;
               var6 = ((<undefinedtype>)var44).Z$0;
               var4 = (String)((<undefinedtype>)var44).L$3;
               var3 = (DeviceScheduleService)((<undefinedtype>)var44).L$2;
               var2 = (AnalyticsService)((<undefinedtype>)var44).L$1;
               var1 = (DeviceManager)((<undefinedtype>)var44).L$0;
               ResultKt.throwOnFailure(var47);
            } else {
               ResultKt.throwOnFailure(var47);
               Timber.Forest var50 = Timber.Forest;
               StringBuilder var48 = new StringBuilder("handleWelcomeHome(");
               var48.append(var4);
               var48.append(", ");
               var48.append(var9);
               var48.append(", ");
               var48.append(var6);
               var48.append(')');
               var50.d(var48.toString(), new Object[0]);
               ((<undefinedtype>)var44).L$0 = var1;
               ((<undefinedtype>)var44).L$1 = var2;
               ((<undefinedtype>)var44).L$2 = SpillingKt.nullOutSpilledVariable(var3);
               ((<undefinedtype>)var44).L$3 = var4;
               ((<undefinedtype>)var44).Z$0 = var9;
               ((<undefinedtype>)var44).Z$1 = var6;
               ((<undefinedtype>)var44).label = 1;
               var47 = (DeviceManager)var3.getSchedulesFor(var4, false, (Continuation)var44);
               if (var47 == var13) {
                  return var13;
               }

               var6 = var9;
            }

            List var49 = (List)var47;
            var9 = this.inScheduleTime(var49);
            if (var9) {
               return Unit.INSTANCE;
            }

            if (!var5) {
               if (!var6) {
                  var2.amplitudeLog(new WelcomeHomeLeaveEvent(var4));
               }

               ((<undefinedtype>)var44).L$0 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var44).L$1 = SpillingKt.nullOutSpilledVariable(var2);
               ((<undefinedtype>)var44).L$2 = SpillingKt.nullOutSpilledVariable(var3);
               ((<undefinedtype>)var44).L$3 = SpillingKt.nullOutSpilledVariable(var4);
               ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var49);
               ((<undefinedtype>)var44).Z$0 = var6;
               ((<undefinedtype>)var44).Z$1 = var5;
               ((<undefinedtype>)var44).Z$2 = var9;
               ((<undefinedtype>)var44).label = 5;
               if (var1.setStandBy(var4, true, (Continuation)var44) == var13) {
                  return var13;
               }

               return Unit.INSTANCE;
            }

            if (!var6) {
               var2.amplitudeLog(new WelcomeHomeEnterEvent(var4));
            }

            ((<undefinedtype>)var44).L$0 = var1;
            ((<undefinedtype>)var44).L$1 = SpillingKt.nullOutSpilledVariable(var2);
            ((<undefinedtype>)var44).L$2 = SpillingKt.nullOutSpilledVariable(var3);
            ((<undefinedtype>)var44).L$3 = var4;
            ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var49);
            ((<undefinedtype>)var44).Z$0 = var6;
            ((<undefinedtype>)var44).Z$1 = var5;
            ((<undefinedtype>)var44).Z$2 = var9;
            ((<undefinedtype>)var44).label = 2;
            if (var1.setStandBy(var4, false, (Continuation)var44) == var13) {
               return var13;
            }

            boolean var10 = var6;
            var6 = var5;
            AnalyticsService var51 = var2;
            var30 = var49;
            var47 = var1;
            var14 = var51;
            var5 = var10;
         }

         if (this.shouldSetNightMode()) {
            ((<undefinedtype>)var44).L$0 = SpillingKt.nullOutSpilledVariable(var47);
            ((<undefinedtype>)var44).L$1 = SpillingKt.nullOutSpilledVariable(var14);
            ((<undefinedtype>)var44).L$2 = SpillingKt.nullOutSpilledVariable(var3);
            ((<undefinedtype>)var44).L$3 = SpillingKt.nullOutSpilledVariable(var4);
            ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var30);
            ((<undefinedtype>)var44).Z$0 = var5;
            ((<undefinedtype>)var44).Z$1 = var6;
            ((<undefinedtype>)var44).Z$2 = var9;
            ((<undefinedtype>)var44).label = 3;
            if (var47.setNightMode(var4, true, (Continuation)var44) != var13) {
               return Unit.INSTANCE;
            }
         } else {
            ((<undefinedtype>)var44).L$0 = SpillingKt.nullOutSpilledVariable(var47);
            ((<undefinedtype>)var44).L$1 = SpillingKt.nullOutSpilledVariable(var14);
            ((<undefinedtype>)var44).L$2 = SpillingKt.nullOutSpilledVariable(var3);
            ((<undefinedtype>)var44).L$3 = SpillingKt.nullOutSpilledVariable(var4);
            ((<undefinedtype>)var44).L$4 = SpillingKt.nullOutSpilledVariable(var30);
            ((<undefinedtype>)var44).Z$0 = var5;
            ((<undefinedtype>)var44).Z$1 = var6;
            ((<undefinedtype>)var44).Z$2 = var9;
            ((<undefinedtype>)var44).label = 4;
            if (var47.setAutoMode(var4, true, (Continuation)var44) != var13) {
               return Unit.INSTANCE;
            }
         }

         return var13;
      }
   }
}
