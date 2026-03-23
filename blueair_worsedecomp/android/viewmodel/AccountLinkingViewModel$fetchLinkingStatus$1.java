package com.blueair.android.viewmodel;

import com.blueair.android.fragment.integration.Integration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.AccountLinkingViewModel$fetchLinkingStatus$1", f = "AccountLinkingViewModel.kt", i = {0, 0, 1, 1}, l = {191, 197}, m = "invokeSuspend", n = {"count", "timedOut", "count", "timedOut"}, s = {"I$0", "I$1", "I$0", "I$1"})
/* compiled from: AccountLinkingViewModel.kt */
final class AccountLinkingViewModel$fetchLinkingStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $expected;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ AccountLinkingViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingViewModel$fetchLinkingStatus$1(boolean z, AccountLinkingViewModel accountLinkingViewModel, Continuation<? super AccountLinkingViewModel$fetchLinkingStatus$1> continuation) {
        super(2, continuation);
        this.$expected = z;
        this.this$0 = accountLinkingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountLinkingViewModel$fetchLinkingStatus$1(this.$expected, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountLinkingViewModel$fetchLinkingStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        if (kotlinx.coroutines.DelayKt.delay(3000, r8) == r0) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            int r1 = r8.I$1
            int r4 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0015:
            r9 = r1
            goto L_0x002c
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            int r1 = r8.I$1
            int r4 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0041
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 0
            r4 = r9
        L_0x002c:
            com.blueair.android.viewmodel.AccountLinkingViewModel r1 = r8.this$0
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.I$0 = r4
            r8.I$1 = r9
            r8.label = r3
            java.lang.Object r1 = invokeSuspend$getStatus(r1, r5)
            if (r1 != r0) goto L_0x003e
            goto L_0x0061
        L_0x003e:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x0041:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            boolean r5 = r8.$expected
            if (r9 == r5) goto L_0x0062
            int r4 = r4 + r3
            r9 = 3
            if (r4 <= r9) goto L_0x0050
            goto L_0x0063
        L_0x0050:
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.I$0 = r4
            r8.I$1 = r1
            r8.label = r2
            r5 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r9)
            if (r9 != r0) goto L_0x0015
        L_0x0061:
            return r0
        L_0x0062:
            r3 = r1
        L_0x0063:
            com.blueair.android.viewmodel.AccountLinkingViewModel r9 = r8.this$0
            kotlinx.coroutines.flow.MutableStateFlow r9 = r9._state
            if (r3 == 0) goto L_0x006e
            com.blueair.android.viewmodel.LinkingState$Failed r0 = com.blueair.android.viewmodel.LinkingState.Failed.INSTANCE
            goto L_0x0070
        L_0x006e:
            com.blueair.android.viewmodel.LinkingState$Success r0 = com.blueair.android.viewmodel.LinkingState.Success.INSTANCE
        L_0x0070:
            com.blueair.android.viewmodel.LinkingState r0 = (com.blueair.android.viewmodel.LinkingState) r0
            r9.setValue(r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.AccountLinkingViewModel$fetchLinkingStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Object invokeSuspend$getStatus(AccountLinkingViewModel accountLinkingViewModel, Continuation<? super Boolean> continuation) {
        if (accountLinkingViewModel.getAccountType() == Integration.GoogleAssistant) {
            return accountLinkingViewModel.getDeviceManager().getGoogleLinkStatus(accountLinkingViewModel.getGoogleClientId(), continuation);
        }
        return accountLinkingViewModel.getDeviceManager().getAlexaLinkStatus(continuation);
    }
}
