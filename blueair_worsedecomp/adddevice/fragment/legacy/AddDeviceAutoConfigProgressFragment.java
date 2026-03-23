package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.R;
import com.blueair.adddevice.service.AddDeviceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "<init>", "()V", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoConfigProgressFragment.kt */
public final class AddDeviceAutoConfigProgressFragment extends AddDeviceProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ConstraintLayout rootView;

    public ConstraintLayout getRootView() {
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (getDeviceModelType() == 3) {
            i = R.layout.fragment_add_device_auto_config_progress_classic;
        } else {
            i = R.layout.fragment_add_device_auto_config_progress;
        }
        View inflate = layoutInflater.inflate(i, viewGroup, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.rootView = constraintLayout;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            constraintLayout = null;
        }
        TextView textView = (TextView) constraintLayout.findViewById(R.id.textAddDeviceSubtitle);
        if (textView != null) {
            textView.setText(com.blueair.viewcore.R.string.add_device_progress);
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        ConstraintLayout constraintLayout3 = this.rootView;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        return constraintLayout2;
    }

    public void onResume() {
        super.onResume();
        AddDeviceService.autoPairDevice$default(getAddService(), (String) null, (String) null, 3, (Object) null);
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.connect));
            }
            hideLoading();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoConfigProgressFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceAutoConfigProgressFragment newInstance(int i) {
            AddDeviceAutoConfigProgressFragment addDeviceAutoConfigProgressFragment = new AddDeviceAutoConfigProgressFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceAutoConfigProgressFragment.setArguments(bundle);
            return addDeviceAutoConfigProgressFragment;
        }
    }
}
