package com.blueair.android.viewmodel;

import com.blueair.core.model.HasSensorData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: _Sequences.kt */
public final class HomeViewModel$flowDevicesRating$1$invokeSuspend$$inlined$filterIsInstance$1 implements Function1<Object, Boolean> {
    public static final HomeViewModel$flowDevicesRating$1$invokeSuspend$$inlined$filterIsInstance$1 INSTANCE = new HomeViewModel$flowDevicesRating$1$invokeSuspend$$inlined$filterIsInstance$1();

    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(obj instanceof HasSensorData);
    }
}
