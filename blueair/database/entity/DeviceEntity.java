package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceClassicWithoutSensors;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceFanPremium;
import com.blueair.core.model.DeviceFanTable;
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
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCleanAirEta;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCompatibility;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasDetectCat;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasDisplayMode;
import com.blueair.core.model.HasDualOscillation;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasGestureRecognition;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasHourFormat;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasInfo;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasMoodLamp;
import com.blueair.core.model.HasNightLamp;
import com.blueair.core.model.HasNightMode;
import com.blueair.core.model.HasNightModeTiming;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasRoom;
import com.blueair.core.model.HasRpm;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasSensorMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterInfill;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.database.DeviceUuidEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\b\u0080\u0001\n\u0002\u0018\u0002\n\u0002\b}\b\u0087\b\u0018\u0000 ý\u00022\u00020\u0001:\u0002ý\u0002B¸\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020'\u0012\b\b\u0002\u0010*\u001a\u00020'\u0012\b\b\u0002\u0010+\u001a\u00020'\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u0012\b\b\u0002\u0010.\u001a\u00020\u0010\u0012\b\b\u0002\u0010/\u001a\u00020\u0010\u0012\b\b\u0002\u00100\u001a\u00020\u0010\u0012\b\b\u0002\u00101\u001a\u00020\u0010\u0012\b\b\u0002\u00102\u001a\u00020\u0010\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u00104\u001a\u00020\u0010\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0010\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010?\u001a\u00020\u0010\u0012\b\b\u0002\u0010@\u001a\u00020\u0010\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\b\b\u0002\u0010B\u001a\u00020\u001a\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\b\u0002\u0010D\u001a\u00020\u0010\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u0012\b\b\u0002\u0010F\u001a\u00020\u0007\u0012\b\b\u0002\u0010G\u001a\u00020\u0007\u0012\b\b\u0002\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010I\u001a\u00020\u001a\u0012\b\b\u0002\u0010J\u001a\u00020\u0007\u0012\b\b\u0002\u0010K\u001a\u00020\u0007\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u0012\b\b\u0002\u0010M\u001a\u00020\u0007\u0012\b\b\u0002\u0010N\u001a\u00020\u0007\u0012\b\b\u0002\u0010O\u001a\u00020\u0007\u0012\b\b\u0002\u0010P\u001a\u00020\u0007\u0012\b\b\u0002\u0010Q\u001a\u00020\u0007\u0012\b\b\u0002\u0010R\u001a\u00020\u0007\u0012\b\b\u0002\u0010S\u001a\u00020\u0007\u0012\b\b\u0002\u0010T\u001a\u00020U\u0012\b\b\u0002\u0010V\u001a\u00020U\u0012\b\b\u0002\u0010W\u001a\u00020\u0007\u0012\b\b\u0002\u0010X\u001a\u00020\u0007\u0012\b\b\u0002\u0010Y\u001a\u00020\u0007\u0012\b\b\u0002\u0010Z\u001a\u00020'\u0012\b\b\u0002\u0010[\u001a\u00020\u0007\u0012\b\b\u0002\u0010\\\u001a\u00020'\u0012\b\b\u0002\u0010]\u001a\u00020\u0010\u0012\b\b\u0002\u0010^\u001a\u00020\u0007\u0012\b\b\u0002\u0010_\u001a\u00020\u0007\u0012\b\b\u0002\u0010`\u001a\u00020\u0007\u0012\b\b\u0002\u0010a\u001a\u00020\u0010\u0012\b\b\u0002\u0010b\u001a\u00020\u0007\u0012\b\b\u0002\u0010c\u001a\u00020\u0010\u0012\b\b\u0002\u0010d\u001a\u00020\u0010\u0012\b\b\u0002\u0010e\u001a\u00020\u0007\u0012\b\b\u0002\u0010f\u001a\u00020\u0007\u0012\b\b\u0002\u0010g\u001a\u00020\u0010\u0012\b\b\u0002\u0010h\u001a\u00020\u0010\u0012\b\b\u0002\u0010i\u001a\u00020\u0007\u0012\b\b\u0002\u0010j\u001a\u00020\u0007\u0012\b\b\u0002\u0010k\u001a\u00020\u0007\u0012\b\b\u0002\u0010l\u001a\u00020\u0007\u0012\b\b\u0002\u0010m\u001a\u00020\u0007\u0012\b\b\u0002\u0010n\u001a\u00020\u0007\u0012\b\b\u0002\u0010o\u001a\u00020\u0007\u0012\b\b\u0002\u0010p\u001a\u00020\u0007\u0012\b\b\u0002\u0010q\u001a\u00020\u0010\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010s\u001a\u00020\u0007\u0012\b\b\u0002\u0010t\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v\u0012\b\b\u0002\u0010x\u001a\u00020\u0007\u0012\b\b\u0002\u0010y\u001a\u00020\u0010\u0012\b\b\u0002\u0010z\u001a\u00020\u0010\u0012\b\b\u0002\u0010{\u001a\u00020\u0007\u0012\b\b\u0002\u0010|\u001a\u00020\u0007\u0012\b\b\u0002\u0010}\u001a\u00020\u0007\u0012\b\b\u0002\u0010~\u001a\u00020\u001a\u0012\t\b\u0002\u0010\u007f\u001a\u00030\u0080\u0001\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0007\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020'¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0080\u0002\u001a\u00030\u0081\u0002J\n\u0010\u0082\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0002\u001a\u00020\u0007HÆ\u0003J\u0012\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\n\u0010\u008c\u0002\u001a\u00020\u0010HÆ\u0003J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\n\u0010\u008f\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0090\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0010HÆ\u0003J\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0093\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0094\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0095\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009e\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009f\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0002\u001a\u00020'HÆ\u0003J\n\u0010¡\u0002\u001a\u00020'HÆ\u0003J\n\u0010¢\u0002\u001a\u00020'HÆ\u0003J\n\u0010£\u0002\u001a\u00020'HÆ\u0003J\n\u0010¤\u0002\u001a\u00020'HÆ\u0003J\n\u0010¥\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¦\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010§\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010¨\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010©\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010ª\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010«\u0002\u001a\u00020\u0010HÆ\u0003J\u0012\u0010¬\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¯\u0001J\n\u0010\u00ad\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010®\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010¯\u0002\u001a\u00020\u0010HÆ\u0003J\f\u0010°\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0002\u001a\u0004\u0018\u00010:HÆ\u0003J\f\u0010³\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010´\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¯\u0001J\u0012\u0010µ\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0003\u0010\u008c\u0001J\u0012\u0010¶\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0003\u0010»\u0001J\n\u0010·\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010¸\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010¹\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010º\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010»\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¼\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010½\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¾\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010¿\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010À\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Á\u0002\u001a\u00020\u001aHÆ\u0003J\n\u0010Â\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ã\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ä\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Å\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Æ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ç\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010È\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010É\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ê\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ë\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ì\u0002\u001a\u00020UHÆ\u0003J\n\u0010Í\u0002\u001a\u00020UHÆ\u0003J\n\u0010Î\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ï\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ð\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ñ\u0002\u001a\u00020'HÆ\u0003J\n\u0010Ò\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ó\u0002\u001a\u00020'HÆ\u0003J\n\u0010Ô\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Õ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ö\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010×\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ø\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ù\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ú\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Û\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010Ü\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Ý\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010Þ\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010ß\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010à\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010á\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010â\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ã\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ä\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010å\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010æ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ç\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010è\u0002\u001a\u00020\u0010HÆ\u0003J\u0012\u0010é\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010¯\u0001J\n\u0010ê\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ë\u0002\u001a\u00020\u0007HÆ\u0003J\u0012\u0010ì\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0vHÆ\u0003J\n\u0010í\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010î\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010ï\u0002\u001a\u00020\u0010HÆ\u0003J\n\u0010ð\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ñ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ò\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ó\u0002\u001a\u00020\u001aHÆ\u0003J\u000b\u0010ô\u0002\u001a\u00030\u0080\u0001HÆ\u0003J\n\u0010õ\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ö\u0002\u001a\u00020'HÆ\u0003JÑ\t\u0010÷\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'2\b\b\u0002\u0010*\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00102\b\b\u0002\u0010/\u001a\u00020\u00102\b\b\u0002\u00100\u001a\u00020\u00102\b\b\u0002\u00101\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u00102\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00104\u001a\u00020\u00102\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00102\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010?\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020\u001a2\b\b\u0002\u0010C\u001a\u00020\u00072\b\b\u0002\u0010D\u001a\u00020\u00102\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u00072\b\b\u0002\u0010P\u001a\u00020\u00072\b\b\u0002\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010R\u001a\u00020\u00072\b\b\u0002\u0010S\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020U2\b\b\u0002\u0010W\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010Z\u001a\u00020'2\b\b\u0002\u0010[\u001a\u00020\u00072\b\b\u0002\u0010\\\u001a\u00020'2\b\b\u0002\u0010]\u001a\u00020\u00102\b\b\u0002\u0010^\u001a\u00020\u00072\b\b\u0002\u0010_\u001a\u00020\u00072\b\b\u0002\u0010`\u001a\u00020\u00072\b\b\u0002\u0010a\u001a\u00020\u00102\b\b\u0002\u0010b\u001a\u00020\u00072\b\b\u0002\u0010c\u001a\u00020\u00102\b\b\u0002\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\u00072\b\b\u0002\u0010g\u001a\u00020\u00102\b\b\u0002\u0010h\u001a\u00020\u00102\b\b\u0002\u0010i\u001a\u00020\u00072\b\b\u0002\u0010j\u001a\u00020\u00072\b\b\u0002\u0010k\u001a\u00020\u00072\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010p\u001a\u00020\u00072\b\b\u0002\u0010q\u001a\u00020\u00102\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010s\u001a\u00020\u00072\b\b\u0002\u0010t\u001a\u00020\u00072\u0010\b\u0002\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v2\b\b\u0002\u0010x\u001a\u00020\u00072\b\b\u0002\u0010y\u001a\u00020\u00102\b\b\u0002\u0010z\u001a\u00020\u00102\b\b\u0002\u0010{\u001a\u00020\u00072\b\b\u0002\u0010|\u001a\u00020\u00072\b\b\u0002\u0010}\u001a\u00020\u00072\b\b\u0002\u0010~\u001a\u00020\u001a2\t\b\u0002\u0010\u007f\u001a\u00030\u0080\u00012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0082\u0001\u001a\u00020'HÆ\u0001¢\u0006\u0003\u0010ø\u0002J\u0015\u0010ù\u0002\u001a\u00020\u00102\t\u0010ú\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010û\u0002\u001a\u00020\u0007HÖ\u0001J\n\u0010ü\u0002\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0086\u0001R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0086\u0001R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u008d\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0086\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u008d\u0001\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0086\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0013\u0010\u000f\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u008d\u0001\u001a\u0006\b\u0098\u0001\u0010\u008c\u0001R\u0012\u0010\u0014\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0014\u0010\u0095\u0001R\u0012\u0010\u0015\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0015\u0010\u0095\u0001R\u0012\u0010\u0016\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0016\u0010\u0095\u0001R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u0086\u0001R\u0013\u0010\u0018\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u008a\u0001R\u0013\u0010\u0019\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0086\u0001R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u0086\u0001R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0086\u0001R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010\u0086\u0001R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u0086\u0001R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010\u0086\u0001R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010\u0086\u0001R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b¤\u0001\u0010\u0086\u0001R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010\u0086\u0001R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010\u0086\u0001R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010\u0086\u0001R\u0013\u0010&\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001R\u0013\u0010(\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010©\u0001R\u0013\u0010)\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010©\u0001R\u0013\u0010*\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010©\u0001R\u0013\u0010+\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010©\u0001R\u0013\u0010,\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010\u008a\u0001R\u0012\u0010-\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b-\u0010\u0095\u0001R\u0012\u0010.\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b.\u0010\u0095\u0001R\u0012\u0010/\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b/\u0010\u0095\u0001R\u0012\u00100\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b0\u0010\u0095\u0001R\u0012\u00101\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b1\u0010\u0095\u0001R\u0012\u00102\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b2\u0010\u0095\u0001R\u0017\u00103\u001a\u0004\u0018\u00010\u0010¢\u0006\f\n\u0003\u0010°\u0001\u001a\u0005\b3\u0010¯\u0001R\u0012\u00104\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b4\u0010\u0095\u0001R\u0013\u00105\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010\u0086\u0001R\u0013\u00106\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010\u0095\u0001R\u0015\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010\u0086\u0001R\u0015\u00108\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010\u0086\u0001R\u001a\u00109\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0015\u0010;\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0000\u001a\u0006\b·\u0001\u0010\u0086\u0001R\u0018\u0010<\u001a\u0004\u0018\u00010\u0010¢\u0006\r\n\u0003\u0010°\u0001\u001a\u0006\b¸\u0001\u0010¯\u0001R\u0018\u0010=\u001a\u0004\u0018\u00010\u0007¢\u0006\r\n\u0003\u0010\u008d\u0001\u001a\u0006\b¹\u0001\u0010\u008c\u0001R\u0018\u0010>\u001a\u0004\u0018\u00010\u001a¢\u0006\r\n\u0003\u0010¼\u0001\u001a\u0006\bº\u0001\u0010»\u0001R\u0013\u0010?\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010\u0095\u0001R\u0013\u0010@\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010\u0095\u0001R\u0013\u0010A\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010\u008a\u0001R\u0013\u0010B\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010\u009c\u0001R\u0013\u0010C\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010\u008a\u0001R\u0013\u0010D\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010\u0095\u0001R\u0013\u0010E\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010\u008a\u0001R\u0013\u0010F\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010\u008a\u0001R\u0013\u0010G\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010\u008a\u0001R\u0013\u0010H\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010\u008a\u0001R\u0013\u0010I\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010\u009c\u0001R\u0013\u0010J\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010\u008a\u0001R\u0013\u0010K\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010\u008a\u0001R\u0013\u0010L\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010\u008a\u0001R\u0013\u0010M\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bË\u0001\u0010\u008a\u0001R\u0013\u0010N\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÌ\u0001\u0010\u008a\u0001R\u0013\u0010O\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010\u008a\u0001R\u0013\u0010P\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010\u008a\u0001R\u0013\u0010Q\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010\u008a\u0001R\u0013\u0010R\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010\u008a\u0001R\u0013\u0010S\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010\u008a\u0001R\u0013\u0010T\u001a\u00020U¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0013\u0010V\u001a\u00020U¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010Ó\u0001R\u0013\u0010W\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010\u008a\u0001R\u0013\u0010X\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010\u008a\u0001R\u0013\u0010Y\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\b×\u0001\u0010\u008a\u0001R\u0013\u0010Z\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bØ\u0001\u0010©\u0001R\u0013\u0010[\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010\u008a\u0001R\u0013\u0010\\\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010©\u0001R\u0013\u0010]\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010\u0095\u0001R\u0013\u0010^\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0001\u0010\u008a\u0001R\u0013\u0010_\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÝ\u0001\u0010\u008a\u0001R\u0013\u0010`\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010\u008a\u0001R\u0013\u0010a\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010\u0095\u0001R\u0013\u0010b\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bà\u0001\u0010\u008a\u0001R\u0013\u0010c\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010\u0095\u0001R\u0013\u0010d\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010\u0095\u0001R\u0013\u0010e\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010\u008a\u0001R\u0013\u0010f\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010\u008a\u0001R\u0013\u0010g\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010\u0095\u0001R\u0013\u0010h\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010\u0095\u0001R\u0013\u0010i\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bç\u0001\u0010\u008a\u0001R\u0013\u0010j\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010\u008a\u0001R\u0013\u0010k\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bé\u0001\u0010\u008a\u0001R\u0013\u0010l\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bê\u0001\u0010\u008a\u0001R\u0013\u0010m\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010\u008a\u0001R\u0013\u0010n\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bì\u0001\u0010\u008a\u0001R\u0013\u0010o\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010\u008a\u0001R\u0013\u0010p\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bî\u0001\u0010\u008a\u0001R\u0013\u0010q\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bï\u0001\u0010\u0095\u0001R\u0018\u0010r\u001a\u0004\u0018\u00010\u0010¢\u0006\r\n\u0003\u0010°\u0001\u001a\u0006\bð\u0001\u0010¯\u0001R\u0013\u0010s\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bñ\u0001\u0010\u008a\u0001R\u0013\u0010t\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010\u008a\u0001R\u001b\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0v¢\u0006\n\n\u0000\u001a\u0006\bó\u0001\u0010ô\u0001R\u0013\u0010x\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010\u008a\u0001R\u0013\u0010y\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\bö\u0001\u0010\u0095\u0001R\u0013\u0010z\u001a\u00020\u0010¢\u0006\n\n\u0000\u001a\u0006\b÷\u0001\u0010\u0095\u0001R\u0013\u0010{\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bø\u0001\u0010\u008a\u0001R\u0013\u0010|\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bù\u0001\u0010\u008a\u0001R\u0013\u0010}\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bú\u0001\u0010\u008a\u0001R\u0013\u0010~\u001a\u00020\u001a¢\u0006\n\n\u0000\u001a\u0006\bû\u0001\u0010\u009c\u0001R\u0019\u0010\u007f\u001a\u00030\u0080\u00018\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bü\u0001\u0010ý\u0001R\u0014\u0010\u0081\u0001\u001a\u00020\u0007¢\u0006\n\n\u0000\u001a\u0006\bþ\u0001\u0010\u008a\u0001R\u0014\u0010\u0082\u0001\u001a\u00020'¢\u0006\n\n\u0000\u001a\u0006\bÿ\u0001\u0010©\u0001¨\u0006þ\u0002"},
   d2 = {"Lcom/blueair/database/entity/DeviceEntity;", "", "uid", "", "name", "modelName", "typeIndex", "", "fanSpeed", "filterLife", "autoModeText", "brightness", "info", "deviceUuid", "Lcom/blueair/database/DeviceUuidEntity;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorType", "isAblDevice", "isNightModeOn", "isChildLockOn", "linkedDeviceUid", "connectivityStatusIndex", "lastConnectivityMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isEcoModeOn", "isHinsModeOn", "isHinsNightModeOn", "isG4NightModeOn", "isGermShieldOn", "isGermShieldNightModeOn", "isSafetySwitchOn", "g4NightModefilterTrigger", "aimInstalled", "sku", "compatibility", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "locationId", "disinfection", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "humMode", "mode", "waterLevel", "dehSubMode", "waterTankFailure", "smartSubMode", "detectCat", "bodyMounted", "cleanAirEta", "panelDisplayMode", "hoverEnabled", "airRefreshEnabled", "airRefreshStatus", "airRefreshDuration", "airRefreshTimeStamp", "airRefreshStartTimeStamp", "airRefreshEndTimeStamp", "roomType", "nightLampBrightness", "wickdryDuration", "wickdryDone", "ywrmEnabled", "ywrmUsage", "nightLampSteplessBrightness", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "humSubMode", "use24Hour", "waterInfill", "sensorMode", "coolFanSpeedLevel", "coolAutoLevel", "nightModeStartTime", "dualOscillationConfig", "Lcom/blueair/core/model/DualOscillationConfig;", "rpm1", "nightPeriods", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/blueair/database/DeviceUuidEntity;ZLcom/blueair/core/model/IndoorDatapoint;Ljava/lang/Integer;ZZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZZLjava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;ZZIJIZIIIIJIIIIIIIIIIDDIII[DI[DZIIIZIZZIIZZIIIIIIIIZLjava/lang/Boolean;IILjava/util/List;IZZIIIJLcom/blueair/core/model/DualOscillationConfig;I[D)V", "getUid", "()Ljava/lang/String;", "getName", "getModelName", "getTypeIndex", "()I", "getFanSpeed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFilterLife", "getAutoModeText", "getBrightness", "getInfo", "getDeviceUuid", "()Lcom/blueair/database/DeviceUuidEntity;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorType", "getLinkedDeviceUid", "getConnectivityStatusIndex", "getLastConnectivityMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getG4NightModefilterTrigger", "getAimInstalled", "getSku", "getCompatibility", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getLocationId", "getDisinfection", "getDisinfectLeftTime", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()D", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getHumMode", "getMode", "getWaterLevel", "getDehSubMode", "getWaterTankFailure", "getSmartSubMode", "getDetectCat", "getBodyMounted", "getCleanAirEta", "getPanelDisplayMode", "getHoverEnabled", "getAirRefreshEnabled", "getAirRefreshStatus", "getAirRefreshDuration", "getAirRefreshTimeStamp", "getAirRefreshStartTimeStamp", "getAirRefreshEndTimeStamp", "getRoomType", "getNightLampBrightness", "getWickdryDuration", "getWickdryDone", "getYwrmEnabled", "getYwrmUsage", "getNightLampSteplessBrightness", "getAlarms", "()Ljava/util/List;", "getHumSubMode", "getUse24Hour", "getWaterInfill", "getSensorMode", "getCoolFanSpeedLevel", "getCoolAutoLevel", "getNightModeStartTime", "getDualOscillationConfig", "()Lcom/blueair/core/model/DualOscillationConfig;", "getRpm1", "getNightPeriods", "toDevice", "Lcom/blueair/core/model/Device;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "component101", "component102", "component103", "component104", "component105", "component106", "component107", "component108", "component109", "component110", "component111", "component112", "component113", "component114", "component115", "component116", "component117", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/blueair/database/DeviceUuidEntity;ZLcom/blueair/core/model/IndoorDatapoint;Ljava/lang/Integer;ZZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZZLjava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;ZZIJIZIIIIJIIIIIIIIIIDDIII[DI[DZIIIZIZZIIZZIIIIIIIIZLjava/lang/Boolean;IILjava/util/List;IZZIIIJLcom/blueair/core/model/DualOscillationConfig;I[D)Lcom/blueair/database/entity/DeviceEntity;", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DEVICE_TABLE = "device_table";
   private static final List NULL_ALARM_LIST;
   private final boolean aimInstalled;
   private final int airRefreshDuration;
   private final boolean airRefreshEnabled;
   private final int airRefreshEndTimeStamp;
   private final int airRefreshStartTimeStamp;
   private final int airRefreshStatus;
   private final int airRefreshTimeStamp;
   private final List alarms;
   private final int apFanSpeed;
   private final int apSubMode;
   private final String autoModeText;
   private final int autoRh;
   private final boolean bodyMounted;
   private final Integer brightness;
   private final int cleanAirEta;
   private final String compatibility;
   private final int connectivityStatusIndex;
   private final int coolAutoLevel;
   private final double[] coolAutoPresets;
   private final int coolAutoTag;
   private final double[] coolEcoPresets;
   private final int coolEcoTag;
   private final int coolFanSpeed;
   private final int coolFanSpeedLevel;
   private final int coolSubMode;
   private final String dealerCountry;
   private final String dealerName;
   private final int dehSubMode;
   private final boolean detectCat;
   private final DeviceUuidEntity deviceUuid;
   private final Integer disinfectLeftTime;
   private final Long disinfectLeftTimeUpdateTime;
   private final Boolean disinfection;
   private final DualOscillationConfig dualOscillationConfig;
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
   private final long nightModeStartTime;
   private final double[] nightPeriods;
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
   private final int rpm1;
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

   static {
      ArrayList var1 = new ArrayList(6);

      for(int var0 = 0; var0 < 6; ++var0) {
         var1.add((Object)null);
      }

      NULL_ALARM_LIST = (List)var1;
   }

   public DeviceEntity(String var1, String var2, String var3, int var4, Integer var5, Integer var6, String var7, Integer var8, String var9, DeviceUuidEntity var10, boolean var11, IndoorDatapoint var12, Integer var13, boolean var14, boolean var15, boolean var16, String var17, int var18, long var19, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, String var30, String var31, double[] var32, double[] var33, double[] var34, double[] var35, double[] var36, int var37, boolean var38, boolean var39, boolean var40, boolean var41, boolean var42, boolean var43, Boolean var44, boolean var45, String var46, boolean var47, String var48, String var49, WelcomeHomeLocation var50, String var51, Boolean var52, Integer var53, Long var54, boolean var55, boolean var56, int var57, long var58, int var60, boolean var61, int var62, int var63, int var64, int var65, long var66, int var68, int var69, int var70, int var71, int var72, int var73, int var74, int var75, int var76, int var77, double var78, double var80, int var82, int var83, int var84, double[] var85, int var86, double[] var87, boolean var88, int var89, int var90, int var91, boolean var92, int var93, boolean var94, boolean var95, int var96, int var97, boolean var98, boolean var99, int var100, int var101, int var102, int var103, int var104, int var105, int var106, int var107, boolean var108, Boolean var109, int var110, int var111, List var112, int var113, boolean var114, boolean var115, int var116, int var117, int var118, long var119, DualOscillationConfig var121, int var122, double[] var123) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "modelName");
      Intrinsics.checkNotNullParameter(var21, "mac");
      Intrinsics.checkNotNullParameter(var22, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var23, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var24, "hardware");
      Intrinsics.checkNotNullParameter(var25, "timeZone");
      Intrinsics.checkNotNullParameter(var26, "serial");
      Intrinsics.checkNotNullParameter(var27, "purchaseDate");
      Intrinsics.checkNotNullParameter(var28, "dealerName");
      Intrinsics.checkNotNullParameter(var29, "dealerCountry");
      Intrinsics.checkNotNullParameter(var30, "filterType");
      Intrinsics.checkNotNullParameter(var31, "filterTrigger");
      Intrinsics.checkNotNullParameter(var32, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var33, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var34, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var35, "vocRanges");
      Intrinsics.checkNotNullParameter(var36, "hchoRanges");
      Intrinsics.checkNotNullParameter(var46, "g4NightModefilterTrigger");
      Intrinsics.checkNotNullParameter(var85, "coolAutoPresets");
      Intrinsics.checkNotNullParameter(var87, "coolEcoPresets");
      Intrinsics.checkNotNullParameter(var112, "alarms");
      Intrinsics.checkNotNullParameter(var121, "dualOscillationConfig");
      Intrinsics.checkNotNullParameter(var123, "nightPeriods");
      super();
      this.uid = var1;
      this.name = var2;
      this.modelName = var3;
      this.typeIndex = var4;
      this.fanSpeed = var5;
      this.filterLife = var6;
      this.autoModeText = var7;
      this.brightness = var8;
      this.info = var9;
      this.deviceUuid = var10;
      this.hasFinishedOnboarding = var11;
      this.latestSensorDatapoint = var12;
      this.lastSelectedSensorType = var13;
      this.isAblDevice = var14;
      this.isNightModeOn = var15;
      this.isChildLockOn = var16;
      this.linkedDeviceUid = var17;
      this.connectivityStatusIndex = var18;
      this.lastConnectivityMillis = var19;
      this.mac = var21;
      this.mcuFirmware = var22;
      this.wifiFirmware = var23;
      this.hardware = var24;
      this.timeZone = var25;
      this.serial = var26;
      this.purchaseDate = var27;
      this.dealerName = var28;
      this.dealerCountry = var29;
      this.filterType = var30;
      this.filterTrigger = var31;
      this.pm1Ranges = var32;
      this.pm10Ranges = var33;
      this.pm25Ranges = var34;
      this.vocRanges = var35;
      this.hchoRanges = var36;
      this.updateProgress = var37;
      this.isStandByOn = var38;
      this.isEcoModeOn = var39;
      this.isHinsModeOn = var40;
      this.isHinsNightModeOn = var41;
      this.isG4NightModeOn = var42;
      this.isGermShieldOn = var43;
      this.isGermShieldNightModeOn = var44;
      this.isSafetySwitchOn = var45;
      this.g4NightModefilterTrigger = var46;
      this.aimInstalled = var47;
      this.sku = var48;
      this.compatibility = var49;
      this.welcomeHome = var50;
      this.locationId = var51;
      this.disinfection = var52;
      this.disinfectLeftTime = var53;
      this.disinfectLeftTimeUpdateTime = var54;
      this.wickdryEnabled = var55;
      this.wickdryOn = var56;
      this.wickdryLeftTime = var57;
      this.wickdryLeftTimeUpdateTime = var58;
      this.wickUsage = var60;
      this.waterShortage = var61;
      this.autoRh = var62;
      this.timerStatus = var63;
      this.timerDuration = var64;
      this.timerLeftTime = var65;
      this.timerLeftTimeUpdateTime = var66;
      this.temperatureUnit = var68;
      this.oscillationState = var69;
      this.oscillationAngle = var70;
      this.oscillationDirection = var71;
      this.oscillationFanSpeed = var72;
      this.mainMode = var73;
      this.apSubMode = var74;
      this.apFanSpeed = var75;
      this.heatSubMode = var76;
      this.heatFanSpeed = var77;
      this.heatAutoTmp = var78;
      this.heatEcoTmp = var80;
      this.coolSubMode = var82;
      this.coolFanSpeed = var83;
      this.coolAutoTag = var84;
      this.coolAutoPresets = var85;
      this.coolEcoTag = var86;
      this.coolEcoPresets = var87;
      this.humMode = var88;
      this.mode = var89;
      this.waterLevel = var90;
      this.dehSubMode = var91;
      this.waterTankFailure = var92;
      this.smartSubMode = var93;
      this.detectCat = var94;
      this.bodyMounted = var95;
      this.cleanAirEta = var96;
      this.panelDisplayMode = var97;
      this.hoverEnabled = var98;
      this.airRefreshEnabled = var99;
      this.airRefreshStatus = var100;
      this.airRefreshDuration = var101;
      this.airRefreshTimeStamp = var102;
      this.airRefreshStartTimeStamp = var103;
      this.airRefreshEndTimeStamp = var104;
      this.roomType = var105;
      this.nightLampBrightness = var106;
      this.wickdryDuration = var107;
      this.wickdryDone = var108;
      this.ywrmEnabled = var109;
      this.ywrmUsage = var110;
      this.nightLampSteplessBrightness = var111;
      this.alarms = var112;
      this.humSubMode = var113;
      this.use24Hour = var114;
      this.waterInfill = var115;
      this.sensorMode = var116;
      this.coolFanSpeedLevel = var117;
      this.coolAutoLevel = var118;
      this.nightModeStartTime = var119;
      this.dualOscillationConfig = var121;
      this.rpm1 = var122;
      this.nightPeriods = var123;
   }

   // $FF: synthetic method
   public DeviceEntity(String var1, String var2, String var3, int var4, Integer var5, Integer var6, String var7, Integer var8, String var9, DeviceUuidEntity var10, boolean var11, IndoorDatapoint var12, Integer var13, boolean var14, boolean var15, boolean var16, String var17, int var18, long var19, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, String var30, String var31, double[] var32, double[] var33, double[] var34, double[] var35, double[] var36, int var37, boolean var38, boolean var39, boolean var40, boolean var41, boolean var42, boolean var43, Boolean var44, boolean var45, String var46, boolean var47, String var48, String var49, WelcomeHomeLocation var50, String var51, Boolean var52, Integer var53, Long var54, boolean var55, boolean var56, int var57, long var58, int var60, boolean var61, int var62, int var63, int var64, int var65, long var66, int var68, int var69, int var70, int var71, int var72, int var73, int var74, int var75, int var76, int var77, double var78, double var80, int var82, int var83, int var84, double[] var85, int var86, double[] var87, boolean var88, int var89, int var90, int var91, boolean var92, int var93, boolean var94, boolean var95, int var96, int var97, boolean var98, boolean var99, int var100, int var101, int var102, int var103, int var104, int var105, int var106, int var107, boolean var108, Boolean var109, int var110, int var111, List var112, int var113, boolean var114, boolean var115, int var116, int var117, int var118, long var119, DualOscillationConfig var121, int var122, double[] var123, int var124, int var125, int var126, int var127, DefaultConstructorMarker var128) {
      if ((var124 & 16) != 0) {
         var5 = null;
      }

      if ((var124 & 32) != 0) {
         var6 = null;
      }

      if ((var124 & 64) != 0) {
         var7 = null;
      }

      if ((var124 & 128) != 0) {
         var8 = null;
      }

      if ((var124 & 256) != 0) {
         var9 = null;
      }

      if ((var124 & 512) != 0) {
         var10 = null;
      }

      if ((var124 & 1024) != 0) {
         var11 = false;
      }

      if ((var124 & 16384) != 0) {
         var15 = false;
      }

      if ((var124 & '耀') != 0) {
         var16 = false;
      }

      if ((var124 & 65536) != 0) {
         var17 = null;
      }

      if ((var124 & 524288) != 0) {
         var21 = "";
      }

      if ((var124 & 1048576) != 0) {
         var22 = "";
      }

      if ((var124 & 2097152) != 0) {
         var23 = "";
      }

      if ((var124 & 4194304) != 0) {
         var24 = "";
      }

      if ((var124 & 8388608) != 0) {
         var25 = "";
      }

      if ((var124 & 16777216) != 0) {
         var26 = "";
      }

      if ((var124 & 33554432) != 0) {
         var27 = "";
      }

      if ((var124 & 67108864) != 0) {
         var28 = "";
      }

      if ((var124 & 134217728) != 0) {
         var29 = "";
      }

      if ((var124 & 268435456) != 0) {
         var30 = "";
      }

      if ((var124 & 536870912) != 0) {
         var31 = "";
      }

      if ((var124 & 1073741824) != 0) {
         var32 = new double[0];
      }

      if ((var124 & Integer.MIN_VALUE) != 0) {
         var33 = new double[0];
      }

      if ((var125 & 1) != 0) {
         var34 = new double[0];
      }

      if ((var125 & 2) != 0) {
         var35 = new double[0];
      }

      if ((var125 & 4) != 0) {
         var36 = new double[0];
      }

      if ((var125 & 8) != 0) {
         var37 = 0;
      }

      if ((var125 & 16) != 0) {
         var38 = false;
      }

      if ((var125 & 32) != 0) {
         var39 = false;
      }

      if ((var125 & 64) != 0) {
         var40 = false;
      }

      if ((var125 & 128) != 0) {
         var41 = false;
      }

      if ((var125 & 256) != 0) {
         var42 = false;
      }

      if ((var125 & 512) != 0) {
         var43 = false;
      }

      if ((var125 & 1024) != 0) {
         var44 = null;
      }

      if ((var125 & 2048) != 0) {
         var45 = true;
      }

      if ((var125 & 4096) != 0) {
         var46 = "";
      }

      if ((var125 & 8192) != 0) {
         var47 = false;
      }

      if ((var125 & 16384) != 0) {
         var48 = null;
      }

      if ((var125 & '耀') != 0) {
         var49 = null;
      }

      if ((var125 & 65536) != 0) {
         var50 = null;
      }

      if ((131072 & var125) != 0) {
         var51 = null;
      }

      if ((262144 & var125) != 0) {
         var52 = null;
      }

      if ((var125 & 524288) != 0) {
         var53 = null;
      }

      if ((var125 & 1048576) != 0) {
         var54 = null;
      }

      if ((var125 & 2097152) != 0) {
         var55 = false;
      }

      if ((var125 & 4194304) != 0) {
         var56 = false;
      }

      if ((var125 & 8388608) != 0) {
         var57 = 0;
      }

      if ((var125 & 16777216) != 0) {
         var58 = 0L;
      }

      if ((var125 & 33554432) != 0) {
         var60 = 0;
      }

      if ((67108864 & var125) != 0) {
         var61 = false;
      }

      if ((134217728 & var125) != 0) {
         var62 = 50;
      }

      if ((268435456 & var125) != 0) {
         var63 = 0;
      }

      if ((536870912 & var125) != 0) {
         var64 = 0;
      }

      if ((1073741824 & var125) != 0) {
         var65 = 0;
      }

      if ((Integer.MIN_VALUE & var125) != 0) {
         var66 = 0L;
      }

      if ((var126 & 1) != 0) {
         var68 = 0;
      }

      if ((var126 & 2) != 0) {
         var69 = 0;
      }

      if ((var126 & 4) != 0) {
         var70 = 90;
      }

      if ((var126 & 8) != 0) {
         var71 = 0;
      }

      if ((var126 & 16) != 0) {
         var72 = 0;
      }

      if ((var126 & 32) != 0) {
         var73 = 0;
      }

      if ((var126 & 64) != 0) {
         var74 = 2;
      }

      if ((var126 & 128) != 0) {
         var75 = 0;
      }

      if ((var126 & 256) != 0) {
         var76 = 2;
      }

      if ((var126 & 512) != 0) {
         var77 = 0;
      }

      if ((var126 & 1024) != 0) {
         var78 = (double)22.0F;
      }

      if ((var126 & 2048) != 0) {
         var80 = (double)22.0F;
      }

      if ((var126 & 4096) != 0) {
         var82 = 2;
      }

      if ((var126 & 8192) != 0) {
         var83 = 0;
      }

      if ((var126 & 16384) != 0) {
         var84 = 0;
      }

      if ((var126 & '耀') != 0) {
         var85 = new double[]{(double)20.0F, (double)23.0F, (double)25.0F};
      }

      if ((var126 & 65536) != 0) {
         var86 = 0;
      }

      if ((131072 & var126) != 0) {
         var87 = new double[]{(double)20.0F, (double)25.0F};
      }

      if ((262144 & var126) != 0) {
         var88 = false;
      }

      if ((var126 & 524288) != 0) {
         var89 = 1;
      }

      if ((var126 & 1048576) != 0) {
         var90 = 0;
      }

      if ((var126 & 2097152) != 0) {
         var91 = 1;
      }

      if ((var126 & 4194304) != 0) {
         var92 = false;
      }

      if ((var126 & 8388608) != 0) {
         var93 = 0;
      }

      if ((var126 & 16777216) != 0) {
         var94 = false;
      }

      if ((var126 & 33554432) != 0) {
         var95 = true;
      }

      if ((67108864 & var126) != 0) {
         var96 = 0;
      }

      if ((134217728 & var126) != 0) {
         var97 = 0;
      }

      if ((268435456 & var126) != 0) {
         var98 = true;
      }

      if ((536870912 & var126) != 0) {
         var99 = true;
      }

      if ((1073741824 & var126) != 0) {
         var100 = 0;
      }

      if ((Integer.MIN_VALUE & var126) != 0) {
         var101 = 0;
      }

      if ((var127 & 1) != 0) {
         var102 = 0;
      }

      if ((var127 & 2) != 0) {
         var103 = 0;
      }

      if ((var127 & 4) != 0) {
         var104 = 0;
      }

      if ((var127 & 8) != 0) {
         var105 = 0;
      }

      if ((var127 & 16) != 0) {
         var106 = 0;
      }

      if ((var127 & 32) != 0) {
         var107 = 0;
      }

      if ((var127 & 64) != 0) {
         var108 = false;
      }

      if ((var127 & 128) != 0) {
         var109 = null;
      }

      if ((var127 & 256) != 0) {
         var110 = 0;
      }

      if ((var127 & 512) != 0) {
         var111 = 0;
      }

      if ((var127 & 1024) != 0) {
         var112 = NULL_ALARM_LIST;
      }

      if ((var127 & 2048) != 0) {
         var113 = 2;
      }

      if ((var127 & 4096) != 0) {
         var114 = true;
      }

      if ((var127 & 8192) != 0) {
         var115 = false;
      }

      if ((var127 & 16384) != 0) {
         var116 = 1;
      }

      if ((var127 & '耀') != 0) {
         var117 = 1;
      }

      if ((var127 & 65536) != 0) {
         var118 = 0;
      }

      if ((131072 & var127) != 0) {
         var119 = 0L;
      }

      if ((262144 & var127) != 0) {
         var121 = new DualOscillationConfig(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, (DefaultConstructorMarker)null);
      }

      if ((var127 & 524288) != 0) {
         var122 = 0;
      }

      if ((var127 & 1048576) != 0) {
         var123 = new double[0];
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var60, var61, var62, var63, var64, var65, var66, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var80, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100, var101, var102, var103, var104, var105, var106, var107, var108, var109, var110, var111, var112, var113, var114, var115, var116, var117, var118, var119, var121, var122, var123);
   }

   // $FF: synthetic method
   public static DeviceEntity copy$default(DeviceEntity var0, String var1, String var2, String var3, int var4, Integer var5, Integer var6, String var7, Integer var8, String var9, DeviceUuidEntity var10, boolean var11, IndoorDatapoint var12, Integer var13, boolean var14, boolean var15, boolean var16, String var17, int var18, long var19, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, String var30, String var31, double[] var32, double[] var33, double[] var34, double[] var35, double[] var36, int var37, boolean var38, boolean var39, boolean var40, boolean var41, boolean var42, boolean var43, Boolean var44, boolean var45, String var46, boolean var47, String var48, String var49, WelcomeHomeLocation var50, String var51, Boolean var52, Integer var53, Long var54, boolean var55, boolean var56, int var57, long var58, int var60, boolean var61, int var62, int var63, int var64, int var65, long var66, int var68, int var69, int var70, int var71, int var72, int var73, int var74, int var75, int var76, int var77, double var78, double var80, int var82, int var83, int var84, double[] var85, int var86, double[] var87, boolean var88, int var89, int var90, int var91, boolean var92, int var93, boolean var94, boolean var95, int var96, int var97, boolean var98, boolean var99, int var100, int var101, int var102, int var103, int var104, int var105, int var106, int var107, boolean var108, Boolean var109, int var110, int var111, List var112, int var113, boolean var114, boolean var115, int var116, int var117, int var118, long var119, DualOscillationConfig var121, int var122, double[] var123, int var124, int var125, int var126, int var127, Object var128) {
      if ((var124 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var124 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var124 & 4) != 0) {
         var3 = var0.modelName;
      }

      if ((var124 & 8) != 0) {
         var4 = var0.typeIndex;
      }

      if ((var124 & 16) != 0) {
         var5 = var0.fanSpeed;
      }

      if ((var124 & 32) != 0) {
         var6 = var0.filterLife;
      }

      if ((var124 & 64) != 0) {
         var7 = var0.autoModeText;
      }

      if ((var124 & 128) != 0) {
         var8 = var0.brightness;
      }

      if ((var124 & 256) != 0) {
         var9 = var0.info;
      }

      if ((var124 & 512) != 0) {
         var10 = var0.deviceUuid;
      }

      if ((var124 & 1024) != 0) {
         var11 = var0.hasFinishedOnboarding;
      }

      if ((var124 & 2048) != 0) {
         var12 = var0.latestSensorDatapoint;
      }

      if ((var124 & 4096) != 0) {
         var13 = var0.lastSelectedSensorType;
      }

      if ((var124 & 8192) != 0) {
         var14 = var0.isAblDevice;
      }

      if ((var124 & 16384) != 0) {
         var15 = var0.isNightModeOn;
      }

      if ((var124 & '耀') != 0) {
         var16 = var0.isChildLockOn;
      }

      if ((var124 & 65536) != 0) {
         var17 = var0.linkedDeviceUid;
      }

      if ((var124 & 131072) != 0) {
         var18 = var0.connectivityStatusIndex;
      }

      if ((var124 & 262144) != 0) {
         var19 = var0.lastConnectivityMillis;
      }

      if ((var124 & 524288) != 0) {
         var21 = var0.mac;
      }

      if ((var124 & 1048576) != 0) {
         var22 = var0.mcuFirmware;
      }

      if ((var124 & 2097152) != 0) {
         var23 = var0.wifiFirmware;
      }

      if ((var124 & 4194304) != 0) {
         var24 = var0.hardware;
      }

      if ((var124 & 8388608) != 0) {
         var25 = var0.timeZone;
      }

      if ((var124 & 16777216) != 0) {
         var26 = var0.serial;
      }

      if ((var124 & 33554432) != 0) {
         var27 = var0.purchaseDate;
      }

      if ((var124 & 67108864) != 0) {
         var28 = var0.dealerName;
      }

      if ((var124 & 134217728) != 0) {
         var29 = var0.dealerCountry;
      }

      if ((var124 & 268435456) != 0) {
         var30 = var0.filterType;
      }

      if ((var124 & 536870912) != 0) {
         var31 = var0.filterTrigger;
      }

      if ((var124 & 1073741824) != 0) {
         var32 = var0.pm1Ranges;
      }

      if ((var124 & Integer.MIN_VALUE) != 0) {
         var33 = var0.pm10Ranges;
      }

      if ((var125 & 1) != 0) {
         var34 = var0.pm25Ranges;
      }

      if ((var125 & 2) != 0) {
         var35 = var0.vocRanges;
      }

      if ((var125 & 4) != 0) {
         var36 = var0.hchoRanges;
      }

      if ((var125 & 8) != 0) {
         var37 = var0.updateProgress;
      }

      if ((var125 & 16) != 0) {
         var38 = var0.isStandByOn;
      }

      if ((var125 & 32) != 0) {
         var39 = var0.isEcoModeOn;
      }

      if ((var125 & 64) != 0) {
         var40 = var0.isHinsModeOn;
      }

      if ((var125 & 128) != 0) {
         var41 = var0.isHinsNightModeOn;
      }

      if ((var125 & 256) != 0) {
         var42 = var0.isG4NightModeOn;
      }

      if ((var125 & 512) != 0) {
         var43 = var0.isGermShieldOn;
      }

      if ((var125 & 1024) != 0) {
         var44 = var0.isGermShieldNightModeOn;
      }

      if ((var125 & 2048) != 0) {
         var45 = var0.isSafetySwitchOn;
      }

      if ((var125 & 4096) != 0) {
         var46 = var0.g4NightModefilterTrigger;
      }

      if ((var125 & 8192) != 0) {
         var47 = var0.aimInstalled;
      }

      if ((var125 & 16384) != 0) {
         var48 = var0.sku;
      }

      if ((var125 & '耀') != 0) {
         var49 = var0.compatibility;
      }

      if ((var125 & 65536) != 0) {
         var50 = var0.welcomeHome;
      }

      if ((var125 & 131072) != 0) {
         var51 = var0.locationId;
      }

      if ((var125 & 262144) != 0) {
         var52 = var0.disinfection;
      }

      if ((var125 & 524288) != 0) {
         var53 = var0.disinfectLeftTime;
      }

      if ((var125 & 1048576) != 0) {
         var54 = var0.disinfectLeftTimeUpdateTime;
      }

      if ((var125 & 2097152) != 0) {
         var55 = var0.wickdryEnabled;
      }

      if ((var125 & 4194304) != 0) {
         var56 = var0.wickdryOn;
      }

      if ((var125 & 8388608) != 0) {
         var57 = var0.wickdryLeftTime;
      }

      if ((var125 & 16777216) != 0) {
         var58 = var0.wickdryLeftTimeUpdateTime;
      }

      if ((var125 & 33554432) != 0) {
         var60 = var0.wickUsage;
      }

      if ((var125 & 67108864) != 0) {
         var61 = var0.waterShortage;
      }

      if ((var125 & 134217728) != 0) {
         var62 = var0.autoRh;
      }

      if ((var125 & 268435456) != 0) {
         var63 = var0.timerStatus;
      }

      if ((var125 & 536870912) != 0) {
         var64 = var0.timerDuration;
      }

      if ((var125 & 1073741824) != 0) {
         var65 = var0.timerLeftTime;
      }

      if ((var125 & Integer.MIN_VALUE) != 0) {
         var66 = var0.timerLeftTimeUpdateTime;
      }

      if ((var126 & 1) != 0) {
         var68 = var0.temperatureUnit;
      }

      if ((var126 & 2) != 0) {
         var69 = var0.oscillationState;
      }

      if ((var126 & 4) != 0) {
         var70 = var0.oscillationAngle;
      }

      if ((var126 & 8) != 0) {
         var71 = var0.oscillationDirection;
      }

      if ((var126 & 16) != 0) {
         var72 = var0.oscillationFanSpeed;
      }

      if ((var126 & 32) != 0) {
         var73 = var0.mainMode;
      }

      if ((var126 & 64) != 0) {
         var74 = var0.apSubMode;
      }

      if ((var126 & 128) != 0) {
         var75 = var0.apFanSpeed;
      }

      if ((var126 & 256) != 0) {
         var76 = var0.heatSubMode;
      }

      if ((var126 & 512) != 0) {
         var77 = var0.heatFanSpeed;
      }

      if ((var126 & 1024) != 0) {
         var78 = var0.heatAutoTmp;
      }

      if ((var126 & 2048) != 0) {
         var80 = var0.heatEcoTmp;
      }

      if ((var126 & 4096) != 0) {
         var82 = var0.coolSubMode;
      }

      if ((var126 & 8192) != 0) {
         var83 = var0.coolFanSpeed;
      }

      if ((var126 & 16384) != 0) {
         var84 = var0.coolAutoTag;
      }

      if ((var126 & '耀') != 0) {
         var85 = var0.coolAutoPresets;
      }

      if ((var126 & 65536) != 0) {
         var86 = var0.coolEcoTag;
      }

      if ((var126 & 131072) != 0) {
         var87 = var0.coolEcoPresets;
      }

      if ((var126 & 262144) != 0) {
         var88 = var0.humMode;
      }

      if ((var126 & 524288) != 0) {
         var89 = var0.mode;
      }

      if ((var126 & 1048576) != 0) {
         var90 = var0.waterLevel;
      }

      if ((var126 & 2097152) != 0) {
         var91 = var0.dehSubMode;
      }

      if ((var126 & 4194304) != 0) {
         var92 = var0.waterTankFailure;
      }

      if ((var126 & 8388608) != 0) {
         var93 = var0.smartSubMode;
      }

      if ((var126 & 16777216) != 0) {
         var94 = var0.detectCat;
      }

      if ((var126 & 33554432) != 0) {
         var95 = var0.bodyMounted;
      }

      if ((var126 & 67108864) != 0) {
         var96 = var0.cleanAirEta;
      }

      if ((var126 & 134217728) != 0) {
         var97 = var0.panelDisplayMode;
      }

      if ((var126 & 268435456) != 0) {
         var98 = var0.hoverEnabled;
      }

      if ((var126 & 536870912) != 0) {
         var99 = var0.airRefreshEnabled;
      }

      if ((var126 & 1073741824) != 0) {
         var100 = var0.airRefreshStatus;
      }

      if ((var126 & Integer.MIN_VALUE) != 0) {
         var101 = var0.airRefreshDuration;
      }

      if ((var127 & 1) != 0) {
         var102 = var0.airRefreshTimeStamp;
      }

      if ((var127 & 2) != 0) {
         var103 = var0.airRefreshStartTimeStamp;
      }

      if ((var127 & 4) != 0) {
         var104 = var0.airRefreshEndTimeStamp;
      }

      if ((var127 & 8) != 0) {
         var105 = var0.roomType;
      }

      if ((var127 & 16) != 0) {
         var106 = var0.nightLampBrightness;
      }

      if ((var127 & 32) != 0) {
         var107 = var0.wickdryDuration;
      }

      if ((var127 & 64) != 0) {
         var108 = var0.wickdryDone;
      }

      if ((var127 & 128) != 0) {
         var109 = var0.ywrmEnabled;
      }

      if ((var127 & 256) != 0) {
         var110 = var0.ywrmUsage;
      }

      if ((var127 & 512) != 0) {
         var111 = var0.nightLampSteplessBrightness;
      }

      if ((var127 & 1024) != 0) {
         var112 = var0.alarms;
      }

      if ((var127 & 2048) != 0) {
         var113 = var0.humSubMode;
      }

      if ((var127 & 4096) != 0) {
         var114 = var0.use24Hour;
      }

      if ((var127 & 8192) != 0) {
         var115 = var0.waterInfill;
      }

      if ((var127 & 16384) != 0) {
         var116 = var0.sensorMode;
      }

      if ((var127 & '耀') != 0) {
         var117 = var0.coolFanSpeedLevel;
      }

      if ((var127 & 65536) != 0) {
         var118 = var0.coolAutoLevel;
      }

      if ((var127 & 131072) != 0) {
         var119 = var0.nightModeStartTime;
      }

      if ((var127 & 262144) != 0) {
         var121 = var0.dualOscillationConfig;
      }

      if ((var127 & 524288) != 0) {
         var122 = var0.rpm1;
      }

      if ((var127 & 1048576) != 0) {
         var123 = var0.nightPeriods;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var60, var61, var62, var63, var64, var65, var66, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var80, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100, var101, var102, var103, var104, var105, var106, var107, var108, var109, var110, var111, var112, var113, var114, var115, var116, var117, var118, var119, var121, var122, var123);
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

   public final List component107() {
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

   public final int component112() {
      return this.coolFanSpeedLevel;
   }

   public final int component113() {
      return this.coolAutoLevel;
   }

   public final long component114() {
      return this.nightModeStartTime;
   }

   public final DualOscillationConfig component115() {
      return this.dualOscillationConfig;
   }

   public final int component116() {
      return this.rpm1;
   }

   public final double[] component117() {
      return this.nightPeriods;
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

   public final DeviceEntity copy(String var1, String var2, String var3, int var4, Integer var5, Integer var6, String var7, Integer var8, String var9, DeviceUuidEntity var10, boolean var11, IndoorDatapoint var12, Integer var13, boolean var14, boolean var15, boolean var16, String var17, int var18, long var19, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, String var30, String var31, double[] var32, double[] var33, double[] var34, double[] var35, double[] var36, int var37, boolean var38, boolean var39, boolean var40, boolean var41, boolean var42, boolean var43, Boolean var44, boolean var45, String var46, boolean var47, String var48, String var49, WelcomeHomeLocation var50, String var51, Boolean var52, Integer var53, Long var54, boolean var55, boolean var56, int var57, long var58, int var60, boolean var61, int var62, int var63, int var64, int var65, long var66, int var68, int var69, int var70, int var71, int var72, int var73, int var74, int var75, int var76, int var77, double var78, double var80, int var82, int var83, int var84, double[] var85, int var86, double[] var87, boolean var88, int var89, int var90, int var91, boolean var92, int var93, boolean var94, boolean var95, int var96, int var97, boolean var98, boolean var99, int var100, int var101, int var102, int var103, int var104, int var105, int var106, int var107, boolean var108, Boolean var109, int var110, int var111, List var112, int var113, boolean var114, boolean var115, int var116, int var117, int var118, long var119, DualOscillationConfig var121, int var122, double[] var123) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "modelName");
      Intrinsics.checkNotNullParameter(var21, "mac");
      Intrinsics.checkNotNullParameter(var22, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var23, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var24, "hardware");
      Intrinsics.checkNotNullParameter(var25, "timeZone");
      Intrinsics.checkNotNullParameter(var26, "serial");
      Intrinsics.checkNotNullParameter(var27, "purchaseDate");
      Intrinsics.checkNotNullParameter(var28, "dealerName");
      Intrinsics.checkNotNullParameter(var29, "dealerCountry");
      Intrinsics.checkNotNullParameter(var30, "filterType");
      Intrinsics.checkNotNullParameter(var31, "filterTrigger");
      Intrinsics.checkNotNullParameter(var32, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var33, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var34, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var35, "vocRanges");
      Intrinsics.checkNotNullParameter(var36, "hchoRanges");
      Intrinsics.checkNotNullParameter(var46, "g4NightModefilterTrigger");
      Intrinsics.checkNotNullParameter(var85, "coolAutoPresets");
      Intrinsics.checkNotNullParameter(var87, "coolEcoPresets");
      Intrinsics.checkNotNullParameter(var112, "alarms");
      Intrinsics.checkNotNullParameter(var121, "dualOscillationConfig");
      Intrinsics.checkNotNullParameter(var123, "nightPeriods");
      return new DeviceEntity(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var60, var61, var62, var63, var64, var65, var66, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var80, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100, var101, var102, var103, var104, var105, var106, var107, var108, var109, var110, var111, var112, var113, var114, var115, var116, var117, var118, var119, var121, var122, var123);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.fanSpeed, var1.fanSpeed)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterLife, var1.filterLife)) {
            return false;
         } else if (!Intrinsics.areEqual(this.autoModeText, var1.autoModeText)) {
            return false;
         } else if (!Intrinsics.areEqual(this.brightness, var1.brightness)) {
            return false;
         } else if (!Intrinsics.areEqual(this.info, var1.info)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceUuid, var1.deviceUuid)) {
            return false;
         } else if (this.hasFinishedOnboarding != var1.hasFinishedOnboarding) {
            return false;
         } else if (!Intrinsics.areEqual(this.latestSensorDatapoint, var1.latestSensorDatapoint)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastSelectedSensorType, var1.lastSelectedSensorType)) {
            return false;
         } else if (this.isAblDevice != var1.isAblDevice) {
            return false;
         } else if (this.isNightModeOn != var1.isNightModeOn) {
            return false;
         } else if (this.isChildLockOn != var1.isChildLockOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkedDeviceUid, var1.linkedDeviceUid)) {
            return false;
         } else if (this.connectivityStatusIndex != var1.connectivityStatusIndex) {
            return false;
         } else if (this.lastConnectivityMillis != var1.lastConnectivityMillis) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serial, var1.serial)) {
            return false;
         } else if (!Intrinsics.areEqual(this.purchaseDate, var1.purchaseDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerName, var1.dealerName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerCountry, var1.dealerCountry)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterType, var1.filterType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterTrigger, var1.filterTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm1Ranges, var1.pm1Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10Ranges, var1.pm10Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25Ranges, var1.pm25Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vocRanges, var1.vocRanges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hchoRanges, var1.hchoRanges)) {
            return false;
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else if (this.isStandByOn != var1.isStandByOn) {
            return false;
         } else if (this.isEcoModeOn != var1.isEcoModeOn) {
            return false;
         } else if (this.isHinsModeOn != var1.isHinsModeOn) {
            return false;
         } else if (this.isHinsNightModeOn != var1.isHinsNightModeOn) {
            return false;
         } else if (this.isG4NightModeOn != var1.isG4NightModeOn) {
            return false;
         } else if (this.isGermShieldOn != var1.isGermShieldOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.isGermShieldNightModeOn, var1.isGermShieldNightModeOn)) {
            return false;
         } else if (this.isSafetySwitchOn != var1.isSafetySwitchOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.g4NightModefilterTrigger, var1.g4NightModefilterTrigger)) {
            return false;
         } else if (this.aimInstalled != var1.aimInstalled) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.compatibility, var1.compatibility)) {
            return false;
         } else if (!Intrinsics.areEqual(this.welcomeHome, var1.welcomeHome)) {
            return false;
         } else if (!Intrinsics.areEqual(this.locationId, var1.locationId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.disinfection, var1.disinfection)) {
            return false;
         } else if (!Intrinsics.areEqual(this.disinfectLeftTime, var1.disinfectLeftTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.disinfectLeftTimeUpdateTime, var1.disinfectLeftTimeUpdateTime)) {
            return false;
         } else if (this.wickdryEnabled != var1.wickdryEnabled) {
            return false;
         } else if (this.wickdryOn != var1.wickdryOn) {
            return false;
         } else if (this.wickdryLeftTime != var1.wickdryLeftTime) {
            return false;
         } else if (this.wickdryLeftTimeUpdateTime != var1.wickdryLeftTimeUpdateTime) {
            return false;
         } else if (this.wickUsage != var1.wickUsage) {
            return false;
         } else if (this.waterShortage != var1.waterShortage) {
            return false;
         } else if (this.autoRh != var1.autoRh) {
            return false;
         } else if (this.timerStatus != var1.timerStatus) {
            return false;
         } else if (this.timerDuration != var1.timerDuration) {
            return false;
         } else if (this.timerLeftTime != var1.timerLeftTime) {
            return false;
         } else if (this.timerLeftTimeUpdateTime != var1.timerLeftTimeUpdateTime) {
            return false;
         } else if (this.temperatureUnit != var1.temperatureUnit) {
            return false;
         } else if (this.oscillationState != var1.oscillationState) {
            return false;
         } else if (this.oscillationAngle != var1.oscillationAngle) {
            return false;
         } else if (this.oscillationDirection != var1.oscillationDirection) {
            return false;
         } else if (this.oscillationFanSpeed != var1.oscillationFanSpeed) {
            return false;
         } else if (this.mainMode != var1.mainMode) {
            return false;
         } else if (this.apSubMode != var1.apSubMode) {
            return false;
         } else if (this.apFanSpeed != var1.apFanSpeed) {
            return false;
         } else if (this.heatSubMode != var1.heatSubMode) {
            return false;
         } else if (this.heatFanSpeed != var1.heatFanSpeed) {
            return false;
         } else if (Double.compare(this.heatAutoTmp, var1.heatAutoTmp) != 0) {
            return false;
         } else if (Double.compare(this.heatEcoTmp, var1.heatEcoTmp) != 0) {
            return false;
         } else if (this.coolSubMode != var1.coolSubMode) {
            return false;
         } else if (this.coolFanSpeed != var1.coolFanSpeed) {
            return false;
         } else if (this.coolAutoTag != var1.coolAutoTag) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolAutoPresets, var1.coolAutoPresets)) {
            return false;
         } else if (this.coolEcoTag != var1.coolEcoTag) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolEcoPresets, var1.coolEcoPresets)) {
            return false;
         } else if (this.humMode != var1.humMode) {
            return false;
         } else if (this.mode != var1.mode) {
            return false;
         } else if (this.waterLevel != var1.waterLevel) {
            return false;
         } else if (this.dehSubMode != var1.dehSubMode) {
            return false;
         } else if (this.waterTankFailure != var1.waterTankFailure) {
            return false;
         } else if (this.smartSubMode != var1.smartSubMode) {
            return false;
         } else if (this.detectCat != var1.detectCat) {
            return false;
         } else if (this.bodyMounted != var1.bodyMounted) {
            return false;
         } else if (this.cleanAirEta != var1.cleanAirEta) {
            return false;
         } else if (this.panelDisplayMode != var1.panelDisplayMode) {
            return false;
         } else if (this.hoverEnabled != var1.hoverEnabled) {
            return false;
         } else if (this.airRefreshEnabled != var1.airRefreshEnabled) {
            return false;
         } else if (this.airRefreshStatus != var1.airRefreshStatus) {
            return false;
         } else if (this.airRefreshDuration != var1.airRefreshDuration) {
            return false;
         } else if (this.airRefreshTimeStamp != var1.airRefreshTimeStamp) {
            return false;
         } else if (this.airRefreshStartTimeStamp != var1.airRefreshStartTimeStamp) {
            return false;
         } else if (this.airRefreshEndTimeStamp != var1.airRefreshEndTimeStamp) {
            return false;
         } else if (this.roomType != var1.roomType) {
            return false;
         } else if (this.nightLampBrightness != var1.nightLampBrightness) {
            return false;
         } else if (this.wickdryDuration != var1.wickdryDuration) {
            return false;
         } else if (this.wickdryDone != var1.wickdryDone) {
            return false;
         } else if (!Intrinsics.areEqual(this.ywrmEnabled, var1.ywrmEnabled)) {
            return false;
         } else if (this.ywrmUsage != var1.ywrmUsage) {
            return false;
         } else if (this.nightLampSteplessBrightness != var1.nightLampSteplessBrightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarms, var1.alarms)) {
            return false;
         } else if (this.humSubMode != var1.humSubMode) {
            return false;
         } else if (this.use24Hour != var1.use24Hour) {
            return false;
         } else if (this.waterInfill != var1.waterInfill) {
            return false;
         } else if (this.sensorMode != var1.sensorMode) {
            return false;
         } else if (this.coolFanSpeedLevel != var1.coolFanSpeedLevel) {
            return false;
         } else if (this.coolAutoLevel != var1.coolAutoLevel) {
            return false;
         } else if (this.nightModeStartTime != var1.nightModeStartTime) {
            return false;
         } else if (!Intrinsics.areEqual(this.dualOscillationConfig, var1.dualOscillationConfig)) {
            return false;
         } else if (this.rpm1 != var1.rpm1) {
            return false;
         } else {
            return Intrinsics.areEqual(this.nightPeriods, var1.nightPeriods);
         }
      }
   }

   public final boolean getAimInstalled() {
      return this.aimInstalled;
   }

   public final int getAirRefreshDuration() {
      return this.airRefreshDuration;
   }

   public final boolean getAirRefreshEnabled() {
      return this.airRefreshEnabled;
   }

   public final int getAirRefreshEndTimeStamp() {
      return this.airRefreshEndTimeStamp;
   }

   public final int getAirRefreshStartTimeStamp() {
      return this.airRefreshStartTimeStamp;
   }

   public final int getAirRefreshStatus() {
      return this.airRefreshStatus;
   }

   public final int getAirRefreshTimeStamp() {
      return this.airRefreshTimeStamp;
   }

   public final List getAlarms() {
      return this.alarms;
   }

   public final int getApFanSpeed() {
      return this.apFanSpeed;
   }

   public final int getApSubMode() {
      return this.apSubMode;
   }

   public final String getAutoModeText() {
      return this.autoModeText;
   }

   public final int getAutoRh() {
      return this.autoRh;
   }

   public final boolean getBodyMounted() {
      return this.bodyMounted;
   }

   public final Integer getBrightness() {
      return this.brightness;
   }

   public final int getCleanAirEta() {
      return this.cleanAirEta;
   }

   public final String getCompatibility() {
      return this.compatibility;
   }

   public final int getConnectivityStatusIndex() {
      return this.connectivityStatusIndex;
   }

   public final int getCoolAutoLevel() {
      return this.coolAutoLevel;
   }

   public final double[] getCoolAutoPresets() {
      return this.coolAutoPresets;
   }

   public final int getCoolAutoTag() {
      return this.coolAutoTag;
   }

   public final double[] getCoolEcoPresets() {
      return this.coolEcoPresets;
   }

   public final int getCoolEcoTag() {
      return this.coolEcoTag;
   }

   public final int getCoolFanSpeed() {
      return this.coolFanSpeed;
   }

   public final int getCoolFanSpeedLevel() {
      return this.coolFanSpeedLevel;
   }

   public final int getCoolSubMode() {
      return this.coolSubMode;
   }

   public final String getDealerCountry() {
      return this.dealerCountry;
   }

   public final String getDealerName() {
      return this.dealerName;
   }

   public final int getDehSubMode() {
      return this.dehSubMode;
   }

   public final boolean getDetectCat() {
      return this.detectCat;
   }

   public final DeviceUuidEntity getDeviceUuid() {
      return this.deviceUuid;
   }

   public final Integer getDisinfectLeftTime() {
      return this.disinfectLeftTime;
   }

   public final Long getDisinfectLeftTimeUpdateTime() {
      return this.disinfectLeftTimeUpdateTime;
   }

   public final Boolean getDisinfection() {
      return this.disinfection;
   }

   public final DualOscillationConfig getDualOscillationConfig() {
      return this.dualOscillationConfig;
   }

   public final Integer getFanSpeed() {
      return this.fanSpeed;
   }

   public final Integer getFilterLife() {
      return this.filterLife;
   }

   public final String getFilterTrigger() {
      return this.filterTrigger;
   }

   public final String getFilterType() {
      return this.filterType;
   }

   public final String getG4NightModefilterTrigger() {
      return this.g4NightModefilterTrigger;
   }

   public final String getHardware() {
      return this.hardware;
   }

   public final boolean getHasFinishedOnboarding() {
      return this.hasFinishedOnboarding;
   }

   public final double[] getHchoRanges() {
      return this.hchoRanges;
   }

   public final double getHeatAutoTmp() {
      return this.heatAutoTmp;
   }

   public final double getHeatEcoTmp() {
      return this.heatEcoTmp;
   }

   public final int getHeatFanSpeed() {
      return this.heatFanSpeed;
   }

   public final int getHeatSubMode() {
      return this.heatSubMode;
   }

   public final boolean getHoverEnabled() {
      return this.hoverEnabled;
   }

   public final boolean getHumMode() {
      return this.humMode;
   }

   public final int getHumSubMode() {
      return this.humSubMode;
   }

   public final String getInfo() {
      return this.info;
   }

   public final long getLastConnectivityMillis() {
      return this.lastConnectivityMillis;
   }

   public final Integer getLastSelectedSensorType() {
      return this.lastSelectedSensorType;
   }

   public final IndoorDatapoint getLatestSensorDatapoint() {
      return this.latestSensorDatapoint;
   }

   public final String getLinkedDeviceUid() {
      return this.linkedDeviceUid;
   }

   public final String getLocationId() {
      return this.locationId;
   }

   public final String getMac() {
      return this.mac;
   }

   public final int getMainMode() {
      return this.mainMode;
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final int getMode() {
      return this.mode;
   }

   public final String getModelName() {
      return this.modelName;
   }

   public final String getName() {
      return this.name;
   }

   public final int getNightLampBrightness() {
      return this.nightLampBrightness;
   }

   public final int getNightLampSteplessBrightness() {
      return this.nightLampSteplessBrightness;
   }

   public final long getNightModeStartTime() {
      return this.nightModeStartTime;
   }

   public final double[] getNightPeriods() {
      return this.nightPeriods;
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

   public final int getOscillationState() {
      return this.oscillationState;
   }

   public final int getPanelDisplayMode() {
      return this.panelDisplayMode;
   }

   public final double[] getPm10Ranges() {
      return this.pm10Ranges;
   }

   public final double[] getPm1Ranges() {
      return this.pm1Ranges;
   }

   public final double[] getPm25Ranges() {
      return this.pm25Ranges;
   }

   public final String getPurchaseDate() {
      return this.purchaseDate;
   }

   public final int getRoomType() {
      return this.roomType;
   }

   public final int getRpm1() {
      return this.rpm1;
   }

   public final int getSensorMode() {
      return this.sensorMode;
   }

   public final String getSerial() {
      return this.serial;
   }

   public final String getSku() {
      return this.sku;
   }

   public final int getSmartSubMode() {
      return this.smartSubMode;
   }

   public final int getTemperatureUnit() {
      return this.temperatureUnit;
   }

   public final String getTimeZone() {
      return this.timeZone;
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

   public final int getTimerStatus() {
      return this.timerStatus;
   }

   public final int getTypeIndex() {
      return this.typeIndex;
   }

   public final String getUid() {
      return this.uid;
   }

   public final int getUpdateProgress() {
      return this.updateProgress;
   }

   public final boolean getUse24Hour() {
      return this.use24Hour;
   }

   public final double[] getVocRanges() {
      return this.vocRanges;
   }

   public final boolean getWaterInfill() {
      return this.waterInfill;
   }

   public final int getWaterLevel() {
      return this.waterLevel;
   }

   public final boolean getWaterShortage() {
      return this.waterShortage;
   }

   public final boolean getWaterTankFailure() {
      return this.waterTankFailure;
   }

   public final WelcomeHomeLocation getWelcomeHome() {
      return this.welcomeHome;
   }

   public final int getWickUsage() {
      return this.wickUsage;
   }

   public final boolean getWickdryDone() {
      return this.wickdryDone;
   }

   public final int getWickdryDuration() {
      return this.wickdryDuration;
   }

   public final boolean getWickdryEnabled() {
      return this.wickdryEnabled;
   }

   public final int getWickdryLeftTime() {
      return this.wickdryLeftTime;
   }

   public final long getWickdryLeftTimeUpdateTime() {
      return this.wickdryLeftTimeUpdateTime;
   }

   public final boolean getWickdryOn() {
      return this.wickdryOn;
   }

   public final String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public final Boolean getYwrmEnabled() {
      return this.ywrmEnabled;
   }

   public final int getYwrmUsage() {
      return this.ywrmUsage;
   }

   public int hashCode() {
      int var21 = this.uid.hashCode();
      int var19 = this.name.hashCode();
      int var20 = this.modelName.hashCode();
      int var22 = this.typeIndex;
      Integer var105 = this.fanSpeed;
      int var18 = 0;
      int var1;
      if (var105 == null) {
         var1 = 0;
      } else {
         var1 = var105.hashCode();
      }

      var105 = this.filterLife;
      int var2;
      if (var105 == null) {
         var2 = 0;
      } else {
         var2 = var105.hashCode();
      }

      String var107 = this.autoModeText;
      int var3;
      if (var107 == null) {
         var3 = 0;
      } else {
         var3 = var107.hashCode();
      }

      Integer var108 = this.brightness;
      int var4;
      if (var108 == null) {
         var4 = 0;
      } else {
         var4 = var108.hashCode();
      }

      String var109 = this.info;
      int var5;
      if (var109 == null) {
         var5 = 0;
      } else {
         var5 = var109.hashCode();
      }

      DeviceUuidEntity var110 = this.deviceUuid;
      int var6;
      if (var110 == null) {
         var6 = 0;
      } else {
         var6 = var110.hashCode();
      }

      int var23 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var111 = this.latestSensorDatapoint;
      int var7;
      if (var111 == null) {
         var7 = 0;
      } else {
         var7 = var111.hashCode();
      }

      Integer var112 = this.lastSelectedSensorType;
      int var8;
      if (var112 == null) {
         var8 = 0;
      } else {
         var8 = var112.hashCode();
      }

      int var25 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isAblDevice);
      int var26 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightModeOn);
      int var24 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      String var113 = this.linkedDeviceUid;
      int var9;
      if (var113 == null) {
         var9 = 0;
      } else {
         var9 = var113.hashCode();
      }

      int var29 = this.connectivityStatusIndex;
      int var33 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityMillis);
      int var27 = this.mac.hashCode();
      int var39 = this.mcuFirmware.hashCode();
      int var44 = this.wifiFirmware.hashCode();
      int var37 = this.hardware.hashCode();
      int var38 = this.timeZone.hashCode();
      int var50 = this.serial.hashCode();
      int var48 = this.purchaseDate.hashCode();
      int var31 = this.dealerName.hashCode();
      int var32 = this.dealerCountry.hashCode();
      int var36 = this.filterType.hashCode();
      int var42 = this.filterTrigger.hashCode();
      int var43 = Arrays.hashCode(this.pm1Ranges);
      int var51 = Arrays.hashCode(this.pm10Ranges);
      int var45 = Arrays.hashCode(this.pm25Ranges);
      int var35 = Arrays.hashCode(this.vocRanges);
      int var46 = Arrays.hashCode(this.hchoRanges);
      int var49 = this.updateProgress;
      int var34 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var40 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isEcoModeOn);
      int var28 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsModeOn);
      int var30 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsNightModeOn);
      int var47 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn);
      int var41 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isGermShieldOn);
      Boolean var114 = this.isGermShieldNightModeOn;
      int var10;
      if (var114 == null) {
         var10 = 0;
      } else {
         var10 = var114.hashCode();
      }

      int var52 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isSafetySwitchOn);
      int var53 = this.g4NightModefilterTrigger.hashCode();
      int var54 = AddDeviceState$$ExternalSyntheticBackport0.m(this.aimInstalled);
      String var115 = this.sku;
      int var11;
      if (var115 == null) {
         var11 = 0;
      } else {
         var11 = var115.hashCode();
      }

      var115 = this.compatibility;
      int var12;
      if (var115 == null) {
         var12 = 0;
      } else {
         var12 = var115.hashCode();
      }

      WelcomeHomeLocation var117 = this.welcomeHome;
      int var13;
      if (var117 == null) {
         var13 = 0;
      } else {
         var13 = var117.hashCode();
      }

      String var118 = this.locationId;
      int var14;
      if (var118 == null) {
         var14 = 0;
      } else {
         var14 = var118.hashCode();
      }

      Boolean var119 = this.disinfection;
      int var15;
      if (var119 == null) {
         var15 = 0;
      } else {
         var15 = var119.hashCode();
      }

      Integer var120 = this.disinfectLeftTime;
      int var16;
      if (var120 == null) {
         var16 = 0;
      } else {
         var16 = var120.hashCode();
      }

      Long var121 = this.disinfectLeftTimeUpdateTime;
      int var17;
      if (var121 == null) {
         var17 = 0;
      } else {
         var17 = var121.hashCode();
      }

      int var67 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled);
      int var82 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn);
      int var85 = this.wickdryLeftTime;
      int var87 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime);
      int var86 = this.wickUsage;
      int var88 = AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage);
      int var84 = this.autoRh;
      int var68 = this.timerStatus;
      int var63 = this.timerDuration;
      int var57 = this.timerLeftTime;
      int var64 = AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime);
      int var98 = this.temperatureUnit;
      int var91 = this.oscillationState;
      int var101 = this.oscillationAngle;
      int var79 = this.oscillationDirection;
      int var66 = this.oscillationFanSpeed;
      int var99 = this.mainMode;
      int var89 = this.apSubMode;
      int var55 = this.apFanSpeed;
      int var92 = this.heatSubMode;
      int var96 = this.heatFanSpeed;
      int var104 = AddDeviceState$$ExternalSyntheticBackport0.m(this.heatAutoTmp);
      int var78 = AddDeviceState$$ExternalSyntheticBackport0.m(this.heatEcoTmp);
      int var103 = this.coolSubMode;
      int var59 = this.coolFanSpeed;
      int var61 = this.coolAutoTag;
      int var60 = Arrays.hashCode(this.coolAutoPresets);
      int var94 = this.coolEcoTag;
      int var76 = Arrays.hashCode(this.coolEcoPresets);
      int var70 = AddDeviceState$$ExternalSyntheticBackport0.m(this.humMode);
      int var83 = this.mode;
      int var81 = this.waterLevel;
      int var74 = this.dehSubMode;
      int var71 = AddDeviceState$$ExternalSyntheticBackport0.m(this.waterTankFailure);
      int var72 = this.smartSubMode;
      int var58 = AddDeviceState$$ExternalSyntheticBackport0.m(this.detectCat);
      int var102 = AddDeviceState$$ExternalSyntheticBackport0.m(this.bodyMounted);
      int var69 = this.cleanAirEta;
      int var97 = this.panelDisplayMode;
      int var77 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hoverEnabled);
      int var90 = AddDeviceState$$ExternalSyntheticBackport0.m(this.airRefreshEnabled);
      int var100 = this.airRefreshStatus;
      int var93 = this.airRefreshDuration;
      int var80 = this.airRefreshTimeStamp;
      int var95 = this.airRefreshStartTimeStamp;
      int var56 = this.airRefreshEndTimeStamp;
      int var62 = this.roomType;
      int var73 = this.nightLampBrightness;
      int var65 = this.wickdryDuration;
      int var75 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryDone);
      Boolean var122 = this.ywrmEnabled;
      if (var122 != null) {
         var18 = var122.hashCode();
      }

      return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((var21 * 31 + var19) * 31 + var20) * 31 + var22) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var23) * 31 + var7) * 31 + var8) * 31 + var25) * 31 + var26) * 31 + var24) * 31 + var9) * 31 + var29) * 31 + var33) * 31 + var27) * 31 + var39) * 31 + var44) * 31 + var37) * 31 + var38) * 31 + var50) * 31 + var48) * 31 + var31) * 31 + var32) * 31 + var36) * 31 + var42) * 31 + var43) * 31 + var51) * 31 + var45) * 31 + var35) * 31 + var46) * 31 + var49) * 31 + var34) * 31 + var40) * 31 + var28) * 31 + var30) * 31 + var47) * 31 + var41) * 31 + var10) * 31 + var52) * 31 + var53) * 31 + var54) * 31 + var11) * 31 + var12) * 31 + var13) * 31 + var14) * 31 + var15) * 31 + var16) * 31 + var17) * 31 + var67) * 31 + var82) * 31 + var85) * 31 + var87) * 31 + var86) * 31 + var88) * 31 + var84) * 31 + var68) * 31 + var63) * 31 + var57) * 31 + var64) * 31 + var98) * 31 + var91) * 31 + var101) * 31 + var79) * 31 + var66) * 31 + var99) * 31 + var89) * 31 + var55) * 31 + var92) * 31 + var96) * 31 + var104) * 31 + var78) * 31 + var103) * 31 + var59) * 31 + var61) * 31 + var60) * 31 + var94) * 31 + var76) * 31 + var70) * 31 + var83) * 31 + var81) * 31 + var74) * 31 + var71) * 31 + var72) * 31 + var58) * 31 + var102) * 31 + var69) * 31 + var97) * 31 + var77) * 31 + var90) * 31 + var100) * 31 + var93) * 31 + var80) * 31 + var95) * 31 + var56) * 31 + var62) * 31 + var73) * 31 + var65) * 31 + var75) * 31 + var18) * 31 + this.ywrmUsage) * 31 + this.nightLampSteplessBrightness) * 31 + this.alarms.hashCode()) * 31 + this.humSubMode) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.use24Hour)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterInfill)) * 31 + this.sensorMode) * 31 + this.coolFanSpeedLevel) * 31 + this.coolAutoLevel) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.nightModeStartTime)) * 31 + this.dualOscillationConfig.hashCode()) * 31 + this.rpm1) * 31 + Arrays.hashCode(this.nightPeriods);
   }

   public final boolean isAblDevice() {
      return this.isAblDevice;
   }

   public final boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public final boolean isEcoModeOn() {
      return this.isEcoModeOn;
   }

   public final boolean isG4NightModeOn() {
      return this.isG4NightModeOn;
   }

   public final Boolean isGermShieldNightModeOn() {
      return this.isGermShieldNightModeOn;
   }

   public final boolean isGermShieldOn() {
      return this.isGermShieldOn;
   }

   public final boolean isHinsModeOn() {
      return this.isHinsModeOn;
   }

   public final boolean isHinsNightModeOn() {
      return this.isHinsNightModeOn;
   }

   public final boolean isNightModeOn() {
      return this.isNightModeOn;
   }

   public final boolean isSafetySwitchOn() {
      return this.isSafetySwitchOn;
   }

   public final boolean isStandByOn() {
      return this.isStandByOn;
   }

   public final Device toDevice() {
      Integer var28 = this.brightness;
      int var1;
      if (var28 != null) {
         var1 = var28;
      } else {
         var1 = 0;
      }

      var28 = this.fanSpeed;
      int var2;
      if (var28 != null) {
         var2 = var28;
      } else {
         var2 = 0;
      }

      Integer var30 = this.filterLife;
      var28 = this.lastSelectedSensorType;
      int var3;
      if (var28 != null) {
         var3 = var28;
      } else {
         var3 = 0;
      }

      String var29 = this.autoModeText;
      String var128 = var29;
      if (var29 == null) {
         var128 = "";
      }

      Timber.Forest var31 = Timber.Forest;
      StringBuilder var129 = new StringBuilder("ToDevice: DeviceType == ");
      var129.append(this.typeIndex);
      var129.append(" for ");
      var129.append(this);
      var129.append('.');
      var31.v(var129.toString(), new Object[0]);
      DeviceType var130 = DeviceType.Companion.fromIndex(this.typeIndex);
      if (Intrinsics.areEqual(var130, DeviceType.Unknown.INSTANCE)) {
         return new DeviceUnknown(this.sku, this.uid, this.name, this.modelName, this.typeIndex, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.updateProgress);
      } else if (Intrinsics.areEqual(var130, DeviceType.Classic.INSTANCE)) {
         return new DeviceClassic(this.uid, this.name, var2, var30, var1, var128, this.info, this.latestSensorDatapoint, var3, this.isNightModeOn, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.modelName, this.aimInstalled, this.compatibility);
      } else if (Intrinsics.areEqual(var130, DeviceType.ClassicWithoutSensor.INSTANCE)) {
         return new DeviceClassicWithoutSensors(this.uid, this.name, var2, var30, var1, var128, this.info, this.isNightModeOn, this.isChildLockOn, this.linkedDeviceUid, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.updateProgress, this.modelName, this.compatibility);
      } else if (Intrinsics.areEqual(var130, DeviceType.NewClassic.INSTANCE)) {
         String var184 = this.uid;
         String var314 = this.name;
         String var301 = this.info;
         boolean var112 = this.isChildLockOn;
         int var66 = this.connectivityStatusIndex;
         long var96 = this.lastConnectivityMillis;
         String var236 = this.mac;
         String var197 = this.mcuFirmware;
         String var223 = this.wifiFirmware;
         String var275 = this.hardware;
         String var171 = this.timeZone;
         String var158 = this.serial;
         String var262 = this.purchaseDate;
         String var288 = this.dealerName;
         String var249 = this.dealerCountry;
         String var210 = this.filterType;
         String var144 = this.filterTrigger;
         return new DeviceNewClassic(var184, var314, var2, var30, var1, var128, var301, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var112, var66, var96, var236, var197, var223, var275, var171, var158, var262, var288, var249, var210, var144, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isEcoModeOn, this.isHinsModeOn, this.isHinsNightModeOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 64, (DefaultConstructorMarker)null);
      } else if (Intrinsics.areEqual(var130, DeviceType.G4.INSTANCE)) {
         String var143 = this.uid;
         String var313 = this.name;
         String var183 = this.info;
         boolean var111 = this.isChildLockOn;
         int var69 = this.connectivityStatusIndex;
         long var95 = this.lastConnectivityMillis;
         String var300 = this.mac;
         String var332 = this.mcuFirmware;
         String var261 = this.wifiFirmware;
         String var196 = this.hardware;
         String var274 = this.timeZone;
         String var235 = this.serial;
         String var209 = this.purchaseDate;
         String var222 = this.dealerName;
         String var320 = this.dealerCountry;
         String var248 = this.filterType;
         String var335 = this.filterTrigger;
         boolean var115 = this.hasFinishedOnboarding;
         IndoorDatapoint var329 = this.latestSensorDatapoint;
         double[] var317 = this.pm1Ranges;
         double[] var157 = this.pm10Ranges;
         double[] var287 = this.pm25Ranges;
         double[] var170 = this.vocRanges;
         double[] var323 = this.hchoRanges;
         int var65 = this.updateProgress;
         boolean var123 = this.isStandByOn;
         boolean var121 = this.isG4NightModeOn;
         boolean var118 = this.isGermShieldOn;
         Boolean var326 = this.isGermShieldNightModeOn;
         boolean var125 = this.isSafetySwitchOn;
         return new DeviceG4(var143, var313, var2, var30, var1, var128, var183, (DeviceUuid)null, var115, var329, var3, var111, var69, var95, var300, var332, var261, var196, var274, var235, var209, var222, var320, var248, var335, var317, var157, var287, var170, var323, var65, var123, var121, var118, var326, this.g4NightModefilterTrigger, var125, this.modelName, 0, this.sku, this.welcomeHome, this.disinfection, this.disinfectLeftTime, this.disinfectLeftTimeUpdateTime, 128, 64, (DefaultConstructorMarker)null);
      } else if (Intrinsics.areEqual(var130, DeviceType.B4.INSTANCE)) {
         String var260 = this.uid;
         String var286 = this.name;
         String var208 = this.info;
         boolean var110 = this.isChildLockOn;
         int var64 = this.connectivityStatusIndex;
         long var94 = this.lastConnectivityMillis;
         String var142 = this.mac;
         String var247 = this.mcuFirmware;
         String var156 = this.wifiFirmware;
         String var299 = this.hardware;
         String var221 = this.timeZone;
         String var169 = this.serial;
         String var195 = this.purchaseDate;
         String var182 = this.dealerName;
         String var234 = this.dealerCountry;
         String var312 = this.filterType;
         String var273 = this.filterTrigger;
         return new DeviceB4(var260, var286, var2, var30, var1, var128, var208, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var110, var64, var94, var142, var247, var156, var299, var221, var169, var195, var182, var234, var312, var273, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker)null);
      } else if (Intrinsics.areEqual(var130, DeviceType.B4sp.INSTANCE)) {
         String var259 = this.uid;
         String var298 = this.name;
         String var311 = this.info;
         boolean var109 = this.isChildLockOn;
         int var63 = this.connectivityStatusIndex;
         long var93 = this.lastConnectivityMillis;
         String var233 = this.mac;
         String var207 = this.mcuFirmware;
         String var272 = this.wifiFirmware;
         String var246 = this.hardware;
         String var141 = this.timeZone;
         String var181 = this.serial;
         String var194 = this.purchaseDate;
         String var155 = this.dealerName;
         String var220 = this.dealerCountry;
         String var285 = this.filterType;
         String var168 = this.filterTrigger;
         return new DeviceB4sp(var259, var298, var2, var30, var1, var128, var311, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var109, var63, var93, var233, var207, var272, var246, var141, var181, var194, var155, var220, var285, var168, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker)null);
      } else if (!Intrinsics.areEqual(var130, DeviceType.Blue.INSTANCE) && !Intrinsics.areEqual(var130, DeviceType.BluePremium.INSTANCE)) {
         if (Intrinsics.areEqual(var130, DeviceType.Aware.INSTANCE)) {
            return new DeviceAware(this.uid, this.name, var1, this.info, this.latestSensorDatapoint, var3, this.isNightModeOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.compatibility);
         } else if (Intrinsics.areEqual(var130, DeviceType.Sense.INSTANCE)) {
            return new DeviceSense(this.uid, this.name, var2, var30, var1, var128, this.info, this.isChildLockOn, this.linkedDeviceUid, this.isNightModeOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterType, this.filterTrigger, this.updateProgress, this.compatibility);
         } else if (Intrinsics.areEqual(var130, DeviceType.Icp.INSTANCE)) {
            return new DeviceIcp(this.uid, this.name, var2, var30, var128, this.info, this.latestSensorDatapoint, var3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.filterTrigger, (String)null, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.compatibility, 2097152, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Humidifier.INSTANCE)) {
            String var271 = this.uid;
            String var140 = this.name;
            String var232 = this.info;
            boolean var108 = this.isChildLockOn;
            int var62 = this.connectivityStatusIndex;
            long var92 = this.lastConnectivityMillis;
            String var219 = this.mac;
            String var258 = this.mcuFirmware;
            String var180 = this.wifiFirmware;
            String var310 = this.hardware;
            String var167 = this.timeZone;
            String var154 = this.serial;
            String var193 = this.purchaseDate;
            String var206 = this.dealerName;
            String var245 = this.dealerCountry;
            String var284 = this.filterType;
            String var297 = this.filterTrigger;
            return new DeviceHumidifier(var271, var140, var2, var30, var1, var128, var232, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var108, var62, var92, var219, var258, var180, var310, var167, var154, var193, var206, var245, var284, var297, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.autoRh, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Combo2in1.INSTANCE)) {
            String var309 = this.uid;
            String var231 = this.name;
            String var328 = this.info;
            boolean var124 = this.isChildLockOn;
            int var83 = this.connectivityStatusIndex;
            long var98 = this.lastConnectivityMillis;
            String var179 = this.mac;
            String var139 = this.mcuFirmware;
            String var153 = this.wifiFirmware;
            String var166 = this.hardware;
            String var331 = this.timeZone;
            String var319 = this.serial;
            String var283 = this.purchaseDate;
            String var316 = this.dealerName;
            String var334 = this.dealerCountry;
            String var244 = this.filterType;
            String var337 = this.filterTrigger;
            boolean var120 = this.hasFinishedOnboarding;
            IndoorDatapoint var205 = this.latestSensorDatapoint;
            double[] var257 = this.pm1Ranges;
            double[] var325 = this.pm10Ranges;
            double[] var339 = this.pm25Ranges;
            double[] var296 = this.vocRanges;
            double[] var322 = this.hchoRanges;
            int var68 = this.updateProgress;
            boolean var117 = this.isStandByOn;
            String var192 = this.modelName;
            String var218 = this.sku;
            WelcomeHomeLocation var270 = this.welcomeHome;
            boolean var114 = this.wickdryEnabled;
            boolean var107 = this.wickdryOn;
            int var81 = this.wickdryLeftTime;
            long var99 = this.wickdryLeftTimeUpdateTime;
            int var61 = this.wickUsage;
            boolean var122 = this.waterShortage;
            int var79 = this.autoRh;
            int var75 = this.timerStatus;
            int var77 = this.timerDuration;
            int var73 = this.timerLeftTime;
            long var91 = this.timerLeftTimeUpdateTime;
            String var340 = this.locationId;
            int var71 = this.waterLevel;
            return new DeviceCombo2in1(var309, var231, var2, var30, var1, var128, var328, (DeviceUuid)null, var120, var205, var3, var124, var83, var98, var179, var139, var153, var166, var331, var319, var283, var316, var334, var244, var337, var257, var325, var339, var296, var322, var68, var117, var192, 0, var218, var270, var114, var107, var81, var99, var61, var122, var79, var75, var77, var73, var91, var340, this.mode, this.humMode, var71, 128, 2, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Combo2in120.INSTANCE)) {
            String var282 = this.uid;
            String var308 = this.name;
            String var338 = this.info;
            boolean var119 = this.isChildLockOn;
            int var78 = this.connectivityStatusIndex;
            long var90 = this.lastConnectivityMillis;
            String var318 = this.mac;
            String var315 = this.mcuFirmware;
            String var295 = this.wifiFirmware;
            String var165 = this.hardware;
            String var336 = this.timeZone;
            String var204 = this.serial;
            String var230 = this.purchaseDate;
            String var256 = this.dealerName;
            String var324 = this.dealerCountry;
            String var243 = this.filterType;
            String var178 = this.filterTrigger;
            boolean var27 = this.hasFinishedOnboarding;
            IndoorDatapoint var269 = this.latestSensorDatapoint;
            double[] var138 = this.pm1Ranges;
            double[] var330 = this.pm10Ranges;
            double[] var333 = this.pm25Ranges;
            double[] var217 = this.vocRanges;
            double[] var327 = this.hchoRanges;
            int var15 = this.updateProgress;
            boolean var106 = this.isStandByOn;
            String var191 = this.modelName;
            String var321 = this.sku;
            WelcomeHomeLocation var152 = this.welcomeHome;
            boolean var113 = this.wickdryEnabled;
            boolean var116 = this.wickdryOn;
            int var72 = this.wickdryLeftTime;
            long var20 = this.wickdryLeftTimeUpdateTime;
            int var80 = this.wickUsage;
            boolean var26 = this.waterShortage;
            int var70 = this.autoRh;
            int var74 = this.timerStatus;
            int var60 = this.timerDuration;
            int var13 = this.timerLeftTime;
            long var97 = this.timerLeftTimeUpdateTime;
            int var82 = this.waterLevel;
            int var76 = this.mainMode;
            int var67 = this.apSubMode;
            int var14 = this.humSubMode;
            return new DeviceCombo2in120(var282, var308, var2, var30, var1, var128, var338, (DeviceUuid)null, var27, var269, var3, var119, var78, var90, var318, var315, var295, var165, var336, var204, var230, var256, var324, var243, var178, var138, var330, var333, var217, var327, var15, var106, var191, 0, var321, var152, var113, var116, var72, var20, var80, var26, var70, var74, var60, var13, var97, var82, this.nightLampBrightness, this.wickdryDuration, this.wickdryDone, this.ywrmEnabled, this.ywrmUsage, var76, var67, var14, this.waterTankFailure, this.isSafetySwitchOn, this.waterInfill, 128, 2, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Combo3in1.INSTANCE)) {
            String var151 = this.uid;
            String var164 = this.name;
            String var177 = this.info;
            boolean var105 = this.isChildLockOn;
            int var59 = this.connectivityStatusIndex;
            long var89 = this.lastConnectivityMillis;
            String var216 = this.mac;
            String var242 = this.mcuFirmware;
            String var294 = this.wifiFirmware;
            String var307 = this.hardware;
            String var137 = this.timeZone;
            String var281 = this.serial;
            String var255 = this.purchaseDate;
            String var203 = this.dealerName;
            String var190 = this.dealerCountry;
            String var229 = this.filterType;
            String var268 = this.filterTrigger;
            return new DeviceCombo3in1(var151, var164, var2, var30, var1, var128, var177, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var105, var59, var89, var216, var242, var294, var307, var137, var281, var255, var203, var190, var229, var268, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.temperatureUnit, this.oscillationState, this.oscillationAngle, this.oscillationDirection, this.oscillationFanSpeed, this.mainMode, this.apSubMode, this.apFanSpeed, this.heatSubMode, this.heatFanSpeed, this.heatAutoTmp, this.heatEcoTmp, this.coolSubMode, this.coolFanSpeed, this.coolAutoTag, this.coolAutoPresets, this.coolEcoTag, this.coolEcoPresets, this.locationId, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Dehumidifier.INSTANCE)) {
            String var215 = this.uid;
            String var267 = this.name;
            String var293 = this.info;
            boolean var104 = this.isChildLockOn;
            int var58 = this.connectivityStatusIndex;
            long var88 = this.lastConnectivityMillis;
            String var202 = this.mac;
            String var189 = this.mcuFirmware;
            String var150 = this.wifiFirmware;
            String var241 = this.hardware;
            String var228 = this.timeZone;
            String var136 = this.serial;
            String var176 = this.purchaseDate;
            String var163 = this.dealerName;
            String var306 = this.dealerCountry;
            String var254 = this.filterType;
            String var280 = this.filterTrigger;
            return new DeviceDehumidifier(var215, var267, var2, var30, var1, var128, var293, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var104, var58, var88, var202, var189, var150, var241, var228, var136, var176, var163, var306, var254, var280, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.autoRh, this.mainMode, this.apSubMode, this.dehSubMode, this.waterLevel, this.waterTankFailure, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Pet20.INSTANCE)) {
            String var292 = this.uid;
            String var162 = this.name;
            String var266 = this.info;
            boolean var103 = this.isChildLockOn;
            int var57 = this.connectivityStatusIndex;
            long var87 = this.lastConnectivityMillis;
            String var253 = this.mac;
            String var305 = this.mcuFirmware;
            String var201 = this.wifiFirmware;
            String var149 = this.hardware;
            String var214 = this.timeZone;
            String var227 = this.serial;
            String var135 = this.purchaseDate;
            String var175 = this.dealerName;
            String var240 = this.dealerCountry;
            String var188 = this.filterType;
            String var279 = this.filterTrigger;
            return new DevicePet20(var292, var162, var2, var30, var1, var128, var266, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var103, var57, var87, var253, var305, var201, var149, var214, var227, var135, var175, var240, var188, var279, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.mainMode, this.apSubMode, this.smartSubMode, this.detectCat, this.bodyMounted, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Blue40.INSTANCE)) {
            String var161 = this.uid;
            String var174 = this.name;
            String var304 = this.info;
            boolean var24 = this.isChildLockOn;
            int var7 = this.connectivityStatusIndex;
            long var86 = this.lastConnectivityMillis;
            String var278 = this.mac;
            String var148 = this.mcuFirmware;
            String var45 = this.wifiFirmware;
            String var48 = this.hardware;
            String var239 = this.timeZone;
            String var134 = this.serial;
            String var200 = this.purchaseDate;
            String var52 = this.dealerName;
            String var226 = this.dealerCountry;
            String var47 = this.filterType;
            String var49 = this.filterTrigger;
            boolean var23 = this.hasFinishedOnboarding;
            IndoorDatapoint var53 = this.latestSensorDatapoint;
            double[] var252 = this.pm1Ranges;
            double[] var291 = this.pm10Ranges;
            double[] var50 = this.pm25Ranges;
            double[] var187 = this.vocRanges;
            double[] var51 = this.hchoRanges;
            int var8 = this.updateProgress;
            boolean var25 = this.isStandByOn;
            boolean var102 = this.isG4NightModeOn;
            String var44 = this.g4NightModefilterTrigger;
            String var46 = this.modelName;
            String var213 = this.sku;
            WelcomeHomeLocation var265 = this.welcomeHome;
            int var6 = this.timerStatus;
            int var10 = this.timerDuration;
            int var12 = this.timerLeftTime;
            long var18 = this.timerLeftTimeUpdateTime;
            int var11 = this.mainMode;
            int var56 = this.apSubMode;
            int var9 = this.cleanAirEta;
            int var5 = this.panelDisplayMode;
            return new DeviceBlue40(var161, var174, var2, var30, var1, var128, var304, (DeviceUuid)null, var23, var53, var3, var24, var7, var86, var278, var148, var45, var48, var239, var134, var200, var52, var226, var47, var49, var252, var291, var50, var187, var51, var8, var25, var102, var44, var46, 0, var213, var265, var6, var10, var12, var18, var11, var56, var9, this.hoverEnabled, var5, this.airRefreshEnabled, this.airRefreshStatus, this.airRefreshDuration, this.airRefreshTimeStamp, this.airRefreshStartTimeStamp, this.airRefreshEndTimeStamp, this.roomType, this.sensorMode, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.Humidifier20.INSTANCE)) {
            String var225 = this.uid;
            String var277 = this.name;
            String var238 = this.info;
            boolean var101 = this.isChildLockOn;
            int var55 = this.connectivityStatusIndex;
            long var85 = this.lastConnectivityMillis;
            String var160 = this.mac;
            String var133 = this.mcuFirmware;
            String var199 = this.wifiFirmware;
            String var147 = this.hardware;
            String var290 = this.timeZone;
            String var264 = this.serial;
            String var212 = this.purchaseDate;
            String var186 = this.dealerName;
            String var173 = this.dealerCountry;
            String var303 = this.filterType;
            String var251 = this.filterTrigger;
            return new DeviceHumidifier20(var225, var277, var2, var30, var1, var128, var238, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var101, var55, var85, var160, var133, var199, var147, var290, var264, var212, var186, var173, var303, var251, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.wickdryEnabled, this.wickdryOn, this.wickdryLeftTime, this.wickdryLeftTimeUpdateTime, this.wickUsage, this.waterShortage, this.waterLevel, this.nightLampBrightness, this.wickdryDuration, this.wickdryDone, this.autoRh, this.ywrmEnabled, this.ywrmUsage, 128, 8, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.MiniRestful.INSTANCE)) {
            String var132 = this.uid;
            String var146 = this.name;
            String var289 = this.info;
            boolean var100 = this.isChildLockOn;
            var3 = this.connectivityStatusIndex;
            long var84 = this.lastConnectivityMillis;
            String var237 = this.mac;
            String var185 = this.mcuFirmware;
            String var302 = this.wifiFirmware;
            String var224 = this.hardware;
            String var263 = this.timeZone;
            String var198 = this.serial;
            String var159 = this.purchaseDate;
            String var276 = this.dealerName;
            String var211 = this.dealerCountry;
            String var172 = this.filterType;
            String var250 = this.filterTrigger;
            return new DeviceMiniRestful(var132, var146, var2, var30, var1, var128, var289, (DeviceUuid)null, this.hasFinishedOnboarding, var100, var3, var84, var237, var185, var302, var224, var263, var198, var159, var276, var211, var172, var250, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.mainMode, this.apSubMode, this.nightLampSteplessBrightness, this.alarms, this.use24Hour, 67108992, 0, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.FanTable.INSTANCE)) {
            return new DeviceFanTable(this.uid, this.name, var1, this.info, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.temperatureUnit, this.mainMode, this.apSubMode, this.coolSubMode, this.coolFanSpeedLevel, this.coolAutoLevel, this.nightModeStartTime, this.dualOscillationConfig, this.rpm1, this.nightPeriods, 268435472, 0, (DefaultConstructorMarker)null);
         } else if (Intrinsics.areEqual(var130, DeviceType.FanPremium.INSTANCE)) {
            return new DeviceFanPremium(this.uid, this.name, var1, this.info, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, this.isChildLockOn, this.connectivityStatusIndex, this.lastConnectivityMillis, this.mac, this.mcuFirmware, this.wifiFirmware, this.hardware, this.timeZone, this.serial, this.purchaseDate, this.dealerName, this.dealerCountry, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.modelName, 0, this.sku, this.timerStatus, this.timerDuration, this.timerLeftTime, this.timerLeftTimeUpdateTime, this.temperatureUnit, this.mainMode, this.apSubMode, this.coolSubMode, this.coolFanSpeedLevel, this.coolAutoLevel, this.nightModeStartTime, this.dualOscillationConfig, this.rpm1, this.nightPeriods, 268435472, 0, (DefaultConstructorMarker)null);
         } else {
            throw new NoWhenBranchMatchedException();
         }
      } else {
         String var38 = this.uid;
         String var40 = this.name;
         String var43 = this.info;
         boolean var22 = this.isChildLockOn;
         int var4 = this.connectivityStatusIndex;
         long var16 = this.lastConnectivityMillis;
         String var37 = this.mac;
         String var41 = this.mcuFirmware;
         String var145 = this.wifiFirmware;
         String var33 = this.hardware;
         String var32 = this.timeZone;
         String var131 = this.serial;
         String var34 = this.purchaseDate;
         String var39 = this.dealerName;
         String var42 = this.dealerCountry;
         String var36 = this.filterType;
         String var35 = this.filterTrigger;
         return new DeviceBlue(var38, var40, var2, var30, var1, var128, var43, (DeviceUuid)null, this.hasFinishedOnboarding, this.latestSensorDatapoint, var3, var22, var4, var16, var37, var41, var145, var33, var32, var131, var34, var39, var42, var36, var35, this.pm1Ranges, this.pm10Ranges, this.pm25Ranges, this.vocRanges, this.hchoRanges, this.updateProgress, this.isStandByOn, this.isG4NightModeOn, this.g4NightModefilterTrigger, this.modelName, 0, this.sku, this.welcomeHome, 128, 8, (DefaultConstructorMarker)null);
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceEntity(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", fanSpeed=");
      var1.append(this.fanSpeed);
      var1.append(", filterLife=");
      var1.append(this.filterLife);
      var1.append(", autoModeText=");
      var1.append(this.autoModeText);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(", deviceUuid=");
      var1.append(this.deviceUuid);
      var1.append(", hasFinishedOnboarding=");
      var1.append(this.hasFinishedOnboarding);
      var1.append(", latestSensorDatapoint=");
      var1.append(this.latestSensorDatapoint);
      var1.append(", lastSelectedSensorType=");
      var1.append(this.lastSelectedSensorType);
      var1.append(", isAblDevice=");
      var1.append(this.isAblDevice);
      var1.append(", isNightModeOn=");
      var1.append(this.isNightModeOn);
      var1.append(", isChildLockOn=");
      var1.append(this.isChildLockOn);
      var1.append(", linkedDeviceUid=");
      var1.append(this.linkedDeviceUid);
      var1.append(", connectivityStatusIndex=");
      var1.append(this.connectivityStatusIndex);
      var1.append(", lastConnectivityMillis=");
      var1.append(this.lastConnectivityMillis);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", hardware=");
      var1.append(this.hardware);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", serial=");
      var1.append(this.serial);
      var1.append(", purchaseDate=");
      var1.append(this.purchaseDate);
      var1.append(", dealerName=");
      var1.append(this.dealerName);
      var1.append(", dealerCountry=");
      var1.append(this.dealerCountry);
      var1.append(", filterType=");
      var1.append(this.filterType);
      var1.append(", filterTrigger=");
      var1.append(this.filterTrigger);
      var1.append(", pm1Ranges=");
      var1.append(Arrays.toString(this.pm1Ranges));
      var1.append(", pm10Ranges=");
      var1.append(Arrays.toString(this.pm10Ranges));
      var1.append(", pm25Ranges=");
      var1.append(Arrays.toString(this.pm25Ranges));
      var1.append(", vocRanges=");
      var1.append(Arrays.toString(this.vocRanges));
      var1.append(", hchoRanges=");
      var1.append(Arrays.toString(this.hchoRanges));
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(", isStandByOn=");
      var1.append(this.isStandByOn);
      var1.append(", isEcoModeOn=");
      var1.append(this.isEcoModeOn);
      var1.append(", isHinsModeOn=");
      var1.append(this.isHinsModeOn);
      var1.append(", isHinsNightModeOn=");
      var1.append(this.isHinsNightModeOn);
      var1.append(", isG4NightModeOn=");
      var1.append(this.isG4NightModeOn);
      var1.append(", isGermShieldOn=");
      var1.append(this.isGermShieldOn);
      var1.append(", isGermShieldNightModeOn=");
      var1.append(this.isGermShieldNightModeOn);
      var1.append(", isSafetySwitchOn=");
      var1.append(this.isSafetySwitchOn);
      var1.append(", g4NightModefilterTrigger=");
      var1.append(this.g4NightModefilterTrigger);
      var1.append(", aimInstalled=");
      var1.append(this.aimInstalled);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", compatibility=");
      var1.append(this.compatibility);
      var1.append(", welcomeHome=");
      var1.append(this.welcomeHome);
      var1.append(", locationId=");
      var1.append(this.locationId);
      var1.append(", disinfection=");
      var1.append(this.disinfection);
      var1.append(", disinfectLeftTime=");
      var1.append(this.disinfectLeftTime);
      var1.append(", disinfectLeftTimeUpdateTime=");
      var1.append(this.disinfectLeftTimeUpdateTime);
      var1.append(", wickdryEnabled=");
      var1.append(this.wickdryEnabled);
      var1.append(", wickdryOn=");
      var1.append(this.wickdryOn);
      var1.append(", wickdryLeftTime=");
      var1.append(this.wickdryLeftTime);
      var1.append(", wickdryLeftTimeUpdateTime=");
      var1.append(this.wickdryLeftTimeUpdateTime);
      var1.append(", wickUsage=");
      var1.append(this.wickUsage);
      var1.append(", waterShortage=");
      var1.append(this.waterShortage);
      var1.append(", autoRh=");
      var1.append(this.autoRh);
      var1.append(", timerStatus=");
      var1.append(this.timerStatus);
      var1.append(", timerDuration=");
      var1.append(this.timerDuration);
      var1.append(", timerLeftTime=");
      var1.append(this.timerLeftTime);
      var1.append(", timerLeftTimeUpdateTime=");
      var1.append(this.timerLeftTimeUpdateTime);
      var1.append(", temperatureUnit=");
      var1.append(this.temperatureUnit);
      var1.append(", oscillationState=");
      var1.append(this.oscillationState);
      var1.append(", oscillationAngle=");
      var1.append(this.oscillationAngle);
      var1.append(", oscillationDirection=");
      var1.append(this.oscillationDirection);
      var1.append(", oscillationFanSpeed=");
      var1.append(this.oscillationFanSpeed);
      var1.append(", mainMode=");
      var1.append(this.mainMode);
      var1.append(", apSubMode=");
      var1.append(this.apSubMode);
      var1.append(", apFanSpeed=");
      var1.append(this.apFanSpeed);
      var1.append(", heatSubMode=");
      var1.append(this.heatSubMode);
      var1.append(", heatFanSpeed=");
      var1.append(this.heatFanSpeed);
      var1.append(", heatAutoTmp=");
      var1.append(this.heatAutoTmp);
      var1.append(", heatEcoTmp=");
      var1.append(this.heatEcoTmp);
      var1.append(", coolSubMode=");
      var1.append(this.coolSubMode);
      var1.append(", coolFanSpeed=");
      var1.append(this.coolFanSpeed);
      var1.append(", coolAutoTag=");
      var1.append(this.coolAutoTag);
      var1.append(", coolAutoPresets=");
      var1.append(Arrays.toString(this.coolAutoPresets));
      var1.append(", coolEcoTag=");
      var1.append(this.coolEcoTag);
      var1.append(", coolEcoPresets=");
      var1.append(Arrays.toString(this.coolEcoPresets));
      var1.append(", humMode=");
      var1.append(this.humMode);
      var1.append(", mode=");
      var1.append(this.mode);
      var1.append(", waterLevel=");
      var1.append(this.waterLevel);
      var1.append(", dehSubMode=");
      var1.append(this.dehSubMode);
      var1.append(", waterTankFailure=");
      var1.append(this.waterTankFailure);
      var1.append(", smartSubMode=");
      var1.append(this.smartSubMode);
      var1.append(", detectCat=");
      var1.append(this.detectCat);
      var1.append(", bodyMounted=");
      var1.append(this.bodyMounted);
      var1.append(", cleanAirEta=");
      var1.append(this.cleanAirEta);
      var1.append(", panelDisplayMode=");
      var1.append(this.panelDisplayMode);
      var1.append(", hoverEnabled=");
      var1.append(this.hoverEnabled);
      var1.append(", airRefreshEnabled=");
      var1.append(this.airRefreshEnabled);
      var1.append(", airRefreshStatus=");
      var1.append(this.airRefreshStatus);
      var1.append(", airRefreshDuration=");
      var1.append(this.airRefreshDuration);
      var1.append(", airRefreshTimeStamp=");
      var1.append(this.airRefreshTimeStamp);
      var1.append(", airRefreshStartTimeStamp=");
      var1.append(this.airRefreshStartTimeStamp);
      var1.append(", airRefreshEndTimeStamp=");
      var1.append(this.airRefreshEndTimeStamp);
      var1.append(", roomType=");
      var1.append(this.roomType);
      var1.append(", nightLampBrightness=");
      var1.append(this.nightLampBrightness);
      var1.append(", wickdryDuration=");
      var1.append(this.wickdryDuration);
      var1.append(", wickdryDone=");
      var1.append(this.wickdryDone);
      var1.append(", ywrmEnabled=");
      var1.append(this.ywrmEnabled);
      var1.append(", ywrmUsage=");
      var1.append(this.ywrmUsage);
      var1.append(", nightLampSteplessBrightness=");
      var1.append(this.nightLampSteplessBrightness);
      var1.append(", alarms=");
      var1.append(this.alarms);
      var1.append(", humSubMode=");
      var1.append(this.humSubMode);
      var1.append(", use24Hour=");
      var1.append(this.use24Hour);
      var1.append(", waterInfill=");
      var1.append(this.waterInfill);
      var1.append(", sensorMode=");
      var1.append(this.sensorMode);
      var1.append(", coolFanSpeedLevel=");
      var1.append(this.coolFanSpeedLevel);
      var1.append(", coolAutoLevel=");
      var1.append(this.coolAutoLevel);
      var1.append(", nightModeStartTime=");
      var1.append(this.nightModeStartTime);
      var1.append(", dualOscillationConfig=");
      var1.append(this.dualOscillationConfig);
      var1.append(", rpm1=");
      var1.append(this.rpm1);
      var1.append(", nightPeriods=");
      var1.append(Arrays.toString(this.nightPeriods));
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"},
      d2 = {"Lcom/blueair/database/entity/DeviceEntity$Companion;", "", "<init>", "()V", "DEVICE_TABLE", "", "NULL_ALARM_LIST", "", "Lcom/blueair/core/model/DeviceAlarm;", "getNULL_ALARM_LIST", "()Ljava/util/List;", "fromDevice", "Lcom/blueair/database/entity/DeviceEntity;", "device", "Lcom/blueair/core/model/Device;", "existingDevice", "fromDeviceOnAblServer", "deviceOnAbl", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "fromDeviceOnBlueServer", "deviceOnBlueServer", "Lcom/blueair/core/model/DeviceOnBlueServer;", "useProtect", "", "isLatestConnectivityState", "nuLastConnectivityMillis", "", "oldLastConnectivityMillis", "(JLjava/lang/Long;)Z", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static DeviceEntity fromDevice$default(Companion var0, Device var1, DeviceEntity var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.fromDevice(var1, var2);
      }

      // $FF: synthetic method
      public static DeviceEntity fromDeviceOnAblServer$default(Companion var0, DeviceDetailsOnAblServer var1, DeviceEntity var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.fromDeviceOnAblServer(var1, var2);
      }

      // $FF: synthetic method
      public static DeviceEntity fromDeviceOnBlueServer$default(Companion var0, DeviceOnBlueServer var1, DeviceEntity var2, boolean var3, int var4, Object var5) {
         if ((var4 & 2) != 0) {
            var2 = null;
         }

         return var0.fromDeviceOnBlueServer(var1, var2, var3);
      }

      private final boolean isLatestConnectivityState(long var1, Long var3) {
         if (var3 != null) {
            return var1 >= var3;
         } else {
            return true;
         }
      }

      public final DeviceEntity fromDevice(Device var1, DeviceEntity var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         KProperty1 var85 = (KProperty1)null.INSTANCE;
         boolean var60 = var1 instanceof HasBlueProvisionCalls;
         Object var150;
         if (var60) {
            var150 = var85.get(var1);
         } else {
            var150 = null;
         }

         DeviceUuid var151 = (DeviceUuid)var150;
         DeviceUuidEntity var152;
         if (var151 != null) {
            var152 = DeviceUuidEntity.Companion.from(var151);
         } else {
            var152 = null;
         }

         Timber.Forest var88 = Timber.Forest;
         StringBuilder var87 = new StringBuilder("FromDevice: nuLastConnectivityMillis = ");
         var87.append(var1.getLastConnectivityInMillis());
         var87.append(", oldLastConnectivityMillis = ");
         Long var86;
         if (var2 != null) {
            var86 = var2.getLastConnectivityMillis();
         } else {
            var86 = null;
         }

         var87.append(var86);
         var88.v(var87.toString(), new Object[0]);
         long var52 = var1.getLastConnectivityInMillis();
         if (var2 != null) {
            var86 = var2.getLastConnectivityMillis();
         } else {
            var86 = null;
         }

         Pair var191;
         if (this.isLatestConnectivityState(var52, var86)) {
            int var7;
            label2027: {
               Integer var189 = (Integer)((KProperty1)null.INSTANCE).get(var1);
               if (var189 == null) {
                  if (var2 != null) {
                     var189 = var2.getConnectivityStatusIndex();
                  } else {
                     var189 = null;
                  }

                  if (var189 == null) {
                     var7 = ConnectivityStatus.ONLINE.ordinal();
                     break label2027;
                  }
               }

               var7 = var189;
            }

            label2021: {
               Long var190 = (Long)((KProperty1)null.INSTANCE).get(var1);
               if (var190 == null) {
                  if (var2 != null) {
                     var190 = var2.getLastConnectivityMillis();
                  } else {
                     var190 = null;
                  }

                  if (var190 == null) {
                     var52 = 0L;
                     break label2021;
                  }
               }

               var52 = var190;
            }

            var191 = new Pair(var7, var52);
         } else {
            int var130;
            if (var2 != null) {
               var130 = var2.getConnectivityStatusIndex();
            } else {
               var130 = ConnectivityStatus.ONLINE.ordinal();
            }

            if (var2 != null) {
               var52 = var2.getLastConnectivityMillis();
            } else {
               var52 = 0L;
            }

            var191 = new Pair(var130, var52);
         }

         int var51 = ((Number)var191.component1()).intValue();
         long var58 = ((Number)var191.component2()).longValue();
         Timber.Forest var238 = Timber.Forest;
         StringBuilder var192 = new StringBuilder("FromDevice: DeviceType = ");
         var192.append(var1.getTypeIndex());
         var192.append(", id = ");
         var192.append(var1.getUid());
         var238.d(var192.toString(), new Object[0]);
         var238 = Timber.Forest;
         var192 = new StringBuilder("FromDevice: Device = ");
         var192.append(var1);
         var238.v(var192.toString(), new Object[0]);
         String var121 = var1.getUid();
         String var122 = var1.getName();
         String var123 = var1.getModelName();
         int var50 = var1.getTypeIndex();
         KProperty1 var194 = (KProperty1)null.INSTANCE;
         boolean var63 = var1 instanceof HasFanSpeed;
         Object var195;
         if (var63) {
            var195 = var194.get(var1);
         } else {
            var195 = null;
         }

         Integer var95;
         label2014: {
            Integer var240 = (Integer)var195;
            Integer var196 = var240;
            if (var240 == null) {
               if (var2 == null) {
                  var95 = null;
                  break label2014;
               }

               var196 = var2.getFanSpeed();
            }

            var95 = var196;
         }

         KProperty1 var197 = (KProperty1)null.INSTANCE;
         Object var198;
         if (var63) {
            var198 = var197.get(var1);
         } else {
            var198 = null;
         }

         Integer var96;
         label2007: {
            Integer var241 = (Integer)var198;
            Integer var199 = var241;
            if (var241 == null) {
               if (var2 == null) {
                  var96 = null;
                  break label2007;
               }

               var199 = var2.getFilterLife();
            }

            var96 = var199;
         }

         KProperty1 var200 = (KProperty1)null.INSTANCE;
         Object var201;
         if (var63) {
            var201 = var200.get(var1);
         } else {
            var201 = null;
         }

         String var97;
         label2000: {
            String var242 = (String)var201;
            String var202 = var242;
            if (var242 == null) {
               if (var2 == null) {
                  var97 = null;
                  break label2000;
               }

               var202 = var2.getAutoModeText();
            }

            var97 = var202;
         }

         KProperty1 var203 = (KProperty1)null.INSTANCE;
         Object var204;
         if (var1 instanceof HasBrightness) {
            var204 = var203.get(var1);
         } else {
            var204 = null;
         }

         Integer var98;
         label1993: {
            Integer var243 = (Integer)var204;
            Integer var205 = var243;
            if (var243 == null) {
               if (var2 == null) {
                  var98 = null;
                  break label1993;
               }

               var205 = var2.getBrightness();
            }

            var98 = var205;
         }

         KProperty1 var206 = (KProperty1)null.INSTANCE;
         Object var207;
         if (var1 instanceof HasInfo) {
            var207 = var206.get(var1);
         } else {
            var207 = null;
         }

         String var99;
         label1986: {
            String var244 = (String)var207;
            String var208 = var244;
            if (var244 == null) {
               if (var2 == null) {
                  var99 = null;
                  break label1986;
               }

               var208 = var2.getInfo();
            }

            var99 = var208;
         }

         DeviceUuidEntity var100;
         label1980: {
            DeviceUuidEntity var209 = var152;
            if (var152 == null) {
               if (var2 == null) {
                  var100 = null;
                  break label1980;
               }

               var209 = var2.getDeviceUuid();
            }

            var100 = var209;
         }

         KProperty1 var153 = (KProperty1)null.INSTANCE;
         Object var154;
         if (var60) {
            var154 = var153.get(var1);
         } else {
            var154 = null;
         }

         Boolean var155 = (Boolean)var154;
         if (var155 != null) {
            var60 = var155;
         } else {
            var60 = false;
         }

         KProperty1 var156 = (KProperty1)null.INSTANCE;
         boolean var64 = var1 instanceof HasSensorData;
         Object var157;
         if (var64) {
            var157 = var156.get(var1);
         } else {
            var157 = null;
         }

         IndoorDatapoint var124 = (IndoorDatapoint)var157;
         KProperty1 var158 = (KProperty1)null.INSTANCE;
         Object var159;
         if (var64) {
            var159 = var158.get(var1);
         } else {
            var159 = null;
         }

         Integer var160 = (Integer)var159;
         int var131;
         if (var160 != null) {
            var131 = var160;
         } else {
            var131 = 0;
         }

         boolean var83 = var1 instanceof HasAblCloudFunctions;
         KProperty1 var161 = (KProperty1)null.INSTANCE;
         Object var162;
         if (var1 instanceof HasNightMode) {
            var162 = var161.get(var1);
         } else {
            var162 = null;
         }

         boolean var61;
         label1973: {
            Boolean var163 = (Boolean)var162;
            if (var163 == null) {
               if (var2 != null) {
                  var163 = var2.isNightModeOn();
               } else {
                  var163 = null;
               }

               if (var163 == null) {
                  var61 = false;
                  break label1973;
               }
            }

            var61 = var163;
         }

         KProperty1 var164 = (KProperty1)null.INSTANCE;
         Object var165;
         if (var1 instanceof HasChildLock) {
            var165 = var164.get(var1);
         } else {
            var165 = null;
         }

         boolean var62;
         label1966: {
            Boolean var166 = (Boolean)var165;
            if (var166 == null) {
               if (var2 != null) {
                  var166 = var2.isChildLockOn();
               } else {
                  var166 = null;
               }

               if (var166 == null) {
                  var62 = false;
                  break label1966;
               }
            }

            var62 = var166;
         }

         KProperty1 var167 = (KProperty1)null.INSTANCE;
         Object var168;
         if (var1 instanceof HasLinkingCapability) {
            var168 = var167.get(var1);
         } else {
            var168 = null;
         }

         String var101;
         label1959: {
            String var210 = (String)var168;
            String var169 = var210;
            if (var210 == null) {
               if (var2 == null) {
                  var101 = null;
                  break label1959;
               }

               var169 = var2.getLinkedDeviceUid();
            }

            var101 = var169;
         }

         String var102;
         label1953: {
            String var211 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var170 = var211;
            if (var211 == null) {
               if (var2 != null) {
                  var211 = var2.getMac();
               } else {
                  var211 = null;
               }

               var170 = var211;
               if (var211 == null) {
                  var102 = "";
                  break label1953;
               }
            }

            var102 = var170;
         }

         String var103;
         label1947: {
            String var213 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var171 = var213;
            if (var213 == null) {
               if (var2 != null) {
                  var213 = var2.getMcuFirmware();
               } else {
                  var213 = null;
               }

               var171 = var213;
               if (var213 == null) {
                  var103 = "";
                  break label1947;
               }
            }

            var103 = var171;
         }

         String var104;
         label1941: {
            String var215 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var172 = var215;
            if (var215 == null) {
               if (var2 != null) {
                  var215 = var2.getWifiFirmware();
               } else {
                  var215 = null;
               }

               var172 = var215;
               if (var215 == null) {
                  var104 = "";
                  break label1941;
               }
            }

            var104 = var172;
         }

         String var105;
         label1935: {
            String var217 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var173 = var217;
            if (var217 == null) {
               if (var2 != null) {
                  var217 = var2.getHardware();
               } else {
                  var217 = null;
               }

               var173 = var217;
               if (var217 == null) {
                  var105 = "";
                  break label1935;
               }
            }

            var105 = var173;
         }

         String var106;
         label1929: {
            String var219 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var174 = var219;
            if (var219 == null) {
               if (var2 != null) {
                  var219 = var2.getTimeZone();
               } else {
                  var219 = null;
               }

               var174 = var219;
               if (var219 == null) {
                  var106 = "";
                  break label1929;
               }
            }

            var106 = var174;
         }

         String var107;
         label1923: {
            String var221 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var175 = var221;
            if (var221 == null) {
               if (var2 != null) {
                  var221 = var2.getSerial();
               } else {
                  var221 = null;
               }

               var175 = var221;
               if (var221 == null) {
                  var107 = "";
                  break label1923;
               }
            }

            var107 = var175;
         }

         String var108;
         label1917: {
            String var223 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var176 = var223;
            if (var223 == null) {
               if (var2 != null) {
                  var223 = var2.getPurchaseDate();
               } else {
                  var223 = null;
               }

               var176 = var223;
               if (var223 == null) {
                  var108 = "";
                  break label1917;
               }
            }

            var108 = var176;
         }

         String var109;
         label1911: {
            String var225 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var177 = var225;
            if (var225 == null) {
               if (var2 != null) {
                  var225 = var2.getDealerName();
               } else {
                  var225 = null;
               }

               var177 = var225;
               if (var225 == null) {
                  var109 = "";
                  break label1911;
               }
            }

            var109 = var177;
         }

         String var110;
         label1905: {
            String var227 = (String)((KProperty1)null.INSTANCE).get(var1);
            String var178 = var227;
            if (var227 == null) {
               if (var2 != null) {
                  var227 = var2.getDealerCountry();
               } else {
                  var227 = null;
               }

               var178 = var227;
               if (var227 == null) {
                  var110 = "";
                  break label1905;
               }
            }

            var110 = var178;
         }

         KProperty1 var179 = (KProperty1)null.INSTANCE;
         Object var180;
         if (var63) {
            var180 = var179.get(var1);
         } else {
            var180 = null;
         }

         String var111;
         label1898: {
            String var229 = (String)var180;
            String var181 = var229;
            if (var229 == null) {
               if (var2 != null) {
                  var229 = var2.getFilterType();
               } else {
                  var229 = null;
               }

               var181 = var229;
               if (var229 == null) {
                  var111 = "";
                  break label1898;
               }
            }

            var111 = var181;
         }

         KProperty1 var182 = (KProperty1)null.INSTANCE;
         Object var183;
         if (var63) {
            var183 = var182.get(var1);
         } else {
            var183 = null;
         }

         String var112;
         label1891: {
            String var231 = (String)var183;
            String var184 = var231;
            if (var231 == null) {
               if (var2 != null) {
                  var231 = var2.getFilterTrigger();
               } else {
                  var231 = null;
               }

               var184 = var231;
               if (var231 == null) {
                  var112 = "";
                  break label1891;
               }
            }

            var112 = var184;
         }

         KProperty1 var185 = (KProperty1)null.INSTANCE;
         Object var186;
         if (var64) {
            var186 = var185.get(var1);
         } else {
            var186 = null;
         }

         double[] var233 = (double[])var186;
         double[] var187 = var233;
         if (var233 == null) {
            if (var2 != null) {
               var233 = var2.getPm1Ranges();
            } else {
               var233 = null;
            }

            var187 = var233;
            if (var233 == null) {
               var187 = new double[0];
            }
         }

         KProperty1 var235 = (KProperty1)null.INSTANCE;
         Object var236;
         if (var64) {
            var236 = var235.get(var1);
         } else {
            var236 = null;
         }

         double[] var245 = (double[])var236;
         double[] var237 = var245;
         if (var245 == null) {
            if (var2 != null) {
               var245 = var2.getPm10Ranges();
            } else {
               var245 = null;
            }

            var237 = var245;
            if (var245 == null) {
               var237 = new double[0];
            }
         }

         KProperty1 var247 = (KProperty1)null.INSTANCE;
         Object var248;
         if (var64) {
            var248 = var247.get(var1);
         } else {
            var248 = null;
         }

         double[] var250 = (double[])var248;
         double[] var249 = var250;
         if (var250 == null) {
            if (var2 != null) {
               var250 = var2.getPm25Ranges();
            } else {
               var250 = null;
            }

            var249 = var250;
            if (var250 == null) {
               var249 = new double[0];
            }
         }

         KProperty1 var252 = (KProperty1)null.INSTANCE;
         Object var253;
         if (var64) {
            var253 = var252.get(var1);
         } else {
            var253 = null;
         }

         double[] var89 = (double[])var253;
         double[] var254 = var89;
         if (var89 == null) {
            if (var2 != null) {
               var89 = var2.getVocRanges();
            } else {
               var89 = null;
            }

            var254 = var89;
            if (var89 == null) {
               var254 = new double[0];
            }
         }

         KProperty1 var256 = (KProperty1)null.INSTANCE;
         Object var257;
         if (var64) {
            var257 = var256.get(var1);
         } else {
            var257 = null;
         }

         double[] var90 = (double[])var257;
         double[] var258 = var90;
         if (var90 == null) {
            if (var2 != null) {
               var90 = var2.getHchoRanges();
            } else {
               var90 = null;
            }

            var258 = var90;
            if (var90 == null) {
               var258 = new double[0];
            }
         }

         int var8;
         label1872: {
            Integer var260 = (Integer)((KProperty1)null.INSTANCE).get(var1);
            if (var260 == null) {
               if (var2 != null) {
                  var260 = var2.getUpdateProgress();
               } else {
                  var260 = null;
               }

               if (var260 == null) {
                  var8 = 0;
                  break label1872;
               }
            }

            var8 = var260;
         }

         KProperty1 var261 = (KProperty1)null.INSTANCE;
         Object var262;
         if (var1 instanceof HasStandBy) {
            var262 = var261.get(var1);
         } else {
            var262 = null;
         }

         label1865: {
            Boolean var263 = (Boolean)var262;
            if (var263 == null) {
               if (var2 != null) {
                  var263 = var2.isStandByOn();
               } else {
                  var263 = null;
               }

               if (var263 == null) {
                  var63 = false;
                  break label1865;
               }
            }

            var63 = var263;
         }

         KProperty1 var264 = (KProperty1)null.INSTANCE;
         Object var265;
         if (var1 instanceof HasEcoMode) {
            var265 = var264.get(var1);
         } else {
            var265 = null;
         }

         label1858: {
            Boolean var266 = (Boolean)var265;
            if (var266 == null) {
               if (var2 != null) {
                  var266 = var2.isEcoModeOn();
               } else {
                  var266 = null;
               }

               if (var266 == null) {
                  var64 = false;
                  break label1858;
               }
            }

            var64 = var266;
         }

         KProperty1 var267 = (KProperty1)null.INSTANCE;
         boolean var66 = var1 instanceof HasHinsMode;
         Object var268;
         if (var66) {
            var268 = var267.get(var1);
         } else {
            var268 = null;
         }

         boolean var65;
         label1851: {
            Boolean var269 = (Boolean)var268;
            if (var269 == null) {
               if (var2 != null) {
                  var269 = var2.isHinsModeOn();
               } else {
                  var269 = null;
               }

               if (var269 == null) {
                  var65 = false;
                  break label1851;
               }
            }

            var65 = var269;
         }

         KProperty1 var270 = (KProperty1)null.INSTANCE;
         Object var271;
         if (var66) {
            var271 = var270.get(var1);
         } else {
            var271 = null;
         }

         label1844: {
            Boolean var272 = (Boolean)var271;
            if (var272 == null) {
               if (var2 != null) {
                  var272 = var2.isHinsNightModeOn();
               } else {
                  var272 = null;
               }

               if (var272 == null) {
                  var66 = false;
                  break label1844;
               }
            }

            var66 = var272;
         }

         KProperty1 var273 = (KProperty1)null.INSTANCE;
         boolean var70 = var1 instanceof HasG4NightMode;
         Object var274;
         if (var70) {
            var274 = var273.get(var1);
         } else {
            var274 = null;
         }

         boolean var67;
         label1837: {
            Boolean var275 = (Boolean)var274;
            if (var275 == null) {
               if (var2 != null) {
                  var275 = var2.isG4NightModeOn();
               } else {
                  var275 = null;
               }

               if (var275 == null) {
                  var67 = false;
                  break label1837;
               }
            }

            var67 = var275;
         }

         KProperty1 var276 = (KProperty1)null.INSTANCE;
         boolean var69 = var1 instanceof HasGermShieldMode;
         Object var277;
         if (var69) {
            var277 = var276.get(var1);
         } else {
            var277 = null;
         }

         boolean var68;
         label1830: {
            Boolean var278 = (Boolean)var277;
            if (var278 == null) {
               if (var2 != null) {
                  var278 = var2.isGermShieldOn();
               } else {
                  var278 = null;
               }

               if (var278 == null) {
                  var68 = false;
                  break label1830;
               }
            }

            var68 = var278;
         }

         KProperty1 var279 = (KProperty1)null.INSTANCE;
         Object var280;
         if (var69) {
            var280 = var279.get(var1);
         } else {
            var280 = null;
         }

         Boolean var113;
         label1823: {
            Boolean var91 = (Boolean)var280;
            Boolean var281 = var91;
            if (var91 == null) {
               if (var2 == null) {
                  var113 = null;
                  break label1823;
               }

               var281 = var2.isGermShieldNightModeOn();
            }

            var113 = var281;
         }

         KProperty1 var282 = (KProperty1)null.INSTANCE;
         Object var283;
         if (var1 instanceof HasSafetySwitch) {
            var283 = var282.get(var1);
         } else {
            var283 = null;
         }

         label1816: {
            Boolean var284 = (Boolean)var283;
            if (var284 == null) {
               if (var2 != null) {
                  var284 = var2.isSafetySwitchOn();
               } else {
                  var284 = null;
               }

               if (var284 == null) {
                  var69 = true;
                  break label1816;
               }
            }

            var69 = var284;
         }

         KProperty1 var285 = (KProperty1)null.INSTANCE;
         Object var286;
         if (var70) {
            var286 = var285.get(var1);
         } else {
            var286 = null;
         }

         String var114;
         label1809: {
            String var388 = (String)var286;
            String var287 = var388;
            if (var388 == null) {
               if (var2 != null) {
                  var388 = var2.getG4NightModefilterTrigger();
               } else {
                  var388 = null;
               }

               var287 = var388;
               if (var388 == null) {
                  var114 = "";
                  break label1809;
               }
            }

            var114 = var287;
         }

         if (var2 != null) {
            var70 = var2.getAimInstalled();
         } else {
            var70 = false;
         }

         KProperty1 var288 = (KProperty1)null.INSTANCE;
         Object var289;
         if (var1 instanceof HasCompatibility) {
            var289 = var288.get(var1);
         } else {
            var289 = null;
         }

         String var115;
         label1802: {
            String var390 = (String)var289;
            String var290 = var390;
            if (var390 == null) {
               if (var2 == null) {
                  var115 = null;
                  break label1802;
               }

               var290 = var2.getCompatibility();
            }

            var115 = var290;
         }

         KProperty1 var291 = (KProperty1)null.INSTANCE;
         Object var292;
         if (var1 instanceof HasSKU) {
            var292 = var291.get(var1);
         } else {
            var292 = null;
         }

         String var116;
         label1795: {
            String var391 = (String)var292;
            String var293 = var391;
            if (var391 == null) {
               if (var2 == null) {
                  var116 = null;
                  break label1795;
               }

               var293 = var2.getSku();
            }

            var116 = var293;
         }

         KProperty1 var294 = (KProperty1)null.INSTANCE;
         Object var295;
         if (var1 instanceof HasWelcomeHome) {
            var295 = var294.get(var1);
         } else {
            var295 = null;
         }

         WelcomeHomeLocation var125 = (WelcomeHomeLocation)var295;
         KProperty1 var296 = (KProperty1)null.INSTANCE;
         Object var297;
         if (var1 instanceof HasLocation) {
            var297 = var296.get(var1);
         } else {
            var297 = null;
         }

         String var126 = (String)var297;
         KProperty1 var298 = (KProperty1)null.INSTANCE;
         boolean var71 = var1 instanceof HasDisinfection;
         Object var299;
         if (var71) {
            var299 = var298.get(var1);
         } else {
            var299 = null;
         }

         Boolean var117;
         label1788: {
            Boolean var392 = (Boolean)var299;
            Boolean var300 = var392;
            if (var392 == null) {
               if (var2 == null) {
                  var117 = null;
                  break label1788;
               }

               var300 = var2.getDisinfection();
            }

            var117 = var300;
         }

         KProperty1 var301 = (KProperty1)null.INSTANCE;
         Object var302;
         if (var71) {
            var302 = var301.get(var1);
         } else {
            var302 = null;
         }

         Integer var118;
         label1781: {
            Integer var393 = (Integer)var302;
            Integer var303 = var393;
            if (var393 == null) {
               if (var2 == null) {
                  var118 = null;
                  break label1781;
               }

               var303 = var2.getDisinfectLeftTime();
            }

            var118 = var303;
         }

         KProperty1 var304 = (KProperty1)null.INSTANCE;
         Object var305;
         if (var71) {
            var305 = var304.get(var1);
         } else {
            var305 = null;
         }

         Long var119;
         label1774: {
            Long var394 = (Long)var305;
            Long var306 = var394;
            if (var394 == null) {
               if (var2 == null) {
                  var119 = null;
                  break label1774;
               }

               var306 = var2.getDisinfectLeftTimeUpdateTime();
            }

            var119 = var306;
         }

         KProperty1 var307 = (KProperty1)null.INSTANCE;
         boolean var73 = var1 instanceof HasWick;
         Object var308;
         if (var73) {
            var308 = var307.get(var1);
         } else {
            var308 = null;
         }

         label1767: {
            Boolean var309 = (Boolean)var308;
            if (var309 == null) {
               if (var2 != null) {
                  var309 = var2.getWickdryEnabled();
               } else {
                  var309 = null;
               }

               if (var309 == null) {
                  var71 = false;
                  break label1767;
               }
            }

            var71 = var309;
         }

         KProperty1 var310 = (KProperty1)null.INSTANCE;
         Object var311;
         if (var73) {
            var311 = var310.get(var1);
         } else {
            var311 = null;
         }

         boolean var72;
         label1760: {
            Boolean var312 = (Boolean)var311;
            if (var312 == null) {
               if (var2 != null) {
                  var312 = var2.getWickdryOn();
               } else {
                  var312 = null;
               }

               if (var312 == null) {
                  var72 = false;
                  break label1760;
               }
            }

            var72 = var312;
         }

         KProperty1 var313 = (KProperty1)null.INSTANCE;
         Object var314;
         if (var73) {
            var314 = var313.get(var1);
         } else {
            var314 = null;
         }

         int var9;
         label1753: {
            Integer var315 = (Integer)var314;
            if (var315 == null) {
               if (var2 != null) {
                  var315 = var2.getWickdryLeftTime();
               } else {
                  var315 = null;
               }

               if (var315 == null) {
                  var9 = 0;
                  break label1753;
               }
            }

            var9 = var315;
         }

         KProperty1 var316 = (KProperty1)null.INSTANCE;
         Object var317;
         if (var73) {
            var317 = var316.get(var1);
         } else {
            var317 = null;
         }

         label1746: {
            Long var318 = (Long)var317;
            if (var318 == null) {
               if (var2 != null) {
                  var318 = var2.getWickdryLeftTimeUpdateTime();
               } else {
                  var318 = null;
               }

               if (var318 == null) {
                  var52 = 0L;
                  break label1746;
               }
            }

            var52 = var318;
         }

         KProperty1 var319 = (KProperty1)null.INSTANCE;
         Object var320;
         if (var73) {
            var320 = var319.get(var1);
         } else {
            var320 = null;
         }

         int var10;
         label1739: {
            Integer var321 = (Integer)var320;
            if (var321 == null) {
               if (var2 != null) {
                  var321 = var2.getWickUsage();
               } else {
                  var321 = null;
               }

               if (var321 == null) {
                  var10 = 0;
                  break label1739;
               }
            }

            var10 = var321;
         }

         KProperty1 var322 = (KProperty1)null.INSTANCE;
         Object var323;
         if (var73) {
            var323 = var322.get(var1);
         } else {
            var323 = null;
         }

         label1732: {
            Boolean var324 = (Boolean)var323;
            if (var324 == null) {
               if (var2 != null) {
                  var324 = var2.getWaterShortage();
               } else {
                  var324 = null;
               }

               if (var324 == null) {
                  var73 = false;
                  break label1732;
               }
            }

            var73 = var324;
         }

         KProperty1 var325 = (KProperty1)null.INSTANCE;
         Object var326;
         if (var1 instanceof HasAutoRh) {
            var326 = var325.get(var1);
         } else {
            var326 = null;
         }

         int var11;
         label1725: {
            Integer var327 = (Integer)var326;
            if (var327 == null) {
               if (var2 != null) {
                  var327 = var2.getAutoRh();
               } else {
                  var327 = null;
               }

               if (var327 == null) {
                  var11 = 50;
                  break label1725;
               }
            }

            var11 = var327;
         }

         KProperty1 var328 = (KProperty1)null.INSTANCE;
         boolean var74 = var1 instanceof HasTimer;
         Object var329;
         if (var74) {
            var329 = var328.get(var1);
         } else {
            var329 = null;
         }

         int var12;
         label1718: {
            Integer var330 = (Integer)var329;
            if (var330 == null) {
               if (var2 != null) {
                  var330 = var2.getTimerStatus();
               } else {
                  var330 = null;
               }

               if (var330 == null) {
                  var12 = 0;
                  break label1718;
               }
            }

            var12 = var330;
         }

         KProperty1 var331 = (KProperty1)null.INSTANCE;
         Object var332;
         if (var74) {
            var332 = var331.get(var1);
         } else {
            var332 = null;
         }

         int var13;
         label1711: {
            Integer var333 = (Integer)var332;
            if (var333 == null) {
               if (var2 != null) {
                  var333 = var2.getTimerDuration();
               } else {
                  var333 = null;
               }

               if (var333 == null) {
                  var13 = 0;
                  break label1711;
               }
            }

            var13 = var333;
         }

         KProperty1 var334 = (KProperty1)null.INSTANCE;
         Object var335;
         if (var74) {
            var335 = var334.get(var1);
         } else {
            var335 = null;
         }

         int var14;
         label1704: {
            Integer var336 = (Integer)var335;
            if (var336 == null) {
               if (var2 != null) {
                  var336 = var2.getTimerLeftTime();
               } else {
                  var336 = null;
               }

               if (var336 == null) {
                  var14 = 0;
                  break label1704;
               }
            }

            var14 = var336;
         }

         KProperty1 var337 = (KProperty1)null.INSTANCE;
         Object var338;
         if (var74) {
            var338 = var337.get(var1);
         } else {
            var338 = null;
         }

         long var54;
         label1697: {
            Long var339 = (Long)var338;
            if (var339 == null) {
               if (var2 != null) {
                  var339 = var2.getTimerLeftTimeUpdateTime();
               } else {
                  var339 = null;
               }

               if (var339 == null) {
                  var54 = 0L;
                  break label1697;
               }
            }

            var54 = var339;
         }

         KProperty1 var340 = (KProperty1)null.INSTANCE;
         Object var341;
         if (var1 instanceof HasTemperatureUnit) {
            var341 = var340.get(var1);
         } else {
            var341 = null;
         }

         int var15;
         label1690: {
            Integer var342 = (Integer)var341;
            if (var342 == null) {
               if (var2 != null) {
                  var342 = var2.getTemperatureUnit();
               } else {
                  var342 = null;
               }

               if (var342 == null) {
                  var15 = 0;
                  break label1690;
               }
            }

            var15 = var342;
         }

         KProperty1 var343 = (KProperty1)null.INSTANCE;
         var74 = var1 instanceof HasOscillation;
         Object var344;
         if (var74) {
            var344 = var343.get(var1);
         } else {
            var344 = null;
         }

         int var16;
         label1683: {
            Integer var345 = (Integer)var344;
            if (var345 == null) {
               if (var2 != null) {
                  var345 = var2.getOscillationState();
               } else {
                  var345 = null;
               }

               if (var345 == null) {
                  var16 = 0;
                  break label1683;
               }
            }

            var16 = var345;
         }

         KProperty1 var346 = (KProperty1)null.INSTANCE;
         Object var347;
         if (var74) {
            var347 = var346.get(var1);
         } else {
            var347 = null;
         }

         int var17;
         label1676: {
            Integer var348 = (Integer)var347;
            if (var348 == null) {
               if (var2 != null) {
                  var348 = var2.getOscillationAngle();
               } else {
                  var348 = null;
               }

               if (var348 == null) {
                  var17 = 90;
                  break label1676;
               }
            }

            var17 = var348;
         }

         KProperty1 var349 = (KProperty1)null.INSTANCE;
         Object var350;
         if (var74) {
            var350 = var349.get(var1);
         } else {
            var350 = null;
         }

         int var18;
         label1669: {
            Integer var351 = (Integer)var350;
            if (var351 == null) {
               if (var2 != null) {
                  var351 = var2.getOscillationDirection();
               } else {
                  var351 = null;
               }

               if (var351 == null) {
                  var18 = 0;
                  break label1669;
               }
            }

            var18 = var351;
         }

         KProperty1 var352 = (KProperty1)null.INSTANCE;
         Object var353;
         if (var74) {
            var353 = var352.get(var1);
         } else {
            var353 = null;
         }

         int var19;
         label1662: {
            Integer var354 = (Integer)var353;
            if (var354 == null) {
               if (var2 != null) {
                  var354 = var2.getOscillationFanSpeed();
               } else {
                  var354 = null;
               }

               if (var354 == null) {
                  var19 = 0;
                  break label1662;
               }
            }

            var19 = var354;
         }

         KProperty1 var355 = (KProperty1)null.INSTANCE;
         var74 = var1 instanceof HasCombo3in1MainMode;
         Object var356;
         if (var74) {
            var356 = var355.get(var1);
         } else {
            var356 = null;
         }

         int var20;
         label1655: {
            Integer var357 = (Integer)var356;
            if (var357 == null) {
               if (var2 != null) {
                  var357 = var2.getMainMode();
               } else {
                  var357 = null;
               }

               if (var357 == null) {
                  var20 = 0;
                  break label1655;
               }
            }

            var20 = var357;
         }

         KProperty1 var358 = (KProperty1)null.INSTANCE;
         Object var359;
         if (var74) {
            var359 = var358.get(var1);
         } else {
            var359 = null;
         }

         int var21;
         label1648: {
            Integer var360 = (Integer)var359;
            if (var360 == null) {
               if (var2 != null) {
                  var360 = var2.getApSubMode();
               } else {
                  var360 = null;
               }

               if (var360 == null) {
                  var21 = 2;
                  break label1648;
               }
            }

            var21 = var360;
         }

         KProperty1 var361 = (KProperty1)null.INSTANCE;
         Object var362;
         if (var74) {
            var362 = var361.get(var1);
         } else {
            var362 = null;
         }

         int var22;
         label1641: {
            Integer var363 = (Integer)var362;
            if (var363 == null) {
               if (var2 != null) {
                  var363 = var2.getApFanSpeed();
               } else {
                  var363 = null;
               }

               if (var363 == null) {
                  var22 = 0;
                  break label1641;
               }
            }

            var22 = var363;
         }

         KProperty1 var364 = (KProperty1)null.INSTANCE;
         Object var365;
         if (var74) {
            var365 = var364.get(var1);
         } else {
            var365 = null;
         }

         int var23;
         label1634: {
            Integer var366 = (Integer)var365;
            if (var366 == null) {
               if (var2 != null) {
                  var366 = var2.getHeatSubMode();
               } else {
                  var366 = null;
               }

               if (var366 == null) {
                  var23 = 2;
                  break label1634;
               }
            }

            var23 = var366;
         }

         KProperty1 var367 = (KProperty1)null.INSTANCE;
         Object var368;
         if (var74) {
            var368 = var367.get(var1);
         } else {
            var368 = null;
         }

         int var24;
         label1627: {
            Integer var369 = (Integer)var368;
            if (var369 == null) {
               if (var2 != null) {
                  var369 = var2.getHeatFanSpeed();
               } else {
                  var369 = null;
               }

               if (var369 == null) {
                  var24 = 0;
                  break label1627;
               }
            }

            var24 = var369;
         }

         KProperty1 var370 = (KProperty1)null.INSTANCE;
         Object var371;
         if (var74) {
            var371 = var370.get(var1);
         } else {
            var371 = null;
         }

         double var3;
         double var5;
         label1620: {
            Double var372 = (Double)var371;
            var5 = (double)22.0F;
            if (var372 == null) {
               if (var2 != null) {
                  var372 = var2.getHeatAutoTmp();
               } else {
                  var372 = null;
               }

               if (var372 == null) {
                  var3 = (double)22.0F;
                  break label1620;
               }
            }

            var3 = var372;
         }

         KProperty1 var373 = (KProperty1)null.INSTANCE;
         Object var374;
         if (var74) {
            var374 = var373.get(var1);
         } else {
            var374 = null;
         }

         label1613: {
            Double var375 = (Double)var374;
            if (var375 == null) {
               if (var2 != null) {
                  var375 = var2.getHeatEcoTmp();
               } else {
                  var375 = null;
               }

               if (var375 == null) {
                  break label1613;
               }
            }

            var5 = var375;
         }

         KProperty1 var376 = (KProperty1)null.INSTANCE;
         Object var377;
         if (var74) {
            var377 = var376.get(var1);
         } else {
            var377 = null;
         }

         int var25;
         label1606: {
            Integer var378 = (Integer)var377;
            if (var378 == null) {
               if (var2 != null) {
                  var378 = var2.getCoolSubMode();
               } else {
                  var378 = null;
               }

               if (var378 == null) {
                  var25 = 2;
                  break label1606;
               }
            }

            var25 = var378;
         }

         KProperty1 var379 = (KProperty1)null.INSTANCE;
         Object var380;
         if (var74) {
            var380 = var379.get(var1);
         } else {
            var380 = null;
         }

         int var26;
         label1599: {
            Integer var381 = (Integer)var380;
            if (var381 == null) {
               if (var2 != null) {
                  var381 = var2.getCoolFanSpeed();
               } else {
                  var381 = null;
               }

               if (var381 == null) {
                  var26 = 0;
                  break label1599;
               }
            }

            var26 = var381;
         }

         KProperty1 var382 = (KProperty1)null.INSTANCE;
         Object var383;
         if (var74) {
            var383 = var382.get(var1);
         } else {
            var383 = null;
         }

         int var27;
         label1592: {
            Integer var384 = (Integer)var383;
            if (var384 == null) {
               if (var2 != null) {
                  var384 = var2.getCoolAutoTag();
               } else {
                  var384 = null;
               }

               if (var384 == null) {
                  var27 = 0;
                  break label1592;
               }
            }

            var27 = var384;
         }

         KProperty1 var385 = (KProperty1)null.INSTANCE;
         Object var386;
         if (var74) {
            var386 = var385.get(var1);
         } else {
            var386 = null;
         }

         double[] var395 = (double[])var386;
         double[] var387 = var395;
         if (var395 == null) {
            if (var2 != null) {
               var395 = var2.getCoolAutoPresets();
            } else {
               var395 = null;
            }

            var387 = var395;
            if (var395 == null) {
               var387 = new double[]{(double)20.0F, (double)23.0F, (double)25.0F};
            }
         }

         KProperty1 var397 = (KProperty1)null.INSTANCE;
         Object var398;
         if (var74) {
            var398 = var397.get(var1);
         } else {
            var398 = null;
         }

         int var28;
         label1582: {
            Integer var399 = (Integer)var398;
            if (var399 == null) {
               if (var2 != null) {
                  var399 = var2.getCoolEcoTag();
               } else {
                  var399 = null;
               }

               if (var399 == null) {
                  var28 = 0;
                  break label1582;
               }
            }

            var28 = var399;
         }

         KProperty1 var400 = (KProperty1)null.INSTANCE;
         Object var401;
         if (var74) {
            var401 = var400.get(var1);
         } else {
            var401 = null;
         }

         double[] var92 = (double[])var401;
         double[] var402 = var92;
         if (var92 == null) {
            if (var2 != null) {
               var92 = var2.getCoolEcoPresets();
            } else {
               var92 = null;
            }

            var402 = var92;
            if (var92 == null) {
               var402 = new double[]{(double)20.0F, (double)25.0F};
            }
         }

         KProperty1 var404 = (KProperty1)null.INSTANCE;
         Object var405;
         if (var1 instanceof HasMode) {
            var405 = var404.get(var1);
         } else {
            var405 = null;
         }

         int var29;
         label1572: {
            Integer var406 = (Integer)var405;
            if (var406 == null) {
               if (var2 != null) {
                  var406 = var2.getMode();
               } else {
                  var406 = null;
               }

               if (var406 == null) {
                  var29 = 1;
                  break label1572;
               }
            }

            var29 = var406;
         }

         KProperty1 var407 = (KProperty1)null.INSTANCE;
         Object var408;
         if (var1 instanceof HasHumMode) {
            var408 = var407.get(var1);
         } else {
            var408 = null;
         }

         label1565: {
            Boolean var409 = (Boolean)var408;
            if (var409 == null) {
               if (var2 != null) {
                  var409 = var2.getHumMode();
               } else {
                  var409 = null;
               }

               if (var409 == null) {
                  var74 = false;
                  break label1565;
               }
            }

            var74 = var409;
         }

         KProperty1 var410 = (KProperty1)null.INSTANCE;
         Object var411;
         if (var1 instanceof HasWaterLevel) {
            var411 = var410.get(var1);
         } else {
            var411 = null;
         }

         int var30;
         label1558: {
            Integer var412 = (Integer)var411;
            if (var412 == null) {
               if (var2 != null) {
                  var412 = var2.getWaterLevel();
               } else {
                  var412 = null;
               }

               if (var412 == null) {
                  var30 = 0;
                  break label1558;
               }
            }

            var30 = var412;
         }

         KProperty1 var413 = (KProperty1)null.INSTANCE;
         Object var414;
         if (var1 instanceof HasDehumidifierMainMode) {
            var414 = var413.get(var1);
         } else {
            var414 = null;
         }

         int var31;
         label1551: {
            Integer var415 = (Integer)var414;
            if (var415 == null) {
               if (var2 != null) {
                  var415 = var2.getDehSubMode();
               } else {
                  var415 = null;
               }

               if (var415 == null) {
                  var31 = 1;
                  break label1551;
               }
            }

            var31 = var415;
         }

         KProperty1 var416 = (KProperty1)null.INSTANCE;
         Object var417;
         if (var1 instanceof HasWaterTank) {
            var417 = var416.get(var1);
         } else {
            var417 = null;
         }

         boolean var75;
         label1544: {
            Boolean var418 = (Boolean)var417;
            if (var418 == null) {
               if (var2 != null) {
                  var418 = var2.getWaterTankFailure();
               } else {
                  var418 = null;
               }

               if (var418 == null) {
                  var75 = false;
                  break label1544;
               }
            }

            var75 = var418;
         }

         KProperty1 var419 = (KProperty1)null.INSTANCE;
         Object var420;
         if (var1 instanceof HasPetMainMode) {
            var420 = var419.get(var1);
         } else {
            var420 = null;
         }

         int var32;
         label1537: {
            Integer var421 = (Integer)var420;
            if (var421 == null) {
               if (var2 != null) {
                  var421 = var2.getSmartSubMode();
               } else {
                  var421 = null;
               }

               if (var421 == null) {
                  var32 = 0;
                  break label1537;
               }
            }

            var32 = var421;
         }

         KProperty1 var422 = (KProperty1)null.INSTANCE;
         Object var423;
         if (var1 instanceof HasDetectCat) {
            var423 = var422.get(var1);
         } else {
            var423 = null;
         }

         boolean var76;
         label1530: {
            Boolean var424 = (Boolean)var423;
            if (var424 == null) {
               if (var2 != null) {
                  var424 = var2.getDetectCat();
               } else {
                  var424 = null;
               }

               if (var424 == null) {
                  var76 = false;
                  break label1530;
               }
            }

            var76 = var424;
         }

         KProperty1 var425 = (KProperty1)null.INSTANCE;
         Object var426;
         if (var1 instanceof HasBody) {
            var426 = var425.get(var1);
         } else {
            var426 = null;
         }

         boolean var77;
         label1523: {
            Boolean var427 = (Boolean)var426;
            if (var427 == null) {
               if (var2 != null) {
                  var427 = var2.getBodyMounted();
               } else {
                  var427 = null;
               }

               if (var427 == null) {
                  var77 = true;
                  break label1523;
               }
            }

            var77 = var427;
         }

         KProperty1 var428 = (KProperty1)null.INSTANCE;
         Object var429;
         if (var1 instanceof HasCleanAirEta) {
            var429 = var428.get(var1);
         } else {
            var429 = null;
         }

         int var33;
         label1516: {
            Integer var430 = (Integer)var429;
            if (var430 == null) {
               if (var2 != null) {
                  var430 = var2.getCleanAirEta();
               } else {
                  var430 = null;
               }

               if (var430 == null) {
                  var33 = 0;
                  break label1516;
               }
            }

            var33 = var430;
         }

         KProperty1 var431 = (KProperty1)null.INSTANCE;
         Object var432;
         if (var1 instanceof HasDisplayMode) {
            var432 = var431.get(var1);
         } else {
            var432 = null;
         }

         int var34;
         label1509: {
            Integer var433 = (Integer)var432;
            if (var433 == null) {
               if (var2 != null) {
                  var433 = var2.getPanelDisplayMode();
               } else {
                  var433 = null;
               }

               if (var433 == null) {
                  var34 = 0;
                  break label1509;
               }
            }

            var34 = var433;
         }

         KProperty1 var434 = (KProperty1)null.INSTANCE;
         Object var435;
         if (var1 instanceof HasGestureRecognition) {
            var435 = var434.get(var1);
         } else {
            var435 = null;
         }

         boolean var78;
         label1502: {
            Boolean var436 = (Boolean)var435;
            if (var436 == null) {
               if (var2 != null) {
                  var436 = var2.getHoverEnabled();
               } else {
                  var436 = null;
               }

               if (var436 == null) {
                  var78 = true;
                  break label1502;
               }
            }

            var78 = var436;
         }

         KProperty1 var437 = (KProperty1)null.INSTANCE;
         boolean var80 = var1 instanceof HasAirRefresh;
         Object var438;
         if (var80) {
            var438 = var437.get(var1);
         } else {
            var438 = null;
         }

         boolean var79;
         label1495: {
            Boolean var439 = (Boolean)var438;
            if (var439 == null) {
               if (var2 != null) {
                  var439 = var2.getAirRefreshEnabled();
               } else {
                  var439 = null;
               }

               if (var439 == null) {
                  var79 = true;
                  break label1495;
               }
            }

            var79 = var439;
         }

         KProperty1 var440 = (KProperty1)null.INSTANCE;
         Object var441;
         if (var80) {
            var441 = var440.get(var1);
         } else {
            var441 = null;
         }

         int var35;
         label1488: {
            Integer var442 = (Integer)var441;
            if (var442 == null) {
               if (var2 != null) {
                  var442 = var2.getAirRefreshStatus();
               } else {
                  var442 = null;
               }

               if (var442 == null) {
                  var35 = 0;
                  break label1488;
               }
            }

            var35 = var442;
         }

         KProperty1 var443 = (KProperty1)null.INSTANCE;
         Object var444;
         if (var80) {
            var444 = var443.get(var1);
         } else {
            var444 = null;
         }

         int var36;
         label1481: {
            Integer var445 = (Integer)var444;
            if (var445 == null) {
               if (var2 != null) {
                  var445 = var2.getAirRefreshDuration();
               } else {
                  var445 = null;
               }

               if (var445 == null) {
                  var36 = 0;
                  break label1481;
               }
            }

            var36 = var445;
         }

         KProperty1 var446 = (KProperty1)null.INSTANCE;
         Object var447;
         if (var80) {
            var447 = var446.get(var1);
         } else {
            var447 = null;
         }

         int var37;
         label1474: {
            Integer var448 = (Integer)var447;
            if (var448 == null) {
               if (var2 != null) {
                  var448 = var2.getAirRefreshTimeStamp();
               } else {
                  var448 = null;
               }

               if (var448 == null) {
                  var37 = 0;
                  break label1474;
               }
            }

            var37 = var448;
         }

         KProperty1 var449 = (KProperty1)null.INSTANCE;
         Object var450;
         if (var80) {
            var450 = var449.get(var1);
         } else {
            var450 = null;
         }

         int var38;
         label1467: {
            Integer var451 = (Integer)var450;
            if (var451 == null) {
               if (var2 != null) {
                  var451 = var2.getAirRefreshStartTimeStamp();
               } else {
                  var451 = null;
               }

               if (var451 == null) {
                  var38 = 0;
                  break label1467;
               }
            }

            var38 = var451;
         }

         KProperty1 var452 = (KProperty1)null.INSTANCE;
         Object var453;
         if (var80) {
            var453 = var452.get(var1);
         } else {
            var453 = null;
         }

         int var39;
         label1460: {
            Integer var454 = (Integer)var453;
            if (var454 == null) {
               if (var2 != null) {
                  var454 = var2.getAirRefreshEndTimeStamp();
               } else {
                  var454 = null;
               }

               if (var454 == null) {
                  var39 = 0;
                  break label1460;
               }
            }

            var39 = var454;
         }

         KProperty1 var455 = (KProperty1)null.INSTANCE;
         Object var456;
         if (var1 instanceof HasRoom) {
            var456 = var455.get(var1);
         } else {
            var456 = null;
         }

         int var40;
         label1453: {
            Integer var457 = (Integer)var456;
            if (var457 == null) {
               if (var2 != null) {
                  var457 = var2.getRoomType();
               } else {
                  var457 = null;
               }

               if (var457 == null) {
                  var40 = 0;
                  break label1453;
               }
            }

            var40 = var457;
         }

         KProperty1 var458 = (KProperty1)null.INSTANCE;
         Object var459;
         if (var1 instanceof HasMoodLamp) {
            var459 = var458.get(var1);
         } else {
            var459 = null;
         }

         int var41;
         label1446: {
            Integer var460 = (Integer)var459;
            if (var460 == null) {
               if (var2 != null) {
                  var460 = var2.getNightLampBrightness();
               } else {
                  var460 = null;
               }

               if (var460 == null) {
                  var41 = 0;
                  break label1446;
               }
            }

            var41 = var460;
         }

         KProperty1 var461 = (KProperty1)null.INSTANCE;
         var80 = var1 instanceof HasWickDryDuration;
         Object var462;
         if (var80) {
            var462 = var461.get(var1);
         } else {
            var462 = null;
         }

         int var42;
         label1439: {
            Integer var463 = (Integer)var462;
            if (var463 == null) {
               if (var2 != null) {
                  var463 = var2.getWickdryDuration();
               } else {
                  var463 = null;
               }

               if (var463 == null) {
                  var42 = 0;
                  break label1439;
               }
            }

            var42 = var463;
         }

         KProperty1 var464 = (KProperty1)null.INSTANCE;
         Object var465;
         if (var80) {
            var465 = var464.get(var1);
         } else {
            var465 = null;
         }

         label1432: {
            Boolean var466 = (Boolean)var465;
            if (var466 == null) {
               if (var2 != null) {
                  var466 = var2.getWickdryDone();
               } else {
                  var466 = null;
               }

               if (var466 == null) {
                  var80 = false;
                  break label1432;
               }
            }

            var80 = var466;
         }

         KProperty1 var467 = (KProperty1)null.INSTANCE;
         boolean var81 = var1 instanceof HasRemoveYellowWater;
         Object var468;
         if (var81) {
            var468 = var467.get(var1);
         } else {
            var468 = null;
         }

         Boolean var120;
         label1425: {
            Boolean var93 = (Boolean)var468;
            Boolean var469 = var93;
            if (var93 == null) {
               if (var2 == null) {
                  var120 = null;
                  break label1425;
               }

               var469 = var2.getYwrmEnabled();
            }

            var120 = var469;
         }

         KProperty1 var470 = (KProperty1)null.INSTANCE;
         Object var471;
         if (var81) {
            var471 = var470.get(var1);
         } else {
            var471 = null;
         }

         int var43;
         label1418: {
            Integer var472 = (Integer)var471;
            if (var472 == null) {
               if (var2 != null) {
                  var472 = var2.getYwrmUsage();
               } else {
                  var472 = null;
               }

               if (var472 == null) {
                  var43 = 0;
                  break label1418;
               }
            }

            var43 = var472;
         }

         KProperty1 var473 = (KProperty1)null.INSTANCE;
         Object var474;
         if (var1 instanceof HasNightLamp) {
            var474 = var473.get(var1);
         } else {
            var474 = null;
         }

         int var44;
         label1411: {
            Integer var475 = (Integer)var474;
            if (var475 == null) {
               if (var2 != null) {
                  var475 = var2.getNightLampSteplessBrightness();
               } else {
                  var475 = null;
               }

               if (var475 == null) {
                  var44 = 0;
                  break label1411;
               }
            }

            var44 = var475;
         }

         KProperty1 var476 = (KProperty1)null.INSTANCE;
         Object var477;
         if (var1 instanceof HasAlarm) {
            var477 = var476.get(var1);
         } else {
            var477 = null;
         }

         List var479 = (List)var477;
         List var478 = var479;
         if (var479 == null) {
            if (var2 != null) {
               var479 = var2.getAlarms();
            } else {
               var479 = null;
            }

            var478 = var479;
            if (var479 == null) {
               var478 = this.getNULL_ALARM_LIST();
            }
         }

         KProperty1 var481 = (KProperty1)null.INSTANCE;
         Object var482;
         if (var1 instanceof HasHumMainMode) {
            var482 = var481.get(var1);
         } else {
            var482 = null;
         }

         int var45;
         label1401: {
            Integer var483 = (Integer)var482;
            if (var483 == null) {
               if (var2 != null) {
                  var483 = var2.getHumSubMode();
               } else {
                  var483 = null;
               }

               if (var483 == null) {
                  var45 = 2;
                  break label1401;
               }
            }

            var45 = var483;
         }

         KProperty1 var484 = (KProperty1)null.INSTANCE;
         Object var485;
         if (var1 instanceof HasHourFormat) {
            var485 = var484.get(var1);
         } else {
            var485 = null;
         }

         label1394: {
            Boolean var486 = (Boolean)var485;
            if (var486 == null) {
               if (var2 != null) {
                  var486 = var2.getUse24Hour();
               } else {
                  var486 = null;
               }

               if (var486 == null) {
                  var81 = true;
                  break label1394;
               }
            }

            var81 = var486;
         }

         KProperty1 var487 = (KProperty1)null.INSTANCE;
         Object var488;
         if (var1 instanceof HasWaterInfill) {
            var488 = var487.get(var1);
         } else {
            var488 = null;
         }

         boolean var82;
         label1387: {
            Boolean var489 = (Boolean)var488;
            if (var489 == null) {
               if (var2 != null) {
                  var489 = var2.getWaterInfill();
               } else {
                  var489 = null;
               }

               if (var489 == null) {
                  var82 = false;
                  break label1387;
               }
            }

            var82 = var489;
         }

         KProperty1 var490 = (KProperty1)null.INSTANCE;
         Object var491;
         if (var1 instanceof HasSensorMode) {
            var491 = var490.get(var1);
         } else {
            var491 = null;
         }

         int var46;
         label1380: {
            Integer var492 = (Integer)var491;
            if (var492 == null) {
               if (var2 != null) {
                  var492 = var2.getSensorMode();
               } else {
                  var492 = null;
               }

               if (var492 == null) {
                  var46 = 1;
                  break label1380;
               }
            }

            var46 = var492;
         }

         KProperty1 var493 = (KProperty1)null.INSTANCE;
         boolean var84 = var1 instanceof HasCoolMainMode;
         Object var494;
         if (var84) {
            var494 = var493.get(var1);
         } else {
            var494 = null;
         }

         int var47;
         label1373: {
            Integer var495 = (Integer)var494;
            if (var495 == null) {
               if (var2 != null) {
                  var495 = var2.getCoolFanSpeedLevel();
               } else {
                  var495 = null;
               }

               if (var495 == null) {
                  var47 = 1;
                  break label1373;
               }
            }

            var47 = var495;
         }

         KProperty1 var496 = (KProperty1)null.INSTANCE;
         Object var497;
         if (var84) {
            var497 = var496.get(var1);
         } else {
            var497 = null;
         }

         int var48;
         label1366: {
            Integer var498 = (Integer)var497;
            if (var498 == null) {
               if (var2 != null) {
                  var498 = var2.getCoolAutoLevel();
               } else {
                  var498 = null;
               }

               if (var498 == null) {
                  var48 = 0;
                  break label1366;
               }
            }

            var48 = var498;
         }

         KProperty1 var499 = (KProperty1)null.INSTANCE;
         var84 = var1 instanceof HasNightModeTiming;
         Object var500;
         if (var84) {
            var500 = var499.get(var1);
         } else {
            var500 = null;
         }

         long var56;
         label1359: {
            Long var501 = (Long)var500;
            if (var501 == null) {
               if (var2 != null) {
                  var501 = var2.getNightModeStartTime();
               } else {
                  var501 = null;
               }

               if (var501 == null) {
                  var56 = 0L;
                  break label1359;
               }
            }

            var56 = var501;
         }

         KProperty1 var502 = (KProperty1)null.INSTANCE;
         Object var503;
         if (var1 instanceof HasDualOscillation) {
            var503 = var502.get(var1);
         } else {
            var503 = null;
         }

         DualOscillationConfig var511;
         label1352: {
            var511 = (DualOscillationConfig)var503;
            DualOscillationConfig var504 = var511;
            if (var511 == null) {
               if (var2 != null) {
                  var511 = var2.getDualOscillationConfig();
               } else {
                  var511 = null;
               }

               var504 = var511;
               if (var511 == null) {
                  var511 = new DualOscillationConfig(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, (DefaultConstructorMarker)null);
                  break label1352;
               }
            }

            var511 = var504;
         }

         KProperty1 var505 = (KProperty1)null.INSTANCE;
         Object var506;
         if (var1 instanceof HasRpm) {
            var506 = var505.get(var1);
         } else {
            var506 = null;
         }

         int var49;
         label1345: {
            Integer var507 = (Integer)var506;
            if (var507 == null) {
               if (var2 != null) {
                  var507 = var2.getRpm1();
               } else {
                  var507 = null;
               }

               if (var507 == null) {
                  var49 = 0;
                  break label1345;
               }
            }

            var49 = var507;
         }

         KProperty1 var508 = (KProperty1)null.INSTANCE;
         Object var127;
         if (var84) {
            var127 = var508.get(var1);
         } else {
            var127 = null;
         }

         double[] var509 = (double[])var127;
         double[] var128 = var509;
         if (var509 == null) {
            double[] var129;
            if (var2 != null) {
               var129 = var2.getNightPeriods();
            } else {
               var129 = null;
            }

            var128 = var129;
            if (var129 == null) {
               var128 = new double[]{(double)8.0F, (double)7.0F, (double)4.0F, (double)0.0F};
            }
         }

         return new DeviceEntity(var121, var122, var123, var50, var95, var96, var97, var98, var99, var100, var60, var124, var131, var83, var61, var62, var101, var51, var58, var102, var103, var104, var105, var106, var107, var108, var109, var110, var111, var112, var187, var237, var249, var254, var258, var8, var63, var64, var65, var66, var67, var68, var113, var69, var114, var70, var116, var115, var125, var126, var117, var118, var119, var71, var72, var9, var52, var10, var73, var11, var12, var13, var14, var54, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var3, var5, var25, var26, var27, var387, var28, var402, var74, var29, var30, var31, var75, var32, var76, var77, var33, var34, var78, var79, var35, var36, var37, var38, var39, var40, var41, var42, var80, var120, var43, var44, var478, var45, var81, var82, var46, var47, var48, var56, var511, var49, var128);
      }

      public final DeviceEntity fromDeviceOnAblServer(DeviceDetailsOnAblServer var1, DeviceEntity var2) {
         Intrinsics.checkNotNullParameter(var1, "deviceOnAbl");
         DeviceType var21 = DeviceType.Companion.fromSkuCompat(var1.getCompatibility());
         String var49 = DeviceType.Companion.displayNameFromSkuCompat(var1.getCompatibility());
         Timber.Forest var20 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("FromDeviceOnAblServer: DeviceType == ");
         var22.append(var21);
         var22.append(" for ");
         var22.append(var1);
         var22.append(". Saving with index ");
         var22.append(var21.getIndex());
         var20.d(var22.toString(), new Object[0]);
         String var50 = var1.getUuid();
         String var53 = var1.getName();
         String var26 = var53;
         if (var53 == null) {
            var26 = "";
         }

         int var5 = var21.getIndex();
         Integer var27;
         if (var2 != null) {
            var27 = var2.getFanSpeed();
         } else {
            var27 = null;
         }

         Integer var28;
         if (var2 != null) {
            var28 = var2.getFilterLife();
         } else {
            var28 = null;
         }

         String var29;
         if (var2 != null) {
            var29 = var2.getAutoModeText();
         } else {
            var29 = null;
         }

         Integer var30;
         if (var2 != null) {
            var30 = var2.getBrightness();
         } else {
            var30 = null;
         }

         String var31;
         if (var2 != null) {
            var31 = var2.getInfo();
         } else {
            var31 = null;
         }

         DeviceUuidEntity var32;
         if (var2 != null) {
            var32 = var2.getDeviceUuid();
         } else {
            var32 = null;
         }

         IndoorDatapoint var33;
         if (var2 != null) {
            var33 = var2.getLatestSensorDatapoint();
         } else {
            var33 = null;
         }

         Integer var34;
         if (var2 != null) {
            var34 = var2.getLastSelectedSensorType();
         } else {
            var34 = null;
         }

         boolean var6;
         if (var2 != null) {
            var6 = var2.isNightModeOn();
         } else {
            var6 = false;
         }

         boolean var7;
         if (var2 != null) {
            var7 = var2.isChildLockOn();
         } else {
            var7 = false;
         }

         String var35;
         if (var2 != null) {
            var35 = var2.getLinkedDeviceUid();
         } else {
            var35 = null;
         }

         int var3;
         if (var2 != null) {
            var3 = var2.getConnectivityStatusIndex();
         } else {
            var3 = ConnectivityStatus.ONLINE.ordinal();
         }

         long var16;
         if (var2 != null) {
            var16 = var2.getLastConnectivityMillis();
         } else {
            var16 = 0L;
         }

         String var55 = var1.getMac();
         var53 = var55;
         if (var55 == null) {
            if (var2 != null) {
               var55 = var2.getMac();
            } else {
               var55 = null;
            }

            var53 = var55;
            if (var55 == null) {
               var53 = "";
            }
         }

         String var58 = var1.getMcuFirmware();
         var55 = var58;
         if (var58 == null) {
            if (var2 != null) {
               var58 = var2.getMcuFirmware();
            } else {
               var58 = null;
            }

            var55 = var58;
            if (var58 == null) {
               var55 = "";
            }
         }

         String var23 = var1.getFirmware();
         var58 = var23;
         if (var23 == null) {
            if (var2 != null) {
               var23 = var2.getWifiFirmware();
            } else {
               var23 = null;
            }

            var58 = var23;
            if (var23 == null) {
               var58 = "";
            }
         }

         String var36;
         label288: {
            if (var2 != null) {
               var23 = var2.getHardware();
               var36 = var23;
               if (var23 != null) {
                  break label288;
               }
            }

            var36 = "";
         }

         String var24 = var1.getTimezone();
         var23 = var24;
         if (var24 == null) {
            if (var2 != null) {
               var24 = var2.getTimeZone();
            } else {
               var24 = null;
            }

            var23 = var24;
            if (var24 == null) {
               var23 = "";
            }
         }

         String var25 = var1.getAimSerialNumber();
         var24 = var25;
         if (var25 == null) {
            if (var2 != null) {
               var25 = var2.getSerial();
            } else {
               var25 = null;
            }

            var24 = var25;
            if (var25 == null) {
               var24 = "";
            }
         }

         label280: {
            if (var2 != null) {
               String var37 = var2.getPurchaseDate();
               var25 = var37;
               if (var37 != null) {
                  break label280;
               }
            }

            var25 = "";
         }

         String var68;
         label275: {
            if (var2 != null) {
               String var38 = var2.getDealerName();
               var68 = var38;
               if (var38 != null) {
                  break label275;
               }
            }

            var68 = "";
         }

         String var69;
         label270: {
            if (var2 != null) {
               String var39 = var2.getDealerCountry();
               var69 = var39;
               if (var39 != null) {
                  break label270;
               }
            }

            var69 = "";
         }

         String var70;
         label265: {
            if (var2 != null) {
               String var40 = var2.getFilterType();
               var70 = var40;
               if (var40 != null) {
                  break label265;
               }
            }

            var70 = "";
         }

         String var71;
         label260: {
            if (var2 != null) {
               String var41 = var2.getFilterTrigger();
               var71 = var41;
               if (var41 != null) {
                  break label260;
               }
            }

            var71 = "";
         }

         double[] var72;
         label255: {
            if (var2 != null) {
               var72 = var2.getPm1Ranges();
               if (var72 != null) {
                  break label255;
               }
            }

            var72 = new double[0];
         }

         double[] var42;
         label250: {
            if (var2 != null) {
               double[] var43 = var2.getPm10Ranges();
               var42 = var43;
               if (var43 != null) {
                  break label250;
               }
            }

            var42 = new double[0];
         }

         double[] var73;
         label245: {
            if (var2 != null) {
               double[] var44 = var2.getPm25Ranges();
               var73 = var44;
               if (var44 != null) {
                  break label245;
               }
            }

            var73 = new double[0];
         }

         double[] var74;
         label240: {
            if (var2 != null) {
               double[] var45 = var2.getVocRanges();
               var74 = var45;
               if (var45 != null) {
                  break label240;
               }
            }

            var74 = new double[0];
         }

         double[] var75;
         label235: {
            if (var2 != null) {
               double[] var46 = var2.getHchoRanges();
               var75 = var46;
               if (var46 != null) {
                  break label235;
               }
            }

            var75 = new double[0];
         }

         int var4;
         if (var2 != null) {
            var4 = var2.getUpdateProgress();
         } else {
            var4 = 0;
         }

         boolean var8;
         if (var2 != null) {
            var8 = var2.isStandByOn();
         } else {
            var8 = false;
         }

         boolean var9;
         if (var2 != null) {
            var9 = var2.isEcoModeOn();
         } else {
            var9 = false;
         }

         boolean var10;
         if (var2 != null) {
            var10 = var2.isHinsModeOn();
         } else {
            var10 = false;
         }

         boolean var11;
         if (var2 != null) {
            var11 = var2.isHinsNightModeOn();
         } else {
            var11 = false;
         }

         boolean var12;
         if (var2 != null) {
            var12 = var2.isG4NightModeOn();
         } else {
            var12 = false;
         }

         boolean var13;
         if (var2 != null) {
            var13 = var2.isGermShieldOn();
         } else {
            var13 = false;
         }

         Boolean var76;
         if (var2 != null) {
            var76 = var2.isGermShieldNightModeOn();
         } else {
            var76 = null;
         }

         boolean var14;
         if (var2 != null) {
            var14 = var2.isSafetySwitchOn();
         } else {
            var14 = true;
         }

         String var47;
         label229: {
            if (var2 != null) {
               String var48 = var2.getG4NightModefilterTrigger();
               var47 = var48;
               if (var48 != null) {
                  break label229;
               }
            }

            var47 = "";
         }

         boolean var15;
         label224: {
            if (var1.getAimSerialNumber() != null) {
               Long var77 = var1.getAimUpdateDate();
               long var18;
               if (var77 != null) {
                  var18 = var77;
               } else {
                  var18 = -1L;
               }

               if (var18 > 0L) {
                  var15 = true;
                  break label224;
               }
            }

            var15 = false;
         }

         String var78 = var1.getCompatibility();
         WelcomeHomeLocation var51;
         if (var2 != null) {
            var51 = var2.getWelcomeHome();
         } else {
            var51 = null;
         }

         String var52;
         if (var2 != null) {
            var52 = var2.getLocationId();
         } else {
            var52 = null;
         }

         return new DeviceEntity(var50, var26, var49, var5, var27, var28, var29, var30, var31, var32, true, var33, var34, true, var6, var7, var35, var3, var16, var53, var55, var58, var36, var23, var24, var25, var68, var69, var70, var71, var72, var42, var73, var74, var75, var4, var8, var9, var10, var11, var12, var13, var76, var14, var47, var15, (String)null, var78, var51, var52, (Boolean)null, (Integer)null, (Long)null, false, false, 0, 0L, 0, false, 0, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (double)0.0F, (double)0.0F, 0, 0, 0, (double[])null, 0, (double[])null, false, 0, 0, 0, false, 0, false, false, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, false, (Boolean)null, 0, 0, (List)null, 0, false, false, 0, 0, 0, 0L, (DualOscillationConfig)null, 0, (double[])null, 0, -245760, -1, 2097151, (DefaultConstructorMarker)null);
      }

      public final DeviceEntity fromDeviceOnBlueServer(DeviceOnBlueServer var1, DeviceEntity var2, boolean var3) {
         String var76;
         label614: {
            Intrinsics.checkNotNullParameter(var1, "deviceOnBlueServer");
            if (var2 != null) {
               String var77 = var2.getSku();
               var76 = var77;
               if (var77 != null) {
                  break label614;
               }
            }

            var76 = var1.getDeviceType();
         }

         String var114;
         String var115;
         String var119;
         label609: {
            var114 = DeviceType.Companion.displayNameFromSkuCompat(var76);
            var115 = var1.getUuid();
            if (var2 != null) {
               String var78 = var2.getName();
               var119 = var78;
               if (var78 != null) {
                  break label609;
               }
            }

            var119 = var114;
         }

         int var8;
         if (var2 != null) {
            var8 = var2.getTypeIndex();
         } else {
            var8 = DeviceType.Companion.fromName(var1.getDeviceType()).getIndex();
         }

         Integer var120;
         if (var2 != null) {
            var120 = var2.getFanSpeed();
         } else {
            var120 = null;
         }

         Integer var79;
         if (var2 != null) {
            var79 = var2.getFilterLife();
         } else {
            var79 = null;
         }

         String var80;
         if (var2 != null) {
            var80 = var2.getAutoModeText();
         } else {
            var80 = null;
         }

         Integer var81;
         if (var2 != null) {
            var81 = var2.getBrightness();
         } else {
            var81 = null;
         }

         String var82;
         if (var2 != null) {
            var82 = var2.getInfo();
         } else {
            var82 = null;
         }

         DeviceUuidEntity var83;
         if (var2 != null) {
            var83 = var2.getDeviceUuid();
         } else {
            var83 = null;
         }

         IndoorDatapoint var84;
         if (var2 != null) {
            var84 = var2.getLatestSensorDatapoint();
         } else {
            var84 = null;
         }

         Integer var85;
         if (var2 != null) {
            var85 = var2.getLastSelectedSensorType();
         } else {
            var85 = null;
         }

         if (var2 != null) {
            var3 = var2.isNightModeOn();
         } else {
            var3 = false;
         }

         boolean var51;
         if (var2 != null) {
            var51 = var2.isChildLockOn();
         } else {
            var51 = false;
         }

         String var86;
         if (var2 != null) {
            var86 = var2.getLinkedDeviceUid();
         } else {
            var86 = null;
         }

         int var9;
         if (var2 != null) {
            var9 = var2.getConnectivityStatusIndex();
         } else {
            var9 = ConnectivityStatus.ONLINE.ordinal();
         }

         long var74 = 0L;
         long var68;
         if (var2 != null) {
            var68 = var2.getLastConnectivityMillis();
         } else {
            var68 = 0L;
         }

         String var87;
         label603: {
            if (var2 != null) {
               String var88 = var2.getMac();
               var87 = var88;
               if (var88 != null) {
                  break label603;
               }
            }

            var87 = "";
         }

         String var89 = var1.getMcuFirmware();
         String var121 = var89;
         if (var89 == null) {
            var121 = "";
         }

         var89 = var1.getWifiFirmware();
         String var116 = var89;
         if (var89 == null) {
            var116 = "";
         }

         label595: {
            if (var2 != null) {
               String var90 = var2.getHardware();
               var89 = var90;
               if (var90 != null) {
                  break label595;
               }
            }

            var89 = "";
         }

         String var124;
         label590: {
            if (var2 != null) {
               String var91 = var2.getTimeZone();
               var124 = var91;
               if (var91 != null) {
                  break label590;
               }
            }

            var124 = "";
         }

         String var125;
         label585: {
            if (var2 != null) {
               String var92 = var2.getSerial();
               var125 = var92;
               if (var92 != null) {
                  break label585;
               }
            }

            var125 = "";
         }

         String var126;
         label580: {
            if (var2 != null) {
               String var93 = var2.getPurchaseDate();
               var126 = var93;
               if (var93 != null) {
                  break label580;
               }
            }

            var126 = "";
         }

         String var127;
         label575: {
            if (var2 != null) {
               String var94 = var2.getDealerName();
               var127 = var94;
               if (var94 != null) {
                  break label575;
               }
            }

            var127 = "";
         }

         String var128;
         label570: {
            if (var2 != null) {
               String var95 = var2.getDealerCountry();
               var128 = var95;
               if (var95 != null) {
                  break label570;
               }
            }

            var128 = "";
         }

         String var129;
         label565: {
            if (var2 != null) {
               String var96 = var2.getFilterType();
               var129 = var96;
               if (var96 != null) {
                  break label565;
               }
            }

            var129 = "";
         }

         String var130;
         label560: {
            if (var2 != null) {
               String var97 = var2.getFilterTrigger();
               var130 = var97;
               if (var97 != null) {
                  break label560;
               }
            }

            var130 = "";
         }

         double[] var131;
         label555: {
            if (var2 != null) {
               double[] var98 = var2.getPm1Ranges();
               var131 = var98;
               if (var98 != null) {
                  break label555;
               }
            }

            var131 = new double[0];
         }

         double[] var132;
         label550: {
            if (var2 != null) {
               double[] var99 = var2.getPm10Ranges();
               var132 = var99;
               if (var99 != null) {
                  break label550;
               }
            }

            var132 = new double[0];
         }

         double[] var133;
         label545: {
            if (var2 != null) {
               var133 = var2.getPm25Ranges();
               if (var133 != null) {
                  break label545;
               }
            }

            var133 = new double[0];
         }

         double[] var100;
         label540: {
            if (var2 != null) {
               double[] var101 = var2.getVocRanges();
               var100 = var101;
               if (var101 != null) {
                  break label540;
               }
            }

            var100 = new double[0];
         }

         double[] var134;
         label535: {
            if (var2 != null) {
               var134 = var2.getHchoRanges();
               if (var134 != null) {
                  break label535;
               }
            }

            var134 = new double[0];
         }

         int var10;
         if (var2 != null) {
            var10 = var2.getUpdateProgress();
         } else {
            var10 = 0;
         }

         boolean var52;
         if (var2 != null) {
            var52 = var2.isStandByOn();
         } else {
            var52 = false;
         }

         boolean var53;
         if (var2 != null) {
            var53 = var2.isEcoModeOn();
         } else {
            var53 = false;
         }

         boolean var54;
         if (var2 != null) {
            var54 = var2.isG4NightModeOn();
         } else {
            var54 = false;
         }

         boolean var55;
         if (var2 != null) {
            var55 = var2.isGermShieldOn();
         } else {
            var55 = false;
         }

         Boolean var102;
         if (var2 != null) {
            var102 = var2.isGermShieldNightModeOn();
         } else {
            var102 = null;
         }

         boolean var56;
         if (var2 != null) {
            var56 = var2.isSafetySwitchOn();
         } else {
            var56 = true;
         }

         String var103;
         label529: {
            if (var2 != null) {
               var103 = var2.getG4NightModefilterTrigger();
               if (var103 != null) {
                  break label529;
               }
            }

            var103 = "";
         }

         WelcomeHomeLocation var104;
         if (var2 != null) {
            var104 = var2.getWelcomeHome();
         } else {
            var104 = null;
         }

         String var105;
         if (var2 != null) {
            var105 = var2.getLocationId();
         } else {
            var105 = null;
         }

         Boolean var106;
         if (var2 != null) {
            var106 = var2.getDisinfection();
         } else {
            var106 = null;
         }

         Integer var107;
         if (var2 != null) {
            var107 = var2.getDisinfectLeftTime();
         } else {
            var107 = null;
         }

         Long var108;
         if (var2 != null) {
            var108 = var2.getDisinfectLeftTimeUpdateTime();
         } else {
            var108 = null;
         }

         boolean var57;
         if (var2 != null) {
            var57 = var2.getWickdryEnabled();
         } else {
            var57 = false;
         }

         boolean var58;
         if (var2 != null) {
            var58 = var2.getWickdryOn();
         } else {
            var58 = false;
         }

         int var11;
         if (var2 != null) {
            var11 = var2.getWickdryLeftTime();
         } else {
            var11 = 0;
         }

         long var70;
         if (var2 != null) {
            var70 = var2.getWickdryLeftTimeUpdateTime();
         } else {
            var70 = 0L;
         }

         int var12;
         if (var2 != null) {
            var12 = var2.getWickUsage();
         } else {
            var12 = 0;
         }

         boolean var59;
         if (var2 != null) {
            var59 = var2.getWaterShortage();
         } else {
            var59 = false;
         }

         int var13;
         if (var2 != null) {
            var13 = var2.getAutoRh();
         } else {
            var13 = 50;
         }

         int var14;
         if (var2 != null) {
            var14 = var2.getTimerStatus();
         } else {
            var14 = 0;
         }

         int var15;
         if (var2 != null) {
            var15 = var2.getTimerDuration();
         } else {
            var15 = 0;
         }

         int var16;
         if (var2 != null) {
            var16 = var2.getTimerLeftTime();
         } else {
            var16 = 0;
         }

         long var72;
         if (var2 != null) {
            var72 = var2.getTimerLeftTimeUpdateTime();
         } else {
            var72 = 0L;
         }

         int var17;
         if (var2 != null) {
            var17 = var2.getTemperatureUnit();
         } else {
            var17 = 0;
         }

         int var18;
         if (var2 != null) {
            var18 = var2.getOscillationState();
         } else {
            var18 = 0;
         }

         int var19;
         if (var2 != null) {
            var19 = var2.getOscillationAngle();
         } else {
            var19 = 90;
         }

         int var20;
         if (var2 != null) {
            var20 = var2.getOscillationDirection();
         } else {
            var20 = 0;
         }

         int var21;
         if (var2 != null) {
            var21 = var2.getOscillationFanSpeed();
         } else {
            var21 = 0;
         }

         int var22;
         if (var2 != null) {
            var22 = var2.getMainMode();
         } else {
            var22 = 0;
         }

         int var23;
         if (var2 != null) {
            var23 = var2.getApSubMode();
         } else {
            var23 = 2;
         }

         int var24;
         if (var2 != null) {
            var24 = var2.getApFanSpeed();
         } else {
            var24 = 0;
         }

         int var25;
         if (var2 != null) {
            var25 = var2.getHeatSubMode();
         } else {
            var25 = 2;
         }

         int var26;
         if (var2 != null) {
            var26 = var2.getHeatFanSpeed();
         } else {
            var26 = 0;
         }

         double var6 = (double)22.0F;
         double var4;
         if (var2 != null) {
            var4 = var2.getHeatAutoTmp();
         } else {
            var4 = (double)22.0F;
         }

         if (var2 != null) {
            var6 = var2.getHeatEcoTmp();
         }

         int var27;
         if (var2 != null) {
            var27 = var2.getCoolSubMode();
         } else {
            var27 = 2;
         }

         int var28;
         if (var2 != null) {
            var28 = var2.getCoolFanSpeed();
         } else {
            var28 = 0;
         }

         int var29;
         if (var2 != null) {
            var29 = var2.getCoolAutoTag();
         } else {
            var29 = 0;
         }

         double[] var109;
         label520: {
            if (var2 != null) {
               var109 = var2.getCoolAutoPresets();
               if (var109 != null) {
                  break label520;
               }
            }

            var109 = new double[]{(double)20.0F, (double)23.0F, (double)25.0F};
         }

         int var30;
         if (var2 != null) {
            var30 = var2.getCoolEcoTag();
         } else {
            var30 = 0;
         }

         double[] var110;
         label514: {
            if (var2 != null) {
               var110 = var2.getCoolEcoPresets();
               if (var110 != null) {
                  break label514;
               }
            }

            var110 = new double[]{(double)20.0F, (double)25.0F};
         }

         int var31;
         if (var2 != null) {
            var31 = var2.getMode();
         } else {
            var31 = 1;
         }

         boolean var60;
         if (var2 != null) {
            var60 = var2.getHumMode();
         } else {
            var60 = false;
         }

         int var32;
         if (var2 != null) {
            var32 = var2.getWaterLevel();
         } else {
            var32 = 0;
         }

         int var33;
         if (var2 != null) {
            var33 = var2.getDehSubMode();
         } else {
            var33 = 1;
         }

         boolean var61;
         if (var2 != null) {
            var61 = var2.getWaterTankFailure();
         } else {
            var61 = false;
         }

         int var34;
         if (var2 != null) {
            var34 = var2.getSmartSubMode();
         } else {
            var34 = 0;
         }

         boolean var62;
         if (var2 != null) {
            var62 = var2.getDetectCat();
         } else {
            var62 = false;
         }

         boolean var63;
         if (var2 != null) {
            var63 = var2.getBodyMounted();
         } else {
            var63 = true;
         }

         int var35;
         if (var2 != null) {
            var35 = var2.getCleanAirEta();
         } else {
            var35 = 0;
         }

         int var36;
         if (var2 != null) {
            var36 = var2.getPanelDisplayMode();
         } else {
            var36 = 0;
         }

         boolean var64;
         if (var2 != null) {
            var64 = var2.getHoverEnabled();
         } else {
            var64 = true;
         }

         boolean var65;
         if (var2 != null) {
            var65 = var2.getAirRefreshEnabled();
         } else {
            var65 = true;
         }

         int var37;
         if (var2 != null) {
            var37 = var2.getAirRefreshStatus();
         } else {
            var37 = 0;
         }

         int var38;
         if (var2 != null) {
            var38 = var2.getAirRefreshDuration();
         } else {
            var38 = 0;
         }

         int var39;
         if (var2 != null) {
            var39 = var2.getAirRefreshTimeStamp();
         } else {
            var39 = 0;
         }

         int var40;
         if (var2 != null) {
            var40 = var2.getAirRefreshStartTimeStamp();
         } else {
            var40 = 0;
         }

         int var41;
         if (var2 != null) {
            var41 = var2.getAirRefreshEndTimeStamp();
         } else {
            var41 = 0;
         }

         int var42;
         if (var2 != null) {
            var42 = var2.getRoomType();
         } else {
            var42 = 0;
         }

         int var43;
         if (var2 != null) {
            var43 = var2.getNightLampBrightness();
         } else {
            var43 = 0;
         }

         int var44;
         if (var2 != null) {
            var44 = var2.getWickdryDuration();
         } else {
            var44 = 0;
         }

         boolean var66;
         if (var2 != null) {
            var66 = var2.getWickdryDone();
         } else {
            var66 = false;
         }

         Boolean var111;
         if (var2 != null) {
            var111 = var2.getYwrmEnabled();
         } else {
            var111 = null;
         }

         int var45;
         if (var2 != null) {
            var45 = var2.getYwrmUsage();
         } else {
            var45 = 0;
         }

         int var46;
         if (var2 != null) {
            var46 = var2.getNightLampSteplessBrightness();
         } else {
            var46 = 0;
         }

         List var112;
         label508: {
            if (var2 != null) {
               List var113 = var2.getAlarms();
               var112 = var113;
               if (var113 != null) {
                  break label508;
               }
            }

            var112 = this.getNULL_ALARM_LIST();
         }

         int var47;
         if (var2 != null) {
            var47 = var2.getHumSubMode();
         } else {
            var47 = 2;
         }

         boolean var67;
         if (var2 != null) {
            var67 = var2.getUse24Hour();
         } else {
            var67 = true;
         }

         int var48;
         if (var2 != null) {
            var48 = var2.getCoolFanSpeedLevel();
         } else {
            var48 = 1;
         }

         int var49;
         if (var2 != null) {
            var49 = var2.getCoolAutoLevel();
         } else {
            var49 = 0;
         }

         if (var2 != null) {
            var74 = var2.getNightModeStartTime();
         }

         DualOscillationConfig var135;
         label502: {
            if (var2 != null) {
               var135 = var2.getDualOscillationConfig();
               if (var135 != null) {
                  break label502;
               }
            }

            var135 = new DualOscillationConfig(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, (DefaultConstructorMarker)null);
         }

         int var50;
         if (var2 != null) {
            var50 = var2.getRpm1();
         } else {
            var50 = 0;
         }

         double[] var117;
         if (var2 != null) {
            var117 = var2.getNightPeriods();
            if (var117 != null) {
               return new DeviceEntity(var115, var119, var114, var8, var120, var79, var80, var81, var82, var83, true, var84, var85, false, var3, var51, var86, var9, var68, var87, var121, var116, var89, var124, var125, var126, var127, var128, var129, var130, var131, var132, var133, var100, var134, var10, var52, var53, false, false, var54, var55, var102, var56, var103, false, var76, (String)null, var104, var105, var106, var107, var108, var57, var58, var11, var70, var12, var59, var13, var14, var15, var16, var72, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var4, var6, var27, var28, var29, var109, var30, var110, var60, var31, var32, var33, var61, var34, var62, var63, var35, var36, var64, var65, var37, var38, var39, var40, var41, var42, var43, var44, var66, var111, var45, var46, var112, var47, var67, false, 0, var48, var49, var74, var135, var50, var117, 0, 41152, 0, 24576, (DefaultConstructorMarker)null);
            }
         }

         var117 = new double[]{(double)8.0F, (double)7.0F, (double)4.0F, (double)0.0F};
         return new DeviceEntity(var115, var119, var114, var8, var120, var79, var80, var81, var82, var83, true, var84, var85, false, var3, var51, var86, var9, var68, var87, var121, var116, var89, var124, var125, var126, var127, var128, var129, var130, var131, var132, var133, var100, var134, var10, var52, var53, false, false, var54, var55, var102, var56, var103, false, var76, (String)null, var104, var105, var106, var107, var108, var57, var58, var11, var70, var12, var59, var13, var14, var15, var16, var72, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var4, var6, var27, var28, var29, var109, var30, var110, var60, var31, var32, var33, var61, var34, var62, var63, var35, var36, var64, var65, var37, var38, var39, var40, var41, var42, var43, var44, var66, var111, var45, var46, var112, var47, var67, false, 0, var48, var49, var74, var135, var50, var117, 0, 41152, 0, 24576, (DefaultConstructorMarker)null);
      }

      public final List getNULL_ALARM_LIST() {
         return DeviceEntity.NULL_ALARM_LIST;
      }
   }
}
