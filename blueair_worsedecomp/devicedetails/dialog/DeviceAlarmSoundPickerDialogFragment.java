package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.AlarmSoundAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceAlarmSoundPickerBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.klaviyo.pushFcm.KlaviyoNotification;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceAlarmSoundPickerBinding;", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmSoundAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarmSoundPickerDialogFragment.kt */
public final class DeviceAlarmSoundPickerDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final String ARG_SOUND = "ARG_SOUND";
    private static final String ARG_VOLUME = "ARG_VOLUME";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY = "DeviceAlarmSoundPickerDialogFragment";
    private AlarmSoundAdapter adapter;
    private DialogfragmentDeviceAlarmSoundPickerBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_ALARM_SOUND;
    private DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    public DeviceAlarmSoundPickerDialogFragment() {
        BaseDialogFragment baseDialogFragment = this;
        this.viewModel = (DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ARG_SOUND", "ARG_VOLUME", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment;", "sound", "", "volume", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarmSoundPickerDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAlarmSoundPickerDialogFragment newInstance(int i, int i2) {
            DeviceAlarmSoundPickerDialogFragment deviceAlarmSoundPickerDialogFragment = new DeviceAlarmSoundPickerDialogFragment();
            deviceAlarmSoundPickerDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceAlarmSoundPickerDialogFragment.ARG_SOUND, Integer.valueOf(i)), TuplesKt.to(DeviceAlarmSoundPickerDialogFragment.ARG_VOLUME, Integer.valueOf(i2))));
            return deviceAlarmSoundPickerDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceDetailsViewModel getViewModel() {
        return this.viewModel;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentDeviceAlarmSoundPickerBinding inflate = DialogfragmentDeviceAlarmSoundPickerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        DialogfragmentDeviceAlarmSoundPickerBinding dialogfragmentDeviceAlarmSoundPickerBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.btnClose.setOnClickListener(new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda0(this));
        inflate.btnDone.setOnClickListener(new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda1(this));
        RecyclerView recyclerView = inflate.rvList;
        MaterialDividerItemDecoration materialDividerItemDecoration = new MaterialDividerItemDecoration(requireContext(), 1);
        materialDividerItemDecoration.setDividerColorResource(requireContext(), R.color.surface_dark_10);
        recyclerView.addItemDecoration(materialDividerItemDecoration);
        int i = requireArguments().getInt(ARG_VOLUME, 50);
        Device device = getViewModel().getDevice();
        if (device == null || (str = device.getMcuFirmware()) == null) {
            str = "";
        }
        AlarmSoundAdapter alarmSoundAdapter = new AlarmSoundAdapter(str, new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda2(this, i));
        this.adapter = alarmSoundAdapter;
        alarmSoundAdapter.setSelectedSound(AlarmSound.Companion.fromValue(requireArguments().getInt(ARG_SOUND, AlarmSound.Birds.getValue())));
        RecyclerView recyclerView2 = inflate.rvList;
        AlarmSoundAdapter alarmSoundAdapter2 = this.adapter;
        if (alarmSoundAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            alarmSoundAdapter2 = null;
        }
        recyclerView2.setAdapter(alarmSoundAdapter2);
        inflate.rvList.addOnScrollListener(new DeviceAlarmSoundPickerDialogFragment$onCreateView$2$5(inflate));
        DialogfragmentDeviceAlarmSoundPickerBinding dialogfragmentDeviceAlarmSoundPickerBinding2 = this.binding;
        if (dialogfragmentDeviceAlarmSoundPickerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceAlarmSoundPickerBinding = dialogfragmentDeviceAlarmSoundPickerBinding2;
        }
        View root = dialogfragmentDeviceAlarmSoundPickerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$1(DeviceAlarmSoundPickerDialogFragment deviceAlarmSoundPickerDialogFragment, View view) {
        deviceAlarmSoundPickerDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$2(DeviceAlarmSoundPickerDialogFragment deviceAlarmSoundPickerDialogFragment, View view) {
        deviceAlarmSoundPickerDialogFragment.dismissAllowingStateLoss();
        Fragment fragment = deviceAlarmSoundPickerDialogFragment;
        Pair[] pairArr = new Pair[1];
        AlarmSoundAdapter alarmSoundAdapter = deviceAlarmSoundPickerDialogFragment.adapter;
        if (alarmSoundAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            alarmSoundAdapter = null;
        }
        pairArr[0] = TuplesKt.to(ARG_SOUND, Integer.valueOf(alarmSoundAdapter.getSelectedSound().getValue()));
        FragmentKt.setFragmentResult(fragment, REQUEST_KEY, BundleKt.bundleOf(pairArr));
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$6$lambda$5(DeviceAlarmSoundPickerDialogFragment deviceAlarmSoundPickerDialogFragment, int i, AlarmSound alarmSound) {
        Intrinsics.checkNotNullParameter(alarmSound, KlaviyoNotification.SOUND_KEY);
        Device device = deviceAlarmSoundPickerDialogFragment.getViewModel().getDevice();
        if (device != null) {
            deviceAlarmSoundPickerDialogFragment.getViewModel().playAlarm(device, alarmSound.getValue(), i);
        }
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Device device = getViewModel().getDevice();
        if (device != null) {
            getViewModel().stopAlarm(device);
        }
    }
}
