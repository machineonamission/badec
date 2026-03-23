package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.dialog.BaseEditDeviceNameDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Landroid/view/View;", "onSaveBtnClicked", "text", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: EnterDeviceNameDialogFragment.kt */
public final class EnterDeviceNameDialogFragment extends BaseEditDeviceNameDialogFragment<AddDeviceViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_NAME = "device_name";
    public static final String SET_NAME_REQUEST_KEY = "set_name";
    private final String screenName;
    public AddDeviceViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment$Companion;", "", "<init>", "()V", "SET_NAME_REQUEST_KEY", "", "DEVICE_NAME", "newInstance", "Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment;", "prePopName", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: EnterDeviceNameDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ EnterDeviceNameDialogFragment newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newInstance(str);
        }

        public final EnterDeviceNameDialogFragment newInstance(String str) {
            EnterDeviceNameDialogFragment enterDeviceNameDialogFragment = new EnterDeviceNameDialogFragment();
            Bundle bundle = new Bundle();
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                bundle.putString("device_name", str);
            }
            enterDeviceNameDialogFragment.setArguments(bundle);
            return enterDeviceNameDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public AddDeviceViewModel getViewModel() {
        AddDeviceViewModel addDeviceViewModel = this.viewModel;
        if (addDeviceViewModel != null) {
            return addDeviceViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(AddDeviceViewModel addDeviceViewModel) {
        Intrinsics.checkNotNullParameter(addDeviceViewModel, "<set-?>");
        this.viewModel = addDeviceViewModel;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        return super.onCreateDialog(bundle);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0069: MOVE  (r4v5 java.lang.CharSequence) = (r4v4 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    public void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.onViewCreated(r3, r4)
            r3 = r2
            com.blueair.viewcore.dialog.BaseDialogFragment r3 = (com.blueair.viewcore.dialog.BaseDialogFragment) r3
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            java.lang.String r4 = "requireActivity(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelProvider r4 = new androidx.lifecycle.ViewModelProvider
            r4.<init>((androidx.lifecycle.ViewModelStoreOwner) r3)
            java.lang.Class<com.blueair.adddevice.viewmodel.AddDeviceViewModel> r3 = com.blueair.adddevice.viewmodel.AddDeviceViewModel.class
            androidx.lifecycle.ViewModel r3 = r4.get(r3)
            com.blueair.viewcore.viewmodel.BaseViewModel r3 = (com.blueair.viewcore.viewmodel.BaseViewModel) r3
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r3 = (com.blueair.adddevice.viewmodel.AddDeviceViewModel) r3
            r2.setViewModel((com.blueair.adddevice.viewmodel.AddDeviceViewModel) r3)
            android.widget.TextView r3 = r2.getDialogTitle()
            r4 = 0
            if (r3 == 0) goto L_0x0040
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L_0x003c
            int r1 = com.blueair.viewcore.R.string.custome_purifier_name
            java.lang.CharSequence r0 = r0.getText(r1)
            goto L_0x003d
        L_0x003c:
            r0 = r4
        L_0x003d:
            r3.setText(r0)
        L_0x0040:
            android.widget.TextView r3 = r2.getDialogMsg()
            if (r3 == 0) goto L_0x0057
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L_0x0053
            int r1 = com.blueair.viewcore.R.string.name_purifier
            java.lang.CharSequence r0 = r0.getText(r1)
            goto L_0x0054
        L_0x0053:
            r0 = r4
        L_0x0054:
            r3.setText(r0)
        L_0x0057:
            android.os.Bundle r3 = r2.getArguments()
            if (r3 == 0) goto L_0x0063
            java.lang.String r4 = "device_name"
            java.lang.String r4 = r3.getString(r4)
        L_0x0063:
            android.widget.EditText r3 = r2.getEditText()
            if (r3 == 0) goto L_0x0084
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0084
            int r0 = r4.length()
            if (r0 != 0) goto L_0x0074
            goto L_0x0084
        L_0x0074:
            r3.setText(r4)
            android.text.Editable r4 = r3.getText()
            if (r4 == 0) goto L_0x0084
            int r4 = r4.length()
            r3.setSelection(r4)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.dialog.EnterDeviceNameDialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onSaveBtnClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        FragmentKt.setFragmentResult(this, SET_NAME_REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to("device_name", str)));
        super.onSaveBtnClicked(str);
    }
}
