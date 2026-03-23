package com.blueair.android;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.blueair.adddevice.AddDeviceKodeinModule;
import com.blueair.auth.AuthKodeinModule;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.bluetooth.BluetoothKodeinModule;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.FileNames;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.core.util.PhoneUtil;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.DeviceManagerKodeinModule;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.outdoor.OutdoorKodeinModule;
import com.blueair.push.NotificationService;
import com.blueair.push.PushKodeinModule;
import com.blueair.sdk.BugfenderSdk;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.sdk.LokaliseSdk;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ResourcesLocationNamePlaceholderProvider;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.gigya.android.sdk.Gigya;
import com.jacquessmuts.rxextensions.RxHelper;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.joda.time.LocalDateTime;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DirectDI;
import org.kodein.di.LazyDI;
import org.kodein.di.LazyDelegate;
import org.kodein.di.bindings.InstanceBinding;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0005\u001a\u00020\u00068VX\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u0002²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u0002²\u0006\n\u0010!\u001a\u00020\"X\u0002²\u0006\n\u0010#\u001a\u00020$X\u0002²\u0006\n\u0010%\u001a\u00020&X\u0002²\u0006\n\u0010'\u001a\u00020(X\u0002²\u0006\n\u0010)\u001a\u00020*X\u0002²\u0006\n\u0010+\u001a\u00020,X\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u0002²\u0006\n\u0010)\u001a\u00020*X\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u0002"}, d2 = {"Lcom/blueair/android/BlueairApp;", "Landroid/app/Application;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/LazyDI;", "getDi", "()Lorg/kodein/di/LazyDI;", "di$delegate", "isInChinaLauncherProcess", "", "onCreate", "", "onAppUpgrade", "oldVersionCode", "", "oldVersionName", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "InMemoryTree", "BugfenderTree", "app_otherRelease", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "authService", "Lcom/blueair/auth/AuthService;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "locationService", "Lcom/blueair/auth/LocationService;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "logoutService", "Lcom/blueair/auth/LogOutService;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "notificationService", "Lcom/blueair/push/NotificationService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairApp.kt */
public final class BlueairApp extends Application implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private final LazyDI di$delegate = DI.Companion.lazy$default(DI.Companion, false, new BlueairApp$$ExternalSyntheticLambda4(this), 1, (Object) null);
    private final boolean isInChinaLauncherProcess = StringsKt.startsWith$default(FilesKt.readText$default(new File("/proc/self/cmdline"), (Charset) null, 1, (Object) null), ".china_launcher", false, 2, (Object) null);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueairApp.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.BuildVariant[] r0 = com.blueair.core.BuildVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.DEBUG     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.BETA     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.RELEASE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.BlueairApp.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<BlueairApp> cls = BlueairApp.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/LazyDI;", 0)), Reflection.property0(new PropertyReference0Impl(cls, "analyticsService", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "authService", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "prefs", "<v#2>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "happyUserService", "<v#3>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "locationService", "<v#4>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "deviceManager", "<v#5>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "welcomeHomeService", "<v#6>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "logoutService", "<v#7>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "gigyaService", "<v#8>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "notificationService", "<v#9>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "analyticsService", "<v#10>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "gigyaService", "<v#11>", 0)), Reflection.property0(new PropertyReference0Impl(cls, "authService", "<v#12>", 0))};
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public LazyDI getDi() {
        return this.di$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public static final Unit di_delegate$lambda$8(BlueairApp blueairApp, DI.MainBuilder mainBuilder) {
        Intrinsics.checkNotNullParameter(mainBuilder, "$this$lazy");
        DI.Builder builder = mainBuilder;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, Application.class), (Object) null, (Boolean) null);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$instance$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new InstanceBinding(new GenericJVMTypeTokenDelegate(typeToken2, BlueairApp.class), blueairApp));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, Context.class), (Object) null, (Boolean) null);
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$instance$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new InstanceBinding(new GenericJVMTypeTokenDelegate(typeToken4, Context.class), applicationContext));
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind3 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken5, Resources.class), (Object) null, (Boolean) null);
        Resources resources = blueairApp.getApplicationContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$instance$3().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind3.with(new InstanceBinding(new GenericJVMTypeTokenDelegate(typeToken6, Resources.class), resources));
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind4 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken7, LocationNamePlaceholderProvider.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = mainBuilder;
        BlueairApp$$ExternalSyntheticLambda5 blueairApp$$ExternalSyntheticLambda5 = new BlueairApp$$ExternalSyntheticLambda5(blueairApp);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind4.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken8, ResourcesLocationNamePlaceholderProvider.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda5));
        JVMTypeToken<?> typeToken9 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind5 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken9, AnalyticsService.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda6 blueairApp$$ExternalSyntheticLambda6 = new BlueairApp$$ExternalSyntheticLambda6(blueairApp);
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken10 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind5.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken10, AnalyticsService.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda6));
        JVMTypeToken<?> typeToken11 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind6 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken11, UnsecurePrefs.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda7 blueairApp$$ExternalSyntheticLambda7 = new BlueairApp$$ExternalSyntheticLambda7(blueairApp);
        Scope scope3 = withScope.getScope();
        TypeToken contextType3 = withScope.getContextType();
        boolean explicitContext3 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken12 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind6.with(new Singleton(scope3, contextType3, explicitContext3, new GenericJVMTypeTokenDelegate(typeToken12, UnsecurePrefs.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda7));
        JVMTypeToken<?> typeToken13 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$7().getSuperType());
        Intrinsics.checkNotNull(typeToken13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind7 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken13, SecurePrefs.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda8 blueairApp$$ExternalSyntheticLambda8 = new BlueairApp$$ExternalSyntheticLambda8(blueairApp);
        Scope scope4 = withScope.getScope();
        TypeToken contextType4 = withScope.getContextType();
        boolean explicitContext4 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken14 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind7.with(new Singleton(scope4, contextType4, explicitContext4, new GenericJVMTypeTokenDelegate(typeToken14, SecurePrefs.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda8));
        JVMTypeToken<?> typeToken15 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$8().getSuperType());
        Intrinsics.checkNotNull(typeToken15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind8 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken15, LocationPermissionTracker.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda9 blueairApp$$ExternalSyntheticLambda9 = new BlueairApp$$ExternalSyntheticLambda9();
        TypeToken contextType5 = mainBuilder.getContextType();
        JVMTypeToken<?> typeToken16 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$provider$1().getSuperType());
        Intrinsics.checkNotNull(typeToken16, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind8.with(new Provider(contextType5, new GenericJVMTypeTokenDelegate(typeToken16, LocationPermissionTracker.class), blueairApp$$ExternalSyntheticLambda9));
        JVMTypeToken<?> typeToken17 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$9().getSuperType());
        Intrinsics.checkNotNull(typeToken17, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind9 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken17, NetworkMonitor.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda10 blueairApp$$ExternalSyntheticLambda10 = new BlueairApp$$ExternalSyntheticLambda10(blueairApp);
        Scope scope5 = withScope.getScope();
        TypeToken contextType6 = withScope.getContextType();
        boolean explicitContext5 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken18 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind9.with(new Singleton(scope5, contextType6, explicitContext5, new GenericJVMTypeTokenDelegate(typeToken18, NetworkMonitor.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda10));
        JVMTypeToken<?> typeToken19 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$10().getSuperType());
        Intrinsics.checkNotNull(typeToken19, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind10 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken19, HappyUserService.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda11 blueairApp$$ExternalSyntheticLambda11 = new BlueairApp$$ExternalSyntheticLambda11();
        Scope scope6 = withScope.getScope();
        TypeToken contextType7 = withScope.getContextType();
        boolean explicitContext6 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken20 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken20, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind10.with(new Singleton(scope6, contextType7, explicitContext6, new GenericJVMTypeTokenDelegate(typeToken20, HappyUserService.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda11));
        JVMTypeToken<?> typeToken21 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$bind$default$11().getSuperType());
        Intrinsics.checkNotNull(typeToken21, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind11 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken21, WelcomeHomeService.class), (Object) null, (Boolean) null);
        BlueairApp$$ExternalSyntheticLambda12 blueairApp$$ExternalSyntheticLambda12 = new BlueairApp$$ExternalSyntheticLambda12(blueairApp);
        Scope scope7 = withScope.getScope();
        TypeToken contextType8 = withScope.getContextType();
        boolean explicitContext7 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken22 = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$$inlined$singleton$default$7().getSuperType());
        Intrinsics.checkNotNull(typeToken22, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind11.with(new Singleton(scope7, contextType8, explicitContext7, new GenericJVMTypeTokenDelegate(typeToken22, WelcomeHomeService.class), (RefMaker) null, true, blueairApp$$ExternalSyntheticLambda12));
        AuthKodeinModule authKodeinModule = AuthKodeinModule.INSTANCE;
        Context applicationContext2 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, authKodeinModule.getModule(applicationContext2), false, 2, (Object) null);
        AddDeviceKodeinModule addDeviceKodeinModule = AddDeviceKodeinModule.INSTANCE;
        Context applicationContext3 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, addDeviceKodeinModule.getModule(applicationContext3), false, 2, (Object) null);
        DeviceManagerKodeinModule deviceManagerKodeinModule = DeviceManagerKodeinModule.INSTANCE;
        Context applicationContext4 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, deviceManagerKodeinModule.getModule(applicationContext4), false, 2, (Object) null);
        PushKodeinModule pushKodeinModule = PushKodeinModule.INSTANCE;
        Context applicationContext5 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, pushKodeinModule.getModule(applicationContext5), false, 2, (Object) null);
        BluetoothKodeinModule bluetoothKodeinModule = BluetoothKodeinModule.INSTANCE;
        Context applicationContext6 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, bluetoothKodeinModule.getModule(applicationContext6), false, 2, (Object) null);
        OutdoorKodeinModule outdoorKodeinModule = OutdoorKodeinModule.INSTANCE;
        Context applicationContext7 = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext7, "getApplicationContext(...)");
        DI.Builder.DefaultImpls.importOnce$default(builder, outdoorKodeinModule.getModule(applicationContext7), false, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final ResourcesLocationNamePlaceholderProvider di_delegate$lambda$8$lambda$0(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new ResourcesLocationNamePlaceholderProvider(applicationContext);
    }

    /* access modifiers changed from: private */
    public static final AnalyticsService di_delegate$lambda$8$lambda$1(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        return new AnalyticsService(blueairApp);
    }

    /* access modifiers changed from: private */
    public static final UnsecurePrefs di_delegate$lambda$8$lambda$2(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new UnsecurePrefs(applicationContext);
    }

    /* access modifiers changed from: private */
    public static final SecurePrefs di_delegate$lambda$8$lambda$3(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new SecurePrefs(applicationContext);
    }

    /* access modifiers changed from: private */
    public static final LocationPermissionTracker di_delegate$lambda$8$lambda$4(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$provider");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$lambda$4$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new LocationPermissionTracker((UnsecurePrefs) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final NetworkMonitor di_delegate$lambda$8$lambda$5(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new NetworkMonitor(applicationContext);
    }

    /* access modifiers changed from: private */
    public static final HappyUserService di_delegate$lambda$8$lambda$6(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$lambda$6$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new HappyUserService((UnsecurePrefs) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final WelcomeHomeService di_delegate$lambda$8$lambda$7(BlueairApp blueairApp, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        Context applicationContext = blueairApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$di_delegate$lambda$8$lambda$7$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new WelcomeHomeService(applicationContext, (UnsecurePrefs) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null));
    }

    public void onCreate() {
        String str;
        super.onCreate();
        if (!this.isInChinaLauncherProcess) {
            BuildEnvironment.INSTANCE.setVersionName("4.4.0");
            BuildEnvironment.INSTANCE.setVersionCode(BuildConfig.VERSION_CODE);
            BuildEnvironment.INSTANCE.setApplicationId(BuildConfig.APPLICATION_ID);
            Application application = this;
            CustomViewModelStoreOwner.Companion.setApplication(application);
            LokaliseSdk.INSTANCE.init(application);
            Context context = this;
            SkuConfigurationManager.INSTANCE.loadFromFile(context);
            UserInfoCollectionsManager.INSTANCE.initialize(context);
            RxJavaPlugins.setErrorHandler(new BlueairApp$$ExternalSyntheticLambda1(new BlueairApp$$ExternalSyntheticLambda13()));
            DIAware dIAware = this;
            JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$1().getSuperType());
            Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null);
            KProperty<Object>[] kPropertyArr = $$delegatedProperties;
            Lazy<Object> provideDelegate = Instance.provideDelegate((Object) null, kPropertyArr[1]);
            JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$2().getSuperType());
            Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate2 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[2]);
            JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$3().getSuperType());
            Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate3 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, UnsecurePrefs.class), (Object) null).provideDelegate((Object) null, kPropertyArr[3]);
            JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$4().getSuperType());
            Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate4 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, HappyUserService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[4]);
            JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$5().getSuperType());
            Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate5 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, LocationService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[5]);
            JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$6().getSuperType());
            Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate6 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken6, DeviceManager.class), (Object) null).provideDelegate((Object) null, kPropertyArr[6]);
            JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$7().getSuperType());
            Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate7 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken7, WelcomeHomeService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[7]);
            JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$8().getSuperType());
            Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> lazy = provideDelegate4;
            Lazy<Object> provideDelegate8 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken8, LogOutService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[8]);
            JVMTypeToken<?> typeToken9 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$9().getSuperType());
            Intrinsics.checkNotNull(typeToken9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> lazy2 = provideDelegate;
            Lazy<Object> provideDelegate9 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken9, GigyaService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[9]);
            JVMTypeToken<?> typeToken10 = TypeTokensJVMKt.typeToken(new BlueairApp$onCreate$$inlined$instance$default$10().getSuperType());
            Intrinsics.checkNotNull(typeToken10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Lazy<Object> provideDelegate10 = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken10, NotificationService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[10]);
            DeviceConfigProvider.INSTANCE.init(onCreate$lambda$15(provideDelegate5));
            Lazy<Object> lazy3 = provideDelegate10;
            if (((Boolean) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_UAT_MODE, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
                AblEnvironment.INSTANCE.setBaseUrl(AblEnvironment.UAT);
            }
            KlaviyoSdk.INSTANCE.initialize(((Boolean) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_DEV_KLAVIYO, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue() ? "UGGizX" : "WaDDdd", application);
            Lazy<Object> lazy4 = provideDelegate5;
            LokaliseSdk.INSTANCE.updateTranslations((Boolean) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_LOKALISE_PRE_RELEASE, Boolean.valueOf(!BuildEnvironment.INSTANCE.isRelease()), Reflection.getOrCreateKotlinClass(Boolean.class)));
            BugfenderSdk.INSTANCE.init(application);
            DialogUtils.INSTANCE.init(context);
            Gigya.setApplication(application);
            onCreate$lambda$15(lazy4).fetchRegion();
            onCreate$lambda$12(provideDelegate2).updateHomeHost();
            boolean isInChina = onCreate$lambda$15(lazy4).isInChina();
            onCreate$lambda$11(lazy2).initAmplitude(((Boolean) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_AMPLITUDE_DEBUG, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue(), isInChina);
            LocationService onCreate$lambda$15 = onCreate$lambda$15(lazy4);
            if (!isInChina) {
                str = "https://play.google.com/store/apps/details?id=com.blueair.android";
            } else if (PhoneUtil.INSTANCE.isHuaweiServicesAvailable(context)) {
                str = "https://appgallery.huawei.com/#/app/C102387123";
            } else {
                str = "https://sj.qq.com/myapp/detail.htm?apkName=com.blueair.android&info=158CA4C865D3B9A3F0FD335059CBD22C";
            }
            onCreate$lambda$15.setMarketLink(str);
            int i = WhenMappings.$EnumSwitchMapping$0[BuildEnvironment.INSTANCE.getVariant().ordinal()];
            if (i == 1) {
                Timber.Forest.plant((Timber.Tree) new Timber.DebugTree());
            } else if (i == 2) {
                Timber.Forest.plant((Timber.Tree) new Timber.DebugTree());
                Timber.Forest.plant((Timber.Tree) new AnalyticsService.CrashlyticsTree());
                Timber.Forest.plant((Timber.Tree) new BugfenderTree());
            } else if (i == 3) {
                Timber.Forest.plant((Timber.Tree) new AnalyticsService.CrashlyticsTree());
                Timber.Forest.plant((Timber.Tree) new BugfenderTree());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Thread.setDefaultUncaughtExceptionHandler(new BlueairApp$$ExternalSyntheticLambda2());
            Timber.Forest.plant((Timber.Tree) new InMemoryTree());
            RxHelper.INSTANCE.setDefaultErrorHandling(new BlueairApp$$ExternalSyntheticLambda3());
            onCreate$lambda$20(lazy3).initialize();
            onCreate$lambda$14(lazy).setCountryAvailable(onCreate$lambda$15(lazy4).isInRateUsRegion());
            onCreate$lambda$14(lazy).reset(onCreate$lambda$15(lazy4).getRateUsResetTimestamp());
            onCreate$lambda$14(lazy).initResetTimeStamp();
            onCreate$lambda$17(provideDelegate7).setCountryAvailable(onCreate$lambda$15(lazy4).isInWelcomeHomeRegion());
            if (!onCreate$lambda$14(lazy).isRateUsShown() && onCreate$lambda$14(lazy).getG4NewBlueOnboardStamp() != -1) {
                HappyUserService onCreate$lambda$14 = onCreate$lambda$14(lazy);
                onCreate$lambda$14.setAppLaunchCount(onCreate$lambda$14.getAppLaunchCount() + 1);
            }
            onCreate$lambda$13(provideDelegate3).remove(PrefKeys.KEY_LOGIN_PENDING_ACTION);
            Object obj = PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE, null, Reflection.getOrCreateKotlinClass(String.class));
            if (((String) obj).length() <= 0) {
                obj = null;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BlueairApp$onCreate$5$1(str2, provideDelegate6, provideDelegate3, (Continuation<? super BlueairApp$onCreate$5$1>) null), 3, (Object) null);
            }
            if (!((Boolean) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.TempUnitWasSet, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue()) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BlueairApp$onCreate$6(provideDelegate3, provideDelegate6, (Continuation<? super BlueairApp$onCreate$6>) null), 3, (Object) null);
            }
            int intValue = ((Number) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_PREVIOUS_VERSION_CODE, 0, Reflection.getOrCreateKotlinClass(Integer.class))).intValue();
            if (intValue > 0 && 2272 > intValue) {
                onAppUpgrade(intValue, (String) PreferencesHelper.INSTANCE.get(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_PREVIOUS_VERSION_NAME, "unknown", Reflection.getOrCreateKotlinClass(String.class)));
            }
            PreferencesHelper.INSTANCE.set(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_PREVIOUS_VERSION_CODE, Integer.valueOf(BuildConfig.VERSION_CODE), Reflection.getOrCreateKotlinClass(Integer.class));
            PreferencesHelper.INSTANCE.set(onCreate$lambda$13(provideDelegate3).getBackend(), PrefKeys.KEY_PREVIOUS_VERSION_NAME, "4.4.0", Reflection.getOrCreateKotlinClass(String.class));
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BlueairApp$onCreate$7(provideDelegate2, provideDelegate9, provideDelegate8, (Continuation<? super BlueairApp$onCreate$7>) null), 3, (Object) null);
        } else if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(".china_launcher");
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$10(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$9(Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.e(th, "RxJavaError: " + th.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    private static final AnalyticsService onCreate$lambda$11(Lazy<AnalyticsService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final AuthService onCreate$lambda$12(Lazy<AuthService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final UnsecurePrefs onCreate$lambda$13(Lazy<UnsecurePrefs> lazy) {
        return lazy.getValue();
    }

    private static final HappyUserService onCreate$lambda$14(Lazy<HappyUserService> lazy) {
        return lazy.getValue();
    }

    private static final LocationService onCreate$lambda$15(Lazy<LocationService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceManager onCreate$lambda$16(Lazy<DeviceManager> lazy) {
        return lazy.getValue();
    }

    private static final WelcomeHomeService onCreate$lambda$17(Lazy<WelcomeHomeService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final LogOutService onCreate$lambda$18(Lazy<LogOutService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final GigyaService onCreate$lambda$19(Lazy<GigyaService> lazy) {
        return lazy.getValue();
    }

    private static final NotificationService onCreate$lambda$20(Lazy<NotificationService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$21(Thread thread, Throwable th) {
        Timber.Forest.e(th, "Uncaught exception", new Object[0]);
        System.exit(-1);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$22(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Timber.Forest.e(th);
        return Unit.INSTANCE;
    }

    private final void onAppUpgrade(int i, String str) {
        Timber.Forest forest = Timber.Forest;
        forest.d("onAppUpgrade: from " + str + '(' + i + ") to 4.4.0(2272)", new Object[0]);
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$onAppUpgrade$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        Lazy<Object> provideDelegate = Instance.provideDelegate((Object) null, kPropertyArr[11]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BlueairApp$onAppUpgrade$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        onAppUpgrade$lambda$25(provideDelegate).event(new AnalyticEvent.AppUpgradeEvent(onAppUpgrade$lambda$26(DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, GigyaService.class), (Object) null).provideDelegate((Object) null, kPropertyArr[12])).getGigyaUid(), i, str, BuildConfig.VERSION_CODE, "4.4.0"));
    }

    private static final AnalyticsService onAppUpgrade$lambda$25(Lazy<AnalyticsService> lazy) {
        return lazy.getValue();
    }

    private static final GigyaService onAppUpgrade$lambda$26(Lazy<GigyaService> lazy) {
        return lazy.getValue();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (!this.isInChinaLauncherProcess) {
            JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$onConfigurationChanged$$inlined$instance$default$1().getSuperType());
            Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BlueairApp$onConfigurationChanged$1(DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[13]), (Continuation<? super BlueairApp$onConfigurationChanged$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final AuthService onConfigurationChanged$lambda$27(Lazy<AuthService> lazy) {
        return lazy.getValue();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u0002"}, d2 = {"Lcom/blueair/android/BlueairApp$InMemoryTree;", "Ltimber/log/Timber$DebugTree;", "<init>", "(Lcom/blueair/android/BlueairApp;)V", "logCount", "", "tempContent", "", "isResizing", "", "logWriter", "Ljava/io/BufferedWriter;", "log", "", "priority", "tag", "message", "t", "", "checkFileSizeLimit", "sizeInMb", "app_otherRelease", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueairApp.kt */
    public final class InMemoryTree extends Timber.DebugTree {
        private volatile boolean isResizing;
        private int logCount;
        private final BufferedWriter logWriter;
        private String tempContent = "";

        public InMemoryTree() {
            FileOutputStream openFileOutput = BlueairApp.this.openFileOutput(FileNames.DEBUG_LOG, 32768);
            Intrinsics.checkNotNullExpressionValue(openFileOutput, "openFileOutput(...)");
            Writer outputStreamWriter = new OutputStreamWriter(openFileOutput, Charsets.UTF_8);
            this.logWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            String str3;
            Intrinsics.checkNotNullParameter(str2, "message");
            switch (i) {
                case 2:
                    return;
                case 3:
                    str3 = "D";
                    break;
                case 4:
                    str3 = "I";
                    break;
                case 5:
                    str3 = ExifInterface.LONGITUDE_WEST;
                    break;
                case 6:
                    str3 = ExifInterface.LONGITUDE_EAST;
                    break;
                case 7:
                    str3 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                    break;
                default:
                    str3 = "U";
                    break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(LocalDateTime.now());
            sb.append(" | ");
            sb.append(str3);
            sb.append(" | ");
            sb.append(StringsKt.padEnd$default(str == null ? "" : str, 35, 0, 2, (Object) null));
            sb.append(" | ");
            sb.append(str2);
            sb.append(" | ");
            sb.append(th != null ? th : "");
            sb.append(10);
            String sb2 = sb.toString();
            if (this.isResizing) {
                this.tempContent += sb2;
            } else {
                this.logWriter.append(sb2).flush();
            }
            int i2 = this.logCount + 1;
            this.logCount = i2;
            if (i2 > 10000) {
                this.logCount = 0;
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new BlueairApp$InMemoryTree$log$1(BlueairApp.this, this, (Continuation<? super BlueairApp$InMemoryTree$log$1>) null), 2, (Object) null);
            }
        }

        public final synchronized void checkFileSizeLimit(int i) {
            String str;
            Log.d("BlueairApp", "checkLogFileSizeLimit");
            this.isResizing = true;
            try {
                File fileStreamPath = BlueairApp.this.getFileStreamPath(FileNames.DEBUG_LOG);
                long length = fileStreamPath.length();
                long j = ((long) i) * 1048576;
                if (length > j) {
                    Log.d("BlueairApp", "doLogFileResize");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileStreamPath, "rw");
                    randomAccessFile.seek(length - j);
                    randomAccessFile.readLine();
                    long filePointer = randomAccessFile.getFilePointer();
                    byte[] bArr = new byte[1024];
                    long j2 = 0;
                    for (int read = randomAccessFile.read(bArr); read >= 0; read = randomAccessFile.read(bArr)) {
                        randomAccessFile.seek(j2);
                        randomAccessFile.write(bArr, 0, read);
                        long j3 = (long) read;
                        filePointer += j3;
                        j2 += j3;
                        randomAccessFile.seek(filePointer);
                    }
                    randomAccessFile.setLength(j2);
                    randomAccessFile.close();
                }
            } finally {
                this.isResizing = false;
                if (this.tempContent.length() > 0) {
                    this.logWriter.append(this.tempContent).flush();
                }
                str = "";
                this.tempContent = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/blueair/android/BlueairApp$BugfenderTree;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "log", "", "priority", "", "tag", "", "message", "t", "", "findCaller", "Ljava/lang/StackTraceElement;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueairApp.kt */
    public static final class BugfenderTree extends Timber.Tree {
        public static final int $stable = 8;

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, "message");
            StackTraceElement findCaller = findCaller(new Exception());
            if (findCaller != null) {
                String className = findCaller.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                if (StringsKt.endsWith$default(className, "StompService", false, 2, (Object) null)) {
                    BugfenderSdk bugfenderSdk = BugfenderSdk.INSTANCE;
                    int lineNumber = findCaller.getLineNumber();
                    String fileName = findCaller.getFileName();
                    Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                    bugfenderSdk.log(lineNumber, findCaller.getClassName() + '.' + findCaller.getMethodName(), fileName, i, str, str2);
                }
            }
        }

        private final StackTraceElement findCaller(Throwable th) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            for (int i = 2; i < length; i++) {
                String className = stackTrace[i].getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                if (!StringsKt.startsWith$default(className, "timber.log.", false, 2, (Object) null)) {
                    return stackTrace[i];
                }
            }
            return null;
        }
    }
}
