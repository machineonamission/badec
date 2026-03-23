package com.blueair.antifake.fragmnet;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.core.model.BluetoothDevice;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.fragmnet.SearchDeviceFragment$onCreateView$4", f = "SearchDeviceFragment.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SearchDeviceFragment.kt */
final class SearchDeviceFragment$onCreateView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchDeviceFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchDeviceFragment$onCreateView$4(SearchDeviceFragment searchDeviceFragment, Continuation<? super SearchDeviceFragment$onCreateView$4> continuation) {
        super(2, continuation);
        this.this$0 = searchDeviceFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchDeviceFragment$onCreateView$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchDeviceFragment$onCreateView$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.antifake.fragmnet.SearchDeviceFragment$onCreateView$4$1", f = "SearchDeviceFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.antifake.fragmnet.SearchDeviceFragment$onCreateView$4$1  reason: invalid class name */
    /* compiled from: SearchDeviceFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(searchDeviceFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<List<BluetoothDevice>> bleDevicesFlow = searchDeviceFragment.getViewModel().getBleDevicesFlow();
                final SearchDeviceFragment searchDeviceFragment = searchDeviceFragment;
                this.label = 1;
                if (bleDevicesFlow.collect(new FlowCollector() {
                    public final Object emit(List<BluetoothDevice> list, Continuation<? super Unit> continuation) {
                        Object obj;
                        searchDeviceFragment.adapter.updateBluetoothDevices(list);
                        if (searchDeviceFragment.adapter.getItemCount() > 0) {
                            searchDeviceFragment.showProgress(false);
                        }
                        BluetoothDevice access$getPendingConnectableDevice$p = searchDeviceFragment.pendingConnectableDevice;
                        if (access$getPendingConnectableDevice$p != null) {
                            SearchDeviceFragment searchDeviceFragment = searchDeviceFragment;
                            Iterator it = list.iterator();
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
                                searchDeviceFragment.pendingConnectableDevice = null;
                                ConnectInstructionsDialog access$getConnectInstructionsDialog$p = searchDeviceFragment.connectInstructionsDialog;
                                if (access$getConnectInstructionsDialog$p != null) {
                                    access$getConnectInstructionsDialog$p.dismiss();
                                }
                                searchDeviceFragment.getViewModel().resetFilterByBluetooth(access$getPendingConnectableDevice$p);
                            }
                        }
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
            final SearchDeviceFragment searchDeviceFragment = this.this$0;
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
