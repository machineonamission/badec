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
@DebugMetadata(c = "com.blueair.android.viewmodel.AccountLinkingViewModel$unlink$1", f = "AccountLinkingViewModel.kt", i = {}, l = {206, 207}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountLinkingViewModel.kt */
final class AccountLinkingViewModel$unlink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountLinkingViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Integration.values().length];
            try {
                iArr[Integration.AmazonAlexa.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingViewModel$unlink$1(AccountLinkingViewModel accountLinkingViewModel, Continuation<? super AccountLinkingViewModel$unlink$1> continuation) {
        super(2, continuation);
        this.this$0 = accountLinkingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountLinkingViewModel$unlink$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountLinkingViewModel$unlink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
        if (r5 == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (r5 == r0) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x006d
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004e
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.android.viewmodel.AccountLinkingViewModel r5 = r4.this$0
            kotlinx.coroutines.flow.MutableStateFlow r5 = r5._state
            com.blueair.android.viewmodel.LinkingState$Loading r1 = com.blueair.android.viewmodel.LinkingState.Loading.INSTANCE
            r5.setValue(r1)
            com.blueair.android.viewmodel.AccountLinkingViewModel r5 = r4.this$0
            com.blueair.android.fragment.integration.Integration r5 = r5.getAccountType()
            int[] r1 = com.blueair.android.viewmodel.AccountLinkingViewModel$unlink$1.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r1[r5]
            if (r5 != r3) goto L_0x0055
            com.blueair.android.viewmodel.AccountLinkingViewModel r5 = r4.this$0
            com.blueair.devicemanager.DeviceManager r5 = r5.getDeviceManager()
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.unlinkAlexa(r1)
            if (r5 != r0) goto L_0x004e
            goto L_0x006c
        L_0x004e:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            goto L_0x0073
        L_0x0055:
            com.blueair.android.viewmodel.AccountLinkingViewModel r5 = r4.this$0
            com.blueair.devicemanager.DeviceManager r5 = r5.getDeviceManager()
            com.blueair.android.viewmodel.AccountLinkingViewModel r1 = r4.this$0
            java.lang.String r1 = r1.getGoogleClientId()
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = r5.unlinkGoogle(r1, r3)
            if (r5 != r0) goto L_0x006d
        L_0x006c:
            return r0
        L_0x006d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
        L_0x0073:
            com.blueair.android.viewmodel.AccountLinkingViewModel r0 = r4.this$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = r0._state
            if (r5 == 0) goto L_0x007e
            com.blueair.android.viewmodel.LinkingState$Success r5 = com.blueair.android.viewmodel.LinkingState.Success.INSTANCE
            goto L_0x0080
        L_0x007e:
            com.blueair.android.viewmodel.LinkingState$Failed r5 = com.blueair.android.viewmodel.LinkingState.Failed.INSTANCE
        L_0x0080:
            com.blueair.android.viewmodel.LinkingState r5 = (com.blueair.android.viewmodel.LinkingState) r5
            r0.setValue(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.AccountLinkingViewModel$unlink$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
