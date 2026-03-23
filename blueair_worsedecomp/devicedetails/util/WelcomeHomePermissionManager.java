package com.blueair.devicedetails.util;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.AppSettingsIntent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0003J\b\u0010\u0014\u001a\u00020\u0012H\u0003J\b\u0010\u0015\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0003J\b\u0010\u0019\u001a\u00020\u0007H\u0003J\b\u0010\u001a\u001a\u00020\u0007H\u0002J$\u0010\u001b\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dJ&\u0010\u001f\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0002J&\u0010 \u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0003J&\u0010!\u001a\u00020\u00122\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0003J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0003J\b\u0010&\u001a\u00020\u0012H\u0003J\b\u0010'\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \f*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e0\u000e0\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "isAndroidQ", "", "isAndroidR", "locationPermissionResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "locationPermissionResultLauncherApi29", "", "locationPermissionResultLauncherApi30", "backgroundLocationPermissionResultLauncher", "requestLocationPermission", "", "requestLocationPermissionApi29", "requestLocationPermissionApi30", "requestBackgroundLocationPermission", "isLocationPermissionGranted", "shouldShowLocationPermissionRationale", "isBackgroundLocationPermissionGranted", "shouldShowBackgroundLocationPermissionRationale", "isLocationEnabled", "checkAndRequest", "actionDenied", "Lkotlin/Function0;", "actionGranted", "checkAndRequestApiPre29", "checkAndRequestApi29", "checkAndRequestApi30", "onPermissionGrantedAndLocationEnabled", "onLocationPermissionRationale", "onLocationPermissionDenied", "onBackgroundLocationPermissionRationale", "onBackgroundLocationPermissionDenied", "onLocationDisabled", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomePermissionManager.kt */
public final class WelcomeHomePermissionManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG_BG_LOCATION_DENIED_DIALOG = "TAG_BG_LOCATION_DENIED_DIALOG";
    private static final String TAG_BG_LOCATION_RATIONALE_DIALOG = "TAG_BG_LOCATION_RATIONALE_DIALOG";
    private static final String TAG_LOCATION_DENIED_DIALOG = "TAG_LOCATION_DENIED_DIALOG";
    private static final String TAG_LOCATION_DISABLED_DIALOG = "TAG_LOCATION_DISABLED_DIALOG";
    private static final String TAG_LOCATION_RATIONALE_DIALOG = "TAG_LOCATION_RATIONALE_DIALOG";
    private final ActivityResultLauncher<String> backgroundLocationPermissionResultLauncher;
    private final Fragment fragment;
    private final boolean isAndroidQ;
    private final boolean isAndroidR;
    private final ActivityResultLauncher<String> locationPermissionResultLauncher;
    private final ActivityResultLauncher<String[]> locationPermissionResultLauncherApi29;
    private final ActivityResultLauncher<String> locationPermissionResultLauncherApi30;
    private Function0<Unit> onPermissionGrantedAndLocationEnabled;

    public WelcomeHomePermissionManager(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        this.fragment = fragment2;
        boolean z = true;
        this.isAndroidQ = Build.VERSION.SDK_INT == 29;
        this.isAndroidR = Build.VERSION.SDK_INT < 30 ? false : z;
        ActivityResultLauncher<String> registerForActivityResult = fragment2.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new WelcomeHomePermissionManager$$ExternalSyntheticLambda11(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.locationPermissionResultLauncher = registerForActivityResult;
        ActivityResultLauncher<String[]> registerForActivityResult2 = fragment2.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new WelcomeHomePermissionManager$$ExternalSyntheticLambda12(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.locationPermissionResultLauncherApi29 = registerForActivityResult2;
        ActivityResultLauncher<String> registerForActivityResult3 = fragment2.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new WelcomeHomePermissionManager$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.locationPermissionResultLauncherApi30 = registerForActivityResult3;
        ActivityResultLauncher<String> registerForActivityResult4 = fragment2.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new WelcomeHomePermissionManager$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult4, "registerForActivityResult(...)");
        this.backgroundLocationPermissionResultLauncher = registerForActivityResult4;
    }

    /* access modifiers changed from: private */
    public static final void locationPermissionResultLauncher$lambda$0(WelcomeHomePermissionManager welcomeHomePermissionManager, Boolean bool) {
        if (bool.booleanValue()) {
            if (!welcomeHomePermissionManager.isLocationEnabled()) {
                welcomeHomePermissionManager.onLocationDisabled();
                return;
            }
            Function0<Unit> function0 = welcomeHomePermissionManager.onPermissionGrantedAndLocationEnabled;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (!welcomeHomePermissionManager.shouldShowLocationPermissionRationale()) {
            welcomeHomePermissionManager.onLocationPermissionDenied();
        }
    }

    /* access modifiers changed from: private */
    public static final void locationPermissionResultLauncherApi29$lambda$1(WelcomeHomePermissionManager welcomeHomePermissionManager, Map map) {
        if (!map.containsValue(false)) {
            if (!welcomeHomePermissionManager.isLocationEnabled()) {
                welcomeHomePermissionManager.onLocationDisabled();
                return;
            }
            Function0<Unit> function0 = welcomeHomePermissionManager.onPermissionGrantedAndLocationEnabled;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (Intrinsics.areEqual(map.get("android.permission.ACCESS_FINE_LOCATION"), (Object) true) && Intrinsics.areEqual(map.get("android.permission.ACCESS_BACKGROUND_LOCATION"), (Object) false) && welcomeHomePermissionManager.shouldShowBackgroundLocationPermissionRationale()) {
            welcomeHomePermissionManager.onBackgroundLocationPermissionRationale();
        } else if (!welcomeHomePermissionManager.shouldShowLocationPermissionRationale() && !welcomeHomePermissionManager.shouldShowBackgroundLocationPermissionRationale()) {
            welcomeHomePermissionManager.onLocationPermissionDenied();
        }
    }

    /* access modifiers changed from: private */
    public static final void locationPermissionResultLauncherApi30$lambda$2(WelcomeHomePermissionManager welcomeHomePermissionManager, Boolean bool) {
        if (bool.booleanValue()) {
            if (!welcomeHomePermissionManager.isBackgroundLocationPermissionGranted() && welcomeHomePermissionManager.shouldShowBackgroundLocationPermissionRationale()) {
                welcomeHomePermissionManager.onBackgroundLocationPermissionRationale();
            } else if (!welcomeHomePermissionManager.isLocationEnabled()) {
                welcomeHomePermissionManager.onLocationDisabled();
            } else {
                Function0<Unit> function0 = welcomeHomePermissionManager.onPermissionGrantedAndLocationEnabled;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        } else if (!welcomeHomePermissionManager.shouldShowLocationPermissionRationale()) {
            welcomeHomePermissionManager.onLocationPermissionDenied();
        }
    }

    /* access modifiers changed from: private */
    public static final void backgroundLocationPermissionResultLauncher$lambda$3(WelcomeHomePermissionManager welcomeHomePermissionManager, Boolean bool) {
        if (bool.booleanValue()) {
            if (!welcomeHomePermissionManager.isLocationEnabled()) {
                welcomeHomePermissionManager.onLocationDisabled();
                return;
            }
            Function0<Unit> function0 = welcomeHomePermissionManager.onPermissionGrantedAndLocationEnabled;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (!welcomeHomePermissionManager.shouldShowBackgroundLocationPermissionRationale()) {
            welcomeHomePermissionManager.onBackgroundLocationPermissionDenied();
        }
    }

    private final void requestLocationPermission() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
        this.locationPermissionResultLauncher.launch("android.permission.ACCESS_FINE_LOCATION");
    }

    private final void requestLocationPermissionApi29() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
        this.locationPermissionResultLauncherApi29.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
    }

    private final void requestLocationPermissionApi30() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
        this.locationPermissionResultLauncherApi30.launch("android.permission.ACCESS_FINE_LOCATION");
    }

    public final void requestBackgroundLocationPermission() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_welcome_home, R.string.permission_request_message_location_welcome_home);
        this.backgroundLocationPermissionResultLauncher.launch("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    private final boolean isLocationPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.fragment.requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final boolean shouldShowLocationPermissionRationale() {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.fragment.requireActivity(), "android.permission.ACCESS_FINE_LOCATION");
    }

    private final boolean isBackgroundLocationPermissionGranted() {
        if (!this.isAndroidQ || ContextCompat.checkSelfPermission(this.fragment.requireContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private final boolean shouldShowBackgroundLocationPermissionRationale() {
        if (this.isAndroidQ) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.fragment.requireActivity(), "android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return false;
    }

    private final boolean isLocationEnabled() {
        try {
            Object systemService = this.fragment.requireContext().getSystemService("location");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            LocationManager locationManager = (LocationManager) systemService;
            if (Build.VERSION.SDK_INT >= 28) {
                return locationManager.isLocationEnabled();
            }
            return locationManager.isProviderEnabled("gps");
        } catch (Throwable th) {
            Timber.Forest.w(th, "isLocationEnabled failed", new Object[0]);
            return false;
        }
    }

    public static /* synthetic */ void checkAndRequest$default(WelcomeHomePermissionManager welcomeHomePermissionManager, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            new WelcomeHomePermissionManager$$ExternalSyntheticLambda10
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v2 ? I:com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda10) =  call: com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda10.<init>():void type: CONSTRUCTOR in method: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequest$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void, dex: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                r3 = r3 & 1
                if (r3 == 0) goto L_0x0009
                com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda10 r1 = new com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda10
                r1.<init>()
            L_0x0009:
                r0.checkAndRequest(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequest$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
        }

        /* access modifiers changed from: private */
        public static final Unit checkAndRequest$lambda$4() {
            return Unit.INSTANCE;
        }

        public final void checkAndRequest(Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(function0, "actionDenied");
            Intrinsics.checkNotNullParameter(function02, "actionGranted");
            if (this.isAndroidR) {
                checkAndRequestApi30(function0, function02);
            } else if (this.isAndroidQ) {
                checkAndRequestApi29(function0, function02);
            } else {
                checkAndRequestApiPre29(function0, function02);
            }
        }

        static /* synthetic */ void checkAndRequestApiPre29$default(WelcomeHomePermissionManager welcomeHomePermissionManager, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 1) != 0) {
                new WelcomeHomePermissionManager$$ExternalSyntheticLambda7
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v2 ? I:com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda7) =  call: com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda7.<init>():void type: CONSTRUCTOR in method: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApiPre29$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 34 more
                    */
                /*
                    r3 = r3 & 1
                    if (r3 == 0) goto L_0x0009
                    com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda7 r1 = new com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda7
                    r1.<init>()
                L_0x0009:
                    r0.checkAndRequestApiPre29(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApiPre29$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
            }

            /* access modifiers changed from: private */
            public static final Unit checkAndRequestApiPre29$lambda$5() {
                return Unit.INSTANCE;
            }

            private final void checkAndRequestApiPre29(Function0<Unit> function0, Function0<Unit> function02) {
                this.onPermissionGrantedAndLocationEnabled = function02;
                if (shouldShowLocationPermissionRationale()) {
                    onLocationPermissionRationale();
                    function0.invoke();
                } else if (!isLocationPermissionGranted()) {
                    requestLocationPermission();
                    function0.invoke();
                } else if (!isLocationEnabled()) {
                    onLocationDisabled();
                    function0.invoke();
                } else {
                    Function0<Unit> function03 = this.onPermissionGrantedAndLocationEnabled;
                    if (function03 != null) {
                        function03.invoke();
                    }
                }
            }

            static /* synthetic */ void checkAndRequestApi29$default(WelcomeHomePermissionManager welcomeHomePermissionManager, Function0 function0, Function0 function02, int i, Object obj) {
                if ((i & 1) != 0) {
                    new WelcomeHomePermissionManager$$ExternalSyntheticLambda8
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v2 ? I:com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda8) =  call: com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda8.<init>():void type: CONSTRUCTOR in method: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApi29$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void, dex: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 34 more
                        */
                    /*
                        r3 = r3 & 1
                        if (r3 == 0) goto L_0x0009
                        com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda8 r1 = new com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda8
                        r1.<init>()
                    L_0x0009:
                        r0.checkAndRequestApi29(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApi29$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
                }

                /* access modifiers changed from: private */
                public static final Unit checkAndRequestApi29$lambda$6() {
                    return Unit.INSTANCE;
                }

                private final void checkAndRequestApi29(Function0<Unit> function0, Function0<Unit> function02) {
                    this.onPermissionGrantedAndLocationEnabled = function02;
                    if (shouldShowLocationPermissionRationale()) {
                        onLocationPermissionRationale();
                        function0.invoke();
                    } else if (!isLocationPermissionGranted()) {
                        requestLocationPermissionApi29();
                        function0.invoke();
                    } else if (shouldShowBackgroundLocationPermissionRationale()) {
                        onBackgroundLocationPermissionRationale();
                        function0.invoke();
                    } else if (!isBackgroundLocationPermissionGranted()) {
                        requestBackgroundLocationPermission();
                        function0.invoke();
                    } else if (!isLocationEnabled()) {
                        onLocationDisabled();
                        function0.invoke();
                    } else {
                        Function0<Unit> function03 = this.onPermissionGrantedAndLocationEnabled;
                        if (function03 != null) {
                            function03.invoke();
                        }
                    }
                }

                static /* synthetic */ void checkAndRequestApi30$default(WelcomeHomePermissionManager welcomeHomePermissionManager, Function0 function0, Function0 function02, int i, Object obj) {
                    if ((i & 1) != 0) {
                        new WelcomeHomePermissionManager$$ExternalSyntheticLambda5
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v2 ? I:com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda5) =  call: com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda5.<init>():void type: CONSTRUCTOR in method: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApi30$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void, dex: classes4.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 34 more
                            */
                        /*
                            r3 = r3 & 1
                            if (r3 == 0) goto L_0x0009
                            com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda5 r1 = new com.blueair.devicedetails.util.WelcomeHomePermissionManager$$ExternalSyntheticLambda5
                            r1.<init>()
                        L_0x0009:
                            r0.checkAndRequestApi30(r1, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.WelcomeHomePermissionManager.checkAndRequestApi30$default(com.blueair.devicedetails.util.WelcomeHomePermissionManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, java.lang.Object):void");
                    }

                    /* access modifiers changed from: private */
                    public static final Unit checkAndRequestApi30$lambda$7() {
                        return Unit.INSTANCE;
                    }

                    private final void checkAndRequestApi30(Function0<Unit> function0, Function0<Unit> function02) {
                        this.onPermissionGrantedAndLocationEnabled = function02;
                        if (shouldShowLocationPermissionRationale()) {
                            onLocationPermissionRationale();
                            function0.invoke();
                        } else if (!isLocationPermissionGranted()) {
                            requestLocationPermissionApi30();
                            function0.invoke();
                        } else if (shouldShowBackgroundLocationPermissionRationale()) {
                            onBackgroundLocationPermissionRationale();
                            function0.invoke();
                        } else if (!isBackgroundLocationPermissionGranted()) {
                            requestBackgroundLocationPermission();
                            function0.invoke();
                        } else if (!isLocationEnabled()) {
                            onLocationDisabled();
                            function0.invoke();
                        } else {
                            Function0<Unit> function03 = this.onPermissionGrantedAndLocationEnabled;
                            if (function03 != null) {
                                function03.invoke();
                            }
                        }
                    }

                    private final void onLocationPermissionRationale() {
                        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.wh_location_permission_dialog_title), Integer.valueOf(R.string.wh_location_permission_dialog_description), R.string.snackbar_ok, Integer.valueOf(R.string.btn_cancel), false, false, false, (String[]) null, 240, (Object) null).show(this.fragment.getChildFragmentManager(), TAG_LOCATION_RATIONALE_DIALOG);
                        this.fragment.getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda4(this));
                    }

                    /* access modifiers changed from: private */
                    public static final void onLocationPermissionRationale$lambda$8(WelcomeHomePermissionManager welcomeHomePermissionManager, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "result");
                        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
                            welcomeHomePermissionManager.requestLocationPermission();
                        }
                    }

                    private final void onLocationPermissionDenied() {
                        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.permission_denied), Integer.valueOf(R.string.wh_permission_denied_description), R.string.btn_goto_settings, Integer.valueOf(R.string.btn_cancel), false, false, false, (String[]) null, 240, (Object) null).show(this.fragment.getChildFragmentManager(), TAG_LOCATION_DENIED_DIALOG);
                        this.fragment.getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda9(this));
                    }

                    /* access modifiers changed from: private */
                    public static final void onLocationPermissionDenied$lambda$9(WelcomeHomePermissionManager welcomeHomePermissionManager, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "result");
                        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
                            AppSettingsIntent appSettingsIntent = AppSettingsIntent.INSTANCE;
                            Context requireContext = welcomeHomePermissionManager.fragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            appSettingsIntent.start(requireContext);
                        }
                    }

                    private final void onBackgroundLocationPermissionRationale() {
                        int i;
                        if (this.isAndroidR) {
                            i = R.string.btn_goto_settings;
                        } else {
                            i = R.string.snackbar_ok;
                        }
                        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.wh_bg_location_permission_dialog_title), Integer.valueOf(R.string.wh_bg_location_permission_rationale), i, Integer.valueOf(R.string.btn_cancel), this.isAndroidR, false, false, (String[]) null, 224, (Object) null).show(this.fragment.getChildFragmentManager(), TAG_BG_LOCATION_RATIONALE_DIALOG);
                        this.fragment.getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda3(this));
                    }

                    /* access modifiers changed from: private */
                    public static final void onBackgroundLocationPermissionRationale$lambda$10(WelcomeHomePermissionManager welcomeHomePermissionManager, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "result");
                        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
                            welcomeHomePermissionManager.requestBackgroundLocationPermission();
                        }
                    }

                    private final void onBackgroundLocationPermissionDenied() {
                        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.permission_denied), Integer.valueOf(R.string.wh_bg_permission_denied_description), R.string.btn_goto_settings, Integer.valueOf(R.string.btn_cancel), false, false, false, (String[]) null, 240, (Object) null).show(this.fragment.getChildFragmentManager(), TAG_BG_LOCATION_DENIED_DIALOG);
                        this.fragment.getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda2(this));
                    }

                    /* access modifiers changed from: private */
                    public static final void onBackgroundLocationPermissionDenied$lambda$11(WelcomeHomePermissionManager welcomeHomePermissionManager, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "result");
                        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
                            AppSettingsIntent appSettingsIntent = AppSettingsIntent.INSTANCE;
                            Context requireContext = welcomeHomePermissionManager.fragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            appSettingsIntent.start(requireContext);
                        }
                    }

                    private final void onLocationDisabled() {
                        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.wh_location_permission_dialog_title), Integer.valueOf(R.string.welcome_home_enable_location), R.string.enable_locations, Integer.valueOf(R.string.btn_cancel), false, false, false, (String[]) null, 224, (Object) null).show(this.fragment.getChildFragmentManager(), TAG_LOCATION_DISABLED_DIALOG);
                        this.fragment.getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this.fragment, new WelcomeHomePermissionManager$$ExternalSyntheticLambda6(this));
                    }

                    /* access modifiers changed from: private */
                    public static final void onLocationDisabled$lambda$12(WelcomeHomePermissionManager welcomeHomePermissionManager, String str, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(str, "<unused var>");
                        Intrinsics.checkNotNullParameter(bundle, "result");
                        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
                            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                            intent.setFlags(268435456);
                            welcomeHomePermissionManager.fragment.startActivity(intent);
                        }
                    }

                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager$Companion;", "", "<init>", "()V", "TAG_LOCATION_DISABLED_DIALOG", "", "TAG_BG_LOCATION_DENIED_DIALOG", "TAG_BG_LOCATION_RATIONALE_DIALOG", "TAG_LOCATION_DENIED_DIALOG", "TAG_LOCATION_RATIONALE_DIALOG", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* compiled from: WelcomeHomePermissionManager.kt */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }
                    }
                }
