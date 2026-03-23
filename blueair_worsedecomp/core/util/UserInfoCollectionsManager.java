package com.blueair.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.FileNames;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.model.UserInfoCollectionItem;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.model.UserInfoExtras;
import com.blueair.core.model.UserInfoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\"H\u0002J*\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u00102\u001a\u00020\u001fH\u0002J \u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u001fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u00107\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u00108\u001a\u00020\u000eJ\u000e\u00109\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006:"}, d2 = {"Lcom/blueair/core/util/UserInfoCollectionsManager;", "", "<init>", "()V", "enabled", "", "getEnabled", "()Z", "MAX_RECORD_SIZE", "", "context", "Landroid/content/Context;", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/UserInfoCollections;", "value", "version", "getVersion", "()I", "series", "getSeries", "Lcom/blueair/core/model/UserInfoExtras;", "extras", "getExtras", "()Lcom/blueair/core/model/UserInfoExtras;", "", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "collections", "getCollections", "()Ljava/util/List;", "initialize", "", "initializeCollections", "email", "", "findUserInfoGroup", "group", "Lcom/blueair/core/model/UserInfoGroup;", "findUserInfoItem", "Lcom/blueair/core/model/UserInfoCollectionItem;", "item", "Lcom/blueair/core/model/UserInfoItem;", "setData", "data", "loadFromFile", "loadFromJson", "json", "merge", "old", "new", "saveData", "addRecord", "type", "clearData", "setVersion", "setChinaPrivacyConsentVersion", "toUserInfoCollections", "update", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollectionsManager.kt */
public final class UserInfoCollectionsManager {
    public static final UserInfoCollectionsManager INSTANCE = new UserInfoCollectionsManager();
    private static final int MAX_RECORD_SIZE = 100;
    private static List<UserInfoCollectionGroup> collections = CollectionsKt.emptyList();
    private static Context context;
    private static final boolean enabled = BuildEnvironment.INSTANCE.isChina();
    private static UserInfoExtras extras = new UserInfoExtras(0, 1, (DefaultConstructorMarker) null);
    private static final MoshiSerializer<UserInfoCollections> serializer = new MoshiSerializer<>(UserInfoCollections.class, I18nConfig.Adapter.INSTANCE, IpConfig.Adapter.INSTANCE);
    private static int series;
    private static int version;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserInfoCollectionsManager.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(2:25|26)|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.UserInfoItem[] r0 = com.blueair.core.model.UserInfoItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.USER_EMAIL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.USER_PASSWORD     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.USER_AGE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_MODEL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_SYSTEM_VERSION     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.BLUEAIR_APP_VERSION     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_BRAND     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_RAM_SIZE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_VENDOR     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.PHONE_COUNTRY_CODE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.BLUEAIR_APP_INFO     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.DEVICE_SERIAL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.core.model.UserInfoItem r1 = com.blueair.core.model.UserInfoItem.DEVICE_MAC     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.WhenMappings.<clinit>():void");
        }
    }

    private UserInfoCollectionsManager() {
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final int getVersion() {
        return version;
    }

    public final int getSeries() {
        return series;
    }

    public final UserInfoExtras getExtras() {
        return extras;
    }

    public final List<UserInfoCollectionGroup> getCollections() {
        return collections;
    }

    public final void initialize(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (enabled) {
            context = context2;
            loadFromFile();
        }
    }

    public final boolean initializeCollections(String str, Context context2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(context2, "context");
        if (!enabled) {
            return false;
        }
        UserInfoCollectionItem findUserInfoItem = findUserInfoItem(UserInfoItem.USER_EMAIL);
        if ((findUserInfoItem != null ? findUserInfoItem.getRecordsCount() : 0) > 0) {
            return false;
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("initializeCollections: " + str, new Object[0]);
        addRecord(UserInfoItem.USER_EMAIL, str, false);
        addRecord(UserInfoItem.USER_PASSWORD, "", false);
        addRecord(UserInfoItem.USER_AGE, "", false);
        addRecord(UserInfoItem.ANDROID_ID, "", false);
        UserInfoItem userInfoItem = UserInfoItem.PHONE_MODEL;
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        addRecord(userInfoItem, str2, false);
        UserInfoItem userInfoItem2 = UserInfoItem.PHONE_SYSTEM_VERSION;
        addRecord(userInfoItem2, StringsKt.trim((CharSequence) Build.VERSION.BASE_OS + TokenParser.SP + Build.VERSION.RELEASE + TokenParser.SP + Build.VERSION.SDK_INT).toString(), false);
        addRecord(UserInfoItem.BLUEAIR_APP_VERSION, BuildEnvironment.INSTANCE.getDisplayVersion(), false);
        UserInfoItem userInfoItem3 = UserInfoItem.PHONE_BRAND;
        String str3 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str3, "BRAND");
        addRecord(userInfoItem3, str3, false);
        Object systemService = context2.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem / ((long) 1048576);
            UserInfoItem userInfoItem4 = UserInfoItem.PHONE_RAM_SIZE;
            addRecord(userInfoItem4, j + " MB", false);
        }
        UserInfoItem userInfoItem5 = UserInfoItem.PHONE_VENDOR;
        String str4 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str4, "MANUFACTURER");
        addRecord(userInfoItem5, str4, false);
        UserInfoItem userInfoItem6 = UserInfoItem.PHONE_COUNTRY_CODE;
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        addRecord(userInfoItem6, country, false);
        addRecord(UserInfoItem.BLUEAIR_APP_INFO, BuildEnvironment.INSTANCE.getApplicationId(), false);
        saveData();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.blueair.core.model.UserInfoCollectionGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.blueair.core.model.UserInfoCollectionGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.blueair.core.model.UserInfoCollectionGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.blueair.core.model.UserInfoCollectionGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.UserInfoCollectionGroup findUserInfoGroup(com.blueair.core.model.UserInfoGroup r6) {
        /*
            r5 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = enabled
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            java.util.List<com.blueair.core.model.UserInfoCollectionGroup> r0 = collections
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0013:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.blueair.core.model.UserInfoCollectionGroup r3 = (com.blueair.core.model.UserInfoCollectionGroup) r3
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r6.getId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0013
            r1 = r2
        L_0x002f:
            com.blueair.core.model.UserInfoCollectionGroup r1 = (com.blueair.core.model.UserInfoCollectionGroup) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.findUserInfoGroup(com.blueair.core.model.UserInfoGroup):com.blueair.core.model.UserInfoCollectionGroup");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.blueair.core.model.UserInfoCollectionItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.blueair.core.model.UserInfoCollectionItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.blueair.core.model.UserInfoCollectionItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.blueair.core.model.UserInfoCollectionItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.UserInfoCollectionItem findUserInfoItem(com.blueair.core.model.UserInfoItem r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = enabled
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            com.blueair.core.model.UserInfoGroup r0 = r6.getGroup()
            com.blueair.core.model.UserInfoCollectionGroup r0 = r5.findUserInfoGroup(r0)
            if (r0 == 0) goto L_0x003f
            java.util.List r0 = r0.getItems()
            if (r0 == 0) goto L_0x003f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.blueair.core.model.UserInfoCollectionItem r3 = (com.blueair.core.model.UserInfoCollectionItem) r3
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r6.getId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0021
            r1 = r2
        L_0x003d:
            com.blueair.core.model.UserInfoCollectionItem r1 = (com.blueair.core.model.UserInfoCollectionItem) r1
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.findUserInfoItem(com.blueair.core.model.UserInfoItem):com.blueair.core.model.UserInfoCollectionItem");
    }

    private final void setData(UserInfoCollections userInfoCollections) {
        List<UserInfoCollectionGroup> list;
        if (enabled) {
            try {
                if (!collections.isEmpty()) {
                    list = merge(collections, userInfoCollections.getCollections());
                } else {
                    list = userInfoCollections.getCollections();
                }
                collections = list;
                Integer intOrNull = StringsKt.toIntOrNull(userInfoCollections.getVersion());
                version = intOrNull != null ? intOrNull.intValue() : 0;
                Integer intOrNull2 = StringsKt.toIntOrNull(userInfoCollections.getSeries());
                series = intOrNull2 != null ? intOrNull2.intValue() : 0;
                UserInfoExtras extras2 = userInfoCollections.getExtras();
                if (extras2 == null) {
                    extras2 = new UserInfoExtras(0, 1, (DefaultConstructorMarker) null);
                }
                extras = extras2;
            } catch (Throwable th) {
                Timber.Forest forest = Timber.Forest;
                forest.e(th, "setData failed: " + th.getLocalizedMessage(), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c0, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadFromFile() {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            boolean r1 = enabled
            if (r1 != 0) goto L_0x0008
            goto L_0x00d4
        L_0x0008:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00ca }
            r1 = r6
            com.blueair.core.util.UserInfoCollectionsManager r1 = (com.blueair.core.util.UserInfoCollectionsManager) r1     // Catch:{ all -> 0x00ca }
            r1 = 8192(0x2000, float:1.14794E-41)
            r2 = 0
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            android.content.Context r3 = context     // Catch:{ all -> 0x005b }
            if (r3 != 0) goto L_0x001a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch:{ all -> 0x005b }
            r3 = r2
        L_0x001a:
            java.lang.String r4 = "user_info_collections.json"
            java.io.FileInputStream r3 = r3.openFileInput(r4)     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "openFileInput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x005b }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x005b }
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x005b }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x005b }
            r5.<init>(r3, r4)     // Catch:{ all -> 0x005b }
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ all -> 0x005b }
            boolean r3 = r5 instanceof java.io.BufferedReader     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x0037
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x005b }
            goto L_0x003d
        L_0x0037:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x005b }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x005b }
            r5 = r3
        L_0x003d:
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x005b }
            r3 = r5
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0054 }
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r3)     // Catch:{ all -> 0x0054 }
            kotlin.io.CloseableKt.closeFinally(r5, r2)     // Catch:{ all -> 0x005b }
            com.blueair.core.model.UserInfoCollections r3 = r6.loadFromJson(r3)     // Catch:{ all -> 0x005b }
            java.lang.Object r3 = kotlin.Result.m9366constructorimpl(r3)     // Catch:{ all -> 0x005b }
            goto L_0x0066
        L_0x0054:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r3)     // Catch:{ all -> 0x005b }
            throw r4     // Catch:{ all -> 0x005b }
        L_0x005b:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00ca }
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)     // Catch:{ all -> 0x00ca }
            java.lang.Object r3 = kotlin.Result.m9366constructorimpl(r3)     // Catch:{ all -> 0x00ca }
        L_0x0066:
            boolean r4 = kotlin.Result.m9372isFailureimpl(r3)     // Catch:{ all -> 0x00ca }
            if (r4 == 0) goto L_0x006d
            r3 = r2
        L_0x006d:
            com.blueair.core.model.UserInfoCollections r3 = (com.blueair.core.model.UserInfoCollections) r3     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x00c1
            android.content.Context r3 = context     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x0079
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch:{ all -> 0x00ca }
            r3 = r2
        L_0x0079:
            android.content.res.Resources r0 = r3.getResources()     // Catch:{ all -> 0x00ca }
            int r3 = com.blueair.core.R.raw.user_info_collections     // Catch:{ all -> 0x00ca }
            java.io.InputStream r0 = r0.openRawResource(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "openRawResource(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ all -> 0x00ca }
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x00ca }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ca }
            r4.<init>(r0, r3)     // Catch:{ all -> 0x00ca }
            java.io.Reader r4 = (java.io.Reader) r4     // Catch:{ all -> 0x00ca }
            boolean r0 = r4 instanceof java.io.BufferedReader     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0098
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x00ca }
            goto L_0x009e
        L_0x0098:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x00ca }
            r0.<init>(r4, r1)     // Catch:{ all -> 0x00ca }
            r4 = r0
        L_0x009e:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00ca }
            r0 = r4
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x00ba }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x00ba }
            kotlin.io.CloseableKt.closeFinally(r4, r2)     // Catch:{ all -> 0x00ca }
            com.blueair.core.model.UserInfoCollections r0 = r6.loadFromJson(r0)     // Catch:{ all -> 0x00ca }
            if (r0 != 0) goto L_0x00b3
            goto L_0x00d4
        L_0x00b3:
            r6.setData(r0)     // Catch:{ all -> 0x00ca }
            r6.saveData()     // Catch:{ all -> 0x00ca }
            goto L_0x00c4
        L_0x00ba:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x00ca }
            throw r1     // Catch:{ all -> 0x00ca }
        L_0x00c1:
            r6.setData(r3)     // Catch:{ all -> 0x00ca }
        L_0x00c4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ca }
            kotlin.Result.m9366constructorimpl(r0)     // Catch:{ all -> 0x00ca }
            goto L_0x00d4
        L_0x00ca:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m9366constructorimpl(r0)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.loadFromFile():void");
    }

    private final UserInfoCollections loadFromJson(String str) {
        return serializer.fromJson(str);
    }

    private final List<UserInfoCollectionGroup> merge(List<UserInfoCollectionGroup> list, List<UserInfoCollectionGroup> list2) {
        Object obj;
        Object obj2;
        List<UserInfoCollectionGroup> arrayList = new ArrayList<>();
        for (UserInfoCollectionGroup userInfoCollectionGroup : list2) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((UserInfoCollectionGroup) obj).getId(), (Object) userInfoCollectionGroup.getId())) {
                    break;
                }
            }
            UserInfoCollectionGroup userInfoCollectionGroup2 = (UserInfoCollectionGroup) obj;
            if (userInfoCollectionGroup2 == null) {
                arrayList.add(userInfoCollectionGroup);
            } else {
                List arrayList2 = new ArrayList();
                for (UserInfoCollectionItem userInfoCollectionItem : userInfoCollectionGroup.getItems()) {
                    Iterator it2 = userInfoCollectionGroup2.getItems().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (Intrinsics.areEqual((Object) ((UserInfoCollectionItem) obj2).getId(), (Object) userInfoCollectionItem.getId())) {
                            break;
                        }
                    }
                    UserInfoCollectionItem userInfoCollectionItem2 = (UserInfoCollectionItem) obj2;
                    if (userInfoCollectionItem2 == null) {
                        arrayList2.add(userInfoCollectionItem);
                    } else {
                        List mutableList = CollectionsKt.toMutableList(CollectionsKt.filterNotNull(userInfoCollectionItem.getRecords()));
                        mutableList.addAll(CollectionsKt.filterNotNull(userInfoCollectionItem2.getRecords()));
                        if (mutableList.size() > 1) {
                            CollectionsKt.sortWith(mutableList, new UserInfoCollectionsManager$merge$lambda$12$lambda$11$lambda$9$$inlined$sortBy$1());
                        }
                        int size = mutableList.size() - 100;
                        if (size > 0) {
                            for (int i = 0; i < size; i++) {
                                CollectionsKt.removeFirstOrNull(mutableList);
                            }
                        }
                        arrayList2.add(UserInfoCollectionItem.copy$default(userInfoCollectionItem, (String) null, (I18nConfig) null, (I18nConfig) null, (I18nConfig) null, userInfoCollectionItem.getOmitted() + Math.max(0, size), mutableList, 15, (Object) null));
                    }
                }
                arrayList.add(UserInfoCollectionGroup.copy$default(userInfoCollectionGroup, (String) null, (I18nConfig) null, arrayList2, 3, (Object) null));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void saveData() {
        /*
            r5 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005f }
            r0 = r5
            com.blueair.core.util.UserInfoCollectionsManager r0 = (com.blueair.core.util.UserInfoCollectionsManager) r0     // Catch:{ all -> 0x005f }
            boolean r0 = enabled     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            com.blueair.core.util.MoshiSerializer<com.blueair.core.model.UserInfoCollections> r0 = serializer     // Catch:{ all -> 0x005f }
            com.blueair.core.model.UserInfoCollections r1 = r5.toUserInfoCollections()     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.toJson(r1)     // Catch:{ all -> 0x005f }
            android.content.Context r1 = context     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r1 != 0) goto L_0x001f
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x005f }
            r1 = r2
        L_0x001f:
            java.lang.String r3 = "user_info_collections.json"
            r4 = 0
            java.io.FileOutputStream r1 = r1.openFileOutput(r3, r4)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "openFileOutput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x005f }
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x005f }
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x005f }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005f }
            r4.<init>(r1, r3)     // Catch:{ all -> 0x005f }
            java.io.Writer r4 = (java.io.Writer) r4     // Catch:{ all -> 0x005f }
            boolean r1 = r4 instanceof java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x003d
            java.io.BufferedWriter r4 = (java.io.BufferedWriter) r4     // Catch:{ all -> 0x005f }
            goto L_0x0045
        L_0x003d:
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            r3 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r3)     // Catch:{ all -> 0x005f }
            r4 = r1
        L_0x0045:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x005f }
            r1 = r4
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x0058 }
            r1.write(r0)     // Catch:{ all -> 0x0058 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0058 }
            kotlin.io.CloseableKt.closeFinally(r4, r2)     // Catch:{ all -> 0x005f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005f }
            kotlin.Result.m9366constructorimpl(r0)     // Catch:{ all -> 0x005f }
            return
        L_0x0058:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x005f }
            throw r1     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m9366constructorimpl(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.saveData():void");
    }

    public static /* synthetic */ void addRecord$default(UserInfoCollectionsManager userInfoCollectionsManager, UserInfoItem userInfoItem, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        userInfoCollectionsManager.addRecord(userInfoItem, str, z);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.blueair.core.model.UserInfoCollectionRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a4, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089 A[Catch:{ all -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0 A[Catch:{ all -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void addRecord(com.blueair.core.model.UserInfoItem r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)     // Catch:{ all -> 0x00a5 }
            boolean r0 = enabled     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r7)
            return
        L_0x0011:
            com.blueair.core.model.UserInfoCollectionItem r0 = r7.findUserInfoItem(r8)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0019
            monitor-exit(r7)
            return
        L_0x0019:
            int[] r1 = com.blueair.core.util.UserInfoCollectionsManager.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00a5 }
            int r8 = r8.ordinal()     // Catch:{ all -> 0x00a5 }
            r8 = r1[r8]     // Catch:{ all -> 0x00a5 }
            r1 = 0
            switch(r8) {
                case 1: goto L_0x0064;
                case 2: goto L_0x0064;
                case 3: goto L_0x0064;
                case 4: goto L_0x004c;
                case 5: goto L_0x004c;
                case 6: goto L_0x004c;
                case 7: goto L_0x004c;
                case 8: goto L_0x004c;
                case 9: goto L_0x004c;
                case 10: goto L_0x004c;
                case 11: goto L_0x004c;
                case 12: goto L_0x0026;
                case 13: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ all -> 0x00a5 }
        L_0x0025:
            goto L_0x006c
        L_0x0026:
            java.util.List r8 = r0.getRecords()     // Catch:{ all -> 0x00a5 }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x00a5 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00a5 }
        L_0x0030:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0048
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00a5 }
            r3 = r2
            com.blueair.core.model.UserInfoCollectionRecord r3 = (com.blueair.core.model.UserInfoCollectionRecord) r3     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x00a5 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x0030
            r1 = r2
        L_0x0048:
            if (r1 == 0) goto L_0x006c
            monitor-exit(r7)
            return
        L_0x004c:
            java.util.List r8 = r0.getRecords()     // Catch:{ all -> 0x00a5 }
            java.lang.Object r8 = kotlin.collections.CollectionsKt.lastOrNull(r8)     // Catch:{ all -> 0x00a5 }
            com.blueair.core.model.UserInfoCollectionRecord r8 = (com.blueair.core.model.UserInfoCollectionRecord) r8     // Catch:{ all -> 0x00a5 }
            if (r8 == 0) goto L_0x005c
            java.lang.String r1 = r8.getValue()     // Catch:{ all -> 0x00a5 }
        L_0x005c:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x00a5 }
            if (r8 == 0) goto L_0x006c
            monitor-exit(r7)
            return
        L_0x0064:
            int r8 = r0.getRecordsCount()     // Catch:{ all -> 0x00a5 }
            if (r8 <= 0) goto L_0x006c
            monitor-exit(r7)
            return
        L_0x006c:
            java.util.List r8 = r0.getRecords()     // Catch:{ all -> 0x00a5 }
            com.blueair.core.model.UserInfoCollectionRecord r1 = new com.blueair.core.model.UserInfoCollectionRecord     // Catch:{ all -> 0x00a5 }
            r5 = 2
            r6 = 0
            r3 = 0
            r2 = r9
            r1.<init>(r2, r3, r5, r6)     // Catch:{ all -> 0x00a5 }
            r8.add(r1)     // Catch:{ all -> 0x00a5 }
            java.util.List r8 = r0.getRecords()     // Catch:{ all -> 0x00a5 }
            int r8 = r8.size()     // Catch:{ all -> 0x00a5 }
            int r8 = r8 + -100
            if (r8 <= 0) goto L_0x009e
            int r9 = r0.getOmitted()     // Catch:{ all -> 0x00a5 }
            int r9 = r9 + r8
            r0.setOmitted(r9)     // Catch:{ all -> 0x00a5 }
            r9 = 0
        L_0x0092:
            if (r9 >= r8) goto L_0x009e
            java.util.List r1 = r0.getRecords()     // Catch:{ all -> 0x00a5 }
            kotlin.collections.CollectionsKt.removeFirstOrNull(r1)     // Catch:{ all -> 0x00a5 }
            int r9 = r9 + 1
            goto L_0x0092
        L_0x009e:
            if (r10 == 0) goto L_0x00a3
            r7.saveData()     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r7)
            return
        L_0x00a5:
            r0 = move-exception
            r8 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x00a5 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.UserInfoCollectionsManager.addRecord(com.blueair.core.model.UserInfoItem, java.lang.String, boolean):void");
    }

    public final void clearData() {
        if (enabled) {
            try {
                Result.Companion companion = Result.Companion;
                UserInfoCollectionsManager userInfoCollectionsManager = this;
                Context context2 = context;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context2 = null;
                }
                Result.m9366constructorimpl(Boolean.valueOf(context2.deleteFile(FileNames.USER_INFO_COLLECTIONS)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void setVersion(int i) {
        if (enabled) {
            version = i;
            saveData();
        }
    }

    public final void setChinaPrivacyConsentVersion(int i) {
        if (enabled) {
            extras.setChinaPrivacyConsentVersion(i);
            saveData();
        }
    }

    public final UserInfoCollections toUserInfoCollections() {
        return new UserInfoCollections(String.valueOf(version), String.valueOf(series), extras, collections);
    }

    public final boolean update(UserInfoCollections userInfoCollections) {
        Intrinsics.checkNotNullParameter(userInfoCollections, "data");
        if (!enabled) {
            return false;
        }
        Integer intOrNull = StringsKt.toIntOrNull(userInfoCollections.getSeries());
        int i = series;
        if (intOrNull != null && intOrNull.intValue() == i) {
            Integer intOrNull2 = StringsKt.toIntOrNull(userInfoCollections.getVersion());
            if ((intOrNull2 != null ? intOrNull2.intValue() : 0) > version) {
                setData(userInfoCollections);
                saveData();
                return true;
            }
        }
        return false;
    }
}
