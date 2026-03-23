package com.blueair.android.viewmodel;

import com.blueair.android.viewmodel.LinkingState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.AccountLinkingViewModel$startLinking$1", f = "AccountLinkingViewModel.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"state"}, s = {"L$0"})
/* compiled from: AccountLinkingViewModel.kt */
final class AccountLinkingViewModel$startLinking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AccountLinkingViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.android.fragment.integration.Integration[] r0 = com.blueair.android.fragment.integration.Integration.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.android.fragment.integration.Integration r1 = com.blueair.android.fragment.integration.Integration.AmazonAlexa     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.android.fragment.integration.Integration r1 = com.blueair.android.fragment.integration.Integration.GoogleAssistant     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.AccountLinkingViewModel$startLinking$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingViewModel$startLinking$1(AccountLinkingViewModel accountLinkingViewModel, Continuation<? super AccountLinkingViewModel$startLinking$1> continuation) {
        super(2, continuation);
        this.this$0 = accountLinkingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountLinkingViewModel$startLinking$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountLinkingViewModel$startLinking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkingState.UrlGot urlGot;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getAccountType().ordinal()];
            if (i2 == 1) {
                String access$generateAlexaState = this.this$0.generateAlexaState();
                this.L$0 = SpillingKt.nullOutSpilledVariable(access$generateAlexaState);
                this.label = 1;
                obj = this.this$0.getDeviceManager().getAlexaLinkingUrls(access$generateAlexaState, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 2) {
                return Unit.INSTANCE;
            } else {
                urlGot = new LinkingState.UrlGot(this.this$0.getGoogleDeeplink());
                this.this$0._state.setValue(urlGot);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            String str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        if (pair == null) {
            this.this$0._state.setValue(LinkingState.Failed.INSTANCE);
            return Unit.INSTANCE;
        }
        String str2 = (String) pair.component1();
        String str3 = (String) pair.component2();
        if (!this.this$0.doesAlexaAppSupportAppToApp()) {
            str2 = str3;
        }
        urlGot = new LinkingState.UrlGot(str2);
        this.this$0._state.setValue(urlGot);
        return Unit.INSTANCE;
    }
}
