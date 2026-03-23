package com.blueair.antifake.activity;

import com.king.camera.scan.AnalyzeResult;
import com.king.camera.scan.CameraScan;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScanActivity$$ExternalSyntheticLambda0 implements CameraScan.OnScanResultCallback {
    public final /* synthetic */ ScanActivity f$0;

    public /* synthetic */ ScanActivity$$ExternalSyntheticLambda0(ScanActivity scanActivity) {
        this.f$0 = scanActivity;
    }

    public final void onScanResultCallback(AnalyzeResult analyzeResult) {
        ScanActivity.onCreate$lambda$1(this.f$0, analyzeResult);
    }

    public /* synthetic */ void onScanResultFailure() {
        CameraScan.OnScanResultCallback.CC.$default$onScanResultFailure(this);
    }
}
