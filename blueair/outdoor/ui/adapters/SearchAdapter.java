package com.blueair.outdoor.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.ui.viewmodels.SearchItemContainer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/Bp\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0018\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u00060"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClicked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "onViewHolderClicked", "onSavedLocationClicked", "Lcom/blueair/core/model/TrackedLocation;", "location", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnItemClicked", "()Lkotlin/jvm/functions/Function1;", "value", "", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "(Ljava/lang/String;)V", "", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "searchResults", "getSearchResults", "()Ljava/util/List;", "setSearchResults", "(Ljava/util/List;)V", "savedLocations", "getSavedLocations", "setSavedLocations", "searchMode", "", "getSearchMode", "()Z", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "getItemCount", "onBindViewHolder", "holder", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchAdapter extends RecyclerView.Adapter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int SAVED_ITEM = 2;
   private static final int SEARCH_ITEM = 1;
   private final Function1 onItemClicked;
   private final Function1 onSavedLocationClicked;
   private final Function1 onViewHolderClicked;
   private List savedLocations;
   private String searchQuery;
   private List searchResults;

   // $FF: synthetic method
   public static void $r8$lambda$fKIs0mBd3jR4t8uhOCmI5NwgNZQ(SearchAdapter var0, int var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$hEBhPA_ZAGMBuudkJ53TyoiadJk(SearchAdapter var0, int var1, String var2) {
      return onBindViewHolder$lambda$1(var0, var1, var2);
   }

   public SearchAdapter(Function1 var1, Function1 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "onItemClicked");
      Intrinsics.checkNotNullParameter(var2, "onViewHolderClicked");
      Intrinsics.checkNotNullParameter(var3, "onSavedLocationClicked");
      super();
      this.onItemClicked = var1;
      this.onViewHolderClicked = var2;
      this.onSavedLocationClicked = var3;
      this.searchQuery = "";
      this.searchResults = CollectionsKt.emptyList();
      this.savedLocations = CollectionsKt.emptyList();
   }

   private final boolean getSearchMode() {
      return ((CharSequence)this.searchQuery).length() > 0;
   }

   private static final void onBindViewHolder$lambda$0(SearchAdapter var0, int var1, View var2) {
      var0.onItemClicked.invoke(var1);
   }

   private static final Unit onBindViewHolder$lambda$1(SearchAdapter var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      var0.onViewHolderClicked.invoke(var1);
      return Unit.INSTANCE;
   }

   public int getItemCount() {
      boolean var1 = this.getSearchMode();
      if (var1) {
         return ((Collection)this.searchResults).size();
      } else if (!var1) {
         return ((Collection)this.savedLocations).size();
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public int getItemViewType(int var1) {
      boolean var2 = this.getSearchMode();
      if (var2) {
         return 1;
      } else if (!var2) {
         return 2;
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public final Function1 getOnItemClicked() {
      return this.onItemClicked;
   }

   public final List getSavedLocations() {
      return this.savedLocations;
   }

   public final String getSearchQuery() {
      return this.searchQuery;
   }

   public final List getSearchResults() {
      return this.searchResults;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof SearchViewHolder) {
         SearchItemContainer var3 = (SearchItemContainer)this.searchResults.get(var2);
         ((SearchViewHolder)var1).bind(var3, new SearchAdapter$$ExternalSyntheticLambda0(this, var2), new SearchAdapter$$ExternalSyntheticLambda1(this, var2));
      } else if (var1 instanceof SavedLocationViewHolder) {
         ((SavedLocationViewHolder)var1).bind((TrackedLocation)this.savedLocations.get(var2), ((TrackedLocation)this.savedLocations.get(var2)).isCurrentLocation(), this.onSavedLocationClicked);
      } else {
         throw new Exception("Invalidate view type onBindViewHolder");
      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 1) {
         if (var2 == 2) {
            return SavedLocationViewHolder.Companion.newInstance(var1);
         } else {
            throw new IllegalArgumentException("Invalidate view type onCreateViewHolder");
         }
      } else {
         return SearchViewHolder.Companion.newInstance(var1);
      }
   }

   public final void setSavedLocations(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.savedLocations = var1;
      if (!this.getSearchMode()) {
         this.notifyDataSetChanged();
      }

   }

   public final void setSearchQuery(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.searchQuery = var1;
      if (!this.getSearchMode()) {
         this.notifyDataSetChanged();
      }

   }

   public final void setSearchResults(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.searchResults = var1;
      if (this.getSearchMode()) {
         this.notifyDataSetChanged();
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/outdoor/ui/adapters/SearchAdapter$Companion;", "", "<init>", "()V", "SEARCH_ITEM", "", "SAVED_ITEM", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
