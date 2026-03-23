package com.blueair.viewcore.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/blueair/viewcore/activity/LoginPendingAction;", "", "action", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getData", "toIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Actions.kt */
public final class LoginPendingAction {
    private static final String ALEXA_LINKING = "ALEXA_LINKING";
    private static final String ANTI_FAKE_SCAN = "ANTI_FAKE_SCAN";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final LoginPendingAction EMPTY = new LoginPendingAction("", (String) null, 2, (DefaultConstructorMarker) null);
    private static final String GOOGLE_LINKING = "GOOGLE_LINKING";
    private final String action;
    private final String data;

    public static /* synthetic */ LoginPendingAction copy$default(LoginPendingAction loginPendingAction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginPendingAction.action;
        }
        if ((i & 2) != 0) {
            str2 = loginPendingAction.data;
        }
        return loginPendingAction.copy(str, str2);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.data;
    }

    public final LoginPendingAction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "action");
        return new LoginPendingAction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginPendingAction)) {
            return false;
        }
        LoginPendingAction loginPendingAction = (LoginPendingAction) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) loginPendingAction.action) && Intrinsics.areEqual((Object) this.data, (Object) loginPendingAction.data);
    }

    public int hashCode() {
        int hashCode = this.action.hashCode() * 31;
        String str = this.data;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginPendingAction(action=" + this.action + ", data=" + this.data + ')';
    }

    public LoginPendingAction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "action");
        this.action = str;
        this.data = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginPendingAction(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/viewcore/activity/LoginPendingAction$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "getEMPTY", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "ALEXA_LINKING", "", "GOOGLE_LINKING", "ANTI_FAKE_SCAN", "alexaLinking", "uri", "Landroid/net/Uri;", "googleLinking", "antiFakeScan", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Actions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginPendingAction getEMPTY() {
            return LoginPendingAction.EMPTY;
        }

        public final LoginPendingAction alexaLinking(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new LoginPendingAction(LoginPendingAction.ALEXA_LINKING, uri.toString());
        }

        public final LoginPendingAction googleLinking() {
            return new LoginPendingAction(LoginPendingAction.GOOGLE_LINKING, (String) null, 2, (DefaultConstructorMarker) null);
        }

        public final LoginPendingAction antiFakeScan() {
            return new LoginPendingAction(LoginPendingAction.ANTI_FAKE_SCAN, (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public final Intent toIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.action;
        int hashCode = str.hashCode();
        Uri uri = null;
        if (hashCode != -1921754998) {
            if (hashCode != 677013890) {
                if (hashCode == 1512988460 && str.equals(ALEXA_LINKING)) {
                    String str2 = this.data;
                    if (str2 != null) {
                        uri = Uri.parse(str2);
                    }
                    return new Intent("android.intent.action.VIEW", uri);
                }
            } else if (str.equals(GOOGLE_LINKING)) {
                return new Intent("blueair.action.appflip");
            }
        } else if (str.equals(ANTI_FAKE_SCAN)) {
            return Actions.openAntiFakeScanIntent$default(Actions.INSTANCE, context, (HasSKU) null, (DeviceFilterType) null, 6, (Object) null);
        }
        return null;
    }
}
