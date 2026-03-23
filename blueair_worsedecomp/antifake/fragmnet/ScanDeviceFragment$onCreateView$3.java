package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.fragmnet.ScanDeviceFragment$onCreateView$3", f = "ScanDeviceFragment.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ScanDeviceFragment.kt */
final class ScanDeviceFragment$onCreateView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ScanDeviceFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScanDeviceFragment$onCreateView$3(ScanDeviceFragment scanDeviceFragment, Continuation<? super ScanDeviceFragment$onCreateView$3> continuation) {
        super(2, continuation);
        this.this$0 = scanDeviceFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScanDeviceFragment$onCreateView$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScanDeviceFragment$onCreateView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.antifake.fragmnet.ScanDeviceFragment$onCreateView$3$1", f = "ScanDeviceFragment.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.antifake.fragmnet.ScanDeviceFragment$onCreateView$3$1  reason: invalid class name */
    /* compiled from: ScanDeviceFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(scanDeviceFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<List<BluetoothDevice>> bleDevicesFlow = scanDeviceFragment.getViewModel().getBleDevicesFlow();
                final ScanDeviceFragment scanDeviceFragment = scanDeviceFragment;
                this.label = 1;
                if (bleDevicesFlow.collect(new FlowCollector() {
                    public final Object emit(List<BluetoothDevice> list, Continuation<? super Unit> continuation) {
                        DialogFragment dialogFragment;
                        Object obj;
                        ScanDeviceFragment scanDeviceFragment = scanDeviceFragment;
                        Iterator it = list.iterator();
                        while (true) {
                            dialogFragment = null;
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (StringsKt.equals(((BluetoothDevice) obj).getWifiMac(), scanDeviceFragment.getViewModel().getResetDeviceWifiMac(), true)) {
                                break;
                            }
                        }
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                        if (bluetoothDevice != null) {
                            ScanDeviceFragment scanDeviceFragment2 = scanDeviceFragment;
                            scanDeviceFragment2.showProgress(false);
                            scanDeviceFragment2.deviceFounded = true;
                            if (bluetoothDevice.getConnectable()) {
                                scanDeviceFragment2.pendingConnectableDevice = null;
                                ConnectInstructionsDialog access$getConnectInstructionsDialog$p = scanDeviceFragment2.connectInstructionsDialog;
                                if (access$getConnectInstructionsDialog$p != null) {
                                    access$getConnectInstructionsDialog$p.dismiss();
                                }
                                scanDeviceFragment2.getViewModel().resetFilterByBluetooth(bluetoothDevice);
                            } else {
                                FragmentManager childFragmentManager = scanDeviceFragment2.getChildFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                                Class<ConnectInstructionsDialog> cls = ConnectInstructionsDialog.class;
                                Intrinsics.checkNotNullExpressionValue(ConnectInstructionsDialog.REQUEST_KEY, "getSimpleName(...)");
                                if (!(childFragmentManager.findFragmentByTag(ConnectInstructionsDialog.REQUEST_KEY) instanceof ConnectInstructionsDialog) && !childFragmentManager.isStateSaved()) {
                                    dialogFragment = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, bluetoothDevice.getFamilyName(), bluetoothDevice.getHasNoAutoButton() ? ConnectInstructionsDialog.ACTION_FAN_SPEED : ConnectInstructionsDialog.ACTION_AUTO, bluetoothDevice, false, 8, (Object) null);
                                    dialogFragment.show(childFragmentManager, ConnectInstructionsDialog.REQUEST_KEY);
                                }
                                ConnectInstructionsDialog connectInstructionsDialog = (ConnectInstructionsDialog) dialogFragment;
                                if (connectInstructionsDialog != null) {
                                    scanDeviceFragment2.pendingConnectableDevice = bluetoothDevice;
                                    scanDeviceFragment2.connectInstructionsDialog = connectInstructionsDialog;
                                    FragmentExtensionsKt.setFragmentResultListenerWithClear(connectInstructionsDialog, ConnectInstructionsDialog.REQUEST_KEY, new ScanDeviceFragment$onCreateView$3$1$1$$ExternalSyntheticLambda0(scanDeviceFragment2));
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* access modifiers changed from: private */
                    public static final Unit emit$lambda$4$lambda$3$lambda$2(ScanDeviceFragment scanDeviceFragment, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
                        if (scanDeviceFragment.pendingConnectableDevice != null) {
                            scanDeviceFragment.getViewModel().goBack();
                        }
                        scanDeviceFragment.pendingConnectableDevice = null;
                        scanDeviceFragment.connectInstructionsDialog = null;
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
            final ScanDeviceFragment scanDeviceFragment = this.this$0;
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
