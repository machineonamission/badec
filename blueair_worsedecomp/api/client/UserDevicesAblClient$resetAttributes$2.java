package com.blueair.api.client;

import com.blueair.api.restapi.UserDevicesAblRestApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
final /* synthetic */ class UserDevicesAblClient$resetAttributes$2 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Response<Object>>, Object>, SuspendFunction {
    UserDevicesAblClient$resetAttributes$2(Object obj) {
        super(2, obj, UserDevicesAblRestApi.class, "resetAttributes", "resetAttributes(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Response<Object>> continuation) {
        return ((UserDevicesAblRestApi) this.receiver).resetAttributes(str, continuation);
    }
}
