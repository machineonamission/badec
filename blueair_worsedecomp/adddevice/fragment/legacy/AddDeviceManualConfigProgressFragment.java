package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualConfigProgressBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualConfigProgressClassicBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getSpannableStringForDevice", "Landroid/text/SpannableString;", "deviceNetwork", "", "fullText", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceManualConfigProgressFragment.kt */
public final class AddDeviceManualConfigProgressFragment extends AddDeviceProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;

    public ConstraintLayout getRootView() {
        ViewBinding viewBinding = this.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        return (ConstraintLayout) root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding viewBinding;
        Resources resources;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = getDeviceModelType() == 3;
        if (z) {
            FragmentAddDeviceManualConfigProgressClassicBinding inflate = FragmentAddDeviceManualConfigProgressClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceManualConfigProgressBinding inflate2 = FragmentAddDeviceManualConfigProgressBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        ViewBinding viewBinding2 = null;
        if (!z) {
            if (viewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewBinding = null;
            }
            TextView textView = (TextView) viewBinding.getRoot().findViewById(R.id.textAddDeviceSubtitle);
            StringBuilder sb = new StringBuilder();
            Context context = getContext();
            sb.append((context == null || (resources = context.getResources()) == null) ? null : resources.getString(com.blueair.viewcore.R.string.add_device_progress_manual));
            sb.append(TokenParser.SP);
            sb.append(DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(getDeviceModelType()));
            textView.setText(getSpannableStringForDevice(DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(getDeviceModelType()), sb.toString()), TextView.BufferType.SPANNABLE);
        }
        ViewBinding viewBinding3 = this.binding;
        if (viewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewBinding2 = viewBinding3;
        }
        View root = viewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final SpannableString getSpannableStringForDevice(String str, String str2) {
        CharSequence charSequence = str2;
        String str3 = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, str3, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.blueair.viewcore.R.color.yellow_jasmine)), indexOf$default, str3.length() + indexOf$default, 33);
        return spannableString;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        if (getAddService().getState().getDeviceInfo() == null) {
            getAsyncSubs().add(getAddService().manualPairDeviceAsync().subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe((Action) new AddDeviceManualConfigProgressFragment$$ExternalSyntheticLambda0()));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0() {
        Timber.Forest.d("manualPairDeviceAsync completed", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.confirm));
            }
            hideLoading();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigProgressFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceManualConfigProgressFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceManualConfigProgressFragment newInstance(int i) {
            AddDeviceManualConfigProgressFragment addDeviceManualConfigProgressFragment = new AddDeviceManualConfigProgressFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceManualConfigProgressFragment.setArguments(bundle);
            return addDeviceManualConfigProgressFragment;
        }
    }
}
