package com.blueair.outdoor.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.viewmodels.SearchItemContainer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "description", "imageButton", "Landroid/widget/ImageButton;", "bind", "", "prediction", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "onButtonClickListener", "Landroid/view/View$OnClickListener;", "onItemClicked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "place", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchAdapter.kt */
public final class SearchViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TextView description;
    private final ImageButton imageButton;
    private final TextView title;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/outdoor/ui/adapters/SearchViewHolder;", "parent", "Landroid/view/ViewGroup;", "createView", "Landroid/view/View;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SearchAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SearchViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new SearchViewHolder(createView(viewGroup));
        }

        private final View createView(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_search_place, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return inflate;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        View findViewById = this.itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.description = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.imageButton);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.imageButton = (ImageButton) findViewById3;
    }

    public final void bind(SearchItemContainer searchItemContainer, View.OnClickListener onClickListener, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(searchItemContainer, "prediction");
        Intrinsics.checkNotNullParameter(onClickListener, "onButtonClickListener");
        Intrinsics.checkNotNullParameter(function1, "onItemClicked");
        this.title.setText(searchItemContainer.getPrimaryText());
        this.description.setText(searchItemContainer.getSecondaryText());
        this.imageButton.setOnClickListener(onClickListener);
        this.itemView.setOnClickListener(new SearchViewHolder$$ExternalSyntheticLambda0(function1, searchItemContainer));
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$0(Function1 function1, SearchItemContainer searchItemContainer, View view) {
        function1.invoke(searchItemContainer.getId());
    }
}
