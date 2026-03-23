package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOfflineHolder.kt */
final /* synthetic */ class DeviceOfflineHolder$Companion$newInstance$inflate$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HolderDeviceHOfflineBinding> {
    public static final DeviceOfflineHolder$Companion$newInstance$inflate$1 INSTANCE = new DeviceOfflineHolder$Companion$newInstance$inflate$1();

    DeviceOfflineHolder$Companion$newInstance$inflate$1() {
        super(3, HolderDeviceHOfflineBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/blueair/devicedetails/databinding/HolderDeviceHOfflineBinding;", 0);
    }

    public final HolderDeviceHOfflineBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "p0");
        return HolderDeviceHOfflineBinding.inflate(layoutInflater, viewGroup, z);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }
}
