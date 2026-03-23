package com.blueair.devicedetails.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.devicedetails.databinding.FragmentDeviceControlsBinding;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.viewcore.R;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceControlsFragment$onResume$1$1", f = "DeviceControlsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceControlsFragment.kt */
final class DeviceControlsFragment$onResume$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttributeAction<?> $action;
    int label;
    final /* synthetic */ DeviceControlsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceControlsFragment$onResume$1$1(AttributeAction<?> attributeAction, DeviceControlsFragment deviceControlsFragment, Continuation<? super DeviceControlsFragment$onResume$1$1> continuation) {
        super(2, continuation);
        this.$action = attributeAction;
        this.this$0 = deviceControlsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceControlsFragment$onResume$1$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceControlsFragment$onResume$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentDeviceControlsBinding fragmentDeviceControlsBinding = null;
            if (!((Boolean) ((AttributeAction.AutoRhShowHintAction) this.$action).getValue()).booleanValue() || this.this$0.getViewModel().getControlsHintClosedBefore()) {
                FragmentDeviceControlsBinding access$getBinding$p = this.this$0.binding;
                if (access$getBinding$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentDeviceControlsBinding = access$getBinding$p;
                }
                ConstraintLayout constraintLayout = fragmentDeviceControlsBinding.controlsHintContainer;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "controlsHintContainer");
                ViewExtensionsKt.show(constraintLayout, false);
            } else {
                int i = this.this$0.getViewModel().getDevice() instanceof DeviceCombo2in120 ? R.string.target_humidity_info_2in120 : R.string.target_humidity_info_v2;
                FragmentDeviceControlsBinding access$getBinding$p2 = this.this$0.binding;
                if (access$getBinding$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    access$getBinding$p2 = null;
                }
                access$getBinding$p2.controlsHintText.setText(i);
                FragmentDeviceControlsBinding access$getBinding$p3 = this.this$0.binding;
                if (access$getBinding$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentDeviceControlsBinding = access$getBinding$p3;
                }
                ConstraintLayout constraintLayout2 = fragmentDeviceControlsBinding.controlsHintContainer;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "controlsHintContainer");
                ViewExtensionsKt.show(constraintLayout2, true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
