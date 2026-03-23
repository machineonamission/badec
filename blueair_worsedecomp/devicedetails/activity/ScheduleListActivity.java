package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.adapter.ScheduleCardAdapter;
import com.blueair.devicedetails.databinding.ActivityScheduleListBinding;
import com.blueair.devicedetails.dialog.DeleteScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0016\u0010\u001a\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0014\u0010 \u001a\u00020\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/activity/ScheduleListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "schedulesBinding", "Lcom/blueair/devicedetails/databinding/ActivityScheduleListBinding;", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "overviewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "hydrateSchedules", "it", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "showMenuDialog", "showDeleteDialog", "gotoScheduleOverview", "mergedSchedule", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScheduleListActivity.kt */
public final class ScheduleListActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityResultLauncher<Intent> overviewLauncher;
    private ScheduleCardAdapter scheduleAdapter;
    /* access modifiers changed from: private */
    public ActivityScheduleListBinding schedulesBinding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_LIST;
    private final Lazy viewModel$delegate;

    public ScheduleListActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceSchedulesViewModel.class), new ScheduleListActivity$special$$inlined$viewModels$default$2(componentActivity), new ScheduleListActivity$special$$inlined$viewModels$default$1(componentActivity), new ScheduleListActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final DeviceSchedulesViewModel getViewModel() {
        return (DeviceSchedulesViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        ActivityScheduleListBinding activityScheduleListBinding = null;
        Device device = intent != null ? (Device) intent.getParcelableExtra("device") : null;
        if (!(device instanceof Device)) {
            device = null;
        }
        if (device != null) {
            getViewModel().setDevice(device);
            configure();
            ActivityScheduleListBinding activityScheduleListBinding2 = this.schedulesBinding;
            if (activityScheduleListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            } else {
                activityScheduleListBinding = activityScheduleListBinding2;
            }
            activityScheduleListBinding.tvSubtitle.setText(device.getName());
            getViewModel().refreshDeviceSchedule(false);
            ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ScheduleListActivity$$ExternalSyntheticLambda0(this));
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
            this.overviewLauncher = registerForActivityResult;
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(ScheduleListActivity scheduleListActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            scheduleListActivity.getViewModel().refreshDeviceSchedule(false);
        }
    }

    private final void configure() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_schedule_list);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityScheduleListBinding activityScheduleListBinding = (ActivityScheduleListBinding) contentView;
        this.schedulesBinding = activityScheduleListBinding;
        ScheduleCardAdapter scheduleCardAdapter = null;
        if (activityScheduleListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding = null;
        }
        activityScheduleListBinding.btnMore.setEnabled(false);
        ActivityScheduleListBinding activityScheduleListBinding2 = this.schedulesBinding;
        if (activityScheduleListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding2 = null;
        }
        activityScheduleListBinding2.btnBack.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda1(this));
        ActivityScheduleListBinding activityScheduleListBinding3 = this.schedulesBinding;
        if (activityScheduleListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding3 = null;
        }
        activityScheduleListBinding3.btnMore.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda2(this));
        ActivityScheduleListBinding activityScheduleListBinding4 = this.schedulesBinding;
        if (activityScheduleListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding4 = null;
        }
        activityScheduleListBinding4.btnCreate.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda3(this));
        this.scheduleAdapter = new ScheduleCardAdapter(getViewModel().getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat(this), getViewModel().getDevice(), new ScheduleListActivity$$ExternalSyntheticLambda4(this), new ScheduleListActivity$$ExternalSyntheticLambda5(this), new ScheduleListActivity$$ExternalSyntheticLambda6(this));
        ActivityScheduleListBinding activityScheduleListBinding5 = this.schedulesBinding;
        if (activityScheduleListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding5 = null;
        }
        RecyclerView recyclerView = activityScheduleListBinding5.rvList;
        ScheduleCardAdapter scheduleCardAdapter2 = this.scheduleAdapter;
        if (scheduleCardAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
        } else {
            scheduleCardAdapter = scheduleCardAdapter2;
        }
        recyclerView.setAdapter(scheduleCardAdapter);
        recyclerView.addItemDecoration(new SimpleSpacingDecoration(0, (int) TypedValueCompat.dpToPx(-2.0f, getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker) null));
        recyclerView.addOnScrollListener(new ScheduleListActivity$configure$7$1(this));
        getViewModel().getSchedules().observe(this, new ScheduleListActivity$sam$androidx_lifecycle_Observer$0(new ScheduleListActivity$$ExternalSyntheticLambda7(this)));
        getViewModel().refreshDeviceSchedule(true);
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$1(ScheduleListActivity scheduleListActivity, View view) {
        scheduleListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$2(ScheduleListActivity scheduleListActivity, View view) {
        scheduleListActivity.showMenuDialog();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$3(ScheduleListActivity scheduleListActivity, View view) {
        gotoScheduleOverview$default(scheduleListActivity, (DeviceScheduleMerged) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$4(ScheduleListActivity scheduleListActivity) {
        gotoScheduleOverview$default(scheduleListActivity, (DeviceScheduleMerged) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$5(ScheduleListActivity scheduleListActivity, DeviceScheduleMerged deviceScheduleMerged, boolean z) {
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "tappedSchedule");
        Job unused = BuildersKt__Builders_commonKt.launch$default(scheduleListActivity, Dispatchers.getIO(), (CoroutineStart) null, new ScheduleListActivity$configure$5$1(scheduleListActivity, deviceScheduleMerged, z, (Continuation<? super ScheduleListActivity$configure$5$1>) null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$6(ScheduleListActivity scheduleListActivity, DeviceScheduleMerged deviceScheduleMerged) {
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "tappedSchedule");
        scheduleListActivity.gotoScheduleOverview(deviceScheduleMerged);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$8(ScheduleListActivity scheduleListActivity, List list) {
        Intrinsics.checkNotNull(list);
        scheduleListActivity.hydrateSchedules(list);
        return Unit.INSTANCE;
    }

    private final void hydrateSchedules(List<DeviceScheduleMerged> list) {
        ScheduleCardAdapter scheduleCardAdapter = this.scheduleAdapter;
        ActivityScheduleListBinding activityScheduleListBinding = null;
        if (scheduleCardAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
            scheduleCardAdapter = null;
        }
        scheduleCardAdapter.setItems(list);
        ActivityScheduleListBinding activityScheduleListBinding2 = this.schedulesBinding;
        if (activityScheduleListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding2 = null;
        }
        RecyclerView recyclerView = activityScheduleListBinding2.rvList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvList");
        int i = 0;
        ViewExtensionsKt.show$default(recyclerView, false, 1, (Object) null);
        ActivityScheduleListBinding activityScheduleListBinding3 = this.schedulesBinding;
        if (activityScheduleListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding3 = null;
        }
        Collection collection = list;
        activityScheduleListBinding3.btnMore.setEnabled(true ^ collection.isEmpty());
        ActivityScheduleListBinding activityScheduleListBinding4 = this.schedulesBinding;
        if (activityScheduleListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
        } else {
            activityScheduleListBinding = activityScheduleListBinding4;
        }
        LinearLayout linearLayout = activityScheduleListBinding.bottomBar;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bottomBar");
        View view = linearLayout;
        if (collection.isEmpty()) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final void showMenuDialog() {
        CustomDialog show = CustomDialog.show((OnBindView<CustomDialog>) new ScheduleListActivity$showMenuDialog$1(this, R.layout.dialog_schedule_more_action));
        ActivityScheduleListBinding activityScheduleListBinding = this.schedulesBinding;
        if (activityScheduleListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
            activityScheduleListBinding = null;
        }
        show.setAlignBaseViewGravity(activityScheduleListBinding.btnMore, 17);
    }

    /* access modifiers changed from: private */
    public final void showDeleteDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeleteScheduleDialogFragment> cls = DeleteScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeleteScheduleDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeleteScheduleDialogFragment") instanceof DeleteScheduleDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeleteScheduleDialogFragment.Companion.newInstance().show(supportFragmentManager, "DeleteScheduleDialogFragment");
        }
    }

    static /* synthetic */ void gotoScheduleOverview$default(ScheduleListActivity scheduleListActivity, DeviceScheduleMerged deviceScheduleMerged, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceScheduleMerged = null;
        }
        scheduleListActivity.gotoScheduleOverview(deviceScheduleMerged);
    }

    private final void gotoScheduleOverview(DeviceScheduleMerged deviceScheduleMerged) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.overviewLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(ScheduleOverviewActivity.Companion.getLaunchIntent(this, getViewModel().getDevice(), deviceScheduleMerged));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/activity/ScheduleListActivity$Companion;", "", "<init>", "()V", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScheduleListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent intent(Context context, Device device) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            Intent intent = new Intent(context, ScheduleListActivity.class);
            intent.putExtra("device", device);
            return intent;
        }
    }
}
