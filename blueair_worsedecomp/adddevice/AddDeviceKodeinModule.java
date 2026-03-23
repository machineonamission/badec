package com.blueair.adddevice;

import android.content.Context;
import android.content.res.Resources;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.adddevice.service.DfuService;
import com.blueair.auth.AuthService;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DI;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/AddDeviceKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceKodeinModule.kt */
public final class AddDeviceKodeinModule {
    public static final AddDeviceKodeinModule INSTANCE = new AddDeviceKodeinModule();
    public static final String moduleName = "AddDevice";

    private AddDeviceKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new AddDeviceKodeinModule$$ExternalSyntheticLambda2(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final AddDeviceService getModule$lambda$2$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI5 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI6 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Resources resources = (Resources) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, Resources.class), (Object) null);
        DeviceManager deviceManager = (DeviceManager) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, DeviceManager.class), (Object) null);
        return new AddDeviceService(context, resources, deviceManager, (AuthService) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, AuthService.class), (Object) null), (SecurePrefs) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, SecurePrefs.class), (Object) null), (UnsecurePrefs) directDI5.Instance(new GenericJVMTypeTokenDelegate(typeToken5, UnsecurePrefs.class), (Object) null), (AnalyticsService) directDI6.Instance(new GenericJVMTypeTokenDelegate(typeToken6, AnalyticsService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final BlueAirManager getModule$lambda$2$lambda$1(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$lambda$1$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new BlueAirManager(context, DfuService.class, (AnalyticsService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$2(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, AddDeviceService.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        AddDeviceKodeinModule$$ExternalSyntheticLambda0 addDeviceKodeinModule$$ExternalSyntheticLambda0 = new AddDeviceKodeinModule$$ExternalSyntheticLambda0(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, AddDeviceService.class), (RefMaker) null, true, addDeviceKodeinModule$$ExternalSyntheticLambda0));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, BlueAirManager.class), (Object) null, (Boolean) null);
        AddDeviceKodeinModule$$ExternalSyntheticLambda1 addDeviceKodeinModule$$ExternalSyntheticLambda1 = new AddDeviceKodeinModule$$ExternalSyntheticLambda1(context);
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AddDeviceKodeinModule$getModule$lambda$2$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, BlueAirManager.class), (RefMaker) null, true, addDeviceKodeinModule$$ExternalSyntheticLambda1));
        return Unit.INSTANCE;
    }
}
