package com.blueair.core;

import com.blueair.android.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006!"}, d2 = {"Lcom/blueair/core/BuildEnvironment;", "", "<init>", "()V", "variant", "Lcom/blueair/core/BuildVariant;", "getVariant", "()Lcom/blueair/core/BuildVariant;", "flavor", "Lcom/blueair/core/BuildFlavor;", "getFlavor", "()Lcom/blueair/core/BuildFlavor;", "isRelease", "", "()Z", "isChina", "versionName", "", "getVersionName", "()Ljava/lang/String;", "setVersionName", "(Ljava/lang/String;)V", "versionCode", "", "getVersionCode", "()I", "setVersionCode", "(I)V", "displayVersion", "getDisplayVersion", "applicationId", "getApplicationId", "setApplicationId", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BuildEnvironment.kt */
public final class BuildEnvironment {
    public static final BuildEnvironment INSTANCE = new BuildEnvironment();
    private static String applicationId = BuildConfig.APPLICATION_ID;
    private static final BuildFlavor flavor;
    private static final boolean isChina;
    private static final boolean isRelease;
    private static final BuildVariant variant;
    private static int versionCode;
    private static String versionName = "";

    private BuildEnvironment() {
    }

    public final BuildVariant getVariant() {
        return variant;
    }

    static {
        BuildVariant buildVariant = BuildVariant.RELEASE;
        variant = buildVariant;
        BuildFlavor buildFlavor = BuildFlavor.OTHER;
        flavor = buildFlavor;
        boolean z = true;
        isRelease = buildVariant == BuildVariant.RELEASE;
        if (buildFlavor != BuildFlavor.CHINA) {
            z = false;
        }
        isChina = z;
    }

    public final BuildFlavor getFlavor() {
        return flavor;
    }

    public final boolean isRelease() {
        return isRelease;
    }

    public final boolean isChina() {
        return isChina;
    }

    public final String getVersionName() {
        return versionName;
    }

    public final void setVersionName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        versionName = str;
    }

    public final int getVersionCode() {
        return versionCode;
    }

    public final void setVersionCode(int i) {
        versionCode = i;
    }

    public final String getDisplayVersion() {
        return versionName + " (" + versionCode + ')';
    }

    public final String getApplicationId() {
        return applicationId;
    }

    public final void setApplicationId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        applicationId = str;
    }
}
