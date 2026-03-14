package com.blueair.outdoor.ui.viewmodels;

import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class GooglePlacesSearchViewModel$$ExternalSyntheticLambda0 implements Function1 {
   public final Function1 f$0;
   public final SearchItemContainer f$1;

   // $FF: synthetic method
   public GooglePlacesSearchViewModel$$ExternalSyntheticLambda0(Function1 var1, SearchItemContainer var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return GooglePlacesSearchViewModel.$r8$lambda$rmt-r-ETJHP5RCE4bZenC-wHayc(this.f$0, this.f$1, (FetchPlaceResponse)var1);
   }
}
