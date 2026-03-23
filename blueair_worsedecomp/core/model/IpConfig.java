package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.foobot.liblabclient.domain.Attribute;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001 B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/blueair/core/model/IpConfig;", "Landroid/os/Parcelable;", "map", "", "", "<init>", "(Ljava/util/Map;)V", "default", "(Ljava/lang/String;)V", "getMap", "()Ljava/util/Map;", "getDefault$annotations", "()V", "getDefault", "()Ljava/lang/String;", "getValue", "ip", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Adapter", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseJsonTypes.kt */
public final class IpConfig implements Parcelable {
    public static final Parcelable.Creator<IpConfig> CREATOR = new Creator();

    /* renamed from: default  reason: not valid java name */
    private final String f67default;
    private final Map<String, String> map;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BaseJsonTypes.kt */
    public static final class Creator implements Parcelable.Creator<IpConfig> {
        public final IpConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new IpConfig((Map<String, String>) linkedHashMap);
        }

        public final IpConfig[] newArray(int i) {
            return new IpConfig[i];
        }
    }

    public static /* synthetic */ IpConfig copy$default(IpConfig ipConfig, Map<String, String> map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map2 = ipConfig.map;
        }
        return ipConfig.copy(map2);
    }

    public static /* synthetic */ void getDefault$annotations() {
    }

    public final Map<String, String> component1() {
        return this.map;
    }

    public final IpConfig copy(Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map2, "map");
        return new IpConfig(map2);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IpConfig) && Intrinsics.areEqual((Object) this.map, (Object) ((IpConfig) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "IpConfig(map=" + this.map + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        Map<String, String> map2 = this.map;
        parcel.writeInt(map2.size());
        for (Map.Entry next : map2.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public IpConfig(Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map2, "map");
        this.map = map2;
        this.f67default = map2.get(Attribute.DEF_VAL_TYPE);
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IpConfig(String str) {
        this((Map<String, String>) MapsKt.mapOf(TuplesKt.to(Attribute.DEF_VAL_TYPE, str)));
        Intrinsics.checkNotNullParameter(str, Attribute.DEF_VAL_TYPE);
    }

    public final String getDefault() {
        return this.f67default;
    }

    public final String getValue(String str) {
        String str2;
        Map<String, String> map2 = this.map;
        if (str != null) {
            str2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        } else {
            str2 = null;
        }
        String str3 = map2.get(str2);
        return str3 == null ? this.f67default : str3;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0017Rb\u0010\u0005\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \b**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/IpConfig$Adapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/blueair/core/model/IpConfig;", "<init>", "()V", "adapter", "", "", "kotlin.jvm.PlatformType", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BaseJsonTypes.kt */
    public static final class Adapter extends JsonAdapter<IpConfig> {
        public static final Adapter INSTANCE = new Adapter();
        private static final JsonAdapter<Map<String, String>> adapter = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter((Type) Types.newParameterizedType(Map.class, String.class, String.class));

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: BaseJsonTypes.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.squareup.moshi.JsonReader$Token[] r0 = com.squareup.moshi.JsonReader.Token.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.IpConfig.Adapter.WhenMappings.<clinit>():void");
            }
        }

        private Adapter() {
        }

        @FromJson
        public IpConfig fromJson(JsonReader jsonReader) {
            Intrinsics.checkNotNullParameter(jsonReader, "reader");
            JsonReader.Token peek = jsonReader.peek();
            int i = peek == null ? -1 : WhenMappings.$EnumSwitchMapping$0[peek.ordinal()];
            if (i == 1) {
                Map fromJson = adapter.fromJson(jsonReader);
                if (fromJson == null) {
                    fromJson = MapsKt.emptyMap();
                }
                return new IpConfig((Map<String, String>) fromJson);
            } else if (i != 2) {
                return null;
            } else {
                String nextString = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "nextString(...)");
                return new IpConfig(nextString);
            }
        }

        @ToJson
        public void toJson(JsonWriter jsonWriter, IpConfig ipConfig) {
            Intrinsics.checkNotNullParameter(jsonWriter, "writer");
            adapter.toJson(jsonWriter, ipConfig != null ? ipConfig.getMap() : null);
        }
    }
}
