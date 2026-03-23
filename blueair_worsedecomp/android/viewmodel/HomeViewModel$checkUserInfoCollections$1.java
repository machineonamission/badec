package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1", f = "HomeViewModel.kt", i = {0, 1, 2}, l = {321, 321, 321}, m = "invokeSuspend", n = {"lastSyncTime", "lastSyncTime", "lastSyncTime"}, s = {"J$0", "J$0", "J$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$checkUserInfoCollections$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$checkUserInfoCollections$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$checkUserInfoCollections$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$checkUserInfoCollections$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$checkUserInfoCollections$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00db, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r14, new com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1.AnonymousClass2>) null), r13) != r0) goto L_0x00de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r5) goto L_0x0026
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00de
        L_0x0017:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001f:
            long r4 = r13.J$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00c7
        L_0x0026:
            long r5 = r13.J$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ad
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r14)
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.String r1 = "checkUserInfoCollections"
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r14.d(r1, r7)
            com.blueair.android.viewmodel.HomeViewModel r14 = r13.this$0
            com.blueair.core.service.UnsecurePrefs r14 = r14.getPrefs()
            io.flatcircle.preferenceshelper2.Prefs r14 = (io.flatcircle.preferenceshelper2.Prefs) r14
            r7 = 0
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            io.flatcircle.preferenceshelper2.PreferencesHelper r7 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r14 = r14.getBackend()
            java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.String r9 = "KEY_USER_INFO_COLLECTIONS_SYNC_TIME"
            java.lang.Object r14 = r7.get(r14, r9, r1, r8)
            java.lang.Number r14 = (java.lang.Number) r14
            long r7 = r14.longValue()
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r7
            r11 = 604800000(0x240c8400, double:2.988109026E-315)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x00de
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.String r1 = "syncUserInfoCollections"
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r14.d(r1, r6)
            com.blueair.core.util.UserInfoCollectionsManager r14 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.android.viewmodel.HomeViewModel r1 = r13.this$0
            com.blueair.auth.AuthService r1 = r1.getAuthService()
            java.lang.String r1 = r1.getUsername()
            com.blueair.android.viewmodel.HomeViewModel r6 = r13.this$0
            android.app.Application r6 = r6.getApplication()
            android.content.Context r6 = (android.content.Context) r6
            r14.initializeCollections(r1, r6)
            com.blueair.android.viewmodel.HomeViewModel r14 = r13.this$0
            com.blueair.devicemanager.DeviceManager r14 = r14.getDeviceManager()
            com.blueair.core.util.UserInfoCollectionsManager r1 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            int r1 = r1.getVersion()
            com.blueair.core.util.UserInfoCollectionsManager r6 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            int r6 = r6.getSeries()
            r9 = r13
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r13.J$0 = r7
            r13.label = r5
            java.lang.Object r14 = r14.getUserInfoCollections(r1, r6, r9)
            if (r14 != r0) goto L_0x00ac
            goto L_0x00dd
        L_0x00ac:
            r5 = r7
        L_0x00ad:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1$1 r1 = new com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1$1
            com.blueair.android.viewmodel.HomeViewModel r7 = r13.this$0
            r1.<init>(r7, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r7 = r13
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r13.J$0 = r5
            r13.label = r4
            java.lang.Object r14 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r14, r1, r7)
            if (r14 != r0) goto L_0x00c6
            goto L_0x00dd
        L_0x00c6:
            r4 = r5
        L_0x00c7:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1$2 r1 = new com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r13
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r13.J$0 = r4
            r13.label = r3
            java.lang.Object r14 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r14, r1, r2)
            if (r14 != r0) goto L_0x00de
        L_0x00dd:
            return r0
        L_0x00de:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.HomeViewModel$checkUserInfoCollections$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
