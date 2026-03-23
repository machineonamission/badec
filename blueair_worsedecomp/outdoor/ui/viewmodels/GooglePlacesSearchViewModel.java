package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
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

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000fH\u0016J5\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J&\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/GooglePlacesSearchViewModel;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "placesClient", "Lcom/google/android/libraries/places/api/net/PlacesClient;", "token", "Lcom/google/android/libraries/places/api/model/AutocompleteSessionToken;", "results", "", "Lcom/google/android/libraries/places/api/model/AutocompletePrediction;", "query", "", "", "getPlace", "place", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "completion", "Lkotlin/Function1;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "Lkotlin/ParameterName;", "name", "onItemSelected", "position", "", "getCoordinate", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "dy", "", "dx", "getRectBoundsFromPoint", "Lcom/google/android/libraries/places/api/model/RectangularBounds;", "range", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GooglePlacesSearchViewModel.kt */
public final class GooglePlacesSearchViewModel extends SearchViewModel {
    private final PlacesClient placesClient;
    private List<? extends AutocompletePrediction> results = CollectionsKt.emptyList();
    private final AutocompleteSessionToken token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePlacesSearchViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        if (!Places.isInitialized()) {
            Places.initialize(application, application.getString(R.string.places_maps_api_key), Locale.getDefault());
        }
        PlacesClient createClient = Places.createClient(application);
        Intrinsics.checkNotNullExpressionValue(createClient, "createClient(...)");
        this.placesClient = createClient;
        AutocompleteSessionToken newInstance = AutocompleteSessionToken.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        this.token = newInstance;
    }

    public void query(String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        FindAutocompletePredictionsRequest.Builder builder = FindAutocompletePredictionsRequest.builder();
        builder.setSessionToken(this.token);
        builder.setQuery(str);
        TrackedLocation value = getCurrentLocation().getValue();
        if (value != null) {
            Pair<Double, Double> latLngInGCJ = value.getLatLngInGCJ();
            LatLng latLng = new LatLng(latLngInGCJ.getFirst().doubleValue(), latLngInGCJ.getSecond().doubleValue());
            builder.setOrigin(latLng);
            builder.setLocationBias(getRectBoundsFromPoint(latLng, 50000));
        }
        Task<FindAutocompletePredictionsResponse> findAutocompletePredictions = this.placesClient.findAutocompletePredictions(builder.build());
        Timber.Forest forest = Timber.Forest;
        forest.d("Thread? " + Thread.currentThread(), new Object[0]);
        findAutocompletePredictions.addOnCanceledListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda3());
        findAutocompletePredictions.addOnFailureListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda4());
        findAutocompletePredictions.addOnSuccessListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda6(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$3() {
        Timber.Forest.d("PlacesSearchContainer addOnCanceledListener", new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$4(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        Timber.Forest.d("PlacesSearchContainer addOnFailureListener", new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$7(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit query$lambda$6(GooglePlacesSearchViewModel googlePlacesSearchViewModel, FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
        List<AutocompletePrediction> autocompletePredictions = findAutocompletePredictionsResponse.getAutocompletePredictions();
        Intrinsics.checkNotNullExpressionValue(autocompletePredictions, "getAutocompletePredictions(...)");
        googlePlacesSearchViewModel.results = autocompletePredictions;
        MutableLiveData<List<SearchItemContainer>> searchItems = googlePlacesSearchViewModel.getSearchItems();
        Iterable<AutocompletePrediction> iterable = googlePlacesSearchViewModel.results;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AutocompletePrediction autocompletePrediction : iterable) {
            String spannableString = autocompletePrediction.getPrimaryText((CharacterStyle) null).toString();
            Intrinsics.checkNotNullExpressionValue(spannableString, "toString(...)");
            String spannableString2 = autocompletePrediction.getSecondaryText((CharacterStyle) null).toString();
            Intrinsics.checkNotNullExpressionValue(spannableString2, "toString(...)");
            String placeId = autocompletePrediction.getPlaceId();
            Intrinsics.checkNotNullExpressionValue(placeId, "getPlaceId(...)");
            arrayList.add(new SearchItemContainer(spannableString, spannableString2, placeId));
        }
        searchItems.setValue((List) arrayList);
        Timber.Forest forest = Timber.Forest;
        forest.d("PlacesSearchContainer addOnSuccessListener " + Thread.currentThread(), new Object[0]);
        return Unit.INSTANCE;
    }

    private final void getPlace(SearchItemContainer searchItemContainer, Function1<? super CustomPlace, Unit> function1) {
        this.placesClient.fetchPlace(FetchPlaceRequest.newInstance(searchItemContainer.getId(), GoogleMapsActivity.Companion.getPLACES_DATA_FIELDS())).addOnSuccessListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda1(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda0(function1, searchItemContainer))).addOnFailureListener(new GooglePlacesSearchViewModel$$ExternalSyntheticLambda2(function1));
    }

    /* access modifiers changed from: private */
    public static final void getPlace$lambda$9(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit getPlace$lambda$8(Function1 function1, SearchItemContainer searchItemContainer, FetchPlaceResponse fetchPlaceResponse) {
        Intrinsics.checkNotNullParameter(fetchPlaceResponse, "response");
        LatLng latLng = fetchPlaceResponse.getPlace().getLatLng();
        if (latLng != null) {
            function1.invoke(new CustomPlace(latLng.latitude, latLng.longitude, searchItemContainer.getPrimaryText(), (String) null, 8, (DefaultConstructorMarker) null));
        } else {
            function1.invoke(null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void getPlace$lambda$10(Function1 function1, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        function1.invoke(null);
    }

    public void onItemSelected(int i, Function1<? super CustomPlace, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completion");
        SearchItemContainer searchItemContainer = get(i);
        if (searchItemContainer != null) {
            getPlace(searchItemContainer, new GooglePlacesSearchViewModel$$ExternalSyntheticLambda7(function1));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onItemSelected$lambda$12$lambda$11(Function1 function1, CustomPlace customPlace) {
        function1.invoke(customPlace);
        return Unit.INSTANCE;
    }

    private final LatLng getCoordinate(LatLng latLng, long j, long j2) {
        long j3 = (long) 6378137;
        double d = latLng.latitude + (((double) (j / j3)) * 57.29577951308232d);
        return new LatLng(d, latLng.longitude + ((((double) (j2 / j3)) * 57.29577951308232d) / Math.cos(d)));
    }

    private final RectangularBounds getRectBoundsFromPoint(LatLng latLng, long j) {
        long j2 = -j;
        LatLng latLng2 = latLng;
        RectangularBounds newInstance = RectangularBounds.newInstance(getCoordinate(latLng2, j2, j2), getCoordinate(latLng2, j, j));
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }
}
