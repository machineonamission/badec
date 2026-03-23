package com.blueair.viewcore.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.I18nConfig;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.HolderFilterTypeBinding;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;", "<init>", "(Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;)V", "getBinding", "()Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;", "update", "", "filter", "Lcom/blueair/core/model/FilterInfo;", "selected", "", "position", "", "onFilterInfoClickListener", "Lkotlin/Function1;", "onFilterSelectedListener", "Lkotlin/Function2;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterTypeHolder.kt */
public final class FilterTypeHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderFilterTypeBinding binding;

    public final HolderFilterTypeBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/viewcore/viewholder/FilterTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterTypeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilterTypeHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderFilterTypeBinding inflate = HolderFilterTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new FilterTypeHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterTypeHolder(HolderFilterTypeBinding holderFilterTypeBinding) {
        super(holderFilterTypeBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderFilterTypeBinding, "binding");
        this.binding = holderFilterTypeBinding;
    }

    public final void update(FilterInfo filterInfo, boolean z, int i, Function1<? super FilterInfo, Unit> function1, Function2<? super Integer, ? super FilterInfo, Unit> function2) {
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        HolderFilterTypeBinding holderFilterTypeBinding = this.binding;
        holderFilterTypeBinding.icon.setImageResource(filterInfo.getImage());
        holderFilterTypeBinding.name.setText(I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null));
        holderFilterTypeBinding.flIcon.setSelected(z);
        if (function2 != null) {
            holderFilterTypeBinding.flIcon.setOnClickListener(new FilterTypeHolder$$ExternalSyntheticLambda0(function2, i, filterInfo));
        }
        if (function1 != null) {
            holderFilterTypeBinding.ivInfo.setOnClickListener(new FilterTypeHolder$$ExternalSyntheticLambda1(function1, filterInfo));
        }
        holderFilterTypeBinding.ivInfo.setContentDescription(holderFilterTypeBinding.getRoot().getContext().getString(R.string.more_info_about, new Object[]{holderFilterTypeBinding.name.getText()}));
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$4$lambda$1$lambda$0(Function2 function2, int i, FilterInfo filterInfo, View view) {
        function2.invoke(Integer.valueOf(i), filterInfo);
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$4$lambda$3$lambda$2(Function1 function1, FilterInfo filterInfo, View view) {
        function1.invoke(filterInfo);
    }
}
