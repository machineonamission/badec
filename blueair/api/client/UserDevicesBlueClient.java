package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.model.SensorDataKt;
import com.blueair.api.restapi.AlexaLinkAppReq;
import com.blueair.api.restapi.AlexaUrls;
import com.blueair.api.restapi.AnalyticsFilterCLickEvent;
import com.blueair.api.restapi.AntiFakeLogReq;
import com.blueair.api.restapi.AntiFakeResetReq;
import com.blueair.api.restapi.ConfigurationAutoMode;
import com.blueair.api.restapi.ConfigurationDeviceInfo;
import com.blueair.api.restapi.Da;
import com.blueair.api.restapi.DeviceBlueWrapper;
import com.blueair.api.restapi.DeviceConfigQuery;
import com.blueair.api.restapi.DeviceInfo;
import com.blueair.api.restapi.DeviceLocationInfo;
import com.blueair.api.restapi.EventSubscription;
import com.blueair.api.restapi.Filter;
import com.blueair.api.restapi.FilterResetReq;
import com.blueair.api.restapi.GetDeviceStatusReq;
import com.blueair.api.restapi.GetDeviceStatusRsp;
import com.blueair.api.restapi.GetGoogleAuthCodeReq;
import com.blueair.api.restapi.GetGoogleAuthCodeRsp;
import com.blueair.api.restapi.Include;
import com.blueair.api.restapi.InitialBody;
import com.blueair.api.restapi.InitialResponse;
import com.blueair.api.restapi.JPushLinkReq;
import com.blueair.api.restapi.PresignUploadRsp;
import com.blueair.api.restapi.Ree;
import com.blueair.api.restapi.SetTimezoneReq;
import com.blueair.api.restapi.SetupDeviceLocationReq;
import com.blueair.api.restapi.ShopifyMultiPassReq;
import com.blueair.api.restapi.State;
import com.blueair.api.restapi.TimezoneConfiguration;
import com.blueair.api.restapi.UploadLogReq;
import com.blueair.api.restapi.UrlResponse;
import com.blueair.api.restapi.UserDevicesRestApi;
import com.blueair.api.restapi.UserDevicesRestApi$_CC;
import com.blueair.api.utils.ProgressListener;
import com.blueair.api.utils.ProgressRequestBody;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.UserForm;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.util.LocaleUtils;
import com.blueair.core.util.MoshiSerializer;
import io.flatcircle.coroutinehelper.ApiResult;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import retrofit2.Retrofit;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0002\u009e\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%H\u0086@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0%2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J(\u0010.\u001a\b\u0012\u0004\u0012\u00020/0%2\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020,01\"\u00020,H\u0086@¢\u0006\u0002\u00102J(\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040&0%2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060&H\u0086@¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0002J@\u0010<\u001a\u0004\u0018\u00010,2\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020*H\u0086@¢\u0006\u0002\u0010CJ,\u0010D\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0018\u00010E2\u0006\u0010F\u001a\u00020,2\u0006\u0010?\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020,2\u0006\u0010F\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u000e\u0010J\u001a\u00020*H\u0086@¢\u0006\u0002\u0010(J\u0016\u0010K\u001a\u00020*2\u0006\u0010F\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001e\u0010L\u001a\u00020,2\u0006\u0010=\u001a\u00020,2\u0006\u0010M\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u0016\u0010N\u001a\u00020*2\u0006\u0010=\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u0016\u0010O\u001a\u00020*2\u0006\u0010=\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u0016\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001e\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020,2\u0006\u0010Q\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u001a\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0&0%H\u0086@¢\u0006\u0002\u0010(J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020W0%2\u0006\u0010X\u001a\u00020UH\u0086@¢\u0006\u0002\u0010YJ*\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0%2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020,0&2\u0006\u0010\\\u001a\u00020,H\u0086@¢\u0006\u0002\u0010]J$\u0010^\u001a\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010+\u001a\u00020,2\u0006\u0010_\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020a0%2\u0006\u0010b\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J$\u0010c\u001a\b\u0012\u0004\u0012\u00020d0%2\u0006\u0010b\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0086@¢\u0006\u0002\u0010gJ$\u0010h\u001a\b\u0012\u0004\u0012\u00020i0%2\u0006\u0010b\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0086@¢\u0006\u0002\u0010gJ\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020W0%2\u0006\u0010k\u001a\u00020iH\u0086@¢\u0006\u0002\u0010lJ\u001e\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010n0%2\u0006\u0010o\u001a\u00020,H\u0087@¢\u0006\u0002\u0010-J8\u0010p\u001a\b\u0012\u0004\u0012\u00020W0%2\u0006\u0010q\u001a\u00020,2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020,0&2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020,0&H\u0086@¢\u0006\u0002\u0010sJ\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\"\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0&0%2\u0006\u0010q\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020w0%2\u0006\u0010I\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J,\u0010x\u001a\b\u0012\u0004\u0012\u00020y0%2\u0006\u0010I\u001a\u00020,2\u0006\u0010z\u001a\u00020,2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010{J4\u0010|\u001a\b\u0012\u0004\u0012\u00020y0%2\u0006\u0010I\u001a\u00020,2\u0006\u0010z\u001a\u00020,2\u0006\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020eH\u0086@¢\u0006\u0002\u0010\u007fJ7\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020W0%2\u0006\u0010I\u001a\u00020,2\u0006\u0010z\u001a\u00020,2\u0006\u0010}\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020,H\u0086@¢\u0006\u0003\u0010\u0082\u0001J&\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020y0%2\u0006\u0010+\u001a\u00020,2\u0007\u0010\u0084\u0001\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020W0%2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0086@¢\u0006\u0003\u0010\u0088\u0001J'\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020,0%2\u0007\u0010\u008a\u0001\u001a\u00020,2\u0007\u0010\u008b\u0001\u001a\u00020,H\u0086@¢\u0006\u0002\u0010GJ\u001b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0086@¢\u0006\u0003\u0010\u0090\u0001J!\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010%2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0086@¢\u0006\u0003\u0010\u0095\u0001J(\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"¨\u0006\u009f\u0001"},
   d2 = {"Lcom/blueair/api/client/UserDevicesBlueClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "userDevicesRestApi", "Lcom/blueair/api/restapi/UserDevicesRestApi;", "getUserDevicesRestApi", "()Lcom/blueair/api/restapi/UserDevicesRestApi;", "alarmSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceAlarm;", "getAlarmSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "alarmSerializer$delegate", "getDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/DeviceOnBlueServer;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceStatus", "", "deviceId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDevice", "", "uid", "", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialSetupCall", "Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "blueDevices", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadOscillationConfigFromState", "Lcom/blueair/core/model/DualOscillationConfig;", "deviceInfo", "Lcom/blueair/api/restapi/DeviceInfo;", "getAlexaRedirectUrl", "clientId", "responseType", "state", "scope", "redirectUri", "userAccepted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlexaLinkingUrls", "Lkotlin/Pair;", "stage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "alexaLinkAccount", "code", "getAlexaLinkStatus", "unlinkAlexa", "getGoogleAuthCode", "gigyaJwt", "getGoogleLinkStatus", "unlinkGoogle", "linkJPush", "jpushId", "unlinkJPush", "bearerToken", "getNotificationSettings", "Lcom/blueair/core/model/NotificationSetting;", "updateNotificationSetting", "Lokhttp3/ResponseBody;", "setting", "(Lcom/blueair/core/model/NotificationSetting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceTimezone", "deviceIdList", "timezone", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceTimezone", "defaultTimezone", "getTimezoneList", "Lcom/blueair/core/util/TimezoneNames;", "version", "getSkuConfigurations", "Lcom/blueair/core/model/SkuConfigurationData;", "", "series", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfoCollections", "Lcom/blueair/core/model/UserInfoCollections;", "uploadUserInfoCollections", "collections", "(Lcom/blueair/core/model/UserInfoCollections;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Ljava/io/InputStream;", "url", "setupDeviceLocation", "locationId", "resetDeviceIdList", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceLocation", "getLocationDevices", "antiFakeVerify", "Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "antiFakeResetByWifi", "Lcom/blueair/api/restapi/AntiFakeResetResp;", "deviceSku", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "antiFakeResetByBluetooth", "mac", "usage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "antiFakeLogBluetooth", "result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetFilterLife", "type", "analyticsLogFilterClickEvent", "event", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "(Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopifyMultiPassLink", "email", "redirectUrl", "postUserForm", "", "userForm", "Lcom/blueair/core/model/UserForm;", "(Lcom/blueair/core/model/UserForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignUploadLog", "Lcom/blueair/api/restapi/UploadLogRsp;", "req", "Lcom/blueair/api/restapi/UploadLogReq;", "(Lcom/blueair/api/restapi/UploadLogReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignUploadFile", "Lokhttp3/Response;", "rsp", "Lcom/blueair/api/restapi/PresignUploadRsp;", "file", "Ljava/io/File;", "listener", "Lcom/blueair/api/utils/ProgressListener;", "DeviceDataOnBlue", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserDevicesBlueClient implements CloudNetworkClient {
   private final Lazy alarmSerializer$delegate;
   private final AuthService authService;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static MoshiSerializer $r8$lambda$D2N6zbMTA5J6WE3y2okWWJ6HCx4() {
      return alarmSerializer_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$q9bvo5evIAsAdk_tL5KKHpOSqaM(UserDevicesBlueClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public UserDevicesBlueClient(Resources var1, AuthService var2, Interceptor var3) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      super();
      this.resources = var1;
      this.authService = var2;
      this.mockInterceptor = var3;
      this.okHttpClient$delegate = LazyKt.lazy(new UserDevicesBlueClient$$ExternalSyntheticLambda0(this));
      this.alarmSerializer$delegate = LazyKt.lazy(new UserDevicesBlueClient$$ExternalSyntheticLambda1());
   }

   // $FF: synthetic method
   public UserDevicesBlueClient(Resources var1, AuthService var2, Interceptor var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   private static final MoshiSerializer alarmSerializer_delegate$lambda$1() {
      return new MoshiSerializer((Type)DeviceAlarm.class, new Object[0]);
   }

   private final MoshiSerializer getAlarmSerializer() {
      return (MoshiSerializer)this.alarmSerializer$delegate.getValue();
   }

   private final UserDevicesRestApi getUserDevicesRestApi() {
      Object var1 = this.getRetrofit().create(UserDevicesRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (UserDevicesRestApi)var1;
   }

   private static final double[] initialSetupCall$lambda$97$lambda$90$parseArray(List var0, JSONObject var1, String var2) {
      Iterator var5;
      try {
         var5 = ((Iterable)var0).iterator();
      } catch (Throwable var35) {
         boolean var10001 = false;
         return null;
      }

      label384: {
         try {
            while(var5.hasNext()) {
               var37 = var5.next();
               String var6 = (String)var37;
               Intrinsics.checkNotNull(var6);
               var6 = var6.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var6, "toLowerCase(...)");
               if (Intrinsics.areEqual(var6, var2)) {
                  break label384;
               }
            }
         } catch (Throwable var36) {
            boolean var42 = false;
            return null;
         }

         var37 = null;
      }

      try {
         var38 = (String)var37;
      } catch (Throwable var34) {
         boolean var43 = false;
         return null;
      }

      if (var38 != null) {
         var2 = var38;
      }

      int var4;
      try {
         var39 = var1.getJSONArray(var2);
         if (var1.length() <= 0) {
            return null;
         }

         var4 = var39.length();
         var40 = new double[var4];
      } catch (Throwable var33) {
         boolean var44 = false;
         return null;
      }

      for(int var3 = 0; var3 < var4; ++var3) {
         try {
            var40[var3] = var39.getDouble(var3);
         } catch (Throwable var32) {
            boolean var45 = false;
            return null;
         }
      }

      return var40;
   }

   private final DualOscillationConfig loadOscillationConfigFromState(DeviceInfo var1) {
      DualOscillationConfig var2 = new DualOscillationConfig(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, (DefaultConstructorMarker)null);
      Integer var3 = var1.obtainStateIntValue("oscmode");
      if (var3 != null) {
         var2.setOscillationMode(((Number)var3).intValue());
         var3 = var1.obtainStateIntValue("oscstateh");
         if (var3 != null) {
            var2.setHorizontalOscillationState(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscfixh");
         if (var3 != null) {
            var2.setHorizontalOscillationFixAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscminh");
         if (var3 != null) {
            var2.setHorizontalOscillationMinAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscmaxh");
         if (var3 != null) {
            var2.setHorizontalOscillationMaxAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscstatev");
         if (var3 != null) {
            var2.setVerticalOscillationState(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscfixv");
         if (var3 != null) {
            var2.setVerticalOscillationFixAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscminv");
         if (var3 != null) {
            var2.setVerticalOscillationMinAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("oscmaxv");
         if (var3 != null) {
            var2.setVerticalOscillationMaxAngle(((Number)var3).intValue());
         }

         var3 = var1.obtainStateIntValue("calibrationh");
         if (var3 != null) {
            var2.setHorizontalCalibrationState(((Number)var3).intValue());
         }

         Integer var4 = var1.obtainStateIntValue("calibrationv");
         if (var4 != null) {
            var2.setVerticalCalibrationState(((Number)var4).intValue());
         }

         return var2;
      } else {
         return null;
      }
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(UserDevicesBlueClient var0) {
      return var0.buildHttpClient(false, var0.getMockInterceptor());
   }

   public final Object alexaLinkAccount(String var1, String var2, Continuation var3) {
      label23: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var13 = var5;
               break label23;
            }
         }

         var13 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.alexaLinkAccount((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var13).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var13).label;
      Object var11;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         Map var8 = (Map)((<undefinedtype>)var13).L$2;
         String var9 = (String)((<undefinedtype>)var13).L$1;
         var9 = (String)((<undefinedtype>)var13).L$0;
         ResultKt.throwOnFailure(var14);
         var11 = var14;
      } else {
         ResultKt.throwOnFailure(var14);
         Map var7 = MapsKt.mapOf(new Pair[]{TuplesKt.to("amazon_auth_code_from_url", var1), TuplesKt.to("stage_value", var2)});
         Deferred var15 = this.getUserDevicesRestApi().alexaLinkAccount(var7);
         ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var13).label = 1;
         Object var12 = this.awaitCall(var15, (Continuation)var13);
         var11 = var12;
         if (var12 == var6) {
            return var6;
         }
      }

      return Boxing.boxBoolean(((ApiResult)var11).isSuccess());
   }

   public final Object analyticsLogFilterClickEvent(AnalyticEvent.FilterClickEvent var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().analyticsLogFilterClickEvent(AnalyticsFilterCLickEvent.Companion.fromAnalyticEvent(var1)), var2);
   }

   public final Object antiFakeLogBluetooth(String var1, String var2, String var3, String var4, Continuation var5) {
      return this.awaitCall(this.getUserDevicesRestApi().antiFakeLog(new AntiFakeLogReq(var1, var2, var4, (String)null, var3, 8, (DefaultConstructorMarker)null)), var5);
   }

   public final Object antiFakeResetByBluetooth(String var1, String var2, String var3, int var4, Continuation var5) {
      return this.awaitCall(this.getUserDevicesRestApi().antiFakeReset(new AntiFakeResetReq(var1, var2, (String)null, var3, Boxing.boxInt(var4), 4, (DefaultConstructorMarker)null)), var5);
   }

   public final Object antiFakeResetByWifi(String var1, String var2, String var3, Continuation var4) {
      return this.awaitCall(this.getUserDevicesRestApi().antiFakeReset(new AntiFakeResetReq(var1, var2, var3, (String)null, (Integer)null, 24, (DefaultConstructorMarker)null)), var4);
   }

   public final Object antiFakeVerify(String var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().antiFakeVerify(var1), var2);
   }

   public Object awaitAllCalls(List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(this, var1, var2);
   }

   public Object awaitCall(Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(this, var1, var2);
   }

   public OkHttpClient buildBasicAuthClient(Interceptor var1) {
      return CloudNetworkClient$_CC.$default$buildBasicAuthClient(this, var1);
   }

   public OkHttpClient buildHttpClient(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClient(this, var1, var2);
   }

   public OkHttpClient buildHttpClientWithFakeUserSupport(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClientWithFakeUserSupport(this, var1, var2);
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public final Object downloadFile(String var1, Continuation var2) {
      return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), new Function2(var1, this, (Continuation)null) {
         final String $url;
         int label;
         final UserDevicesBlueClient this$0;

         {
            this.$url = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$url, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               Request var6 = (new Request.Builder()).url(this.$url).build();

               Exception var10000;
               label38: {
                  ApiResult.Companion var2;
                  try {
                     Response var7 = this.this$0.getOkHttpClient().newCall(var6).execute();
                     var2 = ApiResult.Companion;
                     var8 = var7.body();
                  } catch (Exception var5) {
                     var10000 = var5;
                     boolean var10001 = false;
                     break label38;
                  }

                  InputStream var9;
                  if (var8 != null) {
                     try {
                        var9 = var8.byteStream();
                     } catch (Exception var4) {
                        var10000 = var4;
                        boolean var12 = false;
                        break label38;
                     }
                  } else {
                     var9 = null;
                  }

                  try {
                     ApiResult var11 = var2.success(var9);
                     return var11;
                  } catch (Exception var3) {
                     var10000 = var3;
                     boolean var13 = false;
                  }
               }

               Exception var10 = var10000;
               return ApiResult.Companion.fail((Throwable)var10);
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, var2);
   }

   public final Object getAlexaLinkStatus(Continuation var1) {
      label28: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label28;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAlexaLinkStatus((Continuation)this);
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
         Deferred var10 = this.getUserDevicesRestApi().getAlexaLinkStatus();
         ((<undefinedtype>)var5).label = 1;
         Object var11 = this.awaitCall(var10, (Continuation)var5);
         var6 = var11;
         if (var11 == var4) {
            return var4;
         }
      }

      Map var7 = (Map)((ApiResult)var6).getOrNull();
      String var8;
      if (var7 != null) {
         var8 = (String)var7.get("skill_status");
      } else {
         var8 = null;
      }

      return Boxing.boxBoolean(Intrinsics.areEqual(var8, "enable"));
   }

   public final Object getAlexaLinkingUrls(String var1, String var2, Continuation var3) {
      label27: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var12 = var5;
               break label27;
            }
         }

         var12 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAlexaLinkingUrls((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var12).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var12).label;
      Object var9;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var12).L$1;
         var7 = (String)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var13);
         var9 = var13;
      } else {
         ResultKt.throwOnFailure(var13);
         Deferred var14 = this.getUserDevicesRestApi().getAlexaUrls(var1, var2);
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var12).label = 1;
         Object var11 = this.awaitCall(var14, (Continuation)var12);
         var9 = var11;
         if (var11 == var6) {
            return var6;
         }
      }

      AlexaUrls var10 = (AlexaUrls)((ApiResult)var9).getOrNull();
      return var10 != null ? TuplesKt.to(var10.getAlexaAppUrl(), var10.getLwaFallbackUrl()) : null;
   }

   public final Object getAlexaRedirectUrl(String var1, String var2, String var3, String var4, String var5, boolean var6, Continuation var7) {
      label27: {
         if (var7 instanceof <undefinedtype>) {
            <undefinedtype> var9 = (<undefinedtype>)var7;
            if ((var9.label & Integer.MIN_VALUE) != 0) {
               var9.label += Integer.MIN_VALUE;
               var20 = var9;
               break label27;
            }
         }

         var20 = new ContinuationImpl(this, var7) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            boolean Z$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAlexaRedirectUrl((String)null, (String)null, (String)null, (String)null, (String)null, false, (Continuation)this);
            }
         };
      }

      Object var21 = ((<undefinedtype>)var20).result;
      Object var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var8 = ((<undefinedtype>)var20).label;
      Object var16;
      if (var8 != 0) {
         if (var8 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var6 = ((<undefinedtype>)var20).Z$0;
         String var11 = (String)((<undefinedtype>)var20).L$4;
         var11 = (String)((<undefinedtype>)var20).L$3;
         var11 = (String)((<undefinedtype>)var20).L$2;
         var11 = (String)((<undefinedtype>)var20).L$1;
         var11 = (String)((<undefinedtype>)var20).L$0;
         ResultKt.throwOnFailure(var21);
         var16 = var21;
      } else {
         ResultKt.throwOnFailure(var21);
         Deferred var22 = this.getUserDevicesRestApi().getAlexaRedirectUrl(new AlexaLinkAppReq(var1, var2, var3, var4, var5, var6));
         ((<undefinedtype>)var20).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var20).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var20).L$2 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var20).L$3 = SpillingKt.nullOutSpilledVariable(var4);
         ((<undefinedtype>)var20).L$4 = SpillingKt.nullOutSpilledVariable(var5);
         ((<undefinedtype>)var20).Z$0 = var6;
         ((<undefinedtype>)var20).label = 1;
         Object var18 = this.awaitCall(var22, (Continuation)var20);
         var16 = var18;
         if (var18 == var10) {
            return var10;
         }
      }

      UrlResponse var17 = (UrlResponse)((ApiResult)var16).getOrNull();
      return var17 != null ? var17.getUrl() : null;
   }

   public AuthService getAuthService() {
      return this.authService;
   }

   public final Object getDeviceLocation(String var1, Continuation var2) {
      label33: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label33;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDeviceLocation((String)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var11).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var14);
         var7 = var14;
      } else {
         ResultKt.throwOnFailure(var14);
         Deferred var15 = this.getUserDevicesRestApi().getLocationInfo(var1, "device");
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).label = 1;
         Object var12 = this.awaitCall(var15, (Continuation)var11);
         var7 = var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var17 = (ApiResult)var7;
      ApiResult.Companion var16 = ApiResult.Companion;
      List var8 = (List)var17.getOrNull();
      String var10;
      if (var8 != null) {
         DeviceLocationInfo var9 = (DeviceLocationInfo)CollectionsKt.firstOrNull(var8);
         if (var9 != null) {
            String var13 = var9.getLocation_id();
            var10 = var13;
            if (var13 != null) {
               return var16.fromResult(var17, var10);
            }
         }
      }

      var10 = "";
      return var16.fromResult(var17, var10);
   }

   public final Object getDeviceStatus(String var1, Continuation var2) {
      label28: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var10 = var5;
               break label28;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDeviceStatus((String)null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var10).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var10).label;
      Object var8;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var13);
         var8 = var13;
      } else {
         ResultKt.throwOnFailure(var13);
         Deferred var14 = this.getUserDevicesRestApi().getDeviceStatus(new GetDeviceStatusReq(var1));
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).label = 1;
         Object var11 = this.awaitCall(var14, (Continuation)var10);
         var8 = var11;
         if (var11 == var6) {
            return var6;
         }
      }

      ApiResult var15 = (ApiResult)var8;
      ApiResult.Companion var9 = ApiResult.Companion;
      GetDeviceStatusRsp var12 = (GetDeviceStatusRsp)var15.getOrNull();
      boolean var4;
      if (var12 != null) {
         var4 = var12.getOnline();
      } else {
         var4 = false;
      }

      return var9.fromResult(var15, Boxing.boxBoolean(var4));
   }

   public final Object getDeviceTimezone(String var1, String var2, Continuation var3) {
      label28: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var14 = var5;
               break label28;
            }
         }

         var14 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDeviceTimezone((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var16 = ((<undefinedtype>)var14).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var14).label;
      Object var9;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var14).L$1;
         var7 = (String)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var16);
         var9 = (TimezoneConfiguration)var16;
      } else {
         ResultKt.throwOnFailure(var16);
         Deferred var17 = this.getUserDevicesRestApi().getTimezone(var1, var2);
         ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var14).label = 1;
         Object var12 = this.awaitCall(var17, (Continuation)var14);
         var9 = (TimezoneConfiguration)var12;
         if (var12 == var6) {
            return var6;
         }
      }

      ApiResult var13 = (ApiResult)var9;
      ApiResult.Companion var15 = ApiResult.Companion;
      var9 = (TimezoneConfiguration)var13.getOrNull();
      String var11;
      if (var9 != null) {
         var11 = var9.getTimezone();
      } else {
         var11 = null;
      }

      return var15.fromResult(var13, var11);
   }

   public final Object getDevices(Continuation var1) {
      label28: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label28;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDevices((Continuation)this);
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
         var6 = (DeviceBlueWrapper)var9;
      } else {
         ResultKt.throwOnFailure(var9);
         Timber.Forest.v("getDevices", new Object[0]);
         Deferred var10 = this.getUserDevicesRestApi().getDeviceList();
         ((<undefinedtype>)var5).label = 1;
         Object var11 = this.awaitCall(var10, (Continuation)var5);
         var6 = (DeviceBlueWrapper)var11;
         if (var11 == var4) {
            return var4;
         }
      }

      ApiResult var13 = (ApiResult)var6;
      ApiResult.Companion var12 = ApiResult.Companion;
      var6 = (DeviceBlueWrapper)var13.getOrNull();
      List var8;
      if (var6 != null) {
         var8 = var6.getDevices();
      } else {
         var8 = null;
      }

      return var12.fromResult(var13, var8);
   }

   public final Object getGoogleAuthCode(String var1, String var2, Continuation var3) {
      label30: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var13 = var5;
               break label30;
            }
         }

         var13 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getGoogleAuthCode((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var13).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var13).label;
      Object var9;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var13).L$1;
         var7 = (String)((<undefinedtype>)var13).L$0;
         ResultKt.throwOnFailure(var14);
         var9 = (GetGoogleAuthCodeRsp)var14;
      } else {
         ResultKt.throwOnFailure(var14);
         Deferred var15 = this.getUserDevicesRestApi().getGoogleAuthCode(new GetGoogleAuthCodeReq(var1, var2, (String)null, 4, (DefaultConstructorMarker)null));
         ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var13).label = 1;
         Object var12 = this.awaitCall(var15, (Continuation)var13);
         var9 = (GetGoogleAuthCodeRsp)var12;
         if (var12 == var6) {
            return var6;
         }
      }

      var9 = (GetGoogleAuthCodeRsp)((ApiResult)var9).getOrNull();
      if (var9 != null) {
         String var11 = var9.getCode();
         if (var11 != null) {
            return var11;
         }
      }

      return "";
   }

   public final Object getGoogleLinkStatus(String var1, Continuation var2) {
      label33: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var2;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var10 = var5;
               break label33;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getGoogleLinkStatus((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var10).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var10).label;
      boolean var4 = true;
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
         Deferred var13 = UserDevicesRestApi$_CC.getGoogleLinkStatus$default(this.getUserDevicesRestApi(), var1, (String)null, 2, (Object)null);
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).label = 1;
         Object var11 = this.awaitCall(var13, (Continuation)var10);
         var8 = var11;
         if (var11 == var6) {
            return var6;
         }
      }

      Integer var9 = (Integer)((ApiResult)var8).getOrNull();
      if (var9 == null || var9 != 1) {
         var4 = false;
      }

      return Boxing.boxBoolean(var4);
   }

   public final Object getLocationDevices(String var1, Continuation var2) {
      label37: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label37;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getLocationDevices((String)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var11).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var14);
         var7 = var14;
      } else {
         ResultKt.throwOnFailure(var14);
         Deferred var15 = this.getUserDevicesRestApi().getLocationInfo(var1, "location");
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).label = 1;
         Object var12 = this.awaitCall(var15, (Continuation)var11);
         var7 = var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var16 = (ApiResult)var7;
      ApiResult.Companion var13 = ApiResult.Companion;
      List var8 = (List)var16.getOrNull();
      if (var8 != null) {
         Iterable var17 = (Iterable)var8;
         Collection var9 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var17, 10)));
         Iterator var18 = var17.iterator();

         while(var18.hasNext()) {
            var9.add(((DeviceLocationInfo)var18.next()).getDevice_id());
         }

         var8 = (List)var9;
      } else {
         var8 = CollectionsKt.emptyList();
      }

      return var13.fromResult(var16, var8);
   }

   public Interceptor getMockInterceptor() {
      return this.mockInterceptor;
   }

   public final Object getNotificationSettings(Continuation var1) {
      return this.awaitCall(this.getUserDevicesRestApi().getNotificationSettings(), var1);
   }

   public OkHttpClient getOkHttpClient() {
      return (OkHttpClient)this.okHttpClient$delegate.getValue();
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory(this.getAuthService().getBlueHomeHost());
   }

   public final Object getSkuConfigurations(int var1, int var2, Continuation var3) {
      return this.awaitCall(this.getUserDevicesRestApi().getSkuConfigurations(var1, var2), var3);
   }

   public final Object getTimezoneList(String var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().getTimezoneList(var1), var2);
   }

   public final Object getUserInfoCollections(int var1, int var2, Continuation var3) {
      return this.awaitCall(this.getUserDevicesRestApi().getUserInfoCollections(var1, var2), var3);
   }

   public final Object initialSetupCall(List var1, Continuation var2) {
      label4929: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var18 = (<undefinedtype>)var2;
            if ((var18.label & Integer.MIN_VALUE) != 0) {
               var18.label += Integer.MIN_VALUE;
               var235 = var18;
               break label4929;
            }
         }

         var235 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.initialSetupCall((List)null, (Continuation)this);
            }
         };
      }

      Object var246 = ((<undefinedtype>)var235).result;
      Object var19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var235).label;
      byte var3 = 1;
      Object var122;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         InitialBody var117 = (InitialBody)((<undefinedtype>)var235).L$4;
         List var118 = (List)((<undefinedtype>)var235).L$3;
         EventSubscription var119 = (EventSubscription)((<undefinedtype>)var235).L$2;
         Ref.ObjectRef var120 = (Ref.ObjectRef)((<undefinedtype>)var235).L$1;
         List var121 = (List)((<undefinedtype>)var235).L$0;
         ResultKt.throwOnFailure(var246);
         var122 = var246;
      } else {
         ResultKt.throwOnFailure(var246);
         if (var1.isEmpty()) {
            return ApiResult.Companion.success(CollectionsKt.emptyList());
         }

         Ref.ObjectRef var247 = new Ref.ObjectRef();
         var247.element = "= ";
         Iterable var21 = (Iterable)var1;

         for(HasBlueCloudFunctions var23 : var21) {
            StringBuilder var20 = new StringBuilder();
            var20.append((String)var247.element);
            var20.append(var23.getUid());
            var20.append(", ");
            var247.element = var20.toString();
         }

         StringsKt.dropLast((String)var247.element, 2);
         EventSubscription var443 = new EventSubscription(CollectionsKt.listOf(new Include(new Filter((String)var247.element))));
         Collection var461 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var21, 10)));
         Iterator var454 = var21.iterator();

         while(var454.hasNext()) {
            var461.add(new DeviceConfigQuery(((HasBlueCloudFunctions)var454.next()).getUid(), (Ree)null, 2, (DefaultConstructorMarker)null));
         }

         List var455 = (List)var461;
         InitialBody var462 = new InitialBody(var443, var455, false, (DeviceInfo)null, 12, (DefaultConstructorMarker)null);
         Deferred var465 = this.getUserDevicesRestApi().initialSetupCall(this.getAuthService().getUserIdForBlueCloud(), var462);
         ((<undefinedtype>)var235).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var235).L$1 = SpillingKt.nullOutSpilledVariable(var247);
         ((<undefinedtype>)var235).L$2 = SpillingKt.nullOutSpilledVariable(var443);
         ((<undefinedtype>)var235).L$3 = SpillingKt.nullOutSpilledVariable(var455);
         ((<undefinedtype>)var235).L$4 = SpillingKt.nullOutSpilledVariable(var462);
         ((<undefinedtype>)var235).label = 1;
         Object var236 = this.awaitCall(var465, (Continuation)var235);
         var122 = var236;
         if (var236 == var19) {
            return var19;
         }
      }

      ApiResult var123 = (ApiResult)var122;
      if (!var123.isSuccess()) {
         return ApiResult.Companion.fromResult(var123, CollectionsKt.emptyList());
      } else {
         Object var124 = var123.getOrNull();
         Intrinsics.checkNotNull(var124);
         Iterable var125 = (Iterable)((InitialResponse)var124).getDeviceInfo();
         Collection var104 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var125, 10)));
         Iterator var237 = var125.iterator();

         while(true) {
            int var7 = 2;
            boolean var9 = var237.hasNext();
            int var6 = 0;
            if (!var9) {
               List var234 = (List)var104;
               Timber.Forest var383 = Timber.Forest;
               StringBuilder var238 = new StringBuilder("WH DEVICES: ");
               var238.append(CollectionsKt.joinToString$default((Iterable)var234, (CharSequence)"=\n=", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
               var383.d(var238.toString(), new Object[0]);
               return ApiResult.Companion.success(var234);
            }

            DeviceInfo var105 = (DeviceInfo)var237.next();
            Timber.Forest var248 = Timber.Forest;
            StringBuilder var126 = new StringBuilder("Initial call done, received ");
            var126.append(var105);
            var248.d(var126.toString(), new Object[0]);
            Iterator var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var127 = null;
                  break;
               }

               var127 = var249.next();
            } while(!Intrinsics.areEqual(((State)var127).getN(), "fanspeed"));

            label4294: {
               State var128 = (State)var127;
               if (var128 != null) {
                  Integer var129 = var128.getV();
                  if (var129 != null) {
                     var4 = var129;
                     break label4294;
                  }
               }

               var4 = 0;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var130 = null;
                  break;
               }

               var130 = var249.next();
            } while(!Intrinsics.areEqual(((State)var130).getN(), "brightness"));

            int var5;
            label4306: {
               State var131 = (State)var130;
               if (var131 != null) {
                  Integer var132 = var131.getV();
                  if (var132 != null) {
                     var5 = var132;
                     break label4306;
                  }
               }

               var5 = 0;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var133 = null;
                  break;
               }

               var133 = var249.next();
            } while(!Intrinsics.areEqual(((State)var133).getN(), "childlock"));

            State var134 = (State)var133;
            Boolean var466;
            if (var134 != null) {
               var466 = var134.getVb();
            } else {
               var466 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var135 = null;
                  break;
               }

               var135 = var249.next();
            } while(!Intrinsics.areEqual(((State)var135).getN(), "automode"));

            var134 = (State)var135;
            Boolean var24;
            if (var134 != null) {
               var24 = var134.getVb();
            } else {
               var24 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var137 = null;
                  break;
               }

               var137 = var249.next();
            } while(!Intrinsics.areEqual(((State)var137).getN(), "standby"));

            var134 = (State)var137;
            Boolean var25;
            if (var134 != null) {
               var25 = var134.getVb();
            } else {
               var25 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var139 = null;
                  break;
               }

               var139 = var249.next();
            } while(!Intrinsics.areEqual(((State)var139).getN(), "eco"));

            var134 = (State)var139;
            Boolean var26;
            if (var134 != null) {
               var26 = var134.getVb();
            } else {
               var26 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var141 = null;
                  break;
               }

               var141 = var249.next();
            } while(!Intrinsics.areEqual(((State)var141).getN(), "hins"));

            var134 = (State)var141;
            Boolean var27;
            if (var134 != null) {
               var27 = var134.getVb();
            } else {
               var27 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var143 = null;
                  break;
               }

               var143 = var249.next();
            } while(!Intrinsics.areEqual(((State)var143).getN(), "nmhins"));

            var134 = (State)var143;
            Boolean var29;
            if (var134 != null) {
               var29 = var134.getVb();
            } else {
               var29 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var145 = null;
                  break;
               }

               var145 = var249.next();
            } while(!Intrinsics.areEqual(((State)var145).getN(), "nightmode"));

            var134 = (State)var145;
            Boolean var30;
            if (var134 != null) {
               var30 = var134.getVb();
            } else {
               var30 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var147 = null;
                  break;
               }

               var147 = var249.next();
            } while(!Intrinsics.areEqual(((State)var147).getN(), "germshield"));

            var134 = (State)var147;
            Boolean var32;
            if (var134 != null) {
               var32 = var134.getVb();
            } else {
               var32 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var149 = null;
                  break;
               }

               var149 = var249.next();
            } while(!Intrinsics.areEqual(((State)var149).getN(), "gsnm"));

            var134 = (State)var149;
            Boolean var28;
            if (var134 != null) {
               var28 = var134.getVb();
            } else {
               var28 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var249.hasNext()) {
                  var151 = null;
                  break;
               }

               var151 = var249.next();
            } while(!Intrinsics.areEqual(((State)var151).getN(), "safetyswitch"));

            var134 = (State)var151;
            Boolean var34;
            if (var134 != null) {
               var34 = var134.getVb();
            } else {
               var34 = null;
            }

            Iterator var153 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var153.hasNext()) {
                  var154 = null;
                  break;
               }

               Object var261 = var153.next();
               if (Intrinsics.areEqual(((State)var261).getN(), "filterusage")) {
                  var154 = var261;
                  break;
               }
            }

            State var155 = (State)var154;
            Integer var31;
            if (var155 != null) {
               var31 = var155.getV();
            } else {
               var31 = null;
            }

            Iterator var156 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var156.hasNext()) {
                  var157 = null;
                  break;
               }

               Object var262 = var156.next();
               if (Intrinsics.areEqual(((State)var262).getN(), "disinfection")) {
                  var157 = var262;
                  break;
               }
            }

            State var158 = (State)var157;
            Boolean var33;
            if (var158 != null) {
               var33 = var158.getVb();
            } else {
               var33 = null;
            }

            Iterator var159 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var159.hasNext()) {
                  var160 = null;
                  break;
               }

               Object var263 = var159.next();
               if (Intrinsics.areEqual(((State)var263).getN(), "disinftime")) {
                  var160 = var263;
                  break;
               }
            }

            State var161 = (State)var160;
            Integer var35;
            if (var161 != null) {
               var35 = var161.getV();
            } else {
               var35 = null;
            }

            Long var36;
            if (var161 != null) {
               var36 = Boxing.boxLong(var161.getT());
            } else {
               var36 = null;
            }

            Iterator var162 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var162.hasNext()) {
                  var163 = null;
                  break;
               }

               Object var264 = var162.next();
               if (Intrinsics.areEqual(((State)var264).getN(), "wickdrye")) {
                  var163 = var264;
                  break;
               }
            }

            State var164 = (State)var163;
            Boolean var37;
            if (var164 != null) {
               var37 = var164.getVb();
            } else {
               var37 = null;
            }

            Iterator var165 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var165.hasNext()) {
                  var166 = null;
                  break;
               }

               Object var265 = var165.next();
               if (Intrinsics.areEqual(((State)var265).getN(), "wickdrys")) {
                  var166 = var265;
                  break;
               }
            }

            State var167 = (State)var166;
            Boolean var38;
            if (var167 != null) {
               var38 = var167.getVb();
            } else {
               var38 = null;
            }

            Iterator var168 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var168.hasNext()) {
                  var169 = null;
                  break;
               }

               Object var266 = var168.next();
               if (Intrinsics.areEqual(((State)var266).getN(), "wickdryl")) {
                  var169 = var266;
                  break;
               }
            }

            State var170 = (State)var169;
            Integer var39;
            if (var170 != null) {
               var39 = var170.getV();
            } else {
               var39 = null;
            }

            Iterator var171 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var171.hasNext()) {
                  var172 = null;
                  break;
               }

               Object var267 = var171.next();
               if (Intrinsics.areEqual(((State)var267).getN(), "wickdryts")) {
                  var172 = var267;
                  break;
               }
            }

            State var173 = (State)var172;
            Integer var41;
            if (var173 != null) {
               var41 = var173.getV();
            } else {
               var41 = null;
            }

            Iterator var174 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var174.hasNext()) {
                  var175 = null;
                  break;
               }

               Object var268 = var174.next();
               if (Intrinsics.areEqual(((State)var268).getN(), "wickusage")) {
                  var175 = var268;
                  break;
               }
            }

            State var176 = (State)var175;
            Integer var40;
            if (var176 != null) {
               var40 = var176.getV();
            } else {
               var40 = null;
            }

            Iterator var177 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var177.hasNext()) {
                  var178 = null;
                  break;
               }

               Object var269 = var177.next();
               if (Intrinsics.areEqual(((State)var269).getN(), "wshortage")) {
                  var178 = var269;
                  break;
               }
            }

            State var179 = (State)var178;
            Boolean var42;
            if (var179 != null) {
               var42 = var179.getVb();
            } else {
               var42 = null;
            }

            Iterator var180 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var180.hasNext()) {
                  var181 = null;
                  break;
               }

               Object var270 = var180.next();
               if (Intrinsics.areEqual(((State)var270).getN(), "autorh")) {
                  var181 = var270;
                  break;
               }
            }

            State var182 = (State)var181;
            Integer var43;
            if (var182 != null) {
               var43 = var182.getV();
            } else {
               var43 = null;
            }

            Iterator var183 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var183.hasNext()) {
                  var184 = null;
                  break;
               }

               Object var271 = var183.next();
               if (Intrinsics.areEqual(((State)var271).getN(), "timstate")) {
                  var184 = var271;
                  break;
               }
            }

            State var185 = (State)var184;
            Integer var44;
            if (var185 != null) {
               var44 = var185.getV();
            } else {
               var44 = null;
            }

            Iterator var186 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var186.hasNext()) {
                  var187 = null;
                  break;
               }

               Object var272 = var186.next();
               if (Intrinsics.areEqual(((State)var272).getN(), "timdur")) {
                  var187 = var272;
                  break;
               }
            }

            State var188 = (State)var187;
            Integer var45;
            if (var188 != null) {
               var45 = var188.getV();
            } else {
               var45 = null;
            }

            Iterator var189 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var189.hasNext()) {
                  var190 = null;
                  break;
               }

               Object var273 = var189.next();
               if (Intrinsics.areEqual(((State)var273).getN(), "timl")) {
                  var190 = var273;
                  break;
               }
            }

            State var191 = (State)var190;
            Integer var46;
            if (var191 != null) {
               var46 = var191.getV();
            } else {
               var46 = null;
            }

            Iterator var192 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var192.hasNext()) {
                  var193 = null;
                  break;
               }

               Object var274 = var192.next();
               if (Intrinsics.areEqual(((State)var274).getN(), "timts")) {
                  var193 = var274;
                  break;
               }
            }

            State var194 = (State)var193;
            Integer var195;
            if (var194 != null) {
               var195 = var194.getV();
            } else {
               var195 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();
            Iterator var196 = var249;

            while(true) {
               if (!var196.hasNext()) {
                  var197 = null;
                  break;
               }

               Object var276 = var196.next();
               if (Intrinsics.areEqual(((State)var276).getN(), "tu")) {
                  var197 = var276;
                  break;
               }
            }

            State var198 = (State)var197;
            Integer var47;
            if (var198 != null) {
               var47 = var198.getV();
            } else {
               var47 = null;
            }

            Iterator var199 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var199.hasNext()) {
                  var200 = null;
                  break;
               }

               Object var277 = var199.next();
               if (Intrinsics.areEqual(((State)var277).getN(), "oscstate")) {
                  var200 = var277;
                  break;
               }
            }

            State var201 = (State)var200;
            Integer var49;
            if (var201 != null) {
               var49 = var201.getV();
            } else {
               var49 = null;
            }

            Iterator var202 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var202.hasNext()) {
                  var203 = null;
                  break;
               }

               Object var278 = var202.next();
               if (Intrinsics.areEqual(((State)var278).getN(), "osc")) {
                  var203 = var278;
                  break;
               }
            }

            State var204 = (State)var203;
            Integer var50;
            if (var204 != null) {
               var50 = var204.getV();
            } else {
               var50 = null;
            }

            Iterator var205 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var205.hasNext()) {
                  var206 = null;
                  break;
               }

               Object var279 = var205.next();
               if (Intrinsics.areEqual(((State)var279).getN(), "oscdir")) {
                  var206 = var279;
                  break;
               }
            }

            State var207 = (State)var206;
            Integer var51;
            if (var207 != null) {
               var51 = var207.getV();
            } else {
               var51 = null;
            }

            Iterator var208 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var208.hasNext()) {
                  var209 = null;
                  break;
               }

               Object var280 = var208.next();
               if (Intrinsics.areEqual(((State)var280).getN(), "oscfs")) {
                  var209 = var280;
                  break;
               }
            }

            State var210 = (State)var209;
            Integer var52;
            if (var210 != null) {
               var52 = var210.getV();
            } else {
               var52 = null;
            }

            Iterator var211 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var211.hasNext()) {
                  var212 = null;
                  break;
               }

               Object var281 = var211.next();
               if (Intrinsics.areEqual(((State)var281).getN(), "mainmode")) {
                  var212 = var281;
                  break;
               }
            }

            State var213 = (State)var212;
            Integer var53;
            if (var213 != null) {
               var53 = var213.getV();
            } else {
               var53 = null;
            }

            Iterator var214 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var214.hasNext()) {
                  var215 = null;
                  break;
               }

               Object var282 = var214.next();
               if (Intrinsics.areEqual(((State)var282).getN(), "apsubmode")) {
                  var215 = var282;
                  break;
               }
            }

            State var216 = (State)var215;
            Integer var54;
            if (var216 != null) {
               var54 = var216.getV();
            } else {
               var54 = null;
            }

            Iterator var217 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var217.hasNext()) {
                  var218 = null;
                  break;
               }

               Object var283 = var217.next();
               if (Intrinsics.areEqual(((State)var283).getN(), "fsp0")) {
                  var218 = var283;
                  break;
               }
            }

            State var219 = (State)var218;
            Integer var55;
            if (var219 != null) {
               var55 = var219.getV();
            } else {
               var55 = null;
            }

            Iterator var220 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var220.hasNext()) {
                  var221 = null;
                  break;
               }

               Object var284 = var220.next();
               if (Intrinsics.areEqual(((State)var284).getN(), "heatsubmode")) {
                  var221 = var284;
                  break;
               }
            }

            State var222 = (State)var221;
            Integer var56;
            if (var222 != null) {
               var56 = var222.getV();
            } else {
               var56 = null;
            }

            Iterator var223 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var223.hasNext()) {
                  var224 = null;
                  break;
               }

               Object var285 = var223.next();
               if (Intrinsics.areEqual(((State)var285).getN(), "heatfs")) {
                  var224 = var285;
                  break;
               }
            }

            State var225 = (State)var224;
            Integer var57;
            if (var225 != null) {
               var57 = var225.getV();
            } else {
               var57 = null;
            }

            Iterator var226 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var226.hasNext()) {
                  var227 = null;
                  break;
               }

               Object var286 = var226.next();
               if (Intrinsics.areEqual(((State)var286).getN(), "heattemp")) {
                  var227 = var286;
                  break;
               }
            }

            State var228 = (State)var227;
            Integer var229;
            if (var228 != null) {
               var229 = var228.getV();
            } else {
               var229 = null;
            }

            var249 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var249.hasNext()) {
                  var288 = null;
                  break;
               }

               var19 = var249.next();
               if (Intrinsics.areEqual(((State)var19).getN(), "ecoheattemp")) {
                  var288 = var19;
                  break;
               }
            }

            State var289 = (State)var288;
            Integer var290;
            if (var289 != null) {
               var290 = var289.getV();
            } else {
               var290 = null;
            }

            Iterator var385 = ((Iterable)var105.getStates()).iterator();
            Iterator var291 = var385;

            while(true) {
               if (!var291.hasNext()) {
                  var292 = null;
                  break;
               }

               Object var386 = var291.next();
               if (Intrinsics.areEqual(((State)var386).getN(), "coolsubmode")) {
                  var292 = var386;
                  break;
               }
            }

            State var293 = (State)var292;
            Integer var59;
            if (var293 != null) {
               var59 = var293.getV();
            } else {
               var59 = null;
            }

            Iterator var294 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var294.hasNext()) {
                  var295 = null;
                  break;
               }

               Object var387 = var294.next();
               if (Intrinsics.areEqual(((State)var387).getN(), "coolfs")) {
                  var295 = var387;
                  break;
               }
            }

            State var296 = (State)var295;
            Integer var60;
            if (var296 != null) {
               var60 = var296.getV();
            } else {
               var60 = null;
            }

            Iterator var297 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var297.hasNext()) {
                  var298 = null;
                  break;
               }

               Object var388 = var297.next();
               if (Intrinsics.areEqual(((State)var388).getN(), "coolautotag")) {
                  var298 = var388;
                  break;
               }
            }

            State var299 = (State)var298;
            Integer var61;
            if (var299 != null) {
               var61 = var299.getV();
            } else {
               var61 = null;
            }

            Iterator var300 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var300.hasNext()) {
                  var301 = null;
                  break;
               }

               Object var389 = var300.next();
               if (Intrinsics.areEqual(((State)var389).getN(), "coolautofs1")) {
                  var301 = var389;
                  break;
               }
            }

            State var302 = (State)var301;
            Integer var303;
            if (var302 != null) {
               var303 = var302.getV();
            } else {
               var303 = null;
            }

            Iterator var444 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var444.hasNext()) {
                  var304 = null;
                  break;
               }

               var304 = var444.next();
            } while(!Intrinsics.areEqual(((State)var304).getN(), "coolautofs2"));

            State var305 = (State)var304;
            Integer var306;
            if (var305 != null) {
               var306 = var305.getV();
            } else {
               var306 = null;
            }

            var444 = ((Iterable)var105.getStates()).iterator();

            while(true) {
               if (!var444.hasNext()) {
                  var446 = null;
                  break;
               }

               Object var456 = var444.next();
               if (Intrinsics.areEqual(((State)var456).getN(), "coolautofs3")) {
                  var446 = var456;
                  break;
               }
            }

            State var447 = (State)var446;
            Integer var448;
            if (var447 != null) {
               var448 = var447.getV();
            } else {
               var448 = null;
            }

            Integer[] var457 = new Integer[3];
            var457[var6] = var303;
            var457[var3] = var306;
            var457[var7] = var448;
            Iterable var391 = (Iterable)CollectionsKt.listOfNotNull(var457);
            Collection var307 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var391, 10)));
            Iterator var392 = var391.iterator();

            while(var392.hasNext()) {
               int var8 = ((Number)var392.next()).intValue();
               var307.add(Boxing.boxDouble(DeviceData.Companion.fromServerValue(var8)));
            }

            Collection var393 = (Collection)((List)var307);
            var307 = var393;
            if (var393.isEmpty()) {
               var307 = null;
            }

            List var309 = (List)var307;
            double[] var62;
            if (var309 != null) {
               var62 = CollectionsKt.toDoubleArray((Collection)var309);
            } else {
               var62 = null;
            }

            Iterator var394 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var394.hasNext()) {
                  var310 = null;
                  break;
               }

               var310 = var394.next();
            } while(!Intrinsics.areEqual(((State)var310).getN(), "coolecotag"));

            State var311 = (State)var310;
            Integer var63;
            if (var311 != null) {
               var63 = var311.getV();
            } else {
               var63 = null;
            }

            var394 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var394.hasNext()) {
                  var312 = null;
                  break;
               }

               var312 = var394.next();
            } while(!Intrinsics.areEqual(((State)var312).getN(), "coolecofs1"));

            var311 = (State)var312;
            Integer var314;
            if (var311 != null) {
               var314 = var311.getV();
            } else {
               var314 = null;
            }

            Iterator var449 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var449.hasNext()) {
                  var396 = null;
                  break;
               }

               var396 = var449.next();
            } while(!Intrinsics.areEqual(((State)var396).getN(), "coolecofs2"));

            State var397 = (State)var396;
            Integer var398;
            if (var397 != null) {
               var398 = var397.getV();
            } else {
               var398 = null;
            }

            Integer[] var450 = new Integer[var7];
            var450[var6] = var314;
            var450[var3] = var398;
            Iterable var399 = (Iterable)CollectionsKt.listOfNotNull(var450);
            Collection var315 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var399, 10)));
            Iterator var400 = var399.iterator();

            while(var400.hasNext()) {
               var7 = ((Number)var400.next()).intValue();
               var315.add(Boxing.boxDouble(DeviceData.Companion.fromServerValue(var7)));
            }

            Collection var401 = (Collection)((List)var315);
            var315 = var401;
            if (var401.isEmpty()) {
               var315 = null;
            }

            List var317 = (List)var315;
            double[] var64;
            if (var317 != null) {
               var64 = CollectionsKt.toDoubleArray((Collection)var317);
            } else {
               var64 = null;
            }

            Iterator var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var318 = null;
                  break;
               }

               var318 = var402.next();
            } while(!Intrinsics.areEqual(((State)var318).getN(), "mode"));

            State var319 = (State)var318;
            Integer var65;
            if (var319 != null) {
               var65 = var319.getV();
            } else {
               var65 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var320 = null;
                  break;
               }

               var320 = var402.next();
            } while(!Intrinsics.areEqual(((State)var320).getN(), "hummode"));

            var319 = (State)var320;
            Boolean var66;
            if (var319 != null) {
               var66 = var319.getVb();
            } else {
               var66 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var322 = null;
                  break;
               }

               var322 = var402.next();
            } while(!Intrinsics.areEqual(((State)var322).getN(), "wlevel"));

            var319 = (State)var322;
            Integer var67;
            if (var319 != null) {
               var67 = var319.getV();
            } else {
               var67 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var324 = null;
                  break;
               }

               var324 = var402.next();
            } while(!Intrinsics.areEqual(((State)var324).getN(), "dehsubmode"));

            var319 = (State)var324;
            Integer var68;
            if (var319 != null) {
               var68 = var319.getV();
            } else {
               var68 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var326 = null;
                  break;
               }

               var326 = var402.next();
            } while(!Intrinsics.areEqual(((State)var326).getN(), "watertankfailure"));

            Boolean var69;
            label4684: {
               label4934: {
                  var319 = (State)var326;
                  if (var319 != null) {
                     Boolean var407 = var319.getVb();
                     var328 = var407;
                     if (var407 != null) {
                        break label4934;
                     }
                  }

                  var402 = ((Iterable)var105.getStates()).iterator();

                  do {
                     if (!var402.hasNext()) {
                        var329 = null;
                        break;
                     }

                     var329 = var402.next();
                  } while(!Intrinsics.areEqual(((State)var329).getN(), "wtankfail"));

                  var319 = (State)var329;
                  if (var319 == null) {
                     var69 = null;
                     break label4684;
                  }

                  var328 = var319.getVb();
               }

               var69 = var328;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var331 = null;
                  break;
               }

               var331 = var402.next();
            } while(!Intrinsics.areEqual(((State)var331).getN(), "smartsubmode"));

            var319 = (State)var331;
            Integer var70;
            if (var319 != null) {
               var70 = var319.getV();
            } else {
               var70 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var333 = null;
                  break;
               }

               var333 = var402.next();
            } while(!Intrinsics.areEqual(((State)var333).getN(), "detectcat"));

            var319 = (State)var333;
            Boolean var71;
            if (var319 != null) {
               var71 = var319.getVb();
            } else {
               var71 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var335 = null;
                  break;
               }

               var335 = var402.next();
            } while(!Intrinsics.areEqual(((State)var335).getN(), "bodymounted"));

            var319 = (State)var335;
            Boolean var72;
            if (var319 != null) {
               var72 = var319.getVb();
            } else {
               var72 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var337 = null;
                  break;
               }

               var337 = var402.next();
            } while(!Intrinsics.areEqual(((State)var337).getN(), "aireta"));

            var319 = (State)var337;
            Integer var73;
            if (var319 != null) {
               var73 = var319.getV();
            } else {
               var73 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var339 = null;
                  break;
               }

               var339 = var402.next();
            } while(!Intrinsics.areEqual(((State)var339).getN(), "displaymode"));

            var319 = (State)var339;
            Integer var74;
            if (var319 != null) {
               var74 = var319.getV();
            } else {
               var74 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var341 = null;
                  break;
               }

               var341 = var402.next();
            } while(!Intrinsics.areEqual(((State)var341).getN(), "hover"));

            var319 = (State)var341;
            Boolean var75;
            if (var319 != null) {
               var75 = var319.getVb();
            } else {
               var75 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var343 = null;
                  break;
               }

               var343 = var402.next();
            } while(!Intrinsics.areEqual(((State)var343).getN(), "airrefresh"));

            var319 = (State)var343;
            Boolean var76;
            if (var319 != null) {
               var76 = var319.getVb();
            } else {
               var76 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var345 = null;
                  break;
               }

               var345 = var402.next();
            } while(!Intrinsics.areEqual(((State)var345).getN(), "arstate"));

            var319 = (State)var345;
            Integer var77;
            if (var319 != null) {
               var77 = var319.getV();
            } else {
               var77 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var347 = null;
                  break;
               }

               var347 = var402.next();
            } while(!Intrinsics.areEqual(((State)var347).getN(), "ardur"));

            var319 = (State)var347;
            Integer var78;
            if (var319 != null) {
               var78 = var319.getV();
            } else {
               var78 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var349 = null;
                  break;
               }

               var349 = var402.next();
            } while(!Intrinsics.areEqual(((State)var349).getN(), "arts"));

            var319 = (State)var349;
            Integer var79;
            if (var319 != null) {
               var79 = var319.getV();
            } else {
               var79 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var351 = null;
                  break;
               }

               var351 = var402.next();
            } while(!Intrinsics.areEqual(((State)var351).getN(), "startts"));

            var319 = (State)var351;
            Integer var80;
            if (var319 != null) {
               var80 = var319.getV();
            } else {
               var80 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var353 = null;
                  break;
               }

               var353 = var402.next();
            } while(!Intrinsics.areEqual(((State)var353).getN(), "endts"));

            var319 = (State)var353;
            Integer var81;
            if (var319 != null) {
               var81 = var319.getV();
            } else {
               var81 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var355 = null;
                  break;
               }

               var355 = var402.next();
            } while(!Intrinsics.areEqual(((State)var355).getN(), "roomtype"));

            var319 = (State)var355;
            Integer var82;
            if (var319 != null) {
               var82 = var319.getV();
            } else {
               var82 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var357 = null;
                  break;
               }

               var357 = var402.next();
            } while(!Intrinsics.areEqual(((State)var357).getN(), "nlbrightness"));

            var319 = (State)var357;
            Integer var83;
            if (var319 != null) {
               var83 = var319.getV();
            } else {
               var83 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var359 = null;
                  break;
               }

               var359 = var402.next();
            } while(!Intrinsics.areEqual(((State)var359).getN(), "nlstepless"));

            var319 = (State)var359;
            Integer var84;
            if (var319 != null) {
               var84 = var319.getV();
            } else {
               var84 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var361 = null;
                  break;
               }

               var361 = var402.next();
            } while(!Intrinsics.areEqual(((State)var361).getN(), "wickdrydur"));

            var319 = (State)var361;
            Integer var85;
            if (var319 != null) {
               var85 = var319.getV();
            } else {
               var85 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var363 = null;
                  break;
               }

               var363 = var402.next();
            } while(!Intrinsics.areEqual(((State)var363).getN(), "wickdrydone"));

            var319 = (State)var363;
            Boolean var86;
            if (var319 != null) {
               var86 = var319.getVb();
            } else {
               var86 = null;
            }

            ConfigurationDeviceInfo var365 = var105.getConfiguration().getDeviceInfo();
            Boolean var87;
            if (var365 != null) {
               var87 = var365.getYwrmEnable();
            } else {
               var87 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var366 = null;
                  break;
               }

               var366 = var402.next();
            } while(!Intrinsics.areEqual(((State)var366).getN(), "ywrmusage"));

            State var367 = (State)var366;
            Integer var88;
            if (var367 != null) {
               var88 = var367.getV();
            } else {
               var88 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var368 = null;
                  break;
               }

               var368 = var402.next();
            } while(!Intrinsics.areEqual(((State)var368).getN(), "humsubmode"));

            var367 = (State)var368;
            Integer var89;
            if (var367 != null) {
               var89 = var367.getV();
            } else {
               var89 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var370 = null;
                  break;
               }

               var370 = var402.next();
            } while(!Intrinsics.areEqual(((State)var370).getN(), "hourformat"));

            var367 = (State)var370;
            Boolean var90;
            if (var367 != null) {
               var90 = var367.getVb();
            } else {
               var90 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var372 = null;
                  break;
               }

               var372 = var402.next();
            } while(!Intrinsics.areEqual(((State)var372).getN(), "waterinfill"));

            var367 = (State)var372;
            Boolean var91;
            if (var367 != null) {
               var91 = var367.getVb();
            } else {
               var91 = null;
            }

            var402 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var402.hasNext()) {
                  var374 = null;
                  break;
               }

               var374 = var402.next();
            } while(!Intrinsics.areEqual(((State)var374).getN(), "sensormode"));

            var367 = (State)var374;
            Integer var92;
            if (var367 != null) {
               var92 = var367.getV();
            } else {
               var92 = null;
            }

            Integer var106 = var105.obtainStateIntValue("coolfslevel");
            Integer var107 = var105.obtainStateIntValue("coolauto");
            Integer var376 = var105.obtainStateIntValue("nightstartts");
            Long var93;
            if (var376 != null) {
               var93 = Boxing.boxLong((long)var376);
            } else {
               var93 = null;
            }

            DualOscillationConfig var108 = this.loadOscillationConfigFromState(var105);
            Integer var109 = var105.obtainStateIntValue("rpm");
            ConfigurationDeviceInfo var377 = var105.getConfiguration().getDeviceInfo();
            double[] var94;
            if (var377 != null) {
               var94 = var377.getNightPeroids();
            } else {
               var94 = null;
            }

            List var378 = var105.getSensordata();
            IndoorDatapoint var95;
            if (var378.isEmpty()) {
               var95 = null;
            } else {
               var95 = SensorDataKt.toIndoorDatapoint(var378);
            }

            double[] var97;
            double[] var463;
            double[] var480;
            label4844: {
               double[] var379 = new double[var6];
               double[] var431 = new double[var6];
               double[] var451 = new double[var6];
               double[] var458 = new double[var6];
               var463 = new double[var6];
               ConfigurationDeviceInfo var96 = var105.getConfiguration().getDeviceInfo();
               if (var96 != null) {
                  String var479 = var96.getSensorRanges();
                  if (var479 != null) {
                     JSONObject var488 = new JSONObject(var479);
                     Iterator var481 = var488.keys();
                     Intrinsics.checkNotNullExpressionValue(var481, "keys(...)");
                     List var98 = SequencesKt.toList(SequencesKt.asSequence(var481));
                     double[] var482 = initialSetupCall$lambda$97$lambda$90$parseArray(var98, var488, "pm1");
                     if (var482 != null) {
                        Unit var380 = Unit.INSTANCE;
                        var379 = var482;
                     }

                     var482 = initialSetupCall$lambda$97$lambda$90$parseArray(var98, var488, "pm25");
                     if (var482 != null) {
                        Unit var453 = Unit.INSTANCE;
                        var451 = var482;
                     }

                     var482 = initialSetupCall$lambda$97$lambda$90$parseArray(var98, var488, "pm10");
                     if (var482 != null) {
                        Unit var432 = Unit.INSTANCE;
                        var431 = var482;
                     }

                     var482 = initialSetupCall$lambda$97$lambda$90$parseArray(var98, var488, "tvoc");
                     if (var482 != null) {
                        Unit var460 = Unit.INSTANCE;
                        var458 = var482;
                     }

                     var482 = initialSetupCall$lambda$97$lambda$90$parseArray(var98, var488, "hcho");
                     if (var482 != null) {
                        Unit var464 = Unit.INSTANCE;
                        var463 = var482;
                     }

                     var97 = var431;
                     var452 = var379;
                     var459 = var451;
                     var480 = var458;
                     break label4844;
                  }
               }

               var480 = var458;
               var459 = var451;
               var452 = var379;
               var97 = var431;
            }

            var6 = var3;
            var378 = null;

            while(true) {
               if (var6 >= 7) {
                  var441 = var229;
                  break;
               }

               var402 = ((Iterable)var105.getStates()).iterator();

               while(true) {
                  if (!var402.hasNext()) {
                     var434 = null;
                     break;
                  }

                  Object var490 = var402.next();
                  String var99 = ((State)var490).getN();
                  StringBuilder var100 = new StringBuilder("alarm");
                  var100.append(var6);
                  if (Intrinsics.areEqual(var99, var100.toString())) {
                     var434 = var490;
                     break;
                  }
               }

               State var435 = (State)var434;
               if (var435 == null) {
                  var441 = var229;
                  break;
               }

               Object var491 = var435.getVj();
               DeviceAlarm var440;
               if (var491 == null) {
                  var440 = null;
               } else {
                  label4874: {
                     Throwable var10000;
                     label4938: {
                        label4871: {
                           try {
                              Result.Companion var436 = Result.Companion;
                              if (var491 instanceof Map) {
                                 var440 = (DeviceAlarm)this.getAlarmSerializer().fromMap((Map)var491);
                                 break label4871;
                              }
                           } catch (Throwable var116) {
                              var10000 = var116;
                              boolean var10001 = false;
                              break label4938;
                           }

                           var440 = null;
                        }

                        label4863:
                        try {
                           var440 = (DeviceAlarm)Result.constructor-impl(var440);
                           break label4874;
                        } catch (Throwable var115) {
                           var10000 = var115;
                           boolean var506 = false;
                           break label4863;
                        }
                     }

                     Throwable var438 = var10000;
                     Result.Companion var492 = Result.Companion;
                     var440 = (DeviceAlarm)Result.constructor-impl(ResultKt.createFailure(var438));
                  }

                  var491 = var440;
                  if (Result.isFailure-impl(var440)) {
                     var491 = null;
                  }

                  var440 = (DeviceAlarm)var491;
               }

               if (var378 == null) {
                  ArrayList var382 = new ArrayList(6);

                  for(int var244 = 0; var244 < 6; ++var244) {
                     var382.add((Object)null);
                  }

                  var378 = (List)var382;
               }

               var378.set(var6 - 1, var440);
               ++var6;
            }

            Iterator var494 = ((Iterable)var105.getStates()).iterator();

            do {
               if (!var494.hasNext()) {
                  var230 = null;
                  break;
               }

               var230 = var494.next();
            } while(!Intrinsics.areEqual(((State)var230).getN(), "online"));

            State var231 = (State)var230;
            Boolean var232;
            if (var231 != null) {
               var232 = var231.getVb();
            } else {
               var232 = null;
            }

            Integer var233;
            if (Intrinsics.areEqual(var232, Boxing.boxBoolean((boolean)var3))) {
               var233 = Boxing.boxInt(ConnectivityStatus.ONLINE.ordinal());
            } else if (Intrinsics.areEqual(var232, Boxing.boxBoolean(false))) {
               var233 = Boxing.boxInt(ConnectivityStatus.OFFLINE.ordinal());
            } else {
               var233 = null;
            }

            label4907: {
               Da var495 = var105.getConfiguration().getDa();
               if (var495 != null) {
                  ConfigurationAutoMode var496 = var495.getNightMode();
                  if (var496 != null) {
                     var497 = var496.getNightModeTrigger();
                     break label4907;
                  }
               }

               var497 = null;
            }

            String var500;
            label4902: {
               Da var498 = var105.getConfiguration().getDa();
               if (var498 != null) {
                  ConfigurationAutoMode var499 = var498.getAutoMode();
                  if (var499 != null) {
                     var500 = var499.getAutoModeTrigger();
                     break label4902;
                  }
               }

               var500 = null;
            }

            String var110 = var105.getId();
            ConfigurationDeviceInfo var501 = var105.getConfiguration().getDeviceInfo();
            String var502;
            if (var501 != null) {
               var502 = var501.getType();
            } else {
               var502 = null;
            }

            ConfigurationDeviceInfo var101 = var105.getConfiguration().getDeviceInfo();
            String var503;
            if (var101 != null) {
               var503 = var101.getMcuFirmware();
            } else {
               var503 = null;
            }

            ConfigurationDeviceInfo var102 = var105.getConfiguration().getDeviceInfo();
            String var504;
            if (var102 != null) {
               var504 = var102.getWifiFirmware();
            } else {
               var504 = null;
            }

            ConfigurationDeviceInfo var103 = var105.getConfiguration().getDeviceInfo();
            String var505;
            if (var103 != null) {
               var505 = var103.getHardware();
            } else {
               var505 = null;
            }

            if (var466 != null) {
               var9 = var466;
            } else {
               var9 = false;
            }

            boolean var10;
            if (var24 != null) {
               var10 = var24;
            } else {
               var10 = false;
            }

            boolean var11;
            if (var25 != null) {
               var11 = var25;
            } else {
               var11 = false;
            }

            boolean var12;
            if (var26 != null) {
               var12 = var26;
            } else {
               var12 = false;
            }

            boolean var13;
            if (var27 != null) {
               var13 = var27;
            } else {
               var13 = false;
            }

            boolean var14;
            if (var29 != null) {
               var14 = var29;
            } else {
               var14 = false;
            }

            boolean var15;
            if (var30 != null) {
               var15 = var30;
            } else {
               var15 = false;
            }

            boolean var16;
            if (var32 != null) {
               var16 = var32;
            } else {
               var16 = false;
            }

            ConfigurationDeviceInfo var467 = var105.getConfiguration().getDeviceInfo();
            String var468;
            if (var467 != null) {
               var468 = var467.getSerialNumber();
            } else {
               var468 = null;
            }

            ConfigurationDeviceInfo var469 = var105.getConfiguration().getDeviceInfo();
            String var470;
            if (var469 != null) {
               var470 = var469.getName();
            } else {
               var470 = null;
            }

            boolean var17;
            if (var34 != null) {
               var17 = var34;
            } else {
               var17 = false;
            }

            ConfigurationDeviceInfo var471 = var105.getConfiguration().getDeviceInfo();
            String var472;
            if (var471 != null) {
               var472 = var471.getMacAddress();
            } else {
               var472 = null;
            }

            WelcomeHomeLocation var477 = WelcomeHomeLocation.Companion.fromBlueWelcomeHomeLocation(var105.getWelcomehome());
            String var476 = var105.getLocation_id();
            String var478 = var105.getTimezone();
            Long var473;
            if (var41 != null) {
               var473 = Boxing.boxLong((long)var41);
            } else {
               var473 = null;
            }

            Long var474;
            if (var195 != null) {
               var474 = Boxing.boxLong((long)var195);
            } else {
               var474 = null;
            }

            Double var442;
            if (var441 != null) {
               var6 = ((Number)var441).intValue();
               var442 = Boxing.boxDouble(DeviceData.Companion.fromServerValue(var6));
            } else {
               var442 = null;
            }

            Double var475;
            if (var290 != null) {
               var6 = ((Number)var290).intValue();
               var475 = Boxing.boxDouble(DeviceData.Companion.fromServerValue(var6));
            } else {
               var475 = null;
            }

            var104.add(new DeviceDataOnBlue(var110, var502, var503, var504, var505, var233, var95, var4, var5, var9, var10, var31, var452, var97, var459, var480, var463, var11, var12, var13, var14, var15, var16, var28, var468, var470, var500, var497, var17, var472, var477, var476, var33, var35, var36, var478, var37, var38, var39, var473, var40, var42, var43, var44, var45, var46, var474, var47, var49, var50, var51, var52, var53, var54, var55, var56, var57, var442, var475, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var378, var89, var90, var91, var92, var106, var107, var93, var108, var109, var94));
         }
      }
   }

   public final Object linkJPush(String var1, Continuation var2) {
      label23: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label23;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.linkJPush((String)null, (Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var8).L$0;
         ResultKt.throwOnFailure(var10);
         var7 = var10;
      } else {
         ResultKt.throwOnFailure(var10);
         Deferred var11 = this.getUserDevicesRestApi().jpushLink(new JPushLinkReq(var1, LocaleUtils.INSTANCE.getLanguageCode()));
         ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var8).label = 1;
         Object var9 = this.awaitCall(var11, (Continuation)var8);
         var7 = var9;
         if (var9 == var5) {
            return var5;
         }
      }

      return Boxing.boxBoolean(((ApiResult)var7).isSuccess());
   }

   public final Object postUserForm(UserForm var1, Continuation var2) {
      Object var3 = this.awaitCall(this.getUserDevicesRestApi().postUserForm(var1), var2);
      return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
   }

   public final Response presignUploadFile(PresignUploadRsp var1, File var2, ProgressListener var3) {
      Intrinsics.checkNotNullParameter(var1, "rsp");
      Intrinsics.checkNotNullParameter(var2, "file");
      Intrinsics.checkNotNullParameter(var3, "listener");
      MultipartBody.Builder var6 = (new MultipartBody.Builder((String)null, 1, (DefaultConstructorMarker)null)).setType(MultipartBody.FORM);

      for(Map.Entry var4 : var1.getFields().entrySet()) {
         var6.addFormDataPart((String)var4.getKey(), (String)var4.getValue());
      }

      var6.addFormDataPart("file", (String)null, RequestBody.Companion.create(var2, (MediaType)null));
      ProgressRequestBody var8 = new ProgressRequestBody((RequestBody)var6.build(), var3);
      Request var7 = (new Request.Builder()).url(var1.getUrl()).post(var8).build();
      return (new OkHttpClient()).newCall(var7).execute();
   }

   public final Object presignUploadLog(UploadLogReq var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().presignUploadLog(var1), var2);
   }

   public final Object removeDevice(String[] var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().removeDevice(ArraysKt.toList(var1)), var2);
   }

   public final Object resetFilterLife(String var1, String var2, Continuation var3) {
      return this.awaitCall(this.getUserDevicesRestApi().resetFilterLife(new FilterResetReq(var1, var2)), var3);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public final Object setDeviceTimezone(List var1, String var2, Continuation var3) {
      return this.awaitCall(this.getUserDevicesRestApi().setTimezone(new SetTimezoneReq(var1, var2)), var3);
   }

   public final Object setupDeviceLocation(String var1, List var2, List var3, Continuation var4) {
      return this.awaitCall(this.getUserDevicesRestApi().setupDeviceLocation(new SetupDeviceLocationReq(var1, var2, var3)), var4);
   }

   public final Object shopifyMultiPassLink(String var1, String var2, Continuation var3) {
      label29: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var10 = var5;
               break label29;
            }
         }

         var10 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.shopifyMultiPassLink((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var10).result;
      UrlResponse var6 = (UrlResponse)IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var10).label;
      Object var8;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = (String)((<undefinedtype>)var10).L$1;
         String var7 = (String)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var13);
         var8 = var13;
      } else {
         ResultKt.throwOnFailure(var13);
         Deferred var14 = this.getUserDevicesRestApi().shopifyMultiPassLink(new ShopifyMultiPassReq(var1, var2));
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).L$1 = var2;
         ((<undefinedtype>)var10).label = 1;
         Object var11 = this.awaitCall(var14, (Continuation)var10);
         var8 = var11;
         if (var11 == var6) {
            return var6;
         }
      }

      ApiResult var12 = (ApiResult)var8;
      ApiResult.Companion var15 = ApiResult.Companion;
      var6 = (UrlResponse)var12.getOrNull();
      String var9 = var2;
      if (var6 != null) {
         var9 = var6.getUrl();
         if (var9 == null) {
            var9 = var2;
         }
      }

      return var15.fromResult(var12, var9);
   }

   public final Object unlinkAlexa(String var1, Continuation var2) {
      label28: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var10 = var4;
               break label28;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.unlinkAlexa((String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var10).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var10).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var12);
         var7 = var12;
      } else {
         ResultKt.throwOnFailure(var12);
         Deferred var13 = this.getUserDevicesRestApi().unlinkAlexa(var1);
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).label = 1;
         Object var11 = this.awaitCall(var13, (Continuation)var10);
         var7 = var11;
         if (var11 == var5) {
            return var5;
         }
      }

      Map var8 = (Map)((ApiResult)var7).getOrNull();
      String var9;
      if (var8 != null) {
         var9 = (String)var8.get("skill_status");
      } else {
         var9 = null;
      }

      return Boxing.boxBoolean(Intrinsics.areEqual(var9, "Disabled"));
   }

   public final Object unlinkGoogle(String var1, Continuation var2) {
      label23: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label23;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.unlinkGoogle((String)null, (Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var8).L$0;
         ResultKt.throwOnFailure(var10);
         var7 = var10;
      } else {
         ResultKt.throwOnFailure(var10);
         Deferred var11 = this.getUserDevicesRestApi().unlinkGoogle(var1);
         ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var8).label = 1;
         Object var9 = this.awaitCall(var11, (Continuation)var8);
         var7 = var9;
         if (var9 == var5) {
            return var5;
         }
      }

      return Boxing.boxBoolean(((ApiResult)var7).isSuccess());
   }

   public final Object unlinkJPush(String var1, String var2, Continuation var3) {
      label23: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var11 = var5;
               break label23;
            }
         }

         var11 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesBlueClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.unlinkJPush((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var11).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var11).label;
      Object var9;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var7 = (String)((<undefinedtype>)var11).L$1;
         var7 = (String)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var12);
         var9 = var12;
      } else {
         ResultKt.throwOnFailure(var12);
         Deferred var13 = this.getUserDevicesRestApi().jpushUnlink(var1, var2);
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var11).label = 1;
         Object var10 = this.awaitCall(var13, (Continuation)var11);
         var9 = var10;
         if (var10 == var6) {
            return var6;
         }
      }

      return Boxing.boxBoolean(((ApiResult)var9).isSuccess());
   }

   public final Object updateNotificationSetting(NotificationSetting var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().updateNotificationSetting(var1), var2);
   }

   public final Object uploadUserInfoCollections(UserInfoCollections var1, Continuation var2) {
      return this.awaitCall(this.getUserDevicesRestApi().uploadUserInfoCollections(var1), var2);
   }

   @Metadata(
      d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\bã\u0001\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010+\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\b\u00100\u001a\u0004\u0018\u00010+\u0012\b\u00101\u001a\u0004\u0018\u00010\t\u0012\b\u00102\u001a\u0004\u0018\u00010\u000f\u0012\b\u00103\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\b\u00106\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u00010+\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u00010\t\u0012\b\u0010;\u001a\u0004\u0018\u00010\t\u0012\b\u0010<\u001a\u0004\u0018\u00010\t\u0012\b\u0010=\u001a\u0004\u0018\u00010\t\u0012\b\u0010>\u001a\u0004\u0018\u00010\t\u0012\b\u0010?\u001a\u0004\u0018\u00010\t\u0012\b\u0010@\u001a\u0004\u0018\u00010\t\u0012\b\u0010A\u001a\u0004\u0018\u00010\t\u0012\b\u0010B\u001a\u0004\u0018\u00010C\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010E\u001a\u0004\u0018\u00010\t\u0012\b\u0010F\u001a\u0004\u0018\u00010\t\u0012\b\u0010G\u001a\u0004\u0018\u00010\t\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010I\u001a\u0004\u0018\u00010\t\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010K\u001a\u0004\u0018\u00010\t\u0012\b\u0010L\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010M\u001a\u0004\u0018\u00010\t\u0012\b\u0010N\u001a\u0004\u0018\u00010\t\u0012\b\u0010O\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010P\u001a\u0004\u0018\u00010\t\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010R\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010S\u001a\u0004\u0018\u00010\t\u0012\b\u0010T\u001a\u0004\u0018\u00010\t\u0012\b\u0010U\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010V\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010W\u001a\u0004\u0018\u00010\t\u0012\b\u0010X\u001a\u0004\u0018\u00010\t\u0012\b\u0010Y\u001a\u0004\u0018\u00010\t\u0012\b\u0010Z\u001a\u0004\u0018\u00010\t\u0012\b\u0010[\u001a\u0004\u0018\u00010\t\u0012\b\u0010\\\u001a\u0004\u0018\u00010\t\u0012\b\u0010]\u001a\u0004\u0018\u00010\t\u0012\b\u0010^\u001a\u0004\u0018\u00010\t\u0012\b\u0010_\u001a\u0004\u0018\u00010\t\u0012\b\u0010`\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010b\u001a\u0004\u0018\u00010\t\u0012\u0010\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d\u0012\b\u0010f\u001a\u0004\u0018\u00010\t\u0012\b\u0010g\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010h\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010i\u001a\u0004\u0018\u00010\t\u0012\b\u0010j\u001a\u0004\u0018\u00010\t\u0012\b\u0010k\u001a\u0004\u0018\u00010\t\u0012\b\u0010l\u001a\u0004\u0018\u00010+\u0012\b\u0010m\u001a\u0004\u0018\u00010n\u0012\b\u0010o\u001a\u0004\u0018\u00010\t\u0012\b\u0010p\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bq\u0010rJ\n\u0010ç\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010í\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\n\u0010î\u0001\u001a\u00020\tHÆ\u0003J\n\u0010ï\u0001\u001a\u00020\tHÆ\u0003J\n\u0010ð\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ñ\u0001\u001a\u00020\u000fHÆ\u0003J\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\n\u0010ó\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010õ\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ö\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010÷\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ø\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ù\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ú\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010û\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ü\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ý\u0001\u001a\u00020\u000fHÆ\u0003J\u0012\u0010þ\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0083\u0002\u001a\u00020\u000fHÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010\u0088\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010\u0089\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010 \u0001J\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010\u008d\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010\u008e\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010 \u0001J\u0011\u0010\u008f\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010\u0091\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010\u0095\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010 \u0001J\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0099\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009a\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009b\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009d\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009e\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010 \u0002\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0003\u0010¹\u0001J\u0012\u0010¡\u0002\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0003\u0010¹\u0001J\u0011\u0010¢\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010£\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¤\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010¥\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010¦\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010§\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010¨\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010©\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010ª\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010«\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010¬\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010®\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010¯\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010°\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010±\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010²\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010³\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010´\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010µ\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010·\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¸\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¹\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010º\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010»\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¼\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010½\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010¾\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010¿\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0014\u0010À\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010dHÆ\u0003J\u0011\u0010Á\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010Â\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010Ã\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0092\u0001J\u0011\u0010Ä\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010Å\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010Æ\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010Ç\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010 \u0001J\f\u0010È\u0002\u001a\u0004\u0018\u00010nHÆ\u0003J\u0011\u0010É\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010Ê\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003J¦\t\u0010Ë\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010+2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010+2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010n2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0003\u0010Ì\u0002J\u0015\u0010Í\u0002\u001a\u00020\u000f2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ï\u0002\u001a\u00020\tHÖ\u0001J\n\u0010Ð\u0002\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bu\u0010tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010tR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010{\u001a\u0004\by\u0010zR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0012\u0010\r\u001a\u00020\t¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u007fR\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0013\u0010\u0010\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0082\u0001R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b\u0084\u0001\u0010zR\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0013\u0010\u0014\u001a\u00020\u0013¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0086\u0001R\u0013\u0010\u0015\u001a\u00020\u0013¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0086\u0001R\u0013\u0010\u0016\u001a\u00020\u0013¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0086\u0001R\u0013\u0010\u0017\u001a\u00020\u0013¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u0086\u0001R\u0013\u0010\u0018\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0082\u0001R\u0013\u0010\u0019\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u0082\u0001R\u0013\u0010\u001a\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0082\u0001R\u0013\u0010\u001b\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0082\u0001R\u0013\u0010\u001c\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0082\u0001R\u0013\u0010\u001d\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0082\u0001R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010tR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010tR\u0014\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010tR\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010tR\u0013\u0010#\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0082\u0001R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0099\u0001\u0010tR\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0014\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010tR\u0018\u0010(\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b\u009d\u0001\u0010\u0092\u0001R\u0016\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b\u009e\u0001\u0010zR\u0018\u0010*\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010¡\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0014\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010tR\u0018\u0010-\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b£\u0001\u0010\u0092\u0001R\u0018\u0010.\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b¤\u0001\u0010\u0092\u0001R\u0016\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¥\u0001\u0010zR\u0018\u00100\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010¡\u0001\u001a\u0006\b¦\u0001\u0010 \u0001R\u0016\u00101\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b§\u0001\u0010zR\u0018\u00102\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b¨\u0001\u0010\u0092\u0001R\u0016\u00103\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b©\u0001\u0010zR\u0016\u00104\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bª\u0001\u0010zR\u0016\u00105\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b«\u0001\u0010zR\u0016\u00106\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¬\u0001\u0010zR\u0018\u00107\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010¡\u0001\u001a\u0006\b\u00ad\u0001\u0010 \u0001R\u0016\u00108\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b®\u0001\u0010zR\u0016\u00109\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¯\u0001\u0010zR\u0016\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b°\u0001\u0010zR\u0016\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b±\u0001\u0010zR\u0016\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b²\u0001\u0010zR\u0016\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b³\u0001\u0010zR\u0016\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b´\u0001\u0010zR\u0016\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bµ\u0001\u0010zR\u0016\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¶\u0001\u0010zR\u0016\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b·\u0001\u0010zR\u0018\u0010B\u001a\u0004\u0018\u00010C¢\u0006\r\n\u0003\u0010º\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010D\u001a\u0004\u0018\u00010C¢\u0006\r\n\u0003\u0010º\u0001\u001a\u0006\b»\u0001\u0010¹\u0001R\u0016\u0010E\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¼\u0001\u0010zR\u0016\u0010F\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b½\u0001\u0010zR\u0016\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¾\u0001\u0010zR\u0015\u0010H\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010\u0086\u0001R\u0016\u0010I\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÀ\u0001\u0010zR\u0015\u0010J\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010\u0086\u0001R\u0016\u0010K\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÂ\u0001\u0010zR\u0018\u0010L\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÃ\u0001\u0010\u0092\u0001R\u0016\u0010M\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÄ\u0001\u0010zR\u0016\u0010N\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÅ\u0001\u0010zR\u0018\u0010O\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÆ\u0001\u0010\u0092\u0001R\u0016\u0010P\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÇ\u0001\u0010zR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÈ\u0001\u0010\u0092\u0001R\u0018\u0010R\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÉ\u0001\u0010\u0092\u0001R\u0016\u0010S\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÊ\u0001\u0010zR\u0016\u0010T\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bË\u0001\u0010zR\u0018\u0010U\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÌ\u0001\u0010\u0092\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÍ\u0001\u0010\u0092\u0001R\u0016\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÎ\u0001\u0010zR\u0016\u0010X\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÏ\u0001\u0010zR\u0016\u0010Y\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÐ\u0001\u0010zR\u0016\u0010Z\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÑ\u0001\u0010zR\u0016\u0010[\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÒ\u0001\u0010zR\u0016\u0010\\\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÓ\u0001\u0010zR\u0016\u0010]\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÔ\u0001\u0010zR\u0016\u0010^\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÕ\u0001\u0010zR\u0016\u0010_\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÖ\u0001\u0010zR\u0018\u0010`\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\b×\u0001\u0010\u0092\u0001R\u0018\u0010a\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bØ\u0001\u0010\u0092\u0001R\u0016\u0010b\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÙ\u0001\u0010zR\u001d\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u0016\u0010f\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bÜ\u0001\u0010zR\u0018\u0010g\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÝ\u0001\u0010\u0092\u0001R\u0018\u0010h\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0093\u0001\u001a\u0006\bÞ\u0001\u0010\u0092\u0001R\u0016\u0010i\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bß\u0001\u0010zR\u0016\u0010j\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bà\u0001\u0010zR\u0016\u0010k\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bá\u0001\u0010zR\u0018\u0010l\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010¡\u0001\u001a\u0006\bâ\u0001\u0010 \u0001R\u0015\u0010m\u001a\u0004\u0018\u00010n¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010ä\u0001R\u0016\u0010o\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\bå\u0001\u0010zR\u0015\u0010p\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010\u0086\u0001¨\u0006Ñ\u0002"},
      d2 = {"Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "", "uuid", "", "deviceType", "mcuFirmware", "wifiFirmare", "hardware", "connectivityStatus", "", "latestSensorDataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "fanSpeed", "brightness", "childlock", "", "autoMode", "filter", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "standByMode", "ecoMode", "hinsMode", "hinsNightMode", "g4NightMode", "germShieldMode", "germShieldNightMode", "serialNumber", "name", "autoModeTrigger", "nightModeTrigger", "safetySwitch", "macAddress", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "locationId", "disinfection", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "", "timezone", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "mode", "humMode", "waterLevel", "dehSubMode", "waterTankFailure", "smartSubMode", "detectCat", "bodyMounted", "cleanAirEta", "panelDisplayMode", "hoverEnabled", "airRefreshEnabled", "airRefreshStatus", "airRefreshDuration", "airRefreshTimeStamp", "airRefreshStartTimeStamp", "airRefreshEndTimeStamp", "roomType", "nightLampBrightness", "nightLampSteplessBrightness", "wickdryDuration", "wickdryDone", "ywrmEnabled", "ywrmUsage", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "humSubMode", "use24Hour", "waterInfill", "sensorMode", "coolFanSpeedLevel", "coolAutoLevel", "nightModeStartTime", "dualOscillationConfig", "Lcom/blueair/core/model/DualOscillationConfig;", "rpm", "nightPeriods", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/blueair/core/model/IndoorDatapoint;IIZZLjava/lang/Integer;[D[D[D[D[DZZZZZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;[DLjava/lang/Integer;[DLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/blueair/core/model/DualOscillationConfig;Ljava/lang/Integer;[D)V", "getUuid", "()Ljava/lang/String;", "getDeviceType", "getMcuFirmware", "getWifiFirmare", "getHardware", "getConnectivityStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLatestSensorDataPoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getFanSpeed", "()I", "getBrightness", "getChildlock", "()Z", "getAutoMode", "getFilter", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getStandByMode", "getEcoMode", "getHinsMode", "getHinsNightMode", "getG4NightMode", "getGermShieldMode", "getGermShieldNightMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSerialNumber", "getName", "getAutoModeTrigger", "getNightModeTrigger", "getSafetySwitch", "getMacAddress", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getLocationId", "getDisinfection", "getDisinfectLeftTime", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimezone", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getMode", "getHumMode", "getWaterLevel", "getDehSubMode", "getWaterTankFailure", "getSmartSubMode", "getDetectCat", "getBodyMounted", "getCleanAirEta", "getPanelDisplayMode", "getHoverEnabled", "getAirRefreshEnabled", "getAirRefreshStatus", "getAirRefreshDuration", "getAirRefreshTimeStamp", "getAirRefreshStartTimeStamp", "getAirRefreshEndTimeStamp", "getRoomType", "getNightLampBrightness", "getNightLampSteplessBrightness", "getWickdryDuration", "getWickdryDone", "getYwrmEnabled", "getYwrmUsage", "getAlarms", "()Ljava/util/List;", "getHumSubMode", "getUse24Hour", "getWaterInfill", "getSensorMode", "getCoolFanSpeedLevel", "getCoolAutoLevel", "getNightModeStartTime", "getDualOscillationConfig", "()Lcom/blueair/core/model/DualOscillationConfig;", "getRpm", "getNightPeriods", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/blueair/core/model/IndoorDatapoint;IIZZLjava/lang/Integer;[D[D[D[D[DZZZZZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;[DLjava/lang/Integer;[DLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/blueair/core/model/DualOscillationConfig;Ljava/lang/Integer;[D)Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "equals", "other", "hashCode", "toString", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceDataOnBlue {
      private final Integer airRefreshDuration;
      private final Boolean airRefreshEnabled;
      private final Integer airRefreshEndTimeStamp;
      private final Integer airRefreshStartTimeStamp;
      private final Integer airRefreshStatus;
      private final Integer airRefreshTimeStamp;
      private final List alarms;
      private final Integer apFanSpeed;
      private final Integer apSubMode;
      private final boolean autoMode;
      private final String autoModeTrigger;
      private final Integer autoRh;
      private final Boolean bodyMounted;
      private final int brightness;
      private final boolean childlock;
      private final Integer cleanAirEta;
      private final Integer connectivityStatus;
      private final Integer coolAutoLevel;
      private final double[] coolAutoPresets;
      private final Integer coolAutoTag;
      private final double[] coolEcoPresets;
      private final Integer coolEcoTag;
      private final Integer coolFanSpeed;
      private final Integer coolFanSpeedLevel;
      private final Integer coolSubMode;
      private final Integer dehSubMode;
      private final Boolean detectCat;
      private final String deviceType;
      private final Integer disinfectLeftTime;
      private final Long disinfectLeftTimeUpdateTime;
      private final Boolean disinfection;
      private final DualOscillationConfig dualOscillationConfig;
      private final boolean ecoMode;
      private final int fanSpeed;
      private final Integer filter;
      private final boolean g4NightMode;
      private final boolean germShieldMode;
      private final Boolean germShieldNightMode;
      private final String hardware;
      private final double[] hchoRanges;
      private final Double heatAutoTmp;
      private final Double heatEcoTmp;
      private final Integer heatFanSpeed;
      private final Integer heatSubMode;
      private final boolean hinsMode;
      private final boolean hinsNightMode;
      private final Boolean hoverEnabled;
      private final Boolean humMode;
      private final Integer humSubMode;
      private final IndoorDatapoint latestSensorDataPoint;
      private final String locationId;
      private final String macAddress;
      private final Integer mainMode;
      private final String mcuFirmware;
      private final Integer mode;
      private final String name;
      private final Integer nightLampBrightness;
      private final Integer nightLampSteplessBrightness;
      private final Long nightModeStartTime;
      private final String nightModeTrigger;
      private final double[] nightPeriods;
      private final Integer oscillationAngle;
      private final Integer oscillationDirection;
      private final Integer oscillationFanSpeed;
      private final Integer oscillationState;
      private final Integer panelDisplayMode;
      private final double[] pm10Ranges;
      private final double[] pm1Ranges;
      private final double[] pm25Ranges;
      private final Integer roomType;
      private final Integer rpm;
      private final boolean safetySwitch;
      private final Integer sensorMode;
      private final String serialNumber;
      private final Integer smartSubMode;
      private final boolean standByMode;
      private final Integer temperatureUnit;
      private final Integer timerDuration;
      private final Integer timerLeftTime;
      private final Long timerLeftTimeUpdateTime;
      private final Integer timerStatus;
      private final String timezone;
      private final Boolean use24Hour;
      private final String uuid;
      private final double[] vocRanges;
      private final Boolean waterInfill;
      private final Integer waterLevel;
      private final Boolean waterShortage;
      private final Boolean waterTankFailure;
      private final WelcomeHomeLocation welcomeHome;
      private final Integer wickUsage;
      private final Boolean wickdryDone;
      private final Integer wickdryDuration;
      private final Boolean wickdryEnabled;
      private final Integer wickdryLeftTime;
      private final Long wickdryLeftTimeUpdateTime;
      private final Boolean wickdryOn;
      private final String wifiFirmare;
      private final Boolean ywrmEnabled;
      private final Integer ywrmUsage;

      public DeviceDataOnBlue(String var1, String var2, String var3, String var4, String var5, Integer var6, IndoorDatapoint var7, int var8, int var9, boolean var10, boolean var11, Integer var12, double[] var13, double[] var14, double[] var15, double[] var16, double[] var17, boolean var18, boolean var19, boolean var20, boolean var21, boolean var22, boolean var23, Boolean var24, String var25, String var26, String var27, String var28, boolean var29, String var30, WelcomeHomeLocation var31, String var32, Boolean var33, Integer var34, Long var35, String var36, Boolean var37, Boolean var38, Integer var39, Long var40, Integer var41, Boolean var42, Integer var43, Integer var44, Integer var45, Integer var46, Long var47, Integer var48, Integer var49, Integer var50, Integer var51, Integer var52, Integer var53, Integer var54, Integer var55, Integer var56, Integer var57, Double var58, Double var59, Integer var60, Integer var61, Integer var62, double[] var63, Integer var64, double[] var65, Integer var66, Boolean var67, Integer var68, Integer var69, Boolean var70, Integer var71, Boolean var72, Boolean var73, Integer var74, Integer var75, Boolean var76, Boolean var77, Integer var78, Integer var79, Integer var80, Integer var81, Integer var82, Integer var83, Integer var84, Integer var85, Integer var86, Boolean var87, Boolean var88, Integer var89, List var90, Integer var91, Boolean var92, Boolean var93, Integer var94, Integer var95, Integer var96, Long var97, DualOscillationConfig var98, Integer var99, double[] var100) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         Intrinsics.checkNotNullParameter(var13, "pm1Ranges");
         Intrinsics.checkNotNullParameter(var14, "pm10Ranges");
         Intrinsics.checkNotNullParameter(var15, "pm25Ranges");
         Intrinsics.checkNotNullParameter(var16, "vocRanges");
         Intrinsics.checkNotNullParameter(var17, "hchoRanges");
         super();
         this.uuid = var1;
         this.deviceType = var2;
         this.mcuFirmware = var3;
         this.wifiFirmare = var4;
         this.hardware = var5;
         this.connectivityStatus = var6;
         this.latestSensorDataPoint = var7;
         this.fanSpeed = var8;
         this.brightness = var9;
         this.childlock = var10;
         this.autoMode = var11;
         this.filter = var12;
         this.pm1Ranges = var13;
         this.pm10Ranges = var14;
         this.pm25Ranges = var15;
         this.vocRanges = var16;
         this.hchoRanges = var17;
         this.standByMode = var18;
         this.ecoMode = var19;
         this.hinsMode = var20;
         this.hinsNightMode = var21;
         this.g4NightMode = var22;
         this.germShieldMode = var23;
         this.germShieldNightMode = var24;
         this.serialNumber = var25;
         this.name = var26;
         this.autoModeTrigger = var27;
         this.nightModeTrigger = var28;
         this.safetySwitch = var29;
         this.macAddress = var30;
         this.welcomeHome = var31;
         this.locationId = var32;
         this.disinfection = var33;
         this.disinfectLeftTime = var34;
         this.disinfectLeftTimeUpdateTime = var35;
         this.timezone = var36;
         this.wickdryEnabled = var37;
         this.wickdryOn = var38;
         this.wickdryLeftTime = var39;
         this.wickdryLeftTimeUpdateTime = var40;
         this.wickUsage = var41;
         this.waterShortage = var42;
         this.autoRh = var43;
         this.timerStatus = var44;
         this.timerDuration = var45;
         this.timerLeftTime = var46;
         this.timerLeftTimeUpdateTime = var47;
         this.temperatureUnit = var48;
         this.oscillationState = var49;
         this.oscillationAngle = var50;
         this.oscillationDirection = var51;
         this.oscillationFanSpeed = var52;
         this.mainMode = var53;
         this.apSubMode = var54;
         this.apFanSpeed = var55;
         this.heatSubMode = var56;
         this.heatFanSpeed = var57;
         this.heatAutoTmp = var58;
         this.heatEcoTmp = var59;
         this.coolSubMode = var60;
         this.coolFanSpeed = var61;
         this.coolAutoTag = var62;
         this.coolAutoPresets = var63;
         this.coolEcoTag = var64;
         this.coolEcoPresets = var65;
         this.mode = var66;
         this.humMode = var67;
         this.waterLevel = var68;
         this.dehSubMode = var69;
         this.waterTankFailure = var70;
         this.smartSubMode = var71;
         this.detectCat = var72;
         this.bodyMounted = var73;
         this.cleanAirEta = var74;
         this.panelDisplayMode = var75;
         this.hoverEnabled = var76;
         this.airRefreshEnabled = var77;
         this.airRefreshStatus = var78;
         this.airRefreshDuration = var79;
         this.airRefreshTimeStamp = var80;
         this.airRefreshStartTimeStamp = var81;
         this.airRefreshEndTimeStamp = var82;
         this.roomType = var83;
         this.nightLampBrightness = var84;
         this.nightLampSteplessBrightness = var85;
         this.wickdryDuration = var86;
         this.wickdryDone = var87;
         this.ywrmEnabled = var88;
         this.ywrmUsage = var89;
         this.alarms = var90;
         this.humSubMode = var91;
         this.use24Hour = var92;
         this.waterInfill = var93;
         this.sensorMode = var94;
         this.coolFanSpeedLevel = var95;
         this.coolAutoLevel = var96;
         this.nightModeStartTime = var97;
         this.dualOscillationConfig = var98;
         this.rpm = var99;
         this.nightPeriods = var100;
      }

      // $FF: synthetic method
      public static DeviceDataOnBlue copy$default(DeviceDataOnBlue var0, String var1, String var2, String var3, String var4, String var5, Integer var6, IndoorDatapoint var7, int var8, int var9, boolean var10, boolean var11, Integer var12, double[] var13, double[] var14, double[] var15, double[] var16, double[] var17, boolean var18, boolean var19, boolean var20, boolean var21, boolean var22, boolean var23, Boolean var24, String var25, String var26, String var27, String var28, boolean var29, String var30, WelcomeHomeLocation var31, String var32, Boolean var33, Integer var34, Long var35, String var36, Boolean var37, Boolean var38, Integer var39, Long var40, Integer var41, Boolean var42, Integer var43, Integer var44, Integer var45, Integer var46, Long var47, Integer var48, Integer var49, Integer var50, Integer var51, Integer var52, Integer var53, Integer var54, Integer var55, Integer var56, Integer var57, Double var58, Double var59, Integer var60, Integer var61, Integer var62, double[] var63, Integer var64, double[] var65, Integer var66, Boolean var67, Integer var68, Integer var69, Boolean var70, Integer var71, Boolean var72, Boolean var73, Integer var74, Integer var75, Boolean var76, Boolean var77, Integer var78, Integer var79, Integer var80, Integer var81, Integer var82, Integer var83, Integer var84, Integer var85, Integer var86, Boolean var87, Boolean var88, Integer var89, List var90, Integer var91, Boolean var92, Boolean var93, Integer var94, Integer var95, Integer var96, Long var97, DualOscillationConfig var98, Integer var99, double[] var100, int var101, int var102, int var103, int var104, Object var105) {
         if ((var101 & 1) != 0) {
            var1 = var0.uuid;
         }

         if ((var101 & 2) != 0) {
            var2 = var0.deviceType;
         }

         if ((var101 & 4) != 0) {
            var3 = var0.mcuFirmware;
         }

         if ((var101 & 8) != 0) {
            var4 = var0.wifiFirmare;
         }

         if ((var101 & 16) != 0) {
            var5 = var0.hardware;
         }

         if ((var101 & 32) != 0) {
            var6 = var0.connectivityStatus;
         }

         if ((var101 & 64) != 0) {
            var7 = var0.latestSensorDataPoint;
         }

         if ((var101 & 128) != 0) {
            var8 = var0.fanSpeed;
         }

         if ((var101 & 256) != 0) {
            var9 = var0.brightness;
         }

         if ((var101 & 512) != 0) {
            var10 = var0.childlock;
         }

         if ((var101 & 1024) != 0) {
            var11 = var0.autoMode;
         }

         if ((var101 & 2048) != 0) {
            var12 = var0.filter;
         }

         if ((var101 & 4096) != 0) {
            var13 = var0.pm1Ranges;
         }

         if ((var101 & 8192) != 0) {
            var14 = var0.pm10Ranges;
         }

         if ((var101 & 16384) != 0) {
            var15 = var0.pm25Ranges;
         }

         if ((var101 & '耀') != 0) {
            var16 = var0.vocRanges;
         }

         if ((var101 & 65536) != 0) {
            var17 = var0.hchoRanges;
         }

         if ((var101 & 131072) != 0) {
            var18 = var0.standByMode;
         }

         if ((var101 & 262144) != 0) {
            var19 = var0.ecoMode;
         }

         if ((var101 & 524288) != 0) {
            var20 = var0.hinsMode;
         }

         if ((var101 & 1048576) != 0) {
            var21 = var0.hinsNightMode;
         }

         if ((var101 & 2097152) != 0) {
            var22 = var0.g4NightMode;
         }

         if ((var101 & 4194304) != 0) {
            var23 = var0.germShieldMode;
         }

         if ((var101 & 8388608) != 0) {
            var24 = var0.germShieldNightMode;
         }

         if ((var101 & 16777216) != 0) {
            var25 = var0.serialNumber;
         }

         if ((var101 & 33554432) != 0) {
            var26 = var0.name;
         }

         if ((var101 & 67108864) != 0) {
            var27 = var0.autoModeTrigger;
         }

         if ((var101 & 134217728) != 0) {
            var28 = var0.nightModeTrigger;
         }

         if ((var101 & 268435456) != 0) {
            var29 = var0.safetySwitch;
         }

         if ((var101 & 536870912) != 0) {
            var30 = var0.macAddress;
         }

         if ((var101 & 1073741824) != 0) {
            var31 = var0.welcomeHome;
         }

         if ((var101 & Integer.MIN_VALUE) != 0) {
            var32 = var0.locationId;
         }

         if ((var102 & 1) != 0) {
            var33 = var0.disinfection;
         }

         if ((var102 & 2) != 0) {
            var34 = var0.disinfectLeftTime;
         }

         if ((var102 & 4) != 0) {
            var35 = var0.disinfectLeftTimeUpdateTime;
         }

         if ((var102 & 8) != 0) {
            var36 = var0.timezone;
         }

         if ((var102 & 16) != 0) {
            var37 = var0.wickdryEnabled;
         }

         if ((var102 & 32) != 0) {
            var38 = var0.wickdryOn;
         }

         if ((var102 & 64) != 0) {
            var39 = var0.wickdryLeftTime;
         }

         if ((var102 & 128) != 0) {
            var40 = var0.wickdryLeftTimeUpdateTime;
         }

         if ((var102 & 256) != 0) {
            var41 = var0.wickUsage;
         }

         if ((var102 & 512) != 0) {
            var42 = var0.waterShortage;
         }

         if ((var102 & 1024) != 0) {
            var43 = var0.autoRh;
         }

         if ((var102 & 2048) != 0) {
            var44 = var0.timerStatus;
         }

         if ((var102 & 4096) != 0) {
            var45 = var0.timerDuration;
         }

         if ((var102 & 8192) != 0) {
            var46 = var0.timerLeftTime;
         }

         if ((var102 & 16384) != 0) {
            var47 = var0.timerLeftTimeUpdateTime;
         }

         if ((var102 & '耀') != 0) {
            var48 = var0.temperatureUnit;
         }

         if ((var102 & 65536) != 0) {
            var49 = var0.oscillationState;
         }

         if ((var102 & 131072) != 0) {
            var50 = var0.oscillationAngle;
         }

         if ((var102 & 262144) != 0) {
            var51 = var0.oscillationDirection;
         }

         if ((var102 & 524288) != 0) {
            var52 = var0.oscillationFanSpeed;
         }

         if ((var102 & 1048576) != 0) {
            var53 = var0.mainMode;
         }

         if ((var102 & 2097152) != 0) {
            var54 = var0.apSubMode;
         }

         if ((var102 & 4194304) != 0) {
            var55 = var0.apFanSpeed;
         }

         if ((var102 & 8388608) != 0) {
            var56 = var0.heatSubMode;
         }

         if ((var102 & 16777216) != 0) {
            var57 = var0.heatFanSpeed;
         }

         if ((var102 & 33554432) != 0) {
            var58 = var0.heatAutoTmp;
         }

         if ((var102 & 67108864) != 0) {
            var59 = var0.heatEcoTmp;
         }

         if ((var102 & 134217728) != 0) {
            var60 = var0.coolSubMode;
         }

         if ((var102 & 268435456) != 0) {
            var61 = var0.coolFanSpeed;
         }

         if ((var102 & 536870912) != 0) {
            var62 = var0.coolAutoTag;
         }

         if ((var102 & 1073741824) != 0) {
            var63 = var0.coolAutoPresets;
         }

         if ((var102 & Integer.MIN_VALUE) != 0) {
            var64 = var0.coolEcoTag;
         }

         if ((var103 & 1) != 0) {
            var65 = var0.coolEcoPresets;
         }

         if ((var103 & 2) != 0) {
            var66 = var0.mode;
         }

         if ((var103 & 4) != 0) {
            var67 = var0.humMode;
         }

         if ((var103 & 8) != 0) {
            var68 = var0.waterLevel;
         }

         if ((var103 & 16) != 0) {
            var69 = var0.dehSubMode;
         }

         if ((var103 & 32) != 0) {
            var70 = var0.waterTankFailure;
         }

         if ((var103 & 64) != 0) {
            var71 = var0.smartSubMode;
         }

         if ((var103 & 128) != 0) {
            var72 = var0.detectCat;
         }

         if ((var103 & 256) != 0) {
            var73 = var0.bodyMounted;
         }

         if ((var103 & 512) != 0) {
            var74 = var0.cleanAirEta;
         }

         if ((var103 & 1024) != 0) {
            var75 = var0.panelDisplayMode;
         }

         if ((var103 & 2048) != 0) {
            var76 = var0.hoverEnabled;
         }

         if ((var103 & 4096) != 0) {
            var77 = var0.airRefreshEnabled;
         }

         if ((var103 & 8192) != 0) {
            var78 = var0.airRefreshStatus;
         }

         if ((var103 & 16384) != 0) {
            var79 = var0.airRefreshDuration;
         }

         if ((var103 & '耀') != 0) {
            var80 = var0.airRefreshTimeStamp;
         }

         if ((var103 & 65536) != 0) {
            var81 = var0.airRefreshStartTimeStamp;
         }

         if ((var103 & 131072) != 0) {
            var82 = var0.airRefreshEndTimeStamp;
         }

         if ((var103 & 262144) != 0) {
            var83 = var0.roomType;
         }

         if ((var103 & 524288) != 0) {
            var84 = var0.nightLampBrightness;
         }

         if ((var103 & 1048576) != 0) {
            var85 = var0.nightLampSteplessBrightness;
         }

         if ((var103 & 2097152) != 0) {
            var86 = var0.wickdryDuration;
         }

         if ((var103 & 4194304) != 0) {
            var87 = var0.wickdryDone;
         }

         if ((var103 & 8388608) != 0) {
            var88 = var0.ywrmEnabled;
         }

         if ((var103 & 16777216) != 0) {
            var89 = var0.ywrmUsage;
         }

         if ((var103 & 33554432) != 0) {
            var90 = var0.alarms;
         }

         if ((var103 & 67108864) != 0) {
            var91 = var0.humSubMode;
         }

         if ((var103 & 134217728) != 0) {
            var92 = var0.use24Hour;
         }

         if ((var103 & 268435456) != 0) {
            var93 = var0.waterInfill;
         }

         if ((var103 & 536870912) != 0) {
            var94 = var0.sensorMode;
         }

         if ((var103 & 1073741824) != 0) {
            var95 = var0.coolFanSpeedLevel;
         }

         if ((var103 & Integer.MIN_VALUE) != 0) {
            var96 = var0.coolAutoLevel;
         }

         if ((var104 & 1) != 0) {
            var97 = var0.nightModeStartTime;
         }

         if ((var104 & 2) != 0) {
            var98 = var0.dualOscillationConfig;
         }

         if ((var104 & 4) != 0) {
            var99 = var0.rpm;
         }

         if ((var104 & 8) != 0) {
            var100 = var0.nightPeriods;
         }

         return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100);
      }

      public final String component1() {
         return this.uuid;
      }

      public final boolean component10() {
         return this.childlock;
      }

      public final double[] component100() {
         return this.nightPeriods;
      }

      public final boolean component11() {
         return this.autoMode;
      }

      public final Integer component12() {
         return this.filter;
      }

      public final double[] component13() {
         return this.pm1Ranges;
      }

      public final double[] component14() {
         return this.pm10Ranges;
      }

      public final double[] component15() {
         return this.pm25Ranges;
      }

      public final double[] component16() {
         return this.vocRanges;
      }

      public final double[] component17() {
         return this.hchoRanges;
      }

      public final boolean component18() {
         return this.standByMode;
      }

      public final boolean component19() {
         return this.ecoMode;
      }

      public final String component2() {
         return this.deviceType;
      }

      public final boolean component20() {
         return this.hinsMode;
      }

      public final boolean component21() {
         return this.hinsNightMode;
      }

      public final boolean component22() {
         return this.g4NightMode;
      }

      public final boolean component23() {
         return this.germShieldMode;
      }

      public final Boolean component24() {
         return this.germShieldNightMode;
      }

      public final String component25() {
         return this.serialNumber;
      }

      public final String component26() {
         return this.name;
      }

      public final String component27() {
         return this.autoModeTrigger;
      }

      public final String component28() {
         return this.nightModeTrigger;
      }

      public final boolean component29() {
         return this.safetySwitch;
      }

      public final String component3() {
         return this.mcuFirmware;
      }

      public final String component30() {
         return this.macAddress;
      }

      public final WelcomeHomeLocation component31() {
         return this.welcomeHome;
      }

      public final String component32() {
         return this.locationId;
      }

      public final Boolean component33() {
         return this.disinfection;
      }

      public final Integer component34() {
         return this.disinfectLeftTime;
      }

      public final Long component35() {
         return this.disinfectLeftTimeUpdateTime;
      }

      public final String component36() {
         return this.timezone;
      }

      public final Boolean component37() {
         return this.wickdryEnabled;
      }

      public final Boolean component38() {
         return this.wickdryOn;
      }

      public final Integer component39() {
         return this.wickdryLeftTime;
      }

      public final String component4() {
         return this.wifiFirmare;
      }

      public final Long component40() {
         return this.wickdryLeftTimeUpdateTime;
      }

      public final Integer component41() {
         return this.wickUsage;
      }

      public final Boolean component42() {
         return this.waterShortage;
      }

      public final Integer component43() {
         return this.autoRh;
      }

      public final Integer component44() {
         return this.timerStatus;
      }

      public final Integer component45() {
         return this.timerDuration;
      }

      public final Integer component46() {
         return this.timerLeftTime;
      }

      public final Long component47() {
         return this.timerLeftTimeUpdateTime;
      }

      public final Integer component48() {
         return this.temperatureUnit;
      }

      public final Integer component49() {
         return this.oscillationState;
      }

      public final String component5() {
         return this.hardware;
      }

      public final Integer component50() {
         return this.oscillationAngle;
      }

      public final Integer component51() {
         return this.oscillationDirection;
      }

      public final Integer component52() {
         return this.oscillationFanSpeed;
      }

      public final Integer component53() {
         return this.mainMode;
      }

      public final Integer component54() {
         return this.apSubMode;
      }

      public final Integer component55() {
         return this.apFanSpeed;
      }

      public final Integer component56() {
         return this.heatSubMode;
      }

      public final Integer component57() {
         return this.heatFanSpeed;
      }

      public final Double component58() {
         return this.heatAutoTmp;
      }

      public final Double component59() {
         return this.heatEcoTmp;
      }

      public final Integer component6() {
         return this.connectivityStatus;
      }

      public final Integer component60() {
         return this.coolSubMode;
      }

      public final Integer component61() {
         return this.coolFanSpeed;
      }

      public final Integer component62() {
         return this.coolAutoTag;
      }

      public final double[] component63() {
         return this.coolAutoPresets;
      }

      public final Integer component64() {
         return this.coolEcoTag;
      }

      public final double[] component65() {
         return this.coolEcoPresets;
      }

      public final Integer component66() {
         return this.mode;
      }

      public final Boolean component67() {
         return this.humMode;
      }

      public final Integer component68() {
         return this.waterLevel;
      }

      public final Integer component69() {
         return this.dehSubMode;
      }

      public final IndoorDatapoint component7() {
         return this.latestSensorDataPoint;
      }

      public final Boolean component70() {
         return this.waterTankFailure;
      }

      public final Integer component71() {
         return this.smartSubMode;
      }

      public final Boolean component72() {
         return this.detectCat;
      }

      public final Boolean component73() {
         return this.bodyMounted;
      }

      public final Integer component74() {
         return this.cleanAirEta;
      }

      public final Integer component75() {
         return this.panelDisplayMode;
      }

      public final Boolean component76() {
         return this.hoverEnabled;
      }

      public final Boolean component77() {
         return this.airRefreshEnabled;
      }

      public final Integer component78() {
         return this.airRefreshStatus;
      }

      public final Integer component79() {
         return this.airRefreshDuration;
      }

      public final int component8() {
         return this.fanSpeed;
      }

      public final Integer component80() {
         return this.airRefreshTimeStamp;
      }

      public final Integer component81() {
         return this.airRefreshStartTimeStamp;
      }

      public final Integer component82() {
         return this.airRefreshEndTimeStamp;
      }

      public final Integer component83() {
         return this.roomType;
      }

      public final Integer component84() {
         return this.nightLampBrightness;
      }

      public final Integer component85() {
         return this.nightLampSteplessBrightness;
      }

      public final Integer component86() {
         return this.wickdryDuration;
      }

      public final Boolean component87() {
         return this.wickdryDone;
      }

      public final Boolean component88() {
         return this.ywrmEnabled;
      }

      public final Integer component89() {
         return this.ywrmUsage;
      }

      public final int component9() {
         return this.brightness;
      }

      public final List component90() {
         return this.alarms;
      }

      public final Integer component91() {
         return this.humSubMode;
      }

      public final Boolean component92() {
         return this.use24Hour;
      }

      public final Boolean component93() {
         return this.waterInfill;
      }

      public final Integer component94() {
         return this.sensorMode;
      }

      public final Integer component95() {
         return this.coolFanSpeedLevel;
      }

      public final Integer component96() {
         return this.coolAutoLevel;
      }

      public final Long component97() {
         return this.nightModeStartTime;
      }

      public final DualOscillationConfig component98() {
         return this.dualOscillationConfig;
      }

      public final Integer component99() {
         return this.rpm;
      }

      public final DeviceDataOnBlue copy(String var1, String var2, String var3, String var4, String var5, Integer var6, IndoorDatapoint var7, int var8, int var9, boolean var10, boolean var11, Integer var12, double[] var13, double[] var14, double[] var15, double[] var16, double[] var17, boolean var18, boolean var19, boolean var20, boolean var21, boolean var22, boolean var23, Boolean var24, String var25, String var26, String var27, String var28, boolean var29, String var30, WelcomeHomeLocation var31, String var32, Boolean var33, Integer var34, Long var35, String var36, Boolean var37, Boolean var38, Integer var39, Long var40, Integer var41, Boolean var42, Integer var43, Integer var44, Integer var45, Integer var46, Long var47, Integer var48, Integer var49, Integer var50, Integer var51, Integer var52, Integer var53, Integer var54, Integer var55, Integer var56, Integer var57, Double var58, Double var59, Integer var60, Integer var61, Integer var62, double[] var63, Integer var64, double[] var65, Integer var66, Boolean var67, Integer var68, Integer var69, Boolean var70, Integer var71, Boolean var72, Boolean var73, Integer var74, Integer var75, Boolean var76, Boolean var77, Integer var78, Integer var79, Integer var80, Integer var81, Integer var82, Integer var83, Integer var84, Integer var85, Integer var86, Boolean var87, Boolean var88, Integer var89, List var90, Integer var91, Boolean var92, Boolean var93, Integer var94, Integer var95, Integer var96, Long var97, DualOscillationConfig var98, Integer var99, double[] var100) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         Intrinsics.checkNotNullParameter(var13, "pm1Ranges");
         Intrinsics.checkNotNullParameter(var14, "pm10Ranges");
         Intrinsics.checkNotNullParameter(var15, "pm25Ranges");
         Intrinsics.checkNotNullParameter(var16, "vocRanges");
         Intrinsics.checkNotNullParameter(var17, "hchoRanges");
         return new DeviceDataOnBlue(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DeviceDataOnBlue)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
               return false;
            } else if (!Intrinsics.areEqual(this.deviceType, var1.deviceType)) {
               return false;
            } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wifiFirmare, var1.wifiFirmare)) {
               return false;
            } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
               return false;
            } else if (!Intrinsics.areEqual(this.connectivityStatus, var1.connectivityStatus)) {
               return false;
            } else if (!Intrinsics.areEqual(this.latestSensorDataPoint, var1.latestSensorDataPoint)) {
               return false;
            } else if (this.fanSpeed != var1.fanSpeed) {
               return false;
            } else if (this.brightness != var1.brightness) {
               return false;
            } else if (this.childlock != var1.childlock) {
               return false;
            } else if (this.autoMode != var1.autoMode) {
               return false;
            } else if (!Intrinsics.areEqual(this.filter, var1.filter)) {
               return false;
            } else if (!Intrinsics.areEqual(this.pm1Ranges, var1.pm1Ranges)) {
               return false;
            } else if (!Intrinsics.areEqual(this.pm10Ranges, var1.pm10Ranges)) {
               return false;
            } else if (!Intrinsics.areEqual(this.pm25Ranges, var1.pm25Ranges)) {
               return false;
            } else if (!Intrinsics.areEqual(this.vocRanges, var1.vocRanges)) {
               return false;
            } else if (!Intrinsics.areEqual(this.hchoRanges, var1.hchoRanges)) {
               return false;
            } else if (this.standByMode != var1.standByMode) {
               return false;
            } else if (this.ecoMode != var1.ecoMode) {
               return false;
            } else if (this.hinsMode != var1.hinsMode) {
               return false;
            } else if (this.hinsNightMode != var1.hinsNightMode) {
               return false;
            } else if (this.g4NightMode != var1.g4NightMode) {
               return false;
            } else if (this.germShieldMode != var1.germShieldMode) {
               return false;
            } else if (!Intrinsics.areEqual(this.germShieldNightMode, var1.germShieldNightMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.serialNumber, var1.serialNumber)) {
               return false;
            } else if (!Intrinsics.areEqual(this.name, var1.name)) {
               return false;
            } else if (!Intrinsics.areEqual(this.autoModeTrigger, var1.autoModeTrigger)) {
               return false;
            } else if (!Intrinsics.areEqual(this.nightModeTrigger, var1.nightModeTrigger)) {
               return false;
            } else if (this.safetySwitch != var1.safetySwitch) {
               return false;
            } else if (!Intrinsics.areEqual(this.macAddress, var1.macAddress)) {
               return false;
            } else if (!Intrinsics.areEqual(this.welcomeHome, var1.welcomeHome)) {
               return false;
            } else if (!Intrinsics.areEqual(this.locationId, var1.locationId)) {
               return false;
            } else if (!Intrinsics.areEqual(this.disinfection, var1.disinfection)) {
               return false;
            } else if (!Intrinsics.areEqual(this.disinfectLeftTime, var1.disinfectLeftTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.disinfectLeftTimeUpdateTime, var1.disinfectLeftTimeUpdateTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.timezone, var1.timezone)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryEnabled, var1.wickdryEnabled)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryOn, var1.wickdryOn)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryLeftTime, var1.wickdryLeftTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryLeftTimeUpdateTime, var1.wickdryLeftTimeUpdateTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickUsage, var1.wickUsage)) {
               return false;
            } else if (!Intrinsics.areEqual(this.waterShortage, var1.waterShortage)) {
               return false;
            } else if (!Intrinsics.areEqual(this.autoRh, var1.autoRh)) {
               return false;
            } else if (!Intrinsics.areEqual(this.timerStatus, var1.timerStatus)) {
               return false;
            } else if (!Intrinsics.areEqual(this.timerDuration, var1.timerDuration)) {
               return false;
            } else if (!Intrinsics.areEqual(this.timerLeftTime, var1.timerLeftTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.timerLeftTimeUpdateTime, var1.timerLeftTimeUpdateTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.temperatureUnit, var1.temperatureUnit)) {
               return false;
            } else if (!Intrinsics.areEqual(this.oscillationState, var1.oscillationState)) {
               return false;
            } else if (!Intrinsics.areEqual(this.oscillationAngle, var1.oscillationAngle)) {
               return false;
            } else if (!Intrinsics.areEqual(this.oscillationDirection, var1.oscillationDirection)) {
               return false;
            } else if (!Intrinsics.areEqual(this.oscillationFanSpeed, var1.oscillationFanSpeed)) {
               return false;
            } else if (!Intrinsics.areEqual(this.mainMode, var1.mainMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.apSubMode, var1.apSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.apFanSpeed, var1.apFanSpeed)) {
               return false;
            } else if (!Intrinsics.areEqual(this.heatSubMode, var1.heatSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.heatFanSpeed, var1.heatFanSpeed)) {
               return false;
            } else if (!Intrinsics.areEqual(this.heatAutoTmp, var1.heatAutoTmp)) {
               return false;
            } else if (!Intrinsics.areEqual(this.heatEcoTmp, var1.heatEcoTmp)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolSubMode, var1.coolSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolFanSpeed, var1.coolFanSpeed)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolAutoTag, var1.coolAutoTag)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolAutoPresets, var1.coolAutoPresets)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolEcoTag, var1.coolEcoTag)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolEcoPresets, var1.coolEcoPresets)) {
               return false;
            } else if (!Intrinsics.areEqual(this.mode, var1.mode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.humMode, var1.humMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.waterLevel, var1.waterLevel)) {
               return false;
            } else if (!Intrinsics.areEqual(this.dehSubMode, var1.dehSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.waterTankFailure, var1.waterTankFailure)) {
               return false;
            } else if (!Intrinsics.areEqual(this.smartSubMode, var1.smartSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.detectCat, var1.detectCat)) {
               return false;
            } else if (!Intrinsics.areEqual(this.bodyMounted, var1.bodyMounted)) {
               return false;
            } else if (!Intrinsics.areEqual(this.cleanAirEta, var1.cleanAirEta)) {
               return false;
            } else if (!Intrinsics.areEqual(this.panelDisplayMode, var1.panelDisplayMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.hoverEnabled, var1.hoverEnabled)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshEnabled, var1.airRefreshEnabled)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshStatus, var1.airRefreshStatus)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshDuration, var1.airRefreshDuration)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshTimeStamp, var1.airRefreshTimeStamp)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshStartTimeStamp, var1.airRefreshStartTimeStamp)) {
               return false;
            } else if (!Intrinsics.areEqual(this.airRefreshEndTimeStamp, var1.airRefreshEndTimeStamp)) {
               return false;
            } else if (!Intrinsics.areEqual(this.roomType, var1.roomType)) {
               return false;
            } else if (!Intrinsics.areEqual(this.nightLampBrightness, var1.nightLampBrightness)) {
               return false;
            } else if (!Intrinsics.areEqual(this.nightLampSteplessBrightness, var1.nightLampSteplessBrightness)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryDuration, var1.wickdryDuration)) {
               return false;
            } else if (!Intrinsics.areEqual(this.wickdryDone, var1.wickdryDone)) {
               return false;
            } else if (!Intrinsics.areEqual(this.ywrmEnabled, var1.ywrmEnabled)) {
               return false;
            } else if (!Intrinsics.areEqual(this.ywrmUsage, var1.ywrmUsage)) {
               return false;
            } else if (!Intrinsics.areEqual(this.alarms, var1.alarms)) {
               return false;
            } else if (!Intrinsics.areEqual(this.humSubMode, var1.humSubMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.use24Hour, var1.use24Hour)) {
               return false;
            } else if (!Intrinsics.areEqual(this.waterInfill, var1.waterInfill)) {
               return false;
            } else if (!Intrinsics.areEqual(this.sensorMode, var1.sensorMode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolFanSpeedLevel, var1.coolFanSpeedLevel)) {
               return false;
            } else if (!Intrinsics.areEqual(this.coolAutoLevel, var1.coolAutoLevel)) {
               return false;
            } else if (!Intrinsics.areEqual(this.nightModeStartTime, var1.nightModeStartTime)) {
               return false;
            } else if (!Intrinsics.areEqual(this.dualOscillationConfig, var1.dualOscillationConfig)) {
               return false;
            } else if (!Intrinsics.areEqual(this.rpm, var1.rpm)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.nightPeriods, var1.nightPeriods);
            }
         }
      }

      public final Integer getAirRefreshDuration() {
         return this.airRefreshDuration;
      }

      public final Boolean getAirRefreshEnabled() {
         return this.airRefreshEnabled;
      }

      public final Integer getAirRefreshEndTimeStamp() {
         return this.airRefreshEndTimeStamp;
      }

      public final Integer getAirRefreshStartTimeStamp() {
         return this.airRefreshStartTimeStamp;
      }

      public final Integer getAirRefreshStatus() {
         return this.airRefreshStatus;
      }

      public final Integer getAirRefreshTimeStamp() {
         return this.airRefreshTimeStamp;
      }

      public final List getAlarms() {
         return this.alarms;
      }

      public final Integer getApFanSpeed() {
         return this.apFanSpeed;
      }

      public final Integer getApSubMode() {
         return this.apSubMode;
      }

      public final boolean getAutoMode() {
         return this.autoMode;
      }

      public final String getAutoModeTrigger() {
         return this.autoModeTrigger;
      }

      public final Integer getAutoRh() {
         return this.autoRh;
      }

      public final Boolean getBodyMounted() {
         return this.bodyMounted;
      }

      public final int getBrightness() {
         return this.brightness;
      }

      public final boolean getChildlock() {
         return this.childlock;
      }

      public final Integer getCleanAirEta() {
         return this.cleanAirEta;
      }

      public final Integer getConnectivityStatus() {
         return this.connectivityStatus;
      }

      public final Integer getCoolAutoLevel() {
         return this.coolAutoLevel;
      }

      public final double[] getCoolAutoPresets() {
         return this.coolAutoPresets;
      }

      public final Integer getCoolAutoTag() {
         return this.coolAutoTag;
      }

      public final double[] getCoolEcoPresets() {
         return this.coolEcoPresets;
      }

      public final Integer getCoolEcoTag() {
         return this.coolEcoTag;
      }

      public final Integer getCoolFanSpeed() {
         return this.coolFanSpeed;
      }

      public final Integer getCoolFanSpeedLevel() {
         return this.coolFanSpeedLevel;
      }

      public final Integer getCoolSubMode() {
         return this.coolSubMode;
      }

      public final Integer getDehSubMode() {
         return this.dehSubMode;
      }

      public final Boolean getDetectCat() {
         return this.detectCat;
      }

      public final String getDeviceType() {
         return this.deviceType;
      }

      public final Integer getDisinfectLeftTime() {
         return this.disinfectLeftTime;
      }

      public final Long getDisinfectLeftTimeUpdateTime() {
         return this.disinfectLeftTimeUpdateTime;
      }

      public final Boolean getDisinfection() {
         return this.disinfection;
      }

      public final DualOscillationConfig getDualOscillationConfig() {
         return this.dualOscillationConfig;
      }

      public final boolean getEcoMode() {
         return this.ecoMode;
      }

      public final int getFanSpeed() {
         return this.fanSpeed;
      }

      public final Integer getFilter() {
         return this.filter;
      }

      public final boolean getG4NightMode() {
         return this.g4NightMode;
      }

      public final boolean getGermShieldMode() {
         return this.germShieldMode;
      }

      public final Boolean getGermShieldNightMode() {
         return this.germShieldNightMode;
      }

      public final String getHardware() {
         return this.hardware;
      }

      public final double[] getHchoRanges() {
         return this.hchoRanges;
      }

      public final Double getHeatAutoTmp() {
         return this.heatAutoTmp;
      }

      public final Double getHeatEcoTmp() {
         return this.heatEcoTmp;
      }

      public final Integer getHeatFanSpeed() {
         return this.heatFanSpeed;
      }

      public final Integer getHeatSubMode() {
         return this.heatSubMode;
      }

      public final boolean getHinsMode() {
         return this.hinsMode;
      }

      public final boolean getHinsNightMode() {
         return this.hinsNightMode;
      }

      public final Boolean getHoverEnabled() {
         return this.hoverEnabled;
      }

      public final Boolean getHumMode() {
         return this.humMode;
      }

      public final Integer getHumSubMode() {
         return this.humSubMode;
      }

      public final IndoorDatapoint getLatestSensorDataPoint() {
         return this.latestSensorDataPoint;
      }

      public final String getLocationId() {
         return this.locationId;
      }

      public final String getMacAddress() {
         return this.macAddress;
      }

      public final Integer getMainMode() {
         return this.mainMode;
      }

      public final String getMcuFirmware() {
         return this.mcuFirmware;
      }

      public final Integer getMode() {
         return this.mode;
      }

      public final String getName() {
         return this.name;
      }

      public final Integer getNightLampBrightness() {
         return this.nightLampBrightness;
      }

      public final Integer getNightLampSteplessBrightness() {
         return this.nightLampSteplessBrightness;
      }

      public final Long getNightModeStartTime() {
         return this.nightModeStartTime;
      }

      public final String getNightModeTrigger() {
         return this.nightModeTrigger;
      }

      public final double[] getNightPeriods() {
         return this.nightPeriods;
      }

      public final Integer getOscillationAngle() {
         return this.oscillationAngle;
      }

      public final Integer getOscillationDirection() {
         return this.oscillationDirection;
      }

      public final Integer getOscillationFanSpeed() {
         return this.oscillationFanSpeed;
      }

      public final Integer getOscillationState() {
         return this.oscillationState;
      }

      public final Integer getPanelDisplayMode() {
         return this.panelDisplayMode;
      }

      public final double[] getPm10Ranges() {
         return this.pm10Ranges;
      }

      public final double[] getPm1Ranges() {
         return this.pm1Ranges;
      }

      public final double[] getPm25Ranges() {
         return this.pm25Ranges;
      }

      public final Integer getRoomType() {
         return this.roomType;
      }

      public final Integer getRpm() {
         return this.rpm;
      }

      public final boolean getSafetySwitch() {
         return this.safetySwitch;
      }

      public final Integer getSensorMode() {
         return this.sensorMode;
      }

      public final String getSerialNumber() {
         return this.serialNumber;
      }

      public final Integer getSmartSubMode() {
         return this.smartSubMode;
      }

      public final boolean getStandByMode() {
         return this.standByMode;
      }

      public final Integer getTemperatureUnit() {
         return this.temperatureUnit;
      }

      public final Integer getTimerDuration() {
         return this.timerDuration;
      }

      public final Integer getTimerLeftTime() {
         return this.timerLeftTime;
      }

      public final Long getTimerLeftTimeUpdateTime() {
         return this.timerLeftTimeUpdateTime;
      }

      public final Integer getTimerStatus() {
         return this.timerStatus;
      }

      public final String getTimezone() {
         return this.timezone;
      }

      public final Boolean getUse24Hour() {
         return this.use24Hour;
      }

      public final String getUuid() {
         return this.uuid;
      }

      public final double[] getVocRanges() {
         return this.vocRanges;
      }

      public final Boolean getWaterInfill() {
         return this.waterInfill;
      }

      public final Integer getWaterLevel() {
         return this.waterLevel;
      }

      public final Boolean getWaterShortage() {
         return this.waterShortage;
      }

      public final Boolean getWaterTankFailure() {
         return this.waterTankFailure;
      }

      public final WelcomeHomeLocation getWelcomeHome() {
         return this.welcomeHome;
      }

      public final Integer getWickUsage() {
         return this.wickUsage;
      }

      public final Boolean getWickdryDone() {
         return this.wickdryDone;
      }

      public final Integer getWickdryDuration() {
         return this.wickdryDuration;
      }

      public final Boolean getWickdryEnabled() {
         return this.wickdryEnabled;
      }

      public final Integer getWickdryLeftTime() {
         return this.wickdryLeftTime;
      }

      public final Long getWickdryLeftTimeUpdateTime() {
         return this.wickdryLeftTimeUpdateTime;
      }

      public final Boolean getWickdryOn() {
         return this.wickdryOn;
      }

      public final String getWifiFirmare() {
         return this.wifiFirmare;
      }

      public final Boolean getYwrmEnabled() {
         return this.ywrmEnabled;
      }

      public final Integer getYwrmUsage() {
         return this.ywrmUsage;
      }

      public int hashCode() {
         int var84 = this.uuid.hashCode();
         String var101 = this.deviceType;
         int var83 = 0;
         int var1;
         if (var101 == null) {
            var1 = 0;
         } else {
            var1 = var101.hashCode();
         }

         var101 = this.mcuFirmware;
         int var2;
         if (var101 == null) {
            var2 = 0;
         } else {
            var2 = var101.hashCode();
         }

         var101 = this.wifiFirmare;
         int var3;
         if (var101 == null) {
            var3 = 0;
         } else {
            var3 = var101.hashCode();
         }

         var101 = this.hardware;
         int var4;
         if (var101 == null) {
            var4 = 0;
         } else {
            var4 = var101.hashCode();
         }

         Integer var105 = this.connectivityStatus;
         int var5;
         if (var105 == null) {
            var5 = 0;
         } else {
            var5 = var105.hashCode();
         }

         IndoorDatapoint var106 = this.latestSensorDataPoint;
         int var6;
         if (var106 == null) {
            var6 = 0;
         } else {
            var6 = var106.hashCode();
         }

         int var85 = this.fanSpeed;
         int var86 = this.brightness;
         int var87 = AddDeviceState$$ExternalSyntheticBackport0.m(this.childlock);
         int var88 = AddDeviceState$$ExternalSyntheticBackport0.m(this.autoMode);
         Integer var107 = this.filter;
         int var7;
         if (var107 == null) {
            var7 = 0;
         } else {
            var7 = var107.hashCode();
         }

         int var94 = Arrays.hashCode(this.pm1Ranges);
         int var98 = Arrays.hashCode(this.pm10Ranges);
         int var89 = Arrays.hashCode(this.pm25Ranges);
         int var99 = Arrays.hashCode(this.vocRanges);
         int var95 = Arrays.hashCode(this.hchoRanges);
         int var97 = AddDeviceState$$ExternalSyntheticBackport0.m(this.standByMode);
         int var92 = AddDeviceState$$ExternalSyntheticBackport0.m(this.ecoMode);
         int var93 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hinsMode);
         int var91 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hinsNightMode);
         int var90 = AddDeviceState$$ExternalSyntheticBackport0.m(this.g4NightMode);
         int var96 = AddDeviceState$$ExternalSyntheticBackport0.m(this.germShieldMode);
         Boolean var108 = this.germShieldNightMode;
         int var8;
         if (var108 == null) {
            var8 = 0;
         } else {
            var8 = var108.hashCode();
         }

         String var109 = this.serialNumber;
         int var9;
         if (var109 == null) {
            var9 = 0;
         } else {
            var9 = var109.hashCode();
         }

         var109 = this.name;
         int var10;
         if (var109 == null) {
            var10 = 0;
         } else {
            var10 = var109.hashCode();
         }

         var109 = this.autoModeTrigger;
         int var11;
         if (var109 == null) {
            var11 = 0;
         } else {
            var11 = var109.hashCode();
         }

         var109 = this.nightModeTrigger;
         int var12;
         if (var109 == null) {
            var12 = 0;
         } else {
            var12 = var109.hashCode();
         }

         int var100 = AddDeviceState$$ExternalSyntheticBackport0.m(this.safetySwitch);
         var109 = this.macAddress;
         int var13;
         if (var109 == null) {
            var13 = 0;
         } else {
            var13 = var109.hashCode();
         }

         WelcomeHomeLocation var114 = this.welcomeHome;
         int var14;
         if (var114 == null) {
            var14 = 0;
         } else {
            var14 = var114.hashCode();
         }

         String var115 = this.locationId;
         int var15;
         if (var115 == null) {
            var15 = 0;
         } else {
            var15 = var115.hashCode();
         }

         Boolean var116 = this.disinfection;
         int var16;
         if (var116 == null) {
            var16 = 0;
         } else {
            var16 = var116.hashCode();
         }

         Integer var117 = this.disinfectLeftTime;
         int var17;
         if (var117 == null) {
            var17 = 0;
         } else {
            var17 = var117.hashCode();
         }

         Long var118 = this.disinfectLeftTimeUpdateTime;
         int var18;
         if (var118 == null) {
            var18 = 0;
         } else {
            var18 = var118.hashCode();
         }

         String var119 = this.timezone;
         int var19;
         if (var119 == null) {
            var19 = 0;
         } else {
            var19 = var119.hashCode();
         }

         Boolean var120 = this.wickdryEnabled;
         int var20;
         if (var120 == null) {
            var20 = 0;
         } else {
            var20 = var120.hashCode();
         }

         var120 = this.wickdryOn;
         int var21;
         if (var120 == null) {
            var21 = 0;
         } else {
            var21 = var120.hashCode();
         }

         Integer var122 = this.wickdryLeftTime;
         int var22;
         if (var122 == null) {
            var22 = 0;
         } else {
            var22 = var122.hashCode();
         }

         Long var123 = this.wickdryLeftTimeUpdateTime;
         int var23;
         if (var123 == null) {
            var23 = 0;
         } else {
            var23 = var123.hashCode();
         }

         Integer var124 = this.wickUsage;
         int var24;
         if (var124 == null) {
            var24 = 0;
         } else {
            var24 = var124.hashCode();
         }

         Boolean var125 = this.waterShortage;
         int var25;
         if (var125 == null) {
            var25 = 0;
         } else {
            var25 = var125.hashCode();
         }

         Integer var126 = this.autoRh;
         int var26;
         if (var126 == null) {
            var26 = 0;
         } else {
            var26 = var126.hashCode();
         }

         var126 = this.timerStatus;
         int var27;
         if (var126 == null) {
            var27 = 0;
         } else {
            var27 = var126.hashCode();
         }

         var126 = this.timerDuration;
         int var28;
         if (var126 == null) {
            var28 = 0;
         } else {
            var28 = var126.hashCode();
         }

         var126 = this.timerLeftTime;
         int var29;
         if (var126 == null) {
            var29 = 0;
         } else {
            var29 = var126.hashCode();
         }

         Long var130 = this.timerLeftTimeUpdateTime;
         int var30;
         if (var130 == null) {
            var30 = 0;
         } else {
            var30 = var130.hashCode();
         }

         Integer var131 = this.temperatureUnit;
         int var31;
         if (var131 == null) {
            var31 = 0;
         } else {
            var31 = var131.hashCode();
         }

         var131 = this.oscillationState;
         int var32;
         if (var131 == null) {
            var32 = 0;
         } else {
            var32 = var131.hashCode();
         }

         var131 = this.oscillationAngle;
         int var33;
         if (var131 == null) {
            var33 = 0;
         } else {
            var33 = var131.hashCode();
         }

         var131 = this.oscillationDirection;
         int var34;
         if (var131 == null) {
            var34 = 0;
         } else {
            var34 = var131.hashCode();
         }

         var131 = this.oscillationFanSpeed;
         int var35;
         if (var131 == null) {
            var35 = 0;
         } else {
            var35 = var131.hashCode();
         }

         var131 = this.mainMode;
         int var36;
         if (var131 == null) {
            var36 = 0;
         } else {
            var36 = var131.hashCode();
         }

         var131 = this.apSubMode;
         int var37;
         if (var131 == null) {
            var37 = 0;
         } else {
            var37 = var131.hashCode();
         }

         var131 = this.apFanSpeed;
         int var38;
         if (var131 == null) {
            var38 = 0;
         } else {
            var38 = var131.hashCode();
         }

         var131 = this.heatSubMode;
         int var39;
         if (var131 == null) {
            var39 = 0;
         } else {
            var39 = var131.hashCode();
         }

         var131 = this.heatFanSpeed;
         int var40;
         if (var131 == null) {
            var40 = 0;
         } else {
            var40 = var131.hashCode();
         }

         Double var141 = this.heatAutoTmp;
         int var41;
         if (var141 == null) {
            var41 = 0;
         } else {
            var41 = var141.hashCode();
         }

         var141 = this.heatEcoTmp;
         int var42;
         if (var141 == null) {
            var42 = 0;
         } else {
            var42 = var141.hashCode();
         }

         Integer var143 = this.coolSubMode;
         int var43;
         if (var143 == null) {
            var43 = 0;
         } else {
            var43 = var143.hashCode();
         }

         var143 = this.coolFanSpeed;
         int var44;
         if (var143 == null) {
            var44 = 0;
         } else {
            var44 = var143.hashCode();
         }

         var143 = this.coolAutoTag;
         int var45;
         if (var143 == null) {
            var45 = 0;
         } else {
            var45 = var143.hashCode();
         }

         double[] var146 = this.coolAutoPresets;
         int var46;
         if (var146 == null) {
            var46 = 0;
         } else {
            var46 = Arrays.hashCode(var146);
         }

         Integer var147 = this.coolEcoTag;
         int var47;
         if (var147 == null) {
            var47 = 0;
         } else {
            var47 = var147.hashCode();
         }

         double[] var148 = this.coolEcoPresets;
         int var48;
         if (var148 == null) {
            var48 = 0;
         } else {
            var48 = Arrays.hashCode(var148);
         }

         Integer var149 = this.mode;
         int var49;
         if (var149 == null) {
            var49 = 0;
         } else {
            var49 = var149.hashCode();
         }

         Boolean var150 = this.humMode;
         int var50;
         if (var150 == null) {
            var50 = 0;
         } else {
            var50 = var150.hashCode();
         }

         Integer var151 = this.waterLevel;
         int var51;
         if (var151 == null) {
            var51 = 0;
         } else {
            var51 = var151.hashCode();
         }

         var151 = this.dehSubMode;
         int var52;
         if (var151 == null) {
            var52 = 0;
         } else {
            var52 = var151.hashCode();
         }

         Boolean var153 = this.waterTankFailure;
         int var53;
         if (var153 == null) {
            var53 = 0;
         } else {
            var53 = var153.hashCode();
         }

         Integer var154 = this.smartSubMode;
         int var54;
         if (var154 == null) {
            var54 = 0;
         } else {
            var54 = var154.hashCode();
         }

         Boolean var155 = this.detectCat;
         int var55;
         if (var155 == null) {
            var55 = 0;
         } else {
            var55 = var155.hashCode();
         }

         var155 = this.bodyMounted;
         int var56;
         if (var155 == null) {
            var56 = 0;
         } else {
            var56 = var155.hashCode();
         }

         Integer var157 = this.cleanAirEta;
         int var57;
         if (var157 == null) {
            var57 = 0;
         } else {
            var57 = var157.hashCode();
         }

         var157 = this.panelDisplayMode;
         int var58;
         if (var157 == null) {
            var58 = 0;
         } else {
            var58 = var157.hashCode();
         }

         Boolean var159 = this.hoverEnabled;
         int var59;
         if (var159 == null) {
            var59 = 0;
         } else {
            var59 = var159.hashCode();
         }

         var159 = this.airRefreshEnabled;
         int var60;
         if (var159 == null) {
            var60 = 0;
         } else {
            var60 = var159.hashCode();
         }

         Integer var161 = this.airRefreshStatus;
         int var61;
         if (var161 == null) {
            var61 = 0;
         } else {
            var61 = var161.hashCode();
         }

         var161 = this.airRefreshDuration;
         int var62;
         if (var161 == null) {
            var62 = 0;
         } else {
            var62 = var161.hashCode();
         }

         var161 = this.airRefreshTimeStamp;
         int var63;
         if (var161 == null) {
            var63 = 0;
         } else {
            var63 = var161.hashCode();
         }

         var161 = this.airRefreshStartTimeStamp;
         int var64;
         if (var161 == null) {
            var64 = 0;
         } else {
            var64 = var161.hashCode();
         }

         var161 = this.airRefreshEndTimeStamp;
         int var65;
         if (var161 == null) {
            var65 = 0;
         } else {
            var65 = var161.hashCode();
         }

         var161 = this.roomType;
         int var66;
         if (var161 == null) {
            var66 = 0;
         } else {
            var66 = var161.hashCode();
         }

         var161 = this.nightLampBrightness;
         int var67;
         if (var161 == null) {
            var67 = 0;
         } else {
            var67 = var161.hashCode();
         }

         var161 = this.nightLampSteplessBrightness;
         int var68;
         if (var161 == null) {
            var68 = 0;
         } else {
            var68 = var161.hashCode();
         }

         var161 = this.wickdryDuration;
         int var69;
         if (var161 == null) {
            var69 = 0;
         } else {
            var69 = var161.hashCode();
         }

         Boolean var170 = this.wickdryDone;
         int var70;
         if (var170 == null) {
            var70 = 0;
         } else {
            var70 = var170.hashCode();
         }

         var170 = this.ywrmEnabled;
         int var71;
         if (var170 == null) {
            var71 = 0;
         } else {
            var71 = var170.hashCode();
         }

         Integer var172 = this.ywrmUsage;
         int var72;
         if (var172 == null) {
            var72 = 0;
         } else {
            var72 = var172.hashCode();
         }

         List var173 = this.alarms;
         int var73;
         if (var173 == null) {
            var73 = 0;
         } else {
            var73 = var173.hashCode();
         }

         Integer var174 = this.humSubMode;
         int var74;
         if (var174 == null) {
            var74 = 0;
         } else {
            var74 = var174.hashCode();
         }

         Boolean var175 = this.use24Hour;
         int var75;
         if (var175 == null) {
            var75 = 0;
         } else {
            var75 = var175.hashCode();
         }

         var175 = this.waterInfill;
         int var76;
         if (var175 == null) {
            var76 = 0;
         } else {
            var76 = var175.hashCode();
         }

         Integer var177 = this.sensorMode;
         int var77;
         if (var177 == null) {
            var77 = 0;
         } else {
            var77 = var177.hashCode();
         }

         var177 = this.coolFanSpeedLevel;
         int var78;
         if (var177 == null) {
            var78 = 0;
         } else {
            var78 = var177.hashCode();
         }

         var177 = this.coolAutoLevel;
         int var79;
         if (var177 == null) {
            var79 = 0;
         } else {
            var79 = var177.hashCode();
         }

         Long var180 = this.nightModeStartTime;
         int var80;
         if (var180 == null) {
            var80 = 0;
         } else {
            var80 = var180.hashCode();
         }

         DualOscillationConfig var181 = this.dualOscillationConfig;
         int var81;
         if (var181 == null) {
            var81 = 0;
         } else {
            var81 = var181.hashCode();
         }

         Integer var182 = this.rpm;
         int var82;
         if (var182 == null) {
            var82 = 0;
         } else {
            var82 = var182.hashCode();
         }

         double[] var183 = this.nightPeriods;
         if (var183 != null) {
            var83 = Arrays.hashCode(var183);
         }

         return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((var84 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var85) * 31 + var86) * 31 + var87) * 31 + var88) * 31 + var7) * 31 + var94) * 31 + var98) * 31 + var89) * 31 + var99) * 31 + var95) * 31 + var97) * 31 + var92) * 31 + var93) * 31 + var91) * 31 + var90) * 31 + var96) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11) * 31 + var12) * 31 + var100) * 31 + var13) * 31 + var14) * 31 + var15) * 31 + var16) * 31 + var17) * 31 + var18) * 31 + var19) * 31 + var20) * 31 + var21) * 31 + var22) * 31 + var23) * 31 + var24) * 31 + var25) * 31 + var26) * 31 + var27) * 31 + var28) * 31 + var29) * 31 + var30) * 31 + var31) * 31 + var32) * 31 + var33) * 31 + var34) * 31 + var35) * 31 + var36) * 31 + var37) * 31 + var38) * 31 + var39) * 31 + var40) * 31 + var41) * 31 + var42) * 31 + var43) * 31 + var44) * 31 + var45) * 31 + var46) * 31 + var47) * 31 + var48) * 31 + var49) * 31 + var50) * 31 + var51) * 31 + var52) * 31 + var53) * 31 + var54) * 31 + var55) * 31 + var56) * 31 + var57) * 31 + var58) * 31 + var59) * 31 + var60) * 31 + var61) * 31 + var62) * 31 + var63) * 31 + var64) * 31 + var65) * 31 + var66) * 31 + var67) * 31 + var68) * 31 + var69) * 31 + var70) * 31 + var71) * 31 + var72) * 31 + var73) * 31 + var74) * 31 + var75) * 31 + var76) * 31 + var77) * 31 + var78) * 31 + var79) * 31 + var80) * 31 + var81) * 31 + var82) * 31 + var83;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DeviceDataOnBlue(uuid=");
         var1.append(this.uuid);
         var1.append(", deviceType=");
         var1.append(this.deviceType);
         var1.append(", mcuFirmware=");
         var1.append(this.mcuFirmware);
         var1.append(", wifiFirmare=");
         var1.append(this.wifiFirmare);
         var1.append(", hardware=");
         var1.append(this.hardware);
         var1.append(", connectivityStatus=");
         var1.append(this.connectivityStatus);
         var1.append(", latestSensorDataPoint=");
         var1.append(this.latestSensorDataPoint);
         var1.append(", fanSpeed=");
         var1.append(this.fanSpeed);
         var1.append(", brightness=");
         var1.append(this.brightness);
         var1.append(", childlock=");
         var1.append(this.childlock);
         var1.append(", autoMode=");
         var1.append(this.autoMode);
         var1.append(", filter=");
         var1.append(this.filter);
         var1.append(", pm1Ranges=");
         var1.append(Arrays.toString(this.pm1Ranges));
         var1.append(", pm10Ranges=");
         var1.append(Arrays.toString(this.pm10Ranges));
         var1.append(", pm25Ranges=");
         var1.append(Arrays.toString(this.pm25Ranges));
         var1.append(", vocRanges=");
         var1.append(Arrays.toString(this.vocRanges));
         var1.append(", hchoRanges=");
         var1.append(Arrays.toString(this.hchoRanges));
         var1.append(", standByMode=");
         var1.append(this.standByMode);
         var1.append(", ecoMode=");
         var1.append(this.ecoMode);
         var1.append(", hinsMode=");
         var1.append(this.hinsMode);
         var1.append(", hinsNightMode=");
         var1.append(this.hinsNightMode);
         var1.append(", g4NightMode=");
         var1.append(this.g4NightMode);
         var1.append(", germShieldMode=");
         var1.append(this.germShieldMode);
         var1.append(", germShieldNightMode=");
         var1.append(this.germShieldNightMode);
         var1.append(", serialNumber=");
         var1.append(this.serialNumber);
         var1.append(", name=");
         var1.append(this.name);
         var1.append(", autoModeTrigger=");
         var1.append(this.autoModeTrigger);
         var1.append(", nightModeTrigger=");
         var1.append(this.nightModeTrigger);
         var1.append(", safetySwitch=");
         var1.append(this.safetySwitch);
         var1.append(", macAddress=");
         var1.append(this.macAddress);
         var1.append(", welcomeHome=");
         var1.append(this.welcomeHome);
         var1.append(", locationId=");
         var1.append(this.locationId);
         var1.append(", disinfection=");
         var1.append(this.disinfection);
         var1.append(", disinfectLeftTime=");
         var1.append(this.disinfectLeftTime);
         var1.append(", disinfectLeftTimeUpdateTime=");
         var1.append(this.disinfectLeftTimeUpdateTime);
         var1.append(", timezone=");
         var1.append(this.timezone);
         var1.append(", wickdryEnabled=");
         var1.append(this.wickdryEnabled);
         var1.append(", wickdryOn=");
         var1.append(this.wickdryOn);
         var1.append(", wickdryLeftTime=");
         var1.append(this.wickdryLeftTime);
         var1.append(", wickdryLeftTimeUpdateTime=");
         var1.append(this.wickdryLeftTimeUpdateTime);
         var1.append(", wickUsage=");
         var1.append(this.wickUsage);
         var1.append(", waterShortage=");
         var1.append(this.waterShortage);
         var1.append(", autoRh=");
         var1.append(this.autoRh);
         var1.append(", timerStatus=");
         var1.append(this.timerStatus);
         var1.append(", timerDuration=");
         var1.append(this.timerDuration);
         var1.append(", timerLeftTime=");
         var1.append(this.timerLeftTime);
         var1.append(", timerLeftTimeUpdateTime=");
         var1.append(this.timerLeftTimeUpdateTime);
         var1.append(", temperatureUnit=");
         var1.append(this.temperatureUnit);
         var1.append(", oscillationState=");
         var1.append(this.oscillationState);
         var1.append(", oscillationAngle=");
         var1.append(this.oscillationAngle);
         var1.append(", oscillationDirection=");
         var1.append(this.oscillationDirection);
         var1.append(", oscillationFanSpeed=");
         var1.append(this.oscillationFanSpeed);
         var1.append(", mainMode=");
         var1.append(this.mainMode);
         var1.append(", apSubMode=");
         var1.append(this.apSubMode);
         var1.append(", apFanSpeed=");
         var1.append(this.apFanSpeed);
         var1.append(", heatSubMode=");
         var1.append(this.heatSubMode);
         var1.append(", heatFanSpeed=");
         var1.append(this.heatFanSpeed);
         var1.append(", heatAutoTmp=");
         var1.append(this.heatAutoTmp);
         var1.append(", heatEcoTmp=");
         var1.append(this.heatEcoTmp);
         var1.append(", coolSubMode=");
         var1.append(this.coolSubMode);
         var1.append(", coolFanSpeed=");
         var1.append(this.coolFanSpeed);
         var1.append(", coolAutoTag=");
         var1.append(this.coolAutoTag);
         var1.append(", coolAutoPresets=");
         var1.append(Arrays.toString(this.coolAutoPresets));
         var1.append(", coolEcoTag=");
         var1.append(this.coolEcoTag);
         var1.append(", coolEcoPresets=");
         var1.append(Arrays.toString(this.coolEcoPresets));
         var1.append(", mode=");
         var1.append(this.mode);
         var1.append(", humMode=");
         var1.append(this.humMode);
         var1.append(", waterLevel=");
         var1.append(this.waterLevel);
         var1.append(", dehSubMode=");
         var1.append(this.dehSubMode);
         var1.append(", waterTankFailure=");
         var1.append(this.waterTankFailure);
         var1.append(", smartSubMode=");
         var1.append(this.smartSubMode);
         var1.append(", detectCat=");
         var1.append(this.detectCat);
         var1.append(", bodyMounted=");
         var1.append(this.bodyMounted);
         var1.append(", cleanAirEta=");
         var1.append(this.cleanAirEta);
         var1.append(", panelDisplayMode=");
         var1.append(this.panelDisplayMode);
         var1.append(", hoverEnabled=");
         var1.append(this.hoverEnabled);
         var1.append(", airRefreshEnabled=");
         var1.append(this.airRefreshEnabled);
         var1.append(", airRefreshStatus=");
         var1.append(this.airRefreshStatus);
         var1.append(", airRefreshDuration=");
         var1.append(this.airRefreshDuration);
         var1.append(", airRefreshTimeStamp=");
         var1.append(this.airRefreshTimeStamp);
         var1.append(", airRefreshStartTimeStamp=");
         var1.append(this.airRefreshStartTimeStamp);
         var1.append(", airRefreshEndTimeStamp=");
         var1.append(this.airRefreshEndTimeStamp);
         var1.append(", roomType=");
         var1.append(this.roomType);
         var1.append(", nightLampBrightness=");
         var1.append(this.nightLampBrightness);
         var1.append(", nightLampSteplessBrightness=");
         var1.append(this.nightLampSteplessBrightness);
         var1.append(", wickdryDuration=");
         var1.append(this.wickdryDuration);
         var1.append(", wickdryDone=");
         var1.append(this.wickdryDone);
         var1.append(", ywrmEnabled=");
         var1.append(this.ywrmEnabled);
         var1.append(", ywrmUsage=");
         var1.append(this.ywrmUsage);
         var1.append(", alarms=");
         var1.append(this.alarms);
         var1.append(", humSubMode=");
         var1.append(this.humSubMode);
         var1.append(", use24Hour=");
         var1.append(this.use24Hour);
         var1.append(", waterInfill=");
         var1.append(this.waterInfill);
         var1.append(", sensorMode=");
         var1.append(this.sensorMode);
         var1.append(", coolFanSpeedLevel=");
         var1.append(this.coolFanSpeedLevel);
         var1.append(", coolAutoLevel=");
         var1.append(this.coolAutoLevel);
         var1.append(", nightModeStartTime=");
         var1.append(this.nightModeStartTime);
         var1.append(", dualOscillationConfig=");
         var1.append(this.dualOscillationConfig);
         var1.append(", rpm=");
         var1.append(this.rpm);
         var1.append(", nightPeriods=");
         var1.append(Arrays.toString(this.nightPeriods));
         var1.append(')');
         return var1.toString();
      }
   }
}
