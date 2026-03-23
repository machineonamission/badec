package com.blueair.devicedetails.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blueair.devicedetails.databinding.DialogfragmentWhPermissionsBinding;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtilsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\tR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentWhPermissionsBinding;", "stringNext", "", "getStringNext", "()Ljava/lang/String;", "stringNext$delegate", "Lkotlin/Lazy;", "stringGotIt", "getStringGotIt", "stringGotIt$delegate", "stringBack", "getStringBack", "stringBack$delegate", "stringTryLater", "getStringTryLater", "stringTryLater$delegate", "value", "Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;", "currentPage", "setCurrentPage", "(Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;)V", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updatePage", "page", "openSettings", "PermissionsInstructionsPage", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomePermissionsDialogFragment.kt */
public final class WelcomeHomePermissionsDialogFragment extends DialogFragment {
    private DialogfragmentWhPermissionsBinding binding;
    private PermissionsInstructionsPage currentPage = PermissionsInstructionsPage.SECOND;
    private final Lazy stringBack$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda2(this));
    private final Lazy stringGotIt$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda1(this));
    private final Lazy stringNext$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda0(this));
    private final Lazy stringTryLater$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda3(this));
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomePermissionsDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage[] r0 = com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage r1 = com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.SECOND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage r1 = com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.THIRD     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage r1 = com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.FIRST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    public WelcomeHomePermissionsDialogFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new WelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$2(new WelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$1(fragment)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DeviceWelcomeHomeViewModel.class), new WelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$3(lazy), new WelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new WelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    private final String getStringNext() {
        return (String) this.stringNext$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String stringNext_delegate$lambda$0(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment) {
        return welcomeHomePermissionsDialogFragment.getString(R.string.button_next);
    }

    private final String getStringGotIt() {
        return (String) this.stringGotIt$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String stringGotIt_delegate$lambda$1(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment) {
        return welcomeHomePermissionsDialogFragment.getString(R.string.button_got_it);
    }

    private final String getStringBack() {
        return (String) this.stringBack$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String stringBack_delegate$lambda$2(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment) {
        return welcomeHomePermissionsDialogFragment.getString(R.string.button_back);
    }

    private final String getStringTryLater() {
        return (String) this.stringTryLater$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String stringTryLater_delegate$lambda$3(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment) {
        return welcomeHomePermissionsDialogFragment.getString(R.string.button_try_later);
    }

    private final void setCurrentPage(PermissionsInstructionsPage permissionsInstructionsPage) {
        this.currentPage = permissionsInstructionsPage;
        updatePage(permissionsInstructionsPage);
    }

    private final DeviceWelcomeHomeViewModel getViewModel() {
        return (DeviceWelcomeHomeViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentWhPermissionsBinding inflate = DialogfragmentWhPermissionsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding = this.binding;
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding2 = null;
        if (dialogfragmentWhPermissionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhPermissionsBinding = null;
        }
        dialogfragmentWhPermissionsBinding.btnGtsLocation.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda4(this));
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding3 = this.binding;
        if (dialogfragmentWhPermissionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhPermissionsBinding3 = null;
        }
        dialogfragmentWhPermissionsBinding3.btnGtsAutostart.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda5(this));
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding4 = this.binding;
        if (dialogfragmentWhPermissionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhPermissionsBinding4 = null;
        }
        dialogfragmentWhPermissionsBinding4.btnGtsPowerManagement.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda6(this));
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding5 = this.binding;
        if (dialogfragmentWhPermissionsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhPermissionsBinding5 = null;
        }
        MaterialButton materialButton = dialogfragmentWhPermissionsBinding5.btnNext;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnNext");
        ViewUtilsKt.setOnClickListener(materialButton, 200, new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda7(this));
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding6 = this.binding;
        if (dialogfragmentWhPermissionsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentWhPermissionsBinding2 = dialogfragmentWhPermissionsBinding6;
        }
        MaterialButton materialButton2 = dialogfragmentWhPermissionsBinding2.btnBack;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnBack");
        ViewUtilsKt.setOnClickListener(materialButton2, 200, new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda8(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment, View view) {
        welcomeHomePermissionsDialogFragment.openSettings();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment, View view) {
        welcomeHomePermissionsDialogFragment.openSettings();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment, View view) {
        welcomeHomePermissionsDialogFragment.openSettings();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[welcomeHomePermissionsDialogFragment.currentPage.ordinal()];
        if (i == 1) {
            welcomeHomePermissionsDialogFragment.setCurrentPage(PermissionsInstructionsPage.THIRD);
        } else if (i == 2) {
            welcomeHomePermissionsDialogFragment.getViewModel().setAddHomeInstructionShowed();
            welcomeHomePermissionsDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(WelcomeHomePermissionsDialogFragment welcomeHomePermissionsDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[welcomeHomePermissionsDialogFragment.currentPage.ordinal()];
        if (i == 1) {
            welcomeHomePermissionsDialogFragment.dismiss();
        } else if (i == 2) {
            welcomeHomePermissionsDialogFragment.setCurrentPage(PermissionsInstructionsPage.SECOND);
        }
        return Unit.INSTANCE;
    }

    private final void updatePage(PermissionsInstructionsPage permissionsInstructionsPage) {
        int i = WhenMappings.$EnumSwitchMapping$0[permissionsInstructionsPage.ordinal()];
        DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding = null;
        if (i == 1) {
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding2 = this.binding;
            if (dialogfragmentWhPermissionsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding2 = null;
            }
            dialogfragmentWhPermissionsBinding2.tvPermissionsTitle.setVisibility(0);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding3 = this.binding;
            if (dialogfragmentWhPermissionsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding3 = null;
            }
            dialogfragmentWhPermissionsBinding3.tvScheduleAffect.setVisibility(8);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding4 = this.binding;
            if (dialogfragmentWhPermissionsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding4 = null;
            }
            dialogfragmentWhPermissionsBinding4.containerSecondPage.setVisibility(0);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding5 = this.binding;
            if (dialogfragmentWhPermissionsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding5 = null;
            }
            dialogfragmentWhPermissionsBinding5.containerThirdPage.setVisibility(8);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding6 = this.binding;
            if (dialogfragmentWhPermissionsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding6 = null;
            }
            dialogfragmentWhPermissionsBinding6.btnNext.setText(getStringNext());
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding7 = this.binding;
            if (dialogfragmentWhPermissionsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentWhPermissionsBinding = dialogfragmentWhPermissionsBinding7;
            }
            dialogfragmentWhPermissionsBinding.btnBack.setText(getStringTryLater());
        } else if (i == 2) {
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding8 = this.binding;
            if (dialogfragmentWhPermissionsBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding8 = null;
            }
            dialogfragmentWhPermissionsBinding8.containerSecondPage.setVisibility(8);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding9 = this.binding;
            if (dialogfragmentWhPermissionsBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding9 = null;
            }
            dialogfragmentWhPermissionsBinding9.containerThirdPage.setVisibility(0);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding10 = this.binding;
            if (dialogfragmentWhPermissionsBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding10 = null;
            }
            dialogfragmentWhPermissionsBinding10.btnNext.setText(getStringGotIt());
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding11 = this.binding;
            if (dialogfragmentWhPermissionsBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentWhPermissionsBinding = dialogfragmentWhPermissionsBinding11;
            }
            dialogfragmentWhPermissionsBinding.btnBack.setText(getStringBack());
        } else if (i == 3) {
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding12 = this.binding;
            if (dialogfragmentWhPermissionsBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding12 = null;
            }
            dialogfragmentWhPermissionsBinding12.tvPermissionsTitle.setVisibility(8);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding13 = this.binding;
            if (dialogfragmentWhPermissionsBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding13 = null;
            }
            dialogfragmentWhPermissionsBinding13.tvScheduleAffect.setVisibility(0);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding14 = this.binding;
            if (dialogfragmentWhPermissionsBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentWhPermissionsBinding14 = null;
            }
            dialogfragmentWhPermissionsBinding14.containerSecondPage.setVisibility(8);
            DialogfragmentWhPermissionsBinding dialogfragmentWhPermissionsBinding15 = this.binding;
            if (dialogfragmentWhPermissionsBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentWhPermissionsBinding = dialogfragmentWhPermissionsBinding15;
            }
            dialogfragmentWhPermissionsBinding.btnBack.setText(getStringTryLater());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void openSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder sb = new StringBuilder("package:");
        Context context = getContext();
        sb.append(context != null ? context.getPackageName() : null);
        intent.setData(Uri.parse(sb.toString()));
        Context context2 = getContext();
        if (context2 != null) {
            context2.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "SECOND", "THIRD", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomePermissionsDialogFragment.kt */
    private enum PermissionsInstructionsPage {
        FIRST,
        SECOND,
        THIRD;

        public static EnumEntries<PermissionsInstructionsPage> getEntries() {
            return $ENTRIES;
        }

        static {
            PermissionsInstructionsPage[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
