package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00018B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0016J\u0006\u00101\u001a\u00020-J\u0010\u00102\u001a\u00020-2\b\b\u0002\u00103\u001a\u00020\"R\u001b\u0010\u0007\u001a\u00020\b8VX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138DX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0012\u00104\u001a\u000205X\u0005¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/kodein/di/DIAware;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "addService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addService$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "asyncSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getAsyncSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "isServiceConnected", "", "()Z", "setServiceConnected", "(Z)V", "deviceModelType", "", "getDeviceModelType", "()I", "setDeviceModelType", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "hideLoading", "showLoading", "shouldShowLoading", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceBaseFragment.kt */
public abstract class AddDeviceBaseFragment extends Fragment implements DIAware, ProgressFragment, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final String ARG_DEVICE_MODEL_TYPE = "deviceModelType";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final Lazy addService$delegate;
    private final CompositeDisposable asyncSubs;
    private final Lazy deviceManager$delegate;
    private int deviceModelType;
    private final Lazy di$delegate;
    private boolean isServiceConnected;
    private ProgressBlockerView progressBlockerView;

    static {
        Class<AddDeviceBaseFragment> cls = AddDeviceBaseFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "addService", "getAddService()Lcom/blueair/adddevice/service/AddDeviceService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public AddDeviceBaseFragment() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceBaseFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.addService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AddDeviceService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceBaseFragment$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        this.asyncSubs = new CompositeDisposable();
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final AddDeviceService getAddService() {
        return (AddDeviceService) this.addService$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    /* access modifiers changed from: protected */
    public final CompositeDisposable getAsyncSubs() {
        return this.asyncSubs;
    }

    /* access modifiers changed from: protected */
    public final boolean isServiceConnected() {
        return this.isServiceConnected;
    }

    /* access modifiers changed from: protected */
    public final void setServiceConnected(boolean z) {
        this.isServiceConnected = z;
    }

    /* access modifiers changed from: protected */
    public final int getDeviceModelType() {
        return this.deviceModelType;
    }

    /* access modifiers changed from: protected */
    public final void setDeviceModelType(int i) {
        this.deviceModelType = i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.deviceModelType = arguments.getInt(ARG_DEVICE_MODEL_TYPE);
        }
    }

    public void onPause() {
        this.asyncSubs.clear();
        super.onPause();
    }

    public final void hideLoading() {
        showLoading(false);
    }

    public static /* synthetic */ void showLoading$default(AddDeviceBaseFragment addDeviceBaseFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            addDeviceBaseFragment.showLoading(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
    }

    public final void showLoading(boolean z) {
        showProgress(getContext(), z, Integer.valueOf(ContextCompat.getColor(requireContext(), R.color.white)));
        ProgressBlockerView progressBlockerView2 = getProgressBlockerView();
        if (progressBlockerView2 != null) {
            progressBlockerView2.setAnimationRawRes(R.raw.loading_animation_white);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment$Companion;", "", "<init>", "()V", "ARG_DEVICE_MODEL_TYPE", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceBaseFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
