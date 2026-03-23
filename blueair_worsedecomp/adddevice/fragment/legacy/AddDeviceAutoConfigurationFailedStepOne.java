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
import com.blueair.adddevice.databinding.FragmentAwareFailOneBinding;
import com.blueair.adddevice.databinding.FragmentClassicFailRingBinding;
import com.blueair.adddevice.databinding.FragmentSenseFailRingBinding;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentClassicFailRingBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentClassicFailRingBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "senseBinding", "Lcom/blueair/adddevice/databinding/FragmentSenseFailRingBinding;", "getSenseBinding", "()Lcom/blueair/adddevice/databinding/FragmentSenseFailRingBinding;", "senseBinding$delegate", "awareBinding", "Lcom/blueair/adddevice/databinding/FragmentAwareFailOneBinding;", "getAwareBinding", "()Lcom/blueair/adddevice/databinding/FragmentAwareFailOneBinding;", "awareBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleNextClick", "updateNextButton", "deviceModelType", "", "Companion", "onRadioButtonChanged", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoConfigurationFailedStepOne.kt */
public final class AddDeviceAutoConfigurationFailedStepOne extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy awareBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda5(this));
    private ViewBinding binding;
    private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda3(this));
    private ConstraintLayout rootViewForProgress;
    private final Lazy senseBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda4(this));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoConfigurationFailedStepOne.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceAutoConfigurationFailedStepOne newInstance(int i) {
            AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne = new AddDeviceAutoConfigurationFailedStepOne();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceAutoConfigurationFailedStepOne.setArguments(bundle);
            return addDeviceAutoConfigurationFailedStepOne;
        }
    }

    /* access modifiers changed from: private */
    public static final FragmentClassicFailRingBinding classicBinding_delegate$lambda$0(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepOne.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentClassicFailRingBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public final FragmentClassicFailRingBinding getClassicBinding() {
        return (FragmentClassicFailRingBinding) this.classicBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentSenseFailRingBinding getSenseBinding() {
        return (FragmentSenseFailRingBinding) this.senseBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentSenseFailRingBinding senseBinding_delegate$lambda$1(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepOne.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentSenseFailRingBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public static final FragmentAwareFailOneBinding awareBinding_delegate$lambda$2(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne) {
        ViewBinding viewBinding = addDeviceAutoConfigurationFailedStepOne.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAwareFailOneBinding) viewBinding;
    }

    /* access modifiers changed from: private */
    public final FragmentAwareFailOneBinding getAwareBinding() {
        return (FragmentAwareFailOneBinding) this.awareBinding$delegate.getValue();
    }

    public ConstraintLayout getRootView() {
        return this.rootViewForProgress;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            FragmentAwareFailOneBinding inflate = FragmentAwareFailOneBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
        } else if (deviceModelType == 2) {
            FragmentSenseFailRingBinding inflate2 = FragmentSenseFailRingBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            this.binding = inflate2;
        } else if (deviceModelType == 3) {
            FragmentClassicFailRingBinding inflate3 = FragmentClassicFailRingBinding.inflate(layoutInflater, viewGroup, false);
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
            getAwareBinding().imageFailFlashingFastAware.setImageDrawable(create);
            if (create != null) {
                create.start();
            }
            if (create != null) {
                create.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepOne$onViewCreated$11(create));
            }
            AnimatedVectorDrawableCompat create2 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.device_aware_pulsing_blue);
            getAwareBinding().imageFailFadingSlowAware.setImageDrawable(create2);
            if (create2 != null) {
                create2.start();
            }
            if (create2 != null) {
                create2.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepOne$onViewCreated$12(create2));
            }
            getAwareBinding().radioBtnFailFlashingAware.setOnCheckedChangeListener(new onRadioButtonChanged());
            getAwareBinding().radioBtnFailFadingAware.setOnCheckedChangeListener(new onRadioButtonChanged());
            getAwareBinding().radioBtnFailSolidAware.setOnCheckedChangeListener(new onRadioButtonChanged());
            getAwareBinding().imageFailFlashingFastAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda1(this));
            getAwareBinding().imageFailFadingSlowAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda2(this));
            getAwareBinding().imageFailSolidAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda6(this));
            getAwareBinding().buttonNextAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda7(this));
        } else if (deviceModelType == 2) {
            AnimatedVectorDrawableCompat create3 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.sense_ring_solid_wifi_blinking);
            getSenseBinding().imageFailRingSolidWifiFlashingSense.setImageDrawable(create3);
            if (create3 != null) {
                create3.start();
            }
            if (create3 != null) {
                create3.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepOne$onViewCreated$5(create3));
            }
            AnimatedVectorDrawableCompat create4 = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.sense_ring_wifi_fading);
            getSenseBinding().imageFailRingWifiFadingSense.setImageDrawable(create4);
            if (create4 != null) {
                create4.start();
            }
            if (create4 != null) {
                create4.registerAnimationCallback(new AddDeviceAutoConfigurationFailedStepOne$onViewCreated$6(create4));
            }
            getSenseBinding().imageBackgroundOne.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda11(this));
            getSenseBinding().imageBackgroundTwo.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda12(this));
            getSenseBinding().imageBackgroundThree.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda13(this));
            getSenseBinding().radioBtnRingSolidWifiFlashingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            getSenseBinding().radioBtnRingWifiFadingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            getSenseBinding().radioBtnRingWifiSolidSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            getSenseBinding().buttonNextSense.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda14(this));
        } else if (deviceModelType == 3) {
            Drawable drawable = getClassicBinding().imageFailRingFlashingClassic.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            ((AnimationDrawable) drawable).start();
            getClassicBinding().radioBtnFailRingSolidClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
            getClassicBinding().radioBtnFailRingFlashingClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
            getClassicBinding().radioBtnFailWifiSolidClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
            getClassicBinding().imageFailSolidRingClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda0(this));
            getClassicBinding().imageFailRingFlashingClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda8(this));
            getClassicBinding().imageFailRingFadedClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda9(this));
            getClassicBinding().buttonNextClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.handleNextClick();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$10(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.handleNextClick();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getAwareBinding().radioBtnFailFlashingAware.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getAwareBinding().radioBtnFailFadingAware.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.getAwareBinding().radioBtnFailSolidAware.setChecked(true);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$14(AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne, View view) {
        addDeviceAutoConfigurationFailedStepOne.handleNextClick();
    }

    private final void handleNextClick() {
        Timber.Forest.d("handleNextClick()", new Object[0]);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType != 1) {
            if (deviceModelType != 2) {
                if (deviceModelType == 3) {
                    if (getClassicBinding().radioBtnFailRingSolidClassic.isChecked()) {
                        Timber.Forest.d("handleNextClick() -> addService.autoFailStepCompleted()", new Object[0]);
                        getAddService().autoFailStepCompleted();
                    } else if (getClassicBinding().radioBtnFailRingFlashingClassic.isChecked() || getClassicBinding().radioBtnFailWifiSolidClassic.isChecked()) {
                        Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
                        getAddService().recommendResetDevice();
                    } else {
                        Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            ViewUtils.INSTANCE.showError((Activity) activity, com.blueair.viewcore.R.string.error_select_option);
                        }
                    }
                }
            } else if (getSenseBinding().radioBtnRingSolidWifiFlashingSense.isChecked()) {
                Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
                getAddService().autoFailStepCompleted();
            } else if (getSenseBinding().radioBtnRingWifiFadingSense.isChecked() || getSenseBinding().radioBtnRingWifiSolidSense.isChecked()) {
                Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
                getAddService().recommendResetDevice();
            } else {
                Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ViewUtils.INSTANCE.showError((Activity) activity2, com.blueair.viewcore.R.string.error_select_option);
                }
            }
        } else if (getAwareBinding().radioBtnFailFadingAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
            getAddService().recommendResetDevice();
        } else if (getAwareBinding().radioBtnFailSolidAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
            getAddService().recommendResetDevice();
        } else if (getAwareBinding().radioBtnFailFlashingAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.autoFailStepCompleted()", new Object[0]);
            getAddService().autoFailStepCompleted();
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne$onRadioButtonChanged;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoConfigurationFailedStepOne.kt */
    private final class onRadioButtonChanged implements CompoundButton.OnCheckedChangeListener {
        public onRadioButtonChanged() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                AddDeviceAutoConfigurationFailedStepOne addDeviceAutoConfigurationFailedStepOne = AddDeviceAutoConfigurationFailedStepOne.this;
                addDeviceAutoConfigurationFailedStepOne.updateNextButton(addDeviceAutoConfigurationFailedStepOne.getDeviceModelType());
                Integer valueOf = compoundButton != null ? Integer.valueOf(compoundButton.getId()) : null;
                int i = R.id.radioBtnFailRingFlashingClassic;
                if (valueOf != null && valueOf.intValue() == i) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(false);
                    return;
                }
                int i2 = R.id.radioBtnFailRingSolidClassic;
                if (valueOf != null && valueOf.intValue() == i2) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(false);
                    return;
                }
                int i3 = R.id.radioBtnFailWifiSolidClassic;
                if (valueOf != null && valueOf.intValue() == i3) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(false);
                    return;
                }
                int i4 = R.id.radioBtnRingWifiFadingSense;
                if (valueOf != null && valueOf.intValue() == i4) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(false);
                    return;
                }
                int i5 = R.id.radioBtnRingSolidWifiFlashingSense;
                if (valueOf != null && valueOf.intValue() == i5) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(false);
                    return;
                }
                int i6 = R.id.radioBtnRingWifiSolidSense;
                if (valueOf != null && valueOf.intValue() == i6) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(false);
                    return;
                }
                int i7 = R.id.radioBtnFailFadingAware;
                if (valueOf != null && valueOf.intValue() == i7) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailFlashingAware.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailSolidAware.setChecked(false);
                    return;
                }
                int i8 = R.id.radioBtnFailFlashingAware;
                if (valueOf != null && valueOf.intValue() == i8) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailFadingAware.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailSolidAware.setChecked(false);
                    return;
                }
                int i9 = R.id.radioBtnFailSolidAware;
                if (valueOf != null && valueOf.intValue() == i9) {
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailFadingAware.setChecked(false);
                    AddDeviceAutoConfigurationFailedStepOne.this.getAwareBinding().radioBtnFailFlashingAware.setChecked(false);
                }
            }
        }
    }
}
