package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.AlarmCardAdapter;
import com.blueair.devicedetails.databinding.ActivityAlarmListBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/activity/AlarmListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityAlarmListBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmCardAdapter;", "device", "Lcom/blueair/core/model/HasAlarm;", "getDevice", "()Lcom/blueair/core/model/HasAlarm;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "createNewAlarm", "showMenuDialog", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmListActivity.kt */
public final class AlarmListActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private AlarmCardAdapter adapter;
    private ActivityAlarmListBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_ALARM_LIST;
    private final DeviceDetailsViewModel viewModel;

    public AlarmListActivity() {
        BaseActivity baseActivity = this;
        this.viewModel = (DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/activity/AlarmListActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AlarmListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, AlarmListActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final HasAlarm getDevice() {
        Device device = this.viewModel.getDevice();
        Intrinsics.checkNotNull(device, "null cannot be cast to non-null type com.blueair.core.model.HasAlarm");
        return (HasAlarm) device;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityAlarmListBinding activityAlarmListBinding = null;
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        ActivityAlarmListBinding inflate = ActivityAlarmListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAlarmListBinding = inflate;
        }
        setContentView((View) activityAlarmListBinding.getRoot());
        configure();
    }

    private final void configure() {
        ActivityAlarmListBinding activityAlarmListBinding = this.binding;
        AlarmCardAdapter alarmCardAdapter = null;
        if (activityAlarmListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmListBinding = null;
        }
        AppCompatTextView appCompatTextView = activityAlarmListBinding.tvSubtitle;
        Device device = this.viewModel.getDevice();
        appCompatTextView.setText(device != null ? device.getName() : null);
        activityAlarmListBinding.epBtnBack.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda0(this));
        activityAlarmListBinding.epBtnClose.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda1(this));
        activityAlarmListBinding.epBtnCreate.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda2(this));
        activityAlarmListBinding.btnBack.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda3(this));
        activityAlarmListBinding.btnMore.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda4(this));
        activityAlarmListBinding.btnCreate.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda5(this));
        this.adapter = new AlarmCardAdapter(getColor(R.color.colorPrimaryText), new AlarmListActivity$$ExternalSyntheticLambda6(this), new AlarmListActivity$$ExternalSyntheticLambda7(this));
        RecyclerView recyclerView = activityAlarmListBinding.rvList;
        AlarmCardAdapter alarmCardAdapter2 = this.adapter;
        if (alarmCardAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            alarmCardAdapter = alarmCardAdapter2;
        }
        recyclerView.setAdapter(alarmCardAdapter);
        this.viewModel.getLiveDevice().observe(this, new AlarmListActivity$sam$androidx_lifecycle_Observer$0(new AlarmListActivity$$ExternalSyntheticLambda8(this, activityAlarmListBinding)));
        activityAlarmListBinding.rvList.addOnScrollListener(new AlarmListActivity$configure$1$10(activityAlarmListBinding));
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$0(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$1(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$2(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.createNewAlarm();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$3(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$4(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.showMenuDialog();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$5(AlarmListActivity alarmListActivity, View view) {
        alarmListActivity.createNewAlarm();
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$11$lambda$6(AlarmListActivity alarmListActivity, DeviceAlarm deviceAlarm, boolean z) {
        Intrinsics.checkNotNullParameter(deviceAlarm, NotificationCompat.CATEGORY_ALARM);
        int indexOf = alarmListActivity.getDevice().getAlarms().indexOf(deviceAlarm);
        if (indexOf < 0) {
            return Unit.INSTANCE;
        }
        int i = indexOf;
        DeviceDetailsViewModel.setAlarm$default(alarmListActivity.viewModel, alarmListActivity.getDevice(), i + 1, DeviceAlarm.copy$default(deviceAlarm, (String) null, z, 0, false, 0, 0, 0, 0, 253, (Object) null), (Function2) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$11$lambda$7(AlarmListActivity alarmListActivity, DeviceAlarm deviceAlarm) {
        Intrinsics.checkNotNullParameter(deviceAlarm, NotificationCompat.CATEGORY_ALARM);
        int indexOf = alarmListActivity.getDevice().getAlarms().indexOf(deviceAlarm);
        if (indexOf < 0) {
            return Unit.INSTANCE;
        }
        AlarmEditActivity.Companion.launch(alarmListActivity, alarmListActivity.getDevice(), indexOf);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$11$lambda$10(AlarmListActivity alarmListActivity, ActivityAlarmListBinding activityAlarmListBinding, Device device) {
        alarmListActivity.viewModel.setDevice(device);
        AlarmCardAdapter alarmCardAdapter = alarmListActivity.adapter;
        if (alarmCardAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            alarmCardAdapter = null;
        }
        boolean z = false;
        alarmCardAdapter.setData(CollectionsKt.sortedWith(CollectionsKt.filterNotNull(alarmListActivity.getDevice().getAlarms()), new AlarmListActivity$configure$lambda$11$lambda$10$$inlined$sortedBy$1()), false);
        Iterable alarms = alarmListActivity.getDevice().getAlarms();
        if (!(alarms instanceof Collection) || !((Collection) alarms).isEmpty()) {
            Iterator it = alarms.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((DeviceAlarm) it.next()) != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            ConstraintLayout constraintLayout = activityAlarmListBinding.emptyContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "emptyContainer");
            ViewExtensionsKt.show(constraintLayout, z);
            alarmListActivity.setStatusMode(!z);
            return Unit.INSTANCE;
        }
        z = true;
        ConstraintLayout constraintLayout2 = activityAlarmListBinding.emptyContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "emptyContainer");
        ViewExtensionsKt.show(constraintLayout2, z);
        alarmListActivity.setStatusMode(!z);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void createNewAlarm() {
        Iterable<DeviceAlarm> alarms = getDevice().getAlarms();
        int i = 0;
        if (!(alarms instanceof Collection) || !((Collection) alarms).isEmpty()) {
            int i2 = 0;
            for (DeviceAlarm deviceAlarm : alarms) {
                if ((deviceAlarm != null) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = i2;
        }
        if (i >= 5) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.alarm_full_title, (Integer) null, R.string.alarm_full_desc, Integer.valueOf(R.string.button_got_it), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
                return;
            }
            return;
        }
        int indexOf = getDevice().getAlarms().indexOf((Object) null);
        if (indexOf >= 0) {
            AlarmEditActivity.Companion.launch(this, getDevice(), indexOf);
        }
    }

    private final void showMenuDialog() {
        CustomDialog show = CustomDialog.show((OnBindView<CustomDialog>) new AlarmListActivity$showMenuDialog$1(this, com.blueair.devicedetails.R.layout.dialog_alarm_more_action));
        ActivityAlarmListBinding activityAlarmListBinding = this.binding;
        if (activityAlarmListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmListBinding = null;
        }
        show.setAlignBaseViewGravity(activityAlarmListBinding.btnMore, 17);
    }
}
