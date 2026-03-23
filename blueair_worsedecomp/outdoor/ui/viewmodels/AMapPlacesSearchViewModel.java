package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/AMapPlacesSearchViewModel;", "Lcom/blueair/outdoor/ui/viewmodels/MapboxPlacesSearchViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AMapPlacesSearchViewModel.kt */
public final class AMapPlacesSearchViewModel extends MapboxPlacesSearchViewModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AMapPlacesSearchViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }
}
