package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.blueair.antifake.databinding.FragmentScanDeviceBinding;
import com.blueair.viewcore.dialog.GuidesData;
import com.blueair.viewcore.dialog.StepGuideDialogFragment;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.google.android.material.button.MaterialButton;
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
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.fragmnet.ScanDeviceFragment$launchTroubleshootingTask$1", f = "ScanDeviceFragment.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ScanDeviceFragment.kt */
final class ScanDeviceFragment$launchTroubleshootingTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ScanDeviceFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScanDeviceFragment$launchTroubleshootingTask$1(ScanDeviceFragment scanDeviceFragment, Continuation<? super ScanDeviceFragment$launchTroubleshootingTask$1> continuation) {
        super(2, continuation);
        this.this$0 = scanDeviceFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScanDeviceFragment$launchTroubleshootingTask$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScanDeviceFragment$launchTroubleshootingTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DialogFragment dialogFragment;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(20000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if ((this.this$0.getViewModel().getResetDeviceWifiMac().length() > 0 && !this.this$0.deviceFounded) || (this.this$0.getViewModel().getResetDeviceWifiMac().length() == 0 && this.this$0.adapter.getItemCount() == 0)) {
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<StepGuideDialogFragment> cls = StepGuideDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue(StepGuideDialogFragment.DEFAULT_REQUEST_KEY, "getSimpleName(...)");
            if ((childFragmentManager.findFragmentByTag(StepGuideDialogFragment.DEFAULT_REQUEST_KEY) instanceof StepGuideDialogFragment) || childFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                dialogFragment = StepGuideDialogFragment.Companion.newInstance(GuidesData.INSTANCE.getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN());
                dialogFragment.show(childFragmentManager, StepGuideDialogFragment.DEFAULT_REQUEST_KEY);
            }
            StepGuideDialogFragment stepGuideDialogFragment = (StepGuideDialogFragment) dialogFragment;
            if (stepGuideDialogFragment != null) {
                FragmentExtensionsKt.setFragmentResultListenerWithClear(stepGuideDialogFragment, GuidesData.INSTANCE.getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN().getRequestKey(), new ScanDeviceFragment$launchTroubleshootingTask$1$$ExternalSyntheticLambda0(this.this$0));
            }
            FragmentScanDeviceBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            MaterialButton materialButton = access$getBinding$p.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnCustomerSupport");
            ViewExtensionsKt.show$default(materialButton, false, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(ScanDeviceFragment scanDeviceFragment, String str, Bundle bundle) {
        scanDeviceFragment.launchTroubleshootingTask();
        return Unit.INSTANCE;
    }
}
