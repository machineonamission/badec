package com.blueair.devicedetails.dialog;

import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1", f = "DeleteAlarmDialogFragment.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeleteAlarmDialogFragment.kt */
final class DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeletableItem<DeviceAlarm> $item;
    int label;
    final /* synthetic */ DeleteAlarmDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1(DeleteAlarmDialogFragment deleteAlarmDialogFragment, DeletableItem<DeviceAlarm> deletableItem, Continuation<? super DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteAlarmDialogFragment;
        this.$item = deletableItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1(this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1$1", f = "DeleteAlarmDialogFragment.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1$1  reason: invalid class name */
    /* compiled from: DeleteAlarmDialogFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(deleteAlarmDialogFragment, deletableItem, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DeviceAlarmsViewModel viewModel = deleteAlarmDialogFragment.getViewModel();
                HasAlarm access$getDevice$p = deleteAlarmDialogFragment.device;
                if (access$getDevice$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    access$getDevice$p = null;
                }
                this.label = 1;
                if (viewModel.delete(access$getDevice$p, deletableItem.getData(), this) == coroutine_suspended) {
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
            final DeleteAlarmDialogFragment deleteAlarmDialogFragment = this.this$0;
            final DeletableItem<DeviceAlarm> deletableItem = this.$item;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getViewModel().refreshDeviceAlarms();
        return Unit.INSTANCE;
    }
}
