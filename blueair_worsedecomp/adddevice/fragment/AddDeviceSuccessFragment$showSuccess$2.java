package com.blueair.adddevice.fragment;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.blueair.adddevice.databinding.FragmentAddDeviceSuccessBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.OnboardingFailureEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.AddDeviceSuccessFragment$showSuccess$2", f = "AddDeviceSuccessFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceSuccessFragment.kt */
final class AddDeviceSuccessFragment$showSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMessage;
    int label;
    final /* synthetic */ AddDeviceSuccessFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceSuccessFragment$showSuccess$2(AddDeviceSuccessFragment addDeviceSuccessFragment, String str, Continuation<? super AddDeviceSuccessFragment$showSuccess$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceSuccessFragment;
        this.$errorMessage = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceSuccessFragment$showSuccess$2(this.this$0, this.$errorMessage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceSuccessFragment$showSuccess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        DeviceType deviceType;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.this$0.troubleShowTime < 1000) {
                return Unit.INSTANCE;
            }
            this.this$0.troubleShowTime = currentTimeMillis;
            AnalyticsService access$getAnalytics = this.this$0.getAnalytics();
            BluetoothDevice selectedUiDevice = this.this$0.getViewModel().getSelectedUiDevice();
            String str2 = "";
            if (selectedUiDevice == null || (deviceType = selectedUiDevice.getDeviceType()) == null || (str = deviceType.getName()) == null) {
                str = str2;
            }
            String str3 = this.$errorMessage;
            if (str3 != null) {
                str2 = str3;
            }
            access$getAnalytics.amplitudeLog((AmplitudeEvent) new OnboardingFailureEvent(str, false, str2));
            FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding = null;
            AddDeviceViewModel.logStep5OnboardingFailure$default(this.this$0.getViewModel(), (String) null, 1, (Object) null);
            FragmentAddDeviceSuccessBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                access$getViewDataBinding$p = null;
            }
            ProgressBlockerView progressBlockerView = access$getViewDataBinding$p.progressView;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
            ViewExtensionsKt.hide(progressBlockerView);
            FragmentAddDeviceSuccessBinding access$getViewDataBinding$p2 = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentAddDeviceSuccessBinding = access$getViewDataBinding$p2;
            }
            fragmentAddDeviceSuccessBinding.buttonContinue.setVisibility(8);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            AddDeviceSuccessFragment addDeviceSuccessFragment = this.this$0;
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_trouble_adding_device, (Integer) null, R.string.hint_trouble_adding_device, Boxing.boxInt(R.string.connection_to_purifier_try_again), Boxing.boxInt(R.string.action_read_tips), false, false, false, false, (String[]) null, (String) null, new AddDeviceSuccessFragment$showSuccess$2$$ExternalSyntheticLambda0(addDeviceSuccessFragment), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                childFragmentManager.executePendingTransactions();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$lambda$2(AddDeviceSuccessFragment addDeviceSuccessFragment, boolean z) {
        if (z) {
            addDeviceSuccessFragment.getViewModel().restart();
        } else {
            addDeviceSuccessFragment.getAnalytics().event(new AnalyticEvent.TAP_TROUBLESHOOTING());
            FragmentManager childFragmentManager = addDeviceSuccessFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
            Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
            DialogFragment dialogFragment = null;
            if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
                dialogFragment = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, TroubleshootingDialog.ACTION_TYPE_WIFI_GUIDE, (Device) null, 2, (Object) null);
                dialogFragment.show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
                childFragmentManager.executePendingTransactions();
            }
            TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
            if (troubleshootingDialog != null) {
                FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new AddDeviceSuccessFragment$showSuccess$2$$ExternalSyntheticLambda1(addDeviceSuccessFragment));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$lambda$2$lambda$1(AddDeviceSuccessFragment addDeviceSuccessFragment, String str, Bundle bundle) {
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            addDeviceSuccessFragment.getViewModel().restart();
        }
        return Unit.INSTANCE;
    }
}
