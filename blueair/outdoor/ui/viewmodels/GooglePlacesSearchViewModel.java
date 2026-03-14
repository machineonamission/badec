package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import android.content.Context;
import android.text.style.CharacterStyle;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.activity.GoogleMapsActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000fH\u0016J5\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J&\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/blueair/outdoor/ui/viewmodels/GooglePlacesSearchViewModel;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "placesClient", "Lcom/google/android/libraries/places/api/net/PlacesClient;", "token", "Lcom/google/android/libraries/places/api/model/AutocompleteSessionToken;", "results", "", "Lcom/google/android/libraries/places/api/model/AutocompletePrediction;", "query", "", "", "getPlace", "place", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "completion", "Lkotlin/Function1;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "Lkotlin/ParameterName;", "name", "onItemSelected", "position", "", "getCoordinate", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "dy", "", "dx", "getRectBoundsFromPoint", "Lcom/google/android/libraries/places/api/model/RectangularBounds;", "range", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GooglePlacesSearchViewModel extends SearchViewModel {
   private final PlacesClient placesClient;
   private List results;
   private final AutocompleteSessionToken token;

   // $FF: synthetic method
   public static void $r8$lambda$4Sp1b59SetXqDstEHZRGQMY7Hh8(Exception var0) {
      query$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$C3hLKzxHtV0XEhafrTAh3VF0q1Y(GooglePlacesSearchViewModel var0, FindAutocompletePredictionsResponse var1) {
      return query$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CBK86Lgi_WEZavtTJjb3btXAZQk/* $FF was: $r8$lambda$CBK86Lgi-WEZavtTJjb3btXAZQk*/(Function1 var0, Exception var1) {
      getPlace$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$G4IgMI82hseTLBpJc9Ws8vek61M(Function1 var0, Object var1) {
      getPlace$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$LXH891j914eLyOuRtxXxwXkgE2g(Function1 var0, Object var1) {
      query$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YXTuy2txR8bEWiHAJv9tpLakN3U() {
      query$lambda$3();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$apIO3bJ4ZM53KGZt3sNWv5flvnk(Function1 var0, CustomPlace var1) {
      return onItemSelected$lambda$12$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rmt_r_ETJHP5RCE4bZenC_wHayc/* $FF was: $r8$lambda$rmt-r-ETJHP5RCE4bZenC-wHayc*/(Function1 var0, SearchItemContainer var1, FetchPlaceResponse var2) {
      return getPlace$lambda$8(var0, var1, var2);
   }

   public GooglePlacesSearchViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.results = CollectionsKt.emptyList();
      if (!Places.isInitialized()) {
         Places.initialize((Context)var1, var1.getString(R.string.places_maps_api_key), Locale.getDefault());
      }

      PlacesClient var2 = Places.createClient((Context)var1);
      Intrinsics.checkNotNullExpressionValue(var2, "createClient(...)");
      this.placesClient = var2;
      AutocompleteSessionToken var3 = AutocompleteSessionToken.newInstance();
      Intrinsics.checkNotNullExpressionValue(var3, "newInstance(...)");
      this.token = var3;
   }

   private final LatLng getCoordinate(LatLng var1, long var2, long var4) {
      double var6 = var1.latitude;
      long var8 = (long)6378137;
      var6 += (double)(var2 / var8) * (180D / Math.PI);
      return new LatLng(var6, var1.longitude + (double)(var4 / var8) * (180D / Math.PI) / Math.cos(var6));
   }

   private final void getPlace(SearchItemContainer var1, Function1 var2) {
      FetchPlaceRequest var3 = FetchPlaceRequest.newInstance(var1.getId(), GoogleMapsActivity.Companion.getPLACES_DATA_FIELDS());
      this.placesClient.fetchPlace(var3).addOnSuccessListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda1(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda0(var2, var1))).addOnFailureListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda2(var2));
   }

   private static final void getPlace$lambda$10(Function1 var0, Exception var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.invoke((Object)null);
   }

   private static final Unit getPlace$lambda$8(Function1 var0, SearchItemContainer var1, FetchPlaceResponse var2) {
      Intrinsics.checkNotNullParameter(var2, "response");
      LatLng var3 = var2.getPlace().getLatLng();
      if (var3 != null) {
         var0.invoke(new CustomPlace(var3.latitude, var3.longitude, var1.getPrimaryText(), (String)null, 8, (DefaultConstructorMarker)null));
      } else {
         var0.invoke((Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final void getPlace$lambda$9(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final RectangularBounds getRectBoundsFromPoint(LatLng var1, long var2) {
      long var4 = -var2;
      RectangularBounds var6 = RectangularBounds.newInstance(this.getCoordinate(var1, var4, var4), this.getCoordinate(var1, var2, var2));
      Intrinsics.checkNotNullExpressionValue(var6, "newInstance(...)");
      return var6;
   }

   private static final Unit onItemSelected$lambda$12$lambda$11(Function1 var0, CustomPlace var1) {
      var0.invoke(var1);
      return Unit.INSTANCE;
   }

   private static final void query$lambda$3() {
      Timber.Forest.d("PlacesSearchContainer addOnCanceledListener", new Object[0]);
   }

   private static final void query$lambda$4(Exception var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Timber.Forest.d("PlacesSearchContainer addOnFailureListener", new Object[0]);
   }

   private static final Unit query$lambda$6(GooglePlacesSearchViewModel var0, FindAutocompletePredictionsResponse var1) {
      List var8 = var1.getAutocompletePredictions();
      Intrinsics.checkNotNullExpressionValue(var8, "getAutocompletePredictions(...)");
      var0.results = var8;
      MutableLiveData var9 = var0.getSearchItems();
      Iterable var2 = (Iterable)var0.results;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));

      for(AutocompletePrediction var5 : var2) {
         String var11 = var5.getPrimaryText((CharacterStyle)null).toString();
         Intrinsics.checkNotNullExpressionValue(var11, "toString(...)");
         String var3 = var5.getSecondaryText((CharacterStyle)null).toString();
         Intrinsics.checkNotNullExpressionValue(var3, "toString(...)");
         String var12 = var5.getPlaceId();
         Intrinsics.checkNotNullExpressionValue(var12, "getPlaceId(...)");
         var6.add(new SearchItemContainer(var11, var3, var12));
      }

      var9.setValue((List)var6);
      Timber.Forest var10 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("PlacesSearchContainer addOnSuccessListener ");
      var7.append(Thread.currentThread());
      var10.d(var7.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void query$lambda$7(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   public void onItemSelected(int var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var2, "completion");
      SearchItemContainer var3 = this.get(var1);
      if (var3 != null) {
         this.getPlace(var3, new GooglePlacesSearchViewModel$$ExternalSyntheticLambda7(var2));
      }

   }

   public void query(String var1) {
      Intrinsics.checkNotNullParameter(var1, "query");
      FindAutocompletePredictionsRequest.Builder var2 = FindAutocompletePredictionsRequest.builder();
      var2.setSessionToken(this.token);
      var2.setQuery(var1);
      TrackedLocation var4 = (TrackedLocation)this.getCurrentLocation().getValue();
      if (var4 != null) {
         Pair var5 = var4.getLatLngInGCJ();
         LatLng var6 = new LatLng(((Number)var5.getFirst()).doubleValue(), ((Number)var5.getSecond()).doubleValue());
         var2.setOrigin(var6);
         var2.setLocationBias((LocationBias)this.getRectBoundsFromPoint(var6, 50000L));
      }

      FindAutocompletePredictionsRequest var7 = var2.build();
      Task var9 = this.placesClient.findAutocompletePredictions(var7);
      Timber.Forest var8 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("Thread? ");
      var3.append(Thread.currentThread());
      var8.d(var3.toString(), new Object[0]);
      var9.addOnCanceledListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda3());
      var9.addOnFailureListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda4());
      var9.addOnSuccessListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda6(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda5(this)));
   }
}
