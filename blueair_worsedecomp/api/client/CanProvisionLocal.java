package com.blueair.api.client;

import com.blueair.api.model.ProvisionRequestBody;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ssid;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\tH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\t2\u0006\u0010\u0011\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u001b\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CanProvisionLocal;", "Lcom/blueair/api/client/CanProvision;", "deviceJwt", "", "getDeviceJwt", "()Ljava/lang/String;", "setDeviceJwt", "(Ljava/lang/String;)V", "getUuid", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/DeviceUuid;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSsids", "", "Lcom/blueair/core/model/Ssid;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "body", "Lcom/blueair/api/client/ProvisionBody;", "(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingEvents", "Lcom/blueair/core/model/DeviceEvent;", "Lcom/blueair/api/client/OnboardingEventsBody;", "(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "", "resetDevice", "ipInfo", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public interface CanProvisionLocal extends CanProvision {
    String getDeviceJwt();

    Object getOnboardingEvents(OnboardingEventsBody onboardingEventsBody, Continuation<? super ApiResult<List<DeviceEvent>>> continuation);

    Object getSsids(Continuation<? super ApiResult<List<Ssid>>> continuation);

    Object getUuid(Continuation<? super ApiResult<DeviceUuid>> continuation);

    Object provisionDevice(ProvisionBody provisionBody, Continuation<? super ApiResult<ProvisionRequestBody>> continuation);

    Object resetDevice(DeviceUuid deviceUuid, Continuation<? super ApiResult<String>> continuation);

    void setDeviceJwt(String str);

    Object switchOffSoftAp(Continuation<? super ApiResult<Object>> continuation);
}
