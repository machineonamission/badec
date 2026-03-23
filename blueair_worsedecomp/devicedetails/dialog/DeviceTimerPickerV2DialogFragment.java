package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceTimerPickerV2Binding;
import com.blueair.viewcore.R;
import com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onPickResult", "Lkotlin/Function1;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function1;", "setOnPickResult", "(Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;", "getBinding", "()Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;", "setBinding", "(Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimerPickerV2DialogFragment.kt */
public final class DeviceTimerPickerV2DialogFragment extends DialogFragment {
    private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
    private static final String ARG_MAX_HOUR = "ARG_MAX_HOUR";
    private static final String ARG_TIMER_SECOND = "ARG_TIMER_SECOND";
    private static final String ARG_TITLE = "ARG_TITLE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public DialogfragmentDeviceTimerPickerV2Binding binding;
    private Function1<? super Integer, Unit> onPickResult;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment$Companion;", "", "<init>", "()V", "ARG_TITLE", "", "ARG_MAX_HOUR", "ARG_TIMER_SECOND", "ARG_CYCLIC_ENABLED", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment;", "title", "maxHour", "", "timeSeconds", "cyclicEnabled", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTimerPickerV2DialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceTimerPickerV2DialogFragment newInstance$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                z = true;
            }
            return companion.newInstance(str, i, i2, z);
        }

        public final DeviceTimerPickerV2DialogFragment newInstance(String str, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            DeviceTimerPickerV2DialogFragment deviceTimerPickerV2DialogFragment = new DeviceTimerPickerV2DialogFragment();
            deviceTimerPickerV2DialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceTimerPickerV2DialogFragment.ARG_TITLE, str), TuplesKt.to(DeviceTimerPickerV2DialogFragment.ARG_MAX_HOUR, Integer.valueOf(i)), TuplesKt.to(DeviceTimerPickerV2DialogFragment.ARG_TIMER_SECOND, Integer.valueOf(i2)), TuplesKt.to(DeviceTimerPickerV2DialogFragment.ARG_CYCLIC_ENABLED, Boolean.valueOf(z))));
            return deviceTimerPickerV2DialogFragment;
        }
    }

    public final Function1<Integer, Unit> getOnPickResult() {
        return this.onPickResult;
    }

    public final void setOnPickResult(Function1<? super Integer, Unit> function1) {
        this.onPickResult = function1;
    }

    public final DialogfragmentDeviceTimerPickerV2Binding getBinding() {
        DialogfragmentDeviceTimerPickerV2Binding dialogfragmentDeviceTimerPickerV2Binding = this.binding;
        if (dialogfragmentDeviceTimerPickerV2Binding != null) {
            return dialogfragmentDeviceTimerPickerV2Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogfragmentDeviceTimerPickerV2Binding dialogfragmentDeviceTimerPickerV2Binding) {
        Intrinsics.checkNotNullParameter(dialogfragmentDeviceTimerPickerV2Binding, "<set-?>");
        this.binding = dialogfragmentDeviceTimerPickerV2Binding;
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
        DialogfragmentDeviceTimerPickerV2Binding inflate = DialogfragmentDeviceTimerPickerV2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        DialogfragmentDeviceTimerPickerV2Binding binding2 = getBinding();
        binding2.btnClose.setOnClickListener(new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda0(this));
        DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1 deviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1 = new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1();
        binding2.wheelHour.setFormatter(deviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1);
        binding2.wheelMinute.setFormatter(deviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1);
        OnWheelChangedListener deviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1 = new DeviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1(binding2);
        binding2.wheelMinute.setOnWheelChangedListener(deviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1);
        binding2.wheelHour.setOnWheelChangedListener(deviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int coerceAtLeast = RangesKt.coerceAtLeast(arguments.getInt(ARG_MAX_HOUR) - 1, 0);
            int i = arguments.getInt(ARG_TIMER_SECOND);
            int i2 = i / DateTimeConstants.SECONDS_PER_HOUR;
            binding2.wheelHour.setData(CollectionsKt.toMutableList(new IntRange(0, coerceAtLeast)));
            binding2.wheelHour.setDefaultValue(Integer.valueOf(i2));
            binding2.wheelMinute.setData(CollectionsKt.toMutableList(new IntRange(0, 59)));
            binding2.wheelMinute.setDefaultValue(Integer.valueOf((i / 60) - (i2 * 60)));
            WheelView wheelView = binding2.wheelHour;
            wheelView.setTypeface(ResourcesCompat.getFont(requireContext(), R.font.gilroy_medium));
            wheelView.setCyclicEnabled(arguments.getBoolean(ARG_CYCLIC_ENABLED));
            WheelView wheelView2 = binding2.wheelMinute;
            wheelView2.setTypeface(ResourcesCompat.getFont(requireContext(), R.font.gilroy_medium));
            wheelView2.setCyclicEnabled(arguments.getBoolean(ARG_CYCLIC_ENABLED));
            binding2.title.setText(arguments.getString(ARG_TITLE));
        }
        binding2.btnDone.setOnClickListener(new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda2(binding2, this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$7$lambda$1(DeviceTimerPickerV2DialogFragment deviceTimerPickerV2DialogFragment, View view) {
        deviceTimerPickerV2DialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final String onCreateView$lambda$7$lambda$2(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (!(obj instanceof Integer)) {
            return String.valueOf(obj);
        }
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{obj}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$7$lambda$6(DialogfragmentDeviceTimerPickerV2Binding dialogfragmentDeviceTimerPickerV2Binding, DeviceTimerPickerV2DialogFragment deviceTimerPickerV2DialogFragment, View view) {
        Integer num = (Integer) dialogfragmentDeviceTimerPickerV2Binding.wheelHour.getCurrentItem();
        Integer num2 = (Integer) dialogfragmentDeviceTimerPickerV2Binding.wheelMinute.getCurrentItem();
        if (num == null || num.intValue() != 0 || num2 == null || num2.intValue() != 0) {
            Function1<? super Integer, Unit> function1 = deviceTimerPickerV2DialogFragment.onPickResult;
            if (function1 != null) {
                function1.invoke(Integer.valueOf((num.intValue() * DateTimeConstants.SECONDS_PER_HOUR) + (num2.intValue() * 60)));
            }
            deviceTimerPickerV2DialogFragment.dismiss();
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }
}
