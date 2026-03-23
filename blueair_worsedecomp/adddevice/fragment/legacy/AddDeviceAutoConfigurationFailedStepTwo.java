package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding;
import com.blueair.adddevice.databinding.FragmentClassicFailWifiBinding;
import com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentClassicFailWifiBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentClassicFailWifiBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "senseBinding", "Lcom/blueair/adddevice/databinding/FragmentSenseFailWifiBinding;", "getSenseBinding", "()Lcom/blueair/adddevice/databinding/FragmentSenseFailWifiBinding;", "senseBinding$delegate", "awareBinding", "Lcom/blueair/adddevice/databinding/FragmentAwareFailTwoBinding;", "getAwareBinding", "()Lcom/blueair/adddevice/databinding/FragmentAwareFailTwoBinding;", "awareBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleNextClick", "updateNextButton", "deviceModelType", "", "Companion", "onRadioButtonChanged", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoConfigurationFailedStepTwo.kt */
public final class AddDeviceAutoConfigurationFailedStepTwo extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy awareBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda7(this));
    private ViewBinding binding;
    private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda5(this));
    private ConstraintLayout rootViewForProgress;
    private final Lazy senseBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda6(this));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoConfigurationFailedStepTwo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceAutoConfigurationFailedStepTwo newInstance(int i) {
            AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo = new AddDeviceAutoConfigurationFailedStepTwo();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceAutoConfigurationFailedStepTwo.setArguments(bundle);
            return addDeviceAutoConfigurationFailedStepTwo;
        }
    }

    /* access modifiers changed from: private */
    public static final FragmentClassicFailWifiBinding classicBinding_delegate$lambda$0(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepTwo.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentClassicFailWifiBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public final FragmentClassicFailWifiBinding getClassicBinding() {
        return (FragmentClassicFailWifiBinding) this.classicBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentSenseFailWifiBinding getSenseBinding() {
        return (FragmentSenseFailWifiBinding) this.senseBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentSenseFailWifiBinding senseBinding_delegate$lambda$1(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepTwo.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentSenseFailWifiBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public static final FragmentAwareFailTwoBinding awareBinding_delegate$lambda$2(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepTwo.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAwareFailTwoBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public final FragmentAwareFailTwoBinding getAwareBinding() {
        return (FragmentAwareFailTwoBinding) this.awareBinding$delegate.getValue();
    }

    public ConstraintLayout getRootView() {
        return this.rootViewForProgress;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            FragmentAwareFailTwoBinding inflate = FragmentAwareFailTwoBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
        } else if (deviceModelType == 2) {
            FragmentSenseFailWifiBinding inflate2 = FragmentSenseFailWifiBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            this.binding = inflate2;
        } else if (deviceModelType == 3) {
            FragmentClassicFailWifiBinding inflate3 = FragmentClassicFailWifiBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
            this.binding = inflate3;
        }
        ViewBinding viewBinding = this.binding;
        ViewBinding viewBinding2 = null;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        this.rootViewForProgress = (ConstraintLayout) viewBinding.getRoot().findViewById(R.id.rootLayout);
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

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.device_aware_flashing_blue);
            getAwareBinding().imageFailBlueFlash.setImageDrawable(create);
            if (create != null) {
                create.start();
            }
            if (create != null) {
                create.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$7(create));
            }
            AnimatedVectorDrawableCompat create2 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.device_aware_flashing_orange);
            getAwareBinding().imageFailOrangeFlash.setImageDrawable(create2);
            if (create2 != null) {
                create2.start();
            }
            if (create2 != null) {
                create2.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$8(create2));
            }
            getAwareBinding().radioBtnBlueFlash.setOnCheckedChangeListener(new onRadioButtonChanged());
            getAwareBinding().radioBtnOrangeFlash.setOnCheckedChangeListener(new onRadioButtonChanged());
            getAwareBinding().buttonNextAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda4(this));
        } else if (deviceModelType == 2) {
            AnimatedVectorDrawableCompat create3 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.sense_ring_solid_wifi_blinking);
            getSenseBinding().imageFailFlashingFasterSense.setImageDrawable(create3);
            if (create3 != null) {
                create3.start();
            }
            if (create3 != null) {
                create3.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$2(create3));
            }
            AnimatedVectorDrawableCompat create4 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.sense_ring_solid_wifi_fading);
            getSenseBinding().imageFailFlashingSlowerSense.setImageDrawable(create4);
            if (create4 != null) {
                create4.start();
            }
            if (create4 != null) {
                create4.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$3(create4));
            }
            getSenseBinding().imageBackgroundOne.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda1(this));
            getSenseBinding().imageBackgroundTwo.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda2(this));
            getSenseBinding().radioBtnWifiFlashingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            getSenseBinding().radioBtnWifiPulsingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            getSenseBinding().buttonNextSense.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda3(this));
        } else if (deviceModelType == 3) {
            getClassicBinding().buttonNextClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda0(this));
            Drawable drawable = getClassicBinding().imageFailFlashingFaster.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            ((AnimationDrawable) drawable).start();
            Drawable drawable2 = getClassicBinding().imageFailFlashingSlower.getDrawable();
            Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable2;
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.setExitFadeDuration(2000);
            animationDrawable.start();
            getClassicBinding().radioBtnFailFlashSlower.setOnCheckedChangeListener(new onRadioButtonChanged());
            getClassicBinding().radioBtnFailFlashFaster.setOnCheckedChangeListener(new onRadioButtonChanged());
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo, View view) {
        addDeviceAutoConfigurationFailedStepTwo.handleNextClick();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo, View view) {
        addDeviceAutoConfigurationFailedStepTwo.getSenseBinding().radioBtnWifiFlashingSense.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo, View view) {
        addDeviceAutoConfigurationFailedStepTwo.getSenseBinding().radioBtnWifiPulsingSense.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo, View view) {
        addDeviceAutoConfigurationFailedStepTwo.handleNextClick();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo, View view) {
        addDeviceAutoConfigurationFailedStepTwo.handleNextClick();
    }

    private final void handleNextClick() {
        Timber.Forest.d("handleNextClick()", new Object[0]);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType != 1) {
            if (deviceModelType != 2) {
                if (deviceModelType == 3) {
                    if (getClassicBinding().radioBtnFailFlashFaster.isChecked()) {
                        Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
                        getAddService().startManualConfig();
                    } else if (getClassicBinding().radioBtnFailFlashSlower.isChecked()) {
                        Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
                        getAddService().startManualStepTwo();
                    } else {
                        Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            ViewUtils.INSTANCE.showError((Activity) activity, com.blueair.viewcore.R.string.error_select_option);
                        }
                    }
                }
            } else if (getSenseBinding().radioBtnWifiFlashingSense.isChecked()) {
                Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
                getAddService().startManualConfig();
            } else if (getSenseBinding().radioBtnWifiPulsingSense.isChecked()) {
                Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
                getAddService().startManualStepTwo();
            } else {
                Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ViewUtils.INSTANCE.showError((Activity) activity2, com.blueair.viewcore.R.string.error_select_option);
                }
            }
        } else if (getAwareBinding().radioBtnBlueFlash.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
            getAddService().startManualConfig();
        } else if (getAwareBinding().radioBtnOrangeFlash.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
            getAddService().startManualStepTwo();
        } else {
            Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                ViewUtils.INSTANCE.showError((Activity) activity3, com.blueair.viewcore.R.string.error_select_option);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateNextButton(int i) {
        if (i == 1) {
            getAwareBinding().buttonNextAware.setEnabled(true);
            getAwareBinding().buttonNextAware.setText(getResources().getString(com.blueair.viewcore.R.string.button_next));
        } else if (i == 2) {
            getSenseBinding().buttonNextSense.setEnabled(true);
            getSenseBinding().buttonNextSense.setText(getResources().getString(com.blueair.viewcore.R.string.button_next));
        } else if (i == 3) {
            getClassicBinding().buttonNextClassic.setEnabled(true);
            getClassicBinding().buttonNextClassic.setText(getResources().getString(com.blueair.viewcore.R.string.button_next));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo$onRadioButtonChanged;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoConfigurationFailedStepTwo.kt */
    private final class onRadioButtonChanged implements CompoundButton.OnCheckedChangeListener {
        public onRadioButtonChanged() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                AddDeviceAutoConfigurationFailedStepTwo addDeviceAutoConfigurationFailedStepTwo = AddDeviceAutoConfigurationFailedStepTwo.this;
                addDeviceAutoConfigurationFailedStepTwo.updateNextButton(addDeviceAutoConfigurationFailedStepTwo.getDeviceModelType());
                Integer valueOf = compoundButton != null ? Integer.valueOf(compoundButton.getId()) : null;
                int i = R.id.radioBtnFailFlashFaster;
                if (valueOf != null && valueOf.intValue() == i) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getClassicBinding().radioBtnFailFlashSlower.setChecked(false);
                    return;
                }
                int i2 = R.id.radioBtnFailFlashSlower;
                if (valueOf != null && valueOf.intValue() == i2) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getClassicBinding().radioBtnFailFlashFaster.setChecked(false);
                    return;
                }
                int i3 = R.id.radioBtnWifiPulsingSense;
                if (valueOf != null && valueOf.intValue() == i3) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getSenseBinding().radioBtnWifiFlashingSense.setChecked(false);
                    return;
                }
                int i4 = R.id.radioBtnWifiFlashingSense;
                if (valueOf != null && valueOf.intValue() == i4) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getSenseBinding().radioBtnWifiPulsingSense.setChecked(false);
                    return;
                }
                int i5 = R.id.radioBtnBlueFlash;
                if (valueOf != null && valueOf.intValue() == i5) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getAwareBinding().radioBtnOrangeFlash.setChecked(false);
                    return;
                }
                int i6 = R.id.radioBtnOrangeFlash;
                if (valueOf != null && valueOf.intValue() == i6) {
                    AddDeviceAutoConfigurationFailedStepTwo.this.getAwareBinding().radioBtnBlueFlash.setChecked(false);
                }
            }
        }
    }
}
