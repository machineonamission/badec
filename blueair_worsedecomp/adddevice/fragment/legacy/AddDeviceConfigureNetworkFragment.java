package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.NetworkStateReceiver;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceConfigureNetworkBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceConfigureNetworkClassicBinding;
import com.blueair.viewcore.ViewUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.textfield.TextInputLayout;
import io.flatcircle.connectivityhelper.NetUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "mDeviceConfigurationMode", "", "getMDeviceConfigurationMode$annotations", "mWifiNetworkSSID", "", "mNetworkStateReceiver", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$NetworkBroadcastReceiver;", "hasEnteredText", "", "binding", "Landroidx/viewbinding/ViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onResume", "onPause", "updateNextButtonState", "NetworkBroadcastReceiver", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceConfigureNetworkFragment.kt */
public final class AddDeviceConfigureNetworkFragment extends AddDeviceBaseFragment {
    /* access modifiers changed from: private */
    public static final String ARG_DEVICE_CONFIGURATION_MODE = "mDeviceConfigurationMode";
    /* access modifiers changed from: private */
    public static final String ARG_WIFI_NETWORK_PASSWORD = "mWifiNetworkPassword";
    /* access modifiers changed from: private */
    public static final String ARG_WIFI_NETWORK_SSID = "mWifiNetworkSSID";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    /* access modifiers changed from: private */
    public boolean hasEnteredText;
    private int mDeviceConfigurationMode;
    private NetworkBroadcastReceiver mNetworkStateReceiver = new NetworkBroadcastReceiver();
    private String mWifiNetworkSSID;

