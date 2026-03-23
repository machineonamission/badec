package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "T", "", "action", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "variable", "<init>", "(Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;Ljava/lang/Object;)V", "getAction", "()Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "getVariable", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;Ljava/lang/Object;)Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "equals", "", "other", "hashCode", "", "toString", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public final class BaseViewModelEvent<T> {
    private final BaseViewModelAction<T> action;
    private final T variable;

    public static /* synthetic */ BaseViewModelEvent copy$default(BaseViewModelEvent baseViewModelEvent, BaseViewModelAction<T> baseViewModelAction, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            baseViewModelAction = baseViewModelEvent.action;
        }
        if ((i & 2) != 0) {
            t = baseViewModelEvent.variable;
        }
        return baseViewModelEvent.copy(baseViewModelAction, t);
    }

    public final BaseViewModelAction<T> component1() {
        return this.action;
    }

    public final T component2() {
        return this.variable;
    }

    public final BaseViewModelEvent<T> copy(BaseViewModelAction<T> baseViewModelAction, T t) {
        Intrinsics.checkNotNullParameter(baseViewModelAction, "action");
        return new BaseViewModelEvent<>(baseViewModelAction, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseViewModelEvent)) {
            return false;
        }
        BaseViewModelEvent baseViewModelEvent = (BaseViewModelEvent) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) baseViewModelEvent.action) && Intrinsics.areEqual((Object) this.variable, (Object) baseViewModelEvent.variable);
    }

    public int hashCode() {
        int hashCode = this.action.hashCode() * 31;
        T t = this.variable;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "BaseViewModelEvent(action=" + this.action + ", variable=" + this.variable + ')';
    }

    public BaseViewModelEvent(BaseViewModelAction<T> baseViewModelAction, T t) {
        Intrinsics.checkNotNullParameter(baseViewModelAction, "action");
        this.action = baseViewModelAction;
        this.variable = t;
    }

    public final BaseViewModelAction<T> getAction() {
        return this.action;
    }

    public final T getVariable() {
        return this.variable;
    }
}
