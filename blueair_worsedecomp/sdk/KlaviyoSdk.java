package com.blueair.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.RemoteMessage;
import com.klaviyo.analytics.Klaviyo;
import com.klaviyo.analytics.model.Profile;
import com.klaviyo.analytics.model.ProfileKey;
import com.klaviyo.analytics.networking.requests.KlaviyoApiRequest;
import com.klaviyo.pushFcm.KlaviyoNotification;
import com.klaviyo.pushFcm.KlaviyoRemoteMessage;
import com.mapbox.common.HttpHeaders;
import java.util.Map;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020#J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/sdk/KlaviyoSdk;", "", "<init>", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "apiKey", "", "token", "email", "initialize", "", "context", "Landroid/app/Application;", "setProfile", "profileData", "Lcom/blueair/sdk/KlaviyoProfileData;", "setProfileLocation", "locationData", "Lcom/blueair/sdk/KlaviyoProfileLocationData;", "resetProfile", "setPushToken", "", "removePushToken", "handlePush", "intent", "Landroid/content/Intent;", "isKlaviyoMessage", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "displayNotification", "Landroid/content/Context;", "getDeeplink", "Landroid/net/Uri;", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: KlaviyoSdk.kt */
public final class KlaviyoSdk {
    public static final KlaviyoSdk INSTANCE = new KlaviyoSdk();
    private static String apiKey = "";
    private static String email = "";
    private static boolean enabled = true;
    private static String token = "";

    private KlaviyoSdk() {
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean z) {
        enabled = z;
    }

