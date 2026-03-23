package com.blueair.devicedetails.dialog;

import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.DeletableItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1", f = "DeleteScheduleDialogFragment.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeleteScheduleDialogFragment.kt */
final class DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeletableItem<DeviceScheduleMerged> $item;
    int label;
    final /* synthetic */ DeleteScheduleDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1(DeleteScheduleDialogFragment deleteScheduleDialogFragment, DeletableItem<DeviceScheduleMerged> deletableItem, Continuation<? super DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteScheduleDialogFragment;
        this.$item = deletableItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1(this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1$1", f = "DeleteScheduleDialogFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.dialog.DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1$1  reason: invalid class name */
    /* compiled from: DeleteScheduleDialogFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(deleteScheduleDialogFragment, deletableItem, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (deleteScheduleDialogFragment.getViewModel().delete(deletableItem.getData(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final DeleteScheduleDialogFragment deleteScheduleDialogFragment = this.this$0;
            final DeletableItem<DeviceScheduleMerged> deletableItem = this.$item;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getViewModel().refreshDeviceSchedule(true);
        return Unit.INSTANCE;
    }
}
