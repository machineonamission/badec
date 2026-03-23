package com.blueair.core.model;

import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 $2\u00020\u0001:\u0016\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0015%&'()*+,-./0123456789¨\u0006:"}, d2 = {"Lcom/blueair/core/model/DeviceType;", "", "index", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "isNewPlatform", "", "hasSafetySwitch", "Unknown", "Classic", "G4", "Aware", "Sense", "Icp", "ClassicWithoutSensor", "B4", "B4sp", "BluePremium", "Blue", "NewClassic", "Humidifier", "Combo3in1", "Combo2in1", "Dehumidifier", "Pet20", "Blue40", "Humidifier20", "MiniRestful", "Combo2in120", "Companion", "Lcom/blueair/core/model/DeviceType$Aware;", "Lcom/blueair/core/model/DeviceType$B4;", "Lcom/blueair/core/model/DeviceType$B4sp;", "Lcom/blueair/core/model/DeviceType$Blue;", "Lcom/blueair/core/model/DeviceType$Blue40;", "Lcom/blueair/core/model/DeviceType$BluePremium;", "Lcom/blueair/core/model/DeviceType$Classic;", "Lcom/blueair/core/model/DeviceType$ClassicWithoutSensor;", "Lcom/blueair/core/model/DeviceType$Combo2in1;", "Lcom/blueair/core/model/DeviceType$Combo2in120;", "Lcom/blueair/core/model/DeviceType$Combo3in1;", "Lcom/blueair/core/model/DeviceType$Dehumidifier;", "Lcom/blueair/core/model/DeviceType$G4;", "Lcom/blueair/core/model/DeviceType$Humidifier;", "Lcom/blueair/core/model/DeviceType$Humidifier20;", "Lcom/blueair/core/model/DeviceType$Icp;", "Lcom/blueair/core/model/DeviceType$MiniRestful;", "Lcom/blueair/core/model/DeviceType$NewClassic;", "Lcom/blueair/core/model/DeviceType$Pet20;", "Lcom/blueair/core/model/DeviceType$Sense;", "Lcom/blueair/core/model/DeviceType$Unknown;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceType.kt */
public abstract class DeviceType {
    public static final String BLUE = "Blue";
    public static final String BLUE_PREMIUM = "Blue premium";
    public static final String BLUE_PURE = "Blue Pure";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DUST_MAGNET = "DustMagnet";
    public static final String DUST_MAGNET_SP = "DustMagnet Super Premium";
    /* access modifiers changed from: private */
    public static final Set<String> G4Plus_HCHO_SKU = SetsKt.setOf("110371", "110403", "110428", "110379");
    /* access modifiers changed from: private */
    public static final Set<String> G4Plus_SKU = SetsKt.setOf("110568", "110371", "110426", "110403", "110427", "110428", "110379", "110480", "110481", "110488", "110489");
    /* access modifiers changed from: private */
    public static final Set<String> G4Plus_tVOC_SKU = SetsKt.emptySet();
    /* access modifiers changed from: private */
    public static final Set<String> G4SP_SKU = SetsKt.setOf("104866", "107397", "107399", "107400", "107401", "107402", "104865", "107398", "104874", "107403", "107405", "107406", "107407", "107408", "104873", "107404", "108287", "108288");
    public static final String HEALTH_PROTECT = "HealthProtect";
    public static final String PROTECT = "Protect";
    public static final String PROTECT_PLUS = "Protect+";
    /* access modifiers changed from: private */
    public static boolean isInG4ProtectRegion;
    private final int index;
    private final String name;

