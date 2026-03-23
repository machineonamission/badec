package com.blueair.api;

import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.Info;
import com.blueair.core.model.OnboardingError;
import com.blueair.core.model.OnboardingState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/blueair/api/MockingUtils;", "", "<init>", "()V", "onboardingEvents", "", "Lcom/blueair/core/model/DeviceEvent;", "iteration", "", "onboardingError", "Lcom/blueair/core/model/OnboardingError;", "onboardingEvent", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MockingUtils.kt */
public final class MockingUtils {
    public static final MockingUtils INSTANCE = new MockingUtils();

    private MockingUtils() {
    }

    public static /* synthetic */ List onboardingEvents$default(MockingUtils mockingUtils, int i, OnboardingError onboardingError, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            onboardingError = null;
        }
        return mockingUtils.onboardingEvents(i, onboardingError);
    }

    public final List<DeviceEvent> onboardingEvents(int i, OnboardingError onboardingError) {
        List<DeviceEvent> arrayList = new ArrayList<>();
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                arrayList.add(onboardingEvent(i2, onboardingError));
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ DeviceEvent onboardingEvent$default(MockingUtils mockingUtils, int i, OnboardingError onboardingError, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            onboardingError = null;
        }
        return mockingUtils.onboardingEvent(i, onboardingError);
    }

    public final DeviceEvent onboardingEvent(int i, OnboardingError onboardingError) {
        Pair pair;
        int i2 = i;
        OnboardingError onboardingError2 = onboardingError;
        DeviceEvent deviceEvent = new DeviceEvent("id", System.currentTimeMillis(), "origin", "message", 0, "", "DeviceBound", "", "", (Info) null, 512, (DefaultConstructorMarker) null);
        if (i2 >= Reflection.getOrCreateKotlinClass(OnboardingState.class).getSealedSubclasses().size()) {
            return deviceEvent;
        }
        Iterable<KClass> sealedSubclasses = Reflection.getOrCreateKotlinClass(OnboardingState.class).getSealedSubclasses();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sealedSubclasses, 10));
        for (KClass objectInstance : sealedSubclasses) {
            Object objectInstance2 = objectInstance.getObjectInstance();
            Intrinsics.checkNotNull(objectInstance2, "null cannot be cast to non-null type com.blueair.core.model.OnboardingState");
            arrayList.add((OnboardingState) objectInstance2);
        }
        OnboardingState onboardingState = (OnboardingState) ((List) arrayList).get(i2);
        if (i2 < 2 || onboardingError2 == null) {
            return DeviceEvent.copy$default(deviceEvent, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, onboardingState.getName(), (Info) null, 767, (Object) null);
        }
        if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.JwtError.INSTANCE)) {
            pair = new Pair(OnboardingState.LinkConnect.INSTANCE, -4);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.PasswordError.INSTANCE)) {
            pair = new Pair(OnboardingState.LinkConnect.INSTANCE, -3);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.RouterError.INSTANCE)) {
            pair = new Pair(OnboardingState.ObtainingIPAddress.INSTANCE, -1);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.SignalError.INSTANCE)) {
            pair = new Pair(OnboardingState.LinkReconnect.INSTANCE, -1);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.DeviceOrServerError.INSTANCE)) {
            pair = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -1);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.HoldingError.INSTANCE)) {
            pair = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -5);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.UnknownError.INSTANCE)) {
            pair = new Pair(OnboardingState.LinkReconnect.INSTANCE, -10);
        } else if (Intrinsics.areEqual((Object) onboardingError2, (Object) OnboardingError.InternetError.INSTANCE)) {
            pair = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -99);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return DeviceEvent.copy$default(deviceEvent, (String) null, 0, (String) null, (String) null, ((Number) pair.component2()).intValue(), (String) null, (String) null, (String) null, ((OnboardingState) pair.component1()).getName(), (Info) null, 751, (Object) null);
    }
}
