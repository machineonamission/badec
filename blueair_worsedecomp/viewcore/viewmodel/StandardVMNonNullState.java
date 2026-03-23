package com.blueair.viewcore.viewmodel;

import android.os.Parcelable;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00028\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/blueair/viewcore/viewmodel/StandardVMNonNullState;", "S", "Landroid/os/Parcelable;", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "<init>", "()V", "stateLock", "", "getStateLock", "()Ljava/lang/Object;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "defaultState", "getDefaultState", "()Landroid/os/Parcelable;", "value", "state", "getState", "setState", "(Landroid/os/Parcelable;)V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MvvmCustomView.kt */
public abstract class StandardVMNonNullState<S extends Parcelable> implements MvvmCustomViewModelNonNullState<S> {
    private final MutableLiveData<S> liveData = new MutableLiveData<>();
    private final Object stateLock = new Object();

    /* access modifiers changed from: protected */
    public abstract S getDefaultState();

    /* access modifiers changed from: protected */
    public final Object getStateLock() {
        return this.stateLock;
    }

    public MutableLiveData<S> getLiveData() {
        return this.liveData;
    }

    public S getState() {
        S s;
        synchronized (this.stateLock) {
            s = (Parcelable) getLiveData().getValue();
            if (s == null) {
                s = getDefaultState();
            }
        }
        return s;
    }

    public void setState(S s) {
        Intrinsics.checkNotNullParameter(s, "value");
        synchronized (this.stateLock) {
            getLiveData().setValue(s);
            Unit unit = Unit.INSTANCE;
        }
    }
}
