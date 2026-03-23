package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetupTextBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetupTextClassicBinding;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "btnNext", "Landroid/widget/Button;", "txtWrongWifi", "Landroid/widget/TextView;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceSetupTextFragment.kt */
public final class AddDeviceSetupTextFragment extends AddDeviceBaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AddDeviceSetupTextFragment.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    /* access modifiers changed from: private */
    public Button btnNext;
    private final Lazy networkMonitor$delegate;
    private ConstraintLayout rootViewForProgress;
    /* access modifiers changed from: private */
    public TextView txtWrongWifi;

    public AddDeviceSetupTextFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceSetupTextFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, NetworkMonitor.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    public ConstraintLayout getRootView() {
        return this.rootViewForProgress;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding viewBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (getDeviceModelType() == 3) {
            FragmentAddDeviceSetupTextClassicBinding inflate = FragmentAddDeviceSetupTextClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceSetupTextBinding inflate2 = FragmentAddDeviceSetupTextBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        ViewBinding viewBinding2 = null;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        this.rootViewForProgress = (ConstraintLayout) viewBinding.getRoot().findViewById(R.id.rootLayout);
        ViewBinding viewBinding3 = this.binding;
        if (viewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding3 = null;
        }
        View findViewById = viewBinding3.getRoot().findViewById(R.id.buttonNext);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.btnNext = (Button) findViewById;
        ViewBinding viewBinding4 = this.binding;
        if (viewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding4 = null;
        }
        View findViewById2 = viewBinding4.getRoot().findViewById(R.id.textWrongWifi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.txtWrongWifi = (TextView) findViewById2;
        Button button = this.btnNext;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
            button = null;
        }
        button.setOnClickListener(new AddDeviceSetupTextFragment$$ExternalSyntheticLambda0(this));
        ViewBinding viewBinding5 = this.binding;
        if (viewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewBinding2 = viewBinding5;
        }
        View root = viewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(AddDeviceSetupTextFragment addDeviceSetupTextFragment, View view) {
        if (addDeviceSetupTextFragment.getAddService().getCurrentNetworkSSIDEstimate().length() == 0) {
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentActivity requireActivity = addDeviceSetupTextFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            viewUtils.showError((Activity) requireActivity, com.blueair.viewcore.R.string.error_connect_to_network);
            return;
        }
        addDeviceSetupTextFragment.getAddService().setupTextCompleted();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AddDeviceSetupTextFragment$onViewCreated$1(this, (Continuation<? super AddDeviceSetupTextFragment$onViewCreated$1>) null), 3, (Object) null);
    }

    public void onResume() {
        super.onResume();
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.add_device));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceSetupTextFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceSetupTextFragment newInstance(int i) {
            AddDeviceSetupTextFragment addDeviceSetupTextFragment = new AddDeviceSetupTextFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceSetupTextFragment.setArguments(bundle);
            return addDeviceSetupTextFragment;
        }
    }
}
