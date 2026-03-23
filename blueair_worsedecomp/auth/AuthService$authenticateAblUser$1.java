package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService", f = "AuthService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14}, l = {561, 563, 564, 572, 574, 580, 581, 590, 596, 597, 612, 613, 614, 617, 618}, m = "authenticateAblUser", n = {"nuUsername", "gigyaUid", "nuUsername", "gigyaUid", "ablJwt", "nuUsername", "gigyaUid", "ablJwt", "nuUsername", "gigyaUid", "ablJwt", "expires", "nuUsername", "gigyaUid", "ablJwt", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "extUid", "userAttr", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "extUid", "userAttr", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "extUid", "userAttr", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "extUid", "expires", "nuUsername", "gigyaUid", "ablJwt", "userResponse", "user", "extUidResponse", "extUid", "expires"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0"})
/* compiled from: AuthService.kt */
final class AuthService$authenticateAblUser$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$authenticateAblUser$1(AuthService authService, Continuation<? super AuthService$authenticateAblUser$1> continuation) {
        super(continuation);
        this.this$0 = authService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.authenticateAblUser((String) null, (String) null, this);
    }
}
