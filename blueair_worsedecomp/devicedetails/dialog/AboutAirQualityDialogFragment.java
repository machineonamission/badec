package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.databinding.DialogfragmentAboutAirQualityBinding;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentAboutAirQualityBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureView", "", "onStart", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AboutAirQualityDialogFragment.kt */
public final class AboutAirQualityDialogFragment extends BaseDialogFragment<DeviceSensorsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DialogfragmentAboutAirQualityBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_ABOUT_AQI;
    public DeviceSensorsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AboutAirQualityDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.AboutAirQualityDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AboutAirQualityDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AboutAirQualityDialogFragment newInstance() {
            return new AboutAirQualityDialogFragment();
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceSensorsViewModel getViewModel() {
        DeviceSensorsViewModel deviceSensorsViewModel = this.viewModel;
        if (deviceSensorsViewModel != null) {
            return deviceSensorsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceSensorsViewModel deviceSensorsViewModel) {
        Intrinsics.checkNotNullParameter(deviceSensorsViewModel, "<set-?>");
        this.viewModel = deviceSensorsViewModel;
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
        BaseDialogFragment baseDialogFragment = this;
        setViewModel((DeviceSensorsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceSensorsViewModel.class)));
        DialogfragmentAboutAirQualityBinding inflate = DialogfragmentAboutAirQualityBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.btnClose.setOnClickListener(new AboutAirQualityDialogFragment$$ExternalSyntheticLambda1(this));
        this.binding = inflate;
        configureView();
        DialogfragmentAboutAirQualityBinding dialogfragmentAboutAirQualityBinding = this.binding;
        if (dialogfragmentAboutAirQualityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentAboutAirQualityBinding = null;
        }
        FrameLayout root = dialogfragmentAboutAirQualityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2$lambda$1(AboutAirQualityDialogFragment aboutAirQualityDialogFragment, View view) {
        aboutAirQualityDialogFragment.dismiss();
    }

    private final void configureView() {
        DialogfragmentAboutAirQualityBinding dialogfragmentAboutAirQualityBinding = this.binding;
        if (dialogfragmentAboutAirQualityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentAboutAirQualityBinding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentAboutAirQualityBinding.contentPm1;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "contentPm1");
        ViewExtensionsKt.show(constraintLayout, getViewModel().getSupportedSensors().contains(SensorType.PM1));
        ConstraintLayout constraintLayout2 = dialogfragmentAboutAirQualityBinding.contentPm10;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "contentPm10");
        ViewExtensionsKt.show(constraintLayout2, getViewModel().getSupportedSensors().contains(SensorType.PM10));
        ConstraintLayout constraintLayout3 = dialogfragmentAboutAirQualityBinding.contentPm25;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "contentPm25");
        ViewExtensionsKt.show(constraintLayout3, getViewModel().getSupportedSensors().contains(SensorType.PM25));
        Group group = dialogfragmentAboutAirQualityBinding.groupHum;
        Intrinsics.checkNotNullExpressionValue(group, "groupHum");
        ViewExtensionsKt.show(group, getViewModel().getSupportedSensors().contains(SensorType.HUM));
        Group group2 = dialogfragmentAboutAirQualityBinding.groupGases;
        Intrinsics.checkNotNullExpressionValue(group2, "groupGases");
        ViewExtensionsKt.show(group2, getViewModel().getSupportedSensors().contains(SensorType.VOC));
        ConstraintLayout[] constraintLayoutArr = {dialogfragmentAboutAirQualityBinding.contentPm1, dialogfragmentAboutAirQualityBinding.contentPm10, dialogfragmentAboutAirQualityBinding.contentPm25};
        int i = 0;
        while (true) {
            if (i < 3) {
                ConstraintLayout constraintLayout4 = constraintLayoutArr[i];
                Intrinsics.checkNotNull(constraintLayout4);
                if (constraintLayout4.getVisibility() == 0) {
                    break;
                }
                i++;
            } else {
                Group group3 = dialogfragmentAboutAirQualityBinding.groupParticleHeader;
                Intrinsics.checkNotNullExpressionValue(group3, "groupParticleHeader");
                ViewExtensionsKt.hide(group3);
                Group group4 = dialogfragmentAboutAirQualityBinding.groupIndoorAir;
                Intrinsics.checkNotNullExpressionValue(group4, "groupIndoorAir");
                ViewExtensionsKt.hide(group4);
                TextView textView = dialogfragmentAboutAirQualityBinding.contentTitleHum;
                Intrinsics.checkNotNullExpressionValue(textView, "contentTitleHum");
                View view = textView;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.LayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
                    view.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
        }
        double[] pm25Ranges = getViewModel().getIndoorAirRatings().getPm25Ranges();
        Collection arrayList = new ArrayList(pm25Ranges.length);
        for (double d : pm25Ranges) {
            arrayList.add(Integer.valueOf((int) d));
        }
        List list = (List) arrayList;
        dialogfragmentAboutAirQualityBinding.rangeExcellent.setText("0-" + ((Number) list.get(0)).intValue());
        TextView textView2 = dialogfragmentAboutAirQualityBinding.rangeGood;
        StringBuilder sb = new StringBuilder();
        sb.append(((Number) list.get(0)).intValue() + 1);
        sb.append('-');
        sb.append(((Number) list.get(1)).intValue());
        textView2.setText(sb.toString());
        TextView textView3 = dialogfragmentAboutAirQualityBinding.rangeModerate;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((Number) list.get(1)).intValue() + 1);
        sb2.append('-');
        sb2.append(((Number) list.get(2)).intValue());
        textView3.setText(sb2.toString());
        TextView textView4 = dialogfragmentAboutAirQualityBinding.rangePolluted;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((Number) list.get(2)).intValue() + 1);
        sb3.append('-');
        sb3.append(((Number) list.get(3)).intValue());
        textView4.setText(sb3.toString());
        TextView textView5 = dialogfragmentAboutAirQualityBinding.rangeVpolluted;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((Number) list.get(3)).intValue() + 1);
        sb4.append('-');
        sb4.append(((Number) list.get(4)).intValue());
        textView5.setText(sb4.toString());
        dialogfragmentAboutAirQualityBinding.scrollView.post(new AboutAirQualityDialogFragment$$ExternalSyntheticLambda0(this, dialogfragmentAboutAirQualityBinding));
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$8$lambda$7(AboutAirQualityDialogFragment aboutAirQualityDialogFragment, DialogfragmentAboutAirQualityBinding dialogfragmentAboutAirQualityBinding) {
        View view;
        int i = WhenMappings.$EnumSwitchMapping$0[aboutAirQualityDialogFragment.getViewModel().getSelectedSensor().ordinal()];
        if (i == 1) {
            view = dialogfragmentAboutAirQualityBinding.contentPm1;
        } else if (i == 2) {
            view = dialogfragmentAboutAirQualityBinding.contentPm10;
        } else if (i == 3) {
            view = dialogfragmentAboutAirQualityBinding.contentPm25;
        } else if (i == 4) {
            view = dialogfragmentAboutAirQualityBinding.contentTitleHum;
        } else if (i != 5) {
            view = null;
        } else {
            view = dialogfragmentAboutAirQualityBinding.contentTvoc;
        }
        if (view != null) {
            dialogfragmentAboutAirQualityBinding.scrollView.scrollTo(0, view.getTop());
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
}
