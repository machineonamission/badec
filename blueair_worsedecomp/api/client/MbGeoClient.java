package com.blueair.api.client;

import com.blueair.api.restapi.MbGeoApi;
import com.blueair.core.model.MbGeoLocations;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/blueair/api/client/MbGeoClient;", "", "<init>", "()V", "restAdapter", "Lretrofit2/Retrofit;", "getRestAdapter", "()Lretrofit2/Retrofit;", "restAdapter$delegate", "Lkotlin/Lazy;", "api", "Lcom/blueair/api/restapi/MbGeoApi;", "getApi", "()Lcom/blueair/api/restapi/MbGeoApi;", "api$delegate", "key", "", "getKey", "()Ljava/lang/String;", "key$delegate", "query", "Lretrofit2/Call;", "Lcom/blueair/core/model/MbGeoLocations;", "lngLat", "countryCode", "limit", "", "getLocations", "lat", "lon", "getLocationLang", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MbGeoClient.kt */
public final class MbGeoClient {
    private final Lazy api$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda1(this));
    private final Lazy key$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda2());
    private final Lazy restAdapter$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda0());

    private final Retrofit getRestAdapter() {
        Object value = this.restAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Retrofit) value;
    }

    /* access modifiers changed from: private */
    public static final Retrofit restAdapter_delegate$lambda$0() {
        return new Retrofit.Builder().baseUrl("https://api.mapbox.com/geocoding/v5/mapbox.places/").addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).build();
    }

    private final MbGeoApi getApi() {
        Object value = this.api$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (MbGeoApi) value;
    }

    /* access modifiers changed from: private */
    public static final MbGeoApi api_delegate$lambda$1(MbGeoClient mbGeoClient) {
        return (MbGeoApi) mbGeoClient.getRestAdapter().create(MbGeoApi.class);
    }

    public final String getKey() {
        return (String) this.key$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String key_delegate$lambda$2() {
        return "pk.eyJ1IjoiaXZhbi1zZXJoZWl0c2V2IiwiYSI6ImNrdjJla3JjajN4aWEybnM3NHB6MjFzZTYifQ.DLzKWJTXeKIM9a_yQn1Z7w";
    }

    public final Call<MbGeoLocations> query(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(str2, "lngLat");
        Intrinsics.checkNotNullParameter(str3, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        return getApi().queryAsync(str, getKey(), str2, str3, getLocationLang(), i);
    }

    public final Call<MbGeoLocations> getLocations(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
        String locationLang = getLocationLang();
        Timber.Forest forest = Timber.Forest;
        forest.d("getLocations, location lang = " + locationLang, new Object[0]);
        return getApi().getPoint(str, str2, getKey(), locationLang);
    }

    private final String getLocationLang() {
        Locale locale = Locale.getDefault();
        Timber.Forest forest = Timber.Forest;
        forest.d("getLocationLang, my user's locale = " + locale, new Object[0]);
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return languageTag;
    }
}
