package com.blueair.auth;

import android.content.Context;
import android.util.Log;
import com.auth0.android.jwt.JWT;
import com.blueair.auth.BlueCloudDomain;
import com.blueair.auth.retrofit.GigyaApi;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.gigya.android.sdk.Gigya;
import com.gigya.android.sdk.GigyaDefinitions;
import com.gigya.android.sdk.GigyaLoginCallback;
import com.gigya.android.sdk.account.GigyaAccountConfig;
import com.gigya.android.sdk.api.GigyaApiResponse;
import com.gigya.android.sdk.interruption.IPendingRegistrationResolver;
import com.gigya.android.sdk.interruption.link.ILinkAccountsResolver;
import com.gigya.android.sdk.network.GigyaError;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.mapbox.common.HttpHeaders;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Ê\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\bÇ\u0001È\u0001É\u0001Ê\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010~\u001a\u00020nH\u0002J\u0011\u0010\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\"H\u0002J\u0010\u0010\u0001\u001a\u00020nH@¢\u0006\u0003\u0010\u0001J\u0010\u0010\u0001\u001a\u00020nH@¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020nH\u0016J\u0012\u0010\u0001\u001a\u0004\u0018\u00010\"H@¢\u0006\u0003\u0010\u0001J\u0010\u0010\u0001\u001a\u00020nH@¢\u0006\u0003\u0010\u0001J\u0012\u0010\u0001\u001a\u0004\u0018\u00010\"H@¢\u0006\u0003\u0010\u0001J\u0010\u0010\u0001\u001a\u00020nH@¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020n2\t\u0010\u0001\u001a\u0004\u0018\u00010\"H\u0002J\u001b\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010\"H@¢\u0006\u0003\u0010\u0001J\u001a\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\"H@¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\"J\u0012\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020%H\u0002J\u0012\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020%H\u0002J\t\u0010\u0001\u001a\u00020%H\u0002J\u0010\u0010\u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J\u0010\u0010\u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J\u0010\u0010 \u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J\u0010\u0010¡\u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J\u0010\u0010¢\u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J\u0019\u0010£\u0001\u001a\u00020u2\u0007\u0010¤\u0001\u001a\u00020\"H@¢\u0006\u0003\u0010\u0001J\"\u0010¥\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010¦\u0001\u001a\u00020\"H@¢\u0006\u0003\u0010§\u0001JS\u0010¨\u0001\u001a\u00020u2\u0007\u0010©\u0001\u001a\u00020\"2\u0007\u0010ª\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010¦\u0001\u001a\u00020\"2\t\u0010«\u0001\u001a\u0004\u0018\u00010\"2\b\u0010¬\u0001\u001a\u00030\u00012\b\u0010­\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010®\u0001J\u0019\u0010¯\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020\"H@¢\u0006\u0003\u0010\u0001J\u0010\u0010°\u0001\u001a\u00020uH@¢\u0006\u0003\u0010\u0001J#\u0010±\u0001\u001a\u00020n2\u0007\u0010²\u0001\u001a\u00020u2\b\u0010³\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010´\u0001J\u0010\u0010·\u0001\u001a\u00020nH@¢\u0006\u0003\u0010\u0001J?\u0010¸\u0001\u001a\u0003H¹\u0001\"\u0005\b\u0000\u0010¹\u00012\u0007\u0010º\u0001\u001a\u00020\"2\f\b\u0002\u0010»\u0001\u001a\u0005\u0018\u0001H¹\u00012\u000e\u0010¼\u0001\u001a\t\u0012\u0005\u0012\u0003H¹\u00010yH\b¢\u0006\u0003\u0010½\u0001J\u001c\u0010¾\u0001\u001a\u00020n2\u0007\u0010º\u0001\u001a\u00020\"2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J$\u0010¾\u0001\u001a\u00020n2\u0007\u0010º\u0001\u001a\u00020\"2\u0007\u0010Á\u0001\u001a\u00020\"2\u0007\u0010Â\u0001\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b+\u0010)R+\u0010-\u001a\u00020'2\u0006\u0010,\u001a\u00020'8F@FX\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b.\u0010)\"\u0004\b/\u00100R+\u00103\u001a\u00020'2\u0006\u0010,\u001a\u00020'8F@FX\u0002¢\u0006\u0012\n\u0004\b6\u00102\u001a\u0004\b4\u0010)\"\u0004\b5\u00100R+\u00107\u001a\u00020'2\u0006\u0010,\u001a\u00020'8B@BX\u0002¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b8\u0010)\"\u0004\b9\u00100R\u0011\u0010;\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b?\u0010=R\u001b\u0010@\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bD\u0010\u001b\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020F8BX\u0002¢\u0006\f\n\u0004\bI\u0010\u001b\u001a\u0004\bG\u0010HR!\u0010J\u001a\b\u0012\u0004\u0012\u00020\"0K8BX\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bL\u0010MR5\u0010P\u001a&\u0012\f\u0012\n R*\u0004\u0018\u00010\"0\" R*\u0012\u0012\f\u0012\n R*\u0004\u0018\u00010\"0\"\u0018\u00010Q0Q8F¢\u0006\u0006\u001a\u0004\bS\u0010TR!\u0010U\u001a\b\u0012\u0004\u0012\u00020V0K8BX\u0002¢\u0006\f\n\u0004\bX\u0010O\u001a\u0004\bW\u0010MR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0Q8F¢\u0006\u0006\u001a\u0004\bZ\u0010TR+\u0010[\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"8F@FX\u0002¢\u0006\u0012\n\u0004\b_\u00102\u001a\u0004\b\\\u0010=\"\u0004\b]\u0010^R&\u0010a\u001a\u00020\"2\u0006\u0010`\u001a\u00020\"8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010^R#\u0010d\u001a\n R*\u0004\u0018\u00010e0e8BX\u0002¢\u0006\f\n\u0004\bh\u0010\u001b\u001a\u0004\bf\u0010gR#\u0010i\u001a\n R*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\bk\u0010\u001b\u001a\u0004\bj\u0010=R4\u0010l\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020n0m\u0012\u0004\u0012\u00020n0mX.¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR8\u0010s\u001a&\u0012\f\u0012\n R*\u0004\u0018\u00010u0u R*\u0012\u0012\f\u0012\n R*\u0004\u0018\u00010u0u\u0018\u00010t0t8BX\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\"\u0010x\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010yX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010µ\u0001\u001a\u00030¶\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0005¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001¨\u0006Ë\u0001"}, d2 = {"Lcom/blueair/auth/GigyaService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "locationService", "Lcom/blueair/auth/LocationService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/content/Context;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/AnalyticsService;)V", "getContext", "()Landroid/content/Context;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "getSecurePrefs", "()Lcom/blueair/core/service/SecurePrefs;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "gigyaBaseUrl", "", "dataCenterList", "", "Lcom/blueair/auth/GigyaServer;", "fallbackBlueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getFallbackBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "blueCloudDomain", "getBlueCloudDomain", "<set-?>", "gigyaBlueCloudDomain", "getGigyaBlueCloudDomain", "setGigyaBlueCloudDomain", "(Lcom/blueair/auth/BlueCloudDomain;)V", "gigyaBlueCloudDomain$delegate", "Lkotlin/properties/ReadWriteProperty;", "forceBlueCloudDomain", "getForceBlueCloudDomain", "setForceBlueCloudDomain", "forceBlueCloudDomain$delegate", "deprecatedBlueCloudDomain", "getDeprecatedBlueCloudDomain", "setDeprecatedBlueCloudDomain", "deprecatedBlueCloudDomain$delegate", "cloudUserRegion", "getCloudUserRegion", "()Ljava/lang/String;", "gigyaDataCenter", "getGigyaDataCenter", "gigyaRestAdapter", "Lretrofit2/Retrofit;", "getGigyaRestAdapter", "()Lretrofit2/Retrofit;", "gigyaRestAdapter$delegate", "gigyaApi", "Lcom/blueair/auth/retrofit/GigyaApi;", "getGigyaApi", "()Lcom/blueair/auth/retrofit/GigyaApi;", "gigyaApi$delegate", "gigyaJwtPublisher", "Lio/reactivex/subjects/PublishSubject;", "getGigyaJwtPublisher", "()Lio/reactivex/subjects/PublishSubject;", "gigyaJwtPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "gigyaJwtObserver", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "getGigyaJwtObserver", "()Lio/reactivex/Observable;", "loggedOutPublisher", "", "getLoggedOutPublisher", "loggedOutPublisher$delegate", "loggedOutObserver", "getLoggedOutObserver", "gigyaUid", "getGigyaUid", "setGigyaUid", "(Ljava/lang/String;)V", "gigyaUid$delegate", "value", "gigyaJwt", "getGigyaJwt", "setGigyaJwt", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "preferences", "getPreferences", "preferences$delegate", "getPassword", "Lkotlin/Function1;", "", "getGetPassword", "()Lkotlin/jvm/functions/Function1;", "setGetPassword", "(Lkotlin/jvm/functions/Function1;)V", "gigya", "Lcom/gigya/android/sdk/Gigya;", "Lcom/blueair/auth/GigyaAccountExtended;", "getGigya", "()Lcom/gigya/android/sdk/Gigya;", "clearDataFunc", "Lkotlin/Function0;", "getClearDataFunc", "()Lkotlin/jvm/functions/Function0;", "setClearDataFunc", "(Lkotlin/jvm/functions/Function0;)V", "initializeGigya", "dataCenterFromURL", "url", "refreshGigyaTokenIfExpired", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRefreshingToken", "", "refreshTokens", "isGigyaSessionValid", "millisUntilGigyaTokenExpires", "", "isGigyaTokenExpired", "logOut", "refreshGigyaJwt", "refreshGigyaData", "refreshGigyaUid", "deleteAccount", "setClosestDataCenterForRegion", "region", "updateGigyaDataCenter", "ablRegion", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doGigyaDataCentersHaveEmailAddress", "email", "DATE_FORMAT_WY", "Ljava/text/SimpleDateFormat;", "unixTimeFromDateGigya", "date", "saveUserGigyaServer", "server", "saveUserBlueCloudDomain", "loadUserGigyaServer", "facebookLogin", "googleLogin", "appleLogin", "weChatLogin", "qqLogin", "socialLogin", "socialProvider", "emailLogin", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emailRegister", "firstName", "lastName", "phoneNumber", "subscribe", "consentDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", "getProfile", "updateProfile", "account", "recordUserInfoCollection", "(Lcom/blueair/auth/GigyaAccountExtended;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gigyaTokenExpiryMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkGigyaTokenExpiry", "runWithErrorReport", "T", "api", "failure", "block", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportError", "error", "Lcom/blueair/auth/GigyaService$GigyaException;", "errorCode", "errorMessage", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "GigyaException", "LoginCallback", "RegisterCallback", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaService implements CoroutineScope, LogOutable, DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final String API_FORGOT_PASSWORD = "forgotPassword";
    private static final String API_GET_ACCOUNT = "getAccount";
    private static final String API_IS_ACCOUNT_AVAILABLE = "send(accounts.isAvailableLoginID)";
    private static final String API_LOGIN = "login(email)";
    private static final String API_LOGIN_SOCIAL = "login(%s)";
    private static final String API_LOGOUT = "logout";
    private static final String API_REGISTER = "register";
    private static final String API_SEND_DELETE_ACCOUNT = "send(accounts.deleteAccount)";
    private static final String API_SEND_GET_JWT = "send(accounts.getJWT)";
    private static final String API_SET_ACCOUNT = "setAccount";
    public static final String AUSTRALIA = "au";
    public static final String CANADA = "ca";
    public static final String CHINA = "cn";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_USER_NAME = "-";
    public static final String EUROPE = "eu";
    public static final int EXPIRY_LENGTH_SECONDS = 2592000;
    public static final String USA = "us";
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final SimpleDateFormat DATE_FORMAT_WY;
    private final AnalyticsService analyticsService;
    private final Lazy authService$delegate;
    private Function0<Unit> clearDataFunc;
    private final Context context;
    /* access modifiers changed from: private */
    public List<? extends GigyaServer> dataCenterList;
    private final ReadWriteProperty deprecatedBlueCloudDomain$delegate;
    private final Lazy di$delegate;
    private final ReadWriteProperty forceBlueCloudDomain$delegate;
    public Function1<? super Function1<? super String, Unit>, Unit> getPassword;
    private final Lazy gigyaApi$delegate;
    /* access modifiers changed from: private */
    public String gigyaBaseUrl;
    private final ReadWriteProperty gigyaBlueCloudDomain$delegate;
    private String gigyaJwt;
    private final LazyPublishSubject gigyaJwtPublisher$delegate;
    private final Lazy gigyaRestAdapter$delegate;
    private final Mutex gigyaTokenExpiryMutex;
    private final ReadWriteProperty gigyaUid$delegate;
    private boolean isRefreshingToken;
    private final LocationService locationService;
    private final LazyPublishSubject loggedOutPublisher$delegate;
    private final Lazy moshi$delegate;
    private final Lazy preferences$delegate;
    private final SecurePrefs securePrefs;

    static {
        Class<GigyaService> cls = GigyaService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "gigyaBlueCloudDomain", "getGigyaBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceBlueCloudDomain", "getForceBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "deprecatedBlueCloudDomain", "getDeprecatedBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaJwtPublisher", "getGigyaJwtPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "loggedOutPublisher", "getLoggedOutPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "gigyaUid", "getGigyaUid()Ljava/lang/String;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public GigyaService(Context context2, LocationService locationService2, SecurePrefs securePrefs2, AnalyticsService analyticsService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        Intrinsics.checkNotNullParameter(securePrefs2, "securePrefs");
        Intrinsics.checkNotNullParameter(analyticsService2, "analyticsService");
        this.context = context2;
        this.locationService = locationService2;
        this.securePrefs = securePrefs2;
        this.analyticsService = analyticsService2;
        LazyContextDIPropertyDelegateProvider closestDI = ClosestKt.closestDI(context2);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new GigyaService$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        this.dataCenterList = GigyaServer.Companion.getALL_SERVERS();
        Prefs prefs = securePrefs2;
        BlueCloudDomain invalid = BlueCloudDomain.Companion.getINVALID();
        this.gigyaBlueCloudDomain$delegate = new GigyaService$special$$inlined$ObservablePreference$1(prefs, PrefKeys.GigyaBlueHomeDomain, invalid, PreferencesHelper.INSTANCE.get(prefs.getBackend(), PrefKeys.GigyaBlueHomeDomain, invalid, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class)));
        Prefs prefs2 = securePrefs2;
        BlueCloudDomain invalid2 = BlueCloudDomain.Companion.getINVALID();
        this.forceBlueCloudDomain$delegate = new GigyaService$special$$inlined$ObservablePreference$2(prefs2, PrefKeys.ForceBlueHomeDomain, invalid2, PreferencesHelper.INSTANCE.get(prefs2.getBackend(), PrefKeys.ForceBlueHomeDomain, invalid2, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class)));
        Prefs prefs3 = securePrefs2;
        BlueCloudDomain fallbackBlueCloudDomain = getFallbackBlueCloudDomain();
        this.deprecatedBlueCloudDomain$delegate = new GigyaService$special$$inlined$ObservablePreference$3(prefs3, PrefKeys.BlueHomeDomain, fallbackBlueCloudDomain, PreferencesHelper.INSTANCE.get(prefs3.getBackend(), PrefKeys.BlueHomeDomain, fallbackBlueCloudDomain, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class)));
        this.gigyaRestAdapter$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda1(this));
        this.gigyaApi$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda2(this));
        this.gigyaJwtPublisher$delegate = new LazyPublishSubject();
        this.loggedOutPublisher$delegate = new LazyPublishSubject();
        Prefs prefs4 = securePrefs2;
        this.gigyaUid$delegate = new GigyaService$special$$inlined$ObservablePreference$4(prefs4, PrefKeys.GigyaUid, "", PreferencesHelper.INSTANCE.get(prefs4.getBackend(), PrefKeys.GigyaUid, "", Reflection.getOrCreateKotlinClass(String.class)));
        this.gigyaJwt = "";
        this.moshi$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda3());
        this.preferences$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda4(this));
        initializeGigya();
        if (getGigyaJwt().length() != 0 && isGigyaSessionValid()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 2, (Object) null);
        }
        this.DATE_FORMAT_WY = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.gigyaTokenExpiryMutex = MutexKt.Mutex$default(false, 1, (Object) null);
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

    public final LocationService getLocationService() {
        return this.locationService;
    }

    public final SecurePrefs getSecurePrefs() {
        return this.securePrefs;
    }

    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final BlueCloudDomain getFallbackBlueCloudDomain() {
        return BlueCloudDomain.Companion.getDomainForRegion$default(BlueCloudDomain.Companion, (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), PrefKeys.GigyaServerCountryCode, null, Reflection.getOrCreateKotlinClass(String.class)), (Boolean) null, 2, (Object) null);
    }

    public final BlueCloudDomain getBlueCloudDomain() {
        BlueCloudDomain forceBlueCloudDomain = getForceBlueCloudDomain();
        if (!Intrinsics.areEqual((Object) forceBlueCloudDomain, (Object) BlueCloudDomain.Companion.getINVALID())) {
            return forceBlueCloudDomain;
        }
        BlueCloudDomain gigyaBlueCloudDomain = getGigyaBlueCloudDomain();
        if (!Intrinsics.areEqual((Object) gigyaBlueCloudDomain, (Object) BlueCloudDomain.Companion.getINVALID())) {
            return gigyaBlueCloudDomain;
        }
        return getDeprecatedBlueCloudDomain();
    }

    public final BlueCloudDomain getGigyaBlueCloudDomain() {
        return (BlueCloudDomain) this.gigyaBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setGigyaBlueCloudDomain(BlueCloudDomain blueCloudDomain) {
        Intrinsics.checkNotNullParameter(blueCloudDomain, "<set-?>");
        this.gigyaBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[2], blueCloudDomain);
    }

    public final BlueCloudDomain getForceBlueCloudDomain() {
        return (BlueCloudDomain) this.forceBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setForceBlueCloudDomain(BlueCloudDomain blueCloudDomain) {
        Intrinsics.checkNotNullParameter(blueCloudDomain, "<set-?>");
        this.forceBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[3], blueCloudDomain);
    }

    private final BlueCloudDomain getDeprecatedBlueCloudDomain() {
        return (BlueCloudDomain) this.deprecatedBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[4]);
    }

    private final void setDeprecatedBlueCloudDomain(BlueCloudDomain blueCloudDomain) {
        this.deprecatedBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[4], blueCloudDomain);
    }

    public final String getCloudUserRegion() {
        return getBlueCloudDomain().regionCodeShort();
    }

    public final String getGigyaDataCenter() {
        return loadUserGigyaServer().getCountryCode();
    }

    private final Retrofit getGigyaRestAdapter() {
        Object value = this.gigyaRestAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Retrofit) value;
    }

    /* access modifiers changed from: private */
    public static final Retrofit gigyaRestAdapter_delegate$lambda$3(GigyaService gigyaService) {
        HttpLoggingInterceptor.Level level;
        Timber.Forest.i("starting gigya Rest Adapter", new Object[0]);
        GigyaService$$ExternalSyntheticLambda0 gigyaService$$ExternalSyntheticLambda0 = new GigyaService$$ExternalSyntheticLambda0(gigyaService);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        OkHttpClient build = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor).addInterceptor(gigyaService$$ExternalSyntheticLambda0).build();
        Retrofit.Builder builder = new Retrofit.Builder();
        String str = gigyaService.gigyaBaseUrl;
        Intrinsics.checkNotNull(str);
        return builder.baseUrl(str).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).client(build).build();
    }

    /* access modifiers changed from: private */
    public static final Response gigyaRestAdapter_delegate$lambda$3$lambda$2(GigyaService gigyaService, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl.Companion companion = HttpUrl.Companion;
        String str = gigyaService.gigyaBaseUrl;
        Intrinsics.checkNotNull(str);
        HttpUrl parse = companion.parse(str);
        Intrinsics.checkNotNull(parse);
        String scheme = parse.scheme();
        return chain.proceed(request.newBuilder().url(request.url().newBuilder().scheme(scheme).host(parse.host()).build()).build());
    }

    /* access modifiers changed from: private */
    public final GigyaApi getGigyaApi() {
        Object value = this.gigyaApi$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (GigyaApi) value;
    }

    /* access modifiers changed from: private */
    public static final GigyaApi gigyaApi_delegate$lambda$4(GigyaService gigyaService) {
        return (GigyaApi) gigyaService.getGigyaRestAdapter().create(GigyaApi.class);
    }

    private final PublishSubject<String> getGigyaJwtPublisher() {
        return this.gigyaJwtPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[5]);
    }

    public final Observable<String> getGigyaJwtObserver() {
        return getGigyaJwtPublisher().hide();
    }

    private final PublishSubject<Object> getLoggedOutPublisher() {
        return this.loggedOutPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[6]);
    }

    public final Observable<Object> getLoggedOutObserver() {
        Observable<Object> hide = getLoggedOutPublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final String getGigyaUid() {
        return (String) this.gigyaUid$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setGigyaUid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gigyaUid$delegate.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setGigyaJwt(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        boolean z = this.gigyaJwt.length() > 0;
        String str2 = this.gigyaJwt;
        this.gigyaJwt = str;
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            this.securePrefs.remove(PrefKeys.GigyaJwtAuthToken);
        } else {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), PrefKeys.GigyaJwtAuthToken, str, Reflection.getOrCreateKotlinClass(String.class));
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("GigyaJWT updated with new value: " + str, new Object[0]);
        if (str2.length() > 0 && !Intrinsics.areEqual((Object) str2, (Object) str)) {
            getGigyaJwtPublisher().onNext(str);
        }
        if (charSequence.length() == 0 && z) {
            getLoggedOutPublisher().onNext(true);
        }
    }

    public final String getGigyaJwt() {
        if (this.gigyaJwt.length() == 0) {
            this.gigyaJwt = (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), PrefKeys.GigyaJwtAuthToken, null, Reflection.getOrCreateKotlinClass(String.class));
        }
        return this.gigyaJwt;
    }

    private final Moshi getMoshi() {
        return (Moshi) this.moshi$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Moshi moshi_delegate$lambda$5() {
        return new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
    }

    /* access modifiers changed from: private */
    public final String getPreferences() {
        return (String) this.preferences$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String preferences_delegate$lambda$6(GigyaService gigyaService) {
        return gigyaService.getMoshi().adapter(PreferencesDto.class).toJson(new PreferencesDto(new Cookies(true), new Privacy(new Generic(true)), new AgeConsentGranted(true)));
    }

    public final Function1<Function1<? super String, Unit>, Unit> getGetPassword() {
        Function1<? super Function1<? super String, Unit>, Unit> function1 = this.getPassword;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getPassword");
        return null;
    }

    public final void setGetPassword(Function1<? super Function1<? super String, Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.getPassword = function1;
    }

    /* access modifiers changed from: private */
    public final Gigya<GigyaAccountExtended> getGigya() {
        return Gigya.getInstance(GigyaAccountExtended.class);
    }

    public final Function0<Unit> getClearDataFunc() {
        return this.clearDataFunc;
    }

    public final void setClearDataFunc(Function0<Unit> function0) {
        this.clearDataFunc = function0;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.auth.GigyaService$1", f = "GigyaService.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.auth.GigyaService$1  reason: invalid class name */
    /* compiled from: GigyaService.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GigyaService this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual((Object) this.this$0.getGigyaBlueCloudDomain(), (Object) BlueCloudDomain.Companion.getINVALID())) {
                    String format = String.format(PrefKeys.AppRegionFetched, Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    if (!((Boolean) PreferencesHelper.INSTANCE.get(this.this$0.getSecurePrefs().getBackend(), format, Boxing.boxBoolean(false), Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
                        this.label = 1;
                        if (this.this$0.refreshGigyaData(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String format2 = String.format(PrefKeys.CloudRegionMismatchChecked, Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            if (!((Boolean) PreferencesHelper.INSTANCE.get(this.this$0.getSecurePrefs().getBackend(), format2, Boxing.boxBoolean(false), Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
                String regionCodeShort = this.this$0.getBlueCloudDomain().regionCodeShort();
                if (!Intrinsics.areEqual((Object) this.this$0.getGigyaDataCenter(), (Object) regionCodeShort)) {
                    if (Intrinsics.areEqual((Object) regionCodeShort, (Object) this.this$0.getForceBlueCloudDomain().regionCodeShort())) {
                        str = "dev";
                    } else if (Intrinsics.areEqual((Object) regionCodeShort, (Object) this.this$0.getGigyaBlueCloudDomain().regionCodeShort())) {
                        str = "appRegion";
                    } else {
                        str = "others";
                    }
                    Log.w("GigyaService", "GigyaCloudRegionMismatchEvent: " + this.this$0.getGigyaUid() + " | " + this.this$0.getGigyaDataCenter() + " -> " + regionCodeShort + " | " + str);
                    this.this$0.getAnalyticsService().event(new AnalyticEvent.GigyaCloudRegionMismatchEvent(this.this$0.getGigyaUid(), this.this$0.getGigyaDataCenter(), regionCodeShort, str));
                }
                String format3 = String.format(PrefKeys.CloudRegionMismatchChecked, Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                PreferencesHelper.INSTANCE.set(this.this$0.getSecurePrefs().getBackend(), format3, Boxing.boxBoolean(true), Reflection.getOrCreateKotlinClass(Boolean.class));
            }
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void initializeGigya() {
        GigyaServer loadUserGigyaServer = loadUserGigyaServer();
        String dataCenterFromURL = dataCenterFromURL(loadUserGigyaServer.getUrl());
        Gigya<GigyaAccountExtended> gigya = getGigya();
        gigya.init(loadUserGigyaServer.getApiKey(), dataCenterFromURL);
        GigyaAccountConfig gigyaAccountConfig = new GigyaAccountConfig();
        gigyaAccountConfig.setInclude(new String[]{"data", "profile", GigyaDefinitions.AccountIncludes.EMAILS});
        gigyaAccountConfig.setExtraProfileFields(new String[]{GigyaDefinitions.AccountProfileExtraFields.LANGUAGES, GigyaDefinitions.AccountProfileExtraFields.PHONES});
        gigya.setAccountConfig(gigyaAccountConfig);
        Timber.Forest forest = Timber.Forest;
        forest.d("Gigya initialized: server=" + loadUserGigyaServer.getCountryCode() + ", datacenter=" + dataCenterFromURL, new Object[0]);
    }

    private final String dataCenterFromURL(String str) {
        return new Regex("http[s]://?[^.]+\\.").replaceFirst(str, "");
    }

    public final Object refreshGigyaTokenIfExpired(Continuation<? super Unit> continuation) {
        if (!isGigyaSessionValid() || !isGigyaTokenExpired()) {
            return Unit.INSTANCE;
        }
        Timber.Forest.i("Refreshing Gigya JWT Token", new Object[0]);
        Object refreshTokens = refreshTokens(continuation);
        return refreshTokens == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? refreshTokens : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshTokens(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.auth.GigyaService$refreshTokens$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.auth.GigyaService$refreshTokens$1 r0 = (com.blueair.auth.GigyaService$refreshTokens$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$refreshTokens$1 r0 = new com.blueair.auth.GigyaService$refreshTokens$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0047
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.isRefreshingToken
            if (r5 != 0) goto L_0x004a
            r4.isRefreshingToken = r3
            r4.initializeGigya()
            r0.label = r3
            java.lang.Object r5 = r4.refreshGigyaJwt(r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = 0
            r4.isRefreshingToken = r5
        L_0x004a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.refreshTokens(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        r0 = getGigya().getSession();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isGigyaSessionValid() {
        /*
            r2 = this;
            com.gigya.android.sdk.Gigya r0 = r2.getGigya()
            com.gigya.android.sdk.session.SessionInfo r0 = r0.getSession()
            if (r0 != 0) goto L_0x000d
            r2.initializeGigya()
        L_0x000d:
            com.gigya.android.sdk.Gigya r0 = r2.getGigya()
            com.gigya.android.sdk.session.SessionInfo r0 = r0.getSession()
            if (r0 == 0) goto L_0x0029
            com.gigya.android.sdk.Gigya r0 = r2.getGigya()
            com.gigya.android.sdk.session.SessionInfo r0 = r0.getSession()
            if (r0 == 0) goto L_0x0029
            boolean r0 = r0.isValid()
            r1 = 1
            if (r0 != r1) goto L_0x0029
            return r1
        L_0x0029:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.isGigyaSessionValid():boolean");
    }

    public final long millisUntilGigyaTokenExpires() {
        if (getGigyaJwt().length() == 0) {
            return 0;
        }
        JWT jwt = new JWT(getGigyaJwt());
        long currentTimeMillis = System.currentTimeMillis();
        Date expiresAt = jwt.getExpiresAt();
        return (expiresAt != null ? expiresAt.getTime() : currentTimeMillis) - currentTimeMillis;
    }

    private final boolean isGigyaTokenExpired() {
        if (getGigyaJwt().length() == 0) {
            return true;
        }
        return new JWT(getGigyaJwt()).isExpired(0);
    }

    public void logOut() {
        String str = "";
        try {
            initializeGigya();
            getGigya().logout();
            setGigyaJwt(str);
        } catch (Throwable th) {
            if (!(th instanceof GigyaException)) {
                Timber.Forest forest = Timber.Forest;
                forest.e(th, "Gigya error [logout] " + th.getLocalizedMessage(), new Object[0]);
                String localizedMessage = th.getLocalizedMessage();
                if (localizedMessage != null) {
                    str = localizedMessage;
                }
                reportError("logout", "-1", str);
            } else {
                Timber.Forest forest2 = Timber.Forest;
                StringBuilder sb = new StringBuilder("Gigya error [logout] ");
                GigyaException gigyaException = th;
                sb.append(gigyaException.getError().getErrorCode());
                sb.append(" | ");
                sb.append(gigyaException.getError().getLocalizedMessage());
                sb.append(" | ");
                sb.append(gigyaException.getError().getData());
                forest2.e(th, sb.toString(), new Object[0]);
                reportError("logout", gigyaException);
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshGigyaJwt(kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.blueair.auth.GigyaService$refreshGigyaJwt$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.blueair.auth.GigyaService$refreshGigyaJwt$1 r0 = (com.blueair.auth.GigyaService$refreshGigyaJwt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$refreshGigyaJwt$1 r0 = new com.blueair.auth.GigyaService$refreshGigyaJwt$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = ""
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004d
            if (r2 != r4) goto L_0x0045
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$3
            com.blueair.auth.GigyaService$refreshGigyaJwt$1 r1 = (com.blueair.auth.GigyaService$refreshGigyaJwt$1) r1
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaService r0 = (com.blueair.auth.GigyaService) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0042 }
            goto L_0x00bc
        L_0x0042:
            r11 = move-exception
            goto L_0x00c3
        L_0x0045:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r2 = "send(accounts.getJWT)"
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "Requesting new Gigya Jwt token"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c0 }
            r11.d(r6, r7)     // Catch:{ all -> 0x00c0 }
            r0.L$0 = r10     // Catch:{ all -> 0x00c0 }
            r0.L$1 = r2     // Catch:{ all -> 0x00c0 }
            r0.L$2 = r3     // Catch:{ all -> 0x00c0 }
            r0.L$3 = r0     // Catch:{ all -> 0x00c0 }
            r0.I$0 = r5     // Catch:{ all -> 0x00c0 }
            r0.I$1 = r5     // Catch:{ all -> 0x00c0 }
            r0.label = r4     // Catch:{ all -> 0x00c0 }
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x00c0 }
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x00c0 }
            kotlin.coroutines.Continuation r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r11)     // Catch:{ all -> 0x00c0 }
            r6.<init>(r11)     // Catch:{ all -> 0x00c0 }
            r11 = r6
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x00c0 }
            r7 = 2
            kotlin.Pair[] r7 = new kotlin.Pair[r7]     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = "expiration"
            r9 = 2592000(0x278d00, float:3.632166E-39)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)     // Catch:{ all -> 0x00c0 }
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)     // Catch:{ all -> 0x00c0 }
            r7[r5] = r8     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = "fields"
            java.lang.String r9 = "email"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)     // Catch:{ all -> 0x00c0 }
            r7[r4] = r8     // Catch:{ all -> 0x00c0 }
            java.util.Map r4 = kotlin.collections.MapsKt.mapOf(r7)     // Catch:{ all -> 0x00c0 }
            com.gigya.android.sdk.Gigya r7 = r10.getGigya()     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = "accounts.getJWT"
            com.blueair.auth.GigyaService$refreshGigyaJwt$2$1$1 r9 = new com.blueair.auth.GigyaService$refreshGigyaJwt$2$1$1     // Catch:{ all -> 0x00c0 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00c0 }
            com.gigya.android.sdk.GigyaCallback r9 = (com.gigya.android.sdk.GigyaCallback) r9     // Catch:{ all -> 0x00c0 }
            r7.send(r8, r4, r9)     // Catch:{ all -> 0x00c0 }
            java.lang.Object r11 = r6.getOrThrow()     // Catch:{ all -> 0x00c0 }
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00c0 }
            if (r11 != r4) goto L_0x00b7
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00c0 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00c0 }
        L_0x00b7:
            if (r11 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            r0 = r10
            r1 = r3
        L_0x00bc:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0042 }
            goto L_0x013e
        L_0x00c0:
            r11 = move-exception
            r0 = r10
            r1 = r3
        L_0x00c3:
            boolean r4 = r11 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r6 = "] "
            java.lang.String r7 = "Gigya error ["
            if (r4 == 0) goto L_0x0111
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r7)
            r4.append(r2)
            r4.append(r6)
            r6 = r11
            com.blueair.auth.GigyaService$GigyaException r6 = (com.blueair.auth.GigyaService.GigyaException) r6
            com.gigya.android.sdk.network.GigyaError r7 = r6.getError()
            int r7 = r7.getErrorCode()
            r4.append(r7)
            java.lang.String r7 = " | "
            r4.append(r7)
            com.gigya.android.sdk.network.GigyaError r8 = r6.getError()
            java.lang.String r8 = r8.getLocalizedMessage()
            r4.append(r8)
            r4.append(r7)
            com.gigya.android.sdk.network.GigyaError r7 = r6.getError()
            java.lang.String r7 = r7.getData()
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r3.e(r11, r4, r5)
            r0.reportError(r2, r6)
            goto L_0x013b
        L_0x0111:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r2)
            r8.append(r6)
            java.lang.String r6 = r11.getLocalizedMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r4.e(r11, r6, r5)
            java.lang.String r4 = r11.getLocalizedMessage()
            if (r4 != 0) goto L_0x0135
            goto L_0x0136
        L_0x0135:
            r3 = r4
        L_0x0136:
            java.lang.String r4 = "-1"
            r0.reportError(r2, r4, r3)
        L_0x013b:
            if (r1 == 0) goto L_0x014e
            r11 = r1
        L_0x013e:
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x014c
            int r0 = r0.length()
            if (r0 != 0) goto L_0x014d
        L_0x014c:
            r11 = 0
        L_0x014d:
            return r11
        L_0x014e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.refreshGigyaJwt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshGigyaData(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService$refreshGigyaData$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.auth.GigyaService$refreshGigyaData$1 r0 = (com.blueair.auth.GigyaService$refreshGigyaData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$refreshGigyaData$1 r0 = new com.blueair.auth.GigyaService$refreshGigyaData$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$3
            com.blueair.auth.GigyaService$refreshGigyaData$1 r1 = (com.blueair.auth.GigyaService$refreshGigyaData$1) r1
            java.lang.Object r1 = r0.L$2
            kotlin.Unit r1 = (kotlin.Unit) r1
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaService r0 = (com.blueair.auth.GigyaService) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0040 }
            goto L_0x0115
        L_0x0040:
            r10 = move-exception
            goto L_0x009b
        L_0x0042:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.String r2 = "refreshGigyaData"
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r10.d(r2, r5)
            java.lang.String r2 = "getAccount"
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r0.L$0 = r9     // Catch:{ all -> 0x0097 }
            r0.L$1 = r2     // Catch:{ all -> 0x0097 }
            r0.L$2 = r10     // Catch:{ all -> 0x0097 }
            r0.L$3 = r0     // Catch:{ all -> 0x0097 }
            r0.I$0 = r4     // Catch:{ all -> 0x0097 }
            r0.I$1 = r4     // Catch:{ all -> 0x0097 }
            r0.label = r3     // Catch:{ all -> 0x0097 }
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.SafeContinuation r5 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r3)     // Catch:{ all -> 0x0097 }
            r5.<init>(r3)     // Catch:{ all -> 0x0097 }
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ all -> 0x0097 }
            com.gigya.android.sdk.Gigya r6 = r9.getGigya()     // Catch:{ all -> 0x0097 }
            com.blueair.auth.GigyaService$LoginCallback r7 = new com.blueair.auth.GigyaService$LoginCallback     // Catch:{ all -> 0x0097 }
            r7.<init>(r9, r3)     // Catch:{ all -> 0x0097 }
            com.gigya.android.sdk.GigyaCallback r7 = (com.gigya.android.sdk.GigyaCallback) r7     // Catch:{ all -> 0x0097 }
            r6.getAccount(r7)     // Catch:{ all -> 0x0097 }
            java.lang.Object r3 = r5.getOrThrow()     // Catch:{ all -> 0x0097 }
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0097 }
            if (r3 != r5) goto L_0x0094
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0097 }
        L_0x0094:
            if (r3 != r1) goto L_0x0115
            return r1
        L_0x0097:
            r0 = move-exception
            r1 = r10
            r10 = r0
            r0 = r9
        L_0x009b:
            boolean r3 = r10 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r5 = "] "
            java.lang.String r6 = "Gigya error ["
            if (r3 == 0) goto L_0x00e9
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            r7.append(r5)
            r5 = r10
            com.blueair.auth.GigyaService$GigyaException r5 = (com.blueair.auth.GigyaService.GigyaException) r5
            com.gigya.android.sdk.network.GigyaError r6 = r5.getError()
            int r6 = r6.getErrorCode()
            r7.append(r6)
            java.lang.String r6 = " | "
            r7.append(r6)
            com.gigya.android.sdk.network.GigyaError r8 = r5.getError()
            java.lang.String r8 = r8.getLocalizedMessage()
            r7.append(r8)
            r7.append(r6)
            com.gigya.android.sdk.network.GigyaError r6 = r5.getError()
            java.lang.String r6 = r6.getData()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r3.e(r10, r6, r4)
            r0.reportError(r2, r5)
            goto L_0x0113
        L_0x00e9:
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            r7.append(r5)
            java.lang.String r5 = r10.getLocalizedMessage()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r3.e(r10, r5, r4)
            java.lang.String r3 = r10.getLocalizedMessage()
            if (r3 != 0) goto L_0x010e
            java.lang.String r3 = ""
        L_0x010e:
            java.lang.String r4 = "-1"
            r0.reportError(r2, r4, r3)
        L_0x0113:
            if (r1 == 0) goto L_0x0118
        L_0x0115:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0118:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.refreshGigyaData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0123 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshGigyaUid(kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService$refreshGigyaUid$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.auth.GigyaService$refreshGigyaUid$1 r0 = (com.blueair.auth.GigyaService$refreshGigyaUid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$refreshGigyaUid$1 r0 = new com.blueair.auth.GigyaService$refreshGigyaUid$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = ""
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 != r4) goto L_0x0043
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$3
            com.blueair.auth.GigyaService$refreshGigyaUid$1 r1 = (com.blueair.auth.GigyaService$refreshGigyaUid$1) r1
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaService r0 = (com.blueair.auth.GigyaService) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0041 }
            goto L_0x008f
        L_0x0041:
            r10 = move-exception
            goto L_0x009a
        L_0x0043:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r2 = "getAccount"
            r0.L$0 = r9     // Catch:{ all -> 0x0097 }
            r0.L$1 = r2     // Catch:{ all -> 0x0097 }
            r0.L$2 = r3     // Catch:{ all -> 0x0097 }
            r0.L$3 = r0     // Catch:{ all -> 0x0097 }
            r0.I$0 = r5     // Catch:{ all -> 0x0097 }
            r0.I$1 = r5     // Catch:{ all -> 0x0097 }
            r0.label = r4     // Catch:{ all -> 0x0097 }
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.SafeContinuation r4 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.Continuation r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r10)     // Catch:{ all -> 0x0097 }
            r4.<init>(r10)     // Catch:{ all -> 0x0097 }
            r10 = r4
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ all -> 0x0097 }
            com.gigya.android.sdk.Gigya r6 = r9.getGigya()     // Catch:{ all -> 0x0097 }
            com.blueair.auth.GigyaService$LoginCallback r7 = new com.blueair.auth.GigyaService$LoginCallback     // Catch:{ all -> 0x0097 }
            r7.<init>(r9, r10)     // Catch:{ all -> 0x0097 }
            com.gigya.android.sdk.GigyaCallback r7 = (com.gigya.android.sdk.GigyaCallback) r7     // Catch:{ all -> 0x0097 }
            r6.getAccount(r7)     // Catch:{ all -> 0x0097 }
            java.lang.Object r10 = r4.getOrThrow()     // Catch:{ all -> 0x0097 }
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0097 }
            if (r10 != r4) goto L_0x008a
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0097 }
        L_0x008a:
            if (r10 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r0 = r9
            r1 = r3
        L_0x008f:
            com.blueair.auth.GigyaAccountExtended r10 = (com.blueair.auth.GigyaAccountExtended) r10     // Catch:{ all -> 0x0041 }
            java.lang.String r10 = r10.getUID()     // Catch:{ all -> 0x0041 }
            goto L_0x0115
        L_0x0097:
            r10 = move-exception
            r0 = r9
            r1 = r3
        L_0x009a:
            boolean r4 = r10 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r6 = "] "
            java.lang.String r7 = "Gigya error ["
            if (r4 == 0) goto L_0x00e8
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r7)
            r4.append(r2)
            r4.append(r6)
            r6 = r10
            com.blueair.auth.GigyaService$GigyaException r6 = (com.blueair.auth.GigyaService.GigyaException) r6
            com.gigya.android.sdk.network.GigyaError r7 = r6.getError()
            int r7 = r7.getErrorCode()
            r4.append(r7)
            java.lang.String r7 = " | "
            r4.append(r7)
            com.gigya.android.sdk.network.GigyaError r8 = r6.getError()
            java.lang.String r8 = r8.getLocalizedMessage()
            r4.append(r8)
            r4.append(r7)
            com.gigya.android.sdk.network.GigyaError r7 = r6.getError()
            java.lang.String r7 = r7.getData()
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r3.e(r10, r4, r5)
            r0.reportError(r2, r6)
            goto L_0x0112
        L_0x00e8:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r2)
            r8.append(r6)
            java.lang.String r6 = r10.getLocalizedMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r4.e(r10, r6, r5)
            java.lang.String r4 = r10.getLocalizedMessage()
            if (r4 != 0) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r3 = r4
        L_0x010d:
            java.lang.String r4 = "-1"
            r0.reportError(r2, r4, r3)
        L_0x0112:
            if (r1 == 0) goto L_0x0125
            r10 = r1
        L_0x0115:
            r0 = r10
            java.lang.String r0 = (java.lang.String) r0
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0123
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0124
        L_0x0123:
            r10 = 0
        L_0x0124:
            return r10
        L_0x0125:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.refreshGigyaUid(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e2 A[SYNTHETIC, Splitter:B:38:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteAccount(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.blueair.auth.GigyaService$deleteAccount$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.blueair.auth.GigyaService$deleteAccount$1 r0 = (com.blueair.auth.GigyaService$deleteAccount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$deleteAccount$1 r0 = new com.blueair.auth.GigyaService$deleteAccount$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0063
            if (r2 == r4) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$2
            com.blueair.auth.GigyaService$deleteAccount$1 r1 = (com.blueair.auth.GigyaService$deleteAccount$1) r1
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaService r0 = (com.blueair.auth.GigyaService) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0043 }
            goto L_0x00df
        L_0x0043:
            r11 = move-exception
            goto L_0x00ee
        L_0x0046:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x004e:
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            com.blueair.auth.GigyaService r7 = (com.blueair.auth.GigyaService) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x005e }
            goto L_0x0087
        L_0x005e:
            r11 = move-exception
            r1 = r6
            r0 = r7
            goto L_0x00ee
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "send(accounts.deleteAccount)"
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x00ea }
            java.lang.String r6 = "Requesting account deletion"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00ea }
            r2.d(r6, r7)     // Catch:{ all -> 0x00ea }
            r0.L$0 = r10     // Catch:{ all -> 0x00ea }
            r0.L$1 = r11     // Catch:{ all -> 0x00ea }
            r0.I$0 = r5     // Catch:{ all -> 0x00ea }
            r0.I$1 = r5     // Catch:{ all -> 0x00ea }
            r0.label = r4     // Catch:{ all -> 0x00ea }
            java.lang.Object r2 = r10.refreshGigyaJwt(r0)     // Catch:{ all -> 0x00ea }
            if (r2 != r1) goto L_0x0082
            goto L_0x00dc
        L_0x0082:
            r7 = r10
            r6 = r11
            r11 = r2
            r2 = r5
            r4 = r2
        L_0x0087:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x005e }
            if (r11 == 0) goto L_0x00e2
            r0.L$0 = r7     // Catch:{ all -> 0x005e }
            r0.L$1 = r6     // Catch:{ all -> 0x005e }
            r0.L$2 = r0     // Catch:{ all -> 0x005e }
            r0.L$3 = r11     // Catch:{ all -> 0x005e }
            r0.I$0 = r4     // Catch:{ all -> 0x005e }
            r0.I$1 = r2     // Catch:{ all -> 0x005e }
            r0.label = r3     // Catch:{ all -> 0x005e }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x005e }
            kotlin.coroutines.SafeContinuation r3 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x005e }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x005e }
            r3.<init>(r2)     // Catch:{ all -> 0x005e }
            r2 = r3
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "UID"
            com.auth0.android.jwt.JWT r8 = new com.auth0.android.jwt.JWT     // Catch:{ all -> 0x005e }
            r8.<init>(r11)     // Catch:{ all -> 0x005e }
            java.lang.String r11 = r8.getSubject()     // Catch:{ all -> 0x005e }
            kotlin.Pair r11 = kotlin.TuplesKt.to(r4, r11)     // Catch:{ all -> 0x005e }
            java.util.Map r11 = kotlin.collections.MapsKt.mapOf(r11)     // Catch:{ all -> 0x005e }
            com.gigya.android.sdk.Gigya r4 = r10.getGigya()     // Catch:{ all -> 0x005e }
            java.lang.String r8 = "accounts.deleteAccount"
            com.blueair.auth.GigyaService$deleteAccount$2$1$1 r9 = new com.blueair.auth.GigyaService$deleteAccount$2$1$1     // Catch:{ all -> 0x005e }
            r9.<init>(r2)     // Catch:{ all -> 0x005e }
            com.gigya.android.sdk.GigyaCallback r9 = (com.gigya.android.sdk.GigyaCallback) r9     // Catch:{ all -> 0x005e }
            r4.send(r8, r11, r9)     // Catch:{ all -> 0x005e }
            java.lang.Object r11 = r3.getOrThrow()     // Catch:{ all -> 0x005e }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x005e }
            if (r11 != r2) goto L_0x00da
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x005e }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x005e }
        L_0x00da:
            if (r11 != r1) goto L_0x00dd
        L_0x00dc:
            return r1
        L_0x00dd:
            r1 = r6
            r0 = r7
        L_0x00df:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0043 }
            return r11
        L_0x00e2:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x005e }
            java.lang.String r0 = "Cannot extract UID: null Gigya JWT"
            r11.<init>(r0)     // Catch:{ all -> 0x005e }
            throw r11     // Catch:{ all -> 0x005e }
        L_0x00ea:
            r0 = move-exception
            r1 = r11
            r11 = r0
            r0 = r10
        L_0x00ee:
            boolean r2 = r11 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r3 = "] "
            java.lang.String r4 = "Gigya error ["
            if (r2 != 0) goto L_0x0121
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            r6.append(r1)
            r6.append(r3)
            java.lang.String r3 = r11.getLocalizedMessage()
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r2.e(r11, r3, r4)
            java.lang.String r2 = r11.getLocalizedMessage()
            if (r2 != 0) goto L_0x011b
            java.lang.String r2 = ""
        L_0x011b:
            java.lang.String r3 = "-1"
            r0.reportError(r1, r3, r2)
            goto L_0x0166
        L_0x0121:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            r6.append(r1)
            r6.append(r3)
            r3 = r11
            com.blueair.auth.GigyaService$GigyaException r3 = (com.blueair.auth.GigyaService.GigyaException) r3
            com.gigya.android.sdk.network.GigyaError r4 = r3.getError()
            int r4 = r4.getErrorCode()
            r6.append(r4)
            java.lang.String r4 = " | "
            r6.append(r4)
            com.gigya.android.sdk.network.GigyaError r7 = r3.getError()
            java.lang.String r7 = r7.getLocalizedMessage()
            r6.append(r7)
            r6.append(r4)
            com.gigya.android.sdk.network.GigyaError r4 = r3.getError()
            java.lang.String r4 = r4.getData()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r2.e(r11, r4, r5)
            r0.reportError(r1, r3)
        L_0x0166:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.deleteAccount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/auth/GigyaService$GigyaException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/gigya/android/sdk/network/GigyaError;", "<init>", "(Lcom/gigya/android/sdk/network/GigyaError;)V", "getError", "()Lcom/gigya/android/sdk/network/GigyaError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaService.kt */
    public static final class GigyaException extends Exception {
        private final GigyaError error;

        public static /* synthetic */ GigyaException copy$default(GigyaException gigyaException, GigyaError gigyaError, int i, Object obj) {
            if ((i & 1) != 0) {
                gigyaError = gigyaException.error;
            }
            return gigyaException.copy(gigyaError);
        }

        public final GigyaError component1() {
            return this.error;
        }

        public final GigyaException copy(GigyaError gigyaError) {
            Intrinsics.checkNotNullParameter(gigyaError, "error");
            return new GigyaException(gigyaError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GigyaException) && Intrinsics.areEqual((Object) this.error, (Object) ((GigyaException) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "GigyaException(error=" + this.error + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GigyaException(GigyaError gigyaError) {
            super(gigyaError.getLocalizedMessage());
            Intrinsics.checkNotNullParameter(gigyaError, "error");
            this.error = gigyaError;
        }

        public final GigyaError getError() {
            return this.error;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r4.equals("us") == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r4.equals(CANADA) != false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setClosestDataCenterForRegion(java.lang.String r4) {
        /*
            r3 = this;
            java.util.List<? extends com.blueair.auth.GigyaServer> r0 = r3.dataCenterList
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            com.blueair.auth.RegionUtils r1 = com.blueair.auth.RegionUtils.INSTANCE
            java.lang.String r4 = r1.getCountryCodeFromGigyaRegion(r4)
            if (r4 == 0) goto L_0x0057
            int r1 = r4.hashCode()
            r2 = 3124(0xc34, float:4.378E-42)
            if (r1 == r2) goto L_0x0049
            r2 = 3166(0xc5e, float:4.437E-42)
            if (r1 == r2) goto L_0x003c
            r2 = 3179(0xc6b, float:4.455E-42)
            if (r1 == r2) goto L_0x002e
            r2 = 3742(0xe9e, float:5.244E-42)
            if (r1 == r2) goto L_0x0025
            goto L_0x0057
        L_0x0025:
            java.lang.String r1 = "us"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0044
            goto L_0x0057
        L_0x002e:
            java.lang.String r1 = "cn"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0037
            goto L_0x0057
        L_0x0037:
            com.blueair.auth.GigyaServer$CHINA r4 = com.blueair.auth.GigyaServer.CHINA.INSTANCE
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
            goto L_0x005b
        L_0x003c:
            java.lang.String r1 = "ca"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0057
        L_0x0044:
            com.blueair.auth.GigyaServer$USA r4 = com.blueair.auth.GigyaServer.USA.INSTANCE
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
            goto L_0x005b
        L_0x0049:
            java.lang.String r1 = "au"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            com.blueair.auth.GigyaServer$AUSTRALIA r4 = com.blueair.auth.GigyaServer.AUSTRALIA.INSTANCE
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
            goto L_0x005b
        L_0x0057:
            com.blueair.auth.GigyaServer$EUROPE r4 = com.blueair.auth.GigyaServer.EUROPE.INSTANCE
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
        L_0x005b:
            r0.remove(r4)
            r1 = 0
            r0.add(r1, r4)
            r3.saveUserGigyaServer(r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r4 = kotlin.collections.CollectionsKt.toList(r0)
            r3.dataCenterList = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.setClosestDataCenterForRegion(java.lang.String):void");
    }

    public final Object updateGigyaDataCenter(String str, Continuation<? super GigyaServer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GigyaService$updateGigyaDataCenter$2(this, str, (Continuation<? super GigyaService$updateGigyaDataCenter$2>) null), continuation);
    }

    public final Object doGigyaDataCentersHaveEmailAddress(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GigyaService$doGigyaDataCentersHaveEmailAddress$2(this, str, (Continuation<? super GigyaService$doGigyaDataCentersHaveEmailAddress$2>) null), continuation);
    }

    public final long unixTimeFromDateGigya(String str) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.DATE);
        try {
            return this.DATE_FORMAT_WY.parse(str).getTime() / ((long) 1000);
        } catch (ParseException e) {
            Timber.Forest forest = Timber.Forest;
            forest.e("unixTimeFromDate failed: " + e, new Object[0]);
            return 0;
        } catch (NumberFormatException e2) {
            Timber.Forest forest2 = Timber.Forest;
            forest2.e("unixTimeFromDate failed: " + e2, new Object[0]);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void saveUserGigyaServer(GigyaServer gigyaServer) {
        PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), PrefKeys.GigyaServerCountryCode, gigyaServer.getCountryCode(), Reflection.getOrCreateKotlinClass(String.class));
        Timber.Forest forest = Timber.Forest;
        forest.v("saveUserGigyaServer: " + gigyaServer.getCountryCode(), new Object[0]);
        saveUserBlueCloudDomain(gigyaServer);
    }

    private final void saveUserBlueCloudDomain(GigyaServer gigyaServer) {
        setDeprecatedBlueCloudDomain(BlueCloudDomain.Companion.getDomainForRegion$default(BlueCloudDomain.Companion, gigyaServer.getCountryCode(), (Boolean) null, 2, (Object) null));
        Timber.Forest forest = Timber.Forest;
        forest.v("saveUserBlueCloudDomain: countryCode = " + gigyaServer.getCountryCode() + ", domain = " + getBlueCloudDomain(), new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.blueair.auth.GigyaServer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.blueair.auth.GigyaServer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.blueair.auth.GigyaServer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.blueair.auth.GigyaServer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.blueair.auth.GigyaServer loadUserGigyaServer() {
        /*
            r5 = this;
            java.lang.String r0 = r5.getGigyaJwt()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 0
            if (r1 != 0) goto L_0x0010
        L_0x000e:
            r3 = r2
            goto L_0x005c
        L_0x0010:
            com.auth0.android.jwt.JWT r1 = new com.auth0.android.jwt.JWT
            r1.<init>(r0)
            java.util.Map r0 = r1.getClaims()
            java.lang.String r1 = "apiKey"
            java.lang.Object r0 = r0.get(r1)
            com.auth0.android.jwt.Claim r0 = (com.auth0.android.jwt.Claim) r0
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.asString()
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x000e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0035
            goto L_0x000e
        L_0x0035:
            com.blueair.auth.GigyaServer$Companion r1 = com.blueair.auth.GigyaServer.Companion
            java.util.List r1 = r1.getALL_SERVERS()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0041:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
            java.lang.String r4 = r4.getApiKey()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0041
            goto L_0x005a
        L_0x0059:
            r3 = r2
        L_0x005a:
            com.blueair.auth.GigyaServer r3 = (com.blueair.auth.GigyaServer) r3
        L_0x005c:
            if (r3 != 0) goto L_0x00a5
            com.blueair.core.service.SecurePrefs r0 = r5.securePrefs
            io.flatcircle.preferenceshelper2.Prefs r0 = (io.flatcircle.preferenceshelper2.Prefs) r0
            io.flatcircle.preferenceshelper2.PreferencesHelper r1 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r0 = r0.getBackend()
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r4 = "gigya_server"
            java.lang.Object r0 = r1.get(r0, r4, r2, r3)
            java.lang.String r0 = (java.lang.String) r0
            com.blueair.auth.GigyaServer$Companion r1 = com.blueair.auth.GigyaServer.Companion
            java.util.List r1 = r1.getALL_SERVERS()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0082:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x009a
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.blueair.auth.GigyaServer r4 = (com.blueair.auth.GigyaServer) r4
            java.lang.String r4 = r4.getCountryCode()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0082
            r2 = r3
        L_0x009a:
            com.blueair.auth.GigyaServer r2 = (com.blueair.auth.GigyaServer) r2
            if (r2 != 0) goto L_0x00a4
            com.blueair.auth.GigyaServer$EUROPE r0 = com.blueair.auth.GigyaServer.EUROPE.INSTANCE
            com.blueair.auth.GigyaServer r0 = (com.blueair.auth.GigyaServer) r0
            r3 = r0
            goto L_0x00a5
        L_0x00a4:
            r3 = r2
        L_0x00a5:
            com.blueair.sdk.BugfenderSdk r0 = com.blueair.sdk.BugfenderSdk.INSTANCE
            java.lang.String r1 = r3.getUrl()
            java.lang.String r2 = "https://accounts."
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r1 = kotlin.text.StringsKt.removePrefix((java.lang.String) r1, (java.lang.CharSequence) r2)
            java.lang.String r2 = "gigya_datacenter"
            r0.setDeviceString(r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.loadUserGigyaServer():com.blueair.auth.GigyaServer");
    }

    public final Object facebookLogin(Continuation<? super GigyaAccountExtended> continuation) {
        return socialLogin("facebook", continuation);
    }

    public final Object googleLogin(Continuation<? super GigyaAccountExtended> continuation) {
        return socialLogin(GigyaDefinitions.Providers.GOOGLE, continuation);
    }

    public final Object appleLogin(Continuation<? super GigyaAccountExtended> continuation) {
        return socialLogin(GigyaDefinitions.Providers.APPLE, continuation);
    }

    public final Object weChatLogin(Continuation<? super GigyaAccountExtended> continuation) {
        return socialLogin("wechat", continuation);
    }

    public final Object qqLogin(Continuation<? super GigyaAccountExtended> continuation) {
        return socialLogin(GigyaDefinitions.Providers.TENCENT_QQ, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object socialLogin(java.lang.String r13, kotlin.coroutines.Continuation<? super com.blueair.auth.GigyaAccountExtended> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.blueair.auth.GigyaService$socialLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.auth.GigyaService$socialLogin$1 r0 = (com.blueair.auth.GigyaService$socialLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$socialLogin$1 r0 = new com.blueair.auth.GigyaService$socialLogin$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            int r13 = r0.I$2
            int r13 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r13 = r0.L$3
            com.blueair.auth.GigyaService$socialLogin$1 r13 = (com.blueair.auth.GigyaService$socialLogin$1) r13
            java.lang.Object r13 = r0.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r1 = r0.L$1
            com.blueair.auth.GigyaService r1 = (com.blueair.auth.GigyaService) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0042 }
            goto L_0x00d1
        L_0x0042:
            r0 = move-exception
            r14 = r0
            goto L_0x00da
        L_0x0046:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object[] r14 = new java.lang.Object[r3]
            r14[r4] = r13
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r3)
            java.lang.String r2 = "login(%s)"
            java.lang.String r14 = java.lang.String.format(r2, r14)
            java.lang.String r2 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)
            r0.L$0 = r13     // Catch:{ all -> 0x00d4 }
            r0.L$1 = r12     // Catch:{ all -> 0x00d4 }
            r0.L$2 = r14     // Catch:{ all -> 0x00d4 }
            r0.L$3 = r0     // Catch:{ all -> 0x00d4 }
            r0.I$0 = r4     // Catch:{ all -> 0x00d4 }
            r0.I$1 = r4     // Catch:{ all -> 0x00d4 }
            r0.I$2 = r4     // Catch:{ all -> 0x00d4 }
            r0.label = r3     // Catch:{ all -> 0x00d4 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00d4 }
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00d4 }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x00d4 }
            r5.<init>(r2, r3)     // Catch:{ all -> 0x00d4 }
            r5.initCancellability()     // Catch:{ all -> 0x00d4 }
            r8 = r5
            kotlinx.coroutines.CancellableContinuation r8 = (kotlinx.coroutines.CancellableContinuation) r8     // Catch:{ all -> 0x00d4 }
            com.gigya.android.sdk.Gigya r2 = r12.getGigya()     // Catch:{ all -> 0x00d4 }
            r2.logout()     // Catch:{ all -> 0x00d4 }
            r12.initializeGigya()     // Catch:{ all -> 0x00d4 }
            com.gigya.android.sdk.Gigya r2 = r12.getGigya()     // Catch:{ all -> 0x00d4 }
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00d4 }
            r3.<init>()     // Catch:{ all -> 0x00d4 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x00d4 }
            com.blueair.auth.GigyaService$RegisterCallback r6 = new com.blueair.auth.GigyaService$RegisterCallback     // Catch:{ all -> 0x00d4 }
            java.lang.String r9 = r12.getPreferences()     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = "access$getPreferences(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)     // Catch:{ all -> 0x00d4 }
            com.blueair.auth.LocationService r7 = r12.getLocationService()     // Catch:{ all -> 0x00d4 }
            java.lang.String r10 = r7.getCountry()     // Catch:{ all -> 0x00d4 }
            kotlin.jvm.functions.Function1 r11 = r12.getGetPassword()     // Catch:{ all -> 0x00d4 }
            r7 = r12
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00d4 }
            com.gigya.android.sdk.GigyaLoginCallback r6 = (com.gigya.android.sdk.GigyaLoginCallback) r6     // Catch:{ all -> 0x00d4 }
            r2.login((java.lang.String) r13, (java.util.Map<java.lang.String, java.lang.Object>) r3, r6)     // Catch:{ all -> 0x00d4 }
            java.lang.Object r13 = r5.getResult()     // Catch:{ all -> 0x00d4 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00d4 }
            if (r13 != r2) goto L_0x00ca
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00d4 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00d4 }
        L_0x00ca:
            if (r13 != r1) goto L_0x00cd
            return r1
        L_0x00cd:
            r1 = r14
            r14 = r13
            r13 = r1
            r1 = r12
        L_0x00d1:
            com.blueair.auth.GigyaAccountExtended r14 = (com.blueair.auth.GigyaAccountExtended) r14     // Catch:{ all -> 0x0042 }
            return r14
        L_0x00d4:
            r0 = move-exception
            r13 = r0
            r1 = r14
            r14 = r13
            r13 = r1
            r1 = r12
        L_0x00da:
            boolean r0 = r14 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r2 = "] "
            java.lang.String r3 = "Gigya error ["
            if (r0 != 0) goto L_0x010d
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            r5.append(r13)
            r5.append(r2)
            java.lang.String r2 = r14.getLocalizedMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r0.e(r14, r2, r3)
            java.lang.String r0 = r14.getLocalizedMessage()
            if (r0 != 0) goto L_0x0107
            java.lang.String r0 = ""
        L_0x0107:
            java.lang.String r2 = "-1"
            r1.reportError(r13, r2, r0)
            goto L_0x0152
        L_0x010d:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            r5.append(r13)
            r5.append(r2)
            r2 = r14
            com.blueair.auth.GigyaService$GigyaException r2 = (com.blueair.auth.GigyaService.GigyaException) r2
            com.gigya.android.sdk.network.GigyaError r3 = r2.getError()
            int r3 = r3.getErrorCode()
            r5.append(r3)
            java.lang.String r3 = " | "
            r5.append(r3)
            com.gigya.android.sdk.network.GigyaError r6 = r2.getError()
            java.lang.String r6 = r6.getLocalizedMessage()
            r5.append(r6)
            r5.append(r3)
            com.gigya.android.sdk.network.GigyaError r3 = r2.getError()
            java.lang.String r3 = r3.getData()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r0.e(r14, r3, r4)
            r1.reportError(r13, r2)
        L_0x0152:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.socialLogin(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emailLogin(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.blueair.auth.GigyaAccountExtended> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService$emailLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.auth.GigyaService$emailLogin$1 r0 = (com.blueair.auth.GigyaService$emailLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$emailLogin$1 r0 = new com.blueair.auth.GigyaService$emailLogin$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            int r8 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$4
            com.blueair.auth.GigyaService$emailLogin$1 r8 = (com.blueair.auth.GigyaService$emailLogin$1) r8
            java.lang.Object r8 = r0.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$2
            com.blueair.auth.GigyaService r9 = (com.blueair.auth.GigyaService) r9
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0043 }
            goto L_0x00a6
        L_0x0043:
            r10 = move-exception
            goto L_0x00ae
        L_0x0045:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "login(email)"
            r0.L$0 = r8     // Catch:{ all -> 0x00a9 }
            r0.L$1 = r9     // Catch:{ all -> 0x00a9 }
            r0.L$2 = r7     // Catch:{ all -> 0x00a9 }
            r0.L$3 = r10     // Catch:{ all -> 0x00a9 }
            r0.L$4 = r0     // Catch:{ all -> 0x00a9 }
            r0.I$0 = r4     // Catch:{ all -> 0x00a9 }
            r0.I$1 = r4     // Catch:{ all -> 0x00a9 }
            r0.label = r3     // Catch:{ all -> 0x00a9 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.SafeContinuation r3 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x00a9 }
            r3.<init>(r2)     // Catch:{ all -> 0x00a9 }
            r2 = r3
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00a9 }
            com.gigya.android.sdk.Gigya r5 = r7.getGigya()     // Catch:{ all -> 0x00a9 }
            r5.logout()     // Catch:{ all -> 0x00a9 }
            com.blueair.auth.AuthService r5 = r7.getAuthService()     // Catch:{ all -> 0x00a9 }
            r5.clearUserData()     // Catch:{ all -> 0x00a9 }
            r7.initializeGigya()     // Catch:{ all -> 0x00a9 }
            com.gigya.android.sdk.Gigya r5 = r7.getGigya()     // Catch:{ all -> 0x00a9 }
            com.blueair.auth.GigyaService$LoginCallback r6 = new com.blueair.auth.GigyaService$LoginCallback     // Catch:{ all -> 0x00a9 }
            r6.<init>(r7, r2)     // Catch:{ all -> 0x00a9 }
            com.gigya.android.sdk.GigyaLoginCallback r6 = (com.gigya.android.sdk.GigyaLoginCallback) r6     // Catch:{ all -> 0x00a9 }
            r5.login((java.lang.String) r8, (java.lang.String) r9, r6)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = r3.getOrThrow()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00a9 }
            if (r8 != r9) goto L_0x009f
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00a9 }
        L_0x009f:
            if (r8 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
        L_0x00a6:
            com.blueair.auth.GigyaAccountExtended r10 = (com.blueair.auth.GigyaAccountExtended) r10     // Catch:{ all -> 0x0043 }
            return r10
        L_0x00a9:
            r8 = move-exception
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
        L_0x00ae:
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r1 = "] "
            java.lang.String r2 = "Gigya error ["
            if (r0 != 0) goto L_0x00e1
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r10.getLocalizedMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r0.e(r10, r1, r2)
            java.lang.String r0 = r10.getLocalizedMessage()
            if (r0 != 0) goto L_0x00db
            java.lang.String r0 = ""
        L_0x00db:
            java.lang.String r1 = "-1"
            r9.reportError(r8, r1, r0)
            goto L_0x0126
        L_0x00e1:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            r3.append(r1)
            r1 = r10
            com.blueair.auth.GigyaService$GigyaException r1 = (com.blueair.auth.GigyaService.GigyaException) r1
            com.gigya.android.sdk.network.GigyaError r2 = r1.getError()
            int r2 = r2.getErrorCode()
            r3.append(r2)
            java.lang.String r2 = " | "
            r3.append(r2)
            com.gigya.android.sdk.network.GigyaError r5 = r1.getError()
            java.lang.String r5 = r5.getLocalizedMessage()
            r3.append(r5)
            r3.append(r2)
            com.gigya.android.sdk.network.GigyaError r2 = r1.getError()
            java.lang.String r2 = r2.getData()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r0.e(r10, r2, r3)
            r9.reportError(r8, r1)
        L_0x0126:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.emailLogin(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.blueair.auth.GigyaService} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emailRegister(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27, kotlin.coroutines.Continuation<? super com.blueair.auth.GigyaAccountExtended> r28) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            boolean r9 = r8 instanceof com.blueair.auth.GigyaService$emailRegister$1
            if (r9 == 0) goto L_0x0026
            r9 = r8
            com.blueair.auth.GigyaService$emailRegister$1 r9 = (com.blueair.auth.GigyaService$emailRegister$1) r9
            int r10 = r9.label
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = r10 & r11
            if (r10 == 0) goto L_0x0026
            int r8 = r9.label
            int r8 = r8 - r11
            r9.label = r8
            goto L_0x002b
        L_0x0026:
            com.blueair.auth.GigyaService$emailRegister$1 r9 = new com.blueair.auth.GigyaService$emailRegister$1
            r9.<init>(r1, r8)
        L_0x002b:
            java.lang.Object r8 = r9.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r11 = r9.label
            r12 = 1
            r13 = 0
            if (r11 == 0) goto L_0x0077
            if (r11 != r12) goto L_0x006f
            int r0 = r9.I$1
            int r0 = r9.I$0
            boolean r0 = r9.Z$1
            boolean r0 = r9.Z$0
            java.lang.Object r0 = r9.L$7
            com.blueair.auth.GigyaService$emailRegister$1 r0 = (com.blueair.auth.GigyaService$emailRegister$1) r0
            java.lang.Object r0 = r9.L$6
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r9.L$5
            r3 = r0
            com.blueair.auth.GigyaService r3 = (com.blueair.auth.GigyaService) r3
            java.lang.Object r0 = r9.L$4
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.L$3
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x006a }
            r16 = r13
            goto L_0x0199
        L_0x006a:
            r0 = move-exception
            r16 = r13
            goto L_0x01ac
        L_0x006f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "register"
            r9.L$0 = r0     // Catch:{ all -> 0x01a4 }
            r9.L$1 = r2     // Catch:{ all -> 0x01a4 }
            r9.L$2 = r3     // Catch:{ all -> 0x01a4 }
            r9.L$3 = r4     // Catch:{ all -> 0x01a4 }
            r9.L$4 = r5     // Catch:{ all -> 0x01a4 }
            r9.L$5 = r1     // Catch:{ all -> 0x01a4 }
            r9.L$6 = r8     // Catch:{ all -> 0x01a4 }
            r9.L$7 = r9     // Catch:{ all -> 0x01a4 }
            r9.Z$0 = r6     // Catch:{ all -> 0x01a4 }
            r9.Z$1 = r7     // Catch:{ all -> 0x01a4 }
            r9.I$0 = r13     // Catch:{ all -> 0x01a4 }
            r9.I$1 = r13     // Catch:{ all -> 0x01a4 }
            r9.label = r12     // Catch:{ all -> 0x01a4 }
            r11 = r9
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x01a4 }
            kotlin.coroutines.SafeContinuation r14 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x01a4 }
            kotlin.coroutines.Continuation r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r11)     // Catch:{ all -> 0x01a4 }
            r14.<init>(r11)     // Catch:{ all -> 0x01a4 }
            r11 = r14
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x01a4 }
            com.gigya.android.sdk.Gigya r15 = r1.getGigya()     // Catch:{ all -> 0x01a4 }
            r15.logout()     // Catch:{ all -> 0x01a4 }
            com.blueair.auth.AuthService r15 = r1.getAuthService()     // Catch:{ all -> 0x01a4 }
            r15.clearUserData()     // Catch:{ all -> 0x01a4 }
            r1.initializeGigya()     // Catch:{ all -> 0x01a4 }
            com.gigya.android.sdk.Gigya r15 = r1.getGigya()     // Catch:{ all -> 0x01a4 }
            r28 = r12
            r12 = 5
            kotlin.Pair[] r12 = new kotlin.Pair[r12]     // Catch:{ all -> 0x01a4 }
            r16 = r13
            java.lang.String r13 = "profile"
            r17 = r8
            com.squareup.moshi.Moshi r8 = r1.getMoshi()     // Catch:{ all -> 0x019e }
            r18 = r9
            java.lang.Class<com.blueair.auth.ProfileDto> r9 = com.blueair.auth.ProfileDto.class
            com.squareup.moshi.JsonAdapter r8 = r8.adapter(r9)     // Catch:{ all -> 0x019e }
            if (r5 == 0) goto L_0x00e1
            com.blueair.auth.Phone r9 = new com.blueair.auth.Phone     // Catch:{ all -> 0x019e }
            r19 = r12
            java.lang.String r12 = "mobile"
            r9.<init>(r5, r12)     // Catch:{ all -> 0x019e }
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r9)     // Catch:{ all -> 0x019e }
            goto L_0x00e4
        L_0x00e1:
            r19 = r12
            r5 = 0
        L_0x00e4:
            com.blueair.auth.ProfileDto r9 = new com.blueair.auth.ProfileDto     // Catch:{ all -> 0x019e }
            r9.<init>(r0, r2, r5)     // Catch:{ all -> 0x019e }
            java.lang.String r0 = r8.toJson(r9)     // Catch:{ all -> 0x019e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r0)     // Catch:{ all -> 0x019e }
            r19[r16] = r0     // Catch:{ all -> 0x019e }
            java.lang.String r0 = "preferences"
            java.lang.String r2 = r1.getPreferences()     // Catch:{ all -> 0x019e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)     // Catch:{ all -> 0x019e }
            r19[r28] = r0     // Catch:{ all -> 0x019e }
            java.lang.String r0 = "subscriptions"
            com.squareup.moshi.Moshi r2 = r1.getMoshi()     // Catch:{ all -> 0x019e }
            java.lang.Class<com.blueair.auth.SubscriptionsDto> r5 = com.blueair.auth.SubscriptionsDto.class
            com.squareup.moshi.JsonAdapter r2 = r2.adapter(r5)     // Catch:{ all -> 0x019e }
            com.blueair.auth.SubscriptionsDto r5 = new com.blueair.auth.SubscriptionsDto     // Catch:{ all -> 0x019e }
            com.blueair.auth.OptInOptOut r8 = new com.blueair.auth.OptInOptOut     // Catch:{ all -> 0x019e }
            com.blueair.auth.BrandXxBh8488Eml r9 = new com.blueair.auth.BrandXxBh8488Eml     // Catch:{ all -> 0x019e }
            com.blueair.auth.Email r12 = new com.blueair.auth.Email     // Catch:{ all -> 0x019e }
            r12.<init>(r7)     // Catch:{ all -> 0x019e }
            r9.<init>(r12)     // Catch:{ all -> 0x019e }
            com.blueair.auth.Unilever r7 = new com.blueair.auth.Unilever     // Catch:{ all -> 0x019e }
            com.blueair.auth.Email r12 = new com.blueair.auth.Email     // Catch:{ all -> 0x019e }
            r12.<init>(r6)     // Catch:{ all -> 0x019e }
            r7.<init>(r12)     // Catch:{ all -> 0x019e }
            r8.<init>(r9, r7)     // Catch:{ all -> 0x019e }
            r5.<init>(r8)     // Catch:{ all -> 0x019e }
            java.lang.String r2 = r2.toJson(r5)     // Catch:{ all -> 0x019e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)     // Catch:{ all -> 0x019e }
            r2 = 2
            r19[r2] = r0     // Catch:{ all -> 0x019e }
            java.lang.String r0 = "lang"
            com.blueair.auth.LocationService r5 = r1.locationService     // Catch:{ all -> 0x019e }
            java.lang.String r5 = r5.getCountry()     // Catch:{ all -> 0x019e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r5)     // Catch:{ all -> 0x019e }
            r5 = 3
            r19[r5] = r0     // Catch:{ all -> 0x019e }
            java.lang.String r0 = "data"
            com.squareup.moshi.Moshi r5 = r1.getMoshi()     // Catch:{ all -> 0x019e }
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            com.squareup.moshi.JsonAdapter r5 = r5.adapter(r6)     // Catch:{ all -> 0x019e }
            kotlin.Pair[] r2 = new kotlin.Pair[r2]     // Catch:{ all -> 0x019e }
            java.lang.String r6 = "source"
            java.lang.String r7 = "app"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r7)     // Catch:{ all -> 0x019e }
            r2[r16] = r6     // Catch:{ all -> 0x019e }
            java.lang.String r6 = "platform"
            java.lang.String r7 = "android"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r7)     // Catch:{ all -> 0x019e }
            r2[r28] = r6     // Catch:{ all -> 0x019e }
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r2)     // Catch:{ all -> 0x019e }
            java.lang.String r2 = r5.toJson(r2)     // Catch:{ all -> 0x019e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)     // Catch:{ all -> 0x019e }
            r2 = 4
            r19[r2] = r0     // Catch:{ all -> 0x019e }
            java.util.Map r0 = kotlin.collections.MapsKt.mutableMapOf(r19)     // Catch:{ all -> 0x019e }
            com.blueair.auth.GigyaService$LoginCallback r2 = new com.blueair.auth.GigyaService$LoginCallback     // Catch:{ all -> 0x019e }
            r2.<init>(r1, r11)     // Catch:{ all -> 0x019e }
            com.gigya.android.sdk.GigyaLoginCallback r2 = (com.gigya.android.sdk.GigyaLoginCallback) r2     // Catch:{ all -> 0x019e }
            r15.register(r3, r4, r0, r2)     // Catch:{ all -> 0x019e }
            java.lang.Object r8 = r14.getOrThrow()     // Catch:{ all -> 0x019e }
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x019e }
            if (r8 != r0) goto L_0x0193
            r9 = r18
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x019e }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r9)     // Catch:{ all -> 0x019e }
        L_0x0193:
            if (r8 != r10) goto L_0x0196
            return r10
        L_0x0196:
            r3 = r1
            r2 = r17
        L_0x0199:
            com.blueair.auth.GigyaAccountExtended r8 = (com.blueair.auth.GigyaAccountExtended) r8     // Catch:{ all -> 0x019c }
            return r8
        L_0x019c:
            r0 = move-exception
            goto L_0x01ac
        L_0x019e:
            r0 = move-exception
            goto L_0x01a9
        L_0x01a0:
            r0 = move-exception
            r17 = r8
            goto L_0x01a9
        L_0x01a4:
            r0 = move-exception
            r17 = r8
            r16 = r13
        L_0x01a9:
            r3 = r1
            r2 = r17
        L_0x01ac:
            boolean r4 = r0 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r5 = "] "
            java.lang.String r6 = "Gigya error ["
            if (r4 != 0) goto L_0x01e1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            r7.append(r5)
            java.lang.String r5 = r0.getLocalizedMessage()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6 = r16
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.e(r0, r5, r6)
            java.lang.String r4 = r0.getLocalizedMessage()
            if (r4 != 0) goto L_0x01db
            java.lang.String r4 = ""
        L_0x01db:
            java.lang.String r5 = "-1"
            r3.reportError(r2, r5, r4)
            goto L_0x0227
        L_0x01e1:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            r7.append(r5)
            r5 = r0
            com.blueair.auth.GigyaService$GigyaException r5 = (com.blueair.auth.GigyaService.GigyaException) r5
            com.gigya.android.sdk.network.GigyaError r6 = r5.getError()
            int r6 = r6.getErrorCode()
            r7.append(r6)
            java.lang.String r6 = " | "
            r7.append(r6)
            com.gigya.android.sdk.network.GigyaError r8 = r5.getError()
            java.lang.String r8 = r8.getLocalizedMessage()
            r7.append(r8)
            r7.append(r6)
            com.gigya.android.sdk.network.GigyaError r6 = r5.getError()
            java.lang.String r6 = r6.getData()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r4.e(r0, r6, r7)
            r3.reportError(r2, r5)
        L_0x0227:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.emailRegister(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/auth/GigyaService$LoginCallback;", "Lcom/gigya/android/sdk/GigyaLoginCallback;", "Lcom/blueair/auth/GigyaAccountExtended;", "cont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lcom/blueair/auth/GigyaService;Lkotlin/coroutines/Continuation;)V", "onSuccess", "", "account", "onError", "error", "Lcom/gigya/android/sdk/network/GigyaError;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaService.kt */
    private class LoginCallback extends GigyaLoginCallback<GigyaAccountExtended> {
        private final Continuation<GigyaAccountExtended> cont;
        final /* synthetic */ GigyaService this$0;

        public LoginCallback(GigyaService gigyaService, Continuation<? super GigyaAccountExtended> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "cont");
            this.this$0 = gigyaService;
            this.cont = continuation;
        }

        public void onSuccess(GigyaAccountExtended gigyaAccountExtended) {
            Intrinsics.checkNotNullParameter(gigyaAccountExtended, "account");
            if (gigyaAccountExtended.getDisabled()) {
                Continuation<GigyaAccountExtended> continuation = this.cont;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(new Exception("403047"))));
                return;
            }
            GigyaService gigyaService = this.this$0;
            String uid = gigyaAccountExtended.getUID();
            if (uid == null) {
                uid = "";
            }
            gigyaService.setGigyaUid(uid);
            Timber.Forest forest = Timber.Forest;
            forest.d("gigya.data: " + gigyaAccountExtended.getData(), new Object[0]);
            String format = String.format(PrefKeys.AppRegionFetched, Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            PreferencesHelper.INSTANCE.set(this.this$0.getSecurePrefs().getBackend(), format, true, Reflection.getOrCreateKotlinClass(Boolean.class));
            String appRegion = gigyaAccountExtended.getData().getAppRegion();
            GigyaService gigyaService2 = this.this$0;
            if (appRegion == null) {
                gigyaService2.setGigyaBlueCloudDomain(BlueCloudDomain.Companion.getINVALID());
            } else {
                BlueCloudDomain domainForRegion = BlueCloudDomain.Companion.getDomainForRegion(appRegion, true);
                BlueCloudDomain blueCloudDomain = gigyaService2.getBlueCloudDomain();
                if (!Intrinsics.areEqual((Object) domainForRegion.getHost(), (Object) blueCloudDomain.getHost())) {
                    Timber.Forest forest2 = Timber.Forest;
                    forest2.w("cloud region mismatch: old=" + blueCloudDomain.getHost() + " | gigya=" + domainForRegion.getHost(), new Object[0]);
                    gigyaService2.getAuthService().resetCloudJwt();
                    Function0<Unit> clearDataFunc = gigyaService2.getClearDataFunc();
                    if (clearDataFunc != null) {
                        clearDataFunc.invoke();
                    }
                }
                gigyaService2.setGigyaBlueCloudDomain(domainForRegion);
            }
            Continuation<GigyaAccountExtended> continuation2 = this.cont;
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m9366constructorimpl(gigyaAccountExtended));
        }

        public void onError(GigyaError gigyaError) {
            Intrinsics.checkNotNullParameter(gigyaError, "error");
            String gigyaUid = this.this$0.getGigyaUid();
            GigyaService gigyaService = this.this$0;
            if (gigyaUid.length() > 0) {
                AnalyticsService analyticsService = gigyaService.getAnalyticsService();
                String gigyaDataCenter = gigyaService.getGigyaDataCenter();
                String valueOf = String.valueOf(gigyaError.getErrorCode());
                String localizedMessage = gigyaError.getLocalizedMessage();
                Intrinsics.checkNotNullExpressionValue(localizedMessage, "getLocalizedMessage(...)");
                String data = gigyaError.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                analyticsService.event(new AnalyticEvent.GigyaGetAccountErrorEvent(gigyaUid, gigyaDataCenter, valueOf, localizedMessage, data));
            }
            Continuation<GigyaAccountExtended> continuation = this.cont;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(new GigyaException(gigyaError))));
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012 \u0010\t\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/auth/GigyaService$RegisterCallback;", "Lcom/blueair/auth/GigyaService$LoginCallback;", "Lcom/blueair/auth/GigyaService;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/blueair/auth/GigyaAccountExtended;", "preferences", "", "lang", "getPassword", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/auth/GigyaService;Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onPendingRegistration", "response", "Lcom/gigya/android/sdk/api/GigyaApiResponse;", "resolver", "Lcom/gigya/android/sdk/interruption/IPendingRegistrationResolver;", "onConflictingAccounts", "Lcom/gigya/android/sdk/interruption/link/ILinkAccountsResolver;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaService.kt */
    private final class RegisterCallback extends LoginCallback {
        private final CancellableContinuation<GigyaAccountExtended> cont;
        private final Function1<Function1<? super String, Unit>, Unit> getPassword;
        private final String lang;
        private final String preferences;
        final /* synthetic */ GigyaService this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RegisterCallback(GigyaService gigyaService, CancellableContinuation<? super GigyaAccountExtended> cancellableContinuation, String str, String str2, Function1<? super Function1<? super String, Unit>, Unit> function1) {
            super(gigyaService, cancellableContinuation);
            Intrinsics.checkNotNullParameter(cancellableContinuation, "cont");
            Intrinsics.checkNotNullParameter(str, GigyaDefinitions.AccountIncludes.PREFERENCES);
            Intrinsics.checkNotNullParameter(str2, "lang");
            Intrinsics.checkNotNullParameter(function1, "getPassword");
            this.this$0 = gigyaService;
            this.cont = cancellableContinuation;
            this.preferences = str;
            this.lang = str2;
            this.getPassword = function1;
        }

        public void onPendingRegistration(GigyaApiResponse gigyaApiResponse, IPendingRegistrationResolver iPendingRegistrationResolver) {
            Intrinsics.checkNotNullParameter(gigyaApiResponse, "response");
            Intrinsics.checkNotNullParameter(iPendingRegistrationResolver, "resolver");
            iPendingRegistrationResolver.setAccount(MapsKt.mutableMapOf(TuplesKt.to(GigyaDefinitions.AccountIncludes.PREFERENCES, this.preferences), TuplesKt.to("lang", this.lang)));
        }

        public void onConflictingAccounts(GigyaApiResponse gigyaApiResponse, ILinkAccountsResolver iLinkAccountsResolver) {
            Intrinsics.checkNotNullParameter(gigyaApiResponse, "response");
            Intrinsics.checkNotNullParameter(iLinkAccountsResolver, "resolver");
            this.getPassword.invoke(new GigyaService$RegisterCallback$$ExternalSyntheticLambda0(this, iLinkAccountsResolver));
        }

        /* access modifiers changed from: private */
        public static final Unit onConflictingAccounts$lambda$0(RegisterCallback registerCallback, ILinkAccountsResolver iLinkAccountsResolver, String str) {
            if (str == null) {
                CancellableContinuation.DefaultImpls.cancel$default(registerCallback.cont, (Throwable) null, 1, (Object) null);
            } else {
                iLinkAccountsResolver.linkToSite(iLinkAccountsResolver.getConflictingAccounts().getLoginID(), str);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fa A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object forgotPassword(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.blueair.auth.GigyaService$forgotPassword$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.blueair.auth.GigyaService$forgotPassword$1 r0 = (com.blueair.auth.GigyaService$forgotPassword$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$forgotPassword$1 r0 = new com.blueair.auth.GigyaService$forgotPassword$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x008b
            if (r2 == r5) goto L_0x006e
            if (r2 == r4) goto L_0x0051
            if (r2 != r3) goto L_0x0049
            int r11 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r11 = r0.L$3
            com.blueair.auth.GigyaService$forgotPassword$1 r11 = (com.blueair.auth.GigyaService$forgotPassword$1) r11
            java.lang.Object r11 = r0.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r0.L$1
            com.blueair.auth.GigyaService r1 = (com.blueair.auth.GigyaService) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0046 }
            goto L_0x0103
        L_0x0046:
            r12 = move-exception
            goto L_0x0114
        L_0x0049:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0051:
            int r11 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$1
            com.blueair.auth.GigyaService r5 = (com.blueair.auth.GigyaService) r5
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0069 }
            r12 = r2
            r2 = r11
            r11 = r4
            goto L_0x00c2
        L_0x0069:
            r12 = move-exception
            r11 = r4
        L_0x006b:
            r1 = r5
            goto L_0x0114
        L_0x006e:
            int r11 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r0.L$1
            com.blueair.auth.GigyaService r7 = (com.blueair.auth.GigyaService) r7
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0086 }
            r12 = r5
            r5 = r2
            r2 = r11
            r11 = r8
            goto L_0x00aa
        L_0x0086:
            r12 = move-exception
            r11 = r5
        L_0x0088:
            r1 = r7
            goto L_0x0114
        L_0x008b:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = "forgotPassword"
            com.blueair.auth.AuthService r2 = r10.getAuthService()     // Catch:{ all -> 0x010f }
            r0.L$0 = r11     // Catch:{ all -> 0x010f }
            r0.L$1 = r10     // Catch:{ all -> 0x010f }
            r0.L$2 = r12     // Catch:{ all -> 0x010f }
            r0.I$0 = r6     // Catch:{ all -> 0x010f }
            r0.I$1 = r6     // Catch:{ all -> 0x010f }
            r0.label = r5     // Catch:{ all -> 0x010f }
            java.lang.Object r2 = r2.updateGigyaDataCenter(r0)     // Catch:{ all -> 0x010f }
            if (r2 != r1) goto L_0x00a7
            goto L_0x0101
        L_0x00a7:
            r7 = r10
            r2 = r6
            r5 = r2
        L_0x00aa:
            r0.L$0 = r11     // Catch:{ all -> 0x0109 }
            r0.L$1 = r7     // Catch:{ all -> 0x0109 }
            r0.L$2 = r12     // Catch:{ all -> 0x0109 }
            r0.I$0 = r5     // Catch:{ all -> 0x0109 }
            r0.I$1 = r2     // Catch:{ all -> 0x0109 }
            r0.label = r4     // Catch:{ all -> 0x0109 }
            java.lang.Object r4 = r10.doGigyaDataCentersHaveEmailAddress(r11, r0)     // Catch:{ all -> 0x0109 }
            if (r4 != r1) goto L_0x00bd
            goto L_0x0101
        L_0x00bd:
            r9 = r7
            r7 = r11
            r11 = r12
            r12 = r5
            r5 = r9
        L_0x00c2:
            r0.L$0 = r7     // Catch:{ all -> 0x0106 }
            r0.L$1 = r5     // Catch:{ all -> 0x0106 }
            r0.L$2 = r11     // Catch:{ all -> 0x0106 }
            r0.L$3 = r0     // Catch:{ all -> 0x0106 }
            r0.I$0 = r12     // Catch:{ all -> 0x0106 }
            r0.I$1 = r2     // Catch:{ all -> 0x0106 }
            r0.label = r3     // Catch:{ all -> 0x0106 }
            r12 = r0
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ all -> 0x0106 }
            kotlin.coroutines.SafeContinuation r2 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x0106 }
            kotlin.coroutines.Continuation r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r12)     // Catch:{ all -> 0x0106 }
            r2.<init>(r12)     // Catch:{ all -> 0x0106 }
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ all -> 0x0106 }
            r10.initializeGigya()     // Catch:{ all -> 0x0106 }
            com.gigya.android.sdk.Gigya r3 = r10.getGigya()     // Catch:{ all -> 0x0106 }
            com.blueair.auth.GigyaService$forgotPassword$2$1$1 r4 = new com.blueair.auth.GigyaService$forgotPassword$2$1$1     // Catch:{ all -> 0x0106 }
            r4.<init>(r12)     // Catch:{ all -> 0x0106 }
            com.gigya.android.sdk.GigyaCallback r4 = (com.gigya.android.sdk.GigyaCallback) r4     // Catch:{ all -> 0x0106 }
            r3.forgotPassword((java.lang.String) r7, (com.gigya.android.sdk.GigyaCallback<com.gigya.android.sdk.api.GigyaApiResponse>) r4)     // Catch:{ all -> 0x0106 }
            java.lang.Object r12 = r2.getOrThrow()     // Catch:{ all -> 0x0106 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0106 }
            if (r12 != r2) goto L_0x00ff
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0106 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0106 }
        L_0x00ff:
            if (r12 != r1) goto L_0x0102
        L_0x0101:
            return r1
        L_0x0102:
            r1 = r5
        L_0x0103:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0046 }
            return r11
        L_0x0106:
            r12 = move-exception
            goto L_0x006b
        L_0x0109:
            r11 = move-exception
            r1 = r12
            r12 = r11
            r11 = r1
            goto L_0x0088
        L_0x010f:
            r11 = move-exception
            r1 = r12
            r12 = r11
            r11 = r1
            r1 = r10
        L_0x0114:
            boolean r0 = r12 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r2 = "] "
            java.lang.String r3 = "Gigya error ["
            if (r0 != 0) goto L_0x0147
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r11)
            r4.append(r2)
            java.lang.String r2 = r12.getLocalizedMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r0.e(r12, r2, r3)
            java.lang.String r0 = r12.getLocalizedMessage()
            if (r0 != 0) goto L_0x0141
            java.lang.String r0 = ""
        L_0x0141:
            java.lang.String r2 = "-1"
            r1.reportError(r11, r2, r0)
            goto L_0x018c
        L_0x0147:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r11)
            r4.append(r2)
            r2 = r12
            com.blueair.auth.GigyaService$GigyaException r2 = (com.blueair.auth.GigyaService.GigyaException) r2
            com.gigya.android.sdk.network.GigyaError r3 = r2.getError()
            int r3 = r3.getErrorCode()
            r4.append(r3)
            java.lang.String r3 = " | "
            r4.append(r3)
            com.gigya.android.sdk.network.GigyaError r5 = r2.getError()
            java.lang.String r5 = r5.getLocalizedMessage()
            r4.append(r5)
            r4.append(r3)
            com.gigya.android.sdk.network.GigyaError r3 = r2.getError()
            java.lang.String r3 = r3.getData()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r0.e(r12, r3, r4)
            r1.reportError(r11, r2)
        L_0x018c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.forgotPassword(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getProfile(kotlin.coroutines.Continuation<? super com.blueair.auth.GigyaAccountExtended> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.blueair.auth.GigyaService$getProfile$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.blueair.auth.GigyaService$getProfile$1 r0 = (com.blueair.auth.GigyaService$getProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$getProfile$1 r0 = new com.blueair.auth.GigyaService$getProfile$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r1 = r0.L$2
            com.blueair.auth.GigyaService$getProfile$1 r1 = (com.blueair.auth.GigyaService$getProfile$1) r1
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaService r0 = (com.blueair.auth.GigyaService) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x003b }
            goto L_0x00a3
        L_0x003b:
            r11 = move-exception
            goto L_0x00aa
        L_0x003d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "getAccount"
            r0.L$0 = r10     // Catch:{ all -> 0x00a6 }
            r0.L$1 = r11     // Catch:{ all -> 0x00a6 }
            r0.L$2 = r0     // Catch:{ all -> 0x00a6 }
            r0.I$0 = r4     // Catch:{ all -> 0x00a6 }
            r0.I$1 = r4     // Catch:{ all -> 0x00a6 }
            r0.label = r3     // Catch:{ all -> 0x00a6 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00a6 }
            kotlin.coroutines.SafeContinuation r5 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x00a6 }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x00a6 }
            r5.<init>(r2)     // Catch:{ all -> 0x00a6 }
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00a6 }
            com.gigya.android.sdk.Gigya r6 = r10.getGigya()     // Catch:{ all -> 0x00a6 }
            r7 = 2
            kotlin.Pair[] r7 = new kotlin.Pair[r7]     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "extraProfileFields"
            java.lang.String r9 = "phones"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)     // Catch:{ all -> 0x00a6 }
            r7[r4] = r8     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "include"
            java.lang.String r9 = "subscriptions, data, profile"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)     // Catch:{ all -> 0x00a6 }
            r7[r3] = r8     // Catch:{ all -> 0x00a6 }
            java.util.Map r3 = kotlin.collections.MapsKt.mutableMapOf(r7)     // Catch:{ all -> 0x00a6 }
            com.blueair.auth.GigyaService$getProfile$2$1$1 r7 = new com.blueair.auth.GigyaService$getProfile$2$1$1     // Catch:{ all -> 0x00a6 }
            r7.<init>(r2)     // Catch:{ all -> 0x00a6 }
            com.gigya.android.sdk.GigyaCallback r7 = (com.gigya.android.sdk.GigyaCallback) r7     // Catch:{ all -> 0x00a6 }
            r6.getAccount((java.util.Map<java.lang.String, java.lang.Object>) r3, r7)     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r5.getOrThrow()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00a6 }
            if (r2 != r3) goto L_0x009d
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00a6 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00a6 }
        L_0x009d:
            if (r2 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            r0 = r10
            r1 = r11
            r11 = r2
        L_0x00a3:
            com.blueair.auth.GigyaAccountExtended r11 = (com.blueair.auth.GigyaAccountExtended) r11     // Catch:{ all -> 0x003b }
            return r11
        L_0x00a6:
            r0 = move-exception
            r1 = r11
            r11 = r0
            r0 = r10
        L_0x00aa:
            boolean r2 = r11 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r3 = "] "
            java.lang.String r5 = "Gigya error ["
            if (r2 != 0) goto L_0x00dd
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r1)
            r6.append(r3)
            java.lang.String r3 = r11.getLocalizedMessage()
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r2.e(r11, r3, r4)
            java.lang.String r2 = r11.getLocalizedMessage()
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = ""
        L_0x00d7:
            java.lang.String r3 = "-1"
            r0.reportError(r1, r3, r2)
            goto L_0x0122
        L_0x00dd:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r1)
            r6.append(r3)
            r3 = r11
            com.blueair.auth.GigyaService$GigyaException r3 = (com.blueair.auth.GigyaService.GigyaException) r3
            com.gigya.android.sdk.network.GigyaError r5 = r3.getError()
            int r5 = r5.getErrorCode()
            r6.append(r5)
            java.lang.String r5 = " | "
            r6.append(r5)
            com.gigya.android.sdk.network.GigyaError r7 = r3.getError()
            java.lang.String r7 = r7.getLocalizedMessage()
            r6.append(r7)
            r6.append(r5)
            com.gigya.android.sdk.network.GigyaError r5 = r3.getError()
            java.lang.String r5 = r5.getData()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r2.e(r11, r5, r4)
            r0.reportError(r1, r3)
        L_0x0122:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.getProfile(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateProfile(com.blueair.auth.GigyaAccountExtended r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService$updateProfile$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.auth.GigyaService$updateProfile$1 r0 = (com.blueair.auth.GigyaService$updateProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$updateProfile$1 r0 = new com.blueair.auth.GigyaService$updateProfile$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 != r3) goto L_0x0043
            int r8 = r0.I$1
            int r8 = r0.I$0
            boolean r8 = r0.Z$0
            java.lang.Object r8 = r0.L$3
            com.blueair.auth.GigyaService$updateProfile$1 r8 = (com.blueair.auth.GigyaService$updateProfile$1) r8
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$1
            com.blueair.auth.GigyaService r9 = (com.blueair.auth.GigyaService) r9
            java.lang.Object r0 = r0.L$0
            com.blueair.auth.GigyaAccountExtended r0 = (com.blueair.auth.GigyaAccountExtended) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0041 }
            goto L_0x0093
        L_0x0041:
            r10 = move-exception
            goto L_0x009b
        L_0x0043:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "setAccount"
            r0.L$0 = r8     // Catch:{ all -> 0x0096 }
            r0.L$1 = r7     // Catch:{ all -> 0x0096 }
            r0.L$2 = r10     // Catch:{ all -> 0x0096 }
            r0.L$3 = r0     // Catch:{ all -> 0x0096 }
            r0.Z$0 = r9     // Catch:{ all -> 0x0096 }
            r0.I$0 = r4     // Catch:{ all -> 0x0096 }
            r0.I$1 = r4     // Catch:{ all -> 0x0096 }
            r0.label = r3     // Catch:{ all -> 0x0096 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x0096 }
            kotlin.coroutines.SafeContinuation r3 = new kotlin.coroutines.SafeContinuation     // Catch:{ all -> 0x0096 }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x0096 }
            r3.<init>(r2)     // Catch:{ all -> 0x0096 }
            r2 = r3
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x0096 }
            com.gigya.android.sdk.Gigya r5 = r7.getGigya()     // Catch:{ all -> 0x0096 }
            com.gigya.android.sdk.account.models.GigyaAccount r8 = (com.gigya.android.sdk.account.models.GigyaAccount) r8     // Catch:{ all -> 0x0096 }
            com.blueair.auth.GigyaService$updateProfile$2$1$1 r6 = new com.blueair.auth.GigyaService$updateProfile$2$1$1     // Catch:{ all -> 0x0096 }
            r6.<init>(r9, r2)     // Catch:{ all -> 0x0096 }
            com.gigya.android.sdk.GigyaCallback r6 = (com.gigya.android.sdk.GigyaCallback) r6     // Catch:{ all -> 0x0096 }
            r5.setAccount(r8, r6)     // Catch:{ all -> 0x0096 }
            java.lang.Object r8 = r3.getOrThrow()     // Catch:{ all -> 0x0096 }
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0096 }
            if (r8 != r9) goto L_0x008e
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0096 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0096 }
        L_0x008e:
            if (r8 != r1) goto L_0x0091
            return r1
        L_0x0091:
            r9 = r7
            r8 = r10
        L_0x0093:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            return r8
        L_0x0096:
            r8 = move-exception
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
        L_0x009b:
            boolean r0 = r10 instanceof com.blueair.auth.GigyaService.GigyaException
            java.lang.String r1 = "] "
            java.lang.String r2 = "Gigya error ["
            if (r0 != 0) goto L_0x00ce
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r10.getLocalizedMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r0.e(r10, r1, r2)
            java.lang.String r0 = r10.getLocalizedMessage()
            if (r0 != 0) goto L_0x00c8
            java.lang.String r0 = ""
        L_0x00c8:
            java.lang.String r1 = "-1"
            r9.reportError(r8, r1, r0)
            goto L_0x0113
        L_0x00ce:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            r3.append(r1)
            r1 = r10
            com.blueair.auth.GigyaService$GigyaException r1 = (com.blueair.auth.GigyaService.GigyaException) r1
            com.gigya.android.sdk.network.GigyaError r2 = r1.getError()
            int r2 = r2.getErrorCode()
            r3.append(r2)
            java.lang.String r2 = " | "
            r3.append(r2)
            com.gigya.android.sdk.network.GigyaError r5 = r1.getError()
            java.lang.String r5 = r5.getLocalizedMessage()
            r3.append(r5)
            r3.append(r2)
            com.gigya.android.sdk.network.GigyaError r2 = r1.getError()
            java.lang.String r2 = r2.getData()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r0.e(r10, r2, r3)
            r9.reportError(r8, r1)
        L_0x0113:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.updateProfile(com.blueair.auth.GigyaAccountExtended, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkGigyaTokenExpiry(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.blueair.auth.GigyaService$checkGigyaTokenExpiry$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.auth.GigyaService$checkGigyaTokenExpiry$1 r0 = (com.blueair.auth.GigyaService$checkGigyaTokenExpiry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.GigyaService$checkGigyaTokenExpiry$1 r0 = new com.blueair.auth.GigyaService$checkGigyaTokenExpiry$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x004c
            if (r2 == r5) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            int r1 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0037 }
            goto L_0x006f
        L_0x0037:
            r9 = move-exception
            goto L_0x007b
        L_0x0039:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0041:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            goto L_0x005f
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.gigyaTokenExpiryMutex
            r0.L$0 = r9
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r9.lock(r6, r0)
            if (r2 != r1) goto L_0x005e
            goto L_0x006d
        L_0x005e:
            r2 = r3
        L_0x005f:
            r0.L$0 = r9     // Catch:{ all -> 0x0077 }
            r0.I$0 = r2     // Catch:{ all -> 0x0077 }
            r0.I$1 = r3     // Catch:{ all -> 0x0077 }
            r0.label = r4     // Catch:{ all -> 0x0077 }
            java.lang.Object r0 = r8.refreshGigyaTokenIfExpired(r0)     // Catch:{ all -> 0x0077 }
            if (r0 != r1) goto L_0x006e
        L_0x006d:
            return r1
        L_0x006e:
            r0 = r9
        L_0x006f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            r0.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0077:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x007b:
            r0.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaService.checkGigyaTokenExpiry(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T> T runWithErrorReport(String str, T t, Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Throwable th) {
            if (th instanceof GigyaException) {
                Timber.Forest forest = Timber.Forest;
                StringBuilder sb = new StringBuilder("Gigya error [");
                sb.append(str);
                sb.append("] ");
                GigyaException gigyaException = th;
                sb.append(gigyaException.getError().getErrorCode());
                sb.append(" | ");
                sb.append(gigyaException.getError().getLocalizedMessage());
                sb.append(" | ");
                sb.append(gigyaException.getError().getData());
                forest.e(th, sb.toString(), new Object[0]);
                reportError(str, gigyaException);
            } else {
                Timber.Forest forest2 = Timber.Forest;
                forest2.e(th, "Gigya error [" + str + "] " + th.getLocalizedMessage(), new Object[0]);
                String localizedMessage = th.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "";
                }
                reportError(str, "-1", localizedMessage);
            }
            if (t != null) {
                return t;
            }
            throw th;
        }
    }

    static /* synthetic */ Object runWithErrorReport$default(GigyaService gigyaService, String str, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        try {
            return function0.invoke();
        } catch (Throwable th) {
            if (th instanceof GigyaException) {
                Timber.Forest forest = Timber.Forest;
                StringBuilder sb = new StringBuilder("Gigya error [");
                sb.append(str);
                sb.append("] ");
                GigyaException gigyaException = th;
                sb.append(gigyaException.getError().getErrorCode());
                sb.append(" | ");
                sb.append(gigyaException.getError().getLocalizedMessage());
                sb.append(" | ");
                sb.append(gigyaException.getError().getData());
                forest.e(th, sb.toString(), new Object[0]);
                gigyaService.reportError(str, gigyaException);
            } else {
                Timber.Forest forest2 = Timber.Forest;
                forest2.e(th, "Gigya error [" + str + "] " + th.getLocalizedMessage(), new Object[0]);
                String localizedMessage = th.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "";
                }
                gigyaService.reportError(str, "-1", localizedMessage);
            }
            if (obj != null) {
                return obj;
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void reportError(String str, GigyaException gigyaException) {
        GigyaError error = gigyaException.getError();
        String valueOf = String.valueOf(error.getErrorCode());
        reportError(str, valueOf, error.getLocalizedMessage() + " | " + error.getData());
    }

    /* access modifiers changed from: private */
    public final void reportError(String str, String str2, String str3) {
        this.analyticsService.event(new AnalyticEvent.GigyaErrorEvent(str, str2, str3));
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/auth/GigyaService$Companion;", "", "<init>", "()V", "USA", "", "CANADA", "EUROPE", "CHINA", "AUSTRALIA", "EXPIRY_LENGTH_SECONDS", "", "DEFAULT_USER_NAME", "API_REGISTER", "API_LOGIN", "API_LOGIN_SOCIAL", "API_LOGOUT", "API_FORGOT_PASSWORD", "API_GET_ACCOUNT", "API_SET_ACCOUNT", "API_SEND_GET_JWT", "API_IS_ACCOUNT_AVAILABLE", "API_SEND_DELETE_ACCOUNT", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
