package com.blueair.adddevice.fragment;

import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.core.model.BluetoothDevice;
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
@DebugMetadata(c = "com.blueair.adddevice.fragment.BluetoothScanResultFragment$onResume$4$3$1$1", f = "BluetoothScanResultFragment.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BluetoothScanResultFragment.kt */
final class BluetoothScanResultFragment$onResume$4$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothDevice $device;
    int label;
    final /* synthetic */ BluetoothScanResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothScanResultFragment$onResume$4$3$1$1(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice, Continuation<? super BluetoothScanResultFragment$onResume$4$3$1$1> continuation) {
        super(2, continuation);
        this.this$0 = bluetoothScanResultFragment;
        this.$device = bluetoothDevice;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BluetoothScanResultFragment$onResume$4$3$1$1(this.this$0, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BluetoothScanResultFragment$onResume$4$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showProgress(true);
            final BluetoothScanResultFragment bluetoothScanResultFragment = this.this$0;
            final BluetoothDevice bluetoothDevice = this.$device;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.showProgress(false);
        BluetoothScanResultFragment bluetoothScanResultFragment2 = this.this$0;
        BluetoothDevice bluetoothDevice2 = this.$device;
        Intrinsics.checkNotNull(bluetoothDevice2);
        bluetoothScanResultFragment2.startConnectBleDevice(bluetoothDevice2);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.adddevice.fragment.BluetoothScanResultFragment$onResume$4$3$1$1$1", f = "BluetoothScanResultFragment.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.adddevice.fragment.BluetoothScanResultFragment$onResume$4$3$1$1$1  reason: invalid class name */
    /* compiled from: BluetoothScanResultFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(bluetoothScanResultFragment, bluetoothDevice, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AddDeviceViewModel viewModel = bluetoothScanResultFragment.getViewModel();
                BluetoothDevice bluetoothDevice = bluetoothDevice;
                Intrinsics.checkNotNull(bluetoothDevice);
                this.label = 1;
                if (viewModel.removeOwnedDevice(bluetoothDevice, this) == coroutine_suspended) {
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
}
