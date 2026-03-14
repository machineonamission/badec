package com.blueair.outdoor.ui.fragments;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.databinding.FragmentSearchBinding;
import com.blueair.outdoor.ui.activity.SearchActivity;
import com.blueair.outdoor.ui.adapters.SearchAdapter;
import com.blueair.outdoor.ui.viewmodels.AMapPlacesSearchViewModel;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.outdoor.ui.viewmodels.GooglePlacesSearchViewModel;
import com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel;
import com.blueair.outdoor.ui.viewmodels.SearchItemContainer;
import com.blueair.outdoor.ui.viewmodels.SearchViewModel;
import com.blueair.viewcore.extensions.ActivityExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"},
   d2 = {"Lcom/blueair/outdoor/ui/fragments/PlacesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "<init>", "()V", "searchApi", "Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "getSearchApi", "()Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "searchApi$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;)V", "binding", "Lcom/blueair/outdoor/databinding/FragmentSearchBinding;", "searchAdapter", "Lcom/blueair/outdoor/ui/adapters/SearchAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "", "buildViewModel", "configureCancelButton", "configureSearchBar", "configureSearchResults", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PlacesFragment extends BaseFragment {
   public static final long API_DEBOUNCE_TIME = 300L;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String KEY_SEARCH_API = "KEY_SEARCH_API";
   private FragmentSearchBinding binding;
   private SearchAdapter searchAdapter;
   private final Lazy searchApi$delegate = LazyKt.lazy(new PlacesFragment$$ExternalSyntheticLambda8(this));
   public SearchViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$17zYXgnbWkbCCBgmC00BiTzlkkE(Function1 var0, Object var1) {
      onResume$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$AMZJynIJHmNsNkXM8t5i5w8XXsI(PlacesFragment var0, CustomPlace var1) {
      return configureSearchResults$lambda$14$lambda$10$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FoOGq_K_uTcRftGlHtnivojQbUo(PlacesFragment var0, View var1) {
      configureSearchBar$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$KIyEHyivnyTqqZzBsZwx1bJ6Ly8(PlacesFragment var0, int var1) {
      return configureSearchResults$lambda$14$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NxFe2ou2nn4VvU1or9EfFEPOR84(PlacesFragment var0, int var1) {
      return configureSearchResults$lambda$14$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_H5Eznd8SkxwPUp__sWZlrzKa_M/* $FF was: $r8$lambda$_H5Eznd8SkxwPUp-_sWZlrzKa_M*/(PlacesFragment var0, List var1) {
      return configureSearchResults$lambda$14$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$c0IyAusdqVYU24UEtL0h8l93Hvo(PlacesFragment var0, List var1) {
      return configureSearchResults$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$itzVhuXGFQIbRQAXdrz9k84cjfU(PlacesFragment var0, View var1) {
      configureCancelButton$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static SearchActivity.SearchType $r8$lambda$tkzJl7ZyvJ3BIE136hGWXbKVSF8(PlacesFragment var0) {
      return searchApi_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$un15_KnWYgVl7bN3FgvgobTL4uc/* $FF was: $r8$lambda$un15-KnWYgVl7bN3FgvgobTL4uc*/(PlacesFragment var0, TextViewAfterTextChangeEvent var1) {
      return onResume$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wkyPAZ2kBeyOVciJo2jTqARYjJ4(PlacesFragment var0, TrackedLocation var1) {
      return configureSearchResults$lambda$14$lambda$11(var0, var1);
   }

   private final void buildViewModel() {
      FragmentActivity var2 = this.getActivity();
      if (var2 != null) {
         SearchActivity.SearchType var3 = this.getSearchApi();
         int var1 = PlacesFragment.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
         SearchViewModel var5;
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               Application var4 = var2.getApplication();
               Intrinsics.checkNotNullExpressionValue(var4, "getApplication(...)");
               var5 = new AMapPlacesSearchViewModel(var4);
            } else {
               Application var6 = var2.getApplication();
               Intrinsics.checkNotNullExpressionValue(var6, "getApplication(...)");
               var5 = new MapboxPlacesSearchViewModel(var6);
            }
         } else {
            Application var7 = var2.getApplication();
            Intrinsics.checkNotNullExpressionValue(var7, "getApplication(...)");
            var5 = new GooglePlacesSearchViewModel(var7);
         }

         this.setViewModel(var5);
      }

   }

   private final void configureCancelButton() {
      FragmentSearchBinding var2 = this.binding;
      FragmentSearchBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.cancelBtn.setOnClickListener(new PlacesFragment$$ExternalSyntheticLambda2(this));
   }

   private static final void configureCancelButton$lambda$5(PlacesFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
      ((SearchActivity)var2).searchCancelled();
   }

   private final void configureSearchBar() {
      FragmentSearchBinding var2 = this.binding;
      FragmentSearchBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.searchClearBtn.setOnClickListener(new PlacesFragment$$ExternalSyntheticLambda9(this));
   }

   private static final void configureSearchBar$lambda$6(PlacesFragment var0, View var1) {
      FragmentSearchBinding var3 = var0.binding;
      FragmentSearchBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.searchBar.setText((CharSequence)"");
   }

   private final void configureSearchResults() {
      if (this.getContext() != null) {
         this.searchAdapter = new SearchAdapter(new PlacesFragment$$ExternalSyntheticLambda3(this), new PlacesFragment$$ExternalSyntheticLambda4(this), new PlacesFragment$$ExternalSyntheticLambda5(this));
         this.getViewModel().getSearchItems().observe(this.getViewLifecycleOwner(), new Observer(new PlacesFragment$$ExternalSyntheticLambda6(this)) {
            private final Function1 function;

            {
               Intrinsics.checkNotNullParameter(var1, "function");
               this.function = var1;
            }

            public final boolean equals(Object var1) {
               return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
            }

            public final Function getFunctionDelegate() {
               return (Function)this.function;
            }

            public final int hashCode() {
               return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }

            // $FF: synthetic method
            public final void onChanged(Object var1) {
               this.function.invoke(var1);
            }
         });
      }

      FragmentSearchBinding var3 = this.binding;
      Object var2 = null;
      FragmentSearchBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      RecyclerView var4 = var1.searchResults;
      var4.setHasFixedSize(true);
      SearchAdapter var8 = this.searchAdapter;
      SearchAdapter var5 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
         var5 = null;
      }

      var4.setAdapter(var5);
      var4.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var4.getContext(), 1, false)));
      FragmentSearchBinding var9 = this.binding;
      FragmentSearchBinding var6 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      DividerItemDecoration var10 = new DividerItemDecoration(var6.searchResults.getContext(), 1);
      var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (FragmentSearchBinding)var2;
      }

      var6.searchResults.addItemDecoration((RecyclerView.ItemDecoration)var10);
      this.getViewModel().getSavedLocations().observe(this.getViewLifecycleOwner(), new Observer(new PlacesFragment$$ExternalSyntheticLambda7(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final Unit configureSearchResults$lambda$14$lambda$10(PlacesFragment var0, int var1) {
      var0.getViewModel().onItemSelected(var1, new PlacesFragment$$ExternalSyntheticLambda0(var0));
      return Unit.INSTANCE;
   }

   private static final Unit configureSearchResults$lambda$14$lambda$10$lambda$9(PlacesFragment var0, CustomPlace var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         ActivityExtensionsKt.dismissKeyboard((Activity)var2);
      }

      Intent var4 = new Intent();
      var4.putExtra("place", var1);
      FragmentActivity var3 = var0.getActivity();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
      ((SearchActivity)var3).searchCompleted(var4);
      return Unit.INSTANCE;
   }

   private static final Unit configureSearchResults$lambda$14$lambda$11(PlacesFragment var0, TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "savedLocation");
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         ActivityExtensionsKt.dismissKeyboard((Activity)var2);
      }

      Intent var4 = new Intent();
      var4.putExtra("savedloc", var1);
      FragmentActivity var3 = var0.getActivity();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
      ((SearchActivity)var3).searchCompleted(var4);
      return Unit.INSTANCE;
   }

   private static final Unit configureSearchResults$lambda$14$lambda$13(PlacesFragment var0, List var1) {
      SearchAdapter var7 = var0.searchAdapter;
      Object var6 = null;
      SearchAdapter var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
         var5 = null;
      }

      var5.setSearchQuery(var0.getViewModel().getSearchQuery());
      Intrinsics.checkNotNull(var1);
      var5.setSearchResults(var1);
      FragmentSearchBinding var18 = var0.binding;
      FragmentSearchBinding var11 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      TextView var12 = var11.noResultsTextView;
      Intrinsics.checkNotNullExpressionValue(var12, "noResultsTextView");
      View var13 = (View)var12;
      int var2 = ((CharSequence)var5.getSearchQuery()).length();
      boolean var4 = true;
      byte var3 = 0;
      if (var2 > 0 && var5.getSearchResults().isEmpty()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      if (var2) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var13.setVisibility(var2);
      FragmentSearchBinding var8 = var0.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (FragmentSearchBinding)var6;
      }

      TextView var9 = var8.headerTextView;
      Intrinsics.checkNotNullExpressionValue(var9, "headerTextView");
      View var10 = (View)var9;
      if (((CharSequence)var5.getSearchQuery()).length() == 0) {
         var2 = var4;
      } else {
         var2 = 0;
      }

      if (var2) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var10.setVisibility(var2);
      return Unit.INSTANCE;
   }

   private static final Unit configureSearchResults$lambda$14$lambda$8(PlacesFragment var0, int var1) {
      SearchItemContainer var2 = var0.getViewModel().get(var1);
      if (var2 != null) {
         String var5 = var2.getPrimaryText();
         FragmentSearchBinding var4 = var0.binding;
         Object var3 = null;
         FragmentSearchBinding var7 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         EditText var9 = var7.searchBar;
         CharSequence var8 = (CharSequence)var5;
         var9.setText(var8);
         FragmentSearchBinding var6 = var0.binding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = (FragmentSearchBinding)var3;
         }

         var6.searchBar.setSelection(var8.length());
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureSearchResults$lambda$17(PlacesFragment var0, List var1) {
      SearchAdapter var2 = var0.searchAdapter;
      SearchAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
         var3 = null;
      }

      Intrinsics.checkNotNull(var1);
      var3.setSavedLocations(CollectionsKt.sortedWith((Iterable)var1, new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((TrackedLocation)var1).isCurrentLocation(), (Comparable)((TrackedLocation)var2).isCurrentLocation());
         }
      }));
      return Unit.INSTANCE;
   }

   private final SearchActivity.SearchType getSearchApi() {
      return (SearchActivity.SearchType)this.searchApi$delegate.getValue();
   }

   private static final Unit onResume$lambda$2(PlacesFragment var0, TextViewAfterTextChangeEvent var1) {
      Editable var9 = var1.editable();
      if (var9 != null) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("Triggering api call with ");
         var4.append(var9);
         var3.d(var4.toString(), new Object[0]);
         var0.getViewModel().setSearchQuery(var9.toString());
         int var2 = ((CharSequence)var0.getViewModel().getSearchQuery()).length();
         Object var10 = null;
         if (var2 > 0) {
            FragmentSearchBinding var11 = var0.binding;
            FragmentSearchBinding var5 = var11;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var5 = null;
            }

            ImageButton var6 = var5.searchClearBtn;
            Intrinsics.checkNotNullExpressionValue(var6, "searchClearBtn");
            ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
         } else {
            FragmentSearchBinding var7 = var0.binding;
            if (var7 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var7 = (FragmentSearchBinding)var10;
            }

            ImageButton var8 = var7.searchClearBtn;
            Intrinsics.checkNotNullExpressionValue(var8, "searchClearBtn");
            ViewExtensionsKt.hide((View)var8);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$3(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final SearchActivity.SearchType searchApi_delegate$lambda$0(PlacesFragment var0) {
      int var2 = SearchActivity.SearchType.GOOGLE.ordinal();
      SearchActivity.SearchType[] var3 = SearchActivity.SearchType.values();
      Bundle var4 = var0.getArguments();
      int var1 = var2;
      if (var4 != null) {
         var1 = var2;
         if (var4.containsKey("KEY_SEARCH_API")) {
            Bundle var5 = var0.getArguments();
            var1 = var2;
            if (var5 != null) {
               var1 = var5.getInt("KEY_SEARCH_API");
            }
         }
      }

      return var3[var1];
   }

   public SearchViewModel getViewModel() {
      SearchViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.buildViewModel();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentSearchBinding var4 = FragmentSearchBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      this.configureSearchBar();
      this.configureCancelButton();
      this.configureSearchResults();
      FragmentSearchBinding var7 = this.binding;
      var4 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ConstraintLayout var6 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return (View)var6;
   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var3 = this.getRxSubs();
      FragmentSearchBinding var2 = this.binding;
      FragmentSearchBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var3.add(RxTextView.afterTextChangeEvents((TextView)var1.searchBar).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new PlacesFragment$$ExternalSyntheticLambda1(new PlacesFragment$$ExternalSyntheticLambda10(this))));
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentSearchBinding var4 = this.binding;
      FragmentSearchBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      var3.searchBar.requestFocus();
   }

   public void setViewModel(SearchViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/outdoor/ui/fragments/PlacesFragment$Companion;", "", "<init>", "()V", "API_DEBOUNCE_TIME", "", "KEY_SEARCH_API", "", "newInstance", "Lcom/blueair/outdoor/ui/fragments/PlacesFragment;", "searchApi", "Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "outdoor_otherRelease"},
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

      public final PlacesFragment newInstance(SearchActivity.SearchType var1) {
         Intrinsics.checkNotNullParameter(var1, "searchApi");
         Bundle var2 = new Bundle();
         var2.putInt("KEY_SEARCH_API", var1.ordinal());
         PlacesFragment var3 = new PlacesFragment();
         var3.setArguments(var2);
         return var3;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[SearchActivity.SearchType.values().length];

         try {
            var0[SearchActivity.SearchType.GOOGLE.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SearchActivity.SearchType.MAPBOX.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SearchActivity.SearchType.AMAP.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
