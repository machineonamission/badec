package com.blueair.auth;

import com.blueair.core.util.LinkUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0002J\u0018\u0010L\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010K\u001a\u00020\bH\u0003J$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002HN\u0018\u00010+\"\u0004\b\u0000\u0010N2\u0006\u0010K\u001a\u00020\bH\u0002J.\u0010O\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002HN0+0+\"\u0004\b\u0000\u0010N2\u0006\u0010K\u001a\u00020\bH\u0002J\u000e\u0010P\u001a\u00020EH@¢\u0006\u0002\u0010QR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\nR\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u001c\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\nR\u001c\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\nR\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,\u0018\u00010+8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\nR\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\nR\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\nR\u001c\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\nR\u001c\u00107\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\nR\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\nR\u001c\u0010;\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\nR\u0014\u0010=\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R,\u0010@\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0+0+8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010.R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\nR\u0014\u0010D\u001a\u00020E8VX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010G¨\u0006S"}, d2 = {"Lcom/blueair/auth/RemoteConfigImpl;", "Lcom/blueair/auth/RemoteConfig;", "<init>", "()V", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "klaviyoAvailableCountries", "", "", "getKlaviyoAvailableCountries", "()Ljava/util/Set;", "tmallAvailableCounties", "getTmallAvailableCounties", "alexaUnavailableCounties", "getAlexaUnavailableCounties", "googleAssistantUnavailableCountries", "getGoogleAssistantUnavailableCountries", "googleAssistantClientId", "getGoogleAssistantClientId", "()Ljava/lang/String;", "googleAssistantDeeplink", "getGoogleAssistantDeeplink", "googleAssistantClientIdDev", "getGoogleAssistantClientIdDev", "googleAssistantDeeplinkDev", "getGoogleAssistantDeeplinkDev", "icpAvailableCountries", "getIcpAvailableCountries", "icpUnavailableCountries", "getIcpUnavailableCountries", "awareAvailableCountries", "getAwareAvailableCountries", "awareUnavailableCountries", "getAwareUnavailableCountries", "b4AvailableCounties", "getB4AvailableCounties", "g4AvailableCounties", "getG4AvailableCounties", "antiFakeSupportedDeviceSku", "getAntiFakeSupportedDeviceSku", "rateUsCountries", "getRateUsCountries", "rateUsPromo", "", "", "getRateUsPromo", "()Ljava/util/Map;", "warrantyCountries", "getWarrantyCountries", "googleLoginCountries", "getGoogleLoginCountries", "facebookLoginCountries", "getFacebookLoginCountries", "weChatLoginCountries", "getWeChatLoginCountries", "qqLoginCountries", "getQqLoginCountries", "welcomeHomeCountries", "getWelcomeHomeCountries", "g4ProtectCountries", "getG4ProtectCountries", "minSupportedVersion", "getMinSupportedVersion", "()J", "webLinks", "getWebLinks", "multiPassRules", "getMultiPassRules", "onboardingFilterSubscribeEnabled", "", "getOnboardingFilterSubscribeEnabled", "()Z", "offlineSupportEnabled", "getOfflineSupportEnabled", "getStringByKey", "key", "getSetByKey", "getMapByKey", "T", "getNestedMapByKey", "forceUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RemoteConfigImpl.kt */
public final class RemoteConfigImpl implements RemoteConfig {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String KEY_ALEXA_UNAVAILABLE_COUNTRIES = "alexa_unavailable_countries";
    @Deprecated
    public static final String KEY_ANTI_FAKE_SUPPORTED_DEVICE_SKU = "anti_fake_supported_device_sku";
    @Deprecated
    public static final String KEY_AWARE_AVAILABLE_COUNTRIES = "aware_available_countries";
    @Deprecated
    public static final String KEY_AWARE_UNAVAILABLE_COUNTRIES = "aware_unavailable_countries";
    @Deprecated
    public static final String KEY_B4_AVAILABLE_COUNTRIES = "b4_available_countries";
    @Deprecated
    public static final String KEY_FACEBOOK_LOGIN_COUNTRIES = "facebook_login_countries";
    @Deprecated
    public static final String KEY_G4_AVAILABLE_COUNTRIES = "g4_available_countries";
    @Deprecated
    public static final String KEY_G4_PROTECT_COUNTRIES = "g4_protect_countries";
    @Deprecated
    public static final String KEY_GASSISTANT_CLIENT_ID = "google_assistant_client_id";
    @Deprecated
    public static final String KEY_GASSISTANT_CLIENT_ID_DEV = "google_assistant_client_id_dev";
    @Deprecated
    public static final String KEY_GASSISTANT_DEEPLINK = "google_assistant_deeplink";
    @Deprecated
    public static final String KEY_GASSISTANT_DEEPLINK_DEV = "google_assistant_deeplink_dev";
    @Deprecated
    public static final String KEY_GASSISTANT_UNAVAILABLE_COUNTRIES = "google_assistant_unavailable_countries";
    @Deprecated
    public static final String KEY_GOOGLE_LOGIN_COUNTRIES = "google_login_countries";
    @Deprecated
    public static final String KEY_ICP_AVAILABLE_COUNTRIES = "icp_available_countries";
    @Deprecated
    public static final String KEY_ICP_UNAVAILABLE_COUNTRIES = "icp_unavailable_countries";
    @Deprecated
    public static final String KEY_KLAVIYO_AVAILABLE_COUNTRIES = "klaviyo_available_countries";
    @Deprecated
    public static final String KEY_MIN_SUPPORTED_VERSION = "min_supported_version_android";
    @Deprecated
    public static final String KEY_MULTIPASS_RULES = "multipass_rules";
    @Deprecated
    public static final String KEY_OFFLINE_SUPPORT_ENABLED = "offline_support_enabled";
    @Deprecated
    public static final String KEY_ONBOARDING_FILTER_SUBSCRIBE_ENABLED = "onboarding_filter_subscribe_enabled";
    @Deprecated
    public static final String KEY_QQ_LOGIN_COUNTRIES = "qq_login_countries";
    @Deprecated
    public static final String KEY_RATE_US_COUNTRIES = "rate_us_countries";
    @Deprecated
    public static final String KEY_RATE_US_PROMO = "rate_us_countries_promo";
    @Deprecated
    public static final String KEY_TMALL_AVAILABLE_COUNTRIES = "tmall_available_countries";
    @Deprecated
    public static final String KEY_WARRANTY_COUNTRIES = "warranty_countries";
    @Deprecated
    public static final String KEY_WEB_LINKS = "web_links_v2";
    @Deprecated
    public static final String KEY_WECHAT_LOGIN_COUNTRIES = "wechat_login_countries";
    @Deprecated
    public static final String KEY_WELCOME_HOME_COUNTRIES = "welcome_home_countries";
    private final FirebaseRemoteConfig remoteConfig;

    public RemoteConfigImpl() {
        FirebaseRemoteConfig remoteConfig2 = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
        remoteConfig2.setDefaultsAsync(R.xml.remote_config_defaults);
        remoteConfig2.setConfigSettingsAsync(RemoteConfigKt.remoteConfigSettings(new RemoteConfigImpl$$ExternalSyntheticLambda0()));
        remoteConfig2.fetchAndActivate().addOnCompleteListener(new RemoteConfigImpl$$ExternalSyntheticLambda1(this));
        this.remoteConfig = remoteConfig2;
    }

    /* access modifiers changed from: private */
    public static final Unit remoteConfig$lambda$2$lambda$0(FirebaseRemoteConfigSettings.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$remoteConfigSettings");
        builder.setMinimumFetchIntervalInSeconds(3600);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void remoteConfig$lambda$2$lambda$1(RemoteConfigImpl remoteConfigImpl, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            LinkUtils.INSTANCE.init(remoteConfigImpl.getWebLinks());
        }
    }

    public Set<String> getKlaviyoAvailableCountries() {
        return getSetByKey(KEY_KLAVIYO_AVAILABLE_COUNTRIES);
    }

    public Set<String> getTmallAvailableCounties() {
        return getSetByKey(KEY_TMALL_AVAILABLE_COUNTRIES);
    }

    public Set<String> getAlexaUnavailableCounties() {
        return getSetByKey(KEY_ALEXA_UNAVAILABLE_COUNTRIES);
    }

    public Set<String> getGoogleAssistantUnavailableCountries() {
        return getSetByKey(KEY_GASSISTANT_UNAVAILABLE_COUNTRIES);
    }

    public String getGoogleAssistantClientId() {
        String asString = RemoteConfigKt.get(this.remoteConfig, KEY_GASSISTANT_CLIENT_ID).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public String getGoogleAssistantDeeplink() {
        String asString = RemoteConfigKt.get(this.remoteConfig, KEY_GASSISTANT_DEEPLINK).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public String getGoogleAssistantClientIdDev() {
        String asString = RemoteConfigKt.get(this.remoteConfig, KEY_GASSISTANT_CLIENT_ID_DEV).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public String getGoogleAssistantDeeplinkDev() {
        String asString = RemoteConfigKt.get(this.remoteConfig, KEY_GASSISTANT_DEEPLINK_DEV).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public Set<String> getIcpAvailableCountries() {
        return getSetByKey(KEY_ICP_AVAILABLE_COUNTRIES);
    }

    public Set<String> getIcpUnavailableCountries() {
        return getSetByKey(KEY_ICP_UNAVAILABLE_COUNTRIES);
    }

    public Set<String> getAwareAvailableCountries() {
        return getSetByKey(KEY_AWARE_AVAILABLE_COUNTRIES);
    }

    public Set<String> getAwareUnavailableCountries() {
        return getSetByKey(KEY_AWARE_UNAVAILABLE_COUNTRIES);
    }

    public Set<String> getB4AvailableCounties() {
        return getSetByKey(KEY_B4_AVAILABLE_COUNTRIES);
    }

    public Set<String> getG4AvailableCounties() {
        return getSetByKey(KEY_G4_AVAILABLE_COUNTRIES);
    }

    public Set<String> getAntiFakeSupportedDeviceSku() {
        Set<String> setByKey = getSetByKey(KEY_ANTI_FAKE_SUPPORTED_DEVICE_SKU);
        return setByKey == null ? SetsKt.emptySet() : setByKey;
    }

    public Set<String> getRateUsCountries() {
        return getSetByKey(KEY_RATE_US_COUNTRIES);
    }

    public Map<String, Long> getRateUsPromo() {
        Map mapByKey = getMapByKey(KEY_RATE_US_PROMO);
        if (mapByKey == null) {
            return null;
        }
        Map<String, Long> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(mapByKey.size()));
        for (Map.Entry entry : mapByKey.entrySet()) {
            linkedHashMap.put(entry.getKey(), Long.valueOf(((Number) entry.getValue()).longValue() * 1000));
        }
        return linkedHashMap;
    }

    public Set<String> getWarrantyCountries() {
        return getSetByKey(KEY_WARRANTY_COUNTRIES);
    }

    public Set<String> getGoogleLoginCountries() {
        return getSetByKey(KEY_GOOGLE_LOGIN_COUNTRIES);
    }

    public Set<String> getFacebookLoginCountries() {
        return getSetByKey(KEY_FACEBOOK_LOGIN_COUNTRIES);
    }

    public Set<String> getWeChatLoginCountries() {
        return getSetByKey(KEY_WECHAT_LOGIN_COUNTRIES);
    }

    public Set<String> getQqLoginCountries() {
        return getSetByKey(KEY_QQ_LOGIN_COUNTRIES);
    }

    public Set<String> getWelcomeHomeCountries() {
        return getSetByKey(KEY_WELCOME_HOME_COUNTRIES);
    }

    public Set<String> getG4ProtectCountries() {
        return getSetByKey(KEY_G4_PROTECT_COUNTRIES);
    }

    public long getMinSupportedVersion() {
        return RemoteConfigKt.get(this.remoteConfig, KEY_MIN_SUPPORTED_VERSION).asLong();
    }

    public Map<String, Map<String, String>> getWebLinks() {
        return getNestedMapByKey(KEY_WEB_LINKS);
    }

    public Set<String> getMultiPassRules() {
        Set<String> setByKey = getSetByKey(KEY_MULTIPASS_RULES);
        return setByKey == null ? SetsKt.emptySet() : setByKey;
    }

    public boolean getOnboardingFilterSubscribeEnabled() {
        return this.remoteConfig.getBoolean(KEY_ONBOARDING_FILTER_SUBSCRIBE_ENABLED);
    }

    public boolean getOfflineSupportEnabled() {
        return this.remoteConfig.getBoolean(KEY_OFFLINE_SUPPORT_ENABLED);
    }

    private final String getStringByKey(String str) {
        String asString = RemoteConfigKt.get(this.remoteConfig, str).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return StringsKt.trim(asString, '\"');
    }

    private final Set<String> getSetByKey(String str) {
        String drop;
        String dropLast;
        String replace$default;
        String replace$default2;
        String replace$default3;
        List split$default;
        String asString = RemoteConfigKt.get(this.remoteConfig, str).asString();
        Intrinsics.checkNotNull(asString);
        if (!StringsKt.contains$default((CharSequence) asString, (CharSequence) "\"", false, 2, (Object) null)) {
            asString = null;
        }
        if (!(asString == null || (drop = StringsKt.drop(asString, 1)) == null || (dropLast = StringsKt.dropLast(drop, 1)) == null || (replace$default = StringsKt.replace$default(dropLast, "\"", "", false, 4, (Object) null)) == null || (replace$default2 = StringsKt.replace$default(replace$default, " ", "", false, 4, (Object) null)) == null || (replace$default3 = StringsKt.replace$default(replace$default2, (String) IOUtils.LINE_SEPARATOR_UNIX, "", false, 4, (Object) null)) == null)) {
            String lowerCase = replace$default3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!(lowerCase == null || (split$default = StringsKt.split$default((CharSequence) lowerCase, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
                Set<String> mutableSet = CollectionsKt.toMutableSet(split$default);
                mutableSet.remove("");
                return mutableSet;
            }
        }
        return null;
    }

    private final <T> Map<String, T> getMapByKey(String str) {
        Map<String, T> linkedHashMap = new LinkedHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(RemoteConfigKt.get(this.remoteConfig, str).asString());
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.get(next));
            }
        } catch (Exception e) {
            Timber.Forest.e(e);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        return null;
    }

    private final <T> Map<String, Map<String, T>> getNestedMapByKey(String str) {
        Map<String, Map<String, T>> linkedHashMap = new LinkedHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(RemoteConfigKt.get(this.remoteConfig, str).asString());
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                Map linkedHashMap2 = new LinkedHashMap();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                Iterator<String> keys2 = jSONObject2.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "keys(...)");
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    linkedHashMap2.put(next2, jSONObject2.get(next2));
                }
                linkedHashMap.put(next, linkedHashMap2);
            }
            return linkedHashMap;
        } catch (Exception e) {
            Timber.Forest.e(e);
            return linkedHashMap;
        }
    }

    public Object forceUpdate(Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        FirebaseRemoteConfig firebaseRemoteConfig = this.remoteConfig;
        firebaseRemoteConfig.fetch(0).addOnCompleteListener(new RemoteConfigImpl$forceUpdate$2$1$1(firebaseRemoteConfig, safeContinuation, this));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/auth/RemoteConfigImpl$Companion;", "", "<init>", "()V", "KEY_KLAVIYO_AVAILABLE_COUNTRIES", "", "KEY_TMALL_AVAILABLE_COUNTRIES", "KEY_ALEXA_UNAVAILABLE_COUNTRIES", "KEY_GASSISTANT_UNAVAILABLE_COUNTRIES", "KEY_GASSISTANT_CLIENT_ID", "KEY_GASSISTANT_DEEPLINK", "KEY_GASSISTANT_CLIENT_ID_DEV", "KEY_GASSISTANT_DEEPLINK_DEV", "KEY_ICP_AVAILABLE_COUNTRIES", "KEY_ICP_UNAVAILABLE_COUNTRIES", "KEY_AWARE_AVAILABLE_COUNTRIES", "KEY_AWARE_UNAVAILABLE_COUNTRIES", "KEY_B4_AVAILABLE_COUNTRIES", "KEY_G4_AVAILABLE_COUNTRIES", "KEY_ANTI_FAKE_SUPPORTED_DEVICE_SKU", "KEY_RATE_US_COUNTRIES", "KEY_RATE_US_PROMO", "KEY_WARRANTY_COUNTRIES", "KEY_GOOGLE_LOGIN_COUNTRIES", "KEY_FACEBOOK_LOGIN_COUNTRIES", "KEY_WECHAT_LOGIN_COUNTRIES", "KEY_QQ_LOGIN_COUNTRIES", "KEY_WELCOME_HOME_COUNTRIES", "KEY_G4_PROTECT_COUNTRIES", "KEY_MIN_SUPPORTED_VERSION", "KEY_WEB_LINKS", "KEY_MULTIPASS_RULES", "KEY_ONBOARDING_FILTER_SUBSCRIBE_ENABLED", "KEY_OFFLINE_SUPPORT_ENABLED", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: RemoteConfigImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
