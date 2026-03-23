package com.blueair.adddevice.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.BluetoothScanResultFragment$onViewCreated$1", f = "BluetoothScanResultFragment.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BluetoothScanResultFragment.kt */
final class BluetoothScanResultFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BluetoothScanResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothScanResultFragment$onViewCreated$1(BluetoothScanResultFragment bluetoothScanResultFragment, Continuation<? super BluetoothScanResultFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = bluetoothScanResultFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BluetoothScanResultFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BluetoothScanResultFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.adddevice.fragment.BluetoothScanResultFragment$onViewCreated$1$1", f = "BluetoothScanResultFragment.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.adddevice.fragment.BluetoothScanResultFragment$onViewCreated$1$1  reason: invalid class name */
    /* compiled from: BluetoothScanResultFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(bluetoothScanResultFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<List<BluetoothDevice>> bleDevicesFlow = bluetoothScanResultFragment.getViewModel().getBleDevicesFlow();
                final BluetoothScanResultFragment bluetoothScanResultFragment = bluetoothScanResultFragment;
                this.label = 1;
                if (bleDevicesFlow.collect(new FlowCollector() {
                    /* access modifiers changed from: private */
                    public static final CharSequence emit$lambda$0(BluetoothDevice bluetoothDevice) {
                        Intrinsics.checkNotNullParameter(bluetoothDevice, "it");
                        return bluetoothDevice.getModelName() + '-' + bluetoothDevice.getConnectable();
                    }

                    public final Object emit(List<BluetoothDevice> list, Continuation<? super Unit> continuation) {
                        Object obj;
                        Timber.Forest forest = Timber.Forest;
                        StringBuilder sb = new StringBuilder("liveBleDeviceObserver: ");
                        Iterable iterable = list;
                        sb.append(CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new BluetoothScanResultFragment$onViewCreated$1$1$1$$ExternalSyntheticLambda0(), 31, (Object) null));
                        forest.d(sb.toString(), new Object[0]);
                        BluetoothDevice access$getPendingConnectableDevice$p = bluetoothScanResultFragment.pendingConnectableDevice;
                        if (access$getPendingConnectableDevice$p != null) {
                            BluetoothScanResultFragment bluetoothScanResultFragment = bluetoothScanResultFragment;
                            Iterator it = iterable.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (Intrinsics.areEqual((Object) ((BluetoothDevice) obj).getMac(), (Object) access$getPendingConnectableDevice$p.getMac())) {
                                    break;
                                }
                            }
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                            if (bluetoothDevice != null && bluetoothDevice.getConnectable()) {
                                bluetoothScanResultFragment.pendingConnectableDevice = null;
                                ConnectInstructionsDialog access$getConnectInstructionsDialog$p = bluetoothScanResultFragment.connectInstructionsDialog;
                                if (access$getConnectInstructionsDialog$p != null) {
                                    access$getConnectInstructionsDialog$p.switchConnecting();
                                }
                                bluetoothScanResultFragment.getViewModel().logStep1ConnectionInstructions(bluetoothDevice, AnalyticEvent.OnboardingLogEvent.CONNECT_TYPE_DETECT);
                                bluetoothScanResultFragment.connectBleDevice(bluetoothDevice, 1);
                            }
                        }
                        bluetoothScanResultFragment.showScanningResults(list);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            final BluetoothScanResultFragment bluetoothScanResultFragment = this.this$0;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation<? super Unit>) this) == coroutine_suspended) {
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
