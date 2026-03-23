package com.blueair.bluetooth.service;

import com.blueair.core.model.Ssid;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$wifiScanSync$2$1 implements Function1<List<? extends Ssid>, Unit> {
    final /* synthetic */ Continuation<List<Ssid>> $cont;

    BleDeviceService$wifiScanSync$2$1(Continuation<? super List<Ssid>> continuation) {
        this.$cont = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Ssid>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Ssid> list) {
        Intrinsics.checkNotNullParameter(list, "ssidList");
        Timber.Forest forest = Timber.Forest;
        forest.d("wifiScanSync: ssidList = " + list, new Object[0]);
        Continuation<List<Ssid>> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(list));
    }
}
