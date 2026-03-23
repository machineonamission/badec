package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import com.blueair.api.client.OnboardingEventsBody;
import com.blueair.core.model.DeviceEvent;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getOnboardingEvents$2 extends FunctionReferenceImpl implements Function3<CanProvisionLocal, OnboardingEventsBody, Continuation<? super ApiResult<List<? extends DeviceEvent>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getOnboardingEvents$2 INSTANCE = new ConnectionManager$getOnboardingEvents$2();

    ConnectionManager$getOnboardingEvents$2() {
        super(3, CanProvisionLocal.class, "getOnboardingEvents", "getOnboardingEvents(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, OnboardingEventsBody onboardingEventsBody, Continuation<? super ApiResult<List<DeviceEvent>>> continuation) {
        return canProvisionLocal.getOnboardingEvents(onboardingEventsBody, continuation);
    }
}
