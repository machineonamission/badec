package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.adapter.DeviceTimezoneAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetTimezoneBinding;
import com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.gigya.android.sdk.GigyaDefinitions;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8TX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSetTimezoneBinding;", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "snackbarAnchorView$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;)V", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceTimezoneAdapter;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetTimezoneDialogFragment.kt */
public final class DeviceSetTimezoneDialogFragment extends BaseDialogFragment<DeviceSetTimezoneViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeviceTimezoneAdapter adapter = new DeviceTimezoneAdapter();
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_TIMEZONE;
    private final Lazy snackbarAnchorView$delegate = LazyKt.lazy(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda1(this));
    private DialogfragmentDeviceSetTimezoneBinding viewDataBinding;
    public DeviceSetTimezoneViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetTimezoneDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSetTimezoneDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment = new DeviceSetTimezoneDialogFragment();
            deviceSetTimezoneDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceSetTimezoneDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public static final View snackbarAnchorView_delegate$lambda$0(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment) {
        DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding = deviceSetTimezoneDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceSetTimezoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceSetTimezoneBinding = null;
        }
        return dialogfragmentDeviceSetTimezoneBinding.getRoot();
    }

    /* access modifiers changed from: protected */
    public View getSnackbarAnchorView() {
        return (View) this.snackbarAnchorView$delegate.getValue();
    }

    public DeviceSetTimezoneViewModel getViewModel() {
        DeviceSetTimezoneViewModel deviceSetTimezoneViewModel = this.viewModel;
        if (deviceSetTimezoneViewModel != null) {
            return deviceSetTimezoneViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceSetTimezoneViewModel deviceSetTimezoneViewModel) {
        Intrinsics.checkNotNullParameter(deviceSetTimezoneViewModel, "<set-?>");
        this.viewModel = deviceSetTimezoneViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setWindowAnimations(R.style.dialog_animation);
            }
        }
        setViewModel((DeviceSetTimezoneViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceSetTimezoneViewModel.class)));
        DeviceSetTimezoneViewModel viewModel2 = getViewModel();
        Parcelable parcelable = requireArguments().getParcelable("device");
        Intrinsics.checkNotNull(parcelable);
        viewModel2.setDevice((Device) parcelable);
        DialogfragmentDeviceSetTimezoneBinding inflate = DialogfragmentDeviceSetTimezoneBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        inflate.closeButton.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda2(this));
        inflate.saveButton.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda3(this));
        getViewModel().getRequesting().observe(getViewLifecycleOwner(), new DeviceSetTimezoneDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda4(inflate, this)));
        TextView textView = inflate.currentTimezoneLabel;
        StringBuilder sb = new StringBuilder("<b>");
        sb.append(getString(R.string.dst_current_timezone));
        sb.append("</b> ");
        Device device = getViewModel().getDevice();
        if (StringsKt.isBlank(device.getTimeZone())) {
            str = "";
        } else {
            TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            str = timezoneUtils.getDisplayName(requireContext, Device.CC.getTimezone$default(device, (Context) null, 1, (Object) null));
        }
        sb.append(str);
        textView.setText(HtmlCompat.fromHtml(sb.toString(), 0));
        this.adapter.setSelectedTimezoneListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda5(this, inflate));
        TimeZone timeZone = TimeZone.getDefault();
        StringBuilder sb2 = new StringBuilder("<b>");
        sb2.append(getString(R.string.dst_local_timezone));
        sb2.append("</b> ");
        TimezoneUtils timezoneUtils2 = TimezoneUtils.INSTANCE;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        Intrinsics.checkNotNull(timeZone);
        sb2.append(timezoneUtils2.getDisplayName(requireContext2, timeZone));
        Spanned fromHtml = HtmlCompat.fromHtml(sb2.toString(), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        inflate.localTimezoneLabel.setText(fromHtml);
        inflate.localTimezoneLabel.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda6(inflate, this, timeZone));
        EditText editText = inflate.searchBar;
        Intrinsics.checkNotNullExpressionValue(editText, "searchBar");
        editText.addTextChangedListener(new DeviceSetTimezoneDialogFragment$onCreateView$lambda$14$$inlined$doAfterTextChanged$1(inflate, this));
        inflate.searchClearBtn.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda7(inflate));
        inflate.timezoneList.setLayoutManager(new LinearLayoutManager(requireContext()));
        inflate.timezoneList.addItemDecoration(new DividerItemDecoration(requireContext(), 1));
        inflate.timezoneList.setAdapter(this.adapter);
        this.adapter.setSelectedTimezone(getViewModel().getDevice().getTimezone(requireContext()));
        getViewModel().getTimezoneList().observe(getViewLifecycleOwner(), new DeviceSetTimezoneDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda8(this, inflate)));
        DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding2 = this.viewDataBinding;
        if (dialogfragmentDeviceSetTimezoneBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceSetTimezoneBinding = dialogfragmentDeviceSetTimezoneBinding2;
        }
        View root = dialogfragmentDeviceSetTimezoneBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$2(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, View view) {
        deviceSetTimezoneDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$4(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, View view) {
        deviceSetTimezoneDialogFragment.getViewModel().setDeviceTimezone(deviceSetTimezoneDialogFragment.adapter.getSelectedTimezone(), new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda0(deviceSetTimezoneDialogFragment));
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$4$lambda$3(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment) {
        deviceSetTimezoneDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$5(DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, Boolean bool) {
        dialogfragmentDeviceSetTimezoneBinding.saveButton.setEnabled(!bool.booleanValue());
        Intrinsics.checkNotNull(bool);
        deviceSetTimezoneDialogFragment.showProgress(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$7(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, int i, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        StringBuilder sb = new StringBuilder("<b>");
        sb.append(deviceSetTimezoneDialogFragment.getString(R.string.dst_current_timezone));
        sb.append("</b> ");
        TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
        Context requireContext = deviceSetTimezoneDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        sb.append(timezoneUtils.getDisplayName(requireContext, timeZone));
        Spanned fromHtml = HtmlCompat.fromHtml(sb.toString(), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        dialogfragmentDeviceSetTimezoneBinding.currentTimezoneLabel.setText(fromHtml);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$10(DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, TimeZone timeZone, View view) {
        dialogfragmentDeviceSetTimezoneBinding.searchBar.setText("");
        DeviceTimezoneAdapter deviceTimezoneAdapter = deviceSetTimezoneDialogFragment.adapter;
        Intrinsics.checkNotNull(timeZone);
        deviceTimezoneAdapter.setSelectedTimezone(timeZone);
        if (deviceSetTimezoneDialogFragment.adapter.getSelectedIndex() > 0) {
            dialogfragmentDeviceSetTimezoneBinding.timezoneList.scrollToPosition(deviceSetTimezoneDialogFragment.adapter.getSelectedIndex());
            dialogfragmentDeviceSetTimezoneBinding.timezoneList.post(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda9(dialogfragmentDeviceSetTimezoneBinding, deviceSetTimezoneDialogFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$10$lambda$9(DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment) {
        RecyclerView.LayoutManager layoutManager = dialogfragmentDeviceSetTimezoneBinding.timezoneList.getLayoutManager();
        if (layoutManager != null) {
            DeviceSetTimezoneDialogFragment$onCreateView$2$6$1$1 deviceSetTimezoneDialogFragment$onCreateView$2$6$1$1 = new DeviceSetTimezoneDialogFragment$onCreateView$2$6$1$1(deviceSetTimezoneDialogFragment.requireContext());
            deviceSetTimezoneDialogFragment$onCreateView$2$6$1$1.setTargetPosition(deviceSetTimezoneDialogFragment.adapter.getSelectedIndex());
            layoutManager.startSmoothScroll(deviceSetTimezoneDialogFragment$onCreateView$2$6$1$1);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$12(DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, View view) {
        dialogfragmentDeviceSetTimezoneBinding.searchBar.setText("");
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$13(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding, List list) {
        DeviceTimezoneAdapter deviceTimezoneAdapter = deviceSetTimezoneDialogFragment.adapter;
        Intrinsics.checkNotNull(list);
        deviceTimezoneAdapter.setTimezoneList(list);
        TextView textView = dialogfragmentDeviceSetTimezoneBinding.noResultsView;
        Intrinsics.checkNotNullExpressionValue(textView, "noResultsView");
        ViewExtensionsKt.show(textView, list.isEmpty());
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onPause() {
        super.onPause();
        getRxSubs().clear();
    }

    public void showProgress(boolean z) {
        DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding = this.viewDataBinding;
        if (dialogfragmentDeviceSetTimezoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceSetTimezoneBinding = null;
        }
        ProgressBlockerView progressBlockerView = dialogfragmentDeviceSetTimezoneBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
