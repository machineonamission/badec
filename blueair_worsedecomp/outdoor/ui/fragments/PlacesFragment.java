package com.blueair.outdoor.ui.fragments;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
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
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/blueair/outdoor/ui/fragments/PlacesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "<init>", "()V", "searchApi", "Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "getSearchApi", "()Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "searchApi$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;)V", "binding", "Lcom/blueair/outdoor/databinding/FragmentSearchBinding;", "searchAdapter", "Lcom/blueair/outdoor/ui/adapters/SearchAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "", "buildViewModel", "configureCancelButton", "configureSearchBar", "configureSearchResults", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PlacesFragment.kt */
public final class PlacesFragment extends BaseFragment<SearchViewModel> {
    public static final long API_DEBOUNCE_TIME = 300;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_SEARCH_API = "KEY_SEARCH_API";
    private FragmentSearchBinding binding;
    private SearchAdapter searchAdapter;
    private final Lazy searchApi$delegate = LazyKt.lazy(new PlacesFragment$$ExternalSyntheticLambda8(this));
    public SearchViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PlacesFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.outdoor.ui.activity.SearchActivity$SearchType[] r0 = com.blueair.outdoor.ui.activity.SearchActivity.SearchType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.outdoor.ui.activity.SearchActivity$SearchType r1 = com.blueair.outdoor.ui.activity.SearchActivity.SearchType.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.outdoor.ui.activity.SearchActivity$SearchType r1 = com.blueair.outdoor.ui.activity.SearchActivity.SearchType.MAPBOX     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.outdoor.ui.activity.SearchActivity$SearchType r1 = com.blueair.outdoor.ui.activity.SearchActivity.SearchType.AMAP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.fragments.PlacesFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/outdoor/ui/fragments/PlacesFragment$Companion;", "", "<init>", "()V", "API_DEBOUNCE_TIME", "", "KEY_SEARCH_API", "", "newInstance", "Lcom/blueair/outdoor/ui/fragments/PlacesFragment;", "searchApi", "Lcom/blueair/outdoor/ui/activity/SearchActivity$SearchType;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PlacesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlacesFragment newInstance(SearchActivity.SearchType searchType) {
            Intrinsics.checkNotNullParameter(searchType, "searchApi");
            Bundle bundle = new Bundle();
            bundle.putInt(PlacesFragment.KEY_SEARCH_API, searchType.ordinal());
            PlacesFragment placesFragment = new PlacesFragment();
            placesFragment.setArguments(bundle);
            return placesFragment;
        }
    }

    private final SearchActivity.SearchType getSearchApi() {
        return (SearchActivity.SearchType) this.searchApi$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SearchActivity.SearchType searchApi_delegate$lambda$0(PlacesFragment placesFragment) {
        Bundle arguments;
        int ordinal = SearchActivity.SearchType.GOOGLE.ordinal();
        SearchActivity.SearchType[] values = SearchActivity.SearchType.values();
        Bundle arguments2 = placesFragment.getArguments();
        if (!(arguments2 == null || !arguments2.containsKey(KEY_SEARCH_API) || (arguments = placesFragment.getArguments()) == null)) {
            ordinal = arguments.getInt(KEY_SEARCH_API);
        }
        return values[ordinal];
    }

    public SearchViewModel getViewModel() {
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel != null) {
            return searchViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(SearchViewModel searchViewModel) {
        Intrinsics.checkNotNullParameter(searchViewModel, "<set-?>");
        this.viewModel = searchViewModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        buildViewModel();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSearchBinding inflate = FragmentSearchBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        configureSearchBar();
        configureCancelButton();
        configureSearchResults();
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        ConstraintLayout root = fragmentSearchBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        fragmentSearchBinding.searchBar.requestFocus();
    }

    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        rxSubs.add(RxTextView.afterTextChangeEvents(fragmentSearchBinding.searchBar).skipInitialValue().debounce(300, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new PlacesFragment$$ExternalSyntheticLambda1(new PlacesFragment$$ExternalSyntheticLambda10(this))));
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$3(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$2(PlacesFragment placesFragment, TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        Editable editable = textViewAfterTextChangeEvent.editable();
        if (editable != null) {
            Timber.Forest.d("Triggering api call with " + editable, new Object[0]);
            placesFragment.getViewModel().setSearchQuery(editable.toString());
            FragmentSearchBinding fragmentSearchBinding = null;
            if (placesFragment.getViewModel().getSearchQuery().length() > 0) {
                FragmentSearchBinding fragmentSearchBinding2 = placesFragment.binding;
                if (fragmentSearchBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSearchBinding2 = null;
                }
                ImageButton imageButton = fragmentSearchBinding2.searchClearBtn;
                Intrinsics.checkNotNullExpressionValue(imageButton, "searchClearBtn");
                ViewExtensionsKt.show$default(imageButton, false, 1, (Object) null);
            } else {
                FragmentSearchBinding fragmentSearchBinding3 = placesFragment.binding;
                if (fragmentSearchBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentSearchBinding = fragmentSearchBinding3;
                }
                ImageButton imageButton2 = fragmentSearchBinding.searchClearBtn;
                Intrinsics.checkNotNullExpressionValue(imageButton2, "searchClearBtn");
                ViewExtensionsKt.hide(imageButton2);
            }
        }
        return Unit.INSTANCE;
    }

    private final void buildViewModel() {
        SearchViewModel searchViewModel;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[getSearchApi().ordinal()];
            if (i == 1) {
                Application application = activity.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
                searchViewModel = new GooglePlacesSearchViewModel(application);
            } else if (i == 2) {
                Application application2 = activity.getApplication();
                Intrinsics.checkNotNullExpressionValue(application2, "getApplication(...)");
                searchViewModel = new MapboxPlacesSearchViewModel(application2);
            } else if (i == 3) {
                Application application3 = activity.getApplication();
                Intrinsics.checkNotNullExpressionValue(application3, "getApplication(...)");
                searchViewModel = new AMapPlacesSearchViewModel(application3);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            setViewModel(searchViewModel);
        }
    }

    private final void configureCancelButton() {
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        fragmentSearchBinding.cancelBtn.setOnClickListener(new PlacesFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void configureCancelButton$lambda$5(PlacesFragment placesFragment, View view) {
        FragmentActivity activity = placesFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
        ((SearchActivity) activity).searchCancelled();
    }

    private final void configureSearchBar() {
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        fragmentSearchBinding.searchClearBtn.setOnClickListener(new PlacesFragment$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final void configureSearchBar$lambda$6(PlacesFragment placesFragment, View view) {
        FragmentSearchBinding fragmentSearchBinding = placesFragment.binding;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        fragmentSearchBinding.searchBar.setText("");
    }

    private final void configureSearchResults() {
        if (getContext() != null) {
            this.searchAdapter = new SearchAdapter(new PlacesFragment$$ExternalSyntheticLambda3(this), new PlacesFragment$$ExternalSyntheticLambda4(this), new PlacesFragment$$ExternalSyntheticLambda5(this));
            getViewModel().getSearchItems().observe(getViewLifecycleOwner(), new PlacesFragment$sam$androidx_lifecycle_Observer$0(new PlacesFragment$$ExternalSyntheticLambda6(this)));
        }
        FragmentSearchBinding fragmentSearchBinding = this.binding;
        FragmentSearchBinding fragmentSearchBinding2 = null;
        if (fragmentSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding = null;
        }
        RecyclerView recyclerView = fragmentSearchBinding.searchResults;
        recyclerView.setHasFixedSize(true);
        SearchAdapter searchAdapter2 = this.searchAdapter;
        if (searchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
            searchAdapter2 = null;
        }
        recyclerView.setAdapter(searchAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        FragmentSearchBinding fragmentSearchBinding3 = this.binding;
        if (fragmentSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding3 = null;
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentSearchBinding3.searchResults.getContext(), 1);
        FragmentSearchBinding fragmentSearchBinding4 = this.binding;
        if (fragmentSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSearchBinding2 = fragmentSearchBinding4;
        }
        fragmentSearchBinding2.searchResults.addItemDecoration(dividerItemDecoration);
        getViewModel().getSavedLocations().observe(getViewLifecycleOwner(), new PlacesFragment$sam$androidx_lifecycle_Observer$0(new PlacesFragment$$ExternalSyntheticLambda7(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$14$lambda$8(PlacesFragment placesFragment, int i) {
        SearchItemContainer searchItemContainer = placesFragment.getViewModel().get(i);
        if (searchItemContainer != null) {
            String primaryText = searchItemContainer.getPrimaryText();
            FragmentSearchBinding fragmentSearchBinding = placesFragment.binding;
            FragmentSearchBinding fragmentSearchBinding2 = null;
            if (fragmentSearchBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSearchBinding = null;
            }
            CharSequence charSequence = primaryText;
            fragmentSearchBinding.searchBar.setText(charSequence);
            FragmentSearchBinding fragmentSearchBinding3 = placesFragment.binding;
            if (fragmentSearchBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSearchBinding2 = fragmentSearchBinding3;
            }
            fragmentSearchBinding2.searchBar.setSelection(charSequence.length());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$14$lambda$10(PlacesFragment placesFragment, int i) {
        placesFragment.getViewModel().onItemSelected(i, new PlacesFragment$$ExternalSyntheticLambda0(placesFragment));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$14$lambda$10$lambda$9(PlacesFragment placesFragment, CustomPlace customPlace) {
        FragmentActivity activity = placesFragment.getActivity();
        if (activity != null) {
            ActivityExtensionsKt.dismissKeyboard(activity);
        }
        Intent intent = new Intent();
        intent.putExtra(SearchActivity.SEARCH_REQUEST_KEY, customPlace);
        FragmentActivity activity2 = placesFragment.getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
        ((SearchActivity) activity2).searchCompleted(intent);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$14$lambda$11(PlacesFragment placesFragment, TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "savedLocation");
        FragmentActivity activity = placesFragment.getActivity();
        if (activity != null) {
            ActivityExtensionsKt.dismissKeyboard(activity);
        }
        Intent intent = new Intent();
        intent.putExtra(SearchActivity.SAVED_LOCATION_KEY, trackedLocation);
        FragmentActivity activity2 = placesFragment.getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.blueair.outdoor.ui.activity.SearchActivity");
        ((SearchActivity) activity2).searchCompleted(intent);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$14$lambda$13(PlacesFragment placesFragment, List list) {
        SearchAdapter searchAdapter2 = placesFragment.searchAdapter;
        FragmentSearchBinding fragmentSearchBinding = null;
        if (searchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
            searchAdapter2 = null;
        }
        searchAdapter2.setSearchQuery(placesFragment.getViewModel().getSearchQuery());
        Intrinsics.checkNotNull(list);
        searchAdapter2.setSearchResults(list);
        FragmentSearchBinding fragmentSearchBinding2 = placesFragment.binding;
        if (fragmentSearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchBinding2 = null;
        }
        TextView textView = fragmentSearchBinding2.noResultsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "noResultsTextView");
        boolean z = true;
        int i = 0;
        textView.setVisibility(searchAdapter2.getSearchQuery().length() > 0 && searchAdapter2.getSearchResults().isEmpty() ? 0 : 8);
        FragmentSearchBinding fragmentSearchBinding3 = placesFragment.binding;
        if (fragmentSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSearchBinding = fragmentSearchBinding3;
        }
        TextView textView2 = fragmentSearchBinding.headerTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "headerTextView");
        View view = textView2;
        if (searchAdapter2.getSearchQuery().length() != 0) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSearchResults$lambda$17(PlacesFragment placesFragment, List list) {
        SearchAdapter searchAdapter2 = placesFragment.searchAdapter;
        if (searchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
            searchAdapter2 = null;
        }
        Intrinsics.checkNotNull(list);
        searchAdapter2.setSavedLocations(CollectionsKt.sortedWith(list, new PlacesFragment$configureSearchResults$lambda$17$$inlined$sortedBy$1()));
        return Unit.INSTANCE;
    }
}
