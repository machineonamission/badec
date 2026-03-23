package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNChildLockHolder.kt */
final /* synthetic */ class DeviceNChildLockHolder$Companion$newInstance$inflate$2 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HolderDeviceHChildLockBinding> {
    public static final DeviceNChildLockHolder$Companion$newInstance$inflate$2 INSTANCE = new DeviceNChildLockHolder$Companion$newInstance$inflate$2();

    DeviceNChildLockHolder$Companion$newInstance$inflate$2() {
        super(3, HolderDeviceHChildLockBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/blueair/devicedetails/databinding/HolderDeviceHChildLockBinding;", 0);
    }

    public final HolderDeviceHChildLockBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "p0");
        return HolderDeviceHChildLockBinding.inflate(layoutInflater, viewGroup, z);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }
}
