package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.DevicesAlarmAdapter;
import com.blueair.devicedetails.databinding.ActivityDevicesAlarmListBinding;
import com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/blueair/devicedetails/activity/DevicesAlarmListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDevicesAlarmListBinding;", "devicesAlarmAdapter", "Lcom/blueair/devicedetails/adapter/DevicesAlarmAdapter;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "observeViewModel", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevicesAlarmListActivity.kt */
public final class DevicesAlarmListActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityDevicesAlarmListBinding binding;
    private DevicesAlarmAdapter devicesAlarmAdapter;
    private final String screenName;
    private final Lazy viewModel$delegate;

    public DevicesAlarmListActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceAlarmsViewModel.class), new DevicesAlarmListActivity$special$$inlined$viewModels$default$2(componentActivity), new DevicesAlarmListActivity$special$$inlined$viewModels$default$1(componentActivity), new DevicesAlarmListActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final DeviceAlarmsViewModel getViewModel() {
        return (DeviceAlarmsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        configure();
        observeViewModel();
    }

    private final void configure() {
        ActivityDevicesAlarmListBinding inflate = ActivityDevicesAlarmListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityDevicesAlarmListBinding activityDevicesAlarmListBinding = this.binding;
        if (activityDevicesAlarmListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDevicesAlarmListBinding = null;
        }
        activityDevicesAlarmListBinding.btnBack.setOnClickListener(new DevicesAlarmListActivity$$ExternalSyntheticLambda0(this));
        this.devicesAlarmAdapter = new DevicesAlarmAdapter(new DevicesAlarmListActivity$$ExternalSyntheticLambda1(this), new DevicesAlarmListActivity$$ExternalSyntheticLambda2(this), new DevicesAlarmListActivity$$ExternalSyntheticLambda3(this));
        ActivityDevicesAlarmListBinding activityDevicesAlarmListBinding2 = this.binding;
        if (activityDevicesAlarmListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDevicesAlarmListBinding2 = null;
        }
        RecyclerView recyclerView = activityDevicesAlarmListBinding2.rvList;
        DevicesAlarmAdapter devicesAlarmAdapter2 = this.devicesAlarmAdapter;
        if (devicesAlarmAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
            devicesAlarmAdapter2 = null;
        }
        recyclerView.setAdapter(devicesAlarmAdapter2);
        recyclerView.addItemDecoration(new SimpleSpacingDecoration(0, (int) TypedValueCompat.dpToPx(28.0f, getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker) null));
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        getViewModel().refreshDeviceAlarms();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$0(DevicesAlarmListActivity devicesAlarmListActivity, View view) {
        devicesAlarmListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$1(DevicesAlarmListActivity devicesAlarmListActivity, HasAlarm hasAlarm, DeviceAlarm deviceAlarm, boolean z) {
        Intrinsics.checkNotNullParameter(hasAlarm, "hasAlarm");
        Intrinsics.checkNotNullParameter(deviceAlarm, "deviceAlarm");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(devicesAlarmListActivity), Dispatchers.getIO(), (CoroutineStart) null, new DevicesAlarmListActivity$configure$2$1(devicesAlarmListActivity, hasAlarm, deviceAlarm, z, (Continuation<? super DevicesAlarmListActivity$configure$2$1>) null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$3(DevicesAlarmListActivity devicesAlarmListActivity, HasAlarm hasAlarm) {
        Intrinsics.checkNotNullParameter(hasAlarm, "it");
        FragmentManager supportFragmentManager = devicesAlarmListActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !supportFragmentManager.isStateSaved()) {
            TroubleshootingDialog.Companion.newInstance(TroubleshootingDialog.ACTION_TYPE_DEVICE_OFFLINE, hasAlarm).show(supportFragmentManager, TroubleshootingDialog.REQUEST_KEY);
            supportFragmentManager.executePendingTransactions();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$5(DevicesAlarmListActivity devicesAlarmListActivity, HasAlarm hasAlarm, View view) {
        Intrinsics.checkNotNullParameter(hasAlarm, "hasAlarm");
        Intrinsics.checkNotNullParameter(view, "anchorView");
        FragmentManager supportFragmentManager = devicesAlarmListActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeleteAlarmDialogFragment> cls = DeleteAlarmDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeleteAlarmDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeleteAlarmDialogFragment") instanceof DeleteAlarmDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeleteAlarmDialogFragment.Companion.newInstance(hasAlarm, false, view).show(supportFragmentManager, "DeleteAlarmDialogFragment");
        }
        return Unit.INSTANCE;
    }

    private final void observeViewModel() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getLvDeviceAlarms().observe(lifecycleOwner, new DevicesAlarmListActivity$sam$androidx_lifecycle_Observer$0(new DevicesAlarmListActivity$$ExternalSyntheticLambda4(this)));
        LiveDataExtensionsKt.observeNonNull(getViewModel().getNetworkAvailable(), lifecycleOwner, new DevicesAlarmListActivity$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$7(DevicesAlarmListActivity devicesAlarmListActivity, List list) {
        DevicesAlarmAdapter devicesAlarmAdapter2 = devicesAlarmListActivity.devicesAlarmAdapter;
        if (devicesAlarmAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
            devicesAlarmAdapter2 = null;
        }
        Intrinsics.checkNotNull(list);
        devicesAlarmAdapter2.setItems(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$8(DevicesAlarmListActivity devicesAlarmListActivity, boolean z) {
        DevicesAlarmAdapter devicesAlarmAdapter2 = devicesAlarmListActivity.devicesAlarmAdapter;
        if (devicesAlarmAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
            devicesAlarmAdapter2 = null;
        }
        devicesAlarmAdapter2.setForceOffline(!z);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/activity/DevicesAlarmListActivity$Companion;", "", "<init>", "()V", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DevicesAlarmListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent intent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, DevicesAlarmListActivity.class);
        }
    }
}
