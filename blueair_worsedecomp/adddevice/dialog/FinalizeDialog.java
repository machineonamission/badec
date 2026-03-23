package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.DialogOnboardingFinalizeBinding;
import com.blueair.adddevice.viewmodel.FinalizeViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/blueair/adddevice/dialog/FinalizeDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/DialogOnboardingFinalizeBinding;", "onboardingJob", "Lkotlinx/coroutines/Job;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;)V", "pageIndex", "Landroidx/lifecycle/MutableLiveData;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "gotoHomepage", "dismissAndGotoScanDevice", "showProgress", "shouldShowProgress", "", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FinalizeDialog.kt */
public final class FinalizeDialog extends BaseDialogFragment<FinalizeViewModel> {
    public static final String ACTION_CHOOSE_DEVICE = "action_choose_device";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY = "FinalizeDialog";
    /* access modifiers changed from: private */
    public DialogOnboardingFinalizeBinding binding;
    /* access modifiers changed from: private */
    public Job onboardingJob;
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> pageIndex = new MutableLiveData<>(0);
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_FINALIZE;
    public FinalizeViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/adddevice/dialog/FinalizeDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_CHOOSE_DEVICE", "newInstance", "Lcom/blueair/adddevice/dialog/FinalizeDialog;", "deviceId", "deviceName", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FinalizeDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FinalizeDialog newInstance(String str, String str2, BluetoothDevice bluetoothDevice) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "deviceName");
            Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
            FinalizeDialog finalizeDialog = new FinalizeDialog();
            finalizeDialog.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceDataEntity.DEVICE_ID, str), TuplesKt.to("deviceName", str2), TuplesKt.to("bluetoothDevice", bluetoothDevice)));
            return finalizeDialog;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public FinalizeViewModel getViewModel() {
        FinalizeViewModel finalizeViewModel = this.viewModel;
        if (finalizeViewModel != null) {
            return finalizeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(FinalizeViewModel finalizeViewModel) {
        Intrinsics.checkNotNullParameter(finalizeViewModel, "<set-?>");
        this.viewModel = finalizeViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        int i = 0;
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
        DialogOnboardingFinalizeBinding inflate = DialogOnboardingFinalizeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        setViewModel((FinalizeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(FinalizeViewModel.class)));
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding = this.binding;
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding2 = null;
        if (dialogOnboardingFinalizeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding = null;
        }
        dialogOnboardingFinalizeBinding.closeButton.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda0(this));
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding3 = this.binding;
        if (dialogOnboardingFinalizeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding3 = null;
        }
        dialogOnboardingFinalizeBinding3.btnContinue.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda1(this));
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding4 = this.binding;
        if (dialogOnboardingFinalizeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding4 = null;
        }
        dialogOnboardingFinalizeBinding4.btnAddAnother.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda2(this));
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding5 = this.binding;
        if (dialogOnboardingFinalizeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding5 = null;
        }
        dialogOnboardingFinalizeBinding5.btnBack.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda3(this));
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(DeviceDataEntity.DEVICE_ID)) == null) {
            str = "";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("deviceName")) == null) {
            str2 = "Default";
        }
        Bundle arguments3 = getArguments();
        BluetoothDevice bluetoothDevice = arguments3 != null ? (BluetoothDevice) arguments3.getParcelable("bluetoothDevice") : null;
        Intrinsics.checkNotNull(bluetoothDevice);
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding6 = this.binding;
        if (dialogOnboardingFinalizeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding6 = null;
        }
        ConstraintLayout constraintLayout = dialogOnboardingFinalizeBinding6.clRoot;
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(bluetoothDevice);
        if (deviceImage != null) {
            i = deviceImage.getBgOnboarding();
        }
        constraintLayout.setBackgroundResource(i);
        String[] stringArray = getResources().getStringArray(R.array.onboarding_finalize_step);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding7 = this.binding;
        if (dialogOnboardingFinalizeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding7 = null;
        }
        dialogOnboardingFinalizeBinding7.headerMsg.setText(str2);
        this.pageIndex.observe(getViewLifecycleOwner(), new FinalizeDialog$sam$androidx_lifecycle_Observer$0(new FinalizeDialog$$ExternalSyntheticLambda4(this, stringArray)));
        CoroutineScope coroutineScope = this;
        this.onboardingJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FinalizeDialog$onCreateView$8(this, stringArray, (Continuation<? super FinalizeDialog$onCreateView$8>) null), 3, (Object) null);
        List arrayList = new ArrayList();
        arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new FinalizeDialog$onCreateView$9(this, (Continuation<? super FinalizeDialog$onCreateView$9>) null), 2, (Object) null));
        if (str.length() > 0) {
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new FinalizeDialog$onCreateView$10(this, str, str2, (Continuation<? super FinalizeDialog$onCreateView$10>) null), 2, (Object) null));
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new FinalizeDialog$onCreateView$11(this, str, (Continuation<? super FinalizeDialog$onCreateView$11>) null), 2, (Object) null));
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new FinalizeDialog$onCreateView$12(this, str, (Continuation<? super FinalizeDialog$onCreateView$12>) null), 2, (Object) null));
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new FinalizeDialog$onCreateView$13(arrayList, this, str, (Continuation<? super FinalizeDialog$onCreateView$13>) null), 2, (Object) null);
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding8 = this.binding;
        if (dialogOnboardingFinalizeBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogOnboardingFinalizeBinding2 = dialogOnboardingFinalizeBinding8;
        }
        AbsorbInsetFrameLayout root = dialogOnboardingFinalizeBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3(FinalizeDialog finalizeDialog, View view) {
        FinalizeDialog finalizeDialog2 = finalizeDialog;
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding = finalizeDialog2.binding;
        if (dialogOnboardingFinalizeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding = null;
        }
        Group group = dialogOnboardingFinalizeBinding.groupSuccess;
        Intrinsics.checkNotNullExpressionValue(group, "groupSuccess");
        if (group.getVisibility() == 0) {
            finalizeDialog2.gotoHomepage();
            return;
        }
        FragmentManager childFragmentManager = finalizeDialog2.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_ensure_leave, (Integer) null, R.string.quit_device_setup_confirmation, Integer.valueOf(R.string.action_continue), Integer.valueOf(R.string.action_leave), false, false, false, false, (String[]) null, (String) null, new FinalizeDialog$$ExternalSyntheticLambda5(finalizeDialog2), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3$lambda$2$lambda$1(FinalizeDialog finalizeDialog, boolean z) {
        if (!z) {
            finalizeDialog.gotoHomepage();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(FinalizeDialog finalizeDialog, View view) {
        finalizeDialog.gotoHomepage();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(FinalizeDialog finalizeDialog, View view) {
        finalizeDialog.dismissAndGotoScanDevice();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6(FinalizeDialog finalizeDialog, View view) {
        finalizeDialog.dismissAndGotoScanDevice();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$8(FinalizeDialog finalizeDialog, String[] strArr, Integer num) {
        DialogOnboardingFinalizeBinding dialogOnboardingFinalizeBinding = finalizeDialog.binding;
        if (dialogOnboardingFinalizeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogOnboardingFinalizeBinding = null;
        }
        TextView textView = dialogOnboardingFinalizeBinding.text;
        Intrinsics.checkNotNull(num);
        textView.setText(strArr[num.intValue()]);
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setLayout(-1, -1);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnKeyListener(new FinalizeDialog$$ExternalSyntheticLambda6(this));
        }
        DialogUtils.INSTANCE.immersiveStatusBar(getDialog(), true, true);
    }

    /* access modifiers changed from: private */
    public static final boolean onStart$lambda$9(FinalizeDialog finalizeDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        finalizeDialog.dismissAndGotoScanDevice();
        return true;
    }

    private final void gotoHomepage() {
        dismiss();
        Actions actions = Actions.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        startActivity(actions.openHomeIntent(requireContext));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void dismissAndGotoScanDevice() {
        dismiss();
        FragmentKt.setFragmentResult(this, REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(ACTION_CHOOSE_DEVICE, true)));
    }
}
