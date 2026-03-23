package com.blueair.antifake.viewmodel;

import com.blueair.api.restapi.AntiFakeResetResp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "rsp", "Lcom/blueair/api/restapi/AntiFakeResetResp;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3", f = "AntiFakeViewModel.kt", i = {0, 0, 1, 1, 2, 2}, l = {252, 255, 259}, m = "invokeSuspend", n = {"rsp", "result", "rsp", "result", "rsp", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: AntiFakeViewModel.kt */
final class AntiFakeViewModel$connectBluetoothAndResetFilter$3 extends SuspendLambda implements Function2<AntiFakeResetResp, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AntiFakeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AntiFakeViewModel$connectBluetoothAndResetFilter$3(AntiFakeViewModel antiFakeViewModel, Continuation<? super AntiFakeViewModel$connectBluetoothAndResetFilter$3> continuation) {
        super(2, continuation);
        this.this$0 = antiFakeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AntiFakeViewModel$connectBluetoothAndResetFilter$3 antiFakeViewModel$connectBluetoothAndResetFilter$3 = new AntiFakeViewModel$connectBluetoothAndResetFilter$3(this.this$0, continuation);
        antiFakeViewModel$connectBluetoothAndResetFilter$3.L$0 = obj;
        return antiFakeViewModel$connectBluetoothAndResetFilter$3;
    }

    public final Object invoke(AntiFakeResetResp antiFakeResetResp, Continuation<? super Unit> continuation) {
        return ((AntiFakeViewModel$connectBluetoothAndResetFilter$3) create(antiFakeResetResp, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (r2.resetFilterByBluetooth(r2.resetFilterBluetoothCipherText, r7) == r1) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0095, code lost:
        if (r7.this$0.logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.FAIL, r7) == r1) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b8, code lost:
        if (r7.this$0.logBluetoothResetResult(com.blueair.antifake.viewmodel.BluetoothResetResult.FAIL, r7) == r1) goto L_0x00ba;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            com.blueair.api.restapi.AntiFakeResetResp r0 = (com.blueair.api.restapi.AntiFakeResetResp) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0027
            if (r2 == r5) goto L_0x001e
            if (r2 == r4) goto L_0x001e
            if (r2 != r3) goto L_0x0016
            goto L_0x001e
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            java.lang.Object r0 = r7.L$1
            com.blueair.antifake.viewmodel.ResetResult r0 = (com.blueair.antifake.viewmodel.ResetResult) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00bb
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.antifake.viewmodel.ResetResult$Companion r8 = com.blueair.antifake.viewmodel.ResetResult.Companion
            int r2 = r0.getStatus()
            com.blueair.antifake.viewmodel.ResetResult r8 = r8.fromStatusCode(r2)
            com.blueair.antifake.viewmodel.ResetResult r2 = com.blueair.antifake.viewmodel.ResetResult.SUCCESS
            java.lang.String r6 = "Fail"
            if (r8 != r2) goto L_0x0098
            java.lang.String r2 = r0.getCiphertext()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0073
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0049
            goto L_0x0073
        L_0x0049:
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            java.lang.String r3 = r0.getCiphertext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r2.resetFilterBluetoothCipherText = r3
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            java.lang.String r3 = r2.resetFilterBluetoothCipherText
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$1 = r8
            r7.label = r4
            java.lang.Object r8 = r2.resetFilterByBluetooth(r3, r5)
            if (r8 != r1) goto L_0x00bb
            goto L_0x00ba
        L_0x0073:
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            androidx.lifecycle.MutableLiveData r2 = r2._resetResult
            com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.INTERNAL_ERROR
            r2.postValue(r3)
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$1 = r8
            r7.label = r5
            java.lang.Object r8 = r2.logBluetoothResetResult(r6, r3)
            if (r8 != r1) goto L_0x00bb
            goto L_0x00ba
        L_0x0098:
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            androidx.lifecycle.MutableLiveData r2 = r2._resetResult
            r2.postValue(r8)
            com.blueair.antifake.viewmodel.AntiFakeViewModel r2 = r7.this$0
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$1 = r8
            r7.label = r3
            java.lang.Object r8 = r2.logBluetoothResetResult(r6, r4)
            if (r8 != r1) goto L_0x00bb
        L_0x00ba:
            return r1
        L_0x00bb:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.viewmodel.AntiFakeViewModel$connectBluetoothAndResetFilter$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
