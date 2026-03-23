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
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHTimerPickerBinding;
import com.blueair.viewcore.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onPickResult", "Lkotlin/Function1;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function1;", "setOnPickResult", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimerPickerDialogFragment.kt */
public final class DeviceTimerPickerDialogFragment extends DialogFragment {
    private static final String ARG_CURRENT_INDEX = "ARG_CURRENT_INDEX";
    private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
    private static final String ARG_TITLE = "ARG_TITLE";
    private static final String ARG_VALUE_LIST = "ARG_VALUE_LIST";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Function1<? super Integer, Unit> onPickResult;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment$Companion;", "", "<init>", "()V", "ARG_VALUE_LIST", "", "ARG_CURRENT_INDEX", "ARG_CYCLIC_ENABLED", "ARG_TITLE", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment;", "title", "valueList", "", "currentIndex", "", "cyclicEnabled", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTimerPickerDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceTimerPickerDialogFragment newInstance$default(Companion companion, String str, List list, int i, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                z = true;
            }
            return companion.newInstance(str, list, i, z);
        }

        public final DeviceTimerPickerDialogFragment newInstance(String str, List<String> list, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "valueList");
            DeviceTimerPickerDialogFragment deviceTimerPickerDialogFragment = new DeviceTimerPickerDialogFragment();
            deviceTimerPickerDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceTimerPickerDialogFragment.ARG_TITLE, str), TuplesKt.to(DeviceTimerPickerDialogFragment.ARG_VALUE_LIST, list), TuplesKt.to(DeviceTimerPickerDialogFragment.ARG_CURRENT_INDEX, Integer.valueOf(i)), TuplesKt.to(DeviceTimerPickerDialogFragment.ARG_CYCLIC_ENABLED, Boolean.valueOf(z))));
            return deviceTimerPickerDialogFragment;
        }
    }

    public final Function1<Integer, Unit> getOnPickResult() {
        return this.onPickResult;
    }

    public final void setOnPickResult(Function1<? super Integer, Unit> function1) {
        this.onPickResult = function1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        DialogfragmentDeviceHTimerPickerBinding inflate = DialogfragmentDeviceHTimerPickerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.timerPickerCancel.setOnClickListener(new DeviceTimerPickerDialogFragment$$ExternalSyntheticLambda0(this));
        inflate.timerPickerDone.setOnClickListener(new DeviceTimerPickerDialogFragment$$ExternalSyntheticLambda1(this, inflate));
        Bundle requireArguments = requireArguments();
        ArrayList<String> stringArrayList = requireArguments.getStringArrayList(ARG_VALUE_LIST);
        if (stringArrayList != null) {
            int i = requireArguments.getInt(ARG_CURRENT_INDEX, 0);
            WheelView wheelView = inflate.timerPicker;
            wheelView.setData(stringArrayList);
            wheelView.scrollTo(i);
            wheelView.setTypeface(ResourcesCompat.getFont(requireContext(), R.font.gilroy));
            wheelView.setCyclicEnabled(requireArguments.getBoolean(ARG_CYCLIC_ENABLED));
            inflate.title.setText(requireArguments.getString(ARG_TITLE));
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5$lambda$1(DeviceTimerPickerDialogFragment deviceTimerPickerDialogFragment, View view) {
        deviceTimerPickerDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5$lambda$2(DeviceTimerPickerDialogFragment deviceTimerPickerDialogFragment, DialogfragmentDeviceHTimerPickerBinding dialogfragmentDeviceHTimerPickerBinding, View view) {
        Function1<? super Integer, Unit> function1 = deviceTimerPickerDialogFragment.onPickResult;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(dialogfragmentDeviceHTimerPickerBinding.timerPicker.getCurrentPosition()));
        }
        deviceTimerPickerDialogFragment.dismiss();
    }
}
