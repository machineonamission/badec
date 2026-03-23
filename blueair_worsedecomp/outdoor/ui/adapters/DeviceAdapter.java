package com.blueair.outdoor.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.HasLocation;
import com.blueair.outdoor.databinding.HolderAssignDeviceBinding;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\rJ\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR6\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0013X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/DeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/outdoor/ui/adapters/DeviceViewHolder;", "<init>", "()V", "_selectionModified", "Landroidx/lifecycle/MutableLiveData;", "", "selectionModified", "Landroidx/lifecycle/LiveData;", "getSelectionModified", "()Landroidx/lifecycle/LiveData;", "value", "", "", "originalSelections", "getOriginalSelections", "()Ljava/util/Map;", "_selections", "", "selections", "getSelections", "devices", "", "Lcom/blueair/core/model/HasLocation;", "setData", "", "data", "checkSelectionModified", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAdapter.kt */
public final class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    private final MutableLiveData<Boolean> _selectionModified;
    private final Map<String, Boolean> _selections;
    private List<? extends HasLocation> devices;
    private Map<String, Boolean> originalSelections = MapsKt.emptyMap();
    private final LiveData<Boolean> selectionModified;
    private final Map<String, Boolean> selections;

    public DeviceAdapter() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._selectionModified = mutableLiveData;
        this.selectionModified = Transformations.distinctUntilChanged(mutableLiveData);
        Map<String, Boolean> linkedHashMap = new LinkedHashMap<>();
        this._selections = linkedHashMap;
        this.selections = linkedHashMap;
        this.devices = CollectionsKt.emptyList();
    }

    public final LiveData<Boolean> getSelectionModified() {
        return this.selectionModified;
    }

    public final Map<String, Boolean> getOriginalSelections() {
        return this.originalSelections;
    }

    public final Map<String, Boolean> getSelections() {
        return this.selections;
    }

    private final void checkSelectionModified() {
        MutableLiveData<Boolean> mutableLiveData = this._selectionModified;
        Map<String, Boolean> map = this._selections;
        boolean z = false;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, Boolean>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (!Intrinsics.areEqual(next.getValue(), (Object) this.originalSelections.get(next.getKey()))) {
                    z = true;
                    break;
                }
            }
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
    }

    public DeviceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceViewHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceViewHolder deviceViewHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceViewHolder, "holder");
        HasLocation hasLocation = (HasLocation) this.devices.get(i);
        HolderAssignDeviceBinding binding = deviceViewHolder.getBinding();
        binding.deviceName.setText(hasLocation.getName());
        CheckBox checkBox = binding.checkBox;
        Boolean bool = this._selections.get(hasLocation.getUid());
        checkBox.setChecked(bool != null ? bool.booleanValue() : false);
        binding.getRoot().setOnClickListener(new DeviceAdapter$$ExternalSyntheticLambda0(binding, this, hasLocation));
        binding.checkBox.setOnClickListener(new DeviceAdapter$$ExternalSyntheticLambda1(this, hasLocation, binding));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$2(HolderAssignDeviceBinding holderAssignDeviceBinding, DeviceAdapter deviceAdapter, HasLocation hasLocation, View view) {
        holderAssignDeviceBinding.checkBox.setChecked(!holderAssignDeviceBinding.checkBox.isChecked());
        deviceAdapter._selections.put(hasLocation.getUid(), Boolean.valueOf(holderAssignDeviceBinding.checkBox.isChecked()));
        deviceAdapter.checkSelectionModified();
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$3(DeviceAdapter deviceAdapter, HasLocation hasLocation, HolderAssignDeviceBinding holderAssignDeviceBinding, View view) {
        deviceAdapter._selections.put(hasLocation.getUid(), Boolean.valueOf(holderAssignDeviceBinding.checkBox.isChecked()));
        deviceAdapter.checkSelectionModified();
    }

    public int getItemCount() {
        return this.devices.size();
    }

    public final void setData(Map<HasLocation, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        Map<String, Boolean> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(((HasLocation) entry.getKey()).getUid(), entry.getValue());
        }
        this.originalSelections = linkedHashMap;
        this._selections.clear();
        this._selections.putAll(this.originalSelections);
        this.devices = CollectionsKt.toList(map.keySet());
        this._selectionModified.setValue(false);
        notifyDataSetChanged();
    }
}
