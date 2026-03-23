package com.blueair.push;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.util.PhoneUtil;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.sdk.FirebaseSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0015\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001eJ-\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J(\u0010\u001f\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0007J$\u0010)\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/blueair/push/NotificationService;", "", "context", "Landroid/content/Context;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Landroid/content/Context;Lcom/blueair/auth/AuthService;)V", "useFCM", "", "getUseFCM", "()Z", "enabled", "getEnabled", "pushToken", "", "getPushToken", "()Ljava/lang/String;", "requestCode", "", "getRequestCode", "()I", "_requestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "smallIcon", "initialize", "", "createNotificationChannel", "setNotificationToken", "token", "setNotificationToken$push_otherRelease", "showNotification", "userId", "deviceId", "templateId", "params", "Lorg/json/JSONObject;", "showNotification$push_otherRelease", "title", "message", "actionType", "showStopAlarmNotification", "body", "Companion", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationService.kt */
public final class NotificationService {
    public static final String ACTION_DEVICE_DETAILS = "device_details";
    public static final String ACTION_TYPE_FILTER = "filter";
    public static final String ACTION_TYPE_FILTER_PURCHASE = "filter_purchase";
    public static final String ACTION_TYPE_FILTER_STATUS = "filter_status";
    public static final String ACTION_TYPE_REFRESHER_PURCHASE = "refresher_purchase";
    public static final String ACTION_TYPE_REFRESHER_STATUS = "refresher_status";
    public static final String ACTION_TYPE_STOP_ALARM = "stop_alarm";
    public static final String ACTION_TYPE_WICK_PURCHASE = "wick_purchase";
    public static final String ACTION_TYPE_WICK_STATUS = "wick_status";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TEMPLATE_ALARM_STOP = "alarm_stop";
    private static final String TEMPLATE_FILTER_DOOR_OPEN = "filter_door_open";
    private static final String TEMPLATE_FILTER_USAGE_REPLACE = "filter_usage_replace";
    private static final String TEMPLATE_FILTER_USAGE_REPLACE_URGENT = "filter_usage_replace_urgent";
    private static final String TEMPLATE_PREFILTER_USAGE_CLEAN = "prefilter_usage_clean";
    private static final String TEMPLATE_REFRESHER_USAGE_REPLACE = "ywrm_usage_replace";
    private static final String TEMPLATE_REFRESHER_USAGE_REPLACE_URGENT = "ywrm_usage_replace_urgent";
    private static final String TEMPLATE_WATER_SHORTAGE = "water_shortage";
    private static final String TEMPLATE_WATER_TANK_FAILURE = "water_tank_failure";
    private static final String TEMPLATE_WATER_TANK_FULL = "water_full";
    private static final String TEMPLATE_WICK_USAGE_REPLACE = "wick_usage_replace";
    private static final String TEMPLATE_WICK_USAGE_REPLACE_URGENT = "wick_usage_replace_urgent";
    private final AtomicInteger _requestCode = new AtomicInteger(0);
    private final AuthService authService;
    private final Context context;
    private final boolean enabled;
    private final int smallIcon;
    private final boolean useFCM;

