package com.blueair.adddevice.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.blueair.adddevice.databinding.FragmentBluetoothScanningBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanningFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lcom/blueair/adddevice/databinding/FragmentBluetoothScanningBinding;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onPause", "onDestroy", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothScanningFragment.kt */
public final class BluetoothScanningFragment extends Fragment implements ProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentBluetoothScanningBinding binding;
    private ProgressBlockerView progressBlockerView;

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanningFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/BluetoothScanningFragment;", "buildLegacyClickableSpan", "Landroid/text/style/ClickableSpan;", "linkColor", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BluetoothScanningFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BluetoothScanningFragment newInstance() {
            return new BluetoothScanningFragment();
        }

        public final ClickableSpan buildLegacyClickableSpan(int i) {
            return new BluetoothScanningFragment$Companion$buildLegacyClickableSpan$1(i);
        }
    }

    public ConstraintLayout getRootView() {
        FragmentBluetoothScanningBinding fragmentBluetoothScanningBinding = this.binding;
        if (fragmentBluetoothScanningBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanningBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentBluetoothScanningBinding.root;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root");
        return constraintLayout;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentBluetoothScanningBinding inflate = FragmentBluetoothScanningBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        ConstraintLayout constraintLayout = inflate.root;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root");
        return constraintLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        String string = getString(R.string.action_click_here);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableString spannableString = new SpannableString(getString(R.string.hint_have_legacy_device) + TokenParser.SP + string);
        CharSequence charSequence = spannableString;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        FragmentBluetoothScanningBinding fragmentBluetoothScanningBinding = null;
        if (indexOf$default != -1) {
            spannableString.setSpan(Companion.buildLegacyClickableSpan(view.getContext().getColor(R.color.colorPrimaryText)), indexOf$default, string.length() + indexOf$default, 33);
            FragmentBluetoothScanningBinding fragmentBluetoothScanningBinding2 = this.binding;
            if (fragmentBluetoothScanningBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBluetoothScanningBinding2 = null;
            }
            fragmentBluetoothScanningBinding2.scanningSubtitle.setMovementMethod(LinkMovementMethod.getInstance());
        }
        FragmentBluetoothScanningBinding fragmentBluetoothScanningBinding3 = this.binding;
        if (fragmentBluetoothScanningBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBluetoothScanningBinding = fragmentBluetoothScanningBinding3;
        }
        fragmentBluetoothScanningBinding.scanningSubtitle.setText(charSequence);
    }

    public void onPause() {
        super.onPause();
        clearProgressFragment();
    }

    public void onDestroy() {
        super.onDestroy();
        clearProgressFragment();
    }
}
