package com.blueair.devicemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.blueair.core.service.AnalyticsService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u0002"}, d2 = {"Lcom/blueair/devicemanager/WelcomeHomeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "setDi", "(Lorg/kodein/di/DI;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "devicemanager_otherRelease", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomeBroadcastReceiver.kt */
public final class WelcomeHomeBroadcastReceiver extends BroadcastReceiver implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public DI di;

    static {
        Class<WelcomeHomeBroadcastReceiver> cls = WelcomeHomeBroadcastReceiver.class;
        $$delegatedProperties = new KProperty[]{Reflection.property0(new PropertyReference0Impl(cls, "deviceManager", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "analyticsService", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "scheduleService", "<v#2>", 0))};
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J>\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicemanager/WelcomeHomeBroadcastReceiver$Companion;", "", "<init>", "()V", "shouldSetNightMode", "", "hoursAndMinutesToday", "Lorg/joda/time/DateTime;", "time", "", "inScheduleTime", "schedules", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "handleWelcomeHome", "", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "scheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceId", "isMinRadius", "isEnter", "(Lcom/blueair/devicemanager/DeviceManager;Lcom/blueair/core/service/AnalyticsService;Lcom/blueair/devicemanager/DeviceScheduleService;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeBroadcastReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final boolean shouldSetNightMode() {
            int hourOfDay = new DateTime().getHourOfDay();
            boolean z = false;
            if (8 <= hourOfDay && hourOfDay < 21) {
                z = true;
            }
            return !z;
        }

        private final DateTime hoursAndMinutesToday(String str) {
            DateTime parse = DateTime.parse(str, DateTimeFormat.forPattern("HH:mm"));
            DateTime withMinuteOfHour = new DateTime().withHourOfDay(parse.getHourOfDay()).withMinuteOfHour(parse.getMinuteOfHour());
            Intrinsics.checkNotNullExpressionValue(withMinuteOfHour, "withMinuteOfHour(...)");
            return withMinuteOfHour;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean inScheduleTime(java.util.List<com.blueair.core.model.DeviceScheduleMerged> r11) {
            /*
                r10 = this;
                org.joda.time.DateTime r0 = new org.joda.time.DateTime
                r0.<init>()
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.Iterator r11 = r11.iterator()
            L_0x000b:
                boolean r1 = r11.hasNext()
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0089
                java.lang.Object r1 = r11.next()
                r5 = r1
                com.blueair.core.model.DeviceScheduleMerged r5 = (com.blueair.core.model.DeviceScheduleMerged) r5
                boolean r6 = r5.getPaused()
                if (r6 == 0) goto L_0x0022
                goto L_0x000b
            L_0x0022:
                java.util.Set r6 = r5.getDaysOfWeek()     // Catch:{ Exception -> 0x0084 }
                java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ Exception -> 0x0084 }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0084 }
            L_0x002c:
                boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0084 }
                if (r7 == 0) goto L_0x0044
                java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0084 }
                r8 = r7
                com.blueair.core.model.DayOfWeek r8 = (com.blueair.core.model.DayOfWeek) r8     // Catch:{ Exception -> 0x0084 }
                int r8 = r8.getCompareValue()     // Catch:{ Exception -> 0x0084 }
                int r9 = r0.getDayOfWeek()     // Catch:{ Exception -> 0x0084 }
                if (r8 != r9) goto L_0x002c
                r3 = r7
            L_0x0044:
                if (r3 == 0) goto L_0x0048
                r3 = r4
                goto L_0x0049
            L_0x0048:
                r3 = r2
            L_0x0049:
                com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion r6 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion     // Catch:{ Exception -> 0x0084 }
                java.lang.String r7 = r5.getStartTime()     // Catch:{ Exception -> 0x0084 }
                org.joda.time.DateTime r6 = r6.hoursAndMinutesToday(r7)     // Catch:{ Exception -> 0x0084 }
                com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion r7 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion     // Catch:{ Exception -> 0x0084 }
                java.lang.String r5 = r5.getEndTime()     // Catch:{ Exception -> 0x0084 }
                org.joda.time.DateTime r5 = r7.hoursAndMinutesToday(r5)     // Catch:{ Exception -> 0x0084 }
                r7 = r5
                org.joda.time.ReadableInstant r7 = (org.joda.time.ReadableInstant) r7     // Catch:{ Exception -> 0x0084 }
                boolean r7 = r6.isAfter((org.joda.time.ReadableInstant) r7)     // Catch:{ Exception -> 0x0084 }
                if (r7 == 0) goto L_0x006f
                org.joda.time.DateTime r5 = r5.plusDays(r4)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r7 = "plusDays(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x0084 }
            L_0x006f:
                org.joda.time.Interval r7 = new org.joda.time.Interval     // Catch:{ Exception -> 0x0084 }
                org.joda.time.ReadableInstant r6 = (org.joda.time.ReadableInstant) r6     // Catch:{ Exception -> 0x0084 }
                org.joda.time.ReadableInstant r5 = (org.joda.time.ReadableInstant) r5     // Catch:{ Exception -> 0x0084 }
                r7.<init>((org.joda.time.ReadableInstant) r6, (org.joda.time.ReadableInstant) r5)     // Catch:{ Exception -> 0x0084 }
                r5 = r0
                org.joda.time.ReadableInstant r5 = (org.joda.time.ReadableInstant) r5     // Catch:{ Exception -> 0x0084 }
                boolean r5 = r7.contains((org.joda.time.ReadableInstant) r5)     // Catch:{ Exception -> 0x0084 }
                if (r3 == 0) goto L_0x000b
                if (r5 == 0) goto L_0x000b
                goto L_0x0088
            L_0x0084:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0088:
                r3 = r1
            L_0x0089:
                if (r3 == 0) goto L_0x008c
                r2 = r4
            L_0x008c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion.inScheduleTime(java.util.List):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x01a8, code lost:
            if (r14.setNightMode(r8, true, r5) == r6) goto L_0x0218;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x01d9, code lost:
            if (r14.setAutoMode(r8, true, r5) == r6) goto L_0x0218;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0216, code lost:
            if (r15.setStandBy(r1, true, r5) == r6) goto L_0x0218;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x017e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x01ae  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x021c  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object handleWelcomeHome(com.blueair.devicemanager.DeviceManager r18, com.blueair.core.service.AnalyticsService r19, com.blueair.devicemanager.DeviceScheduleService r20, java.lang.String r21, boolean r22, boolean r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
            /*
                r17 = this;
                r0 = r17
                r1 = r21
                r2 = r22
                r3 = r23
                r4 = r24
                boolean r5 = r4 instanceof com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1
                if (r5 == 0) goto L_0x001e
                r5 = r4
                com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1 r5 = (com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1) r5
                int r6 = r5.label
                r7 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r7
                if (r6 == 0) goto L_0x001e
                int r4 = r5.label
                int r4 = r4 - r7
                r5.label = r4
                goto L_0x0023
            L_0x001e:
                com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1 r5 = new com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1
                r5.<init>(r0, r4)
            L_0x0023:
                java.lang.Object r4 = r5.result
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r7 = r5.label
                r8 = 0
                r9 = 5
                r10 = 4
                r11 = 3
                r12 = 2
                r13 = 1
                if (r7 == 0) goto L_0x00de
                if (r7 == r13) goto L_0x00c1
                if (r7 == r12) goto L_0x00a2
                if (r7 == r11) goto L_0x0083
                if (r7 == r10) goto L_0x0064
                if (r7 != r9) goto L_0x005c
                boolean r1 = r5.Z$2
                boolean r1 = r5.Z$1
                boolean r1 = r5.Z$0
                java.lang.Object r1 = r5.L$4
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r1 = r5.L$3
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r1 = r5.L$2
                com.blueair.devicemanager.DeviceScheduleService r1 = (com.blueair.devicemanager.DeviceScheduleService) r1
                java.lang.Object r1 = r5.L$1
                com.blueair.core.service.AnalyticsService r1 = (com.blueair.core.service.AnalyticsService) r1
                java.lang.Object r1 = r5.L$0
                com.blueair.devicemanager.DeviceManager r1 = (com.blueair.devicemanager.DeviceManager) r1
                kotlin.ResultKt.throwOnFailure(r4)
                goto L_0x0219
            L_0x005c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0064:
                boolean r1 = r5.Z$2
                boolean r1 = r5.Z$1
                boolean r1 = r5.Z$0
                java.lang.Object r1 = r5.L$4
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r1 = r5.L$3
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r1 = r5.L$2
                com.blueair.devicemanager.DeviceScheduleService r1 = (com.blueair.devicemanager.DeviceScheduleService) r1
                java.lang.Object r1 = r5.L$1
                com.blueair.core.service.AnalyticsService r1 = (com.blueair.core.service.AnalyticsService) r1
                java.lang.Object r1 = r5.L$0
                com.blueair.devicemanager.DeviceManager r1 = (com.blueair.devicemanager.DeviceManager) r1
                kotlin.ResultKt.throwOnFailure(r4)
                goto L_0x01dc
            L_0x0083:
                boolean r1 = r5.Z$2
                boolean r1 = r5.Z$1
                boolean r1 = r5.Z$0
                java.lang.Object r1 = r5.L$4
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r1 = r5.L$3
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r1 = r5.L$2
                com.blueair.devicemanager.DeviceScheduleService r1 = (com.blueair.devicemanager.DeviceScheduleService) r1
                java.lang.Object r1 = r5.L$1
                com.blueair.core.service.AnalyticsService r1 = (com.blueair.core.service.AnalyticsService) r1
                java.lang.Object r1 = r5.L$0
                com.blueair.devicemanager.DeviceManager r1 = (com.blueair.devicemanager.DeviceManager) r1
                kotlin.ResultKt.throwOnFailure(r4)
                goto L_0x01ab
            L_0x00a2:
                boolean r1 = r5.Z$2
                boolean r2 = r5.Z$1
                boolean r3 = r5.Z$0
                java.lang.Object r7 = r5.L$4
                java.util.List r7 = (java.util.List) r7
                java.lang.Object r8 = r5.L$3
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r5.L$2
                com.blueair.devicemanager.DeviceScheduleService r9 = (com.blueair.devicemanager.DeviceScheduleService) r9
                java.lang.Object r12 = r5.L$1
                com.blueair.core.service.AnalyticsService r12 = (com.blueair.core.service.AnalyticsService) r12
                java.lang.Object r14 = r5.L$0
                com.blueair.devicemanager.DeviceManager r14 = (com.blueair.devicemanager.DeviceManager) r14
                kotlin.ResultKt.throwOnFailure(r4)
                goto L_0x0178
            L_0x00c1:
                boolean r1 = r5.Z$1
                boolean r2 = r5.Z$0
                java.lang.Object r3 = r5.L$3
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r7 = r5.L$2
                com.blueair.devicemanager.DeviceScheduleService r7 = (com.blueair.devicemanager.DeviceScheduleService) r7
                java.lang.Object r14 = r5.L$1
                com.blueair.core.service.AnalyticsService r14 = (com.blueair.core.service.AnalyticsService) r14
                java.lang.Object r15 = r5.L$0
                com.blueair.devicemanager.DeviceManager r15 = (com.blueair.devicemanager.DeviceManager) r15
                kotlin.ResultKt.throwOnFailure(r4)
                r16 = r3
                r3 = r1
                r1 = r16
                goto L_0x0133
            L_0x00de:
                kotlin.ResultKt.throwOnFailure(r4)
                timber.log.Timber$Forest r4 = timber.log.Timber.Forest
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r14 = "handleWelcomeHome("
                r7.<init>(r14)
                r7.append(r1)
                java.lang.String r14 = ", "
                r7.append(r14)
                r7.append(r2)
                r7.append(r14)
                r7.append(r3)
                r14 = 41
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                java.lang.Object[] r14 = new java.lang.Object[r8]
                r4.d(r7, r14)
                r4 = r18
                r5.L$0 = r4
                r7 = r19
                r5.L$1 = r7
                java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
                r5.L$2 = r14
                r5.L$3 = r1
                r5.Z$0 = r2
                r5.Z$1 = r3
                r5.label = r13
                r14 = r20
                java.lang.Object r15 = r14.getSchedulesFor(r1, r5)
                if (r15 != r6) goto L_0x0129
                goto L_0x0218
            L_0x0129:
                r16 = r15
                r15 = r4
                r4 = r16
                r16 = r14
                r14 = r7
                r7 = r16
            L_0x0133:
                java.util.List r4 = (java.util.List) r4
                boolean r9 = r0.inScheduleTime(r4)
                if (r9 != 0) goto L_0x021c
                if (r3 == 0) goto L_0x01df
                if (r2 != 0) goto L_0x0149
                com.blueair.core.model.WelcomeHomeEnterEvent r10 = new com.blueair.core.model.WelcomeHomeEnterEvent
                r10.<init>(r1)
                com.blueair.core.model.AmplitudeEvent r10 = (com.blueair.core.model.AmplitudeEvent) r10
                r14.amplitudeLog((com.blueair.core.model.AmplitudeEvent) r10)
            L_0x0149:
                r5.L$0 = r15
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
                r5.L$1 = r10
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r5.L$2 = r10
                r5.L$3 = r1
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r5.L$4 = r10
                r5.Z$0 = r2
                r5.Z$1 = r3
                r5.Z$2 = r9
                r5.label = r12
                java.lang.Object r8 = r15.setStandBy(r1, r8, r5)
                if (r8 != r6) goto L_0x016f
                goto L_0x0218
            L_0x016f:
                r8 = r3
                r3 = r2
                r2 = r8
                r8 = r1
                r1 = r9
                r12 = r14
                r14 = r15
                r9 = r7
                r7 = r4
            L_0x0178:
                boolean r4 = r0.shouldSetNightMode()
                if (r4 == 0) goto L_0x01ae
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
                r5.L$0 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                r5.L$1 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r5.L$2 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r5.L$3 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r5.L$4 = r4
                r5.Z$0 = r3
                r5.Z$1 = r2
                r5.Z$2 = r1
                r5.label = r11
                java.lang.Object r1 = r14.setNightMode(r8, r13, r5)
                if (r1 != r6) goto L_0x01ab
                goto L_0x0218
            L_0x01ab:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x01ae:
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
                r5.L$0 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                r5.L$1 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r5.L$2 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r5.L$3 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r5.L$4 = r4
                r5.Z$0 = r3
                r5.Z$1 = r2
                r5.Z$2 = r1
                r1 = 4
                r5.label = r1
                java.lang.Object r1 = r14.setAutoMode(r8, r13, r5)
                if (r1 != r6) goto L_0x01dc
                goto L_0x0218
            L_0x01dc:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x01df:
                if (r2 != 0) goto L_0x01eb
                com.blueair.core.model.WelcomeHomeLeaveEvent r8 = new com.blueair.core.model.WelcomeHomeLeaveEvent
                r8.<init>(r1)
                com.blueair.core.model.AmplitudeEvent r8 = (com.blueair.core.model.AmplitudeEvent) r8
                r14.amplitudeLog((com.blueair.core.model.AmplitudeEvent) r8)
            L_0x01eb:
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                r5.L$0 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
                r5.L$1 = r8
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r5.L$2 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r5.L$3 = r7
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r5.L$4 = r4
                r5.Z$0 = r2
                r5.Z$1 = r3
                r5.Z$2 = r9
                r2 = 5
                r5.label = r2
                java.lang.Object r1 = r15.setStandBy(r1, r13, r5)
                if (r1 != r6) goto L_0x0219
            L_0x0218:
                return r6
            L_0x0219:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x021c:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion.handleWelcomeHome(com.blueair.devicemanager.DeviceManager, com.blueair.core.service.AnalyticsService, com.blueair.devicemanager.DeviceScheduleService, java.lang.String, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public DI getDi() {
        DI di2 = this.di;
        if (di2 != null) {
            return di2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("di");
        return null;
    }

    public void setDi(DI di2) {
        Intrinsics.checkNotNullParameter(di2, "<set-?>");
        this.di = di2;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intent intent2 = intent;
        Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent2);
        if (fromIntent != null) {
            if (fromIntent.hasError()) {
                String statusCodeString = GeofenceStatusCodes.getStatusCodeString(fromIntent.getErrorCode());
                Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
                Timber.Forest.d(statusCodeString, new Object[0]);
                return;
            }
            int geofenceTransition = fromIntent.getGeofenceTransition();
            if (geofenceTransition == 1) {
                z = true;
            } else if (geofenceTransition == 2) {
                z = false;
            } else {
                return;
            }
            List<Geofence> triggeringGeofences = fromIntent.getTriggeringGeofences();
            if (triggeringGeofences != null) {
                Context applicationContext = context2.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type org.kodein.di.DIAware");
                setDi(((DIAware) applicationContext).getDi());
                DIAware dIAware = this;
                JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new WelcomeHomeBroadcastReceiver$onReceive$$inlined$instance$default$1().getSuperType());
                Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
                LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, DeviceManager.class), (Object) null);
                KProperty<Object>[] kPropertyArr = $$delegatedProperties;
                Lazy<Object> provideDelegate = Instance.provideDelegate((Object) null, kPropertyArr[0]);
                JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new WelcomeHomeBroadcastReceiver$onReceive$$inlined$instance$default$2().getSuperType());
                Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
                Lazy<Object> provideDelegate2 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AnalyticsService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[1]);
                JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new WelcomeHomeBroadcastReceiver$onReceive$$inlined$instance$default$3().getSuperType());
                Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new WelcomeHomeBroadcastReceiver$onReceive$1(triggeringGeofences, z, provideDelegate, provideDelegate2, DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, DeviceScheduleService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[2]), (Continuation<? super WelcomeHomeBroadcastReceiver$onReceive$1>) null), 3, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final DeviceManager onReceive$lambda$0(Lazy<DeviceManager> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final AnalyticsService onReceive$lambda$1(Lazy<AnalyticsService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceScheduleService onReceive$lambda$2(Lazy<DeviceScheduleService> lazy) {
        return lazy.getValue();
    }
}
