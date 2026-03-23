package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/FilterTrigger;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Particles", "ParticlesAndGases", "UnknownTrigger", "Companion", "Lcom/blueair/core/model/FilterTrigger$Particles;", "Lcom/blueair/core/model/FilterTrigger$ParticlesAndGases;", "Lcom/blueair/core/model/FilterTrigger$UnknownTrigger;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterTrigger.kt */
public abstract class FilterTrigger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;

    public /* synthetic */ FilterTrigger(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private FilterTrigger(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/FilterTrigger$Particles;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterTrigger.kt */
    public static final class Particles extends FilterTrigger {
        public static final Particles INSTANCE = new Particles();

        private Particles() {
            super("particles", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/FilterTrigger$ParticlesAndGases;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterTrigger.kt */
    public static final class ParticlesAndGases extends FilterTrigger {
        public static final ParticlesAndGases INSTANCE = new ParticlesAndGases();

        private ParticlesAndGases() {
            super("particles and gases", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/FilterTrigger$UnknownTrigger;", "Lcom/blueair/core/model/FilterTrigger;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterTrigger.kt */
    public static final class UnknownTrigger extends FilterTrigger {
        public static final UnknownTrigger INSTANCE = new UnknownTrigger();

        private UnknownTrigger() {
            super("unknown_trigger", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/FilterTrigger$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/FilterTrigger;", "value", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterTrigger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
            if (r3.equals("pm_voc") == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
            if (r3.equals("PMtVOC") == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
            return com.blueair.core.model.FilterTrigger.ParticlesAndGases.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.core.model.FilterTrigger fromServerValue(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r0 = r3
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0013
                com.blueair.core.model.FilterTrigger$UnknownTrigger r3 = com.blueair.core.model.FilterTrigger.UnknownTrigger.INSTANCE
                com.blueair.core.model.FilterTrigger r3 = (com.blueair.core.model.FilterTrigger) r3
                return r3
            L_0x0013:
                int r0 = r3.hashCode()
                r1 = -1929983181(0xffffffff8cf6cb33, float:-3.8024597E-31)
                if (r0 == r1) goto L_0x004a
                r1 = -984891512(0xffffffffc54bbf88, float:-3259.9707)
                if (r0 == r1) goto L_0x0041
                r1 = 2557(0x9fd, float:3.583E-42)
                if (r0 == r1) goto L_0x0033
                r1 = 3581(0xdfd, float:5.018E-42)
                if (r0 == r1) goto L_0x002a
                goto L_0x0052
            L_0x002a:
                java.lang.String r0 = "pm"
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L_0x0052
                goto L_0x003c
            L_0x0033:
                java.lang.String r0 = "PM"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L_0x003c
                goto L_0x0052
            L_0x003c:
                com.blueair.core.model.FilterTrigger$Particles r3 = com.blueair.core.model.FilterTrigger.Particles.INSTANCE
                com.blueair.core.model.FilterTrigger r3 = (com.blueair.core.model.FilterTrigger) r3
                return r3
            L_0x0041:
                java.lang.String r0 = "pm_voc"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L_0x0057
                goto L_0x0052
            L_0x004a:
                java.lang.String r0 = "PMtVOC"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L_0x0057
            L_0x0052:
                com.blueair.core.model.FilterTrigger$UnknownTrigger r3 = com.blueair.core.model.FilterTrigger.UnknownTrigger.INSTANCE
                com.blueair.core.model.FilterTrigger r3 = (com.blueair.core.model.FilterTrigger) r3
                return r3
            L_0x0057:
                com.blueair.core.model.FilterTrigger$ParticlesAndGases r3 = com.blueair.core.model.FilterTrigger.ParticlesAndGases.INSTANCE
                com.blueair.core.model.FilterTrigger r3 = (com.blueair.core.model.FilterTrigger) r3
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.FilterTrigger.Companion.fromServerValue(java.lang.String):com.blueair.core.model.FilterTrigger");
        }
    }
}
