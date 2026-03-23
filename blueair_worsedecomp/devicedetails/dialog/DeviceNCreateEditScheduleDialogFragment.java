package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J)\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u0001072\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u001a\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010Y\u001a\u00020\u0013H\u0002J\b\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010[\u001a\u00020\u001a2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020\u0013H\u0002J\b\u0010b\u001a\u00020\u0013H\u0016J\b\u0010c\u001a\u00020\u0013H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX.¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006e"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showProgress", "", "shouldShowProgress", "", "context", "Landroid/content/Context;", "shouldShow", "forcedColor", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "onScheduleChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isDelete", "device", "Lcom/blueair/core/model/Device;", "contentContainerActive", "contentContainer", "title", "Landroid/widget/TextView;", "backBtn", "Landroid/widget/ImageButton;", "saveBtn", "Lcom/google/android/material/button/MaterialButton;", "scheduleName", "Landroid/widget/EditText;", "timezoneValue", "startTimeValue", "endTimeValue", "scheduleRepeat", "startMainModeIcon", "Landroid/widget/ImageView;", "startIcon", "endMainModeIcon", "endIcon", "settingsStart", "Landroid/view/ViewGroup;", "settingsEnd", "rvStartMode", "Landroidx/recyclerview/widget/RecyclerView;", "rvEndMode", "deleteBtn", "progressView", "cbMon", "Landroid/widget/CheckBox;", "cbTue", "cbWed", "cbThu", "cbFri", "cbSat", "cbSun", "scheduleSwitchBtn", "Lcom/blueair/viewcore/view/SwitchCompat;", "startModeAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "endModeAdapter", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateTimeViews", "updateRepeatDaysText", "getPurifyModeIcon", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getMainModeIcon", "mainMode", "Lcom/blueair/core/model/MainMode;", "saveStartEndModeToViewModel", "onStart", "onDestroy", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNCreateEditScheduleDialogFragment.kt */
public final class DeviceNCreateEditScheduleDialogFragment extends BaseDialogFragment<DeviceCreateEditScheduleViewModel> implements ProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ImageButton backBtn;
    private CheckBox cbFri;
    private CheckBox cbMon;
    private CheckBox cbSat;
    private CheckBox cbSun;
    private CheckBox cbThu;
    private CheckBox cbTue;
    private CheckBox cbWed;
    private ConstraintLayout contentContainer;
    private ConstraintLayout contentContainerActive;
    private MaterialButton deleteBtn;
    private Device device;
    private ImageView endIcon;
    private ImageView endMainModeIcon;
    private DeviceNScheduleModeAdapter endModeAdapter;
    private TextView endTimeValue;
    /* access modifiers changed from: private */
    public Function1<? super Boolean, Unit> onScheduleChanged;
    private ProgressBlockerView progressBlockerView;
    private ProgressBlockerView progressView;
    private RecyclerView rvEndMode;
    private RecyclerView rvStartMode;
    private MaterialButton saveBtn;
    private EditText scheduleName;
    private TextView scheduleRepeat;
    private SwitchCompat scheduleSwitchBtn;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_DETAILS;
    private ViewGroup settingsEnd;
    private ViewGroup settingsStart;
    private ImageView startIcon;
    private ImageView startMainModeIcon;
    private DeviceNScheduleModeAdapter startModeAdapter;
    private TextView startTimeValue;
    private TextView timezoneValue;
    private TextView title;
    public DeviceCreateEditScheduleViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNCreateEditScheduleDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0057 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
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
                com.blueair.core.model.DayOfWeek r4 = com.blueair.core.model.DayOfWeek.THU     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.DayOfWeek r4 = com.blueair.core.model.DayOfWeek.FRI     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.DayOfWeek r4 = com.blueair.core.model.DayOfWeek.SAT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r5 = 6
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.DayOfWeek r4 = com.blueair.core.model.DayOfWeek.SUN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r5 = 7
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x0057 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "onScheduleChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isDelete", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNCreateEditScheduleDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceNCreateEditScheduleDialogFragment newInstance$default(Companion companion, Device device, DeviceScheduleMerged deviceScheduleMerged, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                deviceScheduleMerged = null;
            }
            return companion.newInstance(device, deviceScheduleMerged, function1);
        }

        public final DeviceNCreateEditScheduleDialogFragment newInstance(Device device, DeviceScheduleMerged deviceScheduleMerged, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(function1, "onScheduleChanged");
            DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment = new DeviceNCreateEditScheduleDialogFragment();
            deviceNCreateEditScheduleDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to(Actions.EXTRA_SCHEDULE_MERGED, deviceScheduleMerged)));
            deviceNCreateEditScheduleDialogFragment.onScheduleChanged = function1;
            return deviceNCreateEditScheduleDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        ConstraintLayout constraintLayout = this.contentContainer;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
        setCancelable(!z);
    }

    public DeviceCreateEditScheduleViewModel getViewModel() {
        DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel = this.viewModel;
        if (deviceCreateEditScheduleViewModel != null) {
            return deviceCreateEditScheduleViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        Intrinsics.checkNotNullParameter(deviceCreateEditScheduleViewModel, "<set-?>");
        this.viewModel = deviceCreateEditScheduleViewModel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x037e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r37, android.view.ViewGroup r38, android.os.Bundle r39) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r38
            java.lang.String r3 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            int r3 = com.blueair.viewcore.R.style.DialogTheme
            r4 = 0
            r0.setStyle(r4, r3)
            android.app.Dialog r3 = r0.getDialog()
            if (r3 == 0) goto L_0x0031
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L_0x0031
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r5.<init>(r4)
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            r3.setBackgroundDrawable(r5)
            int r5 = com.blueair.viewcore.R.style.dialog_animation
            r3.setWindowAnimations(r5)
            r5 = 80
            r3.setGravity(r5)
        L_0x0031:
            r3 = r0
            com.blueair.viewcore.dialog.BaseDialogFragment r3 = (com.blueair.viewcore.dialog.BaseDialogFragment) r3
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelProvider r5 = new androidx.lifecycle.ViewModelProvider
            r5.<init>((androidx.lifecycle.ViewModelStoreOwner) r3)
            java.lang.Class<com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel> r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.class
            androidx.lifecycle.ViewModel r3 = r5.get(r3)
            com.blueair.viewcore.viewmodel.BaseViewModel r3 = (com.blueair.viewcore.viewmodel.BaseViewModel) r3
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = (com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel) r3
            r0.setViewModel((com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel) r3)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = r0.getViewModel()
            android.content.Context r5 = r0.requireContext()
            java.lang.String r6 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r3.initTimeFormat(r5)
            android.os.Bundle r3 = r0.getArguments()
            java.lang.String r5 = "device"
            if (r3 == 0) goto L_0x0067
            android.os.Parcelable r3 = r3.getParcelable(r5)
            com.blueair.core.model.Device r3 = (com.blueair.core.model.Device) r3
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x038c
            r0.device = r3
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = r0.getViewModel()
            com.blueair.core.model.Device r7 = r0.device
            if (r7 != 0) goto L_0x0078
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r7 = 0
        L_0x0078:
            r3.setDevice(r7)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = r0.getViewModel()
            android.os.Bundle r7 = r0.getArguments()
            if (r7 == 0) goto L_0x008e
            java.lang.String r8 = "schedule_merged"
            android.os.Parcelable r7 = r7.getParcelable(r8)
            com.blueair.core.model.DeviceScheduleMerged r7 = (com.blueair.core.model.DeviceScheduleMerged) r7
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            r3.setEditingSchedule(r7)
            com.blueair.core.model.Device r3 = r0.device
            if (r3 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r3 = 0
        L_0x009a:
            boolean r3 = r3 instanceof com.blueair.core.model.DeviceNewClassic
            java.lang.String r7 = "cbSat"
            java.lang.String r8 = "cbFri"
            java.lang.String r9 = "cbThu"
            java.lang.String r10 = "cbWed"
            java.lang.String r11 = "cbTue"
            java.lang.String r12 = "cbMon"
            java.lang.String r13 = "deleteBtn"
            java.lang.String r14 = "endTimeValue"
            java.lang.String r15 = "startTimeValue"
            java.lang.String r6 = "timezoneValue"
            java.lang.String r4 = "scheduleName"
            r16 = r3
            java.lang.String r3 = "saveBtn"
            r17 = r5
            java.lang.String r5 = "backBtn"
            r18 = r7
            java.lang.String r7 = "title"
            r19 = r8
            java.lang.String r8 = "contentContainer"
            r20 = r9
            java.lang.String r9 = "inflate(...)"
            r21 = r10
            java.lang.String r10 = "progressView"
            r22 = r11
            java.lang.String r11 = "scheduleRepeat"
            r23 = r12
            java.lang.String r12 = "contentContainerActive"
            if (r16 == 0) goto L_0x01ad
            r16 = r10
            r10 = 0
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNCreateEditScheduleBinding r1 = com.blueair.devicedetails.databinding.DialogfragmentDeviceNCreateEditScheduleBinding.inflate(r1, r2, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            androidx.viewbinding.ViewBinding r1 = (androidx.viewbinding.ViewBinding) r1
            r2 = r1
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNCreateEditScheduleBinding r2 = (com.blueair.devicedetails.databinding.DialogfragmentDeviceNCreateEditScheduleBinding) r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainerActive
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            r0.contentContainerActive = r9
            if (r9 != 0) goto L_0x00f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r9 = 0
        L_0x00f0:
            android.view.View r9 = (android.view.View) r9
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r9)
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainer
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
            r0.contentContainer = r9
            android.widget.TextView r8 = r2.title
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r0.title = r8
            android.widget.ImageButton r7 = r2.backBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r0.backBtn = r7
            com.google.android.material.button.MaterialButton r5 = r2.saveBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.saveBtn = r5
            android.widget.EditText r3 = r2.scheduleName
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.scheduleName = r3
            android.widget.TextView r3 = r2.timezoneValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r0.timezoneValue = r3
            android.widget.TextView r3 = r2.startTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r0.startTimeValue = r3
            android.widget.TextView r3 = r2.endTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            r0.endTimeValue = r3
            android.widget.TextView r3 = r2.scheduleRepeat
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)
            r0.scheduleRepeat = r3
            if (r3 != 0) goto L_0x013a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r3 = 0
        L_0x013a:
            android.view.View r3 = (android.view.View) r3
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r3)
            android.widget.ImageView r3 = r2.startIcon
            r0.startIcon = r3
            android.widget.ImageView r3 = r2.endIcon
            r0.endIcon = r3
            android.widget.LinearLayout r3 = r2.settingsStart
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r0.settingsStart = r3
            android.widget.LinearLayout r3 = r2.settingsEnd
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r0.settingsEnd = r3
            com.google.android.material.button.MaterialButton r3 = r2.deleteBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r0.deleteBtn = r3
            com.blueair.viewcore.view.ProgressBlockerView r3 = r2.progressView
            r10 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r0.progressView = r3
            android.widget.CheckBox r3 = r2.cbMon
            r4 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbMon = r3
            android.widget.CheckBox r3 = r2.cbTue
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbTue = r3
            android.widget.CheckBox r3 = r2.cbWed
            r4 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbWed = r3
            android.widget.CheckBox r3 = r2.cbThu
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbThu = r3
            android.widget.CheckBox r3 = r2.cbFri
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbFri = r3
            android.widget.CheckBox r3 = r2.cbSat
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSat = r3
            android.widget.CheckBox r3 = r2.cbSun
            java.lang.String r4 = "cbSun"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSun = r3
            com.blueair.viewcore.view.SwitchCompat r2 = r2.scheduleSwitchBtn
            java.lang.String r3 = "scheduleSwitchBtn"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.scheduleSwitchBtn = r2
            goto L_0x027a
        L_0x01ad:
            r16 = r10
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r21
            r28 = r22
            r29 = r23
            com.blueair.core.model.Device r10 = r0.device
            if (r10 != 0) goto L_0x01c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)
            r10 = 0
        L_0x01c3:
            boolean r10 = r10 instanceof com.blueair.core.model.DevicePet20
            if (r10 == 0) goto L_0x027d
            r10 = 0
            com.blueair.devicedetails.databinding.DialogfragmentDevicePCreateEditScheduleBinding r1 = com.blueair.devicedetails.databinding.DialogfragmentDevicePCreateEditScheduleBinding.inflate(r1, r2, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            androidx.viewbinding.ViewBinding r1 = (androidx.viewbinding.ViewBinding) r1
            r2 = r1
            com.blueair.devicedetails.databinding.DialogfragmentDevicePCreateEditScheduleBinding r2 = (com.blueair.devicedetails.databinding.DialogfragmentDevicePCreateEditScheduleBinding) r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainerActive
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            r0.contentContainerActive = r9
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainer
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
            r0.contentContainer = r9
            android.widget.TextView r8 = r2.title
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r0.title = r8
            android.widget.ImageButton r7 = r2.backBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r0.backBtn = r7
            com.google.android.material.button.MaterialButton r5 = r2.saveBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.saveBtn = r5
            android.widget.EditText r3 = r2.scheduleName
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.scheduleName = r3
            android.widget.TextView r3 = r2.timezoneValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r0.timezoneValue = r3
            android.widget.TextView r3 = r2.startTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r0.startTimeValue = r3
            android.widget.TextView r3 = r2.endTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            r0.endTimeValue = r3
            android.widget.TextView r3 = r2.scheduleRepeat
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)
            r0.scheduleRepeat = r3
            androidx.recyclerview.widget.RecyclerView r3 = r2.rvStartMode
            r0.rvStartMode = r3
            androidx.recyclerview.widget.RecyclerView r3 = r2.rvEndMode
            r0.rvEndMode = r3
            com.google.android.material.button.MaterialButton r3 = r2.deleteBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r0.deleteBtn = r3
            com.blueair.viewcore.view.ProgressBlockerView r3 = r2.progressView
            r10 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r0.progressView = r3
            android.widget.CheckBox r3 = r2.cbMon
            r4 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbMon = r3
            android.widget.CheckBox r3 = r2.cbTue
            r4 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbTue = r3
            android.widget.CheckBox r3 = r2.cbWed
            r4 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbWed = r3
            android.widget.CheckBox r3 = r2.cbThu
            r4 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbThu = r3
            android.widget.CheckBox r3 = r2.cbFri
            r4 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbFri = r3
            android.widget.CheckBox r3 = r2.cbSat
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSat = r3
            android.widget.CheckBox r3 = r2.cbSun
            java.lang.String r4 = "cbSun"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSun = r3
            com.blueair.viewcore.view.SwitchCompat r2 = r2.scheduleSwitchBtn
            java.lang.String r3 = "scheduleSwitchBtn"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.scheduleSwitchBtn = r2
        L_0x027a:
            r4 = 0
            goto L_0x0375
        L_0x027d:
            r30 = r24
            r31 = r25
            r32 = r26
            r33 = r27
            r34 = r28
            r35 = r29
            r10 = 0
            com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding r1 = com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding.inflate(r1, r2, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            androidx.viewbinding.ViewBinding r1 = (androidx.viewbinding.ViewBinding) r1
            r2 = r1
            com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding r2 = (com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding) r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainerActive
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            r0.contentContainerActive = r9
            androidx.constraintlayout.widget.ConstraintLayout r9 = r2.contentContainer
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
            r0.contentContainer = r9
            android.widget.TextView r8 = r2.title
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r0.title = r8
            android.widget.ImageButton r7 = r2.backBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r0.backBtn = r7
            com.google.android.material.button.MaterialButton r5 = r2.saveBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.saveBtn = r5
            android.widget.EditText r3 = r2.scheduleName
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.scheduleName = r3
            android.widget.TextView r3 = r2.timezoneValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r0.timezoneValue = r3
            android.widget.TextView r3 = r2.startTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r0.startTimeValue = r3
            android.widget.TextView r3 = r2.endTimeValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            r0.endTimeValue = r3
            android.widget.TextView r3 = r2.scheduleRepeat
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)
            r0.scheduleRepeat = r3
            android.widget.ImageView r3 = r2.startMainModeIcon
            r0.startMainModeIcon = r3
            android.widget.ImageView r3 = r2.startIcon
            r0.startIcon = r3
            android.widget.ImageView r3 = r2.endMainModeIcon
            r0.endMainModeIcon = r3
            android.widget.ImageView r3 = r2.endIcon
            r0.endIcon = r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r2.settingsStart
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r0.settingsStart = r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r2.settingsEnd
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r0.settingsEnd = r3
            com.google.android.material.button.MaterialButton r3 = r2.deleteBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r0.deleteBtn = r3
            com.blueair.viewcore.view.ProgressBlockerView r3 = r2.progressView
            r10 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r0.progressView = r3
            android.widget.CheckBox r3 = r2.cbMon
            r4 = r35
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbMon = r3
            android.widget.CheckBox r3 = r2.cbTue
            r4 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbTue = r3
            android.widget.CheckBox r3 = r2.cbWed
            r4 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbWed = r3
            android.widget.CheckBox r3 = r2.cbThu
            r4 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbThu = r3
            android.widget.CheckBox r3 = r2.cbFri
            r4 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbFri = r3
            android.widget.CheckBox r3 = r2.cbSat
            r4 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSat = r3
            android.widget.CheckBox r3 = r2.cbSun
            java.lang.String r4 = "cbSun"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.cbSun = r3
            com.blueair.viewcore.view.SwitchCompat r2 = r2.scheduleSwitchBtn
            java.lang.String r3 = "scheduleSwitchBtn"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.scheduleSwitchBtn = r2
            com.blueair.core.model.Device r2 = r0.device
            if (r2 != 0) goto L_0x0358
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r17)
            r2 = 0
        L_0x0358:
            boolean r2 = r2 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r2 == 0) goto L_0x027a
            android.widget.ImageView r2 = r0.startMainModeIcon
            if (r2 == 0) goto L_0x0369
            android.view.View r2 = (android.view.View) r2
            r3 = 1
            r4 = 0
            r5 = 0
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r2, r5, r3, r4)
            goto L_0x036b
        L_0x0369:
            r4 = 0
            r5 = 0
        L_0x036b:
            android.widget.ImageView r2 = r0.endMainModeIcon
            if (r2 == 0) goto L_0x0375
            android.view.View r2 = (android.view.View) r2
            r3 = 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r2, r5, r3, r4)
        L_0x0375:
            com.blueair.viewcore.view.ProgressBlockerView r2 = r0.progressView
            if (r2 != 0) goto L_0x037e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r6 = r4
            goto L_0x037f
        L_0x037e:
            r6 = r2
        L_0x037f:
            r0.setProgressBlockerView(r6)
            android.view.View r1 = r1.getRoot()
            java.lang.String r2 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        L_0x038c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Required value was null."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* JADX WARNING: type inference failed for: r1v72, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c4, code lost:
        r5 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r20, android.os.Bundle r21) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "view"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            super.onViewCreated(r20, r21)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.contentContainer
            java.lang.String r2 = "contentContainer"
            r3 = 0
            if (r1 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x0017:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$onViewCreated$1 r4 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$onViewCreated$1
            r4.<init>(r0)
            android.view.ViewOutlineProvider r4 = (android.view.ViewOutlineProvider) r4
            r1.setOutlineProvider(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.contentContainer
            if (r1 != 0) goto L_0x0029
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x0029:
            r2 = 1
            r1.setClipToOutline(r2)
            android.widget.TextView r1 = r0.title
            java.lang.String r4 = "title"
            if (r1 != 0) goto L_0x0037
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r3
        L_0x0037:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r5 = r0.getViewModel()
            java.lang.String r5 = r5.getTitle()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r0.title
            if (r1 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r3
        L_0x004c:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda16 r4 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda16
            r4.<init>(r0)
            r1.post(r4)
            android.widget.ImageButton r1 = r0.backBtn
            if (r1 != 0) goto L_0x005e
            java.lang.String r1 = "backBtn"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r3
        L_0x005e:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda3 r4 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda3
            r4.<init>(r0)
            r1.setOnClickListener(r4)
            com.google.android.material.button.MaterialButton r1 = r0.saveBtn
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = "saveBtn"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r3
        L_0x0070:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda4 r4 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda4
            r4.<init>(r0)
            r1.setOnClickListener(r4)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MediatorLiveData r1 = r1.getSaveBtnEnabled()
            androidx.lifecycle.LifecycleOwner r4 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda5 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda5
            r5.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r6.<init>(r5)
            androidx.lifecycle.Observer r6 = (androidx.lifecycle.Observer) r6
            r1.observe(r4, r6)
            com.blueair.viewcore.view.SwitchCompat r1 = r0.scheduleSwitchBtn
            java.lang.String r4 = "scheduleSwitchBtn"
            if (r1 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r3
        L_0x009d:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda6 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda6
            r5.<init>(r0)
            r1.setOnCheckedChangeListener(r5)
            android.widget.EditText r1 = r0.scheduleName
            if (r1 != 0) goto L_0x00af
            java.lang.String r1 = "scheduleName"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r3
        L_0x00af:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r5 = r0.getViewModel()
            java.lang.String r5 = r5.getDisplayLabel()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r0.timezoneValue
            if (r1 != 0) goto L_0x00c6
            java.lang.String r1 = "timezoneValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r3
        L_0x00c6:
            com.blueair.core.util.TimezoneUtils r5 = com.blueair.core.util.TimezoneUtils.INSTANCE
            android.content.Context r6 = r0.requireContext()
            java.lang.String r7 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.blueair.core.model.Device r7 = r0.device
            if (r7 != 0) goto L_0x00db
            java.lang.String r7 = "device"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r3
        L_0x00db:
            java.util.TimeZone r7 = com.blueair.core.model.Device.CC.getTimezone$default(r7, r3, r2, r3)
            java.lang.String r5 = r5.getDisplayName(r6, r7)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            r0.updateTimeViews()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.isStartTimeSameAsEndTime()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda7 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda7
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            android.widget.TextView r1 = r0.startTimeValue
            java.lang.String r5 = "startTimeValue"
            if (r1 != 0) goto L_0x0110
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x0110:
            android.view.View r1 = (android.view.View) r1
            com.blueair.viewcore.ViewUtils r6 = com.blueair.viewcore.ViewUtils.INSTANCE
            int r7 = com.blueair.viewcore.R.string.schedule_start_time_content_description
            androidx.core.view.AccessibilityDelegateCompat r6 = r6.createTimePickerShowAccessibilityDelegate(r7)
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r1, r6)
            android.widget.TextView r1 = r0.startTimeValue
            if (r1 != 0) goto L_0x0125
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x0125:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda8 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda8
            r5.<init>(r0)
            r1.setOnClickListener(r5)
            android.widget.TextView r1 = r0.endTimeValue
            java.lang.String r5 = "endTimeValue"
            if (r1 != 0) goto L_0x0137
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x0137:
            android.view.View r1 = (android.view.View) r1
            com.blueair.viewcore.ViewUtils r6 = com.blueair.viewcore.ViewUtils.INSTANCE
            int r7 = com.blueair.viewcore.R.string.schedule_end_time_content_description
            androidx.core.view.AccessibilityDelegateCompat r6 = r6.createTimePickerShowAccessibilityDelegate(r7)
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r1, r6)
            android.widget.TextView r1 = r0.endTimeValue
            if (r1 != 0) goto L_0x014c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x014c:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda9 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda9
            r5.<init>(r0)
            r1.setOnClickListener(r5)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            java.util.Set r1 = r1.getRepeat()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0162:
            boolean r5 = r1.hasNext()
            java.lang.String r6 = "cbSun"
            java.lang.String r7 = "cbSat"
            java.lang.String r8 = "cbFri"
            java.lang.String r9 = "cbThu"
            java.lang.String r10 = "cbWed"
            java.lang.String r11 = "cbTue"
            java.lang.String r12 = "cbMon"
            if (r5 == 0) goto L_0x01c9
            java.lang.Object r5 = r1.next()
            com.blueair.core.model.DayOfWeek r5 = (com.blueair.core.model.DayOfWeek) r5
            int[] r13 = com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r13[r5]
            switch(r5) {
                case 1: goto L_0x01bd;
                case 2: goto L_0x01b5;
                case 3: goto L_0x01ad;
                case 4: goto L_0x01a5;
                case 5: goto L_0x019d;
                case 6: goto L_0x0195;
                case 7: goto L_0x018d;
                default: goto L_0x0187;
            }
        L_0x0187:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x018d:
            android.widget.CheckBox r5 = r0.cbSun
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x01c4
        L_0x0195:
            android.widget.CheckBox r5 = r0.cbSat
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x01c4
        L_0x019d:
            android.widget.CheckBox r5 = r0.cbFri
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L_0x01c4
        L_0x01a5:
            android.widget.CheckBox r5 = r0.cbThu
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            goto L_0x01c4
        L_0x01ad:
            android.widget.CheckBox r5 = r0.cbWed
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L_0x01c4
        L_0x01b5:
            android.widget.CheckBox r5 = r0.cbTue
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x01c4
        L_0x01bd:
            android.widget.CheckBox r5 = r0.cbMon
            if (r5 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
        L_0x01c4:
            r5 = r3
        L_0x01c5:
            r5.setChecked(r2)
            goto L_0x0162
        L_0x01c9:
            r0.updateRepeatDaysText()
            android.widget.CheckBox r1 = r0.cbMon
            if (r1 != 0) goto L_0x01d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r1 = r3
        L_0x01d4:
            android.widget.CheckBox r5 = r0.cbTue
            if (r5 != 0) goto L_0x01dc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r5 = r3
        L_0x01dc:
            android.widget.CheckBox r11 = r0.cbWed
            if (r11 != 0) goto L_0x01e4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r11 = r3
        L_0x01e4:
            android.widget.CheckBox r10 = r0.cbThu
            if (r10 != 0) goto L_0x01ec
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r10 = r3
        L_0x01ec:
            android.widget.CheckBox r9 = r0.cbFri
            if (r9 != 0) goto L_0x01f4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r9 = r3
        L_0x01f4:
            android.widget.CheckBox r8 = r0.cbSat
            if (r8 != 0) goto L_0x01fc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r8 = r3
        L_0x01fc:
            android.widget.CheckBox r7 = r0.cbSun
            if (r7 != 0) goto L_0x0204
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r7 = r3
        L_0x0204:
            r6 = 7
            android.widget.CheckBox[] r6 = new android.widget.CheckBox[r6]
            r12 = 0
            r6[r12] = r1
            r6[r2] = r5
            r1 = 2
            r6[r1] = r11
            r1 = 3
            r6[r1] = r10
            r1 = 4
            r6[r1] = r9
            r1 = 5
            r6[r1] = r8
            r1 = 6
            r6[r1] = r7
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r6)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0225:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x023a
            java.lang.Object r5 = r1.next()
            android.widget.CheckBox r5 = (android.widget.CheckBox) r5
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda10 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda10
            r6.<init>(r0)
            r5.setOnClickListener(r6)
            goto L_0x0225
        L_0x023a:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getLivePurifierMode()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda12 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda12
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getLiveMainMode()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda17 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda17
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getLiveScheduleEndCustomMode()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda18 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda18
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getScheduleEndType()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda19 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda19
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getLiveScheduleEndCustomMainMode()
            androidx.lifecycle.LifecycleOwner r5 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda20 r6 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda20
            r6.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0 r7 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0
            r7.<init>(r6)
            androidx.lifecycle.Observer r7 = (androidx.lifecycle.Observer) r7
            r1.observe(r5, r7)
            android.view.ViewGroup r1 = r0.settingsStart
            if (r1 == 0) goto L_0x02cd
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda21 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda21
            r5.<init>(r0)
            r1.setOnClickListener(r5)
        L_0x02cd:
            android.view.ViewGroup r1 = r0.settingsEnd
            if (r1 == 0) goto L_0x02d9
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda1 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda1
            r5.<init>(r0)
            r1.setOnClickListener(r5)
        L_0x02d9:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r1 = r1.getState()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.MODIFY
            java.lang.String r6 = "deleteBtn"
            if (r1 != r5) goto L_0x030d
            com.google.android.material.button.MaterialButton r1 = r0.deleteBtn
            if (r1 != 0) goto L_0x02ef
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r3
        L_0x02ef:
            com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda2 r5 = new com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda2
            r5.<init>(r0)
            r1.setOnClickListener(r5)
            com.blueair.viewcore.view.SwitchCompat r1 = r0.scheduleSwitchBtn
            if (r1 != 0) goto L_0x02ff
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0300
        L_0x02ff:
            r3 = r1
        L_0x0300:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            boolean r1 = r1.getPaused()
            r1 = r1 ^ r2
            r3.setCheckedSilence(r1)
            goto L_0x032a
        L_0x030d:
            com.google.android.material.button.MaterialButton r1 = r0.deleteBtn
            if (r1 != 0) goto L_0x0315
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r3
        L_0x0315:
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.contentContainerActive
            if (r1 != 0) goto L_0x0324
            java.lang.String r1 = "contentContainerActive"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0325
        L_0x0324:
            r3 = r1
        L_0x0325:
            android.view.View r3 = (android.view.View) r3
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r3)
        L_0x032a:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r1 = r0.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getScheduleEndType()
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x033c
            java.lang.String r1 = "previous"
        L_0x033c:
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r1 = r0.rvStartMode
            if (r1 == 0) goto L_0x03c1
            com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter r2 = new com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = r0.getViewModel()
            com.blueair.core.model.Device r3 = r3.getDevice()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = r4.getPurifierMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.FanSpeedEnum r7 = r4.getStartFanSpeed()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            java.lang.Object r8 = r4.getStartBrightness()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            int r9 = r4.getStartAutoRh()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.MainMode r10 = r4.getStartMainMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.ApSubMode r11 = r4.getStartApSubMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.SmartSubMode r12 = r4.getStartSmartSubMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            double r13 = r4.getStartHeatAutoTemp()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            double r15 = r4.getStartHeatEcoTemp()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            boolean r17 = r4.getStartOscillationEnabled()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            boolean r18 = r4.getStartHumMode()
            r4 = 1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r18)
            r0.startModeAdapter = r2
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r0.requireContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r1.setLayoutManager(r2)
            com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter r2 = r0.startModeAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r1.setAdapter(r2)
        L_0x03c1:
            androidx.recyclerview.widget.RecyclerView r1 = r0.rvEndMode
            if (r1 == 0) goto L_0x0445
            com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter r2 = new com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r3 = r0.getViewModel()
            com.blueair.core.model.Device r3 = r3.getDevice()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = r4.getScheduleEndCustomMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.FanSpeedEnum r7 = r4.getScheduleEndCustomFanSpeed()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            java.lang.Object r8 = r4.getScheduleEndCustomBrightness()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            int r9 = r4.getScheduleEndCustomAutoRh()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.MainMode r10 = r4.getScheduleEndCustomMainMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.ApSubMode r11 = r4.getScheduleEndCustomApSubMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            com.blueair.core.model.SmartSubMode r12 = r4.getScheduleEndCustomSmartSubMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            double r13 = r4.getScheduleEndCustomHeatAutoTemp()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            double r15 = r4.getScheduleEndCustomHeatEcoTemp()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            boolean r17 = r4.getScheduleEndCustomOscillationEnabled()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r0.getViewModel()
            boolean r18 = r4.getScheduleEndCustomHumMode()
            r4 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r18)
            r0.endModeAdapter = r2
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r0.requireContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r1.setLayoutManager(r2)
            com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter r2 = r0.endModeAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r1.setAdapter(r2)
        L_0x0445:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment) {
        ConstraintLayout constraintLayout = deviceNCreateEditScheduleDialogFragment.contentContainer;
        TextView textView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            constraintLayout = null;
        }
        boolean z = ViewCompat.getLayoutDirection(constraintLayout) == 0;
        TextView textView2 = deviceNCreateEditScheduleDialogFragment.title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView2 = null;
        }
        View view = textView2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (z) {
                ConstraintLayout constraintLayout2 = deviceNCreateEditScheduleDialogFragment.contentContainer;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                    constraintLayout2 = null;
                }
                int width = constraintLayout2.getWidth();
                TextView textView3 = deviceNCreateEditScheduleDialogFragment.title;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView3 = null;
                }
                int right = width - textView3.getRight();
                TextView textView4 = deviceNCreateEditScheduleDialogFragment.title;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                } else {
                    textView = textView4;
                }
                marginLayoutParams.leftMargin = right - textView.getLeft();
            } else {
                TextView textView5 = deviceNCreateEditScheduleDialogFragment.title;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView5 = null;
                }
                int left = textView5.getLeft();
                ConstraintLayout constraintLayout3 = deviceNCreateEditScheduleDialogFragment.contentContainer;
                if (constraintLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                    constraintLayout3 = null;
                }
                int width2 = constraintLayout3.getWidth();
                TextView textView6 = deviceNCreateEditScheduleDialogFragment.title;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                } else {
                    textView = textView6;
                }
                marginLayoutParams.rightMargin = left - (width2 - textView.getRight());
            }
            view.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        deviceNCreateEditScheduleDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        EditText editText = null;
        BaseFragmentInterface.CC.showProgress$default(deviceNCreateEditScheduleDialogFragment, false, 1, (Object) null);
        DeviceCreateEditScheduleViewModel viewModel2 = deviceNCreateEditScheduleDialogFragment.getViewModel();
        EditText editText2 = deviceNCreateEditScheduleDialogFragment.scheduleName;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
        } else {
            editText = editText2;
        }
        viewModel2.setLabel(editText.getText().toString());
        deviceNCreateEditScheduleDialogFragment.saveStartEndModeToViewModel();
        deviceNCreateEditScheduleDialogFragment.getViewModel().onComplete(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda11(deviceNCreateEditScheduleDialogFragment));
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$lambda$6(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, boolean z, boolean z2) {
        Context context = deviceNCreateEditScheduleDialogFragment.getContext();
        if (context != null) {
            deviceNCreateEditScheduleDialogFragment.hideProgress(context);
        }
        if (z) {
            FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.overlap_title), Integer.valueOf(R.string.overlap_content), R.string.btn_cancel, (Integer) null, false, false, false, (String[]) null, 240, (Object) null).show(childFragmentManager, "ConfirmationDialogCentered");
            }
        } else if (z2) {
            Function1<? super Boolean, Unit> function1 = deviceNCreateEditScheduleDialogFragment.onScheduleChanged;
            if (function1 != null) {
                function1.invoke(false);
            }
            deviceNCreateEditScheduleDialogFragment.dismissAllowingStateLoss();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, Boolean bool) {
        MaterialButton materialButton = deviceNCreateEditScheduleDialogFragment.saveBtn;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
            materialButton = null;
        }
        Intrinsics.checkNotNull(bool);
        materialButton.setEnabled(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, CompoundButton compoundButton, boolean z) {
        deviceNCreateEditScheduleDialogFragment.getViewModel().setPaused(!z);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, Boolean bool) {
        int color = ContextCompat.getColor(deviceNCreateEditScheduleDialogFragment.requireContext(), bool.booleanValue() ? R.color.error_red : R.color.colorPrimaryText);
        TextView textView = deviceNCreateEditScheduleDialogFragment.startTimeValue;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
            textView = null;
        }
        textView.setTextColor(color);
        TextView textView3 = deviceNCreateEditScheduleDialogFragment.endTimeValue;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(color);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$14(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TimePickerDialogFragment> cls = TimePickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            new TimePickerDialogFragment(deviceNCreateEditScheduleDialogFragment.getViewModel().getStartTime(), new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda0(deviceNCreateEditScheduleDialogFragment)).show(childFragmentManager, "TimePickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14$lambda$13$lambda$12(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "it");
        deviceNCreateEditScheduleDialogFragment.getViewModel().setStartTime(calendar);
        deviceNCreateEditScheduleDialogFragment.updateTimeViews();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$17(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TimePickerDialogFragment> cls = TimePickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            new TimePickerDialogFragment(deviceNCreateEditScheduleDialogFragment.getViewModel().getEndTime(), new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda13(deviceNCreateEditScheduleDialogFragment)).show(childFragmentManager, "TimePickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17$lambda$16$lambda$15(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "it");
        deviceNCreateEditScheduleDialogFragment.getViewModel().setEndTime(calendar);
        deviceNCreateEditScheduleDialogFragment.updateTimeViews();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$20$lambda$19(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        Set linkedHashSet = new LinkedHashSet();
        CheckBox checkBox = deviceNCreateEditScheduleDialogFragment.cbMon;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbMon");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            linkedHashSet.add(DayOfWeek.MON);
        }
        CheckBox checkBox3 = deviceNCreateEditScheduleDialogFragment.cbTue;
        if (checkBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbTue");
            checkBox3 = null;
        }
        if (checkBox3.isChecked()) {
            linkedHashSet.add(DayOfWeek.TUE);
        }
        CheckBox checkBox4 = deviceNCreateEditScheduleDialogFragment.cbWed;
        if (checkBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbWed");
            checkBox4 = null;
        }
        if (checkBox4.isChecked()) {
            linkedHashSet.add(DayOfWeek.WED);
        }
        CheckBox checkBox5 = deviceNCreateEditScheduleDialogFragment.cbThu;
        if (checkBox5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbThu");
            checkBox5 = null;
        }
        if (checkBox5.isChecked()) {
            linkedHashSet.add(DayOfWeek.THU);
        }
        CheckBox checkBox6 = deviceNCreateEditScheduleDialogFragment.cbFri;
        if (checkBox6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbFri");
            checkBox6 = null;
        }
        if (checkBox6.isChecked()) {
            linkedHashSet.add(DayOfWeek.FRI);
        }
        CheckBox checkBox7 = deviceNCreateEditScheduleDialogFragment.cbSat;
        if (checkBox7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSat");
            checkBox7 = null;
        }
        if (checkBox7.isChecked()) {
            linkedHashSet.add(DayOfWeek.SAT);
        }
        CheckBox checkBox8 = deviceNCreateEditScheduleDialogFragment.cbSun;
        if (checkBox8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSun");
        } else {
            checkBox2 = checkBox8;
        }
        if (checkBox2.isChecked()) {
            linkedHashSet.add(DayOfWeek.SUN);
        }
        deviceNCreateEditScheduleDialogFragment.getViewModel().setRepeat(linkedHashSet);
        deviceNCreateEditScheduleDialogFragment.updateRepeatDaysText();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$21(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        ImageView imageView = deviceNCreateEditScheduleDialogFragment.startIcon;
        if (imageView != null) {
            Intrinsics.checkNotNull(purifierMode);
            imageView.setImageResource(deviceNCreateEditScheduleDialogFragment.getPurifyModeIcon(purifierMode));
        }
        ImageView imageView2 = deviceNCreateEditScheduleDialogFragment.startMainModeIcon;
        if (imageView2 != null) {
            View view = imageView2;
            Device device2 = deviceNCreateEditScheduleDialogFragment.device;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            ViewExtensionsKt.show(view, (device2 instanceof HasCombo3in1MainMode) && purifierMode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$22(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, MainMode mainMode) {
        ImageView imageView = deviceNCreateEditScheduleDialogFragment.startMainModeIcon;
        if (imageView != null) {
            Intrinsics.checkNotNull(mainMode);
            imageView.setImageResource(deviceNCreateEditScheduleDialogFragment.getMainModeIcon(mainMode));
        }
        return Unit.INSTANCE;
    }

    private static final void onViewCreated$updateEndIcon(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment) {
        int i;
        ImageView imageView = deviceNCreateEditScheduleDialogFragment.endMainModeIcon;
        if (imageView != null) {
            View view = imageView;
            Device device2 = deviceNCreateEditScheduleDialogFragment.device;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            ViewExtensionsKt.show(view, (device2 instanceof HasCombo3in1MainMode) && Intrinsics.areEqual((Object) deviceNCreateEditScheduleDialogFragment.getViewModel().getScheduleEndType().getValue(), (Object) "custom") && deviceNCreateEditScheduleDialogFragment.getViewModel().getScheduleEndCustomMode() != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY);
        }
        if (Intrinsics.areEqual((Object) deviceNCreateEditScheduleDialogFragment.getViewModel().getScheduleEndType().getValue(), (Object) "custom")) {
            i = deviceNCreateEditScheduleDialogFragment.getPurifyModeIcon(deviceNCreateEditScheduleDialogFragment.getViewModel().getScheduleEndCustomMode());
        } else {
            i = ModeIcon.PREVIOUS.getOnIcon();
        }
        ImageView imageView2 = deviceNCreateEditScheduleDialogFragment.endIcon;
        if (imageView2 != null) {
            imageView2.setImageResource(i);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$23(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        onViewCreated$updateEndIcon(deviceNCreateEditScheduleDialogFragment);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, String str) {
        onViewCreated$updateEndIcon(deviceNCreateEditScheduleDialogFragment);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$25(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, MainMode mainMode) {
        ImageView imageView = deviceNCreateEditScheduleDialogFragment.endMainModeIcon;
        if (imageView != null) {
            Intrinsics.checkNotNull(mainMode);
            imageView.setImageResource(deviceNCreateEditScheduleDialogFragment.getMainModeIcon(mainMode));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$27(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceNSetScheduleModeDialogFragment> cls = DeviceNSetScheduleModeDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceNSetScheduleModeDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceNSetScheduleModeDialogFragment") instanceof DeviceNSetScheduleModeDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceNSetScheduleModeDialogFragment.Companion.newInstance(true).show(childFragmentManager, "DeviceNSetScheduleModeDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$29(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceNSetScheduleModeDialogFragment> cls = DeviceNSetScheduleModeDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceNSetScheduleModeDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceNSetScheduleModeDialogFragment") instanceof DeviceNSetScheduleModeDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceNSetScheduleModeDialogFragment.Companion.newInstance(false).show(childFragmentManager, "DeviceNSetScheduleModeDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$33(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, View view) {
        DialogFragment dialogFragment;
        FragmentManager childFragmentManager = deviceNCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) || childFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            dialogFragment = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.delete_schedule_title), Integer.valueOf(R.string.delete_schedule_content), R.string.delete_schedule_confirm, Integer.valueOf(R.string.btn_cancel), true, false, false, (String[]) null, 224, (Object) null);
            dialogFragment.show(childFragmentManager, "ConfirmationDialogCentered");
        }
        ConfirmationDialogCentered confirmationDialogCentered = (ConfirmationDialogCentered) dialogFragment;
        if (confirmationDialogCentered != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda14(deviceNCreateEditScheduleDialogFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$33$lambda$32(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            deviceNCreateEditScheduleDialogFragment.getViewModel().delete(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda15(deviceNCreateEditScheduleDialogFragment));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$33$lambda$32$lambda$31(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment, boolean z) {
        if (z) {
            Function1<? super Boolean, Unit> function1 = deviceNCreateEditScheduleDialogFragment.onScheduleChanged;
            if (function1 != null) {
                function1.invoke(true);
            }
            deviceNCreateEditScheduleDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    private final void updateTimeViews() {
        TextView textView = this.startTimeValue;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
            textView = null;
        }
        textView.setText(getViewModel().getDisplayStartTime());
        TextView textView3 = this.endTimeValue;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
        } else {
            textView2 = textView3;
        }
        textView2.setText(getViewModel().getDisplayEndTime());
    }

    private final void updateRepeatDaysText() {
        TextView textView = this.scheduleRepeat;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleRepeat");
            textView = null;
        }
        Set<DayOfWeek> repeat = getViewModel().getRepeat();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        textView.setText(DayOfWeekExtensionKt.toString(repeat, requireContext));
    }

    private final int getPurifyModeIcon(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Device device2 = this.device;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        return purifierMode.toModeIcon(device2).getOnIcon();
    }

    private final int getMainModeIcon(MainMode mainMode) {
        int i = WhenMappings.$EnumSwitchMapping$1[mainMode.ordinal()];
        if (i == 1) {
            return ModeIcon.AIR_PURIFY.getOnIcon();
        }
        if (i == 2) {
            return ModeIcon.HEAT.getOnIcon();
        }
        if (i != 3) {
            return 0;
        }
        return ModeIcon.COOL.getOnIcon();
    }

    private final void saveStartEndModeToViewModel() {
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter = this.startModeAdapter;
        if (deviceNScheduleModeAdapter != null) {
            getViewModel().setPurifierMode(deviceNScheduleModeAdapter.getMode());
            getViewModel().setStartFanSpeed(deviceNScheduleModeAdapter.getFanSpeed());
            getViewModel().setStartBrightness(deviceNScheduleModeAdapter.getBrightness());
            getViewModel().setStartAutoRh(deviceNScheduleModeAdapter.getAutoRh());
            getViewModel().setStartMainMode(deviceNScheduleModeAdapter.getMainMode());
            getViewModel().setStartApSubMode(deviceNScheduleModeAdapter.getApSubMode());
            getViewModel().setStartSmartSubMode(deviceNScheduleModeAdapter.getSmartSubMode());
            getViewModel().setStartHeatAutoTemp(deviceNScheduleModeAdapter.getHeatAutoTemp());
            getViewModel().setStartHeatEcoTemp(deviceNScheduleModeAdapter.getHeatEcoTmp());
            getViewModel().setStartOscillationEnabled(deviceNScheduleModeAdapter.getOscillationEnabled());
            getViewModel().setStartHumMode(deviceNScheduleModeAdapter.getHumMode());
        }
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter2 = this.endModeAdapter;
        if (deviceNScheduleModeAdapter2 != null) {
            getViewModel().getScheduleEndType().setValue(deviceNScheduleModeAdapter2.getCustomType());
            getViewModel().setScheduleEndCustomMode(deviceNScheduleModeAdapter2.getMode());
            getViewModel().setScheduleEndCustomFanSpeed(deviceNScheduleModeAdapter2.getFanSpeed());
            getViewModel().setScheduleEndCustomBrightness(deviceNScheduleModeAdapter2.getBrightness());
            getViewModel().setScheduleEndCustomAutoRh(deviceNScheduleModeAdapter2.getAutoRh());
            getViewModel().setScheduleEndCustomMainMode(deviceNScheduleModeAdapter2.getMainMode());
            getViewModel().setScheduleEndCustomApSubMode(deviceNScheduleModeAdapter2.getApSubMode());
            getViewModel().setScheduleEndCustomSmartSubMode(deviceNScheduleModeAdapter2.getSmartSubMode());
            getViewModel().setScheduleEndCustomHeatAutoTemp(deviceNScheduleModeAdapter2.getHeatAutoTemp());
            getViewModel().setScheduleEndCustomHeatEcoTemp(deviceNScheduleModeAdapter2.getHeatEcoTmp());
            getViewModel().setScheduleEndCustomOscillationEnabled(deviceNScheduleModeAdapter2.getOscillationEnabled());
            getViewModel().setScheduleEndCustomHumMode(deviceNScheduleModeAdapter2.getHumMode());
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        clearProgressFragment();
    }
}
