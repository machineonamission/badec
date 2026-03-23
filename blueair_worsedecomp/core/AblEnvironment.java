package com.blueair.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/AblEnvironment;", "", "<init>", "()V", "PROD", "", "UAT", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "apiKey", "getApiKey", "isUAT", "", "()Z", "getHost", "url", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AblEnvironment.kt */
public final class AblEnvironment {
    public static final AblEnvironment INSTANCE = new AblEnvironment();
    public static final String PROD = "https://api.blueair.io/";
    public static final String UAT = "https://api-uat.blueair.io/";
    private static String baseUrl;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblEnvironment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.BuildVariant[] r0 = com.blueair.core.BuildVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.DEBUG     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.RELEASE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.BuildVariant r1 = com.blueair.core.BuildVariant.BETA     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.AblEnvironment.WhenMappings.<clinit>():void");
        }
    }

    private AblEnvironment() {
    }

    static {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$0[BuildEnvironment.INSTANCE.getVariant().ordinal()];
        if (i == 1 || i == 2) {
            str = PROD;
        } else if (i == 3) {
            str = UAT;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        baseUrl = str;
    }

    public final String getBaseUrl() {
        return baseUrl;
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        baseUrl = str;
    }

    public final String getApiKey() {
        String str = baseUrl;
        if (Intrinsics.areEqual((Object) str, (Object) PROD)) {
            return "eyJhbGciOiJIUzI1NiJ9.eyJncmFudGVlIjoiYmx1ZWFpciIsImlhdCI6MTQ1MzEyNTYzMiwidmFsaWRpdHkiOi0xLCJqdGkiOiJkNmY3OGE0Yi1iMWNkLTRkZDgtOTA2Yi1kN2JkNzM0MTQ2NzQiLCJwZXJtaXNzaW9ucyI6WyJhbGwiXSwicXVvdGEiOi0xLCJyYXRlTGltaXQiOi0xfQ.CJsfWVzFKKDDA6rWdh-hjVVVE9S3d6Hu9BzXG9htWFw";
        }
        if (Intrinsics.areEqual((Object) str, (Object) UAT)) {
            return "eyJhbGciOiJIUzI1NiJ9.eyJncmFudGVlIjoiYmx1ZWFpciIsImlhdCI6MTQ0NzIzOTQyNSwidmFsaWRpdHkiOi0xLCJqdGkiOiIyIiwicGVybWlzc2lvbnMiOlsiYWxsIl0sInF1b3RhIjotMSwicmF0ZUxpbWl0IjotMX0.aqN5MuOHKeEwqOkAJAP0caBcj3Z3nkde0U83OYO9g_A";
        }
        return "";
    }

    public final boolean isUAT() {
        return Intrinsics.areEqual((Object) baseUrl, (Object) UAT);
    }

    public final String getHost(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return StringsKt.removeSuffix(StringsKt.removePrefix(str, (CharSequence) "https://"), (CharSequence) "/");
    }
}
