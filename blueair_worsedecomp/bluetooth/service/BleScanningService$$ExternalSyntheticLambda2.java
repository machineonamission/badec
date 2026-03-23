package com.blueair.bluetooth.service;

import com.polidea.rxandroidble2.scan.ScanResult;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleScanningService$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ BleScanningService f$0;

    public /* synthetic */ BleScanningService$$ExternalSyntheticLambda2(BleScanningService bleScanningService) {
        this.f$0 = bleScanningService;
    }

    public final Object invoke(Object obj) {
        return BleScanningService.startScanning$lambda$3(this.f$0, (ScanResult) obj);
    }
}
