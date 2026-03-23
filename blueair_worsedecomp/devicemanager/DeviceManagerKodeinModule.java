package com.blueair.devicemanager;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.repository.DeviceRepository;
import com.blueair.database.repository.DeviceScheduleRepository;
import com.blueair.database.repository.NotificationRepository;
import com.blueair.database.repository.TrackedLocationRepository;
import com.blueair.livestream.LiveStreamKodeinModule;
import com.blueair.livestream.StreamService;
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

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/devicemanager/DeviceManagerKodeinModule;", "", "<init>", "()V", "MODULE_NAME", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceManagerKodeinModule.kt */
public final class DeviceManagerKodeinModule {
    public static final DeviceManagerKodeinModule INSTANCE = new DeviceManagerKodeinModule();
    private static final String MODULE_NAME = "DeviceManager";

    private DeviceManagerKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(MODULE_NAME, false, (String) null, new DeviceManagerKodeinModule$$ExternalSyntheticLambda0(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final BlueairDatabase getModule$lambda$7$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        return BlueairDatabase.Companion.getDatabase(context);
    }

    /* access modifiers changed from: private */
    public static final DeviceRepository getModule$lambda$7$lambda$1(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$1$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$1$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$1$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$1$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI5 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$1$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new DeviceRepository((BlueairDatabase) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueairDatabase.class), (Object) null), (TrackedLocationRepository) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, TrackedLocationRepository.class), (Object) null), (UnsecurePrefs) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, UnsecurePrefs.class), (Object) null), (AnalyticsService) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, AnalyticsService.class), (Object) null), (LocationService) directDI5.Instance(new GenericJVMTypeTokenDelegate(typeToken5, LocationService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final DeviceScheduleRepository getModule$lambda$7$lambda$2(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$2$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new DeviceScheduleRepository((BlueairDatabase) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueairDatabase.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final DeviceManager getModule$lambda$7$lambda$4(NoArgBindingDI noArgBindingDI) {
        NoArgBindingDI noArgBindingDI2 = noArgBindingDI;
        Intrinsics.checkNotNullParameter(noArgBindingDI2, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI2;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI5 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI6 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI7 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$7().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI8 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$8().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI9 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken9 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$9().getSuperType());
        Intrinsics.checkNotNull(typeToken9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI10 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken10 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$10().getSuperType());
        Intrinsics.checkNotNull(typeToken10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI11 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken11 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$4$$inlined$instance$default$11().getSuperType());
        Intrinsics.checkNotNull(typeToken11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DeviceManager deviceManager = new DeviceManager((Resources) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, Resources.class), (Object) null), (DeviceRepository) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, DeviceRepository.class), (Object) null), (DeviceScheduleRepository) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, DeviceScheduleRepository.class), (Object) null), (NotificationRepository) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, NotificationRepository.class), (Object) null), (AuthService) directDI5.Instance(new GenericJVMTypeTokenDelegate(typeToken5, AuthService.class), (Object) null), (StreamService) directDI6.Instance(new GenericJVMTypeTokenDelegate(typeToken6, StreamService.class), (Object) null), (UnsecurePrefs) directDI7.Instance(new GenericJVMTypeTokenDelegate(typeToken7, UnsecurePrefs.class), (Object) null), (AnalyticsService) directDI8.Instance(new GenericJVMTypeTokenDelegate(typeToken8, AnalyticsService.class), (Object) null), (LocationService) directDI9.Instance(new GenericJVMTypeTokenDelegate(typeToken9, LocationService.class), (Object) null), (HappyUserService) directDI10.Instance(new GenericJVMTypeTokenDelegate(typeToken10, HappyUserService.class), (Object) null), (WelcomeHomeService) directDI11.Instance(new GenericJVMTypeTokenDelegate(typeToken11, WelcomeHomeService.class), (Object) null));
        LogOutService.Companion.registerLogOutable(noArgBindingDI2, deviceManager);
        return deviceManager;
    }

    /* access modifiers changed from: private */
    public static final DeviceScheduleService getModule$lambda$7$lambda$5(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$5$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$5$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new DeviceScheduleService((DeviceManager) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, DeviceManager.class), (Object) null), (DeviceScheduleRepository) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, DeviceScheduleRepository.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final NotificationRepository getModule$lambda$7$lambda$6(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$6$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$lambda$6$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new NotificationRepository((BlueairDatabase) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueairDatabase.class), (Object) null), (DeviceRepository) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, DeviceRepository.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$7(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, BlueairDatabase.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        DeviceManagerKodeinModule$$ExternalSyntheticLambda1 deviceManagerKodeinModule$$ExternalSyntheticLambda1 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda1(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, BlueairDatabase.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda1));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, DeviceRepository.class), (Object) null, (Boolean) null);
        DeviceManagerKodeinModule$$ExternalSyntheticLambda2 deviceManagerKodeinModule$$ExternalSyntheticLambda2 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda2();
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, DeviceRepository.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda2));
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind3 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken5, DeviceScheduleRepository.class), (Object) null, (Boolean) null);
        DeviceManagerKodeinModule$$ExternalSyntheticLambda3 deviceManagerKodeinModule$$ExternalSyntheticLambda3 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda3();
        Scope scope3 = withScope.getScope();
        TypeToken contextType3 = withScope.getContextType();
        boolean explicitContext3 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind3.with(new Singleton(scope3, contextType3, explicitContext3, new GenericJVMTypeTokenDelegate(typeToken6, DeviceScheduleRepository.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda3));
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind4 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken7, DeviceManager.class), (Object) null, (Boolean) null);
        DeviceManagerKodeinModule$$ExternalSyntheticLambda4 deviceManagerKodeinModule$$ExternalSyntheticLambda4 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda4();
        Scope scope4 = withScope.getScope();
        TypeToken contextType4 = withScope.getContextType();
        boolean explicitContext4 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind4.with(new Singleton(scope4, contextType4, explicitContext4, new GenericJVMTypeTokenDelegate(typeToken8, DeviceManager.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda4));
        JVMTypeToken<?> typeToken9 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind5 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken9, DeviceScheduleService.class), (Object) null, (Boolean) null);
        DeviceManagerKodeinModule$$ExternalSyntheticLambda5 deviceManagerKodeinModule$$ExternalSyntheticLambda5 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda5();
        Scope scope5 = withScope.getScope();
        TypeToken contextType5 = withScope.getContextType();
        boolean explicitContext5 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken10 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind5.with(new Singleton(scope5, contextType5, explicitContext5, new GenericJVMTypeTokenDelegate(typeToken10, DeviceScheduleService.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda5));
        JVMTypeToken<?> typeToken11 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$bind$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind6 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken11, NotificationRepository.class), (Object) null, (Boolean) null);
        DeviceManagerKodeinModule$$ExternalSyntheticLambda6 deviceManagerKodeinModule$$ExternalSyntheticLambda6 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda6();
        Scope scope6 = withScope.getScope();
        TypeToken contextType6 = withScope.getContextType();
        boolean explicitContext6 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken12 = TypeTokensJVMKt.typeToken(new DeviceManagerKodeinModule$getModule$lambda$7$$inlined$singleton$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind6.with(new Singleton(scope6, contextType6, explicitContext6, new GenericJVMTypeTokenDelegate(typeToken12, NotificationRepository.class), (RefMaker) null, true, deviceManagerKodeinModule$$ExternalSyntheticLambda6));
        DI.Builder.DefaultImpls.importOnce$default(builder, LiveStreamKodeinModule.INSTANCE.getModule(context), false, 2, (Object) null);
        return Unit.INSTANCE;
    }
}
