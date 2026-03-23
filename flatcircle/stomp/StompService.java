package io.flatcircle.stomp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.blueair.auth.AuthService;
import com.blueair.core.AblEnvironment;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.HasAblCloudFunctions;
import com.foobot.liblabclient.ApiClient;
import com.foobot.liblabclient.User;
import com.foobot.liblabclient.async.AttributeMessageListener;
import com.foobot.liblabclient.async.StompMessenger;
import com.foobot.liblabclient.async.StringMessageListener;
import com.foobot.liblabclient.core.ServiceResolver;
import com.foobot.liblabclient.domain.Attribute;
import com.foobot.liblabclient.domain.AuthData;
import com.foobot.liblabclient.type.PatateModeConfig;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.coroutinehelper.IoCoroutineScope;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0004<=>?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eH@¢\u0006\u0002\u0010 J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0011H@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020+H\u0002J\u0014\u0010-\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u000e\u00102\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u000e\u00103\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u000e\u00104\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u000e\u00105\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u0014\u00106\u001a\u00020\u00182\n\u00107\u001a\u0006\u0012\u0002\b\u00030\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u000209X\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lio/flatcircle/stomp/StompService;", "Lkotlinx/coroutines/CoroutineScope;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Lcom/blueair/auth/AuthService;)V", "messenger", "Lcom/foobot/liblabclient/async/StompMessenger;", "_eventObservable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/flatcircle/stomp/StompEvent;", "eventObservable", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventObservable", "()Lkotlinx/coroutines/flow/SharedFlow;", "registeredDeviceIds", "", "", "pingCounters", "", "", "clientMutex", "Lkotlinx/coroutines/sync/Mutex;", "createClient", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBlueairUser", "Lcom/foobot/liblabclient/User;", "registerDevices", "stompDevices", "", "Lcom/blueair/core/model/HasAblCloudFunctions;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDevicesInternal", "newDevices", "registerDevice", "uuid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPingJob", "requestDataForDevice", "resetPingCounter", "incrementPingCounter", "isDeviceOffline", "", "hasRequiredInfo", "streamFromAttribute", "Lcom/blueair/core/model/DeviceStreamAttribute;", "attribute", "Lcom/foobot/liblabclient/domain/Attribute;", "goOnline", "restart", "goOffline", "clear", "destroySTOMPClient", "sendEvent", "stompEvent", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "AttributeListener", "PatateListener", "PingListener", "Companion", "stomp_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StompService.kt */
public final class StompService implements CoroutineScope {
    public static final String ATTRIBUTE_BRIGHTNESS = "brightness";
    public static final String ATTRIBUTE_FAN_SPEED = "fan_speed";
    public static final String ATTRIBUTE_MODE = "mode";
    private static final int AWARE_STREAMING_INTERVAL = 2;
    private static final int AWARE_STREAMING_TTL = 10;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Unit LOGOUT_EVENT = Unit.INSTANCE;
    private static final long PINGED_STATUS_UPDATE_DELAY = 10000;
    private final /* synthetic */ IoCoroutineScope $$delegate_0 = new IoCoroutineScope();
    /* access modifiers changed from: private */
    public final MutableSharedFlow<StompEvent<?>> _eventObservable;
    private final AuthService authService;
    private final Mutex clientMutex;
    private final SharedFlow<StompEvent<?>> eventObservable;
    /* access modifiers changed from: private */
    public StompMessenger messenger;
    private final Map<String, Integer> pingCounters;
    private final Set<String> registeredDeviceIds;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public StompService(AuthService authService2) {
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.authService = authService2;
        MutableSharedFlow<StompEvent<?>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 64, (BufferOverflow) null, 5, (Object) null);
        this._eventObservable = MutableSharedFlow$default;
        this.eventObservable = MutableSharedFlow$default;
        this.registeredDeviceIds = new LinkedHashSet();
        this.pingCounters = new LinkedHashMap();
        this.clientMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 2, (Object) null);
        Observable<String> filter = authService2.getGigyaJwtObserver().mergeWith(authService2.getAblJwtObserver()).filter(new StompService$$ExternalSyntheticLambda1(new StompService$$ExternalSyntheticLambda0()));
        Intrinsics.checkNotNullExpressionValue(filter, "filter(...)");
        RxExtensionsKt.subscribeAndLogE(filter, new StompService$$ExternalSyntheticLambda2(this));
    }

    public final SharedFlow<StompEvent<?>> getEventObservable() {
        return this.eventObservable;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.flatcircle.stomp.StompService$1", f = "StompService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.flatcircle.stomp.StompService$1  reason: invalid class name */
    /* compiled from: StompService.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ StompService this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Lifecycle lifecycle = ProcessLifecycleOwner.Companion.get().getLifecycle();
                final StompService stompService = this.this$0;
                lifecycle.addObserver(new LifecycleObserver() {
                    private boolean appStart = true;

                    @OnLifecycleEvent(Lifecycle.Event.ON_START)
                    public final void onMoveToForeground() {
                        Timber.Forest.d("LifecycleObserver.onMoveToForeground", new Object[0]);
                        if (this.appStart) {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(stompService, (CoroutineContext) null, (CoroutineStart) null, new StompService$1$1$onMoveToForeground$1(stompService, (Continuation<? super StompService$1$1$onMoveToForeground$1>) null), 3, (Object) null);
                        } else {
                            Job unused2 = BuildersKt__Builders_commonKt.launch$default(stompService, (CoroutineContext) null, (CoroutineStart) null, new StompService$1$1$onMoveToForeground$2(stompService, (Continuation<? super StompService$1$1$onMoveToForeground$2>) null), 3, (Object) null);
                        }
                        this.appStart = false;
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return str.length() > 0;
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final Unit _init_$lambda$2(StompService stompService, String str) {
        Timber.Forest forest = Timber.Forest;
        forest.v("new gigyaJwtObserver/ablJwtObserver value = " + str, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(stompService, (CoroutineContext) null, (CoroutineStart) null, new StompService$3$1(stompService, (Continuation<? super StompService$3$1>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A[Catch:{ Exception -> 0x00c3, all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createClient(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Stomp client failed to initialize with exception "
            java.lang.String r1 = "Creating Stomp Client. userId = "
            boolean r2 = r10 instanceof io.flatcircle.stomp.StompService$createClient$1
            if (r2 == 0) goto L_0x0018
            r2 = r10
            io.flatcircle.stomp.StompService$createClient$1 r2 = (io.flatcircle.stomp.StompService$createClient$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r10 = r2.label
            int r10 = r10 - r4
            r2.label = r10
            goto L_0x001d
        L_0x0018:
            io.flatcircle.stomp.StompService$createClient$1 r2 = new io.flatcircle.stomp.StompService$createClient$1
            r2.<init>(r9, r10)
        L_0x001d:
            java.lang.Object r10 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x003e
            if (r4 != r6) goto L_0x0036
            int r3 = r2.I$0
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0075
        L_0x0036:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "createClient mutex isLocked = "
            r4.<init>(r8)
            kotlinx.coroutines.sync.Mutex r8 = r9.clientMutex
            boolean r8 = r8.isLocked()
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r10.d(r4, r8)
            boolean r10 = r9.hasRequiredInfo()
            if (r10 != 0) goto L_0x0065
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0065:
            kotlinx.coroutines.sync.Mutex r10 = r9.clientMutex
            r2.L$0 = r10
            r2.I$0 = r7
            r2.label = r6
            java.lang.Object r2 = r10.lock(r5, r2)
            if (r2 != r3) goto L_0x0074
            return r3
        L_0x0074:
            r2 = r10
        L_0x0075:
            com.foobot.liblabclient.async.StompMessenger r10 = r9.messenger     // Catch:{ all -> 0x00df }
            if (r10 == 0) goto L_0x0085
            boolean r10 = r10.isConnected()     // Catch:{ all -> 0x00df }
            if (r10 != r6) goto L_0x0085
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00df }
            r2.unlock(r5)
            return r10
        L_0x0085:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r3.<init>(r1)     // Catch:{ all -> 0x00df }
            com.blueair.auth.AuthService r1 = r9.authService     // Catch:{ all -> 0x00df }
            int r1 = r1.getUserId()     // Catch:{ all -> 0x00df }
            r3.append(r1)     // Catch:{ all -> 0x00df }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00df }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ all -> 0x00df }
            r10.i(r1, r3)     // Catch:{ all -> 0x00df }
            com.foobot.liblabclient.async.StompMessenger r10 = new com.foobot.liblabclient.async.StompMessenger     // Catch:{ Exception -> 0x00c3 }
            com.foobot.liblabclient.User r1 = r9.createBlueairUser()     // Catch:{ Exception -> 0x00c3 }
            com.blueair.auth.AuthService r3 = r9.authService     // Catch:{ Exception -> 0x00c3 }
            int r3 = r3.getUserId()     // Catch:{ Exception -> 0x00c3 }
            com.blueair.auth.AuthService r4 = r9.authService     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r4 = r4.getAblJwt()     // Catch:{ Exception -> 0x00c3 }
            r10.<init>(r1, r3, r4)     // Catch:{ Exception -> 0x00c3 }
            r10.connect()     // Catch:{ Exception -> 0x00c3 }
            io.flatcircle.stomp.StompService$AttributeListener r1 = new io.flatcircle.stomp.StompService$AttributeListener     // Catch:{ Exception -> 0x00c3 }
            r1.<init>()     // Catch:{ Exception -> 0x00c3 }
            com.foobot.liblabclient.async.AttributeMessageListener r1 = (com.foobot.liblabclient.async.AttributeMessageListener) r1     // Catch:{ Exception -> 0x00c3 }
            r10.subscribeToDeviceAttributeChanges(r1)     // Catch:{ Exception -> 0x00c3 }
            r9.messenger = r10     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00d7
        L_0x00c3:
            r10 = move-exception
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r3.<init>(r0)     // Catch:{ all -> 0x00df }
            r3.append(r10)     // Catch:{ all -> 0x00df }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x00df }
            java.lang.Object[] r0 = new java.lang.Object[r7]     // Catch:{ all -> 0x00df }
            r1.w(r10, r0)     // Catch:{ all -> 0x00df }
        L_0x00d7:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00df }
            r2.unlock(r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00df:
            r10 = move-exception
            r2.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.createClient(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final User createBlueairUser() {
        String dropLast = StringsKt.dropLast(StringsKt.substringAfter$default(this.authService.getAblHomeHost(), "https://", (String) null, 2, (Object) null), 1);
        User Build = User.Build(this.authService.getUsername(), new AuthData(this.authService.getUsername(), (String) null));
        CharSequence charSequence = dropLast;
        if (charSequence.length() == 0) {
            charSequence = AblEnvironment.INSTANCE.getHost(AblEnvironment.INSTANCE.getBaseUrl());
        }
        ApiClient.setUserApiDomain((String) charSequence);
        Timber.Forest forest = Timber.Forest;
        forest.i("createBlueairUser: homehost = " + dropLast + ", username = " + this.authService.getUsername(), new Object[0]);
        Build.setApiKey(AblEnvironment.INSTANCE.getApiKey());
        Build.SetJwt(this.authService.getGigyaJwt());
        Build.SetEnvironment(AblEnvironment.INSTANCE.isUAT() ? ServiceResolver.Environment.UAT : ServiceResolver.Environment.PROD);
        Build.Login();
        Intrinsics.checkNotNull(Build);
        return Build;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, d2 = {"Lio/flatcircle/stomp/StompService$AttributeListener;", "Lcom/foobot/liblabclient/async/AttributeMessageListener;", "<init>", "(Lio/flatcircle/stomp/StompService;)V", "onMessage", "", "basicStompMessage", "Lcom/foobot/liblabclient/async/StompMessenger$BasicStompMessage;", "Lcom/foobot/liblabclient/domain/Attribute;", "stomp_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StompService.kt */
    private final class AttributeListener extends AttributeMessageListener {
        public AttributeListener() {
        }

        public void onMessage(StompMessenger.BasicStompMessage<Attribute> basicStompMessage) {
            Intrinsics.checkNotNullParameter(basicStompMessage, "basicStompMessage");
            Attribute attribute = (Attribute) basicStompMessage.content;
            String name = attribute.getName();
            Timber.Forest forest = Timber.Forest;
            forest.d("AttributeListener.onMessage: uuid = " + attribute.getUuid() + ", attributeName = " + name + ", value = " + attribute.getCurrentValue(), new Object[0]);
            StompService stompService = StompService.this;
            String str = attribute.uuid;
            Intrinsics.checkNotNullExpressionValue(str, "uuid");
            StompService stompService2 = StompService.this;
            Intrinsics.checkNotNull(attribute);
            stompService.sendEvent(new StompEvent(str, stompService2.streamFromAttribute(attribute)));
        }
    }

    public final Object registerDevices(List<? extends HasAblCloudFunctions> list, Continuation<? super Unit> continuation) {
        Iterable<Device> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Device uid : iterable) {
            arrayList.add(uid.getUid());
        }
        Object registerDevicesInternal = registerDevicesInternal((List) arrayList, continuation);
        return registerDevicesInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? registerDevicesInternal : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object registerDevicesInternal(java.util.List<java.lang.String> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.flatcircle.stomp.StompService$registerDevicesInternal$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.flatcircle.stomp.StompService$registerDevicesInternal$1 r0 = (io.flatcircle.stomp.StompService$registerDevicesInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.flatcircle.stomp.StompService$registerDevicesInternal$1 r0 = new io.flatcircle.stomp.StompService$registerDevicesInternal$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x0051
            if (r2 != r3) goto L_0x0049
            int r11 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$5
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r0.L$4
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b0
        L_0x0049:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0051:
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0075
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r12)
            com.foobot.liblabclient.async.StompMessenger r12 = r10.messenger
            if (r12 == 0) goto L_0x0069
            if (r12 == 0) goto L_0x0069
            boolean r12 = r12.isConnected()
            if (r12 != r5) goto L_0x0069
            goto L_0x0075
        L_0x0069:
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r12 = r10.goOnline(r0)
            if (r12 != r1) goto L_0x0075
            goto L_0x00e9
        L_0x0075:
            java.util.Set<java.lang.String> r12 = r10.registeredDeviceIds
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r12 = r12.containsAll(r2)
            if (r12 == 0) goto L_0x0083
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0083:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Attempting to register devices "
            r2.<init>(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r12.i(r2, r5)
            r12 = r11
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Set<java.lang.String> r2 = r10.registeredDeviceIds
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r12 = kotlin.collections.CollectionsKt.minus(r12, r2)
            r2 = r12
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r5 = r2.iterator()
            r6 = r5
            r5 = r2
            r2 = r6
            r7 = r11
            r6 = r12
            r11 = r4
        L_0x00b0:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x00ea
            java.lang.Object r12 = r2.next()
            r8 = r12
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$2 = r9
            r0.L$3 = r2
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$4 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$5 = r12
            r0.I$0 = r11
            r0.I$1 = r4
            r0.label = r3
            java.lang.Object r12 = r10.registerDevice(r8, r0)
            if (r12 != r1) goto L_0x00b0
        L_0x00e9:
            return r1
        L_0x00ea:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.registerDevicesInternal(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[Catch:{ Exception -> 0x00da, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[SYNTHETIC, Splitter:B:21:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object registerDevice(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.util.concurrent.TimeoutException {
        /*
            r10 = this;
            java.lang.String r0 = "/exchange/amq.topic/device."
            java.lang.String r1 = "offline issue "
            java.lang.String r2 = "Registering new device "
            boolean r3 = r12 instanceof io.flatcircle.stomp.StompService$registerDevice$1
            if (r3 == 0) goto L_0x001a
            r3 = r12
            io.flatcircle.stomp.StompService$registerDevice$1 r3 = (io.flatcircle.stomp.StompService$registerDevice$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r12 = r3.label
            int r12 = r12 - r5
            r3.label = r12
            goto L_0x001f
        L_0x001a:
            io.flatcircle.stomp.StompService$registerDevice$1 r3 = new io.flatcircle.stomp.StompService$registerDevice$1
            r3.<init>(r10, r12)
        L_0x001f:
            java.lang.Object r12 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x0046
            if (r5 != r8) goto L_0x003e
            int r11 = r3.I$0
            java.lang.Object r11 = r3.L$1
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r3 = r3.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r11 = r3
            goto L_0x005a
        L_0x003e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r10.clientMutex
            r3.L$0 = r11
            r3.L$1 = r12
            r3.I$0 = r7
            r3.label = r8
            java.lang.Object r3 = r12.lock(r6, r3)
            if (r3 != r4) goto L_0x005a
            return r4
        L_0x005a:
            java.util.Set<java.lang.String> r3 = r10.registeredDeviceIds     // Catch:{ all -> 0x00f6 }
            boolean r3 = r3.contains(r11)     // Catch:{ all -> 0x00f6 }
            if (r3 == 0) goto L_0x0068
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f6 }
            r12.unlock(r6)
            return r11
        L_0x0068:
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest     // Catch:{ all -> 0x00f6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f6 }
            r4.<init>(r2)     // Catch:{ all -> 0x00f6 }
            r4.append(r11)     // Catch:{ all -> 0x00f6 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00f6 }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ all -> 0x00f6 }
            r3.d(r2, r4)     // Catch:{ all -> 0x00f6 }
            com.foobot.liblabclient.async.StompMessenger r2 = r10.messenger     // Catch:{ Exception -> 0x00da }
            if (r2 == 0) goto L_0x00bc
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00da }
            if (r2 == 0) goto L_0x00bc
            java.lang.String r3 = "subscribe"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00da }
            java.lang.Class<com.foobot.liblabclient.async.StompMessenger$StompMessageListener> r9 = com.foobot.liblabclient.async.StompMessenger.StompMessageListener.class
            r5[r7] = r9     // Catch:{ Exception -> 0x00da }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r5[r8] = r9     // Catch:{ Exception -> 0x00da }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{ Exception -> 0x00da }
            if (r2 == 0) goto L_0x00bc
            r2.setAccessible(r8)     // Catch:{ Exception -> 0x00da }
            com.foobot.liblabclient.async.StompMessenger r3 = r10.messenger     // Catch:{ Exception -> 0x00da }
            io.flatcircle.stomp.StompService$PatateListener r5 = new io.flatcircle.stomp.StompService$PatateListener     // Catch:{ Exception -> 0x00da }
            r5.<init>(r10, r11)     // Catch:{ Exception -> 0x00da }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00da }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00da }
            r9.append(r11)     // Catch:{ Exception -> 0x00da }
            java.lang.String r0 = ".patate.push"
            r9.append(r0)     // Catch:{ Exception -> 0x00da }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x00da }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00da }
            r4[r7] = r5     // Catch:{ Exception -> 0x00da }
            r4[r8] = r0     // Catch:{ Exception -> 0x00da }
            r2.invoke(r3, r4)     // Catch:{ Exception -> 0x00da }
        L_0x00bc:
            com.foobot.liblabclient.async.StompMessenger r0 = r10.messenger     // Catch:{ Exception -> 0x00da }
            if (r0 == 0) goto L_0x00ca
            io.flatcircle.stomp.StompService$PingListener r2 = new io.flatcircle.stomp.StompService$PingListener     // Catch:{ Exception -> 0x00da }
            r2.<init>(r10, r11)     // Catch:{ Exception -> 0x00da }
            com.foobot.liblabclient.async.StringMessageListener r2 = (com.foobot.liblabclient.async.StringMessageListener) r2     // Catch:{ Exception -> 0x00da }
            r0.subscribeToPing(r2, r11)     // Catch:{ Exception -> 0x00da }
        L_0x00ca:
            r10.resetPingCounter(r11)     // Catch:{ Exception -> 0x00da }
            r10.startPingJob(r11)     // Catch:{ Exception -> 0x00da }
            java.util.Set<java.lang.String> r0 = r10.registeredDeviceIds     // Catch:{ Exception -> 0x00da }
            boolean r11 = r0.add(r11)     // Catch:{ Exception -> 0x00da }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)     // Catch:{ Exception -> 0x00da }
            goto L_0x00f0
        L_0x00da:
            r11 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ all -> 0x00f6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f6 }
            r2.<init>(r1)     // Catch:{ all -> 0x00f6 }
            r2.append(r11)     // Catch:{ all -> 0x00f6 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x00f6 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x00f6 }
            r0.w(r11, r1)     // Catch:{ all -> 0x00f6 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f6 }
        L_0x00f0:
            r12.unlock(r6)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00f6:
            r11 = move-exception
            r12.unlock(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.registerDevice(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/flatcircle/stomp/StompService$PatateListener;", "Lcom/foobot/liblabclient/async/StringMessageListener;", "uuid", "", "<init>", "(Lio/flatcircle/stomp/StompService;Ljava/lang/String;)V", "onMessage", "", "message", "Lcom/foobot/liblabclient/async/StompMessenger$BasicStompMessage;", "stomp_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StompService.kt */
    private final class PatateListener extends StringMessageListener {
        final /* synthetic */ StompService this$0;
        private final String uuid;

        public PatateListener(StompService stompService, String str) {
            Intrinsics.checkNotNullParameter(str, "uuid");
            this.this$0 = stompService;
            this.uuid = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
            r8 = kotlin.text.StringsKt.toFloatOrNull(r8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMessage(com.foobot.liblabclient.async.StompMessenger.BasicStompMessage<java.lang.String> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                java.lang.String r2 = "message"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                timber.log.Timber$Forest r2 = timber.log.Timber.Forest
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "PatateListener.onMessage uuid: "
                r3.<init>(r4)
                java.lang.String r4 = r0.uuid
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r4 = 0
                java.lang.Object[] r5 = new java.lang.Object[r4]
                r2.v(r3, r5)
                T r1 = r1.content
                java.lang.String r1 = (java.lang.String) r1
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L_0x0129
                int r3 = r2.length()
                if (r3 != 0) goto L_0x0032
                goto L_0x0129
            L_0x0032:
                int r2 = kotlin.text.StringsKt.getLastIndex(r2)
            L_0x0036:
                r3 = 1
                r5 = -1
                if (r5 >= r2) goto L_0x0050
                char r5 = r1.charAt(r2)
                r6 = 44
                if (r5 != r6) goto L_0x0045
                int r2 = r2 + -1
                goto L_0x0036
            L_0x0045:
                int r2 = r2 + r3
                java.lang.String r1 = r1.substring(r4, r2)
                java.lang.String r2 = "substring(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                goto L_0x0052
            L_0x0050:
                java.lang.String r1 = ""
            L_0x0052:
                r5 = r1
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r1 = ","
                java.lang.String[] r6 = new java.lang.String[]{r1}
                r9 = 6
                r10 = 0
                r7 = 0
                r8 = 0
                java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (java.lang.String[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
                com.blueair.core.model.IndoorDatapoint r5 = new com.blueair.core.model.IndoorDatapoint
                java.util.Date r2 = new java.util.Date
                r2.<init>()
                long r6 = r2.getTime()
                r2 = 1000(0x3e8, float:1.401E-42)
                long r8 = (long) r2
                long r6 = r6 / r8
                r8 = 4
                java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r1, r8)
                java.lang.String r8 = (java.lang.String) r8
                r9 = 0
                if (r8 == 0) goto L_0x0087
                java.lang.Float r8 = kotlin.text.StringsKt.toFloatOrNull(r8)
                if (r8 == 0) goto L_0x0087
                float r8 = r8.floatValue()
                goto L_0x0088
            L_0x0087:
                r8 = r9
            L_0x0088:
                java.lang.Float r8 = java.lang.Float.valueOf(r8)
                r10 = 6
                java.lang.Object r10 = kotlin.collections.CollectionsKt.getOrNull(r1, r10)
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x00a0
                java.lang.Float r10 = kotlin.text.StringsKt.toFloatOrNull(r10)
                if (r10 == 0) goto L_0x00a0
                float r10 = r10.floatValue()
                goto L_0x00a1
            L_0x00a0:
                r10 = r9
            L_0x00a1:
                java.lang.Float r10 = java.lang.Float.valueOf(r10)
                r11 = 5
                java.lang.Object r11 = kotlin.collections.CollectionsKt.getOrNull(r1, r11)
                java.lang.String r11 = (java.lang.String) r11
                if (r11 == 0) goto L_0x00b9
                java.lang.Float r11 = kotlin.text.StringsKt.toFloatOrNull(r11)
                if (r11 == 0) goto L_0x00b9
                float r11 = r11.floatValue()
                goto L_0x00ba
            L_0x00b9:
                r11 = r9
            L_0x00ba:
                java.lang.Float r11 = java.lang.Float.valueOf(r11)
                r12 = 3
                java.lang.Object r12 = kotlin.collections.CollectionsKt.getOrNull(r1, r12)
                java.lang.String r12 = (java.lang.String) r12
                if (r12 == 0) goto L_0x00d2
                java.lang.Float r12 = kotlin.text.StringsKt.toFloatOrNull(r12)
                if (r12 == 0) goto L_0x00d2
                float r12 = r12.floatValue()
                goto L_0x00d3
            L_0x00d2:
                r12 = r9
            L_0x00d3:
                java.lang.Float r12 = java.lang.Float.valueOf(r12)
                java.lang.Object r13 = kotlin.collections.CollectionsKt.getOrNull(r1, r4)
                java.lang.String r13 = (java.lang.String) r13
                if (r13 == 0) goto L_0x00ea
                java.lang.Float r13 = kotlin.text.StringsKt.toFloatOrNull(r13)
                if (r13 == 0) goto L_0x00ea
                float r13 = r13.floatValue()
                goto L_0x00eb
            L_0x00ea:
                r13 = r9
            L_0x00eb:
                float r2 = (float) r2
                float r13 = r13 / r2
                java.lang.Float r13 = java.lang.Float.valueOf(r13)
                java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r1, r3)
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x0103
                java.lang.Float r1 = kotlin.text.StringsKt.toFloatOrNull(r1)
                if (r1 == 0) goto L_0x0103
                float r9 = r1.floatValue()
            L_0x0103:
                float r9 = r9 / r2
                java.lang.Float r14 = java.lang.Float.valueOf(r9)
                r15 = 0
                r16 = 0
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = 0
                r5.<init>(r6, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                timber.log.Timber$Forest r1 = timber.log.Timber.Forest
                java.lang.String r2 = java.lang.String.valueOf(r5)
                java.lang.Object[] r3 = new java.lang.Object[r4]
                r1.v(r2, r3)
                io.flatcircle.stomp.StompService r1 = r0.this$0
                io.flatcircle.stomp.StompEvent r2 = new io.flatcircle.stomp.StompEvent
                java.lang.String r3 = r0.uuid
                r2.<init>(r3, r5)
                r1.sendEvent(r2)
            L_0x0129:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.PatateListener.onMessage(com.foobot.liblabclient.async.StompMessenger$BasicStompMessage):void");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lio/flatcircle/stomp/StompService$PingListener;", "Lcom/foobot/liblabclient/async/StringMessageListener;", "uuid", "", "<init>", "(Lio/flatcircle/stomp/StompService;Ljava/lang/String;)V", "lastUpdateTimestamp", "", "getLastUpdateTimestamp", "()J", "setLastUpdateTimestamp", "(J)V", "onMessage", "", "basicStompMessage", "Lcom/foobot/liblabclient/async/StompMessenger$BasicStompMessage;", "stomp_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StompService.kt */
    private final class PingListener extends StringMessageListener {
        private long lastUpdateTimestamp;
        final /* synthetic */ StompService this$0;
        private final String uuid;

        public PingListener(StompService stompService, String str) {
            Intrinsics.checkNotNullParameter(str, "uuid");
            this.this$0 = stompService;
            this.uuid = str;
        }

        public final long getLastUpdateTimestamp() {
            return this.lastUpdateTimestamp;
        }

        public final void setLastUpdateTimestamp(long j) {
            this.lastUpdateTimestamp = j;
        }

        public void onMessage(StompMessenger.BasicStompMessage<String> basicStompMessage) {
            Intrinsics.checkNotNullParameter(basicStompMessage, "basicStompMessage");
            Timber.Forest forest = Timber.Forest;
            forest.d("sends online event: " + this.this$0._eventObservable + " & uuid = " + this.uuid, new Object[0]);
            this.this$0.sendEvent(new StompEvent(this.uuid, ConnectivityStatus.ONLINE));
            this.this$0.resetPingCounter(this.uuid);
            this.lastUpdateTimestamp = System.currentTimeMillis();
        }
    }

    private final void startPingJob(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new StompService$startPingJob$1(this, str, (Continuation<? super StompService$startPingJob$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void requestDataForDevice(String str) {
        PatateModeConfig ttl = new PatateModeConfig().setOnOff(1).setRefreshFreq(2).setTtl(10);
        StompMessenger stompMessenger = this.messenger;
        if (stompMessenger != null) {
            stompMessenger.publishStartPatateMode(str, ttl);
        }
    }

    /* access modifiers changed from: private */
    public final void resetPingCounter(String str) {
        this.pingCounters.put(str, 0);
    }

    /* access modifiers changed from: private */
    public final void incrementPingCounter(String str) {
        if (this.pingCounters.containsKey(str)) {
            this.pingCounters.put(str, Integer.valueOf(((Number) MapsKt.getValue(this.pingCounters, str)).intValue() + 1));
        } else {
            this.pingCounters.put(str, 1);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isDeviceOffline(String str) {
        return this.pingCounters.containsKey(str) && ((Number) MapsKt.getValue(this.pingCounters, str)).intValue() > 2;
    }

    /* access modifiers changed from: private */
    public final boolean hasRequiredInfo() {
        return this.authService.isUserLoggedIn().getValue().booleanValue() && this.authService.getUsername().length() > 0 && this.authService.getGigyaJwt().length() > 0 && this.authService.getAblJwt().length() > 0;
    }

    /* access modifiers changed from: private */
    public final DeviceStreamAttribute<?> streamFromAttribute(Attribute attribute) {
        String str = attribute.name;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -752282597) {
                if (hashCode != 3357091) {
                    if (hashCode == 648162385 && str.equals("brightness")) {
                        String currentValue = attribute.getCurrentValue();
                        Intrinsics.checkNotNullExpressionValue(currentValue, "getCurrentValue(...)");
                        return new DeviceStreamAttribute.Brightness(Integer.parseInt(currentValue));
                    }
                } else if (str.equals("mode")) {
                    String currentValue2 = attribute.getCurrentValue();
                    Intrinsics.checkNotNullExpressionValue(currentValue2, "getCurrentValue(...)");
                    return new DeviceStreamAttribute.AutoMode(currentValue2);
                }
            } else if (str.equals(ATTRIBUTE_FAN_SPEED)) {
                String currentValue3 = attribute.getCurrentValue();
                Intrinsics.checkNotNullExpressionValue(currentValue3, "getCurrentValue(...)");
                return new DeviceStreamAttribute.FanSpeed(Integer.parseInt(currentValue3));
            }
        }
        return new DeviceStreamAttribute.Unknown(false, 1, (DefaultConstructorMarker) null);
    }

    public final Object goOnline(Continuation<? super Unit> continuation) {
        Timber.Forest.d("goOnline", new Object[0]);
        Object createClient = createClient(continuation);
        return createClient == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? createClient : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        if (createClient(r0) != r1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        if (registerDevicesInternal(r9, r0) == r1) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object restart(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.flatcircle.stomp.StompService$restart$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.flatcircle.stomp.StompService$restart$1 r0 = (io.flatcircle.stomp.StompService$restart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.flatcircle.stomp.StompService$restart$1 r0 = new io.flatcircle.stomp.StompService$restart$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009b
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0085
        L_0x0044:
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007a
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.String r2 = "restart"
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r9.d(r2, r7)
            java.util.Set<java.lang.String> r9 = r8.registeredDeviceIds
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.Object[] r9 = r9.toArray(r2)
            java.lang.String[] r9 = (java.lang.String[]) r9
            int r2 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r2)
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r9)
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r2 = r8.clear(r0)
            if (r2 != r1) goto L_0x0079
            goto L_0x009a
        L_0x0079:
            r2 = r9
        L_0x007a:
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r8.createClient(r0)
            if (r9 != r1) goto L_0x0085
            goto L_0x009a
        L_0x0085:
            r9 = r2
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.toList(r9)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.registerDevicesInternal(r9, r0)
            if (r9 != r1) goto L_0x009b
        L_0x009a:
            return r1
        L_0x009b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.restart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object goOffline(Continuation<? super Unit> continuation) {
        Timber.Forest.d("goOffline", new Object[0]);
        for (String stompEvent : this.registeredDeviceIds) {
            sendEvent(new StompEvent(stompEvent, ConnectivityStatus.OFFLINE));
        }
        Object clear = clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clear(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.flatcircle.stomp.StompService$clear$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.flatcircle.stomp.StompService$clear$1 r0 = (io.flatcircle.stomp.StompService$clear$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.flatcircle.stomp.StompService$clear$1 r0 = new io.flatcircle.stomp.StompService$clear$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "clear"
            r6.d(r4, r2)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            r2 = 0
            kotlinx.coroutines.JobKt__JobKt.cancelChildren$default((kotlin.coroutines.CoroutineContext) r6, (java.util.concurrent.CancellationException) r2, (int) r3, (java.lang.Object) r2)
            java.util.Set<java.lang.String> r6 = r5.registeredDeviceIds
            r6.clear()
            r0.label = r3
            java.lang.Object r6 = r5.destroySTOMPClient(r0)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            io.flatcircle.stomp.StompEvent r6 = new io.flatcircle.stomp.StompEvent
            java.lang.String r0 = ""
            kotlin.Unit r1 = LOGOUT_EVENT
            r6.<init>(r0, r1)
            r5.sendEvent(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.clear(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d A[Catch:{ Exception -> 0x0093, all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object destroySTOMPClient(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to disconnect STOMP messenger "
            boolean r1 = r9 instanceof io.flatcircle.stomp.StompService$destroySTOMPClient$1
            if (r1 == 0) goto L_0x0016
            r1 = r9
            io.flatcircle.stomp.StompService$destroySTOMPClient$1 r1 = (io.flatcircle.stomp.StompService$destroySTOMPClient$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r9 = r1.label
            int r9 = r9 - r3
            r1.label = r9
            goto L_0x001b
        L_0x0016:
            io.flatcircle.stomp.StompService$destroySTOMPClient$1 r1 = new io.flatcircle.stomp.StompService$destroySTOMPClient$1
            r1.<init>(r8, r9)
        L_0x001b:
            java.lang.Object r9 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L_0x003c
            if (r3 != r4) goto L_0x0034
            int r2 = r1.I$0
            java.lang.Object r1 = r1.L$0
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0080
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r9)
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r7 = "destroySTOMPClient mutex isLocked = "
            r3.<init>(r7)
            kotlinx.coroutines.sync.Mutex r7 = r8.clientMutex
            boolean r7 = r7.isLocked()
            r3.append(r7)
            java.lang.String r7 = ", client connected = "
            r3.append(r7)
            com.foobot.liblabclient.async.StompMessenger r7 = r8.messenger
            if (r7 == 0) goto L_0x0063
            boolean r7 = r7.isConnected()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            goto L_0x0064
        L_0x0063:
            r7 = r5
        L_0x0064:
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r9.d(r3, r7)
            kotlinx.coroutines.sync.Mutex r9 = r8.clientMutex
            r1.L$0 = r9
            r1.I$0 = r6
            r1.label = r4
            java.lang.Object r1 = r9.lock(r5, r1)
            if (r1 != r2) goto L_0x007f
            return r2
        L_0x007f:
            r1 = r9
        L_0x0080:
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "destroying STOMP client"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x00af }
            r9.d(r2, r3)     // Catch:{ all -> 0x00af }
            com.foobot.liblabclient.async.StompMessenger r9 = r8.messenger     // Catch:{ Exception -> 0x0093 }
            if (r9 == 0) goto L_0x00a9
            r9.disconnect()     // Catch:{ Exception -> 0x0093 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0093 }
            goto L_0x00a9
        L_0x0093:
            r9 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r3.<init>(r0)     // Catch:{ all -> 0x00af }
            r3.append(r9)     // Catch:{ all -> 0x00af }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x00af }
            java.lang.Object[] r0 = new java.lang.Object[r6]     // Catch:{ all -> 0x00af }
            r2.e(r9, r0)     // Catch:{ all -> 0x00af }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00af }
        L_0x00a9:
            r1.unlock(r5)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00af:
            r9 = move-exception
            r1.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.stomp.StompService.destroySTOMPClient(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void sendEvent(StompEvent<?> stompEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new StompService$sendEvent$1(this, stompEvent, (Continuation<? super StompService$sendEvent$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/flatcircle/stomp/StompService$Companion;", "", "<init>", "()V", "PINGED_STATUS_UPDATE_DELAY", "", "AWARE_STREAMING_INTERVAL", "", "AWARE_STREAMING_TTL", "LOGOUT_EVENT", "", "Lkotlin/Unit;", "ATTRIBUTE_FAN_SPEED", "", "ATTRIBUTE_MODE", "ATTRIBUTE_BRIGHTNESS", "stomp_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StompService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
