package com.blueair.viewcore.viewmodel;

import android.content.Context;
import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.viewcore.viewmodel.MvvmCustomViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/blueair/viewcore/viewmodel/MvvmCustomView;", "S", "Landroid/os/Parcelable;", "VM", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModel;", "", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModel;", "attachLifeCycle", "", "context", "Landroid/content/Context;", "onLifecycleOwnerAttached", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MvvmCustomView.kt */
public interface MvvmCustomView<S extends Parcelable, VM extends MvvmCustomViewModel<S>> {
    void attachLifeCycle(Context context);

    VM getViewModel();

    void onLifecycleOwnerAttached(LifecycleOwner lifecycleOwner);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MvvmCustomView.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <S extends Parcelable, VM extends MvvmCustomViewModel<S>> void attachLifeCycle(MvvmCustomView<S, VM> mvvmCustomView, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CC.$default$attachLifeCycle(mvvmCustomView, context);
        }
    }

    /* renamed from: com.blueair.viewcore.viewmodel.MvvmCustomView$-CC  reason: invalid class name */
    /* compiled from: MvvmCustomView.kt */
    public final /* synthetic */ class CC {
        public static void $default$attachLifeCycle(MvvmCustomView _this, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Timber.Forest forest = Timber.Forest;
            forest.d("Attaching lifecycle for " + context, new Object[0]);
            LifecycleOwner lifecycleOwner = context instanceof LifecycleOwner ? (LifecycleOwner) context : null;
            if (lifecycleOwner != null) {
                _this.onLifecycleOwnerAttached(lifecycleOwner);
                return;
            }
            throw new LifecycleOwnerNotFoundException((String) null, 1, (DefaultConstructorMarker) null);
        }
    }
}
