package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding;
import com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment;
import com.blueair.devicedetails.dialog.TimePickerV2DialogFragment;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, d2 = {"Lcom/blueair/devicedetails/activity/ScheduleOverviewActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "repeatCheckBoxes", "", "Landroid/widget/CheckBox;", "[Landroid/widget/CheckBox;", "dayOfWeekCheckBoxList", "", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceScheduleOverviewBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "configureView", "shouldShowMainMode", "", "parseTimePickerResult", "Ljava/util/Calendar;", "result", "updateTimeViews", "updateRepeatDaysText", "getPurifyModeIcon", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getMainModeIcon", "mainMode", "Lcom/blueair/core/model/MainMode;", "humMode", "showProgress", "hideProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScheduleOverviewActivity.kt */
public final class ScheduleOverviewActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityDeviceScheduleOverviewBinding binding;
    private List<? extends CheckBox> dayOfWeekCheckBoxList;
    private Device device;
    private CheckBox[] repeatCheckBoxes;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_DETAILS;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScheduleOverviewActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0057 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        static {
            /*
                com.blueair.core.model.DayOfWeek[] r0 = com.blueair.core.model.DayOfWeek.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.DayOfWeek r2 = com.blueair.core.model.DayOfWeek.MON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.DayOfWeek r3 = com.blueair.core.model.DayOfWeek.TUE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.core.model.DayOfWeek r4 = com.blueair.core.model.DayOfWeek.WED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.blueair.core.model.DayOfWeek r5 = com.blueair.core.model.DayOfWeek.THU     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.blueair.core.model.DayOfWeek r6 = com.blueair.core.model.DayOfWeek.FRI     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.DayOfWeek r6 = com.blueair.core.model.DayOfWeek.SAT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.DayOfWeek r6 = com.blueair.core.model.DayOfWeek.SUN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r7 = 7
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x0057 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.Dehumidification     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.Humidification     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.activity.ScheduleOverviewActivity.WhenMappings.<clinit>():void");
        }
    }

    public ScheduleOverviewActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceCreateEditScheduleViewModel.class), new ScheduleOverviewActivity$special$$inlined$viewModels$default$2(componentActivity), new ScheduleOverviewActivity$special$$inlined$viewModels$default$1(componentActivity), new ScheduleOverviewActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/activity/ScheduleOverviewActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScheduleOverviewActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, Device device, DeviceScheduleMerged deviceScheduleMerged, int i, Object obj) {
            if ((i & 4) != 0) {
                deviceScheduleMerged = null;
            }
            return companion.getLaunchIntent(context, device, deviceScheduleMerged);
        }

        public final Intent getLaunchIntent(Context context, Device device, DeviceScheduleMerged deviceScheduleMerged) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            Intent intent = new Intent(context, ScheduleOverviewActivity.class);
            intent.putExtra("device", device);
            intent.putExtra(Actions.EXTRA_SCHEDULE_MERGED, deviceScheduleMerged);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final DeviceCreateEditScheduleViewModel getViewModel() {
        return (DeviceCreateEditScheduleViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(onCreateView());
        configureView();
    }

    public final View onCreateView() {
        getViewModel().initTimeFormat(this);
        Intent intent = getIntent();
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = null;
        Device device2 = intent != null ? (Device) intent.getParcelableExtra("device") : null;
        if (device2 != null) {
            this.device = device2;
            DeviceCreateEditScheduleViewModel viewModel = getViewModel();
            Device device3 = this.device;
            if (device3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device3 = null;
            }
            viewModel.setDevice(device3);
            DeviceCreateEditScheduleViewModel viewModel2 = getViewModel();
            Intent intent2 = getIntent();
            viewModel2.setEditingSchedule(intent2 != null ? (DeviceScheduleMerged) intent2.getParcelableExtra(Actions.EXTRA_SCHEDULE_MERGED) : null);
            ActivityDeviceScheduleOverviewBinding inflate = ActivityDeviceScheduleOverviewBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            setContentView((View) inflate.getRoot());
            ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding2 = this.binding;
            if (activityDeviceScheduleOverviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceScheduleOverviewBinding2 = null;
            }
            CheckBox checkBox = activityDeviceScheduleOverviewBinding2.cbEveryday;
            Intrinsics.checkNotNullExpressionValue(checkBox, "cbEveryday");
            ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding3 = this.binding;
            if (activityDeviceScheduleOverviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceScheduleOverviewBinding3 = null;
            }
            CheckBox checkBox2 = activityDeviceScheduleOverviewBinding3.cbWeekdays;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "cbWeekdays");
            ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding4 = this.binding;
            if (activityDeviceScheduleOverviewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceScheduleOverviewBinding4 = null;
            }
            CheckBox checkBox3 = activityDeviceScheduleOverviewBinding4.cbWeekends;
            Intrinsics.checkNotNullExpressionValue(checkBox3, "cbWeekends");
            this.repeatCheckBoxes = new CheckBox[]{checkBox, checkBox2, checkBox3};
            ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding5 = this.binding;
            if (activityDeviceScheduleOverviewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceScheduleOverviewBinding = activityDeviceScheduleOverviewBinding5;
            }
            ConstraintLayout root = activityDeviceScheduleOverviewBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void configureView() {
        CheckBox checkBox;
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = this.binding;
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding2 = null;
        if (activityDeviceScheduleOverviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding = null;
        }
        activityDeviceScheduleOverviewBinding.backBtn.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda0(this));
        activityDeviceScheduleOverviewBinding.btnSaveChange.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda2(this, activityDeviceScheduleOverviewBinding));
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getSaveBtnEnabled().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda7(activityDeviceScheduleOverviewBinding)));
        activityDeviceScheduleOverviewBinding.scheduleName.setText(getViewModel().getDisplayLabel());
        updateTimeViews();
        getViewModel().isStartTimeSameAsEndTime().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda8(this)));
        ViewCompat.setAccessibilityDelegate(activityDeviceScheduleOverviewBinding.startTimeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_start_time_content_description));
        activityDeviceScheduleOverviewBinding.startTimeGroup.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda9(this));
        ViewCompat.setAccessibilityDelegate(activityDeviceScheduleOverviewBinding.endTimeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_end_time_content_description));
        activityDeviceScheduleOverviewBinding.endTimeGroup.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda10(this));
        for (DayOfWeek ordinal : getViewModel().getRepeat()) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal.ordinal()]) {
                case 1:
                    checkBox = activityDeviceScheduleOverviewBinding.cbMon;
                    break;
                case 2:
                    checkBox = activityDeviceScheduleOverviewBinding.cbTue;
                    break;
                case 3:
                    checkBox = activityDeviceScheduleOverviewBinding.cbWed;
                    break;
                case 4:
                    checkBox = activityDeviceScheduleOverviewBinding.cbThu;
                    break;
                case 5:
                    checkBox = activityDeviceScheduleOverviewBinding.cbFri;
                    break;
                case 6:
                    checkBox = activityDeviceScheduleOverviewBinding.cbSat;
                    break;
                case 7:
                    checkBox = activityDeviceScheduleOverviewBinding.cbSun;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNull(checkBox);
            checkBox.setChecked(true);
        }
        updateRepeatDaysText();
        CheckBox checkBox2 = activityDeviceScheduleOverviewBinding.cbMon;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "cbMon");
        CheckBox checkBox3 = activityDeviceScheduleOverviewBinding.cbTue;
        Intrinsics.checkNotNullExpressionValue(checkBox3, "cbTue");
        CheckBox checkBox4 = activityDeviceScheduleOverviewBinding.cbWed;
        Intrinsics.checkNotNullExpressionValue(checkBox4, "cbWed");
        CheckBox checkBox5 = activityDeviceScheduleOverviewBinding.cbThu;
        Intrinsics.checkNotNullExpressionValue(checkBox5, "cbThu");
        CheckBox checkBox6 = activityDeviceScheduleOverviewBinding.cbFri;
        Intrinsics.checkNotNullExpressionValue(checkBox6, "cbFri");
        CheckBox checkBox7 = activityDeviceScheduleOverviewBinding.cbSat;
        Intrinsics.checkNotNullExpressionValue(checkBox7, "cbSat");
        CheckBox checkBox8 = activityDeviceScheduleOverviewBinding.cbSun;
        Intrinsics.checkNotNullExpressionValue(checkBox8, "cbSun");
        List<? extends CheckBox> listOf = CollectionsKt.listOf(checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8);
        this.dayOfWeekCheckBoxList = listOf;
        if (listOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
            listOf = null;
        }
        for (CheckBox onClickListener : listOf) {
            onClickListener.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda12(activityDeviceScheduleOverviewBinding, this));
        }
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding3 = this.binding;
        if (activityDeviceScheduleOverviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding3 = null;
        }
        activityDeviceScheduleOverviewBinding3.cbEveryday.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda13(this));
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding4 = this.binding;
        if (activityDeviceScheduleOverviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding4 = null;
        }
        activityDeviceScheduleOverviewBinding4.cbWeekdays.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda14(this, activityDeviceScheduleOverviewBinding));
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding5 = this.binding;
        if (activityDeviceScheduleOverviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding5 = null;
        }
        activityDeviceScheduleOverviewBinding5.cbWeekends.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda15(this, activityDeviceScheduleOverviewBinding));
        getViewModel().getLiveMainMode().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda11(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getLivePurifierMode().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda19(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getLiveStartFanSpeed().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda20(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getScheduleEndType().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda21(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getLiveScheduleEndCustomMainMode().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda22(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getLiveScheduleEndCustomMode().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda23(this, activityDeviceScheduleOverviewBinding)));
        getViewModel().getLiveScheduleEndCustomFanSpeed().observe(lifecycleOwner, new ScheduleOverviewActivity$sam$androidx_lifecycle_Observer$0(new ScheduleOverviewActivity$$ExternalSyntheticLambda24(this, activityDeviceScheduleOverviewBinding)));
        activityDeviceScheduleOverviewBinding.settingsStart.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda25(this));
        activityDeviceScheduleOverviewBinding.settingsEnd.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda26(this));
        activityDeviceScheduleOverviewBinding.btnCancel.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda1(this));
        if (getViewModel().getState() == DeviceCreateEditScheduleViewModel.State.NEW) {
            ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding6 = this.binding;
            if (activityDeviceScheduleOverviewBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceScheduleOverviewBinding2 = activityDeviceScheduleOverviewBinding6;
            }
            activityDeviceScheduleOverviewBinding2.title.setText(getString(R.string.create_schedule));
        }
        activityDeviceScheduleOverviewBinding.scrollView.setOnScrollChangeListener(new ScheduleOverviewActivity$configureView$1$22(activityDeviceScheduleOverviewBinding));
        String string = getString(R.string.button_role);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ShadowLayout shadowLayout = activityDeviceScheduleOverviewBinding.startTimeGroup;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "startTimeGroup");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, shadowLayout, (KClass) null, string, new ScheduleOverviewActivity$$ExternalSyntheticLambda3(activityDeviceScheduleOverviewBinding), 2, (Object) null);
        ViewUtils viewUtils2 = ViewUtils.INSTANCE;
        ShadowLayout shadowLayout2 = activityDeviceScheduleOverviewBinding.endTimeGroup;
        Intrinsics.checkNotNullExpressionValue(shadowLayout2, "endTimeGroup");
        ViewUtils.setAccessibilityDelegate$default(viewUtils2, shadowLayout2, (KClass) null, string, new ScheduleOverviewActivity$$ExternalSyntheticLambda4(activityDeviceScheduleOverviewBinding), 2, (Object) null);
        ViewUtils viewUtils3 = ViewUtils.INSTANCE;
        ShadowLayout shadowLayout3 = activityDeviceScheduleOverviewBinding.settingsStart;
        Intrinsics.checkNotNullExpressionValue(shadowLayout3, "settingsStart");
        ViewUtils.setAccessibilityDelegate$default(viewUtils3, shadowLayout3, (KClass) null, string, (Function2) null, 10, (Object) null);
        ViewUtils viewUtils4 = ViewUtils.INSTANCE;
        ShadowLayout shadowLayout4 = activityDeviceScheduleOverviewBinding.settingsEnd;
        Intrinsics.checkNotNullExpressionValue(shadowLayout4, "settingsEnd");
        ViewUtils.setAccessibilityDelegate$default(viewUtils4, shadowLayout4, (KClass) null, string, new ScheduleOverviewActivity$$ExternalSyntheticLambda5(activityDeviceScheduleOverviewBinding), 2, (Object) null);
        ScheduleOverviewActivity$$ExternalSyntheticLambda6 scheduleOverviewActivity$$ExternalSyntheticLambda6 = new ScheduleOverviewActivity$$ExternalSyntheticLambda6();
        activityDeviceScheduleOverviewBinding.startTimeGroup.setOnFocusChangeListener(scheduleOverviewActivity$$ExternalSyntheticLambda6);
        activityDeviceScheduleOverviewBinding.endTimeGroup.setOnFocusChangeListener(scheduleOverviewActivity$$ExternalSyntheticLambda6);
        activityDeviceScheduleOverviewBinding.settingsStart.setOnFocusChangeListener(scheduleOverviewActivity$$ExternalSyntheticLambda6);
        activityDeviceScheduleOverviewBinding.settingsEnd.setOnFocusChangeListener(scheduleOverviewActivity$$ExternalSyntheticLambda6);
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$0(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        scheduleOverviewActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$3(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view) {
        scheduleOverviewActivity.showProgress();
        scheduleOverviewActivity.getViewModel().setLabel(String.valueOf(activityDeviceScheduleOverviewBinding.scheduleName.getText()));
        scheduleOverviewActivity.getViewModel().onComplete(new ScheduleOverviewActivity$$ExternalSyntheticLambda17(scheduleOverviewActivity));
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$3$lambda$2(ScheduleOverviewActivity scheduleOverviewActivity, boolean z, boolean z2) {
        scheduleOverviewActivity.hideProgress();
        if (z) {
            FragmentManager supportFragmentManager = scheduleOverviewActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !supportFragmentManager.isStateSaved()) {
                ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.overlap_title), Integer.valueOf(R.string.overlap_content), R.string.btn_cancel, (Integer) null, false, false, false, (String[]) null, 240, (Object) null).show(supportFragmentManager, "ConfirmationDialogCentered");
            }
        } else if (z2) {
            scheduleOverviewActivity.setResult(-1);
            scheduleOverviewActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$4(ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, Boolean bool) {
        MaterialButton materialButton = activityDeviceScheduleOverviewBinding.btnSaveChange;
        Intrinsics.checkNotNull(bool);
        materialButton.setEnabled(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$5(ScheduleOverviewActivity scheduleOverviewActivity, Boolean bool) {
        int i;
        if (bool.booleanValue()) {
            i = R.drawable.rounded_rectangle_white_r16_warning_stroke1;
        } else {
            i = R.drawable.rounded_rectangle_white_r16_black5_stroke1;
        }
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = scheduleOverviewActivity.binding;
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding2 = null;
        if (activityDeviceScheduleOverviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding = null;
        }
        FrameLayout frameLayout = activityDeviceScheduleOverviewBinding.flStartTime;
        Intrinsics.checkNotNull(bool);
        frameLayout.setSelected(bool.booleanValue());
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding3 = scheduleOverviewActivity.binding;
        if (activityDeviceScheduleOverviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding3 = null;
        }
        activityDeviceScheduleOverviewBinding3.flEndTime.setSelected(bool.booleanValue());
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding4 = scheduleOverviewActivity.binding;
        if (activityDeviceScheduleOverviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding4 = null;
        }
        activityDeviceScheduleOverviewBinding4.flStartTime.setBackgroundResource(i);
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding5 = scheduleOverviewActivity.binding;
        if (activityDeviceScheduleOverviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDeviceScheduleOverviewBinding2 = activityDeviceScheduleOverviewBinding5;
        }
        activityDeviceScheduleOverviewBinding2.flEndTime.setBackgroundResource(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$9(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        DialogFragment dialogFragment;
        FragmentManager supportFragmentManager = scheduleOverviewActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TimePickerV2DialogFragment> cls = TimePickerV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue(TimePickerV2DialogFragment.REQUEST_KEY, "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag(TimePickerV2DialogFragment.REQUEST_KEY) instanceof TimePickerV2DialogFragment) || supportFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            TimePickerV2DialogFragment.Companion companion = TimePickerV2DialogFragment.Companion;
            String string = scheduleOverviewActivity.getString(R.string.schedule_start_time_label);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            dialogFragment = TimePickerV2DialogFragment.Companion.newInstance$default(companion, string, scheduleOverviewActivity.getViewModel().getStartTime(), false, 4, (Object) null);
            dialogFragment.show(supportFragmentManager, TimePickerV2DialogFragment.REQUEST_KEY);
        }
        TimePickerV2DialogFragment timePickerV2DialogFragment = (TimePickerV2DialogFragment) dialogFragment;
        if (timePickerV2DialogFragment != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(timePickerV2DialogFragment, TimePickerV2DialogFragment.REQUEST_KEY, new ScheduleOverviewActivity$$ExternalSyntheticLambda18(scheduleOverviewActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$9$lambda$8(ScheduleOverviewActivity scheduleOverviewActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        Calendar parseTimePickerResult = scheduleOverviewActivity.parseTimePickerResult(bundle);
        if (parseTimePickerResult != null) {
            scheduleOverviewActivity.getViewModel().setStartTime(parseTimePickerResult);
            scheduleOverviewActivity.updateTimeViews();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$13(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        DialogFragment dialogFragment;
        FragmentManager supportFragmentManager = scheduleOverviewActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TimePickerV2DialogFragment> cls = TimePickerV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue(TimePickerV2DialogFragment.REQUEST_KEY, "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag(TimePickerV2DialogFragment.REQUEST_KEY) instanceof TimePickerV2DialogFragment) || supportFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            TimePickerV2DialogFragment.Companion companion = TimePickerV2DialogFragment.Companion;
            String string = scheduleOverviewActivity.getString(R.string.schedule_end_time);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            dialogFragment = TimePickerV2DialogFragment.Companion.newInstance$default(companion, string, scheduleOverviewActivity.getViewModel().getEndTime(), false, 4, (Object) null);
            dialogFragment.show(supportFragmentManager, TimePickerV2DialogFragment.REQUEST_KEY);
        }
        TimePickerV2DialogFragment timePickerV2DialogFragment = (TimePickerV2DialogFragment) dialogFragment;
        if (timePickerV2DialogFragment != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(timePickerV2DialogFragment, TimePickerV2DialogFragment.REQUEST_KEY, new ScheduleOverviewActivity$$ExternalSyntheticLambda16(scheduleOverviewActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$13$lambda$12(ScheduleOverviewActivity scheduleOverviewActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        Calendar parseTimePickerResult = scheduleOverviewActivity.parseTimePickerResult(bundle);
        if (parseTimePickerResult != null) {
            scheduleOverviewActivity.getViewModel().setEndTime(parseTimePickerResult);
            scheduleOverviewActivity.updateTimeViews();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$16$lambda$15(ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        Set linkedHashSet = new LinkedHashSet();
        if (activityDeviceScheduleOverviewBinding.cbMon.isChecked()) {
            linkedHashSet.add(DayOfWeek.MON);
        }
        if (activityDeviceScheduleOverviewBinding.cbTue.isChecked()) {
            linkedHashSet.add(DayOfWeek.TUE);
        }
        if (activityDeviceScheduleOverviewBinding.cbWed.isChecked()) {
            linkedHashSet.add(DayOfWeek.WED);
        }
        if (activityDeviceScheduleOverviewBinding.cbThu.isChecked()) {
            linkedHashSet.add(DayOfWeek.THU);
        }
        if (activityDeviceScheduleOverviewBinding.cbFri.isChecked()) {
            linkedHashSet.add(DayOfWeek.FRI);
        }
        if (activityDeviceScheduleOverviewBinding.cbSat.isChecked()) {
            linkedHashSet.add(DayOfWeek.SAT);
        }
        if (activityDeviceScheduleOverviewBinding.cbSun.isChecked()) {
            linkedHashSet.add(DayOfWeek.SUN);
        }
        scheduleOverviewActivity.getViewModel().setRepeat(linkedHashSet);
        scheduleOverviewActivity.updateRepeatDaysText();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$18(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        scheduleOverviewActivity.getViewModel().setRepeat(DayOfWeekExtensionKt.getEverydaySet(DayOfWeek.Companion));
        List<? extends CheckBox> list = scheduleOverviewActivity.dayOfWeekCheckBoxList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
            list = null;
        }
        for (CheckBox checked : list) {
            checked.setChecked(true);
        }
        scheduleOverviewActivity.updateRepeatDaysText();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$20(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view) {
        scheduleOverviewActivity.getViewModel().setRepeat(DayOfWeekExtensionKt.getWeekdaySet(DayOfWeek.Companion));
        List<? extends CheckBox> list = scheduleOverviewActivity.dayOfWeekCheckBoxList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
            list = null;
        }
        for (CheckBox checkBox : list) {
            checkBox.setChecked(true ^ ArraysKt.contains((T[]) new CheckBox[]{activityDeviceScheduleOverviewBinding.cbSat, activityDeviceScheduleOverviewBinding.cbSun}, checkBox));
        }
        scheduleOverviewActivity.updateRepeatDaysText();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$22(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view) {
        scheduleOverviewActivity.getViewModel().setRepeat(DayOfWeekExtensionKt.getWeekendSet(DayOfWeek.Companion));
        List<? extends CheckBox> list = scheduleOverviewActivity.dayOfWeekCheckBoxList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
            list = null;
        }
        for (CheckBox checkBox : list) {
            checkBox.setChecked(ArraysKt.contains((T[]) new CheckBox[]{activityDeviceScheduleOverviewBinding.cbSat, activityDeviceScheduleOverviewBinding.cbSun}, checkBox));
        }
        scheduleOverviewActivity.updateRepeatDaysText();
    }

    private static final void configureView$lambda$39$updateStartMode(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding) {
        if (scheduleOverviewActivity.getViewModel().getPurifierMode() == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY || !scheduleOverviewActivity.shouldShowMainMode()) {
            ImageView imageView = activityDeviceScheduleOverviewBinding.ivStartMainMode;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivStartMainMode");
            ViewExtensionsKt.hide(imageView);
        } else {
            int mainModeIcon = scheduleOverviewActivity.getMainModeIcon(scheduleOverviewActivity.getViewModel().getStartMainMode(), scheduleOverviewActivity.getViewModel().getStartHumMode());
            if (mainModeIcon == 0) {
                ImageView imageView2 = activityDeviceScheduleOverviewBinding.ivStartMainMode;
                Intrinsics.checkNotNullExpressionValue(imageView2, "ivStartMainMode");
                ViewExtensionsKt.hide(imageView2);
            } else {
                ImageView imageView3 = activityDeviceScheduleOverviewBinding.ivStartMainMode;
                Intrinsics.checkNotNullExpressionValue(imageView3, "ivStartMainMode");
                ViewExtensionsKt.show$default(imageView3, false, 1, (Object) null);
                activityDeviceScheduleOverviewBinding.ivStartMainMode.setImageResource(mainModeIcon);
            }
        }
        activityDeviceScheduleOverviewBinding.ictvStartMode.setIconResource(scheduleOverviewActivity.getPurifyModeIcon(scheduleOverviewActivity.getViewModel().getPurifierMode()));
        if (scheduleOverviewActivity.getViewModel().getPurifierMode() == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
            FanSpeedUtils fanSpeedUtils = FanSpeedUtils.INSTANCE;
            Device device2 = scheduleOverviewActivity.device;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            activityDeviceScheduleOverviewBinding.ictvStartMode.setText(String.valueOf(fanSpeedUtils.getFanSpeedLevel(device2, scheduleOverviewActivity.getViewModel().getStartFanSpeed())));
        } else {
            activityDeviceScheduleOverviewBinding.ictvStartMode.hideText();
        }
        Device device3 = scheduleOverviewActivity.device;
        if (device3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device3 = null;
        }
        if ((device3 instanceof HasHumMainMode) && scheduleOverviewActivity.getViewModel().getStartMainMode() == MainMode.Humidification && scheduleOverviewActivity.getViewModel().getPurifierMode() == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
            SimpleIconTextView simpleIconTextView = activityDeviceScheduleOverviewBinding.ictvStartMode;
            Intrinsics.checkNotNullExpressionValue(simpleIconTextView, "ictvStartMode");
            ViewExtensionsKt.hide(simpleIconTextView);
            return;
        }
        SimpleIconTextView simpleIconTextView2 = activityDeviceScheduleOverviewBinding.ictvStartMode;
        Intrinsics.checkNotNullExpressionValue(simpleIconTextView2, "ictvStartMode");
        ViewExtensionsKt.show$default(simpleIconTextView2, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$23(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, MainMode mainMode) {
        configureView$lambda$39$updateStartMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$24(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        configureView$lambda$39$updateStartMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$25(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, FanSpeedEnum fanSpeedEnum) {
        configureView$lambda$39$updateStartMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    private static final void configureView$lambda$39$updateEndMode(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding) {
        if (Intrinsics.areEqual((Object) scheduleOverviewActivity.getViewModel().getScheduleEndType().getValue(), (Object) "custom")) {
            MaterialButton materialButton = activityDeviceScheduleOverviewBinding.btnLastUsed;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnLastUsed");
            ViewExtensionsKt.hide(materialButton);
            if (scheduleOverviewActivity.getViewModel().getScheduleEndCustomMode() == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY || !scheduleOverviewActivity.shouldShowMainMode()) {
                ImageView imageView = activityDeviceScheduleOverviewBinding.ivEndMainMode;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivEndMainMode");
                ViewExtensionsKt.hide(imageView);
            } else {
                int mainModeIcon = scheduleOverviewActivity.getMainModeIcon(scheduleOverviewActivity.getViewModel().getScheduleEndCustomMainMode(), scheduleOverviewActivity.getViewModel().getScheduleEndCustomHumMode());
                if (mainModeIcon == 0) {
                    ImageView imageView2 = activityDeviceScheduleOverviewBinding.ivEndMainMode;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "ivEndMainMode");
                    ViewExtensionsKt.hide(imageView2);
                } else {
                    ImageView imageView3 = activityDeviceScheduleOverviewBinding.ivEndMainMode;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "ivEndMainMode");
                    ViewExtensionsKt.show$default(imageView3, false, 1, (Object) null);
                    activityDeviceScheduleOverviewBinding.ivEndMainMode.setImageResource(mainModeIcon);
                }
            }
            activityDeviceScheduleOverviewBinding.ictvEndMode.setIconResource(scheduleOverviewActivity.getPurifyModeIcon(scheduleOverviewActivity.getViewModel().getScheduleEndCustomMode()));
            if (scheduleOverviewActivity.getViewModel().getScheduleEndCustomMode() == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
                FanSpeedUtils fanSpeedUtils = FanSpeedUtils.INSTANCE;
                Device device2 = scheduleOverviewActivity.device;
                if (device2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    device2 = null;
                }
                activityDeviceScheduleOverviewBinding.ictvEndMode.setText(String.valueOf(fanSpeedUtils.getFanSpeedLevel(device2, scheduleOverviewActivity.getViewModel().getScheduleEndCustomFanSpeed())));
            } else {
                activityDeviceScheduleOverviewBinding.ictvEndMode.hideText();
            }
            SimpleIconTextView simpleIconTextView = activityDeviceScheduleOverviewBinding.ictvEndMode;
            Intrinsics.checkNotNullExpressionValue(simpleIconTextView, "ictvEndMode");
            ViewExtensionsKt.show$default(simpleIconTextView, false, 1, (Object) null);
            Device device3 = scheduleOverviewActivity.device;
            if (device3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device3 = null;
            }
            if ((device3 instanceof HasHumMainMode) && scheduleOverviewActivity.getViewModel().getScheduleEndCustomMainMode() == MainMode.Humidification && scheduleOverviewActivity.getViewModel().getScheduleEndCustomMode() == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
                SimpleIconTextView simpleIconTextView2 = activityDeviceScheduleOverviewBinding.ictvEndMode;
                Intrinsics.checkNotNullExpressionValue(simpleIconTextView2, "ictvEndMode");
                ViewExtensionsKt.hide(simpleIconTextView2);
                return;
            }
            SimpleIconTextView simpleIconTextView3 = activityDeviceScheduleOverviewBinding.ictvEndMode;
            Intrinsics.checkNotNullExpressionValue(simpleIconTextView3, "ictvEndMode");
            ViewExtensionsKt.show$default(simpleIconTextView3, false, 1, (Object) null);
            return;
        }
        MaterialButton materialButton2 = activityDeviceScheduleOverviewBinding.btnLastUsed;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnLastUsed");
        ViewExtensionsKt.show$default(materialButton2, false, 1, (Object) null);
        ImageView imageView4 = activityDeviceScheduleOverviewBinding.ivEndMainMode;
        Intrinsics.checkNotNullExpressionValue(imageView4, "ivEndMainMode");
        ViewExtensionsKt.hide(imageView4);
        SimpleIconTextView simpleIconTextView4 = activityDeviceScheduleOverviewBinding.ictvEndMode;
        Intrinsics.checkNotNullExpressionValue(simpleIconTextView4, "ictvEndMode");
        ViewExtensionsKt.hide(simpleIconTextView4);
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$26(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, String str) {
        configureView$lambda$39$updateEndMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$27(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, MainMode mainMode) {
        configureView$lambda$39$updateEndMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$28(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        configureView$lambda$39$updateEndMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$29(ScheduleOverviewActivity scheduleOverviewActivity, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, FanSpeedEnum fanSpeedEnum) {
        configureView$lambda$39$updateEndMode(scheduleOverviewActivity, activityDeviceScheduleOverviewBinding);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$31(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        FragmentManager supportFragmentManager = scheduleOverviewActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeviceSetScheduleModeV2DialogFragment> cls = DeviceSetScheduleModeV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceSetScheduleModeV2DialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeviceSetScheduleModeV2DialogFragment") instanceof DeviceSetScheduleModeV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeviceSetScheduleModeV2DialogFragment.Companion.newInstance(true).show(supportFragmentManager, "DeviceSetScheduleModeV2DialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$33(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        FragmentManager supportFragmentManager = scheduleOverviewActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeviceSetScheduleModeV2DialogFragment> cls = DeviceSetScheduleModeV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceSetScheduleModeV2DialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeviceSetScheduleModeV2DialogFragment") instanceof DeviceSetScheduleModeV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeviceSetScheduleModeV2DialogFragment.Companion.newInstance(false).show(supportFragmentManager, "DeviceSetScheduleModeV2DialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$34(ScheduleOverviewActivity scheduleOverviewActivity, View view) {
        scheduleOverviewActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$35(ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        accessibilityNodeInfoCompat.setContentDescription(activityDeviceScheduleOverviewBinding.startTimeLabel.getText() + ", " + activityDeviceScheduleOverviewBinding.startTimeValue.getText());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$36(ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        accessibilityNodeInfoCompat.setContentDescription(activityDeviceScheduleOverviewBinding.endTimeLabel.getText() + ", " + activityDeviceScheduleOverviewBinding.endTimeValue.getText());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureView$lambda$39$lambda$37(ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        MaterialButton materialButton = activityDeviceScheduleOverviewBinding.btnLastUsed;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnLastUsed");
        if (materialButton.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat.getContentDescription() + ", " + activityDeviceScheduleOverviewBinding.btnLastUsed.getText());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$39$lambda$38(View view, boolean z) {
        int i;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(0);
            if (z) {
                i = R.drawable.rounded_rectangle_white_r16_focused_stroke2;
            } else if (childAt.isSelected()) {
                i = R.drawable.rounded_rectangle_white_r16_warning_stroke1;
            } else {
                i = R.drawable.rounded_rectangle_white_r16_black5_stroke1;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(i);
            }
        }
    }

    private final boolean shouldShowMainMode() {
        Device device2 = this.device;
        Device device3 = null;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        if (device2 instanceof HasCombo3in1MainMode) {
            return true;
        }
        Device device4 = this.device;
        if (device4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device4 = null;
        }
        if (device4 instanceof HasDehumidifierMainMode) {
            return true;
        }
        Device device5 = this.device;
        if (device5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device5 = null;
        }
        if (device5 instanceof HasHumMainMode) {
            return true;
        }
        Device device6 = this.device;
        if (device6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
        } else {
            device3 = device6;
        }
        return device3 instanceof HasHumMode;
    }

    private final Calendar parseTimePickerResult(Bundle bundle) {
        int i = bundle.getInt(TimePickerV2DialogFragment.ARG_HOUR_OF_DAY, -1);
        int i2 = bundle.getInt(TimePickerV2DialogFragment.ARG_MINUTE, -1);
        if (i == -1 || i2 == -1) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        return instance;
    }

    private final void updateTimeViews() {
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = this.binding;
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding2 = null;
        if (activityDeviceScheduleOverviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding = null;
        }
        activityDeviceScheduleOverviewBinding.startTimeValue.setText(getViewModel().getDisplayStartTime());
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding3 = this.binding;
        if (activityDeviceScheduleOverviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDeviceScheduleOverviewBinding2 = activityDeviceScheduleOverviewBinding3;
        }
        activityDeviceScheduleOverviewBinding2.endTimeValue.setText(getViewModel().getDisplayEndTime());
    }

    private final void updateRepeatDaysText() {
        int i;
        Set<DayOfWeek> repeat = getViewModel().getRepeat();
        if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, repeat)) {
            i = 0;
        } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, repeat)) {
            i = 1;
        } else {
            i = DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, repeat) ? 2 : -1;
        }
        CheckBox[] checkBoxArr = this.repeatCheckBoxes;
        if (checkBoxArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repeatCheckBoxes");
            checkBoxArr = null;
        }
        int length = checkBoxArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            checkBoxArr[i2].setChecked(i3 == i);
            i2++;
            i3 = i4;
        }
    }

    private final int getPurifyModeIcon(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Device device2 = this.device;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        return purifierMode.toModeIcon(device2).getFlatIcon();
    }

    private final int getMainModeIcon(MainMode mainMode, boolean z) {
        Device device2 = this.device;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        if (device2 instanceof HasHumMode) {
            return z ? ModeIcon.HUM.getFlatIcon() : ModeIcon.AIR_PURIFY.getFlatIcon();
        }
        int i = WhenMappings.$EnumSwitchMapping$1[mainMode.ordinal()];
        if (i == 1) {
            return ModeIcon.AIR_PURIFY.getFlatIcon();
        }
        if (i == 2) {
            return ModeIcon.HEAT.getFlatIcon();
        }
        if (i == 3) {
            return ModeIcon.COOL.getFlatIcon();
        }
        if (i == 4) {
            return R.drawable.mode_icon_dehum_flat;
        }
        if (i != 5) {
            return 0;
        }
        return ModeIcon.HUM.getFlatIcon();
    }

    private final void showProgress() {
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = this.binding;
        if (activityDeviceScheduleOverviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityDeviceScheduleOverviewBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
    }

    private final void hideProgress() {
        ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding = this.binding;
        if (activityDeviceScheduleOverviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceScheduleOverviewBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityDeviceScheduleOverviewBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.hide(progressBlockerView);
    }
}
