package com.blueair.outdoor.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.ui.viewmodels.SearchItemContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/Bp\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0018\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020$8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u00060"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClicked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "onViewHolderClicked", "onSavedLocationClicked", "Lcom/blueair/core/model/TrackedLocation;", "location", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnItemClicked", "()Lkotlin/jvm/functions/Function1;", "value", "", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "(Ljava/lang/String;)V", "", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "searchResults", "getSearchResults", "()Ljava/util/List;", "setSearchResults", "(Ljava/util/List;)V", "savedLocations", "getSavedLocations", "setSavedLocations", "searchMode", "", "getSearchMode", "()Z", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "getItemCount", "onBindViewHolder", "holder", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchAdapter.kt */
public final class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SAVED_ITEM = 2;
    private static final int SEARCH_ITEM = 1;
    private final Function1<Integer, Unit> onItemClicked;
    private final Function1<TrackedLocation, Unit> onSavedLocationClicked;
    private final Function1<Integer, Unit> onViewHolderClicked;
    private List<TrackedLocation> savedLocations = CollectionsKt.emptyList();
    private String searchQuery = "";
    private List<SearchItemContainer> searchResults = CollectionsKt.emptyList();

    public final Function1<Integer, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    public SearchAdapter(Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12, Function1<? super TrackedLocation, Unit> function13) {
        Intrinsics.checkNotNullParameter(function1, "onItemClicked");
        Intrinsics.checkNotNullParameter(function12, "onViewHolderClicked");
        Intrinsics.checkNotNullParameter(function13, "onSavedLocationClicked");
        this.onItemClicked = function1;
        this.onViewHolderClicked = function12;
        this.onSavedLocationClicked = function13;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchAdapter$Companion;", "", "<init>", "()V", "SEARCH_ITEM", "", "SAVED_ITEM", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SearchAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final void setSearchQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.searchQuery = str;
        if (!getSearchMode()) {
            notifyDataSetChanged();
        }
    }

    public final List<SearchItemContainer> getSearchResults() {
        return this.searchResults;
    }

    public final void setSearchResults(List<SearchItemContainer> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.searchResults = list;
        if (getSearchMode()) {
            notifyDataSetChanged();
        }
    }

    public final List<TrackedLocation> getSavedLocations() {
        return this.savedLocations;
    }

    public final void setSavedLocations(List<TrackedLocation> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.savedLocations = list;
        if (!getSearchMode()) {
            notifyDataSetChanged();
        }
    }

    private final boolean getSearchMode() {
        return this.searchQuery.length() > 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 1) {
            return SearchViewHolder.Companion.newInstance(viewGroup);
        }
        if (i == 2) {
            return SavedLocationViewHolder.Companion.newInstance(viewGroup);
        }
        throw new IllegalArgumentException("Invalidate view type onCreateViewHolder");
    }

    public int getItemViewType(int i) {
        boolean searchMode = getSearchMode();
        if (searchMode) {
            return 1;
        }
        if (!searchMode) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getItemCount() {
        boolean searchMode = getSearchMode();
        if (searchMode) {
            return this.searchResults.size();
        }
        if (!searchMode) {
            return this.savedLocations.size();
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof SearchViewHolder) {
            ((SearchViewHolder) viewHolder).bind(this.searchResults.get(i), new SearchAdapter$$ExternalSyntheticLambda0(this, i), new SearchAdapter$$ExternalSyntheticLambda1(this, i));
        } else if (viewHolder instanceof SavedLocationViewHolder) {
            ((SavedLocationViewHolder) viewHolder).bind(this.savedLocations.get(i), this.savedLocations.get(i).isCurrentLocation(), this.onSavedLocationClicked);
        } else {
            throw new Exception("Invalidate view type onBindViewHolder");
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SearchAdapter searchAdapter, int i, View view) {
        searchAdapter.onItemClicked.invoke(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1(SearchAdapter searchAdapter, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        searchAdapter.onViewHolderClicked.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }
}
