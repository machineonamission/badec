package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import com.blueair.core.model.MbLocationFeatures;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapboxPlacesSearchViewModel;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "searchResults", "", "Lcom/blueair/core/model/MbLocationFeatures;", "query", "", "", "onItemSelected", "position", "", "completion", "Lkotlin/Function1;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapboxPlacesSearchViewModel.kt */
public class MapboxPlacesSearchViewModel extends SearchViewModel {
    /* access modifiers changed from: private */
    public List<MbLocationFeatures> searchResults = CollectionsKt.emptyList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapboxPlacesSearchViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public void query(String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new MapboxPlacesSearchViewModel$query$1(this, str, (Continuation<? super MapboxPlacesSearchViewModel$query$1>) null), 2, (Object) null);
    }

    public void onItemSelected(int i, Function1<? super CustomPlace, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completion");
        if (i < this.searchResults.size()) {
            MbLocationFeatures mbLocationFeatures = this.searchResults.get(i);
            if (mbLocationFeatures.getCenter().size() == 2) {
                function1.invoke(new CustomPlace(mbLocationFeatures.getCenter().get(1).doubleValue(), mbLocationFeatures.getCenter().get(0).doubleValue(), mbLocationFeatures.getText(), mbLocationFeatures.getPlace_name()));
            } else {
                function1.invoke(null);
            }
        } else {
            function1.invoke(null);
        }
    }
}
