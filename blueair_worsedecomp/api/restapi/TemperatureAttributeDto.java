package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/blueair/api/restapi/TemperatureAttributeDto;", "", "currentValue", "", "defaultValue", "userId", "", "name", "scope", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCurrentValue", "()Ljava/lang/String;", "getDefaultValue", "getUserId", "()I", "getName", "getScope", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblRestApi.kt */
public final class TemperatureAttributeDto {
    private final String currentValue;
    private final String defaultValue;
    private final String name;
    private final String scope;
    private final int userId;

    public static /* synthetic */ TemperatureAttributeDto copy$default(TemperatureAttributeDto temperatureAttributeDto, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = temperatureAttributeDto.currentValue;
        }
        if ((i2 & 2) != 0) {
            str2 = temperatureAttributeDto.defaultValue;
        }
        if ((i2 & 4) != 0) {
            i = temperatureAttributeDto.userId;
        }
        if ((i2 & 8) != 0) {
            str3 = temperatureAttributeDto.name;
        }
        if ((i2 & 16) != 0) {
            str4 = temperatureAttributeDto.scope;
        }
        String str5 = str3;
        String str6 = str4;
        return temperatureAttributeDto.copy(str, str2, i, str5, str6);
    }

    public final String component1() {
        return this.currentValue;
    }

    public final String component2() {
        return this.defaultValue;
    }

    public final int component3() {
        return this.userId;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.scope;
    }

    public final TemperatureAttributeDto copy(String str, String str2, int i, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "currentValue");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "scope");
        return new TemperatureAttributeDto(str, str2, i, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemperatureAttributeDto)) {
            return false;
        }
        TemperatureAttributeDto temperatureAttributeDto = (TemperatureAttributeDto) obj;
        return Intrinsics.areEqual((Object) this.currentValue, (Object) temperatureAttributeDto.currentValue) && Intrinsics.areEqual((Object) this.defaultValue, (Object) temperatureAttributeDto.defaultValue) && this.userId == temperatureAttributeDto.userId && Intrinsics.areEqual((Object) this.name, (Object) temperatureAttributeDto.name) && Intrinsics.areEqual((Object) this.scope, (Object) temperatureAttributeDto.scope);
    }

    public int hashCode() {
        return (((((((this.currentValue.hashCode() * 31) + this.defaultValue.hashCode()) * 31) + this.userId) * 31) + this.name.hashCode()) * 31) + this.scope.hashCode();
    }

    public String toString() {
        return "TemperatureAttributeDto(currentValue=" + this.currentValue + ", defaultValue=" + this.defaultValue + ", userId=" + this.userId + ", name=" + this.name + ", scope=" + this.scope + ')';
    }

    public TemperatureAttributeDto(String str, String str2, int i, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "currentValue");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "scope");
        this.currentValue = str;
        this.defaultValue = str2;
        this.userId = i;
        this.name = str3;
        this.scope = str4;
    }

    public final String getCurrentValue() {
        return this.currentValue;
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final int getUserId() {
        return this.userId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TemperatureAttributeDto(String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? "temperature" : str3, (i2 & 16) != 0 ? "User" : str4);
    }

    public final String getName() {
        return this.name;
    }

    public final String getScope() {
        return this.scope;
    }
}
