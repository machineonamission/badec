package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.outdoor.databinding.HolderSavedLocationBinding;
import com.blueair.outdoor.ui.dialog.LocationEditNameDialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.OutdoorUiUtils;
import com.blueair.viewcore.view.AllQualityStatusView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0001\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001f2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0013\u0018\u00010#2*\b\u0002\u0010$\u001a$\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u0013\u0018\u00010%J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010(\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "binding", "Lcom/blueair/outdoor/databinding/HolderSavedLocationBinding;", "getBinding", "()Lcom/blueair/outdoor/databinding/HolderSavedLocationBinding;", "configureAs", "", "type", "Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "showAssignProduct", "", "bind", "data", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mapType", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "location", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "devices", "TYPE", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationAdapter.kt */
public final class LocationView extends ConstraintLayout {
    private final HolderSavedLocationBinding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationAdapter.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.outdoor.ui.adapters.LocationView$TYPE[] r0 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.outdoor.ui.adapters.LocationView$TYPE r1 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.ASSIGNED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.outdoor.ui.adapters.LocationView$TYPE r1 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.SAVED_LOCATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.outdoor.ui.adapters.LocationView$TYPE r1 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.ADD_LOCATION     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.outdoor.ui.adapters.LocationView$TYPE r1 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.CURRENT_LOCATION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.outdoor.ui.adapters.LocationView$TYPE r1 = com.blueair.outdoor.ui.adapters.LocationView.TYPE.NO_DATA     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.adapters.LocationView.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$5(View view) {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "ASSIGNED", "SAVED_LOCATION", "ADD_LOCATION", "CURRENT_LOCATION", "NO_DATA", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationAdapter.kt */
    public enum TYPE {
        ASSIGNED,
        SAVED_LOCATION,
        ADD_LOCATION,
        CURRENT_LOCATION,
        NO_DATA;

        public static EnumEntries<TYPE> getEntries() {
            return $ENTRIES;
        }

        static {
            TYPE[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        HolderSavedLocationBinding inflate = HolderSavedLocationBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        HolderSavedLocationBinding inflate = HolderSavedLocationBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        HolderSavedLocationBinding inflate = HolderSavedLocationBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        HolderSavedLocationBinding inflate = HolderSavedLocationBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    public final HolderSavedLocationBinding getBinding() {
        return this.binding;
    }

    private final void configureAs(TYPE type, boolean z) {
        FrameLayout frameLayout = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "progressBar");
        ViewExtensionsKt.hide(frameLayout);
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            ConstraintLayout constraintLayout = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "noDataContainer");
            ViewExtensionsKt.hide(constraintLayout);
            ConstraintLayout constraintLayout2 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "addressContainer");
            ViewExtensionsKt.show$default(constraintLayout2, false, 1, (Object) null);
            AllQualityStatusView allQualityStatusView = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(allQualityStatusView, "qualityContainers");
            ViewExtensionsKt.show$default(allQualityStatusView, false, 1, (Object) null);
            ConstraintLayout constraintLayout3 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout3, "assignContainer");
            ViewExtensionsKt.show$default(constraintLayout3, false, 1, (Object) null);
            ConstraintLayout constraintLayout4 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout4, "saveContainer");
            ViewExtensionsKt.hide(constraintLayout4);
        } else if (i == 2) {
            ConstraintLayout constraintLayout5 = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout5, "noDataContainer");
            ViewExtensionsKt.hide(constraintLayout5);
            ConstraintLayout constraintLayout6 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout6, "addressContainer");
            ViewExtensionsKt.show$default(constraintLayout6, false, 1, (Object) null);
            AllQualityStatusView allQualityStatusView2 = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(allQualityStatusView2, "qualityContainers");
            ViewExtensionsKt.show$default(allQualityStatusView2, false, 1, (Object) null);
            ConstraintLayout constraintLayout7 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout7, "assignContainer");
            ViewExtensionsKt.show(constraintLayout7, !z);
            ConstraintLayout constraintLayout8 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout8, "saveContainer");
            ViewExtensionsKt.show(constraintLayout8, z);
        } else if (i == 3) {
            ConstraintLayout constraintLayout9 = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout9, "noDataContainer");
            ViewExtensionsKt.hide(constraintLayout9);
            ConstraintLayout constraintLayout10 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout10, "addressContainer");
            ViewExtensionsKt.show$default(constraintLayout10, false, 1, (Object) null);
            AllQualityStatusView allQualityStatusView3 = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(allQualityStatusView3, "qualityContainers");
            ViewExtensionsKt.show$default(allQualityStatusView3, false, 1, (Object) null);
            ConstraintLayout constraintLayout11 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout11, "assignContainer");
            ViewExtensionsKt.hide(constraintLayout11);
            ConstraintLayout constraintLayout12 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout12, "saveContainer");
            ViewExtensionsKt.show$default(constraintLayout12, false, 1, (Object) null);
        } else if (i == 4) {
            ConstraintLayout constraintLayout13 = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout13, "noDataContainer");
            ViewExtensionsKt.hide(constraintLayout13);
            ConstraintLayout constraintLayout14 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout14, "addressContainer");
            ViewExtensionsKt.show$default(constraintLayout14, false, 1, (Object) null);
            AllQualityStatusView allQualityStatusView4 = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(allQualityStatusView4, "qualityContainers");
            ViewExtensionsKt.show$default(allQualityStatusView4, false, 1, (Object) null);
            ConstraintLayout constraintLayout15 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout15, "assignContainer");
            ViewExtensionsKt.hide(constraintLayout15);
            ConstraintLayout constraintLayout16 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout16, "saveContainer");
            ViewExtensionsKt.hide(constraintLayout16);
        } else if (i == 5) {
            ConstraintLayout constraintLayout17 = this.binding.noDataContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout17, "noDataContainer");
            ViewExtensionsKt.show$default(constraintLayout17, false, 1, (Object) null);
            ConstraintLayout constraintLayout18 = this.binding.addressContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout18, "addressContainer");
            ViewExtensionsKt.hide(constraintLayout18);
            AllQualityStatusView allQualityStatusView5 = this.binding.qualityContainers;
            Intrinsics.checkNotNullExpressionValue(allQualityStatusView5, "qualityContainers");
            ViewExtensionsKt.hide(allQualityStatusView5);
            ConstraintLayout constraintLayout19 = this.binding.assignContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout19, "assignContainer");
            ViewExtensionsKt.hide(constraintLayout19);
            ConstraintLayout constraintLayout20 = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout20, "saveContainer");
            ViewExtensionsKt.hide(constraintLayout20);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.binding.saveBtn.setText(z ? R.string.outdoor_assign_popup_title : R.string.button_save);
    }

    public static /* synthetic */ void bind$default(LocationView locationView, LocationItem locationItem, String str, TYPE type, boolean z, boolean z2, Function2 function2, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function2 = null;
        }
        if ((i & 64) != 0) {
            function1 = null;
        }
        if ((i & 128) != 0) {
            function3 = null;
        }
        locationView.bind(locationItem, str, type, z, z2, function2, function1, function3);
    }

    public final void bind(LocationItem locationItem, String str, TYPE type, boolean z, boolean z2, Function2<? super TrackedLocation, ? super AqiData, Unit> function2, Function1<? super TrackedLocation, Unit> function1, Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function3) {
        TYPE type2 = type;
        Intrinsics.checkNotNullParameter(str, "mapType");
        Intrinsics.checkNotNullParameter(type2, "type");
        boolean z3 = z;
        configureAs(type2, z3);
        if (!SetsKt.setOf(TYPE.ADD_LOCATION, TYPE.SAVED_LOCATION).contains(type2) || locationItem == null) {
            this.binding.primaryText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            this.binding.primaryText.setOnClickListener(new LocationView$$ExternalSyntheticLambda1());
        } else {
            this.binding.primaryText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_edit2, 0);
            boolean z4 = z3;
            this.binding.primaryText.setOnClickListener(new LocationView$$ExternalSyntheticLambda0(this, locationItem, type2, str, z2, z4, function2, function1, function3));
        }
        Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function32 = function3;
        Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function33 = function32;
        this.binding.saveBtn.setOnClickListener(new LocationView$$ExternalSyntheticLambda2(locationItem, z, function32, function2, this));
        this.binding.delete.setOnClickListener(new LocationView$$ExternalSyntheticLambda3(locationItem, function1));
        this.binding.assignProduct.setOnClickListener(new LocationView$$ExternalSyntheticLambda4(locationItem, function33));
        this.binding.assignedProducts.setOnClickListener(new LocationView$$ExternalSyntheticLambda5(locationItem, function33));
        if (locationItem != null) {
            bind(locationItem.getLocation(), str);
            OutdoorPollutants pollutants = locationItem.getAqiData().getPollutants();
            if (pollutants != null) {
                bind(pollutants);
            }
            bind((List<? extends Device>) locationItem.getAssignedDevices());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 3) {
            if (i == 5) {
                FrameLayout frameLayout = this.binding.progressBar;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "progressBar");
                ViewExtensionsKt.hide(frameLayout);
            }
        } else if (locationItem == null) {
            FrameLayout frameLayout2 = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "progressBar");
            ViewExtensionsKt.show$default(frameLayout2, false, 1, (Object) null);
        } else {
            FrameLayout frameLayout3 = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "progressBar");
            ViewExtensionsKt.hide(frameLayout3);
            ConstraintLayout constraintLayout = this.binding.saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "saveContainer");
            ViewExtensionsKt.show(constraintLayout, z2);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$4(LocationView locationView, LocationItem locationItem, TYPE type, String str, boolean z, boolean z2, Function2 function2, Function1 function1, Function3 function3, View view) {
        Context context = locationView.binding.primaryText.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<LocationEditNameDialogFragment> cls = LocationEditNameDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("LocationEditNameDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("LocationEditNameDialogFragment") instanceof LocationEditNameDialogFragment) && !supportFragmentManager.isStateSaved()) {
                LocationEditNameDialogFragment.Companion companion = LocationEditNameDialogFragment.Companion;
                String locationName = locationItem.getLocation().getLocationName();
                if (locationName == null) {
                    locationName = "";
                }
                LocationEditNameDialogFragment newInstance = companion.newInstance(locationName);
                newInstance.setOnSaveListener(new LocationView$$ExternalSyntheticLambda6(type, locationView, locationItem, str, z, z2, function2, function1, function3));
                newInstance.show(supportFragmentManager, "LocationEditNameDialogFragment");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit bind$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(TYPE type, LocationView locationView, LocationItem locationItem, String str, boolean z, boolean z2, Function2 function2, Function1 function1, Function3 function3, String str2) {
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "text");
        TYPE type2 = type;
        if (type2 == TYPE.ADD_LOCATION) {
            LocationView locationView2 = locationView;
            TYPE type3 = type2;
            locationView2.bind(LocationItem.copy$default(locationItem, TrackedLocation.copy$default(locationItem.getLocation(), (String) null, 0.0d, 0.0d, str3, (String) null, (String) null, (String) null, (String) null, (String) null, TypedValues.PositionType.TYPE_PERCENT_WIDTH, (Object) null), (AqiData) null, (List) null, 6, (Object) null), str, type3, z, z2, function2, function1, function3);
        } else {
            Function2 function22 = function2;
            if (function22 != null) {
                function22.invoke(TrackedLocation.copy$default(locationItem.getLocation(), (String) null, 0.0d, 0.0d, str2, (String) null, (String) null, (String) null, (String) null, (String) null, TypedValues.PositionType.TYPE_PERCENT_WIDTH, (Object) null), locationItem.getAqiData());
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$7(LocationItem locationItem, boolean z, Function3 function3, Function2 function2, LocationView locationView, View view) {
        if (locationItem != null) {
            if (z) {
                if (function3 != null) {
                    FrameLayout frameLayout = locationView.binding.progressBar;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "progressBar");
                    ViewExtensionsKt.show$default(frameLayout, false, 1, (Object) null);
                    function3.invoke(locationItem.getLocation(), CollectionsKt.emptyList(), locationItem.getAqiData());
                }
            } else if (function2 != null) {
                function2.invoke(locationItem.getLocation(), locationItem.getAqiData());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$9(LocationItem locationItem, Function1 function1, View view) {
        TrackedLocation location;
        if (locationItem != null && (location = locationItem.getLocation()) != null && function1 != null) {
            function1.invoke(location);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$11(LocationItem locationItem, Function3 function3, View view) {
        TrackedLocation location;
        if (locationItem != null && (location = locationItem.getLocation()) != null && function3 != null) {
            function3.invoke(location, locationItem.getAssignedDevices(), null);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$13(LocationItem locationItem, Function3 function3, View view) {
        TrackedLocation location;
        if (locationItem != null && (location = locationItem.getLocation()) != null && function3 != null) {
            function3.invoke(location, locationItem.getAssignedDevices(), null);
        }
    }

    private final void bind(TrackedLocation trackedLocation, String str) {
        ConstraintLayout constraintLayout = this.binding.addressContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "addressContainer");
        ViewExtensionsKt.show$default(constraintLayout, false, 1, (Object) null);
        this.binding.primaryText.setText(trackedLocation.getLocationName());
        TextView textView = this.binding.secondaryText;
        String cityName = trackedLocation.getCityName();
        textView.setText(cityName != null ? cityName : trackedLocation.getCountryName());
    }

    private final void bind(OutdoorPollutants outdoorPollutants) {
        Double concentration;
        this.binding.qualityContainers.bind(outdoorPollutants);
        AllQualityStatusView allQualityStatusView = this.binding.qualityContainers;
        Intrinsics.checkNotNullExpressionValue(allQualityStatusView, "qualityContainers");
        ViewExtensionsKt.show$default(allQualityStatusView, false, 1, (Object) null);
        Pollutant aqi = outdoorPollutants.getAqi();
        if (aqi != null && (concentration = aqi.getConcentration()) != null) {
            double doubleValue = concentration.doubleValue();
            this.binding.aqiValue.setText(getResources().getString(R.string.saved_location_aqi, new Object[]{Integer.valueOf((int) doubleValue)}));
            int pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition((float) doubleValue, PollutantType.AQI.INSTANCE);
            if (pollutantRangePosition < 0) {
                Timber.Forest forest = Timber.Forest;
                forest.w("bind: rangePos " + pollutantRangePosition + " for value " + doubleValue + " is not found", new Object[0]);
                pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
            }
            int color = getResources().getColor(OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(pollutantRangePosition).intValue(), (Resources.Theme) null);
            this.binding.aqiSeverity.setText(getResources().getStringArray(R.array.severity_strings)[pollutantRangePosition]);
            this.binding.aqiIcon.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }

    private final void bind(List<? extends Device> list) {
        String str;
        if (list.isEmpty()) {
            TextView textView = this.binding.assignProduct;
            Intrinsics.checkNotNullExpressionValue(textView, "assignProduct");
            ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
            TextView textView2 = this.binding.assignedProducts;
            Intrinsics.checkNotNullExpressionValue(textView2, "assignedProducts");
            ViewExtensionsKt.hide(textView2);
            return;
        }
        TextView textView3 = this.binding.assignProduct;
        Intrinsics.checkNotNullExpressionValue(textView3, "assignProduct");
        ViewExtensionsKt.hide(textView3);
        TextView textView4 = this.binding.assignedProducts;
        Intrinsics.checkNotNullExpressionValue(textView4, "assignedProducts");
        ViewExtensionsKt.show$default(textView4, false, 1, (Object) null);
        TextView textView5 = this.binding.assignedProducts;
        if (list.size() <= 1) {
            str = getResources().getString(R.string.outdoor_assigned_product);
        } else {
            str = getResources().getString(R.string.outdoor_assigned_products, new Object[]{Integer.valueOf(list.size())});
        }
        textView5.setText(str);
    }
}