    public /* synthetic */ DeviceType(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    private DeviceType(int i, String str) {
        this.index = i;
        this.name = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Unknown;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Unknown extends DeviceType {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(-1, "Unknown", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Classic;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Classic extends DeviceType {
        public static final Classic INSTANCE = new Classic();

        private Classic() {
            super(0, "Classic", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$G4;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class G4 extends DeviceType {
        public static final G4 INSTANCE = new G4();

        private G4() {
            super(1, "G4", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Aware;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Aware extends DeviceType {
        public static final Aware INSTANCE = new Aware();

        private Aware() {
            super(2, "Aware", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Sense;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Sense extends DeviceType {
        public static final Sense INSTANCE = new Sense();

        private Sense() {
            super(3, "Sense+", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Icp;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Icp extends DeviceType {
        public static final Icp INSTANCE = new Icp();

        private Icp() {
            super(4, "Cabin Air P2i", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$ClassicWithoutSensor;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class ClassicWithoutSensor extends DeviceType {
        public static final ClassicWithoutSensor INSTANCE = new ClassicWithoutSensor();

        private ClassicWithoutSensor() {
            super(6, "Classic", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$B4;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class B4 extends DeviceType {
        public static final B4 INSTANCE = new B4();

        private B4() {
            super(7, "B4", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$B4sp;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class B4sp extends DeviceType {
        public static final B4sp INSTANCE = new B4sp();

        private B4sp() {
            super(8, "B4SP", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$BluePremium;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class BluePremium extends DeviceType {
        public static final BluePremium INSTANCE = new BluePremium();

        private BluePremium() {
            super(9, "NB", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Blue;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Blue extends DeviceType {
        public static final Blue INSTANCE = new Blue();

        private Blue() {
            super(10, "NB", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$NewClassic;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class NewClassic extends DeviceType {
        public static final NewClassic INSTANCE = new NewClassic();

        private NewClassic() {
            super(11, "NC", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Humidifier;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Humidifier extends DeviceType {
        public static final Humidifier INSTANCE = new Humidifier();

        private Humidifier() {
            super(12, "Humidifier", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Combo3in1;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Combo3in1 extends DeviceType {
        public static final Combo3in1 INSTANCE = new Combo3in1();

        private Combo3in1() {
            super(13, "Combo3in1", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Combo2in1;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Combo2in1 extends DeviceType {
        public static final Combo2in1 INSTANCE = new Combo2in1();

        private Combo2in1() {
            super(14, "Combo2in1", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Dehumidifier;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Dehumidifier extends DeviceType {
        public static final Dehumidifier INSTANCE = new Dehumidifier();

        private Dehumidifier() {
            super(15, "Dehumidifier", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Pet20;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Pet20 extends DeviceType {
        public static final Pet20 INSTANCE = new Pet20();

        private Pet20() {
            super(16, "pet20", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Blue40;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Blue40 extends DeviceType {
        public static final Blue40 INSTANCE = new Blue40();

        private Blue40() {
            super(17, "blue40", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Humidifier20;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Humidifier20 extends DeviceType {
        public static final Humidifier20 INSTANCE = new Humidifier20();

        private Humidifier20() {
            super(18, "Humidifier20", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$MiniRestful;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class MiniRestful extends DeviceType {
        public static final MiniRestful INSTANCE = new MiniRestful();

        private MiniRestful() {
            super(19, "mrest", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/DeviceType$Combo2in120;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Combo2in120 extends DeviceType {
        public static final Combo2in120 INSTANCE = new Combo2in120();

        private Combo2in120() {
            super(20, "cmb2in120", (DefaultConstructorMarker) null);
        }
    }

    public final boolean isNewPlatform() {
        return !SetsKt.setOf(Classic.INSTANCE, Aware.INSTANCE, Sense.INSTANCE, Icp.INSTANCE, ClassicWithoutSensor.INSTANCE).contains(this);
    }

    public final boolean hasSafetySwitch() {
        return SetsKt.setOf(G4.INSTANCE, Combo2in120.INSTANCE).contains(this);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\u0010\u0010 \u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u001c\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0012\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0012\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0012\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0010\u0010)\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0012\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050,¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.¨\u00065"}, d2 = {"Lcom/blueair/core/model/DeviceType$Companion;", "", "<init>", "()V", "HEALTH_PROTECT", "", "PROTECT", "PROTECT_PLUS", "DUST_MAGNET", "DUST_MAGNET_SP", "BLUE", "BLUE_PURE", "BLUE_PREMIUM", "isInG4ProtectRegion", "", "()Z", "setInG4ProtectRegion", "(Z)V", "fromIndex", "Lcom/blueair/core/model/DeviceType;", "input", "", "fromName", "fromSkuCompat", "skuCompat", "fromCompatibility", "fromSku", "modelNameFromSkuCompat", "modelNameFromCompatibility", "modelNameFromSku", "sku", "familyNameFromSku", "displayNameFromSkuCompat", "g4ModelNameFromSku", "useProtect", "g4ModelNumberFromModelName", "modelName", "g4ModelSeriesFromModelName", "b4ModelNameFromSku", "b4spModelNameFromSku", "blueFamilyNameFromSku", "isNb411iMax", "blueModelNameFromSku", "G4SP_SKU", "", "getG4SP_SKU", "()Ljava/util/Set;", "G4Plus_SKU", "getG4Plus_SKU", "G4Plus_HCHO_SKU", "getG4Plus_HCHO_SKU", "G4Plus_tVOC_SKU", "getG4Plus_tVOC_SKU", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isInG4ProtectRegion() {
            return DeviceType.isInG4ProtectRegion;
        }

        public final void setInG4ProtectRegion(boolean z) {
            DeviceType.isInG4ProtectRegion = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.core.model.DeviceType fromIndex(int r6) {
            /*
                r5 = this;
                java.lang.Class<com.blueair.core.model.DeviceType> r0 = com.blueair.core.model.DeviceType.class
                kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
                java.util.Collection r0 = r0.getNestedClasses()
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x001d:
                boolean r2 = r0.hasNext()
                r3 = 0
                if (r2 == 0) goto L_0x0039
                java.lang.Object r2 = r0.next()
                kotlin.reflect.KClass r2 = (kotlin.reflect.KClass) r2
                java.lang.Object r2 = r2.getObjectInstance()
                boolean r4 = r2 instanceof com.blueair.core.model.DeviceType
                if (r4 == 0) goto L_0x0035
                r3 = r2
                com.blueair.core.model.DeviceType r3 = (com.blueair.core.model.DeviceType) r3
            L_0x0035:
                r1.add(r3)
                goto L_0x001d
            L_0x0039:
                java.util.List r1 = (java.util.List) r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r0 = r1.iterator()
            L_0x0041:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0057
                java.lang.Object r1 = r0.next()
                r2 = r1
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                if (r2 == 0) goto L_0x0041
                int r2 = r2.getIndex()
                if (r2 != r6) goto L_0x0041
                r3 = r1
            L_0x0057:
                com.blueair.core.model.DeviceType r3 = (com.blueair.core.model.DeviceType) r3
                if (r3 != 0) goto L_0x0060
                com.blueair.core.model.DeviceType$Unknown r6 = com.blueair.core.model.DeviceType.Unknown.INSTANCE
                com.blueair.core.model.DeviceType r6 = (com.blueair.core.model.DeviceType) r6
                return r6
            L_0x0060:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceType.Companion.fromIndex(int):com.blueair.core.model.DeviceType");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.blueair.core.model.DeviceType} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.core.model.DeviceType fromName(java.lang.String r6) {
            /*
                r5 = this;
                java.lang.String r0 = "input"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "G4P"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x000f
                java.lang.String r6 = "G4"
            L_0x000f:
                java.lang.Class<com.blueair.core.model.DeviceType> r0 = com.blueair.core.model.DeviceType.class
                kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
                java.util.Collection r0 = r0.getNestedClasses()
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x002c:
                boolean r2 = r0.hasNext()
                r3 = 0
                if (r2 == 0) goto L_0x0048
                java.lang.Object r2 = r0.next()
                kotlin.reflect.KClass r2 = (kotlin.reflect.KClass) r2
                java.lang.Object r2 = r2.getObjectInstance()
                boolean r4 = r2 instanceof com.blueair.core.model.DeviceType
                if (r4 == 0) goto L_0x0044
                r3 = r2
                com.blueair.core.model.DeviceType r3 = (com.blueair.core.model.DeviceType) r3
            L_0x0044:
                r1.add(r3)
                goto L_0x002c
            L_0x0048:
                java.util.List r1 = (java.util.List) r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r0 = r1.iterator()
            L_0x0050:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x006c
                java.lang.Object r1 = r0.next()
                r2 = r1
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                if (r2 == 0) goto L_0x0064
                java.lang.String r2 = r2.getName()
                goto L_0x0065
            L_0x0064:
                r2 = r3
            L_0x0065:
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
                if (r2 == 0) goto L_0x0050
                r3 = r1
            L_0x006c:
                com.blueair.core.model.DeviceType r3 = (com.blueair.core.model.DeviceType) r3
                if (r3 != 0) goto L_0x0075
                com.blueair.core.model.DeviceType$Unknown r6 = com.blueair.core.model.DeviceType.Unknown.INSTANCE
                com.blueair.core.model.DeviceType r6 = (com.blueair.core.model.DeviceType) r6
                return r6
            L_0x0075:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceType.Companion.fromName(java.lang.String):com.blueair.core.model.DeviceType");
        }

        public final DeviceType fromSkuCompat(String str) {
            DeviceType type;
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return Unknown.INSTANCE;
            }
            DeviceConfig deviceConfig = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(str);
            if (deviceConfig != null && (type = deviceConfig.getType()) != null) {
                return type;
            }
            DeviceType fromSku = fromSku(str);
            if (fromSku != null) {
                return fromSku;
            }
            DeviceType fromCompatibility = fromCompatibility(str);
            return fromCompatibility == null ? Unknown.INSTANCE : fromCompatibility;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
            return com.blueair.core.model.DeviceType.Classic.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x010e, code lost:
            return com.blueair.core.model.DeviceType.ClassicWithoutSensor.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final com.blueair.core.model.DeviceType fromCompatibility(java.lang.String r2) {
            /*
                r1 = this;
                java.util.Locale r0 = java.util.Locale.ROOT
                java.lang.String r2 = r2.toLowerCase(r0)
                java.lang.String r0 = "toLowerCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                int r0 = r2.hashCode()
                switch(r0) {
                    case -905948611: goto L_0x010f;
                    case -138768246: goto L_0x0101;
                    case -138768065: goto L_0x00f8;
                    case -138767285: goto L_0x00ef;
                    case -138766324: goto L_0x00e6;
                    case -138766143: goto L_0x00dd;
                    case -138765363: goto L_0x00d4;
                    case -138764402: goto L_0x00cb;
                    case -138764221: goto L_0x00c2;
                    case -6848215: goto L_0x00b4;
                    case -6842614: goto L_0x00aa;
                    case -6840692: goto L_0x00a0;
                    case -6839731: goto L_0x0096;
                    case -6810901: goto L_0x008c;
                    case -6788633: goto L_0x0082;
                    case -6783032: goto L_0x0078;
                    case -6781110: goto L_0x006e;
                    case -6780149: goto L_0x0064;
                    case -6751319: goto L_0x005a;
                    case -6729051: goto L_0x0050;
                    case -6721528: goto L_0x0046;
                    case -6720567: goto L_0x003c;
                    case 93223518: goto L_0x002d;
                    case 853620882: goto L_0x0023;
                    case 1639265726: goto L_0x0014;
                    default: goto L_0x0012;
                }
            L_0x0012:
                goto L_0x011d
            L_0x0014:
                java.lang.String r0 = "icp_p2i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x001e
                goto L_0x011d
            L_0x001e:
                com.blueair.core.model.DeviceType$Icp r2 = com.blueair.core.model.DeviceType.Icp.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x0023:
                java.lang.String r0 = "classic"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x002d:
                java.lang.String r0 = "aware"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0037
                goto L_0x011d
            L_0x0037:
                com.blueair.core.model.DeviceType$Aware r2 = com.blueair.core.model.DeviceType.Aware.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x003c:
                java.lang.String r0 = "classic_690i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0046:
                java.lang.String r0 = "classic_680i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0050:
                java.lang.String r0 = "classic_605s"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x005a:
                java.lang.String r0 = "classic_580i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0064:
                java.lang.String r0 = "classic_490i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x006e:
                java.lang.String r0 = "classic_480i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0078:
                java.lang.String r0 = "classic_460i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0082:
                java.lang.String r0 = "classic_405s"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x008c:
                java.lang.String r0 = "classic_380i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x0096:
                java.lang.String r0 = "classic_290i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x00a0:
                java.lang.String r0 = "classic_280i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x00aa:
                java.lang.String r0 = "classic_260i"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x00b4:
                java.lang.String r0 = "classic_205s"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x00bd
                goto L_0x011d
            L_0x00bd:
                com.blueair.core.model.DeviceType$Classic r2 = com.blueair.core.model.DeviceType.Classic.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x00c2:
                java.lang.String r0 = "classic_660"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00cb:
                java.lang.String r0 = "classic_605"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00d4:
                java.lang.String r0 = "classic_505"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00dd:
                java.lang.String r0 = "classic_460"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00e6:
                java.lang.String r0 = "classic_405"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00ef:
                java.lang.String r0 = "classic_305"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x00f8:
                java.lang.String r0 = "classic_260"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x0101:
                java.lang.String r0 = "classic_205"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x010a
                goto L_0x011d
            L_0x010a:
                com.blueair.core.model.DeviceType$ClassicWithoutSensor r2 = com.blueair.core.model.DeviceType.ClassicWithoutSensor.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x010f:
                java.lang.String r0 = "sense+"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0118
                goto L_0x011d
            L_0x0118:
                com.blueair.core.model.DeviceType$Sense r2 = com.blueair.core.model.DeviceType.Sense.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x011d:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceType.Companion.fromCompatibility(java.lang.String):com.blueair.core.model.DeviceType");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:224:0x044c, code lost:
            return com.blueair.core.model.DeviceType.BluePremium.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x046f, code lost:
            return com.blueair.core.model.DeviceType.Blue.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:380:0x074e, code lost:
            return com.blueair.core.model.DeviceType.B4sp.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:554:0x0aa6, code lost:
            return com.blueair.core.model.DeviceType.G4.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:560:0x0abe, code lost:
            return com.blueair.core.model.DeviceType.B4.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final com.blueair.core.model.DeviceType fromSku(java.lang.String r2) {
            /*
                r1 = this;
                int r0 = r2.hashCode()
                switch(r0) {
                    case 1448760159: goto L_0x0ab0;
                    case 1448760223: goto L_0x0aa7;
                    case 1448762055: goto L_0x0a99;
                    case 1448762077: goto L_0x0a90;
                    case 1448762078: goto L_0x0a87;
                    case 1448762079: goto L_0x0a7e;
                    case 1448762080: goto L_0x0a75;
                    case 1448762081: goto L_0x0a6c;
                    case 1448762082: goto L_0x0a63;
                    case 1448762083: goto L_0x0a5a;
                    case 1448762084: goto L_0x0a51;
                    case 1448762085: goto L_0x0a47;
                    case 1448762086: goto L_0x0a3d;
                    case 1448786976: goto L_0x0a33;
                    case 1448788801: goto L_0x0a29;
                    case 1448790943: goto L_0x0a1f;
                    case 1448792652: goto L_0x0a15;
                    case 1448792705: goto L_0x0a0b;
                    case 1448792706: goto L_0x0a01;
                    case 1448792707: goto L_0x09f7;
                    case 1448792708: goto L_0x09ed;
                    case 1448792709: goto L_0x09e3;
                    case 1448792710: goto L_0x09d9;
                    case 1448792711: goto L_0x09cf;
                    case 1448792712: goto L_0x09c5;
                    case 1448792713: goto L_0x09bb;
                    case 1448792714: goto L_0x09b1;
                    case 1448792736: goto L_0x09a7;
                    case 1448792737: goto L_0x099d;
                    case 1448792738: goto L_0x0993;
                    case 1448792739: goto L_0x0989;
                    case 1448792740: goto L_0x097f;
                    case 1448792741: goto L_0x0975;
                    case 1448792742: goto L_0x096b;
                    case 1448792743: goto L_0x0961;
                    case 1448792744: goto L_0x0957;
                    case 1448792745: goto L_0x094d;
                    case 1448792767: goto L_0x0943;
                    case 1448792768: goto L_0x0939;
                    case 1448792769: goto L_0x092f;
                    case 1448792770: goto L_0x0925;
                    case 1448792771: goto L_0x091b;
                    case 1448792772: goto L_0x0911;
                    case 1448792773: goto L_0x0907;
                    case 1448814786: goto L_0x08fd;
                    case 1448814808: goto L_0x08f3;
                    case 1448814809: goto L_0x08e9;
                    case 1448814810: goto L_0x08df;
                    case 1448814811: goto L_0x08d5;
                    case 1448814812: goto L_0x08cb;
                    case 1448816860: goto L_0x08c1;
                    case 1448816861: goto L_0x08b7;
                    case 1448816862: goto L_0x08ad;
                    case 1448816863: goto L_0x08a3;
                    case 1448816891: goto L_0x0899;
                    case 1448816892: goto L_0x088f;
                    case 1448816917: goto L_0x0885;
                    case 1448816918: goto L_0x087b;
                    case 1448817722: goto L_0x0871;
                    case 1448817723: goto L_0x0867;
                    case 1448817724: goto L_0x085d;
                    case 1448817725: goto L_0x0853;
                    case 1448817726: goto L_0x0849;
                    case 1448817727: goto L_0x083f;
                    case 1448817753: goto L_0x0835;
                    case 1448817754: goto L_0x082b;
                    case 1448819769: goto L_0x0821;
                    case 1448819770: goto L_0x0817;
                    case 1448819773: goto L_0x080d;
                    case 1448819774: goto L_0x0803;
                    case 1448819833: goto L_0x07f9;
                    case 1448819839: goto L_0x07ef;
                    case 1448821659: goto L_0x07e5;
                    case 1448821660: goto L_0x07db;
                    case 1448821667: goto L_0x07d1;
                    case 1448821668: goto L_0x07c7;
                    case 1448821690: goto L_0x07bd;
                    case 1448821691: goto L_0x07b3;
                    case 1448821692: goto L_0x07a9;
                    case 1448821693: goto L_0x079f;
                    case 1448821694: goto L_0x0795;
                    case 1448821695: goto L_0x078b;
                    case 1448821696: goto L_0x0781;
                    case 1448821697: goto L_0x0777;
                    case 1448821698: goto L_0x076d;
                    case 1448821699: goto L_0x0763;
                    case 1448821721: goto L_0x0759;
                    case 1448821722: goto L_0x074f;
                    case 1448822468: goto L_0x0740;
                    case 1448822469: goto L_0x0736;
                    case 1448822470: goto L_0x072c;
                    case 1448822471: goto L_0x0722;
                    case 1448822472: goto L_0x0718;
                    case 1448822473: goto L_0x070e;
                    case 1448822560: goto L_0x0704;
                    case 1448822561: goto L_0x06fa;
                    case 1448822562: goto L_0x06f0;
                    case 1448822563: goto L_0x06e6;
                    case 1448822595: goto L_0x06dc;
                    case 1448822620: goto L_0x06d2;
                    case 1448822621: goto L_0x06c8;
                    case 1448843642: goto L_0x06be;
                    case 1448843643: goto L_0x06b4;
                    case 1448845532: goto L_0x06aa;
                    case 1448845533: goto L_0x06a0;
                    case 1448845534: goto L_0x0696;
                    case 1448845535: goto L_0x068c;
                    case 1448845536: goto L_0x0682;
                    case 1448845537: goto L_0x0678;
                    case 1448845655: goto L_0x066e;
                    case 1448845656: goto L_0x0664;
                    case 1448845657: goto L_0x065a;
                    case 1448845658: goto L_0x0650;
                    case 1448846654: goto L_0x0646;
                    case 1448846678: goto L_0x063c;
                    case 1448846682: goto L_0x0632;
                    case 1448846683: goto L_0x0628;
                    case 1448846684: goto L_0x061e;
                    case 1448846685: goto L_0x0614;
                    case 1448846707: goto L_0x060a;
                    case 1448846708: goto L_0x0600;
                    case 1448846709: goto L_0x05f6;
                    case 1448846710: goto L_0x05ec;
                    case 1448846711: goto L_0x05e2;
                    case 1448846712: goto L_0x05d8;
                    case 1448846713: goto L_0x05ce;
                    case 1448846715: goto L_0x05c4;
                    case 1448846716: goto L_0x05ba;
                    case 1448846738: goto L_0x05b0;
                    case 1448846739: goto L_0x05a6;
                    case 1448846740: goto L_0x059c;
                    case 1448846741: goto L_0x0592;
                    case 1448846742: goto L_0x0588;
                    case 1448846743: goto L_0x057e;
                    case 1448846745: goto L_0x0574;
                    case 1448846746: goto L_0x056a;
                    case 1448846747: goto L_0x0560;
                    case 1448847420: goto L_0x0556;
                    case 1448847421: goto L_0x054c;
                    case 1448847422: goto L_0x0542;
                    case 1448847423: goto L_0x0538;
                    case 1448847424: goto L_0x052e;
                    case 1448847425: goto L_0x0524;
                    case 1448847426: goto L_0x051a;
                    case 1448847427: goto L_0x0510;
                    case 1448847428: goto L_0x0506;
                    case 1448849444: goto L_0x04fc;
                    case 1448851267: goto L_0x04f2;
                    case 1448875544: goto L_0x04e8;
                    case 1448875545: goto L_0x04de;
                    case 1448876504: goto L_0x04d4;
                    case 1448877496: goto L_0x04ca;
                    case 1448877497: goto L_0x04c0;
                    case 1448877498: goto L_0x04b6;
                    case 1448877499: goto L_0x04ac;
                    case 1448878172: goto L_0x04a2;
                    case 1448878173: goto L_0x0498;
                    case 1448878176: goto L_0x048e;
                    case 1448878177: goto L_0x0484;
                    case 1448878273: goto L_0x047a;
                    case 1448880281: goto L_0x0470;
                    case 1448908064: goto L_0x0461;
                    case 1448908065: goto L_0x0457;
                    case 1448908122: goto L_0x044d;
                    case 1448908124: goto L_0x043e;
                    case 1448908214: goto L_0x0434;
                    case 1448908248: goto L_0x042a;
                    case 1448908933: goto L_0x0420;
                    case 1448911100: goto L_0x0416;
                    case 1449558654: goto L_0x040c;
                    case 1449558656: goto L_0x0402;
                    case 1449558657: goto L_0x03f8;
                    case 1449558658: goto L_0x03ee;
                    case 1449558722: goto L_0x03e4;
                    case 1449558723: goto L_0x03da;
                    case 1449558724: goto L_0x03d0;
                    case 1449558786: goto L_0x03c6;
                    case 1449558808: goto L_0x03bc;
                    case 1449558809: goto L_0x03b2;
                    case 1449558813: goto L_0x03a8;
                    case 1449558814: goto L_0x039e;
                    case 1449558816: goto L_0x0394;
                    case 1449558841: goto L_0x038a;
                    case 1449559683: goto L_0x0380;
                    case 1449559684: goto L_0x0376;
                    case 1449559685: goto L_0x036c;
                    case 1449559708: goto L_0x0362;
                    case 1449559709: goto L_0x0358;
                    case 1449559710: goto L_0x034e;
                    case 1449559740: goto L_0x0344;
                    case 1449559741: goto L_0x033a;
                    case 1449559743: goto L_0x0330;
                    case 1449559746: goto L_0x0326;
                    case 1449559747: goto L_0x031c;
                    case 1449561512: goto L_0x0312;
                    case 1449561661: goto L_0x0308;
                    case 1449561669: goto L_0x02fe;
                    case 1449562407: goto L_0x02f4;
                    case 1449562472: goto L_0x02ea;
                    case 1449562473: goto L_0x02e0;
                    case 1449562474: goto L_0x02d6;
                    case 1449562652: goto L_0x02cc;
                    case 1449562653: goto L_0x02c2;
                    case 1449562660: goto L_0x02b8;
                    case 1449562661: goto L_0x02ae;
                    case 1449563559: goto L_0x02a4;
                    case 1449563650: goto L_0x029a;
                    case 1449566319: goto L_0x0290;
                    case 1449566536: goto L_0x0286;
                    case 1449588508: goto L_0x027c;
                    case 1449588509: goto L_0x0272;
                    case 1449589537: goto L_0x0268;
                    case 1449589566: goto L_0x025e;
                    case 1449589567: goto L_0x0254;
                    case 1449589568: goto L_0x024a;
                    case 1449593406: goto L_0x0240;
                    case 1449597005: goto L_0x0236;
                    case 1449624008: goto L_0x022c;
                    case 1449653766: goto L_0x0222;
                    case 1449678720: goto L_0x0218;
                    default: goto L_0x0007;
                }
            L_0x0007:
                switch(r0) {
                    case 1448762108: goto L_0x020e;
                    case 1448762109: goto L_0x0204;
                    case 1448762110: goto L_0x01fa;
                    case 1448762111: goto L_0x01f0;
                    case 1448762112: goto L_0x01e6;
                    default: goto L_0x000a;
                }
            L_0x000a:
                switch(r0) {
                    case 1448784026: goto L_0x01dc;
                    case 1448784027: goto L_0x01d2;
                    case 1448784028: goto L_0x01c8;
                    default: goto L_0x000d;
                }
            L_0x000d:
                switch(r0) {
                    case 1448784153: goto L_0x01be;
                    case 1448784154: goto L_0x01b4;
                    case 1448784155: goto L_0x01aa;
                    default: goto L_0x0010;
                }
            L_0x0010:
                switch(r0) {
                    case 1448788803: goto L_0x01a0;
                    case 1448788804: goto L_0x0196;
                    default: goto L_0x0013;
                }
            L_0x0013:
                switch(r0) {
                    case 1448791720: goto L_0x018c;
                    case 1448791721: goto L_0x0182;
                    case 1448791722: goto L_0x0178;
                    default: goto L_0x0016;
                }
            L_0x0016:
                switch(r0) {
                    case 1448791744: goto L_0x016e;
                    case 1448791745: goto L_0x0164;
                    case 1448791746: goto L_0x015a;
                    case 1448791747: goto L_0x0150;
                    case 1448791748: goto L_0x0146;
                    case 1448791749: goto L_0x013c;
                    case 1448791750: goto L_0x0132;
                    case 1448791751: goto L_0x0128;
                    case 1448791752: goto L_0x011e;
                    case 1448791753: goto L_0x0114;
                    default: goto L_0x0019;
                }
            L_0x0019:
                switch(r0) {
                    case 1448791775: goto L_0x010a;
                    case 1448791776: goto L_0x0100;
                    case 1448791777: goto L_0x00f6;
                    case 1448791778: goto L_0x00ec;
                    case 1448791779: goto L_0x00e2;
                    case 1448791780: goto L_0x00d8;
                    case 1448791781: goto L_0x00ce;
                    case 1448791782: goto L_0x00c4;
                    case 1448791783: goto L_0x00ba;
                    case 1448791784: goto L_0x00b0;
                    default: goto L_0x001c;
                }
            L_0x001c:
                switch(r0) {
                    case 1448791806: goto L_0x00a6;
                    case 1448791807: goto L_0x009c;
                    case 1448791808: goto L_0x0092;
                    case 1448791809: goto L_0x0088;
                    default: goto L_0x001f;
                }
            L_0x001f:
                switch(r0) {
                    case 1448792674: goto L_0x007e;
                    case 1448792675: goto L_0x0074;
                    case 1448792676: goto L_0x006a;
                    case 1448792677: goto L_0x0060;
                    case 1448792678: goto L_0x0056;
                    case 1448792679: goto L_0x004c;
                    case 1448792680: goto L_0x0042;
                    case 1448792681: goto L_0x0038;
                    case 1448792682: goto L_0x002e;
                    case 1448792683: goto L_0x0024;
                    default: goto L_0x0022;
                }
            L_0x0022:
                goto L_0x0ab8
            L_0x0024:
                java.lang.String r0 = "105919"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x002e:
                java.lang.String r0 = "105918"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0038:
                java.lang.String r0 = "105917"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0042:
                java.lang.String r0 = "105916"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x004c:
                java.lang.String r0 = "105915"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0056:
                java.lang.String r0 = "105914"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0060:
                java.lang.String r0 = "105913"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x006a:
                java.lang.String r0 = "105912"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0074:
                java.lang.String r0 = "105911"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x007e:
                java.lang.String r0 = "105910"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0088:
                java.lang.String r0 = "105843"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0092:
                java.lang.String r0 = "105842"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x009c:
                java.lang.String r0 = "105841"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00a6:
                java.lang.String r0 = "105840"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00b0:
                java.lang.String r0 = "105839"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00ba:
                java.lang.String r0 = "105838"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00c4:
                java.lang.String r0 = "105837"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00ce:
                java.lang.String r0 = "105836"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00d8:
                java.lang.String r0 = "105835"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00e2:
                java.lang.String r0 = "105834"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00ec:
                java.lang.String r0 = "105833"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x00f6:
                java.lang.String r0 = "105832"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0100:
                java.lang.String r0 = "105831"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x010a:
                java.lang.String r0 = "105830"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0114:
                java.lang.String r0 = "105829"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x011e:
                java.lang.String r0 = "105828"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0128:
                java.lang.String r0 = "105827"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0132:
                java.lang.String r0 = "105826"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x013c:
                java.lang.String r0 = "105825"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0146:
                java.lang.String r0 = "105824"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0150:
                java.lang.String r0 = "105823"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x015a:
                java.lang.String r0 = "105822"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0164:
                java.lang.String r0 = "105821"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x016e:
                java.lang.String r0 = "105820"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0178:
                java.lang.String r0 = "105819"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0182:
                java.lang.String r0 = "105818"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x018c:
                java.lang.String r0 = "105817"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0196:
                java.lang.String r0 = "105505"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01a0:
                java.lang.String r0 = "105504"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01aa:
                java.lang.String r0 = "105056"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01b4:
                java.lang.String r0 = "105055"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01be:
                java.lang.String r0 = "105054"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01c8:
                java.lang.String r0 = "105013"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01d2:
                java.lang.String r0 = "105012"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01dc:
                java.lang.String r0 = "105011"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01e6:
                java.lang.String r0 = "104874"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01f0:
                java.lang.String r0 = "104873"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x01fa:
                java.lang.String r0 = "104872"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0204:
                java.lang.String r0 = "104871"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x020e:
                java.lang.String r0 = "104870"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0218:
                java.lang.String r0 = "114114"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0222:
                java.lang.String r0 = "113625"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x022c:
                java.lang.String r0 = "112637"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0236:
                java.lang.String r0 = "111905"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0240:
                java.lang.String r0 = "111582"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x024a:
                java.lang.String r0 = "111188"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0254:
                java.lang.String r0 = "111187"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x025e:
                java.lang.String r0 = "111186"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0268:
                java.lang.String r0 = "111178"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0272:
                java.lang.String r0 = "111053"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x027c:
                java.lang.String r0 = "111052"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0286:
                java.lang.String r0 = "110899"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0290:
                java.lang.String r0 = "110829"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x029a:
                java.lang.String r0 = "110596"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x02a4:
                java.lang.String r0 = "110568"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02ae:
                java.lang.String r0 = "110489"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02b8:
                java.lang.String r0 = "110488"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02c2:
                java.lang.String r0 = "110481"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02cc:
                java.lang.String r0 = "110480"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02d6:
                java.lang.String r0 = "110428"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02e0:
                java.lang.String r0 = "110427"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02ea:
                java.lang.String r0 = "110426"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02f4:
                java.lang.String r0 = "110403"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x02fe:
                java.lang.String r0 = "110379"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0308:
                java.lang.String r0 = "110371"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0312:
                java.lang.String r0 = "110327"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x031c:
                java.lang.String r0 = "110179"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0326:
                java.lang.String r0 = "110178"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0330:
                java.lang.String r0 = "110175"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x033a:
                java.lang.String r0 = "110173"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0344:
                java.lang.String r0 = "110172"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x034e:
                java.lang.String r0 = "110163"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0358:
                java.lang.String r0 = "110162"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0362:
                java.lang.String r0 = "110161"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x036c:
                java.lang.String r0 = "110159"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0376:
                java.lang.String r0 = "110158"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0380:
                java.lang.String r0 = "110157"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x038a:
                java.lang.String r0 = "110092"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0394:
                java.lang.String r0 = "110088"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x039e:
                java.lang.String r0 = "110086"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03a8:
                java.lang.String r0 = "110085"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03b2:
                java.lang.String r0 = "110081"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03bc:
                java.lang.String r0 = "110080"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03c6:
                java.lang.String r0 = "110079"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03d0:
                java.lang.String r0 = "110059"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x03da:
                java.lang.String r0 = "110058"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03e4:
                java.lang.String r0 = "110057"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x03ee:
                java.lang.String r0 = "110035"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x03f8:
                java.lang.String r0 = "110034"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0402:
                java.lang.String r0 = "110033"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x040c:
                java.lang.String r0 = "110031"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0416:
                java.lang.String r0 = "109886"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0420:
                java.lang.String r0 = "109609"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x042a:
                java.lang.String r0 = "109596"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0434:
                java.lang.String r0 = "109583"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x043e:
                java.lang.String r0 = "109556"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0448
                goto L_0x0ab8
            L_0x0448:
                com.blueair.core.model.DeviceType$BluePremium r2 = com.blueair.core.model.DeviceType.BluePremium.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x044d:
                java.lang.String r0 = "109554"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0457:
                java.lang.String r0 = "109539"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x0461:
                java.lang.String r0 = "109538"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x046b
                goto L_0x0ab8
            L_0x046b:
                com.blueair.core.model.DeviceType$Blue r2 = com.blueair.core.model.DeviceType.Blue.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x0470:
                java.lang.String r0 = "108761"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x047a:
                java.lang.String r0 = "108538"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0484:
                java.lang.String r0 = "108505"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x048e:
                java.lang.String r0 = "108504"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0498:
                java.lang.String r0 = "108501"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04a2:
                java.lang.String r0 = "108500"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04ac:
                java.lang.String r0 = "108499"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04b6:
                java.lang.String r0 = "108498"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04c0:
                java.lang.String r0 = "108497"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04ca:
                java.lang.String r0 = "108496"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04d4:
                java.lang.String r0 = "108386"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x04de:
                java.lang.String r0 = "108288"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04e8:
                java.lang.String r0 = "108287"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04f2:
                java.lang.String r0 = "107803"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x04fc:
                java.lang.String r0 = "107639"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0506:
                java.lang.String r0 = "107408"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0510:
                java.lang.String r0 = "107407"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x051a:
                java.lang.String r0 = "107406"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0524:
                java.lang.String r0 = "107405"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x052e:
                java.lang.String r0 = "107404"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0538:
                java.lang.String r0 = "107403"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0542:
                java.lang.String r0 = "107402"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x054c:
                java.lang.String r0 = "107401"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0556:
                java.lang.String r0 = "107400"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0560:
                java.lang.String r0 = "107399"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x056a:
                java.lang.String r0 = "107398"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0574:
                java.lang.String r0 = "107397"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x057e:
                java.lang.String r0 = "107395"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0588:
                java.lang.String r0 = "107394"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0592:
                java.lang.String r0 = "107393"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x059c:
                java.lang.String r0 = "107392"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05a6:
                java.lang.String r0 = "107391"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05b0:
                java.lang.String r0 = "107390"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05ba:
                java.lang.String r0 = "107389"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05c4:
                java.lang.String r0 = "107388"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05ce:
                java.lang.String r0 = "107386"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05d8:
                java.lang.String r0 = "107385"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05e2:
                java.lang.String r0 = "107384"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05ec:
                java.lang.String r0 = "107383"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x05f6:
                java.lang.String r0 = "107382"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0600:
                java.lang.String r0 = "107381"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x060a:
                java.lang.String r0 = "107380"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0614:
                java.lang.String r0 = "107379"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x061e:
                java.lang.String r0 = "107378"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0628:
                java.lang.String r0 = "107377"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0632:
                java.lang.String r0 = "107376"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x063c:
                java.lang.String r0 = "107372"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0646:
                java.lang.String r0 = "107369"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0650:
                java.lang.String r0 = "107255"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x065a:
                java.lang.String r0 = "107254"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0664:
                java.lang.String r0 = "107253"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x066e:
                java.lang.String r0 = "107252"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0678:
                java.lang.String r0 = "107218"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0682:
                java.lang.String r0 = "107217"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x068c:
                java.lang.String r0 = "107216"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0696:
                java.lang.String r0 = "107215"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x06a0:
                java.lang.String r0 = "107214"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x06aa:
                java.lang.String r0 = "107213"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x06b4:
                java.lang.String r0 = "107025"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x06be:
                java.lang.String r0 = "107024"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x06c8:
                java.lang.String r0 = "106961"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x06d2:
                java.lang.String r0 = "106960"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x06dc:
                java.lang.String r0 = "106956"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x06e6:
                java.lang.String r0 = "106945"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x06f0:
                java.lang.String r0 = "106944"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x06fa:
                java.lang.String r0 = "106943"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0704:
                java.lang.String r0 = "106942"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x070e:
                java.lang.String r0 = "106918"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0718:
                java.lang.String r0 = "106917"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0722:
                java.lang.String r0 = "106916"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x072c:
                java.lang.String r0 = "106915"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0736:
                java.lang.String r0 = "106914"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x0740:
                java.lang.String r0 = "106913"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x074a
                goto L_0x0ab8
            L_0x074a:
                com.blueair.core.model.DeviceType$B4sp r2 = com.blueair.core.model.DeviceType.B4sp.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x074f:
                java.lang.String r0 = "106881"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0759:
                java.lang.String r0 = "106880"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0763:
                java.lang.String r0 = "106879"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x076d:
                java.lang.String r0 = "106878"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0777:
                java.lang.String r0 = "106877"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0781:
                java.lang.String r0 = "106876"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x078b:
                java.lang.String r0 = "106875"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0795:
                java.lang.String r0 = "106874"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x079f:
                java.lang.String r0 = "106873"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07a9:
                java.lang.String r0 = "106872"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07b3:
                java.lang.String r0 = "106871"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07bd:
                java.lang.String r0 = "106870"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07c7:
                java.lang.String r0 = "106869"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07d1:
                java.lang.String r0 = "106868"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07db:
                java.lang.String r0 = "106861"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07e5:
                java.lang.String r0 = "106860"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x07ef:
                java.lang.String r0 = "106699"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x07f9:
                java.lang.String r0 = "106693"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0803:
                java.lang.String r0 = "106676"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x080d:
                java.lang.String r0 = "106675"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0817:
                java.lang.String r0 = "106672"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0821:
                java.lang.String r0 = "106671"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x082b:
                java.lang.String r0 = "106441"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0835:
                java.lang.String r0 = "106440"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x083f:
                java.lang.String r0 = "106435"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0849:
                java.lang.String r0 = "106434"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0853:
                java.lang.String r0 = "106433"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x085d:
                java.lang.String r0 = "106432"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0867:
                java.lang.String r0 = "106431"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0871:
                java.lang.String r0 = "106430"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x087b:
                java.lang.String r0 = "106382"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0885:
                java.lang.String r0 = "106381"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x088f:
                java.lang.String r0 = "106377"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0899:
                java.lang.String r0 = "106376"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08a3:
                java.lang.String r0 = "106369"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08ad:
                java.lang.String r0 = "106368"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08b7:
                java.lang.String r0 = "106367"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08c1:
                java.lang.String r0 = "106366"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08cb:
                java.lang.String r0 = "106124"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08d5:
                java.lang.String r0 = "106123"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08df:
                java.lang.String r0 = "106122"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08e9:
                java.lang.String r0 = "106121"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08f3:
                java.lang.String r0 = "106120"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x08fd:
                java.lang.String r0 = "106119"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0907:
                java.lang.String r0 = "105946"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0911:
                java.lang.String r0 = "105945"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x091b:
                java.lang.String r0 = "105944"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0925:
                java.lang.String r0 = "105943"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x092f:
                java.lang.String r0 = "105942"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0939:
                java.lang.String r0 = "105941"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0943:
                java.lang.String r0 = "105940"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x094d:
                java.lang.String r0 = "105939"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0957:
                java.lang.String r0 = "105938"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0961:
                java.lang.String r0 = "105937"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x096b:
                java.lang.String r0 = "105936"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0975:
                java.lang.String r0 = "105935"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x097f:
                java.lang.String r0 = "105934"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0989:
                java.lang.String r0 = "105933"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0993:
                java.lang.String r0 = "105932"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x099d:
                java.lang.String r0 = "105931"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09a7:
                java.lang.String r0 = "105930"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09b1:
                java.lang.String r0 = "105929"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09bb:
                java.lang.String r0 = "105928"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09c5:
                java.lang.String r0 = "105927"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09cf:
                java.lang.String r0 = "105926"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09d9:
                java.lang.String r0 = "105925"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09e3:
                java.lang.String r0 = "105924"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09ed:
                java.lang.String r0 = "105923"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x09f7:
                java.lang.String r0 = "105922"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a01:
                java.lang.String r0 = "105921"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a0b:
                java.lang.String r0 = "105920"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a15:
                java.lang.String r0 = "105909"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a1f:
                java.lang.String r0 = "105775"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a29:
                java.lang.String r0 = "105502"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a33:
                java.lang.String r0 = "105336"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0a3d:
                java.lang.String r0 = "104869"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a47:
                java.lang.String r0 = "104868"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a51:
                java.lang.String r0 = "104867"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a5a:
                java.lang.String r0 = "104866"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a63:
                java.lang.String r0 = "104865"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a6c:
                java.lang.String r0 = "104864"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a75:
                java.lang.String r0 = "104863"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a7e:
                java.lang.String r0 = "104862"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a87:
                java.lang.String r0 = "104861"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a90:
                java.lang.String r0 = "104860"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0a99:
                java.lang.String r0 = "104859"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aa2
                goto L_0x0ab8
            L_0x0aa2:
                com.blueair.core.model.DeviceType$G4 r2 = com.blueair.core.model.DeviceType.G4.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            L_0x0aa7:
                java.lang.String r0 = "104686"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
                goto L_0x0ab8
            L_0x0ab0:
                java.lang.String r0 = "104664"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0aba
            L_0x0ab8:
                r2 = 0
                return r2
            L_0x0aba:
                com.blueair.core.model.DeviceType$B4 r2 = com.blueair.core.model.DeviceType.B4.INSTANCE
                com.blueair.core.model.DeviceType r2 = (com.blueair.core.model.DeviceType) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceType.Companion.fromSku(java.lang.String):com.blueair.core.model.DeviceType");
        }

        public final String modelNameFromSkuCompat(String str) {
            I18nConfig modelName;
            String value$default;
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return Unknown.INSTANCE.getName();
            }
            DeviceConfig deviceConfig = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(str);
            if (deviceConfig != null && (modelName = deviceConfig.getModelName()) != null && (value$default = I18nConfig.getValue$default(modelName, (Locale) null, 1, (Object) null)) != null) {
                return value$default;
            }
            String modelNameFromSku = modelNameFromSku(str);
            if (modelNameFromSku != null) {
                return modelNameFromSku;
            }
            String modelNameFromCompatibility = modelNameFromCompatibility(str);
            return modelNameFromCompatibility == null ? Unknown.INSTANCE.getName() : modelNameFromCompatibility;
        }

        private final String modelNameFromCompatibility(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -905948611:
                    if (!lowerCase.equals("sense+")) {
                        return null;
                    }
                    return Sense.INSTANCE.getName();
                case -138768246:
                    if (!lowerCase.equals("classic_205")) {
                        return null;
                    }
                    return "Classic 205";
                case -138768065:
                    if (!lowerCase.equals("classic_260")) {
                        return null;
                    }
                    return "Classic 260";
                case -138767285:
                    if (!lowerCase.equals("classic_305")) {
                        return null;
                    }
                    return "Classic 305";
                case -138766324:
                    if (!lowerCase.equals("classic_405")) {
                        return null;
                    }
                    return "Classic 405";
                case -138766143:
                    if (!lowerCase.equals("classic_460")) {
                        return null;
                    }
                    return "Classic 460";
                case -138765363:
                    if (!lowerCase.equals("classic_505")) {
                        return null;
                    }
                    return "Classic 505";
                case -138765182:
                    if (!lowerCase.equals("classic_560")) {
                        return null;
                    }
                    return "Classic 560";
                case -138764402:
                    if (!lowerCase.equals("classic_605")) {
                        return null;
                    }
                    return "Classic 605";
                case -138764221:
                    if (!lowerCase.equals("classic_660")) {
                        return null;
                    }
                    return "Classic 660";
                case -6848215:
                    if (!lowerCase.equals("classic_205s")) {
                        return null;
                    }
                    return "Classic 205S";
                case -6842614:
                    if (!lowerCase.equals("classic_260i")) {
                        return null;
                    }
                    return "Classic 260i";
                case -6840692:
                    if (!lowerCase.equals("classic_280i")) {
                        return null;
                    }
                    return "Classic 280i";
                case -6839731:
                    if (!lowerCase.equals("classic_290i")) {
                        return null;
                    }
                    return "Classic 290i";
                case -6810901:
                    if (!lowerCase.equals("classic_380i")) {
                        return null;
                    }
                    return "Classic 380i";
                case -6788633:
                    if (!lowerCase.equals("classic_405s")) {
                        return null;
                    }
                    return "Classic 405S";
                case -6783032:
                    if (!lowerCase.equals("classic_460i")) {
                        return null;
                    }
                    return "Classic 460i";
                case -6781110:
                    if (!lowerCase.equals("classic_480i")) {
                        return null;
                    }
                    return "Classic 480i";
                case -6780149:
                    if (!lowerCase.equals("classic_490i")) {
                        return null;
                    }
                    return "Classic 490i";
                case -6751319:
                    if (!lowerCase.equals("classic_580i")) {
                        return null;
                    }
                    return "Classic 580i";
                case -6729051:
                    if (!lowerCase.equals("classic_605s")) {
                        return null;
                    }
                    return "Classic 605S";
                case -6721528:
                    if (!lowerCase.equals("classic_680i")) {
                        return null;
                    }
                    return "Classic 680i";
                case -6720567:
                    if (!lowerCase.equals("classic_690i")) {
                        return null;
                    }
                    return "Classic 690i";
                case 93223518:
                    if (!lowerCase.equals("aware")) {
                        return null;
                    }
                    return Aware.INSTANCE.getName();
                case 853620882:
                    if (!lowerCase.equals("classic")) {
                        return null;
                    }
                    return Classic.INSTANCE.getName();
                case 1639265726:
                    if (!lowerCase.equals(DeviceUtilsLegacy.DEVICE_COMPATIBILITY_STRING_ICP)) {
                        return null;
                    }
                    return Icp.INSTANCE.getName();
                default:
                    return null;
            }
        }

        private final String modelNameFromSku(String str) {
            DeviceType fromSku = fromSku(str);
            if (Intrinsics.areEqual((Object) fromSku, (Object) G4.INSTANCE)) {
                String g4ModelNameFromSku = g4ModelNameFromSku(str, isInG4ProtectRegion());
                if (g4ModelNameFromSku == null) {
                    return isInG4ProtectRegion() ? DeviceType.PROTECT : DeviceType.HEALTH_PROTECT;
                }
                return g4ModelNameFromSku;
            } else if (Intrinsics.areEqual((Object) fromSku, (Object) B4.INSTANCE)) {
                String b4ModelNameFromSku = b4ModelNameFromSku(str);
                return b4ModelNameFromSku == null ? DeviceType.DUST_MAGNET : b4ModelNameFromSku;
            } else if (Intrinsics.areEqual((Object) fromSku, (Object) B4sp.INSTANCE)) {
                String b4spModelNameFromSku = b4spModelNameFromSku(str);
                return b4spModelNameFromSku == null ? DeviceType.DUST_MAGNET_SP : b4spModelNameFromSku;
            } else if (Intrinsics.areEqual((Object) fromSku, (Object) Blue.INSTANCE)) {
                String blueModelNameFromSku = blueModelNameFromSku(str);
                return blueModelNameFromSku == null ? DeviceType.BLUE : blueModelNameFromSku;
            } else if (!Intrinsics.areEqual((Object) fromSku, (Object) BluePremium.INSTANCE)) {
                return null;
            } else {
                String blueModelNameFromSku2 = blueModelNameFromSku(str);
                return blueModelNameFromSku2 == null ? DeviceType.BLUE_PREMIUM : blueModelNameFromSku2;
            }
        }

        public final String familyNameFromSku(String str) {
            I18nConfig familyName;
            String value$default;
            Intrinsics.checkNotNullParameter(str, "sku");
            DeviceConfig deviceConfig = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(str);
            if (deviceConfig != null && (familyName = deviceConfig.getFamilyName()) != null && (value$default = I18nConfig.getValue$default(familyName, (Locale) null, 1, (Object) null)) != null) {
                return value$default;
            }
            DeviceType fromSku = fromSku(str);
            if (Intrinsics.areEqual((Object) fromSku, (Object) G4.INSTANCE)) {
                if (getG4Plus_SKU().contains(str)) {
                    return DeviceType.PROTECT_PLUS;
                }
                return isInG4ProtectRegion() ? DeviceType.PROTECT : DeviceType.HEALTH_PROTECT;
            } else if (Intrinsics.areEqual((Object) fromSku, (Object) B4.INSTANCE) || Intrinsics.areEqual((Object) fromSku, (Object) B4sp.INSTANCE)) {
                return DeviceType.DUST_MAGNET;
            } else {
                if (!Intrinsics.areEqual((Object) fromSku, (Object) Blue.INSTANCE) && !Intrinsics.areEqual((Object) fromSku, (Object) BluePremium.INSTANCE)) {
                    return Unknown.INSTANCE.getName();
                }
                String blueFamilyNameFromSku = blueFamilyNameFromSku(str);
                return blueFamilyNameFromSku == null ? DeviceType.BLUE : blueFamilyNameFromSku;
            }
        }

        public final String displayNameFromSkuCompat(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return Unknown.INSTANCE.getName();
            }
            String familyNameFromSku = familyNameFromSku(str);
            String modelNameFromSkuCompat = modelNameFromSkuCompat(str);
            if (Intrinsics.areEqual((Object) familyNameFromSku, (Object) Unknown.INSTANCE.getName()) || familyNameFromSku.length() == 0) {
                return modelNameFromSkuCompat;
            }
            CharSequence charSequence2 = modelNameFromSkuCompat;
            if (StringsKt.contains$default(charSequence2, (CharSequence) "PCBA", false, 2, (Object) null) || StringsKt.contains$default(charSequence2, (CharSequence) "Control Board", false, 2, (Object) null)) {
                return modelNameFromSkuCompat;
            }
            return familyNameFromSku + TokenParser.SP + modelNameFromSkuCompat;
        }

        public static /* synthetic */ String g4ModelNameFromSku$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.g4ModelNameFromSku(str, z);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:314:0x060e, code lost:
            return r5;
         */
        /* JADX WARNING: Removed duplicated region for block: B:341:0x0699 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String g4ModelNameFromSku(java.lang.String r4, boolean r5) {
            /*
                r3 = this;
                if (r5 == 0) goto L_0x0005
                java.lang.String r5 = "Protect"
                goto L_0x0007
            L_0x0005:
                java.lang.String r5 = "HealthProtect"
            L_0x0007:
                r0 = 0
                if (r4 == 0) goto L_0x001b
                java.util.Locale r1 = java.util.Locale.UK
                java.lang.String r2 = "UK"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                java.lang.String r4 = r4.toLowerCase(r1)
                java.lang.String r1 = "toLowerCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
                goto L_0x001c
            L_0x001b:
                r4 = r0
            L_0x001c:
                if (r4 == 0) goto L_0x0699
                int r1 = r4.hashCode()
                switch(r1) {
                    case 1448762055: goto L_0x068d;
                    case 1448762077: goto L_0x0684;
                    case 1448762078: goto L_0x0678;
                    case 1448762079: goto L_0x066f;
                    case 1448762080: goto L_0x0663;
                    case 1448762081: goto L_0x065a;
                    case 1448762082: goto L_0x064e;
                    case 1448762083: goto L_0x0645;
                    case 1448762084: goto L_0x0639;
                    case 1448762085: goto L_0x0630;
                    case 1448762086: goto L_0x0623;
                    case 1448788801: goto L_0x0619;
                    case 1448814786: goto L_0x060f;
                    case 1448816860: goto L_0x0604;
                    case 1448816861: goto L_0x05fa;
                    case 1448816862: goto L_0x05f0;
                    case 1448816863: goto L_0x05e6;
                    case 1448816891: goto L_0x05dc;
                    case 1448816892: goto L_0x05d2;
                    case 1448816917: goto L_0x05c8;
                    case 1448816918: goto L_0x05be;
                    case 1448817722: goto L_0x05b4;
                    case 1448817723: goto L_0x05aa;
                    case 1448817724: goto L_0x05a0;
                    case 1448817725: goto L_0x0596;
                    case 1448817726: goto L_0x058c;
                    case 1448817727: goto L_0x0582;
                    case 1448817753: goto L_0x0578;
                    case 1448817754: goto L_0x056e;
                    case 1448821659: goto L_0x0561;
                    case 1448821660: goto L_0x0554;
                    case 1448821667: goto L_0x054a;
                    case 1448821668: goto L_0x0540;
                    case 1448821690: goto L_0x0536;
                    case 1448821691: goto L_0x052c;
                    case 1448821692: goto L_0x0522;
                    case 1448821693: goto L_0x0518;
                    case 1448821694: goto L_0x050e;
                    case 1448821695: goto L_0x0504;
                    case 1448821696: goto L_0x04fa;
                    case 1448821697: goto L_0x04f0;
                    case 1448821698: goto L_0x04e6;
                    case 1448821699: goto L_0x04dc;
                    case 1448821721: goto L_0x04d2;
                    case 1448821722: goto L_0x04c8;
                    case 1448822595: goto L_0x04bb;
                    case 1448822620: goto L_0x04b1;
                    case 1448822621: goto L_0x04a7;
                    case 1448843642: goto L_0x049a;
                    case 1448843643: goto L_0x048d;
                    case 1448845655: goto L_0x0483;
                    case 1448845656: goto L_0x0479;
                    case 1448845657: goto L_0x046f;
                    case 1448845658: goto L_0x0465;
                    case 1448846654: goto L_0x045b;
                    case 1448846678: goto L_0x0451;
                    case 1448846682: goto L_0x0447;
                    case 1448846683: goto L_0x043d;
                    case 1448846684: goto L_0x0433;
                    case 1448846685: goto L_0x0429;
                    case 1448846707: goto L_0x041f;
                    case 1448846708: goto L_0x0415;
                    case 1448846709: goto L_0x040b;
                    case 1448846710: goto L_0x0401;
                    case 1448846711: goto L_0x03f7;
                    case 1448846712: goto L_0x03ed;
                    case 1448846713: goto L_0x03e3;
                    case 1448846715: goto L_0x03d9;
                    case 1448846716: goto L_0x03cc;
                    case 1448846738: goto L_0x03c2;
                    case 1448846739: goto L_0x03b8;
                    case 1448846740: goto L_0x03ae;
                    case 1448846741: goto L_0x03a4;
                    case 1448846742: goto L_0x039a;
                    case 1448846743: goto L_0x0390;
                    case 1448846745: goto L_0x0386;
                    case 1448846746: goto L_0x037c;
                    case 1448846747: goto L_0x0372;
                    case 1448847420: goto L_0x0368;
                    case 1448847421: goto L_0x035e;
                    case 1448847422: goto L_0x0354;
                    case 1448847423: goto L_0x0347;
                    case 1448847424: goto L_0x033d;
                    case 1448847425: goto L_0x0333;
                    case 1448847426: goto L_0x0329;
                    case 1448847427: goto L_0x031f;
                    case 1448847428: goto L_0x0315;
                    case 1448849444: goto L_0x030b;
                    case 1448851267: goto L_0x0301;
                    case 1448875544: goto L_0x02f7;
                    case 1448875545: goto L_0x02ea;
                    case 1448877496: goto L_0x02e0;
                    case 1448877497: goto L_0x02d6;
                    case 1448877498: goto L_0x02cc;
                    case 1448877499: goto L_0x02c2;
                    case 1448878172: goto L_0x02b8;
                    case 1448878173: goto L_0x02ae;
                    case 1448878176: goto L_0x02a4;
                    case 1448878177: goto L_0x029a;
                    case 1448878273: goto L_0x0290;
                    case 1449561661: goto L_0x0283;
                    case 1449561669: goto L_0x0276;
                    case 1449562407: goto L_0x0269;
                    case 1449562472: goto L_0x025c;
                    case 1449562473: goto L_0x024f;
                    case 1449562474: goto L_0x0242;
                    case 1449562652: goto L_0x0235;
                    case 1449562653: goto L_0x022b;
                    case 1449562660: goto L_0x021e;
                    case 1449562661: goto L_0x0211;
                    case 1449563559: goto L_0x0204;
                    default: goto L_0x0025;
                }
            L_0x0025:
                switch(r1) {
                    case 1448762108: goto L_0x01fa;
                    case 1448762109: goto L_0x01f0;
                    case 1448762110: goto L_0x01e6;
                    case 1448762111: goto L_0x01dc;
                    case 1448762112: goto L_0x01d2;
                    default: goto L_0x0028;
                }
            L_0x0028:
                switch(r1) {
                    case 1448784026: goto L_0x01c8;
                    case 1448784027: goto L_0x01be;
                    case 1448784028: goto L_0x01b4;
                    default: goto L_0x002b;
                }
            L_0x002b:
                switch(r1) {
                    case 1448784153: goto L_0x01aa;
                    case 1448784154: goto L_0x01a0;
                    case 1448784155: goto L_0x0196;
                    default: goto L_0x002e;
                }
            L_0x002e:
                switch(r1) {
                    case 1448788803: goto L_0x018c;
                    case 1448788804: goto L_0x0182;
                    default: goto L_0x0031;
                }
            L_0x0031:
                switch(r1) {
                    case 1448791720: goto L_0x0178;
                    case 1448791721: goto L_0x016e;
                    case 1448791722: goto L_0x0164;
                    default: goto L_0x0034;
                }
            L_0x0034:
                switch(r1) {
                    case 1448791744: goto L_0x015a;
                    case 1448791745: goto L_0x0150;
                    case 1448791746: goto L_0x0146;
                    case 1448791747: goto L_0x013c;
                    case 1448791748: goto L_0x0132;
                    case 1448791749: goto L_0x0128;
                    case 1448791750: goto L_0x011e;
                    case 1448791751: goto L_0x0114;
                    case 1448791752: goto L_0x010a;
                    case 1448791753: goto L_0x0100;
                    default: goto L_0x0037;
                }
            L_0x0037:
                switch(r1) {
                    case 1448791775: goto L_0x00f6;
                    case 1448791776: goto L_0x00ec;
                    case 1448791777: goto L_0x00e2;
                    case 1448791778: goto L_0x00d8;
                    case 1448791779: goto L_0x00ce;
                    case 1448791780: goto L_0x00c4;
                    case 1448791781: goto L_0x00ba;
                    case 1448791782: goto L_0x00b0;
                    case 1448791783: goto L_0x00a6;
                    case 1448791784: goto L_0x009c;
                    default: goto L_0x003a;
                }
            L_0x003a:
                switch(r1) {
                    case 1448791806: goto L_0x0092;
                    case 1448791807: goto L_0x0088;
                    case 1448791808: goto L_0x007e;
                    case 1448791809: goto L_0x0074;
                    default: goto L_0x003d;
                }
            L_0x003d:
                switch(r1) {
                    case 1448814808: goto L_0x006a;
                    case 1448814809: goto L_0x0060;
                    case 1448814810: goto L_0x0056;
                    case 1448814811: goto L_0x004c;
                    case 1448814812: goto L_0x0042;
                    default: goto L_0x0040;
                }
            L_0x0040:
                goto L_0x0699
            L_0x0042:
                java.lang.String r5 = "106124"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x004c:
                java.lang.String r5 = "106123"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x0056:
                java.lang.String r5 = "106122"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x0060:
                java.lang.String r5 = "106121"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x006a:
                java.lang.String r5 = "106120"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0074:
                java.lang.String r5 = "105843"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x007e:
                java.lang.String r5 = "105842"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x0088:
                java.lang.String r5 = "105841"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x0092:
                java.lang.String r5 = "105840"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x009c:
                java.lang.String r5 = "105839"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x00a6:
                java.lang.String r5 = "105838"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x00b0:
                java.lang.String r5 = "105837"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x00ba:
                java.lang.String r5 = "105836"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x00c4:
                java.lang.String r5 = "105835"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x00ce:
                java.lang.String r5 = "105834"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x00d8:
                java.lang.String r5 = "105833"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x00e2:
                java.lang.String r5 = "105832"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x00ec:
                java.lang.String r5 = "105831"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x00f6:
                java.lang.String r5 = "105830"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x0100:
                java.lang.String r5 = "105829"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x010a:
                java.lang.String r5 = "105828"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x0114:
                java.lang.String r5 = "105827"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x011e:
                java.lang.String r5 = "105826"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x0128:
                java.lang.String r5 = "105825"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x0132:
                java.lang.String r5 = "105824"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x013c:
                java.lang.String r5 = "105823"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0146:
                java.lang.String r5 = "105822"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0150:
                java.lang.String r5 = "105821"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x015a:
                java.lang.String r5 = "105820"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0164:
                java.lang.String r5 = "105819"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x016e:
                java.lang.String r5 = "105818"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x0178:
                java.lang.String r5 = "105817"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x0182:
                java.lang.String r5 = "105505"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x018c:
                java.lang.String r5 = "105504"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0196:
                java.lang.String r5 = "105056"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x01a0:
                java.lang.String r5 = "105055"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x01aa:
                java.lang.String r5 = "105054"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x01b4:
                java.lang.String r5 = "105013"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x01be:
                java.lang.String r5 = "105012"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x01c8:
                java.lang.String r5 = "105011"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x01d2:
                java.lang.String r5 = "104874"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x01dc:
                java.lang.String r5 = "104873"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x01e6:
                java.lang.String r5 = "104872"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x01f0:
                java.lang.String r5 = "104871"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x01fa:
                java.lang.String r5 = "104870"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x0204:
                java.lang.String r5 = "110568"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x020e
                goto L_0x0699
            L_0x020e:
                java.lang.String r4 = "8440i"
                return r4
            L_0x0211:
                java.lang.String r5 = "110489"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x021b
                goto L_0x0699
            L_0x021b:
                java.lang.String r4 = "8460i/8660i"
                return r4
            L_0x021e:
                java.lang.String r5 = "110488"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0228
                goto L_0x0699
            L_0x0228:
                java.lang.String r4 = "8440i/8640i"
                return r4
            L_0x022b:
                java.lang.String r5 = "110481"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0259
                goto L_0x0699
            L_0x0235:
                java.lang.String r5 = "110480"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x023f
                goto L_0x0699
            L_0x023f:
                java.lang.String r4 = "8860i/8880i"
                return r4
            L_0x0242:
                java.lang.String r5 = "110428"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x024c
                goto L_0x0699
            L_0x024c:
                java.lang.String r4 = "8860i"
                return r4
            L_0x024f:
                java.lang.String r5 = "110427"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0259
                goto L_0x0699
            L_0x0259:
                java.lang.String r4 = "8840i"
                return r4
            L_0x025c:
                java.lang.String r5 = "110426"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0266
                goto L_0x0699
            L_0x0266:
                java.lang.String r4 = "8640i"
                return r4
            L_0x0269:
                java.lang.String r5 = "110403"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0273
                goto L_0x0699
            L_0x0273:
                java.lang.String r4 = "8660i"
                return r4
            L_0x0276:
                java.lang.String r5 = "110379"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0280
                goto L_0x0699
            L_0x0280:
                java.lang.String r4 = "8880i"
                return r4
            L_0x0283:
                java.lang.String r5 = "110371"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x028d
                goto L_0x0699
            L_0x028d:
                java.lang.String r4 = "8460i"
                return r4
            L_0x0290:
                java.lang.String r1 = "108538"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x029a:
                java.lang.String r1 = "108505"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02a4:
                java.lang.String r1 = "108504"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02ae:
                java.lang.String r1 = "108501"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02b8:
                java.lang.String r1 = "108500"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02c2:
                java.lang.String r1 = "108499"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02cc:
                java.lang.String r1 = "108498"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x02d6:
                java.lang.String r5 = "108497"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x02e0:
                java.lang.String r5 = "108496"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x02ea:
                java.lang.String r5 = "108288"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x02f4
                goto L_0x0699
            L_0x02f4:
                java.lang.String r4 = "7770i"
                return r4
            L_0x02f7:
                java.lang.String r5 = "108287"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x0301:
                java.lang.String r1 = "107803"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x030b:
                java.lang.String r5 = "107639"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x0315:
                java.lang.String r5 = "107408"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x031f:
                java.lang.String r5 = "107407"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x0329:
                java.lang.String r5 = "107406"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x0333:
                java.lang.String r5 = "107405"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x033d:
                java.lang.String r5 = "107404"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x0347:
                java.lang.String r5 = "107403"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0351
                goto L_0x0699
            L_0x0351:
                java.lang.String r4 = "7775i"
                return r4
            L_0x0354:
                java.lang.String r5 = "107402"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x035e:
                java.lang.String r5 = "107401"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x0368:
                java.lang.String r5 = "107400"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x0372:
                java.lang.String r5 = "107399"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x037c:
                java.lang.String r5 = "107398"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x0386:
                java.lang.String r5 = "107397"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x0390:
                java.lang.String r5 = "107395"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x039a:
                java.lang.String r5 = "107394"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03a4:
                java.lang.String r5 = "107393"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03ae:
                java.lang.String r5 = "107392"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03b8:
                java.lang.String r5 = "107391"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03c2:
                java.lang.String r5 = "107390"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03cc:
                java.lang.String r5 = "107389"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x03d6
                goto L_0x0699
            L_0x03d6:
                java.lang.String r4 = "7370i"
                return r4
            L_0x03d9:
                java.lang.String r5 = "107388"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x03e3:
                java.lang.String r5 = "107386"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x03ed:
                java.lang.String r5 = "107385"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x03f7:
                java.lang.String r5 = "107384"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x0401:
                java.lang.String r5 = "107383"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x040b:
                java.lang.String r5 = "107382"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x0415:
                java.lang.String r5 = "107381"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x041f:
                java.lang.String r5 = "107380"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x0429:
                java.lang.String r5 = "107379"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x0433:
                java.lang.String r5 = "107378"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x043d:
                java.lang.String r5 = "107377"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x0447:
                java.lang.String r5 = "107376"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x0451:
                java.lang.String r5 = "107372"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x045b:
                java.lang.String r5 = "107369"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x0465:
                java.lang.String r5 = "107255"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x046f:
                java.lang.String r5 = "107254"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x0479:
                java.lang.String r5 = "107253"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x0483:
                java.lang.String r5 = "107252"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x048d:
                java.lang.String r5 = "107025"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0497
                goto L_0x0699
            L_0x0497:
                java.lang.String r4 = "7340i"
                return r4
            L_0x049a:
                java.lang.String r5 = "107024"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04a4
                goto L_0x0699
            L_0x04a4:
                java.lang.String r4 = "7310i"
                return r4
            L_0x04a7:
                java.lang.String r5 = "106961"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x04b1:
                java.lang.String r5 = "106960"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x04bb:
                java.lang.String r5 = "106956"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x04c5
                goto L_0x0699
            L_0x04c5:
                java.lang.String r4 = "7570i"
                return r4
            L_0x04c8:
                java.lang.String r5 = "106881"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x04d2:
                java.lang.String r5 = "106880"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x04dc:
                java.lang.String r5 = "106879"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x04e6:
                java.lang.String r5 = "106878"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x04f0:
                java.lang.String r5 = "106877"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x04fa:
                java.lang.String r5 = "106876"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x0504:
                java.lang.String r5 = "106875"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x050e:
                java.lang.String r5 = "106874"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x0518:
                java.lang.String r5 = "106873"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x0522:
                java.lang.String r5 = "106872"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x052c:
                java.lang.String r5 = "106871"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x0536:
                java.lang.String r5 = "106870"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x0540:
                java.lang.String r5 = "106869"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x054a:
                java.lang.String r5 = "106868"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x0554:
                java.lang.String r5 = "106861"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x055e
                goto L_0x0699
            L_0x055e:
                java.lang.String r4 = "7540i"
                return r4
            L_0x0561:
                java.lang.String r5 = "106860"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x056b
                goto L_0x0699
            L_0x056b:
                java.lang.String r4 = "7510i"
                return r4
            L_0x056e:
                java.lang.String r1 = "106441"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x0578:
                java.lang.String r1 = "106440"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x0582:
                java.lang.String r1 = "106435"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x058c:
                java.lang.String r1 = "106434"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x0596:
                java.lang.String r1 = "106433"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05a0:
                java.lang.String r1 = "106432"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05aa:
                java.lang.String r1 = "106431"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05b4:
                java.lang.String r1 = "106430"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05be:
                java.lang.String r1 = "106382"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05c8:
                java.lang.String r1 = "106381"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05d2:
                java.lang.String r1 = "106377"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05dc:
                java.lang.String r1 = "106376"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05e6:
                java.lang.String r1 = "106369"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05f0:
                java.lang.String r1 = "106368"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x05fa:
                java.lang.String r1 = "106367"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x0604:
                java.lang.String r1 = "106366"
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x060e
                goto L_0x0699
            L_0x060e:
                return r5
            L_0x060f:
                java.lang.String r5 = "106119"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x0619:
                java.lang.String r5 = "105502"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x0623:
                java.lang.String r5 = "104869"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x062d
                goto L_0x0699
            L_0x062d:
                java.lang.String r4 = "7740i"
                return r4
            L_0x0630:
                java.lang.String r5 = "104868"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x0639:
                java.lang.String r5 = "104867"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0642
                goto L_0x0699
            L_0x0642:
                java.lang.String r4 = "7710i"
                return r4
            L_0x0645:
                java.lang.String r5 = "104866"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x064e:
                java.lang.String r5 = "104865"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0657
                goto L_0x0699
            L_0x0657:
                java.lang.String r4 = "7475i"
                return r4
            L_0x065a:
                java.lang.String r5 = "104864"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x0663:
                java.lang.String r5 = "104863"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x066c
                goto L_0x0699
            L_0x066c:
                java.lang.String r4 = "7470i"
                return r4
            L_0x066f:
                java.lang.String r5 = "104862"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0678:
                java.lang.String r5 = "104861"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0681
                goto L_0x0699
            L_0x0681:
                java.lang.String r4 = "7440i"
                return r4
            L_0x0684:
                java.lang.String r5 = "104860"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x068d:
                java.lang.String r5 = "104859"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0696
                goto L_0x0699
            L_0x0696:
                java.lang.String r4 = "7410i"
                return r4
            L_0x0699:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceType.Companion.g4ModelNameFromSku(java.lang.String, boolean):java.lang.String");
        }

        public final String g4ModelNumberFromModelName(String str) {
            Intrinsics.checkNotNullParameter(str, "modelName");
            return StringsKt.takeLast(StringsKt.trimEnd(str, TokenParser.SP, 'i', 'F'), 4);
        }

        public final String g4ModelSeriesFromModelName(String str) {
            Intrinsics.checkNotNullParameter(str, "modelName");
            return StringsKt.dropLast(g4ModelNumberFromModelName(str), 2);
        }

        public final String b4ModelNameFromSku(String str) {
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            switch (hashCode) {
                case 1448760159:
                    if (!str.equals("104664")) {
                        return null;
                    }
                    return "5410i";
                case 1448760223:
                    if (!str.equals("104686")) {
                        return null;
                    }
                    return "5410i";
                case 1448786976:
                    if (!str.equals("105336")) {
                        return null;
                    }
                    return "5440i";
                case 1448790943:
                    if (!str.equals("105775")) {
                        return null;
                    }
                    return "5210i";
                case 1448792652:
                    if (!str.equals("105909")) {
                        return null;
                    }
                    return "5210i";
                case 1448819833:
                    if (!str.equals("106693")) {
                        return null;
                    }
                    return DeviceType.DUST_MAGNET;
                case 1448819839:
                    if (!str.equals("106699")) {
                        return null;
                    }
                    return DeviceType.DUST_MAGNET;
                case 1448876504:
                    if (!str.equals("108386")) {
                        return null;
                    }
                    return DeviceType.DUST_MAGNET;
                default:
                    switch (hashCode) {
                        case 1448792674:
                            if (!str.equals("105910")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792675:
                            if (!str.equals("105911")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792676:
                            if (!str.equals("105912")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792677:
                            if (!str.equals("105913")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792678:
                            if (!str.equals("105914")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792679:
                            if (!str.equals("105915")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792680:
                            if (!str.equals("105916")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792681:
                            if (!str.equals("105917")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792682:
                            if (!str.equals("105918")) {
                                return null;
                            }
                            return "5210i";
                        case 1448792683:
                            if (!str.equals("105919")) {
                                return null;
                            }
                            return "5240i";
                        default:
                            switch (hashCode) {
                                case 1448792705:
                                    if (!str.equals("105920")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792706:
                                    if (!str.equals("105921")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792707:
                                    if (!str.equals("105922")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792708:
                                    if (!str.equals("105923")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792709:
                                    if (!str.equals("105924")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792710:
                                    if (!str.equals("105925")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792711:
                                    if (!str.equals("105926")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792712:
                                    if (!str.equals("105927")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792713:
                                    if (!str.equals("105928")) {
                                        return null;
                                    }
                                    return "5240i";
                                case 1448792714:
                                    if (!str.equals("105929")) {
                                        return null;
                                    }
                                    return "5410i";
                                default:
                                    switch (hashCode) {
                                        case 1448792736:
                                            if (!str.equals("105930")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792737:
                                            if (!str.equals("105931")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792738:
                                            if (!str.equals("105932")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792739:
                                            if (!str.equals("105933")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792740:
                                            if (!str.equals("105934")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792741:
                                            if (str.equals("105935")) {
                                                return "5410i";
                                            }
                                            return null;
                                        case 1448792742:
                                            if (!str.equals("105936")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792743:
                                            if (!str.equals("105937")) {
                                                return null;
                                            }
                                            return "5410i";
                                        case 1448792744:
                                            if (!str.equals("105938")) {
                                                return null;
                                            }
                                            return "5440i";
                                        case 1448792745:
                                            if (!str.equals("105939")) {
                                                return null;
                                            }
                                            return "5440i";
                                        default:
                                            switch (hashCode) {
                                                case 1448792767:
                                                    if (!str.equals("105940")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792768:
                                                    if (!str.equals("105941")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792769:
                                                    if (!str.equals("105942")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792770:
                                                    if (!str.equals("105943")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792771:
                                                    if (!str.equals("105944")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792772:
                                                    if (!str.equals("105945")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                case 1448792773:
                                                    if (!str.equals("105946")) {
                                                        return null;
                                                    }
                                                    return "5440i";
                                                default:
                                                    switch (hashCode) {
                                                        case 1448819769:
                                                            if (!str.equals("106671")) {
                                                                return null;
                                                            }
                                                            return DeviceType.DUST_MAGNET;
                                                        case 1448819770:
                                                            if (!str.equals("106672")) {
                                                                return null;
                                                            }
                                                            return DeviceType.DUST_MAGNET;
                                                        default:
                                                            switch (hashCode) {
                                                                case 1448819773:
                                                                    if (!str.equals("106675")) {
                                                                        return null;
                                                                    }
                                                                    return DeviceType.DUST_MAGNET;
                                                                case 1448819774:
                                                                    if (!str.equals("106676")) {
                                                                        return null;
                                                                    }
                                                                    return DeviceType.DUST_MAGNET;
                                                                default:
                                                                    switch (hashCode) {
                                                                        case 1448822560:
                                                                            if (!str.equals("106942")) {
                                                                                return null;
                                                                            }
                                                                            return "5415i";
                                                                        case 1448822561:
                                                                            if (!str.equals("106943")) {
                                                                                return null;
                                                                            }
                                                                            return "5410i";
                                                                        default:
                                                                            switch (hashCode) {
                                                                                case 1449588508:
                                                                                    if (!str.equals("111052")) {
                                                                                        return null;
                                                                                    }
                                                                                    return "5240i";
                                                                                case 1449588509:
                                                                                    if (!str.equals("111053")) {
                                                                                        return null;
                                                                                    }
                                                                                    return "5440i";
                                                                                default:
                                                                                    return null;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }

        public final String b4spModelNameFromSku(String str) {
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            if (hashCode != 1448880281) {
                switch (hashCode) {
                    case 1448822468:
                        if (str.equals("106913")) {
                            return "DustMagnet Super Premium 5470i";
                        }
                        return null;
                    case 1448822469:
                        if (!str.equals("106914")) {
                            return null;
                        }
                        return "DustMagnet Super Premium 5475i";
                    case 1448822470:
                        if (!str.equals("106915")) {
                            return null;
                        }
                        return "DustMagnet Super Premium 5470i";
                    case 1448822471:
                        if (!str.equals("106916")) {
                            return null;
                        }
                        return "DustMagnet Super Premium 5475i";
                    case 1448822472:
                        if (!str.equals("106917")) {
                            return null;
                        }
                        return "DustMagnet Super Premium 5470i";
                    case 1448822473:
                        if (!str.equals("106918")) {
                            return null;
                        }
                        return "DustMagnet Super Premium 5475i";
                    default:
                        switch (hashCode) {
                            case 1448822562:
                                if (!str.equals("106944")) {
                                    return null;
                                }
                                return "DustMagnet Super Premium 5470i";
                            case 1448822563:
                                if (!str.equals("106945")) {
                                    return null;
                                }
                                return "DustMagnet Super Premium 5475i";
                            default:
                                switch (hashCode) {
                                    case 1448845532:
                                        if (!str.equals("107213")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5470i";
                                    case 1448845533:
                                        if (!str.equals("107214")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5475i";
                                    case 1448845534:
                                        if (!str.equals("107215")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5470i";
                                    case 1448845535:
                                        if (!str.equals("107216")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5475i";
                                    case 1448845536:
                                        if (!str.equals("107217")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5470i";
                                    case 1448845537:
                                        if (!str.equals("107218")) {
                                            return null;
                                        }
                                        return "DustMagnet Super Premium 5475i";
                                    default:
                                        return null;
                                }
                        }
                }
            } else if (!str.equals("108761")) {
                return null;
            } else {
                return "DustMagnet Super Premium 5470i";
            }
        }

        public final String blueFamilyNameFromSku(String str) {
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case 1448908064:
                    if (!str.equals("109538")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1448908065:
                    if (!str.equals("109539")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1448908122:
                    if (!str.equals("109554")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1448908124:
                    if (!str.equals("109556")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1448908214:
                    if (!str.equals("109583")) {
                        return null;
                    }
                    return DeviceType.BLUE;
                case 1448908248:
                    if (!str.equals("109596")) {
                        return null;
                    }
                    return DeviceType.BLUE;
                case 1448908933:
                    if (!str.equals("109609")) {
                        return null;
                    }
                    return DeviceType.BLUE;
                case 1448911100:
                    if (!str.equals("109886")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558654:
                    if (!str.equals("110031")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558656:
                    if (!str.equals("110033")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558657:
                    if (!str.equals("110034")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558658:
                    if (!str.equals("110035")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558722:
                    if (!str.equals("110057")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558723:
                    if (!str.equals("110058")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558724:
                    if (!str.equals("110059")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558786:
                    if (!str.equals("110079")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558808:
                    if (!str.equals("110080")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558809:
                    if (str.equals("110081")) {
                        return DeviceType.BLUE_PURE;
                    }
                    return null;
                case 1449558813:
                    if (!str.equals("110085")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558814:
                    if (!str.equals("110086")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558816:
                    if (!str.equals("110088")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449558841:
                    if (!str.equals("110092")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559683:
                    if (!str.equals("110157")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559684:
                    if (!str.equals("110158")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559685:
                    if (!str.equals("110159")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559708:
                    if (!str.equals("110161")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559709:
                    if (!str.equals("110162")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559710:
                    if (!str.equals("110163")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559740:
                    if (!str.equals("110172")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559741:
                    if (!str.equals("110173")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559743:
                    if (!str.equals("110175")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559746:
                    if (!str.equals("110178")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449559747:
                    if (!str.equals("110179")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449561512:
                    if (!str.equals("110327")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449563650:
                    if (!str.equals("110596")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449566319:
                    if (!str.equals("110829")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449566536:
                    if (!str.equals("110899")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449589537:
                    if (!str.equals("111178")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449589566:
                    if (!str.equals("111186")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449589567:
                    if (!str.equals("111187")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449589568:
                    if (!str.equals("111188")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449593406:
                    if (!str.equals("111582")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449597005:
                    if (!str.equals("111905")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449624008:
                    if (!str.equals("112637")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449653766:
                    if (!str.equals("113625")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                case 1449678720:
                    if (!str.equals("114114")) {
                        return null;
                    }
                    return DeviceType.BLUE_PURE;
                default:
                    return null;
            }
        }

        public final boolean isNb411iMax(String str) {
            if (str == null) {
                return false;
            }
            switch (str.hashCode()) {
                case 1448908122:
                    return str.equals("109554");
                case 1449558654:
                    return str.equals("110031");
                case 1449558722:
                    return str.equals("110057");
                case 1449558786:
                    return str.equals("110079");
                case 1449558813:
                    return str.equals("110085");
                case 1449559683:
                    return str.equals("110157");
                case 1449559708:
                    return str.equals("110161");
                case 1449559740:
                    return str.equals("110172");
                case 1449559746:
                    return str.equals("110178");
                default:
                    return false;
            }
        }

        public final String blueModelNameFromSku(String str) {
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case 1448908064:
                    if (!str.equals("109538")) {
                        return null;
                    }
                    return "311i Max";
                case 1448908065:
                    if (!str.equals("109539")) {
                        return null;
                    }
                    return "311i+ Max";
                case 1448908122:
                    if (!str.equals("109554")) {
                        return null;
                    }
                    return "411i Max";
                case 1448908124:
                    if (!str.equals("109556")) {
                        return null;
                    }
                    return "211i Max";
                case 1448908214:
                    if (!str.equals("109583")) {
                        return null;
                    }
                    return "32/411";
                case 1448908248:
                    if (!str.equals("109596")) {
                        return null;
                    }
                    return "36/211";
                case 1448908933:
                    if (!str.equals("109609")) {
                        return null;
                    }
                    return "33/34/311";
                case 1448911100:
                    if (!str.equals("109886")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                case 1449558654:
                    if (!str.equals("110031")) {
                        return null;
                    }
                    return "411i Max";
                case 1449558656:
                    if (!str.equals("110033")) {
                        return null;
                    }
                    return "311i Max";
                case 1449558657:
                    if (!str.equals("110034")) {
                        return null;
                    }
                    return "311i+ Max";
                case 1449558658:
                    if (!str.equals("110035")) {
                        return null;
                    }
                    return "211i Max";
                case 1449558722:
                    if (!str.equals("110057")) {
                        return null;
                    }
                    return "411i Max";
                case 1449558723:
                    if (!str.equals("110058")) {
                        return null;
                    }
                    return "311i+ Max";
                case 1449558724:
                    if (!str.equals("110059")) {
                        return null;
                    }
                    return "211i Max";
                case 1449558786:
                    if (!str.equals("110079")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449558808:
                    if (!str.equals("110080")) {
                        return null;
                    }
                    return "311i Max (3350i)";
                case 1449558809:
                    if (!str.equals("110081")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449558813:
                    if (!str.equals("110085")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449558814:
                    if (!str.equals("110086")) {
                        return null;
                    }
                    return "311i Max (3350i)";
                case 1449558816:
                    if (!str.equals("110088")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449558841:
                    if (!str.equals("110092")) {
                        return null;
                    }
                    return "311i Max";
                case 1449559683:
                    if (!str.equals("110157")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449559684:
                    if (!str.equals("110158")) {
                        return null;
                    }
                    return "311i Max (3350i)";
                case 1449559685:
                    if (!str.equals("110159")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449559708:
                    if (!str.equals("110161")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449559709:
                    if (!str.equals("110162")) {
                        return null;
                    }
                    return "311i Max (3350i)";
                case 1449559710:
                    if (!str.equals("110163")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449559740:
                    if (!str.equals("110172")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449559741:
                    if (!str.equals("110173")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449559743:
                    if (!str.equals("110175")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                case 1449559746:
                    if (!str.equals("110178")) {
                        return null;
                    }
                    return "411i Max (3250i)";
                case 1449559747:
                    if (!str.equals("110179")) {
                        return null;
                    }
                    return "311i+ Max (3450i)";
                case 1449561512:
                    if (!str.equals("110327")) {
                        return null;
                    }
                    return "311i+ Max";
                case 1449563650:
                    if (!str.equals("110596")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                case 1449566319:
                    if (!str.equals("110829")) {
                        return null;
                    }
                    return "311i Max";
                case 1449566536:
                    if (!str.equals("110899")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                case 1449589537:
                    if (!str.equals("111178")) {
                        return null;
                    }
                    return "511i Max";
                case 1449589566:
                    if (!str.equals("111186")) {
                        return null;
                    }
                    return "511i Max";
                case 1449589567:
                    if (!str.equals("111187")) {
                        return null;
                    }
                    return "511i Max";
                case 1449589568:
                    if (!str.equals("111188")) {
                        return null;
                    }
                    return "511i Max";
                case 1449593406:
                    if (!str.equals("111582")) {
                        return null;
                    }
                    return "511i Max";
                case 1449597005:
                    if (!str.equals("111905")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                case 1449624008:
                    if (!str.equals("112637")) {
                        return null;
                    }
                    return "511i Max";
                case 1449653766:
                    if (!str.equals("113625")) {
                        return null;
                    }
                    return "311i+ Max";
                case 1449678720:
                    if (!str.equals("114114")) {
                        return null;
                    }
                    return "211i Max (3650i)";
                default:
                    return null;
            }
        }

        public final Set<String> getG4SP_SKU() {
            return DeviceType.G4SP_SKU;
        }

        public final Set<String> getG4Plus_SKU() {
            return DeviceType.G4Plus_SKU;
        }

        public final Set<String> getG4Plus_HCHO_SKU() {
            return DeviceType.G4Plus_HCHO_SKU;
        }

        public final Set<String> getG4Plus_tVOC_SKU() {
            return DeviceType.G4Plus_tVOC_SKU;
        }
    }
}
