package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.auth.LocationService;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateClassicBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateClassicBinding;", "classicBinding$delegate", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateBinding;", "otherBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "confirmValidManualNetwork", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceManualUserValidateFragment.kt */
public final class AddDeviceManualUserValidateFragment extends AddDeviceBaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AddDeviceManualUserValidateFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda0(this));
    private final Lazy locationService$delegate;
    private final Lazy otherBinding$delegate = LazyKt.lazy(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda1(this));
    private ConstraintLayout rootViewForProgress;

    public AddDeviceManualUserValidateFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceManualUserValidateFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentAddDeviceManualUserValidateClassicBinding getClassicBinding() {
        return (FragmentAddDeviceManualUserValidateClassicBinding) this.classicBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceManualUserValidateClassicBinding classicBinding_delegate$lambda$0(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment) {
        ViewBinding viewBinding = addDeviceManualUserValidateFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceManualUserValidateClassicBinding) viewBinding;
    }

    private final FragmentAddDeviceManualUserValidateBinding getOtherBinding() {
        return (FragmentAddDeviceManualUserValidateBinding) this.otherBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceManualUserValidateBinding otherBinding_delegate$lambda$1(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment) {
        ViewBinding viewBinding = addDeviceManualUserValidateFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceManualUserValidateBinding) viewBinding;
    }

    public ConstraintLayout getRootView() {
        return this.rootViewForProgress;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding viewBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = getDeviceModelType() == 3;
        if (z) {
            FragmentAddDeviceManualUserValidateClassicBinding inflate = FragmentAddDeviceManualUserValidateClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceManualUserValidateBinding inflate2 = FragmentAddDeviceManualUserValidateBinding.inflate(layoutInflater, viewGroup, false);
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
        View findViewById = viewBinding3.getRoot().findViewById(R.id.buttonNo);
        Button button = findViewById instanceof Button ? (Button) findViewById : null;
        if (button != null) {
            button.setOnClickListener(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda2(z, this));
        }
        ViewBinding viewBinding4 = this.binding;
        if (viewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding4 = null;
        }
        View findViewById2 = viewBinding4.getRoot().findViewById(R.id.buttonYes);
        Button button2 = findViewById2 instanceof Button ? (Button) findViewById2 : null;
        if (button2 != null) {
            button2.setOnClickListener(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda3(this));
        }
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
    public static final void onCreateView$lambda$2(boolean z, AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, View view) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceManualUserValidateFragment$onCreateView$1$1(addDeviceManualUserValidateFragment, (Continuation<? super AddDeviceManualUserValidateFragment$onCreateView$1$1>) null), 3, (Object) null);
        if (z) {
            addDeviceManualUserValidateFragment.getAddService().restartOnboarding(false);
        } else {
            addDeviceManualUserValidateFragment.getAddService().restartManualConfig();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, View view) {
        addDeviceManualUserValidateFragment.confirmValidManualNetwork();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            getOtherBinding().imageAuto.setImageDrawable(getResources().getDrawable(R.drawable.device_aware_step1));
            getOtherBinding().textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.aware_manual);
            getOtherBinding().textAddDeviceSubtitleThree.setText(com.blueair.viewcore.R.string.isconnected);
        } else if (deviceModelType == 2) {
            getOtherBinding().imageAuto.setImageDrawable(getResources().getDrawable(R.drawable.device_sense_confirmation));
        } else if (deviceModelType == 3) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AddDeviceManualUserValidateFragment$onViewCreated$1(this, (Continuation<? super AddDeviceManualUserValidateFragment$onViewCreated$1>) null), 3, (Object) null);
        }
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceManualUserValidateFragment$onViewCreated$2(this, (Continuation<? super AddDeviceManualUserValidateFragment$onViewCreated$2>) null), 3, (Object) null);
    }

    private final void confirmValidManualNetwork() {
        CompositeDisposable asyncSubs = getAsyncSubs();
        AddDeviceUtils addDeviceUtils = AddDeviceUtils.INSTANCE;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.content.Context");
        asyncSubs.add(addDeviceUtils.validateNet(activity, getDeviceModelType()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda5(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda4(this)), new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda7(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda6())));
    }

    /* access modifiers changed from: private */
    public static final void confirmValidManualNetwork$lambda$5(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit confirmValidManualNetwork$lambda$4(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, AddDeviceUtils.NetValidation netValidation) {
        String str;
        Intrinsics.checkNotNullParameter(netValidation, "netValidation");
        if (netValidation.getValid()) {
            addDeviceManualUserValidateFragment.getAddService().validateManual();
        } else {
            if (netValidation.getConnectedWifiSSID() == null) {
                str = addDeviceManualUserValidateFragment.getString(com.blueair.viewcore.R.string.add_device_wrong_network_3);
            } else if (!Intrinsics.areEqual((Object) netValidation.getConnectedWifiSSID(), (Object) netValidation.getNotAllowedWiFISSID())) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = addDeviceManualUserValidateFragment.getString(com.blueair.viewcore.R.string.add_device_wrong_network_2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = String.format(string, Arrays.copyOf(new Object[]{netValidation.getNotAllowedWiFISSID()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            } else {
                str = addDeviceManualUserValidateFragment.getString(com.blueair.viewcore.R.string.offline_error);
            }
            Intrinsics.checkNotNull(str);
            View view = addDeviceManualUserValidateFragment.getView();
            if (addDeviceManualUserValidateFragment.isAdded() && view != null) {
                ViewUtils viewUtils = ViewUtils.INSTANCE;
                FragmentActivity requireActivity = addDeviceManualUserValidateFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                viewUtils.showError((Activity) requireActivity, str);
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void confirmValidManualNetwork$lambda$7(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit confirmValidManualNetwork$lambda$6(Throwable th) {
        Timber.Forest.e(th);
        return Unit.INSTANCE;
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
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceManualUserValidateFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceManualUserValidateFragment newInstance(int i) {
            AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment = new AddDeviceManualUserValidateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceManualUserValidateFragment.setArguments(bundle);
            return addDeviceManualUserValidateFragment;
        }
    }
}
