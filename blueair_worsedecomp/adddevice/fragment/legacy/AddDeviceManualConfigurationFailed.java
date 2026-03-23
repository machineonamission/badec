package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualFailBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualFailBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceManualConfigurationFailed.kt */
public final class AddDeviceManualConfigurationFailed extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentAddDeviceManualFailBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceManualConfigurationFailed.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceManualConfigurationFailed newInstance(int i) {
            AddDeviceManualConfigurationFailed addDeviceManualConfigurationFailed = new AddDeviceManualConfigurationFailed();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceManualConfigurationFailed.setArguments(bundle);
            return addDeviceManualConfigurationFailed;
        }
    }

    public ConstraintLayout getRootView() {
        FragmentAddDeviceManualFailBinding fragmentAddDeviceManualFailBinding = this.binding;
        if (fragmentAddDeviceManualFailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceManualFailBinding = null;
        }
        ConstraintLayout root = fragmentAddDeviceManualFailBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddDeviceManualFailBinding inflate = FragmentAddDeviceManualFailBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        getDeviceModelType();
        FragmentAddDeviceManualFailBinding fragmentAddDeviceManualFailBinding = this.binding;
        FragmentAddDeviceManualFailBinding fragmentAddDeviceManualFailBinding2 = null;
        if (fragmentAddDeviceManualFailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceManualFailBinding = null;
        }
        ImageView imageView = fragmentAddDeviceManualFailBinding.imgManualFail;
        Intrinsics.checkNotNullExpressionValue(imageView, "imgManualFail");
        imageView.setVisibility(4);
        FragmentAddDeviceManualFailBinding fragmentAddDeviceManualFailBinding3 = this.binding;
        if (fragmentAddDeviceManualFailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceManualFailBinding3 = null;
        }
        fragmentAddDeviceManualFailBinding3.buttonRestart.setOnClickListener(new AddDeviceManualConfigurationFailed$$ExternalSyntheticLambda0(this));
        if (getContext() != null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
        FragmentAddDeviceManualFailBinding fragmentAddDeviceManualFailBinding4 = this.binding;
        if (fragmentAddDeviceManualFailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddDeviceManualFailBinding2 = fragmentAddDeviceManualFailBinding4;
        }
        ConstraintLayout root = fragmentAddDeviceManualFailBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(AddDeviceManualConfigurationFailed addDeviceManualConfigurationFailed, View view) {
        addDeviceManualConfigurationFailed.getAddService().restartManualConfig();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (getContext() != null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }
}
