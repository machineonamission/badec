package com.blueair.adddevice.fragment;

import com.blueair.adddevice.databinding.FragmentAddDeviceSuccessBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.OnboardingSuccessEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.AddDeviceSuccessFragment$showSuccess$1", f = "AddDeviceSuccessFragment.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceSuccessFragment.kt */
final class AddDeviceSuccessFragment$showSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AddDeviceSuccessFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceSuccessFragment$showSuccess$1(AddDeviceSuccessFragment addDeviceSuccessFragment, Continuation<? super AddDeviceSuccessFragment$showSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceSuccessFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceSuccessFragment$showSuccess$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceSuccessFragment$showSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        DeviceType deviceType;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnalyticsService access$getAnalytics = this.this$0.getAnalytics();
            BluetoothDevice selectedUiDevice = this.this$0.getViewModel().getSelectedUiDevice();
            String str2 = "";
            if (selectedUiDevice == null || (deviceType = selectedUiDevice.getDeviceType()) == null || (str = deviceType.getName()) == null) {
                str = str2;
            }
            String detectedDeviceUuid = this.this$0.getViewModel().getDetectedDeviceUuid();
            if (detectedDeviceUuid != null) {
                str2 = detectedDeviceUuid;
            }
            access$getAnalytics.amplitudeLog((AmplitudeEvent) new OnboardingSuccessEvent(str, str2, false));
            AddDeviceViewModel.logStep5OnboardingSuccess$default(this.this$0.getViewModel(), (String) null, 1, (Object) null);
            FragmentAddDeviceSuccessBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                access$getViewDataBinding$p = null;
            }
            ProgressBlockerView progressBlockerView = access$getViewDataBinding$p.progressView;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
            ViewExtensionsKt.hide(progressBlockerView);
            if (this.this$0.getContext() != null) {
                AddDeviceSuccessFragment addDeviceSuccessFragment = this.this$0;
                FragmentAddDeviceSuccessBinding access$getViewDataBinding$p2 = addDeviceSuccessFragment.viewDataBinding;
                if (access$getViewDataBinding$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                    access$getViewDataBinding$p2 = null;
                }
                access$getViewDataBinding$p2.ivIndicator.setImageResource(R.drawable.ic_success_flat);
                FragmentAddDeviceSuccessBinding access$getViewDataBinding$p3 = addDeviceSuccessFragment.viewDataBinding;
                if (access$getViewDataBinding$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                    access$getViewDataBinding$p3 = null;
                }
                access$getViewDataBinding$p3.tvStatus.setText(R.string.label_connected);
                FragmentAddDeviceSuccessBinding access$getViewDataBinding$p4 = addDeviceSuccessFragment.viewDataBinding;
                if (access$getViewDataBinding$p4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                    access$getViewDataBinding$p4 = null;
                }
                access$getViewDataBinding$p4.tvContent.setText(R.string.msg_wifi_connection_successful);
            }
            final AddDeviceSuccessFragment addDeviceSuccessFragment2 = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.adddevice.fragment.AddDeviceSuccessFragment$showSuccess$1$2", f = "AddDeviceSuccessFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.adddevice.fragment.AddDeviceSuccessFragment$showSuccess$1$2  reason: invalid class name */
    /* compiled from: AddDeviceSuccessFragment.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(addDeviceSuccessFragment2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                addDeviceSuccessFragment2.getViewModel().addDevice();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
