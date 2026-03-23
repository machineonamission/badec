package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/flatcircle/coroutinehelper/Failure;", "T", "Lio/flatcircle/coroutinehelper/ApiResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coroutinehelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ApiResult.kt */
public final class Failure<T> extends ApiResult<T> {
    private final Throwable error;

    public static /* synthetic */ Failure copy$default(Failure failure, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = failure.error;
        }
        return failure.copy(th);
    }

    public final Throwable component1() {
        return this.error;
    }

    public final Failure<T> copy(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "error");
        return new Failure<>(th);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.error, (Object) ((Failure) obj).error);
        }
        return true;
    }

    public int hashCode() {
        Throwable th = this.error;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Failure(error=" + this.error + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Failure(Throwable th) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(th, "error");
        this.error = th;
    }

    public final Throwable getError() {
        return this.error;
    }
}
