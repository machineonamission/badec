package com.blueair.adddevice.fragment.legacy;

import android.net.wifi.WifiInfo;
import android.widget.Button;
import android.widget.TextView;
import com.blueair.viewcore.R;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.viewhelper.ViewExtensionsKt;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceSetupTextFragment$onViewCreated$1", f = "AddDeviceSetupTextFragment.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceSetupTextFragment.kt */
final class AddDeviceSetupTextFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AddDeviceSetupTextFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceSetupTextFragment$onViewCreated$1(AddDeviceSetupTextFragment addDeviceSetupTextFragment, Continuation<? super AddDeviceSetupTextFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceSetupTextFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceSetupTextFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceSetupTextFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Boolean> wifiStatus = this.this$0.getNetworkMonitor().getWifiStatus();
            final AddDeviceSetupTextFragment addDeviceSetupTextFragment = this.this$0;
            this.label = 1;
            if (wifiStatus.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    boolean z2 = false;
                    Button button = null;
                    if (!z) {
                        Button access$getBtnNext$p = addDeviceSetupTextFragment.btnNext;
                        if (access$getBtnNext$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                            access$getBtnNext$p = null;
                        }
                        access$getBtnNext$p.setEnabled(false);
                        TextView access$getTxtWrongWifi$p = addDeviceSetupTextFragment.txtWrongWifi;
                        if (access$getTxtWrongWifi$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                            access$getTxtWrongWifi$p = null;
                        }
                        access$getTxtWrongWifi$p.setText(addDeviceSetupTextFragment.getString(R.string.setup_check_wifi));
                        TextView access$getTxtWrongWifi$p2 = addDeviceSetupTextFragment.txtWrongWifi;
                        if (access$getTxtWrongWifi$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                            access$getTxtWrongWifi$p2 = null;
                        }
                        ViewExtensionsKt.show$default(access$getTxtWrongWifi$p2, false, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                    WifiInfo activeWifiInfo = NetUtil.INSTANCE.getActiveWifiInfo(addDeviceSetupTextFragment.requireContext());
                    if ((activeWifiInfo != null ? activeWifiInfo.getFrequency() : 0) > 3000) {
                        z2 = true;
                    }
                    TextView access$getTxtWrongWifi$p3 = addDeviceSetupTextFragment.txtWrongWifi;
                    if (access$getTxtWrongWifi$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                        access$getTxtWrongWifi$p3 = null;
                    }
                    access$getTxtWrongWifi$p3.setText(addDeviceSetupTextFragment.getString(R.string.setup_wrong_wifi));
                    TextView access$getTxtWrongWifi$p4 = addDeviceSetupTextFragment.txtWrongWifi;
                    if (access$getTxtWrongWifi$p4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                        access$getTxtWrongWifi$p4 = null;
                    }
                    ViewExtensionsKt.show(access$getTxtWrongWifi$p4, z2);
                    Button access$getBtnNext$p2 = addDeviceSetupTextFragment.btnNext;
                    if (access$getBtnNext$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                    } else {
                        button = access$getBtnNext$p2;
                    }
                    button.setEnabled(true);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
