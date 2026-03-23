package com.blueair.sdk;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.widget.Toolbar;
import com.lokalise.sdk.Lokalise;
import com.lokalise.sdk.LokaliseContextWrapper;
import com.lokalise.sdk.LokaliseFallbackStrategy;
import com.lokalise.sdk.LokaliseResources;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0017\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/blueair/sdk/LokaliseSdk;", "", "<init>", "()V", "init", "", "application", "Landroid/app/Application;", "updateTranslations", "isPreRelease", "", "(Ljava/lang/Boolean;)V", "wrapContext", "Landroid/content/Context;", "context", "translateToolbarItems", "resources", "Landroid/content/res/Resources;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LokaliseSdk.kt */
public final class LokaliseSdk {
    public static final LokaliseSdk INSTANCE = new LokaliseSdk();

    private LokaliseSdk() {
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Lokalise.init$default(application, "62de171ed52f369f8527356055b77177e42aa699", "7602759061af4545796cc0.39061213", (LokaliseFallbackStrategy) null, (List) null, (List) null, 56, (Object) null);
    }

    public static /* synthetic */ void updateTranslations$default(LokaliseSdk lokaliseSdk, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        lokaliseSdk.updateTranslations(bool);
    }

    public final void updateTranslations(Boolean bool) {
        if (bool != null) {
            Lokalise.setPreRelease(bool.booleanValue());
        }
        Lokalise.updateTranslations();
    }

    public final Context wrapContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LokaliseContextWrapper.Companion.wrap(context);
    }

    public final void translateToolbarItems(Resources resources, Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        LokaliseResources lokaliseResources = resources instanceof LokaliseResources ? (LokaliseResources) resources : null;
        if (lokaliseResources != null) {
            lokaliseResources.translateToolbarItems(toolbar);
        }
    }
}
