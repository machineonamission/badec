package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.adapter.DaysOfWeekSelectorAdapter;
import com.blueair.devicedetails.adapter.DeviceScheduleAfterInstructionAdapter;
import com.blueair.devicedetails.adapter.DeviceScheduleInstructionAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceCreateEditScheduleBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00102\u001a\u000203H\u0016J\u0012\u0010?\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\u0012\u0010B\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010C\u001a\u00020:H\u0016J\b\u0010D\u001a\u00020:H\u0016J\u0012\u0010E\u001a\u00020F2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020H2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010O\u001a\u00020:H\u0002J\u0010\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020:H\u0002J\b\u0010T\u001a\u00020:H\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\b\u0010W\u001a\u00020:H\u0002J\b\u0010X\u001a\u00020:H\u0002J\b\u0010Y\u001a\u00020:H\u0016J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u000206H\u0016J\b\u0010\\\u001a\u000206H\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R7\u00104\u001a\u001f\u0012\u0013\u0012\u001106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020:\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006`"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceCreateEditScheduleBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "onStartAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "getOnStartAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "setOnStartAdapter", "(Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;)V", "onCustomAdapter", "getOnCustomAdapter", "setOnCustomAdapter", "onEndAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "getOnEndAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "setOnEndAdapter", "(Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;)V", "daysOfWeekAdapter", "Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "getDaysOfWeekAdapter", "()Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "setDaysOfWeekAdapter", "(Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onDismiss", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isDeleteSchedule", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function1;", "setOnDismiss", "(Lkotlin/jvm/functions/Function1;)V", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "configureTimePicker", "updateTimePickerWithPurifyMode", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "configureControls", "configureCustomSchedule", "configureRepeat", "configureToolbar", "bindViewModeltoView", "configureDelete", "onDestroy", "showProgress", "shouldShowProgress", "shouldShowLabelEditText", "shouldShowEndSchedule", "shouldShowCustomSchedule", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceCreateEditScheduleDialogFragment.kt */
public final class DeviceCreateEditScheduleDialogFragment extends BaseDialogFragment<DeviceCreateEditScheduleViewModel> implements ProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public DaysOfWeekSelectorAdapter daysOfWeekAdapter;
    public Device device;
    public DeviceScheduleInstructionAdapter onCustomAdapter;
    private Function1<? super Boolean, Unit> onDismiss;
    public DeviceScheduleAfterInstructionAdapter onEndAdapter;
    public DeviceScheduleInstructionAdapter onStartAdapter;
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_DETAILS;
    private DialogfragmentDeviceCreateEditScheduleBinding viewDataBinding;
    public DeviceCreateEditScheduleViewModel viewModel;

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCreateEditScheduleDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceCreateEditScheduleDialogFragment newInstance$default(Companion companion, Device device, DeviceScheduleMerged deviceScheduleMerged, int i, Object obj) {
            if ((i & 2) != 0) {
                deviceScheduleMerged = null;
            }
            return companion.newInstance(device, deviceScheduleMerged);
        }

        public final DeviceCreateEditScheduleDialogFragment newInstance(Device device, DeviceScheduleMerged deviceScheduleMerged) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment = new DeviceCreateEditScheduleDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            bundle.putParcelable(Actions.EXTRA_SCHEDULE_MERGED, deviceScheduleMerged);
            deviceCreateEditScheduleDialogFragment.setArguments(bundle);
            return deviceCreateEditScheduleDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
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

    public final DeviceScheduleInstructionAdapter getOnStartAdapter() {
        DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter = this.onStartAdapter;
        if (deviceScheduleInstructionAdapter != null) {
            return deviceScheduleInstructionAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onStartAdapter");
        return null;
    }

    public final void setOnStartAdapter(DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter) {
        Intrinsics.checkNotNullParameter(deviceScheduleInstructionAdapter, "<set-?>");
        this.onStartAdapter = deviceScheduleInstructionAdapter;
    }

    public final DeviceScheduleInstructionAdapter getOnCustomAdapter() {
        DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter = this.onCustomAdapter;
        if (deviceScheduleInstructionAdapter != null) {
            return deviceScheduleInstructionAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onCustomAdapter");
        return null;
    }

    public final void setOnCustomAdapter(DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter) {
        Intrinsics.checkNotNullParameter(deviceScheduleInstructionAdapter, "<set-?>");
        this.onCustomAdapter = deviceScheduleInstructionAdapter;
    }

    public final DeviceScheduleAfterInstructionAdapter getOnEndAdapter() {
        DeviceScheduleAfterInstructionAdapter deviceScheduleAfterInstructionAdapter = this.onEndAdapter;
        if (deviceScheduleAfterInstructionAdapter != null) {
            return deviceScheduleAfterInstructionAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onEndAdapter");
        return null;
    }

    public final void setOnEndAdapter(DeviceScheduleAfterInstructionAdapter deviceScheduleAfterInstructionAdapter) {
        Intrinsics.checkNotNullParameter(deviceScheduleAfterInstructionAdapter, "<set-?>");
        this.onEndAdapter = deviceScheduleAfterInstructionAdapter;
    }

    public final DaysOfWeekSelectorAdapter getDaysOfWeekAdapter() {
        DaysOfWeekSelectorAdapter daysOfWeekSelectorAdapter = this.daysOfWeekAdapter;
        if (daysOfWeekSelectorAdapter != null) {
            return daysOfWeekSelectorAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daysOfWeekAdapter");
        return null;
    }

    public final void setDaysOfWeekAdapter(DaysOfWeekSelectorAdapter daysOfWeekSelectorAdapter) {
        Intrinsics.checkNotNullParameter(daysOfWeekSelectorAdapter, "<set-?>");
        this.daysOfWeekAdapter = daysOfWeekSelectorAdapter;
    }

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentDeviceCreateEditScheduleBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    public final Function1<Boolean, Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void setOnDismiss(Function1<? super Boolean, Unit> function1) {
        this.onDismiss = function1;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
        Bundle arguments = getArguments();
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r2 = r2.getWindowManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r3 = this;
            super.onStart()
            android.app.Dialog r0 = r3.getDialog()
            if (r0 == 0) goto L_0x003a
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            android.view.Window r2 = r0.getWindow()
            if (r2 == 0) goto L_0x001f
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x001f
            android.view.Display r2 = r2.getDefaultDisplay()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0025
            r2.getSize(r1)
        L_0x0025:
            android.view.Window r1 = r0.getWindow()
            if (r1 == 0) goto L_0x002f
            r2 = -1
            r1.setLayout(r2, r2)
        L_0x002f:
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x003a
            r1 = 80
            r0.setGravity(r1)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceCreateEditScheduleDialogFragment.onStart():void");
    }

    public void onStop() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onStop();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
        Dialog dialog = new Dialog(requireContext());
        Timber.Forest forest = Timber.Forest;
        forest.d("onCreateDialog: dialog = " + dialog, new Object[0]);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.top_rounded_rectangle_white));
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeviceCreateEditScheduleBinding inflate = DialogfragmentDeviceCreateEditScheduleBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setDeviceCreateEditScheduleViewModel((DeviceCreateEditScheduleViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceCreateEditScheduleViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        ViewCompat.setAccessibilityDelegate(inflate.textViewSelectedDays, new DeviceCreateEditScheduleDialogFragment$onCreateView$2());
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        }
        DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel = dialogfragmentDeviceCreateEditScheduleBinding2.getDeviceCreateEditScheduleViewModel();
        if (deviceCreateEditScheduleViewModel != null) {
            setViewModel(deviceCreateEditScheduleViewModel);
            DeviceCreateEditScheduleViewModel viewModel2 = getViewModel();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            viewModel2.initTimeFormat(requireContext);
            Timber.Forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + getDevice(), new Object[0]);
            getViewModel().setDevice(getDevice());
            DeviceCreateEditScheduleViewModel viewModel3 = getViewModel();
            Bundle arguments = getArguments();
            viewModel3.setEditingSchedule(arguments != null ? (DeviceScheduleMerged) arguments.getParcelable(Actions.EXTRA_SCHEDULE_MERGED) : null);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding3 = null;
            }
            setProgressBlockerView(dialogfragmentDeviceCreateEditScheduleBinding3.progressView);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding4 = null;
            }
            Group group = dialogfragmentDeviceCreateEditScheduleBinding4.groupLabelText;
            Intrinsics.checkNotNullExpressionValue(group, "groupLabelText");
            ViewExtensionsKt.show(group, shouldShowLabelEditText());
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding5 = null;
            }
            Group group2 = dialogfragmentDeviceCreateEditScheduleBinding5.groupAfterSchedule;
            Intrinsics.checkNotNullExpressionValue(group2, "groupAfterSchedule");
            ViewExtensionsKt.show(group2, shouldShowEndSchedule());
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding6 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding6 = null;
            }
            Group group3 = dialogfragmentDeviceCreateEditScheduleBinding6.groupCustomSchedule;
            Intrinsics.checkNotNullExpressionValue(group3, "groupCustomSchedule");
            ViewExtensionsKt.show(group3, shouldShowCustomSchedule());
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding7 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding7;
            }
            View root = dialogfragmentDeviceCreateEditScheduleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        configureToolbar();
        configureTimePicker();
        configureControls();
        configureCustomSchedule();
        configureRepeat();
        configureDelete();
        bindViewModeltoView();
    }

    private final void configureTimePicker() {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        ViewCompat.setAccessibilityDelegate(dialogfragmentDeviceCreateEditScheduleBinding.buttonStartTime, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_start_time_content_description));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding3 = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding3.buttonStartTime.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda16(this));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding4 = null;
        }
        ViewCompat.setAccessibilityDelegate(dialogfragmentDeviceCreateEditScheduleBinding4.buttonEndTime, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_end_time_content_description));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding5;
        }
        dialogfragmentDeviceCreateEditScheduleBinding2.buttonEndTime.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda17(this));
    }

    /* access modifiers changed from: private */
    public static final void configureTimePicker$lambda$5(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TimePickerDialogFragment> cls = TimePickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            new TimePickerDialogFragment(deviceCreateEditScheduleDialogFragment.getViewModel().getStartTime(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda10(deviceCreateEditScheduleDialogFragment)).show(childFragmentManager, "TimePickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureTimePicker$lambda$5$lambda$4$lambda$3(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setStartTime(calendar);
        deviceCreateEditScheduleDialogFragment.bindViewModeltoView();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureTimePicker$lambda$8(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceCreateEditScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TimePickerDialogFragment> cls = TimePickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            new TimePickerDialogFragment(deviceCreateEditScheduleDialogFragment.getViewModel().getEndTime(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda0(deviceCreateEditScheduleDialogFragment)).show(childFragmentManager, "TimePickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureTimePicker$lambda$8$lambda$7$lambda$6(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setEndTime(calendar);
        deviceCreateEditScheduleDialogFragment.bindViewModeltoView();
        return Unit.INSTANCE;
    }

    private final void updateTimePickerWithPurifyMode(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = null;
        if (purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding2 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding2.buttonEndTimeLayout.setAlpha(0.45f);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding3;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.buttonEndTimeLayout.setEnabled(false);
        } else {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding4 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding4.buttonEndTimeLayout.setAlpha(1.0f);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding5;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.buttonEndTimeLayout.setEnabled(true);
        }
        bindViewModeltoView();
    }

    private final void configureControls() {
        setOnStartAdapter(new DeviceScheduleInstructionAdapter(false, getViewModel().getPurifierMode(), getViewModel().getStartFanSpeed(), getViewModel().getStartBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda21(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda22(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda23(this)));
        setOnEndAdapter(new DeviceScheduleAfterInstructionAdapter(getViewModel().getEndFanSpeed(), getViewModel().getEndBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda24(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda25(this)));
        setOnCustomAdapter(new DeviceScheduleInstructionAdapter(true, getViewModel().getScheduleEndCustomMode(), getViewModel().getScheduleEndCustomFanSpeed(), getViewModel().getScheduleEndCustomBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda1(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda2(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda3(this)));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        RecyclerView recyclerView = dialogfragmentDeviceCreateEditScheduleBinding.recyclerViewStartSchedule;
        recyclerView.setAdapter(getOnStartAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setNestedScrollingEnabled(false);
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding3 = null;
        }
        RecyclerView recyclerView2 = dialogfragmentDeviceCreateEditScheduleBinding3.recyclerViewEndSchedule;
        recyclerView2.setAdapter(getOnEndAdapter());
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 1, false));
        recyclerView2.setNestedScrollingEnabled(false);
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding4;
        }
        RecyclerView recyclerView3 = dialogfragmentDeviceCreateEditScheduleBinding2.recyclerViewCustomSchedule;
        recyclerView3.setAdapter(getOnCustomAdapter());
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext(), 1, false));
        recyclerView3.setNestedScrollingEnabled(false);
        getViewModel().getLiveDevice().observe(getViewLifecycleOwner(), new DeviceCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda4(this)));
        getViewModel().getLivePurifierMode().observe(getViewLifecycleOwner(), new DeviceCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$9(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(purifierMode, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setPurifierMode(purifierMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$10(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setStartFanSpeed(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$11(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setStartBrightness(obj);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$12(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setEndFanSpeed(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$13(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setEndBrightness(obj);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$14(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(purifierMode, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setScheduleEndCustomMode(purifierMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$15(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setScheduleEndCustomFanSpeed(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$16(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setScheduleEndCustomBrightness(obj);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$20(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Device device2) {
        deviceCreateEditScheduleDialogFragment.getOnStartAdapter().setDevice(device2);
        deviceCreateEditScheduleDialogFragment.getOnCustomAdapter().setDevice(device2);
        deviceCreateEditScheduleDialogFragment.getOnEndAdapter().setDevice(device2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureControls$lambda$21(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        DeviceScheduleAfterInstructionAdapter onEndAdapter2 = deviceCreateEditScheduleDialogFragment.getOnEndAdapter();
        Intrinsics.checkNotNull(purifierMode);
        onEndAdapter2.setMode(purifierMode);
        deviceCreateEditScheduleDialogFragment.updateTimePickerWithPurifyMode(purifierMode);
        return Unit.INSTANCE;
    }

    private final void configureCustomSchedule() {
        if (shouldShowCustomSchedule()) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda11(this));
            getViewModel().getScheduleEndType().observe(getViewLifecycleOwner(), new DeviceCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda18(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final void configureCustomSchedule$lambda$22(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, RadioGroup radioGroup, int i) {
        if (i == com.blueair.devicedetails.R.id.radio_button_previous) {
            deviceCreateEditScheduleDialogFragment.getViewModel().getScheduleEndType().setValue(BlueDeviceScheduleEndType.PREVIOUS);
        } else if (i == com.blueair.devicedetails.R.id.radio_button_custom) {
            deviceCreateEditScheduleDialogFragment.getViewModel().getScheduleEndType().setValue("custom");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureCustomSchedule$lambda$23(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, String str) {
        Intrinsics.checkNotNull(str);
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = null;
        if (Intrinsics.areEqual((Object) str, (Object) BlueDeviceScheduleEndType.PREVIOUS)) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding2 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding2.radioGroupCustomScheduleSettings.check(com.blueair.devicedetails.R.id.radio_button_previous);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding3 = null;
            }
            RecyclerView recyclerView = dialogfragmentDeviceCreateEditScheduleBinding3.recyclerViewCustomSchedule;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerViewCustomSchedule");
            ViewExtensionsKt.hide(recyclerView);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding4;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.textviewCustomScheduleDescription.setText(R.string.schedule_previous_description);
        } else if (Intrinsics.areEqual((Object) str, (Object) "custom")) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding5 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding5.radioGroupCustomScheduleSettings.check(com.blueair.devicedetails.R.id.radio_button_custom);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding6 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding6 = null;
            }
            RecyclerView recyclerView2 = dialogfragmentDeviceCreateEditScheduleBinding6.recyclerViewCustomSchedule;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerViewCustomSchedule");
            ViewExtensionsKt.show$default(recyclerView2, false, 1, (Object) null);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding7 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding7;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.textviewCustomScheduleDescription.setText(R.string.schedule_custom_description);
        }
        return Unit.INSTANCE;
    }

    private final void configureRepeat() {
        setDaysOfWeekAdapter(new DaysOfWeekSelectorAdapter(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda7(this)));
        getDaysOfWeekAdapter().setSelectedSet(CollectionsKt.toMutableSet(getViewModel().getRepeat()));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        RecyclerView recyclerView = dialogfragmentDeviceCreateEditScheduleBinding.recyclerViewDayPicker;
        recyclerView.setAdapter(getDaysOfWeekAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setNestedScrollingEnabled(false);
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding3;
        }
        dialogfragmentDeviceCreateEditScheduleBinding2.textViewSelectedDays.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda8(this));
    }

    /* access modifiers changed from: private */
    public static final Unit configureRepeat$lambda$24(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Set set) {
        Intrinsics.checkNotNullParameter(set, "it");
        deviceCreateEditScheduleDialogFragment.getViewModel().setRepeat(set);
        deviceCreateEditScheduleDialogFragment.bindViewModeltoView();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureRepeat$lambda$26(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = deviceCreateEditScheduleDialogFragment.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        RecyclerView recyclerView = dialogfragmentDeviceCreateEditScheduleBinding.recyclerViewDayPicker;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerViewDayPicker");
        if (recyclerView.getVisibility() == 0) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding3 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding3.textViewSelectedDays.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_down_marineblue, 0);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding4;
            }
            RecyclerView recyclerView2 = dialogfragmentDeviceCreateEditScheduleBinding2.recyclerViewDayPicker;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerViewDayPicker");
            ViewExtensionsKt.hide(recyclerView2);
            return;
        }
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding5 = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding5.textViewSelectedDays.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_up_marineblue, 0);
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding6 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding6 = null;
        }
        RecyclerView recyclerView3 = dialogfragmentDeviceCreateEditScheduleBinding6.recyclerViewDayPicker;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerViewDayPicker");
        ViewExtensionsKt.show$default(recyclerView3, false, 1, (Object) null);
    }

    private final void configureToolbar() {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding.title.setText(getViewModel().getTitle());
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding3 = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding3.cancelBtn.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda12(this));
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding4;
        }
        dialogfragmentDeviceCreateEditScheduleBinding2.saveBtn.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda13(this));
        getViewModel().getSaveBtnEnabled().observe(getViewLifecycleOwner(), new DeviceCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda14(this)));
        getViewModel().isStartTimeSameAsEndTime().observe(getViewLifecycleOwner(), new DeviceCreateEditScheduleDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda15(this)));
    }

    /* access modifiers changed from: private */
    public static final void configureToolbar$lambda$27(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        deviceCreateEditScheduleDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void configureToolbar$lambda$31(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = null;
        BaseFragmentInterface.CC.showProgress$default(deviceCreateEditScheduleDialogFragment, false, 1, (Object) null);
        DeviceCreateEditScheduleViewModel viewModel2 = deviceCreateEditScheduleDialogFragment.getViewModel();
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding2;
        }
        viewModel2.setLabel(String.valueOf(dialogfragmentDeviceCreateEditScheduleBinding.editTextLabel.getText()));
        deviceCreateEditScheduleDialogFragment.getViewModel().onComplete(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda9(deviceCreateEditScheduleDialogFragment));
    }

    /* access modifiers changed from: private */
    public static final Unit configureToolbar$lambda$31$lambda$30(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, boolean z, boolean z2) {
        Context context = deviceCreateEditScheduleDialogFragment.getContext();
        if (context != null) {
            deviceCreateEditScheduleDialogFragment.hideProgress(context);
        }
        if (z) {
            FragmentManager childFragmentManager = deviceCreateEditScheduleDialogFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.overlap_title), Integer.valueOf(R.string.overlap_content), R.string.btn_cancel, (Integer) null, false, false, false, (String[]) null, 240, (Object) null).show(childFragmentManager, "ConfirmationDialogCentered");
            }
            return Unit.INSTANCE;
        }
        if (z2) {
            Function1<? super Boolean, Unit> function1 = deviceCreateEditScheduleDialogFragment.onDismiss;
            if (function1 != null) {
                function1.invoke(false);
            }
            deviceCreateEditScheduleDialogFragment.dismissAllowingStateLoss();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureToolbar$lambda$32(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Boolean bool) {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = deviceCreateEditScheduleDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        MaterialButton materialButton = dialogfragmentDeviceCreateEditScheduleBinding.saveBtn;
        Intrinsics.checkNotNull(bool);
        materialButton.setEnabled(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureToolbar$lambda$33(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, Boolean bool) {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = null;
        if (bool.booleanValue()) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding2 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding2.buttonStartTime.setTextColor(ContextCompat.getColor(deviceCreateEditScheduleDialogFragment.requireContext(), R.color.error_red));
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding3;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.buttonEndTime.setTextColor(ContextCompat.getColor(deviceCreateEditScheduleDialogFragment.requireContext(), R.color.error_red));
        } else {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding4 = null;
            }
            dialogfragmentDeviceCreateEditScheduleBinding4.buttonStartTime.setTextColor(ContextCompat.getColor(deviceCreateEditScheduleDialogFragment.requireContext(), R.color.colorPrimaryText));
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = deviceCreateEditScheduleDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding = dialogfragmentDeviceCreateEditScheduleBinding5;
            }
            dialogfragmentDeviceCreateEditScheduleBinding.buttonEndTime.setTextColor(ContextCompat.getColor(deviceCreateEditScheduleDialogFragment.requireContext(), R.color.colorPrimaryText));
        }
        return Unit.INSTANCE;
    }

    private final void bindViewModeltoView() {
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
        if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding.textViewSelectedDays.setText(getViewModel().getDisplayRepeat());
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding3 = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding3.buttonStartTime.setText(getViewModel().getDisplayStartTime());
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding4 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceCreateEditScheduleBinding4 = null;
        }
        dialogfragmentDeviceCreateEditScheduleBinding4.buttonEndTime.setText(getViewModel().getDisplayEndTime());
        DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding5 = this.viewDataBinding;
        if (dialogfragmentDeviceCreateEditScheduleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding5;
        }
        dialogfragmentDeviceCreateEditScheduleBinding2.editTextLabel.setText(getViewModel().getDisplayLabel());
    }

    private final void configureDelete() {
        if (getViewModel().getState() == DeviceCreateEditScheduleViewModel.State.MODIFY) {
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding = this.viewDataBinding;
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding2 = null;
            if (dialogfragmentDeviceCreateEditScheduleBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceCreateEditScheduleBinding = null;
            }
            MaterialButton materialButton = dialogfragmentDeviceCreateEditScheduleBinding.buttonDeleteSchedule;
            Intrinsics.checkNotNullExpressionValue(materialButton, "buttonDeleteSchedule");
            ViewExtensionsKt.show$default(materialButton, false, 1, (Object) null);
            DialogfragmentDeviceCreateEditScheduleBinding dialogfragmentDeviceCreateEditScheduleBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceCreateEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceCreateEditScheduleBinding2 = dialogfragmentDeviceCreateEditScheduleBinding3;
            }
            dialogfragmentDeviceCreateEditScheduleBinding2.buttonDeleteSchedule.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void configureDelete$lambda$37(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, View view) {
        DialogFragment dialogFragment;
        FragmentManager childFragmentManager = deviceCreateEditScheduleDialogFragment.getChildFragmentManager();
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
            FragmentExtensionsKt.setFragmentResultListenerWithClear(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda20(deviceCreateEditScheduleDialogFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureDelete$lambda$37$lambda$36(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            deviceCreateEditScheduleDialogFragment.getViewModel().delete(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda19(deviceCreateEditScheduleDialogFragment));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureDelete$lambda$37$lambda$36$lambda$35(DeviceCreateEditScheduleDialogFragment deviceCreateEditScheduleDialogFragment, boolean z) {
        if (z) {
            Function1<? super Boolean, Unit> function1 = deviceCreateEditScheduleDialogFragment.onDismiss;
            if (function1 != null) {
                function1.invoke(true);
            }
            deviceCreateEditScheduleDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    public void onDestroy() {
        super.onDestroy();
        clearProgressFragment();
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    private final boolean shouldShowLabelEditText() {
        return getDevice() instanceof HasBlueCloudFunctions;
    }

    private final boolean shouldShowEndSchedule() {
        return !(getDevice() instanceof HasBlueCloudFunctions);
    }

    private final boolean shouldShowCustomSchedule() {
        return getDevice() instanceof HasBlueCloudFunctions;
    }
}