    private static /* synthetic */ void getMDeviceConfigurationMode$annotations() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mDeviceConfigurationMode = arguments.getInt(ARG_DEVICE_CONFIGURATION_MODE);
            String str = ARG_WIFI_NETWORK_SSID;
            if (!Intrinsics.areEqual((Object) arguments.getString(str), (Object) "<unknown ssid>")) {
                this.mWifiNetworkSSID = arguments.getString(str);
            }
        }
        this.hasEnteredText = false;
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
            FragmentAddDeviceConfigureNetworkClassicBinding inflate = FragmentAddDeviceConfigureNetworkClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceConfigureNetworkBinding inflate2 = FragmentAddDeviceConfigureNetworkBinding.inflate(layoutInflater, viewGroup, false);
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
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            textView.setText(com.blueair.viewcore.R.string.add_device_network_subtitle_aware);
        } else if (deviceModelType == 2) {
            textView.setText(com.blueair.viewcore.R.string.add_device_network_subtitle_sense);
        } else if (deviceModelType == 3) {
            textView.setText(com.blueair.viewcore.R.string.add_device_network_subtitle_classic);
        }
        ViewBinding viewBinding3 = this.binding;
        if (viewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding3 = null;
        }
        TextView textView2 = (TextView) viewBinding3.getRoot().findViewById(R.id.editTextSSID);
        String str = this.mWifiNetworkSSID;
        textView2.setText(str != null ? StringsKt.trim((CharSequence) str).toString() : null);
        ViewBinding viewBinding4 = this.binding;
        if (viewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding4 = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) viewBinding4.getRoot().findViewById(R.id.passwordViewContainer);
        ViewBinding viewBinding5 = this.binding;
        if (viewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding5 = null;
        }
        EditText editText = (EditText) viewBinding5.getRoot().findViewById(R.id.editTextPassword);
        editText.addTextChangedListener(new AddDeviceConfigureNetworkFragment$onCreateView$1(this, textInputLayout));
        editText.setText(getAddService().getWifiPassword());
        ViewBinding viewBinding6 = this.binding;
        if (viewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding6 = null;
        }
        ((Button) viewBinding6.getRoot().findViewById(R.id.buttonNext)).setOnClickListener(new AddDeviceConfigureNetworkFragment$$ExternalSyntheticLambda0(this, editText, textInputLayout, textView2));
        ViewBinding viewBinding7 = this.binding;
        if (viewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewBinding2 = viewBinding7;
        }
        View root = viewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$1(AddDeviceConfigureNetworkFragment addDeviceConfigureNetworkFragment, EditText editText, TextInputLayout textInputLayout, TextView textView, View view) {
        if (addDeviceConfigureNetworkFragment.getDeviceModelType() != 3 || editText.getText().length() >= 8) {
            String activeWifiSSID = NetUtil.INSTANCE.getActiveWifiSSID(addDeviceConfigureNetworkFragment.getActivity());
            String activeWifiBSSID = NetUtil.INSTANCE.getActiveWifiBSSID(addDeviceConfigureNetworkFragment.getActivity());
            String manualModeWiFiSSID = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(addDeviceConfigureNetworkFragment.getDeviceModelType());
            Timber.Forest forest = Timber.Forest;
            forest.d("connectedWifiSSID: " + activeWifiSSID + ", requiredManualWiFiSSID: " + manualModeWiFiSSID, new Object[0]);
            if (addDeviceConfigureNetworkFragment.mDeviceConfigurationMode != 0 || activeWifiSSID == null || Intrinsics.areEqual((Object) activeWifiSSID, (Object) manualModeWiFiSSID)) {
                if (activeWifiSSID != null && Intrinsics.areEqual((Object) activeWifiSSID, (Object) DeviceUtilsLegacy.EMUALTOR_SSID)) {
                    manualModeWiFiSSID = activeWifiSSID;
                }
                if (activeWifiSSID == null || !Intrinsics.areEqual((Object) activeWifiSSID, (Object) manualModeWiFiSSID)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = addDeviceConfigureNetworkFragment.getString(com.blueair.viewcore.R.string.add_device_wrong_network);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{manualModeWiFiSSID}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    FragmentActivity activity = addDeviceConfigureNetworkFragment.getActivity();
                    if (activity != null) {
                        ViewUtils.INSTANCE.showError((Activity) activity, format);
                        return;
                    }
                    return;
                }
                addDeviceConfigureNetworkFragment.getAddService().setNetworkInfo(activeWifiBSSID, textView.getText().toString(), editText.getText().toString());
                return;
            }
            addDeviceConfigureNetworkFragment.getAddService().setNetworkInfo(activeWifiBSSID, textView.getText().toString(), editText.getText().toString());
            return;
        }
        textInputLayout.setEndIconMode(1);
        textInputLayout.setEndIconMode(0);
        editText.requestFocus();
        editText.setError(addDeviceConfigureNetworkFragment.getString(com.blueair.viewcore.R.string.error_wifi_password_validation));
    }

    public void onStart() {
        super.onStart();
        updateNextButtonState();
    }

    public void onResume() {
        ActionBar supportActionBar;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (!(activity == null || getDeviceModelType() != 3 || (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) == null)) {
            supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.connect));
        }
        NetworkStateReceiver.registerReceiver(getContext(), this.mNetworkStateReceiver);
    }

    public void onPause() {
        super.onPause();
        NetworkStateReceiver.unregisterReceiver(getContext(), this.mNetworkStateReceiver);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$NetworkBroadcastReceiver;", "Lcom/blueair/adddevice/NetworkStateReceiver;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;)V", "connected", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isConnected", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceConfigureNetworkFragment.kt */
    public final class NetworkBroadcastReceiver extends NetworkStateReceiver {
        public NetworkBroadcastReceiver() {
        }

        /* access modifiers changed from: protected */
        public void connected(Context context, Intent intent, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            super.connected(context, intent, z);
            AddDeviceConfigureNetworkFragment.this.updateNextButtonState();
        }
    }

    /* access modifiers changed from: private */
    public final void updateNextButtonState() {
        boolean z;
        int i;
        boolean z2 = false;
        Timber.Forest.d("updateNextButtonState()", new Object[0]);
        View view = getView();
        if (view != null) {
            View findViewById = view.findViewById(R.id.editTextSSID);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.editTextPassword);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.EditText");
            EditText editText = (EditText) findViewById2;
            if (textView.getText().toString().length() == 0) {
                if (this.hasEnteredText) {
                    textView.setError(getString(com.blueair.viewcore.R.string.both_step3_no_ssid));
                }
                z = false;
            } else {
                z = true;
            }
            if (editText.getText().toString().length() == 0) {
                if (this.hasEnteredText && getDeviceModelType() != 3) {
                    editText.setError(getString(com.blueair.viewcore.R.string.both_step3_no_password));
                }
                z = false;
            }
            if (NetUtil.INSTANCE.isWifiConnected(getActivity())) {
                z2 = z;
            }
            View findViewById3 = view.findViewById(R.id.buttonNext);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) findViewById3;
            button.setEnabled(z2);
            if (getDeviceModelType() == 3) {
                if (z2) {
                    i = com.blueair.viewcore.R.color.marineblue;
                } else {
                    i = com.blueair.viewcore.R.color.greyblue;
                }
                button.setBackgroundColor(ResourcesCompat.getColor(getResources(), i, (Resources.Theme) null));
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$Companion;", "", "<init>", "()V", "ARG_DEVICE_CONFIGURATION_MODE", "", "getARG_DEVICE_CONFIGURATION_MODE", "()Ljava/lang/String;", "ARG_WIFI_NETWORK_SSID", "getARG_WIFI_NETWORK_SSID", "ARG_WIFI_NETWORK_PASSWORD", "getARG_WIFI_NETWORK_PASSWORD", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment;", "deviceModelType", "", "deviceConfigurationMode", "wifiNetworkSSID", "wifiNetworkPassword", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceConfigureNetworkFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getARG_DEVICE_CONFIGURATION_MODE() {
            return AddDeviceConfigureNetworkFragment.ARG_DEVICE_CONFIGURATION_MODE;
        }

        public final String getARG_WIFI_NETWORK_SSID() {
            return AddDeviceConfigureNetworkFragment.ARG_WIFI_NETWORK_SSID;
        }

        public final String getARG_WIFI_NETWORK_PASSWORD() {
            return AddDeviceConfigureNetworkFragment.ARG_WIFI_NETWORK_PASSWORD;
        }

        public final AddDeviceConfigureNetworkFragment newInstance(int i, int i2, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "wifiNetworkSSID");
            Intrinsics.checkNotNullParameter(str2, "wifiNetworkPassword");
            AddDeviceConfigureNetworkFragment addDeviceConfigureNetworkFragment = new AddDeviceConfigureNetworkFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            bundle.putInt(getARG_DEVICE_CONFIGURATION_MODE(), i2);
            bundle.putString(getARG_WIFI_NETWORK_SSID(), str);
            bundle.putString(getARG_WIFI_NETWORK_PASSWORD(), str2);
            addDeviceConfigureNetworkFragment.setArguments(bundle);
            return addDeviceConfigureNetworkFragment;
        }
    }
}
