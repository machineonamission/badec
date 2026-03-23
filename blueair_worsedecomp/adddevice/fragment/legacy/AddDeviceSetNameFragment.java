package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetNameBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetNameClassicBinding;
import com.blueair.core.util.KeyboardManager;
import com.blueair.core.util.KeyboardStatus;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "mBtnNext", "Landroid/view/View;", "textAddDeviceSubtitle", "Landroid/widget/TextView;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "chooseName", "", "deviceName", "", "onResume", "hideSubtitle", "shouldHide", "", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceSetNameFragment.kt */
public final class AddDeviceSetNameFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private View mBtnNext;
    private TextView textAddDeviceSubtitle;

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
            FragmentAddDeviceSetNameClassicBinding inflate = FragmentAddDeviceSetNameClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceSetNameBinding inflate2 = FragmentAddDeviceSetNameBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        ViewBinding viewBinding2 = null;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        EditText editText = (EditText) viewBinding.getRoot().findViewById(R.id.editTextDeviceName);
        ViewBinding viewBinding3 = this.binding;
        if (viewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding3 = null;
        }
        this.textAddDeviceSubtitle = (TextView) viewBinding3.getRoot().findViewById(R.id.textAddDeviceSubtitle);
        ViewBinding viewBinding4 = this.binding;
        if (viewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding4 = null;
        }
        View findViewById = viewBinding4.getRoot().findViewById(R.id.buttonNext);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mBtnNext = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
            findViewById = null;
        }
        findViewById.setOnClickListener(new AddDeviceSetNameFragment$$ExternalSyntheticLambda1(editText, this));
        ViewBinding viewBinding5 = this.binding;
        if (viewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewBinding2 = viewBinding5;
        }
        return viewBinding2.getRoot();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(EditText editText, AddDeviceSetNameFragment addDeviceSetNameFragment, View view) {
        String obj = editText.getText().toString();
        if (!StringsKt.isBlank(obj)) {
            addDeviceSetNameFragment.chooseName(obj);
        } else {
            editText.setError(addDeviceSetNameFragment.getResources().getString(com.blueair.viewcore.R.string.device_name_error));
        }
    }

    private final void chooseName(String str) {
        if (!TextUtils.isEmpty(str)) {
            AddDeviceBaseFragment.showLoading$default(this, false, 1, (Object) null);
            View view = this.mBtnNext;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
                view = null;
            }
            view.setVisibility(4);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceSetNameFragment$chooseName$1(this, str, (Continuation<? super AddDeviceSetNameFragment$chooseName$1>) null), 3, (Object) null);
        }
    }

    public void onResume() {
        ActionBar supportActionBar;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardManager keyboardManager = new KeyboardManager(activity);
            CompositeDisposable asyncSubs = getAsyncSubs();
            Observable<KeyboardStatus> observeOn = keyboardManager.status().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(...)");
            asyncSubs.add(RxExtensionsKt.subscribeAndLogE(observeOn, new AddDeviceSetNameFragment$$ExternalSyntheticLambda0(this)));
            if (getDeviceModelType() == 3 && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.complete));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$2$lambda$1(AddDeviceSetNameFragment addDeviceSetNameFragment, KeyboardStatus keyboardStatus) {
        addDeviceSetNameFragment.hideSubtitle(keyboardStatus == KeyboardStatus.OPEN);
        return Unit.INSTANCE;
    }

    private final void hideSubtitle(boolean z) {
        TextView textView = this.textAddDeviceSubtitle;
        if (textView != null) {
            ViewExtensionsKt.show(textView, !z);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceSetNameFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceSetNameFragment newInstance(int i) {
            AddDeviceSetNameFragment addDeviceSetNameFragment = new AddDeviceSetNameFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceSetNameFragment.setArguments(bundle);
            return addDeviceSetNameFragment;
        }
    }
}
