package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/blueair/core/model/UserForm;", "", "deviceid", "", "phoneModel", "systemVersion", "appVersion", "phoneTs", "", "messageType", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getDeviceid", "()Ljava/lang/String;", "getPhoneModel", "getSystemVersion", "getAppVersion", "getPhoneTs", "()J", "getMessageType", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserForm.kt */
public final class UserForm {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_OFFLINE = "offline";
    private final String appVersion;
    private final String description;
    private final String deviceid;
    private final String messageType;
    private final String phoneModel;
    private final long phoneTs;
    private final String systemVersion;

    public static /* synthetic */ UserForm copy$default(UserForm userForm, String str, String str2, String str3, String str4, long j, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userForm.deviceid;
        }
        if ((i & 2) != 0) {
            str2 = userForm.phoneModel;
        }
        if ((i & 4) != 0) {
            str3 = userForm.systemVersion;
        }
        if ((i & 8) != 0) {
            str4 = userForm.appVersion;
        }
        if ((i & 16) != 0) {
            j = userForm.phoneTs;
        }
        if ((i & 32) != 0) {
            str5 = userForm.messageType;
        }
        if ((i & 64) != 0) {
            str6 = userForm.description;
        }
        long j2 = j;
        String str7 = str3;
        String str8 = str4;
        String str9 = str2;
        return userForm.copy(str, str9, str7, str8, j2, str5, str6);
    }

    public final String component1() {
        return this.deviceid;
    }

    public final String component2() {
        return this.phoneModel;
    }

    public final String component3() {
        return this.systemVersion;
    }

    public final String component4() {
        return this.appVersion;
    }

    public final long component5() {
        return this.phoneTs;
    }

    public final String component6() {
        return this.messageType;
    }

    public final String component7() {
        return this.description;
    }

    public final UserForm copy(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "deviceid");
        Intrinsics.checkNotNullParameter(str2, "phoneModel");
        Intrinsics.checkNotNullParameter(str3, "systemVersion");
        Intrinsics.checkNotNullParameter(str4, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "messageType");
        String str8 = str6;
        Intrinsics.checkNotNullParameter(str8, "description");
        return new UserForm(str, str2, str3, str4, j, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserForm)) {
            return false;
        }
        UserForm userForm = (UserForm) obj;
        return Intrinsics.areEqual((Object) this.deviceid, (Object) userForm.deviceid) && Intrinsics.areEqual((Object) this.phoneModel, (Object) userForm.phoneModel) && Intrinsics.areEqual((Object) this.systemVersion, (Object) userForm.systemVersion) && Intrinsics.areEqual((Object) this.appVersion, (Object) userForm.appVersion) && this.phoneTs == userForm.phoneTs && Intrinsics.areEqual((Object) this.messageType, (Object) userForm.messageType) && Intrinsics.areEqual((Object) this.description, (Object) userForm.description);
    }

    public int hashCode() {
        return (((((((((((this.deviceid.hashCode() * 31) + this.phoneModel.hashCode()) * 31) + this.systemVersion.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.phoneTs)) * 31) + this.messageType.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "UserForm(deviceid=" + this.deviceid + ", phoneModel=" + this.phoneModel + ", systemVersion=" + this.systemVersion + ", appVersion=" + this.appVersion + ", phoneTs=" + this.phoneTs + ", messageType=" + this.messageType + ", description=" + this.description + ')';
    }

    public UserForm(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "deviceid");
        Intrinsics.checkNotNullParameter(str2, "phoneModel");
        Intrinsics.checkNotNullParameter(str3, "systemVersion");
        Intrinsics.checkNotNullParameter(str4, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        Intrinsics.checkNotNullParameter(str5, "messageType");
        Intrinsics.checkNotNullParameter(str6, "description");
        this.deviceid = str;
        this.phoneModel = str2;
        this.systemVersion = str3;
        this.appVersion = str4;
        this.phoneTs = j;
        this.messageType = str5;
        this.description = str6;
    }

    public final String getDeviceid() {
        return this.deviceid;
    }

    public final String getPhoneModel() {
        return this.phoneModel;
    }

    public final String getSystemVersion() {
        return this.systemVersion;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserForm(String str, String str2, String str3, String str4, long j, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, j, str5, (i & 64) != 0 ? "" : str6);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final long getPhoneTs() {
        return this.phoneTs;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/UserForm$Companion;", "", "<init>", "()V", "TYPE_OFFLINE", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserForm.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
