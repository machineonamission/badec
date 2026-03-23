package com.blueair.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.blueair.database.dao.AqiDataDao;
import com.blueair.database.dao.DeviceDao;
import com.blueair.database.dao.DeviceDataDao;
import com.blueair.database.dao.DeviceScheduleDao;
import com.blueair.database.dao.NotificationDao;
import com.blueair.database.dao.TrackedLocationDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/blueair/database/BlueairDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "deviceDao", "Lcom/blueair/database/dao/DeviceDao;", "deviceDataDao", "Lcom/blueair/database/dao/DeviceDataDao;", "trackedLocationDao", "Lcom/blueair/database/dao/TrackedLocationDao;", "aqiDataDao", "Lcom/blueair/database/dao/AqiDataDao;", "deviceScheduleDao", "Lcom/blueair/database/dao/DeviceScheduleDao;", "notificationDao", "Lcom/blueair/database/dao/NotificationDao;", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public abstract class BlueairDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATABASE_NAME = "blueair.db";
    /* access modifiers changed from: private */
    public static BlueairDatabase INSTANCE;
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_41_42$1 MIGRATION_41_42 = new BlueairDatabase$Companion$MIGRATION_41_42$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_42_43$1 MIGRATION_42_43 = new BlueairDatabase$Companion$MIGRATION_42_43$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_43_44$1 MIGRATION_43_44 = new BlueairDatabase$Companion$MIGRATION_43_44$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_44_45$1 MIGRATION_44_45 = new BlueairDatabase$Companion$MIGRATION_44_45$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_45_46$1 MIGRATION_45_46 = new BlueairDatabase$Companion$MIGRATION_45_46$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_46_47$1 MIGRATION_46_47 = new BlueairDatabase$Companion$MIGRATION_46_47$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_47_48$1 MIGRATION_47_48 = new BlueairDatabase$Companion$MIGRATION_47_48$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_48_49$1 MIGRATION_48_49 = new BlueairDatabase$Companion$MIGRATION_48_49$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_49_50$1 MIGRATION_49_50 = new BlueairDatabase$Companion$MIGRATION_49_50$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_50_51$1 MIGRATION_50_51 = new BlueairDatabase$Companion$MIGRATION_50_51$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_51_52$1 MIGRATION_51_52 = new BlueairDatabase$Companion$MIGRATION_51_52$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_52_53$1 MIGRATION_52_53 = new BlueairDatabase$Companion$MIGRATION_52_53$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_53_54$1 MIGRATION_53_54 = new BlueairDatabase$Companion$MIGRATION_53_54$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_54_55$1 MIGRATION_54_55 = new BlueairDatabase$Companion$MIGRATION_54_55$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_55_56$1 MIGRATION_55_56 = new BlueairDatabase$Companion$MIGRATION_55_56$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_56_57$1 MIGRATION_56_57 = new BlueairDatabase$Companion$MIGRATION_56_57$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_58_59$1 MIGRATION_58_59 = new BlueairDatabase$Companion$MIGRATION_58_59$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_59_60$1 MIGRATION_59_60 = new BlueairDatabase$Companion$MIGRATION_59_60$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_60_61$1 MIGRATION_60_61 = new BlueairDatabase$Companion$MIGRATION_60_61$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_61_62$1 MIGRATION_61_62 = new BlueairDatabase$Companion$MIGRATION_61_62$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_62_63$1 MIGRATION_62_63 = new BlueairDatabase$Companion$MIGRATION_62_63$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_64_65$1 MIGRATION_64_65 = new BlueairDatabase$Companion$MIGRATION_64_65$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_65_66$1 MIGRATION_65_66 = new BlueairDatabase$Companion$MIGRATION_65_66$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_66_67$1 MIGRATION_66_67 = new BlueairDatabase$Companion$MIGRATION_66_67$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_67_68$1 MIGRATION_67_68 = new BlueairDatabase$Companion$MIGRATION_67_68$1();
    /* access modifiers changed from: private */
    public static final BlueairDatabase$Companion$MIGRATION_68_69$1 MIGRATION_68_69 = new BlueairDatabase$Companion$MIGRATION_68_69$1();

    public abstract AqiDataDao aqiDataDao();

    public abstract DeviceDao deviceDao();

    public abstract DeviceDataDao deviceDataDao();

    public abstract DeviceScheduleDao deviceScheduleDao();

    public abstract NotificationDao notificationDao();

    public abstract TrackedLocationDao trackedLocationDao();

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u001a\u0010\u0013\u0016\u0019\u001c\u001f\"%(+.147:=@CFILORUX[\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u00020:X\u0004¢\u0006\u0004\n\u0002\u0010;R\u0010\u0010<\u001a\u00020=X\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0004¢\u0006\u0004\n\u0002\u0010GR\u0010\u0010H\u001a\u00020IX\u0004¢\u0006\u0004\n\u0002\u0010JR\u0010\u0010K\u001a\u00020LX\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u00020OX\u0004¢\u0006\u0004\n\u0002\u0010PR\u0010\u0010Q\u001a\u00020RX\u0004¢\u0006\u0004\n\u0002\u0010SR\u0010\u0010T\u001a\u00020UX\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010W\u001a\u00020XX\u0004¢\u0006\u0004\n\u0002\u0010YR\u0010\u0010Z\u001a\u00020[X\u0004¢\u0006\u0004\n\u0002\u0010\\¨\u0006]"}, d2 = {"Lcom/blueair/database/BlueairDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/blueair/database/BlueairDatabase;", "getINSTANCE", "()Lcom/blueair/database/BlueairDatabase;", "setINSTANCE", "(Lcom/blueair/database/BlueairDatabase;)V", "getDatabase", "context", "Landroid/content/Context;", "DATABASE_NAME", "", "MIGRATION_41_42", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_41_42$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_41_42$1;", "MIGRATION_42_43", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_42_43$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_42_43$1;", "MIGRATION_43_44", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_43_44$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_43_44$1;", "MIGRATION_44_45", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_44_45$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_44_45$1;", "MIGRATION_45_46", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_45_46$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_45_46$1;", "MIGRATION_46_47", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_46_47$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_46_47$1;", "MIGRATION_47_48", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_47_48$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_47_48$1;", "MIGRATION_48_49", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_48_49$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_48_49$1;", "MIGRATION_49_50", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_49_50$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_49_50$1;", "MIGRATION_50_51", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_50_51$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_50_51$1;", "MIGRATION_51_52", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_51_52$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_51_52$1;", "MIGRATION_52_53", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_52_53$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_52_53$1;", "MIGRATION_53_54", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_53_54$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_53_54$1;", "MIGRATION_54_55", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_54_55$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_54_55$1;", "MIGRATION_55_56", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_55_56$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_55_56$1;", "MIGRATION_56_57", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_56_57$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_56_57$1;", "MIGRATION_58_59", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_58_59$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_58_59$1;", "MIGRATION_59_60", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_59_60$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_59_60$1;", "MIGRATION_60_61", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_60_61$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_60_61$1;", "MIGRATION_61_62", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_61_62$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_61_62$1;", "MIGRATION_62_63", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_62_63$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_62_63$1;", "MIGRATION_64_65", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_64_65$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_64_65$1;", "MIGRATION_65_66", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_65_66$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_65_66$1;", "MIGRATION_66_67", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_66_67$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_66_67$1;", "MIGRATION_67_68", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_67_68$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_67_68$1;", "MIGRATION_68_69", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_68_69$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_68_69$1;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueairDatabase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlueairDatabase getINSTANCE() {
            return BlueairDatabase.INSTANCE;
        }

        public final void setINSTANCE(BlueairDatabase blueairDatabase) {
            BlueairDatabase.INSTANCE = blueairDatabase;
        }

        public final BlueairDatabase getDatabase(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (getINSTANCE() == null) {
                synchronized (Reflection.getOrCreateKotlinClass(BlueairDatabase.class)) {
                    BlueairDatabase.Companion.setINSTANCE(Room.databaseBuilder(context, BlueairDatabase.class, BlueairDatabase.DATABASE_NAME).addMigrations(BlueairDatabase.MIGRATION_41_42, BlueairDatabase.MIGRATION_42_43, BlueairDatabase.MIGRATION_43_44, BlueairDatabase.MIGRATION_44_45, BlueairDatabase.MIGRATION_45_46, BlueairDatabase.MIGRATION_46_47, BlueairDatabase.MIGRATION_47_48, BlueairDatabase.MIGRATION_48_49, BlueairDatabase.MIGRATION_49_50, BlueairDatabase.MIGRATION_50_51, BlueairDatabase.MIGRATION_51_52, BlueairDatabase.MIGRATION_52_53, BlueairDatabase.MIGRATION_53_54, BlueairDatabase.MIGRATION_54_55, BlueairDatabase.MIGRATION_55_56, BlueairDatabase.MIGRATION_56_57, BlueairDatabase.MIGRATION_58_59, BlueairDatabase.MIGRATION_59_60, BlueairDatabase.MIGRATION_60_61, BlueairDatabase.MIGRATION_61_62, BlueairDatabase.MIGRATION_62_63, BlueairDatabase.MIGRATION_64_65, BlueairDatabase.MIGRATION_65_66, BlueairDatabase.MIGRATION_66_67, BlueairDatabase.MIGRATION_67_68, BlueairDatabase.MIGRATION_68_69).fallbackToDestructiveMigration(true).build());
                    Unit unit = Unit.INSTANCE;
                }
            }
            BlueairDatabase instance = getINSTANCE();
            Intrinsics.checkNotNull(instance);
            return instance;
        }
    }
}
