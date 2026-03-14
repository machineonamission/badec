package com.blueair.api.client;

import com.blueair.api.restapi.MbGeoApi;
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
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"},
   d2 = {"Lcom/blueair/api/client/MbGeoClient;", "", "<init>", "()V", "restAdapter", "Lretrofit2/Retrofit;", "getRestAdapter", "()Lretrofit2/Retrofit;", "restAdapter$delegate", "Lkotlin/Lazy;", "api", "Lcom/blueair/api/restapi/MbGeoApi;", "getApi", "()Lcom/blueair/api/restapi/MbGeoApi;", "api$delegate", "key", "", "getKey", "()Ljava/lang/String;", "key$delegate", "query", "Lretrofit2/Call;", "Lcom/blueair/core/model/MbGeoLocations;", "lngLat", "countryCode", "limit", "", "getLocations", "lat", "lon", "getLocationLang", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MbGeoClient {
   private final Lazy api$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda1(this));
   private final Lazy key$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda2());
   private final Lazy restAdapter$delegate = LazyKt.lazy(new MbGeoClient$$ExternalSyntheticLambda0());

   // $FF: synthetic method
   public static MbGeoApi $r8$lambda$2yEPB9ehkARaSsHMmq_EULx6fXA/* $FF was: $r8$lambda$2yEPB9ehkARaSsHMmq-EULx6fXA*/(MbGeoClient var0) {
      return api_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$WDyuOOBDlx2LHIup4uYixBVBaHg() {
      return key_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static Retrofit $r8$lambda$oMp_1BwGfBTmn1jMYhGfeN8hf7g() {
      return restAdapter_delegate$lambda$0();
   }

   private static final MbGeoApi api_delegate$lambda$1(MbGeoClient var0) {
      return (MbGeoApi)var0.getRestAdapter().create(MbGeoApi.class);
   }

   private final MbGeoApi getApi() {
      Object var1 = this.api$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (MbGeoApi)var1;
   }

   private final String getLocationLang() {
      Locale var1 = Locale.getDefault();
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("getLocationLang, my user's locale = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      String var4 = var1.toLanguageTag();
      Intrinsics.checkNotNullExpressionValue(var4, "toLanguageTag(...)");
      return var4;
   }

   private final Retrofit getRestAdapter() {
      Object var1 = this.restAdapter$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Retrofit)var1;
   }

   private static final String key_delegate$lambda$2() {
      return "pk.eyJ1IjoiaXZhbi1zZXJoZWl0c2V2IiwiYSI6ImNrdjJla3JjajN4aWEybnM3NHB6MjFzZTYifQ.DLzKWJTXeKIM9a_yQn1Z7w";
   }

   private static final Retrofit restAdapter_delegate$lambda$0() {
      return (new Retrofit.Builder()).baseUrl("https://api.mapbox.com/geocoding/v5/mapbox.places/").addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).build();
   }

   public final String getKey() {
      return (String)this.key$delegate.getValue();
   }

   public final Call getLocations(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "lat");
      Intrinsics.checkNotNullParameter(var2, "lon");
      String var5 = this.getLocationLang();
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("getLocations, location lang = ");
      var4.append(var5);
      var3.d(var4.toString(), new Object[0]);
      return this.getApi().getPoint(var1, var2, this.getKey(), var5);
   }

   public final Call query(String var1, String var2, String var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "query");
      Intrinsics.checkNotNullParameter(var2, "lngLat");
      Intrinsics.checkNotNullParameter(var3, "countryCode");
      return this.getApi().queryAsync(var1, this.getKey(), var2, var3, this.getLocationLang(), var4);
   }
}
