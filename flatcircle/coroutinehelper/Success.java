package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lio/flatcircle/coroutinehelper/Success;", "T", "Lio/flatcircle/coroutinehelper/ApiResult;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lio/flatcircle/coroutinehelper/Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "coroutinehelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ApiResult.kt */
public final class Success<T> extends ApiResult<T> {
    private final T value;

    public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = success.value;
        }
        return success.copy(t);
    }

    public final T component1() {
        return this.value;
    }

    public final Success<T> copy(T t) {
        return new Success<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.value, (Object) ((Success) obj).value);
        }
        return true;
    }

    public int hashCode() {
        T t = this.value;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Success(value=" + this.value + ")";
    }

    public Success(T t) {
        super((DefaultConstructorMarker) null);
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }
}
