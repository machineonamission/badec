package com.blueair.auth;

import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$setPushToken$2", f = "AuthService.kt", i = {1, 1, 1, 1}, l = {672, 688}, m = "invokeSuspend", n = {"pushSettings", "pushEnabled", "lang", "$i$a$-ifEmpty-AuthService$setPushToken$2$1"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* compiled from: AuthService.kt */
final class AuthService$setPushToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $token;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$setPushToken$2(AuthService authService, String str, Continuation<? super AuthService$setPushToken$2> continuation) {
        super(2, continuation);
        this.this$0 = authService;
        this.$token = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthService$setPushToken$2(this.this$0, this.$token, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthService$setPushToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r13 == r0) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        if (r13 == null) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r12.L$3
            com.blueair.sdk.KlaviyoSdk r0 = (com.blueair.sdk.KlaviyoSdk) r0
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r12.L$1
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r12.L$0
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00d8
        L_0x0023:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005b
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.sdk.KlaviyoSdk r13 = com.blueair.sdk.KlaviyoSdk.INSTANCE
            com.blueair.auth.AuthService r1 = r12.this$0
            com.blueair.auth.LocationService r1 = r1.locationService
            boolean r1 = r1.isInKlaviyoRegion()
            r13.setEnabled(r1)
            com.blueair.sdk.KlaviyoSdk r13 = com.blueair.sdk.KlaviyoSdk.INSTANCE
            boolean r13 = r13.getEnabled()
            if (r13 == 0) goto L_0x0137
            com.blueair.auth.AuthService r13 = r12.this$0
            kotlin.jvm.functions.Function1 r13 = r13.getPushSettingsFetcher()
            if (r13 == 0) goto L_0x005f
            r12.label = r3
            java.lang.Object r13 = r13.invoke(r12)
            if (r13 != r0) goto L_0x005b
            goto L_0x00d1
        L_0x005b:
            java.util.List r13 = (java.util.List) r13
            if (r13 != 0) goto L_0x0063
        L_0x005f:
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0063:
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            r1.element = r3
            com.blueair.core.model.NotificationType r4 = com.blueair.core.model.NotificationType.ALL
            int r4 = invokeSuspend$getSettingValue(r1, r13, r4)
            r5 = 0
            if (r4 != r3) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r3 = r5
        L_0x0075:
            r1.element = r3
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.getLanguage()
            java.lang.String r4 = "zh"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x00a5
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.toLanguageTag()
            int r4 = r3.length()
            r6 = 7
            if (r4 < r6) goto L_0x00a3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = r3.substring(r5, r6)
            java.lang.String r4 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L_0x00a5
        L_0x00a3:
            java.lang.String r3 = "zh-Hans"
        L_0x00a5:
            com.blueair.sdk.KlaviyoSdk r4 = com.blueair.sdk.KlaviyoSdk.INSTANCE
            com.blueair.auth.AuthService r6 = r12.this$0
            com.blueair.auth.GigyaService r6 = r6.getGigyaService()
            java.lang.String r6 = r6.getGigyaUid()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.blueair.auth.AuthService r7 = r12.this$0
            int r8 = r6.length()
            if (r8 != 0) goto L_0x00df
            com.blueair.auth.GigyaService r6 = r7.getGigyaService()
            r12.L$0 = r13
            r12.L$1 = r1
            r12.L$2 = r3
            r12.L$3 = r4
            r12.I$0 = r5
            r12.label = r2
            java.lang.Object r2 = r6.refreshGigyaUid(r12)
            if (r2 != r0) goto L_0x00d2
        L_0x00d1:
            return r0
        L_0x00d2:
            r0 = r3
            r3 = r13
            r13 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L_0x00d8:
            r6 = r13
            java.lang.String r6 = (java.lang.String) r6
            r5 = r1
            r1 = r2
            r13 = r3
            goto L_0x00e1
        L_0x00df:
            r5 = r3
            r0 = r4
        L_0x00e1:
            r3 = r6
            java.lang.String r3 = (java.lang.String) r3
            com.blueair.auth.AuthService r2 = r12.this$0
            java.lang.String r4 = r2.getUsername()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.FILTER_REPLACEMENT
            int r6 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.QUICK_ALARM_STOP
            int r7 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.FILTER_CLEANING
            int r8 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.WATER_LEVEL
            int r9 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.MARKETING
            int r10 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.core.model.NotificationType r2 = com.blueair.core.model.NotificationType.TRANSACTIONAL
            int r11 = invokeSuspend$getSettingValue(r1, r13, r2)
            com.blueair.sdk.KlaviyoProfileData r2 = new com.blueair.sdk.KlaviyoProfileData
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0.setProfile(r2)
            com.blueair.sdk.KlaviyoSdk r13 = com.blueair.sdk.KlaviyoSdk.INSTANCE
            java.lang.String r0 = r12.$token
            java.lang.Throwable r13 = r13.setPushToken(r0)
            if (r13 == 0) goto L_0x0137
            com.blueair.auth.AuthService r0 = r12.this$0
            com.blueair.core.service.AnalyticsService r0 = r0.analyticsService
            com.blueair.core.model.AnalyticEvent$BugEvent$KlaviyoFail r1 = new com.blueair.core.model.AnalyticEvent$BugEvent$KlaviyoFail
            java.lang.String r13 = kotlin.ExceptionsKt.stackTraceToString(r13)
            r1.<init>(r13)
            com.blueair.core.model.AnalyticEvent r1 = (com.blueair.core.model.AnalyticEvent) r1
            r0.event(r1)
        L_0x0137:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthService$setPushToken$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    private static final int invokeSuspend$getSettingValue(Ref.BooleanRef booleanRef, List<NotificationSetting> list, NotificationType notificationType) {
        Object obj;
        if (!booleanRef.element) {
            return 0;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((NotificationSetting) obj).getType(), (Object) notificationType.getValue())) {
                break;
            }
        }
        NotificationSetting notificationSetting = (NotificationSetting) obj;
        if (notificationSetting != null) {
            return notificationSetting.getEnabled();
        }
        return 1;
    }
}
