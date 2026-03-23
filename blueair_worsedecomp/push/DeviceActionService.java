package com.blueair.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.activity.Actions;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u001b\u001a\u00020\u001cX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/blueair/push/DeviceActionService;", "Landroid/app/Service;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onDestroy", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceActionService.kt */
public final class DeviceActionService extends Service implements DIAware, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final Lazy deviceManager$delegate;
    private final Lazy di$delegate;

    static {
        Class<DeviceActionService> cls = DeviceActionService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        return null;
    }

    public DeviceActionService() {
        DIPropertyDelegateProvider<Context> closestDI = ClosestKt.closestDI();
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceActionService$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Timber.Forest forest = Timber.Forest;
        forest.d("onStartCommand: " + intent.getAction(), new Object[0]);
        String stringExtra = intent.getStringExtra("device_id");
        if (stringExtra == null) {
            return 2;
        }
        String action = intent.getAction();
        if (action == null || action.hashCode() != 246957887 || !action.equals(Actions.ACTION_DEVICE_STOP_ALARM)) {
            stopSelf();
            return 2;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceActionService$onStartCommand$1$1(this, stringExtra, intent.getIntExtra(Actions.EXTRA_NOTIFICATION_ID, 0), (Continuation<? super DeviceActionService$onStartCommand$1$1>) null), 2, (Object) null);
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        Timber.Forest.d("onDestroy", new Object[0]);
    }
}
