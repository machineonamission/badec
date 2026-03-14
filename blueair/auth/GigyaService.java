package com.blueair.auth;

import android.content.Context;
import android.util.Log;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.blueair.auth.retrofit.GigyaApi;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.sdk.BugfenderSdk;
import com.gigya.android.sdk.Gigya;
import com.gigya.android.sdk.GigyaCallback;
import com.gigya.android.sdk.GigyaLogger;
import com.gigya.android.sdk.GigyaLoginCallback;
import com.gigya.android.sdk.account.GigyaAccountConfig;
import com.gigya.android.sdk.api.GigyaApiResponse;
import com.gigya.android.sdk.interruption.IPendingRegistrationResolver;
import com.gigya.android.sdk.interruption.link.ILinkAccountsResolver;
import com.gigya.android.sdk.network.GigyaError;
import com.gigya.android.sdk.session.SessionInfo;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Ï\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\bÌ\u0001Í\u0001Î\u0001Ï\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0083\u0001\u001a\u00020sH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020'2\u0007\u0010\u0085\u0001\u001a\u00020'H\u0002J\u0010\u0010\u0086\u0001\u001a\u00020sH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010\u008a\u0001\u001a\u00020sH\u0082@¢\u0006\u0003\u0010\u0087\u0001J\n\u0010\u008b\u0001\u001a\u00030\u0089\u0001H\u0002J\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\n\u0010\u008e\u0001\u001a\u00030\u0089\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020sH\u0016J\u0012\u0010\u0090\u0001\u001a\u0004\u0018\u00010'H\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010\u0091\u0001\u001a\u00020sH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0012\u0010\u0092\u0001\u001a\u0004\u0018\u00010'H\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010\u0093\u0001\u001a\u00020sH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0014\u0010\u0094\u0001\u001a\u00020s2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010'H\u0002J\u001b\u0010\u0096\u0001\u001a\u00020*2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010'H\u0086@¢\u0006\u0003\u0010\u0098\u0001J\u001a\u0010\u0099\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u009a\u0001\u001a\u00020'H\u0087@¢\u0006\u0003\u0010\u0098\u0001J\u0011\u0010\u009d\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u009e\u0001\u001a\u00020'J\u0012\u0010\u009f\u0001\u001a\u00020s2\u0007\u0010 \u0001\u001a\u00020*H\u0002J\u0012\u0010¡\u0001\u001a\u00020s2\u0007\u0010 \u0001\u001a\u00020*H\u0002J\t\u0010¢\u0001\u001a\u00020*H\u0002J\u0010\u0010£\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010¤\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010¥\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010¦\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0010\u0010§\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J\u0019\u0010¨\u0001\u001a\u00020z2\u0007\u0010©\u0001\u001a\u00020'H\u0082@¢\u0006\u0003\u0010\u0098\u0001J\"\u0010ª\u0001\u001a\u00020z2\u0007\u0010\u009a\u0001\u001a\u00020'2\u0007\u0010«\u0001\u001a\u00020'H\u0086@¢\u0006\u0003\u0010¬\u0001JS\u0010\u00ad\u0001\u001a\u00020z2\u0007\u0010®\u0001\u001a\u00020'2\u0007\u0010¯\u0001\u001a\u00020'2\u0007\u0010\u009a\u0001\u001a\u00020'2\u0007\u0010«\u0001\u001a\u00020'2\t\u0010°\u0001\u001a\u0004\u0018\u00010'2\b\u0010±\u0001\u001a\u00030\u0089\u00012\b\u0010²\u0001\u001a\u00030\u0089\u0001H\u0086@¢\u0006\u0003\u0010³\u0001J\u0019\u0010´\u0001\u001a\u00020s2\u0007\u0010\u009a\u0001\u001a\u00020'H\u0086@¢\u0006\u0003\u0010\u0098\u0001J\u0010\u0010µ\u0001\u001a\u00020zH\u0086@¢\u0006\u0003\u0010\u0087\u0001J#\u0010¶\u0001\u001a\u00020s2\u0007\u0010·\u0001\u001a\u00020z2\b\u0010¸\u0001\u001a\u00030\u0089\u0001H\u0086@¢\u0006\u0003\u0010¹\u0001J\u0010\u0010¼\u0001\u001a\u00020sH\u0086@¢\u0006\u0003\u0010\u0087\u0001J?\u0010½\u0001\u001a\u0003H¾\u0001\"\u0005\b\u0000\u0010¾\u00012\u0007\u0010¿\u0001\u001a\u00020'2\f\b\u0002\u0010À\u0001\u001a\u0005\u0018\u0001H¾\u00012\u000e\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u0003H¾\u00010~H\u0082\b¢\u0006\u0003\u0010Â\u0001J\u001c\u0010Ã\u0001\u001a\u00020s2\u0007\u0010¿\u0001\u001a\u00020'2\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0002J$\u0010Ã\u0001\u001a\u00020s2\u0007\u0010¿\u0001\u001a\u00020'2\u0007\u0010Æ\u0001\u001a\u00020'2\u0007\u0010Ç\u0001\u001a\u00020'H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b0\u0010.R+\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020,8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b3\u0010.\"\u0004\b4\u00105R+\u00108\u001a\u00020,2\u0006\u00101\u001a\u00020,8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u00107\u001a\u0004\b9\u0010.\"\u0004\b:\u00105R+\u0010<\u001a\u00020,2\u0006\u00101\u001a\u00020,8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b?\u00107\u001a\u0004\b=\u0010.\"\u0004\b>\u00105R\u0011\u0010@\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\bD\u0010BR\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u001b\u001a\u0004\bG\u0010HR\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u001b\u001a\u0004\bL\u0010MR!\u0010O\u001a\b\u0012\u0004\u0012\u00020'0P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bQ\u0010RR5\u0010U\u001a&\u0012\f\u0012\n W*\u0004\u0018\u00010'0' W*\u0012\u0012\f\u0012\n W*\u0004\u0018\u00010'0'\u0018\u00010V0V8F¢\u0006\u0006\u001a\u0004\bX\u0010YR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010T\u001a\u0004\b\\\u0010RR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020[0V8F¢\u0006\u0006\u001a\u0004\b_\u0010YR+\u0010`\u001a\u00020'2\u0006\u00101\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bd\u00107\u001a\u0004\ba\u0010B\"\u0004\bb\u0010cR&\u0010f\u001a\u00020'2\u0006\u0010e\u001a\u00020'8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010B\"\u0004\bh\u0010cR#\u0010i\u001a\n W*\u0004\u0018\u00010j0j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u001b\u001a\u0004\bk\u0010lR#\u0010n\u001a\n W*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u001b\u001a\u0004\bo\u0010BR4\u0010q\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020s0rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR8\u0010x\u001a&\u0012\f\u0012\n W*\u0004\u0018\u00010z0z W*\u0012\u0012\f\u0012\n W*\u0004\u0018\u00010z0z\u0018\u00010y0y8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R%\u0010}\u001a\n\u0012\u0004\u0012\u00020s\u0018\u00010~X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0010\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010È\u0001\u001a\u00030É\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001¨\u0006Ð\u0001"},
   d2 = {"Lcom/blueair/auth/GigyaService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "locationService", "Lcom/blueair/auth/LocationService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Landroid/content/Context;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/AnalyticsService;)V", "getContext", "()Landroid/content/Context;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "getSecurePrefs", "()Lcom/blueair/core/service/SecurePrefs;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "gigyaBaseUrl", "", "dataCenterList", "", "Lcom/blueair/auth/GigyaServer;", "fallbackBlueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getFallbackBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "blueCloudDomain", "getBlueCloudDomain", "<set-?>", "gigyaBlueCloudDomain", "getGigyaBlueCloudDomain", "setGigyaBlueCloudDomain", "(Lcom/blueair/auth/BlueCloudDomain;)V", "gigyaBlueCloudDomain$delegate", "Lkotlin/properties/ReadWriteProperty;", "forceBlueCloudDomain", "getForceBlueCloudDomain", "setForceBlueCloudDomain", "forceBlueCloudDomain$delegate", "deprecatedBlueCloudDomain", "getDeprecatedBlueCloudDomain", "setDeprecatedBlueCloudDomain", "deprecatedBlueCloudDomain$delegate", "cloudUserRegion", "getCloudUserRegion", "()Ljava/lang/String;", "gigyaDataCenter", "getGigyaDataCenter", "gigyaRestAdapter", "Lretrofit2/Retrofit;", "getGigyaRestAdapter", "()Lretrofit2/Retrofit;", "gigyaRestAdapter$delegate", "gigyaApi", "Lcom/blueair/auth/retrofit/GigyaApi;", "getGigyaApi", "()Lcom/blueair/auth/retrofit/GigyaApi;", "gigyaApi$delegate", "gigyaJwtPublisher", "Lio/reactivex/subjects/PublishSubject;", "getGigyaJwtPublisher", "()Lio/reactivex/subjects/PublishSubject;", "gigyaJwtPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "gigyaJwtObserver", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "getGigyaJwtObserver", "()Lio/reactivex/Observable;", "loggedOutPublisher", "", "getLoggedOutPublisher", "loggedOutPublisher$delegate", "loggedOutObserver", "getLoggedOutObserver", "gigyaUid", "getGigyaUid", "setGigyaUid", "(Ljava/lang/String;)V", "gigyaUid$delegate", "value", "gigyaJwt", "getGigyaJwt", "setGigyaJwt", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "preferences", "getPreferences", "preferences$delegate", "getPassword", "Lkotlin/Function1;", "", "getGetPassword", "()Lkotlin/jvm/functions/Function1;", "setGetPassword", "(Lkotlin/jvm/functions/Function1;)V", "gigya", "Lcom/gigya/android/sdk/Gigya;", "Lcom/blueair/auth/GigyaAccountExtended;", "getGigya", "()Lcom/gigya/android/sdk/Gigya;", "clearDataFunc", "Lkotlin/Function0;", "getClearDataFunc", "()Lkotlin/jvm/functions/Function0;", "setClearDataFunc", "(Lkotlin/jvm/functions/Function0;)V", "initializeGigya", "dataCenterFromURL", "url", "refreshGigyaTokenIfExpired", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRefreshingToken", "", "refreshTokens", "isGigyaSessionValid", "millisUntilGigyaTokenExpires", "", "isGigyaTokenExpired", "logOut", "refreshGigyaJwt", "refreshGigyaData", "refreshGigyaUid", "deleteAccount", "setClosestDataCenterForRegion", "region", "updateGigyaDataCenter", "ablRegion", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doGigyaDataCentersHaveEmailAddress", "email", "DATE_FORMAT_WY", "Ljava/text/SimpleDateFormat;", "unixTimeFromDateGigya", "date", "saveUserGigyaServer", "server", "saveUserBlueCloudDomain", "loadUserGigyaServer", "facebookLogin", "googleLogin", "appleLogin", "weChatLogin", "qqLogin", "socialLogin", "socialProvider", "emailLogin", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emailRegister", "firstName", "lastName", "phoneNumber", "subscribe", "consentDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", "getProfile", "updateProfile", "account", "recordUserInfoCollection", "(Lcom/blueair/auth/GigyaAccountExtended;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gigyaTokenExpiryMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkGigyaTokenExpiry", "runWithErrorReport", "T", "api", "failure", "block", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportError", "error", "Lcom/blueair/auth/GigyaService$GigyaException;", "errorCode", "errorMessage", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "GigyaException", "LoginCallback", "RegisterCallback", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GigyaService implements CoroutineScope, LogOutable, DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(GigyaService.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(GigyaService.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(GigyaService.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(GigyaService.class, "gigyaBlueCloudDomain", "getGigyaBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(GigyaService.class, "forceBlueCloudDomain", "getForceBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(GigyaService.class, "deprecatedBlueCloudDomain", "getDeprecatedBlueCloudDomain()Lcom/blueair/auth/BlueCloudDomain;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(GigyaService.class, "gigyaJwtPublisher", "getGigyaJwtPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(GigyaService.class, "loggedOutPublisher", "getLoggedOutPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(GigyaService.class, "gigyaUid", "getGigyaUid()Ljava/lang/String;", 0)))};
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
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DEFAULT_USER_NAME = "-";
   public static final String EUROPE = "eu";
   public static final int EXPIRY_LENGTH_SECONDS = 2592000;
   public static final String USA = "us";
   private final DefaultCoroutineScope $$delegate_0;
   private final SimpleDateFormat DATE_FORMAT_WY;
   private final AnalyticsService analyticsService;
   private final Lazy authService$delegate;
   private Function0 clearDataFunc;
   private final Context context;
   private List dataCenterList;
   private final ReadWriteProperty deprecatedBlueCloudDomain$delegate;
   private final Lazy di$delegate;
   private final ReadWriteProperty forceBlueCloudDomain$delegate;
   public Function1 getPassword;
   private final Lazy gigyaApi$delegate;
   private String gigyaBaseUrl;
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
   private final Lazy networkMonitor$delegate;
   private final Lazy preferences$delegate;
   private final SecurePrefs securePrefs;

   // $FF: synthetic method
   public static String $r8$lambda$Wq85Z7FIs_QAn52okeu6h1btfLM(GigyaService var0) {
      return preferences_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static Moshi $r8$lambda$jlir8to6nzOUjqo58c2Hv31FsmA() {
      return moshi_delegate$lambda$5();
   }

   // $FF: synthetic method
   public static GigyaApi $r8$lambda$k_nHj9bnD0EhmXrikRiOoCDGnU4/* $FF was: $r8$lambda$k-nHj9bnD0EhmXrikRiOoCDGnU4*/(GigyaService var0) {
      return gigyaApi_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Response $r8$lambda$uKpibRLa_ktsc2QWBx4Q85jiLLs(GigyaService var0, Interceptor.Chain var1) {
      return gigyaRestAdapter_delegate$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Retrofit $r8$lambda$uWdI0fvsTfShPe4nAK8OzswBwgw(GigyaService var0) {
      return gigyaRestAdapter_delegate$lambda$3(var0);
   }

   public GigyaService(Context var1, LocationService var2, SecurePrefs var3, AnalyticsService var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "locationService");
      Intrinsics.checkNotNullParameter(var3, "securePrefs");
      Intrinsics.checkNotNullParameter(var4, "analyticsService");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.context = var1;
      this.locationService = var2;
      this.securePrefs = var3;
      this.analyticsService = var4;
      LazyContextDIPropertyDelegateProvider var10 = ClosestKt.closestDI(var1);
      KProperty[] var5 = $$delegatedProperties;
      this.di$delegate = var10.provideDelegate(this, var5[0]);
      DIAware var11 = this;
      JVMTypeToken var15 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var11, (TypeToken)(new GenericJVMTypeTokenDelegate(var15, AuthService.class)), (Object)null).provideDelegate(this, var5[1]);
      var15 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var11, (TypeToken)(new GenericJVMTypeTokenDelegate(var15, NetworkMonitor.class)), (Object)null).provideDelegate(this, var5[2]);
      this.dataCenterList = GigyaServer.Companion.getALL_SERVERS();
      Prefs var6 = var3;
      BlueCloudDomain var12 = BlueCloudDomain.Companion.getINVALID();
      this.gigyaBlueCloudDomain$delegate = (ReadWriteProperty)(new ObservableProperty(var6, "gigya_domain_blue", var12, PreferencesHelper.INSTANCE.get(var6.getBackend(), "gigya_domain_blue", var12, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class));
            }

         }
      });
      Prefs var13 = var3;
      BlueCloudDomain var7 = BlueCloudDomain.Companion.getINVALID();
      this.forceBlueCloudDomain$delegate = (ReadWriteProperty)(new ObservableProperty(var13, "force_domain_blue", var7, PreferencesHelper.INSTANCE.get(var13.getBackend(), "force_domain_blue", var7, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class));
            }

         }
      });
      Prefs var8 = var3;
      BlueCloudDomain var14 = this.getFallbackBlueCloudDomain();
      this.deprecatedBlueCloudDomain$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "domain_blue", var14, PreferencesHelper.INSTANCE.get(var8.getBackend(), "domain_blue", var14, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(BlueCloudDomain.class));
            }

         }
      });
      this.gigyaRestAdapter$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda1(this));
      this.gigyaApi$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda2(this));
      this.gigyaJwtPublisher$delegate = new LazyPublishSubject();
      this.loggedOutPublisher$delegate = new LazyPublishSubject();
      var8 = var3;
      this.gigyaUid$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "gigya_uid", "", PreferencesHelper.INSTANCE.get(var8.getBackend(), "gigya_uid", "", Reflection.getOrCreateKotlinClass(String.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(String.class));
            }

         }
      });
      this.gigyaJwt = "";
      this.moshi$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda3());
      this.preferences$delegate = LazyKt.lazy(new GigyaService$$ExternalSyntheticLambda4(this));
      GigyaLogger.setDebugMode(BuildEnvironment.INSTANCE.isRelease() ^ true);
      this.initializeGigya();
      if (((CharSequence)this.getGigyaJwt()).length() != 0 && this.isGigyaSessionValid()) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final GigyaService this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  if (Intrinsics.areEqual(this.this$0.getGigyaBlueCloudDomain(), BlueCloudDomain.Companion.getINVALID())) {
                     Prefs var5 = this.this$0.getSecurePrefs();
                     String var6 = String.format("app_region_fetched_%s", Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
                     Intrinsics.checkNotNullExpressionValue(var6, "format(...)");
                     Boolean var4 = Boxing.boxBoolean(false);
                     if (!(Boolean)PreferencesHelper.INSTANCE.get(var5.getBackend(), var6, var4, Reflection.getOrCreateKotlinClass(Boolean.class))) {
                        GigyaService var7 = this.this$0;
                        Continuation var14 = (Continuation)this;
                        this.label = 1;
                        if (var7.refreshGigyaData(var14) == var3) {
                           return var3;
                        }
                     }
                  }
               }

               Prefs var15 = this.this$0.getSecurePrefs();
               String var8 = String.format("cloud_region_mismatch_checked_%s", Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
               Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
               Boolean var11 = Boxing.boxBoolean(false);
               if (!(Boolean)PreferencesHelper.INSTANCE.get(var15.getBackend(), var8, var11, Reflection.getOrCreateKotlinClass(Boolean.class))) {
                  String var12 = this.this$0.getBlueCloudDomain().regionCodeShort();
                  if (!Intrinsics.areEqual(this.this$0.getGigyaDataCenter(), var12)) {
                     if (Intrinsics.areEqual(var12, this.this$0.getForceBlueCloudDomain().regionCodeShort())) {
                        var8 = "dev";
                     } else if (Intrinsics.areEqual(var12, this.this$0.getGigyaBlueCloudDomain().regionCodeShort())) {
                        var8 = "appRegion";
                     } else {
                        var8 = "others";
                     }

                     StringBuilder var16 = new StringBuilder("GigyaCloudRegionMismatchEvent: ");
                     var16.append(this.this$0.getGigyaUid());
                     var16.append(" | ");
                     var16.append(this.this$0.getGigyaDataCenter());
                     var16.append(" -> ");
                     var16.append(var12);
                     var16.append(" | ");
                     var16.append(var8);
                     Log.w("GigyaService", var16.toString());
                     this.this$0.getAnalyticsService().event(new AnalyticEvent.GigyaCloudRegionMismatchEvent(this.this$0.getGigyaUid(), this.this$0.getGigyaDataCenter(), var12, var8));
                  }

                  var15 = this.this$0.getSecurePrefs();
                  var12 = String.format("cloud_region_mismatch_checked_%s", Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
                  Intrinsics.checkNotNullExpressionValue(var12, "format(...)");
                  Boolean var10 = Boxing.boxBoolean(true);
                  PreferencesHelper.INSTANCE.set(var15.getBackend(), var12, var10, Reflection.getOrCreateKotlinClass(Boolean.class));
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

      this.DATE_FORMAT_WY = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      this.gigyaTokenExpiryMutex = MutexKt.Mutex$default(false, 1, (Object)null);
   }

   // $FF: synthetic method
   public static final Gigya access$getGigya(GigyaService var0) {
      return var0.getGigya();
   }

   // $FF: synthetic method
   public static final String access$getPreferences(GigyaService var0) {
      return var0.getPreferences();
   }

   // $FF: synthetic method
   public static final void access$initializeGigya(GigyaService var0) {
      var0.initializeGigya();
   }

   private final String dataCenterFromURL(String var1) {
      return (new Regex("http[s]://?[^.]+\\.")).replaceFirst((CharSequence)var1, "");
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final BlueCloudDomain getDeprecatedBlueCloudDomain() {
      return (BlueCloudDomain)this.deprecatedBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[5]);
   }

   private final Gigya getGigya() {
      return Gigya.getInstance(GigyaAccountExtended.class);
   }

   private final GigyaApi getGigyaApi() {
      Object var1 = this.gigyaApi$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (GigyaApi)var1;
   }

   private final PublishSubject getGigyaJwtPublisher() {
      return this.gigyaJwtPublisher$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private final Retrofit getGigyaRestAdapter() {
      Object var1 = this.gigyaRestAdapter$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Retrofit)var1;
   }

   private final PublishSubject getLoggedOutPublisher() {
      return this.loggedOutPublisher$delegate.getValue(this, $$delegatedProperties[7]);
   }

   private final Moshi getMoshi() {
      return (Moshi)this.moshi$delegate.getValue();
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   private final String getPreferences() {
      return (String)this.preferences$delegate.getValue();
   }

   private static final GigyaApi gigyaApi_delegate$lambda$4(GigyaService var0) {
      return (GigyaApi)var0.getGigyaRestAdapter().create(GigyaApi.class);
   }

   private static final Retrofit gigyaRestAdapter_delegate$lambda$3(GigyaService var0) {
      Timber.Forest.i("starting gigya Rest Adapter", new Object[0]);
      GigyaService$$ExternalSyntheticLambda0 var2 = new GigyaService$$ExternalSyntheticLambda0(var0);
      HttpLoggingInterceptor var3 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var1;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var1 = Level.NONE;
      } else {
         var1 = Level.BODY;
      }

      var3.setLevel(var1);
      OkHttpClient var5 = (new OkHttpClient.Builder()).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).addInterceptor((Interceptor)var3).addInterceptor(var2).build();
      Retrofit.Builder var6 = new Retrofit.Builder();
      String var4 = var0.gigyaBaseUrl;
      Intrinsics.checkNotNull(var4);
      return var6.baseUrl(var4).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).client(var5).build();
   }

   private static final Response gigyaRestAdapter_delegate$lambda$3$lambda$2(GigyaService var0, Interceptor.Chain var1) {
      Intrinsics.checkNotNullParameter(var1, "chain");
      Request var2 = var1.request();
      HttpUrl.Companion var3 = HttpUrl.Companion;
      String var4 = var0.gigyaBaseUrl;
      Intrinsics.checkNotNull(var4);
      HttpUrl var7 = var3.parse(var4);
      Intrinsics.checkNotNull(var7);
      var4 = var7.scheme();
      String var8 = var7.host();
      HttpUrl var6 = var2.url().newBuilder().scheme(var4).host(var8).build();
      return var1.proceed(var2.newBuilder().url(var6).build());
   }

   private final void initializeGigya() {
      GigyaServer var1 = this.loadUserGigyaServer();
      String var2 = this.dataCenterFromURL(var1.getUrl());
      Gigya var4 = this.getGigya();
      var4.init(var1.getApiKey(), var2);
      GigyaAccountConfig var3 = new GigyaAccountConfig();
      var3.setInclude(new String[]{"data", "profile", "emails"});
      var3.setExtraProfileFields(new String[]{"languages", "phones"});
      var4.setAccountConfig(var3);
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("Gigya initialized: server=");
      var6.append(var1.getCountryCode());
      var6.append(", datacenter=");
      var6.append(var2);
      var5.d(var6.toString(), new Object[0]);
   }

   private final boolean isGigyaSessionValid() {
      if (this.getGigya().getSession() == null) {
         this.initializeGigya();
      }

      if (this.getGigya().getSession() != null) {
         SessionInfo var1 = this.getGigya().getSession();
         if (var1 != null && var1.isValid()) {
            return true;
         }
      }

      return false;
   }

   private final boolean isGigyaTokenExpired() {
      return ((CharSequence)this.getGigyaJwt()).length() == 0 ? true : JwtUtilsKt.isExpReached(new JWT(this.getGigyaJwt()));
   }

   private final GigyaServer loadUserGigyaServer() {
      Object var4;
      GigyaServer var12;
      label48: {
         String var2 = this.getGigyaJwt();
         int var1 = ((CharSequence)var2).length();
         var4 = null;
         if (var1 != 0) {
            Claim var6 = (Claim)(new JWT(var2)).getClaims().get("apiKey");
            String var7;
            if (var6 != null) {
               var7 = var6.asString();
            } else {
               var7 = null;
            }

            CharSequence var3 = (CharSequence)var7;
            if (var3 != null && var3.length() != 0) {
               Iterator var5 = ((Iterable)GigyaServer.Companion.getALL_SERVERS()).iterator();

               while(true) {
                  if (!var5.hasNext()) {
                     var8 = null;
                     break;
                  }

                  Object var13 = var5.next();
                  if (Intrinsics.areEqual(((GigyaServer)var13).getApiKey(), var7)) {
                     var8 = var13;
                     break;
                  }
               }

               var12 = (GigyaServer)var8;
               break label48;
            }
         }

         var12 = null;
      }

      GigyaServer var9 = var12;
      if (var12 == null) {
         Prefs var10 = this.securePrefs;
         String var14 = (String)PreferencesHelper.INSTANCE.get(var10.getBackend(), "gigya_server", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
         Iterator var15 = ((Iterable)GigyaServer.Companion.getALL_SERVERS()).iterator();

         do {
            var11 = var4;
            if (!var15.hasNext()) {
               break;
            }

            var11 = var15.next();
         } while(!Intrinsics.areEqual(((GigyaServer)var11).getCountryCode(), var14));

         var9 = (GigyaServer)var11;
         if (var9 == null) {
            var9 = GigyaServer.EUROPE.INSTANCE;
         }
      }

      BugfenderSdk.INSTANCE.setDeviceString("gigya_datacenter", StringsKt.removePrefix(var9.getUrl(), (CharSequence)"https://accounts."));
      return var9;
   }

   private static final Moshi moshi_delegate$lambda$5() {
      return (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build();
   }

   private static final String preferences_delegate$lambda$6(GigyaService var0) {
      return var0.getMoshi().adapter(PreferencesDto.class).toJson(new PreferencesDto(new Cookies(true), new Privacy(new Generic(true)), new AgeConsentGranted(true)));
   }

   private final Object refreshTokens(Continuation var1) {
      label29: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label29;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final GigyaService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.refreshTokens((Continuation)this);
            }
         };
      }

      Object var4 = ((<undefinedtype>)var5).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var4);
      } else {
         ResultKt.throwOnFailure(var4);
         if (this.isRefreshingToken) {
            return Unit.INSTANCE;
         }

         this.isRefreshingToken = true;
         this.initializeGigya();
         ((<undefinedtype>)var5).label = 1;
         if (this.refreshGigyaJwt((Continuation)var5) == var6) {
            return var6;
         }
      }

      this.isRefreshingToken = false;
      return Unit.INSTANCE;
   }

   private final void reportError(String var1, GigyaException var2) {
      GigyaError var5 = var2.getError();
      if (var5.getErrorCode() == 400106 && !this.getNetworkMonitor().getCurrentConnectivityStatus()) {
         Timber.Forest.w("suppress gigya error report: 401006 when network unavailable", new Object[0]);
      } else {
         int var3 = var5.getErrorCode();
         StringBuilder var4 = new StringBuilder();
         var4.append(var5.getLocalizedMessage());
         var4.append(" | ");
         var4.append(var5.getData());
         this.reportError(var1, String.valueOf(var3), var4.toString());
      }
   }

   private final void reportError(String var1, String var2, String var3) {
      this.analyticsService.event(new AnalyticEvent.GigyaErrorEvent(var1, var2, var3));
   }

   private final Object runWithErrorReport(String var1, Object var2, Function0 var3) {
      try {
         Object var12 = var3.invoke();
         return var12;
      } catch (Throwable var8) {
         if (var8 instanceof GigyaException) {
            Timber.Forest var14 = Timber.Forest;
            StringBuilder var11 = new StringBuilder("Gigya error [");
            var11.append(var1);
            var11.append("] ");
            GigyaException var6 = (GigyaException)var8;
            var11.append(var6.getError().getErrorCode());
            var11.append(" | ");
            var11.append(var6.getError().getLocalizedMessage());
            var11.append(" | ");
            var11.append(var6.getError().getData());
            var14.e(var8, var11.toString(), new Object[0]);
            access$reportError(this, var1, var6);
         } else {
            Timber.Forest var9 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("Gigya error [");
            var4.append(var1);
            var4.append("] ");
            var4.append(var8.getLocalizedMessage());
            var9.e(var8, var4.toString(), new Object[0]);
            String var13 = var8.getLocalizedMessage();
            String var10 = var13;
            if (var13 == null) {
               var10 = "";
            }

            access$reportError(this, var1, "-1", var10);
         }

         if (var2 != null) {
            return var2;
         } else {
            throw var8;
         }
      }
   }

   // $FF: synthetic method
   static Object runWithErrorReport$default(GigyaService var0, String var1, Object var2, Function0 var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      try {
         Object var13 = var3.invoke();
         return var13;
      } catch (Throwable var9) {
         if (var9 instanceof GigyaException) {
            Timber.Forest var16 = Timber.Forest;
            StringBuilder var12 = new StringBuilder("Gigya error [");
            var12.append(var1);
            var12.append("] ");
            GigyaException var7 = (GigyaException)var9;
            var12.append(var7.getError().getErrorCode());
            var12.append(" | ");
            var12.append(var7.getError().getLocalizedMessage());
            var12.append(" | ");
            var12.append(var7.getError().getData());
            var16.e(var9, var12.toString(), new Object[0]);
            access$reportError(var0, var1, var7);
         } else {
            Timber.Forest var10 = Timber.Forest;
            StringBuilder var14 = new StringBuilder("Gigya error [");
            var14.append(var1);
            var14.append("] ");
            var14.append(var9.getLocalizedMessage());
            var10.e(var9, var14.toString(), new Object[0]);
            String var15 = var9.getLocalizedMessage();
            String var11 = var15;
            if (var15 == null) {
               var11 = "";
            }

            access$reportError(var0, var1, "-1", var11);
         }

         if (var2 != null) {
            return var2;
         } else {
            throw var9;
         }
      }
   }

   private final void saveUserBlueCloudDomain(GigyaServer var1) {
      this.setDeprecatedBlueCloudDomain(BlueCloudDomain.Companion.getDomainForRegion$default(BlueCloudDomain.Companion, var1.getCountryCode(), (Boolean)null, 2, (Object)null));
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("saveUserBlueCloudDomain: countryCode = ");
      var2.append(var1.getCountryCode());
      var2.append(", domain = ");
      var2.append(this.getBlueCloudDomain());
      var3.v(var2.toString(), new Object[0]);
   }

   private final void saveUserGigyaServer(GigyaServer var1) {
      Prefs var2 = this.securePrefs;
      String var3 = var1.getCountryCode();
      PreferencesHelper.INSTANCE.set(var2.getBackend(), "gigya_server", var3, Reflection.getOrCreateKotlinClass(String.class));
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("saveUserGigyaServer: ");
      var5.append(var1.getCountryCode());
      var4.v(var5.toString(), new Object[0]);
      this.saveUserBlueCloudDomain(var1);
   }

   private final void setClosestDataCenterForRegion(String var1) {
      List var3;
      label34: {
         label33: {
            var3 = CollectionsKt.toMutableList((Collection)this.dataCenterList);
            var1 = RegionUtils.INSTANCE.getCountryCodeFromGigyaRegion(var1);
            if (var1 != null) {
               int var2 = var1.hashCode();
               if (var2 != 3124) {
                  if (var2 != 3166) {
                     if (var2 != 3179) {
                        if (var2 == 3742 && var1.equals("us")) {
                           break label33;
                        }
                     } else if (var1.equals("cn")) {
                        var5 = GigyaServer.CHINA.INSTANCE;
                        break label34;
                     }
                  } else if (var1.equals("ca")) {
                     break label33;
                  }
               } else if (var1.equals("au")) {
                  var5 = GigyaServer.AUSTRALIA.INSTANCE;
                  break label34;
               }
            }

            var5 = GigyaServer.EUROPE.INSTANCE;
            break label34;
         }

         var5 = GigyaServer.USA.INSTANCE;
      }

      var3.remove(var5);
      var3.add(0, var5);
      this.saveUserGigyaServer(var5);
      this.dataCenterList = CollectionsKt.toList((Iterable)var3);
   }

   private final void setDeprecatedBlueCloudDomain(BlueCloudDomain var1) {
      this.deprecatedBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[5], var1);
   }

   private final Object socialLogin(String var1, Continuation var2) {
      label280: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var28 = var4;
               break label280;
            }
         }

         var28 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final GigyaService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.socialLogin((String)null, (Continuation)this);
            }
         };
      }

      Throwable var35;
      label274: {
         Throwable var10000;
         label287: {
            Object var6 = ((<undefinedtype>)var28).result;
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var3 = ((<undefinedtype>)var28).label;
            Object var36;
            if (var3 != 0) {
               if (var3 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var3 = ((<undefinedtype>)var28).I$2;
               var3 = ((<undefinedtype>)var28).I$1;
               var3 = ((<undefinedtype>)var28).I$0;
               <undefinedtype> var26 = (<undefinedtype>)((<undefinedtype>)var28).L$3;
               String var37 = (String)((<undefinedtype>)var28).L$2;
               GigyaService var41 = (GigyaService)((<undefinedtype>)var28).L$1;
               String var27 = (String)((<undefinedtype>)var28).L$0;
               var24 = var41;
               var29 = var37;

               try {
                  ResultKt.throwOnFailure(var6);
               } catch (Throwable var22) {
                  var10000 = var22;
                  boolean var10001 = false;
                  break label287;
               }

               var24 = var41;
               var29 = var37;
               var36 = var6;
            } else {
               ResultKt.throwOnFailure(var6);
               String var34 = String.format("login(%s)", Arrays.copyOf(new Object[]{var1}, 1));
               Intrinsics.checkNotNullExpressionValue(var34, "format(...)");

               try {
                  ((<undefinedtype>)var28).L$0 = var1;
                  ((<undefinedtype>)var28).L$1 = this;
                  ((<undefinedtype>)var28).L$2 = var34;
                  ((<undefinedtype>)var28).L$3 = var28;
                  ((<undefinedtype>)var28).I$0 = 0;
                  ((<undefinedtype>)var28).I$1 = 0;
                  ((<undefinedtype>)var28).I$2 = 0;
                  ((<undefinedtype>)var28).label = 1;
                  Continuation var7 = (Continuation)var28;
                  CancellableContinuationImpl var45 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(var7), 1);
                  var45.initCancellability();
                  CancellableContinuation var49 = (CancellableContinuation)var45;
                  access$getGigya(this).logout();
                  access$getAuthService(this).clearUserData();
                  access$initializeGigya(this);
                  Gigya var8 = access$getGigya(this);
                  LinkedHashMap var9 = new LinkedHashMap();
                  Map var10 = (Map)var9;
                  String var11 = access$getPreferences(this);
                  Intrinsics.checkNotNullExpressionValue(var11, "access$getPreferences(...)");
                  RegisterCallback var51 = new RegisterCallback(var49, var11, this.getLocationService().getCountry(), this.getGetPassword());
                  var8.login(var1, var10, var51);
                  var25 = var45.getResult();
                  if (var25 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                     DebugProbesKt.probeCoroutineSuspended((Continuation)var28);
                  }
               } catch (Throwable var23) {
                  String var39 = var34;
                  var24 = this;
                  var35 = var23;
                  var29 = var39;
                  break label274;
               }

               if (var25 == var5) {
                  return var5;
               }

               Object var30 = var25;
               String var40 = var34;
               var24 = this;
               var36 = var30;
               var29 = var40;
            }

            label254:
            try {
               GigyaAccountExtended var38 = (GigyaAccountExtended)var36;
               return var38;
            } catch (Throwable var21) {
               var10000 = var21;
               boolean var52 = false;
               break label254;
            }
         }

         var35 = var10000;
      }

      if (!(var35 instanceof GigyaException)) {
         Timber.Forest var46 = Timber.Forest;
         StringBuilder var42 = new StringBuilder("Gigya error [");
         var42.append(var29);
         var42.append("] ");
         var42.append(var35.getLocalizedMessage());
         var46.e(var35, var42.toString(), new Object[0]);
         String var47 = var35.getLocalizedMessage();
         String var43 = var47;
         if (var47 == null) {
            var43 = "";
         }

         access$reportError(var24, var29, "-1", var43);
      } else {
         Timber.Forest var48 = Timber.Forest;
         StringBuilder var50 = new StringBuilder("Gigya error [");
         var50.append(var29);
         var50.append("] ");
         GigyaException var44 = (GigyaException)var35;
         var50.append(var44.getError().getErrorCode());
         var50.append(" | ");
         var50.append(var44.getError().getLocalizedMessage());
         var50.append(" | ");
         var50.append(var44.getError().getData());
         var48.e(var35, var50.toString(), new Object[0]);
         access$reportError(var24, var29, var44);
      }

      throw var35;
   }

   public final Object appleLogin(Continuation var1) {
      return this.socialLogin("apple", var1);
   }

   public final Object checkGigyaTokenExpiry(Continuation param1) {
      // $FF: Couldn't be decompiled
   }

   public final Object deleteAccount(Continuation param1) {
      // $FF: Couldn't be decompiled
   }

   public final Object doGigyaDataCentersHaveEmailAddress(String var1, Continuation var2) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, var1, (Continuation)null) {
         final String $email;
         int label;
         final GigyaService this$0;

         {
            this.this$0 = var1;
            this.$email = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$email, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
               ResultKt.throwOnFailure(var1);
               Prefs var2 = this.this$0.getSecurePrefs();
               PreferencesHelper var51 = PreferencesHelper.INSTANCE;
               PrefsBackend var3 = var2.getBackend();
               KClass var4 = Reflection.getOrCreateKotlinClass(String.class);
               String var64 = "";
               var51.set(var3, "gigya_call_id", "", var4);
               Iterable var52 = (Iterable)this.this$0.dataCenterList;
               GigyaService var67 = this.this$0;
               String var68 = this.$email;
               Iterator var7 = var52.iterator();

               while(true) {
                  if (var7.hasNext()) {
                     GigyaServer var5 = (GigyaServer)var7.next();
                     var67.gigyaBaseUrl = var5.getUrl();

                     Throwable var10000;
                     label520: {
                        retrofit2.Response var6;
                        try {
                           var6 = var67.getGigyaApi().checkDataCenterForId(var68, var5.getApiKey()).execute();
                           Timber.Forest var8 = Timber.Forest;
                           StringBuilder var54 = new StringBuilder();
                           var54.append("Gigya user check: dc=");
                           var54.append(var5.getCountryCode());
                           var54.append(", id=");
                           var54.append(var68);
                           var54.append(", response = ");
                           var54.append(var6.body());
                           var8.d(var54.toString(), new Object[0]);
                           var55 = (GigyaApi.UserResponse)var6.body();
                        } catch (Throwable var50) {
                           var10000 = var50;
                           boolean var10001 = false;
                           break label520;
                        }

                        Boolean var56;
                        if (var55 != null) {
                           try {
                              var56 = var55.isAvailable();
                           } catch (Throwable var49) {
                              var10000 = var49;
                              boolean var74 = false;
                              break label520;
                           }
                        } else {
                           var56 = null;
                        }

                        if (var56 == null) {
                           continue;
                        }

                        try {
                           if (var56) {
                              continue;
                           }

                           var57 = (GigyaApi.UserResponse)var6.body();
                        } catch (Throwable var48) {
                           var10000 = var48;
                           boolean var75 = false;
                           break label520;
                        }

                        if (var57 != null) {
                           try {
                              var72 = var57.getCallId();
                           } catch (Throwable var47) {
                              var10000 = var47;
                              boolean var76 = false;
                              break label520;
                           }

                           if (var72 != null) {
                              try {
                                 Prefs var58 = var67.getSecurePrefs();
                                 PreferencesHelper.INSTANCE.set(var58.getBackend(), "gigya_call_id", var72, Reflection.getOrCreateKotlinClass(String.class));
                              } catch (Throwable var46) {
                                 var10000 = var46;
                                 boolean var77 = false;
                                 break label520;
                              }
                           }
                        }

                        label493:
                        try {
                           var67.saveUserGigyaServer(var5);
                           Timber.Forest var62 = Timber.Forest;
                           StringBuilder var73 = new StringBuilder();
                           var73.append("Gigya user found: dc=");
                           var73.append(var5.getCountryCode());
                           var73.append(", id=");
                           var73.append(var68);
                           var73.append(" response=");
                           var73.append(var6);
                           var62.d(var73.toString(), new Object[0]);
                           Boolean var63 = Boxing.boxBoolean(true);
                           return var63;
                        } catch (Throwable var45) {
                           var10000 = var45;
                           boolean var78 = false;
                           break label493;
                        }
                     }

                     Throwable var69 = var10000;
                     if (!(var69 instanceof GigyaException)) {
                        Timber.Forest var59 = Timber.Forest;
                        StringBuilder var70 = new StringBuilder("Gigya error [send(accounts.isAvailableLoginID)] ");
                        var70.append(var69.getLocalizedMessage());
                        var59.e(var69, var70.toString(), new Object[0]);
                        String var60 = var69.getLocalizedMessage();
                        if (var60 == null) {
                           var60 = var64;
                        }

                        var67.reportError("send(accounts.isAvailableLoginID)", "-1", var60);
                     } else {
                        Timber.Forest var61 = Timber.Forest;
                        StringBuilder var71 = new StringBuilder("Gigya error [send(accounts.isAvailableLoginID)] ");
                        GigyaException var66 = (GigyaException)var69;
                        var71.append(var66.getError().getErrorCode());
                        var71.append(" | ");
                        var71.append(var66.getError().getLocalizedMessage());
                        var71.append(" | ");
                        var71.append(var66.getError().getData());
                        var61.e(var69, var71.toString(), new Object[0]);
                        var67.reportError("send(accounts.isAvailableLoginID)", var66);
                     }

                     throw var69;
                  }

                  Timber.Forest var65 = Timber.Forest;
                  StringBuilder var53 = new StringBuilder("Gigya user not found in all datacenters (id=");
                  var53.append(this.$email);
                  var53.append(')');
                  var65.d(var53.toString(), new Object[0]);
                  return Boxing.boxBoolean(false);
               }
            }
         }
      }, var2);
   }

   public final Object emailLogin(String param1, String param2, Continuation param3) {
      // $FF: Couldn't be decompiled
   }

   public final Object emailRegister(String param1, String param2, String param3, String param4, String param5, boolean param6, boolean param7, Continuation param8) {
      // $FF: Couldn't be decompiled
   }

   public final Object facebookLogin(Continuation var1) {
      return this.socialLogin("facebook", var1);
   }

   public final Object forgotPassword(String param1, Continuation param2) {
      // $FF: Couldn't be decompiled
   }

   public final AnalyticsService getAnalyticsService() {
      return this.analyticsService;
   }

   public final BlueCloudDomain getBlueCloudDomain() {
      BlueCloudDomain var1 = this.getForceBlueCloudDomain();
      if (!Intrinsics.areEqual(var1, BlueCloudDomain.Companion.getINVALID())) {
         return var1;
      } else {
         var1 = this.getGigyaBlueCloudDomain();
         return !Intrinsics.areEqual(var1, BlueCloudDomain.Companion.getINVALID()) ? var1 : this.getDeprecatedBlueCloudDomain();
      }
   }

   public final Function0 getClearDataFunc() {
      return this.clearDataFunc;
   }

   public final String getCloudUserRegion() {
      return this.getBlueCloudDomain().regionCodeShort();
   }

   public final Context getContext() {
      return this.context;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final BlueCloudDomain getFallbackBlueCloudDomain() {
      BlueCloudDomain.Companion var1 = BlueCloudDomain.Companion;
      Prefs var2 = this.securePrefs;
      return BlueCloudDomain.Companion.getDomainForRegion$default(var1, (String)PreferencesHelper.INSTANCE.get(var2.getBackend(), "gigya_server", (Object)null, Reflection.getOrCreateKotlinClass(String.class)), (Boolean)null, 2, (Object)null);
   }

   public final BlueCloudDomain getForceBlueCloudDomain() {
      return (BlueCloudDomain)this.forceBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[4]);
   }

   public final Function1 getGetPassword() {
      Function1 var1 = this.getPassword;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("getPassword");
         return null;
      }
   }

   public final BlueCloudDomain getGigyaBlueCloudDomain() {
      return (BlueCloudDomain)this.gigyaBlueCloudDomain$delegate.getValue(this, $$delegatedProperties[3]);
   }

   public final String getGigyaDataCenter() {
      return this.loadUserGigyaServer().getCountryCode();
   }

   public final String getGigyaJwt() {
      if (((CharSequence)this.gigyaJwt).length() == 0) {
         Prefs var1 = this.securePrefs;
         this.gigyaJwt = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "gigya_jwt_auth_token", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
      }

      return this.gigyaJwt;
   }

   public final Observable getGigyaJwtObserver() {
      return this.getGigyaJwtPublisher().hide();
   }

   public final String getGigyaUid() {
      return (String)this.gigyaUid$delegate.getValue(this, $$delegatedProperties[8]);
   }

   public final LocationService getLocationService() {
      return this.locationService;
   }

   public final Observable getLoggedOutObserver() {
      Observable var1 = this.getLoggedOutPublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final Object getProfile(Continuation param1) {
      // $FF: Couldn't be decompiled
   }

   public final SecurePrefs getSecurePrefs() {
      return this.securePrefs;
   }

   public final Object googleLogin(Continuation var1) {
      return this.socialLogin("google", var1);
   }

   public void logOut() {
      String var1 = "";

      try {
         this.initializeGigya();
         this.getGigya().logout();
         this.setGigyaJwt("");
      } catch (Throwable var6) {
         if (!(var6 instanceof GigyaException)) {
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var10 = new StringBuilder("Gigya error [logout] ");
            var10.append(var6.getLocalizedMessage());
            var8.e(var6, var10.toString(), new Object[0]);
            String var9 = var6.getLocalizedMessage();
            if (var9 != null) {
               var1 = var9;
            }

            access$reportError(this, "logout", "-1", var1);
         } else {
            Timber.Forest var7 = Timber.Forest;
            StringBuilder var2 = new StringBuilder("Gigya error [logout] ");
            GigyaException var4 = (GigyaException)var6;
            var2.append(var4.getError().getErrorCode());
            var2.append(" | ");
            var2.append(var4.getError().getLocalizedMessage());
            var2.append(" | ");
            var2.append(var4.getError().getData());
            var7.e(var6, var2.toString(), new Object[0]);
            access$reportError(this, "logout", var4);
         }

         throw var6;
      }
   }

   public final long millisUntilGigyaTokenExpires() {
      if (((CharSequence)this.getGigyaJwt()).length() == 0) {
         return 0L;
      } else {
         JWT var5 = new JWT(this.getGigyaJwt());
         long var3 = System.currentTimeMillis();
         Date var6 = var5.getExpiresAt();
         long var1;
         if (var6 != null) {
            var1 = var6.getTime();
         } else {
            var1 = var3;
         }

         return var1 - var3;
      }
   }

   public final Object qqLogin(Continuation var1) {
      return this.socialLogin("tencent qq", var1);
   }

   public final Object refreshGigyaData(Continuation var1) {
      label172: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var16 = var3;
               break label172;
            }
         }

         var16 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final GigyaService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.refreshGigyaData((Continuation)this);
            }
         };
      }

      Object var6 = ((<undefinedtype>)var16).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var16).label;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var16).I$1;
         var2 = ((<undefinedtype>)var16).I$0;
         <undefinedtype> var19 = (<undefinedtype>)((<undefinedtype>)var16).L$3;
         Unit var4 = (Unit)((<undefinedtype>)var16).L$2;
         String var20 = (String)((<undefinedtype>)var16).L$1;
         GigyaService var23 = (GigyaService)((<undefinedtype>)var16).L$0;

         try {
            ResultKt.throwOnFailure(var6);
         } catch (Throwable var15) {
            if (var15 instanceof GigyaException) {
               Timber.Forest var8 = Timber.Forest;
               StringBuilder var7 = new StringBuilder("Gigya error [");
               var7.append(var20);
               var7.append("] ");
               GigyaException var24 = (GigyaException)var15;
               var7.append(var24.getError().getErrorCode());
               var7.append(" | ");
               var7.append(var24.getError().getLocalizedMessage());
               var7.append(" | ");
               var7.append(var24.getError().getData());
               var8.e(var15, var7.toString(), new Object[0]);
               access$reportError(var23, var20, var24);
            } else {
               Timber.Forest var29 = Timber.Forest;
               StringBuilder var25 = new StringBuilder("Gigya error [");
               var25.append(var20);
               var25.append("] ");
               var25.append(var15.getLocalizedMessage());
               var29.e(var15, var25.toString(), new Object[0]);
               String var30 = var15.getLocalizedMessage();
               String var26 = var30;
               if (var30 == null) {
                  var26 = "";
               }

               access$reportError(var23, var20, "-1", var26);
            }

            if (var4 == null) {
               throw var15;
            }

            return Unit.INSTANCE;
         }
      } else {
         ResultKt.throwOnFailure(var6);
         Timber.Forest.d("refreshGigyaData", new Object[0]);
         String var21 = "getAccount";
         Unit var22 = Unit.INSTANCE;

         try {
            ((<undefinedtype>)var16).L$0 = this;
            ((<undefinedtype>)var16).L$1 = "getAccount";
            ((<undefinedtype>)var16).L$2 = var22;
            ((<undefinedtype>)var16).L$3 = var16;
            ((<undefinedtype>)var16).I$0 = 0;
            ((<undefinedtype>)var16).I$1 = 0;
            ((<undefinedtype>)var16).label = 1;
            Continuation var31 = (Continuation)var16;
            SafeContinuation var27 = new SafeContinuation(IntrinsicsKt.intercepted(var31));
            Continuation var9 = (Continuation)var27;
            Gigya var33 = this.getGigya();
            LoginCallback var32 = new LoginCallback(var9);
            var33.getAccount((GigyaCallback)var32);
            var6 = var27.getOrThrow();
            if (var6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
               DebugProbesKt.probeCoroutineSuspended((Continuation)var16);
            }
         } finally {
            ;
         }

         if (var6 == var5) {
            return var5;
         }
      }

      return Unit.INSTANCE;
   }

   public final Object refreshGigyaJwt(Continuation param1) {
      // $FF: Couldn't be decompiled
   }

   public final Object refreshGigyaTokenIfExpired(Continuation var1) {
      if (this.isGigyaSessionValid() && this.isGigyaTokenExpired()) {
         Timber.Forest.i("Refreshing Gigya JWT Token", new Object[0]);
         Object var2 = this.refreshTokens(var1);
         return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
      } else {
         return Unit.INSTANCE;
      }
   }

   public final Object refreshGigyaUid(Continuation param1) {
      // $FF: Couldn't be decompiled
   }

   public final void setClearDataFunc(Function0 var1) {
      this.clearDataFunc = var1;
   }

   public final void setForceBlueCloudDomain(BlueCloudDomain var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.forceBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[4], var1);
   }

   public final void setGetPassword(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.getPassword = var1;
   }

   public final void setGigyaBlueCloudDomain(BlueCloudDomain var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.gigyaBlueCloudDomain$delegate.setValue(this, $$delegatedProperties[3], var1);
   }

   public final void setGigyaJwt(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      boolean var2;
      if (((CharSequence)this.gigyaJwt).length() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      String var4 = this.gigyaJwt;
      this.gigyaJwt = var1;
      CharSequence var3 = (CharSequence)var1;
      if (var3.length() == 0) {
         this.securePrefs.remove("gigya_jwt_auth_token");
      } else {
         Prefs var5 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var5.getBackend(), "gigya_jwt_auth_token", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

      Timber.Forest var7 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("GigyaJWT updated with new value: ");
      var6.append(var1);
      var7.d(var6.toString(), new Object[0]);
      if (((CharSequence)var4).length() > 0 && !Intrinsics.areEqual(var4, var1)) {
         this.getGigyaJwtPublisher().onNext(var1);
      }

      if (var3.length() == 0 && var2) {
         this.getLoggedOutPublisher().onNext(true);
      }

   }

   public final void setGigyaUid(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.gigyaUid$delegate.setValue(this, $$delegatedProperties[8], var1);
   }

   public final long unixTimeFromDateGigya(String var1) {
      Intrinsics.checkNotNullParameter(var1, "date");

      try {
         long var2 = this.DATE_FORMAT_WY.parse(var1).getTime() / (long)1000;
         return var2;
      } catch (ParseException var6) {
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("unixTimeFromDate failed: ");
         var9.append(var6);
         var5.e(var9.toString(), new Object[0]);
      } catch (NumberFormatException var7) {
         Timber.Forest var8 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("unixTimeFromDate failed: ");
         var4.append(var7);
         var8.e(var4.toString(), new Object[0]);
      }

      return 0L;
   }

   public final Object updateGigyaDataCenter(String var1, Continuation var2) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(this, var1, (Continuation)null) {
         final String $ablRegion;
         int label;
         final GigyaService this$0;

         {
            this.this$0 = var1;
            this.$ablRegion = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$ablRegion, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               LocationService var3 = this.this$0.getLocationService();
               Continuation var5 = (Continuation)this;
               this.label = 1;
               Object var8 = var3.fetchBlueairRegion(var5);
               var1 = var8;
               if (var8 == var4) {
                  return var4;
               }
            }

            String var9 = (String)var1;
            String var6 = var9;
            if (var9 == null) {
               var6 = this.$ablRegion;
               if (var6 != null) {
                  var6 = var6.toLowerCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var6, "toLowerCase(...)");
               } else {
                  var6 = null;
               }
            }

            this.this$0.setClosestDataCenterForRegion(var6);
            return CollectionsKt.first(this.this$0.dataCenterList);
         }
      }, var2);
   }

   public final Object updateProfile(GigyaAccountExtended param1, boolean param2, Continuation param3) {
      // $FF: Couldn't be decompiled
   }

   public final Object weChatLogin(Continuation var1) {
      return this.socialLogin("wechat", var1);
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"},
      d2 = {"Lcom/blueair/auth/GigyaService$Companion;", "", "<init>", "()V", "USA", "", "CANADA", "EUROPE", "CHINA", "AUSTRALIA", "EXPIRY_LENGTH_SECONDS", "", "DEFAULT_USER_NAME", "API_REGISTER", "API_LOGIN", "API_LOGIN_SOCIAL", "API_LOGOUT", "API_FORGOT_PASSWORD", "API_GET_ACCOUNT", "API_SET_ACCOUNT", "API_SEND_GET_JWT", "API_IS_ACCOUNT_AVAILABLE", "API_SEND_DELETE_ACCOUNT", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/auth/GigyaService$GigyaException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/gigya/android/sdk/network/GigyaError;", "<init>", "(Lcom/gigya/android/sdk/network/GigyaError;)V", "getError", "()Lcom/gigya/android/sdk/network/GigyaError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaException extends Exception {
      private final GigyaError error;

      public GigyaException(GigyaError var1) {
         Intrinsics.checkNotNullParameter(var1, "error");
         super(var1.getLocalizedMessage());
         this.error = var1;
      }

      // $FF: synthetic method
      public static GigyaException copy$default(GigyaException var0, GigyaError var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.error;
         }

         return var0.copy(var1);
      }

      public final GigyaError component1() {
         return this.error;
      }

      public final GigyaException copy(GigyaError var1) {
         Intrinsics.checkNotNullParameter(var1, "error");
         return new GigyaException(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof GigyaException)) {
            return false;
         } else {
            GigyaException var2 = (GigyaException)var1;
            return Intrinsics.areEqual(this.error, var2.error);
         }
      }

      public final GigyaError getError() {
         return this.error;
      }

      public int hashCode() {
         return this.error.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("GigyaException(error=");
         var1.append(this.error);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/auth/GigyaService$LoginCallback;", "Lcom/gigya/android/sdk/GigyaLoginCallback;", "Lcom/blueair/auth/GigyaAccountExtended;", "cont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lcom/blueair/auth/GigyaService;Lkotlin/coroutines/Continuation;)V", "onSuccess", "", "account", "onError", "error", "Lcom/gigya/android/sdk/network/GigyaError;", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private class LoginCallback extends GigyaLoginCallback {
      private final Continuation cont;
      final GigyaService this$0;

      public LoginCallback(Continuation var2) {
         Intrinsics.checkNotNullParameter(var2, "cont");
         this.this$0 = GigyaService.this;
         super();
         this.cont = var2;
      }

      public void onError(GigyaError var1) {
         Intrinsics.checkNotNullParameter(var1, "error");
         String var3 = this.this$0.getGigyaUid();
         GigyaService var5 = this.this$0;
         if (((CharSequence)var3).length() > 0) {
            AnalyticsService var4 = var5.getAnalyticsService();
            String var7 = var5.getGigyaDataCenter();
            int var2 = var1.getErrorCode();
            String var10 = var1.getLocalizedMessage();
            Intrinsics.checkNotNullExpressionValue(var10, "getLocalizedMessage(...)");
            String var6 = var1.getData();
            Intrinsics.checkNotNullExpressionValue(var6, "getData(...)");
            var4.event(new AnalyticEvent.GigyaGetAccountErrorEvent(var3, var7, String.valueOf(var2), var10, var6));
         }

         Continuation var9 = this.cont;
         Result.Companion var8 = Result.Companion;
         var9.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)(new GigyaException(var1)))));
      }

      public void onSuccess(GigyaAccountExtended var1) {
         Intrinsics.checkNotNullParameter(var1, "account");
         GigyaService var4 = this.this$0;
         String var3 = var1.getUID();
         String var2 = var3;
         if (var3 == null) {
            var2 = "";
         }

         var4.setGigyaUid(var2);
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var11 = new StringBuilder("gigya.data: ");
         var11.append(var1.getData());
         var7.d(var11.toString(), new Object[0]);
         Prefs var8 = this.this$0.getSecurePrefs();
         String var12 = String.format("app_region_fetched_%s", Arrays.copyOf(new Object[]{this.this$0.getGigyaUid()}, 1));
         Intrinsics.checkNotNullExpressionValue(var12, "format(...)");
         PreferencesHelper.INSTANCE.set(var8.getBackend(), var12, true, Reflection.getOrCreateKotlinClass(Boolean.class));
         var12 = var1.getData().getAppRegion();
         GigyaService var9 = this.this$0;
         if (var12 == null) {
            var9.setGigyaBlueCloudDomain(BlueCloudDomain.Companion.getINVALID());
         } else {
            BlueCloudDomain var14 = BlueCloudDomain.Companion.getDomainForRegion(var12, true);
            BlueCloudDomain var5 = var9.getBlueCloudDomain();
            if (!Intrinsics.areEqual(var14.getHost(), var5.getHost())) {
               Timber.Forest var16 = Timber.Forest;
               StringBuilder var6 = new StringBuilder("cloud region mismatch: old=");
               var6.append(var5.getHost());
               var6.append(" | gigya=");
               var6.append(var14.getHost());
               var16.w(var6.toString(), new Object[0]);
               var9.getAuthService().resetCloudJwt();
               Function0 var17 = var9.getClearDataFunc();
               if (var17 != null) {
                  var17.invoke();
               }
            }

            var9.setGigyaBlueCloudDomain(var14);
         }

         Continuation var10 = this.cont;
         Result.Companion var15 = Result.Companion;
         var10.resumeWith(Result.constructor-impl(var1));
      }
   }

   @Metadata(
      d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012 \u0010\t\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"},
      d2 = {"Lcom/blueair/auth/GigyaService$RegisterCallback;", "Lcom/blueair/auth/GigyaService$LoginCallback;", "Lcom/blueair/auth/GigyaService;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/blueair/auth/GigyaAccountExtended;", "preferences", "", "lang", "getPassword", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/auth/GigyaService;Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onPendingRegistration", "response", "Lcom/gigya/android/sdk/api/GigyaApiResponse;", "resolver", "Lcom/gigya/android/sdk/interruption/IPendingRegistrationResolver;", "onConflictingAccounts", "Lcom/gigya/android/sdk/interruption/link/ILinkAccountsResolver;", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private final class RegisterCallback extends LoginCallback {
      private final CancellableContinuation cont;
      private final Function1 getPassword;
      private final String lang;
      private final String preferences;
      final GigyaService this$0;

      // $FF: synthetic method
      public static Unit $r8$lambda$08vsXZ1p07DeYZGCI9LQTB3F0a4(RegisterCallback var0, ILinkAccountsResolver var1, String var2) {
         return onConflictingAccounts$lambda$0(var0, var1, var2);
      }

      public RegisterCallback(CancellableContinuation var2, String var3, String var4, Function1 var5) {
         Intrinsics.checkNotNullParameter(var2, "cont");
         Intrinsics.checkNotNullParameter(var3, "preferences");
         Intrinsics.checkNotNullParameter(var4, "lang");
         Intrinsics.checkNotNullParameter(var5, "getPassword");
         this.this$0 = GigyaService.this;
         super((Continuation)var2);
         this.cont = var2;
         this.preferences = var3;
         this.lang = var4;
         this.getPassword = var5;
      }

      private static final Unit onConflictingAccounts$lambda$0(RegisterCallback var0, ILinkAccountsResolver var1, String var2) {
         if (var2 == null) {
            kotlinx.coroutines.CancellableContinuation.DefaultImpls.cancel$default(var0.cont, (Throwable)null, 1, (Object)null);
         } else {
            var1.linkToSite(var1.getConflictingAccounts().getLoginID(), var2);
         }

         return Unit.INSTANCE;
      }

      public void onConflictingAccounts(GigyaApiResponse var1, ILinkAccountsResolver var2) {
         Intrinsics.checkNotNullParameter(var1, "response");
         Intrinsics.checkNotNullParameter(var2, "resolver");
         this.getPassword.invoke(new GigyaService$RegisterCallback$$ExternalSyntheticLambda0(this, var2));
      }

      public void onPendingRegistration(GigyaApiResponse var1, IPendingRegistrationResolver var2) {
         Intrinsics.checkNotNullParameter(var1, "response");
         Intrinsics.checkNotNullParameter(var2, "resolver");
         var2.setAccount(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("preferences", this.preferences), TuplesKt.to("lang", this.lang)}));
      }
   }
}
