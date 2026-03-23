package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.NotificationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/blueair/core/model/NotificationMessage;", "list", "devices", "Lcom/blueair/core/model/Device;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.NotificationsViewModel$lvNotificationMsgs$1", f = "NotificationsViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {64, 70, 75, 89}, m = "invokeSuspend", n = {"list", "devices", "$this$forEach$iv", "element$iv", "device", "$i$f$forEach", "$i$a$-forEach-NotificationsViewModel$lvNotificationMsgs$1$1", "it", "$i$a$-let-NotificationsViewModel$lvNotificationMsgs$1$1$1", "list", "devices", "$this$forEach$iv", "element$iv", "device", "$i$f$forEach", "$i$a$-forEach-NotificationsViewModel$lvNotificationMsgs$1$1", "list", "devices", "$this$forEach$iv", "element$iv", "device", "$i$f$forEach", "$i$a$-forEach-NotificationsViewModel$lvNotificationMsgs$1$1", "list", "devices", "$this$forEach$iv", "element$iv", "device", "hum", "aqiHumLevel", "humLevelPair", "$i$f$forEach", "$i$a$-forEach-NotificationsViewModel$lvNotificationMsgs$1$1", "curTimeMillis", "thresold"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "J$0", "J$1"})
/* compiled from: NotificationsViewModel.kt */
final class NotificationsViewModel$lvNotificationMsgs$1 extends SuspendLambda implements Function3<List<? extends NotificationMessage>, List<? extends Device>, Continuation<? super List<? extends NotificationMessage>>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    long J$1;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ NotificationsViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationsViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.core.model.NotificationMsgType[] r0 = com.blueair.core.model.NotificationMsgType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.NotificationMsgType r1 = com.blueair.core.model.NotificationMsgType.FILTER_LIFE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.NotificationMsgType r1 = com.blueair.core.model.NotificationMsgType.AQI     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.NotificationsViewModel$lvNotificationMsgs$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationsViewModel$lvNotificationMsgs$1(NotificationsViewModel notificationsViewModel, Continuation<? super NotificationsViewModel$lvNotificationMsgs$1> continuation) {
        super(3, continuation);
        this.this$0 = notificationsViewModel;
    }

    public final Object invoke(List<NotificationMessage> list, List<? extends Device> list2, Continuation<? super List<NotificationMessage>> continuation) {
        NotificationsViewModel$lvNotificationMsgs$1 notificationsViewModel$lvNotificationMsgs$1 = new NotificationsViewModel$lvNotificationMsgs$1(this.this$0, continuation);
        notificationsViewModel$lvNotificationMsgs$1.L$0 = list;
        notificationsViewModel$lvNotificationMsgs$1.L$1 = list2;
        return notificationsViewModel$lvNotificationMsgs$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: com.blueair.core.model.DeviceHumidifier} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: com.blueair.core.model.HasRemoveYellowWater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.blueair.core.model.HasRemoveYellowWater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.blueair.core.model.Device} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: com.blueair.core.model.HasWick} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: com.blueair.core.model.Device} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: com.blueair.core.model.Device} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: com.blueair.core.model.Device} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: com.blueair.core.model.DeviceHumidifier} */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r13v17, types: [com.blueair.core.model.Device] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0118, code lost:
        if (r7.executeFilterLifeForNotification(r9, r10, r4, r0) == r3) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x015a, code lost:
        if (r7.executeFilterLifeForNotification(r8, r9, r10, r0) == r3) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01b7, code lost:
        if (r8.executeFilterLifeForNotification(r9, r10, r7, r0) == r3) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x034b, code lost:
        if (com.blueair.core.model.DeviceKt.isStandByOn(r7) == false) goto L_0x038c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0311 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            r26 = this;
            r0 = r26
            java.lang.Object r1 = r0.L$0
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            r6 = 4
            r7 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            if (r4 == 0) goto L_0x00a7
            if (r4 == r10) goto L_0x008a
            if (r4 == r9) goto L_0x006d
            if (r4 == r7) goto L_0x004f
            if (r4 != r6) goto L_0x0047
            int r4 = r0.I$0
            java.lang.Object r12 = r0.L$9
            kotlin.Pair r12 = (kotlin.Pair) r12
            java.lang.Object r12 = r0.L$8
            com.blueair.core.model.AqiHumLevel r12 = (com.blueair.core.model.AqiHumLevel) r12
            java.lang.Object r12 = r0.L$7
            java.lang.Float r12 = (java.lang.Float) r12
            java.lang.Object r12 = r0.L$6
            com.blueair.core.model.Device r12 = (com.blueair.core.model.Device) r12
            java.lang.Object r12 = r0.L$4
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r0.L$3
            com.blueair.android.viewmodel.NotificationsViewModel r13 = (com.blueair.android.viewmodel.NotificationsViewModel) r13
            java.lang.Object r14 = r0.L$2
            kotlin.sequences.Sequence r14 = (kotlin.sequences.Sequence) r14
            kotlin.ResultKt.throwOnFailure(r27)
            r23 = r1
            r1 = r6
            r16 = 10
            goto L_0x0295
        L_0x0047:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004f:
            int r4 = r0.I$1
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$6
            com.blueair.core.model.Device r13 = (com.blueair.core.model.Device) r13
            java.lang.Object r14 = r0.L$5
            java.lang.Object r15 = r0.L$4
            java.util.Iterator r15 = (java.util.Iterator) r15
            r16 = 10
            java.lang.Object r5 = r0.L$3
            com.blueair.android.viewmodel.NotificationsViewModel r5 = (com.blueair.android.viewmodel.NotificationsViewModel) r5
            java.lang.Object r6 = r0.L$2
            kotlin.sequences.Sequence r6 = (kotlin.sequences.Sequence) r6
            kotlin.ResultKt.throwOnFailure(r27)
            r11 = r7
            goto L_0x01bb
        L_0x006d:
            r16 = 10
            int r4 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$6
            com.blueair.core.model.Device r6 = (com.blueair.core.model.Device) r6
            java.lang.Object r12 = r0.L$5
            java.lang.Object r13 = r0.L$4
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r0.L$3
            com.blueair.android.viewmodel.NotificationsViewModel r14 = (com.blueair.android.viewmodel.NotificationsViewModel) r14
            java.lang.Object r15 = r0.L$2
            kotlin.sequences.Sequence r15 = (kotlin.sequences.Sequence) r15
            kotlin.ResultKt.throwOnFailure(r27)
            goto L_0x015e
        L_0x008a:
            r16 = 10
            int r4 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$6
            com.blueair.core.model.Device r6 = (com.blueair.core.model.Device) r6
            java.lang.Object r12 = r0.L$5
            java.lang.Object r13 = r0.L$4
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r0.L$3
            com.blueair.android.viewmodel.NotificationsViewModel r14 = (com.blueair.android.viewmodel.NotificationsViewModel) r14
            java.lang.Object r15 = r0.L$2
            kotlin.sequences.Sequence r15 = (kotlin.sequences.Sequence) r15
            kotlin.ResultKt.throwOnFailure(r27)
            goto L_0x011d
        L_0x00a7:
            r16 = 10
            kotlin.ResultKt.throwOnFailure(r27)
            r4 = r2
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)
            com.blueair.android.viewmodel.NotificationsViewModel r5 = r0.this$0
            java.util.Iterator r6 = r4.iterator()
            r15 = r4
            r14 = r5
            r13 = r6
            r5 = 0
        L_0x00bd:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x02cc
            java.lang.Object r12 = r13.next()
            r6 = r12
            com.blueair.core.model.Device r6 = (com.blueair.core.model.Device) r6
            boolean r4 = r6 instanceof com.blueair.core.model.HasFanSpeed
            if (r4 == 0) goto L_0x011c
            boolean r4 = com.blueair.core.model.DeviceKt.hasAirFilter(r6)
            if (r4 == 0) goto L_0x011c
            com.blueair.viewcore.utils.DeviceConfigProvider r4 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            java.lang.Integer r4 = r4.getFilterLifeLeftPercentage(r6)
            if (r4 == 0) goto L_0x011c
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            com.blueair.devicemanager.DeviceManager r7 = r14.getDeviceManager()
            java.lang.String r9 = r6.getUid()
            com.blueair.core.model.DeviceFilterType r10 = com.blueair.core.model.DeviceFilterType.FILTER
            r0.L$0 = r1
            r0.L$1 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$2 = r8
            r0.L$3 = r14
            r0.L$4 = r13
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$5 = r8
            r0.L$6 = r6
            r0.L$7 = r11
            r0.L$8 = r11
            r0.L$9 = r11
            r0.I$0 = r5
            r8 = 0
            r0.I$1 = r8
            r0.I$2 = r4
            r0.I$3 = r8
            r8 = 1
            r0.label = r8
            java.lang.Object r4 = r7.executeFilterLifeForNotification(r9, r10, r4, r0)
            if (r4 != r3) goto L_0x011c
            goto L_0x0291
        L_0x011c:
            r4 = 0
        L_0x011d:
            boolean r7 = r6 instanceof com.blueair.core.model.HasWick
            if (r7 == 0) goto L_0x015e
            com.blueair.devicemanager.DeviceManager r7 = r14.getDeviceManager()
            java.lang.String r8 = r6.getUid()
            com.blueair.core.model.DeviceFilterType r9 = com.blueair.core.model.DeviceFilterType.WICK
            r10 = r6
            com.blueair.core.model.HasWick r10 = (com.blueair.core.model.HasWick) r10
            int r10 = r10.getWickLifeLeft()
            r0.L$0 = r1
            r0.L$1 = r2
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$2 = r11
            r0.L$3 = r14
            r0.L$4 = r13
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$5 = r11
            r0.L$6 = r6
            r11 = 0
            r0.L$7 = r11
            r0.L$8 = r11
            r0.L$9 = r11
            r0.I$0 = r5
            r0.I$1 = r4
            r11 = 2
            r0.label = r11
            java.lang.Object r7 = r7.executeFilterLifeForNotification(r8, r9, r10, r0)
            if (r7 != r3) goto L_0x015e
            goto L_0x0291
        L_0x015e:
            r25 = r12
            r12 = r5
            r5 = r14
            r14 = r25
            r25 = r13
            r13 = r6
            r6 = r15
            r15 = r25
            boolean r7 = r13 instanceof com.blueair.core.model.HasRemoveYellowWater
            if (r7 == 0) goto L_0x01c2
            r7 = r13
            com.blueair.core.model.HasRemoveYellowWater r7 = (com.blueair.core.model.HasRemoveYellowWater) r7
            java.lang.Boolean r8 = r7.getYwrmEnabled()
            r17 = 1
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x01c2
            com.blueair.devicemanager.DeviceManager r8 = r5.getDeviceManager()
            java.lang.String r9 = r13.getUid()
            com.blueair.core.model.DeviceFilterType r10 = com.blueair.core.model.DeviceFilterType.REFRESHER
            int r7 = r7.getRefresherLifeLeft()
            r0.L$0 = r1
            r0.L$1 = r2
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$2 = r11
            r0.L$3 = r5
            r0.L$4 = r15
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r0.L$5 = r11
            r0.L$6 = r13
            r11 = 0
            r0.L$7 = r11
            r0.L$8 = r11
            r0.L$9 = r11
            r0.I$0 = r12
            r0.I$1 = r4
            r11 = 3
            r0.label = r11
            java.lang.Object r7 = r8.executeFilterLifeForNotification(r9, r10, r7, r0)
            if (r7 != r3) goto L_0x01bb
            goto L_0x0291
        L_0x01bb:
            r7 = r14
            r14 = r6
            r6 = r5
            r5 = r4
            r4 = r12
            r12 = r15
            goto L_0x01c4
        L_0x01c2:
            r11 = 3
            goto L_0x01bb
        L_0x01c4:
            boolean r8 = r13 instanceof com.blueair.core.model.DeviceHumidifier
            if (r8 == 0) goto L_0x02bb
            r8 = r13
            com.blueair.core.model.DeviceHumidifier r8 = (com.blueair.core.model.DeviceHumidifier) r8
            com.blueair.core.model.IndoorDatapoint r9 = r8.getLatestSensorDatapoint()
            if (r9 == 0) goto L_0x01d6
            java.lang.Float r9 = r9.getHum()
            goto L_0x01d7
        L_0x01d6:
            r9 = 0
        L_0x01d7:
            if (r9 == 0) goto L_0x01e4
            com.blueair.core.model.AqiHumLevel$Companion r10 = com.blueair.core.model.AqiHumLevel.Companion
            float r15 = r9.floatValue()
            com.blueair.core.model.AqiHumLevel r10 = r10.fromHumValue(r15)
            goto L_0x01e5
        L_0x01e4:
            r10 = 0
        L_0x01e5:
            java.util.HashMap r15 = r6.getAqiHumLevelMap()
            java.lang.String r11 = r8.getUid()
            java.lang.Object r11 = r15.get(r11)
            kotlin.Pair r11 = (kotlin.Pair) r11
            r27 = r7
            r15 = r8
            long r7 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x029d
            r18 = r9
            java.lang.Object r9 = r11.getFirst()
            if (r9 != r10) goto L_0x029d
            com.blueair.core.service.UnsecurePrefs r9 = r6.getPrefs()
            io.flatcircle.preferenceshelper2.Prefs r9 = (io.flatcircle.preferenceshelper2.Prefs) r9
            r19 = r9
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r16)
            r20 = r11
            io.flatcircle.preferenceshelper2.PreferencesHelper r11 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            r21 = r13
            io.flatcircle.preferenceshelper2.PrefsBackend r13 = r19.getBackend()
            java.lang.Class<java.lang.Integer> r19 = java.lang.Integer.class
            r22 = r14
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            r19 = r15
            java.lang.String r15 = "KEY_NOTIFICATION_AQI_INTERMITTENT"
            java.lang.Object r9 = r11.get(r13, r15, r9, r14)
            java.lang.Number r9 = (java.lang.Number) r9
            long r13 = r9.longValue()
            r23 = 1000(0x3e8, double:4.94E-321)
            long r13 = r13 * r23
            java.lang.Object r9 = r20.getSecond()
            java.lang.Number r9 = (java.lang.Number) r9
            long r23 = r9.longValue()
            long r23 = r7 - r23
            int r9 = (r23 > r13 ? 1 : (r23 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x029a
            com.blueair.devicemanager.DeviceManager r9 = r6.getDeviceManager()
            java.lang.String r11 = r19.getUid()
            if (r10 != 0) goto L_0x0251
            com.blueair.core.model.AqiHumLevel r15 = com.blueair.core.model.AqiHumLevel.IDEAL
            goto L_0x0252
        L_0x0251:
            r15 = r10
        L_0x0252:
            r0.L$0 = r1
            r0.L$1 = r2
            r23 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)
            r0.L$2 = r1
            r0.L$3 = r6
            r0.L$4 = r12
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)
            r0.L$5 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21)
            r0.L$6 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)
            r0.L$7 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$8 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
            r0.L$9 = r1
            r0.I$0 = r4
            r0.I$1 = r5
            r0.J$0 = r7
            r0.J$1 = r13
            r1 = 4
            r0.label = r1
            java.lang.Object r5 = r9.executeHumForNotification(r11, r15, r0)
            if (r5 != r3) goto L_0x0292
        L_0x0291:
            return r3
        L_0x0292:
            r13 = r6
            r14 = r22
        L_0x0295:
            r15 = r14
            r14 = r13
        L_0x0297:
            r5 = r4
            r13 = r12
            goto L_0x02c4
        L_0x029a:
            r23 = r1
            goto L_0x02bf
        L_0x029d:
            r23 = r1
            r22 = r14
            r19 = r15
            r1 = 4
            java.util.HashMap r5 = r6.getAqiHumLevelMap()
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r9 = r19.getUid()
            kotlin.Pair r11 = new kotlin.Pair
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            r11.<init>(r10, r7)
            r5.put(r9, r11)
            goto L_0x02c0
        L_0x02bb:
            r23 = r1
            r22 = r14
        L_0x02bf:
            r1 = 4
        L_0x02c0:
            r14 = r6
            r15 = r22
            goto L_0x0297
        L_0x02c4:
            r1 = r23
            r7 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            goto L_0x00bd
        L_0x02cc:
            r23 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r1 = r16
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
            r3 = 16
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r3)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>(r1)
            java.util.Map r3 = (java.util.Map) r3
            java.util.Iterator r1 = r2.iterator()
        L_0x02eb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0300
            java.lang.Object r2 = r1.next()
            r4 = r2
            com.blueair.core.model.Device r4 = (com.blueair.core.model.Device) r4
            java.lang.String r4 = r4.getUid()
            r3.put(r4, r2)
            goto L_0x02eb
        L_0x0300:
            r1 = r23
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.blueair.android.viewmodel.NotificationsViewModel r2 = r0.this$0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0311:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x03af
            java.lang.Object r5 = r1.next()
            com.blueair.core.model.NotificationMessage r5 = (com.blueair.core.model.NotificationMessage) r5
            com.blueair.core.model.Device r6 = r5.getDevice()
            java.lang.String r7 = r6.getUid()
            java.lang.Object r7 = r3.get(r7)
            com.blueair.core.model.Device r7 = (com.blueair.core.model.Device) r7
            com.blueair.core.model.NotificationMsgType r8 = r5.getType()
            int[] r9 = com.blueair.android.viewmodel.NotificationsViewModel$lvNotificationMsgs$1.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r9[r8]
            r9 = 1
            if (r8 == r9) goto L_0x0354
            r11 = 2
            if (r8 != r11) goto L_0x034e
            if (r7 == 0) goto L_0x0363
            com.blueair.core.model.ConnectivityStatus r8 = r7.getConnectivityStatus()
            com.blueair.core.model.ConnectivityStatus r9 = com.blueair.core.model.ConnectivityStatus.ONLINE
            if (r8 != r9) goto L_0x0363
            boolean r8 = com.blueair.core.model.DeviceKt.isStandByOn(r7)
            if (r8 == 0) goto L_0x038c
            goto L_0x0363
        L_0x034e:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0354:
            r11 = 2
            com.blueair.core.model.FilterLifeLevel$Companion r8 = com.blueair.core.model.FilterLifeLevel.Companion
            int r9 = r5.getSubLevel()
            com.blueair.core.model.FilterLifeLevel r8 = r8.fromLevel(r9)
            com.blueair.core.model.FilterLifeLevel r9 = com.blueair.core.model.FilterLifeLevel.NORMAL
            if (r8 != r9) goto L_0x0367
        L_0x0363:
            r5 = 0
            r17 = 1
            goto L_0x03a8
        L_0x0367:
            boolean r8 = r7 instanceof com.blueair.core.model.HasRemoveYellowWater
            if (r8 == 0) goto L_0x038c
            r8 = r7
            com.blueair.core.model.HasRemoveYellowWater r8 = (com.blueair.core.model.HasRemoveYellowWater) r8
            java.lang.Boolean r8 = r8.getYwrmEnabled()
            r17 = 1
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x038e
            java.lang.String r8 = r5.getSubType()
            java.lang.String r9 = "REFRESHER"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x038e
            r5 = 0
            goto L_0x03a8
        L_0x038c:
            r17 = 1
        L_0x038e:
            if (r7 == 0) goto L_0x03a8
            boolean r6 = r2.shouldReplace(r7, r6)
            if (r6 == 0) goto L_0x03a8
            com.blueair.core.model.NotificationMessage r6 = new com.blueair.core.model.NotificationMessage
            com.blueair.core.model.NotificationMsgType r8 = r5.getType()
            java.lang.String r9 = r5.getSubType()
            int r5 = r5.getSubLevel()
            r6.<init>(r7, r8, r9, r5)
            r5 = r6
        L_0x03a8:
            if (r5 == 0) goto L_0x0311
            r4.add(r5)
            goto L_0x0311
        L_0x03af:
            java.util.List r4 = (java.util.List) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.NotificationsViewModel$lvNotificationMsgs$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
