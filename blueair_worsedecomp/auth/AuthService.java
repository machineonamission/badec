package com.blueair.auth;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.blueair.auth.retrofit.AblUserApi;
import com.blueair.auth.retrofit.BlueLoginDetails;
import com.blueair.auth.retrofit.CloudAuthApi;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.StringUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.foobot.liblabclient.ApiClient;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Ì\u00012\u00020\u00012\u00020\u0002:\u0002Ì\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0001\u001a\u00020\u0015H@¢\u0006\u0003\u0010\u0001JS\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\u0005\b\u0000\u0010\u000127\u0010\u0001\u001a2\b\u0001\u0012\u0016\u0012\u00140\u0015¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003H\u00010Q\u0012\u0006\u0012\u0004\u0018\u00010T0\u0001H@¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u0011\u0010 \u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\b\u0010¡\u0001\u001a\u00030\u0001J\n\u0010¢\u0001\u001a\u00030\u0001H\u0002J\t\u0010£\u0001\u001a\u00020\u001bH\u0002J/\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010¥\u0001\u001a\u00020\u00152\f\b\u0002\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\f\b\u0002\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001H\u0002J\u001b\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010©\u0001\u001a\u00020\u001bH@¢\u0006\u0003\u0010ª\u0001J\u000f\u0010«\u0001\u001a\u00020\u001bH\u0000¢\u0006\u0003\b¬\u0001J\n\u0010­\u0001\u001a\u00030\u0001H\u0016J\b\u0010®\u0001\u001a\u00030\u0001J!\u0010¯\u0001\u001a\u00030\u00012\u0006\u0010C\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0007\u0010°\u0001\u001a\u00020\u0015J\u0011\u0010±\u0001\u001a\u00020\u00152\b\u0010²\u0001\u001a\u00030³\u0001J\b\u0010´\u0001\u001a\u00030\u0001J(\u0010µ\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0¶\u00012\u0007\u0010·\u0001\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H@¢\u0006\u0003\u0010¸\u0001J\b\u0010¹\u0001\u001a\u00030\u0001J\u0011\u0010º\u0001\u001a\u00030»\u0001H@¢\u0006\u0003\u0010\u0001J\u0019\u0010¼\u0001\u001a\u00020\u001b2\u0007\u0010½\u0001\u001a\u00020\u0015H@¢\u0006\u0003\u0010¾\u0001J\u0012\u0010¿\u0001\u001a\u0004\u0018\u00010\u0015H@¢\u0006\u0003\u0010\u0001J\"\u0010M\u001a\n\u0012\u0005\u0012\u00030À\u00010¶\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u0015H@¢\u0006\u0003\u0010¾\u0001J\u0018\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030À\u00010¶\u0001H@¢\u0006\u0003\u0010\u0001J\u0011\u0010Â\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\n\u0010Ä\u0001\u001a\u00030\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u0001H\u0002J\n\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R5\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00140\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010!R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150%8BX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b+\u0010\u0018R+\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-8F@FX\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b6\u0010!R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R&\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010?R&\u0010@\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010?R+\u0010C\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@FX\u0002¢\u0006\u0012\n\u0004\bF\u00104\u001a\u0004\bD\u0010!\"\u0004\bE\u0010?R+\u0010G\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@FX\u0002¢\u0006\u0012\n\u0004\bJ\u00104\u001a\u0004\bH\u0010!\"\u0004\bI\u0010?R+\u0010K\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@BX\u0002¢\u0006\u0012\n\u0004\bN\u00104\u001a\u0004\bL\u0010!\"\u0004\bM\u0010?R:\u0010O\u001a \b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R0Q\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010PX\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0011\u0010Z\u001a\u00020[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b_\u0010!R\u0011\u0010`\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\ba\u0010!R\u0014\u0010b\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010!R\u0014\u0010d\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\be\u0010!R\u001b\u0010f\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bg\u0010!R\u001b\u0010j\u001a\u00020k8BX\u0002¢\u0006\f\n\u0004\bn\u0010i\u001a\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020p8BX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u000e\u0010s\u001a\u00020tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010u\u001a\u00020v8BX\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020p8BX\u0004¢\u0006\u0006\u001a\u0004\bz\u0010rR\u0014\u0010{\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b|\u0010!R\u0011\u0010}\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b~\u0010!R\u0012\u0010\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0001\u0010!R\u0013\u0010\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0001\u0010!R3\u0010\u0001\u001a\u00030\u00012\u0007\u0010,\u001a\u00030\u00018B@BX\u0002¢\u0006\u0017\n\u0005\b\u0001\u00104\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00158F@BX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010!\"\u0005\b\u0001\u0010?R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ã\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010È\u0001\u001a\u00030É\u0001X\u0005¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/blueair/auth/AuthService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "unsecurePrefs", "Lcom/blueair/core/service/UnsecurePrefs;", "locationService", "Lcom/blueair/auth/LocationService;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Lcom/blueair/auth/GigyaService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/AnalyticsService;Lokhttp3/Interceptor;)V", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaJwtObserver", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "getGigyaJwtObserver", "()Lio/reactivex/Observable;", "_isUserLoggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isUserLoggedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "cloudUserRegion", "getCloudUserRegion", "()Ljava/lang/String;", "gigyaJwt", "getGigyaJwt", "ablJwtPublisher", "Lio/reactivex/subjects/PublishSubject;", "getAblJwtPublisher", "()Lio/reactivex/subjects/PublishSubject;", "ablJwtPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "ablJwtObserver", "getAblJwtObserver", "<set-?>", "Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "ablUser", "getAblUser", "()Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "setAblUser", "(Lcom/blueair/auth/retrofit/AblUserApi$AblUser;)V", "ablUser$delegate", "Lkotlin/properties/ReadWriteProperty;", "gigyaUid", "getGigyaUid", "userId", "", "getUserId", "()I", "nuValue", "userIdForBlueCloud", "getUserIdForBlueCloud", "setUserIdForBlueCloud", "(Ljava/lang/String;)V", "appIdForMqtt", "getAppIdForMqtt", "setAppIdForMqtt", "username", "getUsername", "setUsername", "username$delegate", "ablHomeHost", "getAblHomeHost", "setAblHomeHost", "ablHomeHost$delegate", "pushToken", "getPushToken", "setPushToken", "pushToken$delegate", "pushSettingsFetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Lcom/blueair/core/model/NotificationSetting;", "", "getPushSettingsFetcher", "()Lkotlin/jvm/functions/Function1;", "setPushSettingsFetcher", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "blueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "blueHomeHost", "getBlueHomeHost", "blueBrokerURL", "getBlueBrokerURL", "blueClientID", "getBlueClientID", "blueClientSecret", "getBlueClientSecret", "httpUserAgent", "getHttpUserAgent", "httpUserAgent$delegate", "Lkotlin/Lazy;", "userOkhttpClient", "Lokhttp3/OkHttpClient;", "getUserOkhttpClient", "()Lokhttp3/OkHttpClient;", "userOkhttpClient$delegate", "ablRestAdapter", "Lretrofit2/Retrofit;", "getAblRestAdapter", "()Lretrofit2/Retrofit;", "userApi", "Lcom/blueair/auth/retrofit/AblUserApi;", "cloudAuthApi", "Lcom/blueair/auth/retrofit/CloudAuthApi;", "getCloudAuthApi", "()Lcom/blueair/auth/retrofit/CloudAuthApi;", "cloudRestAdapter", "getCloudRestAdapter", "cloudJwtInternal", "getCloudJwtInternal", "authNameForMqtt", "getAuthNameForMqtt", "signatureForMqtt", "getSignatureForMqtt", "tokenForMqtt", "getTokenForMqtt", "Lcom/blueair/auth/retrofit/BlueLoginDetails;", "blueLoginDetails", "getBlueLoginDetails", "()Lcom/blueair/auth/retrofit/BlueLoginDetails;", "setBlueLoginDetails", "(Lcom/blueair/auth/retrofit/BlueLoginDetails;)V", "blueLoginDetails$delegate", "ablJwtMutex", "Lkotlinx/coroutines/sync/Mutex;", "value", "ablJwt", "getAblJwt", "setAblJwt", "cloudJwtMutex", "cloudJwtExpiredCount", "cloudJwtExpiredJob", "Lkotlinx/coroutines/Job;", "getCloudJwt", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBearerToken", "T", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "token", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disableUserAccount", "", "deleteAccount", "resetCloudJwt", "resetAblToken", "isCloudJwtExpired", "recordCloudJwtExpired", "cause", "iat", "Ljava/util/Date;", "exp", "checkGigyaJwtExpiry", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAblJwtExpired", "isAblJwtExpired$auth_otherRelease", "logOut", "clearUserData", "setGigyaToken", "gigyaToken", "getLocallySavedDeviceJwt", "device", "Lcom/blueair/core/model/Device;", "clear", "authenticateAblUser", "Lio/flatcircle/coroutinehelper/ApiResult;", "nuUsername", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHomeHost", "updateGigyaDataCenter", "Lcom/blueair/auth/GigyaServer;", "doGigyaDataCentersHaveEmailAddress", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAblGranularRegion", "Lokhttp3/ResponseBody;", "removePushToken", "updateLanguage", "ablTokenRefreshingJob", "startAblTokenRefreshingJob", "stopAblTokenRefreshingJob", "millisUntilAblTokenExpires", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
public final class AuthService implements CoroutineScope, LogOutable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final int ABL_TOKEN_EXPIRE_RETRY_LENGTH_SECONDS = 300;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_EMPTY_CLOUD_JWT = "empty cloud jwt";
    public static final String EXTUID = "ext_uid";
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0;
    private final MutableStateFlow<Boolean> _isUserLoggedIn;
    private final ReadWriteProperty ablHomeHost$delegate;
    private volatile String ablJwt;
    private final Mutex ablJwtMutex;
    private final LazyPublishSubject ablJwtPublisher$delegate;
    private Job ablTokenRefreshingJob;
    private final ReadWriteProperty ablUser$delegate;
    /* access modifiers changed from: private */
    public final AnalyticsService analyticsService;
    private String appIdForMqtt;
    private final ReadWriteProperty blueLoginDetails$delegate;
    /* access modifiers changed from: private */
    public int cloudJwtExpiredCount;
    /* access modifiers changed from: private */
    public Job cloudJwtExpiredJob;
    private final Mutex cloudJwtMutex;
    private final GigyaService gigyaService;
    private final Lazy httpUserAgent$delegate;
    private final StateFlow<Boolean> isUserLoggedIn;
    /* access modifiers changed from: private */
    public final LocationService locationService;
    private final Interceptor mockInterceptor;
    private Function1<? super Continuation<? super List<NotificationSetting>>, ? extends Object> pushSettingsFetcher;
    private final ReadWriteProperty pushToken$delegate;
    /* access modifiers changed from: private */
    public final SecurePrefs securePrefs;
    /* access modifiers changed from: private */
    public final UnsecurePrefs unsecurePrefs;
    /* access modifiers changed from: private */
    public AblUserApi userApi;
    private String userIdForBlueCloud;
    private final Lazy userOkhttpClient$delegate;
    private final ReadWriteProperty username$delegate;

    static {
        Class<AuthService> cls = AuthService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "ablJwtPublisher", "getAblJwtPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "ablUser", "getAblUser()Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "username", "getUsername()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "ablHomeHost", "getAblHomeHost()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "pushToken", "getPushToken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "blueLoginDetails", "getBlueLoginDetails()Lcom/blueair/auth/retrofit/BlueLoginDetails;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public AuthService(GigyaService gigyaService2, SecurePrefs securePrefs2, UnsecurePrefs unsecurePrefs2, LocationService locationService2, AnalyticsService analyticsService2, Interceptor interceptor) {
        GigyaService gigyaService3 = gigyaService2;
        SecurePrefs securePrefs3 = securePrefs2;
        UnsecurePrefs unsecurePrefs3 = unsecurePrefs2;
        LocationService locationService3 = locationService2;
        AnalyticsService analyticsService3 = analyticsService2;
        Intrinsics.checkNotNullParameter(gigyaService3, "gigyaService");
        Intrinsics.checkNotNullParameter(securePrefs3, "securePrefs");
        Intrinsics.checkNotNullParameter(unsecurePrefs3, "unsecurePrefs");
        Intrinsics.checkNotNullParameter(locationService3, "locationService");
        Intrinsics.checkNotNullParameter(analyticsService3, "analyticsService");
        this.$$delegate_0 = new DefaultCoroutineScope();
        this.gigyaService = gigyaService3;
        this.securePrefs = securePrefs3;
        this.unsecurePrefs = unsecurePrefs3;
        this.locationService = locationService3;
        this.analyticsService = analyticsService3;
        this.mockInterceptor = interceptor;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(getGigyaJwt().length() > 0));
        this._isUserLoggedIn = MutableStateFlow;
        StateFlow<Boolean> asStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.isUserLoggedIn = asStateFlow;
        this.ablJwtPublisher$delegate = new LazyPublishSubject();
        Delegates delegates = Delegates.INSTANCE;
        this.ablUser$delegate = new AuthService$special$$inlined$observable$1(PreferencesHelper.INSTANCE.get(securePrefs3.getBackend(), PrefKeys.AblUser, new AblUserApi.AblUser(0, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 4095, (DefaultConstructorMarker) null), Reflection.getOrCreateKotlinClass(AblUserApi.AblUser.class)), this);
        this.userIdForBlueCloud = (String) PreferencesHelper.INSTANCE.get(securePrefs3.getBackend(), PrefKeys.UserIdBlueCloud, "", Reflection.getOrCreateKotlinClass(String.class));
        this.appIdForMqtt = (String) PreferencesHelper.INSTANCE.get(securePrefs3.getBackend(), PrefKeys.AppIdMqtt, null, Reflection.getOrCreateKotlinClass(String.class));
        Delegates delegates2 = Delegates.INSTANCE;
        this.username$delegate = new AuthService$special$$inlined$observable$2(PreferencesHelper.INSTANCE.get(securePrefs3.getBackend(), PrefKeys.EncryptedEmail, null, Reflection.getOrCreateKotlinClass(String.class)), this);
        Prefs prefs = securePrefs3;
        String baseUrl = AblEnvironment.INSTANCE.getBaseUrl();
        this.ablHomeHost$delegate = new AuthService$special$$inlined$ObservablePreference$1(prefs, PrefKeys.AblHomeHostUrl, baseUrl, PreferencesHelper.INSTANCE.get(prefs.getBackend(), PrefKeys.AblHomeHostUrl, baseUrl, Reflection.getOrCreateKotlinClass(String.class)));
        Prefs prefs2 = securePrefs3;
        this.pushToken$delegate = new AuthService$special$$inlined$ObservablePreference$2(prefs2, PrefKeys.PushToken, "", PreferencesHelper.INSTANCE.get(prefs2.getBackend(), PrefKeys.PushToken, "", Reflection.getOrCreateKotlinClass(String.class)));
        this.httpUserAgent$delegate = LazyKt.lazy(new AuthService$$ExternalSyntheticLambda1());
        this.userOkhttpClient$delegate = LazyKt.lazy(new AuthService$$ExternalSyntheticLambda2(this));
        Object create = getAblRestAdapter().create(AblUserApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.userApi = (AblUserApi) create;
        Delegates delegates3 = Delegates.INSTANCE;
        this.blueLoginDetails$delegate = new AuthService$special$$inlined$observable$3(PreferencesHelper.INSTANCE.get(securePrefs3.getBackend(), PrefKeys.BlueAirLoginDetails, new BlueLoginDetails((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null), Reflection.getOrCreateKotlinClass(BlueLoginDetails.class)), this);
        this.ablJwtMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.ablJwt = "";
        FlowKt.launchIn(FlowKt.onEach(new AuthService$special$$inlined$filter$1(asStateFlow), new AnonymousClass2(this, (Continuation<? super AnonymousClass2>) null)), this);
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new LifecycleObserver(this) {
            final /* synthetic */ AuthService this$0;

            {
                this.this$0 = r1;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onMoveToForeground() {
                Timber.Forest.d("LifecycleObserver.onMoveToForeground", new Object[0]);
                this.this$0.startAblTokenRefreshingJob();
            }
        });
        this.cloudJwtMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthService(GigyaService gigyaService2, SecurePrefs securePrefs2, UnsecurePrefs unsecurePrefs2, LocationService locationService2, AnalyticsService analyticsService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gigyaService2, securePrefs2, unsecurePrefs2, locationService2, analyticsService2, (i & 32) != 0 ? null : interceptor);
    }

    public final GigyaService getGigyaService() {
        return this.gigyaService;
    }

    public final Observable<String> getGigyaJwtObserver() {
        return this.gigyaService.getGigyaJwtObserver();
    }

    public final StateFlow<Boolean> isUserLoggedIn() {
        return this.isUserLoggedIn;
    }

    public final String getCloudUserRegion() {
        return this.gigyaService.getCloudUserRegion();
    }

    public final String getGigyaJwt() {
        return this.gigyaService.getGigyaJwt();
    }

    private final PublishSubject<String> getAblJwtPublisher() {
        return this.ablJwtPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public final Observable<String> getAblJwtObserver() {
        Observable<String> hide = getAblJwtPublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final AblUserApi.AblUser getAblUser() {
        return (AblUserApi.AblUser) this.ablUser$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setAblUser(AblUserApi.AblUser ablUser) {
        Intrinsics.checkNotNullParameter(ablUser, "<set-?>");
        this.ablUser$delegate.setValue(this, $$delegatedProperties[1], ablUser);
    }

    public final String getGigyaUid() {
        return this.gigyaService.getGigyaUid();
    }

    public final int getUserId() {
        return getAblUser().getId();
    }

    /* access modifiers changed from: private */
    public final void setUserIdForBlueCloud(String str) {
        if (str.length() == 0) {
            this.securePrefs.remove(PrefKeys.UserIdBlueCloud);
        } else if (!Intrinsics.areEqual((Object) str, (Object) this.userIdForBlueCloud)) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), PrefKeys.UserIdBlueCloud, str, Reflection.getOrCreateKotlinClass(String.class));
        }
        this.userIdForBlueCloud = str;
    }

    public final String getUserIdForBlueCloud() {
        if (this.userIdForBlueCloud.length() == 0) {
            String access_token = getBlueLoginDetails().getAccess_token();
            String asString = access_token.length() > 0 ? new JWT(access_token).getClaim("username").asString() : null;
            if (asString == null) {
                asString = "";
            }
            setUserIdForBlueCloud(asString);
        }
        return this.userIdForBlueCloud;
    }

    private final void setAppIdForMqtt(String str) {
        if (!Intrinsics.areEqual((Object) str, (Object) this.appIdForMqtt)) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), PrefKeys.AppIdMqtt, str, Reflection.getOrCreateKotlinClass(String.class));
        }
        this.appIdForMqtt = str;
    }

    public final String getAppIdForMqtt() {
        if (this.appIdForMqtt.length() == 0) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            setAppIdForMqtt(uuid);
        }
        return this.appIdForMqtt;
    }

    public final String getUsername() {
        return (String) this.username$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.username$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final String getAblHomeHost() {
        return (String) this.ablHomeHost$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setAblHomeHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ablHomeHost$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    private final void setPushToken(String str) {
        this.pushToken$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final String getPushToken() {
        return (String) this.pushToken$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final Function1<Continuation<? super List<NotificationSetting>>, Object> getPushSettingsFetcher() {
        return this.pushSettingsFetcher;
    }

    public final void setPushSettingsFetcher(Function1<? super Continuation<? super List<NotificationSetting>>, ? extends Object> function1) {
        this.pushSettingsFetcher = function1;
    }

    public final BlueCloudDomain getBlueCloudDomain() {
        return this.gigyaService.getBlueCloudDomain();
    }

    public final String getBlueHomeHost() {
        return this.gigyaService.getBlueCloudDomain().getHost();
    }

    public final String getBlueBrokerURL() {
        return this.gigyaService.getBlueCloudDomain().getMqttBroker();
    }

    private final String getBlueClientID() {
        return this.gigyaService.getBlueCloudDomain().getClientId();
    }

    private final String getBlueClientSecret() {
        return this.gigyaService.getBlueCloudDomain().getClientSecret();
    }

    private final String getHttpUserAgent() {
        return (String) this.httpUserAgent$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String httpUserAgent_delegate$lambda$3() {
        return StringUtils.INSTANCE.ensureValidHttpHeader(System.getProperty("os.name") + TokenParser.SP + System.getProperty("os.arch") + " - ApiClient Java - " + System.getProperty("os.version"));
    }

    private final OkHttpClient getUserOkhttpClient() {
        return (OkHttpClient) this.userOkhttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient userOkhttpClient_delegate$lambda$5(AuthService authService) {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        Interceptor authService$$ExternalSyntheticLambda3 = new AuthService$$ExternalSyntheticLambda3(authService);
        OkHttpClient.Builder connectTimeout = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS);
        Interceptor interceptor = authService.mockInterceptor;
        if (interceptor != null) {
            authService$$ExternalSyntheticLambda3 = interceptor;
        }
        return connectTimeout.addInterceptor(authService$$ExternalSyntheticLambda3).addInterceptor(httpLoggingInterceptor).build();
    }

    /* access modifiers changed from: private */
    public static final Response userOkhttpClient_delegate$lambda$5$lambda$4(AuthService authService, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder addHeader = chain.request().newBuilder().addHeader("Accept-Charset", "UTF-8").addHeader("User-Agent", authService.getHttpUserAgent()).addHeader(ApiClient.AK_TOKEN_HEADER, AblEnvironment.INSTANCE.getApiKey());
        return chain.proceed(addHeader.addHeader("Authorization", "Bearer " + authService.getGigyaJwt()).build());
    }

    private final Retrofit getAblRestAdapter() {
        Retrofit build = new Retrofit.Builder().baseUrl(getAblHomeHost()).addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).client(getUserOkhttpClient()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* access modifiers changed from: private */
    public final CloudAuthApi getCloudAuthApi() {
        Object create = getCloudRestAdapter().create(CloudAuthApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (CloudAuthApi) create;
    }

    private final Retrofit getCloudRestAdapter() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        Retrofit build = new Retrofit.Builder().baseUrl(getBlueHomeHost()).addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).client(new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor).addInterceptor(new AuthService$$ExternalSyntheticLambda0(this)).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* access modifiers changed from: private */
    public static final Response _get_cloudRestAdapter_$lambda$6(AuthService authService, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader("Accept-Charset", "UTF-8").addHeader("User-Agent", authService.getHttpUserAgent()).build());
    }

    private final String getCloudJwtInternal() {
        return getBlueLoginDetails().getAccess_token();
    }

    public final String getAuthNameForMqtt() {
        return getBlueLoginDetails().getCustom_auth_name();
    }

    public final String getSignatureForMqtt() {
        return getBlueLoginDetails().getCustom_auth_signature();
    }

    public final String getTokenForMqtt() {
        return getBlueLoginDetails().getCustom_auth_token();
    }

    private final BlueLoginDetails getBlueLoginDetails() {
        return (BlueLoginDetails) this.blueLoginDetails$delegate.getValue(this, $$delegatedProperties[5]);
    }

    /* access modifiers changed from: private */
    public final void setBlueLoginDetails(BlueLoginDetails blueLoginDetails) {
        this.blueLoginDetails$delegate.setValue(this, $$delegatedProperties[5], blueLoginDetails);
    }

    public final String getAblJwt() {
        if (this.ablJwt.length() != 0) {
            return this.ablJwt;
        }
        String str = (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), PrefKeys.AirBoxLabsJwtAuthToken, "", Reflection.getOrCreateKotlinClass(String.class));
        if (str.length() > 0) {
            this.ablJwt = str;
        }
        return this.ablJwt;
    }

    private final void setAblJwt(String str) {
        if (str.length() == 0) {
            this.securePrefs.remove(PrefKeys.AirBoxLabsJwtAuthToken);
            getAblJwtPublisher().onNext(str);
            this.ablJwt = str;
        } else if (!Intrinsics.areEqual((Object) str, (Object) this.ablJwt)) {
            PreferencesHelper.INSTANCE.set(this.securePrefs.getBackend(), PrefKeys.AirBoxLabsJwtAuthToken, str, Reflection.getOrCreateKotlinClass(String.class));
            getAblJwtPublisher().onNext(str);
            this.ablJwt = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.auth.AuthService$2", f = "AuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.auth.AuthService$2  reason: invalid class name */
    /* compiled from: AuthService.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AuthService this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.startAblTokenRefreshingJob();
                this.this$0.analyticsService.setUserId(String.valueOf(this.this$0.getAblUser().getId()), this.this$0.getGigyaService().getGigyaUid(), this.this$0.getGigyaService().getBlueCloudDomain().tag());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d4, code lost:
        if (r0.checkGigyaTokenExpiry(r3) == r4) goto L_0x01b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f3 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0189 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x018a A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b3 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b6 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCloudJwt(kotlin.coroutines.Continuation<? super java.lang.String> r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "Bearer "
            boolean r3 = r0 instanceof com.blueair.auth.AuthService$getCloudJwt$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.blueair.auth.AuthService$getCloudJwt$1 r3 = (com.blueair.auth.AuthService$getCloudJwt$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.blueair.auth.AuthService$getCloudJwt$1 r3 = new com.blueair.auth.AuthService$getCloudJwt$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            r12 = 0
            if (r5 == 0) goto L_0x00be
            if (r5 == r10) goto L_0x00b6
            if (r5 == r9) goto L_0x00a7
            if (r5 == r8) goto L_0x0082
            if (r5 == r7) goto L_0x005e
            if (r5 != r6) goto L_0x0056
            int r2 = r3.I$1
            int r2 = r3.I$0
            java.lang.Object r2 = r3.L$3
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r2 = r3.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r2 = r3.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r3 = r3.L$0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x01b4
        L_0x0053:
            r0 = move-exception
            goto L_0x01ce
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x005e:
            int r2 = r3.I$1
            int r5 = r3.I$0
            java.lang.Object r7 = r3.L$3
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r3.L$2
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r3.L$1
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x007e }
            r16 = r5
            r5 = r2
            r2 = r9
            r9 = r8
            r8 = r16
            goto L_0x018d
        L_0x007e:
            r0 = move-exception
            r2 = r9
            goto L_0x01ce
        L_0x0082:
            int r2 = r3.I$1
            int r5 = r3.I$0
            java.lang.Object r8 = r3.L$3
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r3.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r3.L$1
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00a3 }
            r16 = r5
            r5 = r2
            r2 = r10
            r10 = r9
            r9 = r8
            r8 = r16
            goto L_0x0164
        L_0x00a3:
            r0 = move-exception
            r2 = r10
            goto L_0x01ce
        L_0x00a7:
            int r5 = r3.I$0
            java.lang.Object r9 = r3.L$1
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r13 = r10
            goto L_0x00ed
        L_0x00b6:
            java.lang.Object r5 = r3.L$0
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d8
        L_0x00be:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            java.lang.String r0 = ""
            r5.element = r0
            com.blueair.auth.GigyaService r0 = r1.gigyaService
            r3.L$0 = r5
            r3.label = r10
            java.lang.Object r0 = r0.checkGigyaTokenExpiry(r3)
            if (r0 != r4) goto L_0x00d8
            goto L_0x01b2
        L_0x00d8:
            kotlinx.coroutines.sync.Mutex r0 = r1.cloudJwtMutex
            r3.L$0 = r5
            r3.L$1 = r0
            r3.I$0 = r11
            r3.label = r9
            java.lang.Object r9 = r0.lock(r12, r3)
            if (r9 != r4) goto L_0x00ea
            goto L_0x01b2
        L_0x00ea:
            r9 = r0
            r13 = r5
            r5 = r11
        L_0x00ed:
            boolean r0 = r1.isCloudJwtExpired()     // Catch:{ all -> 0x007e }
            if (r0 == 0) goto L_0x01b6
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ all -> 0x007e }
            r0.<init>()     // Catch:{ all -> 0x007e }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "Authorization"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r14.<init>(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r1.getGigyaJwt()     // Catch:{ all -> 0x007e }
            r14.append(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r14.toString()     // Catch:{ all -> 0x007e }
            r0.put(r10, r2)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "idtoken"
            java.lang.String r10 = r1.getGigyaJwt()     // Catch:{ all -> 0x007e }
            r0.put(r2, r10)     // Catch:{ all -> 0x007e }
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x007e }
            r2.<init>()     // Catch:{ all -> 0x007e }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "client_id"
            java.lang.String r14 = r1.getBlueClientID()     // Catch:{ all -> 0x007e }
            r2.put(r10, r14)     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "client_secret"
            java.lang.String r14 = r1.getBlueClientSecret()     // Catch:{ all -> 0x007e }
            r2.put(r10, r14)     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "scope"
            java.lang.String r14 = "todo"
            r2.put(r10, r14)     // Catch:{ all -> 0x007e }
            com.blueair.auth.retrofit.CloudAuthApi r10 = r1.getCloudAuthApi()     // Catch:{ all -> 0x007e }
            kotlinx.coroutines.Deferred r10 = r10.login(r0, r2)     // Catch:{ all -> 0x007e }
            r3.L$0 = r13     // Catch:{ all -> 0x007e }
            r3.L$1 = r9     // Catch:{ all -> 0x007e }
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch:{ all -> 0x007e }
            r3.L$2 = r14     // Catch:{ all -> 0x007e }
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch:{ all -> 0x007e }
            r3.L$3 = r14     // Catch:{ all -> 0x007e }
            r3.I$0 = r5     // Catch:{ all -> 0x007e }
            r3.I$1 = r11     // Catch:{ all -> 0x007e }
            r3.label = r8     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = com.blueair.auth.AuthServiceKt.awaitCall(r10, r3)     // Catch:{ all -> 0x007e }
            if (r8 != r4) goto L_0x015d
            goto L_0x01b2
        L_0x015d:
            r10 = r9
            r9 = r2
            r2 = r10
            r10 = r0
            r0 = r8
            r8 = r5
            r5 = r11
        L_0x0164:
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0     // Catch:{ all -> 0x0053 }
            com.blueair.auth.AuthService$getCloudJwt$2$1 r14 = new com.blueair.auth.AuthService$getCloudJwt$2$1     // Catch:{ all -> 0x0053 }
            r14.<init>(r1, r12)     // Catch:{ all -> 0x0053 }
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ all -> 0x0053 }
            r3.L$0 = r13     // Catch:{ all -> 0x0053 }
            r3.L$1 = r2     // Catch:{ all -> 0x0053 }
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch:{ all -> 0x0053 }
            r3.L$2 = r15     // Catch:{ all -> 0x0053 }
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)     // Catch:{ all -> 0x0053 }
            r3.L$3 = r15     // Catch:{ all -> 0x0053 }
            r3.I$0 = r8     // Catch:{ all -> 0x0053 }
            r3.I$1 = r5     // Catch:{ all -> 0x0053 }
            r3.label = r7     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r0, r14, r3)     // Catch:{ all -> 0x0053 }
            if (r0 != r4) goto L_0x018a
            goto L_0x01b2
        L_0x018a:
            r7 = r9
            r9 = r10
            r10 = r13
        L_0x018d:
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0     // Catch:{ all -> 0x0053 }
            com.blueair.auth.AuthService$getCloudJwt$2$2 r13 = new com.blueair.auth.AuthService$getCloudJwt$2$2     // Catch:{ all -> 0x0053 }
            r13.<init>(r1, r12)     // Catch:{ all -> 0x0053 }
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ all -> 0x0053 }
            r3.L$0 = r10     // Catch:{ all -> 0x0053 }
            r3.L$1 = r2     // Catch:{ all -> 0x0053 }
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)     // Catch:{ all -> 0x0053 }
            r3.L$2 = r9     // Catch:{ all -> 0x0053 }
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch:{ all -> 0x0053 }
            r3.L$3 = r7     // Catch:{ all -> 0x0053 }
            r3.I$0 = r8     // Catch:{ all -> 0x0053 }
            r3.I$1 = r5     // Catch:{ all -> 0x0053 }
            r3.label = r6     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r0, r13, r3)     // Catch:{ all -> 0x0053 }
            if (r0 != r4) goto L_0x01b3
        L_0x01b2:
            return r4
        L_0x01b3:
            r3 = r10
        L_0x01b4:
            r13 = r3
            goto L_0x01b7
        L_0x01b6:
            r2 = r9
        L_0x01b7:
            java.lang.String r0 = r1.getCloudJwtInternal()     // Catch:{ all -> 0x0053 }
            r13.element = r0     // Catch:{ all -> 0x0053 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            r2.unlock(r12)
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.String r2 = "getCloudJwt done"
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r0.d(r2, r3)
            T r0 = r13.element
            return r0
        L_0x01ce:
            r2.unlock(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.getCloudJwt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (r7 == r1) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object getBearerToken(kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.blueair.auth.AuthService$getBearerToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.auth.AuthService$getBearerToken$1 r0 = (com.blueair.auth.AuthService$getBearerToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$getBearerToken$1 r0 = new com.blueair.auth.AuthService$getBearerToken$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r6 = r0.I$0
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.getCloudJwt(r0)
            if (r7 != r1) goto L_0x0055
            goto L_0x008c
        L_0x0055:
            r2 = r7
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            r4 = 0
            if (r2 <= 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r7 = r4
        L_0x0063:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x008e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Bearer "
            r2.<init>(r4)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r7
            r7 = 0
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r2, r0)
            if (r6 != r1) goto L_0x008d
        L_0x008c:
            return r1
        L_0x008d:
            return r6
        L_0x008e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.getBearerToken(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object disableUserAccount(Continuation<? super Unit> continuation) {
        Object bearerToken = getBearerToken(new AuthService$disableUserAccount$2(this, (Continuation<? super AuthService$disableUserAccount$2>) null), continuation);
        return bearerToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bearerToken : Unit.INSTANCE;
    }

    public final Object deleteAccount(Continuation<? super Unit> continuation) {
        Object bearerToken = getBearerToken(new AuthService$deleteAccount$2(this, (Continuation<? super AuthService$deleteAccount$2>) null), continuation);
        return bearerToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bearerToken : Unit.INSTANCE;
    }

    public final void resetCloudJwt() {
        setBlueLoginDetails(new BlueLoginDetails((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null));
    }

    private final void resetAblToken() {
        setAblJwt("");
    }

    private final boolean isCloudJwtExpired() {
        AuthService authService;
        String str;
        if (getCloudJwtInternal().length() == 0) {
            recordCloudJwtExpired$default(this, ERROR_EMPTY_CLOUD_JWT, (Date) null, (Date) null, 6, (Object) null);
            return true;
        } else if (getTokenForMqtt().length() == 0) {
            recordCloudJwtExpired$default(this, "empty mqtt jwt", (Date) null, (Date) null, 6, (Object) null);
            return true;
        } else {
            try {
                JWT jwt = new JWT(getCloudJwtInternal());
                if (jwt.isExpired(60)) {
                    Date date = new Date();
                    if (jwt.getIssuedAt() != null) {
                        if (jwt.getExpiresAt() != null) {
                            if (date.before(jwt.getIssuedAt())) {
                                str = "now < iat";
                            } else if (date.after(jwt.getExpiresAt())) {
                                str = "now > exp";
                            } else {
                                str = "unknown";
                            }
                            authService = this;
                            authService.recordCloudJwtExpired("cloud jwt expired: ".concat(str), jwt.getIssuedAt(), jwt.getExpiresAt());
                            Timber.Forest forest = Timber.Forest;
                            forest.d("cloud jwt expired: iat=" + jwt.getIssuedAt() + " | exp=" + jwt.getExpiresAt() + " | timezone=" + TimeZone.getDefault().getID() + " | time=" + new Date(), new Object[0]);
                            return true;
                        }
                    }
                    str = "iat/exp == null";
                    authService = this;
                    try {
                        authService.recordCloudJwtExpired("cloud jwt expired: ".concat(str), jwt.getIssuedAt(), jwt.getExpiresAt());
                        Timber.Forest forest2 = Timber.Forest;
                        forest2.d("cloud jwt expired: iat=" + jwt.getIssuedAt() + " | exp=" + jwt.getExpiresAt() + " | timezone=" + TimeZone.getDefault().getID() + " | time=" + new Date(), new Object[0]);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        recordCloudJwtExpired$default(authService, "invalid cloud jwt: " + th.getLocalizedMessage(), (Date) null, (Date) null, 6, (Object) null);
                        return true;
                    }
                } else {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                authService = this;
                recordCloudJwtExpired$default(authService, "invalid cloud jwt: " + th.getLocalizedMessage(), (Date) null, (Date) null, 6, (Object) null);
                return true;
            }
        }
    }

    static /* synthetic */ void recordCloudJwtExpired$default(AuthService authService, String str, Date date, Date date2, int i, Object obj) {
        if ((i & 2) != 0) {
            date = null;
        }
        if ((i & 4) != 0) {
            date2 = null;
        }
        authService.recordCloudJwtExpired(str, date, date2);
    }

    private final void recordCloudJwtExpired(String str, Date date, Date date2) {
        Timber.Forest forest = Timber.Forest;
        forest.d("recordCloudJwtExpired(" + str + ", " + date + ", " + date2 + ')', new Object[0]);
        int i = this.cloudJwtExpiredCount + 1;
        this.cloudJwtExpiredCount = i;
        if (i > 1) {
            if (this.cloudJwtExpiredJob == null) {
                this.analyticsService.event(new AnalyticEvent.CloudJwtExpiredEvent(this.cloudJwtExpiredCount, str, date, date2));
            }
            Job job = this.cloudJwtExpiredJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.cloudJwtExpiredJob = null;
            this.cloudJwtExpiredJob = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AuthService$recordCloudJwtExpired$1(this, (Continuation<? super AuthService$recordCloudJwtExpired$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r15.checkGigyaTokenExpiry(r1) == r2) goto L_0x00cb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00de A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fd A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0100 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAblJwt(boolean r14, kotlin.coroutines.Continuation<? super java.lang.String> r15) {
        /*
            r13 = this;
            java.lang.String r0 = "ABL TOKEN "
            boolean r1 = r15 instanceof com.blueair.auth.AuthService$getAblJwt$1
            if (r1 == 0) goto L_0x0016
            r1 = r15
            com.blueair.auth.AuthService$getAblJwt$1 r1 = (com.blueair.auth.AuthService$getAblJwt$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r15 = r1.label
            int r15 = r15 - r3
            r1.label = r15
            goto L_0x001b
        L_0x0016:
            com.blueair.auth.AuthService$getAblJwt$1 r1 = new com.blueair.auth.AuthService$getAblJwt$1
            r1.<init>(r13, r15)
        L_0x001b:
            java.lang.Object r15 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            java.lang.String r4 = ""
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r3 == 0) goto L_0x006e
            if (r3 == r7) goto L_0x0064
            if (r3 == r6) goto L_0x0050
            if (r3 != r5) goto L_0x0048
            int r14 = r1.I$1
            int r14 = r1.I$0
            boolean r14 = r1.Z$0
            java.lang.Object r14 = r1.L$1
            kotlinx.coroutines.sync.Mutex r14 = (kotlinx.coroutines.sync.Mutex) r14
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0045 }
            goto L_0x00cd
        L_0x0045:
            r15 = move-exception
            goto L_0x011d
        L_0x0048:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0050:
            int r14 = r1.I$0
            boolean r3 = r1.Z$0
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            r14 = r6
            r6 = r3
            r3 = r7
            goto L_0x009f
        L_0x0064:
            boolean r14 = r1.Z$0
            java.lang.Object r3 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0089
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r4
            if (r14 == 0) goto L_0x0089
            com.blueair.auth.GigyaService r15 = r13.gigyaService
            r1.L$0 = r3
            r1.Z$0 = r14
            r1.label = r7
            java.lang.Object r15 = r15.checkGigyaTokenExpiry(r1)
            if (r15 != r2) goto L_0x0089
            goto L_0x00cb
        L_0x0089:
            kotlinx.coroutines.sync.Mutex r15 = r13.ablJwtMutex
            r1.L$0 = r3
            r1.L$1 = r15
            r1.Z$0 = r14
            r1.I$0 = r8
            r1.label = r6
            java.lang.Object r6 = r15.lock(r9, r1)
            if (r6 != r2) goto L_0x009c
            goto L_0x00cb
        L_0x009c:
            r6 = r14
            r14 = r15
            r15 = r8
        L_0x009f:
            boolean r7 = r13.isAblJwtExpired$auth_otherRelease()     // Catch:{ all -> 0x0045 }
            if (r7 == 0) goto L_0x0106
            com.blueair.auth.AuthService$getAblJwt$2$response$1 r7 = new com.blueair.auth.AuthService$getAblJwt$2$response$1     // Catch:{ all -> 0x0045 }
            com.blueair.auth.retrofit.AblUserApi r10 = r13.userApi     // Catch:{ all -> 0x0045 }
            r7.<init>(r10)     // Catch:{ all -> 0x0045 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ all -> 0x0045 }
            com.blueair.auth.retrofit.AblUserApi$GigyaJwtTokenExchange r10 = new com.blueair.auth.retrofit.AblUserApi$GigyaJwtTokenExchange     // Catch:{ all -> 0x0045 }
            java.lang.String r11 = r13.getGigyaJwt()     // Catch:{ all -> 0x0045 }
            java.lang.String r12 = "gigya"
            r10.<init>(r11, r12)     // Catch:{ all -> 0x0045 }
            r1.L$0 = r3     // Catch:{ all -> 0x0045 }
            r1.L$1 = r14     // Catch:{ all -> 0x0045 }
            r1.Z$0 = r6     // Catch:{ all -> 0x0045 }
            r1.I$0 = r15     // Catch:{ all -> 0x0045 }
            r1.I$1 = r8     // Catch:{ all -> 0x0045 }
            r1.label = r5     // Catch:{ all -> 0x0045 }
            java.lang.Object r15 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r7, r10, r1)     // Catch:{ all -> 0x0045 }
            if (r15 != r2) goto L_0x00cc
        L_0x00cb:
            return r2
        L_0x00cc:
            r1 = r3
        L_0x00cd:
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15     // Catch:{ all -> 0x0045 }
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r3.<init>(r0)     // Catch:{ all -> 0x0045 }
            java.lang.Object r0 = r15.getOrNull()     // Catch:{ all -> 0x0045 }
            com.blueair.auth.retrofit.AblUserApi$GigyaJwtTokenExchange r0 = (com.blueair.auth.retrofit.AblUserApi.GigyaJwtTokenExchange) r0     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = r0.getToken()     // Catch:{ all -> 0x0045 }
            goto L_0x00e4
        L_0x00e3:
            r0 = r9
        L_0x00e4:
            r3.append(r0)     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0045 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x0045 }
            r2.d(r0, r3)     // Catch:{ all -> 0x0045 }
            java.lang.Object r15 = r15.getOrNull()     // Catch:{ all -> 0x0045 }
            com.blueair.auth.retrofit.AblUserApi$GigyaJwtTokenExchange r15 = (com.blueair.auth.retrofit.AblUserApi.GigyaJwtTokenExchange) r15     // Catch:{ all -> 0x0045 }
            if (r15 == 0) goto L_0x00fd
            java.lang.String r15 = r15.getToken()     // Catch:{ all -> 0x0045 }
            goto L_0x00fe
        L_0x00fd:
            r15 = r9
        L_0x00fe:
            if (r15 != 0) goto L_0x0101
            goto L_0x0102
        L_0x0101:
            r4 = r15
        L_0x0102:
            r13.setAblJwt(r4)     // Catch:{ all -> 0x0045 }
            r3 = r1
        L_0x0106:
            java.lang.String r15 = r13.getAblJwt()     // Catch:{ all -> 0x0045 }
            r3.element = r15     // Catch:{ all -> 0x0045 }
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0045 }
            r14.unlock(r9)
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.String r15 = "getAblJwt done"
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r14.d(r15, r0)
            T r14 = r3.element
            return r14
        L_0x011d:
            r14.unlock(r9)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.getAblJwt(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getAblJwt$default(AuthService authService, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return authService.getAblJwt(z, continuation);
    }

    public final boolean isAblJwtExpired$auth_otherRelease() {
        if (getAblJwt().length() != 0 && Companion.getAblExpireTimeMillis$auth_otherRelease(getAblJwt()) > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public void logOut() {
        this._isUserLoggedIn.setValue(false);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AuthService$logOut$1(this, (Continuation<? super AuthService$logOut$1>) null), 3, (Object) null);
        this.gigyaService.logOut();
        stopAblTokenRefreshingJob();
        resetAblToken();
        setAblUser(new AblUserApi.AblUser(0, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 4095, (DefaultConstructorMarker) null));
        resetCloudJwt();
        this.analyticsService.setUserId((String) null, (String) null, (String) null);
        clearUserData();
    }

    public final void clearUserData() {
        PreferencesHelper.INSTANCE.set(this.unsecurePrefs.getBackend(), PrefKeys.KEY_USER_INFO_COLLECTIONS_SYNC_TIME, 0L, Reflection.getOrCreateKotlinClass(Long.class));
        UserInfoCollectionsManager.INSTANCE.clearData();
    }

    public final void setGigyaToken(String str, String str2, String str3) {
        Claim claim;
        CharSequence charSequence = str;
        String str4 = str2;
        String str5 = str3;
        Intrinsics.checkNotNullParameter(charSequence, "username");
        Intrinsics.checkNotNullParameter(str4, "gigyaUid");
        Intrinsics.checkNotNullParameter(str5, "gigyaToken");
        logOut();
        this.gigyaService.setGigyaJwt(str5);
        CharSequence charSequence2 = str5;
        this._isUserLoggedIn.setValue(Boolean.valueOf(charSequence2.length() > 0));
        if (charSequence2.length() != 0) {
            CharSequence charSequence3 = charSequence;
            if (charSequence3.length() == 0 && ((claim = new JWT(str5).getClaims().get("email")) == null || (charSequence3 = claim.asString()) == null)) {
                charSequence3 = "";
            }
            String str6 = (String) charSequence3;
            if (str6.length() > 0) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AuthService$setGigyaToken$1(this, str6, str4, (Continuation<? super AuthService$setGigyaToken$1>) null), 3, (Object) null);
            } else {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AuthService$setGigyaToken$2(this, (Continuation<? super AuthService$setGigyaToken$2>) null), 3, (Object) null);
            }
        }
    }

    public final String getLocallySavedDeviceJwt(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return (String) PreferencesHelper.INSTANCE.get(this.securePrefs.getBackend(), "JWT" + device.getUid(), null, Reflection.getOrCreateKotlinClass(String.class));
    }

    public final void clear() {
        stopAblTokenRefreshingJob();
        JobKt__JobKt.cancelChildren$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0510, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0511, code lost:
        if (r1 == null) goto L_0x061c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x051b, code lost:
        if (kotlin.text.StringsKt.isBlank(r17) != false) goto L_0x061c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x051d, code lost:
        r1 = new com.blueair.auth.retrofit.AblUserApi.UserAttribute(r17, "", EXTUID, com.foobot.liblabclient.domain.Attribute.SCOPE_USER, r13.getId(), "");
        r8 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r3.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17);
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r3.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r3.L$7 = r1;
        r3.J$0 = r5;
        r3.label = 11;
        r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$2(r0.userApi), r8, r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0573, code lost:
        if (r2 != r4) goto L_0x0577;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0577, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x057f, code lost:
        if (((io.flatcircle.coroutinehelper.ApiResult) r2).isFailure() == false) goto L_0x0614;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0581, code lost:
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r3.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r3.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r3.L$7 = r1;
        r3.J$0 = r5;
        r3.label = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x05b9, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r3) != r4) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x05bd, code lost:
        r8 = r13;
        r13 = r15;
        r15 = r7;
        r7 = r11;
        r11 = r14;
        r14 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x05c3, code lost:
        r9 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r3.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r3.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8);
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r3.L$7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.J$0 = r5;
        r3.label = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x060a, code lost:
        if (com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$3(r0.userApi), r9, r1, r3) != r4) goto L_0x060e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x060e, code lost:
        r1 = r7;
        r7 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0614, code lost:
        r1 = r11;
        r8 = r13;
        r11 = r14;
        r14 = r7;
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0619, code lost:
        r7 = r12;
        r12 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x061c, code lost:
        r1 = r11;
        r8 = r13;
        r11 = r14;
        r13 = r17;
        r14 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0623, code lost:
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r3.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r3.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8);
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r3.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.L$7 = null;
        r3.J$0 = r5;
        r3.label = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x065a, code lost:
        if (updateLanguage(r3) != r4) goto L_0x065d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x065d, code lost:
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
        r3.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r3.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8);
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r3.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.J$0 = r5;
        r3.label = 15;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0693, code lost:
        if (setPushToken$default(r0, (java.lang.String) null, r3, 1, (java.lang.Object) null) != r4) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0695, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x069f, code lost:
        return new io.flatcircle.coroutinehelper.Success(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x06b4, code lost:
        return new io.flatcircle.coroutinehelper.Failure(new java.lang.Exception(java.lang.String.valueOf(r2.exceptionOrNull())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x06c9, code lost:
        return new io.flatcircle.coroutinehelper.Failure(new java.lang.Exception(java.lang.String.valueOf(r2.exceptionOrNull())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0138, code lost:
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0255, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r3) == r4) goto L_0x0695;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0259, code lost:
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r3.L$1 = r1;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r3.label = 3;
        r2 = getAblJwt(false, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x026e, code lost:
        if (r2 != r4) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0272, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x027b, code lost:
        if (r2.length() != 0) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x028b, code lost:
        return new io.flatcircle.coroutinehelper.Failure(new java.lang.Exception("getAirBoxJwtFromGigyaJwt returned empty string"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x02e2, code lost:
        r12 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$1 = r5;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.J$0 = r7;
        r3.label = 5;
        r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$userResponse$1(r0.userApi), r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0306, code lost:
        if (r2 != r4) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x030a, code lost:
        r2 = (io.flatcircle.coroutinehelper.ApiResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0310, code lost:
        if (r2.isSuccess() == false) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0312, code lost:
        timber.log.Timber.Forest.d("authenticateAblUser: user response body = " + r2.getOrNull(), new java.lang.Object[0]);
        r12 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r2.getOrNull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0331, code lost:
        r13 = r10;
        r10 = r1;
        r1 = r12;
        r12 = r5;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0338, code lost:
        timber.log.Timber.Forest.d("authenticateAblUser: user failed with exception = " + r2.exceptionOrNull(), new java.lang.Object[0]);
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$1 = r5;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r3.J$0 = r7;
        r3.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0370, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r3) != r4) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0374, code lost:
        r13 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$1 = r5;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r3.J$0 = r7;
        r3.label = 7;
        r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$user$1(r0.userApi), r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x039e, code lost:
        if (r2 != r4) goto L_0x03a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x03a2, code lost:
        r2 = (io.flatcircle.coroutinehelper.ApiResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x03a8, code lost:
        if (r2.isSuccess() == false) goto L_0x06b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x03aa, code lost:
        r12 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r2.getOrNull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x03b1, code lost:
        if (r1 == null) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x03b3, code lost:
        setAblUser(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x03b6, code lost:
        r14 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$1 = r12;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r3.L$4 = r1;
        r3.J$0 = r7;
        r3.label = 8;
        r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$extUidResponse$1(r0.userApi), r14, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x03e3, code lost:
        if (r2 != r4) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x03e7, code lost:
        r2 = (io.flatcircle.coroutinehelper.ApiResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x03ed, code lost:
        if (r2.isSuccess() == false) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x03ef, code lost:
        timber.log.Timber.Forest.d("authenticateAblUser: extUid response body = " + r2.getOrNull(), new java.lang.Object[0]);
        r9 = (java.util.List) r2.getOrNull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x040e, code lost:
        if (r9 == null) goto L_0x0438;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0410, code lost:
        r9 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x041a, code lost:
        if (r9.hasNext() == false) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x041c, code lost:
        r11 = r9.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x042b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((com.blueair.auth.retrofit.AblUserApi.UserAttribute) r11).getName(), (java.lang.Object) EXTUID) == false) goto L_0x0416;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x042e, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x042f, code lost:
        r11 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r11;
        r14 = r5;
        r5 = r7;
        r15 = r10;
        r17 = r12;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0438, code lost:
        r14 = r5;
        r5 = r7;
        r15 = r10;
        r17 = r12;
        r7 = r13;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x043f, code lost:
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0440, code lost:
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0443, code lost:
        timber.log.Timber.Forest.d("authenticateAblUser: extUid failed with exception = " + r2.exceptionOrNull(), new java.lang.Object[0]);
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13);
        r3.L$1 = r12;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r3.L$4 = r1;
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r3.J$0 = r7;
        r3.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0484, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r3) != r4) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0488, code lost:
        r13 = getUsername();
        r3.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r3.L$1 = r11;
        r3.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r3.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r3.L$4 = r1;
        r3.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r3.J$0 = r7;
        r3.label = 10;
        r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(new com.blueair.auth.AuthService$authenticateAblUser$extUid$2(r0.userApi), r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x04bb, code lost:
        if (r2 != r4) goto L_0x04bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x04bf, code lost:
        r2 = (io.flatcircle.coroutinehelper.ApiResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x04c5, code lost:
        if (r2.isSuccess() == false) goto L_0x06a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x04c7, code lost:
        r9 = (java.util.List) r2.getOrNull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x04cd, code lost:
        if (r9 == null) goto L_0x04f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x04cf, code lost:
        r9 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x04d9, code lost:
        if (r9.hasNext() == false) goto L_0x04ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x04db, code lost:
        r13 = r9.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x04ea, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((com.blueair.auth.retrofit.AblUserApi.UserAttribute) r13).getName(), (java.lang.Object) EXTUID) == false) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x04ed, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x04ee, code lost:
        r14 = r5;
        r5 = r7;
        r15 = r10;
        r17 = r11;
        r7 = r12;
        r11 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x04f9, code lost:
        r13 = r1;
        r14 = r5;
        r5 = r7;
        r15 = r10;
        r17 = r11;
        r7 = r12;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0503, code lost:
        if (r11 != null) goto L_0x061c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0505, code lost:
        if (r13 == null) goto L_0x0510;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0507, code lost:
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13.getId());
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object authenticateAblUser(java.lang.String r25, java.lang.String r26, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Boolean>> r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r2 = r27
            boolean r3 = r2 instanceof com.blueair.auth.AuthService$authenticateAblUser$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.auth.AuthService$authenticateAblUser$1 r3 = (com.blueair.auth.AuthService$authenticateAblUser$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.auth.AuthService$authenticateAblUser$1 r3 = new com.blueair.auth.AuthService$authenticateAblUser$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            java.lang.String r6 = "ext_uid"
            r9 = 1
            r11 = 0
            switch(r5) {
                case 0: goto L_0x01e0;
                case 1: goto L_0x01d4;
                case 2: goto L_0x01c0;
                case 3: goto L_0x01af;
                case 4: goto L_0x019c;
                case 5: goto L_0x0189;
                case 6: goto L_0x016e;
                case 7: goto L_0x0157;
                case 8: goto L_0x013c;
                case 9: goto L_0x0117;
                case 10: goto L_0x00f8;
                case 11: goto L_0x00d1;
                case 12: goto L_0x00a4;
                case 13: goto L_0x007d;
                case 14: goto L_0x005a;
                case 15: goto L_0x0036;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            long r4 = r3.J$0
            java.lang.Object r1 = r3.L$6
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r1 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r1 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r1
            java.lang.Object r1 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r1 = r9
            goto L_0x0696
        L_0x005a:
            long r5 = r3.J$0
            java.lang.Object r1 = r3.L$6
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r7 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r8 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r8 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r8
            java.lang.Object r11 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r11 = (io.flatcircle.coroutinehelper.ApiResult) r11
            java.lang.Object r12 = r3.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r3.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x065d
        L_0x007d:
            long r5 = r3.J$0
            java.lang.Object r1 = r3.L$7
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r1 = r3.L$6
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r7 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r8 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r8 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r8
            java.lang.Object r11 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r11 = (io.flatcircle.coroutinehelper.ApiResult) r11
            java.lang.Object r12 = r3.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r3.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0623
        L_0x00a4:
            long r5 = r3.J$0
            java.lang.Object r1 = r3.L$7
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r7 = r3.L$6
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r7 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r7
            java.lang.Object r8 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            java.lang.Object r11 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r11 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r11
            java.lang.Object r12 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            java.lang.Object r13 = r3.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r3.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r3.L$0
            java.lang.String r15 = (java.lang.String) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r23 = r12
            r12 = r8
            r8 = r11
            r11 = r23
            goto L_0x05c3
        L_0x00d1:
            long r5 = r3.J$0
            java.lang.Object r1 = r3.L$7
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r1 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r1
            java.lang.Object r11 = r3.L$6
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r11 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r11
            java.lang.Object r12 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            java.lang.Object r13 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r13 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r13
            java.lang.Object r14 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            java.lang.Object r15 = r3.L$2
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r10 = r3.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r7 = r3.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0579
        L_0x00f8:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r1 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r1
            java.lang.Object r5 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            java.lang.Object r10 = r3.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r3.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r3.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x04bf
        L_0x0117:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$5
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r5 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r5 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r5
            java.lang.Object r10 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            java.lang.Object r11 = r3.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r3.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            r1 = r5
            r5 = r10
            r10 = r11
        L_0x0138:
            r11 = r12
            r12 = r13
            goto L_0x0488
        L_0x013c:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$4
            com.blueair.auth.retrofit.AblUserApi$AblUser r1 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r1
            java.lang.Object r5 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            java.lang.Object r10 = r3.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r12 = r3.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x03e7
        L_0x0157:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r3.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x03a2
        L_0x016e:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$3
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r3.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r12 = r3.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            r1 = r5
            r5 = r10
            r10 = r12
            goto L_0x0374
        L_0x0189:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r3.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x030a
        L_0x019c:
            long r7 = r3.J$0
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r3.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x02e2
        L_0x01af:
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0272
        L_0x01c0:
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r3.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            r1 = r5
            r5 = r7
            goto L_0x0259
        L_0x01d4:
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0233
        L_0x01e0:
            kotlin.ResultKt.throwOnFailure(r2)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "authenticateAblUser: "
            r5.<init>(r7)
            r7 = r25
            r5.append(r7)
            java.lang.String r8 = ", "
            r5.append(r8)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r11]
            r2.d(r5, r8)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._isUserLoggedIn
            java.lang.String r5 = r0.getGigyaJwt()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0212
            r5 = r9
            goto L_0x0213
        L_0x0212:
            r5 = r11
        L_0x0213:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r2.setValue(r5)
            r24.setUsername(r25)
            r0.updateHomeHost()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$0 = r2
            r3.L$1 = r1
            r3.label = r9
            java.lang.Object r2 = r0.getAblJwt(r11, r3)
            if (r2 != r4) goto L_0x0232
            goto L_0x0695
        L_0x0232:
            r5 = r7
        L_0x0233:
            java.lang.String r2 = (java.lang.String) r2
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x028c
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$0 = r7
            r3.L$1 = r1
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$2 = r7
            r7 = 2
            r3.label = r7
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r7, r3)
            if (r10 != r4) goto L_0x0259
            goto L_0x0695
        L_0x0259:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$0 = r7
            r3.L$1 = r1
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$2 = r2
            r2 = 3
            r3.label = r2
            java.lang.Object r2 = r0.getAblJwt(r11, r3)
            if (r2 != r4) goto L_0x0272
            goto L_0x0695
        L_0x0272:
            java.lang.String r2 = (java.lang.String) r2
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x028c
            io.flatcircle.coroutinehelper.Failure r1 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "getAirBoxJwtFromGigyaJwt returned empty string"
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1.<init>(r2)
            return r1
        L_0x028c:
            com.auth0.android.jwt.JWT r7 = new com.auth0.android.jwt.JWT
            r7.<init>(r2)
            java.util.Date r7 = r7.getExpiresAt()
            if (r7 == 0) goto L_0x029c
            long r7 = r7.getTime()
            goto L_0x02a3
        L_0x029c:
            r7 = 0
            long r12 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r12
        L_0x02a3:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "ablJwt acquired. Expires in "
            r12.<init>(r13)
            r13 = 1000(0x3e8, float:1.401E-42)
            long r13 = (long) r13
            long r13 = r7 / r13
            r12.append(r13)
            java.lang.String r13 = " seconds"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.Object[] r13 = new java.lang.Object[r11]
            r10.i(r12, r13)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$0 = r10
            r3.L$1 = r1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$2 = r10
            r3.J$0 = r7
            r10 = 4
            r3.label = r10
            r12 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r12, r3)
            if (r10 != r4) goto L_0x02df
            goto L_0x0695
        L_0x02df:
            r10 = r5
            r5 = r1
            r1 = r2
        L_0x02e2:
            com.blueair.auth.AuthService$authenticateAblUser$userResponse$1 r2 = new com.blueair.auth.AuthService$authenticateAblUser$userResponse$1
            com.blueair.auth.retrofit.AblUserApi r12 = r0.userApi
            r2.<init>(r12)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.String r12 = r0.getUsername()
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$0 = r13
            r3.L$1 = r5
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$2 = r13
            r3.J$0 = r7
            r13 = 5
            r3.label = r13
            java.lang.Object r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r2, r12, r3)
            if (r2 != r4) goto L_0x030a
            goto L_0x0695
        L_0x030a:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r12 = r2.isSuccess()
            if (r12 == 0) goto L_0x0338
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "authenticateAblUser: user response body = "
            r13.<init>(r14)
            java.lang.Object r14 = r2.getOrNull()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r14 = new java.lang.Object[r11]
            r12.d(r13, r14)
            java.lang.Object r12 = r2.getOrNull()
            com.blueair.auth.retrofit.AblUserApi$AblUser r12 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r12
        L_0x0331:
            r13 = r10
            r10 = r1
            r1 = r12
            r12 = r5
            r5 = r2
            goto L_0x03b1
        L_0x0338:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "authenticateAblUser: user failed with exception = "
            r13.<init>(r14)
            java.lang.Throwable r14 = r2.exceptionOrNull()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r14 = new java.lang.Object[r11]
            r12.d(r13, r14)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$0 = r12
            r3.L$1 = r5
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$2 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$3 = r12
            r3.J$0 = r7
            r12 = 6
            r3.label = r12
            r12 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r12, r3)
            if (r14 != r4) goto L_0x0374
            goto L_0x0695
        L_0x0374:
            com.blueair.auth.AuthService$authenticateAblUser$user$1 r12 = new com.blueair.auth.AuthService$authenticateAblUser$user$1
            com.blueair.auth.retrofit.AblUserApi r13 = r0.userApi
            r12.<init>(r13)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.String r13 = r0.getUsername()
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$0 = r14
            r3.L$1 = r5
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$2 = r14
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$3 = r2
            r3.J$0 = r7
            r2 = 7
            r3.label = r2
            java.lang.Object r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r12, r13, r3)
            if (r2 != r4) goto L_0x03a2
            goto L_0x0695
        L_0x03a2:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r12 = r2.isSuccess()
            if (r12 == 0) goto L_0x06b5
            java.lang.Object r12 = r2.getOrNull()
            com.blueair.auth.retrofit.AblUserApi$AblUser r12 = (com.blueair.auth.retrofit.AblUserApi.AblUser) r12
            goto L_0x0331
        L_0x03b1:
            if (r1 == 0) goto L_0x03b6
            r0.setAblUser(r1)
        L_0x03b6:
            com.blueair.auth.AuthService$authenticateAblUser$extUidResponse$1 r2 = new com.blueair.auth.AuthService$authenticateAblUser$extUidResponse$1
            com.blueair.auth.retrofit.AblUserApi r14 = r0.userApi
            r2.<init>(r14)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.String r14 = r0.getUsername()
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$0 = r15
            r3.L$1 = r12
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$2 = r15
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$3 = r15
            r3.L$4 = r1
            r3.J$0 = r7
            r15 = 8
            r3.label = r15
            java.lang.Object r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r2, r14, r3)
            if (r2 != r4) goto L_0x03e7
            goto L_0x0695
        L_0x03e7:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r14 = r2.isSuccess()
            if (r14 == 0) goto L_0x0443
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r9 = "authenticateAblUser: extUid response body = "
            r15.<init>(r9)
            java.lang.Object r9 = r2.getOrNull()
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r14.d(r9, r11)
            java.lang.Object r9 = r2.getOrNull()
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x0438
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0416:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x042e
            java.lang.Object r11 = r9.next()
            r14 = r11
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r14 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r14
            java.lang.String r14 = r14.getName()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r6)
            if (r14 == 0) goto L_0x0416
            goto L_0x042f
        L_0x042e:
            r11 = 0
        L_0x042f:
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r11 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r11
            r14 = r5
            r5 = r7
            r15 = r10
            r17 = r12
            r7 = r13
            goto L_0x043f
        L_0x0438:
            r14 = r5
            r5 = r7
            r15 = r10
            r17 = r12
            r7 = r13
            r11 = 0
        L_0x043f:
            r13 = r1
        L_0x0440:
            r12 = r2
            goto L_0x0503
        L_0x0443:
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "authenticateAblUser: extUid failed with exception = "
            r14.<init>(r15)
            java.lang.Throwable r15 = r2.exceptionOrNull()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r9.d(r14, r11)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$0 = r9
            r3.L$1 = r12
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$2 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$3 = r9
            r3.L$4 = r1
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$5 = r9
            r3.J$0 = r7
            r9 = 9
            r3.label = r9
            r14 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r14, r3)
            if (r9 != r4) goto L_0x0138
            goto L_0x0695
        L_0x0488:
            com.blueair.auth.AuthService$authenticateAblUser$extUid$2 r9 = new com.blueair.auth.AuthService$authenticateAblUser$extUid$2
            com.blueair.auth.retrofit.AblUserApi r13 = r0.userApi
            r9.<init>(r13)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.String r13 = r0.getUsername()
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$0 = r14
            r3.L$1 = r11
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$2 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$3 = r14
            r3.L$4 = r1
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$5 = r2
            r3.J$0 = r7
            r2 = 10
            r3.label = r2
            java.lang.Object r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r9, r13, r3)
            if (r2 != r4) goto L_0x04bf
            goto L_0x0695
        L_0x04bf:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r9 = r2.isSuccess()
            if (r9 == 0) goto L_0x06a0
            java.lang.Object r9 = r2.getOrNull()
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x04f9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x04d5:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x04ed
            java.lang.Object r13 = r9.next()
            r14 = r13
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r14 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r14
            java.lang.String r14 = r14.getName()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r6)
            if (r14 == 0) goto L_0x04d5
            goto L_0x04ee
        L_0x04ed:
            r13 = 0
        L_0x04ee:
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r13 = (com.blueair.auth.retrofit.AblUserApi.UserAttribute) r13
            r14 = r5
            r5 = r7
            r15 = r10
            r17 = r11
            r7 = r12
            r11 = r13
            goto L_0x043f
        L_0x04f9:
            r13 = r1
            r14 = r5
            r5 = r7
            r15 = r10
            r17 = r11
            r7 = r12
            r11 = 0
            goto L_0x0440
        L_0x0503:
            if (r11 != 0) goto L_0x061c
            if (r13 == 0) goto L_0x0510
            int r1 = r13.getId()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            goto L_0x0511
        L_0x0510:
            r1 = 0
        L_0x0511:
            if (r1 == 0) goto L_0x061c
            r1 = r17
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 != 0) goto L_0x061c
            int r21 = r13.getId()
            com.blueair.auth.retrofit.AblUserApi$UserAttribute r16 = new com.blueair.auth.retrofit.AblUserApi$UserAttribute
            java.lang.String r20 = "user"
            java.lang.String r22 = ""
            java.lang.String r18 = ""
            java.lang.String r19 = "ext_uid"
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r1 = r16
            com.blueair.auth.AuthService$authenticateAblUser$2 r2 = new com.blueair.auth.AuthService$authenticateAblUser$2
            com.blueair.auth.retrofit.AblUserApi r8 = r0.userApi
            r2.<init>(r8)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            java.lang.String r8 = r0.getUsername()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r3.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r3.L$2 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$3 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$4 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$5 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$6 = r9
            r3.L$7 = r1
            r3.J$0 = r5
            r9 = 11
            r3.label = r9
            java.lang.Object r2 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r2, r8, r1, r3)
            if (r2 != r4) goto L_0x0577
            goto L_0x0695
        L_0x0577:
            r10 = r17
        L_0x0579:
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isFailure()
            if (r2 == 0) goto L_0x0614
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r3.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$4 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$5 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$6 = r2
            r3.L$7 = r1
            r3.J$0 = r5
            r2 = 12
            r3.label = r2
            r8 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r8, r3)
            if (r2 != r4) goto L_0x05bd
            goto L_0x0695
        L_0x05bd:
            r8 = r13
            r13 = r15
            r15 = r7
            r7 = r11
            r11 = r14
            r14 = r10
        L_0x05c3:
            com.blueair.auth.AuthService$authenticateAblUser$3 r2 = new com.blueair.auth.AuthService$authenticateAblUser$3
            com.blueair.auth.retrofit.AblUserApi r9 = r0.userApi
            r2.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            java.lang.String r9 = r0.getUsername()
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r3.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$3 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$4 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$5 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$6 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$7 = r10
            r3.J$0 = r5
            r10 = 13
            r3.label = r10
            java.lang.Object r1 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r2, r9, r1, r3)
            if (r1 != r4) goto L_0x060e
            goto L_0x0695
        L_0x060e:
            r1 = r7
            r7 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            goto L_0x0623
        L_0x0614:
            r1 = r11
            r8 = r13
            r11 = r14
            r14 = r7
            r13 = r10
        L_0x0619:
            r7 = r12
            r12 = r15
            goto L_0x0623
        L_0x061c:
            r1 = r11
            r8 = r13
            r11 = r14
            r13 = r17
            r14 = r7
            goto L_0x0619
        L_0x0623:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$4 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$5 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$6 = r2
            r2 = 0
            r3.L$7 = r2
            r3.J$0 = r5
            r2 = 14
            r3.label = r2
            java.lang.Object r2 = r0.updateLanguage(r3)
            if (r2 != r4) goto L_0x065d
            goto L_0x0695
        L_0x065d:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$4 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$5 = r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$6 = r1
            r3.J$0 = r5
            r1 = 15
            r3.label = r1
            r1 = 1
            r2 = 0
            java.lang.Object r2 = setPushToken$default(r0, r2, r3, r1, r2)
            if (r2 != r4) goto L_0x0696
        L_0x0695:
            return r4
        L_0x0696:
            io.flatcircle.coroutinehelper.Success r2 = new io.flatcircle.coroutinehelper.Success
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r2.<init>(r1)
            return r2
        L_0x06a0:
            io.flatcircle.coroutinehelper.Failure r1 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Exception r3 = new java.lang.Exception
            java.lang.Throwable r2 = r2.exceptionOrNull()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.<init>(r2)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1.<init>(r3)
            return r1
        L_0x06b5:
            io.flatcircle.coroutinehelper.Failure r1 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Exception r3 = new java.lang.Exception
            java.lang.Throwable r2 = r2.exceptionOrNull()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.<init>(r2)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1.<init>(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.authenticateAblUser(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateHomeHost() {
        if (AblEnvironment.INSTANCE.isUAT()) {
            setAblHomeHost(AblEnvironment.UAT);
        } else if (getUsername().length() > 0) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AuthService$updateHomeHost$1(this, (Continuation<? super AuthService$updateHomeHost$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r6 == r1) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateGigyaDataCenter(kotlin.coroutines.Continuation<? super com.blueair.auth.GigyaServer> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.auth.AuthService$updateGigyaDataCenter$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.auth.AuthService$updateGigyaDataCenter$1 r0 = (com.blueair.auth.AuthService$updateGigyaDataCenter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$updateGigyaDataCenter$1 r0 = new com.blueair.auth.AuthService$updateGigyaDataCenter$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            return r6
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.blueair.auth.GigyaService r2 = (com.blueair.auth.GigyaService) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.auth.GigyaService r2 = r5.gigyaService
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r6 = r5.fetchAblGranularRegion(r0)
            if (r6 != r1) goto L_0x004d
            goto L_0x005a
        L_0x004d:
            java.lang.String r6 = (java.lang.String) r6
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.updateGigyaDataCenter(r6, r0)
            if (r6 != r1) goto L_0x005b
        L_0x005a:
            return r1
        L_0x005b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.updateGigyaDataCenter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object doGigyaDataCentersHaveEmailAddress(String str, Continuation<? super Boolean> continuation) {
        return this.gigyaService.doGigyaDataCentersHaveEmailAddress(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAblGranularRegion(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.auth.AuthService$fetchAblGranularRegion$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.auth.AuthService$fetchAblGranularRegion$1 r0 = (com.blueair.auth.AuthService$fetchAblGranularRegion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$fetchAblGranularRegion$1 r0 = new com.blueair.auth.AuthService$fetchAblGranularRegion$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.auth.AuthService$fetchAblGranularRegion$response$1 r6 = new com.blueair.auth.AuthService$fetchAblGranularRegion$response$1
            com.blueair.auth.retrofit.AblUserApi r2 = r5.userApi
            r6.<init>(r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.label = r3
            java.lang.Object r6 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "fetchGranularRegionSync: response = "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            boolean r0 = r6.isSuccess()
            r1 = 0
            if (r0 == 0) goto L_0x008d
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "fetchGranularRegionSync: response.body = "
            r3.<init>(r4)
            java.lang.Object r4 = r6.getOrNull()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.d(r3, r2)
            java.lang.Object r6 = r6.getOrNull()
            com.blueair.auth.retrofit.AblUserApi$BlueairGranularRegion r6 = (com.blueair.auth.retrofit.AblUserApi.BlueairGranularRegion) r6
            if (r6 == 0) goto L_0x008c
            java.lang.String r6 = r6.getCountryCode()
            return r6
        L_0x008c:
            return r1
        L_0x008d:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "fetchGranularRegionSync: failed with exception: "
            r3.<init>(r4)
            java.lang.Throwable r6 = r6.exceptionOrNull()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.w(r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.fetchAblGranularRegion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object setPushToken$default(AuthService authService, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authService.getPushToken();
        }
        return authService.setPushToken(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setPushToken(java.lang.String r12, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.blueair.auth.AuthService$setPushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.auth.AuthService$setPushToken$1 r0 = (com.blueair.auth.AuthService$setPushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$setPushToken$1 r0 = new com.blueair.auth.AuthService$setPushToken$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r12 = r0.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a3
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r13)
            r11.setPushToken(r12)
            java.lang.String r13 = r11.getPushToken()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0049
            goto L_0x0057
        L_0x0049:
            kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> r13 = r11.isUserLoggedIn
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0060
        L_0x0057:
            io.flatcircle.coroutinehelper.ApiResult$Companion r12 = io.flatcircle.coroutinehelper.ApiResult.Companion
            okhttp3.ResponseBody r13 = okhttp3.internal.Util.EMPTY_RESPONSE
            io.flatcircle.coroutinehelper.ApiResult r12 = r12.success(r13)
            return r12
        L_0x0060:
            timber.log.Timber$Forest r13 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "setPushToken token = "
            r2.<init>(r4)
            java.lang.String r4 = r11.getPushToken()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r13.d(r2, r4)
            r5 = r11
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            com.blueair.auth.AuthService$setPushToken$2 r13 = new com.blueair.auth.AuthService$setPushToken$2
            r2 = 0
            r13.<init>(r11, r12, r2)
            r8 = r13
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
            com.blueair.auth.AuthService$setPushToken$3 r13 = new com.blueair.auth.AuthService$setPushToken$3
            r13.<init>(r11, r2)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r13 = r11.getBearerToken(r13, r0)
            if (r13 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            if (r13 != 0) goto L_0x00b7
            io.flatcircle.coroutinehelper.ApiResult$Companion r12 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Exception r13 = new java.lang.Exception
            java.lang.String r0 = "empty cloud jwt"
            r13.<init>(r0)
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            io.flatcircle.coroutinehelper.ApiResult r12 = r12.fail(r13)
            return r12
        L_0x00b7:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.setPushToken(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removePushToken(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.blueair.auth.AuthService$removePushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.blueair.auth.AuthService$removePushToken$1 r0 = (com.blueair.auth.AuthService$removePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$removePushToken$1 r0 = new com.blueair.auth.AuthService$removePushToken$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0058
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r10
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            com.blueair.auth.AuthService$removePushToken$2 r11 = new com.blueair.auth.AuthService$removePushToken$2
            r2 = 0
            r11.<init>(r2)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            com.blueair.auth.AuthService$removePushToken$3 r11 = new com.blueair.auth.AuthService$removePushToken$3
            r11.<init>(r10, r2)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r0.label = r3
            java.lang.Object r11 = r10.getBearerToken(r11, r0)
            if (r11 != r1) goto L_0x0058
            return r1
        L_0x0058:
            io.flatcircle.coroutinehelper.ApiResult r11 = (io.flatcircle.coroutinehelper.ApiResult) r11
            if (r11 != 0) goto L_0x006b
            io.flatcircle.coroutinehelper.ApiResult$Companion r11 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "empty cloud jwt"
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            io.flatcircle.coroutinehelper.ApiResult r11 = r11.fail(r0)
        L_0x006b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.removePushToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0169, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r12, new com.blueair.auth.AuthService$updateLanguage$3(r11, r2, (kotlin.coroutines.Continuation<? super com.blueair.auth.AuthService$updateLanguage$3>) null), r0) != r1) goto L_0x016c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateLanguage(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.blueair.auth.AuthService$updateLanguage$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.blueair.auth.AuthService$updateLanguage$1 r0 = (com.blueair.auth.AuthService$updateLanguage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthService$updateLanguage$1 r0 = new com.blueair.auth.AuthService$updateLanguage$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$1
            java.util.Locale r1 = (java.util.Locale) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x016c
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0043:
            java.lang.Object r2 = r0.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$1
            java.util.Locale r5 = (java.util.Locale) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0148
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r11.getUsername()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0064
            goto L_0x0072
        L_0x0064:
            kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> r12 = r11.isUserLoggedIn
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0075
        L_0x0072:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0075:
            com.blueair.core.service.UnsecurePrefs r12 = r11.unsecurePrefs
            io.flatcircle.preferenceshelper2.Prefs r12 = (io.flatcircle.preferenceshelper2.Prefs) r12
            io.flatcircle.preferenceshelper2.PreferencesHelper r2 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r12 = r12.getBackend()
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.String r7 = "language"
            java.lang.Object r12 = r2.get(r12, r7, r3, r6)
            r6 = r12
            java.lang.String r6 = (java.lang.String) r6
            java.util.Locale r12 = java.util.Locale.getDefault()
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "zh"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00b2
            java.lang.String r2 = r12.getCountry()
            java.util.Locale r8 = java.util.Locale.TAIWAN
            java.lang.String r8 = r8.getCountry()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r8)
            if (r2 == 0) goto L_0x00b2
            java.lang.String r2 = "zh_zh"
            goto L_0x011b
        L_0x00b2:
            java.lang.String r2 = r12.getLanguage()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00bf
            java.lang.String r2 = "zh_cn"
            goto L_0x011b
        L_0x00bf:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "fr"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00ce
            java.lang.String r2 = "fr_fr"
            goto L_0x011b
        L_0x00ce:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "ja"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00dd
            java.lang.String r2 = "ja_jp"
            goto L_0x011b
        L_0x00dd:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "ko"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = "ko_kr"
            goto L_0x011b
        L_0x00ec:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "es"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x00fb
            java.lang.String r2 = "es_es"
            goto L_0x011b
        L_0x00fb:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "sv"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x010a
            java.lang.String r2 = "sv_se"
            goto L_0x011b
        L_0x010a:
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r7 = "de"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x0119
            java.lang.String r2 = "de_de"
            goto L_0x011b
        L_0x0119:
            java.lang.String r2 = "en_us"
        L_0x011b:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            if (r7 != 0) goto L_0x016f
            com.blueair.auth.AuthService$updateLanguage$2 r7 = new com.blueair.auth.AuthService$updateLanguage$2
            com.blueair.auth.retrofit.AblUserApi r8 = r11.userApi
            r7.<init>(r8)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            java.lang.String r8 = r11.getUsername()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$1 = r9
            r0.L$2 = r2
            r0.label = r5
            java.lang.Object r5 = com.blueair.auth.AuthServiceKt.doSuspendedApiCall(r7, r8, r2, r0)
            if (r5 != r1) goto L_0x0145
            goto L_0x016b
        L_0x0145:
            r10 = r5
            r5 = r12
            r12 = r10
        L_0x0148:
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12
            com.blueair.auth.AuthService$updateLanguage$3 r7 = new com.blueair.auth.AuthService$updateLanguage$3
            r7.<init>(r11, r2, r3)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$1 = r3
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r12 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r12, r7, r0)
            if (r12 != r1) goto L_0x016c
        L_0x016b:
            return r1
        L_0x016c:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x016f:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService.updateLanguage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void startAblTokenRefreshingJob() {
        stopAblTokenRefreshingJob();
        if (this.isUserLoggedIn.getValue().booleanValue()) {
            this.ablTokenRefreshingJob = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AuthService$startAblTokenRefreshingJob$1(this, (Continuation<? super AuthService$startAblTokenRefreshingJob$1>) null), 2, (Object) null);
        }
    }

    private final void stopAblTokenRefreshingJob() {
        Job job = this.ablTokenRefreshingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.ablTokenRefreshingJob = null;
    }

    /* access modifiers changed from: private */
    public final long millisUntilAblTokenExpires() {
        if (isAblJwtExpired$auth_otherRelease()) {
            return 0;
        }
        return Companion.getAblExpireTimeMillis$auth_otherRelease(getAblJwt()) - System.currentTimeMillis();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/auth/AuthService$Companion;", "", "<init>", "()V", "EXTUID", "", "ABL_TOKEN_EXPIRE_RETRY_LENGTH_SECONDS", "", "ERROR_EMPTY_CLOUD_JWT", "getAblExpireTimeMillis", "", "ablJwt", "getAblExpireTimeMillis$auth_otherRelease", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AuthService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getAblExpireTimeMillis$auth_otherRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "ablJwt");
            JWT jwt = new JWT(str);
            Calendar instance = Calendar.getInstance();
            instance.add(1, 100);
            Date expiresAt = jwt.getExpiresAt();
            long time = expiresAt != null ? expiresAt.getTime() : 0;
            return time > instance.getTimeInMillis() ? time / 1000 : time;
        }
    }
}
