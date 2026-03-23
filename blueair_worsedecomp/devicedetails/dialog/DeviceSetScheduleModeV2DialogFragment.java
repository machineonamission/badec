package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.dd.ShadowLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSetScheduleModeV2Binding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "isStartMode", "", "modesAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter;", "controlsAdapter", "modesAdapterActionListener", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "controlsAdapterActionListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureAsStartMode", "configureAsEndMode", "updateStandByUI", "onViewCreated", "view", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetScheduleModeV2DialogFragment.kt */
public final class DeviceSetScheduleModeV2DialogFragment extends BaseDialogFragment<DeviceCreateEditScheduleViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_IS_START_MODE = "EXTRA_IS_START_MODE";
    private DialogfragmentDeviceSetScheduleModeV2Binding binding;
    private DeviceScheduleModeV2Adapter controlsAdapter;
    private final Function1<DeviceScheduleModeV2Adapter.Action<?>, Unit> controlsAdapterActionListener = new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda2(this);
    private boolean isStartMode = true;
    private DeviceScheduleModeV2Adapter modesAdapter;
    private final Function1<DeviceScheduleModeV2Adapter.Action<?>, Unit> modesAdapterActionListener = new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda1(this);
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_MODE;
    public DeviceCreateEditScheduleViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_START_MODE", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment;", "isStartMode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetScheduleModeV2DialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSetScheduleModeV2DialogFragment newInstance(boolean z) {
            DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment = new DeviceSetScheduleModeV2DialogFragment();
            deviceSetScheduleModeV2DialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceSetScheduleModeV2DialogFragment.EXTRA_IS_START_MODE, Boolean.valueOf(z))));
            return deviceSetScheduleModeV2DialogFragment;
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit modesAdapterActionListener$lambda$0(com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment r5, com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action r6) {
        /*
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.MAIN_MODE_CHANGED
            java.lang.String r1 = "controlsAdapter"
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter r5 = r5.controlsAdapter
            if (r5 != 0) goto L_0x0014
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0015
        L_0x0014:
            r2 = r5
        L_0x0015:
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$MAIN_MODE_CHANGED r6 = (com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.MAIN_MODE_CHANGED) r6
            java.lang.Object r5 = r6.getData()
            com.blueair.core.model.MainMode r5 = (com.blueair.core.model.MainMode) r5
            r2.setMainMode(r5)
            goto L_0x00da
        L_0x0022:
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.SUB_MODE_CHANGED
            if (r0 == 0) goto L_0x003f
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter r0 = r5.controlsAdapter
            if (r0 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED r6 = (com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.SUB_MODE_CHANGED) r6
            java.lang.Object r6 = r6.getData()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = (com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode) r6
            r2.setMode(r6)
            r5.updateStandByUI()
            goto L_0x00da
        L_0x003f:
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.END_TYPE_HINT_CLOSED
            r3 = 1
            if (r0 == 0) goto L_0x005b
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r6 = r5.getViewModel()
            r6.setScheduleEndTypeHintClosedBefore(r3)
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter r5 = r5.modesAdapter
            if (r5 != 0) goto L_0x0055
            java.lang.String r5 = "modesAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0056
        L_0x0055:
            r2 = r5
        L_0x0056:
            r2.setEndTypeHintClosedBefore(r3)
            goto L_0x00da
        L_0x005b:
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.CUSTOM_TYPE_CHANGED
            java.lang.String r4 = "binding"
            if (r0 == 0) goto L_0x0094
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter r0 = r5.controlsAdapter
            if (r0 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0069:
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$CUSTOM_TYPE_CHANGED r6 = (com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.CUSTOM_TYPE_CHANGED) r6
            java.lang.Object r1 = r6.getData()
            java.lang.String r1 = (java.lang.String) r1
            r0.setCustomType(r1)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding r5 = r5.binding
            if (r5 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x007d
        L_0x007c:
            r2 = r5
        L_0x007d:
            com.dd.ShadowLayout r5 = r2.standbyContainer
            java.lang.String r0 = "standbyContainer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r6.getData()
            java.lang.String r0 = "custom"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r6)
            goto L_0x00da
        L_0x0094:
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED
            if (r0 == 0) goto L_0x00be
            com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding r5 = r5.binding
            if (r5 != 0) goto L_0x00a0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00a1
        L_0x00a0:
            r2 = r5
        L_0x00a1:
            androidx.recyclerview.widget.RecyclerView r5 = r2.rvModeButtons
            java.lang.String r0 = "rvModeButtons"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            android.view.View r5 = (android.view.View) r5
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$ITEM_COUNT_CHANGED r6 = (com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED) r6
            java.lang.Object r6 = r6.getData()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 <= 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r3 = 0
        L_0x00ba:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r3)
            goto L_0x00da
        L_0x00be:
            boolean r0 = r6 instanceof com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.HUM_MODE_CHANGED
            if (r0 == 0) goto L_0x00da
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter r5 = r5.controlsAdapter
            if (r5 != 0) goto L_0x00ca
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00cb
        L_0x00ca:
            r2 = r5
        L_0x00cb:
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$HUM_MODE_CHANGED r6 = (com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.Action.HUM_MODE_CHANGED) r6
            java.lang.Object r5 = r6.getData()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r2.setHumMode(r5)
        L_0x00da:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment.modesAdapterActionListener$lambda$0(com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment, com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final Unit controlsAdapterActionListener$lambda$2(DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment, DeviceScheduleModeV2Adapter.Action action) {
        DeviceScheduleModeV2Adapter.Action action2 = action;
        Intrinsics.checkNotNullParameter(action2, "action");
        if (action2 instanceof DeviceScheduleModeV2Adapter.Action.OPEN_TARGET_HUMIDITY_INFO) {
            FragmentManager childFragmentManager = deviceSetScheduleModeV2DialogFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_humidity, (Integer) null, deviceSetScheduleModeV2DialogFragment.getViewModel().getDevice() instanceof DeviceCombo2in120 ? R.string.target_humidity_info_2in120 : R.string.target_humidity_info_v2, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
            }
        } else if (action2 instanceof DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED) {
            DialogfragmentDeviceSetScheduleModeV2Binding dialogfragmentDeviceSetScheduleModeV2Binding = deviceSetScheduleModeV2DialogFragment.binding;
            if (dialogfragmentDeviceSetScheduleModeV2Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceSetScheduleModeV2Binding = null;
            }
            ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = dialogfragmentDeviceSetScheduleModeV2Binding.rvControlGroup;
            Intrinsics.checkNotNullExpressionValue(shadowedRecyclerViewLayout, "rvControlGroup");
            ViewExtensionsKt.show(shadowedRecyclerViewLayout, ((Number) ((DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED) action2).getData()).intValue() > 0);
        }
        return Unit.INSTANCE;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        this.isStartMode = requireArguments().getBoolean(EXTRA_IS_START_MODE, true);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DeviceCreateEditScheduleViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceCreateEditScheduleViewModel.class)));
        DialogfragmentDeviceSetScheduleModeV2Binding inflate = DialogfragmentDeviceSetScheduleModeV2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void configureAsStartMode() {
        DialogfragmentDeviceSetScheduleModeV2Binding dialogfragmentDeviceSetScheduleModeV2Binding = this.binding;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = null;
        if (dialogfragmentDeviceSetScheduleModeV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceSetScheduleModeV2Binding = null;
        }
        dialogfragmentDeviceSetScheduleModeV2Binding.title.setText(R.string.select_start_mode);
        dialogfragmentDeviceSetScheduleModeV2Binding.btnDone.setText(R.string.select_end_mode);
        dialogfragmentDeviceSetScheduleModeV2Binding.btnDone.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda3(this));
        Device device = getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        this.modesAdapter = new DeviceScheduleModeV2Adapter(device, DeviceScheduleModeV2Adapter.ControlGroup.MODES, true, BlueDeviceScheduleEndType.PREVIOUS, getViewModel().getStartMainMode(), getViewModel().getPurifierMode(), getViewModel().getStartFanSpeed(), getViewModel().getStartBrightness(), getViewModel().getStartAutoRh(), getViewModel().getStartHumMode(), this.modesAdapterActionListener);
        Device device2 = getViewModel().getDevice();
        Intrinsics.checkNotNull(device2);
        this.controlsAdapter = new DeviceScheduleModeV2Adapter(device2, DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS, true, BlueDeviceScheduleEndType.PREVIOUS, getViewModel().getStartMainMode(), getViewModel().getPurifierMode(), getViewModel().getStartFanSpeed(), getViewModel().getStartBrightness(), getViewModel().getStartAutoRh(), getViewModel().getStartHumMode(), this.controlsAdapterActionListener);
        RecyclerView recyclerView = dialogfragmentDeviceSetScheduleModeV2Binding.rvModeButtons;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = this.modesAdapter;
        if (deviceScheduleModeV2Adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter2 = null;
        }
        recyclerView.setAdapter(deviceScheduleModeV2Adapter2);
        RecyclerView recyclerView2 = dialogfragmentDeviceSetScheduleModeV2Binding.rvControlGroup.getRecyclerView();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter3 = this.controlsAdapter;
        if (deviceScheduleModeV2Adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
        } else {
            deviceScheduleModeV2Adapter = deviceScheduleModeV2Adapter3;
        }
        recyclerView2.setAdapter(deviceScheduleModeV2Adapter);
        ShadowLayout shadowLayout = dialogfragmentDeviceSetScheduleModeV2Binding.standbyContainer;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "standbyContainer");
        ViewExtensionsKt.show(shadowLayout, true);
        updateStandByUI();
    }

    /* access modifiers changed from: private */
    public static final void configureAsStartMode$lambda$5$lambda$4(DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment, View view) {
        DeviceCreateEditScheduleViewModel viewModel2 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = null;
        if (deviceScheduleModeV2Adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter = null;
        }
        viewModel2.setStartMainMode(deviceScheduleModeV2Adapter.getMainMode());
        DeviceCreateEditScheduleViewModel viewModel3 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter3 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter3 = null;
        }
        viewModel3.setPurifierMode(deviceScheduleModeV2Adapter3.getMode());
        DeviceCreateEditScheduleViewModel viewModel4 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter4 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter4 = null;
        }
        viewModel4.setStartHumMode(deviceScheduleModeV2Adapter4.getHumMode());
        DeviceCreateEditScheduleViewModel viewModel5 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter5 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter5 = null;
        }
        viewModel5.setStartFanSpeed(deviceScheduleModeV2Adapter5.getFanSpeed());
        DeviceCreateEditScheduleViewModel viewModel6 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter6 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter6 = null;
        }
        viewModel6.setStartBrightness(deviceScheduleModeV2Adapter6.getBrightness());
        DeviceCreateEditScheduleViewModel viewModel7 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter7 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
        } else {
            deviceScheduleModeV2Adapter2 = deviceScheduleModeV2Adapter7;
        }
        viewModel7.setStartAutoRh(deviceScheduleModeV2Adapter2.getAutoRh());
        deviceSetScheduleModeV2DialogFragment.configureAsEndMode();
    }

    private final void configureAsEndMode() {
        DialogfragmentDeviceSetScheduleModeV2Binding dialogfragmentDeviceSetScheduleModeV2Binding = this.binding;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = null;
        if (dialogfragmentDeviceSetScheduleModeV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceSetScheduleModeV2Binding = null;
        }
        dialogfragmentDeviceSetScheduleModeV2Binding.title.setText(R.string.select_end_mode);
        dialogfragmentDeviceSetScheduleModeV2Binding.btnDone.setText(R.string.btn_done);
        dialogfragmentDeviceSetScheduleModeV2Binding.btnDone.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda0(this));
        String value = getViewModel().getScheduleEndType().getValue();
        if (value == null) {
            value = BlueDeviceScheduleEndType.PREVIOUS;
        }
        String str = value;
        Device device = getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = new DeviceScheduleModeV2Adapter(device, DeviceScheduleModeV2Adapter.ControlGroup.MODES, false, str, getViewModel().getScheduleEndCustomMainMode(), getViewModel().getScheduleEndCustomMode(), getViewModel().getScheduleEndCustomFanSpeed(), getViewModel().getScheduleEndCustomBrightness(), getViewModel().getScheduleEndCustomAutoRh(), getViewModel().getScheduleEndCustomHumMode(), this.modesAdapterActionListener);
        this.modesAdapter = deviceScheduleModeV2Adapter2;
        deviceScheduleModeV2Adapter2.setEndTypeHintClosedBefore(getViewModel().getScheduleEndTypeHintClosedBefore());
        Device device2 = getViewModel().getDevice();
        Intrinsics.checkNotNull(device2);
        this.controlsAdapter = new DeviceScheduleModeV2Adapter(device2, DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS, false, str, getViewModel().getScheduleEndCustomMainMode(), getViewModel().getScheduleEndCustomMode(), getViewModel().getScheduleEndCustomFanSpeed(), getViewModel().getScheduleEndCustomBrightness(), getViewModel().getScheduleEndCustomAutoRh(), getViewModel().getScheduleEndCustomHumMode(), this.controlsAdapterActionListener);
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter3 = this.modesAdapter;
        if (deviceScheduleModeV2Adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter3 = null;
        }
        Function1<DeviceScheduleModeV2Adapter.Action<?>, Unit> onActionListener = deviceScheduleModeV2Adapter3.getOnActionListener();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter4 = this.modesAdapter;
        if (deviceScheduleModeV2Adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter4 = null;
        }
        onActionListener.invoke(new DeviceScheduleModeV2Adapter.Action.CUSTOM_TYPE_CHANGED(deviceScheduleModeV2Adapter4.getCustomType()));
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter5 = this.controlsAdapter;
        if (deviceScheduleModeV2Adapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter5 = null;
        }
        Function1<DeviceScheduleModeV2Adapter.Action<?>, Unit> onActionListener2 = deviceScheduleModeV2Adapter5.getOnActionListener();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter6 = this.controlsAdapter;
        if (deviceScheduleModeV2Adapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter6 = null;
        }
        onActionListener2.invoke(new DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED(deviceScheduleModeV2Adapter6.getItemCount()));
        RecyclerView recyclerView = dialogfragmentDeviceSetScheduleModeV2Binding.rvModeButtons;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter7 = this.modesAdapter;
        if (deviceScheduleModeV2Adapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter7 = null;
        }
        recyclerView.setAdapter(deviceScheduleModeV2Adapter7);
        RecyclerView recyclerView2 = dialogfragmentDeviceSetScheduleModeV2Binding.rvControlGroup.getRecyclerView();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter8 = this.controlsAdapter;
        if (deviceScheduleModeV2Adapter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
        } else {
            deviceScheduleModeV2Adapter = deviceScheduleModeV2Adapter8;
        }
        recyclerView2.setAdapter(deviceScheduleModeV2Adapter);
        updateStandByUI();
    }

    /* access modifiers changed from: private */
    public static final void configureAsEndMode$lambda$7$lambda$6(DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment, View view) {
        MutableLiveData<String> scheduleEndType = deviceSetScheduleModeV2DialogFragment.getViewModel().getScheduleEndType();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = null;
        if (deviceScheduleModeV2Adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter = null;
        }
        scheduleEndType.setValue(deviceScheduleModeV2Adapter.getCustomType());
        DeviceCreateEditScheduleViewModel viewModel2 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter3 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter3 = null;
        }
        viewModel2.setScheduleEndCustomMainMode(deviceScheduleModeV2Adapter3.getMainMode());
        DeviceCreateEditScheduleViewModel viewModel3 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter4 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter4 = null;
        }
        viewModel3.setScheduleEndCustomMode(deviceScheduleModeV2Adapter4.getMode());
        DeviceCreateEditScheduleViewModel viewModel4 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter5 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter5 = null;
        }
        viewModel4.setScheduleEndCustomHumMode(deviceScheduleModeV2Adapter5.getHumMode());
        DeviceCreateEditScheduleViewModel viewModel5 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter6 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter6 = null;
        }
        viewModel5.setScheduleEndCustomFanSpeed(deviceScheduleModeV2Adapter6.getFanSpeed());
        DeviceCreateEditScheduleViewModel viewModel6 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter7 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            deviceScheduleModeV2Adapter7 = null;
        }
        viewModel6.setScheduleEndCustomBrightness(deviceScheduleModeV2Adapter7.getBrightness());
        DeviceCreateEditScheduleViewModel viewModel7 = deviceSetScheduleModeV2DialogFragment.getViewModel();
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter8 = deviceSetScheduleModeV2DialogFragment.controlsAdapter;
        if (deviceScheduleModeV2Adapter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
        } else {
            deviceScheduleModeV2Adapter2 = deviceScheduleModeV2Adapter8;
        }
        viewModel7.setScheduleEndCustomAutoRh(deviceScheduleModeV2Adapter2.getAutoRh());
        deviceSetScheduleModeV2DialogFragment.dismiss();
    }

    private final void updateStandByUI() {
        DialogfragmentDeviceSetScheduleModeV2Binding dialogfragmentDeviceSetScheduleModeV2Binding = this.binding;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = null;
        if (dialogfragmentDeviceSetScheduleModeV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceSetScheduleModeV2Binding = null;
        }
        ImageView imageView = dialogfragmentDeviceSetScheduleModeV2Binding.standbyIcon;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = this.modesAdapter;
        if (deviceScheduleModeV2Adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
        } else {
            deviceScheduleModeV2Adapter = deviceScheduleModeV2Adapter2;
        }
        imageView.setImageResource(deviceScheduleModeV2Adapter.isStandByOn() ? R.drawable.mode_icon_standby_on_schedule : ModeIcon.STANDBY.getOffIconV2());
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [androidx.recyclerview.widget.RecyclerView$ItemAnimator] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.onViewCreated(r3, r4)
            boolean r3 = r2.isStartMode
            if (r3 == 0) goto L_0x0010
            r2.configureAsStartMode()
            goto L_0x0013
        L_0x0010:
            r2.configureAsEndMode()
        L_0x0013:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding r3 = r2.binding
            r4 = 0
            if (r3 != 0) goto L_0x001e
            java.lang.String r3 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r4
        L_0x001e:
            androidx.appcompat.widget.AppCompatImageView r0 = r3.btnClose
            com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda4 r1 = new com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda4
            r1.<init>(r2)
            r0.setOnClickListener(r1)
            com.dd.ShadowLayout r0 = r3.standbyContainer
            com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda5 r1 = new com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda5
            r1.<init>(r2)
            r0.setOnClickListener(r1)
            androidx.recyclerview.widget.RecyclerView r0 = r3.rvModeButtons
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r0.getItemAnimator()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.SimpleItemAnimator
            if (r1 == 0) goto L_0x003f
            r4 = r0
            androidx.recyclerview.widget.SimpleItemAnimator r4 = (androidx.recyclerview.widget.SimpleItemAnimator) r4
        L_0x003f:
            if (r4 == 0) goto L_0x0045
            r0 = 0
            r4.setSupportsChangeAnimations(r0)
        L_0x0045:
            androidx.core.widget.NestedScrollView r4 = r3.scrollable
            com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$onViewCreated$1$3 r0 = new com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment$onViewCreated$1$3
            r0.<init>(r3)
            androidx.core.widget.NestedScrollView$OnScrollChangeListener r0 = (androidx.core.widget.NestedScrollView.OnScrollChangeListener) r0
            r4.setOnScrollChangeListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$8(DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment, View view) {
        deviceSetScheduleModeV2DialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(DeviceSetScheduleModeV2DialogFragment deviceSetScheduleModeV2DialogFragment, View view) {
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter2 = null;
        if (deviceScheduleModeV2Adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
            deviceScheduleModeV2Adapter = null;
        }
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter3 = deviceSetScheduleModeV2DialogFragment.modesAdapter;
        if (deviceScheduleModeV2Adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
        } else {
            deviceScheduleModeV2Adapter2 = deviceScheduleModeV2Adapter3;
        }
        deviceScheduleModeV2Adapter.setStandByOn(!deviceScheduleModeV2Adapter2.isStandByOn());
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }
}
