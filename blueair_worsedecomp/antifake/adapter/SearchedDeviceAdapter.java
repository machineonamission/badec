package com.blueair.antifake.adapter;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.HolderSearchedDeviceBinding;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.MacAddressInfoDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0014\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0014\u0010!\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\"0\u001fJ\b\u0010#\u001a\u00020\u0011H\u0002R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/antifake/adapter/SearchedDeviceHolder;", "<init>", "()V", "acceptedSkus", "", "", "getAcceptedSkus", "()Ljava/util/Set;", "setAcceptedSkus", "(Ljava/util/Set;)V", "deviceList", "", "Lcom/blueair/antifake/adapter/SearchedDevice;", "onDeviceSelectedListener", "Lkotlin/Function1;", "", "setOnDeviceSelectedListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateOnboardedDevices", "devices", "", "Lcom/blueair/core/model/Device;", "updateBluetoothDevices", "Lcom/blueair/core/model/BluetoothDevice;", "sortList", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchedDeviceAdapter.kt */
public final class SearchedDeviceAdapter extends RecyclerView.Adapter<SearchedDeviceHolder> {
    private Set<String> acceptedSkus = SetsKt.emptySet();
    private final List<SearchedDevice> deviceList = new ArrayList();
    private Function1<? super SearchedDevice, Unit> onDeviceSelectedListener;

    public final Set<String> getAcceptedSkus() {
        return this.acceptedSkus;
    }

    public final void setAcceptedSkus(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.acceptedSkus = set;
    }

    public final void setOnDeviceSelectedListener(Function1<? super SearchedDevice, Unit> function1) {
        this.onDeviceSelectedListener = function1;
    }

