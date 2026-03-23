package com.blueair.outdoor.ui.dialog;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseEditTextDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;)V", "onSaveListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "getOnSaveListener", "()Lkotlin/jvm/functions/Function1;", "setOnSaveListener", "(Lkotlin/jvm/functions/Function1;)V", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "validateText", "", "onSaveBtnClicked", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationEditNameDialogFragment.kt */
public final class LocationEditNameDialogFragment extends BaseEditTextDialogFragment<MapsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private Function1<? super String, Unit> onSaveListener;
    private final String screenName;
    public MapsViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_NAME", "", "newInstance", "Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment;", "name", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationEditNameDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocationEditNameDialogFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            LocationEditNameDialogFragment locationEditNameDialogFragment = new LocationEditNameDialogFragment();
            locationEditNameDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("EXTRA_NAME", str)));
            return locationEditNameDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public MapsViewModel getViewModel() {
        MapsViewModel mapsViewModel = this.viewModel;
        if (mapsViewModel != null) {
            return mapsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(MapsViewModel mapsViewModel) {
        Intrinsics.checkNotNullParameter(mapsViewModel, "<set-?>");
        this.viewModel = mapsViewModel;
    }

    public final Function1<String, Unit> getOnSaveListener() {
        return this.onSaveListener;
    }

    public final void setOnSaveListener(Function1<? super String, Unit> function1) {
        this.onSaveListener = function1;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((MapsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(MapsViewModel.class)));
        TextView dialogTitle = getDialogTitle();
        if (dialogTitle != null) {
            dialogTitle.setText(R.string.outdoor_edit_location_name);
        }
        TextView dialogMsg = getDialogMsg();
        if (dialogMsg != null) {
            ViewExtensionsKt.hide(dialogMsg);
        }
        EditText editText = getEditText();
        if (editText != null) {
            editText.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)});
        }
        EditText editText2 = getEditText();
        if (editText2 != null) {
            editText2.addTextChangedListener(new LocationEditNameDialogFragment$onViewCreated$$inlined$doOnTextChanged$1(this));
        }
        EditText editText3 = getEditText();
        if (editText3 != null) {
            editText3.setText(requireArguments().getString("EXTRA_NAME"));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateText() {
        /*
            r2 = this;
            android.widget.EditText r0 = r2.getEditText()
            if (r0 == 0) goto L_0x0011
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.toString()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            if (r0 == 0) goto L_0x0020
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r0 = 0
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.dialog.LocationEditNameDialogFragment.validateText():boolean");
    }

    /* access modifiers changed from: protected */
    public void onSaveBtnClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Function1<? super String, Unit> function1 = this.onSaveListener;
        if (function1 != null) {
            function1.invoke(str);
        }
        super.onSaveBtnClicked(str);
    }
}
