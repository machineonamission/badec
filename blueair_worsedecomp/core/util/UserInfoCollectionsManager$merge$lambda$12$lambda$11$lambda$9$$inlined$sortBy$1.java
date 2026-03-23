package com.blueair.core.util;

import com.blueair.core.model.UserInfoCollectionRecord;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class UserInfoCollectionsManager$merge$lambda$12$lambda$11$lambda$9$$inlined$sortBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Long.valueOf(((UserInfoCollectionRecord) t).getTime()), Long.valueOf(((UserInfoCollectionRecord) t2).getTime()));
    }
}