    public NotificationService(Context context2, AuthService authService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.context = context2;
        this.authService = authService2;
        boolean z = !BuildEnvironment.INSTANCE.isChina();
        this.useFCM = z;
        this.enabled = z;
        this.smallIcon = PhoneUtil.INSTANCE.isGoogleServicesAvailable(context2) ? R.drawable.ic_notification : R.drawable.ic_launcher;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/blueair/push/NotificationService$Companion;", "", "<init>", "()V", "TEMPLATE_PREFILTER_USAGE_CLEAN", "", "TEMPLATE_FILTER_USAGE_REPLACE", "TEMPLATE_FILTER_USAGE_REPLACE_URGENT", "TEMPLATE_WICK_USAGE_REPLACE", "TEMPLATE_WICK_USAGE_REPLACE_URGENT", "TEMPLATE_REFRESHER_USAGE_REPLACE", "TEMPLATE_REFRESHER_USAGE_REPLACE_URGENT", "TEMPLATE_WATER_SHORTAGE", "TEMPLATE_WATER_TANK_FULL", "TEMPLATE_WATER_TANK_FAILURE", "TEMPLATE_ALARM_STOP", "TEMPLATE_FILTER_DOOR_OPEN", "ACTION_DEVICE_DETAILS", "ACTION_TYPE_FILTER", "ACTION_TYPE_FILTER_STATUS", "ACTION_TYPE_FILTER_PURCHASE", "ACTION_TYPE_WICK_STATUS", "ACTION_TYPE_WICK_PURCHASE", "ACTION_TYPE_REFRESHER_STATUS", "ACTION_TYPE_REFRESHER_PURCHASE", "ACTION_TYPE_STOP_ALARM", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getUseFCM() {
        return this.useFCM;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getPushToken() {
        return this.authService.getPushToken();
    }

    private final int getRequestCode() {
        return this._requestCode.getAndIncrement();
    }

    public final void initialize() {
        if (this.enabled) {
            createNotificationChannel();
            if (this.useFCM) {
                FirebaseSdk.INSTANCE.getMessagingToken(new NotificationService$$ExternalSyntheticLambda3(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit initialize$lambda$0(NotificationService notificationService, Result result) {
        if (Result.m9373isSuccessimpl(result.m9375unboximpl())) {
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder("Firebase token = ");
            Object r2 = result.m9375unboximpl();
            if (Result.m9372isFailureimpl(r2)) {
                r2 = null;
            }
            sb.append((String) r2);
            forest.d(sb.toString(), new Object[0]);
            Object r5 = result.m9375unboximpl();
            if (Result.m9372isFailureimpl(r5)) {
                r5 = "";
            }
            notificationService.setNotificationToken$push_otherRelease((String) r5);
        }
        return Unit.INSTANCE;
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            BlueairApp$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m = BlueairApp$$ExternalSyntheticApiModelOutline0.m(this.context.getString(R.string.channel_id), (CharSequence) this.context.getString(R.string.channel_name), 3);
            m.setDescription(this.context.getString(R.string.channel_description));
            NotificationManagerCompat.from(this.context).createNotificationChannel(m);
        }
    }

    public final void setNotificationToken$push_otherRelease(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        AuthService authService2 = this.authService;
        Job unused = BuildersKt__Builders_commonKt.launch$default(authService2, (CoroutineContext) null, (CoroutineStart) null, new NotificationService$setNotificationToken$1$1(authService2, str, (Continuation<? super NotificationService$setNotificationToken$1$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0115, code lost:
        r6 = ACTION_TYPE_REFRESHER_STATUS;
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0195, code lost:
        r6 = ACTION_TYPE_WICK_STATUS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0227, code lost:
        r6 = ACTION_TYPE_FILTER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0262, code lost:
        showNotification(r12, r2, r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showNotification$push_otherRelease(java.lang.String r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14) {
        /*
            r10 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "deviceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "templateId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.blueair.auth.AuthService r0 = r10.authService
            java.lang.String r0 = r0.getUserIdForBlueCloud()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x0265
        L_0x0022:
            r0 = 0
            int r1 = r13.hashCode()     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = "refresher_status"
            java.lang.String r3 = "wick_status"
            java.lang.String r4 = "filter_life_left"
            java.lang.String r5 = "filter"
            java.lang.String r6 = "device_details"
            java.lang.String r7 = "device_name"
            r8 = 1
            java.lang.String r9 = "getString(...)"
            switch(r1) {
                case -2003314351: goto L_0x0229;
                case -1923137593: goto L_0x0200;
                case -1016813516: goto L_0x01d7;
                case -956559056: goto L_0x01c2;
                case -732600995: goto L_0x0198;
                case 475990511: goto L_0x016d;
                case 483913713: goto L_0x0143;
                case 1378289963: goto L_0x0119;
                case 1388897328: goto L_0x00e5;
                case 1716033072: goto L_0x00ac;
                case 1797312911: goto L_0x0065;
                case 1961012407: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0265
        L_0x003b:
            java.lang.String r1 = "water_full"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x0045
            goto L_0x0265
        L_0x0045:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_water_tank_full     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_water_tank_full     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r5[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r5)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0262
        L_0x0065:
            java.lang.String r1 = "filter_usage_replace"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x006f
            goto L_0x0265
        L_0x006f:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            int r2 = r14.getInt(r4)     // Catch:{ all -> 0x0266 }
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r0)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_title_filter_usage_prompt     // Catch:{ all -> 0x0266 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x0266 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r4[r0] = r2     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r8)     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = java.lang.String.format(r3, r2)     // Catch:{ all -> 0x0266 }
            java.lang.String r3 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_filter_usage_prompt     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0227
        L_0x00ac:
            java.lang.String r1 = "ywrm_usage_replace"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x00b6
            goto L_0x0265
        L_0x00b6:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            int r3 = r14.getInt(r4)     // Catch:{ all -> 0x0266 }
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r0)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.refresher_usage_state     // Catch:{ all -> 0x0266 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r3     // Catch:{ all -> 0x0266 }
            java.lang.String r3 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.notification_template_content_refresher_usage_prompt     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0115
        L_0x00e5:
            java.lang.String r1 = "ywrm_usage_replace_urgent"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x00ef
            goto L_0x0265
        L_0x00ef:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.refresher_usage_state     // Catch:{ all -> 0x0266 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r5     // Catch:{ all -> 0x0266 }
            java.lang.String r3 = r3.getString(r4, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.notification_template_content_refresher_usage_warning     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
        L_0x0115:
            r6 = r2
            r2 = r3
            goto L_0x0262
        L_0x0119:
            java.lang.String r1 = "water_shortage"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x0123
            goto L_0x0265
        L_0x0123:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_water_shortage_new     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_water_shortage_new     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r5[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r5)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0262
        L_0x0143:
            java.lang.String r1 = "filter_usage_replace_urgent"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x014d
            goto L_0x0265
        L_0x014d:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_filter_usage_warning     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_filter_usage_warning     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0227
        L_0x016d:
            java.lang.String r1 = "wick_usage_replace_urgent"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x0177
            goto L_0x0265
        L_0x0177:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_title_wick_usage_warning     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.notification_template_content_wick_usage_warning     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
        L_0x0195:
            r6 = r3
            goto L_0x0262
        L_0x0198:
            java.lang.String r1 = "water_tank_failure"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x01a2
            goto L_0x0265
        L_0x01a2:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_water_tank_failure     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_water_tank_failure     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r5[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r5)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0262
        L_0x01c2:
            java.lang.String r1 = "alarm_stop"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x01cc
            goto L_0x0265
        L_0x01cc:
            java.lang.String r1 = "alarm_name"
            java.lang.String r1 = r14.getString(r1)     // Catch:{ all -> 0x0266 }
            r2 = 0
            r10.showStopAlarmNotification(r12, r2, r1)     // Catch:{ all -> 0x0266 }
            return
        L_0x01d7:
            java.lang.String r1 = "filter_door_open"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x01e1
            goto L_0x0265
        L_0x01e1:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_filter_door_open     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_filter_door_open     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r5[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r5)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0262
        L_0x0200:
            java.lang.String r1 = "prefilter_usage_clean"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x0209
            goto L_0x0265
        L_0x0209:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0266 }
            int r3 = com.blueair.viewcore.R.string.notification_template_title_prefilter_usage_clean     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r3 = r10.context     // Catch:{ all -> 0x0266 }
            int r4 = com.blueair.viewcore.R.string.notification_template_content_prefilter_usage_clean     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r3.getString(r4, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
        L_0x0227:
            r6 = r5
            goto L_0x0262
        L_0x0229:
            java.lang.String r1 = "wick_usage_replace"
            boolean r1 = r13.equals(r1)     // Catch:{ all -> 0x0266 }
            if (r1 != 0) goto L_0x0232
            goto L_0x0265
        L_0x0232:
            java.lang.String r1 = r14.getString(r7)     // Catch:{ all -> 0x0266 }
            int r2 = r14.getInt(r4)     // Catch:{ all -> 0x0266 }
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r0)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.notification_template_title_wick_usage_prompt     // Catch:{ all -> 0x0266 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r2     // Catch:{ all -> 0x0266 }
            java.lang.String r2 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0266 }
            android.content.Context r4 = r10.context     // Catch:{ all -> 0x0266 }
            int r5 = com.blueair.viewcore.R.string.notification_template_content_wick_usage_prompt     // Catch:{ all -> 0x0266 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0266 }
            r6[r0] = r1     // Catch:{ all -> 0x0266 }
            java.lang.String r1 = r4.getString(r5, r6)     // Catch:{ all -> 0x0266 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ all -> 0x0266 }
            goto L_0x0195
        L_0x0262:
            r10.showNotification(r12, r2, r1, r6)     // Catch:{ all -> 0x0266 }
        L_0x0265:
            return
        L_0x0266:
            r1 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error parsing notification: userId="
            r3.<init>(r4)
            r3.append(r11)
            java.lang.String r11 = ", deviceId="
            r3.append(r11)
            r3.append(r12)
            java.lang.String r11 = ", templateId="
            r3.append(r11)
            r3.append(r13)
            java.lang.String r11 = ", params="
            r3.append(r11)
            r3.append(r14)
            java.lang.String r11 = r3.toString()
            java.lang.Object[] r12 = new java.lang.Object[r0]
            r2.e(r1, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.push.NotificationService.showNotification$push_otherRelease(java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    public final void showNotification(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "message");
        Intrinsics.checkNotNullParameter(str4, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        String string = this.context.getString(R.string.channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CharSequence charSequence = str3;
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this.context, string).setAutoCancel(true).setSmallIcon(this.smallIcon).setColorized(true).setColor(this.context.getColor(R.color.colorPrimary)).setContentTitle(str2).setContentText(charSequence).setStyle(new NotificationCompat.BigTextStyle().bigText(charSequence)).setSound(RingtoneManager.getDefaultUri(2)).setVisibility(1).setContentIntent(PendingIntent.getActivity(this.context, getRequestCode(), Actions.INSTANCE.openNotificationIntent(this.context, str, str4), 1140850688));
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        NotificationManagerCompat.from(this.context).notify(Random.Default.nextInt(), contentIntent.build());
    }

    public final void showStopAlarmNotification(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        String string = this.context.getString(R.string.channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int requestCode = getRequestCode();
        RemoteViews remoteViews = new RemoteViews(this.context.getPackageName(), R.layout.notification_stop_alarm);
        if (str2 != null) {
            remoteViews.setTextViewText(R.id.title, str2);
        }
        if (str3 != null) {
            remoteViews.setTextViewText(R.id.body, str3);
        }
        remoteViews.setOnClickPendingIntent(R.id.btn_stop, PendingIntent.getService(this.context, getRequestCode(), Actions.INSTANCE.stopAlarmIntent(this.context, str, requestCode), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        NotificationCompat.Builder visibility = new NotificationCompat.Builder(this.context, string).setAutoCancel(true).setSmallIcon(this.smallIcon).setColorized(true).setColor(this.context.getColor(R.color.colorPrimary)).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setCustomContentView(remoteViews).setSound(RingtoneManager.getDefaultUri(2)).setVisibility(1);
        Intrinsics.checkNotNullExpressionValue(visibility, "setVisibility(...)");
        NotificationManagerCompat.from(this.context).notify(requestCode, visibility.build());
    }
}
