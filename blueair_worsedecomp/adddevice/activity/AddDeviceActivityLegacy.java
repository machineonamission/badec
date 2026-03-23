package com.blueair.adddevice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionSet;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.ActivityAddDeviceLegacyBinding;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigProgressFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigurationFailedStepOne;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigurationFailedStepTwo;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoStepOneFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoStepTwoFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceConfigureNetworkFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualConfigProgressFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualConfigurationFailed;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualStepOneFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualStepTwoFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceMigrationOtaFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceResetDeviceFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSelectModelFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSetNameFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSetupTextFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSuccessFragment;
import com.blueair.adddevice.fragment.legacy.ClassicTroubleShootingFragment;
import com.blueair.adddevice.fragment.legacy.IcpAddDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpPairDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpSaveDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpSetupDeviceFragment;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0015J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0014J\b\u0010@\u001a\u000209H\u0014J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020;H\u0014J\b\u0010C\u001a\u000209H\u0017J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000209H\u0002J\u0006\u0010I\u001a\u000209J\u0006\u0010J\u001a\u000209J\u000e\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020\u0019J\u000e\u0010M\u001a\u0002092\u0006\u0010N\u001a\u00020\u0019J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020SH\u0002J\u0018\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020PH\u0002J\u0012\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u00020EH\u0002J\b\u0010Z\u001a\u000209H\u0002J\b\u0010[\u001a\u00020EH\u0002J+\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050`2\u0006\u0010a\u001a\u00020bH\u0016¢\u0006\u0002\u0010cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/blueair/adddevice/activity/AddDeviceActivityLegacy;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "addDeviceService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddDeviceService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addDeviceService$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "currentScreen", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "asyncSubs", "Lio/reactivex/disposables/CompositeDisposable;", "binding", "Lcom/blueair/adddevice/databinding/ActivityAddDeviceLegacyBinding;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar$delegate", "addDeviceAppbar", "Lcom/google/android/material/appbar/AppBarLayout;", "getAddDeviceAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "addDeviceAppbar$delegate", "layoutExpandedToolbar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutExpandedToolbar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "layoutExpandedToolbar$delegate", "collapsingToolbar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbar", "()Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "collapsingToolbar$delegate", "btnClose", "Landroidx/appcompat/widget/AppCompatImageButton;", "getBtnClose", "()Landroidx/appcompat/widget/AppCompatImageButton;", "btnClose$delegate", "oldScreen", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "enableBackgroundAnimation", "disableBackgroundAnimation", "setBackgroundImage", "onResumeFragments", "onPause", "onSaveInstanceState", "outState", "onBackPressed", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCloseClick", "updateBackAllowedUi", "handleBack", "goBackToScreen", "targetScreen", "goForwardToScreen", "nextScreen", "animationTransaction", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "nextFragment", "Landroidx/fragment/app/Fragment;", "recursivelyAddSharedTransitions", "parent", "Landroid/view/ViewGroup;", "fragmentTransaction", "expandToolbar", "shouldExpandToolbar", "finishAddDevice", "canWriteMarshmallowSettings", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceActivityLegacy.kt */
public final class AddDeviceActivityLegacy extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_DEVICE_COMPATIBILITY = "PARAM_DEVICE_COMPATIBILITY";
    public static final String PARAM_SELECTED_DEVICE = "SELECTED_DEVICE";
    private static final int REQUEST_LOCATION_PERMISSION = 104;
    private static final int REQUEST_NETWORK_AND_BASIC_LOCATION_PERMISSIONS = 105;
    private static final int REQUEST_NETWORK_PERMISSIONS = 101;
    private static final String STATE_KEY = "state_key";
    private static final int WRITE_PERMISSION_REQUEST = 103;
    private final Lazy addDeviceAppbar$delegate;
    private final Lazy addDeviceService$delegate;
    private final CompositeDisposable asyncSubs;
    private ActivityAddDeviceLegacyBinding binding;
    private final Lazy btnClose$delegate;
    private final Lazy collapsingToolbar$delegate;
    private AddDeviceUtils.AddDeviceScreen currentScreen;
    private final Lazy deviceManager$delegate;
    private final Lazy layoutExpandedToolbar$delegate;
    private AddDeviceUtils.AddDeviceScreen oldScreen;
    private final Lazy prefs$delegate;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_LEGACY;
    private final Lazy toolbar$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceActivityLegacy.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|49) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen[] r0 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.SETUP_TEXT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.ICP_ADD_DEVICE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.ICP_SETUP_DEVICE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.ICP_PAIR_DEVICE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.ICP_SAVE_DEVICE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.ICP_NAME_DEVICE     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.AUTO_STEP_1     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.NAME_DEVICE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_1     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_2     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.RESET_DEVICE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MANUAL_FAIL     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MANUAL_VALIDATE     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.SUCCESS     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_2     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.adddevice.utils.AddDeviceUtils$AddDeviceScreen r1 = com.blueair.adddevice.utils.AddDeviceUtils.AddDeviceScreen.TROUBLESHOOT     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.activity.AddDeviceActivityLegacy.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<AddDeviceActivityLegacy> cls = AddDeviceActivityLegacy.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "addDeviceService", "getAddDeviceService()Lcom/blueair/adddevice/service/AddDeviceService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))};
    }

    public AddDeviceActivityLegacy() {
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceActivityLegacy$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AddDeviceService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.addDeviceService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceActivityLegacy$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AddDeviceActivityLegacy$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        this.currentScreen = AddDeviceUtils.AddDeviceScreen.NONE;
        this.asyncSubs = new CompositeDisposable();
        this.toolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda0(this));
        this.addDeviceAppbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda2(this));
        this.layoutExpandedToolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda3(this));
        this.collapsingToolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda4(this));
        this.btnClose$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda5(this));
        this.oldScreen = AddDeviceUtils.AddDeviceScreen.NONE;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/adddevice/activity/AddDeviceActivityLegacy$Companion;", "", "<init>", "()V", "STATE_KEY", "", "REQUEST_NETWORK_PERMISSIONS", "", "WRITE_PERMISSION_REQUEST", "REQUEST_LOCATION_PERMISSION", "REQUEST_NETWORK_AND_BASIC_LOCATION_PERMISSIONS", "PARAM_SELECTED_DEVICE", "PARAM_DEVICE_COMPATIBILITY", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceActivityLegacy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final AddDeviceService getAddDeviceService() {
        return (AddDeviceService) this.addDeviceService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    private final Toolbar getToolbar() {
        Object value = this.toolbar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Toolbar) value;
    }

    /* access modifiers changed from: private */
    public static final Toolbar toolbar_delegate$lambda$0(AddDeviceActivityLegacy addDeviceActivityLegacy) {
        Toolbar toolbar = (Toolbar) addDeviceActivityLegacy.findViewById(R.id.add_device_toolbar);
        toolbar.setTitleTextColor(-1);
        return toolbar;
    }

    private final AppBarLayout getAddDeviceAppbar() {
        Object value = this.addDeviceAppbar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AppBarLayout) value;
    }

    /* access modifiers changed from: private */
    public static final AppBarLayout addDeviceAppbar_delegate$lambda$1(AddDeviceActivityLegacy addDeviceActivityLegacy) {
        return (AppBarLayout) addDeviceActivityLegacy.findViewById(R.id.add_device_appbar);
    }

    private final ConstraintLayout getLayoutExpandedToolbar() {
        Object value = this.layoutExpandedToolbar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ConstraintLayout) value;
    }

    /* access modifiers changed from: private */
    public static final ConstraintLayout layoutExpandedToolbar_delegate$lambda$2(AddDeviceActivityLegacy addDeviceActivityLegacy) {
        return (ConstraintLayout) addDeviceActivityLegacy.findViewById(R.id.layout_expanded_toolbar);
    }

    private final CollapsingToolbarLayout getCollapsingToolbar() {
        Object value = this.collapsingToolbar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (CollapsingToolbarLayout) value;
    }

    /* access modifiers changed from: private */
    public static final CollapsingToolbarLayout collapsingToolbar_delegate$lambda$3(AddDeviceActivityLegacy addDeviceActivityLegacy) {
        return (CollapsingToolbarLayout) addDeviceActivityLegacy.findViewById(R.id.collapsing_toolbar);
    }

    private final AppCompatImageButton getBtnClose() {
        Object value = this.btnClose$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AppCompatImageButton) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageButton btnClose_delegate$lambda$4(AddDeviceActivityLegacy addDeviceActivityLegacy) {
        return (AppCompatImageButton) addDeviceActivityLegacy.findViewById(R.id.btnClose);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityAddDeviceLegacyBinding inflate = ActivityAddDeviceLegacyBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        setStatusBarColor(-1, true);
        disableBackgroundAnimation();
        setSupportActionBar(getToolbar());
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding2 = this.binding;
        if (activityAddDeviceLegacyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding2 = null;
        }
        ViewGroup.LayoutParams layoutParams = activityAddDeviceLegacyBinding2.addDeviceAppbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
        behavior.setDragCallback(new AddDeviceActivityLegacy$onCreate$1());
        ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(behavior);
        getAddDeviceService().initState(bundle != null ? (AddDeviceState) bundle.getParcelable(STATE_KEY) : null);
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding3 = this.binding;
        if (activityAddDeviceLegacyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding3 = null;
        }
        activityAddDeviceLegacyBinding3.btnClose.setOnClickListener(new AddDeviceActivityLegacy$$ExternalSyntheticLambda10(this));
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding4 = this.binding;
        if (activityAddDeviceLegacyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAddDeviceLegacyBinding = activityAddDeviceLegacyBinding4;
        }
        activityAddDeviceLegacyBinding.btnBack.setOnClickListener(new AddDeviceActivityLegacy$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$5(AddDeviceActivityLegacy addDeviceActivityLegacy, View view) {
        addDeviceActivityLegacy.onCloseClick();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$6(AddDeviceActivityLegacy addDeviceActivityLegacy, View view) {
        addDeviceActivityLegacy.onCloseClick();
    }

    private final void enableBackgroundAnimation() {
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = this.binding;
        if (activityAddDeviceLegacyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding = null;
        }
        Drawable background = activityAddDeviceLegacyBinding.layoutAddDeviceCoordinator.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable = (AnimationDrawable) background;
        if (!animationDrawable.isRunning()) {
            animationDrawable.setEnterFadeDuration(3000);
            animationDrawable.setExitFadeDuration(3000);
        }
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }

    private final void disableBackgroundAnimation() {
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = this.binding;
        if (activityAddDeviceLegacyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding = null;
        }
        Drawable background = activityAddDeviceLegacyBinding.layoutAddDeviceCoordinator.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) background).stop();
        Timber.Forest.d("执行disableBackgroundAnimation", new Object[0]);
    }

    private final void setBackgroundImage() {
        getPrefs().remove(PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE);
        ViewExtensionsKt.hide(getToolbar());
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = this.binding;
        if (activityAddDeviceLegacyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding = null;
        }
        activityAddDeviceLegacyBinding.layoutAddDeviceCoordinator.setBackground(getDrawable(R.drawable.background_indoor_success_layered));
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        super.onResumeFragments();
        if (getAddDeviceService().getState().isSuccess()) {
            finishAddDevice();
            return;
        }
        CompositeDisposable compositeDisposable = this.asyncSubs;
        Observable<String> observeOn = getAddDeviceService().getMessageDisplayObserver().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(...)");
        compositeDisposable.add(RxExtensionsKt.subscribeAndLogE(observeOn, new AddDeviceActivityLegacy$$ExternalSyntheticLambda6(this)));
        CompositeDisposable compositeDisposable2 = this.asyncSubs;
        Observable<AddDeviceUtils.AddDeviceScreen> observeOn2 = getAddDeviceService().getScreenChangeObserver().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn2, "observeOn(...)");
        compositeDisposable2.add(RxExtensionsKt.subscribeAndLogE(observeOn2, new AddDeviceActivityLegacy$$ExternalSyntheticLambda7(this)));
        CompositeDisposable compositeDisposable3 = this.asyncSubs;
        Observable<AddDeviceUtils.AddDeviceScreen> observeOn3 = getAddDeviceService().getScreenRevertObserver().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn3, "observeOn(...)");
        compositeDisposable3.add(RxExtensionsKt.subscribeAndLogE(observeOn3, new AddDeviceActivityLegacy$$ExternalSyntheticLambda8(this)));
        CompositeDisposable compositeDisposable4 = this.asyncSubs;
        Observable<AddDeviceState> observeOn4 = getAddDeviceService().getSuccessObserver().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn4, "observeOn(...)");
        compositeDisposable4.add(RxExtensionsKt.subscribeAndLogE(observeOn4, new AddDeviceActivityLegacy$$ExternalSyntheticLambda9(this)));
        goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(getAddDeviceService().getState()));
    }

    /* access modifiers changed from: private */
    public static final Unit onResumeFragments$lambda$7(AddDeviceActivityLegacy addDeviceActivityLegacy, String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ViewUtils.INSTANCE.showSnackbar((Activity) addDeviceActivityLegacy, str, (ViewUtils.MessageType) ViewUtils.MessageType.ERROR.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResumeFragments$lambda$8(AddDeviceActivityLegacy addDeviceActivityLegacy, AddDeviceUtils.AddDeviceScreen addDeviceScreen) {
        Intrinsics.checkNotNullParameter(addDeviceScreen, "nextScreen");
        Timber.Forest forest = Timber.Forest;
        forest.d("screenChangeObserver success, next screen = " + addDeviceScreen, new Object[0]);
        addDeviceActivityLegacy.goForwardToScreen(addDeviceScreen);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResumeFragments$lambda$9(AddDeviceActivityLegacy addDeviceActivityLegacy, AddDeviceUtils.AddDeviceScreen addDeviceScreen) {
        Intrinsics.checkNotNullParameter(addDeviceScreen, "screen");
        Timber.Forest forest = Timber.Forest;
        forest.d("screenRevertObserver success, screen = " + addDeviceScreen, new Object[0]);
        addDeviceActivityLegacy.goBackToScreen(addDeviceScreen);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResumeFragments$lambda$10(AddDeviceActivityLegacy addDeviceActivityLegacy, AddDeviceState addDeviceState) {
        addDeviceActivityLegacy.finishAddDevice();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.asyncSubs.clear();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putParcelable(STATE_KEY, getAddDeviceService().getState());
        super.onSaveInstanceState(bundle);
    }

    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "handleBack()", imports = {}))
    public void onBackPressed() {
        handleBack();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        handleBack();
        return true;
    }

    private final void onCloseClick() {
        getAddDeviceService().setWifiPassword("");
        Object obj = PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE, null, Reflection.getOrCreateKotlinClass(String.class));
        if (((String) obj).length() <= 0) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceActivityLegacy$onCloseClick$2$1(this, str, (Continuation<? super AddDeviceActivityLegacy$onCloseClick$2$1>) null), 3, (Object) null);
        }
        if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
            finish();
            return;
        }
        goBackToScreen(AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE);
        getAddDeviceService().initState((AddDeviceState) null);
    }

    public final void updateBackAllowedUi() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(AddDeviceUtils.INSTANCE.screenAllowsBack(this.currentScreen));
        }
    }

    public final void handleBack() {
        boolean popState;
        AddDeviceUtils.AddDeviceScreen screen;
        if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_2 && getAddDeviceService().getTroubleshootThirdItemSelected()) {
            getAddDeviceService().showManualStep1();
        } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1 && getAddDeviceService().getTroubleshoot()) {
            getAddDeviceService().showAutoStep2();
        } else if (this.currentScreen != AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK && getAddDeviceService().getTroubleshoot()) {
            getAddDeviceService().troubleshoot();
        } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.TROUBLESHOOT) {
            getAddDeviceService().startConnectToNetworkClassic();
        } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
            finish();
        } else if (!AddDeviceUtils.INSTANCE.screenDoesNotAllowBack(this.currentScreen)) {
            if (this.oldScreen == AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA && this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
                finish();
            }
            while (true) {
                popState = getAddDeviceService().popState();
                screen = popState ? AddDeviceUtils.INSTANCE.getScreen(getAddDeviceService().getState()) : null;
                Timber.Forest forest = Timber.Forest;
                forest.d("handleBack loop: canGoBack = " + popState + ", targetScreen = " + screen + ", screenAllowsBack = " + AddDeviceUtils.INSTANCE.screenAllowsBack(screen), new Object[0]);
                if (!popState || !AddDeviceUtils.INSTANCE.screenAllowsBack(screen) || !(screen == this.currentScreen || screen == AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS || screen == AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS)) {
                    Timber.Forest forest2 = Timber.Forest;
                    forest2.d("handleBack: canGoBack = " + popState + ", targetScreen = " + screen + ", currentScreen = " + this.currentScreen, new Object[0]);
                }
            }
            Timber.Forest forest22 = Timber.Forest;
            forest22.d("handleBack: canGoBack = " + popState + ", targetScreen = " + screen + ", currentScreen = " + this.currentScreen, new Object[0]);
            if (!popState || screen == null) {
                Timber.Forest.d("handleBack: finish", new Object[0]);
                finish();
                return;
            }
            goBackToScreen(screen);
        }
    }

    public final void goBackToScreen(AddDeviceUtils.AddDeviceScreen addDeviceScreen) {
        Intrinsics.checkNotNullParameter(addDeviceScreen, "targetScreen");
        Timber.Forest forest = Timber.Forest;
        forest.d("goBackToScreen: targetScreen = " + addDeviceScreen + ", currentScreen = " + this.currentScreen, new Object[0]);
        if (this.currentScreen != addDeviceScreen) {
            if (WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()] == 1) {
                expandToolbar$default(this, false, 1, (Object) null);
            } else {
                expandToolbar(false);
            }
            if (!AddDeviceUtils.INSTANCE.screenAllowsBack(addDeviceScreen)) {
                getToolbar().setTitle((CharSequence) "");
            }
            int i = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()];
            if (i == 2 || i == 3) {
                enableBackgroundAnimation();
            } else {
                disableBackgroundAnimation();
            }
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("goBackToScreen: stack name = " + addDeviceScreen, new Object[0]);
            getSupportFragmentManager().popBackStack(addDeviceScreen.toString(), 1);
            this.currentScreen = addDeviceScreen;
            invalidateOptionsMenu();
            updateBackAllowedUi();
        }
    }

    public final void goForwardToScreen(AddDeviceUtils.AddDeviceScreen addDeviceScreen) {
        Fragment fragment;
        AddDeviceManualConfigProgressFragment addDeviceManualConfigProgressFragment;
        Intrinsics.checkNotNullParameter(addDeviceScreen, "nextScreen");
        this.oldScreen = this.currentScreen;
        Timber.Forest.d("goForwardToScreen: nextScreen = " + addDeviceScreen + ", currentScreen = " + this.currentScreen, new Object[0]);
        if (this.currentScreen != addDeviceScreen) {
            AddDeviceState state = getAddDeviceService().getState();
            ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = null;
            switch (WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()]) {
                case 1:
                    fragment = AddDeviceSelectModelFragment.Companion.newInstance();
                    break;
                case 2:
                    fragment = AddDeviceSetupTextFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 3:
                    fragment = IcpAddDeviceFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 4:
                    fragment = IcpSetupDeviceFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 5:
                    fragment = IcpPairDeviceFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 6:
                    fragment = IcpSaveDeviceFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 7:
                    fragment = AddDeviceSetNameFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 8:
                    fragment = AddDeviceAutoStepOneFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 9:
                    fragment = AddDeviceAutoStepTwoFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 10:
                    fragment = AddDeviceAutoConfigProgressFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 11:
                    fragment = AddDeviceSetNameFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 12:
                    fragment = AddDeviceAutoConfigurationFailedStepOne.Companion.newInstance(state.getDeviceType());
                    break;
                case 13:
                    fragment = AddDeviceAutoConfigurationFailedStepTwo.Companion.newInstance(state.getDeviceType());
                    break;
                case 14:
                    fragment = AddDeviceResetDeviceFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 15:
                    fragment = AddDeviceManualConfigurationFailed.Companion.newInstance(state.getDeviceType());
                    break;
                case 16:
                    fragment = AddDeviceManualUserValidateFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 17:
                    fragment = AddDeviceSuccessFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 18:
                    if (state.getDeviceType() == 3) {
                        getToolbar().setTitle((CharSequence) getString(com.blueair.viewcore.R.string.manual_configuration));
                    }
                    fragment = AddDeviceManualStepOneFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 19:
                    Timber.Forest forest = Timber.Forest;
                    StringBuilder sb = new StringBuilder("deviceType = ");
                    sb.append(getAddDeviceService().getState().getDeviceType());
                    sb.append(", CHANGE_WIFI_STATE = ");
                    Context context = this;
                    sb.append(ContextCompat.checkSelfPermission(context, "android.permission.CHANGE_WIFI_STATE"));
                    sb.append(", ACCESS_COARSE_LOCATION = ");
                    sb.append(ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION"));
                    forest.d(sb.toString(), new Object[0]);
                    fragment = AddDeviceManualStepTwoFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 20:
                    fragment = AddDeviceConfigureNetworkFragment.Companion.newInstance(state.getDeviceType(), state.getCurrentConfigMode(), getAddDeviceService().getCurrentNetworkSSIDEstimate(), getAddDeviceService().getSettingsWiFiNetworkPassword());
                    break;
                case 21:
                    if (ContextCompat.checkSelfPermission(this, "android.permission.CHANGE_NETWORK_STATE") == 0 || canWriteMarshmallowSettings()) {
                        addDeviceManualConfigProgressFragment = AddDeviceManualConfigProgressFragment.Companion.newInstance(state.getDeviceType());
                    } else {
                        DialogUtils.INSTANCE.showRequestPermissionHint(com.blueair.viewcore.R.string.permission_request_title_network_settings, com.blueair.viewcore.R.string.permission_request_message_network_settings);
                        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CHANGE_NETWORK_STATE"}, 101);
                        addDeviceManualConfigProgressFragment = null;
                    }
                    fragment = addDeviceManualConfigProgressFragment;
                    break;
                case 22:
                    fragment = AddDeviceMigrationOtaFragment.Companion.newInstance(state.getDeviceType());
                    break;
                case 23:
                    fragment = new ClassicTroubleShootingFragment();
                    break;
                default:
                    fragment = null;
                    break;
            }
            boolean z = true;
            boolean z2 = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()] == 1;
            boolean z3 = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()] == 17;
            int i = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()];
            if (!(i == 2 || i == 3)) {
                z = false;
            }
            Timber.Forest.d("screenFragment = " + fragment, new Object[0]);
            if (fragment != null) {
                expandToolbar(z2);
                if (z) {
                    enableBackgroundAnimation();
                } else {
                    disableBackgroundAnimation();
                }
                if (!AddDeviceUtils.INSTANCE.screenAllowsBack(addDeviceScreen)) {
                    getToolbar().setTitle((CharSequence) "");
                }
                if (AddDeviceUtils.INSTANCE.screenHasNoToolbar(addDeviceScreen)) {
                    getToolbar().setBackgroundColor(getResources().getColor(com.blueair.viewcore.R.color.transparent));
                    getToolbar().removeAllViews();
                }
                if (z3) {
                    setBackgroundImage();
                }
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
                FragmentTransaction animationTransaction = animationTransaction(beginTransaction, fragment);
                this.currentScreen = addDeviceScreen;
                invalidateOptionsMenu();
                updateBackAllowedUi();
                ViewHelperUtil viewHelperUtil = ViewHelperUtil.INSTANCE;
                ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding2 = this.binding;
                if (activityAddDeviceLegacyBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityAddDeviceLegacyBinding = activityAddDeviceLegacyBinding2;
                }
                viewHelperUtil.hideSoftKeyboard(activityAddDeviceLegacyBinding.contentFragment);
                Timber.Forest.d("goForwardToScreen, add old fragment to backstack " + this.oldScreen, new Object[0]);
                animationTransaction.replace(R.id.content_fragment, fragment);
                animationTransaction.addToBackStack(this.oldScreen.toString());
                animationTransaction.commitAllowingStateLoss();
                return;
            }
            Timber.Forest.w("gotoNextScreen, but no valid screen foundIp", new Object[0]);
        }
    }

    private final FragmentTransaction animationTransaction(FragmentTransaction fragmentTransaction, Fragment fragment) {
        if (getSupportFragmentManager().getBackStackEntryCount() - 1 < 0) {
            return fragmentTransaction;
        }
        TransitionSet transitionSet = new TransitionSet();
        Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760257);
        if (inflateTransition != null) {
            transitionSet.addTransition(inflateTransition);
        }
        transitionSet.setDuration(250);
        fragment.setSharedElementEnterTransition(transitionSet);
        fragment.setSharedElementReturnTransition(transitionSet);
        ActivityAddDeviceLegacyBinding activityAddDeviceLegacyBinding = this.binding;
        if (activityAddDeviceLegacyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDeviceLegacyBinding = null;
        }
        FrameLayout frameLayout = activityAddDeviceLegacyBinding.contentFragment;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentFragment");
        recursivelyAddSharedTransitions(frameLayout, fragmentTransaction);
        return fragmentTransaction;
    }

    private final void recursivelyAddSharedTransitions(ViewGroup viewGroup, FragmentTransaction fragmentTransaction) {
        CharSequence transitionName;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                recursivelyAddSharedTransitions((ViewGroup) childAt, fragmentTransaction);
            } else if (!(childAt == null || (transitionName = childAt.getTransitionName()) == null || transitionName.length() == 0)) {
                try {
                    Intrinsics.checkNotNull(fragmentTransaction.addSharedElement(childAt, childAt.getTransitionName()));
                } catch (IllegalArgumentException e) {
                    Timber.Forest.w(e, "There is more than one element in this screen with the same transitionName of " + childAt.getTransitionName(), new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ void expandToolbar$default(AddDeviceActivityLegacy addDeviceActivityLegacy, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        addDeviceActivityLegacy.expandToolbar(z);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r2v15, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void expandToolbar(boolean r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L_0x004f
            androidx.appcompat.widget.Toolbar r2 = r5.getToolbar()
            java.lang.String r3 = ""
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setTitle((java.lang.CharSequence) r3)
            androidx.appcompat.app.ActionBar r2 = r5.getSupportActionBar()
            if (r2 == 0) goto L_0x001a
            int r3 = com.blueair.viewcore.R.drawable.ic_close
            r2.setHomeAsUpIndicator((int) r3)
        L_0x001a:
            androidx.constraintlayout.widget.ConstraintLayout r2 = r5.getLayoutExpandedToolbar()
            r2.setVisibility(r1)
            androidx.appcompat.widget.AppCompatImageButton r2 = r5.getBtnClose()
            int r3 = com.blueair.viewcore.R.drawable.ic_close_outlined_primary
            r2.setImageResource(r3)
            com.google.android.material.appbar.CollapsingToolbarLayout r2 = r5.getCollapsingToolbar()
            r3 = -1
            r2.setContentScrimColor(r3)
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r5.setStatusBarColor(r3, r2)
            com.google.android.material.appbar.CollapsingToolbarLayout r2 = r5.getCollapsingToolbar()
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            boolean r3 = r2 instanceof com.google.android.material.appbar.AppBarLayout.LayoutParams
            if (r3 == 0) goto L_0x0049
            r0 = r2
            com.google.android.material.appbar.AppBarLayout$LayoutParams r0 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r0
        L_0x0049:
            if (r0 == 0) goto L_0x00a9
            r0.setScrollFlags(r1)
            goto L_0x00a9
        L_0x004f:
            androidx.appcompat.widget.Toolbar r2 = r5.getToolbar()
            int r3 = com.blueair.viewcore.R.string.add_device
            r2.setTitle((int) r3)
            androidx.appcompat.app.ActionBar r2 = r5.getSupportActionBar()
            if (r2 == 0) goto L_0x0063
            int r3 = com.blueair.viewcore.R.drawable.ic_arrow_back_white
            r2.setHomeAsUpIndicator((int) r3)
        L_0x0063:
            androidx.appcompat.widget.Toolbar r2 = r5.getToolbar()
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = com.blueair.viewcore.R.font.gilroy_bold
            com.blueair.viewcore.extensions.ToolbarExtensionsKt.changeToolbarFont(r2, r3, r4)
            int r2 = com.blueair.viewcore.R.color.colorPrimary
            int r2 = r5.getColor(r2)
            androidx.appcompat.widget.AppCompatImageButton r3 = r5.getBtnClose()
            int r4 = com.blueair.viewcore.R.drawable.ic_close
            r3.setImageResource(r4)
            com.google.android.material.appbar.CollapsingToolbarLayout r3 = r5.getCollapsingToolbar()
            r3.setContentScrimColor(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5.setStatusBarColor(r2, r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r5.getLayoutExpandedToolbar()
            r2 = 4
            r1.setVisibility(r2)
            com.google.android.material.appbar.CollapsingToolbarLayout r1 = r5.getCollapsingToolbar()
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            boolean r2 = r1 instanceof com.google.android.material.appbar.AppBarLayout.LayoutParams
            if (r2 == 0) goto L_0x00a3
            r0 = r1
            com.google.android.material.appbar.AppBarLayout$LayoutParams r0 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r0
        L_0x00a3:
            if (r0 == 0) goto L_0x00a9
            r1 = 3
            r0.setScrollFlags(r1)
        L_0x00a9:
            com.google.android.material.appbar.AppBarLayout r0 = r5.getAddDeviceAppbar()
            r0.setExpanded(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.activity.AddDeviceActivityLegacy.expandToolbar(boolean):void");
    }

    private final void finishAddDevice() {
        DeviceInformationLegacy deviceInfo = getAddDeviceService().getState().getDeviceInfo();
        Bundle bundle = new Bundle();
        if (deviceInfo != null) {
            bundle.putString(PARAM_SELECTED_DEVICE, deviceInfo.getId());
            bundle.putString(PARAM_DEVICE_COMPATIBILITY, deviceInfo.getCompatibility());
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
        startActivity(Actions.INSTANCE.openHomeIntent(this));
    }

    private final boolean canWriteMarshmallowSettings() {
        if (Build.VERSION.SDK_INT == 23) {
            return Settings.System.canWrite(this);
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = 0;
        Timber.Forest.d("onRequestPermissionsResult: requestCode = " + i + ", grantResults = " + iArr + ", grantResults.length = " + iArr.length, new Object[0]);
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Timber.Forest.d("permission = " + strArr[i3] + ", result = " + iArr[i3], new Object[0]);
        }
        boolean z = true;
        if (i == 101) {
            if (iArr.length != 0) {
                z = false;
            }
            if (!z && iArr[0] == 0) {
                goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(getAddDeviceService().getState()));
                return;
            }
        } else if (i == 105) {
            if (iArr.length != 0) {
                z = false;
            }
            if (!z) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    if (iArr[i2] == 0) {
                        i2++;
                    }
                }
                goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(getAddDeviceService().getState()));
                return;
            }
        } else {
            return;
        }
        if (Build.VERSION.SDK_INT == 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 103);
            return;
        }
        ViewUtils.INSTANCE.showError((Activity) this, com.blueair.viewcore.R.string.add_device_info_missing);
    }
}