    public final void initialize(String str, Application application) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(application, "context");
        if (enabled) {
            apiKey = str;
            Klaviyo.INSTANCE.initialize(str, application);
        }
    }

    public final void setProfile(KlaviyoProfileData klaviyoProfileData) {
        Intrinsics.checkNotNullParameter(klaviyoProfileData, "profileData");
        if (enabled) {
            email = klaviyoProfileData.getEmail();
            Timber.Forest forest = Timber.Forest;
            forest.d("setProfile: " + klaviyoProfileData, new Object[0]);
            Klaviyo klaviyo = Klaviyo.INSTANCE;
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(ProfileKey.EMAIL.INSTANCE, klaviyoProfileData.getEmail()), TuplesKt.to(new ProfileKey.CUSTOM("language"), klaviyoProfileData.getLanguage()), TuplesKt.to(new ProfileKey.CUSTOM("filterReplacement"), Integer.valueOf(klaviyoProfileData.getFilterReplacement())), TuplesKt.to(new ProfileKey.CUSTOM("quickAlarmStop"), Integer.valueOf(klaviyoProfileData.getQuickAlarmStop())), TuplesKt.to(new ProfileKey.CUSTOM("cleaningReminders"), Integer.valueOf(klaviyoProfileData.getCleaningReminders())), TuplesKt.to(new ProfileKey.CUSTOM("waterLevel"), Integer.valueOf(klaviyoProfileData.getWaterLevel())), TuplesKt.to(new ProfileKey.CUSTOM("marketingNotifications"), Integer.valueOf(klaviyoProfileData.getMarketingNotifications())), TuplesKt.to(new ProfileKey.CUSTOM("transactionalNotifications"), Integer.valueOf(klaviyoProfileData.getTransactionalNotifications())));
            if (klaviyoProfileData.getGigyaUid() != null) {
                mutableMapOf.put(ProfileKey.EXTERNAL_ID.INSTANCE, klaviyoProfileData.getGigyaUid());
            }
            klaviyo.setProfile(new Profile(mutableMapOf));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004d, code lost:
        if (r4 == null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setProfileLocation(com.blueair.sdk.KlaviyoProfileLocationData r8) {
        /*
            r7 = this;
            java.lang.String r0 = "locationData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = enabled
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setProfileLocation: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            com.klaviyo.analytics.Klaviyo r0 = com.klaviyo.analytics.Klaviyo.INSTANCE
            com.klaviyo.analytics.model.Profile r1 = new com.klaviyo.analytics.model.Profile
            r3 = 4
            kotlin.Pair[] r3 = new kotlin.Pair[r3]
            com.klaviyo.analytics.model.ProfileKey$EMAIL r4 = com.klaviyo.analytics.model.ProfileKey.EMAIL.INSTANCE
            java.lang.String r5 = r8.getEmail()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r3[r2] = r4
            com.klaviyo.analytics.model.ProfileKey$CUSTOM r2 = new com.klaviyo.analytics.model.ProfileKey$CUSTOM
            java.lang.String r4 = "countryFromApp"
            r2.<init>(r4)
            java.lang.String r4 = r8.getCountryCode()
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x004f
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r6)
            java.lang.String r6 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            if (r4 != 0) goto L_0x0050
        L_0x004f:
            r4 = r5
        L_0x0050:
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r4)
            r4 = 1
            r3[r4] = r2
            com.klaviyo.analytics.model.ProfileKey$CUSTOM r2 = new com.klaviyo.analytics.model.ProfileKey$CUSTOM
            java.lang.String r4 = "stateFromApp"
            r2.<init>(r4)
            java.lang.String r4 = r8.getState()
            if (r4 != 0) goto L_0x0065
            r4 = r5
        L_0x0065:
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r4)
            r4 = 2
            r3[r4] = r2
            com.klaviyo.analytics.model.ProfileKey$CUSTOM r2 = new com.klaviyo.analytics.model.ProfileKey$CUSTOM
            java.lang.String r4 = "cityFromApp"
            r2.<init>(r4)
            java.lang.String r8 = r8.getCity()
            if (r8 != 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r5 = r8
        L_0x007b:
            kotlin.Pair r8 = kotlin.TuplesKt.to(r2, r5)
            r2 = 3
            r3[r2] = r8
            java.util.Map r8 = kotlin.collections.MapsKt.mutableMapOf(r3)
            r1.<init>(r8)
            r0.setProfile(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.sdk.KlaviyoSdk.setProfileLocation(com.blueair.sdk.KlaviyoProfileLocationData):void");
    }

    public final void resetProfile() {
        if (enabled) {
            Timber.Forest.d("resetProfile", new Object[0]);
            Klaviyo.INSTANCE.resetProfile();
        }
    }

    public final Throwable setPushToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        if (!enabled) {
            return null;
        }
        token = str;
        Timber.Forest forest = Timber.Forest;
        forest.d("setPushToken: " + str, new Object[0]);
        try {
            Klaviyo.INSTANCE.setPushToken(str);
            return null;
        } catch (Throwable th) {
            Timber.Forest.e(th, "setPushToken: runtime exception", new Object[0]);
            return th;
        }
    }

    public final void removePushToken() {
        if (enabled) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                MediaType parse = MediaType.Companion.parse(KlaviyoApiRequest.TYPE_JSON);
                RequestBody.Companion companion = RequestBody.Companion;
                RequestBody create = companion.create(StringsKt.trimIndent("\n            {\n              \"data\": {\n                \"type\": \"push-token-unregister\",\n                \"attributes\": {\n                  \"token\": \"" + token + "\",\n                  \"platform\": \"android\",\n                  \"vendor\": \"fcm\",\n                  \"profile\": {\n                    \"data\": {\n                      \"type\": \"profile\",\n                      \"attributes\": {\n                        \"email\": \"" + email + "\"\n                      }\n                    }\n                  }\n                }\n              }\n            }\n        "), parse);
                Request.Builder builder = new Request.Builder();
                StringBuilder sb = new StringBuilder("https://a.klaviyo.com/client/push-token-unregister/?company_id=");
                sb.append(apiKey);
                Response execute = okHttpClient.newCall(builder.url(sb.toString()).addHeader(HttpHeaders.ACCEPT, KlaviyoApiRequest.TYPE_JSON).addHeader("revision", "2024-02-15").addHeader("content-type", KlaviyoApiRequest.TYPE_JSON).post(create).build()).execute();
                Timber.Forest forest = Timber.Forest;
                forest.d("removePushToken: " + execute.code() + " | " + execute.message(), new Object[0]);
            } catch (Throwable th) {
                Timber.Forest.e(th, "removePushToken: runtime exception", new Object[0]);
            }
        }
    }

    public final void handlePush(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        if (enabled) {
            Timber.Forest.d("handlePush", new Object[0]);
            Klaviyo.INSTANCE.handlePush(intent);
        }
    }

    public final boolean isKlaviyoMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "message");
        if (!enabled) {
            return false;
        }
        return KlaviyoRemoteMessage.INSTANCE.isKlaviyoMessage(remoteMessage);
    }

    public final boolean displayNotification(RemoteMessage remoteMessage, Context context) {
        Intrinsics.checkNotNullParameter(remoteMessage, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!enabled) {
            return false;
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("displayNotification: " + remoteMessage.getData(), new Object[0]);
        if (!KlaviyoRemoteMessage.INSTANCE.isKlaviyoNotification(remoteMessage)) {
            return false;
        }
        new KlaviyoNotification(remoteMessage).displayNotification(context);
        return true;
    }

    public final Uri getDeeplink(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "message");
        return KlaviyoRemoteMessage.INSTANCE.getDeepLink(remoteMessage);
    }
}
