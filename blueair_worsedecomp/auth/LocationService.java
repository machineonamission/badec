package com.blueair.auth;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.auth.retrofit.RegionApi;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.DeviceType;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.PhoneUtil;
import com.foobot.liblabclient.ApiClient;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 p2\u00020\u0001:\u0002opB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010O\u001a\u000209*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010P2\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u000209H\u0002J\u000e\u00104\u001a\u00020YH@¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u0004\u0018\u00010\u001aH@¢\u0006\u0002\u0010ZJ\u0010\u0010\\\u001a\u0004\u0018\u00010\u001aH@¢\u0006\u0002\u0010ZJ\u0006\u0010]\u001a\u00020YJ\u000e\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u001aJ\u0006\u0010`\u001a\u00020\u001aJ\u0006\u0010a\u001a\u000209J\u0006\u0010b\u001a\u000209J\u0010\u0010e\u001a\u00020\u001a2\b\b\u0002\u0010f\u001a\u000209J\u0010\u0010g\u001a\u00020\u001a2\b\b\u0002\u0010f\u001a\u000209J\u0006\u0010h\u001a\u00020iJ\u0010\u0010j\u001a\u0002092\b\u0010k\u001a\u0004\u0018\u00010lJ\u000e\u0010m\u001a\u0002092\u0006\u0010n\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b0\u00101R\"\u00104\u001a\u0004\u0018\u00010\u001a2\b\u00103\u001a\u0004\u0018\u00010\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001cR\u0011\u00106\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001cR\u0011\u00108\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b8\u0010:R\u0011\u0010;\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b;\u0010:R\u0011\u0010<\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0011\u0010=\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b=\u0010:R\u0011\u0010>\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0011\u0010?\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b?\u0010:R\u0011\u0010@\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b@\u0010:R\u0011\u0010A\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bA\u0010:R\u0011\u0010B\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bB\u0010:R\u0013\u0010C\u001a\u0004\u0018\u00010D8G¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bG\u0010:R\u0011\u0010H\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bH\u0010:R\u0011\u0010I\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bI\u0010:R\u0011\u0010J\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bJ\u0010:R\u0011\u0010K\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bK\u0010:R\u0011\u0010L\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bL\u0010:R\u0011\u0010M\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bM\u0010:R\u0011\u0010N\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bN\u0010:R\u000e\u0010S\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001c\"\u0004\bW\u0010XR\u0011\u0010c\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bd\u0010:¨\u0006q"}, d2 = {"Lcom/blueair/auth/LocationService;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Landroid/content/Context;Lcom/blueair/core/service/UnsecurePrefs;)V", "getContext", "()Landroid/content/Context;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "baseUrl$delegate", "cloudRegion", "getCloudRegion", "remoteConfig", "Lcom/blueair/auth/RemoteConfig;", "getRemoteConfig", "()Lcom/blueair/auth/RemoteConfig;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "restAdapter", "Lretrofit2/Retrofit;", "getRestAdapter", "()Lretrofit2/Retrofit;", "restAdapter$delegate", "regionApi", "Lcom/blueair/auth/retrofit/RegionApi;", "getRegionApi", "()Lcom/blueair/auth/retrofit/RegionApi;", "regionApi$delegate", "value", "ablRegion", "getAblRegion", "deviceRegion", "getDeviceRegion", "isInKlaviyoRegion", "", "()Z", "isInTmallRegion", "isInAlexaRegion", "isInGoogleAssistantRegion", "isInIcpRegion", "isInAwareRegion", "isInB4Region", "isInG4Region", "isInRateUsRegion", "rateUsResetTimestamp", "", "getRateUsResetTimestamp", "()Ljava/lang/Long;", "isInWarrantyRegion", "isInGoogleLoginRegion", "isInFacebookLoginRegion", "isInWeChatLoginRegion", "isInQQLoginRegion", "isInWelcomeHomeRegion", "isInG4ProtectRegion", "isInAntiFakeRegion", "getAvailability", "", "useExclude", "useUserRegion", "regionMutex", "Lkotlinx/coroutines/sync/Mutex;", "marketLink", "getMarketLink", "setMarketLink", "(Ljava/lang/String;)V", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBlueairRegion", "fetchAblRegion", "fetchRegion", "setRegion", "nuCountry", "getCountry", "isInChina", "isInDualProtectionRegion", "useProdGoogle", "getUseProdGoogle", "getGoogleClientId", "useProd", "getGoogleDeeplink", "getMapType", "Lcom/blueair/auth/LocationService$MapType;", "deviceSupportAntiFake", "device", "Lcom/blueair/core/model/Device;", "isMultiPassLink", "link", "MapType", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationService.kt */
public final class LocationService implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final String CHINA = "cn";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HONGKONG = "hk";
    public static final String JAPAN = "jp";
    public static final String KOREA = "kr";
    public static final String MALAYSIA = "my";
    public static final String PHILIPPINES = "ph";
    public static final String SINGAPORE = "sg";
    public static final String TAIWAN = "tw";
    public static final String THAILAND = "th";
    public static final String USA = "us";
    public static final String VIETNAM = "vn";
    private String ablRegion;
    private final Lazy authService$delegate;
    private final Lazy baseUrl$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda1());
    private final Context context;
    private final Lazy di$delegate;
    public String marketLink;
    private final Lazy okHttpClient$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda2());
    private final UnsecurePrefs prefs;
    private final Lazy regionApi$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda4(this));
    private final Mutex regionMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final RemoteConfig remoteConfig = new RemoteConfigImpl();
    private final Lazy restAdapter$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda3(this));

    static {
        Class<LocationService> cls = LocationService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))};
    }

    public LocationService(Context context2, UnsecurePrefs unsecurePrefs) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(unsecurePrefs, "prefs");
        this.context = context2;
        this.prefs = unsecurePrefs;
        LazyContextDIPropertyDelegateProvider closestDI = ClosestKt.closestDI(context2);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LocationService$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public final Context getContext() {
        return this.context;
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final Resources getResources() {
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return resources;
    }

    /* access modifiers changed from: private */
    public static final String baseUrl_delegate$lambda$0() {
        return AblEnvironment.INSTANCE.getBaseUrl();
    }

    private final String getBaseUrl() {
        return (String) this.baseUrl$delegate.getValue();
    }

    public final String getCloudRegion() {
        return getAuthService().getCloudUserRegion();
    }

    public final RemoteConfig getRemoteConfig() {
        return this.remoteConfig;
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$2() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        return new OkHttpClient.Builder().addInterceptor(new LocationService$$ExternalSyntheticLambda0()).addInterceptor(httpLoggingInterceptor).build();
    }

    /* access modifiers changed from: private */
    public static final Response okHttpClient_delegate$lambda$2$lambda$1(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader(ApiClient.AK_TOKEN_HEADER, AblEnvironment.INSTANCE.getApiKey()).build());
    }

    private final Retrofit getRestAdapter() {
        Object value = this.restAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Retrofit) value;
    }

    /* access modifiers changed from: private */
    public static final Retrofit restAdapter_delegate$lambda$3(LocationService locationService) {
        return new Retrofit.Builder().baseUrl(locationService.getBaseUrl()).addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).client(locationService.getOkHttpClient()).build();
    }

    private final RegionApi getRegionApi() {
        Object value = this.regionApi$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (RegionApi) value;
    }

    /* access modifiers changed from: private */
    public static final RegionApi regionApi_delegate$lambda$4(LocationService locationService) {
        return (RegionApi) locationService.getRestAdapter().create(RegionApi.class);
    }

    public final String getAblRegion() {
        return this.ablRegion;
    }

    public final String getDeviceRegion() {
        String resourceConfigCountryOrFallback = RegionUtils.INSTANCE.getResourceConfigCountryOrFallback(this.context);
        Timber.Forest forest = Timber.Forest;
        forest.v("deviceRegion: " + resourceConfigCountryOrFallback, new Object[0]);
        return resourceConfigCountryOrFallback;
    }

    public final boolean isInKlaviyoRegion() {
        return getAvailability(this.remoteConfig.getKlaviyoAvailableCountries(), false, true);
    }

    public final boolean isInTmallRegion() {
        return getAvailability$default(this, this.remoteConfig.getTmallAvailableCounties(), false, false, 3, (Object) null);
    }

    public final boolean isInAlexaRegion() {
        return getAvailability(this.remoteConfig.getAlexaUnavailableCounties(), true, true);
    }

    public final boolean isInGoogleAssistantRegion() {
        return getAvailability(this.remoteConfig.getGoogleAssistantUnavailableCountries(), true, true);
    }

    public final boolean isInIcpRegion() {
        boolean z;
        boolean booleanValue = ((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_FORCE_ICP_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
        Collection icpUnavailableCountries = this.remoteConfig.getIcpUnavailableCountries();
        if (icpUnavailableCountries == null || icpUnavailableCountries.isEmpty()) {
            z = getAvailability$default(this, this.remoteConfig.getIcpAvailableCountries(), false, false, 3, (Object) null);
        } else {
            z = getAvailability$default(this, this.remoteConfig.getIcpUnavailableCountries(), true, false, 2, (Object) null);
        }
        if (booleanValue || z) {
            return true;
        }
        return false;
    }

    public final boolean isInAwareRegion() {
        boolean z;
        boolean booleanValue = ((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_FORCE_AWARE_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
        Collection awareUnavailableCountries = this.remoteConfig.getAwareUnavailableCountries();
        if (awareUnavailableCountries == null || awareUnavailableCountries.isEmpty()) {
            z = getAvailability$default(this, this.remoteConfig.getAwareAvailableCountries(), false, false, 3, (Object) null);
        } else {
            z = getAvailability$default(this, this.remoteConfig.getAwareUnavailableCountries(), true, false, 2, (Object) null);
        }
        if (booleanValue || z) {
            return true;
        }
        return false;
    }

    public final boolean isInB4Region() {
        if (((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_FORCE_B4_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
            return true;
        }
        if (getAvailability$default(this, this.remoteConfig.getB4AvailableCounties(), false, false, 3, (Object) null)) {
            return true;
        }
        return false;
    }

    public final boolean isInG4Region() {
        if (((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_FORCE_G4_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
            return true;
        }
        if (getAvailability$default(this, this.remoteConfig.getG4AvailableCounties(), false, false, 3, (Object) null)) {
            return true;
        }
        return false;
    }

    public final boolean isInRateUsRegion() {
        return getAvailability$default(this, this.remoteConfig.getRateUsCountries(), false, false, 3, (Object) null);
    }

    public final Long getRateUsResetTimestamp() {
        Map<String, Long> rateUsPromo = this.remoteConfig.getRateUsPromo();
        if (rateUsPromo == null) {
            return null;
        }
        String lowerCase = getCountry().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return rateUsPromo.get(lowerCase);
    }

    public final boolean isInWarrantyRegion() {
        return getAvailability$default(this, this.remoteConfig.getWarrantyCountries(), false, false, 3, (Object) null);
    }

    public final boolean isInGoogleLoginRegion() {
        return getAvailability$default(this, this.remoteConfig.getGoogleLoginCountries(), false, false, 3, (Object) null);
    }

    public final boolean isInFacebookLoginRegion() {
        return getAvailability$default(this, this.remoteConfig.getFacebookLoginCountries(), false, false, 3, (Object) null);
    }

    public final boolean isInWeChatLoginRegion() {
        return getAvailability$default(this, this.remoteConfig.getWeChatLoginCountries(), false, false, 3, (Object) null);
    }

    public final boolean isInQQLoginRegion() {
        return getAvailability$default(this, this.remoteConfig.getQqLoginCountries(), false, false, 3, (Object) null);
    }

    public final boolean isInWelcomeHomeRegion() {
        if (((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_FORCE_WELCOME_HOME, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
            return true;
        }
        if (getAvailability$default(this, this.remoteConfig.getWelcomeHomeCountries(), false, false, 3, (Object) null)) {
            return true;
        }
        return false;
    }

    public final boolean isInG4ProtectRegion() {
        boolean availability$default = getAvailability$default(this, this.remoteConfig.getG4ProtectCountries(), false, false, 3, (Object) null);
        DeviceType.Companion.setInG4ProtectRegion(availability$default);
        return availability$default;
    }

    public final boolean isInAntiFakeRegion() {
        return BuildEnvironment.INSTANCE.isChina();
    }

    static /* synthetic */ boolean getAvailability$default(LocationService locationService, Set set, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return locationService.getAvailability(set, z, z2);
    }

    private final boolean getAvailability(Set<String> set, boolean z, boolean z2) {
        String cloudUserRegion = z2 ? getAuthService().getCloudUserRegion() : getDeviceRegion();
        if (z) {
            if (set != null) {
                return set.isEmpty() || !set.contains(cloudUserRegion);
            }
            return false;
        } else if (set != null) {
            return !set.isEmpty() && set.contains(cloudUserRegion);
        } else {
            return true;
        }
    }

    public final String getMarketLink() {
        String str = this.marketLink;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("marketLink");
        return null;
    }

    public final void setMarketLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marketLink = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[Catch:{ all -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ablRegion(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.blueair.auth.LocationService$ablRegion$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.auth.LocationService$ablRegion$1 r0 = (com.blueair.auth.LocationService$ablRegion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.LocationService$ablRegion$1 r0 = new com.blueair.auth.LocationService$ablRegion$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0050
            if (r2 == r5) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$1
            com.blueair.auth.LocationService r1 = (com.blueair.auth.LocationService) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0087
        L_0x003b:
            r9 = move-exception
            goto L_0x0097
        L_0x003d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0045:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            goto L_0x0063
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.regionMutex
            r0.L$0 = r9
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r9.lock(r6, r0)
            if (r2 != r1) goto L_0x0062
            goto L_0x0082
        L_0x0062:
            r2 = r3
        L_0x0063:
            java.lang.String r5 = r8.ablRegion     // Catch:{ all -> 0x0093 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x0093 }
            if (r5 == 0) goto L_0x0072
            int r5 = r5.length()     // Catch:{ all -> 0x0093 }
            if (r5 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r0 = r9
            goto L_0x008b
        L_0x0072:
            r0.L$0 = r9     // Catch:{ all -> 0x0093 }
            r0.L$1 = r8     // Catch:{ all -> 0x0093 }
            r0.I$0 = r2     // Catch:{ all -> 0x0093 }
            r0.I$1 = r3     // Catch:{ all -> 0x0093 }
            r0.label = r4     // Catch:{ all -> 0x0093 }
            java.lang.Object r0 = r8.fetchAblRegion(r0)     // Catch:{ all -> 0x0093 }
            if (r0 != r1) goto L_0x0083
        L_0x0082:
            return r1
        L_0x0083:
            r1 = r0
            r0 = r9
            r9 = r1
            r1 = r8
        L_0x0087:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x003b }
            r1.ablRegion = r9     // Catch:{ all -> 0x003b }
        L_0x008b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003b }
            r0.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0093:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x0097:
            r0.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.LocationService.ablRegion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchBlueairRegion(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.auth.LocationService$fetchBlueairRegion$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.auth.LocationService$fetchBlueairRegion$1 r0 = (com.blueair.auth.LocationService$fetchBlueairRegion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.LocationService$fetchBlueairRegion$1 r0 = new com.blueair.auth.LocationService$fetchBlueairRegion$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.auth.LocationService$fetchBlueairRegion$response$1 r6 = new com.blueair.auth.LocationService$fetchBlueairRegion$response$1
            com.blueair.auth.retrofit.RegionApi r2 = r5.getRegionApi()
            r6.<init>(r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.label = r3
            java.lang.Object r6 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r6, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "fetchBlueairRegion: response = "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            boolean r0 = r6.isSuccess()
            r1 = 0
            if (r0 == 0) goto L_0x0083
            java.lang.Object r6 = r6.getOrNull()
            com.blueair.auth.retrofit.BlueairRegion r6 = (com.blueair.auth.retrofit.BlueairRegion) r6
            if (r6 == 0) goto L_0x0082
            java.lang.String r6 = r6.getCountryCode()
            if (r6 == 0) goto L_0x0082
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        L_0x0082:
            return r1
        L_0x0083:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "fetchBlueairRegion: failed with exception = "
            r3.<init>(r4)
            java.lang.Throwable r6 = r6.exceptionOrNull()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.w(r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.LocationService.fetchBlueairRegion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAblRegion(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.auth.LocationService$fetchAblRegion$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.auth.LocationService$fetchAblRegion$1 r0 = (com.blueair.auth.LocationService$fetchAblRegion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.LocationService$fetchAblRegion$1 r0 = new com.blueair.auth.LocationService$fetchAblRegion$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.auth.LocationService$fetchAblRegion$response$1 r6 = new com.blueair.auth.LocationService$fetchAblRegion$response$1
            com.blueair.auth.retrofit.RegionApi r2 = r5.getRegionApi()
            r6.<init>(r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.label = r3
            java.lang.Object r6 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r6, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "fetchRegionSync: response = "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            boolean r0 = r6.isSuccess()
            r1 = 0
            if (r0 == 0) goto L_0x008f
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "fetchRegionSync: response.body = "
            r3.<init>(r4)
            java.lang.Object r4 = r6.getOrNull()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.d(r3, r2)
            java.lang.Object r6 = r6.getOrNull()
            com.blueair.auth.retrofit.AblRegion r6 = (com.blueair.auth.retrofit.AblRegion) r6
            if (r6 == 0) goto L_0x008e
            java.lang.String r6 = r6.getRegion()
            return r6
        L_0x008e:
            return r1
        L_0x008f:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "fetchRegionSync: failed with exception = "
            r3.<init>(r4)
            java.lang.Throwable r6 = r6.exceptionOrNull()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.w(r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.LocationService.fetchAblRegion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void fetchRegion() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new LocationService$fetchRegion$1(this, (Continuation<? super LocationService$fetchRegion$1>) null), 3, (Object) null);
    }

    public final void setRegion(String str) {
        Intrinsics.checkNotNullParameter(str, "nuCountry");
        Timber.Forest forest = Timber.Forest;
        forest.v("setRegion: " + str, new Object[0]);
        PreferencesHelper.INSTANCE.set(this.prefs.getBackend(), PrefKeys.RegionCountry, str, Reflection.getOrCreateKotlinClass(String.class));
    }

    public final String getCountry() {
        String str = (String) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.CountryCodePref, null, Reflection.getOrCreateKotlinClass(String.class));
        if (str.length() > 0) {
            Timber.Forest forest = Timber.Forest;
            forest.d("getCountry: pref country: " + str, new Object[0]);
            return str;
        }
        String str2 = (String) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.RegionCountry, null, Reflection.getOrCreateKotlinClass(String.class));
        Timber.Forest forest2 = Timber.Forest;
        forest2.v("getCountry:  stored country: " + str2, new Object[0]);
        if (str2.length() > 0) {
            return str2;
        }
        String backupCountryCascading = RegionUtils.INSTANCE.getBackupCountryCascading(this.context);
        Timber.Forest forest3 = Timber.Forest;
        forest3.v("getCountry(): from backup cascading " + backupCountryCascading, new Object[0]);
        return backupCountryCascading;
    }

    public final boolean isInChina() {
        String country = getCountry();
        Timber.Forest forest = Timber.Forest;
        forest.v("isInChina(): " + country, new Object[0]);
        return StringsKt.equals(country, "cn", true);
    }

    public final boolean isInDualProtectionRegion() {
        String country = getCountry();
        int hashCode = country.hashCode();
        return hashCode != 3331 ? hashCode != 3398 ? hashCode != 3431 ? hashCode != 3500 ? hashCode != 3576 ? hashCode != 3668 ? hashCode != 3700 ? hashCode != 3715 ? hashCode != 3742 ? hashCode == 3768 && country.equals(VIETNAM) : country.equals("us") : country.equals(TAIWAN) : country.equals(THAILAND) : country.equals(SINGAPORE) : country.equals("ph") : country.equals(MALAYSIA) : country.equals("kr") : country.equals(JAPAN) : country.equals(HONGKONG);
    }

    public final boolean getUseProdGoogle() {
        return ((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.KEY_GOOGLE_LIVE, true, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public static /* synthetic */ String getGoogleClientId$default(LocationService locationService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = locationService.getUseProdGoogle();
        }
        return locationService.getGoogleClientId(z);
    }

    public final String getGoogleClientId(boolean z) {
        if (z) {
            return this.remoteConfig.getGoogleAssistantClientId();
        }
        return this.remoteConfig.getGoogleAssistantClientIdDev();
    }

    public static /* synthetic */ String getGoogleDeeplink$default(LocationService locationService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = locationService.getUseProdGoogle();
        }
        return locationService.getGoogleDeeplink(z);
    }

    public final String getGoogleDeeplink(boolean z) {
        if (z) {
            return this.remoteConfig.getGoogleAssistantDeeplink();
        }
        return this.remoteConfig.getGoogleAssistantDeeplinkDev();
    }

    public final MapType getMapType() {
        if (BuildEnvironment.INSTANCE.isChina()) {
            return MapType.AMAP;
        }
        return PhoneUtil.INSTANCE.isGoogleServicesAvailable(this.context) ? MapType.GOOGLE : MapType.MAPBOX;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r2 = ((com.blueair.core.model.HasSKU) r2).getSku();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean deviceSupportAntiFake(com.blueair.core.model.Device r2) {
        /*
            r1 = this;
            com.blueair.core.BuildEnvironment r0 = com.blueair.core.BuildEnvironment.INSTANCE
            boolean r0 = r0.isChina()
            if (r0 == 0) goto L_0x0022
            boolean r0 = r2 instanceof com.blueair.core.model.HasSKU
            if (r0 == 0) goto L_0x0022
            com.blueair.core.model.HasSKU r2 = (com.blueair.core.model.HasSKU) r2
            java.lang.String r2 = r2.getSku()
            if (r2 == 0) goto L_0x0022
            com.blueair.auth.RemoteConfig r0 = r1.remoteConfig
            java.util.Set r0 = r0.getAntiFakeSupportedDeviceSku()
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x0022
            r2 = 1
            return r2
        L_0x0022:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.LocationService.deviceSupportAntiFake(com.blueair.core.model.Device):boolean");
    }

    public final boolean isMultiPassLink(String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        for (String replace$default : this.remoteConfig.getMultiPassRules()) {
            if (new Regex(StringsKt.replace$default(replace$default, "\\\\", "\\", false, 4, (Object) null)).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/auth/LocationService$MapType;", "", "<init>", "(Ljava/lang/String;I)V", "GOOGLE", "MAPBOX", "AMAP", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationService.kt */
    public enum MapType {
        GOOGLE,
        MAPBOX,
        AMAP;

        public static EnumEntries<MapType> getEntries() {
            return $ENTRIES;
        }

        static {
            MapType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/auth/LocationService$Companion;", "", "<init>", "()V", "CHINA", "", "KOREA", "USA", "PHILIPPINES", "THAILAND", "VIETNAM", "JAPAN", "TAIWAN", "HONGKONG", "MALAYSIA", "SINGAPORE", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
