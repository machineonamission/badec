package com.blueair.adddevice.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$8", f = "FinalizeDialog.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"index"}, s = {"I$0"})
/* compiled from: FinalizeDialog.kt */
final class FinalizeDialog$onCreateView$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String[] $texts;
    int I$0;
    int label;
    final /* synthetic */ FinalizeDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinalizeDialog$onCreateView$8(FinalizeDialog finalizeDialog, String[] strArr, Continuation<? super FinalizeDialog$onCreateView$8> continuation) {
        super(2, continuation);
        this.this$0 = finalizeDialog;
        this.$texts = strArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinalizeDialog$onCreateView$8(this.this$0, this.$texts, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FinalizeDialog$onCreateView$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001a
            if (r1 != r3) goto L_0x0012
            int r1 = r6.I$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003b
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x001d:
            r1 = r2
        L_0x001e:
            com.blueair.adddevice.dialog.FinalizeDialog r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.pageIndex
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r7.postValue(r4)
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.I$0 = r1
            r6.label = r3
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L_0x003b
            return r0
        L_0x003b:
            int r1 = r1 + r3
            java.lang.String[] r7 = r6.$texts
            int r4 = r7.length
            if (r1 < r4) goto L_0x001e
            int r7 = r7.length
            if (r7 <= r3) goto L_0x001d
            r1 = r3
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.dialog.FinalizeDialog$onCreateView$8.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
