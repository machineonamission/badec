package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\r\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lio/flatcircle/coroutinehelper/ApiResult;", "T", "", "()V", "isFailure", "", "()Z", "isSuccess", "exceptionOrNull", "", "getOrNull", "()Ljava/lang/Object;", "Companion", "Lio/flatcircle/coroutinehelper/Success;", "Lio/flatcircle/coroutinehelper/Failure;", "coroutinehelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ApiResult.kt */
public abstract class ApiResult<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private ApiResult() {
    }

    public /* synthetic */ ApiResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\n\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005J\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005J\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/flatcircle/coroutinehelper/ApiResult$Companion;", "", "()V", "fail", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "error", "", "fromResult", "originalResult", "successValue", "(Lio/flatcircle/coroutinehelper/ApiResult;Ljava/lang/Object;)Lio/flatcircle/coroutinehelper/ApiResult;", "notImplemented", "purposefullyLeftEmpty", "success", "value", "(Ljava/lang/Object;)Lio/flatcircle/coroutinehelper/ApiResult;", "coroutinehelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ApiResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> ApiResult<T> fromResult(ApiResult<?> apiResult, T t) {
            Intrinsics.checkParameterIsNotNull(apiResult, "originalResult");
            if ((apiResult instanceof Success) && t != null) {
                return new Success<>(t);
            }
            if (apiResult instanceof Failure) {
                return new Failure<>(((Failure) apiResult).getError());
            }
            return new Failure<>(new IllegalArgumentException("Cannot convert " + apiResult + " without successvalue, " + t));
        }

        public final <T> ApiResult<T> purposefullyLeftEmpty() {
            return new Failure<>(new PurposeFullyLeftEmptyException("This API call is not implemented on this specific client."));
        }

        public final <T> ApiResult<T> notImplemented() {
            return new Failure<>(new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null));
        }

        public final <T> ApiResult<T> success(T t) {
            return new Success<>(t);
        }

        public final <T> ApiResult<T> fail(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "error");
            return new Failure<>(th);
        }
    }

    public final boolean isSuccess() {
        return !(this instanceof Failure);
    }

    public final boolean isFailure() {
        return this instanceof Failure;
    }

    public final T getOrNull() {
        if (this instanceof Failure) {
            return null;
        }
        if (this instanceof Success) {
            return ((Success) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Throwable exceptionOrNull() {
        if (this instanceof Failure) {
            return ((Failure) this).getError();
        }
        return null;
    }
}
