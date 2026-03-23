package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.ActivityAlarmEditBinding;
import com.blueair.devicedetails.dialog.DeviceAlarmSoundPickerDialogFragment;
import com.blueair.devicedetails.dialog.TimePickerV2DialogFragment;
import com.blueair.devicedetails.viewholder.DeviceOfflineV2Holder;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.ByteLengthFilter;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.google.android.material.textfield.TextInputEditText;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0014J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001e@BX\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/blueair/devicedetails/activity/AlarmEditActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityAlarmEditBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "device", "Lcom/blueair/core/model/HasAlarm;", "alarmIndex", "", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "alarmTime", "Ljava/util/Calendar;", "value", "Lcom/blueair/core/model/AlarmSound;", "alarmSound", "setAlarmSound", "(Lcom/blueair/core/model/AlarmSound;)V", "", "Lcom/blueair/core/model/DayOfWeek;", "repeatDays", "setRepeatDays", "(Ljava/util/Set;)V", "", "offlineClosed", "setOfflineClosed", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "checkAlarmMutualExclusive", "showProgress", "hideProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmEditActivity.kt */
public final class AlarmEditActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_ALARM_INDEX = "EXTRA_ALARM_INDEX";
    private DeviceAlarm alarm;
    private int alarmIndex;
    /* access modifiers changed from: private */
    public AlarmSound alarmSound;
    private Calendar alarmTime;
    private ActivityAlarmEditBinding binding;
    /* access modifiers changed from: private */
    public HasAlarm device;
    private boolean offlineClosed;
    private Set<? extends DayOfWeek> repeatDays;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_ALARM_DETAILS;
    /* access modifiers changed from: private */
    public final DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AlarmEditActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.DayOfWeek[] r0 = com.blueair.core.model.DayOfWeek.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.MON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.TUE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.WED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.THU     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.FRI     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.SAT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.SUN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.activity.AlarmEditActivity.WhenMappings.<clinit>():void");
        }
    }

    public AlarmEditActivity() {
        BaseActivity baseActivity = this;
        this.viewModel = (DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class));
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        this.alarmTime = instance;
        this.alarmSound = AlarmSound.Birds;
        this.repeatDays = SetsKt.emptySet();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/activity/AlarmEditActivity$Companion;", "", "<init>", "()V", "EXTRA_ALARM_INDEX", "", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "alarmIndex", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AlarmEditActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, Device device, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            Intent intent = new Intent(context, AlarmEditActivity.class);
            intent.putExtra("device", device);
            intent.putExtra(AlarmEditActivity.EXTRA_ALARM_INDEX, i);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final void setAlarmSound(AlarmSound alarmSound2) {
        this.alarmSound = alarmSound2;
        ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
        HasAlarm hasAlarm = null;
        if (activityAlarmEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding = null;
        }
        TextView textView = activityAlarmEditBinding.tvSoundValue;
        HasAlarm hasAlarm2 = this.device;
        if (hasAlarm2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
        } else {
            hasAlarm = hasAlarm2;
        }
        textView.setText(alarmSound2.getName(hasAlarm.getMcuFirmware()));
    }

    private final void setRepeatDays(Set<? extends DayOfWeek> set) {
        int i;
        this.repeatDays = set;
        if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, set)) {
            i = 0;
        } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, set)) {
            i = 1;
        } else {
            i = DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, set) ? 2 : -1;
        }
        ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
        ActivityAlarmEditBinding activityAlarmEditBinding2 = null;
        if (activityAlarmEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding = null;
        }
        CheckBox checkBox = activityAlarmEditBinding.cbEveryday;
        ActivityAlarmEditBinding activityAlarmEditBinding3 = this.binding;
        if (activityAlarmEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding3 = null;
        }
        CheckBox checkBox2 = activityAlarmEditBinding3.cbWeekdays;
        ActivityAlarmEditBinding activityAlarmEditBinding4 = this.binding;
        if (activityAlarmEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAlarmEditBinding2 = activityAlarmEditBinding4;
        }
        int i2 = 0;
        for (Object next : CollectionsKt.listOf(checkBox, checkBox2, activityAlarmEditBinding2.cbWeekends)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((CheckBox) next).setChecked(i2 == i);
            i2 = i3;
        }
    }

    private final void setOfflineClosed(boolean z) {
        if (this.offlineClosed != z) {
            this.offlineClosed = z;
            ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
            if (activityAlarmEditBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAlarmEditBinding = null;
            }
            FrameLayout frameLayout = activityAlarmEditBinding.offlineContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "offlineContainer");
            View view = frameLayout;
            boolean z2 = true;
            if (!Intrinsics.areEqual((Object) this.viewModel.getDeviceOffline().getValue(), (Object) true) || z) {
                z2 = false;
            }
            ViewExtensionsKt.show(view, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        CheckBox checkBox;
        super.onCreate(bundle);
        ActivityAlarmEditBinding inflate = ActivityAlarmEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        Intent intent = getIntent();
        ActivityAlarmEditBinding activityAlarmEditBinding = null;
        HasAlarm hasAlarm = intent != null ? (HasAlarm) intent.getParcelableExtra("device") : null;
        if (hasAlarm != null) {
            this.device = hasAlarm;
            Intent intent2 = getIntent();
            this.alarmIndex = intent2 != null ? intent2.getIntExtra(EXTRA_ALARM_INDEX, 0) : 0;
            HasAlarm hasAlarm2 = this.device;
            if (hasAlarm2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasAlarm2 = null;
            }
            this.alarm = (DeviceAlarm) CollectionsKt.getOrNull(hasAlarm2.getAlarms(), this.alarmIndex);
            AlarmSound.Companion companion = AlarmSound.Companion;
            DeviceAlarm deviceAlarm = this.alarm;
            setAlarmSound(companion.fromValue(deviceAlarm != null ? deviceAlarm.getSound() : AlarmSound.Birds.getValue()));
            DeviceAlarm deviceAlarm2 = this.alarm;
            if (deviceAlarm2 != null) {
                int secondsInDay = deviceAlarm2.getSecondsInDay();
                int i = secondsInDay / DateTimeConstants.SECONDS_PER_HOUR;
                this.alarmTime.set(11, i);
                this.alarmTime.set(12, (secondsInDay - (i * DateTimeConstants.SECONDS_PER_HOUR)) / 60);
                setRepeatDays(deviceAlarm2.getDaysOfWeek());
            }
            ActivityAlarmEditBinding activityAlarmEditBinding2 = this.binding;
            if (activityAlarmEditBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAlarmEditBinding2 = null;
            }
            setContentView((View) activityAlarmEditBinding2.getRoot());
            ActivityAlarmEditBinding activityAlarmEditBinding3 = this.binding;
            if (activityAlarmEditBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityAlarmEditBinding = activityAlarmEditBinding3;
            }
            DeviceAlarm deviceAlarm3 = this.alarm;
            activityAlarmEditBinding.btnBack.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda9(this));
            activityAlarmEditBinding.btnCancel.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda16(this));
            activityAlarmEditBinding.scrollView.setOnScrollChangeListener(new AlarmEditActivity$onCreate$2$3(activityAlarmEditBinding));
            TextView textView = activityAlarmEditBinding.title;
            if (deviceAlarm3 == null || (str = deviceAlarm3.getName()) == null) {
                str = getString(R.string.create_sunrise_alarm);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
            textView.setText(str);
            if (deviceAlarm3 == null) {
                activityAlarmEditBinding.btnSaveChange.setText(R.string.create_alarm);
            }
            DeviceOfflineV2Holder.Companion companion2 = DeviceOfflineV2Holder.Companion;
            FrameLayout frameLayout = activityAlarmEditBinding.offlineContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "offlineContainer");
            activityAlarmEditBinding.offlineContainer.addView(companion2.newInstance(frameLayout, new AlarmEditActivity$$ExternalSyntheticLambda17(this), new AlarmEditActivity$$ExternalSyntheticLambda1(this)).itemView);
            this.viewModel.getDeviceOffline().observe(this, new AlarmEditActivity$sam$androidx_lifecycle_Observer$0(new AlarmEditActivity$$ExternalSyntheticLambda2(activityAlarmEditBinding, this)));
            TextInputEditText textInputEditText = activityAlarmEditBinding.alarmName;
            if (deviceAlarm3 == null || (str2 = deviceAlarm3.getName()) == null) {
                str2 = getString(R.string.alarm_default_name);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            }
            textInputEditText.setText(str2);
            activityAlarmEditBinding.alarmName.setFilters((InputFilter[]) new ByteLengthFilter[]{new ByteLengthFilter(21, Charsets.UTF_8)});
            activityAlarmEditBinding.timeValue.setText(this.viewModel.getCurrentTimeFormatter().format(this.alarmTime.getTime()));
            ViewCompat.setAccessibilityDelegate(activityAlarmEditBinding.timeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.alarm_time_content_description));
            activityAlarmEditBinding.setTimeGroup.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda3(this, activityAlarmEditBinding));
            activityAlarmEditBinding.ringtoneSwitch.setOnCheckedChangeListener(new AlarmEditActivity$$ExternalSyntheticLambda4(this, activityAlarmEditBinding));
            activityAlarmEditBinding.ringtoneSwitch.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda5(activityAlarmEditBinding, this));
            activityAlarmEditBinding.ringtoneSwitch.setChecked(!(deviceAlarm3 != null && deviceAlarm3.getSound() == AlarmSound.Mute.getValue()));
            activityAlarmEditBinding.clickViewSound.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda6(this, activityAlarmEditBinding));
            activityAlarmEditBinding.seekbarVolume.setProgress(deviceAlarm3 != null ? deviceAlarm3.getVolume() : 50);
            activityAlarmEditBinding.tvVolumeValue.setText(String.valueOf(activityAlarmEditBinding.seekbarVolume.getProgress()));
            activityAlarmEditBinding.seekbarVolume.setOnSeekBarChangeListener(new AlarmEditActivity$onCreate$2$9(activityAlarmEditBinding, this));
            activityAlarmEditBinding.sunriseSwitch.setOnCheckedChangeListener(new AlarmEditActivity$$ExternalSyntheticLambda7(this, activityAlarmEditBinding));
            activityAlarmEditBinding.sunriseSwitch.setChecked(!(deviceAlarm3 != null && !deviceAlarm3.getLightEnabled()));
            int lightDuration = deviceAlarm3 != null ? deviceAlarm3.getLightDuration() : 15;
            if (lightDuration == 15) {
                activityAlarmEditBinding.seekbarDuration.setProgress(30);
            }
            activityAlarmEditBinding.seekbarDuration.setOnSeekBarChangeListener(new AlarmEditActivity$onCreate$2$11(this, activityAlarmEditBinding));
            activityAlarmEditBinding.seekbarDuration.setProgress(lightDuration);
            activityAlarmEditBinding.tvProgress0.setText("15 " + getString(R.string.eta_minutes));
            activityAlarmEditBinding.tvProgress100.setText("30 " + getString(R.string.eta_minutes));
            ConstraintLayout constraintLayout = activityAlarmEditBinding.hintContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "hintContainer");
            ViewExtensionsKt.show(constraintLayout, !this.viewModel.getSunRiseLightHintClosedBefore());
            activityAlarmEditBinding.btnCloseHint.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda10(this, activityAlarmEditBinding));
            for (DayOfWeek ordinal : this.repeatDays) {
                switch (WhenMappings.$EnumSwitchMapping$0[ordinal.ordinal()]) {
                    case 1:
                        checkBox = activityAlarmEditBinding.cbMon;
                        break;
                    case 2:
                        checkBox = activityAlarmEditBinding.cbTue;
                        break;
                    case 3:
                        checkBox = activityAlarmEditBinding.cbWed;
                        break;
                    case 4:
                        checkBox = activityAlarmEditBinding.cbThu;
                        break;
                    case 5:
                        checkBox = activityAlarmEditBinding.cbFri;
                        break;
                    case 6:
                        checkBox = activityAlarmEditBinding.cbSat;
                        break;
                    case 7:
                        checkBox = activityAlarmEditBinding.cbSun;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNull(checkBox);
                checkBox.setChecked(true);
            }
            List<CheckBox> listOf = CollectionsKt.listOf(activityAlarmEditBinding.cbMon, activityAlarmEditBinding.cbTue, activityAlarmEditBinding.cbWed, activityAlarmEditBinding.cbThu, activityAlarmEditBinding.cbFri, activityAlarmEditBinding.cbSat, activityAlarmEditBinding.cbSun);
            for (CheckBox onClickListener : listOf) {
                onClickListener.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda11(activityAlarmEditBinding, this));
            }
            activityAlarmEditBinding.cbEveryday.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda12(this, listOf));
            activityAlarmEditBinding.cbWeekdays.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda13(this, listOf, activityAlarmEditBinding));
            activityAlarmEditBinding.cbWeekends.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda14(this, listOf, activityAlarmEditBinding));
            activityAlarmEditBinding.btnSaveChange.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda15(this, activityAlarmEditBinding, deviceAlarm3));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$2(AlarmEditActivity alarmEditActivity, View view) {
        alarmEditActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$3(AlarmEditActivity alarmEditActivity, View view) {
        alarmEditActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$30$lambda$4(AlarmEditActivity alarmEditActivity) {
        alarmEditActivity.setOfflineClosed(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$30$lambda$6(AlarmEditActivity alarmEditActivity) {
        FragmentManager supportFragmentManager = alarmEditActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !supportFragmentManager.isStateSaved()) {
            TroubleshootingDialog.Companion companion = TroubleshootingDialog.Companion;
            HasAlarm hasAlarm = alarmEditActivity.device;
            if (hasAlarm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasAlarm = null;
            }
            companion.newInstance(TroubleshootingDialog.ACTION_TYPE_DEVICE_OFFLINE, hasAlarm).show(supportFragmentManager, TroubleshootingDialog.REQUEST_KEY);
            supportFragmentManager.executePendingTransactions();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$30$lambda$7(ActivityAlarmEditBinding activityAlarmEditBinding, AlarmEditActivity alarmEditActivity, Boolean bool) {
        FrameLayout frameLayout = activityAlarmEditBinding.offlineContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "offlineContainer");
        ViewExtensionsKt.show(frameLayout, bool.booleanValue() && !alarmEditActivity.offlineClosed);
        activityAlarmEditBinding.btnSaveChange.setEnabled(!bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$10(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, View view) {
        DialogFragment dialogFragment;
        FragmentManager supportFragmentManager = alarmEditActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TimePickerV2DialogFragment> cls = TimePickerV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue(TimePickerV2DialogFragment.REQUEST_KEY, "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag(TimePickerV2DialogFragment.REQUEST_KEY) instanceof TimePickerV2DialogFragment) || supportFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            TimePickerV2DialogFragment.Companion companion = TimePickerV2DialogFragment.Companion;
            String string = alarmEditActivity.getString(R.string.alarm_default_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            dialogFragment = TimePickerV2DialogFragment.Companion.newInstance$default(companion, string, alarmEditActivity.alarmTime, false, 4, (Object) null);
            dialogFragment.show(supportFragmentManager, TimePickerV2DialogFragment.REQUEST_KEY);
        }
        TimePickerV2DialogFragment timePickerV2DialogFragment = (TimePickerV2DialogFragment) dialogFragment;
        if (timePickerV2DialogFragment != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(timePickerV2DialogFragment, TimePickerV2DialogFragment.REQUEST_KEY, new AlarmEditActivity$$ExternalSyntheticLambda8(alarmEditActivity, activityAlarmEditBinding));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$30$lambda$10$lambda$9(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        int i = bundle.getInt(TimePickerV2DialogFragment.ARG_HOUR_OF_DAY, -1);
        int i2 = bundle.getInt(TimePickerV2DialogFragment.ARG_MINUTE, -1);
        if (!(i == -1 || i2 == -1)) {
            alarmEditActivity.alarmTime.set(11, i);
            alarmEditActivity.alarmTime.set(12, i2);
            activityAlarmEditBinding.timeValue.setText(alarmEditActivity.viewModel.getCurrentTimeFormatter().format(alarmEditActivity.alarmTime.getTime()));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$11(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, CompoundButton compoundButton, boolean z) {
        if (z || !alarmEditActivity.checkAlarmMutualExclusive()) {
            Group group = activityAlarmEditBinding.ringtoneContent;
            Intrinsics.checkNotNullExpressionValue(group, "ringtoneContent");
            ViewExtensionsKt.show(group, z);
            return;
        }
        activityAlarmEditBinding.ringtoneSwitch.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$12(ActivityAlarmEditBinding activityAlarmEditBinding, AlarmEditActivity alarmEditActivity, View view) {
        if (!activityAlarmEditBinding.ringtoneSwitch.isChecked()) {
            DeviceDetailsViewModel deviceDetailsViewModel = alarmEditActivity.viewModel;
            HasAlarm hasAlarm = alarmEditActivity.device;
            if (hasAlarm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasAlarm = null;
            }
            deviceDetailsViewModel.stopAlarm(hasAlarm);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$15(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, View view) {
        DialogFragment dialogFragment;
        FragmentManager supportFragmentManager = alarmEditActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeviceAlarmSoundPickerDialogFragment> cls = DeviceAlarmSoundPickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue(DeviceAlarmSoundPickerDialogFragment.REQUEST_KEY, "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag(DeviceAlarmSoundPickerDialogFragment.REQUEST_KEY) instanceof DeviceAlarmSoundPickerDialogFragment) || supportFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            dialogFragment = DeviceAlarmSoundPickerDialogFragment.Companion.newInstance(alarmEditActivity.alarmSound.getValue(), activityAlarmEditBinding.seekbarVolume.getProgress());
            dialogFragment.show(supportFragmentManager, DeviceAlarmSoundPickerDialogFragment.REQUEST_KEY);
        }
        DeviceAlarmSoundPickerDialogFragment deviceAlarmSoundPickerDialogFragment = (DeviceAlarmSoundPickerDialogFragment) dialogFragment;
        if (deviceAlarmSoundPickerDialogFragment != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(deviceAlarmSoundPickerDialogFragment, DeviceAlarmSoundPickerDialogFragment.REQUEST_KEY, new AlarmEditActivity$$ExternalSyntheticLambda0(alarmEditActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$30$lambda$15$lambda$14(AlarmEditActivity alarmEditActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        alarmEditActivity.setAlarmSound(AlarmSound.Companion.fromValue(bundle.getInt(DeviceAlarmSoundPickerDialogFragment.ARG_SOUND, AlarmSound.Birds.getValue())));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$16(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, CompoundButton compoundButton, boolean z) {
        if (z || !alarmEditActivity.checkAlarmMutualExclusive()) {
            Group group = activityAlarmEditBinding.sunriseContent;
            Intrinsics.checkNotNullExpressionValue(group, "sunriseContent");
            ViewExtensionsKt.show(group, z);
            return;
        }
        activityAlarmEditBinding.sunriseSwitch.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$17(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, View view) {
        alarmEditActivity.viewModel.setSunRiseLightHintClosedBefore(true);
        ConstraintLayout constraintLayout = activityAlarmEditBinding.hintContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "hintContainer");
        ViewExtensionsKt.hide(constraintLayout);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$20$lambda$19(ActivityAlarmEditBinding activityAlarmEditBinding, AlarmEditActivity alarmEditActivity, View view) {
        Set linkedHashSet = new LinkedHashSet();
        if (activityAlarmEditBinding.cbMon.isChecked()) {
            linkedHashSet.add(DayOfWeek.MON);
        }
        if (activityAlarmEditBinding.cbTue.isChecked()) {
            linkedHashSet.add(DayOfWeek.TUE);
        }
        if (activityAlarmEditBinding.cbWed.isChecked()) {
            linkedHashSet.add(DayOfWeek.WED);
        }
        if (activityAlarmEditBinding.cbThu.isChecked()) {
            linkedHashSet.add(DayOfWeek.THU);
        }
        if (activityAlarmEditBinding.cbFri.isChecked()) {
            linkedHashSet.add(DayOfWeek.FRI);
        }
        if (activityAlarmEditBinding.cbSat.isChecked()) {
            linkedHashSet.add(DayOfWeek.SAT);
        }
        if (activityAlarmEditBinding.cbSun.isChecked()) {
            linkedHashSet.add(DayOfWeek.SUN);
        }
        alarmEditActivity.setRepeatDays(linkedHashSet);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$22(AlarmEditActivity alarmEditActivity, List list, View view) {
        alarmEditActivity.setRepeatDays(DayOfWeekExtensionKt.getEverydaySet(DayOfWeek.Companion));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CheckBox) it.next()).setChecked(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$24(AlarmEditActivity alarmEditActivity, List list, ActivityAlarmEditBinding activityAlarmEditBinding, View view) {
        alarmEditActivity.setRepeatDays(DayOfWeekExtensionKt.getWeekdaySet(DayOfWeek.Companion));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CheckBox checkBox = (CheckBox) it.next();
            checkBox.setChecked(true ^ ArraysKt.contains((T[]) new CheckBox[]{activityAlarmEditBinding.cbSat, activityAlarmEditBinding.cbSun}, checkBox));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$26(AlarmEditActivity alarmEditActivity, List list, ActivityAlarmEditBinding activityAlarmEditBinding, View view) {
        alarmEditActivity.setRepeatDays(DayOfWeekExtensionKt.getWeekendSet(DayOfWeek.Companion));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CheckBox checkBox = (CheckBox) it.next();
            checkBox.setChecked(ArraysKt.contains((T[]) new CheckBox[]{activityAlarmEditBinding.cbSat, activityAlarmEditBinding.cbSun}, checkBox));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30$lambda$29(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding, DeviceAlarm deviceAlarm, View view) {
        int i;
        AlarmEditActivity alarmEditActivity2 = alarmEditActivity;
        ActivityAlarmEditBinding activityAlarmEditBinding2 = activityAlarmEditBinding;
        boolean z = false;
        int i2 = 0;
        for (DayOfWeek monFirstOrder : alarmEditActivity2.repeatDays) {
            i2 |= 1 << monFirstOrder.getMonFirstOrder();
        }
        if (i2 == 0) {
            i2 = 128;
        }
        int i3 = i2;
        alarmEditActivity2.showProgress();
        DeviceDetailsViewModel deviceDetailsViewModel = alarmEditActivity2.viewModel;
        HasAlarm hasAlarm = alarmEditActivity2.device;
        if (hasAlarm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasAlarm = null;
        }
        Device device2 = hasAlarm;
        int i4 = alarmEditActivity2.alarmIndex + 1;
        CharSequence valueOf = String.valueOf(activityAlarmEditBinding2.alarmName.getText());
        if (valueOf.length() == 0) {
            valueOf = alarmEditActivity2.getString(R.string.alarm_default_name);
            Intrinsics.checkNotNullExpressionValue(valueOf, "getString(...)");
        }
        String str = (String) valueOf;
        if (deviceAlarm != null && !deviceAlarm.getEnabled()) {
            z = true;
        }
        boolean z2 = !z;
        int i5 = (alarmEditActivity2.alarmTime.get(11) * DateTimeConstants.SECONDS_PER_HOUR) + (alarmEditActivity2.alarmTime.get(12) * 60);
        boolean isChecked = activityAlarmEditBinding2.sunriseSwitch.isChecked();
        int progress = activityAlarmEditBinding2.seekbarDuration.getProgress();
        if (activityAlarmEditBinding2.ringtoneSwitch.isChecked()) {
            i = (alarmEditActivity2.alarmSound == AlarmSound.Mute ? AlarmSound.Birds : alarmEditActivity2.alarmSound).getValue();
        } else {
            i = AlarmSound.Mute.getValue();
        }
        deviceDetailsViewModel.setAlarm(device2, i4, new DeviceAlarm(str, z2, i5, isChecked, progress, i, activityAlarmEditBinding2.seekbarVolume.getProgress(), i3), new AlarmEditActivity$onCreate$2$18$3(alarmEditActivity2, (Continuation<? super AlarmEditActivity$onCreate$2$18$3>) null));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        HasAlarm hasAlarm = this.device;
        if (hasAlarm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasAlarm = null;
        }
        deviceDetailsViewModel.stopAlarm(hasAlarm);
    }

    private final boolean checkAlarmMutualExclusive() {
        ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
        ActivityAlarmEditBinding activityAlarmEditBinding2 = null;
        if (activityAlarmEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding = null;
        }
        if (activityAlarmEditBinding.ringtoneSwitch.isChecked()) {
            return false;
        }
        ActivityAlarmEditBinding activityAlarmEditBinding3 = this.binding;
        if (activityAlarmEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAlarmEditBinding2 = activityAlarmEditBinding3;
        }
        if (activityAlarmEditBinding2.sunriseSwitch.isChecked()) {
            return false;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) || supportFragmentManager.isStateSaved()) {
            return true;
        }
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.alarm_mutual_exclusive_title, (Integer) null, R.string.alarm_mutual_exclusive_msg, Integer.valueOf(R.string.button_got_it), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        return true;
    }

    private final void showProgress() {
        ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
        if (activityAlarmEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityAlarmEditBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void hideProgress() {
        ActivityAlarmEditBinding activityAlarmEditBinding = this.binding;
        if (activityAlarmEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAlarmEditBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityAlarmEditBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.hide(progressBlockerView);
    }
}
