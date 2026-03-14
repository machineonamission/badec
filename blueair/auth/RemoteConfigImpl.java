package com.blueair.auth;

import com.google.android.gms.tasks.OnCompleteListener;
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
import kotlin.Result;
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
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0002J\u0018\u0010H\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010G\u001a\u00020\bH\u0003J$\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002HJ\u0018\u00010)\"\u0004\b\u0000\u0010J2\u0006\u0010G\u001a\u00020\bH\u0002J.\u0010K\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002HJ0)0)\"\u0004\b\u0000\u0010J2\u0006\u0010G\u001a\u00020\bH\u0002J\u000e\u0010L\u001a\u00020AH\u0096@¢\u0006\u0002\u0010MR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\nR\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u001c\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\nR\"\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020*\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\nR\u001c\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\nR\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\nR\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\nR\u001c\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\nR\u001c\u00107\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\nR\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\nR\u0014\u0010;\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\nR\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010C¨\u0006O"},
   d2 = {"Lcom/blueair/auth/RemoteConfigImpl;", "Lcom/blueair/auth/RemoteConfig;", "<init>", "()V", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "klaviyoAvailableCountries", "", "", "getKlaviyoAvailableCountries", "()Ljava/util/Set;", "tmallAvailableCounties", "getTmallAvailableCounties", "alexaUnavailableCounties", "getAlexaUnavailableCounties", "googleAssistantUnavailableCountries", "getGoogleAssistantUnavailableCountries", "googleAssistantClientId", "getGoogleAssistantClientId", "()Ljava/lang/String;", "googleAssistantDeeplink", "getGoogleAssistantDeeplink", "googleAssistantClientIdDev", "getGoogleAssistantClientIdDev", "googleAssistantDeeplinkDev", "getGoogleAssistantDeeplinkDev", "icpAvailableCountries", "getIcpAvailableCountries", "icpUnavailableCountries", "getIcpUnavailableCountries", "awareAvailableCountries", "getAwareAvailableCountries", "awareUnavailableCountries", "getAwareUnavailableCountries", "b4AvailableCounties", "getB4AvailableCounties", "g4AvailableCounties", "getG4AvailableCounties", "rateUsCountries", "getRateUsCountries", "rateUsPromo", "", "", "getRateUsPromo", "()Ljava/util/Map;", "warrantyCountries", "getWarrantyCountries", "googleLoginCountries", "getGoogleLoginCountries", "facebookLoginCountries", "getFacebookLoginCountries", "weChatLoginCountries", "getWeChatLoginCountries", "qqLoginCountries", "getQqLoginCountries", "welcomeHomeCountries", "getWelcomeHomeCountries", "g4ProtectCountries", "getG4ProtectCountries", "minSupportedVersion", "getMinSupportedVersion", "()J", "multiPassRules", "getMultiPassRules", "onboardingFilterSubscribeEnabled", "", "getOnboardingFilterSubscribeEnabled", "()Z", "offlineSupportEnabled", "getOfflineSupportEnabled", "getStringByKey", "key", "getSetByKey", "getMapByKey", "T", "getNestedMapByKey", "forceUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RemoteConfigImpl implements RemoteConfig {
   private static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @Deprecated
   public static final String KEY_ALEXA_UNAVAILABLE_COUNTRIES = "alexa_unavailable_countries";
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
   public static final String KEY_WECHAT_LOGIN_COUNTRIES = "wechat_login_countries";
   @Deprecated
   public static final String KEY_WELCOME_HOME_COUNTRIES = "welcome_home_countries";
   private final FirebaseRemoteConfig remoteConfig;

   // $FF: synthetic method
   public static Unit $r8$lambda$wC8rr3DlDwjMX6yGp8UEXLz11J4(FirebaseRemoteConfigSettings.Builder var0) {
      return remoteConfig$lambda$1$lambda$0(var0);
   }

   public RemoteConfigImpl() {
      FirebaseRemoteConfig var1 = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
      var1.setDefaultsAsync(R.xml.remote_config_defaults);
      var1.setConfigSettingsAsync(RemoteConfigKt.remoteConfigSettings(new RemoteConfigImpl$$ExternalSyntheticLambda0()));
      var1.fetchAndActivate();
      this.remoteConfig = var1;
   }

   private final Map getMapByKey(String var1) {
      Map var2 = (Map)(new LinkedHashMap());

      label31: {
         Exception var10000;
         label30: {
            JSONObject var3;
            try {
               var3 = new JSONObject(RemoteConfigKt.get(this.remoteConfig, var1).asString());
               var7 = var3.keys();
               Intrinsics.checkNotNullExpressionValue(var7, "keys(...)");
            } catch (Exception var6) {
               var10000 = var6;
               boolean var10001 = false;
               break label30;
            }

            while(true) {
               try {
                  if (!var7.hasNext()) {
                     break label31;
                  }

                  String var4 = (String)var7.next();
                  var2.put(var4, var3.get(var4));
               } catch (Exception var5) {
                  var10000 = var5;
                  boolean var10 = false;
                  break;
               }
            }
         }

         Exception var8 = var10000;
         Timber.Forest.e((Throwable)var8);
      }

      Map var9;
      if (!var2.isEmpty()) {
         var9 = var2;
      } else {
         var9 = null;
      }

      return var9;
   }

   private final Map getNestedMapByKey(String var1) {
      Map var2 = (Map)(new LinkedHashMap());

      Exception var10000;
      label42: {
         JSONObject var3;
         try {
            var3 = new JSONObject(RemoteConfigKt.get(this.remoteConfig, var1).asString());
            var13 = var3.keys();
            Intrinsics.checkNotNullExpressionValue(var13, "keys(...)");
         } catch (Exception var12) {
            var10000 = var12;
            boolean var10001 = false;
            break label42;
         }

         label39:
         while(true) {
            String var4;
            JSONObject var6;
            Map var8;
            Iterator var15;
            try {
               if (!var13.hasNext()) {
                  return var2;
               }

               var4 = (String)var13.next();
               LinkedHashMap var5 = new LinkedHashMap();
               var8 = (Map)var5;
               var6 = var3.getJSONObject(var4);
               var15 = var6.keys();
               Intrinsics.checkNotNullExpressionValue(var15, "keys(...)");
            } catch (Exception var10) {
               var10000 = var10;
               boolean var16 = false;
               break;
            }

            while(true) {
               try {
                  if (!var15.hasNext()) {
                     break;
                  }

                  String var7 = (String)var15.next();
                  var8.put(var7, var6.get(var7));
               } catch (Exception var11) {
                  var10000 = var11;
                  boolean var17 = false;
                  break label39;
               }
            }

            try {
               var2.put(var4, var8);
            } catch (Exception var9) {
               var10000 = var9;
               boolean var18 = false;
               break;
            }
         }
      }

      Exception var14 = var10000;
      Timber.Forest.e((Throwable)var14);
      return var2;
   }

   private final Set getSetByKey(String var1) {
      var1 = RemoteConfigKt.get(this.remoteConfig, var1).asString();
      Intrinsics.checkNotNull(var1);
      if (!StringsKt.contains$default((CharSequence)var1, (CharSequence)"\"", false, 2, (Object)null)) {
         var1 = null;
      }

      if (var1 != null) {
         var1 = StringsKt.drop(var1, 1);
         if (var1 != null) {
            var1 = StringsKt.dropLast(var1, 1);
            if (var1 != null) {
               var1 = StringsKt.replace$default(var1, "\"", "", false, 4, (Object)null);
               if (var1 != null) {
                  var1 = StringsKt.replace$default(var1, " ", "", false, 4, (Object)null);
                  if (var1 != null) {
                     var1 = StringsKt.replace$default(var1, "\n", "", false, 4, (Object)null);
                     if (var1 != null) {
                        var1 = var1.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
                        if (var1 != null) {
                           List var9 = StringsKt.split$default((CharSequence)var1, new String[]{","}, false, 0, 6, (Object)null);
                           if (var9 != null) {
                              Set var10 = CollectionsKt.toMutableSet((Iterable)var9);
                              var10.remove("");
                              return var10;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return null;
   }

   private final String getStringByKey(String var1) {
      var1 = RemoteConfigKt.get(this.remoteConfig, var1).asString();
      Intrinsics.checkNotNullExpressionValue(var1, "asString(...)");
      return StringsKt.trim(var1, new char[]{'"'});
   }

   private static final Unit remoteConfig$lambda$1$lambda$0(FirebaseRemoteConfigSettings.Builder var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$remoteConfigSettings");
      var0.setMinimumFetchIntervalInSeconds(3600L);
      return Unit.INSTANCE;
   }

   public Object forceUpdate(Continuation var1) {
      SafeContinuation var4 = new SafeContinuation(IntrinsicsKt.intercepted(var1));
      Continuation var3 = (Continuation)var4;
      FirebaseRemoteConfig var2 = this.remoteConfig;
      var2.fetch(0L).addOnCompleteListener(new OnCompleteListener(var2, var3) {
         final Continuation $cont;
         final FirebaseRemoteConfig $this_with;

         {
            this.$this_with = var1;
            this.$cont = var2;
         }

         public final void onComplete(Task var1) {
            Intrinsics.checkNotNullParameter(var1, "fetchTask");
            if (var1.isSuccessful()) {
               this.$this_with.activate().addOnCompleteListener(new OnCompleteListener(this.$cont) {
                  final Continuation $cont;

                  {
                     this.$cont = var1;
                  }

                  public final void onComplete(Task var1) {
                     Intrinsics.checkNotNullParameter(var1, "activateTask");
                     if (var1.isSuccessful()) {
                        Continuation var4 = this.$cont;
                        Result.Companion var5 = Result.Companion;
                        var4.resumeWith(Result.constructor-impl(true));
                     } else {
                        Continuation var2 = this.$cont;
                        Result.Companion var3 = Result.Companion;
                        var2.resumeWith(Result.constructor-impl(false));
                     }
                  }
               });
            } else {
               Continuation var3 = this.$cont;
               Result.Companion var2 = Result.Companion;
               var3.resumeWith(Result.constructor-impl(false));
            }
         }
      });
      Object var5 = var4.getOrThrow();
      if (var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
         DebugProbesKt.probeCoroutineSuspended(var1);
      }

      return var5;
   }

   public Set getAlexaUnavailableCounties() {
      return this.getSetByKey("alexa_unavailable_countries");
   }

   public Set getAwareAvailableCountries() {
      return this.getSetByKey("aware_available_countries");
   }

   public Set getAwareUnavailableCountries() {
      return this.getSetByKey("aware_unavailable_countries");
   }

   public Set getB4AvailableCounties() {
      return this.getSetByKey("b4_available_countries");
   }

   public Set getFacebookLoginCountries() {
      return this.getSetByKey("facebook_login_countries");
   }

   public Set getG4AvailableCounties() {
      return this.getSetByKey("g4_available_countries");
   }

   public Set getG4ProtectCountries() {
      return this.getSetByKey("g4_protect_countries");
   }

   public String getGoogleAssistantClientId() {
      String var1 = RemoteConfigKt.get(this.remoteConfig, "google_assistant_client_id").asString();
      Intrinsics.checkNotNullExpressionValue(var1, "asString(...)");
      return var1;
   }

   public String getGoogleAssistantClientIdDev() {
      String var1 = RemoteConfigKt.get(this.remoteConfig, "google_assistant_client_id_dev").asString();
      Intrinsics.checkNotNullExpressionValue(var1, "asString(...)");
      return var1;
   }

   public String getGoogleAssistantDeeplink() {
      String var1 = RemoteConfigKt.get(this.remoteConfig, "google_assistant_deeplink").asString();
      Intrinsics.checkNotNullExpressionValue(var1, "asString(...)");
      return var1;
   }

   public String getGoogleAssistantDeeplinkDev() {
      String var1 = RemoteConfigKt.get(this.remoteConfig, "google_assistant_deeplink_dev").asString();
      Intrinsics.checkNotNullExpressionValue(var1, "asString(...)");
      return var1;
   }

   public Set getGoogleAssistantUnavailableCountries() {
      return this.getSetByKey("google_assistant_unavailable_countries");
   }

   public Set getGoogleLoginCountries() {
      return this.getSetByKey("google_login_countries");
   }

   public Set getIcpAvailableCountries() {
      return this.getSetByKey("icp_available_countries");
   }

   public Set getIcpUnavailableCountries() {
      return this.getSetByKey("icp_unavailable_countries");
   }

   public Set getKlaviyoAvailableCountries() {
      return this.getSetByKey("klaviyo_available_countries");
   }

   public long getMinSupportedVersion() {
      return RemoteConfigKt.get(this.remoteConfig, "min_supported_version_android").asLong();
   }

   public Set getMultiPassRules() {
      Set var2 = this.getSetByKey("multipass_rules");
      Set var1 = var2;
      if (var2 == null) {
         var1 = SetsKt.emptySet();
      }

      return var1;
   }

   public boolean getOfflineSupportEnabled() {
      return this.remoteConfig.getBoolean("offline_support_enabled");
   }

   public boolean getOnboardingFilterSubscribeEnabled() {
      return this.remoteConfig.getBoolean("onboarding_filter_subscribe_enabled");
   }

   public Set getQqLoginCountries() {
      return this.getSetByKey("qq_login_countries");
   }

   public Set getRateUsCountries() {
      return this.getSetByKey("rate_us_countries");
   }

   public Map getRateUsPromo() {
      Map var2 = this.getMapByKey("rate_us_countries_promo");
      if (var2 == null) {
         return null;
      } else {
         Map var1 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var2.size())));

         for(Map.Entry var3 : (Iterable)var2.entrySet()) {
            var1.put(var3.getKey(), ((Number)var3.getValue()).longValue() * 1000L);
         }

         return var1;
      }
   }

   public Set getTmallAvailableCounties() {
      return this.getSetByKey("tmall_available_countries");
   }

   public Set getWarrantyCountries() {
      return this.getSetByKey("warranty_countries");
   }

   public Set getWeChatLoginCountries() {
      return this.getSetByKey("wechat_login_countries");
   }

   public Set getWelcomeHomeCountries() {
      return this.getSetByKey("welcome_home_countries");
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "},
      d2 = {"Lcom/blueair/auth/RemoteConfigImpl$Companion;", "", "<init>", "()V", "KEY_KLAVIYO_AVAILABLE_COUNTRIES", "", "KEY_TMALL_AVAILABLE_COUNTRIES", "KEY_ALEXA_UNAVAILABLE_COUNTRIES", "KEY_GASSISTANT_UNAVAILABLE_COUNTRIES", "KEY_GASSISTANT_CLIENT_ID", "KEY_GASSISTANT_DEEPLINK", "KEY_GASSISTANT_CLIENT_ID_DEV", "KEY_GASSISTANT_DEEPLINK_DEV", "KEY_ICP_AVAILABLE_COUNTRIES", "KEY_ICP_UNAVAILABLE_COUNTRIES", "KEY_AWARE_AVAILABLE_COUNTRIES", "KEY_AWARE_UNAVAILABLE_COUNTRIES", "KEY_B4_AVAILABLE_COUNTRIES", "KEY_G4_AVAILABLE_COUNTRIES", "KEY_RATE_US_COUNTRIES", "KEY_RATE_US_PROMO", "KEY_WARRANTY_COUNTRIES", "KEY_GOOGLE_LOGIN_COUNTRIES", "KEY_FACEBOOK_LOGIN_COUNTRIES", "KEY_WECHAT_LOGIN_COUNTRIES", "KEY_QQ_LOGIN_COUNTRIES", "KEY_WELCOME_HOME_COUNTRIES", "KEY_G4_PROTECT_COUNTRIES", "KEY_MIN_SUPPORTED_VERSION", "KEY_MULTIPASS_RULES", "KEY_ONBOARDING_FILTER_SUBSCRIBE_ENABLED", "KEY_OFFLINE_SUPPORT_ENABLED", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
