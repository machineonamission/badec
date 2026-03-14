package com.blueair.auth;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000e\u0010B\u001a\u00020=H¦@¢\u0006\u0002\u0010CR\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0012\u0010\u0014\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R \u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0006R\u001a\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0006R\u001a\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0006R\u001a\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0006R\u001a\u00105\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0006R\u0012\u00107\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0006R\u0012\u0010<\u001a\u00020=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0012\u0010@\u001a\u00020=X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?¨\u0006DÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/auth/RemoteConfig;", "", "klaviyoAvailableCountries", "", "", "getKlaviyoAvailableCountries", "()Ljava/util/Set;", "tmallAvailableCounties", "getTmallAvailableCounties", "alexaUnavailableCounties", "getAlexaUnavailableCounties", "googleAssistantUnavailableCountries", "getGoogleAssistantUnavailableCountries", "googleAssistantClientId", "getGoogleAssistantClientId", "()Ljava/lang/String;", "googleAssistantDeeplink", "getGoogleAssistantDeeplink", "googleAssistantClientIdDev", "getGoogleAssistantClientIdDev", "googleAssistantDeeplinkDev", "getGoogleAssistantDeeplinkDev", "icpAvailableCountries", "getIcpAvailableCountries", "icpUnavailableCountries", "getIcpUnavailableCountries", "awareAvailableCountries", "getAwareAvailableCountries", "awareUnavailableCountries", "getAwareUnavailableCountries", "b4AvailableCounties", "getB4AvailableCounties", "g4AvailableCounties", "getG4AvailableCounties", "rateUsCountries", "getRateUsCountries", "rateUsPromo", "", "", "getRateUsPromo", "()Ljava/util/Map;", "warrantyCountries", "getWarrantyCountries", "googleLoginCountries", "getGoogleLoginCountries", "facebookLoginCountries", "getFacebookLoginCountries", "weChatLoginCountries", "getWeChatLoginCountries", "qqLoginCountries", "getQqLoginCountries", "welcomeHomeCountries", "getWelcomeHomeCountries", "g4ProtectCountries", "getG4ProtectCountries", "minSupportedVersion", "getMinSupportedVersion", "()J", "multiPassRules", "getMultiPassRules", "onboardingFilterSubscribeEnabled", "", "getOnboardingFilterSubscribeEnabled", "()Z", "offlineSupportEnabled", "getOfflineSupportEnabled", "forceUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface RemoteConfig {
   Object forceUpdate(Continuation var1);

   Set getAlexaUnavailableCounties();

   Set getAwareAvailableCountries();

   Set getAwareUnavailableCountries();

   Set getB4AvailableCounties();

   Set getFacebookLoginCountries();

   Set getG4AvailableCounties();

   Set getG4ProtectCountries();

   String getGoogleAssistantClientId();

   String getGoogleAssistantClientIdDev();

   String getGoogleAssistantDeeplink();

   String getGoogleAssistantDeeplinkDev();

   Set getGoogleAssistantUnavailableCountries();

   Set getGoogleLoginCountries();

   Set getIcpAvailableCountries();

   Set getIcpUnavailableCountries();

   Set getKlaviyoAvailableCountries();

   long getMinSupportedVersion();

   Set getMultiPassRules();

   boolean getOfflineSupportEnabled();

   boolean getOnboardingFilterSubscribeEnabled();

   Set getQqLoginCountries();

   Set getRateUsCountries();

   Map getRateUsPromo();

   Set getTmallAvailableCounties();

   Set getWarrantyCountries();

   Set getWeChatLoginCountries();

   Set getWelcomeHomeCountries();
}
