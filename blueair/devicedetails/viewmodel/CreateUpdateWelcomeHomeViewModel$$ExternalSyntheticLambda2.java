package com.blueair.devicedetails.viewmodel;

import android.location.Geocoder;
import java.util.List;
import kotlin.jvm.functions.Function0;

// $FF: synthetic class
public final class CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2 implements Geocoder.GeocodeListener {
   public final CreateUpdateWelcomeHomeViewModel f$0;
   public final double f$1;
   public final double f$2;
   public final Function0 f$3;

   // $FF: synthetic method
   public CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2(CreateUpdateWelcomeHomeViewModel var1, double var2, double var4, Function0 var6) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var4;
      this.f$3 = var6;
   }

   public final void onGeocode(List var1) {
      CreateUpdateWelcomeHomeViewModel.$r8$lambda$WDCfzqWFfdnf_CdrT2Ahx3tEkdE(this.f$0, this.f$1, this.f$2, this.f$3, var1);
   }
}
