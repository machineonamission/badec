package com.blueair.antifake.activity;

import com.king.camera.scan.AnalyzeResult;
import com.king.camera.scan.CameraScan;
import com.king.camera.scan.CameraScan.OnScanResultCallback._CC;

// $FF: synthetic class
public final class ScanActivity$$ExternalSyntheticLambda0 implements CameraScan.OnScanResultCallback {
   public final ScanActivity f$0;

   // $FF: synthetic method
   public ScanActivity$$ExternalSyntheticLambda0(ScanActivity var1) {
      this.f$0 = var1;
   }

   public final void onScanResultCallback(AnalyzeResult var1) {
      ScanActivity.$r8$lambda$UrmyKYW5mSYZaz_DtQ8R7woTjoE(this.f$0, var1);
   }

   // $FF: synthetic method
   public void onScanResultFailure() {
      _CC.$default$onScanResultFailure(this);
   }
}
