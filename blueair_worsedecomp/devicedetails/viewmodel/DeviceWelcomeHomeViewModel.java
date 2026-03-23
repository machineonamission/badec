package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.devicedetails.util.DeviceWelcomeHomeProvider;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#2\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010!J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020\u0015J\b\u0010/\u001a\u00020\u001cH\u0016J\b\u00100\u001a\u00020\u0015H\u0016J\b\u00101\u001a\u00020\u0015H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "Lkotlin/Lazy;", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "getDevice", "()Lcom/blueair/core/model/HasWelcomeHome;", "setDevice", "(Lcom/blueair/core/model/HasWelcomeHome;)V", "welcomeHomeExist", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getWelcomeHomeExist", "()Landroidx/lifecycle/MutableLiveData;", "welcomeHomeEnabled", "getWelcomeHomeEnabled", "address", "", "getAddress", "radius", "getRadius", "welcomeHomeLocation", "Lcom/blueair/core/model/WelcomeHomeLocation;", "getLiveDeviceWelcomeHome", "Landroidx/lifecycle/LiveData;", "deviceId", "loadHomeLocation", "", "whLocation", "setWelcomeHomeEnabled", "enabled", "setAddHomeInstructionShowed", "isAddHomeInstructionsShowed", "homeAddress", "getHomeAddress", "()Ljava/lang/String;", "fetchRadius", "isEnabled", "isHomeLocationExist", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWelcomeHomeViewModel.kt */
public final class DeviceWelcomeHomeViewModel extends BaseViewModel implements DeviceWelcomeHomeProvider {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceWelcomeHomeViewModel.class, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0))};
    private final MutableLiveData<String> address = new MutableLiveData<>();
    public HasWelcomeHome device;
    private final MutableLiveData<String> radius = new MutableLiveData<>();
    private final MutableLiveData<Boolean> welcomeHomeEnabled = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> welcomeHomeExist = new MutableLiveData<>(false);
    private WelcomeHomeLocation welcomeHomeLocation;
    private final Lazy welcomeHomeService$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceWelcomeHomeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceWelcomeHomeViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.welcomeHomeService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, WelcomeHomeService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    private final WelcomeHomeService getWelcomeHomeService() {
        return (WelcomeHomeService) this.welcomeHomeService$delegate.getValue();
    }

    public final HasWelcomeHome getDevice() {
        HasWelcomeHome hasWelcomeHome = this.device;
        if (hasWelcomeHome != null) {
            return hasWelcomeHome;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(HasWelcomeHome hasWelcomeHome) {
        Intrinsics.checkNotNullParameter(hasWelcomeHome, "<set-?>");
        this.device = hasWelcomeHome;
    }

    public final MutableLiveData<Boolean> getWelcomeHomeExist() {
        return this.welcomeHomeExist;
    }

    public final MutableLiveData<Boolean> getWelcomeHomeEnabled() {
        return this.welcomeHomeEnabled;
    }

    public final MutableLiveData<String> getAddress() {
        return this.address;
    }

    public final MutableLiveData<String> getRadius() {
        return this.radius;
    }

    public final LiveData<WelcomeHomeLocation> getLiveDeviceWelcomeHome(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(new DeviceWelcomeHomeViewModel$getLiveDeviceWelcomeHome$$inlined$map$1(getDeviceManager().getFlowHasWelcomeHomeDevice(str)), new DeviceWelcomeHomeViewModel$$ExternalSyntheticLambda0()), ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean getLiveDeviceWelcomeHome$lambda$1(WelcomeHomeLocation welcomeHomeLocation2, WelcomeHomeLocation welcomeHomeLocation3) {
        Boolean bool = null;
        if (Intrinsics.areEqual((Object) welcomeHomeLocation2, (Object) welcomeHomeLocation3)) {
            boolean areEqual = Intrinsics.areEqual((Object) welcomeHomeLocation2 != null ? Boolean.valueOf(welcomeHomeLocation2.isEnabled()) : null, (Object) welcomeHomeLocation3 != null ? Boolean.valueOf(welcomeHomeLocation3.isEnabled()) : null);
        }
        if (!Intrinsics.areEqual((Object) welcomeHomeLocation2, (Object) welcomeHomeLocation3)) {
            return false;
        }
        Boolean valueOf = welcomeHomeLocation2 != null ? Boolean.valueOf(welcomeHomeLocation2.isEnabled()) : null;
        if (welcomeHomeLocation3 != null) {
            bool = Boolean.valueOf(welcomeHomeLocation3.isEnabled());
        }
        return Intrinsics.areEqual((Object) valueOf, (Object) bool);
    }

    public final void loadHomeLocation(WelcomeHomeLocation welcomeHomeLocation2) {
        if (welcomeHomeLocation2 != null) {
            this.welcomeHomeExist.setValue(true);
            if (!Intrinsics.areEqual((Object) this.welcomeHomeEnabled.getValue(), (Object) Boolean.valueOf(welcomeHomeLocation2.isEnabled()))) {
                this.welcomeHomeEnabled.setValue(Boolean.valueOf(welcomeHomeLocation2.isEnabled()));
            }
            this.address.setValue(welcomeHomeLocation2.getTextValue());
            MutableLiveData<String> mutableLiveData = this.radius;
            WelcomeHomeLocation.WelcomeHomeRadius fromValue = WelcomeHomeLocation.WelcomeHomeRadius.Companion.fromValue(Float.valueOf((float) welcomeHomeLocation2.getRadius()));
            mutableLiveData.setValue(fromValue != null ? fromValue.getTextValue() : null);
        } else {
            DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel = this;
            this.welcomeHomeExist.setValue(false);
        }
        this.welcomeHomeLocation = welcomeHomeLocation2;
    }

    public final void setWelcomeHomeEnabled(boolean z) {
        getDeviceManager().setWelcomeHomeEnabled(getDevice(), this.welcomeHomeLocation, z);
    }

    public final void setAddHomeInstructionShowed() {
        getWelcomeHomeService().setAddHomeInstructionsShowed(true);
    }

    public final boolean isAddHomeInstructionsShowed() {
        return getWelcomeHomeService().getAddHomeInstructionsShowed();
    }

    public String getHomeAddress() {
        String value = this.address.getValue();
        return value == null ? "" : value;
    }

    public String fetchRadius() {
        String value = this.radius.getValue();
        return value == null ? "" : value;
    }

    public boolean isEnabled() {
        if (isHomeLocationExist()) {
            Boolean value = this.welcomeHomeEnabled.getValue();
            if (value != null ? value.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    public boolean isHomeLocationExist() {
        Boolean value = this.welcomeHomeExist.getValue();
        if (value != null) {
            return value.booleanValue();
        }
        return false;
    }
}
