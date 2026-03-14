package com.blueair.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.messaging.RemoteMessage;
import com.klaviyo.analytics.Klaviyo;
import com.klaviyo.analytics.model.Profile;
import com.klaviyo.analytics.model.ProfileKey;
import com.klaviyo.analytics.model.ProfileKey.EMAIL;
import com.klaviyo.analytics.model.ProfileKey.EXTERNAL_ID;
import com.klaviyo.pushFcm.KlaviyoNotification;
import com.klaviyo.pushFcm.KlaviyoRemoteMessage;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020#J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/sdk/KlaviyoSdk;", "", "<init>", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "apiKey", "", "token", "email", "initialize", "", "context", "Landroid/app/Application;", "setProfile", "profileData", "Lcom/blueair/sdk/KlaviyoProfileData;", "setProfileLocation", "locationData", "Lcom/blueair/sdk/KlaviyoProfileLocationData;", "resetProfile", "setPushToken", "", "removePushToken", "handlePush", "intent", "Landroid/content/Intent;", "isKlaviyoMessage", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "displayNotification", "Landroid/content/Context;", "getDeeplink", "Landroid/net/Uri;", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class KlaviyoSdk {
   public static final KlaviyoSdk INSTANCE = new KlaviyoSdk();
   private static String apiKey = "";
   private static String email = "";
   private static boolean enabled = true;
   private static String token = "";

   private KlaviyoSdk() {
   }

   public final boolean displayNotification(RemoteMessage var1, Context var2) {
      Intrinsics.checkNotNullParameter(var1, "message");
      Intrinsics.checkNotNullParameter(var2, "context");
      if (!enabled) {
         return false;
      } else {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("displayNotification: ");
         var4.append(var1.getData());
         var3.d(var4.toString(), new Object[0]);
         if (KlaviyoRemoteMessage.INSTANCE.isKlaviyoNotification(var1)) {
            (new KlaviyoNotification(var1)).displayNotification(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   public final Uri getDeeplink(RemoteMessage var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      return KlaviyoRemoteMessage.INSTANCE.getDeepLink(var1);
   }

   public final boolean getEnabled() {
      return enabled;
   }

   public final void handlePush(Intent var1) {
      Intrinsics.checkNotNullParameter(var1, "intent");
      if (enabled) {
         Timber.Forest.d("handlePush", new Object[0]);
         Klaviyo.INSTANCE.handlePush(var1);
      }
   }

   public final void initialize(String var1, Application var2) {
      Intrinsics.checkNotNullParameter(var1, "apiKey");
      Intrinsics.checkNotNullParameter(var2, "context");
      if (enabled) {
         apiKey = var1;
         Klaviyo.INSTANCE.initialize(var1, (Context)var2);
      }
   }

   public final boolean isKlaviyoMessage(RemoteMessage var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      return !enabled ? false : KlaviyoRemoteMessage.INSTANCE.isKlaviyoMessage(var1);
   }

   public final void removePushToken() {
      if (enabled) {
         try {
            OkHttpClient var1 = new OkHttpClient();
            MediaType var2 = MediaType.Companion.parse("application/json");
            RequestBody.Companion var3 = RequestBody.Companion;
            StringBuilder var4 = new StringBuilder("\n            {\n              \"data\": {\n                \"type\": \"push-token-unregister\",\n                \"attributes\": {\n                  \"token\": \"");
            var4.append(token);
            var4.append("\",\n                  \"platform\": \"android\",\n                  \"vendor\": \"fcm\",\n                  \"profile\": {\n                    \"data\": {\n                      \"type\": \"profile\",\n                      \"attributes\": {\n                        \"email\": \"");
            var4.append(email);
            var4.append("\"\n                      }\n                    }\n                  }\n                }\n              }\n            }\n        ");
            RequestBody var10 = var3.create(StringsKt.trimIndent(var4.toString()), var2);
            Request.Builder var12 = new Request.Builder();
            StringBuilder var8 = new StringBuilder("https://a.klaviyo.com/client/push-token-unregister/?company_id=");
            var8.append(apiKey);
            Response var9 = var1.newCall(var12.url(var8.toString()).addHeader("accept", "application/json").addHeader("revision", "2024-02-15").addHeader("content-type", "application/json").post(var10).build()).execute();
            Timber.Forest var7 = Timber.Forest;
            StringBuilder var11 = new StringBuilder("removePushToken: ");
            var11.append(var9.code());
            var11.append(" | ");
            var11.append(var9.message());
            var7.d(var11.toString(), new Object[0]);
         } catch (Throwable var6) {
            Timber.Forest.e(var6, "removePushToken: runtime exception", new Object[0]);
            return;
         }
      }
   }

   public final void resetProfile() {
      if (enabled) {
         Timber.Forest.d("resetProfile", new Object[0]);
         Klaviyo.INSTANCE.resetProfile();
      }
   }

   public final void setEnabled(boolean var1) {
      enabled = var1;
   }

   public final void setProfile(KlaviyoProfileData var1) {
      Intrinsics.checkNotNullParameter(var1, "profileData");
      if (enabled) {
         email = var1.getEmail();
         Timber.Forest var2 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("setProfile: ");
         var3.append(var1);
         var2.d(var3.toString(), new Object[0]);
         Klaviyo var5 = Klaviyo.INSTANCE;
         Map var4 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EMAIL.INSTANCE, var1.getEmail()), TuplesKt.to(new ProfileKey.CUSTOM("language"), var1.getLanguage()), TuplesKt.to(new ProfileKey.CUSTOM("filterReplacement"), var1.getFilterReplacement()), TuplesKt.to(new ProfileKey.CUSTOM("quickAlarmStop"), var1.getQuickAlarmStop()), TuplesKt.to(new ProfileKey.CUSTOM("cleaningReminders"), var1.getCleaningReminders()), TuplesKt.to(new ProfileKey.CUSTOM("waterLevel"), var1.getWaterLevel()), TuplesKt.to(new ProfileKey.CUSTOM("marketingNotifications"), var1.getMarketingNotifications()), TuplesKt.to(new ProfileKey.CUSTOM("transactionalNotifications"), var1.getTransactionalNotifications())});
         if (var1.getGigyaUid() != null) {
            var4.put(EXTERNAL_ID.INSTANCE, var1.getGigyaUid());
         }

         var5.setProfile(new Profile(var4));
      }
   }

   public final void setProfileLocation(KlaviyoProfileLocationData var1) {
      Intrinsics.checkNotNullParameter(var1, "locationData");
      if (enabled) {
         Pair var5;
         Klaviyo var6;
         ProfileKey.CUSTOM var7;
         String var11;
         String var14;
         label22: {
            Timber.Forest var2 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("setProfileLocation: ");
            var3.append(var1);
            var2.d(var3.toString(), new Object[0]);
            var6 = Klaviyo.INSTANCE;
            var5 = TuplesKt.to(EMAIL.INSTANCE, var1.getEmail());
            var7 = new ProfileKey.CUSTOM("countryFromApp");
            String var10 = var1.getCountryCode();
            var14 = "";
            if (var10 != null) {
               String var4 = var10.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var4, "toLowerCase(...)");
               var11 = var4;
               if (var4 != null) {
                  break label22;
               }
            }

            var11 = "";
         }

         Pair var17 = TuplesKt.to(var7, var11);
         ProfileKey.CUSTOM var8 = new ProfileKey.CUSTOM("stateFromApp");
         String var15 = var1.getState();
         var11 = var15;
         if (var15 == null) {
            var11 = "";
         }

         Pair var13 = TuplesKt.to(var8, var11);
         ProfileKey.CUSTOM var16 = new ProfileKey.CUSTOM("cityFromApp");
         String var9 = var1.getCity();
         if (var9 == null) {
            var9 = var14;
         }

         var6.setProfile(new Profile(MapsKt.mutableMapOf(new Pair[]{var5, var17, var13, TuplesKt.to(var16, var9)})));
      }
   }

   public final Throwable setPushToken(String var1) {
      Intrinsics.checkNotNullParameter(var1, "token");
      if (!enabled) {
         return null;
      } else {
         token = var1;
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("setPushToken: ");
         var2.append(var1);
         var3.d(var2.toString(), new Object[0]);

         try {
            Klaviyo.INSTANCE.setPushToken(var1);
            return null;
         } catch (Throwable var5) {
            Timber.Forest.e(var5, "setPushToken: runtime exception", new Object[0]);
            return var5;
         }
      }
   }
}
