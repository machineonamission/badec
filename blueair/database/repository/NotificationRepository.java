package com.blueair.database.repository;

import com.blueair.core.model.Device;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.model.NotificationMsgType;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.dao.NotificationDao;
import com.blueair.database.entity.NotificationEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006#"},
   d2 = {"Lcom/blueair/database/repository/NotificationRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "deviceRepository", "Lcom/blueair/database/repository/DeviceRepository;", "<init>", "(Lcom/blueair/database/BlueairDatabase;Lcom/blueair/database/repository/DeviceRepository;)V", "flowNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/blueair/core/model/NotificationMessage;", "getFlowNotifications", "()Lkotlinx/coroutines/flow/Flow;", "flowNotifications$delegate", "Lkotlin/Lazy;", "getNotification", "Lcom/blueair/database/entity/NotificationEntity;", "deviceId", "", "type", "subType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "", "dismissAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "deleteNotification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entity", "(Lcom/blueair/database/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "insertNotification", "revokeDismission", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationRepository {
   private final BlueairDatabase blueairDb;
   private final DeviceRepository deviceRepository;
   private final Lazy flowNotifications$delegate;

   // $FF: synthetic method
   public static Flow $r8$lambda$ToJ2BycwRYELVt0PrMIr1n8N4ow(NotificationRepository var0) {
      return flowNotifications_delegate$lambda$2(var0);
   }

   public NotificationRepository(BlueairDatabase var1, DeviceRepository var2) {
      Intrinsics.checkNotNullParameter(var1, "blueairDb");
      Intrinsics.checkNotNullParameter(var2, "deviceRepository");
      super();
      this.blueairDb = var1;
      this.deviceRepository = var2;
      this.flowNotifications$delegate = LazyKt.lazy(new NotificationRepository$$ExternalSyntheticLambda0(this));
   }

   private static final Flow flowNotifications_delegate$lambda$2(NotificationRepository var0) {
      return new Flow(var0.blueairDb.notificationDao().getFlowNotifications(), var0) {
         final Flow $this_unsafeTransform$inlined;
         final NotificationRepository this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final NotificationRepository this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label39: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var14 = var4;
                           break label39;
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

                  Object var16 = ((<undefinedtype>)var14).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var14).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var14).I$0;
                     FlowCollector var10 = (FlowCollector)((<undefinedtype>)var14).L$3;
                     Object var11 = ((<undefinedtype>)var14).L$2;
                     <undefinedtype> var12 = (<undefinedtype>)((<undefinedtype>)var14).L$1;
                     Object var13 = ((<undefinedtype>)var14).L$0;
                     ResultKt.throwOnFailure(var16);
                  } else {
                     ResultKt.throwOnFailure(var16);
                     FlowCollector var6 = this.$this_unsafeFlow;
                     Continuation var17 = (Continuation)var14;
                     Iterable var18 = (Iterable)((List)var1);
                     Collection var7 = (Collection)(new ArrayList());

                     for(NotificationEntity var9 : var18) {
                        Device var19 = this.this$0.deviceRepository.getDevice(var9.getDeviceId());
                        NotificationMessage var20;
                        if (var19 == null) {
                           var20 = null;
                        } else {
                           var20 = new NotificationMessage(var19, NotificationMsgType.valueOf(var9.getType()), var9.getSubType(), var9.getSubLevel());
                        }

                        if (var20 != null) {
                           var7.add(var20);
                        }
                     }

                     List var21 = (List)var7;
                     ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var14).L$3 = SpillingKt.nullOutSpilledVariable(var6);
                     ((<undefinedtype>)var14).I$0 = 0;
                     ((<undefinedtype>)var14).label = 1;
                     if (var6.emit(var21, (Continuation)var14) == var5) {
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

   public final Object deleteAll(Continuation var1) {
      Object var2 = this.blueairDb.notificationDao().deleteAll(var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final Object deleteNotification(NotificationEntity var1, Continuation var2) {
      Object var3 = this.blueairDb.notificationDao().delete(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Object deleteNotification(String var1, Continuation var2) {
      Object var3 = this.blueairDb.notificationDao().delete(var1, var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Object dismiss(String var1, String var2, String var3, Continuation var4) {
      Object var5 = this.blueairDb.notificationDao().dismiss(var1, var2, var3, System.currentTimeMillis(), var4);
      return var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var5 : Unit.INSTANCE;
   }

   public final Object dismissAll(Continuation var1) {
      Object var2 = this.blueairDb.notificationDao().dismissAll(System.currentTimeMillis(), var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final Flow getFlowNotifications() {
      return (Flow)this.flowNotifications$delegate.getValue();
   }

   public final Object getNotification(String var1, String var2, String var3, Continuation var4) {
      return this.blueairDb.notificationDao().getNotification(var1, var2, var3, var4);
   }

   public final Object insertNotification(NotificationEntity var1, Continuation var2) {
      label194: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var20 = var4;
               break label194;
            }
         }

         var20 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            int label;
            Object result;
            final NotificationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.insertNotification((NotificationEntity)null, (Continuation)this);
            }
         };
      }

      Throwable var10000;
      label187: {
         Object var5 = ((<undefinedtype>)var20).result;
         Object var23 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var20).label;
         if (var3 != 0) {
            if (var3 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var3 = ((<undefinedtype>)var20).I$0;
            var1 = (NotificationEntity)((<undefinedtype>)var20).L$0;

            try {
               ResultKt.throwOnFailure(var5);
            } catch (Throwable var17) {
               var10000 = var17;
               boolean var10001 = false;
               break label187;
            }
         } else {
            ResultKt.throwOnFailure(var5);

            try {
               Result.Companion var24 = Result.Companion;
               NotificationDao var25 = this.blueairDb.notificationDao();
               ((<undefinedtype>)var20).L$0 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var20).I$0 = 0;
               ((<undefinedtype>)var20).label = 1;
               if (var25.insert(var1, (Continuation)var20) == var23) {
                  return var23;
               }
            } catch (Throwable var16) {
               var10000 = var16;
               boolean var26 = false;
               break label187;
            }
         }

         label179:
         try {
            Result.constructor-impl(Unit.INSTANCE);
            return Unit.INSTANCE;
         } catch (Throwable var15) {
            var10000 = var15;
            boolean var27 = false;
            break label179;
         }
      }

      Throwable var19 = var10000;
      Result.Companion var21 = Result.Companion;
      Result.constructor-impl(ResultKt.createFailure(var19));
      return Unit.INSTANCE;
   }

   public final Object revokeDismission(String var1, Continuation var2) {
      label194: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var20 = var4;
               break label194;
            }
         }

         var20 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            int label;
            Object result;
            final NotificationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.revokeDismission((String)null, (Continuation)this);
            }
         };
      }

      Throwable var10000;
      label187: {
         Object var5 = ((<undefinedtype>)var20).result;
         Object var23 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var20).label;
         if (var3 != 0) {
            if (var3 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var3 = ((<undefinedtype>)var20).I$0;
            var1 = (String)((<undefinedtype>)var20).L$0;

            try {
               ResultKt.throwOnFailure(var5);
            } catch (Throwable var17) {
               var10000 = var17;
               boolean var10001 = false;
               break label187;
            }
         } else {
            ResultKt.throwOnFailure(var5);

            try {
               Result.Companion var24 = Result.Companion;
               NotificationDao var25 = this.blueairDb.notificationDao();
               ((<undefinedtype>)var20).L$0 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var20).I$0 = 0;
               ((<undefinedtype>)var20).label = 1;
               if (var25.revokeDismission(var1, (Continuation)var20) == var23) {
                  return var23;
               }
            } catch (Throwable var16) {
               var10000 = var16;
               boolean var26 = false;
               break label187;
            }
         }

         label179:
         try {
            Result.constructor-impl(Unit.INSTANCE);
            return Unit.INSTANCE;
         } catch (Throwable var15) {
            var10000 = var15;
            boolean var27 = false;
            break label179;
         }
      }

      Throwable var19 = var10000;
      Result.Companion var21 = Result.Companion;
      Result.constructor-impl(ResultKt.createFailure(var19));
      return Unit.INSTANCE;
   }

   public final Object updateNotification(NotificationEntity var1, Continuation var2) {
      label194: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var20 = var4;
               break label194;
            }
         }

         var20 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            int label;
            Object result;
            final NotificationRepository this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateNotification((NotificationEntity)null, (Continuation)this);
            }
         };
      }

      Throwable var10000;
      label187: {
         Object var5 = ((<undefinedtype>)var20).result;
         Object var23 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var20).label;
         if (var3 != 0) {
            if (var3 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var3 = ((<undefinedtype>)var20).I$0;
            var1 = (NotificationEntity)((<undefinedtype>)var20).L$0;

            try {
               ResultKt.throwOnFailure(var5);
            } catch (Throwable var17) {
               var10000 = var17;
               boolean var10001 = false;
               break label187;
            }
         } else {
            ResultKt.throwOnFailure(var5);

            try {
               Result.Companion var24 = Result.Companion;
               NotificationDao var25 = this.blueairDb.notificationDao();
               ((<undefinedtype>)var20).L$0 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var20).I$0 = 0;
               ((<undefinedtype>)var20).label = 1;
               if (var25.update(var1, (Continuation)var20) == var23) {
                  return var23;
               }
            } catch (Throwable var16) {
               var10000 = var16;
               boolean var26 = false;
               break label187;
            }
         }

         label179:
         try {
            Result.constructor-impl(Unit.INSTANCE);
            return Unit.INSTANCE;
         } catch (Throwable var15) {
            var10000 = var15;
            boolean var27 = false;
            break label179;
         }
      }

      Throwable var21 = var10000;
      Result.Companion var19 = Result.Companion;
      Result.constructor-impl(ResultKt.createFailure(var21));
      return Unit.INSTANCE;
   }
}
