package com.blueair.database.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceClassicWithoutSensors;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DeviceOnBlueServer;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.DeviceSense;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.DeviceUnknown;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.database.DeviceUuidEntity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b{\n\u0002\u0018\u0002\n\u0002\bw\b\b\u0018\u0000 é\u00022\u00020\u0001:\u0002é\u0002B÷\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020'\u0012\b\b\u0002\u0010*\u001a\u00020'\u0012\b\b\u0002\u0010+\u001a\u00020'\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u0012\b\b\u0002\u0010.\u001a\u00020\u0010\u0012\b\b\u0002\u0010/\u001a\u00020\u0010\u0012\b\b\u0002\u00100\u001a\u00020\u0010\u0012\b\b\u0002\u00101\u001a\u00020\u0010\u0012\b\b\u0002\u00102\u001a\u00020\u0010\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u00104\u001a\u00020\u0010\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0010\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010?\u001a\u00020\u0010\u0012\b\b\u0002\u0010@\u001a\u00020\u0010\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\b\b\u0002\u0010B\u001a\u00020\u001a\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\b\u0002\u0010D\u001a\u00020\u0010\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u0012\b\b\u0002\u0010F\u001a\u00020\u0007\u0012\b\b\u0002\u0010G\u001a\u00020\u0007\u0012\b\b\u0002\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010I\u001a\u00020\u001a\u0012\b\b\u0002\u0010J\u001a\u00020\u0007\u0012\b\b\u0002\u0010K\u001a\u00020\u0007\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u0012\b\b\u0002\u0010M\u001a\u00020\u0007\u0012\b\b\u0002\u0010N\u001a\u00020\u0007\u0012\b\b\u0002\u0010O\u001a\u00020\u0007\u0012\b\b\u0002\u0010P\u001a\u00020\u0007\u0012\b\b\u0002\u0010Q\u001a\u00020\u0007\u0012\b\b\u0002\u0010R\u001a\u00020\u0007\u0012\b\b\u0002\u0010S\u001a\u00020\u0007\u0012\b\b\u0002\u0010T\u001a\u00020U\u0012\b\b\u0002\u0010V\u001a\u00020U\u0012\b\b\u0002\u0010W\u001a\u00020\u0007\u0012\b\b\u0002\u0010X\u001a\u00020\u0007\u0012\b\b\u0002\u0010Y\u001a\u00020\u0007\u0012\b\b\u0002\u0010Z\u001a\u00020'\u0012\b\b\u0002\u0010[\u001a\u00020\u0007\u0012\b\b\u0002\u0010\\\u001a\u00020'\u0012\b\b\u0002\u0010]\u001a\u00020\u0010\u0012\b\b\u0002\u0010^\u001a\u00020\u0007\u0012\b\b\u0002\u0010_\u001a\u00020\u0007\u0012\b\b\u0002\u0010`\u001a\u00020\u0007\u0012\b\b\u0002\u0010a\u001a\u00020\u0010\u0012\b\b\u0002\u0010b\u001a\u00020\u0007\u0012\b\b\u0002\u0010c\u001a\u00020\u0010\u0012\b\b\u0002\u0010d\u001a\u00020\u0010\u0012\b\b\u0002\u0010e\u001a\u00020\u0007\u0012\b\b\u0002\u0010f\u001a\u00020\u0007\u0012\b\b\u0002\u0010g\u001a\u00020\u0010\u0012\b\b\u0002\u0010h\u001a\u00020\u0010\u0012\b\b\u0002\u0010i\u001a\u00020\u0007\u0012\b\b\u0002\u0010j\u001a\u00020\u0007\u0012\b\b\u0002\u0010k\u001a\u00020\u0007\u0012\b\b\u0002\u0010l\u001a\u00020\u0007\u0012\b\b\u0002\u0010m\u001a\u00020\u0007\u0012\b\b\u0002\u0010n\u001a\u00020\u0007\u0012\b\b\u0002\u0010o\u001a\u00020\u0007\u0012\b\b\u0002\u0010p\u001a\u00020\u0007\u0012\b\b\u0002\u0010q\u001a\u00020\u0010\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010s\u001a\u00020\u0007\u0012\b\b\u0002\u0010t\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v\u0012\b\b\u0002\u0010x\u001a\u00020\u0007\u0012\b\b\u0002\u0010y\u001a\u00020\u0010\u0012\b\b\u0002\u0010z\u001a\u00020\u0010\u0012\b\b\u0002\u0010{\u001a\u00020\u0007¢\u0006\u0004\b|\u0010}J\b\u0010ò\u0001\u001a\u00030ó\u0001J\n\u0010ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010õ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010÷\u0001\u001a\u00020\u0007HÆ\u0003J\u0012\u0010ø\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010ù\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010û\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ý\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\n\u0010þ\u0001\u001a\u00020\u0010HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020'HÆ\u0003J\n\u0010\u0002\u001a\u00020'HÆ\u0003J\n\u0010\u0002\u001a\u00020'HÆ\u0003J\n\u0010\u0002\u001a\u00020'HÆ\u0003J\n\u0010\u0002\u001a\u00020'HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¨\u0001J\n\u0010\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010 \u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0002\u001a\u00020\u0010HÆ\u0003J\f\u0010¢\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¤\u0002\u001a\u0004\u0018\u00010:HÆ\u0003J\f\u0010¥\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¦\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¨\u0001J\u0012\u0010§\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010¨\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0003\u0010´\u0001J\n\u0010©\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010ª\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010«\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¬\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010­\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010®\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010¯\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010°\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010±\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010²\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010³\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010´\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010µ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¶\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010·\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¸\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¹\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010º\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010»\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¼\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010½\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¾\u0002\u001a\u00020UHÆ\u0003J\n\u0010¿\u0002\u001a\u00020UHÆ\u0003J\n\u0010À\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Á\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Â\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ã\u0002\u001a\u00020'HÆ\u0003J\n\u0010Ä\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Å\u0002\u001a\u00020'HÆ\u0003J\n\u0010Æ\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ç\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010È\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010É\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ê\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ë\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ì\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Í\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Î\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ï\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ð\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ñ\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ò\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ó\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ô\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Õ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ö\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010×\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ø\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ù\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ú\u0002\u001a\u00020\u0010HÆ\u0003J\u0012\u0010Û\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¨\u0001J\n\u0010Ü\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ý\u0002\u001a\u00020\u0007HÆ\u0003J\u0012\u0010Þ\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0vHÆ\u0003J\n\u0010ß\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010à\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010á\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010â\u0002\u001a\u00020\u0007HÆ\u0003J\t\u0010ã\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'2\b\b\u0002\u0010*\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00102\b\b\u0002\u0010/\u001a\u00020\u00102\b\b\u0002\u00100\u001a\u00020\u00102\b\b\u0002\u00101\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u00102\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00104\u001a\u00020\u00102\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00102\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010?\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020\u001a2\b\b\u0002\u0010C\u001a\u00020\u00072\b\b\u0002\u0010D\u001a\u00020\u00102\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u00072\b\b\u0002\u0010P\u001a\u00020\u00072\b\b\u0002\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010R\u001a\u00020\u00072\b\b\u0002\u0010S\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020U2\b\b\u0002\u0010W\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010Z\u001a\u00020'2\b\b\u0002\u0010[\u001a\u00020\u00072\b\b\u0002\u0010\\\u001a\u00020'2\b\b\u0002\u0010]\u001a\u00020\u00102\b\b\u0002\u0010^\u001a\u00020\u00072\b\b\u0002\u0010_\u001a\u00020\u00072\b\b\u0002\u0010`\u001a\u00020\u00072\b\b\u0002\u0010a\u001a\u00020\u00102\b\b\u0002\u0010b\u001a\u00020\u00072\b\b\u0002\u0010c\u001a\u00020\u00102\b\b\u0002\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\u00072\b\b\u0002\u0010g\u001a\u00020\u00102\b\b\u0002\u0010h\u001a\u00020\u00102\b\b\u0002\u0010i\u001a\u00020\u00072\b\b\u0002\u0010j\u001a\u00020\u00072\b\b\u0002\u0010k\u001a\u00020\u00072\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010p\u001a\u00020\u00072\b\b\u0002\u0010q\u001a\u00020\u00102\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010s\u001a\u00020\u00072\b\b\u0002\u0010t\u001a\u00020\u00072\u0010\b\u0002\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v2\b\b\u0002\u0010x\u001a\u00020\u00072\b\b\u0002\u0010y\u001a\u00020\u00102\b\b\u0002\u0010z\u001a\u00020\u00102\b\b\u0002\u0010{\u001a\u00020\u0007HÆ\u0001¢\u0006\u0003\u0010ä\u0002J\u0015\u0010å\u0002\u001a\u00020\u00102\t\u0010æ\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ç\u0002\u001a\u00020\u0007HÖ\u0001J\n\u0010è\u0002\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010R\u0012\u0010\u0004\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u0005\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010\u000f\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010\u0014\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0014\u0010\u0001R\u0012\u0010\u0015\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0015\u0010\u0001R\u0012\u0010\u0016\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0016\u0010\u0001R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0013\u0010\u0018\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010\u0019\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010\u001b\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u001c\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u001d\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u001e\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u001f\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010 \u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010!\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\"\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010#\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010$\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010%\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010R\u0013\u0010&\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0013\u0010(\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¢\u0001R\u0013\u0010)\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¤\u0001\u0010¢\u0001R\u0013\u0010*\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¢\u0001R\u0013\u0010+\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010¢\u0001R\u0013\u0010,\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010\u0001R\u0012\u0010-\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b-\u0010\u0001R\u0012\u0010.\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b.\u0010\u0001R\u0012\u0010/\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b/\u0010\u0001R\u0012\u00100\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b0\u0010\u0001R\u0012\u00101\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b1\u0010\u0001R\u0012\u00102\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b2\u0010\u0001R\u0017\u00103\u001a\u0004\u0018\u00010\u0010¢\u0006\f\n\u0003\u0010©\u0001\u001a\u0005\b3\u0010¨\u0001R\u0012\u00104\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b4\u0010\u0001R\u0012\u00105\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010R\u0013\u00106\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010\u0001R\u0014\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010R\u0014\u00108\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b­\u0001\u0010R\u001a\u00109\u001a\u0004\u0018\u00010:8\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0014\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b°\u0001\u0010R\u0018\u0010<\u001a\u0004\u0018\u00010\u0010¢\u0006\r\n\u0003\u0010©\u0001\u001a\u0006\b±\u0001\u0010¨\u0001R\u0018\u0010=\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b²\u0001\u0010\u0001R\u0018\u0010>\u001a\u0004\u0018\u00010\u001a¢\u0006\r\n\u0003\u0010µ\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u0013\u0010?\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010\u0001R\u0013\u0010@\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b·\u0001\u0010\u0001R\u0013\u0010A\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010\u0001R\u0013\u0010B\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010\u0001R\u0013\u0010C\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bº\u0001\u0010\u0001R\u0013\u0010D\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010\u0001R\u0013\u0010E\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010\u0001R\u0013\u0010F\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010\u0001R\u0013\u0010G\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010\u0001R\u0013\u0010H\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010\u0001R\u0013\u0010I\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010\u0001R\u0013\u0010J\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010\u0001R\u0013\u0010K\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010\u0001R\u0013\u0010L\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010\u0001R\u0013\u0010M\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0001R\u0013\u0010N\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010\u0001R\u0013\u0010O\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0001R\u0013\u0010P\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010\u0001R\u0013\u0010Q\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010\u0001R\u0013\u0010R\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010\u0001R\u0013\u0010S\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0001R\u0013\u0010T\u001a\u00020U¢\u0006\n\n\u0000\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0013\u0010V\u001a\u00020U¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010Ì\u0001R\u0013\u0010W\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010\u0001R\u0013\u0010X\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010\u0001R\u0013\u0010Y\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010\u0001R\u0013\u0010Z\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010¢\u0001R\u0013\u0010[\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010\u0001R\u0013\u0010\\\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010¢\u0001R\u0013\u0010]\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010\u0001R\u0013\u0010^\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010\u0001R\u0013\u0010_\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010\u0001R\u0013\u0010`\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b×\u0001\u0010\u0001R\u0013\u0010a\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bØ\u0001\u0010\u0001R\u0013\u0010b\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010\u0001R\u0013\u0010c\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010\u0001R\u0013\u0010d\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010\u0001R\u0013\u0010e\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0001\u0010\u0001R\u0013\u0010f\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÝ\u0001\u0010\u0001R\u0013\u0010g\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010\u0001R\u0013\u0010h\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010\u0001R\u0013\u0010i\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bà\u0001\u0010\u0001R\u0013\u0010j\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010\u0001R\u0013\u0010k\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010\u0001R\u0013\u0010l\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010\u0001R\u0013\u0010m\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010\u0001R\u0013\u0010n\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010\u0001R\u0013\u0010o\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010\u0001R\u0013\u0010p\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bç\u0001\u0010\u0001R\u0013\u0010q\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010\u0001R\u0018\u0010r\u001a\u0004\u0018\u00010\u0010¢\u0006\r\n\u0003\u0010©\u0001\u001a\u0006\bé\u0001\u0010¨\u0001R\u0013\u0010s\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bê\u0001\u0010\u0001R\u0013\u0010t\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010\u0001R\u001b\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v¢\u0006\n\n\u0000\u001a\u0006\bì\u0001\u0010í\u0001R\u0013\u0010x\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bî\u0001\u0010\u0001R\u0013\u0010y\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bï\u0001\u0010\u0001R\u0013\u0010z\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bð\u0001\u0010\u0001R\u0013\u0010{\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bñ\u0001\u0010\u0001¨\u0006ê\u0002"}, d2 = {"Lcom/blueair/database/entity/DeviceEntity;", "", "uid", "", "name", "modelName", "typeIndex", "", "fanSpeed", "filterLife", "autoModeText", "brightness", "info", "deviceUuid", "Lcom/blueair/database/DeviceUuidEntity;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorType", "isAblDevice", "isNightModeOn", "isChildLockOn", "linkedDeviceUid", "connectivityStatusIndex", "lastConnectivityMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isEcoModeOn", "isHinsModeOn", "isHinsNightModeOn", "isG4NightModeOn", "isGermShieldOn", "isGermShieldNightModeOn", "isSafetySwitchOn", "g4NightModefilterTrigger", "aimInstalled", "sku", "compatibility", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "locationId", "disinfection", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "humMode", "mode", "waterLevel", "dehSubMode", "waterTankFailure", "smartSubMode", "detectCat", "bodyMounted", "cleanAirEta", "panelDisplayMode", "hoverEnabled", "airRefreshEnabled", "airRefreshStatus", "airRefreshDuration", "airRefreshTimeStamp", "airRefreshStartTimeStamp", "airRefreshEndTimeStamp", "roomType", "nightLampBrightness", "wickdryDuration", "wickdryDone", "ywrmEnabled", "ywrmUsage", "nightLampSteplessBrightness", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "humSubMode", "use24Hour", "waterInfill", "sensorMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/blueair/database/DeviceUuidEntity;ZLcom/blueair/core/model/IndoorDatapoint;Ljava/lang/Integer;ZZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZZLjava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;ZZIJIZIIIIJIIIIIIIIIIDDIII[DI[DZIIIZIZZIIZZIIIIIIIIZLjava/lang/Boolean;IILjava/util/List;IZZI)V", "getUid", "()Ljava/lang/String;", "getName", "getModelName", "getTypeIndex", "()I", "getFanSpeed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFilterLife", "getAutoModeText", "getBrightness", "getInfo", "getDeviceUuid", "()Lcom/blueair/database/DeviceUuidEntity;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorType", "getLinkedDeviceUid", "getConnectivityStatusIndex", "getLastConnectivityMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getG4NightModefilterTrigger", "getAimInstalled", "getSku", "getCompatibility", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getLocationId", "getDisinfection", "getDisinfectLeftTime", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()D", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getHumMode", "getMode", "getWaterLevel", "getDehSubMode", "getWaterTankFailure", "getSmartSubMode", "getDetectCat", "getBodyMounted", "getCleanAirEta", "getPanelDisplayMode", "getHoverEnabled", "getAirRefreshEnabled", "getAirRefreshStatus", "getAirRefreshDuration", "getAirRefreshTimeStamp", "getAirRefreshStartTimeStamp", "getAirRefreshEndTimeStamp", "getRoomType", "getNightLampBrightness", "getWickdryDuration", "getWickdryDone", "getYwrmEnabled", "getYwrmUsage", "getNightLampSteplessBrightness", "getAlarms", "()Ljava/util/List;", "getHumSubMode", "getUse24Hour", "getWaterInfill", "getSensorMode", "toDevice", "Lcom/blueair/core/model/Device;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "component101", "component102", "component103", "component104", "component105", "component106", "component107", "component108", "component109", "component110", "component111", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/blueair/database/DeviceUuidEntity;ZLcom/blueair/core/model/IndoorDatapoint;Ljava/lang/Integer;ZZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZZLjava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;ZZIJIZIIIIJIIIIIIIIIIDDIII[DI[DZIIIZIZZIIZZIIIIIIIIZLjava/lang/Boolean;IILjava/util/List;IZZI)Lcom/blueair/database/entity/DeviceEntity;", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
public final class DeviceEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_TABLE = "device_table";
    /* access modifiers changed from: private */
    public static final List<DeviceAlarm> NULL_ALARM_LIST;
    private final boolean aimInstalled;
    private final int airRefreshDuration;
    private final boolean airRefreshEnabled;
    private final int airRefreshEndTimeStamp;
    private final int airRefreshStartTimeStamp;
    private final int airRefreshStatus;
    private final int airRefreshTimeStamp;
    private final List<DeviceAlarm> alarms;
    private final int apFanSpeed;
    private final int apSubMode;
    private final String autoModeText;
    private final int autoRh;
    private final boolean bodyMounted;
    private final Integer brightness;
    private final int cleanAirEta;
    private final String compatibility;
    private final int connectivityStatusIndex;
    private final double[] coolAutoPresets;
    private final int coolAutoTag;
    private final double[] coolEcoPresets;
    private final int coolEcoTag;
    private final int coolFanSpeed;
    private final int coolSubMode;
    private final String dealerCountry;
    private final String dealerName;
    private final int dehSubMode;
    private final boolean detectCat;
    private final DeviceUuidEntity deviceUuid;
    private final Integer disinfectLeftTime;
    private final Long disinfectLeftTimeUpdateTime;
    private final Boolean disinfection;
    private final Integer fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String g4NightModefilterTrigger;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final double heatAutoTmp;
    private final double heatEcoTmp;
    private final int heatFanSpeed;
    private final int heatSubMode;
    private final boolean hoverEnabled;
    private final boolean humMode;
    private final int humSubMode;
    private final String info;
    private final boolean isAblDevice;
    private final boolean isChildLockOn;
    private final boolean isEcoModeOn;
    private final boolean isG4NightModeOn;
    private final Boolean isGermShieldNightModeOn;
    private final boolean isGermShieldOn;
    private final boolean isHinsModeOn;
    private final boolean isHinsNightModeOn;
    private final boolean isNightModeOn;
    private final boolean isSafetySwitchOn;
    private final boolean isStandByOn;
    private final long lastConnectivityMillis;
    private final Integer lastSelectedSensorType;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String linkedDeviceUid;
    private final String locationId;
    private final String mac;
    private final int mainMode;
    private final String mcuFirmware;
    private final int mode;
    private final String modelName;
    private final String name;
    private final int nightLampBrightness;
    private final int nightLampSteplessBrightness;
    private final int oscillationAngle;
    private final int oscillationDirection;
    private final int oscillationFanSpeed;
    private final int oscillationState;
    private final int panelDisplayMode;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final int roomType;
    private final int sensorMode;
    private final String serial;
    private final String sku;
    private final int smartSubMode;
    private final int temperatureUnit;
    private final String timeZone;
    private final int timerDuration;
    private final int timerLeftTime;
    private final long timerLeftTimeUpdateTime;
    private final int timerStatus;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final boolean use24Hour;
    private final double[] vocRanges;
    private final boolean waterInfill;
    private final int waterLevel;
    private final boolean waterShortage;
    private final boolean waterTankFailure;
    private final WelcomeHomeLocation welcomeHome;
    private final int wickUsage;
    private final boolean wickdryDone;
    private final int wickdryDuration;
    private final boolean wickdryEnabled;
    private final int wickdryLeftTime;
    private final long wickdryLeftTimeUpdateTime;
    private final boolean wickdryOn;
    private final String wifiFirmware;
    private final Boolean ywrmEnabled;
    private final int ywrmUsage;

    public static /* synthetic */ DeviceEntity copy$default(DeviceEntity deviceEntity, String str, String str2, String str3, int i, Integer num, Integer num2, String str4, Integer num3, String str5, DeviceUuidEntity deviceUuidEntity, boolean z, IndoorDatapoint indoorDatapoint, Integer num4, boolean z2, boolean z3, boolean z4, String str6, int i2, long j, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i3, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, Boolean bool, boolean z11, String str18, boolean z12, String str19, String str20, WelcomeHomeLocation welcomeHomeLocation, String str21, Boolean bool2, Integer num5, Long l, boolean z13, boolean z14, int i4, long j2, int i5, boolean z15, int i6, int i7, int i8, int i9, long j3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, boolean z16, int i24, int i25, int i26, boolean z17, int i27, boolean z18, boolean z19, int i28, int i29, boolean z20, boolean z21, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, boolean z22, Boolean bool3, int i38, int i39, List list, int i40, boolean z23, boolean z24, int i41, int i42, int i43, int i44, int i45, Object obj) {
        DeviceEntity deviceEntity2 = deviceEntity;
        int i46 = i42;
        int i47 = i43;
        int i48 = i44;
        int i49 = i45;
        String str22 = (i46 & 1) != 0 ? deviceEntity2.uid : str;
        String str23 = (i46 & 2) != 0 ? deviceEntity2.name : str2;
        String str24 = (i46 & 4) != 0 ? deviceEntity2.modelName : str3;
        int i50 = (i46 & 8) != 0 ? deviceEntity2.typeIndex : i;
        Integer num6 = (i46 & 16) != 0 ? deviceEntity2.fanSpeed : num;
        Integer num7 = (i46 & 32) != 0 ? deviceEntity2.filterLife : num2;
        String str25 = (i46 & 64) != 0 ? deviceEntity2.autoModeText : str4;
        Integer num8 = (i46 & 128) != 0 ? deviceEntity2.brightness : num3;
        String str26 = (i46 & 256) != 0 ? deviceEntity2.info : str5;
        DeviceUuidEntity deviceUuidEntity2 = (i46 & 512) != 0 ? deviceEntity2.deviceUuid : deviceUuidEntity;
        boolean z25 = (i46 & 1024) != 0 ? deviceEntity2.hasFinishedOnboarding : z;
        String str27 = str22;
        IndoorDatapoint indoorDatapoint2 = (i46 & 2048) != 0 ? deviceEntity2.latestSensorDatapoint : indoorDatapoint;
        Integer num9 = (i46 & 4096) != 0 ? deviceEntity2.lastSelectedSensorType : num4;
        boolean z26 = (i46 & 8192) != 0 ? deviceEntity2.isAblDevice : z2;
        boolean z27 = (i46 & 16384) != 0 ? deviceEntity2.isNightModeOn : z3;
        boolean z28 = (i46 & 32768) != 0 ? deviceEntity2.isChildLockOn : z4;
        String str28 = (i42 & 65536) != 0 ? deviceEntity2.linkedDeviceUid : str6;
        int i51 = (i42 & 131072) != 0 ? deviceEntity2.connectivityStatusIndex : i2;
        boolean z29 = z27;
        String str29 = str23;
        long j4 = (i42 & 262144) != 0 ? deviceEntity2.lastConnectivityMillis : j;
        int i52 = i51;
        String str30 = (i42 & 524288) != 0 ? deviceEntity2.mac : str7;
        String str31 = (i42 & 1048576) != 0 ? deviceEntity2.mcuFirmware : str8;
        String str32 = (i42 & 2097152) != 0 ? deviceEntity2.wifiFirmware : str9;
        String str33 = (i42 & 4194304) != 0 ? deviceEntity2.hardware : str10;
        String str34 = (i42 & 8388608) != 0 ? deviceEntity2.timeZone : str11;
        String str35 = (i42 & 16777216) != 0 ? deviceEntity2.serial : str12;
        String str36 = (i42 & 33554432) != 0 ? deviceEntity2.purchaseDate : str13;
        String str37 = (i42 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceEntity2.dealerName : str14;
        String str38 = (i42 & 134217728) != 0 ? deviceEntity2.dealerCountry : str15;
        String str39 = (i42 & 268435456) != 0 ? deviceEntity2.filterType : str16;
        String str40 = (i42 & 536870912) != 0 ? deviceEntity2.filterTrigger : str17;
        double[] dArr8 = (i42 & 1073741824) != 0 ? deviceEntity2.pm1Ranges : dArr;
        double[] dArr9 = (i42 & Integer.MIN_VALUE) != 0 ? deviceEntity2.pm10Ranges : dArr2;
        double[] dArr10 = (i47 & 1) != 0 ? deviceEntity2.pm25Ranges : dArr3;
        double[] dArr11 = (i47 & 2) != 0 ? deviceEntity2.vocRanges : dArr4;
        double[] dArr12 = (i47 & 4) != 0 ? deviceEntity2.hchoRanges : dArr5;
        int i53 = (i47 & 8) != 0 ? deviceEntity2.updateProgress : i3;
        boolean z30 = (i47 & 16) != 0 ? deviceEntity2.isStandByOn : z5;
        boolean z31 = (i47 & 32) != 0 ? deviceEntity2.isEcoModeOn : z6;
        boolean z32 = (i47 & 64) != 0 ? deviceEntity2.isHinsModeOn : z7;
        boolean z33 = (i47 & 128) != 0 ? deviceEntity2.isHinsNightModeOn : z8;
        boolean z34 = (i47 & 256) != 0 ? deviceEntity2.isG4NightModeOn : z9;
        boolean z35 = (i47 & 512) != 0 ? deviceEntity2.isGermShieldOn : z10;
        Boolean bool4 = (i47 & 1024) != 0 ? deviceEntity2.isGermShieldNightModeOn : bool;
        boolean z36 = (i47 & 2048) != 0 ? deviceEntity2.isSafetySwitchOn : z11;
        String str41 = (i47 & 4096) != 0 ? deviceEntity2.g4NightModefilterTrigger : str18;
        boolean z37 = (i47 & 8192) != 0 ? deviceEntity2.aimInstalled : z12;
        String str42 = (i47 & 16384) != 0 ? deviceEntity2.sku : str19;
        String str43 = (i47 & 32768) != 0 ? deviceEntity2.compatibility : str20;
        WelcomeHomeLocation welcomeHomeLocation2 = (i47 & 65536) != 0 ? deviceEntity2.welcomeHome : welcomeHomeLocation;
        String str44 = (i47 & 131072) != 0 ? deviceEntity2.locationId : str21;
        Boolean bool5 = (i47 & 262144) != 0 ? deviceEntity2.disinfection : bool2;
        Integer num10 = (i47 & 524288) != 0 ? deviceEntity2.disinfectLeftTime : num5;
        Long l2 = (i47 & 1048576) != 0 ? deviceEntity2.disinfectLeftTimeUpdateTime : l;
        boolean z38 = (i47 & 2097152) != 0 ? deviceEntity2.wickdryEnabled : z13;
        boolean z39 = (i47 & 4194304) != 0 ? deviceEntity2.wickdryOn : z14;
        int i54 = (i47 & 8388608) != 0 ? deviceEntity2.wickdryLeftTime : i4;
        long j5 = (i47 & 16777216) != 0 ? deviceEntity2.wickdryLeftTimeUpdateTime : j2;
        int i55 = (i43 & 33554432) != 0 ? deviceEntity2.wickUsage : i5;
        boolean z40 = (i43 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceEntity2.waterShortage : z15;
        int i56 = i55;
        int i57 = (i43 & 134217728) != 0 ? deviceEntity2.autoRh : i6;
        int i58 = (i43 & 268435456) != 0 ? deviceEntity2.timerStatus : i7;
        int i59 = (i43 & 536870912) != 0 ? deviceEntity2.timerDuration : i8;
        int i60 = (i43 & 1073741824) != 0 ? deviceEntity2.timerLeftTime : i9;
        boolean z41 = z40;
        long j6 = (i43 & Integer.MIN_VALUE) != 0 ? deviceEntity2.timerLeftTimeUpdateTime : j3;
        int i61 = (i48 & 1) != 0 ? deviceEntity2.temperatureUnit : i10;
        int i62 = (i48 & 2) != 0 ? deviceEntity2.oscillationState : i11;
        int i63 = i61;
        int i64 = (i48 & 4) != 0 ? deviceEntity2.oscillationAngle : i12;
        int i65 = (i48 & 8) != 0 ? deviceEntity2.oscillationDirection : i13;
        int i66 = (i48 & 16) != 0 ? deviceEntity2.oscillationFanSpeed : i14;
        int i67 = (i48 & 32) != 0 ? deviceEntity2.mainMode : i15;
        int i68 = (i48 & 64) != 0 ? deviceEntity2.apSubMode : i16;
        int i69 = (i48 & 128) != 0 ? deviceEntity2.apFanSpeed : i17;
        int i70 = (i48 & 256) != 0 ? deviceEntity2.heatSubMode : i18;
        int i71 = (i48 & 512) != 0 ? deviceEntity2.heatFanSpeed : i19;
        int i72 = i62;
        double d3 = (i48 & 1024) != 0 ? deviceEntity2.heatAutoTmp : d;
        double d4 = (i48 & 2048) != 0 ? deviceEntity2.heatEcoTmp : d2;
        int i73 = (i48 & 4096) != 0 ? deviceEntity2.coolSubMode : i20;
        return deviceEntity2.copy(str27, str29, str24, i50, num6, num7, str25, num8, str26, deviceUuidEntity2, z25, indoorDatapoint2, num9, z26, z29, z28, str28, i52, j4, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, dArr8, dArr9, dArr10, dArr11, dArr12, i53, z30, z31, z32, z33, z34, z35, bool4, z36, str41, z37, str42, str43, welcomeHomeLocation2, str44, bool5, num10, l2, z38, z39, i54, j5, i56, z41, i57, i58, i59, i60, j6, i63, i72, i64, i65, i66, i67, i68, i69, i70, i71, d3, d4, i73, (i48 & 8192) != 0 ? deviceEntity2.coolFanSpeed : i21, (i48 & 16384) != 0 ? deviceEntity2.coolAutoTag : i22, (i48 & 32768) != 0 ? deviceEntity2.coolAutoPresets : dArr6, (i48 & 65536) != 0 ? deviceEntity2.coolEcoTag : i23, (i48 & 131072) != 0 ? deviceEntity2.coolEcoPresets : dArr7, (i48 & 262144) != 0 ? deviceEntity2.humMode : z16, (i48 & 524288) != 0 ? deviceEntity2.mode : i24, (i48 & 1048576) != 0 ? deviceEntity2.waterLevel : i25, (i48 & 2097152) != 0 ? deviceEntity2.dehSubMode : i26, (i48 & 4194304) != 0 ? deviceEntity2.waterTankFailure : z17, (i48 & 8388608) != 0 ? deviceEntity2.smartSubMode : i27, (i48 & 16777216) != 0 ? deviceEntity2.detectCat : z18, (i48 & 33554432) != 0 ? deviceEntity2.bodyMounted : z19, (i48 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceEntity2.cleanAirEta : i28, (i48 & 134217728) != 0 ? deviceEntity2.panelDisplayMode : i29, (i48 & 268435456) != 0 ? deviceEntity2.hoverEnabled : z20, (i48 & 536870912) != 0 ? deviceEntity2.airRefreshEnabled : z21, (i48 & 1073741824) != 0 ? deviceEntity2.airRefreshStatus : i30, (i48 & Integer.MIN_VALUE) != 0 ? deviceEntity2.airRefreshDuration : i31, (i49 & 1) != 0 ? deviceEntity2.airRefreshTimeStamp : i32, (i49 & 2) != 0 ? deviceEntity2.airRefreshStartTimeStamp : i33, (i49 & 4) != 0 ? deviceEntity2.airRefreshEndTimeStamp : i34, (i49 & 8) != 0 ? deviceEntity2.roomType : i35, (i49 & 16) != 0 ? deviceEntity2.nightLampBrightness : i36, (i49 & 32) != 0 ? deviceEntity2.wickdryDuration : i37, (i49 & 64) != 0 ? deviceEntity2.wickdryDone : z22, (i49 & 128) != 0 ? deviceEntity2.ywrmEnabled : bool3, (i49 & 256) != 0 ? deviceEntity2.ywrmUsage : i38, (i49 & 512) != 0 ? deviceEntity2.nightLampSteplessBrightness : i39, (i49 & 1024) != 0 ? deviceEntity2.alarms : list, (i49 & 2048) != 0 ? deviceEntity2.humSubMode : i40, (i49 & 4096) != 0 ? deviceEntity2.use24Hour : z23, (i49 & 8192) != 0 ? deviceEntity2.waterInfill : z24, (i49 & 16384) != 0 ? deviceEntity2.sensorMode : i41);
    }

    public final String component1() {
        return this.uid;
    }

    public final DeviceUuidEntity component10() {
        return this.deviceUuid;
    }

    public final int component100() {
        return this.roomType;
    }

    public final int component101() {
        return this.nightLampBrightness;
    }

    public final int component102() {
        return this.wickdryDuration;
    }

    public final boolean component103() {
        return this.wickdryDone;
    }

    public final Boolean component104() {
        return this.ywrmEnabled;
    }

    public final int component105() {
        return this.ywrmUsage;
    }

    public final int component106() {
        return this.nightLampSteplessBrightness;
    }

    public final List<DeviceAlarm> component107() {
        return this.alarms;
    }

    public final int component108() {
        return this.humSubMode;
    }

    public final boolean component109() {
        return this.use24Hour;
    }

    public final boolean component11() {
        return this.hasFinishedOnboarding;
    }

    public final boolean component110() {
        return this.waterInfill;
    }

    public final int component111() {
        return this.sensorMode;
    }

    public final IndoorDatapoint component12() {
        return this.latestSensorDatapoint;
    }

    public final Integer component13() {
        return this.lastSelectedSensorType;
    }

    public final boolean component14() {
        return this.isAblDevice;
    }

    public final boolean component15() {
        return this.isNightModeOn;
    }

    public final boolean component16() {
        return this.isChildLockOn;
    }

    public final String component17() {
        return this.linkedDeviceUid;
    }

    public final int component18() {
        return this.connectivityStatusIndex;
    }

    public final long component19() {
        return this.lastConnectivityMillis;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.mac;
    }

    public final String component21() {
        return this.mcuFirmware;
    }

    public final String component22() {
        return this.wifiFirmware;
    }

    public final String component23() {
        return this.hardware;
    }

    public final String component24() {
        return this.timeZone;
    }

    public final String component25() {
        return this.serial;
    }

    public final String component26() {
        return this.purchaseDate;
    }

    public final String component27() {
        return this.dealerName;
    }

    public final String component28() {
        return this.dealerCountry;
    }

    public final String component29() {
        return this.filterType;
    }

    public final String component3() {
        return this.modelName;
    }

    public final String component30() {
        return this.filterTrigger;
    }

    public final double[] component31() {
        return this.pm1Ranges;
    }

    public final double[] component32() {
        return this.pm10Ranges;
    }

    public final double[] component33() {
        return this.pm25Ranges;
    }

    public final double[] component34() {
        return this.vocRanges;
    }

    public final double[] component35() {
        return this.hchoRanges;
    }

    public final int component36() {
        return this.updateProgress;
    }

    public final boolean component37() {
        return this.isStandByOn;
    }

    public final boolean component38() {
        return this.isEcoModeOn;
    }

    public final boolean component39() {
        return this.isHinsModeOn;
    }

    public final int component4() {
        return this.typeIndex;
    }

    public final boolean component40() {
        return this.isHinsNightModeOn;
    }

    public final boolean component41() {
        return this.isG4NightModeOn;
    }

    public final boolean component42() {
        return this.isGermShieldOn;
    }

    public final Boolean component43() {
        return this.isGermShieldNightModeOn;
    }

    public final boolean component44() {
        return this.isSafetySwitchOn;
    }

    public final String component45() {
        return this.g4NightModefilterTrigger;
    }

    public final boolean component46() {
        return this.aimInstalled;
    }

    public final String component47() {
        return this.sku;
    }

    public final String component48() {
        return this.compatibility;
    }

    public final WelcomeHomeLocation component49() {
        return this.welcomeHome;
    }

    public final Integer component5() {
        return this.fanSpeed;
    }

    public final String component50() {
        return this.locationId;
    }

    public final Boolean component51() {
        return this.disinfection;
    }

    public final Integer component52() {
        return this.disinfectLeftTime;
    }

    public final Long component53() {
        return this.disinfectLeftTimeUpdateTime;
    }

    public final boolean component54() {
        return this.wickdryEnabled;
    }

    public final boolean component55() {
        return this.wickdryOn;
    }

    public final int component56() {
        return this.wickdryLeftTime;
    }

    public final long component57() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int component58() {
        return this.wickUsage;
    }

    public final boolean component59() {
        return this.waterShortage;
    }

    public final Integer component6() {
        return this.filterLife;
    }

    public final int component60() {
        return this.autoRh;
    }

    public final int component61() {
        return this.timerStatus;
    }

    public final int component62() {
        return this.timerDuration;
    }

    public final int component63() {
        return this.timerLeftTime;
    }

    public final long component64() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int component65() {
        return this.temperatureUnit;
    }

    public final int component66() {
        return this.oscillationState;
    }

    public final int component67() {
        return this.oscillationAngle;
    }

    public final int component68() {
        return this.oscillationDirection;
    }

    public final int component69() {
        return this.oscillationFanSpeed;
    }

    public final String component7() {
        return this.autoModeText;
    }

    public final int component70() {
        return this.mainMode;
    }

    public final int component71() {
        return this.apSubMode;
    }

    public final int component72() {
        return this.apFanSpeed;
    }

    public final int component73() {
        return this.heatSubMode;
    }

    public final int component74() {
        return this.heatFanSpeed;
    }

    public final double component75() {
        return this.heatAutoTmp;
    }

    public final double component76() {
        return this.heatEcoTmp;
    }

    public final int component77() {
        return this.coolSubMode;
    }

    public final int component78() {
        return this.coolFanSpeed;
    }

    public final int component79() {
        return this.coolAutoTag;
    }

    public final Integer component8() {
        return this.brightness;
    }

    public final double[] component80() {
        return this.coolAutoPresets;
    }

    public final int component81() {
        return this.coolEcoTag;
    }

    public final double[] component82() {
        return this.coolEcoPresets;
    }

    public final boolean component83() {
        return this.humMode;
    }

    public final int component84() {
        return this.mode;
    }

    public final int component85() {
        return this.waterLevel;
    }

    public final int component86() {
        return this.dehSubMode;
    }

    public final boolean component87() {
        return this.waterTankFailure;
    }

    public final int component88() {
        return this.smartSubMode;
    }

    public final boolean component89() {
        return this.detectCat;
    }

    public final String component9() {
        return this.info;
    }

    public final boolean component90() {
        return this.bodyMounted;
    }

    public final int component91() {
        return this.cleanAirEta;
    }

    public final int component92() {
        return this.panelDisplayMode;
    }

    public final boolean component93() {
        return this.hoverEnabled;
    }

    public final boolean component94() {
        return this.airRefreshEnabled;
    }

    public final int component95() {
        return this.airRefreshStatus;
    }

    public final int component96() {
        return this.airRefreshDuration;
    }

    public final int component97() {
        return this.airRefreshTimeStamp;
    }

    public final int component98() {
        return this.airRefreshStartTimeStamp;
    }

    public final int component99() {
        return this.airRefreshEndTimeStamp;
    }

    public final DeviceEntity copy(String str, String str2, String str3, int i, Integer num, Integer num2, String str4, Integer num3, String str5, DeviceUuidEntity deviceUuidEntity, boolean z, IndoorDatapoint indoorDatapoint, Integer num4, boolean z2, boolean z3, boolean z4, String str6, int i2, long j, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i3, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, Boolean bool, boolean z11, String str18, boolean z12, String str19, String str20, WelcomeHomeLocation welcomeHomeLocation, String str21, Boolean bool2, Integer num5, Long l, boolean z13, boolean z14, int i4, long j2, int i5, boolean z15, int i6, int i7, int i8, int i9, long j3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, boolean z16, int i24, int i25, int i26, boolean z17, int i27, boolean z18, boolean z19, int i28, int i29, boolean z20, boolean z21, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, boolean z22, Boolean bool3, int i38, int i39, List<DeviceAlarm> list, int i40, boolean z23, boolean z24, int i41) {
        String str22 = str;
        Intrinsics.checkNotNullParameter(str22, "uid");
        String str23 = str2;
        Intrinsics.checkNotNullParameter(str23, "name");
        String str24 = str3;
        Intrinsics.checkNotNullParameter(str24, "modelName");
        Intrinsics.checkNotNullParameter(str7, AnalyticEvent.KEY_MAC);
        String str25 = str8;
        Intrinsics.checkNotNullParameter(str25, "mcuFirmware");
        String str26 = str9;
        Intrinsics.checkNotNullParameter(str26, "wifiFirmware");
        String str27 = str10;
        Intrinsics.checkNotNullParameter(str27, "hardware");
        String str28 = str11;
        Intrinsics.checkNotNullParameter(str28, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str29 = str12;
        Intrinsics.checkNotNullParameter(str29, "serial");
        String str30 = str13;
        Intrinsics.checkNotNullParameter(str30, "purchaseDate");
        String str31 = str14;
        Intrinsics.checkNotNullParameter(str31, "dealerName");
        String str32 = str15;
        Intrinsics.checkNotNullParameter(str32, "dealerCountry");
        String str33 = str16;
        Intrinsics.checkNotNullParameter(str33, "filterType");
        String str34 = str17;
        Intrinsics.checkNotNullParameter(str34, "filterTrigger");
        double[] dArr8 = dArr;
        Intrinsics.checkNotNullParameter(dArr8, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str18, "g4NightModefilterTrigger");
        Intrinsics.checkNotNullParameter(dArr6, "coolAutoPresets");
        Intrinsics.checkNotNullParameter(dArr7, "coolEcoPresets");
        Intrinsics.checkNotNullParameter(list, "alarms");
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        String str42 = str32;
        String str43 = str33;
        String str44 = str34;
        double[] dArr9 = dArr8;
        return new DeviceEntity(str22, str23, str24, i, num, num2, str4, num3, str5, deviceUuidEntity, z, indoorDatapoint, num4, z2, z3, z4, str6, i2, j, str7, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, dArr9, dArr2, dArr3, dArr4, dArr5, i3, z5, z6, z7, z8, z9, z10, bool, z11, str18, z12, str19, str20, welcomeHomeLocation, str21, bool2, num5, l, z13, z14, i4, j2, i5, z15, i6, i7, i8, i9, j3, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, d, d2, i20, i21, i22, dArr6, i23, dArr7, z16, i24, i25, i26, z17, i27, z18, z19, i28, i29, z20, z21, i30, i31, i32, i33, i34, i35, i36, i37, z22, bool3, i38, i39, list, i40, z23, z24, i41);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceEntity)) {
            return false;
        }
        DeviceEntity deviceEntity = (DeviceEntity) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceEntity.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceEntity.name) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceEntity.modelName) && this.typeIndex == deviceEntity.typeIndex && Intrinsics.areEqual((Object) this.fanSpeed, (Object) deviceEntity.fanSpeed) && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceEntity.filterLife) && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceEntity.autoModeText) && Intrinsics.areEqual((Object) this.brightness, (Object) deviceEntity.brightness) && Intrinsics.areEqual((Object) this.info, (Object) deviceEntity.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceEntity.deviceUuid) && this.hasFinishedOnboarding == deviceEntity.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceEntity.latestSensorDatapoint) && Intrinsics.areEqual((Object) this.lastSelectedSensorType, (Object) deviceEntity.lastSelectedSensorType) && this.isAblDevice == deviceEntity.isAblDevice && this.isNightModeOn == deviceEntity.isNightModeOn && this.isChildLockOn == deviceEntity.isChildLockOn && Intrinsics.areEqual((Object) this.linkedDeviceUid, (Object) deviceEntity.linkedDeviceUid) && this.connectivityStatusIndex == deviceEntity.connectivityStatusIndex && this.lastConnectivityMillis == deviceEntity.lastConnectivityMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceEntity.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceEntity.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceEntity.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceEntity.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceEntity.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceEntity.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceEntity.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceEntity.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceEntity.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceEntity.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceEntity.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceEntity.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceEntity.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceEntity.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceEntity.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceEntity.hchoRanges) && this.updateProgress == deviceEntity.updateProgress && this.isStandByOn == deviceEntity.isStandByOn && this.isEcoModeOn == deviceEntity.isEcoModeOn && this.isHinsModeOn == deviceEntity.isHinsModeOn && this.isHinsNightModeOn == deviceEntity.isHinsNightModeOn && this.isG4NightModeOn == deviceEntity.isG4NightModeOn && this.isGermShieldOn == deviceEntity.isGermShieldOn && Intrinsics.areEqual((Object) this.isGermShieldNightModeOn, (Object) deviceEntity.isGermShieldNightModeOn) && this.isSafetySwitchOn == deviceEntity.isSafetySwitchOn && Intrinsics.areEqual((Object) this.g4NightModefilterTrigger, (Object) deviceEntity.g4NightModefilterTrigger) && this.aimInstalled == deviceEntity.aimInstalled && Intrinsics.areEqual((Object) this.sku, (Object) deviceEntity.sku) && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceEntity.compatibility) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceEntity.welcomeHome) && Intrinsics.areEqual((Object) this.locationId, (Object) deviceEntity.locationId) && Intrinsics.areEqual((Object) this.disinfection, (Object) deviceEntity.disinfection) && Intrinsics.areEqual((Object) this.disinfectLeftTime, (Object) deviceEntity.disinfectLeftTime) && Intrinsics.areEqual((Object) this.disinfectLeftTimeUpdateTime, (Object) deviceEntity.disinfectLeftTimeUpdateTime) && this.wickdryEnabled == deviceEntity.wickdryEnabled && this.wickdryOn == deviceEntity.wickdryOn && this.wickdryLeftTime == deviceEntity.wickdryLeftTime && this.wickdryLeftTimeUpdateTime == deviceEntity.wickdryLeftTimeUpdateTime && this.wickUsage == deviceEntity.wickUsage && this.waterShortage == deviceEntity.waterShortage && this.autoRh == deviceEntity.autoRh && this.timerStatus == deviceEntity.timerStatus && this.timerDuration == deviceEntity.timerDuration && this.timerLeftTime == deviceEntity.timerLeftTime && this.timerLeftTimeUpdateTime == deviceEntity.timerLeftTimeUpdateTime && this.temperatureUnit == deviceEntity.temperatureUnit && this.oscillationState == deviceEntity.oscillationState && this.oscillationAngle == deviceEntity.oscillationAngle && this.oscillationDirection == deviceEntity.oscillationDirection && this.oscillationFanSpeed == deviceEntity.oscillationFanSpeed && this.mainMode == deviceEntity.mainMode && this.apSubMode == deviceEntity.apSubMode && this.apFanSpeed == deviceEntity.apFanSpeed && this.heatSubMode == deviceEntity.heatSubMode && this.heatFanSpeed == deviceEntity.heatFanSpeed && Double.compare(this.heatAutoTmp, deviceEntity.heatAutoTmp) == 0 && Double.compare(this.heatEcoTmp, deviceEntity.heatEcoTmp) == 0 && this.coolSubMode == deviceEntity.coolSubMode && this.coolFanSpeed == deviceEntity.coolFanSpeed && this.coolAutoTag == deviceEntity.coolAutoTag && Intrinsics.areEqual((Object) this.coolAutoPresets, (Object) deviceEntity.coolAutoPresets) && this.coolEcoTag == deviceEntity.coolEcoTag && Intrinsics.areEqual((Object) this.coolEcoPresets, (Object) deviceEntity.coolEcoPresets) && this.humMode == deviceEntity.humMode && this.mode == deviceEntity.mode && this.waterLevel == deviceEntity.waterLevel && this.dehSubMode == deviceEntity.dehSubMode && this.waterTankFailure == deviceEntity.waterTankFailure && this.smartSubMode == deviceEntity.smartSubMode && this.detectCat == deviceEntity.detectCat && this.bodyMounted == deviceEntity.bodyMounted && this.cleanAirEta == deviceEntity.cleanAirEta && this.panelDisplayMode == deviceEntity.panelDisplayMode && this.hoverEnabled == deviceEntity.hoverEnabled && this.airRefreshEnabled == deviceEntity.airRefreshEnabled && this.airRefreshStatus == deviceEntity.airRefreshStatus && this.airRefreshDuration == deviceEntity.airRefreshDuration && this.airRefreshTimeStamp == deviceEntity.airRefreshTimeStamp && this.airRefreshStartTimeStamp == deviceEntity.airRefreshStartTimeStamp && this.airRefreshEndTimeStamp == deviceEntity.airRefreshEndTimeStamp && this.roomType == deviceEntity.roomType && this.nightLampBrightness == deviceEntity.nightLampBrightness && this.wickdryDuration == deviceEntity.wickdryDuration && this.wickdryDone == deviceEntity.wickdryDone && Intrinsics.areEqual((Object) this.ywrmEnabled, (Object) deviceEntity.ywrmEnabled) && this.ywrmUsage == deviceEntity.ywrmUsage && this.nightLampSteplessBrightness == deviceEntity.nightLampSteplessBrightness && Intrinsics.areEqual((Object) this.alarms, (Object) deviceEntity.alarms) && this.humSubMode == deviceEntity.humSubMode && this.use24Hour == deviceEntity.use24Hour && this.waterInfill == deviceEntity.waterInfill && this.sensorMode == deviceEntity.sensorMode;
    }

    public int hashCode() {
        int hashCode = ((((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        Integer num = this.fanSpeed;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.filterLife;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.autoModeText;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.brightness;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.info;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeviceUuidEntity deviceUuidEntity = this.deviceUuid;
        int hashCode7 = (((hashCode6 + (deviceUuidEntity == null ? 0 : deviceUuidEntity.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding)) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode8 = (hashCode7 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31;
        Integer num4 = this.lastSelectedSensorType;
        int hashCode9 = (((((((hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isAblDevice)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31;
        String str3 = this.linkedDeviceUid;
        int hashCode10 = (((((((((((((((((((((((((((((((((((((((((((((((((((hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isEcoModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsNightModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isGermShieldOn)) * 31;
        Boolean bool = this.isGermShieldNightModeOn;
        int hashCode11 = (((((((hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isSafetySwitchOn)) * 31) + this.g4NightModefilterTrigger.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.aimInstalled)) * 31;
        String str4 = this.sku;
        int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.compatibility;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        int hashCode14 = (hashCode13 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31;
        String str6 = this.locationId;
        int hashCode15 = (hashCode14 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool2 = this.disinfection;
        int hashCode16 = (hashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num5 = this.disinfectLeftTime;
        int hashCode17 = (hashCode16 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Long l = this.disinfectLeftTimeUpdateTime;
        int hashCode18 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode17 + (l == null ? 0 : l.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn)) * 31) + this.wickdryLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime)) * 31) + this.wickUsage) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage)) * 31) + this.autoRh) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + this.temperatureUnit) * 31) + this.oscillationState) * 31) + this.oscillationAngle) * 31) + this.oscillationDirection) * 31) + this.oscillationFanSpeed) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.apFanSpeed) * 31) + this.heatSubMode) * 31) + this.heatFanSpeed) * 31) + Double.doubleToLongBits(this.heatAutoTmp)) * 31) + Double.doubleToLongBits(this.heatEcoTmp)) * 31) + this.coolSubMode) * 31) + this.coolFanSpeed) * 31) + this.coolAutoTag) * 31) + Arrays.hashCode(this.coolAutoPresets)) * 31) + this.coolEcoTag) * 31) + Arrays.hashCode(this.coolEcoPresets)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.humMode)) * 31) + this.mode) * 31) + this.waterLevel) * 31) + this.dehSubMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterTankFailure)) * 31) + this.smartSubMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.detectCat)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.bodyMounted)) * 31) + this.cleanAirEta) * 31) + this.panelDisplayMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hoverEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.airRefreshEnabled)) * 31) + this.airRefreshStatus) * 31) + this.airRefreshDuration) * 31) + this.airRefreshTimeStamp) * 31) + this.airRefreshStartTimeStamp) * 31) + this.airRefreshEndTimeStamp) * 31) + this.roomType) * 31) + this.nightLampBrightness) * 31) + this.wickdryDuration) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryDone)) * 31;
        Boolean bool3 = this.ywrmEnabled;
        if (bool3 != null) {
            i = bool3.hashCode();
        }
        return ((((((((((((((hashCode18 + i) * 31) + this.ywrmUsage) * 31) + this.nightLampSteplessBrightness) * 31) + this.alarms.hashCode()) * 31) + this.humSubMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.use24Hour)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterInfill)) * 31) + this.sensorMode;
    }

    public String toString() {
        return "DeviceEntity(uid=" + this.uid + ", name=" + this.name + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", autoModeText=" + this.autoModeText + ", brightness=" + this.brightness + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorType=" + this.lastSelectedSensorType + ", isAblDevice=" + this.isAblDevice + ", isNightModeOn=" + this.isNightModeOn + ", isChildLockOn=" + this.isChildLockOn + ", linkedDeviceUid=" + this.linkedDeviceUid + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityMillis=" + this.lastConnectivityMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isEcoModeOn=" + this.isEcoModeOn + ", isHinsModeOn=" + this.isHinsModeOn + ", isHinsNightModeOn=" + this.isHinsNightModeOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", isGermShieldOn=" + this.isGermShieldOn + ", isGermShieldNightModeOn=" + this.isGermShieldNightModeOn + ", isSafetySwitchOn=" + this.isSafetySwitchOn + ", g4NightModefilterTrigger=" + this.g4NightModefilterTrigger + ", aimInstalled=" + this.aimInstalled + ", sku=" + this.sku + ", compatibility=" + this.compatibility + ", welcomeHome=" + this.welcomeHome + ", locationId=" + this.locationId + ", disinfection=" + this.disinfection + ", disinfectLeftTime=" + this.disinfectLeftTime + ", disinfectLeftTimeUpdateTime=" + this.disinfectLeftTimeUpdateTime + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", autoRh=" + this.autoRh + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", temperatureUnit=" + this.temperatureUnit + ", oscillationState=" + this.oscillationState + ", oscillationAngle=" + this.oscillationAngle + ", oscillationDirection=" + this.oscillationDirection + ", oscillationFanSpeed=" + this.oscillationFanSpeed + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", apFanSpeed=" + this.apFanSpeed + ", heatSubMode=" + this.heatSubMode + ", heatFanSpeed=" + this.heatFanSpeed + ", heatAutoTmp=" + this.heatAutoTmp + ", heatEcoTmp=" + this.heatEcoTmp + ", coolSubMode=" + this.coolSubMode + ", coolFanSpeed=" + this.coolFanSpeed + ", coolAutoTag=" + this.coolAutoTag + ", coolAutoPresets=" + Arrays.toString(this.coolAutoPresets) + ", coolEcoTag=" + this.coolEcoTag + ", coolEcoPresets=" + Arrays.toString(this.coolEcoPresets) + ", humMode=" + this.humMode + ", mode=" + this.mode + ", waterLevel=" + this.waterLevel + ", dehSubMode=" + this.dehSubMode + ", waterTankFailure=" + this.waterTankFailure + ", smartSubMode=" + this.smartSubMode + ", detectCat=" + this.detectCat + ", bodyMounted=" + this.bodyMounted + ", cleanAirEta=" + this.cleanAirEta + ", panelDisplayMode=" + this.panelDisplayMode + ", hoverEnabled=" + this.hoverEnabled + ", airRefreshEnabled=" + this.airRefreshEnabled + ", airRefreshStatus=" + this.airRefreshStatus + ", airRefreshDuration=" + this.airRefreshDuration + ", airRefreshTimeStamp=" + this.airRefreshTimeStamp + ", airRefreshStartTimeStamp=" + this.airRefreshStartTimeStamp + ", airRefreshEndTimeStamp=" + this.airRefreshEndTimeStamp + ", roomType=" + this.roomType + ", nightLampBrightness=" + this.nightLampBrightness + ", wickdryDuration=" + this.wickdryDuration + ", wickdryDone=" + this.wickdryDone + ", ywrmEnabled=" + this.ywrmEnabled + ", ywrmUsage=" + this.ywrmUsage + ", nightLampSteplessBrightness=" + this.nightLampSteplessBrightness + ", alarms=" + this.alarms + ", humSubMode=" + this.humSubMode + ", use24Hour=" + this.use24Hour + ", waterInfill=" + this.waterInfill + ", sensorMode=" + this.sensorMode + ')';
    }

    public DeviceEntity(String str, String str2, String str3, int i, Integer num, Integer num2, String str4, Integer num3, String str5, DeviceUuidEntity deviceUuidEntity, boolean z, IndoorDatapoint indoorDatapoint, Integer num4, boolean z2, boolean z3, boolean z4, String str6, int i2, long j, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i3, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, Boolean bool, boolean z11, String str18, boolean z12, String str19, String str20, WelcomeHomeLocation welcomeHomeLocation, String str21, Boolean bool2, Integer num5, Long l, boolean z13, boolean z14, int i4, long j2, int i5, boolean z15, int i6, int i7, int i8, int i9, long j3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, boolean z16, int i24, int i25, int i26, boolean z17, int i27, boolean z18, boolean z19, int i28, int i29, boolean z20, boolean z21, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, boolean z22, Boolean bool3, int i38, int i39, List<DeviceAlarm> list, int i40, boolean z23, boolean z24, int i41) {
        String str22 = str;
        String str23 = str2;
        String str24 = str3;
        String str25 = str7;
        String str26 = str8;
        String str27 = str9;
        String str28 = str10;
        String str29 = str11;
        String str30 = str12;
        String str31 = str13;
        String str32 = str14;
        String str33 = str15;
        String str34 = str16;
        String str35 = str17;
        Intrinsics.checkNotNullParameter(str22, "uid");
        Intrinsics.checkNotNullParameter(str23, "name");
        Intrinsics.checkNotNullParameter(str24, "modelName");
        Intrinsics.checkNotNullParameter(str25, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str26, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str27, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str28, "hardware");
        Intrinsics.checkNotNullParameter(str29, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str30, "serial");
        Intrinsics.checkNotNullParameter(str31, "purchaseDate");
        Intrinsics.checkNotNullParameter(str32, "dealerName");
        Intrinsics.checkNotNullParameter(str33, "dealerCountry");
        Intrinsics.checkNotNullParameter(str34, "filterType");
        Intrinsics.checkNotNullParameter(str35, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str18, "g4NightModefilterTrigger");
        Intrinsics.checkNotNullParameter(dArr6, "coolAutoPresets");
        Intrinsics.checkNotNullParameter(dArr7, "coolEcoPresets");
        List<DeviceAlarm> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "alarms");
        this.uid = str22;
        this.name = str23;
        this.modelName = str24;
        this.typeIndex = i;
        this.fanSpeed = num;
        this.filterLife = num2;
        this.autoModeText = str4;
        this.brightness = num3;
        this.info = str5;
        this.deviceUuid = deviceUuidEntity;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorType = num4;
        this.isAblDevice = z2;
        this.isNightModeOn = z3;
        this.isChildLockOn = z4;
        this.linkedDeviceUid = str6;
        this.connectivityStatusIndex = i2;
        this.lastConnectivityMillis = j;
        this.mac = str25;
        this.mcuFirmware = str26;
        this.wifiFirmware = str27;
        this.hardware = str28;
        this.timeZone = str29;
        this.serial = str30;
        this.purchaseDate = str31;
        this.dealerName = str32;
        this.dealerCountry = str33;
        this.filterType = str34;
        this.filterTrigger = str35;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i3;
        this.isStandByOn = z5;
        this.isEcoModeOn = z6;
        this.isHinsModeOn = z7;
        this.isHinsNightModeOn = z8;
        this.isG4NightModeOn = z9;
        this.isGermShieldOn = z10;
        this.isGermShieldNightModeOn = bool;
        this.isSafetySwitchOn = z11;
        this.g4NightModefilterTrigger = str18;
        this.aimInstalled = z12;
        this.sku = str19;
        this.compatibility = str20;
        this.welcomeHome = welcomeHomeLocation;
        this.locationId = str21;
        this.disinfection = bool2;
        this.disinfectLeftTime = num5;
        this.disinfectLeftTimeUpdateTime = l;
        this.wickdryEnabled = z13;
        this.wickdryOn = z14;
        this.wickdryLeftTime = i4;
        this.wickdryLeftTimeUpdateTime = j2;
        this.wickUsage = i5;
        this.waterShortage = z15;
        this.autoRh = i6;
        this.timerStatus = i7;
        this.timerDuration = i8;
        this.timerLeftTime = i9;
        this.timerLeftTimeUpdateTime = j3;
        this.temperatureUnit = i10;
        this.oscillationState = i11;
        this.oscillationAngle = i12;
        this.oscillationDirection = i13;
        this.oscillationFanSpeed = i14;
        this.mainMode = i15;
        this.apSubMode = i16;
        this.apFanSpeed = i17;
        this.heatSubMode = i18;
        this.heatFanSpeed = i19;
        this.heatAutoTmp = d;
        this.heatEcoTmp = d2;
        this.coolSubMode = i20;
        this.coolFanSpeed = i21;
        this.coolAutoTag = i22;
        this.coolAutoPresets = dArr6;
        this.coolEcoTag = i23;
        this.coolEcoPresets = dArr7;
        this.humMode = z16;
        this.mode = i24;
        this.waterLevel = i25;
        this.dehSubMode = i26;
        this.waterTankFailure = z17;
        this.smartSubMode = i27;
        this.detectCat = z18;
        this.bodyMounted = z19;
        this.cleanAirEta = i28;
        this.panelDisplayMode = i29;
        this.hoverEnabled = z20;
        this.airRefreshEnabled = z21;
        this.airRefreshStatus = i30;
        this.airRefreshDuration = i31;
        this.airRefreshTimeStamp = i32;
        this.airRefreshStartTimeStamp = i33;
        this.airRefreshEndTimeStamp = i34;
        this.roomType = i35;
        this.nightLampBrightness = i36;
        this.wickdryDuration = i37;
        this.wickdryDone = z22;
        this.ywrmEnabled = bool3;
        this.ywrmUsage = i38;
        this.nightLampSteplessBrightness = i39;
        this.alarms = list2;
        this.humSubMode = i40;
        this.use24Hour = z23;
        this.waterInfill = z24;
        this.sensorMode = i41;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceEntity(java.lang.String r124, java.lang.String r125, java.lang.String r126, int r127, java.lang.Integer r128, java.lang.Integer r129, java.lang.String r130, java.lang.Integer r131, java.lang.String r132, com.blueair.database.DeviceUuidEntity r133, boolean r134, com.blueair.core.model.IndoorDatapoint r135, java.lang.Integer r136, boolean r137, boolean r138, boolean r139, java.lang.String r140, int r141, long r142, java.lang.String r144, java.lang.String r145, java.lang.String r146, java.lang.String r147, java.lang.String r148, java.lang.String r149, java.lang.String r150, java.lang.String r151, java.lang.String r152, java.lang.String r153, java.lang.String r154, double[] r155, double[] r156, double[] r157, double[] r158, double[] r159, int r160, boolean r161, boolean r162, boolean r163, boolean r164, boolean r165, boolean r166, java.lang.Boolean r167, boolean r168, java.lang.String r169, boolean r170, java.lang.String r171, java.lang.String r172, com.blueair.core.model.WelcomeHomeLocation r173, java.lang.String r174, java.lang.Boolean r175, java.lang.Integer r176, java.lang.Long r177, boolean r178, boolean r179, int r180, long r181, int r183, boolean r184, int r185, int r186, int r187, int r188, long r189, int r191, int r192, int r193, int r194, int r195, int r196, int r197, int r198, int r199, int r200, double r201, double r203, int r205, int r206, int r207, double[] r208, int r209, double[] r210, boolean r211, int r212, int r213, int r214, boolean r215, int r216, boolean r217, boolean r218, int r219, int r220, boolean r221, boolean r222, int r223, int r224, int r225, int r226, int r227, int r228, int r229, int r230, boolean r231, java.lang.Boolean r232, int r233, int r234, java.util.List r235, int r236, boolean r237, boolean r238, int r239, int r240, int r241, int r242, int r243, kotlin.jvm.internal.DefaultConstructorMarker r244) {
        /*
            r123 = this;
            r0 = r240
            r1 = r241
            r2 = r242
            r3 = r243
            r4 = r0 & 16
            r5 = 0
            if (r4 == 0) goto L_0x000f
            r11 = r5
            goto L_0x0011
        L_0x000f:
            r11 = r128
        L_0x0011:
            r4 = r0 & 32
            if (r4 == 0) goto L_0x0017
            r12 = r5
            goto L_0x0019
        L_0x0017:
            r12 = r129
        L_0x0019:
            r4 = r0 & 64
            if (r4 == 0) goto L_0x001f
            r13 = r5
            goto L_0x0021
        L_0x001f:
            r13 = r130
        L_0x0021:
            r4 = r0 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0027
            r14 = r5
            goto L_0x0029
        L_0x0027:
            r14 = r131
        L_0x0029:
            r4 = r0 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x002f
            r15 = r5
            goto L_0x0031
        L_0x002f:
            r15 = r132
        L_0x0031:
            r4 = r0 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0038
            r16 = r5
            goto L_0x003a
        L_0x0038:
            r16 = r133
        L_0x003a:
            r4 = r0 & 1024(0x400, float:1.435E-42)
            r6 = 0
            if (r4 == 0) goto L_0x0042
            r17 = r6
            goto L_0x0044
        L_0x0042:
            r17 = r134
        L_0x0044:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x004b
            r21 = r6
            goto L_0x004d
        L_0x004b:
            r21 = r138
        L_0x004d:
            r4 = 32768(0x8000, float:4.5918E-41)
            r7 = r0 & r4
            if (r7 == 0) goto L_0x0057
            r22 = r6
            goto L_0x0059
        L_0x0057:
            r22 = r139
        L_0x0059:
            r7 = 65536(0x10000, float:9.18355E-41)
            r8 = r0 & r7
            if (r8 == 0) goto L_0x0062
            r23 = r5
            goto L_0x0064
        L_0x0062:
            r23 = r140
        L_0x0064:
            r8 = 524288(0x80000, float:7.34684E-40)
            r9 = r0 & r8
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x006f
            r27 = r10
            goto L_0x0071
        L_0x006f:
            r27 = r144
        L_0x0071:
            r9 = 1048576(0x100000, float:1.469368E-39)
            r18 = r0 & r9
            if (r18 == 0) goto L_0x007a
            r28 = r10
            goto L_0x007c
        L_0x007a:
            r28 = r145
        L_0x007c:
            r18 = 2097152(0x200000, float:2.938736E-39)
            r19 = r0 & r18
            if (r19 == 0) goto L_0x0085
            r29 = r10
            goto L_0x0087
        L_0x0085:
            r29 = r146
        L_0x0087:
            r19 = 4194304(0x400000, float:5.877472E-39)
            r20 = r0 & r19
            if (r20 == 0) goto L_0x0090
            r30 = r10
            goto L_0x0092
        L_0x0090:
            r30 = r147
        L_0x0092:
            r20 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r20
            if (r24 == 0) goto L_0x009b
            r31 = r10
            goto L_0x009d
        L_0x009b:
            r31 = r148
        L_0x009d:
            r24 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x00a6
            r32 = r10
            goto L_0x00a8
        L_0x00a6:
            r32 = r149
        L_0x00a8:
            r25 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r25
            if (r26 == 0) goto L_0x00b1
            r33 = r10
            goto L_0x00b3
        L_0x00b1:
            r33 = r150
        L_0x00b3:
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00bc
            r34 = r10
            goto L_0x00be
        L_0x00bc:
            r34 = r151
        L_0x00be:
            r26 = 134217728(0x8000000, float:3.85186E-34)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00c7
            r35 = r10
            goto L_0x00c9
        L_0x00c7:
            r35 = r152
        L_0x00c9:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d2
            r36 = r10
            goto L_0x00d4
        L_0x00d2:
            r36 = r153
        L_0x00d4:
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00dd
            r37 = r10
            goto L_0x00df
        L_0x00dd:
            r37 = r154
        L_0x00df:
            r26 = 1073741824(0x40000000, float:2.0)
            r26 = r0 & r26
            r128 = r4
            if (r26 == 0) goto L_0x00ec
            double[] r4 = new double[r6]
            r38 = r4
            goto L_0x00ee
        L_0x00ec:
            r38 = r155
        L_0x00ee:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x00f8
            double[] r0 = new double[r6]
            r39 = r0
            goto L_0x00fa
        L_0x00f8:
            r39 = r156
        L_0x00fa:
            r0 = r1 & 1
            if (r0 == 0) goto L_0x0103
            double[] r0 = new double[r6]
            r40 = r0
            goto L_0x0105
        L_0x0103:
            r40 = r157
        L_0x0105:
            r0 = r1 & 2
            if (r0 == 0) goto L_0x010e
            double[] r0 = new double[r6]
            r41 = r0
            goto L_0x0110
        L_0x010e:
            r41 = r158
        L_0x0110:
            r0 = r1 & 4
            if (r0 == 0) goto L_0x0119
            double[] r0 = new double[r6]
            r42 = r0
            goto L_0x011b
        L_0x0119:
            r42 = r159
        L_0x011b:
            r0 = r1 & 8
            if (r0 == 0) goto L_0x0122
            r43 = r6
            goto L_0x0124
        L_0x0122:
            r43 = r160
        L_0x0124:
            r0 = r1 & 16
            if (r0 == 0) goto L_0x012b
            r44 = r6
            goto L_0x012d
        L_0x012b:
            r44 = r161
        L_0x012d:
            r0 = r1 & 32
            if (r0 == 0) goto L_0x0134
            r45 = r6
            goto L_0x0136
        L_0x0134:
            r45 = r162
        L_0x0136:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x013d
            r46 = r6
            goto L_0x013f
        L_0x013d:
            r46 = r163
        L_0x013f:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0146
            r47 = r6
            goto L_0x0148
        L_0x0146:
            r47 = r164
        L_0x0148:
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x014f
            r48 = r6
            goto L_0x0151
        L_0x014f:
            r48 = r165
        L_0x0151:
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0158
            r49 = r6
            goto L_0x015a
        L_0x0158:
            r49 = r166
        L_0x015a:
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0161
            r50 = r5
            goto L_0x0163
        L_0x0161:
            r50 = r167
        L_0x0163:
            r0 = r1 & 2048(0x800, float:2.87E-42)
            r4 = 1
            if (r0 == 0) goto L_0x016b
            r51 = r4
            goto L_0x016d
        L_0x016b:
            r51 = r168
        L_0x016d:
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0174
            r52 = r10
            goto L_0x0176
        L_0x0174:
            r52 = r169
        L_0x0176:
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x017d
            r53 = r6
            goto L_0x017f
        L_0x017d:
            r53 = r170
        L_0x017f:
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0186
            r54 = r5
            goto L_0x0188
        L_0x0186:
            r54 = r171
        L_0x0188:
            r0 = r1 & r128
            if (r0 == 0) goto L_0x018f
            r55 = r5
            goto L_0x0191
        L_0x018f:
            r55 = r172
        L_0x0191:
            r0 = r1 & r7
            if (r0 == 0) goto L_0x0198
            r56 = r5
            goto L_0x019a
        L_0x0198:
            r56 = r173
        L_0x019a:
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x01a2
            r57 = r5
            goto L_0x01a4
        L_0x01a2:
            r57 = r174
        L_0x01a4:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x01ac
            r58 = r5
            goto L_0x01ae
        L_0x01ac:
            r58 = r175
        L_0x01ae:
            r0 = r1 & r8
            if (r0 == 0) goto L_0x01b5
            r59 = r5
            goto L_0x01b7
        L_0x01b5:
            r59 = r176
        L_0x01b7:
            r0 = r1 & r9
            if (r0 == 0) goto L_0x01be
            r60 = r5
            goto L_0x01c0
        L_0x01be:
            r60 = r177
        L_0x01c0:
            r0 = r1 & r18
            if (r0 == 0) goto L_0x01c7
            r61 = r6
            goto L_0x01c9
        L_0x01c7:
            r61 = r178
        L_0x01c9:
            r0 = r1 & r19
            if (r0 == 0) goto L_0x01d0
            r62 = r6
            goto L_0x01d2
        L_0x01d0:
            r62 = r179
        L_0x01d2:
            r0 = r1 & r20
            if (r0 == 0) goto L_0x01d9
            r63 = r6
            goto L_0x01db
        L_0x01d9:
            r63 = r180
        L_0x01db:
            r0 = r1 & r24
            if (r0 == 0) goto L_0x01e2
            r64 = 0
            goto L_0x01e4
        L_0x01e2:
            r64 = r181
        L_0x01e4:
            r0 = r1 & r25
            if (r0 == 0) goto L_0x01eb
            r66 = r6
            goto L_0x01ed
        L_0x01eb:
            r66 = r183
        L_0x01ed:
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x01f5
            r67 = r6
            goto L_0x01f7
        L_0x01f5:
            r67 = r184
        L_0x01f7:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0201
            r0 = 50
            r68 = r0
            goto L_0x0203
        L_0x0201:
            r68 = r185
        L_0x0203:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x020b
            r69 = r6
            goto L_0x020d
        L_0x020b:
            r69 = r186
        L_0x020d:
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0215
            r70 = r6
            goto L_0x0217
        L_0x0215:
            r70 = r187
        L_0x0217:
            r0 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x021f
            r71 = r6
            goto L_0x0221
        L_0x021f:
            r71 = r188
        L_0x0221:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x022b
            r0 = 0
            r72 = r0
            goto L_0x022d
        L_0x022b:
            r72 = r189
        L_0x022d:
            r0 = r2 & 1
            if (r0 == 0) goto L_0x0234
            r74 = r6
            goto L_0x0236
        L_0x0234:
            r74 = r191
        L_0x0236:
            r0 = r2 & 2
            if (r0 == 0) goto L_0x023d
            r75 = r6
            goto L_0x023f
        L_0x023d:
            r75 = r192
        L_0x023f:
            r0 = r2 & 4
            if (r0 == 0) goto L_0x0248
            r0 = 90
            r76 = r0
            goto L_0x024a
        L_0x0248:
            r76 = r193
        L_0x024a:
            r0 = r2 & 8
            if (r0 == 0) goto L_0x0251
            r77 = r6
            goto L_0x0253
        L_0x0251:
            r77 = r194
        L_0x0253:
            r0 = r2 & 16
            if (r0 == 0) goto L_0x025a
            r78 = r6
            goto L_0x025c
        L_0x025a:
            r78 = r195
        L_0x025c:
            r0 = r2 & 32
            if (r0 == 0) goto L_0x0263
            r79 = r6
            goto L_0x0265
        L_0x0263:
            r79 = r196
        L_0x0265:
            r0 = r2 & 64
            r1 = 2
            if (r0 == 0) goto L_0x026d
            r80 = r1
            goto L_0x026f
        L_0x026d:
            r80 = r197
        L_0x026f:
            r0 = r2 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0276
            r81 = r6
            goto L_0x0278
        L_0x0276:
            r81 = r198
        L_0x0278:
            r0 = r2 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x027f
            r82 = r1
            goto L_0x0281
        L_0x027f:
            r82 = r199
        L_0x0281:
            r0 = r2 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0288
            r83 = r6
            goto L_0x028a
        L_0x0288:
            r83 = r200
        L_0x028a:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0291
            r84 = 4626885667169763328(0x4036000000000000, double:22.0)
            goto L_0x0293
        L_0x0291:
            r84 = r201
        L_0x0293:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x029a
            r86 = 4626885667169763328(0x4036000000000000, double:22.0)
            goto L_0x029c
        L_0x029a:
            r86 = r203
        L_0x029c:
            r0 = r2 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02a3
            r88 = r1
            goto L_0x02a5
        L_0x02a3:
            r88 = r205
        L_0x02a5:
            r0 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x02ac
            r89 = r6
            goto L_0x02ae
        L_0x02ac:
            r89 = r206
        L_0x02ae:
            r0 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02b5
            r90 = r6
            goto L_0x02b7
        L_0x02b5:
            r90 = r207
        L_0x02b7:
            r0 = r2 & r128
            if (r0 == 0) goto L_0x02cd
            r0 = 3
            double[] r0 = new double[r0]
            r91 = 4626322717216342016(0x4034000000000000, double:20.0)
            r0[r6] = r91
            r91 = 4627167142146473984(0x4037000000000000, double:23.0)
            r0[r4] = r91
            r91 = 4627730092099895296(0x4039000000000000, double:25.0)
            r0[r1] = r91
            r91 = r0
            goto L_0x02cf
        L_0x02cd:
            r91 = r208
        L_0x02cf:
            r0 = r2 & r7
            if (r0 == 0) goto L_0x02d6
            r92 = r6
            goto L_0x02d8
        L_0x02d6:
            r92 = r209
        L_0x02d8:
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x02ea
            double[] r0 = new double[r1]
            r93 = 4626322717216342016(0x4034000000000000, double:20.0)
            r0[r6] = r93
            r93 = 4627730092099895296(0x4039000000000000, double:25.0)
            r0[r4] = r93
            r93 = r0
            goto L_0x02ec
        L_0x02ea:
            r93 = r210
        L_0x02ec:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x02f4
            r94 = r6
            goto L_0x02f6
        L_0x02f4:
            r94 = r211
        L_0x02f6:
            r0 = r2 & r8
            if (r0 == 0) goto L_0x02fd
            r95 = r4
            goto L_0x02ff
        L_0x02fd:
            r95 = r212
        L_0x02ff:
            r0 = r2 & r9
            if (r0 == 0) goto L_0x0306
            r96 = r6
            goto L_0x0308
        L_0x0306:
            r96 = r213
        L_0x0308:
            r0 = r2 & r18
            if (r0 == 0) goto L_0x030f
            r97 = r4
            goto L_0x0311
        L_0x030f:
            r97 = r214
        L_0x0311:
            r0 = r2 & r19
            if (r0 == 0) goto L_0x0318
            r98 = r6
            goto L_0x031a
        L_0x0318:
            r98 = r215
        L_0x031a:
            r0 = r2 & r20
            if (r0 == 0) goto L_0x0321
            r99 = r6
            goto L_0x0323
        L_0x0321:
            r99 = r216
        L_0x0323:
            r0 = r2 & r24
            if (r0 == 0) goto L_0x032a
            r100 = r6
            goto L_0x032c
        L_0x032a:
            r100 = r217
        L_0x032c:
            r0 = r2 & r25
            if (r0 == 0) goto L_0x0333
            r101 = r4
            goto L_0x0335
        L_0x0333:
            r101 = r218
        L_0x0335:
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x033d
            r102 = r6
            goto L_0x033f
        L_0x033d:
            r102 = r219
        L_0x033f:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0347
            r103 = r6
            goto L_0x0349
        L_0x0347:
            r103 = r220
        L_0x0349:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0351
            r104 = r4
            goto L_0x0353
        L_0x0351:
            r104 = r221
        L_0x0353:
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x035b
            r105 = r4
            goto L_0x035d
        L_0x035b:
            r105 = r222
        L_0x035d:
            r0 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0365
            r106 = r6
            goto L_0x0367
        L_0x0365:
            r106 = r223
        L_0x0367:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x036f
            r107 = r6
            goto L_0x0371
        L_0x036f:
            r107 = r224
        L_0x0371:
            r0 = r3 & 1
            if (r0 == 0) goto L_0x0378
            r108 = r6
            goto L_0x037a
        L_0x0378:
            r108 = r225
        L_0x037a:
            r0 = r3 & 2
            if (r0 == 0) goto L_0x0381
            r109 = r6
            goto L_0x0383
        L_0x0381:
            r109 = r226
        L_0x0383:
            r0 = r3 & 4
            if (r0 == 0) goto L_0x038a
            r110 = r6
            goto L_0x038c
        L_0x038a:
            r110 = r227
        L_0x038c:
            r0 = r3 & 8
            if (r0 == 0) goto L_0x0393
            r111 = r6
            goto L_0x0395
        L_0x0393:
            r111 = r228
        L_0x0395:
            r0 = r3 & 16
            if (r0 == 0) goto L_0x039c
            r112 = r6
            goto L_0x039e
        L_0x039c:
            r112 = r229
        L_0x039e:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x03a5
            r113 = r6
            goto L_0x03a7
        L_0x03a5:
            r113 = r230
        L_0x03a7:
            r0 = r3 & 64
            if (r0 == 0) goto L_0x03ae
            r114 = r6
            goto L_0x03b0
        L_0x03ae:
            r114 = r231
        L_0x03b0:
            r0 = r3 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03b7
            r115 = r5
            goto L_0x03b9
        L_0x03b7:
            r115 = r232
        L_0x03b9:
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03c0
            r116 = r6
            goto L_0x03c2
        L_0x03c0:
            r116 = r233
        L_0x03c2:
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03c9
            r117 = r6
            goto L_0x03cb
        L_0x03c9:
            r117 = r234
        L_0x03cb:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x03d4
            java.util.List<com.blueair.core.model.DeviceAlarm> r0 = NULL_ALARM_LIST
            r118 = r0
            goto L_0x03d6
        L_0x03d4:
            r118 = r235
        L_0x03d6:
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x03dd
            r119 = r1
            goto L_0x03df
        L_0x03dd:
            r119 = r236
        L_0x03df:
            r0 = r3 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x03e6
            r120 = r4
            goto L_0x03e8
        L_0x03e6:
            r120 = r237
        L_0x03e8:
            r0 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x03ef
            r121 = r6
            goto L_0x03f1
        L_0x03ef:
            r121 = r238
        L_0x03f1:
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x03f8
            r122 = r4
            goto L_0x03fa
        L_0x03f8:
            r122 = r239
        L_0x03fa:
            r6 = r123
            r7 = r124
            r8 = r125
            r9 = r126
            r10 = r127
            r18 = r135
            r19 = r136
            r20 = r137
            r24 = r141
            r25 = r142
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r66, r67, r68, r69, r70, r71, r72, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r86, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.DeviceEntity.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, com.blueair.database.DeviceUuidEntity, boolean, com.blueair.core.model.IndoorDatapoint, java.lang.Integer, boolean, boolean, boolean, java.lang.String, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.Boolean, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.Long, boolean, boolean, int, long, int, boolean, int, int, int, int, long, int, int, int, int, int, int, int, int, int, int, double, double, int, int, int, double[], int, double[], boolean, int, int, int, boolean, int, boolean, boolean, int, int, boolean, boolean, int, int, int, int, int, int, int, int, boolean, java.lang.Boolean, int, int, java.util.List, int, boolean, boolean, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final int getTypeIndex() {
        return this.typeIndex;
    }

    public final Integer getFanSpeed() {
        return this.fanSpeed;
    }

    public final Integer getFilterLife() {
        return this.filterLife;
    }

    public final String getAutoModeText() {
        return this.autoModeText;
    }

    public final Integer getBrightness() {
        return this.brightness;
    }

    public final String getInfo() {
        return this.info;
    }

    public final DeviceUuidEntity getDeviceUuid() {
        return this.deviceUuid;
    }

    public final boolean getHasFinishedOnboarding() {
        return this.hasFinishedOnboarding;
    }

    public final IndoorDatapoint getLatestSensorDatapoint() {
        return this.latestSensorDatapoint;
    }

    public final Integer getLastSelectedSensorType() {
        return this.lastSelectedSensorType;
    }

    public final boolean isAblDevice() {
        return this.isAblDevice;
    }

    public final boolean isNightModeOn() {
        return this.isNightModeOn;
    }

    public final boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public final String getLinkedDeviceUid() {
        return this.linkedDeviceUid;
    }

    public final int getConnectivityStatusIndex() {
        return this.connectivityStatusIndex;
    }

    public final long getLastConnectivityMillis() {
        return this.lastConnectivityMillis;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public final String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getSerial() {
        return this.serial;
    }

    public final String getPurchaseDate() {
        return this.purchaseDate;
    }

    public final String getDealerName() {
        return this.dealerName;
    }

    public final String getDealerCountry() {
        return this.dealerCountry;
    }

    public final String getFilterType() {
        return this.filterType;
    }

    public final String getFilterTrigger() {
        return this.filterTrigger;
    }

    public final double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public final double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public final double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public final double[] getVocRanges() {
        return this.vocRanges;
    }

    public final double[] getHchoRanges() {
        return this.hchoRanges;
    }

    public final int getUpdateProgress() {
        return this.updateProgress;
    }

    public final boolean isStandByOn() {
        return this.isStandByOn;
    }

    public final boolean isEcoModeOn() {
        return this.isEcoModeOn;
    }

    public final boolean isHinsModeOn() {
        return this.isHinsModeOn;
    }

    public final boolean isHinsNightModeOn() {
        return this.isHinsNightModeOn;
    }

    public final boolean isG4NightModeOn() {
        return this.isG4NightModeOn;
    }

    public final boolean isGermShieldOn() {
        return this.isGermShieldOn;
    }

    public final Boolean isGermShieldNightModeOn() {
        return this.isGermShieldNightModeOn;
    }

    public final boolean isSafetySwitchOn() {
        return this.isSafetySwitchOn;
    }

    public final String getG4NightModefilterTrigger() {
        return this.g4NightModefilterTrigger;
    }

    public final boolean getAimInstalled() {
        return this.aimInstalled;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getCompatibility() {
        return this.compatibility;
    }

    public final WelcomeHomeLocation getWelcomeHome() {
        return this.welcomeHome;
    }

    public final String getLocationId() {
        return this.locationId;
    }

    public final Boolean getDisinfection() {
        return this.disinfection;
    }

    public final Integer getDisinfectLeftTime() {
        return this.disinfectLeftTime;
    }

    public final Long getDisinfectLeftTimeUpdateTime() {
        return this.disinfectLeftTimeUpdateTime;
    }

    public final boolean getWickdryEnabled() {
        return this.wickdryEnabled;
    }

    public final boolean getWickdryOn() {
        return this.wickdryOn;
    }

    public final int getWickdryLeftTime() {
        return this.wickdryLeftTime;
    }

    public final long getWickdryLeftTimeUpdateTime() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int getWickUsage() {
        return this.wickUsage;
    }

    public final boolean getWaterShortage() {
        return this.waterShortage;
    }

    public final int getAutoRh() {
        return this.autoRh;
    }

    public final int getTimerStatus() {
        return this.timerStatus;
    }

    public final int getTimerDuration() {
        return this.timerDuration;
    }

    public final int getTimerLeftTime() {
        return this.timerLeftTime;
    }

    public final long getTimerLeftTimeUpdateTime() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public final int getOscillationState() {
        return this.oscillationState;
    }

    public final int getOscillationAngle() {
        return this.oscillationAngle;
    }

    public final int getOscillationDirection() {
        return this.oscillationDirection;
    }

    public final int getOscillationFanSpeed() {
        return this.oscillationFanSpeed;
    }

    public final int getMainMode() {
        return this.mainMode;
    }

    public final int getApSubMode() {
        return this.apSubMode;
    }

    public final int getApFanSpeed() {
        return this.apFanSpeed;
    }

    public final int getHeatSubMode() {
        return this.heatSubMode;
    }

    public final int getHeatFanSpeed() {
        return this.heatFanSpeed;
    }

    public final double getHeatAutoTmp() {
        return this.heatAutoTmp;
    }

    public final double getHeatEcoTmp() {
        return this.heatEcoTmp;
    }

    public final int getCoolSubMode() {
        return this.coolSubMode;
    }

    public final int getCoolFanSpeed() {
        return this.coolFanSpeed;
    }

    public final int getCoolAutoTag() {
        return this.coolAutoTag;
    }

    public final double[] getCoolAutoPresets() {
        return this.coolAutoPresets;
    }

    public final int getCoolEcoTag() {
        return this.coolEcoTag;
    }

    public final double[] getCoolEcoPresets() {
        return this.coolEcoPresets;
    }

    public final boolean getHumMode() {
        return this.humMode;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getWaterLevel() {
        return this.waterLevel;
    }

    public final int getDehSubMode() {
        return this.dehSubMode;
    }

    public final boolean getWaterTankFailure() {
        return this.waterTankFailure;
    }

    public final int getSmartSubMode() {
        return this.smartSubMode;
    }

    public final boolean getDetectCat() {
        return this.detectCat;
    }

    public final boolean getBodyMounted() {
        return this.bodyMounted;
    }

    public final int getCleanAirEta() {
        return this.cleanAirEta;
    }

    public final int getPanelDisplayMode() {
        return this.panelDisplayMode;
    }

    public final boolean getHoverEnabled() {
        return this.hoverEnabled;
    }

    public final boolean getAirRefreshEnabled() {
        return this.airRefreshEnabled;
    }

    public final int getAirRefreshStatus() {
        return this.airRefreshStatus;
    }

    public final int getAirRefreshDuration() {
        return this.airRefreshDuration;
    }

    public final int getAirRefreshTimeStamp() {
        return this.airRefreshTimeStamp;
    }

    public final int getAirRefreshStartTimeStamp() {
        return this.airRefreshStartTimeStamp;
    }

    public final int getAirRefreshEndTimeStamp() {
        return this.airRefreshEndTimeStamp;
    }

    public final int getRoomType() {
        return this.roomType;
    }

    public final int getNightLampBrightness() {
        return this.nightLampBrightness;
    }

    public final int getWickdryDuration() {
        return this.wickdryDuration;
    }

    public final boolean getWickdryDone() {
        return this.wickdryDone;
    }

    public final Boolean getYwrmEnabled() {
        return this.ywrmEnabled;
    }

    public final int getYwrmUsage() {
        return this.ywrmUsage;
    }

    public final int getNightLampSteplessBrightness() {
        return this.nightLampSteplessBrightness;
    }

    public final List<DeviceAlarm> getAlarms() {
        return this.alarms;
    }

    public final int getHumSubMode() {
        return this.humSubMode;
    }

    public final boolean getUse24Hour() {
        return this.use24Hour;
    }

    public final boolean getWaterInfill() {
        return this.waterInfill;
    }

    public final int getSensorMode() {
        return this.sensorMode;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/blueair/database/entity/DeviceEntity$Companion;", "", "<init>", "()V", "DEVICE_TABLE", "", "NULL_ALARM_LIST", "", "Lcom/blueair/core/model/DeviceAlarm;", "getNULL_ALARM_LIST", "()Ljava/util/List;", "fromDevice", "Lcom/blueair/database/entity/DeviceEntity;", "device", "Lcom/blueair/core/model/Device;", "existingDevice", "fromDeviceOnAblServer", "deviceOnAbl", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "fromDeviceOnBlueServer", "deviceOnBlueServer", "Lcom/blueair/core/model/DeviceOnBlueServer;", "useProtect", "", "isLatestConnectivityState", "nuLastConnectivityMillis", "", "oldLastConnectivityMillis", "(JLjava/lang/Long;)Z", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceAlarm> getNULL_ALARM_LIST() {
            return DeviceEntity.NULL_ALARM_LIST;
        }

        public static /* synthetic */ DeviceEntity fromDevice$default(Companion companion, Device device, DeviceEntity deviceEntity, int i, Object obj) {
            if ((i & 2) != 0) {
                deviceEntity = null;
            }
            return companion.fromDevice(device, deviceEntity);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1135:0x0f51, code lost:
            if (r2 != null) goto L_0x0f3e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:1159:0x0fa3, code lost:
            if (r2 != null) goto L_0x0f90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:611:0x085c, code lost:
            if (r2 != null) goto L_0x0849;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:756:0x0a44, code lost:
            if (r2 != null) goto L_0x0a31;
         */
        /* JADX WARNING: Removed duplicated region for block: B:1002:0x0d93  */
        /* JADX WARNING: Removed duplicated region for block: B:1009:0x0daa  */
        /* JADX WARNING: Removed duplicated region for block: B:1010:0x0daf  */
        /* JADX WARNING: Removed duplicated region for block: B:1014:0x0dbb  */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x01e5  */
        /* JADX WARNING: Removed duplicated region for block: B:1021:0x0dd2  */
        /* JADX WARNING: Removed duplicated region for block: B:1022:0x0dd7  */
        /* JADX WARNING: Removed duplicated region for block: B:1026:0x0de3  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:1033:0x0dfc  */
        /* JADX WARNING: Removed duplicated region for block: B:1034:0x0e01  */
        /* JADX WARNING: Removed duplicated region for block: B:1038:0x0e0d  */
        /* JADX WARNING: Removed duplicated region for block: B:1045:0x0e26  */
        /* JADX WARNING: Removed duplicated region for block: B:1046:0x0e2b  */
        /* JADX WARNING: Removed duplicated region for block: B:1050:0x0e37  */
        /* JADX WARNING: Removed duplicated region for block: B:1057:0x0e50  */
        /* JADX WARNING: Removed duplicated region for block: B:1058:0x0e55  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:1062:0x0e61  */
        /* JADX WARNING: Removed duplicated region for block: B:1069:0x0e78  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01f6  */
        /* JADX WARNING: Removed duplicated region for block: B:1070:0x0e7d  */
        /* JADX WARNING: Removed duplicated region for block: B:1074:0x0e89  */
        /* JADX WARNING: Removed duplicated region for block: B:1081:0x0ea2  */
        /* JADX WARNING: Removed duplicated region for block: B:1082:0x0ea7  */
        /* JADX WARNING: Removed duplicated region for block: B:1085:0x0eac  */
        /* JADX WARNING: Removed duplicated region for block: B:1091:0x0ebe  */
        /* JADX WARNING: Removed duplicated region for block: B:1092:0x0ec3  */
        /* JADX WARNING: Removed duplicated region for block: B:1096:0x0ecf  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0200  */
        /* JADX WARNING: Removed duplicated region for block: B:1103:0x0ee8  */
        /* JADX WARNING: Removed duplicated region for block: B:1104:0x0eed  */
        /* JADX WARNING: Removed duplicated region for block: B:1108:0x0ef9  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0205  */
        /* JADX WARNING: Removed duplicated region for block: B:1115:0x0f12  */
        /* JADX WARNING: Removed duplicated region for block: B:1116:0x0f17  */
        /* JADX WARNING: Removed duplicated region for block: B:1119:0x0f1c  */
        /* JADX WARNING: Removed duplicated region for block: B:1126:0x0f34  */
        /* JADX WARNING: Removed duplicated region for block: B:1127:0x0f39  */
        /* JADX WARNING: Removed duplicated region for block: B:1132:0x0f45  */
        /* JADX WARNING: Removed duplicated region for block: B:1138:0x0f5c  */
        /* JADX WARNING: Removed duplicated region for block: B:1139:0x0f61  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0210  */
        /* JADX WARNING: Removed duplicated region for block: B:1143:0x0f6d  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x0215  */
        /* JADX WARNING: Removed duplicated region for block: B:1150:0x0f86  */
        /* JADX WARNING: Removed duplicated region for block: B:1151:0x0f8b  */
        /* JADX WARNING: Removed duplicated region for block: B:1156:0x0f97  */
        /* JADX WARNING: Removed duplicated region for block: B:1162:0x0fae  */
        /* JADX WARNING: Removed duplicated region for block: B:1163:0x0fb3  */
        /* JADX WARNING: Removed duplicated region for block: B:1166:0x0fb8  */
        /* JADX WARNING: Removed duplicated region for block: B:1168:0x0fbf  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x021a  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x021f  */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x022a  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x022f  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x023b  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0254  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x0259  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x0265  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x027e  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x0283  */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x0288  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x02a2  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x02bd  */
        /* JADX WARNING: Removed duplicated region for block: B:171:0x02d8  */
        /* JADX WARNING: Removed duplicated region for block: B:179:0x02f3  */
        /* JADX WARNING: Removed duplicated region for block: B:187:0x030e  */
        /* JADX WARNING: Removed duplicated region for block: B:195:0x0329  */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x0344  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x035f  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x037a  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x038f  */
        /* JADX WARNING: Removed duplicated region for block: B:228:0x0394  */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x0399  */
        /* JADX WARNING: Removed duplicated region for block: B:239:0x03ae  */
        /* JADX WARNING: Removed duplicated region for block: B:240:0x03b3  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x03b8  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x03cd  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x03d2  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x03d7  */
        /* JADX WARNING: Removed duplicated region for block: B:262:0x03eb  */
        /* JADX WARNING: Removed duplicated region for block: B:263:0x03f0  */
        /* JADX WARNING: Removed duplicated region for block: B:266:0x03f5  */
        /* JADX WARNING: Removed duplicated region for block: B:273:0x0409  */
        /* JADX WARNING: Removed duplicated region for block: B:274:0x040e  */
        /* JADX WARNING: Removed duplicated region for block: B:277:0x0413  */
        /* JADX WARNING: Removed duplicated region for block: B:284:0x0427  */
        /* JADX WARNING: Removed duplicated region for block: B:285:0x042c  */
        /* JADX WARNING: Removed duplicated region for block: B:288:0x0431  */
        /* JADX WARNING: Removed duplicated region for block: B:295:0x0445  */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x044a  */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x044f  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:307:0x0470  */
        /* JADX WARNING: Removed duplicated region for block: B:314:0x0489  */
        /* JADX WARNING: Removed duplicated region for block: B:315:0x048e  */
        /* JADX WARNING: Removed duplicated region for block: B:319:0x049a  */
        /* JADX WARNING: Removed duplicated region for block: B:326:0x04b3  */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x04b8  */
        /* JADX WARNING: Removed duplicated region for block: B:331:0x04c4  */
        /* JADX WARNING: Removed duplicated region for block: B:338:0x04dd  */
        /* JADX WARNING: Removed duplicated region for block: B:339:0x04e2  */
        /* JADX WARNING: Removed duplicated region for block: B:343:0x04ee  */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0505  */
        /* JADX WARNING: Removed duplicated region for block: B:351:0x050a  */
        /* JADX WARNING: Removed duplicated region for block: B:355:0x0516  */
        /* JADX WARNING: Removed duplicated region for block: B:362:0x052f  */
        /* JADX WARNING: Removed duplicated region for block: B:363:0x0534  */
        /* JADX WARNING: Removed duplicated region for block: B:367:0x0540  */
        /* JADX WARNING: Removed duplicated region for block: B:374:0x0559  */
        /* JADX WARNING: Removed duplicated region for block: B:375:0x055e  */
        /* JADX WARNING: Removed duplicated region for block: B:379:0x056a  */
        /* JADX WARNING: Removed duplicated region for block: B:386:0x0581  */
        /* JADX WARNING: Removed duplicated region for block: B:387:0x0586  */
        /* JADX WARNING: Removed duplicated region for block: B:390:0x058b  */
        /* JADX WARNING: Removed duplicated region for block: B:396:0x059f  */
        /* JADX WARNING: Removed duplicated region for block: B:397:0x05a4  */
        /* JADX WARNING: Removed duplicated region for block: B:401:0x05b1  */
        /* JADX WARNING: Removed duplicated region for block: B:408:0x05c8  */
        /* JADX WARNING: Removed duplicated region for block: B:409:0x05cd  */
        /* JADX WARNING: Removed duplicated region for block: B:412:0x05d2  */
        /* JADX WARNING: Removed duplicated region for block: B:419:0x05e3  */
        /* JADX WARNING: Removed duplicated region for block: B:420:0x05ea  */
        /* JADX WARNING: Removed duplicated region for block: B:423:0x05f4  */
        /* JADX WARNING: Removed duplicated region for block: B:424:0x05f9  */
        /* JADX WARNING: Removed duplicated region for block: B:427:0x05fe  */
        /* JADX WARNING: Removed duplicated region for block: B:433:0x0612  */
        /* JADX WARNING: Removed duplicated region for block: B:434:0x0617  */
        /* JADX WARNING: Removed duplicated region for block: B:437:0x061c  */
        /* JADX WARNING: Removed duplicated region for block: B:443:0x0630  */
        /* JADX WARNING: Removed duplicated region for block: B:444:0x0635  */
        /* JADX WARNING: Removed duplicated region for block: B:447:0x0642  */
        /* JADX WARNING: Removed duplicated region for block: B:448:0x0647  */
        /* JADX WARNING: Removed duplicated region for block: B:451:0x0654  */
        /* JADX WARNING: Removed duplicated region for block: B:452:0x0659  */
        /* JADX WARNING: Removed duplicated region for block: B:455:0x065e  */
        /* JADX WARNING: Removed duplicated region for block: B:461:0x0670  */
        /* JADX WARNING: Removed duplicated region for block: B:462:0x0675  */
        /* JADX WARNING: Removed duplicated region for block: B:465:0x067a  */
        /* JADX WARNING: Removed duplicated region for block: B:471:0x068c  */
        /* JADX WARNING: Removed duplicated region for block: B:472:0x0691  */
        /* JADX WARNING: Removed duplicated region for block: B:475:0x0696  */
        /* JADX WARNING: Removed duplicated region for block: B:481:0x06aa  */
        /* JADX WARNING: Removed duplicated region for block: B:482:0x06af  */
        /* JADX WARNING: Removed duplicated region for block: B:486:0x06bb  */
        /* JADX WARNING: Removed duplicated region for block: B:493:0x06d2  */
        /* JADX WARNING: Removed duplicated region for block: B:494:0x06d7  */
        /* JADX WARNING: Removed duplicated region for block: B:498:0x06e3  */
        /* JADX WARNING: Removed duplicated region for block: B:505:0x06fa  */
        /* JADX WARNING: Removed duplicated region for block: B:506:0x06ff  */
        /* JADX WARNING: Removed duplicated region for block: B:510:0x070b  */
        /* JADX WARNING: Removed duplicated region for block: B:517:0x0722  */
        /* JADX WARNING: Removed duplicated region for block: B:518:0x0727  */
        /* JADX WARNING: Removed duplicated region for block: B:522:0x0733  */
        /* JADX WARNING: Removed duplicated region for block: B:529:0x074a  */
        /* JADX WARNING: Removed duplicated region for block: B:530:0x074f  */
        /* JADX WARNING: Removed duplicated region for block: B:534:0x075b  */
        /* JADX WARNING: Removed duplicated region for block: B:541:0x0772  */
        /* JADX WARNING: Removed duplicated region for block: B:542:0x0777  */
        /* JADX WARNING: Removed duplicated region for block: B:546:0x0783  */
        /* JADX WARNING: Removed duplicated region for block: B:553:0x079c  */
        /* JADX WARNING: Removed duplicated region for block: B:554:0x07a1  */
        /* JADX WARNING: Removed duplicated region for block: B:559:0x07ad  */
        /* JADX WARNING: Removed duplicated region for block: B:566:0x07c7  */
        /* JADX WARNING: Removed duplicated region for block: B:567:0x07cc  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0163  */
        /* JADX WARNING: Removed duplicated region for block: B:571:0x07d8  */
        /* JADX WARNING: Removed duplicated region for block: B:578:0x07ef  */
        /* JADX WARNING: Removed duplicated region for block: B:579:0x07f4  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0168  */
        /* JADX WARNING: Removed duplicated region for block: B:583:0x0800  */
        /* JADX WARNING: Removed duplicated region for block: B:590:0x0817  */
        /* JADX WARNING: Removed duplicated region for block: B:591:0x081c  */
        /* JADX WARNING: Removed duplicated region for block: B:595:0x0828  */
        /* JADX WARNING: Removed duplicated region for block: B:602:0x083f  */
        /* JADX WARNING: Removed duplicated region for block: B:603:0x0844  */
        /* JADX WARNING: Removed duplicated region for block: B:608:0x0850  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x016d  */
        /* JADX WARNING: Removed duplicated region for block: B:614:0x0867  */
        /* JADX WARNING: Removed duplicated region for block: B:615:0x086c  */
        /* JADX WARNING: Removed duplicated region for block: B:619:0x0878  */
        /* JADX WARNING: Removed duplicated region for block: B:626:0x0891  */
        /* JADX WARNING: Removed duplicated region for block: B:627:0x0896  */
        /* JADX WARNING: Removed duplicated region for block: B:631:0x08a2  */
        /* JADX WARNING: Removed duplicated region for block: B:638:0x08b9  */
        /* JADX WARNING: Removed duplicated region for block: B:639:0x08be  */
        /* JADX WARNING: Removed duplicated region for block: B:644:0x08ca  */
        /* JADX WARNING: Removed duplicated region for block: B:651:0x08e2  */
        /* JADX WARNING: Removed duplicated region for block: B:652:0x08e7  */
        /* JADX WARNING: Removed duplicated region for block: B:656:0x08f3  */
        /* JADX WARNING: Removed duplicated region for block: B:663:0x090a  */
        /* JADX WARNING: Removed duplicated region for block: B:664:0x090f  */
        /* JADX WARNING: Removed duplicated region for block: B:668:0x091b  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:675:0x0934  */
        /* JADX WARNING: Removed duplicated region for block: B:676:0x0939  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:680:0x0945  */
        /* JADX WARNING: Removed duplicated region for block: B:687:0x095c  */
        /* JADX WARNING: Removed duplicated region for block: B:688:0x0961  */
        /* JADX WARNING: Removed duplicated region for block: B:692:0x096e  */
        /* JADX WARNING: Removed duplicated region for block: B:699:0x0985  */
        /* JADX WARNING: Removed duplicated region for block: B:700:0x098a  */
        /* JADX WARNING: Removed duplicated region for block: B:704:0x0996  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0189  */
        /* JADX WARNING: Removed duplicated region for block: B:711:0x09ad  */
        /* JADX WARNING: Removed duplicated region for block: B:712:0x09b2  */
        /* JADX WARNING: Removed duplicated region for block: B:716:0x09be  */
        /* JADX WARNING: Removed duplicated region for block: B:723:0x09d5  */
        /* JADX WARNING: Removed duplicated region for block: B:724:0x09da  */
        /* JADX WARNING: Removed duplicated region for block: B:728:0x09e6  */
        /* JADX WARNING: Removed duplicated region for block: B:735:0x09fd  */
        /* JADX WARNING: Removed duplicated region for block: B:736:0x0a02  */
        /* JADX WARNING: Removed duplicated region for block: B:740:0x0a10  */
        /* JADX WARNING: Removed duplicated region for block: B:747:0x0a27  */
        /* JADX WARNING: Removed duplicated region for block: B:748:0x0a2c  */
        /* JADX WARNING: Removed duplicated region for block: B:753:0x0a38  */
        /* JADX WARNING: Removed duplicated region for block: B:759:0x0a4d  */
        /* JADX WARNING: Removed duplicated region for block: B:760:0x0a52  */
        /* JADX WARNING: Removed duplicated region for block: B:764:0x0a5e  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x019d  */
        /* JADX WARNING: Removed duplicated region for block: B:771:0x0a75  */
        /* JADX WARNING: Removed duplicated region for block: B:772:0x0a7a  */
        /* JADX WARNING: Removed duplicated region for block: B:776:0x0a86  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:783:0x0a9d  */
        /* JADX WARNING: Removed duplicated region for block: B:784:0x0aa2  */
        /* JADX WARNING: Removed duplicated region for block: B:788:0x0aae  */
        /* JADX WARNING: Removed duplicated region for block: B:795:0x0ac5  */
        /* JADX WARNING: Removed duplicated region for block: B:796:0x0aca  */
        /* JADX WARNING: Removed duplicated region for block: B:799:0x0ad3  */
        /* JADX WARNING: Removed duplicated region for block: B:806:0x0af0  */
        /* JADX WARNING: Removed duplicated region for block: B:807:0x0af5  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01a7  */
        /* JADX WARNING: Removed duplicated region for block: B:811:0x0b01  */
        /* JADX WARNING: Removed duplicated region for block: B:818:0x0b18  */
        /* JADX WARNING: Removed duplicated region for block: B:819:0x0b1d  */
        /* JADX WARNING: Removed duplicated region for block: B:822:0x0b22  */
        /* JADX WARNING: Removed duplicated region for block: B:829:0x0b3c  */
        /* JADX WARNING: Removed duplicated region for block: B:830:0x0b41  */
        /* JADX WARNING: Removed duplicated region for block: B:834:0x0b4d  */
        /* JADX WARNING: Removed duplicated region for block: B:841:0x0b66  */
        /* JADX WARNING: Removed duplicated region for block: B:842:0x0b6b  */
        /* JADX WARNING: Removed duplicated region for block: B:846:0x0b77  */
        /* JADX WARNING: Removed duplicated region for block: B:853:0x0b90  */
        /* JADX WARNING: Removed duplicated region for block: B:854:0x0b95  */
        /* JADX WARNING: Removed duplicated region for block: B:858:0x0ba1  */
        /* JADX WARNING: Removed duplicated region for block: B:865:0x0bba  */
        /* JADX WARNING: Removed duplicated region for block: B:866:0x0bbf  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:870:0x0bcb  */
        /* JADX WARNING: Removed duplicated region for block: B:877:0x0be4  */
        /* JADX WARNING: Removed duplicated region for block: B:878:0x0be9  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01c0  */
        /* JADX WARNING: Removed duplicated region for block: B:882:0x0bf5  */
        /* JADX WARNING: Removed duplicated region for block: B:889:0x0c0e  */
        /* JADX WARNING: Removed duplicated region for block: B:890:0x0c13  */
        /* JADX WARNING: Removed duplicated region for block: B:894:0x0c1f  */
        /* JADX WARNING: Removed duplicated region for block: B:901:0x0c38  */
        /* JADX WARNING: Removed duplicated region for block: B:902:0x0c3d  */
        /* JADX WARNING: Removed duplicated region for block: B:906:0x0c49  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:913:0x0c62  */
        /* JADX WARNING: Removed duplicated region for block: B:914:0x0c67  */
        /* JADX WARNING: Removed duplicated region for block: B:918:0x0c73  */
        /* JADX WARNING: Removed duplicated region for block: B:925:0x0c8c  */
        /* JADX WARNING: Removed duplicated region for block: B:926:0x0c91  */
        /* JADX WARNING: Removed duplicated region for block: B:930:0x0c9d  */
        /* JADX WARNING: Removed duplicated region for block: B:937:0x0cb6  */
        /* JADX WARNING: Removed duplicated region for block: B:938:0x0cbb  */
        /* JADX WARNING: Removed duplicated region for block: B:942:0x0cc7  */
        /* JADX WARNING: Removed duplicated region for block: B:949:0x0ce0  */
        /* JADX WARNING: Removed duplicated region for block: B:950:0x0ce5  */
        /* JADX WARNING: Removed duplicated region for block: B:954:0x0cf1  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x01d3  */
        /* JADX WARNING: Removed duplicated region for block: B:961:0x0d0a  */
        /* JADX WARNING: Removed duplicated region for block: B:962:0x0d0f  */
        /* JADX WARNING: Removed duplicated region for block: B:966:0x0d1b  */
        /* JADX WARNING: Removed duplicated region for block: B:973:0x0d32  */
        /* JADX WARNING: Removed duplicated region for block: B:974:0x0d37  */
        /* JADX WARNING: Removed duplicated region for block: B:978:0x0d43  */
        /* JADX WARNING: Removed duplicated region for block: B:985:0x0d5a  */
        /* JADX WARNING: Removed duplicated region for block: B:986:0x0d5f  */
        /* JADX WARNING: Removed duplicated region for block: B:990:0x0d6b  */
        /* JADX WARNING: Removed duplicated region for block: B:997:0x0d82  */
        /* JADX WARNING: Removed duplicated region for block: B:998:0x0d87  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.database.entity.DeviceEntity fromDevice(com.blueair.core.model.Device r129, com.blueair.database.entity.DeviceEntity r130) {
            /*
                r128 = this;
                r0 = r129
                java.lang.String r1 = "device"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$deviceUuid$1 r1 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$deviceUuid$1.INSTANCE
                kotlin.reflect.KProperty1 r1 = (kotlin.reflect.KProperty1) r1
                boolean r2 = r0 instanceof com.blueair.core.model.HasBlueProvisionCalls
                r3 = 0
                if (r2 == 0) goto L_0x0015
                java.lang.Object r1 = r1.get(r0)
                goto L_0x0016
            L_0x0015:
                r1 = r3
            L_0x0016:
                com.blueair.core.model.DeviceUuid r1 = (com.blueair.core.model.DeviceUuid) r1
                if (r1 == 0) goto L_0x0021
                com.blueair.database.DeviceUuidEntity$Companion r4 = com.blueair.database.DeviceUuidEntity.Companion
                com.blueair.database.DeviceUuidEntity r1 = r4.from(r1)
                goto L_0x0022
            L_0x0021:
                r1 = r3
            L_0x0022:
                timber.log.Timber$Forest r4 = timber.log.Timber.Forest
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "FromDevice: nuLastConnectivityMillis = "
                r5.<init>(r6)
                long r6 = r0.getLastConnectivityInMillis()
                r5.append(r6)
                java.lang.String r6 = ", oldLastConnectivityMillis = "
                r5.append(r6)
                if (r130 == 0) goto L_0x0042
                long r6 = r130.getLastConnectivityMillis()
                java.lang.Long r6 = java.lang.Long.valueOf(r6)
                goto L_0x0043
            L_0x0042:
                r6 = r3
            L_0x0043:
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                r6 = 0
                java.lang.Object[] r7 = new java.lang.Object[r6]
                r4.v(r5, r7)
                long r4 = r0.getLastConnectivityInMillis()
                if (r130 == 0) goto L_0x005f
                long r7 = r130.getLastConnectivityMillis()
                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                goto L_0x0060
            L_0x005f:
                r7 = r3
            L_0x0060:
                r8 = r128
                boolean r4 = r8.isLatestConnectivityState(r4, r7)
                r9 = 0
                if (r4 == 0) goto L_0x00bf
                kotlin.Pair r4 = new kotlin.Pair
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$1 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$1.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                java.lang.Object r5 = r5.get(r0)
                java.lang.Integer r5 = (java.lang.Integer) r5
                if (r5 == 0) goto L_0x007d
            L_0x0078:
                int r5 = r5.intValue()
                goto L_0x0092
            L_0x007d:
                if (r130 == 0) goto L_0x0088
                int r5 = r130.getConnectivityStatusIndex()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                goto L_0x0089
            L_0x0088:
                r5 = r3
            L_0x0089:
                if (r5 == 0) goto L_0x008c
                goto L_0x0078
            L_0x008c:
                com.blueair.core.model.ConnectivityStatus r5 = com.blueair.core.model.ConnectivityStatus.ONLINE
                int r5 = r5.ordinal()
            L_0x0092:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$2 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$2.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.Long r7 = (java.lang.Long) r7
                if (r7 == 0) goto L_0x00a7
            L_0x00a2:
                long r11 = r7.longValue()
                goto L_0x00b7
            L_0x00a7:
                if (r130 == 0) goto L_0x00b2
                long r11 = r130.getLastConnectivityMillis()
                java.lang.Long r7 = java.lang.Long.valueOf(r11)
                goto L_0x00b3
            L_0x00b2:
                r7 = r3
            L_0x00b3:
                if (r7 == 0) goto L_0x00b6
                goto L_0x00a2
            L_0x00b6:
                r11 = r9
            L_0x00b7:
                java.lang.Long r7 = java.lang.Long.valueOf(r11)
                r4.<init>(r5, r7)
                goto L_0x00e1
            L_0x00bf:
                kotlin.Pair r4 = new kotlin.Pair
                if (r130 == 0) goto L_0x00c8
                int r5 = r130.getConnectivityStatusIndex()
                goto L_0x00ce
            L_0x00c8:
                com.blueair.core.model.ConnectivityStatus r5 = com.blueair.core.model.ConnectivityStatus.ONLINE
                int r5 = r5.ordinal()
            L_0x00ce:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                if (r130 == 0) goto L_0x00d9
                long r11 = r130.getLastConnectivityMillis()
                goto L_0x00da
            L_0x00d9:
                r11 = r9
            L_0x00da:
                java.lang.Long r7 = java.lang.Long.valueOf(r11)
                r4.<init>(r5, r7)
            L_0x00e1:
                java.lang.Object r5 = r4.component1()
                java.lang.Number r5 = (java.lang.Number) r5
                int r29 = r5.intValue()
                java.lang.Object r4 = r4.component2()
                java.lang.Number r4 = (java.lang.Number) r4
                long r30 = r4.longValue()
                timber.log.Timber$Forest r4 = timber.log.Timber.Forest
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r7 = "FromDevice: DeviceType = "
                r5.<init>(r7)
                int r7 = r0.getTypeIndex()
                r5.append(r7)
                java.lang.String r7 = ", id = "
                r5.append(r7)
                java.lang.String r7 = r0.getUid()
                r5.append(r7)
                java.lang.String r5 = r5.toString()
                java.lang.Object[] r7 = new java.lang.Object[r6]
                r4.d(r5, r7)
                timber.log.Timber$Forest r4 = timber.log.Timber.Forest
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r7 = "FromDevice: Device = "
                r5.<init>(r7)
                r5.append(r0)
                java.lang.String r5 = r5.toString()
                java.lang.Object[] r7 = new java.lang.Object[r6]
                r4.v(r5, r7)
                java.lang.String r12 = r0.getUid()
                java.lang.String r13 = r0.getName()
                java.lang.String r14 = r0.getModelName()
                int r15 = r0.getTypeIndex()
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$3 r4 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$3.INSTANCE
                kotlin.reflect.KProperty1 r4 = (kotlin.reflect.KProperty1) r4
                boolean r5 = r0 instanceof com.blueair.core.model.HasFanSpeed
                if (r5 == 0) goto L_0x014c
                java.lang.Object r4 = r4.get(r0)
                goto L_0x014d
            L_0x014c:
                r4 = r3
            L_0x014d:
                java.lang.Integer r4 = (java.lang.Integer) r4
                if (r4 != 0) goto L_0x015b
                if (r130 == 0) goto L_0x0158
                java.lang.Integer r4 = r130.getFanSpeed()
                goto L_0x015b
            L_0x0158:
                r16 = r3
                goto L_0x015d
            L_0x015b:
                r16 = r4
            L_0x015d:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$4 r4 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$4.INSTANCE
                kotlin.reflect.KProperty1 r4 = (kotlin.reflect.KProperty1) r4
                if (r5 == 0) goto L_0x0168
                java.lang.Object r4 = r4.get(r0)
                goto L_0x0169
            L_0x0168:
                r4 = r3
            L_0x0169:
                java.lang.Integer r4 = (java.lang.Integer) r4
                if (r4 != 0) goto L_0x0177
                if (r130 == 0) goto L_0x0174
                java.lang.Integer r4 = r130.getFilterLife()
                goto L_0x0177
            L_0x0174:
                r17 = r3
                goto L_0x0179
            L_0x0177:
                r17 = r4
            L_0x0179:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$5 r4 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$5.INSTANCE
                kotlin.reflect.KProperty1 r4 = (kotlin.reflect.KProperty1) r4
                if (r5 == 0) goto L_0x0184
                java.lang.Object r4 = r4.get(r0)
                goto L_0x0185
            L_0x0184:
                r4 = r3
            L_0x0185:
                java.lang.String r4 = (java.lang.String) r4
                if (r4 != 0) goto L_0x0193
                if (r130 == 0) goto L_0x0190
                java.lang.String r4 = r130.getAutoModeText()
                goto L_0x0193
            L_0x0190:
                r18 = r3
                goto L_0x0195
            L_0x0193:
                r18 = r4
            L_0x0195:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$6 r4 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$6.INSTANCE
                kotlin.reflect.KProperty1 r4 = (kotlin.reflect.KProperty1) r4
                boolean r7 = r0 instanceof com.blueair.core.model.HasBrightness
                if (r7 == 0) goto L_0x01a2
                java.lang.Object r4 = r4.get(r0)
                goto L_0x01a3
            L_0x01a2:
                r4 = r3
            L_0x01a3:
                java.lang.Integer r4 = (java.lang.Integer) r4
                if (r4 != 0) goto L_0x01b1
                if (r130 == 0) goto L_0x01ae
                java.lang.Integer r4 = r130.getBrightness()
                goto L_0x01b1
            L_0x01ae:
                r19 = r3
                goto L_0x01b3
            L_0x01b1:
                r19 = r4
            L_0x01b3:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$7 r4 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$7.INSTANCE
                kotlin.reflect.KProperty1 r4 = (kotlin.reflect.KProperty1) r4
                boolean r7 = r0 instanceof com.blueair.core.model.HasInfo
                if (r7 == 0) goto L_0x01c0
                java.lang.Object r4 = r4.get(r0)
                goto L_0x01c1
            L_0x01c0:
                r4 = r3
            L_0x01c1:
                java.lang.String r4 = (java.lang.String) r4
                if (r4 != 0) goto L_0x01cf
                if (r130 == 0) goto L_0x01cc
                java.lang.String r4 = r130.getInfo()
                goto L_0x01cf
            L_0x01cc:
                r20 = r3
                goto L_0x01d1
            L_0x01cf:
                r20 = r4
            L_0x01d1:
                if (r1 != 0) goto L_0x01dd
                if (r130 == 0) goto L_0x01da
                com.blueair.database.DeviceUuidEntity r1 = r130.getDeviceUuid()
                goto L_0x01dd
            L_0x01da:
                r21 = r3
                goto L_0x01df
            L_0x01dd:
                r21 = r1
            L_0x01df:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$8 r1 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$8.INSTANCE
                kotlin.reflect.KProperty1 r1 = (kotlin.reflect.KProperty1) r1
                if (r2 == 0) goto L_0x01ea
                java.lang.Object r1 = r1.get(r0)
                goto L_0x01eb
            L_0x01ea:
                r1 = r3
            L_0x01eb:
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                if (r1 == 0) goto L_0x01f6
                boolean r1 = r1.booleanValue()
                r22 = r1
                goto L_0x01f8
            L_0x01f6:
                r22 = r6
            L_0x01f8:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$9 r1 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$9.INSTANCE
                kotlin.reflect.KProperty1 r1 = (kotlin.reflect.KProperty1) r1
                boolean r2 = r0 instanceof com.blueair.core.model.HasSensorData
                if (r2 == 0) goto L_0x0205
                java.lang.Object r1 = r1.get(r0)
                goto L_0x0206
            L_0x0205:
                r1 = r3
            L_0x0206:
                r23 = r1
                com.blueair.core.model.IndoorDatapoint r23 = (com.blueair.core.model.IndoorDatapoint) r23
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$10 r1 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$10.INSTANCE
                kotlin.reflect.KProperty1 r1 = (kotlin.reflect.KProperty1) r1
                if (r2 == 0) goto L_0x0215
                java.lang.Object r1 = r1.get(r0)
                goto L_0x0216
            L_0x0215:
                r1 = r3
            L_0x0216:
                java.lang.Integer r1 = (java.lang.Integer) r1
                if (r1 == 0) goto L_0x021f
                int r1 = r1.intValue()
                goto L_0x0220
            L_0x021f:
                r1 = r6
            L_0x0220:
                boolean r4 = r0 instanceof com.blueair.core.model.HasAblCloudFunctions
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$11 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$11.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                boolean r11 = r0 instanceof com.blueair.core.model.HasNightMode
                if (r11 == 0) goto L_0x022f
                java.lang.Object r7 = r7.get(r0)
                goto L_0x0230
            L_0x022f:
                r7 = r3
            L_0x0230:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                if (r7 == 0) goto L_0x023b
            L_0x0234:
                boolean r7 = r7.booleanValue()
                r26 = r7
                goto L_0x024c
            L_0x023b:
                if (r130 == 0) goto L_0x0246
                boolean r7 = r130.isNightModeOn()
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
                goto L_0x0247
            L_0x0246:
                r7 = r3
            L_0x0247:
                if (r7 == 0) goto L_0x024a
                goto L_0x0234
            L_0x024a:
                r26 = r6
            L_0x024c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$12 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$12.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                boolean r11 = r0 instanceof com.blueair.core.model.HasChildLock
                if (r11 == 0) goto L_0x0259
                java.lang.Object r7 = r7.get(r0)
                goto L_0x025a
            L_0x0259:
                r7 = r3
            L_0x025a:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                if (r7 == 0) goto L_0x0265
            L_0x025e:
                boolean r7 = r7.booleanValue()
                r27 = r7
                goto L_0x0276
            L_0x0265:
                if (r130 == 0) goto L_0x0270
                boolean r7 = r130.isChildLockOn()
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
                goto L_0x0271
            L_0x0270:
                r7 = r3
            L_0x0271:
                if (r7 == 0) goto L_0x0274
                goto L_0x025e
            L_0x0274:
                r27 = r6
            L_0x0276:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$13 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$13.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                boolean r11 = r0 instanceof com.blueair.core.model.HasLinkingCapability
                if (r11 == 0) goto L_0x0283
                java.lang.Object r7 = r7.get(r0)
                goto L_0x0284
            L_0x0283:
                r7 = r3
            L_0x0284:
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x0292
                if (r130 == 0) goto L_0x028f
                java.lang.String r7 = r130.getLinkedDeviceUid()
                goto L_0x0292
            L_0x028f:
                r28 = r3
                goto L_0x0294
            L_0x0292:
                r28 = r7
            L_0x0294:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$14 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$14.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r11 = ""
                if (r7 != 0) goto L_0x02af
                if (r130 == 0) goto L_0x02a9
                java.lang.String r7 = r130.getMac()
                goto L_0x02aa
            L_0x02a9:
                r7 = r3
            L_0x02aa:
                if (r7 != 0) goto L_0x02af
                r32 = r11
                goto L_0x02b1
            L_0x02af:
                r32 = r7
            L_0x02b1:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$15 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$15.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x02ca
                if (r130 == 0) goto L_0x02c4
                java.lang.String r7 = r130.getMcuFirmware()
                goto L_0x02c5
            L_0x02c4:
                r7 = r3
            L_0x02c5:
                if (r7 != 0) goto L_0x02ca
                r33 = r11
                goto L_0x02cc
            L_0x02ca:
                r33 = r7
            L_0x02cc:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$16 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$16.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x02e5
                if (r130 == 0) goto L_0x02df
                java.lang.String r7 = r130.getWifiFirmware()
                goto L_0x02e0
            L_0x02df:
                r7 = r3
            L_0x02e0:
                if (r7 != 0) goto L_0x02e5
                r34 = r11
                goto L_0x02e7
            L_0x02e5:
                r34 = r7
            L_0x02e7:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$17 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$17.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x0300
                if (r130 == 0) goto L_0x02fa
                java.lang.String r7 = r130.getHardware()
                goto L_0x02fb
            L_0x02fa:
                r7 = r3
            L_0x02fb:
                if (r7 != 0) goto L_0x0300
                r35 = r11
                goto L_0x0302
            L_0x0300:
                r35 = r7
            L_0x0302:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$18 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$18.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x031b
                if (r130 == 0) goto L_0x0315
                java.lang.String r7 = r130.getTimeZone()
                goto L_0x0316
            L_0x0315:
                r7 = r3
            L_0x0316:
                if (r7 != 0) goto L_0x031b
                r36 = r11
                goto L_0x031d
            L_0x031b:
                r36 = r7
            L_0x031d:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$19 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$19.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x0336
                if (r130 == 0) goto L_0x0330
                java.lang.String r7 = r130.getSerial()
                goto L_0x0331
            L_0x0330:
                r7 = r3
            L_0x0331:
                if (r7 != 0) goto L_0x0336
                r37 = r11
                goto L_0x0338
            L_0x0336:
                r37 = r7
            L_0x0338:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$20 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$20.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x0351
                if (r130 == 0) goto L_0x034b
                java.lang.String r7 = r130.getPurchaseDate()
                goto L_0x034c
            L_0x034b:
                r7 = r3
            L_0x034c:
                if (r7 != 0) goto L_0x0351
                r38 = r11
                goto L_0x0353
            L_0x0351:
                r38 = r7
            L_0x0353:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$21 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$21.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x036c
                if (r130 == 0) goto L_0x0366
                java.lang.String r7 = r130.getDealerName()
                goto L_0x0367
            L_0x0366:
                r7 = r3
            L_0x0367:
                if (r7 != 0) goto L_0x036c
                r39 = r11
                goto L_0x036e
            L_0x036c:
                r39 = r7
            L_0x036e:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$22 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$22.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                java.lang.Object r7 = r7.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x0387
                if (r130 == 0) goto L_0x0381
                java.lang.String r7 = r130.getDealerCountry()
                goto L_0x0382
            L_0x0381:
                r7 = r3
            L_0x0382:
                if (r7 != 0) goto L_0x0387
                r40 = r11
                goto L_0x0389
            L_0x0387:
                r40 = r7
            L_0x0389:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$23 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$23.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                if (r5 == 0) goto L_0x0394
                java.lang.Object r7 = r7.get(r0)
                goto L_0x0395
            L_0x0394:
                r7 = r3
            L_0x0395:
                java.lang.String r7 = (java.lang.String) r7
                if (r7 != 0) goto L_0x03a6
                if (r130 == 0) goto L_0x03a0
                java.lang.String r7 = r130.getFilterType()
                goto L_0x03a1
            L_0x03a0:
                r7 = r3
            L_0x03a1:
                if (r7 != 0) goto L_0x03a6
                r41 = r11
                goto L_0x03a8
            L_0x03a6:
                r41 = r7
            L_0x03a8:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$24 r7 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$24.INSTANCE
                kotlin.reflect.KProperty1 r7 = (kotlin.reflect.KProperty1) r7
                if (r5 == 0) goto L_0x03b3
                java.lang.Object r5 = r7.get(r0)
                goto L_0x03b4
            L_0x03b3:
                r5 = r3
            L_0x03b4:
                java.lang.String r5 = (java.lang.String) r5
                if (r5 != 0) goto L_0x03c5
                if (r130 == 0) goto L_0x03bf
                java.lang.String r5 = r130.getFilterTrigger()
                goto L_0x03c0
            L_0x03bf:
                r5 = r3
            L_0x03c0:
                if (r5 != 0) goto L_0x03c5
                r42 = r11
                goto L_0x03c7
            L_0x03c5:
                r42 = r5
            L_0x03c7:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$25 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$25.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                if (r2 == 0) goto L_0x03d2
                java.lang.Object r5 = r5.get(r0)
                goto L_0x03d3
            L_0x03d2:
                r5 = r3
            L_0x03d3:
                double[] r5 = (double[]) r5
                if (r5 != 0) goto L_0x03e3
                if (r130 == 0) goto L_0x03de
                double[] r5 = r130.getPm1Ranges()
                goto L_0x03df
            L_0x03de:
                r5 = r3
            L_0x03df:
                if (r5 != 0) goto L_0x03e3
                double[] r5 = new double[r6]
            L_0x03e3:
                r43 = r5
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$26 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$26.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                if (r2 == 0) goto L_0x03f0
                java.lang.Object r5 = r5.get(r0)
                goto L_0x03f1
            L_0x03f0:
                r5 = r3
            L_0x03f1:
                double[] r5 = (double[]) r5
                if (r5 != 0) goto L_0x0401
                if (r130 == 0) goto L_0x03fc
                double[] r5 = r130.getPm10Ranges()
                goto L_0x03fd
            L_0x03fc:
                r5 = r3
            L_0x03fd:
                if (r5 != 0) goto L_0x0401
                double[] r5 = new double[r6]
            L_0x0401:
                r44 = r5
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$27 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$27.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                if (r2 == 0) goto L_0x040e
                java.lang.Object r5 = r5.get(r0)
                goto L_0x040f
            L_0x040e:
                r5 = r3
            L_0x040f:
                double[] r5 = (double[]) r5
                if (r5 != 0) goto L_0x041f
                if (r130 == 0) goto L_0x041a
                double[] r5 = r130.getPm25Ranges()
                goto L_0x041b
            L_0x041a:
                r5 = r3
            L_0x041b:
                if (r5 != 0) goto L_0x041f
                double[] r5 = new double[r6]
            L_0x041f:
                r45 = r5
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$28 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$28.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                if (r2 == 0) goto L_0x042c
                java.lang.Object r5 = r5.get(r0)
                goto L_0x042d
            L_0x042c:
                r5 = r3
            L_0x042d:
                double[] r5 = (double[]) r5
                if (r5 != 0) goto L_0x043d
                if (r130 == 0) goto L_0x0438
                double[] r5 = r130.getVocRanges()
                goto L_0x0439
            L_0x0438:
                r5 = r3
            L_0x0439:
                if (r5 != 0) goto L_0x043d
                double[] r5 = new double[r6]
            L_0x043d:
                r46 = r5
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$29 r5 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$29.INSTANCE
                kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
                if (r2 == 0) goto L_0x044a
                java.lang.Object r2 = r5.get(r0)
                goto L_0x044b
            L_0x044a:
                r2 = r3
            L_0x044b:
                double[] r2 = (double[]) r2
                if (r2 != 0) goto L_0x045b
                if (r130 == 0) goto L_0x0456
                double[] r2 = r130.getHchoRanges()
                goto L_0x0457
            L_0x0456:
                r2 = r3
            L_0x0457:
                if (r2 != 0) goto L_0x045b
                double[] r2 = new double[r6]
            L_0x045b:
                r47 = r2
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$30 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$30.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0470
            L_0x0469:
                int r2 = r2.intValue()
                r48 = r2
                goto L_0x0481
            L_0x0470:
                if (r130 == 0) goto L_0x047b
                int r2 = r130.getUpdateProgress()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x047c
            L_0x047b:
                r2 = r3
            L_0x047c:
                if (r2 == 0) goto L_0x047f
                goto L_0x0469
            L_0x047f:
                r48 = r6
            L_0x0481:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$31 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$31.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasStandBy
                if (r5 == 0) goto L_0x048e
                java.lang.Object r2 = r2.get(r0)
                goto L_0x048f
            L_0x048e:
                r2 = r3
            L_0x048f:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x049a
            L_0x0493:
                boolean r2 = r2.booleanValue()
                r49 = r2
                goto L_0x04ab
            L_0x049a:
                if (r130 == 0) goto L_0x04a5
                boolean r2 = r130.isStandByOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x04a6
            L_0x04a5:
                r2 = r3
            L_0x04a6:
                if (r2 == 0) goto L_0x04a9
                goto L_0x0493
            L_0x04a9:
                r49 = r6
            L_0x04ab:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$32 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$32.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasEcoMode
                if (r5 == 0) goto L_0x04b8
                java.lang.Object r2 = r2.get(r0)
                goto L_0x04b9
            L_0x04b8:
                r2 = r3
            L_0x04b9:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x04c4
            L_0x04bd:
                boolean r2 = r2.booleanValue()
                r50 = r2
                goto L_0x04d5
            L_0x04c4:
                if (r130 == 0) goto L_0x04cf
                boolean r2 = r130.isEcoModeOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x04d0
            L_0x04cf:
                r2 = r3
            L_0x04d0:
                if (r2 == 0) goto L_0x04d3
                goto L_0x04bd
            L_0x04d3:
                r50 = r6
            L_0x04d5:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$33 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$33.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasHinsMode
                if (r5 == 0) goto L_0x04e2
                java.lang.Object r2 = r2.get(r0)
                goto L_0x04e3
            L_0x04e2:
                r2 = r3
            L_0x04e3:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x04ee
            L_0x04e7:
                boolean r2 = r2.booleanValue()
                r51 = r2
                goto L_0x04ff
            L_0x04ee:
                if (r130 == 0) goto L_0x04f9
                boolean r2 = r130.isHinsModeOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x04fa
            L_0x04f9:
                r2 = r3
            L_0x04fa:
                if (r2 == 0) goto L_0x04fd
                goto L_0x04e7
            L_0x04fd:
                r51 = r6
            L_0x04ff:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$34 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$34.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x050a
                java.lang.Object r2 = r2.get(r0)
                goto L_0x050b
            L_0x050a:
                r2 = r3
            L_0x050b:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0516
            L_0x050f:
                boolean r2 = r2.booleanValue()
                r52 = r2
                goto L_0x0527
            L_0x0516:
                if (r130 == 0) goto L_0x0521
                boolean r2 = r130.isHinsNightModeOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0522
            L_0x0521:
                r2 = r3
            L_0x0522:
                if (r2 == 0) goto L_0x0525
                goto L_0x050f
            L_0x0525:
                r52 = r6
            L_0x0527:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$35 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$35.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasG4NightMode
                if (r5 == 0) goto L_0x0534
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0535
            L_0x0534:
                r2 = r3
            L_0x0535:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0540
            L_0x0539:
                boolean r2 = r2.booleanValue()
                r53 = r2
                goto L_0x0551
            L_0x0540:
                if (r130 == 0) goto L_0x054b
                boolean r2 = r130.isG4NightModeOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x054c
            L_0x054b:
                r2 = r3
            L_0x054c:
                if (r2 == 0) goto L_0x054f
                goto L_0x0539
            L_0x054f:
                r53 = r6
            L_0x0551:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$36 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$36.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r7 = r0 instanceof com.blueair.core.model.HasGermShieldMode
                if (r7 == 0) goto L_0x055e
                java.lang.Object r2 = r2.get(r0)
                goto L_0x055f
            L_0x055e:
                r2 = r3
            L_0x055f:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x056a
            L_0x0563:
                boolean r2 = r2.booleanValue()
                r54 = r2
                goto L_0x057b
            L_0x056a:
                if (r130 == 0) goto L_0x0575
                boolean r2 = r130.isGermShieldOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0576
            L_0x0575:
                r2 = r3
            L_0x0576:
                if (r2 == 0) goto L_0x0579
                goto L_0x0563
            L_0x0579:
                r54 = r6
            L_0x057b:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$37 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$37.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r7 == 0) goto L_0x0586
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0587
            L_0x0586:
                r2 = r3
            L_0x0587:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 != 0) goto L_0x0595
                if (r130 == 0) goto L_0x0592
                java.lang.Boolean r2 = r130.isGermShieldNightModeOn()
                goto L_0x0595
            L_0x0592:
                r55 = r3
                goto L_0x0597
            L_0x0595:
                r55 = r2
            L_0x0597:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$38 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$38.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r7 = r0 instanceof com.blueair.core.model.HasSafetySwitch
                if (r7 == 0) goto L_0x05a4
                java.lang.Object r2 = r2.get(r0)
                goto L_0x05a5
            L_0x05a4:
                r2 = r3
            L_0x05a5:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                r7 = 1
                if (r2 == 0) goto L_0x05b1
            L_0x05aa:
                boolean r2 = r2.booleanValue()
                r56 = r2
                goto L_0x05c2
            L_0x05b1:
                if (r130 == 0) goto L_0x05bc
                boolean r2 = r130.isSafetySwitchOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x05bd
            L_0x05bc:
                r2 = r3
            L_0x05bd:
                if (r2 == 0) goto L_0x05c0
                goto L_0x05aa
            L_0x05c0:
                r56 = r7
            L_0x05c2:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$39 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$39.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x05cd
                java.lang.Object r2 = r2.get(r0)
                goto L_0x05ce
            L_0x05cd:
                r2 = r3
            L_0x05ce:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 != 0) goto L_0x05df
                if (r130 == 0) goto L_0x05d9
                java.lang.String r2 = r130.getG4NightModefilterTrigger()
                goto L_0x05da
            L_0x05d9:
                r2 = r3
            L_0x05da:
                if (r2 != 0) goto L_0x05df
                r57 = r11
                goto L_0x05e1
            L_0x05df:
                r57 = r2
            L_0x05e1:
                if (r130 == 0) goto L_0x05ea
                boolean r2 = r130.getAimInstalled()
                r58 = r2
                goto L_0x05ec
            L_0x05ea:
                r58 = r6
            L_0x05ec:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$40 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$40.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasCompatibility
                if (r5 == 0) goto L_0x05f9
                java.lang.Object r2 = r2.get(r0)
                goto L_0x05fa
            L_0x05f9:
                r2 = r3
            L_0x05fa:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 != 0) goto L_0x0608
                if (r130 == 0) goto L_0x0605
                java.lang.String r2 = r130.getCompatibility()
                goto L_0x0608
            L_0x0605:
                r60 = r3
                goto L_0x060a
            L_0x0608:
                r60 = r2
            L_0x060a:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$41 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$41.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasSKU
                if (r5 == 0) goto L_0x0617
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0618
            L_0x0617:
                r2 = r3
            L_0x0618:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 != 0) goto L_0x0626
                if (r130 == 0) goto L_0x0623
                java.lang.String r2 = r130.getSku()
                goto L_0x0626
            L_0x0623:
                r59 = r3
                goto L_0x0628
            L_0x0626:
                r59 = r2
            L_0x0628:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$42 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$42.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWelcomeHome
                if (r5 == 0) goto L_0x0635
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0636
            L_0x0635:
                r2 = r3
            L_0x0636:
                r61 = r2
                com.blueair.core.model.WelcomeHomeLocation r61 = (com.blueair.core.model.WelcomeHomeLocation) r61
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$43 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$43.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasLocation
                if (r5 == 0) goto L_0x0647
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0648
            L_0x0647:
                r2 = r3
            L_0x0648:
                r62 = r2
                java.lang.String r62 = (java.lang.String) r62
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$44 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$44.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasDisinfection
                if (r5 == 0) goto L_0x0659
                java.lang.Object r2 = r2.get(r0)
                goto L_0x065a
            L_0x0659:
                r2 = r3
            L_0x065a:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 != 0) goto L_0x0668
                if (r130 == 0) goto L_0x0665
                java.lang.Boolean r2 = r130.getDisinfection()
                goto L_0x0668
            L_0x0665:
                r63 = r3
                goto L_0x066a
            L_0x0668:
                r63 = r2
            L_0x066a:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$45 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$45.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0675
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0676
            L_0x0675:
                r2 = r3
            L_0x0676:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 != 0) goto L_0x0684
                if (r130 == 0) goto L_0x0681
                java.lang.Integer r2 = r130.getDisinfectLeftTime()
                goto L_0x0684
            L_0x0681:
                r64 = r3
                goto L_0x0686
            L_0x0684:
                r64 = r2
            L_0x0686:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$46 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$46.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0691
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0692
            L_0x0691:
                r2 = r3
            L_0x0692:
                java.lang.Long r2 = (java.lang.Long) r2
                if (r2 != 0) goto L_0x06a0
                if (r130 == 0) goto L_0x069d
                java.lang.Long r2 = r130.getDisinfectLeftTimeUpdateTime()
                goto L_0x06a0
            L_0x069d:
                r65 = r3
                goto L_0x06a2
            L_0x06a0:
                r65 = r2
            L_0x06a2:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$47 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$47.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWick
                if (r5 == 0) goto L_0x06af
                java.lang.Object r2 = r2.get(r0)
                goto L_0x06b0
            L_0x06af:
                r2 = r3
            L_0x06b0:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x06bb
            L_0x06b4:
                boolean r2 = r2.booleanValue()
                r66 = r2
                goto L_0x06cc
            L_0x06bb:
                if (r130 == 0) goto L_0x06c6
                boolean r2 = r130.getWickdryEnabled()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x06c7
            L_0x06c6:
                r2 = r3
            L_0x06c7:
                if (r2 == 0) goto L_0x06ca
                goto L_0x06b4
            L_0x06ca:
                r66 = r6
            L_0x06cc:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$48 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$48.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x06d7
                java.lang.Object r2 = r2.get(r0)
                goto L_0x06d8
            L_0x06d7:
                r2 = r3
            L_0x06d8:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x06e3
            L_0x06dc:
                boolean r2 = r2.booleanValue()
                r67 = r2
                goto L_0x06f4
            L_0x06e3:
                if (r130 == 0) goto L_0x06ee
                boolean r2 = r130.getWickdryOn()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x06ef
            L_0x06ee:
                r2 = r3
            L_0x06ef:
                if (r2 == 0) goto L_0x06f2
                goto L_0x06dc
            L_0x06f2:
                r67 = r6
            L_0x06f4:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$49 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$49.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x06ff
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0700
            L_0x06ff:
                r2 = r3
            L_0x0700:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x070b
            L_0x0704:
                int r2 = r2.intValue()
                r68 = r2
                goto L_0x071c
            L_0x070b:
                if (r130 == 0) goto L_0x0716
                int r2 = r130.getWickdryLeftTime()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0717
            L_0x0716:
                r2 = r3
            L_0x0717:
                if (r2 == 0) goto L_0x071a
                goto L_0x0704
            L_0x071a:
                r68 = r6
            L_0x071c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$50 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$50.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0727
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0728
            L_0x0727:
                r2 = r3
            L_0x0728:
                java.lang.Long r2 = (java.lang.Long) r2
                if (r2 == 0) goto L_0x0733
            L_0x072c:
                long r24 = r2.longValue()
                r69 = r24
                goto L_0x0744
            L_0x0733:
                if (r130 == 0) goto L_0x073e
                long r24 = r130.getWickdryLeftTimeUpdateTime()
                java.lang.Long r2 = java.lang.Long.valueOf(r24)
                goto L_0x073f
            L_0x073e:
                r2 = r3
            L_0x073f:
                if (r2 == 0) goto L_0x0742
                goto L_0x072c
            L_0x0742:
                r69 = r9
            L_0x0744:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$51 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$51.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x074f
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0750
            L_0x074f:
                r2 = r3
            L_0x0750:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x075b
            L_0x0754:
                int r2 = r2.intValue()
                r71 = r2
                goto L_0x076c
            L_0x075b:
                if (r130 == 0) goto L_0x0766
                int r2 = r130.getWickUsage()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0767
            L_0x0766:
                r2 = r3
            L_0x0767:
                if (r2 == 0) goto L_0x076a
                goto L_0x0754
            L_0x076a:
                r71 = r6
            L_0x076c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$52 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$52.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0777
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0778
            L_0x0777:
                r2 = r3
            L_0x0778:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0783
            L_0x077c:
                boolean r2 = r2.booleanValue()
                r72 = r2
                goto L_0x0794
            L_0x0783:
                if (r130 == 0) goto L_0x078e
                boolean r2 = r130.getWaterShortage()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x078f
            L_0x078e:
                r2 = r3
            L_0x078f:
                if (r2 == 0) goto L_0x0792
                goto L_0x077c
            L_0x0792:
                r72 = r6
            L_0x0794:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$53 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$53.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasAutoRh
                if (r5 == 0) goto L_0x07a1
                java.lang.Object r2 = r2.get(r0)
                goto L_0x07a2
            L_0x07a1:
                r2 = r3
            L_0x07a2:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x07ad
            L_0x07a6:
                int r2 = r2.intValue()
            L_0x07aa:
                r73 = r2
                goto L_0x07bf
            L_0x07ad:
                if (r130 == 0) goto L_0x07b8
                int r2 = r130.getAutoRh()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x07b9
            L_0x07b8:
                r2 = r3
            L_0x07b9:
                if (r2 == 0) goto L_0x07bc
                goto L_0x07a6
            L_0x07bc:
                r2 = 50
                goto L_0x07aa
            L_0x07bf:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$54 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$54.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasTimer
                if (r5 == 0) goto L_0x07cc
                java.lang.Object r2 = r2.get(r0)
                goto L_0x07cd
            L_0x07cc:
                r2 = r3
            L_0x07cd:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x07d8
            L_0x07d1:
                int r2 = r2.intValue()
                r74 = r2
                goto L_0x07e9
            L_0x07d8:
                if (r130 == 0) goto L_0x07e3
                int r2 = r130.getTimerStatus()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x07e4
            L_0x07e3:
                r2 = r3
            L_0x07e4:
                if (r2 == 0) goto L_0x07e7
                goto L_0x07d1
            L_0x07e7:
                r74 = r6
            L_0x07e9:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$55 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$55.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x07f4
                java.lang.Object r2 = r2.get(r0)
                goto L_0x07f5
            L_0x07f4:
                r2 = r3
            L_0x07f5:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0800
            L_0x07f9:
                int r2 = r2.intValue()
                r75 = r2
                goto L_0x0811
            L_0x0800:
                if (r130 == 0) goto L_0x080b
                int r2 = r130.getTimerDuration()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x080c
            L_0x080b:
                r2 = r3
            L_0x080c:
                if (r2 == 0) goto L_0x080f
                goto L_0x07f9
            L_0x080f:
                r75 = r6
            L_0x0811:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$56 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$56.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x081c
                java.lang.Object r2 = r2.get(r0)
                goto L_0x081d
            L_0x081c:
                r2 = r3
            L_0x081d:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0828
            L_0x0821:
                int r2 = r2.intValue()
                r76 = r2
                goto L_0x0839
            L_0x0828:
                if (r130 == 0) goto L_0x0833
                int r2 = r130.getTimerLeftTime()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0834
            L_0x0833:
                r2 = r3
            L_0x0834:
                if (r2 == 0) goto L_0x0837
                goto L_0x0821
            L_0x0837:
                r76 = r6
            L_0x0839:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$57 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$57.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0844
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0845
            L_0x0844:
                r2 = r3
            L_0x0845:
                java.lang.Long r2 = (java.lang.Long) r2
                if (r2 == 0) goto L_0x0850
            L_0x0849:
                long r9 = r2.longValue()
            L_0x084d:
                r77 = r9
                goto L_0x085f
            L_0x0850:
                if (r130 == 0) goto L_0x085b
                long r24 = r130.getTimerLeftTimeUpdateTime()
                java.lang.Long r2 = java.lang.Long.valueOf(r24)
                goto L_0x085c
            L_0x085b:
                r2 = r3
            L_0x085c:
                if (r2 == 0) goto L_0x084d
                goto L_0x0849
            L_0x085f:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$58 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$58.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasTemperatureUnit
                if (r5 == 0) goto L_0x086c
                java.lang.Object r2 = r2.get(r0)
                goto L_0x086d
            L_0x086c:
                r2 = r3
            L_0x086d:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0878
            L_0x0871:
                int r2 = r2.intValue()
                r79 = r2
                goto L_0x0889
            L_0x0878:
                if (r130 == 0) goto L_0x0883
                int r2 = r130.getTemperatureUnit()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0884
            L_0x0883:
                r2 = r3
            L_0x0884:
                if (r2 == 0) goto L_0x0887
                goto L_0x0871
            L_0x0887:
                r79 = r6
            L_0x0889:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$59 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$59.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasOscillation
                if (r5 == 0) goto L_0x0896
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0897
            L_0x0896:
                r2 = r3
            L_0x0897:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x08a2
            L_0x089b:
                int r2 = r2.intValue()
                r80 = r2
                goto L_0x08b3
            L_0x08a2:
                if (r130 == 0) goto L_0x08ad
                int r2 = r130.getOscillationState()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x08ae
            L_0x08ad:
                r2 = r3
            L_0x08ae:
                if (r2 == 0) goto L_0x08b1
                goto L_0x089b
            L_0x08b1:
                r80 = r6
            L_0x08b3:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$60 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$60.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x08be
                java.lang.Object r2 = r2.get(r0)
                goto L_0x08bf
            L_0x08be:
                r2 = r3
            L_0x08bf:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x08ca
            L_0x08c3:
                int r2 = r2.intValue()
            L_0x08c7:
                r81 = r2
                goto L_0x08dc
            L_0x08ca:
                if (r130 == 0) goto L_0x08d5
                int r2 = r130.getOscillationAngle()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x08d6
            L_0x08d5:
                r2 = r3
            L_0x08d6:
                if (r2 == 0) goto L_0x08d9
                goto L_0x08c3
            L_0x08d9:
                r2 = 90
                goto L_0x08c7
            L_0x08dc:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$61 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$61.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x08e7
                java.lang.Object r2 = r2.get(r0)
                goto L_0x08e8
            L_0x08e7:
                r2 = r3
            L_0x08e8:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x08f3
            L_0x08ec:
                int r2 = r2.intValue()
                r82 = r2
                goto L_0x0904
            L_0x08f3:
                if (r130 == 0) goto L_0x08fe
                int r2 = r130.getOscillationDirection()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x08ff
            L_0x08fe:
                r2 = r3
            L_0x08ff:
                if (r2 == 0) goto L_0x0902
                goto L_0x08ec
            L_0x0902:
                r82 = r6
            L_0x0904:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$62 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$62.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x090f
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0910
            L_0x090f:
                r2 = r3
            L_0x0910:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x091b
            L_0x0914:
                int r2 = r2.intValue()
                r83 = r2
                goto L_0x092c
            L_0x091b:
                if (r130 == 0) goto L_0x0926
                int r2 = r130.getOscillationFanSpeed()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0927
            L_0x0926:
                r2 = r3
            L_0x0927:
                if (r2 == 0) goto L_0x092a
                goto L_0x0914
            L_0x092a:
                r83 = r6
            L_0x092c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$63 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$63.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasCombo3in1MainMode
                if (r5 == 0) goto L_0x0939
                java.lang.Object r2 = r2.get(r0)
                goto L_0x093a
            L_0x0939:
                r2 = r3
            L_0x093a:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0945
            L_0x093e:
                int r2 = r2.intValue()
                r84 = r2
                goto L_0x0956
            L_0x0945:
                if (r130 == 0) goto L_0x0950
                int r2 = r130.getMainMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0951
            L_0x0950:
                r2 = r3
            L_0x0951:
                if (r2 == 0) goto L_0x0954
                goto L_0x093e
            L_0x0954:
                r84 = r6
            L_0x0956:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$64 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$64.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0961
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0962
            L_0x0961:
                r2 = r3
            L_0x0962:
                java.lang.Integer r2 = (java.lang.Integer) r2
                r9 = 2
                if (r2 == 0) goto L_0x096e
            L_0x0967:
                int r2 = r2.intValue()
                r85 = r2
                goto L_0x097f
            L_0x096e:
                if (r130 == 0) goto L_0x0979
                int r2 = r130.getApSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x097a
            L_0x0979:
                r2 = r3
            L_0x097a:
                if (r2 == 0) goto L_0x097d
                goto L_0x0967
            L_0x097d:
                r85 = r9
            L_0x097f:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$65 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$65.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x098a
                java.lang.Object r2 = r2.get(r0)
                goto L_0x098b
            L_0x098a:
                r2 = r3
            L_0x098b:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0996
            L_0x098f:
                int r2 = r2.intValue()
                r86 = r2
                goto L_0x09a7
            L_0x0996:
                if (r130 == 0) goto L_0x09a1
                int r2 = r130.getApFanSpeed()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x09a2
            L_0x09a1:
                r2 = r3
            L_0x09a2:
                if (r2 == 0) goto L_0x09a5
                goto L_0x098f
            L_0x09a5:
                r86 = r6
            L_0x09a7:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$66 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$66.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x09b2
                java.lang.Object r2 = r2.get(r0)
                goto L_0x09b3
            L_0x09b2:
                r2 = r3
            L_0x09b3:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x09be
            L_0x09b7:
                int r2 = r2.intValue()
                r87 = r2
                goto L_0x09cf
            L_0x09be:
                if (r130 == 0) goto L_0x09c9
                int r2 = r130.getHeatSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x09ca
            L_0x09c9:
                r2 = r3
            L_0x09ca:
                if (r2 == 0) goto L_0x09cd
                goto L_0x09b7
            L_0x09cd:
                r87 = r9
            L_0x09cf:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$67 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$67.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x09da
                java.lang.Object r2 = r2.get(r0)
                goto L_0x09db
            L_0x09da:
                r2 = r3
            L_0x09db:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x09e6
            L_0x09df:
                int r2 = r2.intValue()
                r88 = r2
                goto L_0x09f7
            L_0x09e6:
                if (r130 == 0) goto L_0x09f1
                int r2 = r130.getHeatFanSpeed()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x09f2
            L_0x09f1:
                r2 = r3
            L_0x09f2:
                if (r2 == 0) goto L_0x09f5
                goto L_0x09df
            L_0x09f5:
                r88 = r6
            L_0x09f7:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$68 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$68.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0a02
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0a03
            L_0x0a02:
                r2 = r3
            L_0x0a03:
                java.lang.Double r2 = (java.lang.Double) r2
                r10 = 4626885667169763328(0x4036000000000000, double:22.0)
                if (r2 == 0) goto L_0x0a10
            L_0x0a09:
                double r24 = r2.doubleValue()
                r89 = r24
                goto L_0x0a21
            L_0x0a10:
                if (r130 == 0) goto L_0x0a1b
                double r24 = r130.getHeatAutoTmp()
                java.lang.Double r2 = java.lang.Double.valueOf(r24)
                goto L_0x0a1c
            L_0x0a1b:
                r2 = r3
            L_0x0a1c:
                if (r2 == 0) goto L_0x0a1f
                goto L_0x0a09
            L_0x0a1f:
                r89 = r10
            L_0x0a21:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$69 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$69.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0a2c
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0a2d
            L_0x0a2c:
                r2 = r3
            L_0x0a2d:
                java.lang.Double r2 = (java.lang.Double) r2
                if (r2 == 0) goto L_0x0a38
            L_0x0a31:
                double r10 = r2.doubleValue()
            L_0x0a35:
                r91 = r10
                goto L_0x0a47
            L_0x0a38:
                if (r130 == 0) goto L_0x0a43
                double r24 = r130.getHeatEcoTmp()
                java.lang.Double r2 = java.lang.Double.valueOf(r24)
                goto L_0x0a44
            L_0x0a43:
                r2 = r3
            L_0x0a44:
                if (r2 == 0) goto L_0x0a35
                goto L_0x0a31
            L_0x0a47:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$70 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$70.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0a52
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0a53
            L_0x0a52:
                r2 = r3
            L_0x0a53:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0a5e
            L_0x0a57:
                int r2 = r2.intValue()
                r93 = r2
                goto L_0x0a6f
            L_0x0a5e:
                if (r130 == 0) goto L_0x0a69
                int r2 = r130.getCoolSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0a6a
            L_0x0a69:
                r2 = r3
            L_0x0a6a:
                if (r2 == 0) goto L_0x0a6d
                goto L_0x0a57
            L_0x0a6d:
                r93 = r9
            L_0x0a6f:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$71 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$71.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0a7a
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0a7b
            L_0x0a7a:
                r2 = r3
            L_0x0a7b:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0a86
            L_0x0a7f:
                int r2 = r2.intValue()
                r94 = r2
                goto L_0x0a97
            L_0x0a86:
                if (r130 == 0) goto L_0x0a91
                int r2 = r130.getCoolFanSpeed()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0a92
            L_0x0a91:
                r2 = r3
            L_0x0a92:
                if (r2 == 0) goto L_0x0a95
                goto L_0x0a7f
            L_0x0a95:
                r94 = r6
            L_0x0a97:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$72 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$72.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0aa2
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0aa3
            L_0x0aa2:
                r2 = r3
            L_0x0aa3:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0aae
            L_0x0aa7:
                int r2 = r2.intValue()
                r95 = r2
                goto L_0x0abf
            L_0x0aae:
                if (r130 == 0) goto L_0x0ab9
                int r2 = r130.getCoolAutoTag()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0aba
            L_0x0ab9:
                r2 = r3
            L_0x0aba:
                if (r2 == 0) goto L_0x0abd
                goto L_0x0aa7
            L_0x0abd:
                r95 = r6
            L_0x0abf:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$73 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$73.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0aca
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0acb
            L_0x0aca:
                r2 = r3
            L_0x0acb:
                double[] r2 = (double[]) r2
                r10 = 4627730092099895296(0x4039000000000000, double:25.0)
                r24 = 4626322717216342016(0x4034000000000000, double:20.0)
                if (r2 != 0) goto L_0x0ae8
                if (r130 == 0) goto L_0x0ada
                double[] r2 = r130.getCoolAutoPresets()
                goto L_0x0adb
            L_0x0ada:
                r2 = r3
            L_0x0adb:
                if (r2 != 0) goto L_0x0ae8
                r2 = 3
                double[] r2 = new double[r2]
                r2[r6] = r24
                r96 = 4627167142146473984(0x4037000000000000, double:23.0)
                r2[r7] = r96
                r2[r9] = r10
            L_0x0ae8:
                r96 = r2
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$74 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$74.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0af5
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0af6
            L_0x0af5:
                r2 = r3
            L_0x0af6:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0b01
            L_0x0afa:
                int r2 = r2.intValue()
                r97 = r2
                goto L_0x0b12
            L_0x0b01:
                if (r130 == 0) goto L_0x0b0c
                int r2 = r130.getCoolEcoTag()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0b0d
            L_0x0b0c:
                r2 = r3
            L_0x0b0d:
                if (r2 == 0) goto L_0x0b10
                goto L_0x0afa
            L_0x0b10:
                r97 = r6
            L_0x0b12:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$75 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$75.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0b1d
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0b1e
            L_0x0b1d:
                r2 = r3
            L_0x0b1e:
                double[] r2 = (double[]) r2
                if (r2 != 0) goto L_0x0b32
                if (r130 == 0) goto L_0x0b29
                double[] r2 = r130.getCoolEcoPresets()
                goto L_0x0b2a
            L_0x0b29:
                r2 = r3
            L_0x0b2a:
                if (r2 != 0) goto L_0x0b32
                double[] r2 = new double[r9]
                r2[r6] = r24
                r2[r7] = r10
            L_0x0b32:
                r98 = r2
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$76 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$76.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasMode
                if (r5 == 0) goto L_0x0b41
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0b42
            L_0x0b41:
                r2 = r3
            L_0x0b42:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0b4d
            L_0x0b46:
                int r2 = r2.intValue()
                r100 = r2
                goto L_0x0b5e
            L_0x0b4d:
                if (r130 == 0) goto L_0x0b58
                int r2 = r130.getMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0b59
            L_0x0b58:
                r2 = r3
            L_0x0b59:
                if (r2 == 0) goto L_0x0b5c
                goto L_0x0b46
            L_0x0b5c:
                r100 = r7
            L_0x0b5e:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$77 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$77.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasHumMode
                if (r5 == 0) goto L_0x0b6b
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0b6c
            L_0x0b6b:
                r2 = r3
            L_0x0b6c:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0b77
            L_0x0b70:
                boolean r2 = r2.booleanValue()
                r99 = r2
                goto L_0x0b88
            L_0x0b77:
                if (r130 == 0) goto L_0x0b82
                boolean r2 = r130.getHumMode()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0b83
            L_0x0b82:
                r2 = r3
            L_0x0b83:
                if (r2 == 0) goto L_0x0b86
                goto L_0x0b70
            L_0x0b86:
                r99 = r6
            L_0x0b88:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$78 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$78.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWaterLevel
                if (r5 == 0) goto L_0x0b95
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0b96
            L_0x0b95:
                r2 = r3
            L_0x0b96:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0ba1
            L_0x0b9a:
                int r2 = r2.intValue()
                r101 = r2
                goto L_0x0bb2
            L_0x0ba1:
                if (r130 == 0) goto L_0x0bac
                int r2 = r130.getWaterLevel()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0bad
            L_0x0bac:
                r2 = r3
            L_0x0bad:
                if (r2 == 0) goto L_0x0bb0
                goto L_0x0b9a
            L_0x0bb0:
                r101 = r6
            L_0x0bb2:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$79 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$79.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasDehumidifierMainMode
                if (r5 == 0) goto L_0x0bbf
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0bc0
            L_0x0bbf:
                r2 = r3
            L_0x0bc0:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0bcb
            L_0x0bc4:
                int r2 = r2.intValue()
                r102 = r2
                goto L_0x0bdc
            L_0x0bcb:
                if (r130 == 0) goto L_0x0bd6
                int r2 = r130.getDehSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0bd7
            L_0x0bd6:
                r2 = r3
            L_0x0bd7:
                if (r2 == 0) goto L_0x0bda
                goto L_0x0bc4
            L_0x0bda:
                r102 = r7
            L_0x0bdc:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$80 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$80.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWaterTank
                if (r5 == 0) goto L_0x0be9
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0bea
            L_0x0be9:
                r2 = r3
            L_0x0bea:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0bf5
            L_0x0bee:
                boolean r2 = r2.booleanValue()
                r103 = r2
                goto L_0x0c06
            L_0x0bf5:
                if (r130 == 0) goto L_0x0c00
                boolean r2 = r130.getWaterTankFailure()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0c01
            L_0x0c00:
                r2 = r3
            L_0x0c01:
                if (r2 == 0) goto L_0x0c04
                goto L_0x0bee
            L_0x0c04:
                r103 = r6
            L_0x0c06:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$81 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$81.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasPetMainMode
                if (r5 == 0) goto L_0x0c13
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0c14
            L_0x0c13:
                r2 = r3
            L_0x0c14:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0c1f
            L_0x0c18:
                int r2 = r2.intValue()
                r104 = r2
                goto L_0x0c30
            L_0x0c1f:
                if (r130 == 0) goto L_0x0c2a
                int r2 = r130.getSmartSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0c2b
            L_0x0c2a:
                r2 = r3
            L_0x0c2b:
                if (r2 == 0) goto L_0x0c2e
                goto L_0x0c18
            L_0x0c2e:
                r104 = r6
            L_0x0c30:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$82 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$82.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasDetectCat
                if (r5 == 0) goto L_0x0c3d
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0c3e
            L_0x0c3d:
                r2 = r3
            L_0x0c3e:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0c49
            L_0x0c42:
                boolean r2 = r2.booleanValue()
                r105 = r2
                goto L_0x0c5a
            L_0x0c49:
                if (r130 == 0) goto L_0x0c54
                boolean r2 = r130.getDetectCat()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0c55
            L_0x0c54:
                r2 = r3
            L_0x0c55:
                if (r2 == 0) goto L_0x0c58
                goto L_0x0c42
            L_0x0c58:
                r105 = r6
            L_0x0c5a:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$83 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$83.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasBody
                if (r5 == 0) goto L_0x0c67
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0c68
            L_0x0c67:
                r2 = r3
            L_0x0c68:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0c73
            L_0x0c6c:
                boolean r2 = r2.booleanValue()
                r106 = r2
                goto L_0x0c84
            L_0x0c73:
                if (r130 == 0) goto L_0x0c7e
                boolean r2 = r130.getBodyMounted()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0c7f
            L_0x0c7e:
                r2 = r3
            L_0x0c7f:
                if (r2 == 0) goto L_0x0c82
                goto L_0x0c6c
            L_0x0c82:
                r106 = r7
            L_0x0c84:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$84 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$84.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasCleanAirEta
                if (r5 == 0) goto L_0x0c91
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0c92
            L_0x0c91:
                r2 = r3
            L_0x0c92:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0c9d
            L_0x0c96:
                int r2 = r2.intValue()
                r107 = r2
                goto L_0x0cae
            L_0x0c9d:
                if (r130 == 0) goto L_0x0ca8
                int r2 = r130.getCleanAirEta()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0ca9
            L_0x0ca8:
                r2 = r3
            L_0x0ca9:
                if (r2 == 0) goto L_0x0cac
                goto L_0x0c96
            L_0x0cac:
                r107 = r6
            L_0x0cae:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$85 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$85.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasDisplayMode
                if (r5 == 0) goto L_0x0cbb
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0cbc
            L_0x0cbb:
                r2 = r3
            L_0x0cbc:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0cc7
            L_0x0cc0:
                int r2 = r2.intValue()
                r108 = r2
                goto L_0x0cd8
            L_0x0cc7:
                if (r130 == 0) goto L_0x0cd2
                int r2 = r130.getPanelDisplayMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0cd3
            L_0x0cd2:
                r2 = r3
            L_0x0cd3:
                if (r2 == 0) goto L_0x0cd6
                goto L_0x0cc0
            L_0x0cd6:
                r108 = r6
            L_0x0cd8:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$86 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$86.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasGestureRecognition
                if (r5 == 0) goto L_0x0ce5
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0ce6
            L_0x0ce5:
                r2 = r3
            L_0x0ce6:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0cf1
            L_0x0cea:
                boolean r2 = r2.booleanValue()
                r109 = r2
                goto L_0x0d02
            L_0x0cf1:
                if (r130 == 0) goto L_0x0cfc
                boolean r2 = r130.getHoverEnabled()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0cfd
            L_0x0cfc:
                r2 = r3
            L_0x0cfd:
                if (r2 == 0) goto L_0x0d00
                goto L_0x0cea
            L_0x0d00:
                r109 = r7
            L_0x0d02:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$87 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$87.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasAirRefresh
                if (r5 == 0) goto L_0x0d0f
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0d10
            L_0x0d0f:
                r2 = r3
            L_0x0d10:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0d1b
            L_0x0d14:
                boolean r2 = r2.booleanValue()
                r110 = r2
                goto L_0x0d2c
            L_0x0d1b:
                if (r130 == 0) goto L_0x0d26
                boolean r2 = r130.getAirRefreshEnabled()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0d27
            L_0x0d26:
                r2 = r3
            L_0x0d27:
                if (r2 == 0) goto L_0x0d2a
                goto L_0x0d14
            L_0x0d2a:
                r110 = r7
            L_0x0d2c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$88 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$88.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0d37
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0d38
            L_0x0d37:
                r2 = r3
            L_0x0d38:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0d43
            L_0x0d3c:
                int r2 = r2.intValue()
                r111 = r2
                goto L_0x0d54
            L_0x0d43:
                if (r130 == 0) goto L_0x0d4e
                int r2 = r130.getAirRefreshStatus()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0d4f
            L_0x0d4e:
                r2 = r3
            L_0x0d4f:
                if (r2 == 0) goto L_0x0d52
                goto L_0x0d3c
            L_0x0d52:
                r111 = r6
            L_0x0d54:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$89 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$89.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0d5f
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0d60
            L_0x0d5f:
                r2 = r3
            L_0x0d60:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0d6b
            L_0x0d64:
                int r2 = r2.intValue()
                r112 = r2
                goto L_0x0d7c
            L_0x0d6b:
                if (r130 == 0) goto L_0x0d76
                int r2 = r130.getAirRefreshDuration()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0d77
            L_0x0d76:
                r2 = r3
            L_0x0d77:
                if (r2 == 0) goto L_0x0d7a
                goto L_0x0d64
            L_0x0d7a:
                r112 = r6
            L_0x0d7c:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$90 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$90.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0d87
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0d88
            L_0x0d87:
                r2 = r3
            L_0x0d88:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0d93
            L_0x0d8c:
                int r2 = r2.intValue()
                r113 = r2
                goto L_0x0da4
            L_0x0d93:
                if (r130 == 0) goto L_0x0d9e
                int r2 = r130.getAirRefreshTimeStamp()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0d9f
            L_0x0d9e:
                r2 = r3
            L_0x0d9f:
                if (r2 == 0) goto L_0x0da2
                goto L_0x0d8c
            L_0x0da2:
                r113 = r6
            L_0x0da4:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$91 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$91.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0daf
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0db0
            L_0x0daf:
                r2 = r3
            L_0x0db0:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0dbb
            L_0x0db4:
                int r2 = r2.intValue()
                r114 = r2
                goto L_0x0dcc
            L_0x0dbb:
                if (r130 == 0) goto L_0x0dc6
                int r2 = r130.getAirRefreshStartTimeStamp()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0dc7
            L_0x0dc6:
                r2 = r3
            L_0x0dc7:
                if (r2 == 0) goto L_0x0dca
                goto L_0x0db4
            L_0x0dca:
                r114 = r6
            L_0x0dcc:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$92 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$92.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0dd7
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0dd8
            L_0x0dd7:
                r2 = r3
            L_0x0dd8:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0de3
            L_0x0ddc:
                int r2 = r2.intValue()
                r115 = r2
                goto L_0x0df4
            L_0x0de3:
                if (r130 == 0) goto L_0x0dee
                int r2 = r130.getAirRefreshEndTimeStamp()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0def
            L_0x0dee:
                r2 = r3
            L_0x0def:
                if (r2 == 0) goto L_0x0df2
                goto L_0x0ddc
            L_0x0df2:
                r115 = r6
            L_0x0df4:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$93 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$93.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasRoom
                if (r5 == 0) goto L_0x0e01
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0e02
            L_0x0e01:
                r2 = r3
            L_0x0e02:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0e0d
            L_0x0e06:
                int r2 = r2.intValue()
                r116 = r2
                goto L_0x0e1e
            L_0x0e0d:
                if (r130 == 0) goto L_0x0e18
                int r2 = r130.getRoomType()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0e19
            L_0x0e18:
                r2 = r3
            L_0x0e19:
                if (r2 == 0) goto L_0x0e1c
                goto L_0x0e06
            L_0x0e1c:
                r116 = r6
            L_0x0e1e:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$94 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$94.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasMoodLamp
                if (r5 == 0) goto L_0x0e2b
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0e2c
            L_0x0e2b:
                r2 = r3
            L_0x0e2c:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0e37
            L_0x0e30:
                int r2 = r2.intValue()
                r117 = r2
                goto L_0x0e48
            L_0x0e37:
                if (r130 == 0) goto L_0x0e42
                int r2 = r130.getNightLampBrightness()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0e43
            L_0x0e42:
                r2 = r3
            L_0x0e43:
                if (r2 == 0) goto L_0x0e46
                goto L_0x0e30
            L_0x0e46:
                r117 = r6
            L_0x0e48:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$95 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$95.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWickDryDuration
                if (r5 == 0) goto L_0x0e55
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0e56
            L_0x0e55:
                r2 = r3
            L_0x0e56:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0e61
            L_0x0e5a:
                int r2 = r2.intValue()
                r118 = r2
                goto L_0x0e72
            L_0x0e61:
                if (r130 == 0) goto L_0x0e6c
                int r2 = r130.getWickdryDuration()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0e6d
            L_0x0e6c:
                r2 = r3
            L_0x0e6d:
                if (r2 == 0) goto L_0x0e70
                goto L_0x0e5a
            L_0x0e70:
                r118 = r6
            L_0x0e72:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$96 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$96.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0e7d
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0e7e
            L_0x0e7d:
                r2 = r3
            L_0x0e7e:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0e89
            L_0x0e82:
                boolean r2 = r2.booleanValue()
                r119 = r2
                goto L_0x0e9a
            L_0x0e89:
                if (r130 == 0) goto L_0x0e94
                boolean r2 = r130.getWickdryDone()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0e95
            L_0x0e94:
                r2 = r3
            L_0x0e95:
                if (r2 == 0) goto L_0x0e98
                goto L_0x0e82
            L_0x0e98:
                r119 = r6
            L_0x0e9a:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$97 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$97.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasRemoveYellowWater
                if (r5 == 0) goto L_0x0ea7
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0ea8
            L_0x0ea7:
                r2 = r3
            L_0x0ea8:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 != 0) goto L_0x0eb6
                if (r130 == 0) goto L_0x0eb3
                java.lang.Boolean r2 = r130.getYwrmEnabled()
                goto L_0x0eb6
            L_0x0eb3:
                r120 = r3
                goto L_0x0eb8
            L_0x0eb6:
                r120 = r2
            L_0x0eb8:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$98 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$98.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                if (r5 == 0) goto L_0x0ec3
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0ec4
            L_0x0ec3:
                r2 = r3
            L_0x0ec4:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0ecf
            L_0x0ec8:
                int r2 = r2.intValue()
                r121 = r2
                goto L_0x0ee0
            L_0x0ecf:
                if (r130 == 0) goto L_0x0eda
                int r2 = r130.getYwrmUsage()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0edb
            L_0x0eda:
                r2 = r3
            L_0x0edb:
                if (r2 == 0) goto L_0x0ede
                goto L_0x0ec8
            L_0x0ede:
                r121 = r6
            L_0x0ee0:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$99 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$99.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasNightLamp
                if (r5 == 0) goto L_0x0eed
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0eee
            L_0x0eed:
                r2 = r3
            L_0x0eee:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0ef9
            L_0x0ef2:
                int r2 = r2.intValue()
                r122 = r2
                goto L_0x0f0a
            L_0x0ef9:
                if (r130 == 0) goto L_0x0f04
                int r2 = r130.getNightLampSteplessBrightness()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0f05
            L_0x0f04:
                r2 = r3
            L_0x0f05:
                if (r2 == 0) goto L_0x0f08
                goto L_0x0ef2
            L_0x0f08:
                r122 = r6
            L_0x0f0a:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$100 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$100.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasAlarm
                if (r5 == 0) goto L_0x0f17
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0f18
            L_0x0f17:
                r2 = r3
            L_0x0f18:
                java.util.List r2 = (java.util.List) r2
                if (r2 != 0) goto L_0x0f2a
                if (r130 == 0) goto L_0x0f23
                java.util.List r2 = r130.getAlarms()
                goto L_0x0f24
            L_0x0f23:
                r2 = r3
            L_0x0f24:
                if (r2 != 0) goto L_0x0f2a
                java.util.List r2 = r8.getNULL_ALARM_LIST()
            L_0x0f2a:
                r123 = r2
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$101 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$101.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasHumMainMode
                if (r5 == 0) goto L_0x0f39
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0f3a
            L_0x0f39:
                r2 = r3
            L_0x0f3a:
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0f45
            L_0x0f3e:
                int r9 = r2.intValue()
            L_0x0f42:
                r124 = r9
                goto L_0x0f54
            L_0x0f45:
                if (r130 == 0) goto L_0x0f50
                int r2 = r130.getHumSubMode()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0f51
            L_0x0f50:
                r2 = r3
            L_0x0f51:
                if (r2 == 0) goto L_0x0f42
                goto L_0x0f3e
            L_0x0f54:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$102 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$102.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasHourFormat
                if (r5 == 0) goto L_0x0f61
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0f62
            L_0x0f61:
                r2 = r3
            L_0x0f62:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0f6d
            L_0x0f66:
                boolean r2 = r2.booleanValue()
                r125 = r2
                goto L_0x0f7e
            L_0x0f6d:
                if (r130 == 0) goto L_0x0f78
                boolean r2 = r130.getUse24Hour()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0f79
            L_0x0f78:
                r2 = r3
            L_0x0f79:
                if (r2 == 0) goto L_0x0f7c
                goto L_0x0f66
            L_0x0f7c:
                r125 = r7
            L_0x0f7e:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$103 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$103.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasWaterInfill
                if (r5 == 0) goto L_0x0f8b
                java.lang.Object r2 = r2.get(r0)
                goto L_0x0f8c
            L_0x0f8b:
                r2 = r3
            L_0x0f8c:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                if (r2 == 0) goto L_0x0f97
            L_0x0f90:
                boolean r6 = r2.booleanValue()
            L_0x0f94:
                r126 = r6
                goto L_0x0fa6
            L_0x0f97:
                if (r130 == 0) goto L_0x0fa2
                boolean r2 = r130.getWaterInfill()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0fa3
            L_0x0fa2:
                r2 = r3
            L_0x0fa3:
                if (r2 == 0) goto L_0x0f94
                goto L_0x0f90
            L_0x0fa6:
                com.blueair.database.entity.DeviceEntity$Companion$fromDevice$104 r2 = com.blueair.database.entity.DeviceEntity$Companion$fromDevice$104.INSTANCE
                kotlin.reflect.KProperty1 r2 = (kotlin.reflect.KProperty1) r2
                boolean r5 = r0 instanceof com.blueair.core.model.HasSensorMode
                if (r5 == 0) goto L_0x0fb3
                java.lang.Object r0 = r2.get(r0)
                goto L_0x0fb4
            L_0x0fb3:
                r0 = r3
            L_0x0fb4:
                java.lang.Integer r0 = (java.lang.Integer) r0
                if (r0 == 0) goto L_0x0fbf
                int r7 = r0.intValue()
            L_0x0fbc:
                r127 = r7
                goto L_0x0fd0
            L_0x0fbf:
                if (r130 == 0) goto L_0x0fc9
                int r0 = r130.getSensorMode()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            L_0x0fc9:
                if (r3 == 0) goto L_0x0fbc
                int r7 = r3.intValue()
                goto L_0x0fbc
            L_0x0fd0:
                com.blueair.database.entity.DeviceEntity r11 = new com.blueair.database.entity.DeviceEntity
                java.lang.Integer r24 = java.lang.Integer.valueOf(r1)
                r25 = r4
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r71, r72, r73, r74, r75, r76, r77, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r91, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.DeviceEntity.Companion.fromDevice(com.blueair.core.model.Device, com.blueair.database.entity.DeviceEntity):com.blueair.database.entity.DeviceEntity");
        }

        public static /* synthetic */ DeviceEntity fromDeviceOnAblServer$default(Companion companion, DeviceDetailsOnAblServer deviceDetailsOnAblServer, DeviceEntity deviceEntity, int i, Object obj) {
            if ((i & 2) != 0) {
                deviceEntity = null;
            }
            return companion.fromDeviceOnAblServer(deviceDetailsOnAblServer, deviceEntity);
        }

        /* JADX WARNING: Removed duplicated region for block: B:171:0x023e  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x0245  */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x0249  */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x0250  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.database.entity.DeviceEntity fromDeviceOnAblServer(com.blueair.core.model.DeviceDetailsOnAblServer r127, com.blueair.database.entity.DeviceEntity r128) {
            /*
                r126 = this;
                r0 = r127
                java.lang.String r1 = "deviceOnAbl"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                com.blueair.core.model.DeviceType$Companion r1 = com.blueair.core.model.DeviceType.Companion
                java.lang.String r2 = r0.getCompatibility()
                com.blueair.core.model.DeviceType r1 = r1.fromSkuCompat(r2)
                com.blueair.core.model.DeviceType$Companion r2 = com.blueair.core.model.DeviceType.Companion
                java.lang.String r3 = r0.getCompatibility()
                java.lang.String r7 = r2.displayNameFromSkuCompat(r3)
                timber.log.Timber$Forest r2 = timber.log.Timber.Forest
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "FromDeviceOnAblServer: DeviceType == "
                r3.<init>(r4)
                r3.append(r1)
                java.lang.String r4 = " for "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r4 = ". Saving with index "
                r3.append(r4)
                int r4 = r1.getIndex()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r4 = 0
                java.lang.Object[] r5 = new java.lang.Object[r4]
                r2.d(r3, r5)
                com.blueair.database.entity.DeviceEntity r2 = new com.blueair.database.entity.DeviceEntity
                java.lang.String r5 = r0.getUuid()
                java.lang.String r3 = r0.getName()
                java.lang.String r6 = ""
                if (r3 != 0) goto L_0x0054
                r3 = r6
            L_0x0054:
                int r8 = r1.getIndex()
                if (r128 == 0) goto L_0x005f
                java.lang.Integer r9 = r128.getFanSpeed()
                goto L_0x0060
            L_0x005f:
                r9 = 0
            L_0x0060:
                if (r128 == 0) goto L_0x0067
                java.lang.Integer r10 = r128.getFilterLife()
                goto L_0x0068
            L_0x0067:
                r10 = 0
            L_0x0068:
                if (r128 == 0) goto L_0x006f
                java.lang.String r11 = r128.getAutoModeText()
                goto L_0x0070
            L_0x006f:
                r11 = 0
            L_0x0070:
                if (r128 == 0) goto L_0x0077
                java.lang.Integer r12 = r128.getBrightness()
                goto L_0x0078
            L_0x0077:
                r12 = 0
            L_0x0078:
                if (r128 == 0) goto L_0x007f
                java.lang.String r13 = r128.getInfo()
                goto L_0x0080
            L_0x007f:
                r13 = 0
            L_0x0080:
                if (r128 == 0) goto L_0x0087
                com.blueair.database.DeviceUuidEntity r14 = r128.getDeviceUuid()
                goto L_0x0088
            L_0x0087:
                r14 = 0
            L_0x0088:
                if (r128 == 0) goto L_0x0091
                com.blueair.core.model.IndoorDatapoint r15 = r128.getLatestSensorDatapoint()
                r16 = r15
                goto L_0x0093
            L_0x0091:
                r16 = 0
            L_0x0093:
                if (r128 == 0) goto L_0x009c
                java.lang.Integer r15 = r128.getLastSelectedSensorType()
                r17 = r15
                goto L_0x009e
            L_0x009c:
                r17 = 0
            L_0x009e:
                if (r128 == 0) goto L_0x00a7
                boolean r15 = r128.isNightModeOn()
                r19 = r15
                goto L_0x00a9
            L_0x00a7:
                r19 = r4
            L_0x00a9:
                if (r128 == 0) goto L_0x00b2
                boolean r15 = r128.isChildLockOn()
                r20 = r15
                goto L_0x00b4
            L_0x00b2:
                r20 = r4
            L_0x00b4:
                if (r128 == 0) goto L_0x00bd
                java.lang.String r15 = r128.getLinkedDeviceUid()
                r21 = r15
                goto L_0x00bf
            L_0x00bd:
                r21 = 0
            L_0x00bf:
                if (r128 == 0) goto L_0x00c6
                int r15 = r128.getConnectivityStatusIndex()
                goto L_0x00cc
            L_0x00c6:
                com.blueair.core.model.ConnectivityStatus r15 = com.blueair.core.model.ConnectivityStatus.ONLINE
                int r15 = r15.ordinal()
            L_0x00cc:
                r22 = r15
                r23 = 0
                if (r128 == 0) goto L_0x00d7
                long r25 = r128.getLastConnectivityMillis()
                goto L_0x00d9
            L_0x00d7:
                r25 = r23
            L_0x00d9:
                java.lang.String r15 = r0.getMac()
                if (r15 != 0) goto L_0x00ea
                if (r128 == 0) goto L_0x00e6
                java.lang.String r15 = r128.getMac()
                goto L_0x00e7
            L_0x00e6:
                r15 = 0
            L_0x00e7:
                if (r15 != 0) goto L_0x00ea
                r15 = r6
            L_0x00ea:
                java.lang.String r18 = r0.getMcuFirmware()
                if (r18 != 0) goto L_0x00fd
                if (r128 == 0) goto L_0x00f7
                java.lang.String r18 = r128.getMcuFirmware()
                goto L_0x00f9
            L_0x00f7:
                r18 = 0
            L_0x00f9:
                if (r18 != 0) goto L_0x00fd
                r18 = r6
            L_0x00fd:
                java.lang.String r27 = r0.getFirmware()
                if (r27 != 0) goto L_0x0110
                if (r128 == 0) goto L_0x010a
                java.lang.String r27 = r128.getWifiFirmware()
                goto L_0x010c
            L_0x010a:
                r27 = 0
            L_0x010c:
                if (r27 != 0) goto L_0x0110
                r27 = r6
            L_0x0110:
                if (r128 == 0) goto L_0x0118
                java.lang.String r28 = r128.getHardware()
                if (r28 != 0) goto L_0x011a
            L_0x0118:
                r28 = r6
            L_0x011a:
                java.lang.String r29 = r0.getTimezone()
                if (r29 != 0) goto L_0x012d
                if (r128 == 0) goto L_0x0127
                java.lang.String r29 = r128.getTimeZone()
                goto L_0x0129
            L_0x0127:
                r29 = 0
            L_0x0129:
                if (r29 != 0) goto L_0x012d
                r29 = r6
            L_0x012d:
                java.lang.String r30 = r0.getAimSerialNumber()
                if (r30 != 0) goto L_0x0140
                if (r128 == 0) goto L_0x013a
                java.lang.String r30 = r128.getSerial()
                goto L_0x013c
            L_0x013a:
                r30 = 0
            L_0x013c:
                if (r30 != 0) goto L_0x0140
                r30 = r6
            L_0x0140:
                if (r128 == 0) goto L_0x0148
                java.lang.String r31 = r128.getPurchaseDate()
                if (r31 != 0) goto L_0x014a
            L_0x0148:
                r31 = r6
            L_0x014a:
                if (r128 == 0) goto L_0x0152
                java.lang.String r32 = r128.getDealerName()
                if (r32 != 0) goto L_0x0154
            L_0x0152:
                r32 = r6
            L_0x0154:
                if (r128 == 0) goto L_0x015c
                java.lang.String r33 = r128.getDealerCountry()
                if (r33 != 0) goto L_0x015e
            L_0x015c:
                r33 = r6
            L_0x015e:
                if (r128 == 0) goto L_0x0166
                java.lang.String r34 = r128.getFilterType()
                if (r34 != 0) goto L_0x0168
            L_0x0166:
                r34 = r6
            L_0x0168:
                if (r128 == 0) goto L_0x0170
                java.lang.String r35 = r128.getFilterTrigger()
                if (r35 != 0) goto L_0x0172
            L_0x0170:
                r35 = r6
            L_0x0172:
                if (r128 == 0) goto L_0x017e
                double[] r36 = r128.getPm1Ranges()
                if (r36 != 0) goto L_0x017b
                goto L_0x017e
            L_0x017b:
                r1 = r36
                goto L_0x0180
            L_0x017e:
                double[] r1 = new double[r4]
            L_0x0180:
                if (r128 == 0) goto L_0x0188
                double[] r37 = r128.getPm10Ranges()
                if (r37 != 0) goto L_0x018c
            L_0x0188:
                double[] r0 = new double[r4]
                r37 = r0
            L_0x018c:
                if (r128 == 0) goto L_0x0194
                double[] r0 = r128.getPm25Ranges()
                if (r0 != 0) goto L_0x0196
            L_0x0194:
                double[] r0 = new double[r4]
            L_0x0196:
                r38 = r0
                if (r128 == 0) goto L_0x01a0
                double[] r0 = r128.getVocRanges()
                if (r0 != 0) goto L_0x01a2
            L_0x01a0:
                double[] r0 = new double[r4]
            L_0x01a2:
                r39 = r0
                if (r128 == 0) goto L_0x01ac
                double[] r0 = r128.getHchoRanges()
                if (r0 != 0) goto L_0x01ae
            L_0x01ac:
                double[] r0 = new double[r4]
            L_0x01ae:
                r40 = r0
                if (r128 == 0) goto L_0x01b9
                int r0 = r128.getUpdateProgress()
                r41 = r0
                goto L_0x01bb
            L_0x01b9:
                r41 = r4
            L_0x01bb:
                if (r128 == 0) goto L_0x01c4
                boolean r0 = r128.isStandByOn()
                r42 = r0
                goto L_0x01c6
            L_0x01c4:
                r42 = r4
            L_0x01c6:
                if (r128 == 0) goto L_0x01cf
                boolean r0 = r128.isEcoModeOn()
                r43 = r0
                goto L_0x01d1
            L_0x01cf:
                r43 = r4
            L_0x01d1:
                if (r128 == 0) goto L_0x01da
                boolean r0 = r128.isHinsModeOn()
                r44 = r0
                goto L_0x01dc
            L_0x01da:
                r44 = r4
            L_0x01dc:
                if (r128 == 0) goto L_0x01e5
                boolean r0 = r128.isHinsNightModeOn()
                r45 = r0
                goto L_0x01e7
            L_0x01e5:
                r45 = r4
            L_0x01e7:
                if (r128 == 0) goto L_0x01f0
                boolean r0 = r128.isG4NightModeOn()
                r46 = r0
                goto L_0x01f2
            L_0x01f0:
                r46 = r4
            L_0x01f2:
                if (r128 == 0) goto L_0x01fb
                boolean r0 = r128.isGermShieldOn()
                r47 = r0
                goto L_0x01fd
            L_0x01fb:
                r47 = r4
            L_0x01fd:
                if (r128 == 0) goto L_0x0206
                java.lang.Boolean r0 = r128.isGermShieldNightModeOn()
                r48 = r0
                goto L_0x0208
            L_0x0206:
                r48 = 0
            L_0x0208:
                r0 = 1
                if (r128 == 0) goto L_0x0210
                boolean r49 = r128.isSafetySwitchOn()
                goto L_0x0212
            L_0x0210:
                r49 = r0
            L_0x0212:
                if (r128 == 0) goto L_0x021a
                java.lang.String r50 = r128.getG4NightModefilterTrigger()
                if (r50 != 0) goto L_0x021c
            L_0x021a:
                r50 = r6
            L_0x021c:
                java.lang.String r6 = r127.getAimSerialNumber()
                if (r6 == 0) goto L_0x0236
                java.lang.Long r6 = r127.getAimUpdateDate()
                if (r6 == 0) goto L_0x022d
                long r51 = r6.longValue()
                goto L_0x022f
            L_0x022d:
                r51 = -1
            L_0x022f:
                int r6 = (r51 > r23 ? 1 : (r51 == r23 ? 0 : -1))
                if (r6 <= 0) goto L_0x0236
                r51 = r0
                goto L_0x0238
            L_0x0236:
                r51 = r4
            L_0x0238:
                java.lang.String r53 = r127.getCompatibility()
                if (r128 == 0) goto L_0x0245
                com.blueair.core.model.WelcomeHomeLocation r0 = r128.getWelcomeHome()
                r54 = r0
                goto L_0x0247
            L_0x0245:
                r54 = 0
            L_0x0247:
                if (r128 == 0) goto L_0x0250
                java.lang.String r0 = r128.getLocationId()
                r55 = r0
                goto L_0x0252
            L_0x0250:
                r55 = 0
            L_0x0252:
                r124 = 32767(0x7fff, float:4.5916E-41)
                r125 = 0
                r23 = r25
                r25 = r15
                r15 = 1
                r26 = r18
                r18 = 1
                r52 = 0
                r56 = 0
                r57 = 0
                r58 = 0
                r59 = 0
                r60 = 0
                r61 = 0
                r62 = 0
                r64 = 0
                r65 = 0
                r66 = 0
                r67 = 0
                r68 = 0
                r69 = 0
                r70 = 0
                r72 = 0
                r73 = 0
                r74 = 0
                r75 = 0
                r76 = 0
                r77 = 0
                r78 = 0
                r79 = 0
                r80 = 0
                r81 = 0
                r82 = 0
                r84 = 0
                r86 = 0
                r87 = 0
                r88 = 0
                r89 = 0
                r90 = 0
                r91 = 0
                r92 = 0
                r93 = 0
                r94 = 0
                r95 = 0
                r96 = 0
                r97 = 0
                r98 = 0
                r99 = 0
                r100 = 0
                r101 = 0
                r102 = 0
                r103 = 0
                r104 = 0
                r105 = 0
                r106 = 0
                r107 = 0
                r108 = 0
                r109 = 0
                r110 = 0
                r111 = 0
                r112 = 0
                r113 = 0
                r114 = 0
                r115 = 0
                r116 = 0
                r117 = 0
                r118 = 0
                r119 = 0
                r120 = 0
                r121 = 0
                r122 = -245760(0xfffffffffffc4000, float:NaN)
                r123 = -1
                r36 = r1
                r4 = r2
                r6 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.DeviceEntity.Companion.fromDeviceOnAblServer(com.blueair.core.model.DeviceDetailsOnAblServer, com.blueair.database.entity.DeviceEntity):com.blueair.database.entity.DeviceEntity");
        }

        public static /* synthetic */ DeviceEntity fromDeviceOnBlueServer$default(Companion companion, DeviceOnBlueServer deviceOnBlueServer, DeviceEntity deviceEntity, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                deviceEntity = null;
            }
            return companion.fromDeviceOnBlueServer(deviceOnBlueServer, deviceEntity, z);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v0, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r89v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r93v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r95v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r109v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r109v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r109v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r95v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r95v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r93v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r93v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r89v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r89v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v2, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v4, resolved type: int} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.database.entity.DeviceEntity fromDeviceOnBlueServer(com.blueair.core.model.DeviceOnBlueServer r124, com.blueair.database.entity.DeviceEntity r125, boolean r126) {
            /*
                r123 = this;
                java.lang.String r0 = "deviceOnBlueServer"
                r1 = r124
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                if (r125 == 0) goto L_0x000f
                java.lang.String r0 = r125.getSku()
                if (r0 != 0) goto L_0x0013
            L_0x000f:
                java.lang.String r0 = r1.getDeviceType()
            L_0x0013:
                com.blueair.core.model.DeviceType$Companion r2 = com.blueair.core.model.DeviceType.Companion
                java.lang.String r4 = r2.displayNameFromSkuCompat(r0)
                java.lang.String r2 = r1.getUuid()
                if (r125 == 0) goto L_0x0025
                java.lang.String r3 = r125.getName()
                if (r3 != 0) goto L_0x0026
            L_0x0025:
                r3 = r4
            L_0x0026:
                if (r125 == 0) goto L_0x002d
                int r5 = r125.getTypeIndex()
                goto L_0x003b
            L_0x002d:
                com.blueair.core.model.DeviceType$Companion r5 = com.blueair.core.model.DeviceType.Companion
                java.lang.String r6 = r1.getDeviceType()
                com.blueair.core.model.DeviceType r5 = r5.fromName(r6)
                int r5 = r5.getIndex()
            L_0x003b:
                if (r125 == 0) goto L_0x0042
                java.lang.Integer r7 = r125.getFanSpeed()
                goto L_0x0043
            L_0x0042:
                r7 = 0
            L_0x0043:
                if (r125 == 0) goto L_0x004a
                java.lang.Integer r8 = r125.getFilterLife()
                goto L_0x004b
            L_0x004a:
                r8 = 0
            L_0x004b:
                if (r125 == 0) goto L_0x0052
                java.lang.String r9 = r125.getAutoModeText()
                goto L_0x0053
            L_0x0052:
                r9 = 0
            L_0x0053:
                if (r125 == 0) goto L_0x005a
                java.lang.Integer r10 = r125.getBrightness()
                goto L_0x005b
            L_0x005a:
                r10 = 0
            L_0x005b:
                if (r125 == 0) goto L_0x0062
                java.lang.String r11 = r125.getInfo()
                goto L_0x0063
            L_0x0062:
                r11 = 0
            L_0x0063:
                if (r125 == 0) goto L_0x006a
                com.blueair.database.DeviceUuidEntity r12 = r125.getDeviceUuid()
                goto L_0x006b
            L_0x006a:
                r12 = 0
            L_0x006b:
                if (r125 == 0) goto L_0x0072
                com.blueair.core.model.IndoorDatapoint r13 = r125.getLatestSensorDatapoint()
                goto L_0x0073
            L_0x0072:
                r13 = 0
            L_0x0073:
                if (r125 == 0) goto L_0x007a
                java.lang.Integer r14 = r125.getLastSelectedSensorType()
                goto L_0x007b
            L_0x007a:
                r14 = 0
            L_0x007b:
                r15 = 0
                if (r125 == 0) goto L_0x0083
                boolean r16 = r125.isNightModeOn()
                goto L_0x0085
            L_0x0083:
                r16 = r15
            L_0x0085:
                if (r125 == 0) goto L_0x008c
                boolean r17 = r125.isChildLockOn()
                goto L_0x008e
            L_0x008c:
                r17 = r15
            L_0x008e:
                if (r125 == 0) goto L_0x0095
                java.lang.String r18 = r125.getLinkedDeviceUid()
                goto L_0x0097
            L_0x0095:
                r18 = 0
            L_0x0097:
                if (r125 == 0) goto L_0x009e
                int r19 = r125.getConnectivityStatusIndex()
                goto L_0x00a4
            L_0x009e:
                com.blueair.core.model.ConnectivityStatus r19 = com.blueair.core.model.ConnectivityStatus.ONLINE
                int r19 = r19.ordinal()
            L_0x00a4:
                r20 = 0
                if (r125 == 0) goto L_0x00ad
                long r22 = r125.getLastConnectivityMillis()
                goto L_0x00af
            L_0x00ad:
                r22 = r20
            L_0x00af:
                java.lang.String r24 = ""
                if (r125 == 0) goto L_0x00b9
                java.lang.String r25 = r125.getMac()
                if (r25 != 0) goto L_0x00bb
            L_0x00b9:
                r25 = r24
            L_0x00bb:
                r26 = r20
                r20 = r22
                java.lang.String r23 = r1.getMcuFirmware()
                java.lang.String r1 = r1.getWifiFirmware()
                if (r125 == 0) goto L_0x00cf
                java.lang.String r22 = r125.getHardware()
                if (r22 != 0) goto L_0x00d1
            L_0x00cf:
                r22 = r24
            L_0x00d1:
                if (r125 == 0) goto L_0x00d9
                java.lang.String r28 = r125.getTimeZone()
                if (r28 != 0) goto L_0x00db
            L_0x00d9:
                r28 = r24
            L_0x00db:
                if (r125 == 0) goto L_0x00e3
                java.lang.String r29 = r125.getSerial()
                if (r29 != 0) goto L_0x00e5
            L_0x00e3:
                r29 = r24
            L_0x00e5:
                if (r125 == 0) goto L_0x00ed
                java.lang.String r30 = r125.getPurchaseDate()
                if (r30 != 0) goto L_0x00ef
            L_0x00ed:
                r30 = r24
            L_0x00ef:
                if (r125 == 0) goto L_0x00f7
                java.lang.String r31 = r125.getDealerName()
                if (r31 != 0) goto L_0x00f9
            L_0x00f7:
                r31 = r24
            L_0x00f9:
                if (r125 == 0) goto L_0x0101
                java.lang.String r32 = r125.getDealerCountry()
                if (r32 != 0) goto L_0x0103
            L_0x0101:
                r32 = r24
            L_0x0103:
                if (r125 == 0) goto L_0x010b
                java.lang.String r33 = r125.getFilterType()
                if (r33 != 0) goto L_0x010d
            L_0x010b:
                r33 = r24
            L_0x010d:
                if (r125 == 0) goto L_0x0115
                java.lang.String r34 = r125.getFilterTrigger()
                if (r34 != 0) goto L_0x0117
            L_0x0115:
                r34 = r24
            L_0x0117:
                if (r125 == 0) goto L_0x011f
                double[] r35 = r125.getPm1Ranges()
                if (r35 != 0) goto L_0x0123
            L_0x011f:
                double[] r6 = new double[r15]
                r35 = r6
            L_0x0123:
                if (r125 == 0) goto L_0x012b
                double[] r6 = r125.getPm10Ranges()
                if (r6 != 0) goto L_0x012d
            L_0x012b:
                double[] r6 = new double[r15]
            L_0x012d:
                if (r125 == 0) goto L_0x0139
                double[] r36 = r125.getPm25Ranges()
                if (r36 != 0) goto L_0x0136
                goto L_0x0139
            L_0x0136:
                r49 = r0
                goto L_0x013f
            L_0x0139:
                r49 = r0
                double[] r0 = new double[r15]
                r36 = r0
            L_0x013f:
                if (r125 == 0) goto L_0x0147
                double[] r0 = r125.getVocRanges()
                if (r0 != 0) goto L_0x0149
            L_0x0147:
                double[] r0 = new double[r15]
            L_0x0149:
                if (r125 == 0) goto L_0x0155
                double[] r37 = r125.getHchoRanges()
                if (r37 != 0) goto L_0x0152
                goto L_0x0155
            L_0x0152:
                r124 = r0
                goto L_0x015b
            L_0x0155:
                r124 = r0
                double[] r0 = new double[r15]
                r37 = r0
            L_0x015b:
                if (r125 == 0) goto L_0x0164
                int r0 = r125.getUpdateProgress()
                r38 = r0
                goto L_0x0166
            L_0x0164:
                r38 = r15
            L_0x0166:
                if (r125 == 0) goto L_0x016f
                boolean r0 = r125.isStandByOn()
                r39 = r0
                goto L_0x0171
            L_0x016f:
                r39 = r15
            L_0x0171:
                if (r125 == 0) goto L_0x017a
                boolean r0 = r125.isEcoModeOn()
                r40 = r0
                goto L_0x017c
            L_0x017a:
                r40 = r15
            L_0x017c:
                if (r125 == 0) goto L_0x0185
                boolean r0 = r125.isG4NightModeOn()
                r43 = r0
                goto L_0x0187
            L_0x0185:
                r43 = r15
            L_0x0187:
                if (r125 == 0) goto L_0x0190
                boolean r0 = r125.isGermShieldOn()
                r44 = r0
                goto L_0x0192
            L_0x0190:
                r44 = r15
            L_0x0192:
                if (r125 == 0) goto L_0x019b
                java.lang.Boolean r0 = r125.isGermShieldNightModeOn()
                r45 = r0
                goto L_0x019d
            L_0x019b:
                r45 = 0
            L_0x019d:
                if (r125 == 0) goto L_0x01a6
                boolean r41 = r125.isSafetySwitchOn()
                r46 = r41
                goto L_0x01a8
            L_0x01a6:
                r46 = 1
            L_0x01a8:
                if (r125 == 0) goto L_0x01b4
                java.lang.String r41 = r125.getG4NightModefilterTrigger()
                if (r41 != 0) goto L_0x01b1
                goto L_0x01b4
            L_0x01b1:
                r47 = r41
                goto L_0x01b6
            L_0x01b4:
                r47 = r24
            L_0x01b6:
                if (r125 == 0) goto L_0x01bf
                com.blueair.core.model.WelcomeHomeLocation r24 = r125.getWelcomeHome()
                r51 = r24
                goto L_0x01c1
            L_0x01bf:
                r51 = 0
            L_0x01c1:
                if (r125 == 0) goto L_0x01ca
                java.lang.String r24 = r125.getLocationId()
                r52 = r24
                goto L_0x01cc
            L_0x01ca:
                r52 = 0
            L_0x01cc:
                if (r125 == 0) goto L_0x01d5
                java.lang.Boolean r24 = r125.getDisinfection()
                r53 = r24
                goto L_0x01d7
            L_0x01d5:
                r53 = 0
            L_0x01d7:
                if (r125 == 0) goto L_0x01e0
                java.lang.Integer r24 = r125.getDisinfectLeftTime()
                r54 = r24
                goto L_0x01e2
            L_0x01e0:
                r54 = 0
            L_0x01e2:
                if (r125 == 0) goto L_0x01eb
                java.lang.Long r24 = r125.getDisinfectLeftTimeUpdateTime()
                r55 = r24
                goto L_0x01ed
            L_0x01eb:
                r55 = 0
            L_0x01ed:
                if (r125 == 0) goto L_0x01f6
                boolean r24 = r125.getWickdryEnabled()
                r56 = r24
                goto L_0x01f8
            L_0x01f6:
                r56 = r15
            L_0x01f8:
                if (r125 == 0) goto L_0x0201
                boolean r24 = r125.getWickdryOn()
                r57 = r24
                goto L_0x0203
            L_0x0201:
                r57 = r15
            L_0x0203:
                if (r125 == 0) goto L_0x020c
                int r24 = r125.getWickdryLeftTime()
                r58 = r24
                goto L_0x020e
            L_0x020c:
                r58 = r15
            L_0x020e:
                if (r125 == 0) goto L_0x0217
                long r41 = r125.getWickdryLeftTimeUpdateTime()
                r59 = r41
                goto L_0x0219
            L_0x0217:
                r59 = r26
            L_0x0219:
                if (r125 == 0) goto L_0x0222
                int r24 = r125.getWickUsage()
                r61 = r24
                goto L_0x0224
            L_0x0222:
                r61 = r15
            L_0x0224:
                if (r125 == 0) goto L_0x022d
                boolean r24 = r125.getWaterShortage()
                r62 = r24
                goto L_0x022f
            L_0x022d:
                r62 = r15
            L_0x022f:
                if (r125 == 0) goto L_0x0236
                int r24 = r125.getAutoRh()
                goto L_0x0238
            L_0x0236:
                r24 = 50
            L_0x0238:
                r63 = r24
                if (r125 == 0) goto L_0x0243
                int r24 = r125.getTimerStatus()
                r64 = r24
                goto L_0x0245
            L_0x0243:
                r64 = r15
            L_0x0245:
                if (r125 == 0) goto L_0x024e
                int r24 = r125.getTimerDuration()
                r65 = r24
                goto L_0x0250
            L_0x024e:
                r65 = r15
            L_0x0250:
                if (r125 == 0) goto L_0x0259
                int r24 = r125.getTimerLeftTime()
                r66 = r24
                goto L_0x025b
            L_0x0259:
                r66 = r15
            L_0x025b:
                if (r125 == 0) goto L_0x0261
                long r26 = r125.getTimerLeftTimeUpdateTime()
            L_0x0261:
                r67 = r26
                if (r125 == 0) goto L_0x026c
                int r24 = r125.getTemperatureUnit()
                r69 = r24
                goto L_0x026e
            L_0x026c:
                r69 = r15
            L_0x026e:
                if (r125 == 0) goto L_0x0277
                int r24 = r125.getOscillationState()
                r70 = r24
                goto L_0x0279
            L_0x0277:
                r70 = r15
            L_0x0279:
                if (r125 == 0) goto L_0x0280
                int r24 = r125.getOscillationAngle()
                goto L_0x0282
            L_0x0280:
                r24 = 90
            L_0x0282:
                r71 = r24
                if (r125 == 0) goto L_0x028d
                int r24 = r125.getOscillationDirection()
                r72 = r24
                goto L_0x028f
            L_0x028d:
                r72 = r15
            L_0x028f:
                if (r125 == 0) goto L_0x0298
                int r24 = r125.getOscillationFanSpeed()
                r73 = r24
                goto L_0x029a
            L_0x0298:
                r73 = r15
            L_0x029a:
                if (r125 == 0) goto L_0x02a3
                int r24 = r125.getMainMode()
                r74 = r24
                goto L_0x02a5
            L_0x02a3:
                r74 = r15
            L_0x02a5:
                r24 = 1
                r0 = 2
                if (r125 == 0) goto L_0x02b1
                int r26 = r125.getApSubMode()
                r75 = r26
                goto L_0x02b3
            L_0x02b1:
                r75 = r0
            L_0x02b3:
                if (r125 == 0) goto L_0x02bc
                int r26 = r125.getApFanSpeed()
                r76 = r26
                goto L_0x02be
            L_0x02bc:
                r76 = r15
            L_0x02be:
                if (r125 == 0) goto L_0x02c7
                int r26 = r125.getHeatSubMode()
                r77 = r26
                goto L_0x02c9
            L_0x02c7:
                r77 = r0
            L_0x02c9:
                if (r125 == 0) goto L_0x02d2
                int r26 = r125.getHeatFanSpeed()
                r78 = r26
                goto L_0x02d4
            L_0x02d2:
                r78 = r15
            L_0x02d4:
                r26 = 4626885667169763328(0x4036000000000000, double:22.0)
                if (r125 == 0) goto L_0x02df
                double r41 = r125.getHeatAutoTmp()
                r79 = r41
                goto L_0x02e1
            L_0x02df:
                r79 = r26
            L_0x02e1:
                if (r125 == 0) goto L_0x02e7
                double r26 = r125.getHeatEcoTmp()
            L_0x02e7:
                r81 = r26
                if (r125 == 0) goto L_0x02f2
                int r26 = r125.getCoolSubMode()
                r83 = r26
                goto L_0x02f4
            L_0x02f2:
                r83 = r0
            L_0x02f4:
                if (r125 == 0) goto L_0x02fd
                int r26 = r125.getCoolFanSpeed()
                r84 = r26
                goto L_0x02ff
            L_0x02fd:
                r84 = r15
            L_0x02ff:
                if (r125 == 0) goto L_0x0308
                int r26 = r125.getCoolAutoTag()
                r85 = r26
                goto L_0x030a
            L_0x0308:
                r85 = r15
            L_0x030a:
                r26 = 4627730092099895296(0x4039000000000000, double:25.0)
                r41 = 4626322717216342016(0x4034000000000000, double:20.0)
                if (r125 == 0) goto L_0x031c
                double[] r48 = r125.getCoolAutoPresets()
                if (r48 != 0) goto L_0x0317
                goto L_0x031c
            L_0x0317:
                r86 = r48
                r48 = r15
                goto L_0x032b
            L_0x031c:
                r48 = r15
                r15 = 3
                double[] r15 = new double[r15]
                r15[r48] = r41
                r86 = 4627167142146473984(0x4037000000000000, double:23.0)
                r15[r24] = r86
                r15[r0] = r26
                r86 = r15
            L_0x032b:
                if (r125 == 0) goto L_0x0334
                int r15 = r125.getCoolEcoTag()
                r87 = r15
                goto L_0x0336
            L_0x0334:
                r87 = r48
            L_0x0336:
                if (r125 == 0) goto L_0x033e
                double[] r15 = r125.getCoolEcoPresets()
                if (r15 != 0) goto L_0x0344
            L_0x033e:
                double[] r15 = new double[r0]
                r15[r48] = r41
                r15[r24] = r26
            L_0x0344:
                r88 = r15
                if (r125 == 0) goto L_0x034f
                int r15 = r125.getMode()
                r90 = r15
                goto L_0x0351
            L_0x034f:
                r90 = r24
            L_0x0351:
                if (r125 == 0) goto L_0x035a
                boolean r15 = r125.getHumMode()
                r89 = r15
                goto L_0x035c
            L_0x035a:
                r89 = r48
            L_0x035c:
                if (r125 == 0) goto L_0x0365
                int r15 = r125.getWaterLevel()
                r91 = r15
                goto L_0x0367
            L_0x0365:
                r91 = r48
            L_0x0367:
                if (r125 == 0) goto L_0x0370
                int r15 = r125.getDehSubMode()
                r92 = r15
                goto L_0x0372
            L_0x0370:
                r92 = r24
            L_0x0372:
                if (r125 == 0) goto L_0x037b
                boolean r15 = r125.getWaterTankFailure()
                r93 = r15
                goto L_0x037d
            L_0x037b:
                r93 = r48
            L_0x037d:
                if (r125 == 0) goto L_0x0386
                int r15 = r125.getSmartSubMode()
                r94 = r15
                goto L_0x0388
            L_0x0386:
                r94 = r48
            L_0x0388:
                if (r125 == 0) goto L_0x0391
                boolean r15 = r125.getDetectCat()
                r95 = r15
                goto L_0x0393
            L_0x0391:
                r95 = r48
            L_0x0393:
                if (r125 == 0) goto L_0x039c
                boolean r15 = r125.getBodyMounted()
                r96 = r15
                goto L_0x039e
            L_0x039c:
                r96 = r24
            L_0x039e:
                if (r125 == 0) goto L_0x03a7
                int r15 = r125.getCleanAirEta()
                r97 = r15
                goto L_0x03a9
            L_0x03a7:
                r97 = r48
            L_0x03a9:
                if (r125 == 0) goto L_0x03b2
                int r15 = r125.getPanelDisplayMode()
                r98 = r15
                goto L_0x03b4
            L_0x03b2:
                r98 = r48
            L_0x03b4:
                if (r125 == 0) goto L_0x03bd
                boolean r15 = r125.getHoverEnabled()
                r99 = r15
                goto L_0x03bf
            L_0x03bd:
                r99 = r24
            L_0x03bf:
                if (r125 == 0) goto L_0x03c8
                boolean r15 = r125.getAirRefreshEnabled()
                r100 = r15
                goto L_0x03ca
            L_0x03c8:
                r100 = r24
            L_0x03ca:
                if (r125 == 0) goto L_0x03d3
                int r15 = r125.getAirRefreshStatus()
                r101 = r15
                goto L_0x03d5
            L_0x03d3:
                r101 = r48
            L_0x03d5:
                if (r125 == 0) goto L_0x03de
                int r15 = r125.getAirRefreshDuration()
                r102 = r15
                goto L_0x03e0
            L_0x03de:
                r102 = r48
            L_0x03e0:
                if (r125 == 0) goto L_0x03e9
                int r15 = r125.getAirRefreshTimeStamp()
                r103 = r15
                goto L_0x03eb
            L_0x03e9:
                r103 = r48
            L_0x03eb:
                if (r125 == 0) goto L_0x03f4
                int r15 = r125.getAirRefreshStartTimeStamp()
                r104 = r15
                goto L_0x03f6
            L_0x03f4:
                r104 = r48
            L_0x03f6:
                if (r125 == 0) goto L_0x03ff
                int r15 = r125.getAirRefreshEndTimeStamp()
                r105 = r15
                goto L_0x0401
            L_0x03ff:
                r105 = r48
            L_0x0401:
                if (r125 == 0) goto L_0x040a
                int r15 = r125.getRoomType()
                r106 = r15
                goto L_0x040c
            L_0x040a:
                r106 = r48
            L_0x040c:
                if (r125 == 0) goto L_0x0415
                int r15 = r125.getNightLampBrightness()
                r107 = r15
                goto L_0x0417
            L_0x0415:
                r107 = r48
            L_0x0417:
                if (r125 == 0) goto L_0x0420
                int r15 = r125.getWickdryDuration()
                r108 = r15
                goto L_0x0422
            L_0x0420:
                r108 = r48
            L_0x0422:
                if (r125 == 0) goto L_0x042b
                boolean r15 = r125.getWickdryDone()
                r109 = r15
                goto L_0x042d
            L_0x042b:
                r109 = r48
            L_0x042d:
                if (r125 == 0) goto L_0x0436
                java.lang.Boolean r15 = r125.getYwrmEnabled()
                r110 = r15
                goto L_0x0438
            L_0x0436:
                r110 = 0
            L_0x0438:
                if (r125 == 0) goto L_0x0441
                int r15 = r125.getYwrmUsage()
                r111 = r15
                goto L_0x0443
            L_0x0441:
                r111 = r48
            L_0x0443:
                if (r125 == 0) goto L_0x044c
                int r15 = r125.getNightLampSteplessBrightness()
                r112 = r15
                goto L_0x044e
            L_0x044c:
                r112 = r48
            L_0x044e:
                if (r125 == 0) goto L_0x0456
                java.util.List r15 = r125.getAlarms()
                if (r15 != 0) goto L_0x045a
            L_0x0456:
                java.util.List r15 = r123.getNULL_ALARM_LIST()
            L_0x045a:
                r113 = r15
                if (r125 == 0) goto L_0x0462
                int r0 = r125.getHumSubMode()
            L_0x0462:
                r114 = r0
                if (r125 == 0) goto L_0x046d
                boolean r0 = r125.getUse24Hour()
                r115 = r0
                goto L_0x046f
            L_0x046d:
                r115 = r24
            L_0x046f:
                r24 = r1
                com.blueair.database.entity.DeviceEntity r1 = new com.blueair.database.entity.DeviceEntity
                r121 = 24576(0x6000, float:3.4438E-41)
                r122 = 0
                r26 = r28
                r28 = r30
                r30 = r32
                r32 = r34
                r34 = r6
                r6 = r7
                r7 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = 1
                r15 = 0
                r41 = 0
                r42 = 0
                r48 = 0
                r50 = 0
                r116 = 0
                r117 = 0
                r118 = 0
                r119 = 41152(0xa0c0, float:5.7666E-41)
                r120 = 0
                r27 = r25
                r25 = r22
                r22 = r27
                r27 = r29
                r29 = r31
                r31 = r33
                r33 = r35
                r35 = r36
                r36 = r124
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r61, r62, r63, r64, r65, r66, r67, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r81, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.DeviceEntity.Companion.fromDeviceOnBlueServer(com.blueair.core.model.DeviceOnBlueServer, com.blueair.database.entity.DeviceEntity, boolean):com.blueair.database.entity.DeviceEntity");
        }

        private final boolean isLatestConnectivityState(long j, Long l) {
            return l == null || j >= l.longValue();
        }
    }

    static {
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add((Object) null);
        }
        NULL_ALARM_LIST = arrayList;
    }

    public final Device toDevice() {
        Integer num = this.brightness;
        int intValue = num != null ? num.intValue() : 0;
        Integer num2 = this.fanSpeed;
        int intValue2 = num2 != null ? num2.intValue() : 0;
        Integer num3 = this.filterLife;
        Integer num4 = this.lastSelectedSensorType;
        int intValue3 = num4 != null ? num4.intValue() : 0;
        String str = this.autoModeText;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Timber.Forest forest = Timber.Forest;
        forest.v("ToDevice: DeviceType == " + this.typeIndex + " for " + this + '.', new Object[0]);
        DeviceType fromIndex = DeviceType.Companion.fromIndex(this.typeIndex);
        if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Unknown.INSTANCE)) {
            return new DeviceUnknown(this.sku, this.uid, this.name, this.modelName, this.typeIndex, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.updateProgress);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Classic.INSTANCE)) {
            return new DeviceClassic(this.uid, this.name, intValue2, num3, intValue, str2, this.info, this.latestSensorDatapoint, intValue3, this.isNightModeOn, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.modelName, this.aimInstalled, this.compatibility);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.ClassicWithoutSensor.INSTANCE)) {
            return new DeviceClassicWithoutSensors(this.uid, this.name, intValue2, num3, intValue, str2, this.info, this.isNightModeOn, this.isChildLockOn, this.linkedDeviceUid, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.updateProgress, this.modelName, this.compatibility);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.NewClassic.INSTANCE)) {
            return new DeviceNewClassic(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isEcoModeOn, this.isHinsModeOn, this.isHinsNightModeOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 64, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.G4.INSTANCE)) {
            return new DeviceG4(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.isGermShieldOn, this.isGermShieldNightModeOn, this.g4NightModefilterTrigger, this.isSafetySwitchOn, this.modelName, 0, this.sku, this.welcomeHome, this.disinfection, this.disinfectLeftTime, this.disinfectLeftTimeUpdateTime, 128, 64, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.B4.INSTANCE)) {
            return new DeviceB4(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.B4sp.INSTANCE)) {
            return new DeviceB4sp(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Blue.INSTANCE)) {
            return new DeviceBlue(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.BluePremium.INSTANCE)) {
            return new DeviceBluePremium(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Aware.INSTANCE)) {
            return new DeviceAware(this.uid, this.name, intValue, this.info, this.latestSensorDatapoint, intValue3, this.isNightModeOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.compatibility);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Sense.INSTANCE)) {
            return new DeviceSense(this.uid, this.name, intValue2, num3, intValue, str2, this.info, this.isChildLockOn, this.linkedDeviceUid, this.isNightModeOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.updateProgress, this.compatibility);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Icp.INSTANCE)) {
            return new DeviceIcp(this.uid, this.name, intValue2, num3, str2, this.info, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterTrigger, (String) null, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.compatibility, 2097152, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Humidifier.INSTANCE)) {
            return new DeviceHumidifier(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.autoRh, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Combo2in1.INSTANCE)) {
            String str3 = this.uid;
            String str4 = this.name;
            String str5 = this.info;
            boolean z = this.isChildLockOn;
            int i = this.connectivityStatusIndex;
            long j = this.lastConnectivityMillis;
            String str6 = this.mac;
            String str7 = this.mcuFirmware;
            String str8 = this.wifiFirmware;
            return new DeviceCombo2in1(str3, str4, intValue2, num3, intValue, str2, str5, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, z, i, j, str6, str7, str8, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.welcomeHome, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.autoRh, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.locationId, this.mode, this.humMode, this.waterLevel, 128, 2, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Combo2in120.INSTANCE)) {
            String str9 = this.uid;
            String str10 = this.name;
            String str11 = this.info;
            boolean z2 = this.isChildLockOn;
            int i2 = this.connectivityStatusIndex;
            long j2 = this.lastConnectivityMillis;
            String str12 = this.mac;
            String str13 = this.mcuFirmware;
            String str14 = this.wifiFirmware;
            int i3 = i2;
            String str15 = this.hardware;
            String str16 = this.timeZone;
            String str17 = this.serial;
            String str18 = this.purchaseDate;
            String str19 = this.dealerName;
            String str20 = this.dealerCountry;
            String str21 = this.filterType;
            String str22 = this.filterTrigger;
            String str23 = str13;
            String str24 = str14;
            return new DeviceCombo2in120(str9, str10, intValue2, num3, intValue, str2, str11, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, z2, i3, j2, str12, str23, str24, str15, str16, str17, str18, str19, str20, str21, str22, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.welcomeHome, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.autoRh, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.waterLevel, this.nightLampBrightness, this.wickdryDuration, this.wickdryDone, this.ywrmEnabled, this.ywrmUsage, this.mainMode, this.apSubMode, this.humSubMode, this.waterTankFailure, this.isSafetySwitchOn, this.waterInfill, 128, 2, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Combo3in1.INSTANCE)) {
            String str25 = this.uid;
            String str26 = this.name;
            String str27 = this.info;
            boolean z3 = this.isChildLockOn;
            int i4 = this.connectivityStatusIndex;
            long j3 = this.lastConnectivityMillis;
            String str28 = this.mac;
            String str29 = this.mcuFirmware;
            String str30 = this.wifiFirmware;
            return new DeviceCombo3in1(str25, str26, intValue2, num3, intValue, str2, str27, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, z3, i4, j3, str28, str29, str30, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.temperatureUnit, this.oscillationState, this.oscillationAngle, this.oscillationDirection, this.oscillationFanSpeed, this.mainMode, this.apSubMode, this.apFanSpeed, this.heatSubMode, this.heatFanSpeed, this.heatAutoTmp, this.heatEcoTmp, this.coolSubMode, this.coolFanSpeed, this.coolAutoTag, this.coolAutoPresets, this.coolEcoTag, this.coolEcoPresets, this.locationId, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Dehumidifier.INSTANCE)) {
            return new DeviceDehumidifier(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.autoRh, this.mainMode, this.apSubMode, this.dehSubMode, this.waterLevel, this.waterTankFailure, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Pet20.INSTANCE)) {
            return new DevicePet20(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.mainMode, this.apSubMode, this.smartSubMode, this.detectCat, this.bodyMounted, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Blue40.INSTANCE)) {
            String str31 = this.uid;
            String str32 = this.name;
            String str33 = this.info;
            boolean z4 = this.isChildLockOn;
            int i5 = this.connectivityStatusIndex;
            long j4 = this.lastConnectivityMillis;
            String str34 = this.mac;
            String str35 = this.mcuFirmware;
            String str36 = this.wifiFirmware;
            return new DeviceBlue40(str31, str32, intValue2, num3, intValue, str2, str33, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, z4, i5, j4, str34, str35, str36, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.mainMode, this.apSubMode, this.cleanAirEta, this.hoverEnabled, this.panelDisplayMode, this.airRefreshEnabled, this.airRefreshStatus, this.airRefreshDuration, this.airRefreshTimeStamp, this.airRefreshStartTimeStamp, this.airRefreshEndTimeStamp, this.roomType, this.sensorMode, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.Humidifier20.INSTANCE)) {
            return new DeviceHumidifier20(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.latestSensorDatapoint, intValue3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.waterLevel, this.nightLampBrightness, this.wickdryDuration, this.wickdryDone, this.autoRh, this.ywrmEnabled, this.ywrmUsage, 128, 8, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) fromIndex, (Object) DeviceType.MiniRestful.INSTANCE)) {
            return new DeviceMiniRestful(this.uid, this.name, intValue2, num3, intValue, str2, this.info, (DeviceUuid) null, this.hasFinishedOnboarding, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.mainMode, this.apSubMode, this.nightLampSteplessBrightness, this.alarms, this.use24Hour, 67108992, 0, (DefaultConstructorMarker) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
