package com.blueair.android.viewmodel;

import com.blueair.core.model.HasSensorData;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Map f$0;
    public final /* synthetic */ HomeViewModel f$1;

    public /* synthetic */ HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda1(Map map, HomeViewModel homeViewModel) {
        this.f$0 = map;
        this.f$1 = homeViewModel;
    }

    public final Object invoke(Object obj) {
        return HomeViewModel$flowDevicesRating$1.invokeSuspend$lambda$2(this.f$0, this.f$1, (HasSensorData) obj);
    }
}
