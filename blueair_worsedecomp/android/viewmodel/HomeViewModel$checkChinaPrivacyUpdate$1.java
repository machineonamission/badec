package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$checkChinaPrivacyUpdate$1", f = "HomeViewModel.kt", i = {0, 0, 0, 0, 0}, l = {360}, m = "invokeSuspend", n = {"$this$launch", "latestVersion", "localConsentVersion", "remoteConsentVersion", "consentVersion"}, s = {"L$0", "I$0", "I$1", "I$2", "I$3"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$checkChinaPrivacyUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$checkChinaPrivacyUpdate$1(HomeViewModel homeViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super HomeViewModel$checkChinaPrivacyUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeViewModel$checkChinaPrivacyUpdate$1 homeViewModel$checkChinaPrivacyUpdate$1 = new HomeViewModel$checkChinaPrivacyUpdate$1(this.this$0, this.$onResult, continuation);
        homeViewModel$checkChinaPrivacyUpdate$1.L$0 = obj;
        return homeViewModel$checkChinaPrivacyUpdate$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$checkChinaPrivacyUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            r3 = 1
            if (r2 == 0) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0158
        L_0x0014:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.blueair.core.util.SkuConfigurationManager r14 = com.blueair.core.util.SkuConfigurationManager.INSTANCE
            com.blueair.core.model.ChinaPrivacy r14 = r14.getChinaPrivacy()
            int r14 = r14.getVersion()
            com.blueair.android.viewmodel.HomeViewModel r2 = r13.this$0
            r4 = 0
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0075 }
            android.app.Application r2 = r2.getApplication()     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = "china_privacy_consent_version"
            java.io.FileInputStream r2 = r2.openFileInput(r5)     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = "openFileInput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ all -> 0x0075 }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0075 }
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0075 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x0075 }
            r6.<init>(r2, r5)     // Catch:{ all -> 0x0075 }
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ all -> 0x0075 }
            boolean r2 = r6 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x004f
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x0075 }
            goto L_0x0057
        L_0x004f:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0075 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r6, r5)     // Catch:{ all -> 0x0075 }
            r6 = r2
        L_0x0057:
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x0075 }
            r2 = r6
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x006e }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x006e }
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x006e }
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch:{ all -> 0x0075 }
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = kotlin.Result.m9366constructorimpl(r2)     // Catch:{ all -> 0x0075 }
            goto L_0x0080
        L_0x006e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r2)     // Catch:{ all -> 0x0075 }
            throw r5     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r2 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m9366constructorimpl(r2)
        L_0x0080:
            boolean r5 = kotlin.Result.m9372isFailureimpl(r2)
            if (r5 == 0) goto L_0x0087
            r2 = r4
        L_0x0087:
            java.lang.Integer r2 = (java.lang.Integer) r2
            r5 = 0
            if (r2 == 0) goto L_0x0091
            int r2 = r2.intValue()
            goto L_0x0092
        L_0x0091:
            r2 = r5
        L_0x0092:
            com.blueair.core.util.UserInfoCollectionsManager r6 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.android.viewmodel.HomeViewModel r7 = r13.this$0
            com.blueair.auth.AuthService r7 = r7.getAuthService()
            java.lang.String r7 = r7.getUsername()
            com.blueair.android.viewmodel.HomeViewModel r8 = r13.this$0
            android.app.Application r8 = r8.getApplication()
            android.content.Context r8 = (android.content.Context) r8
            r6.initializeCollections(r7, r8)
            com.blueair.core.util.UserInfoCollectionsManager r6 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.core.model.UserInfoExtras r6 = r6.getExtras()
            int r6 = r6.getChinaPrivacyConsentVersion()
            if (r2 <= r6) goto L_0x0108
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "checkChinaPrivacyUpdate: write localConsentVersion "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = " to remote"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r7.d(r8, r9)
            com.blueair.android.viewmodel.HomeViewModel r7 = r13.this$0
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x00fe }
            com.blueair.core.util.UserInfoCollectionsManager r8 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE     // Catch:{ all -> 0x00fe }
            r8.setChinaPrivacyConsentVersion(r2)     // Catch:{ all -> 0x00fe }
            com.blueair.core.service.UnsecurePrefs r8 = r7.getPrefs()     // Catch:{ all -> 0x00fe }
            io.flatcircle.preferenceshelper2.Prefs r8 = (io.flatcircle.preferenceshelper2.Prefs) r8     // Catch:{ all -> 0x00fe }
            java.lang.String r9 = "KEY_USER_INFO_COLLECTIONS_SYNC_TIME"
            r10 = 0
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)     // Catch:{ all -> 0x00fe }
            io.flatcircle.preferenceshelper2.PreferencesHelper r11 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE     // Catch:{ all -> 0x00fe }
            io.flatcircle.preferenceshelper2.PrefsBackend r8 = r8.getBackend()     // Catch:{ all -> 0x00fe }
            java.lang.Class<java.lang.Long> r12 = java.lang.Long.class
            kotlin.reflect.KClass r12 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r12)     // Catch:{ all -> 0x00fe }
            r11.set(r8, r9, r10, r12)     // Catch:{ all -> 0x00fe }
            r7.checkUserInfoCollections()     // Catch:{ all -> 0x00fe }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fe }
            kotlin.Result.m9366constructorimpl(r7)     // Catch:{ all -> 0x00fe }
            goto L_0x0108
        L_0x00fe:
            r7 = move-exception
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            kotlin.Result.m9366constructorimpl(r7)
        L_0x0108:
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "checkChinaPrivacyUpdate: "
            r8.<init>(r9)
            r8.append(r14)
            java.lang.String r9 = " | "
            r8.append(r9)
            r8.append(r2)
            r8.append(r9)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r7.d(r8, r5)
            int r5 = java.lang.Math.max(r2, r6)
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.blueair.android.viewmodel.HomeViewModel$checkChinaPrivacyUpdate$1$2 r8 = new com.blueair.android.viewmodel.HomeViewModel$checkChinaPrivacyUpdate$1$2
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r9 = r13.$onResult
            r8.<init>(r9, r14, r5, r4)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r4 = r13
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r13.L$0 = r0
            r13.I$0 = r14
            r13.I$1 = r2
            r13.I$2 = r6
            r13.I$3 = r5
            r13.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r4)
            if (r14 != r1) goto L_0x0158
            return r1
        L_0x0158:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$checkChinaPrivacyUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
