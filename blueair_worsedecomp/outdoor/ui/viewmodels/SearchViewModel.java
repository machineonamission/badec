package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.GeocodeService;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020(2\u0006\u0010'\u001a\u00020!H&J&\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020(0-H&J\u0013\u0010/\u001a\u0004\u0018\u00010\u001b2\u0006\u00100\u001a\u00020+H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R&\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00130\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "geocodeService", "Lcom/blueair/outdoor/service/GeocodeService;", "getGeocodeService", "()Lcom/blueair/outdoor/service/GeocodeService;", "geocodeService$delegate", "Lkotlin/Lazy;", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "savedLocations", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/TrackedLocation;", "getSavedLocations", "()Landroidx/lifecycle/LiveData;", "currentLocation", "getCurrentLocation", "searchItems", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "getSearchItems", "()Landroidx/lifecycle/MutableLiveData;", "setSearchItems", "(Landroidx/lifecycle/MutableLiveData;)V", "value", "", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "(Ljava/lang/String;)V", "query", "", "onItemSelected", "position", "", "completion", "Lkotlin/Function1;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "get", "i", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchViewModel.kt */
public abstract class SearchViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final LiveData<TrackedLocation> currentLocation = getOutdoorService().getDatabaseLiveCurrentLocation();
    private final Lazy geocodeService$delegate;
    private final Lazy outdoorService$delegate;
    private final LiveData<List<TrackedLocation>> savedLocations = getOutdoorService().getDatabaseLiveTrackedLocations();
    private MutableLiveData<List<SearchItemContainer>> searchItems = new MutableLiveData<>(CollectionsKt.emptyList());
    private String searchQuery = "";

    static {
        Class<SearchViewModel> cls = SearchViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "geocodeService", "getGeocodeService()Lcom/blueair/outdoor/service/GeocodeService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))};
    }

    public abstract void onItemSelected(int i, Function1<? super CustomPlace, Unit> function1);

    public abstract void query(String str);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new SearchViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, GeocodeService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.geocodeService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new SearchViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.outdoorService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, OutdoorService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    public final GeocodeService getGeocodeService() {
        return (GeocodeService) this.geocodeService$delegate.getValue();
    }

    private final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    public final LiveData<List<TrackedLocation>> getSavedLocations() {
        return this.savedLocations;
    }

    public final LiveData<TrackedLocation> getCurrentLocation() {
        return this.currentLocation;
    }

    public final MutableLiveData<List<SearchItemContainer>> getSearchItems() {
        return this.searchItems;
    }

    public final void setSearchItems(MutableLiveData<List<SearchItemContainer>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.searchItems = mutableLiveData;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final void setSearchQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.searchQuery = str;
        if (str.length() > 0) {
            query(this.searchQuery);
        } else {
            this.searchItems.setValue(CollectionsKt.emptyList());
        }
    }

    public final SearchItemContainer get(int i) {
        List value = this.searchItems.getValue();
        if (value != null) {
            return (SearchItemContainer) value.get(i);
        }
        return null;
    }
}
