package com.blueair.antifake.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.antifake.databinding.ActivityResetBinding;
import com.blueair.antifake.viewmodel.AntiFakePage;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.bluetooth.utils.BluetoothConnectivityBroadcastReceiver;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0014J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/blueair/antifake/activity/ResetActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/antifake/databinding/ActivityResetBinding;", "networkBroadcastReceiver", "Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "getNetworkBroadcastReceiver", "()Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "networkBroadcastReceiver$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "setPage", "page", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ResetActivity.kt */
public final class ResetActivity extends BaseActivity {
    private static final String CODE = "CODE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityResetBinding binding;
    private final Lazy networkBroadcastReceiver$delegate;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ANTIFAKE_RESET;
    private final Lazy viewModel$delegate;

    public ResetActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AntiFakeViewModel.class), new ResetActivity$special$$inlined$viewModels$default$2(componentActivity), new ResetActivity$special$$inlined$viewModels$default$1(componentActivity), new ResetActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.networkBroadcastReceiver$delegate = LazyKt.lazy(new ResetActivity$$ExternalSyntheticLambda0(this));
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/antifake/activity/ResetActivity$Companion;", "", "<init>", "()V", "CODE", "", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "code", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ResetActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, HasSKU hasSKU, DeviceFilterType deviceFilterType, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "code");
            context.startActivity(new Intent(context, ResetActivity.class).putExtra("device", hasSKU).putExtra(Actions.EXTRA_FILTER_TYPE, deviceFilterType != null ? deviceFilterType.name() : null).putExtra(ResetActivity.CODE, str));
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final AntiFakeViewModel getViewModel() {
        return (AntiFakeViewModel) this.viewModel$delegate.getValue();
    }

    private final BluetoothConnectivityBroadcastReceiver getNetworkBroadcastReceiver() {
        return (BluetoothConnectivityBroadcastReceiver) this.networkBroadcastReceiver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BluetoothConnectivityBroadcastReceiver networkBroadcastReceiver_delegate$lambda$0(ResetActivity resetActivity) {
        resetActivity.getViewModel().getBtConnectivityService().updateBluetoothConnectivityState(BluetoothUtils.INSTANCE.isBluetoothEnabled(resetActivity));
        return new BluetoothConnectivityBroadcastReceiver(resetActivity.getViewModel().getBtConnectivityService());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        ActivityResetBinding inflate = ActivityResetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        DeviceFilterType deviceFilterType = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        ActivityResetBinding activityResetBinding = this.binding;
        if (activityResetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityResetBinding = null;
        }
        activityResetBinding.btnClose.setOnClickListener(new ResetActivity$$ExternalSyntheticLambda1(this));
        ActivityResetBinding activityResetBinding2 = this.binding;
        if (activityResetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityResetBinding2 = null;
        }
        activityResetBinding2.btnBack.setOnClickListener(new ResetActivity$$ExternalSyntheticLambda2(this));
        HasSKU hasSKU = (HasSKU) getIntent().getParcelableExtra("device");
        String stringExtra = getIntent().getStringExtra(Actions.EXTRA_FILTER_TYPE);
        if (stringExtra != null) {
            deviceFilterType = DeviceFilterType.valueOf(stringExtra);
        }
        getViewModel().init(hasSKU, deviceFilterType);
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        LifecycleOwner lifecycleOwner = this;
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, lifecycleOwner, false, new ResetActivity$$ExternalSyntheticLambda3(this), 2, (Object) null);
        getViewModel().getCurrentPage().observe(lifecycleOwner, new ResetActivity$sam$androidx_lifecycle_Observer$0(new ResetActivity$$ExternalSyntheticLambda4(this)));
        AntiFakeViewModel viewModel = getViewModel();
        Bundle extras = getIntent().getExtras();
        if (extras == null || (str = extras.getString(CODE)) == null) {
            str = "";
        }
        viewModel.validateCode(str);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ResetActivity resetActivity, View view) {
        if ((resetActivity.getViewModel().getCurrentPage().getValue() instanceof AntiFakePage.ResetByWifi) || (resetActivity.getViewModel().getCurrentPage().getValue() instanceof AntiFakePage.ResetByBluetooth)) {
            resetActivity.getOnBackPressedDispatcher().onBackPressed();
        } else {
            resetActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(ResetActivity resetActivity, View view) {
        resetActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$4(ResetActivity resetActivity, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        if (!resetActivity.getViewModel().goBack()) {
            resetActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(ResetActivity resetActivity, AntiFakePage antiFakePage) {
        resetActivity.setPage(antiFakePage);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        registerReceiver(getNetworkBroadcastReceiver(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        unregisterReceiver(getNetworkBroadcastReceiver());
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setPage(com.blueair.antifake.viewmodel.AntiFakePage r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            java.lang.String r1 = "binding"
            r2 = 0
            if (r0 != 0) goto L_0x000e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000e:
            androidx.appcompat.widget.AppCompatImageView r0 = r0.btnBack
            java.lang.String r3 = "btnBack"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.view.View r0 = (android.view.View) r0
            boolean r3 = r12.getBackBtnEnabled()
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r0, r3)
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0026:
            androidx.appcompat.widget.AppCompatImageView r0 = r0.btnClose
            java.lang.String r3 = "btnClose"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.view.View r0 = (android.view.View) r0
            boolean r3 = r12.getCloseBtnEnabled()
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r0, r3)
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x003e:
            android.widget.TextView r0 = r0.title
            int r3 = r12.getTitle()
            r0.setText(r3)
            int r0 = r12.getHeader()
            r3 = 2
            java.lang.String r4 = "headerBar"
            r5 = 0
            r6 = 1
            if (r0 != 0) goto L_0x0066
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x005a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x005a:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.headerBar
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            android.view.View r0 = (android.view.View) r0
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r0)
            goto L_0x00ed
        L_0x0066:
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x006e:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.headerBar
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            android.view.View r0 = (android.view.View) r0
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r0, r5, r6, r2)
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x0080
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0080:
            android.widget.TextView r0 = r0.headerTitle
            int r4 = r12.getHeader()
            r0.setText(r4)
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x0091
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0091:
            com.google.android.material.progressindicator.LinearProgressIndicator r0 = r0.headerProgress
            int r4 = r12.getStep()
            r0.setProgress(r4)
            com.blueair.antifake.databinding.ActivityResetBinding r0 = r11.binding
            if (r0 != 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x00a2:
            android.widget.TextView r0 = r0.step1
            com.blueair.antifake.databinding.ActivityResetBinding r4 = r11.binding
            if (r4 != 0) goto L_0x00ac
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r4 = r2
        L_0x00ac:
            android.widget.TextView r4 = r4.step2
            com.blueair.antifake.databinding.ActivityResetBinding r7 = r11.binding
            if (r7 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x00b6:
            android.widget.TextView r7 = r7.step3
            r8 = 3
            android.widget.TextView[] r8 = new android.widget.TextView[r8]
            r8[r5] = r0
            r8[r6] = r4
            r8[r3] = r7
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r8)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r4 = r5
        L_0x00cc:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00ed
            java.lang.Object r7 = r0.next()
            int r8 = r4 + 1
            if (r4 >= 0) goto L_0x00dd
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00dd:
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r9 = r12.getStep()
            if (r4 > r9) goto L_0x00e7
            r4 = r6
            goto L_0x00e8
        L_0x00e7:
            r4 = r5
        L_0x00e8:
            r7.setEnabled(r4)
            r4 = r8
            goto L_0x00cc
        L_0x00ed:
            com.blueair.antifake.viewmodel.AntiFakePage$CodeVerifying r0 = com.blueair.antifake.viewmodel.AntiFakePage.CodeVerifying.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00ff
            com.blueair.antifake.fragmnet.ScanVerifyingFragment$Companion r0 = com.blueair.antifake.fragmnet.ScanVerifyingFragment.Companion
            com.blueair.antifake.fragmnet.ScanVerifyingFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
        L_0x00fd:
            r4 = r6
            goto L_0x0145
        L_0x00ff:
            boolean r0 = r12 instanceof com.blueair.antifake.viewmodel.AntiFakePage.CodeVerifyResult
            if (r0 == 0) goto L_0x010c
            com.blueair.antifake.fragmnet.ScanResultFragment$Companion r0 = com.blueair.antifake.fragmnet.ScanResultFragment.Companion
            com.blueair.antifake.fragmnet.ScanResultFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x00fd
        L_0x010c:
            com.blueair.antifake.viewmodel.AntiFakePage$SelectDevice r0 = com.blueair.antifake.viewmodel.AntiFakePage.SelectDevice.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x011e
            com.blueair.antifake.fragmnet.SearchDeviceFragment$Companion r0 = com.blueair.antifake.fragmnet.SearchDeviceFragment.Companion
            com.blueair.antifake.fragmnet.SearchDeviceFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
        L_0x011c:
            r4 = r5
            goto L_0x0145
        L_0x011e:
            boolean r0 = r12 instanceof com.blueair.antifake.viewmodel.AntiFakePage.ScanBluetooth
            if (r0 == 0) goto L_0x012b
            com.blueair.antifake.fragmnet.ScanDeviceFragment$Companion r0 = com.blueair.antifake.fragmnet.ScanDeviceFragment.Companion
            com.blueair.antifake.fragmnet.ScanDeviceFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x011c
        L_0x012b:
            boolean r0 = r12 instanceof com.blueair.antifake.viewmodel.AntiFakePage.ResetByWifi
            if (r0 == 0) goto L_0x0138
            com.blueair.antifake.fragmnet.ResetFilterFragment$Companion r0 = com.blueair.antifake.fragmnet.ResetFilterFragment.Companion
            com.blueair.antifake.fragmnet.ResetFilterFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x00fd
        L_0x0138:
            boolean r0 = r12 instanceof com.blueair.antifake.viewmodel.AntiFakePage.ResetByBluetooth
            if (r0 == 0) goto L_0x01d0
            com.blueair.antifake.fragmnet.ResetFilterFragment$Companion r0 = com.blueair.antifake.fragmnet.ResetFilterFragment.Companion
            com.blueair.antifake.fragmnet.ResetFilterFragment r0 = r0.newInstance()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            goto L_0x011c
        L_0x0145:
            com.blueair.core.service.AnalyticsService r7 = r11.getAnalytics()
            com.blueair.core.model.AnalyticEvent$ScreenViewEvent r8 = new com.blueair.core.model.AnalyticEvent$ScreenViewEvent
            java.lang.String r12 = r12.getScreenName()
            java.lang.Class r9 = r0.getClass()
            java.lang.String r9 = r9.getSimpleName()
            java.lang.String r10 = "getSimpleName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r8.<init>(r12, r9)
            com.blueair.core.model.AnalyticEvent r8 = (com.blueair.core.model.AnalyticEvent) r8
            r7.event(r8)
            androidx.fragment.app.FragmentManager r12 = r11.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r12 = r12.beginTransaction()
            com.blueair.antifake.databinding.ActivityResetBinding r7 = r11.binding
            if (r7 != 0) goto L_0x0174
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x0174:
            android.widget.FrameLayout r7 = r7.containerFragment
            int r7 = r7.getId()
            androidx.fragment.app.FragmentTransaction r12 = r12.replace(r7, r0)
            r12.commit()
            com.blueair.antifake.viewmodel.AntiFakeViewModel r12 = r11.getViewModel()
            com.blueair.core.model.HasSKU r12 = r12.getDevice()
            java.lang.String r0 = "step3"
            if (r12 == 0) goto L_0x01b0
            if (r4 == 0) goto L_0x01b0
            com.blueair.antifake.databinding.ActivityResetBinding r12 = r11.binding
            if (r12 != 0) goto L_0x0197
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r12 = r2
        L_0x0197:
            com.google.android.material.progressindicator.LinearProgressIndicator r12 = r12.headerProgress
            r12.setMax(r6)
            com.blueair.antifake.databinding.ActivityResetBinding r12 = r11.binding
            if (r12 != 0) goto L_0x01a4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x01a5
        L_0x01a4:
            r2 = r12
        L_0x01a5:
            android.widget.TextView r12 = r2.step3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r12)
            return
        L_0x01b0:
            com.blueair.antifake.databinding.ActivityResetBinding r12 = r11.binding
            if (r12 != 0) goto L_0x01b8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r12 = r2
        L_0x01b8:
            com.google.android.material.progressindicator.LinearProgressIndicator r12 = r12.headerProgress
            r12.setMax(r3)
            com.blueair.antifake.databinding.ActivityResetBinding r12 = r11.binding
            if (r12 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r12 = r2
        L_0x01c5:
            android.widget.TextView r12 = r12.step3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r12, r5, r6, r2)
            return
        L_0x01d0:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.activity.ResetActivity.setPage(com.blueair.antifake.viewmodel.AntiFakePage):void");
    }
}
