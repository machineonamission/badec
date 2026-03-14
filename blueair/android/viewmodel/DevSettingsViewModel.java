package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.Context;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.api.utils.ProgressListener;
import com.blueair.auth.AuthService;
import com.blueair.auth.BlueCloudDomain;
import com.blueair.auth.GigyaServer;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.auth.RemoteConfig;
import com.blueair.core.AblEnvironment;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.DeviceScheduleService;
import com.blueair.devicemanager.WelcomeHomeBroadcastReceiver;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020?J\b\u0010Ï\u0001\u001a\u00030Í\u0001J\b\u0010Ð\u0001\u001a\u00030Í\u0001J\u0011\u0010Ñ\u0001\u001a\u00030Í\u00012\u0007\u0010Ò\u0001\u001a\u000202J\u001a\u0010Ó\u0001\u001a\u00030Í\u00012\u0007\u0010Ô\u0001\u001a\u00020?2\u0007\u0010Õ\u0001\u001a\u00020?J\u0019\u0010f\u001a\u00030Í\u00012\u0007\u0010Ö\u0001\u001a\u0002022\u0007\u0010×\u0001\u001a\u00020?J\u0011\u0010Ø\u0001\u001a\u00030Í\u00012\u0007\u0010Ù\u0001\u001a\u00020XJ\u001e\u0010Ú\u0001\u001a\u00030Í\u00012\t\b\u0002\u0010×\u0001\u001a\u00020?2\t\b\u0002\u0010Û\u0001\u001a\u000202J\b\u0010Ü\u0001\u001a\u00030Í\u0001J\b\u0010Ý\u0001\u001a\u00030Í\u0001J\b\u0010Þ\u0001\u001a\u00030Í\u0001J\u0011\u0010ß\u0001\u001a\u00030Í\u00012\u0007\u0010à\u0001\u001a\u000202J#\u0010á\u0001\u001a\u00030Í\u00012\u0007\u0010â\u0001\u001a\u0002062\u0007\u0010ã\u0001\u001a\u0002022\u0007\u0010ä\u0001\u001a\u000202J%\u0010å\u0001\u001a\u00030Í\u00012\b\u0010æ\u0001\u001a\u00030ç\u00012\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010ê\u0001\u001a\u00020?J\b\u0010ë\u0001\u001a\u00030Í\u0001J\b\u0010ì\u0001\u001a\u00030Í\u0001J\u001c\u0010í\u0001\u001a\u00030Í\u00012\b\u0010î\u0001\u001a\u00030ï\u00012\b\u0010ð\u0001\u001a\u00030ï\u0001J\n\u0010ñ\u0001\u001a\u00030Í\u0001H\u0014R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020605048F¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0011\u0010G\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bH\u0010BR\u0011\u0010I\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bJ\u0010BR\u0011\u0010K\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bL\u0010BR\u0011\u0010M\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bN\u0010BR\u0011\u0010O\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bP\u0010BR\u0011\u0010Q\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bR\u0010BR\u0011\u0010S\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020X8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0011\u0010[\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b\\\u0010BR\u0011\u0010]\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b^\u0010BR\u0017\u0010_\u001a\b\u0012\u0004\u0012\u0002020`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR+\u0010d\u001a\u00020?2\u0006\u0010c\u001a\u00020?8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\be\u0010B\"\u0004\bf\u0010DR+\u0010i\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010h\u001a\u0004\bj\u0010T\"\u0004\bk\u0010lR+\u0010n\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010h\u001a\u0004\bo\u0010T\"\u0004\bp\u0010lR+\u0010r\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bu\u0010h\u001a\u0004\bs\u0010T\"\u0004\bt\u0010lR+\u0010v\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\by\u0010h\u001a\u0004\bw\u0010T\"\u0004\bx\u0010lR+\u0010z\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b}\u0010h\u001a\u0004\b{\u0010T\"\u0004\b|\u0010lR-\u0010~\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0014\n\u0005\b\u0081\u0001\u0010h\u001a\u0004\b\u007f\u0010T\"\u0005\b\u0080\u0001\u0010lR/\u0010\u0082\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010h\u001a\u0005\b\u0083\u0001\u0010T\"\u0005\b\u0084\u0001\u0010lR/\u0010\u0086\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010h\u001a\u0005\b\u0087\u0001\u0010T\"\u0005\b\u0088\u0001\u0010lR/\u0010\u008a\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010h\u001a\u0005\b\u008b\u0001\u0010T\"\u0005\b\u008c\u0001\u0010lR/\u0010\u008e\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010h\u001a\u0005\b\u008f\u0001\u0010T\"\u0005\b\u0090\u0001\u0010lR/\u0010\u0092\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010h\u001a\u0005\b\u0093\u0001\u0010T\"\u0005\b\u0094\u0001\u0010lR/\u0010\u0096\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010h\u001a\u0005\b\u0097\u0001\u0010T\"\u0005\b\u0098\u0001\u0010lR/\u0010\u009a\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010h\u001a\u0005\b\u009b\u0001\u0010T\"\u0005\b\u009c\u0001\u0010lR/\u0010\u009e\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¡\u0001\u0010h\u001a\u0005\b\u009f\u0001\u0010T\"\u0005\b \u0001\u0010lR/\u0010¢\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¥\u0001\u0010h\u001a\u0005\b£\u0001\u0010T\"\u0005\b¤\u0001\u0010lR/\u0010¦\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b©\u0001\u0010h\u001a\u0005\b§\u0001\u0010T\"\u0005\b¨\u0001\u0010lR/\u0010ª\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010h\u001a\u0005\b«\u0001\u0010T\"\u0005\b¬\u0001\u0010lR/\u0010®\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b±\u0001\u0010h\u001a\u0005\b¯\u0001\u0010T\"\u0005\b°\u0001\u0010lR3\u0010³\u0001\u001a\u00030²\u00012\u0007\u0010c\u001a\u00030²\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b¸\u0001\u0010h\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R3\u0010¹\u0001\u001a\u00030²\u00012\u0007\u0010c\u001a\u00030²\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b¼\u0001\u0010h\u001a\u0006\bº\u0001\u0010µ\u0001\"\u0006\b»\u0001\u0010·\u0001R3\u0010½\u0001\u001a\u00030²\u00012\u0007\u0010c\u001a\u00030²\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bÀ\u0001\u0010h\u001a\u0006\b¾\u0001\u0010µ\u0001\"\u0006\b¿\u0001\u0010·\u0001R/\u0010Á\u0001\u001a\u0002022\u0006\u0010c\u001a\u0002028F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bÄ\u0001\u0010h\u001a\u0005\bÂ\u0001\u0010T\"\u0005\bÃ\u0001\u0010lR \u0010Å\u0001\u001a\u0013\u0012\u000f\u0012\r Æ\u0001*\u0005\u0018\u00010²\u00010²\u00010`X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Ç\u0001\u001a\t\u0012\u0005\u0012\u00030²\u000104¢\u0006\t\n\u0000\u001a\u0005\bÈ\u0001\u00108R\u001e\u0010É\u0001\u001a\u0011\u0012\r\u0012\u000b Æ\u0001*\u0004\u0018\u00010?0?0`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020?04¢\u0006\t\n\u0000\u001a\u0005\bË\u0001\u00108¨\u0006ò\u0001"},
   d2 = {"Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "scheduleService$delegate", "remoteConfig", "Lcom/blueair/auth/RemoteConfig;", "backendModified", "", "liveDevices", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "welcomeHomeTestDevice", "getWelcomeHomeTestDevice", "()Lcom/blueair/core/model/Device;", "setWelcomeHomeTestDevice", "(Lcom/blueair/core/model/Device;)V", "value", "", "homehost", "getHomehost", "()Ljava/lang/String;", "setHomehost", "(Ljava/lang/String;)V", "gigyaDataCenter", "getGigyaDataCenter", "gigyaCloudDomainRegion", "getGigyaCloudDomainRegion", "deviceRegion", "getDeviceRegion", "ipRegion", "getIpRegion", "gigyaToken", "getGigyaToken", "baseUrl", "getBaseUrl", "brokerBaseURL", "getBrokerBaseURL", "isForceChina", "()Z", "isForceUSA", "isForceKorea", "defaultBlueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getDefaultBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "defaultUrl", "getDefaultUrl", "defaultBroker", "getDefaultBroker", "remoteConfigUpdated", "Landroidx/lifecycle/MutableLiveData;", "getRemoteConfigUpdated", "()Landroidx/lifecycle/MutableLiveData;", "<set-?>", "forceRegion", "getForceRegion", "setForceRegion", "forceRegion$delegate", "Lkotlin/properties/ReadWriteProperty;", "forceIcpAvailable", "getForceIcpAvailable", "setForceIcpAvailable", "(Z)V", "forceIcpAvailable$delegate", "forceAwareAvailable", "getForceAwareAvailable", "setForceAwareAvailable", "forceAwareAvailable$delegate", "forceG4available", "getForceG4available", "setForceG4available", "forceG4available$delegate", "forceB4available", "getForceB4available", "setForceB4available", "forceB4available$delegate", "forceAlexaAvailable", "getForceAlexaAvailable", "setForceAlexaAvailable", "forceAlexaAvailable$delegate", "forceTmallAvailable", "getForceTmallAvailable", "setForceTmallAvailable", "forceTmallAvailable$delegate", "forceGAssistantAvailable", "getForceGAssistantAvailable", "setForceGAssistantAvailable", "forceGAssistantAvailable$delegate", "amplitudeDebug", "getAmplitudeDebug", "setAmplitudeDebug", "amplitudeDebug$delegate", "forceWelcomeHome", "getForceWelcomeHome", "setForceWelcomeHome", "forceWelcomeHome$delegate", "facebookLoginEnabled", "getFacebookLoginEnabled", "setFacebookLoginEnabled", "facebookLoginEnabled$delegate", "googleLoginEnabled", "getGoogleLoginEnabled", "setGoogleLoginEnabled", "googleLoginEnabled$delegate", "wechatQQAppleLoginEnabled", "getWechatQQAppleLoginEnabled", "setWechatQQAppleLoginEnabled", "wechatQQAppleLoginEnabled$delegate", "lokalisePreRelease", "getLokalisePreRelease", "setLokalisePreRelease", "lokalisePreRelease$delegate", "googleLive", "getGoogleLive", "setGoogleLive", "googleLive$delegate", "alexaLive", "getAlexaLive", "setAlexaLive", "alexaLive$delegate", "inUatMode", "getInUatMode", "setInUatMode", "inUatMode$delegate", "useDevKlaviyo", "getUseDevKlaviyo", "setUseDevKlaviyo", "useDevKlaviyo$delegate", "showDetectCat", "getShowDetectCat", "setShowDetectCat", "showDetectCat$delegate", "", "maxLogFileSizeInMB", "getMaxLogFileSizeInMB", "()I", "setMaxLogFileSizeInMB", "(I)V", "maxLogFileSizeInMB$delegate", "aqiNotificationIntermittentInSecond", "getAqiNotificationIntermittentInSecond", "setAqiNotificationIntermittentInSecond", "aqiNotificationIntermittentInSecond$delegate", "aqiNotificationContinuousInSecond", "getAqiNotificationContinuousInSecond", "setAqiNotificationContinuousInSecond", "aqiNotificationContinuousInSecond$delegate", "useGigyaSandbox", "getUseGigyaSandbox", "setUseGigyaSandbox", "useGigyaSandbox$delegate", "_liveLogUploadProgress", "kotlin.jvm.PlatformType", "liveLogUploadProgress", "getLiveLogUploadProgress", "_liveLogUploadError", "liveLogUploadError", "getLiveLogUploadError", "setGigyaJwt", "", "token", "toggleShouldShowRateUsDev", "toggleShouldShowWHExploreDev", "reInitAmplitude", "debug", "changeBaseUrl", "nuUrl", "brokerURL", "force", "region", "setBackend", "blueCloudDomain", "forceBackend", "isRelease", "forceUpdateRemoteConfig", "showNotification", "resetUserInfoSyncTime", "setUatMode", "isUatMode", "testWelcomeHome", "device", "isMinRadius", "isEnter", "uploadLog", "type", "Lcom/blueair/core/model/IssueType;", "length", "Lcom/blueair/core/model/LogLength;", "description", "clearLogs", "revokeAqiDismission", "saveAqiThresold", "intermittent", "", "continuous", "onCleared", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevSettingsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DevSettingsViewModel.class, "scheduleService", "getScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceRegion", "getForceRegion()Ljava/lang/String;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceIcpAvailable", "getForceIcpAvailable()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceAwareAvailable", "getForceAwareAvailable()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceG4available", "getForceG4available()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceB4available", "getForceB4available()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceAlexaAvailable", "getForceAlexaAvailable()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceTmallAvailable", "getForceTmallAvailable()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceGAssistantAvailable", "getForceGAssistantAvailable()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "amplitudeDebug", "getAmplitudeDebug()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "forceWelcomeHome", "getForceWelcomeHome()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "facebookLoginEnabled", "getFacebookLoginEnabled()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "googleLoginEnabled", "getGoogleLoginEnabled()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "wechatQQAppleLoginEnabled", "getWechatQQAppleLoginEnabled()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "lokalisePreRelease", "getLokalisePreRelease()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "googleLive", "getGoogleLive()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "alexaLive", "getAlexaLive()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "inUatMode", "getInUatMode()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "useDevKlaviyo", "getUseDevKlaviyo()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "showDetectCat", "getShowDetectCat()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "maxLogFileSizeInMB", "getMaxLogFileSizeInMB()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "aqiNotificationIntermittentInSecond", "getAqiNotificationIntermittentInSecond()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "aqiNotificationContinuousInSecond", "getAqiNotificationContinuousInSecond()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(DevSettingsViewModel.class, "useGigyaSandbox", "getUseGigyaSandbox()Z", 0)))};
   public static final int $stable = 8;
   private final MutableLiveData _liveLogUploadError;
   private final MutableLiveData _liveLogUploadProgress;
   private final ReadWriteProperty alexaLive$delegate;
   private final ReadWriteProperty amplitudeDebug$delegate;
   private final ReadWriteProperty aqiNotificationContinuousInSecond$delegate;
   private final ReadWriteProperty aqiNotificationIntermittentInSecond$delegate;
   private final Lazy authService$delegate;
   private boolean backendModified;
   private final ReadWriteProperty facebookLoginEnabled$delegate;
   private final ReadWriteProperty forceAlexaAvailable$delegate;
   private final ReadWriteProperty forceAwareAvailable$delegate;
   private final ReadWriteProperty forceB4available$delegate;
   private final ReadWriteProperty forceG4available$delegate;
   private final ReadWriteProperty forceGAssistantAvailable$delegate;
   private final ReadWriteProperty forceIcpAvailable$delegate;
   private final ReadWriteProperty forceRegion$delegate;
   private final ReadWriteProperty forceTmallAvailable$delegate;
   private final ReadWriteProperty forceWelcomeHome$delegate;
   private final Lazy gigyaService$delegate;
   private final ReadWriteProperty googleLive$delegate;
   private final ReadWriteProperty googleLoginEnabled$delegate;
   private final Lazy happyUserService$delegate;
   private final ReadWriteProperty inUatMode$delegate;
   private final LiveData liveLogUploadError;
   private final LiveData liveLogUploadProgress;
   private final Lazy locationService$delegate;
   private final ReadWriteProperty lokalisePreRelease$delegate;
   private final ReadWriteProperty maxLogFileSizeInMB$delegate;
   private final Lazy notificationService$delegate;
   private final Lazy prefs$delegate;
   private final RemoteConfig remoteConfig;
   private final MutableLiveData remoteConfigUpdated;
   private final Lazy scheduleService$delegate;
   private final ReadWriteProperty showDetectCat$delegate;
   private final ReadWriteProperty useDevKlaviyo$delegate;
   private final ReadWriteProperty useGigyaSandbox$delegate;
   private final ReadWriteProperty wechatQQAppleLoginEnabled$delegate;
   private final Lazy welcomeHomeService$delegate;
   private Device welcomeHomeTestDevice;

   public DevSettingsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var3 = this;
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var2 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, AuthService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      Boolean var7 = false;
      this.authService$delegate = var2.provideDelegate(this, var4[0]);
      JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var5 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var14, GigyaService.class)), (Object)null);
      Boolean var15 = true;
      this.gigyaService$delegate = var5.provideDelegate(this, var4[1]);
      JVMTypeToken var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, LocationService.class)), (Object)null).provideDelegate(this, var4[2]);
      var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.happyUserService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, HappyUserService.class)), (Object)null).provideDelegate(this, var4[3]);
      var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var4[4]);
      var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.welcomeHomeService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, WelcomeHomeService.class)), (Object)null).provideDelegate(this, var4[5]);
      var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.notificationService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, NotificationService.class)), (Object)null).provideDelegate(this, var4[6]);
      var39 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var39, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.scheduleService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var39, DeviceScheduleService.class)), (Object)null).provideDelegate(this, var4[7]);
      this.remoteConfig = this.getGigyaService().getLocationService().getRemoteConfig();
      this.remoteConfigUpdated = new MutableLiveData();
      Prefs var23 = this.getPrefs();
      this.forceRegion$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "country_code_pref", "", PreferencesHelper.INSTANCE.get(var23.getBackend(), "country_code_pref", "", Reflection.getOrCreateKotlinClass(String.class))) {
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
      var23 = this.getPrefs();
      this.forceIcpAvailable$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_ICP_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_ICP_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceAwareAvailable$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_AWARE_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_AWARE_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceG4available$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_G4_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_G4_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceB4available$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_B4_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_B4_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceAlexaAvailable$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_ALEXA_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_ALEXA_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceTmallAvailable$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_TMALL_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_TMALL_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceGAssistantAvailable$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_GASSISTANT_AVAILABLE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_GASSISTANT_AVAILABLE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.amplitudeDebug$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_AMPLITUDE_DEBUG", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_AMPLITUDE_DEBUG", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.forceWelcomeHome$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FORCE_WELCOME_HOME", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FORCE_WELCOME_HOME", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.facebookLoginEnabled$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_FACEBOOK_LOGIN_ENABLED", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_FACEBOOK_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.googleLoginEnabled$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_GOOGLE_LOGIN_ENABLED", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_GOOGLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.wechatQQAppleLoginEnabled$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.lokalisePreRelease$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_LOKALISE_PRE_RELEASE", var7, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_LOKALISE_PRE_RELEASE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.googleLive$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_GOOGLE_LIVE", var15, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_GOOGLE_LIVE", var15, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var23 = this.getPrefs();
      this.alexaLive$delegate = (ReadWriteProperty)(new ObservableProperty(var23, "KEY_ALEXA_LIVE", var15, PreferencesHelper.INSTANCE.get(var23.getBackend(), "KEY_ALEXA_LIVE", var15, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      Prefs var16 = this.getPrefs();
      this.inUatMode$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "KEY_UAT_MODE", var7, PreferencesHelper.INSTANCE.get(var16.getBackend(), "KEY_UAT_MODE", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var16 = this.getPrefs();
      this.useDevKlaviyo$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "KEY_DEV_KLAVIYO", var7, PreferencesHelper.INSTANCE.get(var16.getBackend(), "KEY_DEV_KLAVIYO", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var16 = this.getPrefs();
      this.showDetectCat$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "KEY_SHOW_DETECT_CAT", var7, PreferencesHelper.INSTANCE.get(var16.getBackend(), "KEY_SHOW_DETECT_CAT", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      var16 = this.getPrefs();
      Integer var8 = 100;
      this.maxLogFileSizeInMB$delegate = (ReadWriteProperty)(new ObservableProperty(var16, "KEY_MAX_LOG_FILE_SIZE", var8, PreferencesHelper.INSTANCE.get(var16.getBackend(), "KEY_MAX_LOG_FILE_SIZE", var8, Reflection.getOrCreateKotlinClass(Integer.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      Prefs var9 = this.getPrefs();
      Integer var20 = 10;
      this.aqiNotificationIntermittentInSecond$delegate = (ReadWriteProperty)(new ObservableProperty(var9, "KEY_NOTIFICATION_AQI_INTERMITTENT", var20, PreferencesHelper.INSTANCE.get(var9.getBackend(), "KEY_NOTIFICATION_AQI_INTERMITTENT", var20, Reflection.getOrCreateKotlinClass(Integer.class))) {
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
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      Prefs var21 = this.getPrefs();
      Integer var10 = 86400;
      this.aqiNotificationContinuousInSecond$delegate = (ReadWriteProperty)(new ObservableProperty(var21, "KEY_NOTIFICATION_AQI_CONTINUOUS", var10, PreferencesHelper.INSTANCE.get(var21.getBackend(), "KEY_NOTIFICATION_AQI_CONTINUOUS", var10, Reflection.getOrCreateKotlinClass(Integer.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      Prefs var11 = this.getPrefs();
      Boolean var22 = GigyaServer.Companion.getUseSandbox();
      this.useGigyaSandbox$delegate = (ReadWriteProperty)(new ObservableProperty(var11, "KEY_USE_GIGYA_SANDBOX", var22, PreferencesHelper.INSTANCE.get(var11.getBackend(), "KEY_USE_GIGYA_SANDBOX", var22, Reflection.getOrCreateKotlinClass(Boolean.class))) {
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
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      MutableLiveData var12 = new MutableLiveData(0);
      this._liveLogUploadProgress = var12;
      this.liveLogUploadProgress = (LiveData)var12;
      var12 = new MutableLiveData("");
      this._liveLogUploadError = var12;
      this.liveLogUploadError = (LiveData)var12;
   }

   // $FF: synthetic method
   public static void forceBackend$default(DevSettingsViewModel var0, String var1, boolean var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.getGigyaService().getBlueCloudDomain().getRegionCode();
      }

      if ((var3 & 2) != 0) {
         var2 = StringsKt.endsWith$default(var0.getGigyaService().getBlueCloudDomain().getHost(), "prod/", false, 2, (Object)null);
      }

      var0.forceBackend(var1, var2);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final BlueCloudDomain getDefaultBlueCloudDomain() {
      return this.getGigyaService().getFallbackBlueCloudDomain();
   }

   private final GigyaService getGigyaService() {
      return (GigyaService)this.gigyaService$delegate.getValue();
   }

   private final HappyUserService getHappyUserService() {
      return (HappyUserService)this.happyUserService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
   }

   private final Prefs getPrefs() {
      return (Prefs)this.prefs$delegate.getValue();
   }

   private final DeviceScheduleService getScheduleService() {
      return (DeviceScheduleService)this.scheduleService$delegate.getValue();
   }

   private final WelcomeHomeService getWelcomeHomeService() {
      return (WelcomeHomeService)this.welcomeHomeService$delegate.getValue();
   }

   public final void changeBaseUrl(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "nuUrl");
      Intrinsics.checkNotNullParameter(var2, "brokerURL");
      if (URLUtil.isValidUrl(var1)) {
         this.setBackend(BlueCloudDomain.copy$default(this.getGigyaService().getBlueCloudDomain(), var1, (String)null, (String)null, var2, (String)null, 22, (Object)null));
      } else {
         BaseViewModel.showMessage$default(this, R.string.base_url_fail, (ViewUtils.MessageType)null, 2, (Object)null);
      }
   }

   public final void clearLogs() {
      this.getDeviceManager().clearLogs((Context)this.getApplication());
   }

   public final void forceBackend(String var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "region");
      this.setBackend(BlueCloudDomain.Companion.fromProvisionRegionCode(var1, var2));
   }

   public final void forceUpdateRemoteConfig() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final DevSettingsViewModel this$0;

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
            Object var4;
            MutableLiveData var7;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var7 = (MutableLiveData)this.L$0;
               ResultKt.throwOnFailure(var1);
               var4 = var1;
            } else {
               ResultKt.throwOnFailure(var1);
               MutableLiveData var6 = this.this$0.getRemoteConfigUpdated();
               RemoteConfig var5 = this.this$0.remoteConfig;
               Continuation var8 = (Continuation)this;
               this.L$0 = var6;
               this.label = 1;
               var4 = var5.forceUpdate(var8);
               if (var4 == var3) {
                  return var3;
               }

               var7 = var6;
            }

            var7.postValue(var4);
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final boolean getAlexaLive() {
      return (Boolean)this.alexaLive$delegate.getValue(this, $$delegatedProperties[23]);
   }

   public final boolean getAmplitudeDebug() {
      return (Boolean)this.amplitudeDebug$delegate.getValue(this, $$delegatedProperties[16]);
   }

   public final int getAqiNotificationContinuousInSecond() {
      return ((Number)this.aqiNotificationContinuousInSecond$delegate.getValue(this, $$delegatedProperties[29])).intValue();
   }

   public final int getAqiNotificationIntermittentInSecond() {
      return ((Number)this.aqiNotificationIntermittentInSecond$delegate.getValue(this, $$delegatedProperties[28])).intValue();
   }

   public final String getBaseUrl() {
      return this.getAuthService().getBlueHomeHost();
   }

   public final String getBrokerBaseURL() {
      return this.getAuthService().getBlueBrokerURL();
   }

   public final String getDefaultBroker() {
      return this.getDefaultBlueCloudDomain().getMqttBroker();
   }

   public final String getDefaultUrl() {
      return this.getDefaultBlueCloudDomain().getHost();
   }

   public final String getDeviceRegion() {
      return this.getLocationService().getDeviceRegion();
   }

   public final boolean getFacebookLoginEnabled() {
      return (Boolean)this.facebookLoginEnabled$delegate.getValue(this, $$delegatedProperties[18]);
   }

   public final boolean getForceAlexaAvailable() {
      return (Boolean)this.forceAlexaAvailable$delegate.getValue(this, $$delegatedProperties[13]);
   }

   public final boolean getForceAwareAvailable() {
      return (Boolean)this.forceAwareAvailable$delegate.getValue(this, $$delegatedProperties[10]);
   }

   public final boolean getForceB4available() {
      return (Boolean)this.forceB4available$delegate.getValue(this, $$delegatedProperties[12]);
   }

   public final boolean getForceG4available() {
      return (Boolean)this.forceG4available$delegate.getValue(this, $$delegatedProperties[11]);
   }

   public final boolean getForceGAssistantAvailable() {
      return (Boolean)this.forceGAssistantAvailable$delegate.getValue(this, $$delegatedProperties[15]);
   }

   public final boolean getForceIcpAvailable() {
      return (Boolean)this.forceIcpAvailable$delegate.getValue(this, $$delegatedProperties[9]);
   }

   public final String getForceRegion() {
      return (String)this.forceRegion$delegate.getValue(this, $$delegatedProperties[8]);
   }

   public final boolean getForceTmallAvailable() {
      return (Boolean)this.forceTmallAvailable$delegate.getValue(this, $$delegatedProperties[14]);
   }

   public final boolean getForceWelcomeHome() {
      return (Boolean)this.forceWelcomeHome$delegate.getValue(this, $$delegatedProperties[17]);
   }

   public final String getGigyaCloudDomainRegion() {
      return this.getGigyaService().getGigyaBlueCloudDomain().regionCodeShort();
   }

   public final String getGigyaDataCenter() {
      return this.getGigyaService().getGigyaDataCenter();
   }

   public final String getGigyaToken() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getAuthService().getUsername());
      var1.append(':');
      var1.append(this.getGigyaService().getGigyaJwt());
      return StringsKt.trim(var1.toString(), new char[]{':'});
   }

   public final boolean getGoogleLive() {
      return (Boolean)this.googleLive$delegate.getValue(this, $$delegatedProperties[22]);
   }

   public final boolean getGoogleLoginEnabled() {
      return (Boolean)this.googleLoginEnabled$delegate.getValue(this, $$delegatedProperties[19]);
   }

   public final String getHomehost() {
      return AblEnvironment.INSTANCE.getHost(this.getAuthService().getAblHomeHost());
   }

   public final boolean getInUatMode() {
      return (Boolean)this.inUatMode$delegate.getValue(this, $$delegatedProperties[24]);
   }

   public final String getIpRegion() {
      return this.getLocationService().getCountry();
   }

   public final LiveData getLiveDevices() {
      return this.getDeviceManager().getLiveDevices();
   }

   public final LiveData getLiveLogUploadError() {
      return this.liveLogUploadError;
   }

   public final LiveData getLiveLogUploadProgress() {
      return this.liveLogUploadProgress;
   }

   public final boolean getLokalisePreRelease() {
      return (Boolean)this.lokalisePreRelease$delegate.getValue(this, $$delegatedProperties[21]);
   }

   public final int getMaxLogFileSizeInMB() {
      return ((Number)this.maxLogFileSizeInMB$delegate.getValue(this, $$delegatedProperties[27])).intValue();
   }

   public final MutableLiveData getRemoteConfigUpdated() {
      return this.remoteConfigUpdated;
   }

   public final boolean getShowDetectCat() {
      return (Boolean)this.showDetectCat$delegate.getValue(this, $$delegatedProperties[26]);
   }

   public final boolean getUseDevKlaviyo() {
      return (Boolean)this.useDevKlaviyo$delegate.getValue(this, $$delegatedProperties[25]);
   }

   public final boolean getUseGigyaSandbox() {
      return (Boolean)this.useGigyaSandbox$delegate.getValue(this, $$delegatedProperties[30]);
   }

   public final boolean getWechatQQAppleLoginEnabled() {
      return (Boolean)this.wechatQQAppleLoginEnabled$delegate.getValue(this, $$delegatedProperties[20]);
   }

   public final Device getWelcomeHomeTestDevice() {
      return this.welcomeHomeTestDevice;
   }

   public final boolean isForceChina() {
      return Intrinsics.areEqual(this.getForceRegion(), "cn");
   }

   public final boolean isForceKorea() {
      return Intrinsics.areEqual(this.getForceRegion(), "kr");
   }

   public final boolean isForceUSA() {
      return Intrinsics.areEqual(this.getForceRegion(), "us");
   }

   protected void onCleared() {
      super.onCleared();
      if (this.backendModified) {
         BuildersKt.launch$default(this.getAuthService(), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final DevSettingsViewModel this$0;

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
                  AuthService var4 = this.this$0.getAuthService();
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

   public final void reInitAmplitude(boolean var1) {
      this.getAnalyticsService().initAmplitude(var1, this.getGigyaService().getLocationService().isInChina());
   }

   public final void resetUserInfoSyncTime() {
      Prefs var1 = this.getPrefs();
      PreferencesHelper.INSTANCE.set(var1.getBackend(), "KEY_USER_INFO_COLLECTIONS_SYNC_TIME", 0L, Reflection.getOrCreateKotlinClass(Long.class));
      this.showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
   }

   public final void revokeAqiDismission() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DevSettingsViewModel this$0;

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
               CoroutineContext var5 = (CoroutineContext)Dispatchers.getIO();
               Function2 var6 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final DevSettingsViewModel this$0;

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
                        DeviceManager var4 = this.this$0.getDeviceManager();
                        Continuation var5 = (Continuation)this;
                        this.label = 1;
                        if (var4.revokeAqiDismission(var5) == var3) {
                           return var3;
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (BuildersKt.withContext(var5, var6, var4) == var3) {
                  return var3;
               }
            }

            this.this$0.showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void saveAqiThresold(CharSequence var1, CharSequence var2) {
      Intrinsics.checkNotNullParameter(var1, "intermittent");
      Intrinsics.checkNotNullParameter(var2, "continuous");
      Integer var4 = StringsKt.toIntOrNull(var1.toString());
      int var3;
      if (var4 != null) {
         var3 = var4;
      } else {
         var3 = 10;
      }

      this.setAqiNotificationIntermittentInSecond(var3);
      var4 = StringsKt.toIntOrNull(var2.toString());
      if (var4 != null) {
         var3 = var4;
      } else {
         var3 = 86400;
      }

      this.setAqiNotificationContinuousInSecond(var3);
      this.showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
   }

   public final void setAlexaLive(boolean var1) {
      this.alexaLive$delegate.setValue(this, $$delegatedProperties[23], var1);
   }

   public final void setAmplitudeDebug(boolean var1) {
      this.amplitudeDebug$delegate.setValue(this, $$delegatedProperties[16], var1);
   }

   public final void setAqiNotificationContinuousInSecond(int var1) {
      this.aqiNotificationContinuousInSecond$delegate.setValue(this, $$delegatedProperties[29], var1);
   }

   public final void setAqiNotificationIntermittentInSecond(int var1) {
      this.aqiNotificationIntermittentInSecond$delegate.setValue(this, $$delegatedProperties[28], var1);
   }

   public final void setBackend(BlueCloudDomain var1) {
      Intrinsics.checkNotNullParameter(var1, "blueCloudDomain");
      this.getGigyaService().setForceBlueCloudDomain(var1);
      this.getAuthService().resetCloudJwt();
      this.getDeviceManager().logOut();
      this.backendModified = true;
      this.getAnalyticsService().setPropertyCloudRegion(this.getGigyaService().getBlueCloudDomain().tag());
      this.showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
   }

   public final void setFacebookLoginEnabled(boolean var1) {
      this.facebookLoginEnabled$delegate.setValue(this, $$delegatedProperties[18], var1);
   }

   public final void setForceAlexaAvailable(boolean var1) {
      this.forceAlexaAvailable$delegate.setValue(this, $$delegatedProperties[13], var1);
   }

   public final void setForceAwareAvailable(boolean var1) {
      this.forceAwareAvailable$delegate.setValue(this, $$delegatedProperties[10], var1);
   }

   public final void setForceB4available(boolean var1) {
      this.forceB4available$delegate.setValue(this, $$delegatedProperties[12], var1);
   }

   public final void setForceG4available(boolean var1) {
      this.forceG4available$delegate.setValue(this, $$delegatedProperties[11], var1);
   }

   public final void setForceGAssistantAvailable(boolean var1) {
      this.forceGAssistantAvailable$delegate.setValue(this, $$delegatedProperties[15], var1);
   }

   public final void setForceIcpAvailable(boolean var1) {
      this.forceIcpAvailable$delegate.setValue(this, $$delegatedProperties[9], var1);
   }

   public final void setForceRegion(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.forceRegion$delegate.setValue(this, $$delegatedProperties[8], var1);
   }

   public final void setForceRegion(boolean var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "region");
      if (!var1) {
         var2 = "";
      }

      this.setForceRegion(var2);
      this.showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
   }

   public final void setForceTmallAvailable(boolean var1) {
      this.forceTmallAvailable$delegate.setValue(this, $$delegatedProperties[14], var1);
   }

   public final void setForceWelcomeHome(boolean var1) {
      this.forceWelcomeHome$delegate.setValue(this, $$delegatedProperties[17], var1);
   }

   public final void setGigyaJwt(String var1) {
      Intrinsics.checkNotNullParameter(var1, "token");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("setGigyaJwt: ");
      var4.append(var1);
      var3.d(var4.toString(), new Object[0]);
      List var7 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      int var2 = var7.size();
      if (var2 != 0) {
         String var6 = "";
         String var8;
         if (var2 != 1) {
            if (var2 != 2) {
               var6 = (String)var7.get(0);
               var1 = (String)var7.get(1);
               var8 = (String)var7.get(2);
            } else {
               var6 = (String)var7.get(0);
               var8 = (String)var7.get(1);
               var1 = "";
            }
         } else {
            var8 = (String)var7.get(0);
            var1 = "";
         }

         this.getAuthService().setGigyaToken(var6, var1, var8);
      }

   }

   public final void setGoogleLive(boolean var1) {
      this.googleLive$delegate.setValue(this, $$delegatedProperties[22], var1);
   }

   public final void setGoogleLoginEnabled(boolean var1) {
      this.googleLoginEnabled$delegate.setValue(this, $$delegatedProperties[19], var1);
   }

   public final void setHomehost(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.getAuthService().setAblHomeHost(var1);
   }

   public final void setInUatMode(boolean var1) {
      this.inUatMode$delegate.setValue(this, $$delegatedProperties[24], var1);
   }

   public final void setLokalisePreRelease(boolean var1) {
      this.lokalisePreRelease$delegate.setValue(this, $$delegatedProperties[21], var1);
   }

   public final void setMaxLogFileSizeInMB(int var1) {
      this.maxLogFileSizeInMB$delegate.setValue(this, $$delegatedProperties[27], var1);
   }

   public final void setShowDetectCat(boolean var1) {
      this.showDetectCat$delegate.setValue(this, $$delegatedProperties[26], var1);
   }

   public final void setUatMode(boolean var1) {
      this.setInUatMode(var1);
      AuthService var3 = this.getAuthService();
      String var2;
      if (var1) {
         var2 = "https://api-uat.blueair.io/";
      } else {
         var2 = "https://api.blueair.io/";
      }

      var3.setAblHomeHost(var2);
   }

   public final void setUseDevKlaviyo(boolean var1) {
      this.useDevKlaviyo$delegate.setValue(this, $$delegatedProperties[25], var1);
   }

   public final void setUseGigyaSandbox(boolean var1) {
      this.useGigyaSandbox$delegate.setValue(this, $$delegatedProperties[30], var1);
   }

   public final void setWechatQQAppleLoginEnabled(boolean var1) {
      this.wechatQQAppleLoginEnabled$delegate.setValue(this, $$delegatedProperties[20], var1);
   }

   public final void setWelcomeHomeTestDevice(Device var1) {
      this.welcomeHomeTestDevice = var1;
   }

   public final void showNotification() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final DevSettingsViewModel this$0;

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
            NotificationService var3;
            label32: {
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = (NotificationService)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     break label32;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(2000L, var6) == var4) {
                     return var4;
                  }
               }

               var3 = this.this$0.getNotificationService();
               var1 = this.this$0.getDeviceManager();
               Continuation var5 = (Continuation)this;
               this.L$0 = var3;
               this.label = 2;
               var1 = (HasBlueCloudFunctions)var1.getBlueDevices(var5);
               if (var1 == var4) {
                  return var4;
               }
            }

            label23: {
               var1 = (HasBlueCloudFunctions)CollectionsKt.firstOrNull((List)var1);
               if (var1 != null) {
                  String var10 = var1.getUid();
                  var9 = var10;
                  if (var10 != null) {
                     break label23;
                  }
               }

               var9 = "";
            }

            var3.showNotification(var9, "Test Notification", "Click to open filter page", "filter");
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final void testWelcomeHome(Device var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, var2, var3, (Continuation)null) {
         final Device $device;
         final boolean $isEnter;
         final boolean $isMinRadius;
         int label;
         final DevSettingsViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$isMinRadius = var3;
            this.$isEnter = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$isMinRadius, this.$isEnter, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Continuation var11 = (Continuation)this;
               this.label = 1;
               if (DelayKt.delay(3000L, var11) == var5) {
                  return var5;
               }
            }

            WelcomeHomeBroadcastReceiver.Companion var10 = WelcomeHomeBroadcastReceiver.Companion;
            var1 = this.this$0.getDeviceManager();
            AnalyticsService var9 = this.this$0.getAnalyticsService();
            DeviceScheduleService var7 = this.this$0.getScheduleService();
            String var6 = this.$device.getUid();
            boolean var4 = this.$isMinRadius;
            boolean var3 = this.$isEnter;
            Continuation var8 = (Continuation)this;
            this.label = 2;
            if (var10.handleWelcomeHome(var1, var9, var7, var6, var4, var3, var8) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 3, (Object)null);
   }

   public final void toggleShouldShowRateUsDev() {
      this.getHappyUserService().setShouldShowDev(true);
   }

   public final void toggleShouldShowWHExploreDev() {
      this.getWelcomeHomeService().setShouldShowDev(true);
   }

   public final void uploadLog(IssueType var1, LogLength var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "length");
      Intrinsics.checkNotNullParameter(var3, "description");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, var3, (Continuation)null) {
         final String $description;
         final LogLength $length;
         final IssueType $type;
         Object L$0;
         int label;
         final DevSettingsViewModel this$0;

         {
            this.this$0 = var1;
            this.$type = var2;
            this.$length = var3;
            this.$description = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$type, this.$length, this.$description, var2));
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

               Application var3 = (Application)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Application var11 = this.this$0.getApplication();
               DeviceManager var10 = this.this$0.getDeviceManager();
               Context var5 = (Context)var11;
               IssueType var8 = this.$type;
               LogLength var13 = this.$length;
               String var9 = this.$description;
               ProgressListener var7 = new ProgressListener(this.this$0) {
                  final DevSettingsViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public void onFailure(Throwable var1) {
                     Intrinsics.checkNotNullParameter(var1, "t");
                     this.this$0._liveLogUploadError.postValue(var1.getLocalizedMessage());
                     Timber.Forest var2 = Timber.Forest;
                     StringBuilder var3 = new StringBuilder("UploadLog failed: ");
                     var3.append(var1.getMessage());
                     var2.e(var1, var3.toString(), new Object[0]);
                  }

                  public void update(long var1, long var3, boolean var5) {
                     int var6 = (int)((long)100 * var1 / var3);
                     this.this$0._liveLogUploadProgress.postValue(var6);
                     Timber.Forest var8 = Timber.Forest;
                     StringBuilder var7 = new StringBuilder("UploadLog: ");
                     var7.append(var6);
                     var7.append("% done");
                     var8.d(var7.toString(), new Object[0]);
                  }
               };
               Continuation var6 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var11);
               this.label = 1;
               Object var14 = var10.uploadLog(var5, var8, var13, var9, var7, var6);
               var1 = var14;
               if (var14 == var4) {
                  return var4;
               }
            }

            String var12 = (String)var1;
            Timber.Forest var16 = Timber.Forest;
            StringBuilder var15 = new StringBuilder("UploadLog uuid: ");
            var15.append(var12);
            var16.d(var15.toString(), new Object[0]);
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }
}
