package com.blueair.adddevice.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.WifiPasswordFragment$onResume$7$1", f = "WifiPasswordFragment.kt", i = {1}, l = {190, 195}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"})
/* compiled from: WifiPasswordFragment.kt */
final class WifiPasswordFragment$onResume$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ WifiPasswordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiPasswordFragment$onResume$7$1(WifiPasswordFragment wifiPasswordFragment, Continuation<? super WifiPasswordFragment$onResume$7$1> continuation) {
        super(2, continuation);
        this.this$0 = wifiPasswordFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiPasswordFragment$onResume$7$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WifiPasswordFragment$onResume$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        if (r11 == r0) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            java.lang.Object r0 = r10.L$0
            com.blueair.adddevice.fragment.WifiPasswordFragment r0 = (com.blueair.adddevice.fragment.WifiPasswordFragment) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0084
        L_0x0017:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0041
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.blueair.adddevice.fragment.WifiPasswordFragment$onResume$7$1$success$1 r1 = new com.blueair.adddevice.fragment.WifiPasswordFragment$onResume$7$1$success$1
            com.blueair.adddevice.fragment.WifiPasswordFragment r5 = r10.this$0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r10.label = r4
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r5)
            if (r11 != r0) goto L_0x0041
            goto L_0x0082
        L_0x0041:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x008e
            com.blueair.core.util.UserInfoCollectionsManager r4 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.core.model.UserInfoItem r5 = com.blueair.core.model.UserInfoItem.NET_WIFI_SSID
            com.blueair.adddevice.fragment.WifiPasswordFragment r1 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r1 = r1.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getSelectedSsid()
            java.lang.Object r1 = r1.getValue()
            com.blueair.core.model.Ssid r1 = (com.blueair.core.model.Ssid) r1
            if (r1 == 0) goto L_0x0063
            java.lang.String r2 = r1.getSsid()
        L_0x0063:
            java.lang.String r6 = java.lang.String.valueOf(r2)
            r8 = 4
            r9 = 0
            r7 = 0
            com.blueair.core.util.UserInfoCollectionsManager.addRecord$default(r4, r5, r6, r7, r8, r9)
            com.blueair.adddevice.fragment.WifiPasswordFragment r1 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r2 = r1.getViewModel()
            r4 = r10
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r10.L$0 = r1
            r10.Z$0 = r11
            r10.label = r3
            java.lang.Object r11 = r2.pollwifiConnected(r4)
            if (r11 != r0) goto L_0x0083
        L_0x0082:
            return r0
        L_0x0083:
            r0 = r1
        L_0x0084:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r0.polling = r11
            goto L_0x00dd
        L_0x008e:
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            android.content.Context r0 = r11.getContext()
            r11.hideProgress(r0)
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r11.getViewModel()
            java.lang.Boolean r11 = r11.isSelectedBleDeviceConnected()
            r0 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r1)
            if (r11 == 0) goto L_0x00b2
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            r11.showInputConnectError()
            goto L_0x00dd
        L_0x00b2:
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r11.getViewModel()
            boolean r11 = r11.isRandRegisterFailed()
            if (r11 == 0) goto L_0x00c4
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            r11.showRandRegisterError()
            goto L_0x00dd
        L_0x00c4:
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r11.getViewModel()
            java.lang.Boolean r11 = r11.isSelectedBleDeviceWifiConnected()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
            if (r11 == 0) goto L_0x00dd
            com.blueair.adddevice.fragment.WifiPasswordFragment r11 = r10.this$0
            r11.showInputWifiConnError()
        L_0x00dd:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.WifiPasswordFragment$onResume$7$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
