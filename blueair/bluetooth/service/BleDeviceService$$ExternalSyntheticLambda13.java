package com.blueair.bluetooth.service;

import custom.CustomCommands;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class BleDeviceService$$ExternalSyntheticLambda13 implements Function1 {
   public final BleDeviceService f$0;
   public final BleDeviceState f$1;
   public final ProvisionConfig f$2;
   public final Continuation f$3;

   // $FF: synthetic method
   public BleDeviceService$$ExternalSyntheticLambda13(BleDeviceService var1, BleDeviceState var2, ProvisionConfig var3, Continuation var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
   }

   public final Object invoke(Object var1) {
      return BleDeviceService.$r8$lambda$mlqrPyy93IJc98lb7OUPZ4XYYf8(this.f$0, this.f$1, this.f$2, this.f$3, (CustomCommands.CommandWrapper)var1);
   }
}
