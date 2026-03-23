package com.blueair.viewcore.viewmodel;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.viewcore.viewmodel.MvvmCustomViewModelNonNullState;
import com.blueair.viewcore.viewmodel.MvvmCustomViewNonNullState;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0015\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/blueair/viewcore/viewmodel/CustomConstraintLayoutNonNullState;", "S", "Landroid/os/Parcelable;", "VM", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewNonNullState;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSaveInstanceState", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewStateWrapper;", "onRestoreInstanceState", "", "state", "onLifecycleOwnerAttached", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onStateUpdate", "(Landroid/os/Parcelable;)V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MvvmCustomView.kt */
public abstract class CustomConstraintLayoutNonNullState<S extends Parcelable, VM extends MvvmCustomViewModelNonNullState<S>> extends ConstraintLayout implements MvvmCustomViewNonNullState<S, VM> {
    public abstract void onStateUpdate(S s);

    public void attachLifeCycle(LifecycleOwner lifecycleOwner) {
        MvvmCustomViewNonNullState.CC.$default$attachLifeCycle(this, lifecycleOwner);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomConstraintLayoutNonNullState(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomConstraintLayoutNonNullState(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrSet");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomConstraintLayoutNonNullState(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public MvvmCustomViewStateWrapper onSaveInstanceState() {
        return new MvvmCustomViewStateWrapper(super.onSaveInstanceState(), getViewModel().onSaveState());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof MvvmCustomViewStateWrapper) {
            MvvmCustomViewModelNonNullState viewModel = getViewModel();
            MvvmCustomViewStateWrapper mvvmCustomViewStateWrapper = (MvvmCustomViewStateWrapper) parcelable;
            Parcelable state = mvvmCustomViewStateWrapper.getState();
            Intrinsics.checkNotNull(state, "null cannot be cast to non-null type S of com.blueair.viewcore.viewmodel.CustomConstraintLayoutNonNullState");
            viewModel.setState(state);
            super.onRestoreInstanceState(mvvmCustomViewStateWrapper.getSuperState());
        }
    }

    public void onLifecycleOwnerAttached(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Timber.Forest forest = Timber.Forest;
        forest.d("onLifecycleOwnerAttached for " + lifecycleOwner, new Object[0]);
        LiveDataExtensionsKt.observeNonNull(getViewModel().getLiveData(), lifecycleOwner, new CustomConstraintLayoutNonNullState$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final Unit onLifecycleOwnerAttached$lambda$0(CustomConstraintLayoutNonNullState customConstraintLayoutNonNullState, Parcelable parcelable) {
        Intrinsics.checkNotNull(parcelable);
        customConstraintLayoutNonNullState.onStateUpdate(parcelable);
        return Unit.INSTANCE;
    }
}
