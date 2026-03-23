package com.blueair.outdoor.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.databinding.HolderSearchSavedLocationBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\u0013H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;", "<init>", "(Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;)V", "getBinding", "()Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;", "primary", "Landroid/widget/TextView;", "getPrimary", "()Landroid/widget/TextView;", "bind", "", "location", "Lcom/blueair/core/model/TrackedLocation;", "isCurrentLocation", "", "onSavedLocationClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchAdapter.kt */
final class SavedLocationViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderSearchSavedLocationBinding binding;
    private final TextView primary;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder;", "parent", "Landroid/view/ViewGroup;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SearchAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SavedLocationViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderSearchSavedLocationBinding inflate = HolderSearchSavedLocationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new SavedLocationViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedLocationViewHolder(HolderSearchSavedLocationBinding holderSearchSavedLocationBinding) {
        super(holderSearchSavedLocationBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderSearchSavedLocationBinding, "binding");
        this.binding = holderSearchSavedLocationBinding;
        TextView textView = holderSearchSavedLocationBinding.primaryText;
        Intrinsics.checkNotNullExpressionValue(textView, "primaryText");
        this.primary = textView;
    }

    public final HolderSearchSavedLocationBinding getBinding() {
        return this.binding;
    }

    public final TextView getPrimary() {
        return this.primary;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bind(com.blueair.core.model.TrackedLocation r5, boolean r6, kotlin.jvm.functions.Function1<? super com.blueair.core.model.TrackedLocation, kotlin.Unit> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "location"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onSavedLocationClicked"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.widget.TextView r0 = r4.primary
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.getLocationName()
            r1.append(r2)
            java.lang.String r2 = " - "
            r1.append(r2)
            java.lang.String r2 = r5.getCityName()
            if (r2 != 0) goto L_0x002b
            java.lang.String r2 = r5.getCountryName()
            if (r2 != 0) goto L_0x002b
            java.lang.String r2 = ""
        L_0x002b:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            r1 = 1
            r2 = 1103101952(0x41c00000, float:24.0)
            float r0 = android.util.TypedValue.applyDimension(r1, r2, r0)
            int r0 = (int) r0
            r1 = 0
            if (r6 == 0) goto L_0x0070
            android.view.View r6 = r4.itemView
            android.content.Context r6 = r6.getContext()
            int r2 = com.blueair.viewcore.R.drawable.ic_gps
            android.graphics.drawable.Drawable r6 = androidx.core.content.ContextCompat.getDrawable(r6, r2)
            if (r6 == 0) goto L_0x0083
            android.graphics.drawable.Drawable r6 = r6.mutate()
            if (r6 == 0) goto L_0x0083
            android.view.View r2 = r4.itemView
            android.content.Context r2 = r2.getContext()
            int r3 = com.blueair.viewcore.R.color.marineblue
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r6.setTint(r2)
            goto L_0x0084
        L_0x0070:
            android.view.View r6 = r4.itemView
            android.content.Context r6 = r6.getContext()
            int r2 = com.blueair.viewcore.R.drawable.ic_location_marker_selected
            android.graphics.drawable.Drawable r6 = androidx.core.content.ContextCompat.getDrawable(r6, r2)
            if (r6 == 0) goto L_0x0083
            android.graphics.drawable.Drawable r6 = r6.mutate()
            goto L_0x0084
        L_0x0083:
            r6 = r1
        L_0x0084:
            if (r6 == 0) goto L_0x008a
            r2 = 0
            r6.setBounds(r2, r2, r0, r0)
        L_0x008a:
            android.widget.TextView r0 = r4.primary
            r0.setCompoundDrawables(r6, r1, r1, r1)
            android.view.View r6 = r4.itemView
            com.blueair.outdoor.ui.adapters.SavedLocationViewHolder$$ExternalSyntheticLambda0 r0 = new com.blueair.outdoor.ui.adapters.SavedLocationViewHolder$$ExternalSyntheticLambda0
            r0.<init>(r7, r5)
            r6.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.adapters.SavedLocationViewHolder.bind(com.blueair.core.model.TrackedLocation, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$1(Function1 function1, TrackedLocation trackedLocation, View view) {
        function1.invoke(trackedLocation);
    }
}
