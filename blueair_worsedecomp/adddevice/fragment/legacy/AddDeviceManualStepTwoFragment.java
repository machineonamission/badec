package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepTwoBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepTwoClassicBinding;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.connectivityhelper.NetUtil;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepTwoBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepTwoBinding;", "otherBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getSpannableStringForDevice", "Landroid/text/SpannableString;", "deviceNetwork", "", "fullText", "onViewCreated", "", "view", "handleNext", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceManualStepTwoFragment.kt */
public final class AddDeviceManualStepTwoFragment extends AddDeviceBaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AddDeviceManualStepTwoFragment.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private final Lazy networkMonitor$delegate;
    private final Lazy otherBinding$delegate = LazyKt.lazy(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda2(this));

    public AddDeviceManualStepTwoFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceManualStepTwoFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, NetworkMonitor.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    private final FragmentAddDeviceManualStepTwoBinding getOtherBinding() {
        return (FragmentAddDeviceManualStepTwoBinding) this.otherBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceManualStepTwoBinding otherBinding_delegate$lambda$0(AddDeviceManualStepTwoFragment addDeviceManualStepTwoFragment) {
        ViewBinding viewBinding = addDeviceManualStepTwoFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceManualStepTwoBinding) viewBinding;
    }

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
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (getDeviceModelType() == 3) {
            FragmentAddDeviceManualStepTwoClassicBinding inflate = FragmentAddDeviceManualStepTwoClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceManualStepTwoBinding inflate2 = FragmentAddDeviceManualStepTwoBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        ViewBinding viewBinding2 = null;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        TextView textView = (TextView) viewBinding.getRoot().findViewById(R.id.textAddDeviceSubtitle);
        String deviceModelNameForDisplay = DeviceUtilsLegacy.getDeviceModelNameForDisplay(getDeviceModelType());
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            String string = getResources().getString(com.blueair.viewcore.R.string.device_manual_wifi, new Object[]{DeviceUtilsLegacy.AWARE_CONFIG_SSID, deviceModelNameForDisplay});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (textView != null) {
                textView.setText(getSpannableStringForDevice(DeviceUtilsLegacy.AWARE_CONFIG_SSID, string), TextView.BufferType.SPANNABLE);
            }
        } else if (deviceModelType != 2) {
            Html.fromHtml(getResources().getString(com.blueair.viewcore.R.string.device_manual_wifi));
        } else {
            String string2 = getResources().getString(com.blueair.viewcore.R.string.device_manual_wifi, new Object[]{DeviceUtilsLegacy.SENSE_CONFIG_SSID, deviceModelNameForDisplay});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (textView != null) {
                textView.setText(getSpannableStringForDevice(DeviceUtilsLegacy.SENSE_CONFIG_SSID, string2), TextView.BufferType.SPANNABLE);
            }
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
        SpannableString spannableString = new SpannableString(charSequence);
        String str3 = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, str3, 0, false, 6, (Object) null);
        int length = str3.length() + indexOf$default;
        if (indexOf$default >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(getResources(), com.blueair.viewcore.R.color.yellow_jasmine, (Resources.Theme) null)), indexOf$default, length, 33);
        }
        return spannableString;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        if (getDeviceModelType() == 1 || getDeviceModelType() == 2 || getDeviceModelType() == 3) {
            ViewBinding viewBinding = this.binding;
            if (viewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewBinding = null;
            }
            viewBinding.getRoot().findViewById(R.id.buttonNext).setOnClickListener(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda0(this));
        }
        Button button = (Button) view.findViewById(R.id.btnSettings);
        if (button != null) {
            button.setOnClickListener(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda1(this));
        }
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            getOtherBinding().imageAuto.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_manual, (Resources.Theme) null));
        } else if (deviceModelType == 2) {
            getOtherBinding().imageAuto.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_sense_manual, (Resources.Theme) null));
        }
        if (getDeviceModelType() == 3) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AddDeviceManualStepTwoFragment$onViewCreated$3(this, (Continuation<? super AddDeviceManualStepTwoFragment$onViewCreated$3>) null), 3, (Object) null);
        } else {
            getAddService().setSettingsWiFiNetworkPassword("");
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AddDeviceManualStepTwoFragment addDeviceManualStepTwoFragment, View view) {
        addDeviceManualStepTwoFragment.handleNext();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(AddDeviceManualStepTwoFragment addDeviceManualStepTwoFragment, View view) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        intent.setFlags(268435456);
        addDeviceManualStepTwoFragment.startActivity(intent);
    }

    private final void handleNext() {
        String str;
        String activeWifiSSID = NetUtil.INSTANCE.getActiveWifiSSID(getActivity());
        if (activeWifiSSID == null || !Intrinsics.areEqual((Object) activeWifiSSID, (Object) DeviceUtilsLegacy.EMUALTOR_SSID)) {
            str = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(getDeviceModelType());
        } else {
            str = activeWifiSSID;
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("connectedWifiSSID: " + activeWifiSSID + ", requiredWiFISSID = " + str, new Object[0]);
        if (activeWifiSSID == null || !Intrinsics.areEqual((Object) activeWifiSSID, (Object) str)) {
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(com.blueair.viewcore.R.string.add_device_wrong_network);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            viewUtils.showError((Activity) requireActivity, format);
            return;
        }
        getAddService().manualStepCompleted();
    }

    public void onResume() {
        super.onResume();
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.add_device_title_join_config_network));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceManualStepTwoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceManualStepTwoFragment newInstance(int i) {
            AddDeviceManualStepTwoFragment addDeviceManualStepTwoFragment = new AddDeviceManualStepTwoFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceManualStepTwoFragment.setArguments(bundle);
            return addDeviceManualStepTwoFragment;
        }
    }
}
