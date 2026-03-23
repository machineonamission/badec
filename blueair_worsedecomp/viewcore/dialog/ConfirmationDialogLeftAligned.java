package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010B\u001a\u0004\u0018\u0001HC\"\u0004\b\u0000\u0010C2\u0006\u0010D\u001a\u00020&H\u0002¢\u0006\u0002\u0010EJ\u0012\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020LH\u0002R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0001\u0010\u000b\u001as\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b#\u0010\u001bR\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b+\u0010 R\u001d\u0010-\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b.\u0010 R\u001b\u00100\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b6\u0010\u001d\u001a\u0004\b5\u00102R\u001b\u00107\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b9\u0010\u001d\u001a\u0004\b8\u00102R\u001b\u0010:\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b<\u0010\u001d\u001a\u0004\b;\u00102R#\u0010=\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010>8BX\u0002¢\u0006\f\n\u0004\bA\u0010\u001d\u001a\u0004\b?\u0010@¨\u0006N"}, d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "viewBinder", "Lkotlin/Function5;", "Landroid/widget/TextView;", "title", "subTitle", "body", "Lcom/google/android/material/button/MaterialButton;", "positiveBtn", "negativeBtn", "getViewBinder", "()Lkotlin/jvm/functions/Function5;", "setViewBinder", "(Lkotlin/jvm/functions/Function5;)V", "argTitleTextResId", "", "getArgTitleTextResId", "()I", "argTitleTextResId$delegate", "Lkotlin/Lazy;", "argSubTitleTextResId", "getArgSubTitleTextResId", "()Ljava/lang/Integer;", "argSubTitleTextResId$delegate", "argBodyTextResId", "getArgBodyTextResId", "argBodyTextResId$delegate", "argTitleText", "", "getArgTitleText", "()Ljava/lang/String;", "argTitleText$delegate", "argPositiveTextResId", "getArgPositiveTextResId", "argPositiveTextResId$delegate", "argNegativeTextResId", "getArgNegativeTextResId", "argNegativeTextResId$delegate", "primaryButtonDestructive", "getPrimaryButtonDestructive", "()Z", "primaryButtonDestructive$delegate", "primaryButtonAsSecondary", "getPrimaryButtonAsSecondary", "primaryButtonAsSecondary$delegate", "buttonsVertical", "getButtonsVertical", "buttonsVertical$delegate", "centeredAndMultiLinedTitle", "getCenteredAndMultiLinedTitle", "centeredAndMultiLinedTitle$delegate", "bodyTextArgs", "", "getBodyTextArgs", "()[Ljava/lang/String;", "bodyTextArgs$delegate", "getArgument", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "bind", "view", "Landroid/view/View;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConfirmationDialogLeftAligned.kt */
public final class ConfirmationDialogLeftAligned extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_BODY_TEXT_ARGS = "bodyTextArgs";
    private static final String KEY_BODY_TEXT_RES_ID = "bodyTextResId";
    private static final String KEY_BUTTONS_VERTICAL = "buttonsVertical";
    private static final String KEY_CENTERED_AND_MULTILINED_TITLE = "centeredAndMultiLinedTitle";
    private static final String KEY_NEGATIVE_TEXT_RES_ID = "negativeTextResId";
    private static final String KEY_POSITIVE_TEXT_RES_ID = "positiveTextResId";
    private static final String KEY_PRIMARY_BUTTON_AS_SECONDARY = "primaryButtonAsSecondary";
    private static final String KEY_PRIMARY_BUTTON_DESTRUCTIVE = "primaryButtonDestructive";
    private static final String KEY_SUB_TITLE_TEXT_RES_ID = "subTitleTextResId";
    private static final String KEY_TITLE_TEXT = "titleText";
    private static final String KEY_TITLE_TEXT_RES_ID = "titleTextResId";
    private final Lazy argBodyTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda10(this));
    private final Lazy argNegativeTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda13(this));
    private final Lazy argPositiveTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda12(this));
    private final Lazy argSubTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda9(this));
    private final Lazy argTitleText$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda11(this));
    private final Lazy argTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda7(this));
    private final Lazy bodyTextArgs$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda8(this));
    private final Lazy buttonsVertical$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda3(this));
    private final Lazy centeredAndMultiLinedTitle$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda4(this));
    private final Lazy primaryButtonAsSecondary$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda2(this));
    private final Lazy primaryButtonDestructive$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda1(this));
    /* access modifiers changed from: private */
    public Function1<? super Boolean, Unit> resultListener;
    private Function5<? super TextView, ? super TextView, ? super TextView, ? super MaterialButton, ? super MaterialButton, Unit> viewBinder;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¦\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052%\b\u0002\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010!¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned$Companion;", "", "<init>", "()V", "KEY_TITLE_TEXT_RES_ID", "", "KEY_TITLE_TEXT", "KEY_SUB_TITLE_TEXT_RES_ID", "KEY_BODY_TEXT_RES_ID", "KEY_POSITIVE_TEXT_RES_ID", "KEY_NEGATIVE_TEXT_RES_ID", "KEY_PRIMARY_BUTTON_AS_SECONDARY", "KEY_PRIMARY_BUTTON_DESTRUCTIVE", "KEY_BUTTONS_VERTICAL", "KEY_CENTERED_AND_MULTILINED_TITLE", "KEY_BODY_TEXT_ARGS", "newInstance", "Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "titleTextResId", "", "subTitleResId", "bodyTextResId", "positiveTextResId", "negativeTextResId", "primaryButtonDestructive", "", "primaryButtonAsSecondary", "buttonsVertical", "centeredAndMultiLinedTitle", "bodyTextArgs", "", "preferTitleText", "resultListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "(ILjava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;ZZZZ[Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConfirmationDialogLeftAligned.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ConfirmationDialogLeftAligned newInstance$default(Companion companion, int i, Integer num, int i2, Integer num2, Integer num3, boolean z, boolean z2, boolean z3, boolean z4, String[] strArr, String str, Function1 function1, int i3, Object obj) {
            if ((i3 & 32) != 0) {
                z = false;
            }
            if ((i3 & 64) != 0) {
                z2 = false;
            }
            if ((i3 & 128) != 0) {
                z3 = true;
            }
            if ((i3 & 256) != 0) {
                z4 = false;
            }
            if ((i3 & 512) != 0) {
                strArr = null;
            }
            if ((i3 & 1024) != 0) {
                str = null;
            }
            if ((i3 & 2048) != 0) {
                function1 = null;
            }
            return companion.newInstance(i, num, i2, num2, num3, z, z2, z3, z4, strArr, str, function1);
        }

        public final ConfirmationDialogLeftAligned newInstance(int i, Integer num, int i2, Integer num2, Integer num3, boolean z, boolean z2, boolean z3, boolean z4, String[] strArr, String str, Function1<? super Boolean, Unit> function1) {
            Bundle bundle = new Bundle();
            bundle.putInt(ConfirmationDialogLeftAligned.KEY_TITLE_TEXT_RES_ID, i);
            if (str != null) {
                bundle.putString(ConfirmationDialogLeftAligned.KEY_TITLE_TEXT, str);
            }
            if (num != null) {
                bundle.putInt(ConfirmationDialogLeftAligned.KEY_SUB_TITLE_TEXT_RES_ID, num.intValue());
            }
            bundle.putInt(ConfirmationDialogLeftAligned.KEY_BODY_TEXT_RES_ID, i2);
            if (num2 != null) {
                bundle.putInt(ConfirmationDialogLeftAligned.KEY_POSITIVE_TEXT_RES_ID, num2.intValue());
            }
            if (num3 != null) {
                bundle.putInt(ConfirmationDialogLeftAligned.KEY_NEGATIVE_TEXT_RES_ID, num3.intValue());
            }
            bundle.putBoolean(ConfirmationDialogLeftAligned.KEY_PRIMARY_BUTTON_DESTRUCTIVE, z);
            bundle.putBoolean(ConfirmationDialogLeftAligned.KEY_PRIMARY_BUTTON_AS_SECONDARY, z2);
            bundle.putBoolean(ConfirmationDialogLeftAligned.KEY_BUTTONS_VERTICAL, z3);
            bundle.putBoolean(ConfirmationDialogLeftAligned.KEY_CENTERED_AND_MULTILINED_TITLE, z4);
            if (strArr != null) {
                bundle.putStringArray(ConfirmationDialogLeftAligned.KEY_BODY_TEXT_ARGS, strArr);
            }
            ConfirmationDialogLeftAligned confirmationDialogLeftAligned = new ConfirmationDialogLeftAligned();
            confirmationDialogLeftAligned.setArguments(bundle);
            confirmationDialogLeftAligned.resultListener = function1;
            return confirmationDialogLeftAligned;
        }
    }

    public final Function5<TextView, TextView, TextView, MaterialButton, MaterialButton, Unit> getViewBinder() {
        return this.viewBinder;
    }

    public final void setViewBinder(Function5<? super TextView, ? super TextView, ? super TextView, ? super MaterialButton, ? super MaterialButton, Unit> function5) {
        this.viewBinder = function5;
    }

    private final int getArgTitleTextResId() {
        return ((Number) this.argTitleTextResId$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int argTitleTextResId_delegate$lambda$0(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return confirmationDialogLeftAligned.requireArguments().getInt(KEY_TITLE_TEXT_RES_ID);
    }

    private final Integer getArgSubTitleTextResId() {
        return (Integer) this.argSubTitleTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argSubTitleTextResId_delegate$lambda$1(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return (Integer) confirmationDialogLeftAligned.getArgument(KEY_SUB_TITLE_TEXT_RES_ID);
    }

    private final int getArgBodyTextResId() {
        return ((Number) this.argBodyTextResId$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int argBodyTextResId_delegate$lambda$2(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return confirmationDialogLeftAligned.requireArguments().getInt(KEY_BODY_TEXT_RES_ID);
    }

    private final String getArgTitleText() {
        return (String) this.argTitleText$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String argTitleText_delegate$lambda$3(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return confirmationDialogLeftAligned.requireArguments().getString(KEY_TITLE_TEXT);
    }

    private final Integer getArgPositiveTextResId() {
        return (Integer) this.argPositiveTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argPositiveTextResId_delegate$lambda$4(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return (Integer) confirmationDialogLeftAligned.getArgument(KEY_POSITIVE_TEXT_RES_ID);
    }

    private final Integer getArgNegativeTextResId() {
        return (Integer) this.argNegativeTextResId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Integer argNegativeTextResId_delegate$lambda$5(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return (Integer) confirmationDialogLeftAligned.getArgument(KEY_NEGATIVE_TEXT_RES_ID);
    }

    private final boolean getPrimaryButtonDestructive() {
        return ((Boolean) this.primaryButtonDestructive$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean primaryButtonDestructive_delegate$lambda$6(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        Boolean bool = (Boolean) confirmationDialogLeftAligned.getArgument(KEY_PRIMARY_BUTTON_DESTRUCTIVE);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean getPrimaryButtonAsSecondary() {
        return ((Boolean) this.primaryButtonAsSecondary$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean primaryButtonAsSecondary_delegate$lambda$7(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        Boolean bool = (Boolean) confirmationDialogLeftAligned.getArgument(KEY_PRIMARY_BUTTON_AS_SECONDARY);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean getButtonsVertical() {
        return ((Boolean) this.buttonsVertical$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean buttonsVertical_delegate$lambda$8(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        Boolean bool = (Boolean) confirmationDialogLeftAligned.getArgument(KEY_BUTTONS_VERTICAL);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final boolean getCenteredAndMultiLinedTitle() {
        return ((Boolean) this.centeredAndMultiLinedTitle$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean centeredAndMultiLinedTitle_delegate$lambda$9(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        Boolean bool = (Boolean) confirmationDialogLeftAligned.getArgument(KEY_CENTERED_AND_MULTILINED_TITLE);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final String[] getBodyTextArgs() {
        return (String[]) this.bodyTextArgs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String[] bodyTextArgs_delegate$lambda$10(ConfirmationDialogLeftAligned confirmationDialogLeftAligned) {
        return (String[]) confirmationDialogLeftAligned.getArgument(KEY_BODY_TEXT_ARGS);
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
        int i;
        Window window;
        FragmentActivity activity = getActivity();
        View view = null;
        LayoutInflater layoutInflater = activity != null ? activity.getLayoutInflater() : null;
        if (getButtonsVertical()) {
            i = R.layout.confirmation_dialog_left_aligned_vertical;
        } else if (getPrimaryButtonAsSecondary()) {
            i = R.layout.confirmation_dialog_left_aligned_horizontal_secondary;
        } else {
            i = R.layout.confirmation_dialog_left_aligned_horizontal;
        }
        if (layoutInflater != null) {
            view = layoutInflater.inflate(i, (ViewGroup) null);
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
        TextView textView = (TextView) view.findViewById(R.id.title);
        String argTitleText = getArgTitleText();
        if (argTitleText == null) {
            argTitleText = context.getString(getArgTitleTextResId());
            Intrinsics.checkNotNullExpressionValue(argTitleText, "getString(...)");
        }
        textView.setText(argTitleText);
        TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
        Integer argSubTitleTextResId = getArgSubTitleTextResId();
        String str = "";
        boolean z = false;
        if (argSubTitleTextResId != null) {
            textView2.setText(context.getString(argSubTitleTextResId.intValue()));
            textView2.setVisibility(0);
        } else {
            textView2.setText(str);
            textView2.setVisibility(4);
        }
        if (getCenteredAndMultiLinedTitle()) {
            textView.setGravity(17);
            Intrinsics.checkNotNull(textView);
            View view2 = textView;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
                layoutParams3.width = 0;
                layoutParams3.endToStart = R.id.end_guideline;
                view2.setLayoutParams(layoutParams2);
                Intrinsics.checkNotNull(textView2);
                ViewExtensionsKt.show(textView2, false);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        if (getArgBodyTextResId() != 0) {
            str = context.getString(getArgBodyTextResId());
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
        TextView textView3 = (TextView) view.findViewById(R.id.body);
        CharSequence charSequence = str;
        textView3.setText(charSequence);
        Intrinsics.checkNotNull(textView3);
        ViewExtensionsKt.show(textView3, charSequence.length() > 0);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.confirm_button);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.show(materialButton, getArgPositiveTextResId() != null);
        Integer argPositiveTextResId = getArgPositiveTextResId();
        String str2 = null;
        if (argPositiveTextResId != null) {
            materialButton.setText(context != null ? context.getString(argPositiveTextResId.intValue()) : null);
        }
        if (getPrimaryButtonDestructive()) {
            materialButton.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.button_primary_destructive));
        }
        materialButton.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda0(this));
        View findViewById = view.findViewById(R.id.iv_close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda5(this));
        }
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.dismiss_button);
        Integer argNegativeTextResId = getArgNegativeTextResId();
        Intrinsics.checkNotNull(materialButton2);
        View view3 = materialButton2;
        if (argNegativeTextResId != null) {
            z = true;
        }
        ViewExtensionsKt.show(view3, z);
        if (argNegativeTextResId != null) {
            if (context != null) {
                str2 = context.getString(argNegativeTextResId.intValue());
            }
            materialButton2.setText(str2);
            materialButton2.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda6(this));
        }
        MaterialButton materialButton3 = materialButton;
        Function5<? super TextView, ? super TextView, ? super TextView, ? super MaterialButton, ? super MaterialButton, Unit> function5 = this.viewBinder;
        if (function5 != null) {
            Intrinsics.checkNotNull(textView);
            Intrinsics.checkNotNull(textView2);
            function5.invoke(textView, textView2, textView3, materialButton3, materialButton2);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$18(ConfirmationDialogLeftAligned confirmationDialogLeftAligned, View view) {
        confirmationDialogLeftAligned.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = confirmationDialogLeftAligned.resultListener;
        if (function1 != null) {
            function1.invoke(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$19(ConfirmationDialogLeftAligned confirmationDialogLeftAligned, View view) {
        confirmationDialogLeftAligned.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$20(ConfirmationDialogLeftAligned confirmationDialogLeftAligned, View view) {
        confirmationDialogLeftAligned.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = confirmationDialogLeftAligned.resultListener;
        if (function1 != null) {
            function1.invoke(false);
        }
    }
}
