package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010%\u001a\u0004\u0018\u0001H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u00020!H\u0002¢\u0006\u0002\u0010(J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0017R#\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "argTitleTextResId", "", "getArgTitleTextResId", "()Ljava/lang/Integer;", "argTitleTextResId$delegate", "Lkotlin/Lazy;", "argBodyTextResId", "getArgBodyTextResId", "argBodyTextResId$delegate", "argPositiveTextResId", "getArgPositiveTextResId", "()I", "argPositiveTextResId$delegate", "argNegativeTextResId", "getArgNegativeTextResId", "argNegativeTextResId$delegate", "primaryButtonDestructive", "", "getPrimaryButtonDestructive", "()Z", "primaryButtonDestructive$delegate", "buttonsHorizontal", "getButtonsHorizontal", "buttonsHorizontal$delegate", "bodyTextStart", "getBodyTextStart", "bodyTextStart$delegate", "bodyTextArgs", "", "", "getBodyTextArgs", "()[Ljava/lang/String;", "bodyTextArgs$delegate", "getArgument", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "bind", "", "view", "Landroid/view/View;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConfirmationDialogCentered.kt */
public final class ConfirmationDialogCentered extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILTER_TAG = "Device_Details_Filter_Dialog";
    private static final String KEY_BODY_TEXT_ARGS = "bodyTextArgs";
    private static final String KEY_BODY_TEXT_RES_ID = "bodyTextResId";
    private static final String KEY_BODY_TEXT_START = "bodyTextStart";
    private static final String KEY_BUTTONS_HORIZONTAL = "KEY_BUTTONS_HORIZONTAL";
    private static final String KEY_NEGATIVE_TEXT_RES_ID = "negativeTextResId";
    private static final String KEY_POSITIVE_TEXT_RES_ID = "positiveTextResId";
    private static final String KEY_PRIMARY_BUTTON_DESTRUCTIVE = "primaryButtonDestructive";
    private static final String KEY_TITLE_TEXT_RES_ID = "titleTextResId";
    private static final String OFFLINE_TAG = "Device_Details_Offline_Dialog";
    private final Lazy argBodyTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda1(this));
    private final Lazy argNegativeTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda3(this));
    private final Lazy argPositiveTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda2(this));
    private final Lazy argTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda0(this));
    private final Lazy bodyTextArgs$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda7(this));
    private final Lazy bodyTextStart$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda6(this));
    private final Lazy buttonsHorizontal$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda5(this));
    private final Lazy primaryButtonDestructive$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda4(this));

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered$Companion;", "", "<init>", "()V", "FILTER_TAG", "", "OFFLINE_TAG", "KEY_TITLE_TEXT_RES_ID", "KEY_BODY_TEXT_RES_ID", "KEY_POSITIVE_TEXT_RES_ID", "KEY_NEGATIVE_TEXT_RES_ID", "KEY_PRIMARY_BUTTON_DESTRUCTIVE", "KEY_BUTTONS_HORIZONTAL", "KEY_BODY_TEXT_START", "KEY_BODY_TEXT_ARGS", "newInstance", "Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "titleTextResId", "", "bodyTextResId", "positiveTextResId", "negativeTextResId", "primaryButtonDestructive", "", "buttonsHorizontal", "bodyTextStart", "bodyTextArgs", "", "(Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZZ[Ljava/lang/String;)Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "showFilterDoorOpenDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "dismissFilterDoorOpenDialog", "showOfflineDialog", "dismissOfflineDialog", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConfirmationDialogCentered.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ConfirmationDialogCentered newInstance$default(Companion companion, Integer num, Integer num2, int i, Integer num3, boolean z, boolean z2, boolean z3, String[] strArr, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = null;
            }
            if ((i2 & 2) != 0) {
                num2 = null;
            }
            if ((i2 & 16) != 0) {
                z = false;
            }
            if ((i2 & 32) != 0) {
                z2 = false;
            }
            if ((i2 & 64) != 0) {
                z3 = true;
            }
            if ((i2 & 128) != 0) {
                strArr = null;
            }
            return companion.newInstance(num, num2, i, num3, z, z2, z3, strArr);
        }

        public final ConfirmationDialogCentered newInstance(Integer num, Integer num2, int i, Integer num3, boolean z, boolean z2, boolean z3, String[] strArr) {
            Bundle bundle = new Bundle();
            if (num != null) {
                bundle.putInt(ConfirmationDialogCentered.KEY_TITLE_TEXT_RES_ID, num.intValue());
            }
            if (num2 != null) {
                bundle.putInt(ConfirmationDialogCentered.KEY_BODY_TEXT_RES_ID, num2.intValue());
            }
            bundle.putInt(ConfirmationDialogCentered.KEY_POSITIVE_TEXT_RES_ID, i);
            if (num3 != null) {
                bundle.putInt(ConfirmationDialogCentered.KEY_NEGATIVE_TEXT_RES_ID, num3.intValue());
            }
            bundle.putBoolean(ConfirmationDialogCentered.KEY_PRIMARY_BUTTON_DESTRUCTIVE, z);
            bundle.putBoolean(ConfirmationDialogCentered.KEY_BUTTONS_HORIZONTAL, z2);
            bundle.putBoolean(ConfirmationDialogCentered.KEY_BODY_TEXT_START, z3);
            if (strArr != null) {
                bundle.putStringArray(ConfirmationDialogCentered.KEY_BODY_TEXT_ARGS, strArr);
            }
            ConfirmationDialogCentered confirmationDialogCentered = new ConfirmationDialogCentered();
            confirmationDialogCentered.setArguments(bundle);
            return confirmationDialogCentered;
        }

        public final void dismissFilterDoorOpenDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(ConfirmationDialogCentered.FILTER_TAG);
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }

        public final void dismissOfflineDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(ConfirmationDialogCentered.OFFLINE_TAG);
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }

        public final void showFilterDoorOpenDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (!(fragmentManager.findFragmentByTag(ConfirmationDialogCentered.FILTER_TAG) instanceof ConfirmationDialogCentered) && !fragmentManager.isStateSaved()) {
                newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.filter_door_open), Integer.valueOf(R.string.filter_door_open_content), R.string.close, (Integer) null, false, false, false, (String[]) null, 224, (Object) null).show(fragmentManager, ConfirmationDialogCentered.FILTER_TAG);
            }
        }

        public final void showOfflineDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (!(fragmentManager.findFragmentByTag(ConfirmationDialogCentered.OFFLINE_TAG) instanceof ConfirmationDialogCentered) && !fragmentManager.isStateSaved()) {
                newInstance$default(ConfirmationDialogCentered.Companion, (Integer) null, Integer.valueOf(R.string.generic_offline_error), R.string.close, (Integer) null, false, false, false, (String[]) null, 224, (Object) null).show(fragmentManager, ConfirmationDialogCentered.OFFLINE_TAG);
            }
        }
    }

    private final Integer getArgTitleTextResId() {
        return (Integer) this.argTitleTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argTitleTextResId_delegate$lambda$0(ConfirmationDialogCentered confirmationDialogCentered) {
        return (Integer) confirmationDialogCentered.getArgument(KEY_TITLE_TEXT_RES_ID);
    }

    private final Integer getArgBodyTextResId() {
        return (Integer) this.argBodyTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argBodyTextResId_delegate$lambda$1(ConfirmationDialogCentered confirmationDialogCentered) {
        return (Integer) confirmationDialogCentered.getArgument(KEY_BODY_TEXT_RES_ID);
    }

    private final int getArgPositiveTextResId() {
        return ((Number) this.argPositiveTextResId$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int argPositiveTextResId_delegate$lambda$2(ConfirmationDialogCentered confirmationDialogCentered) {
        return confirmationDialogCentered.requireArguments().getInt(KEY_POSITIVE_TEXT_RES_ID);
    }

    private final Integer getArgNegativeTextResId() {
        return (Integer) this.argNegativeTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argNegativeTextResId_delegate$lambda$3(ConfirmationDialogCentered confirmationDialogCentered) {
        return (Integer) confirmationDialogCentered.getArgument(KEY_NEGATIVE_TEXT_RES_ID);
    }

    private final boolean getPrimaryButtonDestructive() {
        return ((Boolean) this.primaryButtonDestructive$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean primaryButtonDestructive_delegate$lambda$4(ConfirmationDialogCentered confirmationDialogCentered) {
        Boolean bool = (Boolean) confirmationDialogCentered.getArgument(KEY_PRIMARY_BUTTON_DESTRUCTIVE);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean getButtonsHorizontal() {
        return ((Boolean) this.buttonsHorizontal$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean buttonsHorizontal_delegate$lambda$5(ConfirmationDialogCentered confirmationDialogCentered) {
        Boolean bool = (Boolean) confirmationDialogCentered.getArgument(KEY_BUTTONS_HORIZONTAL);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean getBodyTextStart() {
        return ((Boolean) this.bodyTextStart$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean bodyTextStart_delegate$lambda$6(ConfirmationDialogCentered confirmationDialogCentered) {
        Boolean bool = (Boolean) confirmationDialogCentered.getArgument(KEY_BODY_TEXT_START);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String[] getBodyTextArgs() {
        return (String[]) this.bodyTextArgs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String[] bodyTextArgs_delegate$lambda$7(ConfirmationDialogCentered confirmationDialogCentered) {
        return (String[]) confirmationDialogCentered.getArgument(KEY_BODY_TEXT_ARGS);
    }

    private final <T> T getArgument(String str) {
        T t;
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(str) || (t = arguments.get(str)) == null) {
            return null;
        }
        return t;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        FragmentActivity activity = getActivity();
        View view = null;
        LayoutInflater layoutInflater = activity != null ? activity.getLayoutInflater() : null;
        if (layoutInflater != null) {
            view = layoutInflater.inflate(R.layout.confirmation_dialog_centered, (ViewGroup) null);
        }
        Dialog dialog = new Dialog(requireContext());
        if (view != null) {
            dialog.setContentView(view);
            bind(view);
        }
        FragmentActivity activity2 = getActivity();
        if (!(activity2 == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity2, R.drawable.rounded_rectangle_white));
        }
        return dialog;
    }

    private final void bind(View view) {
        Context context = view.getContext();
        boolean z = false;
        if (getButtonsHorizontal()) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.buttons_container);
            linearLayoutCompat.setOrientation(0);
            Intrinsics.checkNotNull(linearLayoutCompat);
            List<View> reversed = CollectionsKt.reversed(SequencesKt.toList(ViewGroupKt.getChildren(linearLayoutCompat)));
            linearLayoutCompat.removeAllViews();
            for (View addView : reversed) {
                linearLayoutCompat.addView(addView);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        Integer argTitleTextResId = getArgTitleTextResId();
        String str = "";
        if (argTitleTextResId == null || argTitleTextResId.intValue() == 0) {
            textView.setText(str);
            textView.setVisibility(8);
        } else {
            textView.setText(context.getString(argTitleTextResId.intValue()));
            textView.setVisibility(0);
        }
        Integer argBodyTextResId = getArgBodyTextResId();
        if (!(argBodyTextResId == null || argBodyTextResId.intValue() == 0)) {
            str = context.getString(argBodyTextResId.intValue());
        }
        Intrinsics.checkNotNull(str);
        String[] bodyTextArgs = getBodyTextArgs();
        if (bodyTextArgs != null) {
            if (!(bodyTextArgs.length == 0)) {
                Object[] copyOf = Arrays.copyOf(bodyTextArgs, bodyTextArgs.length);
                String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                str = format;
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.body);
        textView2.setText(str);
        if (getBodyTextStart()) {
            textView2.setGravity(GravityCompat.START);
        }
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.confirm_button);
        materialButton.setText(context != null ? context.getString(getArgPositiveTextResId()) : null);
        if (getPrimaryButtonDestructive()) {
            materialButton.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.button_primary_destructive));
        }
        if (materialButton != null) {
            materialButton.setOnClickListener(new ConfirmationDialogCentered$$ExternalSyntheticLambda8(this));
        }
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.dismiss_button);
        Integer argNegativeTextResId = getArgNegativeTextResId();
        Intrinsics.checkNotNull(materialButton2);
        View view2 = materialButton2;
        if (argNegativeTextResId != null) {
            z = true;
        }
        ViewExtensionsKt.show(view2, z);
        if (argNegativeTextResId != null) {
            materialButton2.setText(requireContext().getString(argNegativeTextResId.intValue()));
            materialButton2.setOnClickListener(new ConfirmationDialogCentered$$ExternalSyntheticLambda9(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$14(ConfirmationDialogCentered confirmationDialogCentered, View view) {
        FragmentKt.setFragmentResult(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY, true)));
        confirmationDialogCentered.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$15(ConfirmationDialogCentered confirmationDialogCentered, View view) {
        FragmentKt.setFragmentResult(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY, false)));
        confirmationDialogCentered.dismiss();
    }
}
