package com.blueair.core.service;

import android.app.Application;
import android.os.Bundle;
import com.amplitude.api.Amplitude;
import com.amplitude.api.AmplitudeClient;
import com.amplitude.api.Identify;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.AmplitudeEventKt;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.OnboardingFlowEvent;
import com.blueair.core.model.OnboardingStartedEvent;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0019J$\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/core/service/AnalyticsService;", "", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "firebase", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebase", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebase$delegate", "Lkotlin/Lazy;", "amplitude", "Lcom/amplitude/api/AmplitudeClient;", "initAmplitude", "", "debug", "", "inChina", "event", "Lcom/blueair/core/model/AnalyticEvent;", "firebaseLog", "amplitudeLog", "onboardingId", "", "Lcom/blueair/core/model/AmplitudeEvent;", "setUserId", "ablUid", "gigyaUid", "cloudRegion", "setPropertyCloudRegion", "setWelcomeHomeEnabled", "enabled", "CrashlyticsTree", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AnalyticsService.kt */
public final class AnalyticsService {
    private static final String AMPLITUDE_DEBUG_KEY = "ad41433cbd2c7506305377c8db044ea1";
    private static final String AMPLITUDE_RELEASE_KEY = "077494ebdb38272b5ba3b7b4b5cc3f2f";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private AmplitudeClient amplitude;
    private final Application application;
    private final Lazy firebase$delegate = LazyKt.lazy(new AnalyticsService$$ExternalSyntheticLambda0(this));
    private String onboardingId;

    public AnalyticsService(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        this.application = application2;
        getFirebase().setUserProperty("versionCode", String.valueOf(BuildEnvironment.INSTANCE.getVersionCode()));
    }