    public SearchedDeviceHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HolderSearchedDeviceBinding inflate = HolderSearchedDeviceBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SearchedDeviceHolder(inflate);
    }

    private static final int onBindViewHolder$getColor(SearchedDeviceHolder searchedDeviceHolder, int i) {
        return searchedDeviceHolder.itemView.getContext().getColor(i);
    }

    public void onBindViewHolder(SearchedDeviceHolder searchedDeviceHolder, int i) {
        SearchedDeviceHolder searchedDeviceHolder2 = searchedDeviceHolder;
        Intrinsics.checkNotNullParameter(searchedDeviceHolder2, "holder");
        SearchedDevice searchedDevice = this.deviceList.get(i);
        if (searchedDevice.isOnboarded()) {
            Device device = searchedDevice.getDevice();
            Intrinsics.checkNotNull(device);
            HasSKU hasSKU = (HasSKU) device;
            HolderSearchedDeviceBinding binding = searchedDeviceHolder2.getBinding();
            TextView textView = binding.modelName;
            DeviceType.Companion companion = DeviceType.Companion;
            String sku = hasSKU.getSku();
            Intrinsics.checkNotNull(sku);
            textView.setText(companion.familyNameFromSku(sku));
            binding.deviceName.setText(hasSKU.getName());
            AppCompatImageView appCompatImageView = binding.deviceImg;
            Device device2 = hasSKU;
            DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(device2);
            appCompatImageView.setImageResource(deviceImage != null ? deviceImage.getDevice() : 0);
            if (searchedDevice.isOnline()) {
                if (hasSKU instanceof HasFanSpeed) {
                    FilterLifeTime filterLifeTime = DeviceKt.getFilterLifeTime(device2);
                    int filterLife = filterLifeTime.getFilterLife();
                    int filterStatusColor = DeviceConfigProvider.INSTANCE.getFilterStatusColor(filterLifeTime);
                    TextView textView2 = binding.filterLeftValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(filterLife);
                    sb.append('%');
                    textView2.setText(sb.toString());
                    binding.filterLeftValue.setTextColor(filterStatusColor);
                    TextView textView3 = binding.filterLeftLabel;
                    Intrinsics.checkNotNullExpressionValue(textView3, "filterLeftLabel");
                    ViewExtensionsKt.show$default(textView3, false, 1, (Object) null);
                    TextView textView4 = binding.filterLeftValue;
                    Intrinsics.checkNotNullExpressionValue(textView4, "filterLeftValue");
                    ViewExtensionsKt.show$default(textView4, false, 1, (Object) null);
                } else {
                    TextView textView5 = binding.filterLeftLabel;
                    Intrinsics.checkNotNullExpressionValue(textView5, "filterLeftLabel");
                    ViewExtensionsKt.hide(textView5);
                    TextView textView6 = binding.filterLeftValue;
                    Intrinsics.checkNotNullExpressionValue(textView6, "filterLeftValue");
                    ViewExtensionsKt.hide(textView6);
                }
                if (hasSKU instanceof HasWick) {
                    int wickLifeLeft = ((HasWick) hasSKU).getWickLifeLeft();
                    TextView textView7 = binding.wickLeftValue;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(wickLifeLeft);
                    sb2.append('%');
                    textView7.setText(sb2.toString());
                    binding.wickLeftValue.setTextColor(DeviceConfigProvider.INSTANCE.getWickStatusColor(wickLifeLeft));
                    TextView textView8 = binding.wickLeftLabel;
                    Intrinsics.checkNotNullExpressionValue(textView8, "wickLeftLabel");
                    ViewExtensionsKt.show$default(textView8, false, 1, (Object) null);
                    TextView textView9 = binding.wickLeftValue;
                    Intrinsics.checkNotNullExpressionValue(textView9, "wickLeftValue");
                    ViewExtensionsKt.show$default(textView9, false, 1, (Object) null);
                } else {
                    TextView textView10 = binding.wickLeftLabel;
                    Intrinsics.checkNotNullExpressionValue(textView10, "wickLeftLabel");
                    ViewExtensionsKt.hide(textView10);
                    TextView textView11 = binding.wickLeftValue;
                    Intrinsics.checkNotNullExpressionValue(textView11, "wickLeftValue");
                    ViewExtensionsKt.hide(textView11);
                }
                TextView textView12 = binding.bluetoothStatus;
                Intrinsics.checkNotNullExpressionValue(textView12, "bluetoothStatus");
                ViewExtensionsKt.hide(textView12);
                TextView textView13 = binding.offlineLabel;
                Intrinsics.checkNotNullExpressionValue(textView13, "offlineLabel");
                ViewExtensionsKt.hide(textView13);
                TextView textView14 = binding.macLabel;
                Intrinsics.checkNotNullExpressionValue(textView14, "macLabel");
                ViewExtensionsKt.hide(textView14);
                TextView textView15 = binding.macNumber;
                Intrinsics.checkNotNullExpressionValue(textView15, "macNumber");
                ViewExtensionsKt.hide(textView15);
            } else if (searchedDevice.getBluetoothAvailable()) {
                TextView textView16 = binding.filterLeftLabel;
                Intrinsics.checkNotNullExpressionValue(textView16, "filterLeftLabel");
                ViewExtensionsKt.hide(textView16);
                TextView textView17 = binding.filterLeftValue;
                Intrinsics.checkNotNullExpressionValue(textView17, "filterLeftValue");
                ViewExtensionsKt.hide(textView17);
                TextView textView18 = binding.wickLeftLabel;
                Intrinsics.checkNotNullExpressionValue(textView18, "wickLeftLabel");
                ViewExtensionsKt.hide(textView18);
                TextView textView19 = binding.wickLeftValue;
                Intrinsics.checkNotNullExpressionValue(textView19, "wickLeftValue");
                ViewExtensionsKt.hide(textView19);
                if (searchedDevice.isOnboarded()) {
                    TextView textView20 = binding.offlineLabel;
                    Intrinsics.checkNotNullExpressionValue(textView20, "offlineLabel");
                    ViewExtensionsKt.show$default(textView20, false, 1, (Object) null);
                    TextView textView21 = binding.macLabel;
                    Intrinsics.checkNotNullExpressionValue(textView21, "macLabel");
                    ViewExtensionsKt.hide(textView21);
                    TextView textView22 = binding.macNumber;
                    Intrinsics.checkNotNullExpressionValue(textView22, "macNumber");
                    ViewExtensionsKt.hide(textView22);
                } else {
                    TextView textView23 = binding.offlineLabel;
                    Intrinsics.checkNotNullExpressionValue(textView23, "offlineLabel");
                    ViewExtensionsKt.hide(textView23);
                    TextView textView24 = binding.macLabel;
                    Intrinsics.checkNotNullExpressionValue(textView24, "macLabel");
                    ViewExtensionsKt.show$default(textView24, false, 1, (Object) null);
                    TextView textView25 = binding.macNumber;
                    BluetoothDevice bluetoothDevice = searchedDevice.getBluetoothDevice();
                    textView25.setText(bluetoothDevice != null ? bluetoothDevice.getWifiMac() : null);
                    TextView textView26 = binding.macNumber;
                    Intrinsics.checkNotNullExpressionValue(textView26, "macNumber");
                    ViewExtensionsKt.show$default(textView26, false, 1, (Object) null);
                }
                binding.bluetoothStatus.setText(R.string.available);
                TextViewCompat.setCompoundDrawableTintList(binding.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(searchedDeviceHolder2, R.color.colorPrimary)));
                TextView textView27 = binding.bluetoothStatus;
                Intrinsics.checkNotNullExpressionValue(textView27, "bluetoothStatus");
                ViewExtensionsKt.show$default(textView27, false, 1, (Object) null);
            } else {
                TextView textView28 = binding.filterLeftLabel;
                Intrinsics.checkNotNullExpressionValue(textView28, "filterLeftLabel");
                ViewExtensionsKt.hide(textView28);
                TextView textView29 = binding.filterLeftValue;
                Intrinsics.checkNotNullExpressionValue(textView29, "filterLeftValue");
                ViewExtensionsKt.hide(textView29);
                TextView textView30 = binding.wickLeftLabel;
                Intrinsics.checkNotNullExpressionValue(textView30, "wickLeftLabel");
                ViewExtensionsKt.hide(textView30);
                TextView textView31 = binding.wickLeftValue;
                Intrinsics.checkNotNullExpressionValue(textView31, "wickLeftValue");
                ViewExtensionsKt.hide(textView31);
                TextView textView32 = binding.offlineLabel;
                Intrinsics.checkNotNullExpressionValue(textView32, "offlineLabel");
                ViewExtensionsKt.show$default(textView32, false, 1, (Object) null);
                TextView textView33 = binding.macLabel;
                Intrinsics.checkNotNullExpressionValue(textView33, "macLabel");
                ViewExtensionsKt.hide(textView33);
                TextView textView34 = binding.macNumber;
                Intrinsics.checkNotNullExpressionValue(textView34, "macNumber");
                ViewExtensionsKt.hide(textView34);
                binding.bluetoothStatus.setText(R.string.unavailable);
                TextViewCompat.setCompoundDrawableTintList(binding.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(searchedDeviceHolder2, R.color.dark_grey)));
                TextView textView35 = binding.bluetoothStatus;
                Intrinsics.checkNotNullExpressionValue(textView35, "bluetoothStatus");
                ViewExtensionsKt.show$default(textView35, false, 1, (Object) null);
            }
        } else if (searchedDevice.getBluetoothAvailable()) {
            BluetoothDevice bluetoothDevice2 = searchedDevice.getBluetoothDevice();
            Intrinsics.checkNotNull(bluetoothDevice2);
            HolderSearchedDeviceBinding binding2 = searchedDeviceHolder2.getBinding();
            binding2.modelName.setText(bluetoothDevice2.getFamilyName());
            binding2.deviceName.setText(bluetoothDevice2.getModelName());
            AppCompatImageView appCompatImageView2 = binding2.deviceImg;
            DeviceImage deviceImage2 = DeviceConfigProvider.INSTANCE.getDeviceImage(bluetoothDevice2);
            appCompatImageView2.setImageResource(deviceImage2 != null ? deviceImage2.getDevice() : 0);
            TextView textView36 = binding2.filterLeftLabel;
            Intrinsics.checkNotNullExpressionValue(textView36, "filterLeftLabel");
            ViewExtensionsKt.hide(textView36);
            TextView textView37 = binding2.filterLeftValue;
            Intrinsics.checkNotNullExpressionValue(textView37, "filterLeftValue");
            ViewExtensionsKt.hide(textView37);
            TextView textView38 = binding2.wickLeftLabel;
            Intrinsics.checkNotNullExpressionValue(textView38, "wickLeftLabel");
            ViewExtensionsKt.hide(textView38);
            TextView textView39 = binding2.wickLeftValue;
            Intrinsics.checkNotNullExpressionValue(textView39, "wickLeftValue");
            ViewExtensionsKt.hide(textView39);
            TextView textView40 = binding2.offlineLabel;
            Intrinsics.checkNotNullExpressionValue(textView40, "offlineLabel");
            ViewExtensionsKt.hide(textView40);
            TextView textView41 = binding2.macLabel;
            Intrinsics.checkNotNullExpressionValue(textView41, "macLabel");
            ViewExtensionsKt.show$default(textView41, false, 1, (Object) null);
            binding2.macNumber.setText(bluetoothDevice2.getWifiMac());
            TextView textView42 = binding2.macNumber;
            Intrinsics.checkNotNullExpressionValue(textView42, "macNumber");
            ViewExtensionsKt.show$default(textView42, false, 1, (Object) null);
            binding2.bluetoothStatus.setText(R.string.available);
            TextViewCompat.setCompoundDrawableTintList(binding2.bluetoothStatus, ColorStateList.valueOf(onBindViewHolder$getColor(searchedDeviceHolder2, R.color.colorPrimary)));
            TextView textView43 = binding2.bluetoothStatus;
            Intrinsics.checkNotNullExpressionValue(textView43, "bluetoothStatus");
            ViewExtensionsKt.show$default(textView43, false, 1, (Object) null);
        }
        searchedDeviceHolder2.itemView.setOnClickListener(new SearchedDeviceAdapter$$ExternalSyntheticLambda0(this, searchedDevice));
        searchedDeviceHolder2.getBinding().macLabel.setOnClickListener(new SearchedDeviceAdapter$$ExternalSyntheticLambda1(searchedDevice));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(SearchedDeviceAdapter searchedDeviceAdapter, SearchedDevice searchedDevice, View view) {
        Function1<? super SearchedDevice, Unit> function1 = searchedDeviceAdapter.onDeviceSelectedListener;
        if (function1 != null) {
            function1.invoke(searchedDevice);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(SearchedDevice searchedDevice, View view) {
        DeviceType deviceType;
        Intrinsics.checkNotNull(view);
        FragmentManager childFragmentManager = ViewKt.findFragment(view).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<MacAddressInfoDialogFragment> cls = MacAddressInfoDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("MacAddressInfoDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("MacAddressInfoDialogFragment") instanceof MacAddressInfoDialogFragment) && !childFragmentManager.isStateSaved()) {
            MacAddressInfoDialogFragment.Companion companion = MacAddressInfoDialogFragment.Companion;
            Device device = searchedDevice.getDevice();
            if (device == null || (deviceType = device.getType()) == null) {
                BluetoothDevice bluetoothDevice = searchedDevice.getBluetoothDevice();
                deviceType = bluetoothDevice != null ? bluetoothDevice.getDeviceType() : null;
            }
            companion.newInstance(deviceType).show(childFragmentManager, "MacAddressInfoDialogFragment");
        }
    }

    public int getItemCount() {
        return this.deviceList.size();
    }

    public final void updateOnboardedDevices(List<? extends Device> list) {
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter(list, "devices");
        boolean z = false;
        for (Device device : list) {
            if ((device instanceof HasSKU) && CollectionsKt.contains(this.acceptedSkus, ((HasSKU) device).getSku())) {
                Iterator it = this.deviceList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((SearchedDevice) obj).getWifiMac(), (Object) device.getMac())) {
                        break;
                    }
                }
                SearchedDevice searchedDevice = (SearchedDevice) obj;
                if (searchedDevice != null && searchedDevice.getDevice() != null && searchedDevice.getDevice().getConnectivityStatusIndex() == device.getConnectivityStatusIndex() && Intrinsics.areEqual((Object) searchedDevice.getDevice().getName(), (Object) device.getName())) {
                    Device device2 = searchedDevice.getDevice();
                    HasFanSpeed hasFanSpeed = device2 instanceof HasFanSpeed ? (HasFanSpeed) device2 : null;
                    Integer filterLife = hasFanSpeed != null ? hasFanSpeed.getFilterLife() : null;
                    HasFanSpeed hasFanSpeed2 = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
                    if (Intrinsics.areEqual((Object) filterLife, (Object) hasFanSpeed2 != null ? hasFanSpeed2.getFilterLife() : null)) {
                        Device device3 = searchedDevice.getDevice();
                        HasWick hasWick = device3 instanceof HasWick ? (HasWick) device3 : null;
                        Integer valueOf = hasWick != null ? Integer.valueOf(hasWick.getWickUsage()) : null;
                        HasWick hasWick2 = device instanceof HasWick ? (HasWick) device : null;
                        if (Intrinsics.areEqual((Object) valueOf, (Object) hasWick2 != null ? Integer.valueOf(hasWick2.getWickUsage()) : null)) {
                        }
                    }
                }
                if (searchedDevice == null) {
                    i = -1;
                } else {
                    i = this.deviceList.indexOf(searchedDevice);
                }
                if (i >= 0) {
                    List<SearchedDevice> list2 = this.deviceList;
                    Intrinsics.checkNotNull(searchedDevice);
                    list2.set(i, SearchedDevice.copy$default(searchedDevice, device, (BluetoothDevice) null, 2, (Object) null));
                } else {
                    this.deviceList.add(new SearchedDevice(device, (BluetoothDevice) null));
                }
                z = true;
            }
        }
        if (z) {
            sortList();
            notifyDataSetChanged();
        }
    }

    public final void updateBluetoothDevices(List<BluetoothDevice> list) {
        Object obj;
        int i;
        BluetoothDevice bluetoothDevice;
        Intrinsics.checkNotNullParameter(list, "devices");
        Iterable<BluetoothDevice> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (BluetoothDevice wifiMac : iterable) {
            arrayList.add(wifiMac.getWifiMac());
        }
        Set set = CollectionsKt.toSet((List) arrayList);
        Collection arrayList2 = new ArrayList();
        Iterator it = this.deviceList.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            SearchedDevice searchedDevice = (SearchedDevice) it.next();
            if (searchedDevice.getBluetoothAvailable() && (bluetoothDevice = searchedDevice.getBluetoothDevice()) != null) {
                str = bluetoothDevice.getWifiMac();
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        Iterator it2 = ((List) arrayList2).iterator();
        boolean z = false;
        while (true) {
            int i2 = -1;
            if (!it2.hasNext()) {
                break;
            }
            String str2 = (String) it2.next();
            if (!set.contains(str2)) {
                Iterator<SearchedDevice> it3 = this.deviceList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    String wifiMac2 = it3.next().getWifiMac();
                    String lowerCase = str2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (Intrinsics.areEqual((Object) wifiMac2, (Object) lowerCase)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 >= 0) {
                    SearchedDevice searchedDevice2 = this.deviceList.get(i2);
                    if (searchedDevice2.isOnboarded()) {
                        this.deviceList.set(i2, SearchedDevice.copy$default(searchedDevice2, (Device) null, (BluetoothDevice) null, 1, (Object) null));
                    } else {
                        this.deviceList.remove(i2);
                    }
                    z = true;
                }
            }
        }
        for (BluetoothDevice bluetoothDevice2 : iterable) {
            if (this.acceptedSkus.contains(bluetoothDevice2.getSku())) {
                Iterator it4 = this.deviceList.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it4.next();
                    String wifiMac3 = ((SearchedDevice) obj).getWifiMac();
                    String lowerCase2 = bluetoothDevice2.getWifiMac().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual((Object) wifiMac3, (Object) lowerCase2)) {
                        break;
                    }
                }
                SearchedDevice searchedDevice3 = (SearchedDevice) obj;
                if (searchedDevice3 == null || searchedDevice3.getBluetoothDevice() == null) {
                    if (searchedDevice3 == null) {
                        i = -1;
                    } else {
                        i = this.deviceList.indexOf(searchedDevice3);
                    }
                    if (i >= 0) {
                        List<SearchedDevice> list2 = this.deviceList;
                        Intrinsics.checkNotNull(searchedDevice3);
                        list2.set(i, SearchedDevice.copy$default(searchedDevice3, (Device) null, bluetoothDevice2, 1, (Object) null));
                    } else {
                        this.deviceList.add(new SearchedDevice((Device) null, bluetoothDevice2));
                    }
                    z = true;
                }
            }
        }
        if (z) {
            sortList();
            notifyDataSetChanged();
        }
    }

    private final void sortList() {
        List<SearchedDevice> list = this.deviceList;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new SearchedDeviceAdapter$sortList$$inlined$sortBy$1());
        }
    }
}
