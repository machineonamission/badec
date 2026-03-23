package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.TroubleShootingItem;
import com.blueair.viewcore.databinding.DialogTroubleshootingBinding;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.EmptyViewModel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020-H\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00108\u001a\u000209H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lcom/blueair/viewcore/dialog/TroubleshootingDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/viewcore/adapter/TroubleShootingItem;", "actionType", "device", "Lcom/blueair/core/model/Device;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/EmptyViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "hydrateHeaderAndList", "", "binding", "Lcom/blueair/viewcore/databinding/DialogTroubleshootingBinding;", "setCantSeeHeaderSpan", "tvHeader", "Landroidx/appcompat/widget/AppCompatTextView;", "setFooterSpan", "tvFooter", "onStart", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TroubleshootingDialog.kt */
public final class TroubleshootingDialog extends BaseDialogFragment<EmptyViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final String ACTION_RETRY = "action_retry";
    public static final String ACTION_TYPE_BLUETOOTH_CANT_SEE = "action_type_bluetooth_cant_see";
    private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO = "action_type_bluetooth_connecting_auto";
    private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY = "action_type_bluetooth_connecting_auto_humidity";
    private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_FAN = "action_type_bluetooth_connecting_fan";
    private static final String ACTION_TYPE_BLUETOOTH_CONNECTING_NORMAL = "action_type_bluetooth_connecting_normal";
    public static final String ACTION_TYPE_DEVICE_OFFLINE = "action_type_device_offline";
    public static final String ACTION_TYPE_WIFI_GUIDE = "action_type_wifi_guide";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LINK_TOKEN_CUSTOMER_SUPPORT = "customer_support";
    public static final String REQUEST_KEY = "TroubleshootingDialog";
    private String actionType = "";
    private final Lazy authService$delegate;
    private Device device;
    private final Lazy deviceManager$delegate;
    private final ItemAdapter<TroubleShootingItem> itemAdapter = new ItemAdapter<>();
    private final Lazy locationService$delegate;
    private final String screenName;
    public EmptyViewModel viewModel;

    static {
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    }

    public void showProgress(boolean z) {
    }

    public TroubleshootingDialog() {
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new TroubleshootingDialog$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new TroubleshootingDialog$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new TroubleshootingDialog$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public EmptyViewModel getViewModel() {
        EmptyViewModel emptyViewModel = this.viewModel;
        if (emptyViewModel != null) {
            return emptyViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(EmptyViewModel emptyViewModel) {
        Intrinsics.checkNotNullParameter(emptyViewModel, "<set-?>");
        this.viewModel = emptyViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setWindowAnimations(R.style.dialog_animation);
            }
        }
        setViewModel((EmptyViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(EmptyViewModel.class)));
        DialogTroubleshootingBinding inflate = DialogTroubleshootingBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.closeButton.setOnClickListener(new TroubleshootingDialog$$ExternalSyntheticLambda1(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("action_type", this.actionType);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.actionType = string;
            this.device = (Device) arguments.getParcelable("device");
        }
        hydrateHeaderAndList(inflate);
        inflate.rvList.setAdapter(FastAdapter.Companion.with(this.itemAdapter));
        if (!Intrinsics.areEqual((Object) this.actionType, (Object) ACTION_TYPE_DEVICE_OFFLINE)) {
            AppCompatTextView appCompatTextView = inflate.tvFooter;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvFooter");
            setFooterSpan(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = inflate.tvFooter;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "tvFooter");
            ViewExtensionsKt.hide(appCompatTextView2);
        }
        inflate.btnTryAgain.setOnClickListener(new TroubleshootingDialog$$ExternalSyntheticLambda2(this));
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(TroubleshootingDialog troubleshootingDialog, View view) {
        troubleshootingDialog.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(TroubleshootingDialog troubleshootingDialog, View view) {
        troubleshootingDialog.dismissAllowingStateLoss();
        FragmentKt.setFragmentResult(troubleshootingDialog, REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(ACTION_RETRY, true)));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x02e1, code lost:
        if (r3.equals(ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY) == false) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x02e5, code lost:
        r1.tvHeader.setText(getString(com.blueair.viewcore.R.string.troubleshooting_bluetooth_header_msg));
        r1 = new com.blueair.core.model.SimpleResourceBundle[8];
        r1[0] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_power_on, com.blueair.viewcore.R.string.step_title_power_on_device, com.blueair.viewcore.R.string.bt_troubleshooting_1_step, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r17 = com.blueair.viewcore.R.drawable.ic_wifi_4;
        r18 = com.blueair.viewcore.R.string.step_title_ready_to_pair;
        r2 = r0.actionType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0317, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY) == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0319, code lost:
        r2 = com.blueair.viewcore.R.string.wifi_connect_instruction_auto_humidity;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0322, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) ACTION_TYPE_BLUETOOTH_CONNECTING_FAN) == false) goto L_0x0327;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0324, code lost:
        r2 = com.blueair.viewcore.R.string.step_content_ready_to_pair_fan;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0327, code lost:
        r2 = com.blueair.viewcore.R.string.bt_troubleshooting_press_auto;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x032a, code lost:
        r1[1] = new com.blueair.core.model.SimpleResourceBundle(r17, r18, r2, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[2] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_device_model, com.blueair.viewcore.R.string.step_title_check_device_model, com.blueair.viewcore.R.string.bt_troubleshooting_2_step, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[3] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_smartphone, com.blueair.viewcore.R.string.step_title_check_close_enough, com.blueair.viewcore.R.string.step_content_check_close_enough, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[4] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_latest_app, com.blueair.viewcore.R.string.step_title_ensure_latest_app, com.blueair.viewcore.R.string.step_content_ensure_latest_app, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[5] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_bluetooth_on, com.blueair.viewcore.R.string.step_title_turn_on_bluetooth, com.blueair.viewcore.R.string.step_content_turn_on_bluetooth, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[6] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_location_on, com.blueair.viewcore.R.string.step_title_ensure_location_settings, com.blueair.viewcore.R.string.step_content_ensure_location_settings, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r1[7] = new com.blueair.core.model.SimpleResourceBundle(com.blueair.viewcore.R.drawable.icon_internet, com.blueair.viewcore.R.string.step_title_check_phone_internet, com.blueair.viewcore.R.string.step_content_check_phone_internet, (java.lang.String) null, (java.lang.String) null, 24, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r2 = kotlin.collections.CollectionsKt.arrayListOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r3.equals(ACTION_TYPE_BLUETOOTH_CONNECTING_FAN) == false) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00d6, code lost:
        if (r3.equals(ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO) == false) goto L_0x03b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void hydrateHeaderAndList(com.blueair.viewcore.databinding.DialogTroubleshootingBinding r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.String r3 = r0.actionType
            int r4 = r3.hashCode()
            java.lang.String r5 = "action_type_bluetooth_connecting_fan"
            java.lang.String r6 = "action_type_bluetooth_connecting_auto_humidity"
            r7 = 7
            r8 = 6
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            switch(r4) {
                case -1166068087: goto L_0x02dd;
                case -118147818: goto L_0x020d;
                case -95719570: goto L_0x0177;
                case 118272197: goto L_0x00da;
                case 384927145: goto L_0x00d0;
                case 914378337: goto L_0x0027;
                case 982252505: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x03b0
        L_0x001f:
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x02e5
            goto L_0x03b0
        L_0x0027:
            java.lang.String r4 = "action_type_bluetooth_connecting_normal"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0031
            goto L_0x03b0
        L_0x0031:
            androidx.appcompat.widget.AppCompatTextView r1 = r1.tvHeader
            int r2 = com.blueair.viewcore.R.string.troubleshooting_bluetooth_header_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            com.blueair.core.model.SimpleResourceBundle[] r1 = new com.blueair.core.model.SimpleResourceBundle[r7]
            com.blueair.core.model.SimpleResourceBundle r15 = new com.blueair.core.model.SimpleResourceBundle
            int r16 = com.blueair.viewcore.R.drawable.icon_power_on
            int r17 = com.blueair.viewcore.R.string.step_title_power_on_device
            int r18 = com.blueair.viewcore.R.string.bt_troubleshooting_1_step
            r21 = 24
            r22 = 0
            r19 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r1[r14] = r15
            com.blueair.core.model.SimpleResourceBundle r16 = new com.blueair.core.model.SimpleResourceBundle
            int r17 = com.blueair.viewcore.R.drawable.icon_device_model
            int r18 = com.blueair.viewcore.R.string.step_title_check_device_model
            int r19 = com.blueair.viewcore.R.string.bt_troubleshooting_2_step
            r22 = 24
            r23 = 0
            r21 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1[r13] = r16
            com.blueair.core.model.SimpleResourceBundle r17 = new com.blueair.core.model.SimpleResourceBundle
            int r18 = com.blueair.viewcore.R.drawable.icon_smartphone
            int r19 = com.blueair.viewcore.R.string.step_title_check_close_enough
            int r20 = com.blueair.viewcore.R.string.step_content_check_close_enough
            r23 = 24
            r24 = 0
            r22 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r1[r12] = r17
            com.blueair.core.model.SimpleResourceBundle r18 = new com.blueair.core.model.SimpleResourceBundle
            int r19 = com.blueair.viewcore.R.drawable.icon_latest_app
            int r20 = com.blueair.viewcore.R.string.step_title_ensure_latest_app
            int r21 = com.blueair.viewcore.R.string.step_content_ensure_latest_app
            r24 = 24
            r25 = 0
            r23 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1[r11] = r18
            com.blueair.core.model.SimpleResourceBundle r19 = new com.blueair.core.model.SimpleResourceBundle
            int r20 = com.blueair.viewcore.R.drawable.icon_bluetooth_on
            int r21 = com.blueair.viewcore.R.string.step_title_turn_on_bluetooth
            int r22 = com.blueair.viewcore.R.string.step_content_turn_on_bluetooth
            r25 = 24
            r26 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r1[r10] = r19
            com.blueair.core.model.SimpleResourceBundle r20 = new com.blueair.core.model.SimpleResourceBundle
            int r21 = com.blueair.viewcore.R.drawable.icon_location_on
            int r22 = com.blueair.viewcore.R.string.step_title_ensure_location_settings
            int r23 = com.blueair.viewcore.R.string.step_content_ensure_location_settings
            r26 = 24
            r27 = 0
            r25 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r1[r9] = r20
            com.blueair.core.model.SimpleResourceBundle r21 = new com.blueair.core.model.SimpleResourceBundle
            int r22 = com.blueair.viewcore.R.drawable.icon_internet
            int r23 = com.blueair.viewcore.R.string.step_title_check_phone_internet
            int r24 = com.blueair.viewcore.R.string.step_content_check_phone_internet
            r27 = 24
            r28 = 0
            r26 = 0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28)
            r1[r8] = r21
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            goto L_0x03b0
        L_0x00d0:
            java.lang.String r4 = "action_type_bluetooth_connecting_auto"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02e5
            goto L_0x03b0
        L_0x00da:
            java.lang.String r4 = "action_type_bluetooth_cant_see"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x03b0
            androidx.appcompat.widget.AppCompatTextView r2 = r1.tvCantSeeMsg
            java.lang.String r3 = "tvCantSeeMsg"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r2.setVisibility(r14)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.tvHeader
            java.lang.String r2 = "tvHeader"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setCantSeeHeaderSpan(r1)
            com.blueair.core.model.SimpleResourceBundle[] r1 = new com.blueair.core.model.SimpleResourceBundle[r8]
            com.blueair.core.model.SimpleResourceBundle r15 = new com.blueair.core.model.SimpleResourceBundle
            int r16 = com.blueair.viewcore.R.drawable.icon_power_on
            int r17 = com.blueair.viewcore.R.string.step_title_power_on_device
            int r18 = com.blueair.viewcore.R.string.bt_troubleshooting_1_step
            r21 = 24
            r22 = 0
            r19 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r1[r14] = r15
            com.blueair.core.model.SimpleResourceBundle r16 = new com.blueair.core.model.SimpleResourceBundle
            int r17 = com.blueair.viewcore.R.drawable.icon_device_model
            int r18 = com.blueair.viewcore.R.string.step_title_check_device_model
            int r19 = com.blueair.viewcore.R.string.bt_troubleshooting_2_step
            r22 = 24
            r23 = 0
            r21 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1[r13] = r16
            com.blueair.core.model.SimpleResourceBundle r17 = new com.blueair.core.model.SimpleResourceBundle
            int r18 = com.blueair.viewcore.R.drawable.icon_smartphone
            int r19 = com.blueair.viewcore.R.string.step_title_check_close_enough
            int r20 = com.blueair.viewcore.R.string.step_content_check_close_enough
            r23 = 24
            r24 = 0
            r22 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r1[r12] = r17
            com.blueair.core.model.SimpleResourceBundle r18 = new com.blueair.core.model.SimpleResourceBundle
            int r19 = com.blueair.viewcore.R.drawable.icon_latest_app
            int r20 = com.blueair.viewcore.R.string.step_title_ensure_latest_app
            int r21 = com.blueair.viewcore.R.string.step_content_ensure_latest_app
            r24 = 24
            r25 = 0
            r23 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1[r11] = r18
            com.blueair.core.model.SimpleResourceBundle r19 = new com.blueair.core.model.SimpleResourceBundle
            int r20 = com.blueair.viewcore.R.drawable.icon_bluetooth_on
            int r21 = com.blueair.viewcore.R.string.step_title_turn_on_bluetooth
            int r22 = com.blueair.viewcore.R.string.step_content_turn_on_bluetooth
            r25 = 24
            r26 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r1[r10] = r19
            com.blueair.core.model.SimpleResourceBundle r20 = new com.blueair.core.model.SimpleResourceBundle
            int r21 = com.blueair.viewcore.R.drawable.icon_internet
            int r22 = com.blueair.viewcore.R.string.step_title_check_phone_internet
            int r23 = com.blueair.viewcore.R.string.step_content_check_phone_internet
            r26 = 24
            r27 = 0
            r25 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r1[r9] = r20
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            goto L_0x03b0
        L_0x0177:
            java.lang.String r4 = "action_type_wifi_guide"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0181
            goto L_0x03b0
        L_0x0181:
            androidx.appcompat.widget.AppCompatTextView r1 = r1.tvHeader
            int r2 = com.blueair.viewcore.R.string.troubleshooting_wifi_header_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            com.blueair.core.model.SimpleResourceBundle[] r1 = new com.blueair.core.model.SimpleResourceBundle[r8]
            com.blueair.core.model.SimpleResourceBundle r15 = new com.blueair.core.model.SimpleResourceBundle
            int r16 = com.blueair.viewcore.R.drawable.icon_power_on
            int r17 = com.blueair.viewcore.R.string.step_title_check_router_internet
            int r18 = com.blueair.viewcore.R.string.wifi_troubleshooting_step_1
            r21 = 24
            r22 = 0
            r19 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r1[r14] = r15
            com.blueair.core.model.SimpleResourceBundle r16 = new com.blueair.core.model.SimpleResourceBundle
            int r17 = com.blueair.viewcore.R.drawable.ic_wifi_4
            int r18 = com.blueair.viewcore.R.string.step_title_prefer_band
            int r19 = com.blueair.viewcore.R.string.step_content_prefer_band
            r22 = 24
            r23 = 0
            r21 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1[r13] = r16
            com.blueair.core.model.SimpleResourceBundle r17 = new com.blueair.core.model.SimpleResourceBundle
            int r18 = com.blueair.viewcore.R.drawable.icon_internet
            int r19 = com.blueair.viewcore.R.string.step_title_check_phone_internet
            int r20 = com.blueair.viewcore.R.string.step_content_check_phone_internet
            r23 = 24
            r24 = 0
            r22 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r1[r12] = r17
            com.blueair.core.model.SimpleResourceBundle r18 = new com.blueair.core.model.SimpleResourceBundle
            int r19 = com.blueair.viewcore.R.drawable.icon_smartphone
            int r20 = com.blueair.viewcore.R.string.step_title_connecting_hidden_wifi
            int r21 = com.blueair.viewcore.R.string.step_content_connecting_hidden_wifi
            r24 = 24
            r25 = 0
            r23 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1[r11] = r18
            com.blueair.core.model.SimpleResourceBundle r19 = new com.blueair.core.model.SimpleResourceBundle
            int r20 = com.blueair.viewcore.R.drawable.icon_vpn_services
            int r21 = com.blueair.viewcore.R.string.step_title_deactivate_vpn
            int r22 = com.blueair.viewcore.R.string.step_content_deactivate_vpn
            r25 = 24
            r26 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r1[r10] = r19
            com.blueair.core.model.SimpleResourceBundle r20 = new com.blueair.core.model.SimpleResourceBundle
            int r21 = com.blueair.viewcore.R.drawable.icon_wifi_router
            int r22 = com.blueair.viewcore.R.string.step_title_close_to_router
            int r23 = com.blueair.viewcore.R.string.step_content_close_to_router
            r26 = 24
            r27 = 0
            r25 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r1[r9] = r20
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            goto L_0x03b0
        L_0x020d:
            java.lang.String r4 = "action_type_device_offline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0217
            goto L_0x03b0
        L_0x0217:
            androidx.appcompat.widget.AppCompatTextView r1 = r1.tvHeader
            int r2 = com.blueair.viewcore.R.string.troubleshooting_offline_header_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            com.blueair.core.model.SimpleResourceBundle[] r1 = new com.blueair.core.model.SimpleResourceBundle[r7]
            com.blueair.core.model.SimpleResourceBundle r15 = new com.blueair.core.model.SimpleResourceBundle
            int r16 = com.blueair.viewcore.R.drawable.icon_internet
            int r17 = com.blueair.viewcore.R.string.step_title_check_wifi_internet
            int r18 = com.blueair.viewcore.R.string.step_content_check_wifi_internet
            r21 = 24
            r22 = 0
            r19 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r1[r14] = r15
            com.blueair.core.model.SimpleResourceBundle r16 = new com.blueair.core.model.SimpleResourceBundle
            int r17 = com.blueair.viewcore.R.drawable.icon_wifi_router
            int r18 = com.blueair.viewcore.R.string.step_title_restart_router
            int r19 = com.blueair.viewcore.R.string.step_content_restart_router
            r22 = 24
            r23 = 0
            r21 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1[r13] = r16
            com.blueair.core.model.SimpleResourceBundle r17 = new com.blueair.core.model.SimpleResourceBundle
            int r18 = com.blueair.viewcore.R.drawable.ic_wifi_4
            int r19 = com.blueair.viewcore.R.string.step_title_prefer_band
            int r20 = com.blueair.viewcore.R.string.step_content_prefer_band_v2
            r23 = 24
            r24 = 0
            r22 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r1[r12] = r17
            com.blueair.core.model.SimpleResourceBundle r18 = new com.blueair.core.model.SimpleResourceBundle
            int r19 = com.blueair.viewcore.R.drawable.icon_power_on
            int r20 = com.blueair.viewcore.R.string.step_title_replug_device
            int r21 = com.blueair.viewcore.R.string.step_content_replug_device
            r24 = 24
            r25 = 0
            r23 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1[r11] = r18
            com.blueair.core.model.SimpleResourceBundle r19 = new com.blueair.core.model.SimpleResourceBundle
            int r20 = com.blueair.viewcore.R.drawable.icon_readd
            int r21 = com.blueair.viewcore.R.string.step_title_readd_device
            int r22 = com.blueair.viewcore.R.string.step_content_readd_device
            r25 = 24
            r26 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r1[r10] = r19
            com.blueair.core.model.SimpleResourceBundle r20 = new com.blueair.core.model.SimpleResourceBundle
            int r21 = com.blueair.viewcore.R.drawable.icon_latest_app
            int r22 = com.blueair.viewcore.R.string.step_title_reinstall_app
            int r23 = com.blueair.viewcore.R.string.step_content_reinstall_app
            r26 = 24
            r27 = 0
            r25 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r1[r9] = r20
            com.blueair.core.model.SimpleResourceBundle r21 = new com.blueair.core.model.SimpleResourceBundle
            int r22 = com.blueair.viewcore.R.drawable.icon_power_on
            int r23 = com.blueair.viewcore.R.string.step_title_reset_device
            int r24 = com.blueair.viewcore.R.string.step_content_reset_device
            r27 = 24
            r28 = 0
            r26 = 0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28)
            r1[r8] = r21
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            com.blueair.auth.LocationService r1 = r0.getLocationService()
            com.blueair.auth.RemoteConfig r1 = r1.getRemoteConfig()
            boolean r1 = r1.getOfflineSupportEnabled()
            if (r1 == 0) goto L_0x03b0
            r1 = r2
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            com.blueair.core.model.SimpleResourceBundle r3 = new com.blueair.core.model.SimpleResourceBundle
            int r4 = com.blueair.viewcore.R.drawable.icon_customer_support
            int r5 = com.blueair.viewcore.R.string.step_title_customer_support
            int r6 = com.blueair.viewcore.R.string.step_content_customer_support
            int r7 = com.blueair.viewcore.R.string.action_click_here
            java.lang.String r7 = r0.getString(r7)
            java.lang.String r8 = "customer_support"
            r3.<init>(r4, r5, r6, r7, r8)
            r1.add(r3)
            goto L_0x03b0
        L_0x02dd:
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x02e5
            goto L_0x03b0
        L_0x02e5:
            androidx.appcompat.widget.AppCompatTextView r1 = r1.tvHeader
            int r2 = com.blueair.viewcore.R.string.troubleshooting_bluetooth_header_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            r1 = 8
            com.blueair.core.model.SimpleResourceBundle[] r1 = new com.blueair.core.model.SimpleResourceBundle[r1]
            com.blueair.core.model.SimpleResourceBundle r15 = new com.blueair.core.model.SimpleResourceBundle
            int r16 = com.blueair.viewcore.R.drawable.icon_power_on
            int r17 = com.blueair.viewcore.R.string.step_title_power_on_device
            int r18 = com.blueair.viewcore.R.string.bt_troubleshooting_1_step
            r21 = 24
            r22 = 0
            r19 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r1[r14] = r15
            com.blueair.core.model.SimpleResourceBundle r16 = new com.blueair.core.model.SimpleResourceBundle
            int r17 = com.blueair.viewcore.R.drawable.ic_wifi_4
            int r18 = com.blueair.viewcore.R.string.step_title_ready_to_pair
            java.lang.String r2 = r0.actionType
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x031e
            int r2 = com.blueair.viewcore.R.string.wifi_connect_instruction_auto_humidity
        L_0x031b:
            r19 = r2
            goto L_0x032a
        L_0x031e:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0327
            int r2 = com.blueair.viewcore.R.string.step_content_ready_to_pair_fan
            goto L_0x031b
        L_0x0327:
            int r2 = com.blueair.viewcore.R.string.bt_troubleshooting_press_auto
            goto L_0x031b
        L_0x032a:
            r22 = 24
            r23 = 0
            r20 = 0
            r21 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r1[r13] = r16
            com.blueair.core.model.SimpleResourceBundle r17 = new com.blueair.core.model.SimpleResourceBundle
            int r18 = com.blueair.viewcore.R.drawable.icon_device_model
            int r19 = com.blueair.viewcore.R.string.step_title_check_device_model
            int r20 = com.blueair.viewcore.R.string.bt_troubleshooting_2_step
            r23 = 24
            r24 = 0
            r22 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r1[r12] = r17
            com.blueair.core.model.SimpleResourceBundle r18 = new com.blueair.core.model.SimpleResourceBundle
            int r19 = com.blueair.viewcore.R.drawable.icon_smartphone
            int r20 = com.blueair.viewcore.R.string.step_title_check_close_enough
            int r21 = com.blueair.viewcore.R.string.step_content_check_close_enough
            r24 = 24
            r25 = 0
            r23 = 0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1[r11] = r18
            com.blueair.core.model.SimpleResourceBundle r19 = new com.blueair.core.model.SimpleResourceBundle
            int r20 = com.blueair.viewcore.R.drawable.icon_latest_app
            int r21 = com.blueair.viewcore.R.string.step_title_ensure_latest_app
            int r22 = com.blueair.viewcore.R.string.step_content_ensure_latest_app
            r25 = 24
            r26 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r1[r10] = r19
            com.blueair.core.model.SimpleResourceBundle r20 = new com.blueair.core.model.SimpleResourceBundle
            int r21 = com.blueair.viewcore.R.drawable.icon_bluetooth_on
            int r22 = com.blueair.viewcore.R.string.step_title_turn_on_bluetooth
            int r23 = com.blueair.viewcore.R.string.step_content_turn_on_bluetooth
            r26 = 24
            r27 = 0
            r25 = 0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r1[r9] = r20
            com.blueair.core.model.SimpleResourceBundle r21 = new com.blueair.core.model.SimpleResourceBundle
            int r22 = com.blueair.viewcore.R.drawable.icon_location_on
            int r23 = com.blueair.viewcore.R.string.step_title_ensure_location_settings
            int r24 = com.blueair.viewcore.R.string.step_content_ensure_location_settings
            r27 = 24
            r28 = 0
            r26 = 0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28)
            r1[r8] = r21
            com.blueair.core.model.SimpleResourceBundle r22 = new com.blueair.core.model.SimpleResourceBundle
            int r23 = com.blueair.viewcore.R.drawable.icon_internet
            int r24 = com.blueair.viewcore.R.string.step_title_check_phone_internet
            int r25 = com.blueair.viewcore.R.string.step_content_check_phone_internet
            r28 = 24
            r29 = 0
            r27 = 0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29)
            r1[r7] = r22
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = r1
            java.util.List r2 = (java.util.List) r2
        L_0x03b0:
            com.blueair.viewcore.dialog.TroubleshootingDialog$$ExternalSyntheticLambda0 r1 = new com.blueair.viewcore.dialog.TroubleshootingDialog$$ExternalSyntheticLambda0
            r1.<init>(r0)
            com.mikepenz.fastadapter.adapters.ItemAdapter<com.blueair.viewcore.adapter.TroubleShootingItem> r3 = r0.itemAdapter
            com.mikepenz.fastadapter.IItemList r3 = r3.getItemList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x03ce:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x03e3
            java.lang.Object r5 = r2.next()
            com.blueair.core.model.SimpleResourceBundle r5 = (com.blueair.core.model.SimpleResourceBundle) r5
            com.blueair.viewcore.adapter.TroubleShootingItem r6 = new com.blueair.viewcore.adapter.TroubleShootingItem
            r6.<init>(r5, r1)
            r4.add(r6)
            goto L_0x03ce
        L_0x03e3:
            java.util.List r4 = (java.util.List) r4
            r3.setNewList(r4, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.dialog.TroubleshootingDialog.hydrateHeaderAndList(com.blueair.viewcore.databinding.DialogTroubleshootingBinding):void");
    }

    /* access modifiers changed from: private */
    public static final Unit hydrateHeaderAndList$lambda$6(TroubleshootingDialog troubleshootingDialog, String str, String str2) {
        Device device2;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        if (Intrinsics.areEqual((Object) str2, (Object) LINK_TOKEN_CUSTOMER_SUPPORT) && (device2 = troubleshootingDialog.device) != null) {
            LifecycleOwner viewLifecycleOwner = troubleshootingDialog.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1(troubleshootingDialog, device2, (Continuation<? super TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private final void setCantSeeHeaderSpan(AppCompatTextView appCompatTextView) {
        String string = getString(R.string.action_click_here);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableString spannableString = new SpannableString(getString(R.string.hint_have_legacy_device) + TokenParser.SP + string);
        CharSequence charSequence = spannableString;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        int color = ContextCompat.getColor(appCompatTextView.getContext(), R.color.colorPrimary);
        if (indexOf$default > -1) {
            spannableString.setSpan(Companion.buildLegacyClickableSpan(color), indexOf$default, string.length() + indexOf$default, 33);
            appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        appCompatTextView.setText(charSequence);
    }

    private final void setFooterSpan(AppCompatTextView appCompatTextView) {
        String string = getString(R.string.customer_support_lowercase);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableString spannableString = new SpannableString(getString(R.string.troubleshooting_support_msg, string));
        CharSequence charSequence = spannableString;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            spannableString.setSpan(Companion.buildSupportClickableSpan(ContextCompat.getColor(appCompatTextView.getContext(), R.color.colorPrimary)), indexOf$default, string.length() + indexOf$default, 33);
            appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        appCompatTextView.setText(charSequence);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(8448);
            window.setStatusBarColor(0);
            DialogUtils.INSTANCE.immersiveStatusBar(getDialog(), false, true);
            window.setLayout(-1, -1);
        }
    }

    public void onPause() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onPause();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/viewcore/dialog/TroubleshootingDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_RETRY", "ACTION_TYPE_BLUETOOTH_CANT_SEE", "ACTION_TYPE_WIFI_GUIDE", "ACTION_TYPE_DEVICE_OFFLINE", "ACTION_TYPE_BLUETOOTH_CONNECTING_NORMAL", "ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO", "ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY", "ACTION_TYPE_BLUETOOTH_CONNECTING_FAN", "LINK_TOKEN_CUSTOMER_SUPPORT", "newInstanceForBluetooth", "Lcom/blueair/viewcore/dialog/TroubleshootingDialog;", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "newInstance", "actionType", "device", "Lcom/blueair/core/model/Device;", "buildSupportClickableSpan", "Landroid/text/style/ClickableSpan;", "linkColor", "", "buildLegacyClickableSpan", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TroubleshootingDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TroubleshootingDialog newInstanceForBluetooth(BluetoothDevice bluetoothDevice) {
            String str;
            if (bluetoothDevice == null || !bluetoothDevice.getAutoButtonPressNeeded()) {
                str = TroubleshootingDialog.ACTION_TYPE_BLUETOOTH_CONNECTING_NORMAL;
            } else if (bluetoothDevice.getHasNoAutoButton()) {
                str = TroubleshootingDialog.ACTION_TYPE_BLUETOOTH_CONNECTING_FAN;
            } else if (bluetoothDevice.getUseWaterdropAuto()) {
                str = TroubleshootingDialog.ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO_HUMIDITY;
            } else {
                str = TroubleshootingDialog.ACTION_TYPE_BLUETOOTH_CONNECTING_AUTO;
            }
            return newInstance$default(this, str, (Device) null, 2, (Object) null);
        }

        public static /* synthetic */ TroubleshootingDialog newInstance$default(Companion companion, String str, Device device, int i, Object obj) {
            if ((i & 2) != 0) {
                device = null;
            }
            return companion.newInstance(str, device);
        }

        public final TroubleshootingDialog newInstance(String str, Device device) {
            Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            TroubleshootingDialog troubleshootingDialog = new TroubleshootingDialog();
            Bundle bundle = new Bundle();
            bundle.putString("action_type", str);
            bundle.putParcelable("device", device);
            troubleshootingDialog.setArguments(bundle);
            return troubleshootingDialog;
        }

        public final ClickableSpan buildSupportClickableSpan(int i) {
            return new TroubleshootingDialog$Companion$buildSupportClickableSpan$1(i);
        }

        public final ClickableSpan buildLegacyClickableSpan(int i) {
            return new TroubleshootingDialog$Companion$buildLegacyClickableSpan$1(i);
        }
    }
}
