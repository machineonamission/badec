package com.blueair.android.viewmodel;

import android.net.Uri;
import com.blueair.android.viewmodel.LinkingState;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.blueair.android.viewmodel.AccountLinkingViewModel$startAlexaLinking$1", f = "AccountLinkingViewModel.kt", i = {0, 0, 0, 0, 0}, l = {89}, m = "invokeSuspend", n = {"clientId", "responseType", "state", "scope", "redirectUri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: AccountLinkingViewModel.kt */
final class AccountLinkingViewModel$startAlexaLinking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $accepted;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AccountLinkingViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingViewModel$startAlexaLinking$1(Uri uri, AccountLinkingViewModel accountLinkingViewModel, boolean z, Continuation<? super AccountLinkingViewModel$startAlexaLinking$1> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.this$0 = accountLinkingViewModel;
        this.$accepted = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountLinkingViewModel$startAlexaLinking$1(this.$uri, this.this$0, this.$accepted, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountLinkingViewModel$startAlexaLinking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Uri uri = this.$uri;
            if (uri == null) {
                return Unit.INSTANCE;
            }
            String queryParameter = uri.getQueryParameter("client_id");
            String str5 = queryParameter == null ? "" : queryParameter;
            String queryParameter2 = this.$uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE);
            if (queryParameter2 == null) {
                str2 = "";
            } else {
                str2 = queryParameter2;
            }
            String queryParameter3 = this.$uri.getQueryParameter("state");
            if (queryParameter3 == null) {
                str3 = "";
            } else {
                str3 = queryParameter3;
            }
            String queryParameter4 = this.$uri.getQueryParameter("scope");
            if (queryParameter4 == null) {
                str4 = "";
            } else {
                str4 = queryParameter4;
            }
            String queryParameter5 = this.$uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI);
            if (queryParameter5 == null) {
                return Unit.INSTANCE;
            }
            this.this$0.setStartFromAlexa(true);
            this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str5);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(str4);
            this.L$4 = queryParameter5;
            this.label = 1;
            obj = this.this$0.getDeviceManager().getAlexaRedirectUrl(str5, str2, str3, str4, queryParameter5, this.$accepted, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = queryParameter5;
        } else if (i == 1) {
            str = (String) this.L$4;
            String str6 = (String) this.L$3;
            String str7 = (String) this.L$2;
            String str8 = (String) this.L$1;
            String str9 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str10 = (String) obj;
        CharSequence charSequence = str10;
        if (charSequence == null || charSequence.length() == 0) {
            str10 = Uri.parse(str).buildUpon().appendQueryParameter("error", "access_denied").appendQueryParameter("state", "authorizationRequestState").appendQueryParameter("error_description", "get auth code failed").build().toString();
        }
        this.this$0.setAlexaRedirectUrlRequested(true);
        this.this$0._state.setValue(new LinkingState.UrlGot(str10));
        return Unit.INSTANCE;
    }
}
