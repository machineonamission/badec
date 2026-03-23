package com.blueair.adddevice.adapter;

import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/blueair/adddevice/adapter/DeviceModel;", "", "modelName", "", "modelImageRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getModelName", "()Ljava/lang/String;", "getModelImageRes", "()I", "CLASSIC", "SENSE", "AWARE", "ICP", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SelectDeviceModelAdapter.kt */
public enum DeviceModel {
    CLASSIC(DeviceType.Classic.INSTANCE.getName(), DeviceImage.CLASSIC.getDevice()),
    SENSE(DeviceType.Sense.INSTANCE.getName(), DeviceImage.SENSE.getDevice()),
    AWARE(DeviceType.Aware.INSTANCE.getName(), DeviceImage.AWARE.getDevice()),
    ICP("Cabin Air", DeviceImage.ICP.getDevice());
    
    private final int modelImageRes;
    private final String modelName;

    public static EnumEntries<DeviceModel> getEntries() {
        return $ENTRIES;
    }

    private DeviceModel(String str, int i) {
        this.modelName = str;
        this.modelImageRes = i;
    }

    public final int getModelImageRes() {
        return this.modelImageRes;
    }

    public final String getModelName() {
        return this.modelName;
    }

    static {
        DeviceModel[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