    private final FirebaseAnalytics getFirebase() {
        return (FirebaseAnalytics) this.firebase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FirebaseAnalytics firebase_delegate$lambda$0(AnalyticsService analyticsService) {
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(analyticsService.application.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        instance.setAnalyticsCollectionEnabled(true);
        return instance;
    }

    public final void initAmplitude(boolean z, boolean z2) {
        String str = z ? AMPLITUDE_DEBUG_KEY : AMPLITUDE_RELEASE_KEY;
        AmplitudeClient amplitudeClient = this.amplitude;
        if (amplitudeClient == null || amplitudeClient.initialize(this.application.getApplicationContext(), str) == null) {
            AmplitudeClient instance = Amplitude.getInstance();
            if (z2) {
                instance.setServerUrl("api2.amplitude.com");
            }
            this.amplitude = instance.initialize(this.application.getApplicationContext(), str);
        }
        AmplitudeClient amplitudeClient2 = this.amplitude;
        if (amplitudeClient2 != null) {
            amplitudeClient2.enableForegroundTracking(this.application);
        }
    }

    public final void event(AnalyticEvent analyticEvent) {
        Intrinsics.checkNotNullParameter(analyticEvent, "event");
        firebaseLog(analyticEvent);
    }

    private final void firebaseLog(AnalyticEvent analyticEvent) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : analyticEvent.getPayload().entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof Integer) {
                bundle.putInt(str, ((Number) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(str, ((Number) value).longValue());
            } else if (value instanceof String) {
                bundle.putString(str, (String) value);
            } else if (value instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) value).booleanValue());
            } else {
                Timber.Forest forest = Timber.Forest;
                forest.e("firebaseLog: Event type not supported " + value, new Object[0]);
            }
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.v("firebaseLog: event: name = " + analyticEvent.getEventName() + ", bundle = " + bundle, new Object[0]);
        UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.USER_BEHAVIOR, analyticEvent.getEventName(), false, 4, (Object) null);
        getFirebase().logEvent(analyticEvent.getEventName(), bundle);
    }

    private final void amplitudeLog(AnalyticEvent analyticEvent) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : analyticEvent.getPayload().entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            try {
                if (value instanceof Integer) {
                    jSONObject.put(str, ((Number) value).intValue());
                } else if (value instanceof String) {
                    jSONObject.put(str, value);
                } else if (value instanceof Boolean) {
                    jSONObject.put(str, ((Boolean) value).booleanValue());
                } else {
                    Timber.Forest forest = Timber.Forest;
                    forest.e("amplitudeLog: Event type not supported " + value, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (JSONException e) {
                Timber.Forest.e(e.getLocalizedMessage(), new Object[0]);
            }
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.v("amplitudeLog: event: name = " + analyticEvent.getEventName() + ", json = " + jSONObject, new Object[0]);
        AmplitudeClient amplitudeClient = this.amplitude;
        if (amplitudeClient != null) {
            amplitudeClient.logEvent(analyticEvent.getEventName(), jSONObject);
        }
    }

    public final void amplitudeLog(AmplitudeEvent amplitudeEvent) {
        Set<Map.Entry<String, Object>> entrySet;
        Intrinsics.checkNotNullParameter(amplitudeEvent, "event");
        Timber.Forest.d("Logging amplitude event: %s", amplitudeEvent.toString());
        if (amplitudeEvent instanceof OnboardingStartedEvent) {
            this.onboardingId = UUID.randomUUID().toString();
        }
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> props = amplitudeEvent.getProps();
        if (!(props == null || (entrySet = props.entrySet()) == null)) {
            for (Map.Entry entry : entrySet) {
                try {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        jSONObject.put((String) entry.getKey(), ((Number) value).intValue());
                    } else if (value instanceof String) {
                        jSONObject.put((String) entry.getKey(), value);
                    } else if (value instanceof Boolean) {
                        jSONObject.put((String) entry.getKey(), ((Boolean) value).booleanValue());
                    } else {
                        Timber.Forest forest = Timber.Forest;
                        forest.e("amplitudeLog: Event type not supported " + value, new Object[0]);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (JSONException e) {
                    Timber.Forest.e(e.getLocalizedMessage(), new Object[0]);
                }
            }
        }
        if (amplitudeEvent instanceof OnboardingFlowEvent) {
            jSONObject.put(AmplitudeEventKt.PROP_ONBOARDING_ID, this.onboardingId);
        }
        AmplitudeClient amplitudeClient = this.amplitude;
        if (amplitudeClient != null) {
            amplitudeClient.logEvent(amplitudeEvent.getEventName(), jSONObject);
        }
    }

    public final void setUserId(String str, String str2, String str3) {
        getFirebase().setUserId(str);
        getFirebase().setUserProperty("gigyaUid", str2);
        getFirebase().setUserProperty("cloudRegion", str3);
        AmplitudeClient amplitudeClient = this.amplitude;
        if (amplitudeClient != null) {
            amplitudeClient.setUserId(str2);
        }
    }

    public final void setPropertyCloudRegion(String str) {
        getFirebase().setUserProperty("cloudRegion", str);
    }

    public final void setWelcomeHomeEnabled(boolean z) {
        String str = z ? AmplitudeEventKt.WELCOME_HOME_ENABLED : AmplitudeEventKt.WELCOME_HOME_DISABLED;
        AmplitudeClient amplitudeClient = this.amplitude;
        if (amplitudeClient != null) {
            amplitudeClient.identify(new Identify().set(AmplitudeEventKt.USER_PROP_WELCOME_HOME, str));
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/blueair/core/service/AnalyticsService$CrashlyticsTree;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "log", "", "priority", "", "tag", "", "message", "t", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticsService.kt */
    public static final class CrashlyticsTree extends Timber.Tree {
        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, "message");
            if (i != 2 && i != 3 && i != 4 && i != 5) {
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                if (th == null) {
                    th = new Exception(str2);
                }
                instance.recordException(th);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/core/service/AnalyticsService$Companion;", "", "<init>", "()V", "AMPLITUDE_DEBUG_KEY", "", "AMPLITUDE_RELEASE_KEY", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticsService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
