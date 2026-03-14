package com.blueair.auth;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.Lifecycle.Event;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.DecodeException;
import com.auth0.android.jwt.JWT;
import com.blueair.auth.retrofit.AblUserApi;
import com.blueair.auth.retrofit.BlueLoginDetails;
import com.blueair.auth.retrofit.CloudAuthApi;
import com.blueair.auth.retrofit.SetPushTokenRequest;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.LocaleUtils;
import com.blueair.core.util.StringUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.sdk.BugfenderSdk;
import com.blueair.sdk.KlaviyoProfileData;
import com.blueair.sdk.KlaviyoSdk;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.Success;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Ð\u00012\u00020\u00012\u00020\u0002:\u0002Ð\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0099\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010\u009a\u0001JS\u0010\u0087\u0001\u001a\u0005\u0018\u0001H\u009b\u0001\"\u0005\b\u0000\u0010\u009b\u000127\u0010\u009c\u0001\u001a2\b\u0001\u0012\u0016\u0012\u00140\u0015¢\u0006\u000f\b\u009e\u0001\u0012\n\b\u009f\u0001\u0012\u0005\b\b( \u0001\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003H\u009b\u00010Q\u0012\u0006\u0012\u0004\u0018\u00010T0\u009d\u0001H\u0086@¢\u0006\u0003\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00030£\u0001H\u0086@¢\u0006\u0003\u0010\u009a\u0001J\u0011\u0010¤\u0001\u001a\u00030£\u0001H\u0086@¢\u0006\u0003\u0010\u009a\u0001J\b\u0010¥\u0001\u001a\u00030£\u0001J\n\u0010¦\u0001\u001a\u00030£\u0001H\u0002J\t\u0010§\u0001\u001a\u00020\u001bH\u0002J/\u0010¨\u0001\u001a\u00030£\u00012\u0007\u0010©\u0001\u001a\u00020\u00152\f\b\u0002\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\f\b\u0002\u0010¬\u0001\u001a\u0005\u0018\u00010«\u0001H\u0002J\u001b\u0010\u0093\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\u001bH\u0082@¢\u0006\u0003\u0010®\u0001J\u000f\u0010¯\u0001\u001a\u00020\u001bH\u0000¢\u0006\u0003\b°\u0001J\n\u0010±\u0001\u001a\u00030£\u0001H\u0016J\b\u0010²\u0001\u001a\u00030£\u0001J!\u0010³\u0001\u001a\u00030£\u00012\u0006\u0010C\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0007\u0010´\u0001\u001a\u00020\u0015J\u0011\u0010µ\u0001\u001a\u00020\u00152\b\u0010¶\u0001\u001a\u00030·\u0001J\b\u0010¸\u0001\u001a\u00030£\u0001J(\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0º\u00012\u0007\u0010»\u0001\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010¼\u0001J\b\u0010½\u0001\u001a\u00030£\u0001J\u0011\u0010¾\u0001\u001a\u00030¿\u0001H\u0086@¢\u0006\u0003\u0010\u009a\u0001J\u0019\u0010À\u0001\u001a\u00020\u001b2\u0007\u0010Á\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Â\u0001J\u0012\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0003\u0010\u009a\u0001J\"\u0010M\u001a\n\u0012\u0005\u0012\u00030Ä\u00010º\u00012\t\b\u0002\u0010 \u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Â\u0001J!\u0010Å\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010º\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0015H\u0086@¢\u0006\u0003\u0010Â\u0001J\u0011\u0010Æ\u0001\u001a\u00030£\u0001H\u0086@¢\u0006\u0003\u0010\u009a\u0001J\n\u0010È\u0001\u001a\u00030£\u0001H\u0002J\n\u0010É\u0001\u001a\u00030£\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00140\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010!R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b+\u0010\u0018R+\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b6\u0010!R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R&\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010?R&\u0010@\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010?R+\u0010C\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u00104\u001a\u0004\bD\u0010!\"\u0004\bE\u0010?R+\u0010G\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u00104\u001a\u0004\bH\u0010!\"\u0004\bI\u0010?R+\u0010K\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bN\u00104\u001a\u0004\bL\u0010!\"\u0004\bM\u0010?R:\u0010O\u001a \b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R0Q\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010PX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0011\u0010Z\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010]\u001a\u00020^8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010a\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bb\u0010!R\u0011\u0010c\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bd\u0010!R\u0014\u0010e\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010!R\u0014\u0010g\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010!R\u001b\u0010i\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bj\u0010!R\u001b\u0010m\u001a\u00020n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010l\u001a\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u000e\u0010v\u001a\u00020wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\u00020y8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b}\u0010uR\u0014\u0010~\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010!R\u0013\u0010\u0080\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010!R\u0013\u0010\u0082\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010!R\u0013\u0010\u0084\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010!R\u0013\u0010\u0086\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010!R3\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0007\u0010,\u001a\u00030\u0088\u00018B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u008e\u0001\u00104\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0092\u0001\u001a\u00020\u00152\u0007\u0010\u0091\u0001\u001a\u00020\u00158F@BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010!\"\u0005\b\u0094\u0001\u0010?R\u0010\u0010\u0095\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ç\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ì\u0001\u001a\u00030Í\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001¨\u0006Ñ\u0001"},
   d2 = {"Lcom/blueair/auth/AuthService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "unsecurePrefs", "Lcom/blueair/core/service/UnsecurePrefs;", "locationService", "Lcom/blueair/auth/LocationService;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Lcom/blueair/auth/GigyaService;Lcom/blueair/core/service/SecurePrefs;Lcom/blueair/core/service/UnsecurePrefs;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/AnalyticsService;Lokhttp3/Interceptor;)V", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaJwtObserver", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "getGigyaJwtObserver", "()Lio/reactivex/Observable;", "_isUserLoggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isUserLoggedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "cloudUserRegion", "getCloudUserRegion", "()Ljava/lang/String;", "gigyaJwt", "getGigyaJwt", "ablJwtPublisher", "Lio/reactivex/subjects/PublishSubject;", "getAblJwtPublisher", "()Lio/reactivex/subjects/PublishSubject;", "ablJwtPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "ablJwtObserver", "getAblJwtObserver", "<set-?>", "Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "ablUser", "getAblUser", "()Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "setAblUser", "(Lcom/blueair/auth/retrofit/AblUserApi$AblUser;)V", "ablUser$delegate", "Lkotlin/properties/ReadWriteProperty;", "gigyaUid", "getGigyaUid", "userId", "", "getUserId", "()I", "nuValue", "userIdForBlueCloud", "getUserIdForBlueCloud", "setUserIdForBlueCloud", "(Ljava/lang/String;)V", "appIdForMqtt", "getAppIdForMqtt", "setAppIdForMqtt", "username", "getUsername", "setUsername", "username$delegate", "ablHomeHost", "getAblHomeHost", "setAblHomeHost", "ablHomeHost$delegate", "pushToken", "getPushToken", "setPushToken", "pushToken$delegate", "pushSettingsFetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Lcom/blueair/core/model/NotificationSetting;", "", "getPushSettingsFetcher", "()Lkotlin/jvm/functions/Function1;", "setPushSettingsFetcher", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "useJPush", "getUseJPush", "()Z", "blueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "blueHomeHost", "getBlueHomeHost", "blueBrokerURL", "getBlueBrokerURL", "blueClientID", "getBlueClientID", "blueClientSecret", "getBlueClientSecret", "httpUserAgent", "getHttpUserAgent", "httpUserAgent$delegate", "Lkotlin/Lazy;", "userOkhttpClient", "Lokhttp3/OkHttpClient;", "getUserOkhttpClient", "()Lokhttp3/OkHttpClient;", "userOkhttpClient$delegate", "ablRestAdapter", "Lretrofit2/Retrofit;", "getAblRestAdapter", "()Lretrofit2/Retrofit;", "userApi", "Lcom/blueair/auth/retrofit/AblUserApi;", "cloudAuthApi", "Lcom/blueair/auth/retrofit/CloudAuthApi;", "getCloudAuthApi", "()Lcom/blueair/auth/retrofit/CloudAuthApi;", "cloudRestAdapter", "getCloudRestAdapter", "cloudJwtInternal", "getCloudJwtInternal", "authNameForMqtt", "getAuthNameForMqtt", "signatureForMqtt", "getSignatureForMqtt", "tokenForMqtt", "getTokenForMqtt", "bearerToken", "getBearerToken", "Lcom/blueair/auth/retrofit/BlueLoginDetails;", "blueLoginDetails", "getBlueLoginDetails", "()Lcom/blueair/auth/retrofit/BlueLoginDetails;", "setBlueLoginDetails", "(Lcom/blueair/auth/retrofit/BlueLoginDetails;)V", "blueLoginDetails$delegate", "ablJwtMutex", "Lkotlinx/coroutines/sync/Mutex;", "value", "ablJwt", "getAblJwt", "setAblJwt", "cloudJwtMutex", "cloudJwtExpiredCount", "cloudJwtExpiredJob", "Lkotlinx/coroutines/Job;", "getCloudJwt", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "token", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disableUserAccount", "", "deleteAccount", "resetCloudJwt", "resetAblToken", "isCloudJwtExpired", "recordCloudJwtExpired", "cause", "iat", "Ljava/util/Date;", "exp", "checkGigyaJwtExpiry", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAblJwtExpired", "isAblJwtExpired$auth_otherRelease", "logOut", "clearUserData", "setGigyaToken", "gigyaToken", "getLocallySavedDeviceJwt", "device", "Lcom/blueair/core/model/Device;", "clear", "authenticateAblUser", "Lio/flatcircle/coroutinehelper/ApiResult;", "nuUsername", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHomeHost", "updateGigyaDataCenter", "Lcom/blueair/auth/GigyaServer;", "doGigyaDataCentersHaveEmailAddress", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAblGranularRegion", "Lokhttp3/ResponseBody;", "removePushToken", "updateLanguage", "ablTokenRefreshingJob", "startAblTokenRefreshingJob", "stopAblTokenRefreshingJob", "millisUntilAblTokenExpires", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AuthService implements CoroutineScope, LogOutable {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AuthService.class, "ablJwtPublisher", "getAblJwtPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AuthService.class, "ablUser", "getAblUser()Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AuthService.class, "username", "getUsername()Ljava/lang/String;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AuthService.class, "ablHomeHost", "getAblHomeHost()Ljava/lang/String;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AuthService.class, "pushToken", "getPushToken()Ljava/lang/String;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AuthService.class, "blueLoginDetails", "getBlueLoginDetails()Lcom/blueair/auth/retrofit/BlueLoginDetails;", 0)))};
   private static final int ABL_TOKEN_EXPIRE_RETRY_LENGTH_SECONDS = 300;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String ERROR_EMPTY_CLOUD_JWT = "empty cloud jwt";
   public static final String EXTUID = "ext_uid";
   private final DefaultCoroutineScope $$delegate_0;
   private final MutableStateFlow _isUserLoggedIn;
   private final ReadWriteProperty ablHomeHost$delegate;
   private volatile String ablJwt;
   private final Mutex ablJwtMutex;
   private final LazyPublishSubject ablJwtPublisher$delegate;
   private Job ablTokenRefreshingJob;
   private final ReadWriteProperty ablUser$delegate;
   private final AnalyticsService analyticsService;
   private String appIdForMqtt;
   private final ReadWriteProperty blueLoginDetails$delegate;
   private int cloudJwtExpiredCount;
   private Job cloudJwtExpiredJob;
   private final Mutex cloudJwtMutex;
   private final GigyaService gigyaService;
   private final Lazy httpUserAgent$delegate;
   private final StateFlow isUserLoggedIn;
   private final LocationService locationService;
   private final Interceptor mockInterceptor;
   private Function1 pushSettingsFetcher;
   private final ReadWriteProperty pushToken$delegate;
   private final SecurePrefs securePrefs;
   private final UnsecurePrefs unsecurePrefs;
   private AblUserApi userApi;
   private String userIdForBlueCloud;
   private final Lazy userOkhttpClient$delegate;
   private final ReadWriteProperty username$delegate;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$1QzPv_d2FCXo0LmFbxo6wkc9ang(AuthService var0) {
      return userOkhttpClient_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Response $r8$lambda$8aDINd4QWYx9aM3IKclyDP1BGcc(AuthService var0, Interceptor.Chain var1) {
      return userOkhttpClient_delegate$lambda$5$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$s_ZJQglA0HbYrz00MnfogSOHAKQ/* $FF was: $r8$lambda$s-ZJQglA0HbYrz00MnfogSOHAKQ*/() {
      return httpUserAgent_delegate$lambda$3();
   }

   // $FF: synthetic method
   public static Response $r8$lambda$vbs0YE1xOs5u4NnNmigr_afaR5o/* $FF was: $r8$lambda$vbs0YE1xOs5u4NnNmigr-afaR5o*/(AuthService var0, Interceptor.Chain var1) {
      return _get_cloudRestAdapter_$lambda$6(var0, var1);
   }

   public AuthService(GigyaService var1, SecurePrefs var2, UnsecurePrefs var3, LocationService var4, AnalyticsService var5, Interceptor var6) {
      Intrinsics.checkNotNullParameter(var1, "gigyaService");
      Intrinsics.checkNotNullParameter(var2, "securePrefs");
      Intrinsics.checkNotNullParameter(var3, "unsecurePrefs");
      Intrinsics.checkNotNullParameter(var4, "locationService");
      Intrinsics.checkNotNullParameter(var5, "analyticsService");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.gigyaService = var1;
      this.securePrefs = var2;
      this.unsecurePrefs = var3;
      this.locationService = var4;
      this.analyticsService = var5;
      this.mockInterceptor = var6;
      boolean var7;
      if (((CharSequence)this.getGigyaJwt()).length() > 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      MutableStateFlow var8 = StateFlowKt.MutableStateFlow(var7);
      this._isUserLoggedIn = var8;
      StateFlow var9 = FlowKt.asStateFlow(var8);
      this.isUserLoggedIn = var9;
      this.ablJwtPublisher$delegate = new LazyPublishSubject();
      Delegates var11 = Delegates.INSTANCE;
      Prefs var12 = var2;
      AblUserApi.AblUser var22 = new AblUserApi.AblUser(0, (String)null, (Boolean)null, (String)null, (String)null, (String)null, (Integer)null, (String)null, (String)null, (String)null, (String)null, (Integer)null, 4095, (DefaultConstructorMarker)null);
      this.ablUser$delegate = (ReadWriteProperty)(new ObservableProperty(PreferencesHelper.INSTANCE.get(var12.getBackend(), "user_abl", var22, Reflection.getOrCreateKotlinClass(AblUserApi.AblUser.class)), this) {
         final AuthService this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            AblUserApi.AblUser var4 = (AblUserApi.AblUser)var3;
            if (!Intrinsics.areEqual(var4, (AblUserApi.AblUser)var2)) {
               if (Intrinsics.areEqual(var4, new AblUserApi.AblUser(0, (String)null, (Boolean)null, (String)null, (String)null, (String)null, (Integer)null, (String)null, (String)null, (String)null, (String)null, (Integer)null, 4095, (DefaultConstructorMarker)null))) {
                  this.this$0.securePrefs.remove("user_abl");
               } else {
                  Prefs var5 = this.this$0.securePrefs;
                  PreferencesHelper.INSTANCE.set(var5.getBackend(), "user_abl", var4, Reflection.getOrCreateKotlinClass(AblUserApi.AblUser.class));
               }

               this.this$0.setUsername(var4.getUsername());
            }

         }
      });
      var12 = var2;
      this.userIdForBlueCloud = (String)PreferencesHelper.INSTANCE.get(var12.getBackend(), "user_id_blue_cloud", "", Reflection.getOrCreateKotlinClass(String.class));
      var12 = var2;
      this.appIdForMqtt = (String)PreferencesHelper.INSTANCE.get(var12.getBackend(), "app_id_mqtt", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
      Delegates var15 = Delegates.INSTANCE;
      Prefs var16 = var2;
      this.username$delegate = (ReadWriteProperty)(new ObservableProperty(PreferencesHelper.INSTANCE.get(var16.getBackend(), "auth_email_encrypted", (Object)null, Reflection.getOrCreateKotlinClass(String.class)), this) {
         final AuthService this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            String var4 = (String)var3;
            if (!Intrinsics.areEqual(var4, (String)var2)) {
               if (((CharSequence)var4).length() == 0) {
                  this.this$0.securePrefs.remove("auth_email_encrypted");
                  return;
               }

               Prefs var5 = this.this$0.securePrefs;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), "auth_email_encrypted", var4, Reflection.getOrCreateKotlinClass(String.class));
            }

         }
      });
      var16 = var2;
      String var23 = AblEnvironment.INSTANCE.getBaseUrl();
      this.ablHomeHost$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "homehost_url_abl", var23, PreferencesHelper.INSTANCE.get(var16.getBackend(), "homehost_url_abl", var23, Reflection.getOrCreateKotlinClass(String.class))) {
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
      var16 = var2;
      this.pushToken$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "push_token", "", PreferencesHelper.INSTANCE.get(var16.getBackend(), "push_token", "", Reflection.getOrCreateKotlinClass(String.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(String.class));
            }

         }
      });
      this.httpUserAgent$delegate = LazyKt.lazy(new AuthService$$ExternalSyntheticLambda1());
      this.userOkhttpClient$delegate = LazyKt.lazy(new AuthService$$ExternalSyntheticLambda2(this));
      Object var19 = this.getAblRestAdapter().create(AblUserApi.class);
      Intrinsics.checkNotNullExpressionValue(var19, "create(...)");
      this.userApi = (AblUserApi)var19;
      Delegates var20 = Delegates.INSTANCE;
      Prefs var10 = var2;
      BlueLoginDetails var21 = new BlueLoginDetails((String)null, (String)null, 0, (String)null, (String)null, (String)null, (String)null, (String)null, 255, (DefaultConstructorMarker)null);
      this.blueLoginDetails$delegate = (ReadWriteProperty)(new ObservableProperty(PreferencesHelper.INSTANCE.get(var10.getBackend(), "blueair_login_details", var21, Reflection.getOrCreateKotlinClass(BlueLoginDetails.class)), this) {
         final AuthService this$0;

         public {
            this.this$0 = var2;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            BlueLoginDetails var4 = (BlueLoginDetails)var3;
            var2 = var2;
            if (!Intrinsics.areEqual(var4, var2)) {
               if (Intrinsics.areEqual(var4, new BlueLoginDetails((String)null, (String)null, 0, (String)null, (String)null, (String)null, (String)null, (String)null, 255, (DefaultConstructorMarker)null))) {
                  this.this$0.securePrefs.remove("blueair_login_details");
                  this.this$0.setUserIdForBlueCloud("");
                  return;
               }

               if (!Intrinsics.areEqual(var4, var2)) {
                  Prefs var6 = this.this$0.securePrefs;
                  PreferencesHelper.INSTANCE.set(var6.getBackend(), "blueair_login_details", var4, Reflection.getOrCreateKotlinClass(BlueLoginDetails.class));
                  this.this$0.setUserIdForBlueCloud("");
               }
            }

         }
      });
      this.ablJwtMutex = MutexKt.Mutex$default(false, 1, (Object)null);
      this.ablJwt = "";
      FlowKt.launchIn(FlowKt.onEach(new Flow((Flow)var9) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label25: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var11 = var4;
                           break label25;
                        }
                     }

                     var11 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var13 = ((<undefinedtype>)var11).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var11).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var11).I$0;
                     FlowCollector var7 = (FlowCollector)((<undefinedtype>)var11).L$3;
                     Object var8 = ((<undefinedtype>)var11).L$2;
                     <undefinedtype> var9 = (<undefinedtype>)((<undefinedtype>)var11).L$1;
                     Object var10 = ((<undefinedtype>)var11).L$0;
                     ResultKt.throwOnFailure(var13);
                  } else {
                     ResultKt.throwOnFailure(var13);
                     FlowCollector var14 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var11;
                     if ((Boolean)var1) {
                        ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                        ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                        ((<undefinedtype>)var11).I$0 = 0;
                        ((<undefinedtype>)var11).label = 1;
                        if (var14.emit(var1, (Continuation)var11) == var5) {
                           return var5;
                        }
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, new Function2(this, (Continuation)null) {
         int label;
         final AuthService this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.startAblTokenRefreshingJob();
               this.this$0.analyticsService.setUserId(String.valueOf(this.this$0.getAblUser().getId()), this.this$0.getGigyaService().getGigyaUid(), this.this$0.getGigyaService().getBlueCloudDomain().tag());
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), this);
      ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new LifecycleObserver(this) {
         final AuthService this$0;

         {
            this.this$0 = var1;
         }

         @OnLifecycleEvent(Event.ON_START)
         public final void onMoveToForeground() {
            Timber.Forest.d("LifecycleObserver.onMoveToForeground", new Object[0]);
            this.this$0.startAblTokenRefreshingJob();
         }
      });
      this.cloudJwtMutex = MutexKt.Mutex$default(false, 1, (Object)null);
   }

   // $FF: synthetic method
   public AuthService(GigyaService var1, SecurePrefs var2, UnsecurePrefs var3, LocationService var4, AnalyticsService var5, Interceptor var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 32) != 0) {
         var6 = null;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   private static final Response _get_cloudRestAdapter_$lambda$6(AuthService var0, Interceptor.Chain var1) {
      Intrinsics.checkNotNullParameter(var1, "chain");
      return var1.proceed(var1.request().newBuilder().addHeader("Accept-Charset", "UTF-8").addHeader("User-Agent", var0.getHttpUserAgent()).build());
   }

   private final Object getAblJwt(boolean var1, Continuation var2) {
      Object var8;
      label6689: {
         if (var2 instanceof <undefinedtype>) {
            var8 = (<undefinedtype>)var2;
            if ((((<undefinedtype>)var8).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var8).label += Integer.MIN_VALUE;
               break label6689;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            boolean Z$0;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAblJwt(false, (Continuation)this);
            }
         };
      }

      Mutex var5;
      Throwable var10000;
      label6692: {
         Ref.ObjectRef var9;
         Mutex var779;
         label6693: {
            Ref.ObjectRef var6;
            String var10;
            label6694: {
               Object var11;
               int var774;
               label6695: {
                  var7 = ((<undefinedtype>)var8).result;
                  var11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  var774 = ((<undefinedtype>)var8).label;
                  var10 = "";
                  boolean var4;
                  if (var774 != 0) {
                     if (var774 != 1) {
                        if (var774 != 2) {
                           if (var774 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var774 = ((<undefinedtype>)var8).I$1;
                           var774 = ((<undefinedtype>)var8).I$0;
                           var1 = ((<undefinedtype>)var8).Z$0;
                           var770 = (Mutex)((<undefinedtype>)var8).L$1;
                           var6 = (Ref.ObjectRef)((<undefinedtype>)var8).L$0;
                           var5 = var770;

                           try {
                              ResultKt.throwOnFailure(var7);
                              break label6694;
                           } catch (Throwable var766) {
                              var10000 = var766;
                              boolean var10001 = false;
                              break label6692;
                           }
                        }

                        var774 = ((<undefinedtype>)var8).I$0;
                        var1 = ((<undefinedtype>)var8).Z$0;
                        var770 = (Mutex)((<undefinedtype>)var8).L$1;
                        var6 = (Ref.ObjectRef)((<undefinedtype>)var8).L$0;
                        ResultKt.throwOnFailure(var7);
                        break label6695;
                     }

                     var4 = ((<undefinedtype>)var8).Z$0;
                     var6 = (Ref.ObjectRef)((<undefinedtype>)var8).L$0;
                     ResultKt.throwOnFailure(var7);
                  } else {
                     ResultKt.throwOnFailure(var7);
                     Ref.ObjectRef var771 = new Ref.ObjectRef();
                     var771.element = "";
                     var6 = var771;
                     var4 = var1;
                     if (var1) {
                        GigyaService var777 = this.gigyaService;
                        ((<undefinedtype>)var8).L$0 = var771;
                        ((<undefinedtype>)var8).Z$0 = var1;
                        ((<undefinedtype>)var8).label = 1;
                        var6 = var771;
                        var4 = var1;
                        if (var777.checkGigyaTokenExpiry((Continuation)var8) == var11) {
                           return var11;
                        }
                     }
                  }

                  var770 = this.ablJwtMutex;
                  ((<undefinedtype>)var8).L$0 = var6;
                  ((<undefinedtype>)var8).L$1 = var770;
                  ((<undefinedtype>)var8).Z$0 = var4;
                  ((<undefinedtype>)var8).I$0 = 0;
                  ((<undefinedtype>)var8).label = 2;
                  if (var770.lock((Object)null, (Continuation)var8) == var11) {
                     return var11;
                  }

                  var1 = var4;
                  var774 = 0;
               }

               var5 = var770;
               var9 = var6;
               var779 = var770;

               try {
                  if (!this.isAblJwtExpired$auth_otherRelease()) {
                     break label6693;
                  }
               } catch (Throwable var767) {
                  var10000 = var767;
                  boolean var791 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var780 = new Function2() {
                     public final Object invoke(AblUserApi.GigyaJwtTokenExchange var1, Continuation var2) {
                        return ((AblUserApi)this.receiver).doTokenExchange(var1, var2);
                     }
                  };
               } catch (Throwable var765) {
                  var10000 = var765;
                  boolean var792 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var780.<init>(this.userApi);
               } catch (Throwable var764) {
                  var10000 = var764;
                  boolean var793 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var788 = var780;
               } catch (Throwable var763) {
                  var10000 = var763;
                  boolean var794 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var781 = new AblUserApi.GigyaJwtTokenExchange;
               } catch (Throwable var762) {
                  var10000 = var762;
                  boolean var795 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var781.<init>(this.getGigyaJwt(), "gigya");
               } catch (Throwable var761) {
                  var10000 = var761;
                  boolean var796 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).L$0 = var6;
               } catch (Throwable var760) {
                  var10000 = var760;
                  boolean var797 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).L$1 = var770;
               } catch (Throwable var759) {
                  var10000 = var759;
                  boolean var798 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).Z$0 = var1;
               } catch (Throwable var758) {
                  var10000 = var758;
                  boolean var799 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).I$0 = var774;
               } catch (Throwable var757) {
                  var10000 = var757;
                  boolean var800 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).I$1 = 0;
               } catch (Throwable var756) {
                  var10000 = var756;
                  boolean var801 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  ((<undefinedtype>)var8).label = 3;
               } catch (Throwable var755) {
                  var10000 = var755;
                  boolean var802 = false;
                  break label6692;
               }

               var5 = var770;

               try {
                  var7 = AuthServiceKt.doSuspendedApiCall(var788, var781, (Continuation)var8);
               } catch (Throwable var754) {
                  var10000 = var754;
                  boolean var803 = false;
                  break label6692;
               }

               if (var7 == var11) {
                  return var11;
               }
            }

            var5 = var770;

            ApiResult var790;
            try {
               var790 = (ApiResult)var7;
            } catch (Throwable var753) {
               var10000 = var753;
               boolean var804 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var789 = Timber.Forest;
            } catch (Throwable var752) {
               var10000 = var752;
               boolean var805 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var787 = new StringBuilder;
            } catch (Throwable var751) {
               var10000 = var751;
               boolean var806 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var787.<init>("ABL TOKEN ");
            } catch (Throwable var750) {
               var10000 = var750;
               boolean var807 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var782 = (AblUserApi.GigyaJwtTokenExchange)var790.getOrNull();
            } catch (Throwable var749) {
               var10000 = var749;
               boolean var808 = false;
               break label6692;
            }

            String var783;
            if (var782 != null) {
               var5 = var770;

               try {
                  var783 = var782.getToken();
               } catch (Throwable var748) {
                  var10000 = var748;
                  boolean var809 = false;
                  break label6692;
               }
            } else {
               var783 = null;
            }

            var5 = var770;

            try {
               var787.append(var783);
            } catch (Throwable var747) {
               var10000 = var747;
               boolean var810 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var789.d(var787.toString(), new Object[0]);
            } catch (Throwable var746) {
               var10000 = var746;
               boolean var811 = false;
               break label6692;
            }

            var5 = var770;

            try {
               var784 = (AblUserApi.GigyaJwtTokenExchange)var790.getOrNull();
            } catch (Throwable var745) {
               var10000 = var745;
               boolean var812 = false;
               break label6692;
            }

            String var778;
            if (var784 != null) {
               var5 = var770;

               try {
                  var783 = var784.getToken();
               } catch (Throwable var744) {
                  var10000 = var744;
                  boolean var813 = false;
                  break label6692;
               }

               var778 = var783;
            } else {
               var778 = null;
            }

            if (var778 == null) {
               var783 = var10;
            } else {
               var783 = var778;
            }

            var5 = var770;

            try {
               this.setAblJwt(var783);
            } catch (Throwable var743) {
               var10000 = var743;
               boolean var814 = false;
               break label6692;
            }

            var779 = var770;
            var9 = var6;
         }

         var5 = var779;

         try {
            var9.element = this.getAblJwt();
         } catch (Throwable var742) {
            var10000 = var742;
            boolean var815 = false;
            break label6692;
         }

         var5 = var779;

         try {
            Unit var773 = Unit.INSTANCE;
         } catch (Throwable var741) {
            var10000 = var741;
            boolean var816 = false;
            break label6692;
         }

         var779.unlock((Object)null);
         Timber.Forest.d("getAblJwt done", new Object[0]);
         return var9.element;
      }

      Throwable var772 = var10000;
      var5.unlock((Object)null);
      throw var772;
   }

   // $FF: synthetic method
   static Object getAblJwt$default(AuthService var0, boolean var1, Continuation var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = true;
      }

      return var0.getAblJwt(var1, var2);
   }

   private final PublishSubject getAblJwtPublisher() {
      return this.ablJwtPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final Retrofit getAblRestAdapter() {
      Retrofit var1 = (new Retrofit.Builder()).baseUrl(this.getAblHomeHost()).addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).client(this.getUserOkhttpClient()).build();
      Intrinsics.checkNotNullExpressionValue(var1, "build(...)");
      return var1;
   }

   private final String getBlueClientID() {
      return this.gigyaService.getBlueCloudDomain().getClientId();
   }

   private final String getBlueClientSecret() {
      return this.gigyaService.getBlueCloudDomain().getClientSecret();
   }

   private final BlueLoginDetails getBlueLoginDetails() {
      return (BlueLoginDetails)this.blueLoginDetails$delegate.getValue(this, $$delegatedProperties[5]);
   }

   private final CloudAuthApi getCloudAuthApi() {
      Object var1 = this.getCloudRestAdapter().create(CloudAuthApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (CloudAuthApi)var1;
   }

   private final String getCloudJwtInternal() {
      return this.getBlueLoginDetails().getAccess_token();
   }

   private final Retrofit getCloudRestAdapter() {
      HttpLoggingInterceptor var2 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var1;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var1 = Level.NONE;
      } else {
         var1 = Level.BODY;
      }

      var2.setLevel(var1);
      AuthService$$ExternalSyntheticLambda0 var3 = new AuthService$$ExternalSyntheticLambda0(this);
      OkHttpClient var4 = (new OkHttpClient.Builder()).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).addInterceptor((Interceptor)var2).addInterceptor(var3).build();
      Retrofit var5 = (new Retrofit.Builder()).baseUrl(this.getBlueHomeHost()).addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).client(var4).build();
      Intrinsics.checkNotNullExpressionValue(var5, "build(...)");
      return var5;
   }

   private final String getHttpUserAgent() {
      return (String)this.httpUserAgent$delegate.getValue();
   }

   private final OkHttpClient getUserOkhttpClient() {
      return (OkHttpClient)this.userOkhttpClient$delegate.getValue();
   }

   private static final String httpUserAgent_delegate$lambda$3() {
      StringBuilder var0 = new StringBuilder();
      var0.append(System.getProperty("os.name"));
      var0.append(' ');
      var0.append(System.getProperty("os.arch"));
      var0.append(" - ApiClient Java - ");
      var0.append(System.getProperty("os.version"));
      String var1 = var0.toString();
      return StringUtils.INSTANCE.ensureValidHttpHeader(var1);
   }

   private final boolean isCloudJwtExpired() {
      if (((CharSequence)this.getCloudJwtInternal()).length() == 0) {
         recordCloudJwtExpired$default(this, "empty cloud jwt", (Date)null, (Date)null, 6, (Object)null);
         return true;
      } else if (((CharSequence)this.getTokenForMqtt()).length() == 0) {
         recordCloudJwtExpired$default(this, "empty mqtt jwt", (Date)null, (Date)null, 6, (Object)null);
         return true;
      } else {
         try {
            JWT var3 = new JWT(this.getCloudJwtInternal());
            if (JwtUtilsKt.isExpReached(var3)) {
               this.recordCloudJwtExpired("cloud jwt expired: now > exp", var3.getIssuedAt(), var3.getExpiresAt());
               Timber.Forest var6 = Timber.Forest;
               StringBuilder var2 = new StringBuilder("cloud jwt expired: iat=");
               var2.append(var3.getIssuedAt());
               var2.append(" | exp=");
               var2.append(var3.getExpiresAt());
               var2.append(" | timezone=");
               var2.append(TimeZone.getDefault().getID());
               var2.append(" | time=");
               Date var7 = new Date();
               var2.append(var7);
               var6.d(var2.toString(), new Object[0]);
               return true;
            } else {
               return false;
            }
         } catch (Throwable var5) {
            StringBuilder var1 = new StringBuilder("invalid cloud jwt: ");
            var1.append(var5.getLocalizedMessage());
            recordCloudJwtExpired$default(this, var1.toString(), (Date)null, (Date)null, 6, (Object)null);
            return true;
         }
      }
   }

   private final long millisUntilAblTokenExpires() {
      if (this.isAblJwtExpired$auth_otherRelease()) {
         return 0L;
      } else {
         long var1 = System.currentTimeMillis();
         return Companion.getAblExpireTimeMillis$auth_otherRelease(this.getAblJwt()) - var1;
      }
   }

   private final void recordCloudJwtExpired(String var1, Date var2, Date var3) {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("recordCloudJwtExpired(");
      var5.append(var1);
      var5.append(", ");
      var5.append(var2);
      var5.append(", ");
      var5.append(var3);
      var5.append(')');
      var6.d(var5.toString(), new Object[0]);
      int var4 = this.cloudJwtExpiredCount + 1;
      this.cloudJwtExpiredCount = var4;
      if (var4 > 1) {
         if (this.cloudJwtExpiredJob == null) {
            this.analyticsService.event(new AnalyticEvent.CloudJwtExpiredEvent(this.cloudJwtExpiredCount, var1, var2, var3));
         }

         Job var7 = this.cloudJwtExpiredJob;
         if (var7 != null) {
            DefaultImpls.cancel$default(var7, (CancellationException)null, 1, (Object)null);
         }

         this.cloudJwtExpiredJob = null;
         this.cloudJwtExpiredJob = BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final AuthService this$0;

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
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(30000L, var4) == var3) {
                     return var3;
                  }
               }

               this.this$0.cloudJwtExpiredCount = 0;
               this.this$0.cloudJwtExpiredJob = null;
               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   // $FF: synthetic method
   static void recordCloudJwtExpired$default(AuthService var0, String var1, Date var2, Date var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      var0.recordCloudJwtExpired(var1, var2, var3);
   }

   private final void resetAblToken() {
      this.setAblJwt("");
   }

   private final void setAblJwt(String var1) {
      if (((CharSequence)var1).length() == 0) {
         this.securePrefs.remove("abl_jwt_token");
         this.getAblJwtPublisher().onNext(var1);
         this.ablJwt = var1;
      } else {
         if (!Intrinsics.areEqual(var1, this.ablJwt)) {
            Prefs var2 = this.securePrefs;
            PreferencesHelper.INSTANCE.set(var2.getBackend(), "abl_jwt_token", var1, Reflection.getOrCreateKotlinClass(String.class));
            this.getAblJwtPublisher().onNext(var1);
            this.ablJwt = var1;
         }

      }
   }

   private final void setAppIdForMqtt(String var1) {
      if (!Intrinsics.areEqual(var1, this.appIdForMqtt)) {
         Prefs var2 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var2.getBackend(), "app_id_mqtt", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

      this.appIdForMqtt = var1;
   }

   private final void setBlueLoginDetails(BlueLoginDetails var1) {
      this.blueLoginDetails$delegate.setValue(this, $$delegatedProperties[5], var1);
   }

   private final void setPushToken(String var1) {
      this.pushToken$delegate.setValue(this, $$delegatedProperties[4], var1);
   }

   // $FF: synthetic method
   public static Object setPushToken$default(AuthService var0, String var1, Continuation var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.getPushToken();
      }

      return var0.setPushToken(var1, var2);
   }

   private final void setUserIdForBlueCloud(String var1) {
      if (((CharSequence)var1).length() == 0) {
         this.securePrefs.remove("user_id_blue_cloud");
      } else if (!Intrinsics.areEqual(var1, this.userIdForBlueCloud)) {
         Prefs var2 = this.securePrefs;
         PreferencesHelper.INSTANCE.set(var2.getBackend(), "user_id_blue_cloud", var1, Reflection.getOrCreateKotlinClass(String.class));
      }

      this.userIdForBlueCloud = var1;
   }

   private final void startAblTokenRefreshingJob() {
      this.stopAblTokenRefreshingJob();
      if ((Boolean)this.isUserLoggedIn.getValue()) {
         this.ablTokenRefreshingJob = BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            long J$0;
            long J$1;
            int label;
            final AuthService this$0;

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
               label40: {
                  Object var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  long var3;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2 && var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                        break label40;
                     }

                     var3 = this.J$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var3 = this.this$0.millisUntilAblTokenExpires();
                     if (var3 > 0L) {
                        Continuation var13 = (Continuation)this;
                        this.J$0 = var3;
                        this.label = 3;
                        if (DelayKt.delay(var3, var13) == var9) {
                           return var9;
                        }
                        break label40;
                     }

                     AuthService var10 = this.this$0;
                     Continuation var11 = (Continuation)this;
                     this.J$0 = var3;
                     this.label = 1;
                     if (AuthService.getAblJwt$default(var10, false, var11, 1, (Object)null) == var9) {
                        return var9;
                     }
                  }

                  long var7 = this.this$0.millisUntilAblTokenExpires();
                  long var5 = var7;
                  if (var7 <= 0L) {
                     Timber.Forest.w("stopAblTokenRefreshingJob: refresh failed!", new Object[0]);
                     var5 = 300000L;
                  }

                  Continuation var12 = (Continuation)this;
                  this.J$0 = var3;
                  this.J$1 = var5;
                  this.label = 2;
                  if (DelayKt.delay(var5, var12) == var9) {
                     return var9;
                  }
               }

               this.this$0.startAblTokenRefreshingJob();
               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   private final void stopAblTokenRefreshingJob() {
      Job var1 = this.ablTokenRefreshingJob;
      if (var1 != null) {
         DefaultImpls.cancel$default(var1, (CancellationException)null, 1, (Object)null);
      }

      this.ablTokenRefreshingJob = null;
   }

   private static final OkHttpClient userOkhttpClient_delegate$lambda$5(AuthService var0) {
      HttpLoggingInterceptor var2 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var1;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var1 = Level.NONE;
      } else {
         var1 = Level.BODY;
      }

      var2.setLevel(var1);
      AuthService$$ExternalSyntheticLambda3 var5 = new AuthService$$ExternalSyntheticLambda3(var0);
      OkHttpClient.Builder var3 = (new OkHttpClient.Builder()).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS);
      Object var4 = var0.mockInterceptor;
      if (var4 == null) {
         var4 = var5;
      }

      return var3.addInterceptor((Interceptor)var4).addInterceptor((Interceptor)var2).build();
   }

   private static final Response userOkhttpClient_delegate$lambda$5$lambda$4(AuthService var0, Interceptor.Chain var1) {
      Intrinsics.checkNotNullParameter(var1, "chain");
      Request.Builder var3 = var1.request().newBuilder().addHeader("Accept-Charset", "UTF-8").addHeader("User-Agent", var0.getHttpUserAgent()).addHeader("X-API-KEY-TOKEN", AblEnvironment.INSTANCE.getApiKey());
      StringBuilder var2 = new StringBuilder("Bearer ");
      var2.append(var0.getGigyaJwt());
      return var1.proceed(var3.addHeader("Authorization", var2.toString()).build());
   }

   public final Object authenticateAblUser(String var1, String var2, Continuation var3) {
      String var7;
      Object var12;
      label271: {
         var7 = var2;
         if (var3 instanceof <undefinedtype>) {
            var12 = (<undefinedtype>)var3;
            if ((((<undefinedtype>)var12).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var12).label += Integer.MIN_VALUE;
               break label271;
            }
         }

         var12 = new ContinuationImpl(this, var3) {
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.authenticateAblUser((String)null, (String)null, (Continuation)this);
            }
         };
      }

      String var8;
      String var9;
      String var10;
      Object var16;
      long var64;
      label304: {
         label259: {
            ApiResult var129;
            label305: {
               label306: {
                  Object var131;
                  label276: {
                     label307: {
                        label308: {
                           label309: {
                              label279: {
                                 label310: {
                                    label311: {
                                       label312: {
                                          label313: {
                                             label282: {
                                                label314: {
                                                   label235: {
                                                      label283: {
                                                         var39 = ((<undefinedtype>)var12).result;
                                                         var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                         switch (((<undefinedtype>)var12).label) {
                                                            case 0:
                                                               ResultKt.throwOnFailure(var39);
                                                               Timber.Forest var45 = Timber.Forest;
                                                               StringBuilder var59 = new StringBuilder("authenticateAblUser: ");
                                                               var59.append(var1);
                                                               var59.append(", ");
                                                               var59.append(var7);
                                                               var45.d(var59.toString(), new Object[0]);
                                                               MutableStateFlow var46 = this._isUserLoggedIn;
                                                               boolean var6;
                                                               if (((CharSequence)this.getGigyaJwt()).length() > 0) {
                                                                  var6 = true;
                                                               } else {
                                                                  var6 = false;
                                                               }

                                                               var46.setValue(Boxing.boxBoolean(var6));
                                                               this.setUsername(var1);
                                                               this.updateHomeHost();
                                                               ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                                               ((<undefinedtype>)var12).L$1 = var7;
                                                               ((<undefinedtype>)var12).label = 1;
                                                               var39 = this.getAblJwt(false, (Continuation)var12);
                                                               if (var39 == var16) {
                                                                  return var16;
                                                               }

                                                               var58 = var7;
                                                               break;
                                                            case 1:
                                                               var58 = (String)((<undefinedtype>)var12).L$1;
                                                               var1 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               break;
                                                            case 2:
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               var58 = (String)((<undefinedtype>)var12).L$1;
                                                               var7 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var9 = var1;
                                                               var1 = var7;
                                                               break label283;
                                                            case 3:
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               var58 = (String)((<undefinedtype>)var12).L$1;
                                                               var8 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               break label235;
                                                            case 4:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               var7 = (String)((<undefinedtype>)var12).L$1;
                                                               var57 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var2 = var7;
                                                               break label282;
                                                            case 5:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               var8 = (String)((<undefinedtype>)var12).L$1;
                                                               var57 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var68 = var39;
                                                               var2 = var8;
                                                               break label313;
                                                            case 6:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var95 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               String var56 = (String)((<undefinedtype>)var12).L$1;
                                                               var7 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var2 = var56;
                                                               break label312;
                                                            case 7:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               ApiResult var30 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var1 = (String)((<undefinedtype>)var12).L$2;
                                                               var55 = (String)((<undefinedtype>)var12).L$1;
                                                               var7 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var81 = var39;
                                                               break label311;
                                                            case 8:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var80 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var54 = (String)((<undefinedtype>)var12).L$2;
                                                               var9 = (String)((<undefinedtype>)var12).L$1;
                                                               var1 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var113 = var39;
                                                               var2 = var9;
                                                               break label279;
                                                            case 9:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var112 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var80 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var54 = (String)((<undefinedtype>)var12).L$2;
                                                               var9 = (String)((<undefinedtype>)var12).L$1;
                                                               var1 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var2 = var9;
                                                               break label309;
                                                            case 10:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               ApiResult var27 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var28 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               ApiResult var111 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var7 = (String)((<undefinedtype>)var12).L$2;
                                                               var8 = (String)((<undefinedtype>)var12).L$1;
                                                               var53 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var92 = var39;
                                                               var42 = var111;
                                                               break label308;
                                                            case 11:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var118 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$7;
                                                               var78 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$6;
                                                               var26 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var110 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var9 = (String)((<undefinedtype>)var12).L$2;
                                                               var52 = (String)((<undefinedtype>)var12).L$1;
                                                               String var14 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var131 = var39;
                                                               var2 = var14;
                                                               break label276;
                                                            case 12:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var118 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$7;
                                                               var109 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$6;
                                                               var26 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var51 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var9 = (String)((<undefinedtype>)var12).L$2;
                                                               var8 = (String)((<undefinedtype>)var12).L$1;
                                                               String var13 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var2 = var13;
                                                               break label306;
                                                            case 13:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               AblUserApi.UserAttribute var25 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$7;
                                                               var24 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$6;
                                                               var129 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var51 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var8 = (String)((<undefinedtype>)var12).L$2;
                                                               var9 = (String)((<undefinedtype>)var12).L$1;
                                                               var10 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var40 = var129;
                                                               break label259;
                                                            case 14:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               var24 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$6;
                                                               var129 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               var51 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               var65 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               var8 = (String)((<undefinedtype>)var12).L$2;
                                                               var9 = (String)((<undefinedtype>)var12).L$1;
                                                               var10 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               var40 = var129;
                                                               break label304;
                                                            case 15:
                                                               var64 = ((<undefinedtype>)var12).J$0;
                                                               AblUserApi.UserAttribute var17 = (AblUserApi.UserAttribute)((<undefinedtype>)var12).L$6;
                                                               ApiResult var18 = (ApiResult)((<undefinedtype>)var12).L$5;
                                                               AblUserApi.AblUser var19 = (AblUserApi.AblUser)((<undefinedtype>)var12).L$4;
                                                               ApiResult var20 = (ApiResult)((<undefinedtype>)var12).L$3;
                                                               String var21 = (String)((<undefinedtype>)var12).L$2;
                                                               var21 = (String)((<undefinedtype>)var12).L$1;
                                                               var21 = (String)((<undefinedtype>)var12).L$0;
                                                               ResultKt.throwOnFailure(var39);
                                                               return new Success(Boxing.boxBoolean(true));
                                                            default:
                                                               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                         }

                                                         var9 = (String)var39;
                                                         var7 = var58;
                                                         var2 = var9;
                                                         var8 = var1;
                                                         if (((CharSequence)var9).length() != 0) {
                                                            break label314;
                                                         }

                                                         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                                         ((<undefinedtype>)var12).L$1 = var58;
                                                         ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var9);
                                                         ((<undefinedtype>)var12).label = 2;
                                                         if (DelayKt.delay(1000L, (Continuation)var12) == var16) {
                                                            return var16;
                                                         }
                                                      }

                                                      ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                                      ((<undefinedtype>)var12).L$1 = var58;
                                                      ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var9);
                                                      ((<undefinedtype>)var12).label = 3;
                                                      Object var72 = this.getAblJwt(false, (Continuation)var12);
                                                      var39 = var72;
                                                      var8 = var1;
                                                      if (var72 == var16) {
                                                         return var16;
                                                      }
                                                   }

                                                   var1 = (String)var39;
                                                   var7 = var58;
                                                   var2 = var1;
                                                   if (((CharSequence)var1).length() == 0) {
                                                      return new Failure((Throwable)(new Exception("getAirBoxJwtFromGigyaJwt returned empty string")));
                                                   }
                                                }

                                                Date var35 = (new JWT(var2)).getExpiresAt();
                                                if (var35 != null) {
                                                   var64 = var35.getTime();
                                                } else {
                                                   var64 = 0L - System.currentTimeMillis();
                                                }

                                                Timber.Forest var36 = Timber.Forest;
                                                StringBuilder var60 = new StringBuilder("ablJwt acquired. Expires in ");
                                                var60.append(var64 / (long)1000);
                                                var60.append(" seconds");
                                                var36.i(var60.toString(), new Object[0]);
                                                ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var8);
                                                ((<undefinedtype>)var12).L$1 = var7;
                                                ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var2);
                                                ((<undefinedtype>)var12).J$0 = var64;
                                                ((<undefinedtype>)var12).label = 4;
                                                if (DelayKt.delay(1500L, (Continuation)var12) == var16) {
                                                   return var16;
                                                }

                                                var57 = var8;
                                                var1 = var2;
                                                var2 = var7;
                                             }

                                             Function2 var73 = new Function2(this.userApi) {
                                                public final Object invoke(String var1, Continuation var2) {
                                                   return ((AblUserApi)this.receiver).getUser(var1, var2);
                                                }
                                             };
                                             var8 = this.getUsername();
                                             ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var57);
                                             ((<undefinedtype>)var12).L$1 = var2;
                                             ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                                             ((<undefinedtype>)var12).J$0 = var64;
                                             ((<undefinedtype>)var12).label = 5;
                                             Object var85 = AuthServiceKt.doSuspendedApiCall(var73, var8, (Continuation)var12);
                                             var68 = var85;
                                             if (var85 == var16) {
                                                return var16;
                                             }
                                          }

                                          var95 = (ApiResult)var68;
                                          if (var95.isSuccess()) {
                                             Timber.Forest var76 = Timber.Forest;
                                             StringBuilder var89 = new StringBuilder("authenticateAblUser: user response body = ");
                                             var89.append(var95.getOrNull());
                                             var76.d(var89.toString(), new Object[0]);
                                             var75 = (AblUserApi.AblUser)var95.getOrNull();
                                             var8 = var57;
                                             var55 = var2;
                                             var48 = var95;
                                             break label310;
                                          }

                                          Timber.Forest var74 = Timber.Forest;
                                          StringBuilder var86 = new StringBuilder("authenticateAblUser: user failed with exception = ");
                                          var86.append(var95.exceptionOrNull());
                                          var74.d(var86.toString(), new Object[0]);
                                          ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var57);
                                          ((<undefinedtype>)var12).L$1 = var2;
                                          ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                                          ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var95);
                                          ((<undefinedtype>)var12).J$0 = var64;
                                          ((<undefinedtype>)var12).label = 6;
                                          var7 = var57;
                                          if (DelayKt.delay(1000L, (Continuation)var12) == var16) {
                                             return var16;
                                          }
                                       }

                                       Function2 var87 = new Function2(this.userApi) {
                                          public final Object invoke(String var1, Continuation var2) {
                                             return ((AblUserApi)this.receiver).getUser(var1, var2);
                                          }
                                       };
                                       String var61 = this.getUsername();
                                       ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var7);
                                       ((<undefinedtype>)var12).L$1 = var2;
                                       ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                                       ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var95);
                                       ((<undefinedtype>)var12).J$0 = var64;
                                       ((<undefinedtype>)var12).label = 7;
                                       Object var97 = AuthServiceKt.doSuspendedApiCall(var87, var61, (Continuation)var12);
                                       var81 = var97;
                                       var55 = var2;
                                       if (var97 == var16) {
                                          return var16;
                                       }
                                    }

                                    var48 = (ApiResult)var81;
                                    if (!var48.isSuccess()) {
                                       return new Failure((Throwable)(new Exception(String.valueOf(var48.exceptionOrNull()))));
                                    }

                                    AblUserApi.AblUser var98 = (AblUserApi.AblUser)var48.getOrNull();
                                    var8 = var7;
                                    var75 = var98;
                                 }

                                 var9 = var8;
                                 String var119 = var55;
                                 if (var75 != null) {
                                    this.setAblUser(var75);
                                 }

                                 Function2 var90 = new Function2(this.userApi) {
                                    public final Object invoke(String var1, Continuation var2) {
                                       return ((AblUserApi)this.receiver).getAttributes(var1, var2);
                                    }
                                 };
                                 String var62 = this.getUsername();
                                 ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var9);
                                 ((<undefinedtype>)var12).L$1 = var119;
                                 ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                                 ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var48);
                                 ((<undefinedtype>)var12).L$4 = var75;
                                 ((<undefinedtype>)var12).J$0 = var64;
                                 ((<undefinedtype>)var12).label = 8;
                                 var131 = AuthServiceKt.doSuspendedApiCall(var90, var62, (Continuation)var12);
                                 var80 = var75;
                                 var113 = var131;
                                 var65 = var48;
                                 var54 = var1;
                                 var2 = var119;
                                 var1 = var9;
                                 if (var131 == var16) {
                                    return var16;
                                 }
                              }

                              var112 = (ApiResult)var113;
                              if (var112.isSuccess()) {
                                 Timber.Forest var125 = Timber.Forest;
                                 StringBuilder var105 = new StringBuilder("authenticateAblUser: extUid response body = ");
                                 var105.append(var112.getOrNull());
                                 var125.d(var105.toString(), new Object[0]);
                                 List var106 = (List)var112.getOrNull();
                                 if (var106 != null) {
                                    Iterator var126 = ((Iterable)var106).iterator();

                                    do {
                                       if (!var126.hasNext()) {
                                          var107 = null;
                                          break;
                                       }

                                       var107 = var126.next();
                                    } while(!Intrinsics.areEqual(((AblUserApi.UserAttribute)var107).getName(), "ext_uid"));

                                    AblUserApi.UserAttribute var136 = (AblUserApi.UserAttribute)var107;
                                    String var108 = var54;
                                    String var127 = var2;
                                    var2 = var1;
                                    var63 = var136;
                                    var1 = var108;
                                    var9 = var127;
                                 } else {
                                    var9 = var2;
                                    var2 = var1;
                                    Object var128 = null;
                                    var1 = var54;
                                    var63 = (AblUserApi.UserAttribute)var128;
                                 }
                                 break label307;
                              }

                              Timber.Forest var100 = Timber.Forest;
                              StringBuilder var120 = new StringBuilder("authenticateAblUser: extUid failed with exception = ");
                              var120.append(var112.exceptionOrNull());
                              var100.d(var120.toString(), new Object[0]);
                              ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                              ((<undefinedtype>)var12).L$1 = var2;
                              ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var54);
                              ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
                              ((<undefinedtype>)var12).L$4 = var80;
                              ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var112);
                              ((<undefinedtype>)var12).J$0 = var64;
                              ((<undefinedtype>)var12).label = 9;
                              if (DelayKt.delay(1000L, (Continuation)var12) == var16) {
                                 return var16;
                              }
                           }

                           String var121 = var2;
                           String var133 = var1;
                           Function2 var49 = new Function2(this.userApi) {
                              public final Object invoke(String var1, Continuation var2) {
                                 return ((AblUserApi)this.receiver).getAttributes(var1, var2);
                              }
                           };
                           var1 = this.getUsername();
                           ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var133);
                           ((<undefinedtype>)var12).L$1 = var121;
                           ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var54);
                           ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
                           ((<undefinedtype>)var12).L$4 = var80;
                           ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var112);
                           ((<undefinedtype>)var12).J$0 = var64;
                           ((<undefinedtype>)var12).label = 10;
                           Object var114 = AuthServiceKt.doSuspendedApiCall(var49, var1, (Continuation)var12);
                           var28 = var80;
                           var92 = var114;
                           var42 = var65;
                           var7 = var54;
                           var8 = var121;
                           var53 = var133;
                           if (var114 == var16) {
                              return var16;
                           }
                        }

                        var112 = (ApiResult)var92;
                        if (!var112.isSuccess()) {
                           return new Failure((Throwable)(new Exception(String.valueOf(var112.exceptionOrNull()))));
                        }

                        List var101 = (List)var112.getOrNull();
                        if (var101 != null) {
                           Iterator var122 = ((Iterable)var101).iterator();

                           do {
                              if (!var122.hasNext()) {
                                 var102 = null;
                                 break;
                              }

                              var102 = var122.next();
                           } while(!Intrinsics.areEqual(((AblUserApi.UserAttribute)var102).getName(), "ext_uid"));

                           AblUserApi.UserAttribute var143 = (AblUserApi.UserAttribute)var102;
                           ApiResult var103 = var42;
                           String var134 = var7;
                           String var123 = var8;
                           var2 = var53;
                           var63 = var143;
                           var80 = var28;
                           var65 = var103;
                           var1 = var134;
                           var9 = var123;
                        } else {
                           ApiResult var104 = var42;
                           String var124 = var7;
                           String var135 = var8;
                           var2 = var53;
                           var63 = null;
                           var80 = var28;
                           var65 = var104;
                           var1 = var124;
                           var9 = var135;
                        }
                     }

                     var129 = var112;
                     if (var63 == null) {
                        Integer var115;
                        if (var80 != null) {
                           var115 = Boxing.boxInt(var80.getId());
                        } else {
                           var115 = null;
                        }

                        if (var115 != null && !StringsKt.isBlank((CharSequence)var9)) {
                           AblUserApi.UserAttribute var144 = new AblUserApi.UserAttribute(var9, "", "ext_uid", "user", var80.getId(), "");
                           Function3 var116 = new Function3(this.userApi) {
                              public final Object invoke(String var1, AblUserApi.UserAttribute var2, Continuation var3) {
                                 return ((AblUserApi)this.receiver).setExternalUidAttr(var1, var2, var3);
                              }
                           };
                           String var137 = this.getUsername();
                           ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var2);
                           ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var9);
                           ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                           ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
                           ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var80);
                           ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var129);
                           ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var63);
                           ((<undefinedtype>)var12).L$7 = var144;
                           ((<undefinedtype>)var12).J$0 = var64;
                           ((<undefinedtype>)var12).label = 11;
                           Object var15 = AuthServiceKt.doSuspendedApiCall(var116, var137, var144, (Continuation)var12);
                           if (var15 == var16) {
                              return var16;
                           }

                           var137 = var9;
                           var9 = var1;
                           var110 = var80;
                           var26 = var129;
                           var78 = var63;
                           var52 = var137;
                           var131 = var15;
                           var118 = var144;
                           break label276;
                        }
                     }

                     var10 = var2;
                     var50 = var63;
                     var51 = var80;
                     var8 = var1;
                     break label305;
                  }

                  if (!((ApiResult)var131).isFailure()) {
                     AblUserApi.UserAttribute var142 = var78;
                     AblUserApi.AblUser var147 = var110;
                     var8 = var9;
                     var10 = var2;
                     var9 = var52;
                     var129 = var26;
                     var51 = var147;
                     var50 = var142;
                     break label305;
                  }

                  ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var2);
                  ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var52);
                  ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var9);
                  ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
                  ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var110);
                  ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var26);
                  ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var78);
                  ((<undefinedtype>)var12).L$7 = var118;
                  ((<undefinedtype>)var12).J$0 = var64;
                  ((<undefinedtype>)var12).label = 12;
                  if (DelayKt.delay(1000L, (Continuation)var12) == var16) {
                     return var16;
                  }

                  AblUserApi.UserAttribute var139 = var78;
                  var8 = var52;
                  var51 = var110;
                  var109 = var139;
               }

               Function3 var140 = new Function3(this.userApi) {
                  public final Object invoke(String var1, AblUserApi.UserAttribute var2, Continuation var3) {
                     return ((AblUserApi)this.receiver).setExternalUidAttr(var1, var2, var3);
                  }
               };
               String var145 = this.getUsername();
               ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var2);
               ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var8);
               ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var9);
               ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
               ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var51);
               ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var26);
               ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var109);
               ((<undefinedtype>)var12).L$7 = SpillingKt.nullOutSpilledVariable(var118);
               ((<undefinedtype>)var12).J$0 = var64;
               ((<undefinedtype>)var12).label = 13;
               if (AuthServiceKt.doSuspendedApiCall(var140, var145, var118, (Continuation)var12) == var16) {
                  return var16;
               }

               AblUserApi.UserAttribute var146 = var109;
               ApiResult var141 = var26;
               String var130 = var9;
               var9 = var8;
               var10 = var2;
               var24 = var146;
               var40 = var141;
               var8 = var130;
               break label259;
            }

            var24 = var50;
            var40 = var129;
         }

         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
         ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var51);
         ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var40);
         ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var24);
         ((<undefinedtype>)var12).L$7 = null;
         ((<undefinedtype>)var12).J$0 = var64;
         ((<undefinedtype>)var12).label = 14;
         if (this.updateLanguage((Continuation)var12) == var16) {
            return var16;
         }
      }

      ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var10);
      ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var9);
      ((<undefinedtype>)var12).L$2 = SpillingKt.nullOutSpilledVariable(var8);
      ((<undefinedtype>)var12).L$3 = SpillingKt.nullOutSpilledVariable(var65);
      ((<undefinedtype>)var12).L$4 = SpillingKt.nullOutSpilledVariable(var51);
      ((<undefinedtype>)var12).L$5 = SpillingKt.nullOutSpilledVariable(var40);
      ((<undefinedtype>)var12).L$6 = SpillingKt.nullOutSpilledVariable(var24);
      ((<undefinedtype>)var12).J$0 = var64;
      ((<undefinedtype>)var12).label = 15;
      if (setPushToken$default(this, (String)null, (Continuation)var12, 1, (Object)null) == var16) {
         return var16;
      } else {
         return new Success(Boxing.boxBoolean(true));
      }
   }

   public final void clear() {
      this.stopAblTokenRefreshingJob();
      JobKt.cancelChildren$default(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
   }

   public final void clearUserData() {
      this.resetAblToken();
      this.resetCloudJwt();
      this.setAblUser(new AblUserApi.AblUser(0, (String)null, (Boolean)null, (String)null, (String)null, (String)null, (Integer)null, (String)null, (String)null, (String)null, (String)null, (Integer)null, 4095, (DefaultConstructorMarker)null));
      this.analyticsService.setUserId((String)null, (String)null, (String)null);
      Prefs var1 = this.unsecurePrefs;
      PreferencesHelper.INSTANCE.set(var1.getBackend(), "KEY_USER_INFO_COLLECTIONS_SYNC_TIME", 0L, Reflection.getOrCreateKotlinClass(Long.class));
      UserInfoCollectionsManager.INSTANCE.clearData();
   }

   public final Object deleteAccount(Continuation var1) {
      Object var2 = this.getBearerToken(new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final AuthService this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(String var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            String var4 = (String)this.L$0;
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 == 1) {
                  ResultKt.throwOnFailure(var1);
                  return var1;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            } else {
               ResultKt.throwOnFailure(var1);
               Deferred var6 = this.this$0.getCloudAuthApi().deleteUserAccount(var4);
               Continuation var5 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
               this.label = 1;
               Object var7 = AuthServiceKt.awaitCall(var6, var5);
               return var7 == var3 ? var3 : var7;
            }
         }
      }, var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final Object disableUserAccount(Continuation var1) {
      Object var2 = this.getBearerToken(new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final AuthService this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(String var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            String var4 = (String)this.L$0;
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 == 1) {
                  ResultKt.throwOnFailure(var1);
                  return var1;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            } else {
               ResultKt.throwOnFailure(var1);
               Deferred var6 = this.this$0.getCloudAuthApi().disableUserAccount(var4);
               Continuation var5 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
               this.label = 1;
               Object var7 = AuthServiceKt.awaitCall(var6, var5);
               return var7 == var3 ? var3 : var7;
            }
         }
      }, var1);
      return var2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var2 : Unit.INSTANCE;
   }

   public final Object doGigyaDataCentersHaveEmailAddress(String var1, Continuation var2) {
      return this.gigyaService.doGigyaDataCentersHaveEmailAddress(var1, var2);
   }

   public final Object fetchAblGranularRegion(Continuation var1) {
      label31: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label31;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchAblGranularRegion((Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var9);
         var6 = var9;
      } else {
         ResultKt.throwOnFailure(var9);
         Function1 var10 = new Function1(this.userApi) {
            public final Object invoke(Continuation var1) {
               return ((AblUserApi)this.receiver).getSpecificRegionSync(var1);
            }
         };
         ((<undefinedtype>)var5).label = 1;
         Object var11 = AuthServiceKt.doSuspendedApiCall(var10, (Continuation)var5);
         var6 = var11;
         if (var11 == var4) {
            return var4;
         }
      }

      ApiResult var7 = (ApiResult)var6;
      Timber.Forest var12 = Timber.Forest;
      StringBuilder var15 = new StringBuilder("fetchGranularRegionSync: response = ");
      var15.append(var7);
      var12.d(var15.toString(), new Object[0]);
      if (var7.isSuccess()) {
         Timber.Forest var17 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("fetchGranularRegionSync: response.body = ");
         var14.append(var7.getOrNull());
         var17.d(var14.toString(), new Object[0]);
         AblUserApi.BlueairGranularRegion var8 = (AblUserApi.BlueairGranularRegion)var7.getOrNull();
         return var8 != null ? var8.getCountryCode() : null;
      } else {
         var12 = Timber.Forest;
         var15 = new StringBuilder("fetchGranularRegionSync: failed with exception: ");
         var15.append(var7.exceptionOrNull());
         var12.w(var15.toString(), new Object[0]);
         return null;
      }
   }

   public final String getAblHomeHost() {
      return (String)this.ablHomeHost$delegate.getValue(this, $$delegatedProperties[3]);
   }

   public final String getAblJwt() {
      if (((CharSequence)this.ablJwt).length() == 0) {
         Prefs var1 = this.securePrefs;
         String var2 = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "abl_jwt_token", "", Reflection.getOrCreateKotlinClass(String.class));
         if (((CharSequence)var2).length() > 0) {
            this.ablJwt = var2;
         }

         return this.ablJwt;
      } else {
         return this.ablJwt;
      }
   }

   public final Observable getAblJwtObserver() {
      Observable var1 = this.getAblJwtPublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final AblUserApi.AblUser getAblUser() {
      return (AblUserApi.AblUser)this.ablUser$delegate.getValue(this, $$delegatedProperties[1]);
   }

   public final String getAppIdForMqtt() {
      if (((CharSequence)this.appIdForMqtt).length() == 0) {
         String var1 = UUID.randomUUID().toString();
         Intrinsics.checkNotNullExpressionValue(var1, "toString(...)");
         this.setAppIdForMqtt(var1);
      }

      return this.appIdForMqtt;
   }

   public final String getAuthNameForMqtt() {
      return this.getBlueLoginDetails().getCustom_auth_name();
   }

   public final Object getBearerToken(Function2 var1, Continuation var2) {
      label41: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var12 = var4;
               break label41;
            }
         }

         var12 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getBearerToken((Function2)null, (Continuation)this);
            }
         };
      }

      Object var5 = ((<undefinedtype>)var12).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var12).label;
      Object var7;
      Function2 var14;
      if (var3 != 0) {
         if (var3 != 1) {
            if (var3 == 2) {
               var3 = ((<undefinedtype>)var12).I$0;
               String var8 = (String)((<undefinedtype>)var12).L$1;
               Function2 var9 = (Function2)((<undefinedtype>)var12).L$0;
               ResultKt.throwOnFailure(var5);
               return var5;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var14 = (Function2)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var5);
         var7 = var5;
      } else {
         ResultKt.throwOnFailure(var5);
         ((<undefinedtype>)var12).L$0 = var1;
         ((<undefinedtype>)var12).label = 1;
         var5 = this.getCloudJwt((Continuation)var12);
         var14 = var1;
         var7 = var5;
         if (var5 == var6) {
            return var6;
         }
      }

      if (((CharSequence)((String)var7)).length() <= 0) {
         var7 = null;
      }

      String var10 = (String)var7;
      if (var10 == null) {
         return null;
      } else {
         StringBuilder var16 = new StringBuilder("Bearer ");
         var16.append(var10);
         String var17 = var16.toString();
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var10);
         ((<undefinedtype>)var12).I$0 = 0;
         ((<undefinedtype>)var12).label = 2;
         Object var11 = var14.invoke(var17, var12);
         if (var11 != var6) {
            return var11;
         } else {
            return var6;
         }
      }
   }

   public final String getBearerToken() {
      String var1 = this.getCloudJwtInternal();
      if (((CharSequence)var1).length() == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder("Bearer ");
         var2.append(var1);
         return var2.toString();
      }
   }

   public final String getBlueBrokerURL() {
      return this.gigyaService.getBlueCloudDomain().getMqttBroker();
   }

   public final BlueCloudDomain getBlueCloudDomain() {
      return this.gigyaService.getBlueCloudDomain();
   }

   public final String getBlueHomeHost() {
      return this.gigyaService.getBlueCloudDomain().getHost();
   }

   public final Object getCloudJwt(Continuation var1) {
      Object var9;
      label22242: {
         if (var1 instanceof <undefinedtype>) {
            var9 = (<undefinedtype>)var1;
            if ((((<undefinedtype>)var9).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var9).label += Integer.MIN_VALUE;
               break label22242;
            }
         }

         var9 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getCloudJwt((Continuation)this);
            }
         };
      }

      Object var5;
      label22235: {
         Throwable var2918;
         label22245: {
            Ref.ObjectRef var2900;
            label22233: {
               label22232: {
                  label22231: {
                     label22246: {
                        int var4;
                        Object var10;
                        Object var12;
                        int var2890;
                        Map var2901;
                        Map var2906;
                        label22247: {
                           int var2888;
                           label22248: {
                              label22249: {
                                 var5 = ((<undefinedtype>)var9).result;
                                 var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 var2888 = ((<undefinedtype>)var9).label;
                                 Ref.ObjectRef var2875;
                                 if (var2888 != 0) {
                                    if (var2888 != 1) {
                                       if (var2888 != 2) {
                                          if (var2888 != 3) {
                                             if (var2888 != 4) {
                                                if (var2888 != 5) {
                                                   throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }

                                                var2888 = ((<undefinedtype>)var9).I$1;
                                                var2888 = ((<undefinedtype>)var9).I$0;
                                                Map var2879 = (Map)((<undefinedtype>)var9).L$3;
                                                var2879 = (Map)((<undefinedtype>)var9).L$2;
                                                Mutex var2898 = (Mutex)((<undefinedtype>)var9).L$1;
                                                Ref.ObjectRef var2902 = (Ref.ObjectRef)((<undefinedtype>)var9).L$0;
                                                var2877 = var2898;

                                                try {
                                                   ResultKt.throwOnFailure(var5);
                                                } catch (Throwable var2849) {
                                                   var2918 = var2849;
                                                   boolean var2919 = false;
                                                   break label22245;
                                                }

                                                var2893 = var2898;
                                                var2881 = var2902;
                                                break label22232;
                                             }

                                             var2890 = ((<undefinedtype>)var9).I$1;
                                             var2888 = ((<undefinedtype>)var9).I$0;
                                             var2901 = (Map)((<undefinedtype>)var9).L$3;
                                             var2906 = (Map)((<undefinedtype>)var9).L$2;
                                             Mutex var2878 = (Mutex)((<undefinedtype>)var9).L$1;
                                             Ref.ObjectRef var11 = (Ref.ObjectRef)((<undefinedtype>)var9).L$0;
                                             var2896 = var2878;

                                             try {
                                                ResultKt.throwOnFailure(var5);
                                             } catch (Throwable var2874) {
                                                var2918 = var2874;
                                                boolean var10001 = false;
                                                break label22246;
                                             }

                                             var10 = var5;
                                             var2893 = var2878;
                                             var4 = var2890;
                                             var2890 = var2888;
                                             var2900 = var11;
                                             break label22247;
                                          }

                                          var2888 = ((<undefinedtype>)var9).I$1;
                                          var2890 = ((<undefinedtype>)var9).I$0;
                                          var2906 = (Map)((<undefinedtype>)var9).L$3;
                                          var2901 = (Map)((<undefinedtype>)var9).L$2;
                                          var2877 = (Mutex)((<undefinedtype>)var9).L$1;
                                          var2900 = (Ref.ObjectRef)((<undefinedtype>)var9).L$0;

                                          try {
                                             ResultKt.throwOnFailure(var5);
                                          } finally {
                                             break label22235;
                                          }

                                          break label22248;
                                       }

                                       var2888 = ((<undefinedtype>)var9).I$0;
                                       var2876 = (Mutex)((<undefinedtype>)var9).L$1;
                                       var2900 = (Ref.ObjectRef)((<undefinedtype>)var9).L$0;
                                       ResultKt.throwOnFailure(var5);
                                       var2892 = var2900;
                                       break label22249;
                                    }

                                    var2875 = (Ref.ObjectRef)((<undefinedtype>)var9).L$0;
                                    ResultKt.throwOnFailure(var5);
                                 } else {
                                    ResultKt.throwOnFailure(var5);
                                    var2875 = new Ref.ObjectRef();
                                    var2875.element = "";
                                    GigyaService var2894 = this.gigyaService;
                                    ((<undefinedtype>)var9).L$0 = var2875;
                                    ((<undefinedtype>)var9).label = 1;
                                    if (var2894.checkGigyaTokenExpiry((Continuation)var9) == var12) {
                                       return var12;
                                    }
                                 }

                                 Mutex var2899 = this.cloudJwtMutex;
                                 ((<undefinedtype>)var9).L$0 = var2875;
                                 ((<undefinedtype>)var9).L$1 = var2899;
                                 ((<undefinedtype>)var9).I$0 = 0;
                                 ((<undefinedtype>)var9).label = 2;
                                 if (var2899.lock((Object)null, (Continuation)var9) == var12) {
                                    return var12;
                                 }

                                 var2888 = 0;
                                 var2892 = var2875;
                                 var2876 = var2899;
                              }

                              var2896 = var2876;

                              try {
                                 if (!this.isCloudJwtExpired()) {
                                    break label22231;
                                 }
                              } catch (Throwable var2873) {
                                 var2918 = var2873;
                                 boolean var2920 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2903 = new LinkedHashMap;
                              } catch (Throwable var2872) {
                                 var2918 = var2872;
                                 boolean var2921 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2903.<init>();
                              } catch (Throwable var2871) {
                                 var2918 = var2871;
                                 boolean var2922 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2901 = (Map)var2903;
                              } catch (Throwable var2870) {
                                 var2918 = var2870;
                                 boolean var2923 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2907 = new StringBuilder;
                              } catch (Throwable var2869) {
                                 var2918 = var2869;
                                 boolean var2924 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2907.<init>("Bearer ");
                              } catch (Throwable var2868) {
                                 var2918 = var2868;
                                 boolean var2925 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2907.append(this.getGigyaJwt());
                              } catch (Throwable var2867) {
                                 var2918 = var2867;
                                 boolean var2926 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2901.put("Authorization", var2907.toString());
                              } catch (Throwable var2866) {
                                 var2918 = var2866;
                                 boolean var2927 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2901.put("idtoken", this.getGigyaJwt());
                              } catch (Throwable var2865) {
                                 var2918 = var2865;
                                 boolean var2928 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2908 = new LinkedHashMap;
                              } catch (Throwable var2864) {
                                 var2918 = var2864;
                                 boolean var2929 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2908.<init>();
                              } catch (Throwable var2863) {
                                 var2918 = var2863;
                                 boolean var2930 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2906 = (Map)var2908;
                              } catch (Throwable var2862) {
                                 var2918 = var2862;
                                 boolean var2931 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2906.put("client_id", this.getBlueClientID());
                              } catch (Throwable var2861) {
                                 var2918 = var2861;
                                 boolean var2932 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2906.put("client_secret", this.getBlueClientSecret());
                              } catch (Throwable var2860) {
                                 var2918 = var2860;
                                 boolean var2933 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2906.put("scope", "todo");
                              } catch (Throwable var2859) {
                                 var2918 = var2859;
                                 boolean var2934 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var2910 = this.getCloudAuthApi().login(var2901, var2906);
                              } catch (Throwable var2858) {
                                 var2918 = var2858;
                                 boolean var2935 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).L$0 = var2892;
                              } catch (Throwable var2857) {
                                 var2918 = var2857;
                                 boolean var2936 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).L$1 = var2876;
                              } catch (Throwable var2856) {
                                 var2918 = var2856;
                                 boolean var2937 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).L$2 = SpillingKt.nullOutSpilledVariable(var2901);
                              } catch (Throwable var2855) {
                                 var2918 = var2855;
                                 boolean var2938 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var2906);
                              } catch (Throwable var2854) {
                                 var2918 = var2854;
                                 boolean var2939 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).I$0 = var2888;
                              } catch (Throwable var2853) {
                                 var2918 = var2853;
                                 boolean var2940 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).I$1 = 0;
                              } catch (Throwable var2852) {
                                 var2918 = var2852;
                                 boolean var2941 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 ((<undefinedtype>)var9).label = 3;
                              } catch (Throwable var2851) {
                                 var2918 = var2851;
                                 boolean var2942 = false;
                                 break label22246;
                              }

                              var2896 = var2876;

                              try {
                                 var10 = AuthServiceKt.awaitCall(var2910, (Continuation)var9);
                              } catch (Throwable var2850) {
                                 var2918 = var2850;
                                 boolean var2943 = false;
                                 break label22246;
                              }

                              if (var10 == var12) {
                                 return var12;
                              }

                              var4 = 0;
                              var2900 = var2892;
                              var2890 = var2888;
                              var2888 = var4;
                              var2893 = var2876;
                           }

                           var2877 = var2876;

                           try {
                              var2912 = (ApiResult)var10;
                           } catch (Throwable var2848) {
                              var2918 = var2848;
                              boolean var2944 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           Function2 var2914;
                           try {
                              var2914 = new Function2() {
                                 Object L$0;
                                 int label;
                                 final AuthService this$0;

                                 {
                                    this.this$0 = var1;
                                 }

                                 public final Continuation create(Object var1, Continuation var2) {
                                    Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                                    var3.L$0 = var1;
                                    return (Continuation)var3;
                                 }

                                 public final Object invoke(BlueLoginDetails var1, Continuation var2) {
                                    return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                                 }

                                 public final Object invokeSuspend(Object var1) {
                                    BlueLoginDetails var2 = (BlueLoginDetails)this.L$0;
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label == 0) {
                                       ResultKt.throwOnFailure(var1);
                                       this.this$0.setBlueLoginDetails(var2);

                                       try {
                                          var1 = BugfenderSdk.INSTANCE;
                                          JWT var8 = new JWT(var2.getAccess_token());
                                          var1.setDeviceString("uid", var8.getClaim("client_id").asString());
                                       } catch (DecodeException var5) {
                                          Timber.Forest var6 = Timber.Forest;
                                          Throwable var4 = (Throwable)var5;
                                          StringBuilder var3 = new StringBuilder("Failed to decode aws access token: ");
                                          var3.append(var2.getAccess_token().length());
                                          var6.e(var4, var3.toString(), new Object[0]);
                                       }

                                       return Unit.INSTANCE;
                                    } else {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                 }
                              };
                           } catch (Throwable var2847) {
                              var2918 = var2847;
                              boolean var2945 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              var2914.<init>(this, (Continuation)null);
                           } catch (Throwable var2846) {
                              var2918 = var2846;
                              boolean var2946 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              var2914 = var2914;
                           } catch (Throwable var2845) {
                              var2918 = var2845;
                              boolean var2947 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).L$0 = var2900;
                           } catch (Throwable var2844) {
                              var2918 = var2844;
                              boolean var2948 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).L$1 = var2893;
                           } catch (Throwable var2843) {
                              var2918 = var2843;
                              boolean var2949 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).L$2 = SpillingKt.nullOutSpilledVariable(var2901);
                           } catch (Throwable var2842) {
                              var2918 = var2842;
                              boolean var2950 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var2906);
                           } catch (Throwable var2841) {
                              var2918 = var2841;
                              boolean var2951 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).I$0 = var2890;
                           } catch (Throwable var2840) {
                              var2918 = var2840;
                              boolean var2952 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).I$1 = var2888;
                           } catch (Throwable var2839) {
                              var2918 = var2839;
                              boolean var2953 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              ((<undefinedtype>)var9).label = 4;
                           } catch (Throwable var2838) {
                              var2918 = var2838;
                              boolean var2954 = false;
                              break label22245;
                           }

                           var2877 = var2893;

                           try {
                              var10 = ApiResultKt.onSuccess(var2912, var2914, (Continuation)var9);
                           } catch (Throwable var2837) {
                              var2918 = var2837;
                              boolean var2955 = false;
                              break label22245;
                           }

                           if (var10 == var12) {
                              return var12;
                           }

                           Map var2882 = var2906;
                           var2906 = var2901;
                           var2901 = var2882;
                           var4 = var4;
                        }

                        var2877 = var2893;

                        try {
                           var2913 = (ApiResult)var10;
                        } catch (Throwable var2836) {
                           var2918 = var2836;
                           boolean var2956 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        Function2 var2916;
                        try {
                           var2916 = new Function2() {
                              Object L$0;
                              int label;
                              final AuthService this$0;

                              {
                                 this.this$0 = var1;
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                                 var3.L$0 = var1;
                                 return (Continuation)var3;
                              }

                              public final Object invoke(Throwable var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 Throwable var2 = (Throwable)this.L$0;
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    Timber.Forest.e(var2, "Failed to login to cloud", new Object[0]);
                                    this.this$0.setBlueLoginDetails(new BlueLoginDetails((String)null, (String)null, 0, (String)null, (String)null, (String)null, (String)null, (String)null, 255, (DefaultConstructorMarker)null));
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                        } catch (Throwable var2835) {
                           var2918 = var2835;
                           boolean var2957 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           var2916.<init>(this, (Continuation)null);
                        } catch (Throwable var2834) {
                           var2918 = var2834;
                           boolean var2958 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           var2916 = var2916;
                        } catch (Throwable var2833) {
                           var2918 = var2833;
                           boolean var2959 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).L$0 = var2900;
                        } catch (Throwable var2832) {
                           var2918 = var2832;
                           boolean var2960 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).L$1 = var2893;
                        } catch (Throwable var2831) {
                           var2918 = var2831;
                           boolean var2961 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).L$2 = SpillingKt.nullOutSpilledVariable(var2906);
                        } catch (Throwable var2830) {
                           var2918 = var2830;
                           boolean var2962 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).L$3 = SpillingKt.nullOutSpilledVariable(var2901);
                        } catch (Throwable var2829) {
                           var2918 = var2829;
                           boolean var2963 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).I$0 = var2890;
                        } catch (Throwable var2828) {
                           var2918 = var2828;
                           boolean var2964 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).I$1 = var4;
                        } catch (Throwable var2827) {
                           var2918 = var2827;
                           boolean var2965 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           ((<undefinedtype>)var9).label = 5;
                        } catch (Throwable var2826) {
                           var2918 = var2826;
                           boolean var2966 = false;
                           break label22245;
                        }

                        var2877 = var2893;

                        try {
                           if (ApiResultKt.onFail(var2913, var2916, (Continuation)var9) == var12) {
                              return var12;
                           }
                        } catch (Throwable var2825) {
                           var2918 = var2825;
                           boolean var2967 = false;
                           break label22245;
                        }

                        var2881 = var2900;
                        break label22232;
                     }

                     var5 = var2918;
                     var2877 = var2896;
                     break label22235;
                  }

                  var2900 = var2892;
                  var2893 = var2876;
                  break label22233;
               }

               var2900 = var2881;
            }

            var2877 = var2893;

            try {
               var2900.element = this.getCloudJwtInternal();
            } catch (Throwable var2824) {
               var2918 = var2824;
               boolean var2968 = false;
               break label22245;
            }

            var2877 = var2893;

            try {
               Unit var2905 = Unit.INSTANCE;
            } catch (Throwable var2822) {
               var2918 = var2822;
               boolean var2969 = false;
               break label22245;
            }

            var2893.unlock((Object)null);
            Timber.Forest.d("getCloudJwt done", new Object[0]);
            return var2900.element;
         }

         var5 = var2918;
      }

      var2877.unlock((Object)null);
      throw var5;
   }

   public final String getCloudUserRegion() {
      return this.gigyaService.getCloudUserRegion();
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final String getGigyaJwt() {
      return this.gigyaService.getGigyaJwt();
   }

   public final Observable getGigyaJwtObserver() {
      return this.gigyaService.getGigyaJwtObserver();
   }

   public final GigyaService getGigyaService() {
      return this.gigyaService;
   }

   public final String getGigyaUid() {
      return this.gigyaService.getGigyaUid();
   }

   public final String getLocallySavedDeviceJwt(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Prefs var2 = this.securePrefs;
      StringBuilder var3 = new StringBuilder("JWT");
      var3.append(var1.getUid());
      String var4 = var3.toString();
      return (String)PreferencesHelper.INSTANCE.get(var2.getBackend(), var4, (Object)null, Reflection.getOrCreateKotlinClass(String.class));
   }

   public final Function1 getPushSettingsFetcher() {
      return this.pushSettingsFetcher;
   }

   public final String getPushToken() {
      return (String)this.pushToken$delegate.getValue(this, $$delegatedProperties[4]);
   }

   public final String getSignatureForMqtt() {
      return this.getBlueLoginDetails().getCustom_auth_signature();
   }

   public final String getTokenForMqtt() {
      return this.getBlueLoginDetails().getCustom_auth_token();
   }

   public final boolean getUseJPush() {
      return Intrinsics.areEqual(this.getBlueCloudDomain().regionCodeShort(), "cn");
   }

   public final int getUserId() {
      return this.getAblUser().getId();
   }

   public final String getUserIdForBlueCloud() {
      if (((CharSequence)this.userIdForBlueCloud).length() == 0) {
         String var1 = this.getBlueLoginDetails().getAccess_token();
         if (((CharSequence)var1).length() > 0) {
            var1 = (new JWT(var1)).getClaim("username").asString();
         } else {
            var1 = null;
         }

         String var2 = var1;
         if (var1 == null) {
            var2 = "";
         }

         this.setUserIdForBlueCloud(var2);
      }

      return this.userIdForBlueCloud;
   }

   public final String getUsername() {
      return (String)this.username$delegate.getValue(this, $$delegatedProperties[2]);
   }

   public final boolean isAblJwtExpired$auth_otherRelease() {
      if (((CharSequence)this.getAblJwt()).length() == 0) {
         return true;
      } else {
         return Companion.getAblExpireTimeMillis$auth_otherRelease(this.getAblJwt()) <= System.currentTimeMillis();
      }
   }

   public final StateFlow isUserLoggedIn() {
      return this.isUserLoggedIn;
   }

   public void logOut() {
      this._isUserLoggedIn.setValue(false);
      String var1 = this.getBearerToken();
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final String $bearerToken;
         int label;
         final AuthService this$0;

         {
            this.this$0 = var1;
            this.$bearerToken = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$bearerToken, var2));
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
               AuthService var4 = this.this$0;
               String var5 = this.$bearerToken;
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var4.removePushToken(var5, var6) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);

      label24:
      try {
         Result.Companion var6 = Result.Companion;
         AuthService var7 = this;
         this.gigyaService.logOut();
         Result.constructor-impl(Unit.INSTANCE);
      } catch (Throwable var4) {
         Result.Companion var5 = Result.Companion;
         Result.constructor-impl(ResultKt.createFailure(var4));
         break label24;
      }

      this.stopAblTokenRefreshingJob();
      this.clearUserData();
   }

   public final Object removePushToken(String var1, Continuation var2) {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               KlaviyoSdk.INSTANCE.removePushToken();
               KlaviyoSdk.INSTANCE.resetProfile();
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, 3, (Object)null);
      return ((CharSequence)var1).length() == 0 ? ApiResult.Companion.fail((Throwable)(new Exception("empty cloud jwt"))) : AuthServiceKt.awaitCall(this.getCloudAuthApi().setPushToken(var1, new SetPushTokenRequest("null", false, (String)null, 4, (DefaultConstructorMarker)null)), var2);
   }

   public final void resetCloudJwt() {
      this.setBlueLoginDetails(new BlueLoginDetails((String)null, (String)null, 0, (String)null, (String)null, (String)null, (String)null, (String)null, 255, (DefaultConstructorMarker)null));
   }

   public final void setAblHomeHost(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.ablHomeHost$delegate.setValue(this, $$delegatedProperties[3], var1);
   }

   public final void setAblUser(AblUserApi.AblUser var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.ablUser$delegate.setValue(this, $$delegatedProperties[1], var1);
   }

   public final void setGigyaToken(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "username");
      Intrinsics.checkNotNullParameter(var2, "gigyaUid");
      Intrinsics.checkNotNullParameter(var3, "gigyaToken");
      this.logOut();
      this.gigyaService.setGigyaJwt(var3);
      MutableStateFlow var6 = this._isUserLoggedIn;
      CharSequence var5 = (CharSequence)var3;
      boolean var4;
      if (var5.length() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      var6.setValue(var4);
      if (var5.length() != 0) {
         var5 = (CharSequence)var1;
         Object var7 = var5;
         if (var5.length() == 0) {
            label24: {
               Claim var8 = (Claim)(new JWT(var3)).getClaims().get("email");
               if (var8 != null) {
                  var3 = var8.asString();
                  var7 = var3;
                  if (var3 != null) {
                     break label24;
                  }
               }

               var7 = "";
            }
         }

         String var9 = (String)var7;
         if (((CharSequence)var9).length() > 0) {
            BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var9, var2, (Continuation)null) {
               final String $gigyaUid;
               final String $userName;
               int label;
               final AuthService this$0;

               {
                  this.this$0 = var1;
                  this.$userName = var2;
                  this.$gigyaUid = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$userName, this.$gigyaUid, var2));
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
                     AuthService var6 = this.this$0;
                     String var5 = this.$userName;
                     String var4 = this.$gigyaUid;
                     Continuation var7 = (Continuation)this;
                     this.label = 1;
                     if (var6.authenticateAblUser(var5, var4, var7) == var3) {
                        return var3;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         } else {
            BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
               int label;
               final AuthService this$0;

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
                     AuthService var4 = this.this$0;
                     Continuation var5 = (Continuation)this;
                     this.label = 1;
                     if (AuthService.setPushToken$default(var4, (String)null, var5, 1, (Object)null) == var3) {
                        return var3;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }
      }
   }

   public final void setPushSettingsFetcher(Function1 var1) {
      this.pushSettingsFetcher = var1;
   }

   public final Object setPushToken(String var1, Continuation var2) {
      label38: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var10 = var4;
               break label38;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setPushToken((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var10).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var10).label;
      Object var8;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var12);
         var8 = var12;
      } else {
         ResultKt.throwOnFailure(var12);
         this.setPushToken(var1);
         if (((CharSequence)this.getPushToken()).length() == 0 || !(Boolean)this.isUserLoggedIn.getValue()) {
            return ApiResult.Companion.success(Util.EMPTY_RESPONSE);
         }

         Timber.Forest var13 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("setPushToken token = ");
         var6.append(this.getPushToken());
         var13.d(var6.toString(), new Object[0]);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final String $token;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final AuthService this$0;

            {
               this.this$0 = var1;
               this.$token = var2;
            }

            private static final int invokeSuspend$getSettingValue(Ref.BooleanRef var0, List var1, NotificationType var2) {
               if (!var0.element) {
                  return 0;
               } else {
                  Iterator var5 = ((Iterable)var1).iterator();

                  do {
                     if (!var5.hasNext()) {
                        var3 = null;
                        break;
                     }

                     var3 = var5.next();
                  } while(!Intrinsics.areEqual(((NotificationSetting)var3).getType(), var2.getValue()));

                  NotificationSetting var4 = (NotificationSetting)var3;
                  return var4 != null ? var4.getEnabled() : 1;
               }
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$token, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               KlaviyoSdk var9;
               List var10;
               GigyaService var21;
               Ref.BooleanRef var23;
               label61: {
                  Ref.BooleanRef var5;
                  KlaviyoSdk var6;
                  label65: {
                     boolean var4;
                     Object var12;
                     label59: {
                        label58: {
                           var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           var4 = true;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 if (var2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 var6 = (KlaviyoSdk)this.L$2;
                                 var5 = (Ref.BooleanRef)this.L$1;
                                 List var7 = (List)this.L$0;
                                 ResultKt.throwOnFailure(var1);
                                 var8 = var1;
                                 var14 = var7;
                                 break label65;
                              }

                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              var1 = KlaviyoSdk.INSTANCE;
                              boolean var3;
                              if (this.this$0.locationService.isInKlaviyoRegion() && !this.this$0.getUseJPush()) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var1.setEnabled(var3);
                              if (!KlaviyoSdk.INSTANCE.getEnabled()) {
                                 return Unit.INSTANCE;
                              }

                              Function1 var16 = this.this$0.getPushSettingsFetcher();
                              if (var16 == null) {
                                 break label58;
                              }

                              this.label = 1;
                              Object var19 = var16.invoke(this);
                              var1 = (KlaviyoSdk)var19;
                              if (var19 == var12) {
                                 return var12;
                              }
                           }

                           List var20 = (List)var1;
                           var14 = var20;
                           if (var20 != null) {
                              break label59;
                           }
                        }

                        var14 = CollectionsKt.emptyList();
                     }

                     var5 = new Ref.BooleanRef();
                     var5.element = true;
                     boolean var18;
                     if (invokeSuspend$getSettingValue(var5, var14, NotificationType.ALL) == 1) {
                        var18 = var4;
                     } else {
                        var18 = false;
                     }

                     var5.element = var18;
                     var6 = KlaviyoSdk.INSTANCE;
                     CharSequence var11 = (CharSequence)this.this$0.getGigyaService().getGigyaUid();
                     AuthService var13 = this.this$0;
                     var10 = var14;
                     var9 = var6;
                     var23 = var5;
                     var21 = var11;
                     if (var11.length() != 0) {
                        break label61;
                     }

                     var21 = var13.getGigyaService();
                     this.L$0 = var14;
                     this.L$1 = var5;
                     this.L$2 = var6;
                     this.I$0 = 0;
                     this.label = 2;
                     var8 = var21.refreshGigyaUid(this);
                     if (var8 == var12) {
                        return var12;
                     }
                  }

                  var21 = (String)var8;
                  var23 = var5;
                  var9 = var6;
                  var10 = var14;
               }

               var9.setProfile(new KlaviyoProfileData((String)var21, this.this$0.getUsername(), LocaleUtils.INSTANCE.getLanguageCode(), invokeSuspend$getSettingValue(var23, var10, NotificationType.FILTER_REPLACEMENT), invokeSuspend$getSettingValue(var23, var10, NotificationType.QUICK_ALARM_STOP), invokeSuspend$getSettingValue(var23, var10, NotificationType.FILTER_CLEANING), invokeSuspend$getSettingValue(var23, var10, NotificationType.WATER_LEVEL), invokeSuspend$getSettingValue(var23, var10, NotificationType.MARKETING), invokeSuspend$getSettingValue(var23, var10, NotificationType.TRANSACTIONAL)));
               Throwable var17 = KlaviyoSdk.INSTANCE.setPushToken(this.$token);
               if (var17 != null) {
                  this.this$0.analyticsService.event(new AnalyticEvent.BugEvent.KlaviyoFail(ExceptionsKt.stackTraceToString(var17)));
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
         Function2 var14 = new Function2(this, (Continuation)null) {
            Object L$0;
            int label;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(String var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               String var4 = (String)this.L$0;
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 == 1) {
                     ResultKt.throwOnFailure(var1);
                     return var1;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               } else {
                  ResultKt.throwOnFailure(var1);
                  Deferred var5 = this.this$0.getCloudAuthApi().setPushToken(var4, new SetPushTokenRequest(this.this$0.getPushToken(), true, (String)null, 4, (DefaultConstructorMarker)null));
                  Continuation var6 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                  this.label = 1;
                  Object var7 = AuthServiceKt.awaitCall(var5, var6);
                  return var7 == var3 ? var3 : var7;
               }
            }
         };
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).label = 1;
         Object var11 = this.getBearerToken(var14, (Continuation)var10);
         var8 = var11;
         if (var11 == var5) {
            return var5;
         }
      }

      ApiResult var9 = (ApiResult)var8;
      if (var9 == null) {
         return ApiResult.Companion.fail((Throwable)(new Exception("empty cloud jwt")));
      } else {
         return var9;
      }
   }

   public final void setUsername(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.username$delegate.setValue(this, $$delegatedProperties[2], var1);
   }

   public final Object updateGigyaDataCenter(Continuation var1) {
      label32: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var7 = var3;
               break label32;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            Object L$0;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateGigyaDataCenter((Continuation)this);
            }
         };
      }

      Object var4 = ((<undefinedtype>)var7).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      GigyaService var9;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 == 2) {
               ResultKt.throwOnFailure(var4);
               return var4;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var9 = (GigyaService)((<undefinedtype>)var7).L$0;
         ResultKt.throwOnFailure(var4);
      } else {
         ResultKt.throwOnFailure(var4);
         var9 = this.gigyaService;
         ((<undefinedtype>)var7).L$0 = var9;
         ((<undefinedtype>)var7).label = 1;
         Object var5 = this.fetchAblGranularRegion((Continuation)var7);
         var4 = var5;
         if (var5 == var6) {
            return var6;
         }
      }

      String var10 = (String)var4;
      ((<undefinedtype>)var7).L$0 = null;
      ((<undefinedtype>)var7).label = 2;
      Object var8 = var9.updateGigyaDataCenter(var10, (Continuation)var7);
      if (var8 != var6) {
         return var8;
      } else {
         return var6;
      }
   }

   public final void updateHomeHost() {
      if (AblEnvironment.INSTANCE.isUAT()) {
         this.setAblHomeHost("https://api-uat.blueair.io/");
      } else {
         if (((CharSequence)this.getUsername()).length() > 0) {
            BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
               Object L$0;
               int label;
               final AuthService this$0;

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
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ApiResult var3 = (ApiResult)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Function2 var12 = new Function2(this.this$0.userApi) {
                        public final Object invoke(String var1, Continuation var2) {
                           return ((AblUserApi)this.receiver).getHomehost(var1, var2);
                        }
                     };
                     String var8 = this.this$0.getUsername();
                     Continuation var5 = (Continuation)this;
                     this.label = 1;
                     Object var13 = AuthServiceKt.doSuspendedApiCall(var12, var8, var5);
                     var1 = var13;
                     if (var13 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var17 = (ApiResult)var1;
                  Timber.Forest var9 = Timber.Forest;
                  StringBuilder var14 = new StringBuilder("getHomeHost: response = ");
                  var14.append(var17);
                  var9.d(var14.toString(), new Object[0]);
                  if (var17.isFailure()) {
                     Exception var7 = new Exception("getHomeHost returned failure");
                     Timber.Forest var6 = Timber.Forest;
                     Throwable var15 = var17.exceptionOrNull();
                     Throwable var10 = var15;
                     if (var15 == null) {
                        var10 = (Throwable)var7;
                     }

                     var6.e(var10, "loginUser: getHomeHost() failed", new Object[0]);
                  }

                  Function2 var16 = new Function2(this.this$0, (Continuation)null) {
                     Object L$0;
                     int label;
                     final AuthService this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(String var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        String var2 = (String)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           AuthService var3 = this.this$0;
                           StringBuilder var4 = new StringBuilder("https://");
                           var4.append(var2);
                           var4.append('/');
                           var3.setAblHomeHost(var4.toString());
                           BugfenderSdk var5 = BugfenderSdk.INSTANCE;
                           StringBuilder var6 = new StringBuilder("https://");
                           var6.append(var2);
                           var5.setDeviceString("homehost", var6.toString());
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var11 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var17);
                  this.label = 2;
                  if (ApiResultKt.onSuccess(var17, var16, var11) == var4) {
                     return var4;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, 3, (Object)null);
         }

      }
   }

   public final Object updateLanguage(Continuation var1) {
      Object var3;
      label79: {
         if (var1 instanceof <undefinedtype>) {
            var3 = (<undefinedtype>)var1;
            if ((((<undefinedtype>)var3).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var3).label += Integer.MIN_VALUE;
               break label79;
            }
         }

         var3 = new ContinuationImpl(this, var1) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final AuthService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateLanguage((Continuation)this);
            }
         };
      }

      Object var6 = ((<undefinedtype>)var3).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var3).label;
      String var4;
      Locale var5;
      String var9;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var9 = (String)((<undefinedtype>)var3).L$2;
            Locale var11 = (Locale)((<undefinedtype>)var3).L$1;
            String var12 = (String)((<undefinedtype>)var3).L$0;
            ResultKt.throwOnFailure(var6);
            return Unit.INSTANCE;
         }

         var9 = (String)((<undefinedtype>)var3).L$2;
         var5 = (Locale)((<undefinedtype>)var3).L$1;
         var4 = (String)((<undefinedtype>)var3).L$0;
         ResultKt.throwOnFailure(var6);
      } else {
         ResultKt.throwOnFailure(var6);
         if (((CharSequence)this.getUsername()).length() == 0 || !(Boolean)this.isUserLoggedIn.getValue()) {
            return Unit.INSTANCE;
         }

         Prefs var13 = this.unsecurePrefs;
         var4 = (String)PreferencesHelper.INSTANCE.get(var13.getBackend(), "language", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
         var5 = Locale.getDefault();
         if (Intrinsics.areEqual(var5.getLanguage(), "zh") && Intrinsics.areEqual(var5.getCountry(), Locale.TAIWAN.getCountry())) {
            var9 = "zh_zh";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "zh")) {
            var9 = "zh_cn";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "fr")) {
            var9 = "fr_fr";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "ja")) {
            var9 = "ja_jp";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "ko")) {
            var9 = "ko_kr";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "es")) {
            var9 = "es_es";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "sv")) {
            var9 = "sv_se";
         } else if (Intrinsics.areEqual(var5.getLanguage(), "de")) {
            var9 = "de_de";
         } else {
            var9 = "en_us";
         }

         if (Intrinsics.areEqual(var4, var9)) {
            return Unit.INSTANCE;
         }

         Function3 var14 = new Function3(this.userApi) {
            public final Object invoke(String var1, String var2, Continuation var3) {
               return ((AblUserApi)this.receiver).setLanguage(var1, var2, var3);
            }
         };
         String var8 = this.getUsername();
         ((<undefinedtype>)var3).L$0 = SpillingKt.nullOutSpilledVariable(var4);
         ((<undefinedtype>)var3).L$1 = SpillingKt.nullOutSpilledVariable(var5);
         ((<undefinedtype>)var3).L$2 = var9;
         ((<undefinedtype>)var3).label = 1;
         var6 = AuthServiceKt.doSuspendedApiCall(var14, var8, var9, (Continuation)var3);
         if (var6 == var7) {
            return var7;
         }
      }

      ApiResult var15 = (ApiResult)var6;
      Function2 var16 = new Function2(this, var9, (Continuation)null) {
         final String $newLanguage;
         int label;
         final AuthService this$0;

         {
            this.this$0 = var1;
            this.$newLanguage = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$newLanguage, var2));
         }

         public final Object invoke(Unit var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               Prefs var2 = this.this$0.unsecurePrefs;
               String var3 = this.$newLanguage;
               PreferencesHelper.INSTANCE.set(var2.getBackend(), "language", var3, Reflection.getOrCreateKotlinClass(String.class));
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      };
      ((<undefinedtype>)var3).L$0 = SpillingKt.nullOutSpilledVariable(var4);
      ((<undefinedtype>)var3).L$1 = SpillingKt.nullOutSpilledVariable(var5);
      ((<undefinedtype>)var3).L$2 = SpillingKt.nullOutSpilledVariable(var9);
      ((<undefinedtype>)var3).label = 2;
      if (ApiResultKt.onSuccess(var15, var16, (Continuation)var3) == var7) {
         return var7;
      } else {
         return Unit.INSTANCE;
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/auth/AuthService$Companion;", "", "<init>", "()V", "EXTUID", "", "ABL_TOKEN_EXPIRE_RETRY_LENGTH_SECONDS", "", "ERROR_EMPTY_CLOUD_JWT", "getAblExpireTimeMillis", "", "ablJwt", "getAblExpireTimeMillis$auth_otherRelease", "auth_otherRelease"},
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

      public final long getAblExpireTimeMillis$auth_otherRelease(String var1) {
         Intrinsics.checkNotNullParameter(var1, "ablJwt");
         JWT var6 = new JWT(var1);
         Calendar var7 = Calendar.getInstance();
         var7.add(1, 100);
         Date var8 = var6.getExpiresAt();
         long var2;
         if (var8 != null) {
            var2 = var8.getTime();
         } else {
            var2 = 0L;
         }

         long var4 = var2;
         if (var2 > var7.getTimeInMillis()) {
            var4 = var2 / 1000L;
         }

         return var4;
      }
   }
}
