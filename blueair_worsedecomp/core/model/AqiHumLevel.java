package com.blueair.core.model;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0017"}, d2 = {"Lcom/blueair/core/model/AqiHumLevel;", "", "level", "", "minValue", "", "maxValue", "<init>", "(Ljava/lang/String;IIFF)V", "getLevel", "()I", "getMinValue", "()F", "getMaxValue", "VERY_DRY", "DRY", "IDEAL", "MOSIT", "VERY_MOSIT", "isWorseThan", "", "other", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiHumLevel.kt */
public enum AqiHumLevel {
    VERY_DRY(0, 0.0f, 10.0f),
    DRY(1, 11.0f, 29.0f),
    IDEAL(2, 30.0f, 50.0f),
    MOSIT(3, 51.0f, 70.0f),
    VERY_MOSIT(4, 71.0f, 100.0f);
    
    public static final Companion Companion = null;
    private static final Map<AqiHumLevel, AqiHumLevel[]> worseRelations = null;
    private final int level;
    private final float maxValue;
    private final float minValue;

    public static EnumEntries<AqiHumLevel> getEntries() {
        return $ENTRIES;
    }

    private AqiHumLevel(int i, float f, float f2) {
        this.level = i;
        this.minValue = f;
        this.maxValue = f2;
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getMaxValue() {
        return this.maxValue;
    }

    public final float getMinValue() {
        return this.minValue;
    }

    static {
        AqiHumLevel aqiHumLevel;
        AqiHumLevel aqiHumLevel2;
        AqiHumLevel aqiHumLevel3;
        AqiHumLevel aqiHumLevel4;
        AqiHumLevel aqiHumLevel5;
        AqiHumLevel[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
        worseRelations = MapsKt.mapOf(TuplesKt.to(aqiHumLevel5, new AqiHumLevel[]{aqiHumLevel2, aqiHumLevel}), TuplesKt.to(aqiHumLevel4, new AqiHumLevel[]{aqiHumLevel2, aqiHumLevel, aqiHumLevel5}), TuplesKt.to(aqiHumLevel2, new AqiHumLevel[]{aqiHumLevel4, aqiHumLevel, aqiHumLevel5}), TuplesKt.to(aqiHumLevel, new AqiHumLevel[]{aqiHumLevel4, aqiHumLevel5}), TuplesKt.to(aqiHumLevel3, new AqiHumLevel[]{aqiHumLevel4, aqiHumLevel5, aqiHumLevel2, aqiHumLevel}));
    }

    public final boolean isWorseThan(AqiHumLevel aqiHumLevel) {
        Intrinsics.checkNotNullParameter(aqiHumLevel, "other");
        AqiHumLevel[] aqiHumLevelArr = worseRelations.get(aqiHumLevel);
        return aqiHumLevelArr != null && ArraysKt.contains((T[]) aqiHumLevelArr, this);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AqiHumLevel$Companion;", "", "<init>", "()V", "worseRelations", "", "Lcom/blueair/core/model/AqiHumLevel;", "", "fromHumValue", "hum", "", "fromLevel", "level", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AqiHumLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AqiHumLevel fromHumValue(float f) {
            for (AqiHumLevel aqiHumLevel : AqiHumLevel.getEntries()) {
                float minValue = aqiHumLevel.getMinValue();
                if (f <= aqiHumLevel.getMaxValue() && minValue <= f) {
                    return aqiHumLevel;
                }
            }
            return AqiHumLevel.IDEAL;
        }

        public final AqiHumLevel fromLevel(int i) {
            Object obj;
            Iterator it = AqiHumLevel.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((AqiHumLevel) obj).getLevel() == i) {
                    break;
                }
            }
            AqiHumLevel aqiHumLevel = (AqiHumLevel) obj;
            return aqiHumLevel == null ? AqiHumLevel.IDEAL : aqiHumLevel;
        }
    }
}
