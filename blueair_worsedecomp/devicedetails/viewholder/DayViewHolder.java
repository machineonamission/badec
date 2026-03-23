package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.devicedetails.databinding.HolderDayBinding;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDayBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDayBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDayBinding;", "bind", "", "item", "Lcom/blueair/core/model/DayOfWeek;", "showTick", "", "onClick", "Lkotlin/Function0;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DayViewHolder.kt */
public final class DayViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDayBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DayViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DayViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DayViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DayViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderDayBinding inflate = HolderDayBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DayViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayViewHolder(HolderDayBinding holderDayBinding) {
        super(holderDayBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDayBinding, "binding");
        this.binding = holderDayBinding;
    }

    public final HolderDayBinding getBinding() {
        return this.binding;
    }

    public final void bind(DayOfWeek dayOfWeek, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "item");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        TextView textView = this.binding.day;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(DayOfWeekExtensionKt.displayValueEveryLong(dayOfWeek, context));
        if (z) {
            ImageView imageView = this.binding.tick;
            Intrinsics.checkNotNullExpressionValue(imageView, "tick");
            ViewExtensionsKt.show$default(imageView, false, 1, (Object) null);
        } else {
            this.binding.tick.setVisibility(4);
        }
        this.binding.getRoot().setOnClickListener(new DayViewHolder$$ExternalSyntheticLambda0(function0));
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$0(Function0 function0, View view) {
        function0.invoke();
    }
}
