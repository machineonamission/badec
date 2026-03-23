package com.blueair.devicedetails.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.OscillationDirection;
import com.blueair.core.model.OscillationFanSpeed;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.view.FanView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0016J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020$H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceOscillationSettingsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "angleBarLabels", "", "Landroid/widget/TextView;", "separatorList", "Landroid/view/View;", "currentDirection", "Lcom/blueair/core/model/OscillationDirection;", "mAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "disableView", "", "disable", "", "currentAngleBarValue", "", "update", "device", "Lcom/blueair/core/model/HasOscillation;", "updateFanView", "updateDeviceImageAngle", "updateAngleBarLabels", "updateAngleLabel", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOscillationSettingsDialogFragment.kt */
public final class DeviceOscillationSettingsDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    /* access modifiers changed from: private */
    public static final List<Integer> ANGLES = CollectionsKt.listOf(45, 90, 180, 270, 350);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<? extends TextView> angleBarLabels;
    private DialogfragmentDeviceOscillationSettingsBinding binding;
    private OscillationDirection currentDirection = OscillationDirection.STRAIGHT;
    private final ValueAnimator mAnimator;
    private final String screenName;
    private List<? extends View> separatorList;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOscillationSettingsDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        static {
            /*
                com.blueair.core.model.OscillationFanSpeed[] r0 = com.blueair.core.model.OscillationFanSpeed.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.OscillationFanSpeed r2 = com.blueair.core.model.OscillationFanSpeed.SPEED_1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.OscillationFanSpeed r3 = com.blueair.core.model.OscillationFanSpeed.SPEED_2     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.core.model.OscillationFanSpeed r4 = com.blueair.core.model.OscillationFanSpeed.SPEED_3     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.OscillationDirection[] r0 = com.blueair.core.model.OscillationDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.OscillationDirection r4 = com.blueair.core.model.OscillationDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.STRAIGHT     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceOscillationSettingsDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    public DeviceOscillationSettingsDialogFragment() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnimator = ofFloat;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment$Companion;", "", "<init>", "()V", "ANGLES", "", "", "getANGLES", "()Ljava/util/List;", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOscillationSettingsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Integer> getANGLES() {
            return DeviceOscillationSettingsDialogFragment.ANGLES;
        }

        public final DeviceOscillationSettingsDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment = new DeviceOscillationSettingsDialogFragment();
            deviceOscillationSettingsDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceOscillationSettingsDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding;
        Window window;
        LayoutInflater layoutInflater2 = layoutInflater;
        Intrinsics.checkNotNullParameter(layoutInflater2, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        Bundle arguments = getArguments();
        HasOscillation hasOscillation = arguments != null ? (HasOscillation) arguments.getParcelable("device") : null;
        if (!(hasOscillation instanceof HasOscillation)) {
            hasOscillation = null;
        }
        boolean z = (hasOscillation instanceof HasCombo3in1MainMode) && ((HasCombo3in1MainMode) hasOscillation).currentSubMode() == ApSubMode.ECO;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        DialogfragmentDeviceOscillationSettingsBinding inflate = DialogfragmentDeviceOscillationSettingsBinding.inflate(layoutInflater2, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        TextView textView = inflate.angleLevel1;
        Intrinsics.checkNotNullExpressionValue(textView, "angleLevel1");
        TextView textView2 = inflate.angleLevel2;
        Intrinsics.checkNotNullExpressionValue(textView2, "angleLevel2");
        TextView textView3 = inflate.angleLevel3;
        Intrinsics.checkNotNullExpressionValue(textView3, "angleLevel3");
        TextView textView4 = inflate.angleLevel4;
        Intrinsics.checkNotNullExpressionValue(textView4, "angleLevel4");
        TextView textView5 = inflate.angleLevel5;
        Intrinsics.checkNotNullExpressionValue(textView5, "angleLevel5");
        this.angleBarLabels = CollectionsKt.listOf(textView, textView2, textView3, textView4, textView5);
        View view = inflate.separatorAngle1;
        Intrinsics.checkNotNullExpressionValue(view, "separatorAngle1");
        View view2 = inflate.separatorAngle2;
        Intrinsics.checkNotNullExpressionValue(view2, "separatorAngle2");
        View view3 = inflate.separatorAngle3;
        Intrinsics.checkNotNullExpressionValue(view3, "separatorAngle3");
        View view4 = inflate.separatorAngle4;
        Intrinsics.checkNotNullExpressionValue(view4, "separatorAngle4");
        View view5 = inflate.separatorAngle5;
        Intrinsics.checkNotNullExpressionValue(view5, "separatorAngle5");
        this.separatorList = CollectionsKt.listOf(view, view2, view3, view4, view5);
        inflate.cancelBtn.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda1(this));
        inflate.doneBtn.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda2(inflate, hasOscillation, this));
        inflate.fanView.setInAttribute(false);
        inflate.angleSeekbar.setOnSeekBarChangeListener(new DeviceOscillationSettingsDialogFragment$onCreateView$2$3(this, z));
        inflate.arrowLeft.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda3(this));
        inflate.arrowStraight.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda4(this));
        inflate.arrowRight.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda5(this));
        this.binding = inflate;
        if (hasOscillation != null) {
            update(hasOscillation);
        }
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding2 = this.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        } else {
            dialogfragmentDeviceOscillationSettingsBinding = dialogfragmentDeviceOscillationSettingsBinding2;
        }
        FrameLayout root = dialogfragmentDeviceOscillationSettingsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$2(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, View view) {
        deviceOscillationSettingsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$4(DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding, HasOscillation hasOscillation, DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, View view) {
        OscillationFanSpeed oscillationFanSpeed;
        int checkedRadioButtonId = dialogfragmentDeviceOscillationSettingsBinding.radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == com.blueair.devicedetails.R.id.speed_1) {
            oscillationFanSpeed = OscillationFanSpeed.SPEED_1;
        } else if (checkedRadioButtonId == com.blueair.devicedetails.R.id.speed_2) {
            oscillationFanSpeed = OscillationFanSpeed.SPEED_2;
        } else if (checkedRadioButtonId == com.blueair.devicedetails.R.id.speed_3) {
            oscillationFanSpeed = OscillationFanSpeed.SPEED_3;
        } else {
            oscillationFanSpeed = OscillationFanSpeed.SPEED_1;
        }
        if (hasOscillation != null) {
            deviceOscillationSettingsDialogFragment.getViewModel().setOscillationParams(hasOscillation, deviceOscillationSettingsDialogFragment.currentAngleBarValue(), deviceOscillationSettingsDialogFragment.currentDirection.getValue(), oscillationFanSpeed.getValue());
        }
        deviceOscillationSettingsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$5(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, View view) {
        deviceOscillationSettingsDialogFragment.currentDirection = OscillationDirection.LEFT;
        deviceOscillationSettingsDialogFragment.updateFanView();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$6(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, View view) {
        deviceOscillationSettingsDialogFragment.currentDirection = OscillationDirection.STRAIGHT;
        deviceOscillationSettingsDialogFragment.updateFanView();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$7(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, View view) {
        deviceOscillationSettingsDialogFragment.currentDirection = OscillationDirection.RIGHT;
        deviceOscillationSettingsDialogFragment.updateFanView();
    }

    private final void disableView(boolean z) {
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding2 = null;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        RadioGroup radioGroup = dialogfragmentDeviceOscillationSettingsBinding.radioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        for (View enabled : ViewGroupKt.getChildren(radioGroup)) {
            enabled.setEnabled(!z);
        }
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding3 = this.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding3 = null;
        }
        dialogfragmentDeviceOscillationSettingsBinding3.angleSeekbar.setEnabled(!z);
        Context context = getContext();
        if (context != null) {
            int color = context.getColor(z ? R.color.greyblue : R.color.colorPrimaryText);
            DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding4 = this.binding;
            if (dialogfragmentDeviceOscillationSettingsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceOscillationSettingsBinding4 = null;
            }
            dialogfragmentDeviceOscillationSettingsBinding4.angleTitle.setTextColor(color);
            DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding5 = this.binding;
            if (dialogfragmentDeviceOscillationSettingsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceOscillationSettingsBinding5 = null;
            }
            dialogfragmentDeviceOscillationSettingsBinding5.oscillationSpeedTitle.setTextColor(color);
            int color2 = context.getColor(z ? R.color.smokegray50 : R.color.smokegray);
            List<? extends View> list = this.separatorList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("separatorList");
                list = null;
            }
            for (View backgroundColor : list) {
                backgroundColor.setBackgroundColor(color2);
            }
            DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding6 = this.binding;
            if (dialogfragmentDeviceOscillationSettingsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentDeviceOscillationSettingsBinding2 = dialogfragmentDeviceOscillationSettingsBinding6;
            }
            dialogfragmentDeviceOscillationSettingsBinding2.angleSeekbar.setProgressDrawable(context.getDrawable(z ? R.drawable.progressbar_slim_gray : R.drawable.progressbar_slim));
        }
    }

    private final int currentAngleBarValue() {
        List<Integer> list = ANGLES;
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        return list.get(dialogfragmentDeviceOscillationSettingsBinding.angleSeekbar.getProgress() - 1).intValue();
    }

    private final void update(HasOscillation hasOscillation) {
        int i;
        boolean z = (hasOscillation instanceof HasCombo3in1MainMode) && ((HasCombo3in1MainMode) hasOscillation).currentSubMode() == ApSubMode.ECO;
        this.currentDirection = hasOscillation.oscillationDirection();
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        Iterator<Integer> it = ANGLES.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().intValue() >= hasOscillation.getOscillationAngle()) {
                break;
            } else {
                i2++;
            }
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i2, 0) + 1;
        if (coerceAtLeast == dialogfragmentDeviceOscillationSettingsBinding.angleSeekbar.getProgress()) {
            updateAngleBarLabels(z);
            updateFanView();
        } else {
            dialogfragmentDeviceOscillationSettingsBinding.angleSeekbar.setProgress(coerceAtLeast);
        }
        RadioGroup radioGroup = dialogfragmentDeviceOscillationSettingsBinding.radioGroup;
        int i3 = WhenMappings.$EnumSwitchMapping$0[hasOscillation.oscillationFanSpeed().ordinal()];
        if (i3 == 1) {
            i = com.blueair.devicedetails.R.id.speed_1;
        } else if (i3 == 2) {
            i = com.blueair.devicedetails.R.id.speed_2;
        } else if (i3 == 3) {
            i = com.blueair.devicedetails.R.id.speed_3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i);
        updateAngleLabel();
        disableView(z);
    }

    /* access modifiers changed from: private */
    public final void updateFanView() {
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        dialogfragmentDeviceOscillationSettingsBinding.arrowLeft.setImageResource(this.currentDirection == OscillationDirection.LEFT ? R.drawable.ic_arrow_left_on : R.drawable.ic_arrow_left_off);
        dialogfragmentDeviceOscillationSettingsBinding.arrowStraight.setImageResource(this.currentDirection == OscillationDirection.STRAIGHT ? R.drawable.ic_arrow_straight_on : R.drawable.ic_arrow_straight_off);
        dialogfragmentDeviceOscillationSettingsBinding.arrowRight.setImageResource(this.currentDirection == OscillationDirection.RIGHT ? R.drawable.ic_arrow_right_on : R.drawable.ic_arrow_right_off);
        dialogfragmentDeviceOscillationSettingsBinding.fanView.animateFanAngles(currentAngleBarValue(), this.currentDirection);
        updateDeviceImageAngle(this.currentDirection);
        updateAngleLabel();
    }

    private final void updateDeviceImageAngle(OscillationDirection oscillationDirection) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$1[oscillationDirection.ordinal()];
        if (i2 == 1) {
            i = 90;
        } else if (i2 == 2) {
            i = 0;
        } else if (i2 == 3) {
            i = -90;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.mAnimator.removeAllUpdateListeners();
        this.mAnimator.addUpdateListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda0(this, i));
        this.mAnimator.start();
    }

    /* access modifiers changed from: private */
    public static final void updateDeviceImageAngle$lambda$16(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = deviceOscillationSettingsDialogFragment.binding;
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding2 = null;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        AppCompatImageView appCompatImageView = dialogfragmentDeviceOscillationSettingsBinding.deviceImage;
        FanView.Companion companion = FanView.Companion;
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding3 = deviceOscillationSettingsDialogFragment.binding;
        if (dialogfragmentDeviceOscillationSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceOscillationSettingsBinding2 = dialogfragmentDeviceOscillationSettingsBinding3;
        }
        appCompatImageView.setRotation(companion.lerp(dialogfragmentDeviceOscillationSettingsBinding2.deviceImage.getRotation(), (float) i, floatValue));
    }

    /* access modifiers changed from: private */
    public final void updateAngleBarLabels(boolean z) {
        int i;
        Context context = getContext();
        if (context != null) {
            DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
            List<? extends TextView> list = null;
            if (dialogfragmentDeviceOscillationSettingsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceOscillationSettingsBinding = null;
            }
            int progress = dialogfragmentDeviceOscillationSettingsBinding.angleSeekbar.getProgress() - 1;
            List<? extends TextView> list2 = this.angleBarLabels;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("angleBarLabels");
            } else {
                list = list2;
            }
            int i2 = 0;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TextView textView = (TextView) next;
                if (i2 == progress) {
                    i = z ? R.color.greyblue : R.color.colorPrimaryText;
                } else {
                    i = z ? R.color.lightbluegrey50 : R.color.lightbluegrey;
                }
                textView.setTextColor(context.getColor(i));
                i2 = i3;
            }
        }
    }

    private final void updateAngleLabel() {
        DialogfragmentDeviceOscillationSettingsBinding dialogfragmentDeviceOscillationSettingsBinding = this.binding;
        String str = null;
        if (dialogfragmentDeviceOscillationSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceOscillationSettingsBinding = null;
        }
        TextView textView = dialogfragmentDeviceOscillationSettingsBinding.oscillationDiagramAngle;
        StringBuilder sb = new StringBuilder();
        sb.append(currentAngleBarValue());
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.temperature_degree);
        }
        sb.append(str);
        textView.setText(sb.toString());
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
