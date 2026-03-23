package com.blueair.adddevice.fragment.legacy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$1", f = "AddDeviceManualUserValidateFragment.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
/* compiled from: AddDeviceManualUserValidateFragment.kt */
final class AddDeviceManualUserValidateFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ AddDeviceManualUserValidateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceManualUserValidateFragment$onViewCreated$1(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, Continuation<? super AddDeviceManualUserValidateFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceManualUserValidateFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceManualUserValidateFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceManualUserValidateFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            int r1 = r5.I$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x0011:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 25
            r1 = r6
        L_0x001f:
            if (r1 <= 0) goto L_0x0045
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r6 = r5.this$0
            com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding r6 = r6.getClassicBinding()
            android.widget.TextView r6 = r6.txtCountdown
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.I$0 = r1
            r5.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x0042
            return r0
        L_0x0042:
            int r1 = r1 + -1
            goto L_0x001f
        L_0x0045:
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r6 = r5.this$0
            com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding r6 = r6.getClassicBinding()
            android.widget.TextView r6 = r6.textAddDeviceSubtitleTwo
            int r0 = com.blueair.viewcore.R.string.add_device_confirm_subtitle2
            r6.setText(r0)
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r6 = r5.this$0
            com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding r6 = r6.getClassicBinding()
            android.widget.TextView r6 = r6.txtCountdown
            java.lang.String r0 = "txtCountdown"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            android.view.View r6 = (android.view.View) r6
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r6)
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r6 = r5.this$0
            com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding r6 = r6.getClassicBinding()
            androidx.constraintlayout.widget.Group r6 = r6.groupButtons
            java.lang.String r0 = "groupButtons"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            android.view.View r6 = (android.view.View) r6
            r0 = 0
            r1 = 0
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r6, r0, r2, r1)
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r6 = r5.this$0
            com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding r6 = r6.getClassicBinding()
            android.widget.ImageView r6 = r6.bgCountdown
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r0 = r5.this$0
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.blueair.adddevice.R.drawable.ic_wifi_blue_big
            android.graphics.drawable.Drawable r0 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r2, r1)
            r6.setImageDrawable(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
