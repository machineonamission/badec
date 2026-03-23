package com.blueair.android.viewmodel;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.amplitude.api.Constants;
import com.blueair.auth.AuthService;
import com.blueair.auth.BlueCloudDomain;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.auth.RemoteConfig;
import com.blueair.core.AblEnvironment;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.Device;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceScheduleService;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.joda.time.DateTimeConstants;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020?J\b\u0010Ê\u0001\u001a\u00030È\u0001J\b\u0010Ë\u0001\u001a\u00030È\u0001J\u0011\u0010Ì\u0001\u001a\u00030È\u00012\u0007\u0010Í\u0001\u001a\u000202J\u001a\u0010Î\u0001\u001a\u00030È\u00012\u0007\u0010Ï\u0001\u001a\u00020?2\u0007\u0010Ð\u0001\u001a\u00020?J\u0019\u0010U\u001a\u00030È\u00012\u0007\u0010Ñ\u0001\u001a\u0002022\u0007\u0010Ò\u0001\u001a\u00020?J\u0011\u0010Ó\u0001\u001a\u00030È\u00012\u0007\u0010Ô\u0001\u001a\u00020[J\u001e\u0010Õ\u0001\u001a\u00030È\u00012\t\b\u0002\u0010Ò\u0001\u001a\u00020?2\t\b\u0002\u0010Ö\u0001\u001a\u000202J\b\u0010×\u0001\u001a\u00030È\u0001J\b\u0010Ø\u0001\u001a\u00030È\u0001J\b\u0010Ù\u0001\u001a\u00030È\u0001J\u0011\u0010Ú\u0001\u001a\u00030È\u00012\u0007\u0010Û\u0001\u001a\u000202J#\u0010Ü\u0001\u001a\u00030È\u00012\u0007\u0010Ý\u0001\u001a\u0002062\u0007\u0010Þ\u0001\u001a\u0002022\u0007\u0010ß\u0001\u001a\u000202J%\u0010à\u0001\u001a\u00030È\u00012\b\u0010á\u0001\u001a\u00030â\u00012\b\u0010ã\u0001\u001a\u00030ä\u00012\u0007\u0010å\u0001\u001a\u00020?J\b\u0010æ\u0001\u001a\u00030È\u0001J\b\u0010ç\u0001\u001a\u00030È\u0001J\u001c\u0010è\u0001\u001a\u00030È\u00012\b\u0010é\u0001\u001a\u00030ê\u00012\b\u0010ë\u0001\u001a\u00030ê\u0001J\n\u0010ì\u0001\u001a\u00030È\u0001H\u0014R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020605048F¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0011\u0010G\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bH\u0010BR\u0011\u0010I\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bJ\u0010BR\u0011\u0010K\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bL\u0010BR\u0011\u0010M\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bN\u0010BR\u0011\u0010O\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bP\u0010BR\u0011\u0010Q\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bR\u0010BR\u001a\u0010S\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010B\"\u0004\bU\u0010DR\u0011\u0010V\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bX\u0010WR\u0011\u0010Y\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bY\u0010WR\u0014\u0010Z\u001a\u00020[8BX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b_\u0010BR\u0011\u0010`\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\ba\u0010BR+\u0010c\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bd\u0010W\"\u0004\be\u0010fR+\u0010i\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bl\u0010h\u001a\u0004\bj\u0010W\"\u0004\bk\u0010fR+\u0010m\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bp\u0010h\u001a\u0004\bn\u0010W\"\u0004\bo\u0010fR+\u0010q\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bt\u0010h\u001a\u0004\br\u0010W\"\u0004\bs\u0010fR+\u0010u\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bx\u0010h\u001a\u0004\bv\u0010W\"\u0004\bw\u0010fR+\u0010y\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\b|\u0010h\u001a\u0004\bz\u0010W\"\u0004\b{\u0010fR,\u0010}\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0013\n\u0005\b\u0001\u0010h\u001a\u0004\b~\u0010W\"\u0004\b\u0010fR\u001b\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b \u0001\u0010h\u001a\u0005\b\u0001\u0010W\"\u0005\b\u0001\u0010fR/\u0010¡\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b¤\u0001\u0010h\u001a\u0005\b¢\u0001\u0010W\"\u0005\b£\u0001\u0010fR/\u0010¥\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b¨\u0001\u0010h\u001a\u0005\b¦\u0001\u0010W\"\u0005\b§\u0001\u0010fR/\u0010©\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b¬\u0001\u0010h\u001a\u0005\bª\u0001\u0010W\"\u0005\b«\u0001\u0010fR/\u0010­\u0001\u001a\u0002022\u0006\u0010b\u001a\u0002028F@FX\u0002¢\u0006\u0015\n\u0005\b°\u0001\u0010h\u001a\u0005\b®\u0001\u0010W\"\u0005\b¯\u0001\u0010fR3\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010b\u001a\u00030±\u00018F@FX\u0002¢\u0006\u0017\n\u0005\b·\u0001\u0010h\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R3\u0010¸\u0001\u001a\u00030±\u00012\u0007\u0010b\u001a\u00030±\u00018F@FX\u0002¢\u0006\u0017\n\u0005\b»\u0001\u0010h\u001a\u0006\b¹\u0001\u0010´\u0001\"\u0006\bº\u0001\u0010¶\u0001R3\u0010¼\u0001\u001a\u00030±\u00012\u0007\u0010b\u001a\u00030±\u00018F@FX\u0002¢\u0006\u0017\n\u0005\b¿\u0001\u0010h\u001a\u0006\b½\u0001\u0010´\u0001\"\u0006\b¾\u0001\u0010¶\u0001R!\u0010À\u0001\u001a\u0014\u0012\u000f\u0012\r Á\u0001*\u0005\u0018\u00010±\u00010±\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Â\u0001\u001a\t\u0012\u0005\u0012\u00030±\u000104¢\u0006\t\n\u0000\u001a\u0005\bÃ\u0001\u00108R\u001f\u0010Ä\u0001\u001a\u0012\u0012\r\u0012\u000b Á\u0001*\u0004\u0018\u00010?0?0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020?04¢\u0006\t\n\u0000\u001a\u0005\bÆ\u0001\u00108¨\u0006í\u0001"}, d2 = {"Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "scheduleService$delegate", "remoteConfig", "Lcom/blueair/auth/RemoteConfig;", "backendModified", "", "liveDevices", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "welcomeHomeTestDevice", "getWelcomeHomeTestDevice", "()Lcom/blueair/core/model/Device;", "setWelcomeHomeTestDevice", "(Lcom/blueair/core/model/Device;)V", "value", "", "homehost", "getHomehost", "()Ljava/lang/String;", "setHomehost", "(Ljava/lang/String;)V", "gigyaDataCenter", "getGigyaDataCenter", "gigyaCloudDomainRegion", "getGigyaCloudDomainRegion", "deviceRegion", "getDeviceRegion", "ipRegion", "getIpRegion", "gigyaToken", "getGigyaToken", "baseUrl", "getBaseUrl", "brokerBaseURL", "getBrokerBaseURL", "forceRegion", "getForceRegion", "setForceRegion", "isForceChina", "()Z", "isForceUSA", "isForceKorea", "defaultBlueCloudDomain", "Lcom/blueair/auth/BlueCloudDomain;", "getDefaultBlueCloudDomain", "()Lcom/blueair/auth/BlueCloudDomain;", "defaultUrl", "getDefaultUrl", "defaultBroker", "getDefaultBroker", "<set-?>", "forceIcpAvailable", "getForceIcpAvailable", "setForceIcpAvailable", "(Z)V", "forceIcpAvailable$delegate", "Lkotlin/properties/ReadWriteProperty;", "forceAwareAvailable", "getForceAwareAvailable", "setForceAwareAvailable", "forceAwareAvailable$delegate", "forceG4available", "getForceG4available", "setForceG4available", "forceG4available$delegate", "forceB4available", "getForceB4available", "setForceB4available", "forceB4available$delegate", "forceAlexaAvailable", "getForceAlexaAvailable", "setForceAlexaAvailable", "forceAlexaAvailable$delegate", "forceTmallAvailable", "getForceTmallAvailable", "setForceTmallAvailable", "forceTmallAvailable$delegate", "forceGAssistantAvailable", "getForceGAssistantAvailable", "setForceGAssistantAvailable", "forceGAssistantAvailable$delegate", "remoteConfigUpdated", "Landroidx/lifecycle/MutableLiveData;", "getRemoteConfigUpdated", "()Landroidx/lifecycle/MutableLiveData;", "amplitudeDebug", "getAmplitudeDebug", "setAmplitudeDebug", "amplitudeDebug$delegate", "forceWelcomeHome", "getForceWelcomeHome", "setForceWelcomeHome", "forceWelcomeHome$delegate", "facebookLoginEnabled", "getFacebookLoginEnabled", "setFacebookLoginEnabled", "facebookLoginEnabled$delegate", "googleLoginEnabled", "getGoogleLoginEnabled", "setGoogleLoginEnabled", "googleLoginEnabled$delegate", "wechatQQAppleLoginEnabled", "getWechatQQAppleLoginEnabled", "setWechatQQAppleLoginEnabled", "wechatQQAppleLoginEnabled$delegate", "lokalisePreRelease", "getLokalisePreRelease", "setLokalisePreRelease", "lokalisePreRelease$delegate", "googleLive", "getGoogleLive", "setGoogleLive", "googleLive$delegate", "alexaLive", "getAlexaLive", "setAlexaLive", "alexaLive$delegate", "inUatMode", "getInUatMode", "setInUatMode", "inUatMode$delegate", "useDevKlaviyo", "getUseDevKlaviyo", "setUseDevKlaviyo", "useDevKlaviyo$delegate", "showDetectCat", "getShowDetectCat", "setShowDetectCat", "showDetectCat$delegate", "", "maxLogFileSizeInMB", "getMaxLogFileSizeInMB", "()I", "setMaxLogFileSizeInMB", "(I)V", "maxLogFileSizeInMB$delegate", "aqiNotificationIntermittentInSecond", "getAqiNotificationIntermittentInSecond", "setAqiNotificationIntermittentInSecond", "aqiNotificationIntermittentInSecond$delegate", "aqiNotificationContinuousInSecond", "getAqiNotificationContinuousInSecond", "setAqiNotificationContinuousInSecond", "aqiNotificationContinuousInSecond$delegate", "_liveLogUploadProgress", "kotlin.jvm.PlatformType", "liveLogUploadProgress", "getLiveLogUploadProgress", "_liveLogUploadError", "liveLogUploadError", "getLiveLogUploadError", "setGigyaJwt", "", "token", "toggleShouldShowRateUsDev", "toggleShouldShowWHExploreDev", "reInitAmplitude", "debug", "changeBaseUrl", "nuUrl", "brokerURL", "force", "region", "setBackend", "blueCloudDomain", "forceBackend", "isRelease", "forceUpdateRemoteConfig", "showNotification", "resetUserInfoSyncTime", "setUatMode", "isUatMode", "testWelcomeHome", "device", "isMinRadius", "isEnter", "uploadLog", "type", "Lcom/blueair/core/model/IssueType;", "length", "Lcom/blueair/core/model/LogLength;", "description", "clearLogs", "revokeAqiDismission", "saveAqiThresold", "intermittent", "", "continuous", "onCleared", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevSettingsViewModel.kt */
public final class DevSettingsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _liveLogUploadError;
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _liveLogUploadProgress;
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
    private String forceRegion = "";
    private final ReadWriteProperty forceTmallAvailable$delegate;
    private final ReadWriteProperty forceWelcomeHome$delegate;
    private final Lazy gigyaService$delegate;
    private final ReadWriteProperty googleLive$delegate;
    private final ReadWriteProperty googleLoginEnabled$delegate;
    private final Lazy happyUserService$delegate;
    private final ReadWriteProperty inUatMode$delegate;
    private final LiveData<String> liveLogUploadError;
    private final LiveData<Integer> liveLogUploadProgress;
    private final Lazy locationService$delegate;
    private final ReadWriteProperty lokalisePreRelease$delegate;
    private final ReadWriteProperty maxLogFileSizeInMB$delegate;
    private final Lazy notificationService$delegate;
    private final Lazy prefs$delegate;
    /* access modifiers changed from: private */
    public final RemoteConfig remoteConfig = getGigyaService().getLocationService().getRemoteConfig();
    private final MutableLiveData<Boolean> remoteConfigUpdated;
    private final Lazy scheduleService$delegate;
    private final ReadWriteProperty showDetectCat$delegate;
    private final ReadWriteProperty useDevKlaviyo$delegate;
    private final ReadWriteProperty wechatQQAppleLoginEnabled$delegate;
    private final Lazy welcomeHomeService$delegate;
    private Device welcomeHomeTestDevice;

    static {
        Class<DevSettingsViewModel> cls = DevSettingsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "scheduleService", "getScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceIcpAvailable", "getForceIcpAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceAwareAvailable", "getForceAwareAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceG4available", "getForceG4available()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceB4available", "getForceB4available()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceAlexaAvailable", "getForceAlexaAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceTmallAvailable", "getForceTmallAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceGAssistantAvailable", "getForceGAssistantAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "amplitudeDebug", "getAmplitudeDebug()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "forceWelcomeHome", "getForceWelcomeHome()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "facebookLoginEnabled", "getFacebookLoginEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "googleLoginEnabled", "getGoogleLoginEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "wechatQQAppleLoginEnabled", "getWechatQQAppleLoginEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "lokalisePreRelease", "getLokalisePreRelease()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "googleLive", "getGoogleLive()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "alexaLive", "getAlexaLive()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "inUatMode", "getInUatMode()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "useDevKlaviyo", "getUseDevKlaviyo()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "showDetectCat", "getShowDetectCat()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "maxLogFileSizeInMB", "getMaxLogFileSizeInMB()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "aqiNotificationIntermittentInSecond", "getAqiNotificationIntermittentInSecond()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "aqiNotificationContinuousInSecond", "getAqiNotificationContinuousInSecond()I", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevSettingsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.gigyaService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, GigyaService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.happyUserService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, HappyUserService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.welcomeHomeService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken6, WelcomeHomeService.class), (Object) null).provideDelegate(this, kPropertyArr[5]);
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$7().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.notificationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken7, NotificationService.class), (Object) null).provideDelegate(this, kPropertyArr[6]);
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new DevSettingsViewModel$special$$inlined$instance$default$8().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.scheduleService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken8, DeviceScheduleService.class), (Object) null).provideDelegate(this, kPropertyArr[7]);
        Prefs prefs = getPrefs();
        this.forceIcpAvailable$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$1(prefs, PrefKeys.KEY_FORCE_ICP_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs.getBackend(), PrefKeys.KEY_FORCE_ICP_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs2 = getPrefs();
        this.forceAwareAvailable$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$2(prefs2, PrefKeys.KEY_FORCE_AWARE_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs2.getBackend(), PrefKeys.KEY_FORCE_AWARE_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs3 = getPrefs();
        this.forceG4available$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$3(prefs3, PrefKeys.KEY_FORCE_G4_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs3.getBackend(), PrefKeys.KEY_FORCE_G4_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs4 = getPrefs();
        this.forceB4available$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$4(prefs4, PrefKeys.KEY_FORCE_B4_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs4.getBackend(), PrefKeys.KEY_FORCE_B4_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs5 = getPrefs();
        this.forceAlexaAvailable$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$5(prefs5, PrefKeys.KEY_FORCE_ALEXA_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs5.getBackend(), PrefKeys.KEY_FORCE_ALEXA_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs6 = getPrefs();
        this.forceTmallAvailable$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$6(prefs6, PrefKeys.KEY_FORCE_TMALL_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs6.getBackend(), PrefKeys.KEY_FORCE_TMALL_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs7 = getPrefs();
        this.forceGAssistantAvailable$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$7(prefs7, PrefKeys.KEY_FORCE_GASSISTANT_AVAILABLE, false, PreferencesHelper.INSTANCE.get(prefs7.getBackend(), PrefKeys.KEY_FORCE_GASSISTANT_AVAILABLE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        this.remoteConfigUpdated = new MutableLiveData<>();
        Prefs prefs8 = getPrefs();
        this.amplitudeDebug$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$8(prefs8, PrefKeys.KEY_AMPLITUDE_DEBUG, false, PreferencesHelper.INSTANCE.get(prefs8.getBackend(), PrefKeys.KEY_AMPLITUDE_DEBUG, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs9 = getPrefs();
        this.forceWelcomeHome$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$9(prefs9, PrefKeys.KEY_FORCE_WELCOME_HOME, false, PreferencesHelper.INSTANCE.get(prefs9.getBackend(), PrefKeys.KEY_FORCE_WELCOME_HOME, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs10 = getPrefs();
        this.facebookLoginEnabled$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$10(prefs10, PrefKeys.KEY_FACEBOOK_LOGIN_ENABLED, false, PreferencesHelper.INSTANCE.get(prefs10.getBackend(), PrefKeys.KEY_FACEBOOK_LOGIN_ENABLED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs11 = getPrefs();
        this.googleLoginEnabled$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$11(prefs11, PrefKeys.KEY_GOOGLE_LOGIN_ENABLED, false, PreferencesHelper.INSTANCE.get(prefs11.getBackend(), PrefKeys.KEY_GOOGLE_LOGIN_ENABLED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs12 = getPrefs();
        this.wechatQQAppleLoginEnabled$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$12(prefs12, PrefKeys.KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED, false, PreferencesHelper.INSTANCE.get(prefs12.getBackend(), PrefKeys.KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs13 = getPrefs();
        this.lokalisePreRelease$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$13(prefs13, PrefKeys.KEY_LOKALISE_PRE_RELEASE, false, PreferencesHelper.INSTANCE.get(prefs13.getBackend(), PrefKeys.KEY_LOKALISE_PRE_RELEASE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs14 = getPrefs();
        this.googleLive$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$14(prefs14, PrefKeys.KEY_GOOGLE_LIVE, true, PreferencesHelper.INSTANCE.get(prefs14.getBackend(), PrefKeys.KEY_GOOGLE_LIVE, true, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs15 = getPrefs();
        this.alexaLive$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$15(prefs15, PrefKeys.KEY_ALEXA_LIVE, true, PreferencesHelper.INSTANCE.get(prefs15.getBackend(), PrefKeys.KEY_ALEXA_LIVE, true, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs16 = getPrefs();
        this.inUatMode$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$16(prefs16, PrefKeys.KEY_UAT_MODE, false, PreferencesHelper.INSTANCE.get(prefs16.getBackend(), PrefKeys.KEY_UAT_MODE, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs17 = getPrefs();
        this.useDevKlaviyo$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$17(prefs17, PrefKeys.KEY_DEV_KLAVIYO, false, PreferencesHelper.INSTANCE.get(prefs17.getBackend(), PrefKeys.KEY_DEV_KLAVIYO, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs18 = getPrefs();
        this.showDetectCat$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$18(prefs18, PrefKeys.KEY_SHOW_DETECT_CAT, false, PreferencesHelper.INSTANCE.get(prefs18.getBackend(), PrefKeys.KEY_SHOW_DETECT_CAT, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs19 = getPrefs();
        this.maxLogFileSizeInMB$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$19(prefs19, PrefKeys.KEY_MAX_LOG_FILE_SIZE, 100, PreferencesHelper.INSTANCE.get(prefs19.getBackend(), PrefKeys.KEY_MAX_LOG_FILE_SIZE, 100, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs20 = getPrefs();
        this.aqiNotificationIntermittentInSecond$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$20(prefs20, PrefKeys.KEY_NOTIFICATION_AQI_INTERMITTENT, 10, PreferencesHelper.INSTANCE.get(prefs20.getBackend(), PrefKeys.KEY_NOTIFICATION_AQI_INTERMITTENT, 10, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs21 = getPrefs();
        Integer valueOf = Integer.valueOf(DateTimeConstants.SECONDS_PER_DAY);
        this.aqiNotificationContinuousInSecond$delegate = new DevSettingsViewModel$special$$inlined$ObservablePreference$21(prefs21, PrefKeys.KEY_NOTIFICATION_AQI_CONTINUOUS, valueOf, PreferencesHelper.INSTANCE.get(prefs21.getBackend(), PrefKeys.KEY_NOTIFICATION_AQI_CONTINUOUS, valueOf, Reflection.getOrCreateKotlinClass(Integer.class)));
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._liveLogUploadProgress = mutableLiveData;
        this.liveLogUploadProgress = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>("");
        this._liveLogUploadError = mutableLiveData2;
        this.liveLogUploadError = mutableLiveData2;
        this.forceRegion = (String) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), com.blueair.auth.PrefKeys.CountryCodePref, "", Reflection.getOrCreateKotlinClass(String.class));
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final GigyaService getGigyaService() {
        return (GigyaService) this.gigyaService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    private final HappyUserService getHappyUserService() {
        return (HappyUserService) this.happyUserService$delegate.getValue();
    }

    private final Prefs getPrefs() {
        return (Prefs) this.prefs$delegate.getValue();
    }

    private final WelcomeHomeService getWelcomeHomeService() {
        return (WelcomeHomeService) this.welcomeHomeService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NotificationService getNotificationService() {
        return (NotificationService) this.notificationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceScheduleService getScheduleService() {
        return (DeviceScheduleService) this.scheduleService$delegate.getValue();
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return getDeviceManager().getLiveDevices();
    }

    public final Device getWelcomeHomeTestDevice() {
        return this.welcomeHomeTestDevice;
    }

    public final void setWelcomeHomeTestDevice(Device device) {
        this.welcomeHomeTestDevice = device;
    }

    public final String getHomehost() {
        return AblEnvironment.INSTANCE.getHost(getAuthService().getAblHomeHost());
    }

    public final void setHomehost(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        getAuthService().setAblHomeHost(str);
    }

    public final String getGigyaDataCenter() {
        return getGigyaService().getGigyaDataCenter();
    }

    public final String getGigyaCloudDomainRegion() {
        return getGigyaService().getGigyaBlueCloudDomain().regionCodeShort();
    }

    public final String getDeviceRegion() {
        return getLocationService().getDeviceRegion();
    }

    public final String getIpRegion() {
        return getLocationService().getCountry();
    }

    public final String getGigyaToken() {
        return StringsKt.trim(getAuthService().getUsername() + ':' + getGigyaService().getGigyaJwt(), ':');
    }

    public final String getBaseUrl() {
        return getAuthService().getBlueHomeHost();
    }

    public final String getBrokerBaseURL() {
        return getAuthService().getBlueBrokerURL();
    }

    public final String getForceRegion() {
        return this.forceRegion;
    }

    public final void setForceRegion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.forceRegion = str;
    }

    public final boolean isForceChina() {
        return Intrinsics.areEqual((Object) this.forceRegion, (Object) "cn");
    }

    public final boolean isForceUSA() {
        return Intrinsics.areEqual((Object) this.forceRegion, (Object) "us");
    }

    public final boolean isForceKorea() {
        return Intrinsics.areEqual((Object) this.forceRegion, (Object) "kr");
    }

    private final BlueCloudDomain getDefaultBlueCloudDomain() {
        return getGigyaService().getFallbackBlueCloudDomain();
    }

    public final String getDefaultUrl() {
        return getDefaultBlueCloudDomain().getHost();
    }

    public final String getDefaultBroker() {
        return getDefaultBlueCloudDomain().getMqttBroker();
    }

    public final boolean getForceIcpAvailable() {
        return ((Boolean) this.forceIcpAvailable$delegate.getValue(this, $$delegatedProperties[8])).booleanValue();
    }

    public final void setForceIcpAvailable(boolean z) {
        this.forceIcpAvailable$delegate.setValue(this, $$delegatedProperties[8], Boolean.valueOf(z));
    }

    public final boolean getForceAwareAvailable() {
        return ((Boolean) this.forceAwareAvailable$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public final void setForceAwareAvailable(boolean z) {
        this.forceAwareAvailable$delegate.setValue(this, $$delegatedProperties[9], Boolean.valueOf(z));
    }

    public final boolean getForceG4available() {
        return ((Boolean) this.forceG4available$delegate.getValue(this, $$delegatedProperties[10])).booleanValue();
    }

    public final void setForceG4available(boolean z) {
        this.forceG4available$delegate.setValue(this, $$delegatedProperties[10], Boolean.valueOf(z));
    }

    public final boolean getForceB4available() {
        return ((Boolean) this.forceB4available$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public final void setForceB4available(boolean z) {
        this.forceB4available$delegate.setValue(this, $$delegatedProperties[11], Boolean.valueOf(z));
    }

    public final boolean getForceAlexaAvailable() {
        return ((Boolean) this.forceAlexaAvailable$delegate.getValue(this, $$delegatedProperties[12])).booleanValue();
    }

    public final void setForceAlexaAvailable(boolean z) {
        this.forceAlexaAvailable$delegate.setValue(this, $$delegatedProperties[12], Boolean.valueOf(z));
    }

    public final boolean getForceTmallAvailable() {
        return ((Boolean) this.forceTmallAvailable$delegate.getValue(this, $$delegatedProperties[13])).booleanValue();
    }

    public final void setForceTmallAvailable(boolean z) {
        this.forceTmallAvailable$delegate.setValue(this, $$delegatedProperties[13], Boolean.valueOf(z));
    }

    public final boolean getForceGAssistantAvailable() {
        return ((Boolean) this.forceGAssistantAvailable$delegate.getValue(this, $$delegatedProperties[14])).booleanValue();
    }

    public final void setForceGAssistantAvailable(boolean z) {
        this.forceGAssistantAvailable$delegate.setValue(this, $$delegatedProperties[14], Boolean.valueOf(z));
    }

    public final MutableLiveData<Boolean> getRemoteConfigUpdated() {
        return this.remoteConfigUpdated;
    }

    public final boolean getAmplitudeDebug() {
        return ((Boolean) this.amplitudeDebug$delegate.getValue(this, $$delegatedProperties[15])).booleanValue();
    }

    public final void setAmplitudeDebug(boolean z) {
        this.amplitudeDebug$delegate.setValue(this, $$delegatedProperties[15], Boolean.valueOf(z));
    }

    public final boolean getForceWelcomeHome() {
        return ((Boolean) this.forceWelcomeHome$delegate.getValue(this, $$delegatedProperties[16])).booleanValue();
    }

    public final void setForceWelcomeHome(boolean z) {
        this.forceWelcomeHome$delegate.setValue(this, $$delegatedProperties[16], Boolean.valueOf(z));
    }

    public final boolean getFacebookLoginEnabled() {
        return ((Boolean) this.facebookLoginEnabled$delegate.getValue(this, $$delegatedProperties[17])).booleanValue();
    }

    public final void setFacebookLoginEnabled(boolean z) {
        this.facebookLoginEnabled$delegate.setValue(this, $$delegatedProperties[17], Boolean.valueOf(z));
    }

    public final boolean getGoogleLoginEnabled() {
        return ((Boolean) this.googleLoginEnabled$delegate.getValue(this, $$delegatedProperties[18])).booleanValue();
    }

    public final void setGoogleLoginEnabled(boolean z) {
        this.googleLoginEnabled$delegate.setValue(this, $$delegatedProperties[18], Boolean.valueOf(z));
    }

    public final boolean getWechatQQAppleLoginEnabled() {
        return ((Boolean) this.wechatQQAppleLoginEnabled$delegate.getValue(this, $$delegatedProperties[19])).booleanValue();
    }

    public final void setWechatQQAppleLoginEnabled(boolean z) {
        this.wechatQQAppleLoginEnabled$delegate.setValue(this, $$delegatedProperties[19], Boolean.valueOf(z));
    }

    public final boolean getLokalisePreRelease() {
        return ((Boolean) this.lokalisePreRelease$delegate.getValue(this, $$delegatedProperties[20])).booleanValue();
    }

    public final void setLokalisePreRelease(boolean z) {
        this.lokalisePreRelease$delegate.setValue(this, $$delegatedProperties[20], Boolean.valueOf(z));
    }

    public final boolean getGoogleLive() {
        return ((Boolean) this.googleLive$delegate.getValue(this, $$delegatedProperties[21])).booleanValue();
    }

    public final void setGoogleLive(boolean z) {
        this.googleLive$delegate.setValue(this, $$delegatedProperties[21], Boolean.valueOf(z));
    }

    public final boolean getAlexaLive() {
        return ((Boolean) this.alexaLive$delegate.getValue(this, $$delegatedProperties[22])).booleanValue();
    }

    public final void setAlexaLive(boolean z) {
        this.alexaLive$delegate.setValue(this, $$delegatedProperties[22], Boolean.valueOf(z));
    }

    public final boolean getInUatMode() {
        return ((Boolean) this.inUatMode$delegate.getValue(this, $$delegatedProperties[23])).booleanValue();
    }

    public final void setInUatMode(boolean z) {
        this.inUatMode$delegate.setValue(this, $$delegatedProperties[23], Boolean.valueOf(z));
    }

    public final boolean getUseDevKlaviyo() {
        return ((Boolean) this.useDevKlaviyo$delegate.getValue(this, $$delegatedProperties[24])).booleanValue();
    }

    public final void setUseDevKlaviyo(boolean z) {
        this.useDevKlaviyo$delegate.setValue(this, $$delegatedProperties[24], Boolean.valueOf(z));
    }

    public final boolean getShowDetectCat() {
        return ((Boolean) this.showDetectCat$delegate.getValue(this, $$delegatedProperties[25])).booleanValue();
    }

    public final void setShowDetectCat(boolean z) {
        this.showDetectCat$delegate.setValue(this, $$delegatedProperties[25], Boolean.valueOf(z));
    }

    public final int getMaxLogFileSizeInMB() {
        return ((Number) this.maxLogFileSizeInMB$delegate.getValue(this, $$delegatedProperties[26])).intValue();
    }

    public final void setMaxLogFileSizeInMB(int i) {
        this.maxLogFileSizeInMB$delegate.setValue(this, $$delegatedProperties[26], Integer.valueOf(i));
    }

    public final int getAqiNotificationIntermittentInSecond() {
        return ((Number) this.aqiNotificationIntermittentInSecond$delegate.getValue(this, $$delegatedProperties[27])).intValue();
    }

    public final void setAqiNotificationIntermittentInSecond(int i) {
        this.aqiNotificationIntermittentInSecond$delegate.setValue(this, $$delegatedProperties[27], Integer.valueOf(i));
    }

    public final int getAqiNotificationContinuousInSecond() {
        return ((Number) this.aqiNotificationContinuousInSecond$delegate.getValue(this, $$delegatedProperties[28])).intValue();
    }

    public final void setAqiNotificationContinuousInSecond(int i) {
        this.aqiNotificationContinuousInSecond$delegate.setValue(this, $$delegatedProperties[28], Integer.valueOf(i));
    }

    public final LiveData<Integer> getLiveLogUploadProgress() {
        return this.liveLogUploadProgress;
    }

    public final LiveData<String> getLiveLogUploadError() {
        return this.liveLogUploadError;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setGigyaJwt(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "token"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setGigyaJwt: "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            r4 = r12
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r12 = ":"
            java.lang.String[] r5 = new java.lang.String[]{r12}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r12 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            int r0 = r12.size()
            if (r0 == 0) goto L_0x006c
            java.lang.String r1 = ""
            r3 = 1
            if (r0 == r3) goto L_0x005e
            r4 = 2
            if (r0 == r4) goto L_0x004e
            java.lang.Object r0 = r12.get(r2)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r12.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r12 = r12.get(r4)
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x0065
        L_0x004e:
            java.lang.Object r0 = r12.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r12 = r12.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0065
        L_0x005e:
            java.lang.Object r12 = r12.get(r2)
            java.lang.String r12 = (java.lang.String) r12
            r0 = r1
        L_0x0065:
            com.blueair.auth.AuthService r2 = r11.getAuthService()
            r2.setGigyaToken(r1, r0, r12)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.DevSettingsViewModel.setGigyaJwt(java.lang.String):void");
    }

    public final void toggleShouldShowRateUsDev() {
        getHappyUserService().setShouldShowDev(true);
    }

    public final void toggleShouldShowWHExploreDev() {
        getWelcomeHomeService().setShouldShowDev(true);
    }

    public final void reInitAmplitude(boolean z) {
        getAnalyticsService().initAmplitude(z, getGigyaService().getLocationService().isInChina());
    }

    public final void changeBaseUrl(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "nuUrl");
        Intrinsics.checkNotNullParameter(str2, "brokerURL");
        if (URLUtil.isValidUrl(str)) {
            setBackend(BlueCloudDomain.copy$default(getGigyaService().getBlueCloudDomain(), str, (String) null, (String) null, str2, (String) null, 22, (Object) null));
        } else {
            BaseViewModel.showMessage$default(this, R.string.base_url_fail, (ViewUtils.MessageType) null, 2, (Object) null);
        }
    }

    public final void setForceRegion(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, Constants.AMP_TRACKING_OPTION_REGION);
        if (z) {
            this.forceRegion = str;
            PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), com.blueair.auth.PrefKeys.CountryCodePref, str, Reflection.getOrCreateKotlinClass(String.class));
        } else {
            this.forceRegion = "";
            getPrefs().remove(com.blueair.auth.PrefKeys.CountryCodePref);
        }
        showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
    }

    public final void setBackend(BlueCloudDomain blueCloudDomain) {
        Intrinsics.checkNotNullParameter(blueCloudDomain, "blueCloudDomain");
        getGigyaService().setForceBlueCloudDomain(blueCloudDomain);
        getAuthService().resetCloudJwt();
        getDeviceManager().logOut();
        this.backendModified = true;
        getAnalyticsService().setPropertyCloudRegion(getGigyaService().getBlueCloudDomain().tag());
        showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
    }

    public static /* synthetic */ void forceBackend$default(DevSettingsViewModel devSettingsViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = devSettingsViewModel.getGigyaService().getBlueCloudDomain().getRegionCode();
        }
        if ((i & 2) != 0) {
            z = StringsKt.endsWith$default(devSettingsViewModel.getGigyaService().getBlueCloudDomain().getHost(), "prod/", false, 2, (Object) null);
        }
        devSettingsViewModel.forceBackend(str, z);
    }

    public final void forceBackend(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.AMP_TRACKING_OPTION_REGION);
        setBackend(BlueCloudDomain.Companion.fromProvisionRegionCode(str, Boolean.valueOf(z)));
    }

    public final void forceUpdateRemoteConfig() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new DevSettingsViewModel$forceUpdateRemoteConfig$1(this, (Continuation<? super DevSettingsViewModel$forceUpdateRemoteConfig$1>) null), 3, (Object) null);
    }

    public final void showNotification() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new DevSettingsViewModel$showNotification$1(this, (Continuation<? super DevSettingsViewModel$showNotification$1>) null), 3, (Object) null);
    }

    public final void resetUserInfoSyncTime() {
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), PrefKeys.KEY_USER_INFO_COLLECTIONS_SYNC_TIME, 0L, Reflection.getOrCreateKotlinClass(Long.class));
        showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
    }

    public final void setUatMode(boolean z) {
        setInUatMode(z);
        getAuthService().setAblHomeHost(z ? AblEnvironment.UAT : AblEnvironment.PROD);
    }

    public final void testWelcomeHome(Device device, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DevSettingsViewModel$testWelcomeHome$1(this, device, z, z2, (Continuation<? super DevSettingsViewModel$testWelcomeHome$1>) null), 3, (Object) null);
    }

    public final void uploadLog(IssueType issueType, LogLength logLength, String str) {
        Intrinsics.checkNotNullParameter(issueType, "type");
        Intrinsics.checkNotNullParameter(logLength, "length");
        Intrinsics.checkNotNullParameter(str, "description");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DevSettingsViewModel$uploadLog$1(this, issueType, logLength, str, (Continuation<? super DevSettingsViewModel$uploadLog$1>) null), 2, (Object) null);
    }

    public final void clearLogs() {
        getDeviceManager().clearLogs(getApplication());
    }

    public final void revokeAqiDismission() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new DevSettingsViewModel$revokeAqiDismission$1(this, (Continuation<? super DevSettingsViewModel$revokeAqiDismission$1>) null), 2, (Object) null);
    }

    public final void saveAqiThresold(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "intermittent");
        Intrinsics.checkNotNullParameter(charSequence2, "continuous");
        Integer intOrNull = StringsKt.toIntOrNull(charSequence.toString());
        setAqiNotificationIntermittentInSecond(intOrNull != null ? intOrNull.intValue() : 10);
        Integer intOrNull2 = StringsKt.toIntOrNull(charSequence2.toString());
        setAqiNotificationContinuousInSecond(intOrNull2 != null ? intOrNull2.intValue() : DateTimeConstants.SECONDS_PER_DAY);
        showMessage(R.string.success, ViewUtils.MessageType.SUCCESS.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        if (this.backendModified) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getAuthService(), (CoroutineContext) null, (CoroutineStart) null, new DevSettingsViewModel$onCleared$1(this, (Continuation<? super DevSettingsViewModel$onCleared$1>) null), 3, (Object) null);
        }
    }
}
