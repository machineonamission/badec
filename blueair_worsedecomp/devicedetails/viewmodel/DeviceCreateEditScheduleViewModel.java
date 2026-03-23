package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.format.DateFormat;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleInstruction;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicedetails.util.DeviceScheduleUtils;
import com.blueair.devicemanager.DeviceScheduleService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.AppEventsConstants;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004÷\u0001ø\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010Ô\u0001\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020,H\u0002JI\u0010×\u0001\u001a\u00030Õ\u00012?\u0010×\u0001\u001a:\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Û\u0001\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Ü\u0001\u0012\u0005\u0012\u00030Õ\u00010Ø\u0001J\u0019\u0010Û\u0001\u001a\u00020@2\u000e\u0010Ý\u0001\u001a\t\u0012\u0004\u0012\u00020,0Þ\u0001H\u0002J\t\u0010ß\u0001\u001a\u00020@H\u0002J~\u0010à\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u001e2\u0007\u0010â\u0001\u001a\u00020\"2\u0007\u0010ã\u0001\u001a\u00020k2\u0007\u0010ä\u0001\u001a\u00020q2\u0007\u0010å\u0001\u001a\u00020v2\u0007\u0010æ\u0001\u001a\u00020~2\b\u0010ç\u0001\u001a\u00030\u00012\b\u0010è\u0001\u001a\u00030\u00012\b\u0010é\u0001\u001a\u00030\u00012\u0007\u0010ê\u0001\u001a\u00020@2\u0007\u0010ë\u0001\u001a\u00020@H\u0002J\u0019\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0019\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001b\u0010î\u0001\u001a\f\u0012\u0005\u0012\u00030á\u0001\u0018\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\f\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0002J1\u0010ñ\u0001\u001a\u00030Õ\u00012'\u0010×\u0001\u001a\"\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Ü\u0001\u0012\u0005\u0012\u00030Õ\u00010ò\u0001J\t\u0010Ð\u0001\u001a\u00020@H\u0002J\u0011\u0010ó\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u0001H\u0002J\u0012\u0010ô\u0001\u001a\u00030Õ\u00012\b\u0010õ\u0001\u001a\u00030ö\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0017\u001a\u0004\u0018\u00010,@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b:\u00105R\u0011\u0010;\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b<\u00105R\u0011\u0010=\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b>\u00105R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020E@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020E@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR0\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020O0N@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u0010XR\u001b\u0010Y\u001a\u0002038FX\u0002¢\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bZ\u00105R\u0011\u0010\\\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b]\u00105R$\u0010^\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010!\"\u0004\b`\u0010aR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001e0'¢\u0006\b\n\u0000\u001a\u0004\bc\u0010)R$\u0010d\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010%\"\u0004\bf\u0010gR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\"0'¢\u0006\b\n\u0000\u001a\u0004\bi\u0010)R\u001a\u0010j\u001a\u00020kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020qX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010w\u001a\u00020v2\u0006\u0010\u0017\u001a\u00020v@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020v0'¢\u0006\b\n\u0000\u001a\u0004\b}\u0010)R(\u0010\u001a\u00020~2\u0006\u0010\u0017\u001a\u00020~@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020@X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010B\"\u0005\b\u0001\u0010DR\u001d\u0010\u0001\u001a\u00020@X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010B\"\u0005\b\u0001\u0010DR \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010%\"\u0005\b\u0001\u0010gR\u001d\u0010\u0001\u001a\u00020kX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010m\"\u0005\b\u0001\u0010oR\u0019\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002030'¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010)R'\u0010¡\u0001\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010!\"\u0005\b£\u0001\u0010aR\u0019\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0'¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010)R'\u0010¦\u0001\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010%\"\u0005\b¨\u0001\u0010gR\u0019\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\"0'¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010)R\u001d\u0010«\u0001\u001a\u00020kX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010m\"\u0005\b­\u0001\u0010oR\u001d\u0010®\u0001\u001a\u00020qX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010s\"\u0005\b°\u0001\u0010uR'\u0010±\u0001\u001a\u00020v2\u0006\u0010\u0017\u001a\u00020v@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010y\"\u0005\b³\u0001\u0010{R\u0019\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020v0'¢\u0006\t\n\u0000\u001a\u0005\bµ\u0001\u0010)R)\u0010¶\u0001\u001a\u00020~2\u0006\u0010\u0017\u001a\u00020~@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010\u0001\"\u0006\b¸\u0001\u0010\u0001R \u0010¹\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010\u0001\"\u0006\b»\u0001\u0010\u0001R \u0010¼\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010\u0001\"\u0006\b¾\u0001\u0010\u0001R\u001d\u0010¿\u0001\u001a\u00020@X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010B\"\u0005\bÁ\u0001\u0010DR\u001d\u0010Â\u0001\u001a\u00020@X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010B\"\u0005\bÄ\u0001\u0010DR \u0010Å\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0001\"\u0006\bÇ\u0001\u0010\u0001R\u0019\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bÉ\u0001\u0010)R\u0019\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bË\u0001\u0010)R\u001b\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020@0Í\u0001¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bÐ\u0001\u0010)R'\u0010Ñ\u0001\u001a\u00020@2\u0006\u0010\u0017\u001a\u00020@8F@FX\u000e¢\u0006\u000e\u001a\u0005\bÒ\u0001\u0010B\"\u0005\bÓ\u0001\u0010D¨\u0006ù\u0001"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "deviceScheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getDeviceScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceScheduleService$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "getState", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "setState", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;)V", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "defaultPurifierMode", "getDefaultPurifierMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "Lcom/blueair/core/model/FanSpeedEnum;", "defaultFanSpeed", "getDefaultFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "liveDevice", "Landroidx/lifecycle/MutableLiveData;", "getLiveDevice", "()Landroidx/lifecycle/MutableLiveData;", "setLiveDevice", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/blueair/core/model/DeviceScheduleMerged;", "editingSchedule", "getEditingSchedule", "()Lcom/blueair/core/model/DeviceScheduleMerged;", "setEditingSchedule", "(Lcom/blueair/core/model/DeviceScheduleMerged;)V", "title", "", "getTitle", "()Ljava/lang/String;", "currentTimeFormatter", "Ljava/text/SimpleDateFormat;", "timeFormatter", "displayStartTime", "getDisplayStartTime", "displayEndTime", "getDisplayEndTime", "displayRepeat", "getDisplayRepeat", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "Ljava/util/Calendar;", "startTime", "getStartTime", "()Ljava/util/Calendar;", "setStartTime", "(Ljava/util/Calendar;)V", "endTime", "getEndTime", "setEndTime", "", "Lcom/blueair/core/model/DayOfWeek;", "repeat", "getRepeat", "()Ljava/util/Set;", "setRepeat", "(Ljava/util/Set;)V", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "defaultLabel", "getDefaultLabel", "defaultLabel$delegate", "displayLabel", "getDisplayLabel", "purifierMode", "getPurifierMode", "setPurifierMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "livePurifierMode", "getLivePurifierMode", "startFanSpeed", "getStartFanSpeed", "setStartFanSpeed", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "liveStartFanSpeed", "getLiveStartFanSpeed", "startBrightness", "", "getStartBrightness", "()Ljava/lang/Object;", "setStartBrightness", "(Ljava/lang/Object;)V", "startAutoRh", "", "getStartAutoRh", "()I", "setStartAutoRh", "(I)V", "Lcom/blueair/core/model/MainMode;", "startMainMode", "getStartMainMode", "()Lcom/blueair/core/model/MainMode;", "setStartMainMode", "(Lcom/blueair/core/model/MainMode;)V", "liveMainMode", "getLiveMainMode", "Lcom/blueair/core/model/ApSubMode;", "startApSubMode", "getStartApSubMode", "()Lcom/blueair/core/model/ApSubMode;", "setStartApSubMode", "(Lcom/blueair/core/model/ApSubMode;)V", "startHeatAutoTemp", "", "getStartHeatAutoTemp", "()D", "setStartHeatAutoTemp", "(D)V", "startHeatEcoTemp", "getStartHeatEcoTemp", "setStartHeatEcoTemp", "startOscillationEnabled", "getStartOscillationEnabled", "setStartOscillationEnabled", "startHumMode", "getStartHumMode", "setStartHumMode", "startSmartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "getStartSmartSubMode", "()Lcom/blueair/core/model/SmartSubMode;", "setStartSmartSubMode", "(Lcom/blueair/core/model/SmartSubMode;)V", "endFanSpeed", "getEndFanSpeed", "setEndFanSpeed", "endBrightness", "getEndBrightness", "setEndBrightness", "scheduleEndType", "getScheduleEndType", "scheduleEndCustomMode", "getScheduleEndCustomMode", "setScheduleEndCustomMode", "liveScheduleEndCustomMode", "getLiveScheduleEndCustomMode", "scheduleEndCustomFanSpeed", "getScheduleEndCustomFanSpeed", "setScheduleEndCustomFanSpeed", "liveScheduleEndCustomFanSpeed", "getLiveScheduleEndCustomFanSpeed", "scheduleEndCustomBrightness", "getScheduleEndCustomBrightness", "setScheduleEndCustomBrightness", "scheduleEndCustomAutoRh", "getScheduleEndCustomAutoRh", "setScheduleEndCustomAutoRh", "scheduleEndCustomMainMode", "getScheduleEndCustomMainMode", "setScheduleEndCustomMainMode", "liveScheduleEndCustomMainMode", "getLiveScheduleEndCustomMainMode", "scheduleEndCustomApSubMode", "getScheduleEndCustomApSubMode", "setScheduleEndCustomApSubMode", "scheduleEndCustomHeatAutoTemp", "getScheduleEndCustomHeatAutoTemp", "setScheduleEndCustomHeatAutoTemp", "scheduleEndCustomHeatEcoTemp", "getScheduleEndCustomHeatEcoTemp", "setScheduleEndCustomHeatEcoTemp", "scheduleEndCustomOscillationEnabled", "getScheduleEndCustomOscillationEnabled", "setScheduleEndCustomOscillationEnabled", "scheduleEndCustomHumMode", "getScheduleEndCustomHumMode", "setScheduleEndCustomHumMode", "scheduleEndCustomSmartSubMode", "getScheduleEndCustomSmartSubMode", "setScheduleEndCustomSmartSubMode", "validState", "getValidState", "requesting", "getRequesting", "saveBtnEnabled", "Landroidx/lifecycle/MediatorLiveData;", "getSaveBtnEnabled", "()Landroidx/lifecycle/MediatorLiveData;", "isStartTimeSameAsEndTime", "scheduleEndTypeHintClosedBefore", "getScheduleEndTypeHintClosedBefore", "setScheduleEndTypeHintClosedBefore", "configureForModify", "", "scheduleMerged", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "hasOverlap", "success", "allSchedules", "", "validateModel", "buildInstructions", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "fanSpeed", "brightness", "autoRh", "mainMode", "apSubMode", "smartSubMode", "heatAutoTemp", "heatEcoTemp", "oscillationEnabled", "humMode", "buildStartInstructions", "buildEndCustomInstructions", "buildLegacyEndInstructions", "toDeviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "delete", "Lkotlin/Function1;", "resetAutoAndNightInstructions", "initTimeFormat", "context", "Landroid/content/Context;", "State", "PurifierMode", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceCreateEditScheduleViewModel.kt */
public final class DeviceCreateEditScheduleViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private SimpleDateFormat currentTimeFormatter;
    private FanSpeedEnum defaultFanSpeed = FanSpeedEnum.OFF;
    private final Lazy defaultLabel$delegate;
    private PurifierMode defaultPurifierMode = PurifierMode.AUTO;
    private Device device;
    private final Lazy deviceScheduleService$delegate;
    private DeviceScheduleMerged editingSchedule;
    private Object endBrightness;
    private FanSpeedEnum endFanSpeed;
    private Calendar endTime;
    private final MutableLiveData<Boolean> isStartTimeSameAsEndTime;
    private String label;
    private MutableLiveData<Device> liveDevice = new MutableLiveData<>();
    private final MutableLiveData<MainMode> liveMainMode;
    private final MutableLiveData<PurifierMode> livePurifierMode;
    private final MutableLiveData<FanSpeedEnum> liveScheduleEndCustomFanSpeed;
    private final MutableLiveData<MainMode> liveScheduleEndCustomMainMode;
    private final MutableLiveData<PurifierMode> liveScheduleEndCustomMode;
    private final MutableLiveData<FanSpeedEnum> liveStartFanSpeed;
    private boolean paused;
    private final Lazy prefs$delegate;
    private PurifierMode purifierMode;
    private Set<? extends DayOfWeek> repeat;
    private final MutableLiveData<Boolean> requesting;
    private final MediatorLiveData<Boolean> saveBtnEnabled;
    private ApSubMode scheduleEndCustomApSubMode;
    private int scheduleEndCustomAutoRh;
    private Object scheduleEndCustomBrightness;
    private FanSpeedEnum scheduleEndCustomFanSpeed;
    private double scheduleEndCustomHeatAutoTemp;
    private double scheduleEndCustomHeatEcoTemp;
    private boolean scheduleEndCustomHumMode;
    private MainMode scheduleEndCustomMainMode;
    private PurifierMode scheduleEndCustomMode;
    private boolean scheduleEndCustomOscillationEnabled;
    private SmartSubMode scheduleEndCustomSmartSubMode;
    private final MutableLiveData<String> scheduleEndType;
    private ApSubMode startApSubMode;
    private int startAutoRh;
    private Object startBrightness;
    private FanSpeedEnum startFanSpeed;
    private double startHeatAutoTemp;
    private double startHeatEcoTemp;
    private boolean startHumMode;
    private MainMode startMainMode;
    private boolean startOscillationEnabled;
    private SmartSubMode startSmartSubMode;
    private Calendar startTime;
    private State state = State.NEW;
    private final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
    private final MutableLiveData<Boolean> validState;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCreateEditScheduleViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|(2:73|74)|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|(2:73|74)|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0102 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0115 */
        static {
            /*
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r2 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.NEW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.MODIFY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.Mode[] r0 = com.blueair.core.model.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.Mode r3 = com.blueair.core.model.Mode.AUTO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.blueair.core.model.Mode r3 = com.blueair.core.model.Mode.FAN     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                com.blueair.core.model.Mode r4 = com.blueair.core.model.Mode.NIGHT     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                r4 = 4
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.ECO     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                r5 = 5
                com.blueair.core.model.Mode r6 = com.blueair.core.model.Mode.SKIN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                $EnumSwitchMapping$1 = r0
                com.blueair.core.model.DehSubMode[] r0 = com.blueair.core.model.DehSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DehSubMode r6 = com.blueair.core.model.DehSubMode.DRYING     // Catch:{ NoSuchFieldError -> 0x005e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                com.blueair.core.model.DehSubMode r6 = com.blueair.core.model.DehSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                com.blueair.core.model.DehSubMode r6 = com.blueair.core.model.DehSubMode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x006e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$2 = r0
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x007f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x008f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                $EnumSwitchMapping$3 = r0
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.Dehumidification     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.SMART     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                $EnumSwitchMapping$4 = r0
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x00e1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DRYING     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO     // Catch:{ NoSuchFieldError -> 0x00f1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f1 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00f1 }
            L_0x00f1:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x00f9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f9 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00f9 }
            L_0x00f9:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SKIN     // Catch:{ NoSuchFieldError -> 0x010b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010b }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010b }
            L_0x010b:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO     // Catch:{ NoSuchFieldError -> 0x0115 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0115 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0115 }
            L_0x0115:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x011f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011f }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x011f }
            L_0x011f:
                $EnumSwitchMapping$5 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<DeviceCreateEditScheduleViewModel> cls = DeviceCreateEditScheduleViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "deviceScheduleService", "getDeviceScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceCreateEditScheduleViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceCreateEditScheduleViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, DeviceScheduleService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.deviceScheduleService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceCreateEditScheduleViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        this.startTime = instance;
        DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel = this;
        Calendar instance2 = Calendar.getInstance();
        instance2.add(10, 1);
        Intrinsics.checkNotNullExpressionValue(instance2, "run(...)");
        this.endTime = instance2;
        this.repeat = SetsKt.setOf(DayOfWeek.SUN, DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI, DayOfWeek.SAT);
        this.label = "";
        this.defaultLabel$delegate = LazyKt.lazy(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda2(this));
        this.purifierMode = PurifierMode.AUTO;
        this.livePurifierMode = new MutableLiveData<>(this.purifierMode);
        this.startFanSpeed = FanSpeedEnum.OFF;
        this.liveStartFanSpeed = new MutableLiveData<>(this.startFanSpeed);
        this.startBrightness = Brightness.TWO;
        this.startAutoRh = 50;
        this.startMainMode = MainMode.AirPurify;
        this.liveMainMode = new MutableLiveData<>(this.startMainMode);
        this.startApSubMode = ApSubMode.AUTO;
        this.startHeatAutoTemp = 22.0d;
        this.startHeatEcoTemp = 22.0d;
        this.startHumMode = true;
        this.startSmartSubMode = SmartSubMode.AUTO_ON;
        this.endFanSpeed = FanSpeedEnum.ONE;
        this.endBrightness = Brightness.ONE;
        this.scheduleEndType = new MutableLiveData<>(BlueDeviceScheduleEndType.PREVIOUS);
        this.scheduleEndCustomMode = PurifierMode.AUTO;
        this.liveScheduleEndCustomMode = new MutableLiveData<>(this.scheduleEndCustomMode);
        this.scheduleEndCustomFanSpeed = FanSpeedEnum.OFF;
        this.liveScheduleEndCustomFanSpeed = new MutableLiveData<>(this.scheduleEndCustomFanSpeed);
        this.scheduleEndCustomBrightness = Brightness.TWO;
        this.scheduleEndCustomAutoRh = 50;
        this.scheduleEndCustomMainMode = MainMode.AirPurify;
        this.liveScheduleEndCustomMainMode = new MutableLiveData<>(this.scheduleEndCustomMainMode);
        this.scheduleEndCustomApSubMode = ApSubMode.AUTO;
        this.scheduleEndCustomHeatAutoTemp = 22.0d;
        this.scheduleEndCustomHeatEcoTemp = 22.0d;
        this.scheduleEndCustomHumMode = true;
        this.scheduleEndCustomSmartSubMode = SmartSubMode.AUTO_ON;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this.validState = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this.requesting = mutableLiveData2;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(mutableLiveData, new DeviceCreateEditScheduleViewModel$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda3(mediatorLiveData, this)));
        mediatorLiveData.addSource(mutableLiveData2, new DeviceCreateEditScheduleViewModel$sam$androidx_lifecycle_Observer$0(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda4(mediatorLiveData, this)));
        this.saveBtnEnabled = mediatorLiveData;
        this.isStartTimeSameAsEndTime = new MutableLiveData<>(false);
        validateModel();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "MODIFY", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCreateEditScheduleViewModel.kt */
    public enum State {
        NEW,
        MODIFY;

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            State[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "<init>", "(Ljava/lang/String;I)V", "STANDBY", "AUTO", "MANUAL", "NIGHT", "DISINFECTION", "ECO", "SKIN", "SMART", "DRYING", "CONTINUOUS", "toModeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCreateEditScheduleViewModel.kt */
    public enum PurifierMode {
        STANDBY,
        AUTO,
        MANUAL,
        NIGHT,
        DISINFECTION,
        ECO,
        SKIN,
        SMART,
        DRYING,
        CONTINUOUS;
        
        public static final Companion Companion = null;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceCreateEditScheduleViewModel.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23) */
            /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|23) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART     // Catch:{ NoSuchFieldError -> 0x0046 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
                L_0x0046:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DRYING     // Catch:{ NoSuchFieldError -> 0x0050 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                    r2 = 8
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
                L_0x0050:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x005a }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                    r2 = 9
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
                L_0x005a:
                    com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SKIN     // Catch:{ NoSuchFieldError -> 0x0064 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                    r2 = 10
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
                L_0x0064:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.WhenMappings.<clinit>():void");
            }
        }

        public static EnumEntries<PurifierMode> getEntries() {
            return $ENTRIES;
        }

        static {
            PurifierMode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode$Companion;", "", "<init>", "()V", "fromModeIcon", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "fromSubMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "fromHumSubMode", "Lcom/blueair/core/model/HumSubMode;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceCreateEditScheduleViewModel.kt */
        public static final class Companion {

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* compiled from: DeviceCreateEditScheduleViewModel.kt */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
                public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|(2:47|48)|49|51) */
                /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|(2:47|48)|49|51) */
                /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|51) */
                /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|51) */
                /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|51) */
                /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|51) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
                /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0034 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
                /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0046 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0050 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
                /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007f */
                /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0087 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008f */
                /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a8 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b0 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b8 */
                static {
                    /*
                        com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        r1 = 1
                        com.blueair.viewcore.utils.ModeIcon r2 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        r2 = 2
                        com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        r3 = 3
                        com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        r4 = 4
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x0034 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                        r6 = 5
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0034 }
                    L_0x0034:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.STANDBY     // Catch:{ NoSuchFieldError -> 0x003d }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                        r6 = 6
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
                    L_0x003d:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x0046 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                        r6 = 7
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0046 }
                    L_0x0046:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.SMART     // Catch:{ NoSuchFieldError -> 0x0050 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                        r6 = 8
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0050 }
                    L_0x0050:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.DRYING     // Catch:{ NoSuchFieldError -> 0x005a }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                        r6 = 9
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x005a }
                    L_0x005a:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0064 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                        r6 = 10
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0064 }
                    L_0x0064:
                        com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.SKIN     // Catch:{ NoSuchFieldError -> 0x006e }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                        r6 = 11
                        r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006e }
                    L_0x006e:
                        $EnumSwitchMapping$0 = r0
                        com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x007f }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                        r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
                    L_0x007f:
                        com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x0087 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                        r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
                    L_0x0087:
                        com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x008f }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                        r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
                    L_0x008f:
                        com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0097 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                        r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0097 }
                    L_0x0097:
                        $EnumSwitchMapping$1 = r0
                        com.blueair.core.model.HumSubMode[] r0 = com.blueair.core.model.HumSubMode.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.blueair.core.model.HumSubMode r5 = com.blueair.core.model.HumSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x00a8 }
                        int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                        r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00a8 }
                    L_0x00a8:
                        com.blueair.core.model.HumSubMode r1 = com.blueair.core.model.HumSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x00b0 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
                    L_0x00b0:
                        com.blueair.core.model.HumSubMode r1 = com.blueair.core.model.HumSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x00b8 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                        r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00b8 }
                    L_0x00b8:
                        com.blueair.core.model.HumSubMode r1 = com.blueair.core.model.HumSubMode.SKIN     // Catch:{ NoSuchFieldError -> 0x00c0 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                        r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00c0 }
                    L_0x00c0:
                        $EnumSwitchMapping$2 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.Companion.WhenMappings.<clinit>():void");
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PurifierMode fromModeIcon(ModeIcon modeIcon) {
                Intrinsics.checkNotNullParameter(modeIcon, "modeIcon");
                switch (WhenMappings.$EnumSwitchMapping$0[modeIcon.ordinal()]) {
                    case 1:
                        return PurifierMode.MANUAL;
                    case 2:
                    case 3:
                        return PurifierMode.AUTO;
                    case 4:
                        return PurifierMode.NIGHT;
                    case 5:
                        return PurifierMode.ECO;
                    case 6:
                        return PurifierMode.STANDBY;
                    case 7:
                        return PurifierMode.DISINFECTION;
                    case 8:
                        return PurifierMode.SMART;
                    case 9:
                        return PurifierMode.DRYING;
                    case 10:
                        return PurifierMode.CONTINUOUS;
                    case 11:
                        return PurifierMode.SKIN;
                    default:
                        return null;
                }
            }

            public final PurifierMode fromSubMode(ApSubMode apSubMode) {
                Intrinsics.checkNotNullParameter(apSubMode, "subMode");
                int i = WhenMappings.$EnumSwitchMapping$1[apSubMode.ordinal()];
                if (i == 1) {
                    return PurifierMode.ECO;
                }
                if (i == 2) {
                    return PurifierMode.MANUAL;
                }
                if (i == 3) {
                    return PurifierMode.AUTO;
                }
                if (i == 4) {
                    return PurifierMode.NIGHT;
                }
                throw new NoWhenBranchMatchedException();
            }

            public final PurifierMode fromHumSubMode(HumSubMode humSubMode) {
                Intrinsics.checkNotNullParameter(humSubMode, "subMode");
                int i = WhenMappings.$EnumSwitchMapping$2[humSubMode.ordinal()];
                if (i == 1) {
                    return PurifierMode.MANUAL;
                }
                if (i == 2) {
                    return PurifierMode.AUTO;
                }
                if (i == 3) {
                    return PurifierMode.NIGHT;
                }
                if (i == 4) {
                    return PurifierMode.SKIN;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        public final ModeIcon toModeIcon(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return ModeIcon.STANDBY;
                case 2:
                    return ModeIcon.AUTO.proofread(device);
                case 3:
                    return ModeIcon.FAN_SPEED;
                case 4:
                    return ModeIcon.NIGHT;
                case 5:
                    return ModeIcon.DISINFECTION;
                case 6:
                    return ModeIcon.ECO;
                case 7:
                    return ModeIcon.SMART;
                case 8:
                    return ModeIcon.DRYING;
                case 9:
                    return ModeIcon.CONTINUOUS;
                case 10:
                    return ModeIcon.SKIN;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* access modifiers changed from: private */
    public final DeviceScheduleService getDeviceScheduleService() {
        return (DeviceScheduleService) this.deviceScheduleService$delegate.getValue();
    }

    private final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    public final State getState() {
        return this.state;
    }

    public final void setState(State state2) {
        Intrinsics.checkNotNullParameter(state2, "<set-?>");
        this.state = state2;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        PurifierMode purifierMode2;
        MainMode mainMode;
        this.device = device2;
        if (device2 != null) {
            this.liveDevice.setValue(device2);
            if (device2 instanceof DevicePet20) {
                setScheduleEndCustomMode(PurifierMode.SMART);
                purifierMode2 = PurifierMode.SMART;
            } else if (device2 instanceof DeviceMiniRestful) {
                purifierMode2 = PurifierMode.MANUAL;
            } else if ((device2 instanceof HasFanSpeed) && ((HasFanSpeed) device2).getAutoMode() != AutoMode.NOT_AVAILABLE) {
                purifierMode2 = PurifierMode.AUTO;
            } else if (!(device2 instanceof HasLinkingCapability) || !((HasLinkingCapability) device2).isLinked()) {
                purifierMode2 = PurifierMode.MANUAL;
            } else {
                purifierMode2 = PurifierMode.AUTO;
            }
            this.defaultPurifierMode = purifierMode2;
            setPurifierMode(purifierMode2);
            setScheduleEndCustomMode(this.defaultPurifierMode);
            Device device3 = this.device;
            if ((device3 instanceof DeviceHumidifier20) || (device3 instanceof DeviceMiniRestful) || (device3 instanceof DevicePet20) || (device3 instanceof DeviceCombo2in120)) {
                FanSpeedEnum fanSpeedEnum = FanSpeedEnum.ELEVEN;
                this.defaultFanSpeed = fanSpeedEnum;
                setStartFanSpeed(fanSpeedEnum);
                setScheduleEndCustomFanSpeed(this.defaultFanSpeed);
            }
            if (device2 instanceof DeviceDehumidifier) {
                setScheduleEndCustomMainMode(MainMode.Dehumidification);
                mainMode = MainMode.Dehumidification;
            } else {
                mainMode = MainMode.AirPurify;
            }
            setStartMainMode(mainMode);
        }
    }

    public final PurifierMode getDefaultPurifierMode() {
        return this.defaultPurifierMode;
    }

    public final FanSpeedEnum getDefaultFanSpeed() {
        return this.defaultFanSpeed;
    }

    public final MutableLiveData<Device> getLiveDevice() {
        return this.liveDevice;
    }

    public final void setLiveDevice(MutableLiveData<Device> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.liveDevice = mutableLiveData;
    }

    public final DeviceScheduleMerged getEditingSchedule() {
        return this.editingSchedule;
    }

    public final void setEditingSchedule(DeviceScheduleMerged deviceScheduleMerged) {
        this.editingSchedule = deviceScheduleMerged;
        if (deviceScheduleMerged != null) {
            configureForModify(deviceScheduleMerged);
        }
    }

    public final String getTitle() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i == 1) {
            String string = getApplication().getString(R.string.new_schedule);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == 2) {
            String string2 = getApplication().getString(R.string.modify_schedule);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String getDisplayStartTime() {
        SimpleDateFormat simpleDateFormat = this.currentTimeFormatter;
        if (simpleDateFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentTimeFormatter");
            simpleDateFormat = null;
        }
        String format = simpleDateFormat.format(this.startTime.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String getDisplayEndTime() {
        SimpleDateFormat simpleDateFormat = this.currentTimeFormatter;
        if (simpleDateFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentTimeFormatter");
            simpleDateFormat = null;
        }
        String format = simpleDateFormat.format(this.endTime.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String getDisplayRepeat() {
        String str;
        Application application = getApplication();
        if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, this.repeat)) {
            str = application.getApplicationContext().getString(R.string.weekend);
        } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, this.repeat)) {
            str = application.getApplicationContext().getString(R.string.weekdays);
        } else if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, this.repeat)) {
            str = application.getApplicationContext().getString(R.string.everyday);
        } else {
            str = CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.repeat, new DeviceCreateEditScheduleViewModel$special$$inlined$sortedBy$1()), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda5(application), 30, (Object) null);
        }
        Intrinsics.checkNotNull(str);
        return str + TokenParser.SP + getDisplayStartTime() + " - " + getDisplayEndTime();
    }

    /* access modifiers changed from: private */
    public static final CharSequence _get_displayRepeat_$lambda$1(Application application, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "it");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return DayOfWeekExtensionKt.displayValueShort(dayOfWeek, applicationContext);
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final void setPaused(boolean z) {
        this.paused = z;
    }

    public final Calendar getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "value");
        this.startTime = calendar;
        if (this.purifierMode == PurifierMode.DISINFECTION) {
            Object clone = calendar.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
            Calendar calendar2 = (Calendar) clone;
            calendar2.add(13, 7200);
            setEndTime(calendar2);
        }
        this.isStartTimeSameAsEndTime.setValue(Boolean.valueOf(isStartTimeSameAsEndTime()));
        validateModel();
    }

    public final Calendar getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "value");
        this.endTime = calendar;
        this.isStartTimeSameAsEndTime.setValue(Boolean.valueOf(isStartTimeSameAsEndTime()));
        validateModel();
    }

    public final Set<DayOfWeek> getRepeat() {
        return this.repeat;
    }

    public final void setRepeat(Set<? extends DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(set, "value");
        this.repeat = set;
        validateModel();
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    /* access modifiers changed from: private */
    public static final String defaultLabel_delegate$lambda$4(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        String string = deviceCreateEditScheduleViewModel.getApplication().getString(R.string.schedule_default_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getDefaultLabel() {
        return (String) this.defaultLabel$delegate.getValue();
    }

    public final String getDisplayLabel() {
        CharSequence charSequence = this.label;
        if (StringsKt.isBlank(charSequence)) {
            charSequence = getDefaultLabel();
        }
        return (String) charSequence;
    }

    public final PurifierMode getPurifierMode() {
        return this.purifierMode;
    }

    public final void setPurifierMode(PurifierMode purifierMode2) {
        Intrinsics.checkNotNullParameter(purifierMode2, "value");
        this.purifierMode = purifierMode2;
        if (purifierMode2 == PurifierMode.DISINFECTION) {
            setStartTime(this.startTime);
        }
        this.livePurifierMode.setValue(purifierMode2);
    }

    public final MutableLiveData<PurifierMode> getLivePurifierMode() {
        return this.livePurifierMode;
    }

    public final FanSpeedEnum getStartFanSpeed() {
        return this.startFanSpeed;
    }

    public final void setStartFanSpeed(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "value");
        this.startFanSpeed = fanSpeedEnum;
        this.liveStartFanSpeed.setValue(fanSpeedEnum);
    }

    public final MutableLiveData<FanSpeedEnum> getLiveStartFanSpeed() {
        return this.liveStartFanSpeed;
    }

    public final Object getStartBrightness() {
        return this.startBrightness;
    }

    public final void setStartBrightness(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.startBrightness = obj;
    }

    public final int getStartAutoRh() {
        return this.startAutoRh;
    }

    public final void setStartAutoRh(int i) {
        this.startAutoRh = i;
    }

    public final MainMode getStartMainMode() {
        return this.startMainMode;
    }

    public final void setStartMainMode(MainMode mainMode) {
        Intrinsics.checkNotNullParameter(mainMode, "value");
        this.startMainMode = mainMode;
        this.liveMainMode.setValue(mainMode);
    }

    public final MutableLiveData<MainMode> getLiveMainMode() {
        return this.liveMainMode;
    }

    public final ApSubMode getStartApSubMode() {
        return this.startApSubMode;
    }

    public final void setStartApSubMode(ApSubMode apSubMode) {
        Intrinsics.checkNotNullParameter(apSubMode, "value");
        if (this.startApSubMode != apSubMode) {
            this.startApSubMode = apSubMode;
            if (this.purifierMode != PurifierMode.STANDBY) {
                setPurifierMode(PurifierMode.Companion.fromSubMode(apSubMode));
            }
        }
    }

    public final double getStartHeatAutoTemp() {
        return this.startHeatAutoTemp;
    }

    public final void setStartHeatAutoTemp(double d) {
        this.startHeatAutoTemp = d;
    }

    public final double getStartHeatEcoTemp() {
        return this.startHeatEcoTemp;
    }

    public final void setStartHeatEcoTemp(double d) {
        this.startHeatEcoTemp = d;
    }

    public final boolean getStartOscillationEnabled() {
        return this.startOscillationEnabled;
    }

    public final void setStartOscillationEnabled(boolean z) {
        this.startOscillationEnabled = z;
    }

    public final boolean getStartHumMode() {
        return this.startHumMode;
    }

    public final void setStartHumMode(boolean z) {
        this.startHumMode = z;
    }

    public final SmartSubMode getStartSmartSubMode() {
        return this.startSmartSubMode;
    }

    public final void setStartSmartSubMode(SmartSubMode smartSubMode) {
        Intrinsics.checkNotNullParameter(smartSubMode, "<set-?>");
        this.startSmartSubMode = smartSubMode;
    }

    public final FanSpeedEnum getEndFanSpeed() {
        return this.endFanSpeed;
    }

    public final void setEndFanSpeed(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "<set-?>");
        this.endFanSpeed = fanSpeedEnum;
    }

    public final Object getEndBrightness() {
        return this.endBrightness;
    }

    public final void setEndBrightness(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.endBrightness = obj;
    }

    public final MutableLiveData<String> getScheduleEndType() {
        return this.scheduleEndType;
    }

    public final PurifierMode getScheduleEndCustomMode() {
        return this.scheduleEndCustomMode;
    }

    public final void setScheduleEndCustomMode(PurifierMode purifierMode2) {
        Intrinsics.checkNotNullParameter(purifierMode2, "value");
        this.scheduleEndCustomMode = purifierMode2;
        this.liveScheduleEndCustomMode.setValue(purifierMode2);
    }

    public final MutableLiveData<PurifierMode> getLiveScheduleEndCustomMode() {
        return this.liveScheduleEndCustomMode;
    }

    public final FanSpeedEnum getScheduleEndCustomFanSpeed() {
        return this.scheduleEndCustomFanSpeed;
    }

    public final void setScheduleEndCustomFanSpeed(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "value");
        this.scheduleEndCustomFanSpeed = fanSpeedEnum;
        this.liveScheduleEndCustomFanSpeed.setValue(fanSpeedEnum);
    }

    public final MutableLiveData<FanSpeedEnum> getLiveScheduleEndCustomFanSpeed() {
        return this.liveScheduleEndCustomFanSpeed;
    }

    public final Object getScheduleEndCustomBrightness() {
        return this.scheduleEndCustomBrightness;
    }

    public final void setScheduleEndCustomBrightness(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.scheduleEndCustomBrightness = obj;
    }

    public final int getScheduleEndCustomAutoRh() {
        return this.scheduleEndCustomAutoRh;
    }

    public final void setScheduleEndCustomAutoRh(int i) {
        this.scheduleEndCustomAutoRh = i;
    }

    public final MainMode getScheduleEndCustomMainMode() {
        return this.scheduleEndCustomMainMode;
    }

    public final void setScheduleEndCustomMainMode(MainMode mainMode) {
        Intrinsics.checkNotNullParameter(mainMode, "value");
        this.scheduleEndCustomMainMode = mainMode;
        this.liveScheduleEndCustomMainMode.setValue(mainMode);
    }

    public final MutableLiveData<MainMode> getLiveScheduleEndCustomMainMode() {
        return this.liveScheduleEndCustomMainMode;
    }

    public final ApSubMode getScheduleEndCustomApSubMode() {
        return this.scheduleEndCustomApSubMode;
    }

    public final void setScheduleEndCustomApSubMode(ApSubMode apSubMode) {
        Intrinsics.checkNotNullParameter(apSubMode, "value");
        if (this.scheduleEndCustomApSubMode != apSubMode) {
            this.scheduleEndCustomApSubMode = apSubMode;
            if (this.scheduleEndCustomMode != PurifierMode.STANDBY) {
                setScheduleEndCustomMode(PurifierMode.Companion.fromSubMode(apSubMode));
            }
        }
    }

    public final double getScheduleEndCustomHeatAutoTemp() {
        return this.scheduleEndCustomHeatAutoTemp;
    }

    public final void setScheduleEndCustomHeatAutoTemp(double d) {
        this.scheduleEndCustomHeatAutoTemp = d;
    }

    public final double getScheduleEndCustomHeatEcoTemp() {
        return this.scheduleEndCustomHeatEcoTemp;
    }

    public final void setScheduleEndCustomHeatEcoTemp(double d) {
        this.scheduleEndCustomHeatEcoTemp = d;
    }

    public final boolean getScheduleEndCustomOscillationEnabled() {
        return this.scheduleEndCustomOscillationEnabled;
    }

    public final void setScheduleEndCustomOscillationEnabled(boolean z) {
        this.scheduleEndCustomOscillationEnabled = z;
    }

    public final boolean getScheduleEndCustomHumMode() {
        return this.scheduleEndCustomHumMode;
    }

    public final void setScheduleEndCustomHumMode(boolean z) {
        this.scheduleEndCustomHumMode = z;
    }

    public final SmartSubMode getScheduleEndCustomSmartSubMode() {
        return this.scheduleEndCustomSmartSubMode;
    }

    public final void setScheduleEndCustomSmartSubMode(SmartSubMode smartSubMode) {
        Intrinsics.checkNotNullParameter(smartSubMode, "<set-?>");
        this.scheduleEndCustomSmartSubMode = smartSubMode;
    }

    public final MutableLiveData<Boolean> getValidState() {
        return this.validState;
    }

    public final MutableLiveData<Boolean> getRequesting() {
        return this.requesting;
    }

    public final MediatorLiveData<Boolean> getSaveBtnEnabled() {
        return this.saveBtnEnabled;
    }

    /* access modifiers changed from: private */
    public static final Unit saveBtnEnabled$lambda$8$lambda$6(MediatorLiveData mediatorLiveData, DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, Boolean bool) {
        boolean z = false;
        if (bool.booleanValue() && Intrinsics.areEqual((Object) deviceCreateEditScheduleViewModel.requesting.getValue(), (Object) false)) {
            z = true;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit saveBtnEnabled$lambda$8$lambda$7(MediatorLiveData mediatorLiveData, DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, Boolean bool) {
        boolean z = true;
        if (!Intrinsics.areEqual((Object) deviceCreateEditScheduleViewModel.validState.getValue(), (Object) true) || bool.booleanValue()) {
            z = false;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* renamed from: isStartTimeSameAsEndTime  reason: collision with other method in class */
    public final MutableLiveData<Boolean> m8590isStartTimeSameAsEndTime() {
        return this.isStartTimeSameAsEndTime;
    }

    public final boolean getScheduleEndTypeHintClosedBefore() {
        String str;
        Prefs prefs = getPrefs();
        Device device2 = this.device;
        if (device2 == null || (str = device2.getUid()) == null) {
            str = "";
        }
        String format = String.format(PrefKeys.KEY_SCHEDULE_END_TYPE_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(prefs.getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setScheduleEndTypeHintClosedBefore(boolean z) {
        String str;
        Prefs prefs = getPrefs();
        Device device2 = this.device;
        if (device2 == null || (str = device2.getUid()) == null) {
            str = "";
        }
        String format = String.format(PrefKeys.KEY_SCHEDULE_END_TYPE_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(prefs.getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    private final void configureForModify(DeviceScheduleMerged deviceScheduleMerged) {
        this.state = State.MODIFY;
        Calendar timeToCalendar = deviceScheduleMerged.timeToCalendar(deviceScheduleMerged.getStartTime());
        if (timeToCalendar == null) {
            timeToCalendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(timeToCalendar, "getInstance(...)");
        }
        setStartTime(timeToCalendar);
        Calendar timeToCalendar2 = deviceScheduleMerged.timeToCalendar(deviceScheduleMerged.getEndTime());
        if (timeToCalendar2 == null) {
            timeToCalendar2 = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(timeToCalendar2, "getInstance(...)");
        }
        setEndTime(timeToCalendar2);
        setRepeat(deviceScheduleMerged.getDaysOfWeek());
        this.label = deviceScheduleMerged.getName();
        this.paused = deviceScheduleMerged.getPaused();
        configureForModify$configureInstructions(this, deviceScheduleMerged.getInstructions(), new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda0(this));
        MutableLiveData<String> mutableLiveData = this.scheduleEndType;
        String endScheduleMode = deviceScheduleMerged.getEndScheduleMode();
        if (endScheduleMode == null) {
            endScheduleMode = BlueDeviceScheduleEndType.PREVIOUS;
        }
        mutableLiveData.setValue(endScheduleMode);
        configureForModify$configureInstructions(this, deviceScheduleMerged.getEndInstructions(), new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda1(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: com.blueair.core.model.ApSubMode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v5, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: com.blueair.core.model.DehSubMode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v7, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v8, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: com.blueair.core.model.HumSubMode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v10, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v11, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v13, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v14, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v20, resolved type: com.blueair.core.model.SmartSubMode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v16, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v17, resolved type: com.blueair.core.model.Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: com.blueair.core.model.MainMode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v19, resolved type: com.blueair.core.model.Mode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void configureForModify$configureInstructions(com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r26, java.util.List<com.blueair.core.model.DeviceScheduleInstruction> r27, kotlin.jvm.functions.Function11<? super com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode, ? super com.blueair.core.model.MainMode, ? super com.blueair.core.model.ApSubMode, ? super com.blueair.core.model.SmartSubMode, ? super com.blueair.core.model.FanSpeedEnum, java.lang.Object, ? super java.lang.Integer, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> r28) {
        /*
            r0 = r26
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = r0.defaultPurifierMode
            com.blueair.core.model.MainMode r2 = com.blueair.core.model.MainMode.AirPurify
            com.blueair.core.model.ApSubMode r3 = com.blueair.core.model.ApSubMode.AUTO
            com.blueair.core.model.SmartSubMode r4 = com.blueair.core.model.SmartSubMode.AUTO_ON
            com.blueair.core.model.DehSubMode r5 = com.blueair.core.model.DehSubMode.AUTO
            com.blueair.core.model.HumSubMode r6 = com.blueair.core.model.HumSubMode.AUTO
            com.blueair.core.model.FanSpeedEnum r7 = r0.defaultFanSpeed
            com.blueair.core.model.Brightness r8 = com.blueair.core.model.Brightness.TWO
            com.blueair.core.model.Device r9 = r0.device
            boolean r9 = r9 instanceof com.blueair.core.model.HasBlueCloudFunctions
            java.lang.String r11 = "Schedule Instruction type not supported: "
            r15 = 1
            if (r9 == 0) goto L_0x045b
            java.util.Iterator r9 = r27.iterator()
            r22 = r15
            r16 = 0
            r17 = 50
            r18 = 4626885667169763328(0x4036000000000000, double:22.0)
            r20 = 4626885667169763328(0x4036000000000000, double:22.0)
        L_0x0029:
            boolean r23 = r9.hasNext()
            if (r23 == 0) goto L_0x044f
            java.lang.Object r23 = r9.next()
            r14 = r23
            com.blueair.core.model.DeviceScheduleInstruction r14 = (com.blueair.core.model.DeviceScheduleInstruction) r14
            java.lang.String r10 = r14.getName()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r24 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE
            java.lang.String r12 = r24.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x005f
            java.lang.String r1 = r14.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r10 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE
            java.lang.String r10 = r10.getDefaultValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r1 == 0) goto L_0x005a
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            goto L_0x005c
        L_0x005a:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
        L_0x005c:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x005f:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0080
            java.lang.String r10 = r14.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE
            java.lang.String r12 = r12.getDefaultValue()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x007d
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
        L_0x007d:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x0080:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x00ac
            com.blueair.core.model.Device r10 = r0.device
            if (r10 == 0) goto L_0x0029
            java.lang.String r12 = r14.getValue()
            java.lang.Integer r12 = kotlin.text.StringsKt.toIntOrNull(r12)
            if (r12 == 0) goto L_0x0029
            java.lang.Number r12 = (java.lang.Number) r12
            int r7 = r12.intValue()
            com.blueair.core.model.FanSpeedEnum$Companion r12 = com.blueair.core.model.FanSpeedEnum.Companion
            com.blueair.core.model.FanSpeedEnum r7 = r12.fromServerValue(r10, r7)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x00ac:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.BRIGHTNESS
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x00e3
            com.blueair.core.model.Device r10 = r0.device
            if (r10 == 0) goto L_0x0029
            java.lang.String r12 = r14.getValue()
            java.lang.Integer r12 = kotlin.text.StringsKt.toIntOrNull(r12)
            if (r12 == 0) goto L_0x0029
            java.lang.Number r12 = (java.lang.Number) r12
            int r8 = r12.intValue()
            boolean r12 = com.blueair.core.model.BrightnessKt.hasBrightnessInPercent(r10)
            if (r12 == 0) goto L_0x00d7
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00dd
        L_0x00d7:
            com.blueair.core.model.Brightness$Companion r12 = com.blueair.core.model.Brightness.Companion
            com.blueair.core.model.Brightness r8 = r12.fromServerValue(r10, r8)
        L_0x00dd:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x00e3:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0107
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r17 = r10
            goto L_0x0029
        L_0x0107:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0129
            java.lang.String r10 = r14.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY
            java.lang.String r12 = r12.getDefaultValue()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x0125
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
        L_0x0125:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x0129:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x014b
            java.lang.String r10 = r14.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION
            java.lang.String r12 = r12.getDefaultValue()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x0147
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION
        L_0x0147:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x014b:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x016d
            java.lang.String r10 = r14.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO
            java.lang.String r12 = r12.getDefaultValue()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x0169
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO
        L_0x0169:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x016d:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            r24 = 0
            if (r12 == 0) goto L_0x01b7
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.MainMode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0195:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x01ab
            java.lang.Object r14 = r12.next()
            r25 = r14
            com.blueair.core.model.MainMode r25 = (com.blueair.core.model.MainMode) r25
            int r13 = r25.getValue()
            if (r13 != r10) goto L_0x0195
            r24 = r14
        L_0x01ab:
            com.blueair.core.model.MainMode r24 = (com.blueair.core.model.MainMode) r24
            if (r24 == 0) goto L_0x0029
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r2 = r24
            goto L_0x0029
        L_0x01b7:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x0414
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x0414
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x01dd
            goto L_0x0414
        L_0x01dd:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.SMART_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0224
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.SmartSubMode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0203:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0218
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.core.model.SmartSubMode r14 = (com.blueair.core.model.SmartSubMode) r14
            int r14 = r14.getValue()
            if (r14 != r10) goto L_0x0203
            r24 = r13
        L_0x0218:
            com.blueair.core.model.SmartSubMode r24 = (com.blueair.core.model.SmartSubMode) r24
            if (r24 == 0) goto L_0x0029
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r4 = r24
            goto L_0x0029
        L_0x0224:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x03f4
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x03f4
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x024a
            goto L_0x03f4
        L_0x024a:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_ECO_TMP
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0274
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            com.blueair.core.model.DeviceData$Companion r12 = com.blueair.core.model.DeviceData.Companion
            double r12 = r12.fromServerValue(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r20 = r12
            goto L_0x0029
        L_0x0274:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_AUTO_TMP
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x029e
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            com.blueair.core.model.DeviceData$Companion r12 = com.blueair.core.model.DeviceData.Companion
            double r12 = r12.fromServerValue(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r18 = r12
            goto L_0x0029
        L_0x029e:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.OSCILLATION_STATE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x02c7
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r10 != r15) goto L_0x02bf
            r16 = r15
            goto L_0x02c1
        L_0x02bf:
            r16 = 0
        L_0x02c1:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x02c7:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0336
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.Mode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x02ed:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0302
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.core.model.Mode r14 = (com.blueair.core.model.Mode) r14
            int r14 = r14.getValue()
            if (r14 != r10) goto L_0x02ed
            r24 = r13
        L_0x0302:
            com.blueair.core.model.Mode r24 = (com.blueair.core.model.Mode) r24
            if (r24 == 0) goto L_0x0029
            int[] r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$1
            int r10 = r24.ordinal()
            r1 = r1[r10]
            if (r1 == r15) goto L_0x032e
            r10 = 2
            if (r1 == r10) goto L_0x032b
            r10 = 3
            if (r1 == r10) goto L_0x0328
            r10 = 4
            if (r1 == r10) goto L_0x0325
            r10 = 5
            if (r1 != r10) goto L_0x031f
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SKIN
            goto L_0x0330
        L_0x031f:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0325:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO
            goto L_0x0330
        L_0x0328:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
            goto L_0x0330
        L_0x032b:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
            goto L_0x0330
        L_0x032e:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
        L_0x0330:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x0336:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x034e
            java.lang.String r10 = r14.getValue()
            boolean r22 = java.lang.Boolean.parseBoolean(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x034e:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0395
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.HumSubMode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0374:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0389
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.core.model.HumSubMode r14 = (com.blueair.core.model.HumSubMode) r14
            int r14 = r14.getValue()
            if (r14 != r10) goto L_0x0374
            r24 = r13
        L_0x0389:
            com.blueair.core.model.HumSubMode r24 = (com.blueair.core.model.HumSubMode) r24
            if (r24 == 0) goto L_0x0029
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r6 = r24
            goto L_0x0029
        L_0x0395:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r12 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE
            java.lang.String r12 = r12.getInstructionName()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x03dc
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.DehSubMode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x03bb:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x03d0
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.core.model.DehSubMode r14 = (com.blueair.core.model.DehSubMode) r14
            int r14 = r14.getValue()
            if (r14 != r10) goto L_0x03bb
            r24 = r13
        L_0x03d0:
            com.blueair.core.model.DehSubMode r24 = (com.blueair.core.model.DehSubMode) r24
            if (r24 == 0) goto L_0x0029
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r5 = r24
            goto L_0x0029
        L_0x03dc:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            r13 = 0
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r10.e(r12, r14)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x03f4:
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            com.blueair.core.model.Device r12 = r0.device
            if (r12 == 0) goto L_0x0029
            com.blueair.core.model.FanSpeedEnum$Companion r7 = com.blueair.core.model.FanSpeedEnum.Companion
            com.blueair.core.model.FanSpeedEnum r7 = r7.fromServerValue(r12, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0029
        L_0x0414:
            java.lang.String r10 = r14.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x0029
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            kotlin.enums.EnumEntries r12 = com.blueair.core.model.ApSubMode.getEntries()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x042e:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0443
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.core.model.ApSubMode r14 = (com.blueair.core.model.ApSubMode) r14
            int r14 = r14.getValue()
            if (r14 != r10) goto L_0x042e
            r24 = r13
        L_0x0443:
            com.blueair.core.model.ApSubMode r24 = (com.blueair.core.model.ApSubMode) r24
            if (r24 == 0) goto L_0x0029
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r3 = r24
            goto L_0x0029
        L_0x044f:
            r13 = r4
            r4 = r2
            r2 = r5
            r5 = r3
            r3 = r6
            r6 = r13
            r13 = r16
            r14 = r17
            goto L_0x051c
        L_0x045b:
            java.util.Iterator r9 = r27.iterator()
        L_0x045f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x050d
            java.lang.Object r10 = r9.next()
            com.blueair.core.model.DeviceScheduleInstruction r10 = (com.blueair.core.model.DeviceScheduleInstruction) r10
            java.lang.String r12 = r10.getName()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r13 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE
            java.lang.String r13 = r13.getInstructionName()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0493
            java.lang.String r1 = r10.getValue()
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r10 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE
            java.lang.String r10 = r10.getDefaultValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r1 == 0) goto L_0x048e
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            goto L_0x0490
        L_0x048e:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
        L_0x0490:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x04bd
        L_0x0493:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r13 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED
            java.lang.String r13 = r13.getInstructionName()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x04bf
            com.blueair.core.model.Device r12 = r0.device
            if (r12 == 0) goto L_0x04bd
            java.lang.String r10 = r10.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x04bd
            java.lang.Number r10 = (java.lang.Number) r10
            int r7 = r10.intValue()
            com.blueair.core.model.FanSpeedEnum$Companion r10 = com.blueair.core.model.FanSpeedEnum.Companion
            com.blueair.core.model.FanSpeedEnum r7 = r10.fromServerValue(r12, r7)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x04bd:
            r13 = 0
            goto L_0x045f
        L_0x04bf:
            com.blueair.core.model.DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType r13 = com.blueair.core.model.DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS
            java.lang.String r13 = r13.getInstructionName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x04f5
            com.blueair.core.model.Device r12 = r0.device
            if (r12 == 0) goto L_0x04bd
            java.lang.String r10 = r10.getValue()
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 == 0) goto L_0x04bd
            java.lang.Number r10 = (java.lang.Number) r10
            int r8 = r10.intValue()
            boolean r10 = com.blueair.core.model.BrightnessKt.hasBrightnessInPercent(r12)
            if (r10 == 0) goto L_0x04ea
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x04f0
        L_0x04ea:
            com.blueair.core.model.Brightness$Companion r10 = com.blueair.core.model.Brightness.Companion
            com.blueair.core.model.Brightness r8 = r10.fromServerValue(r12, r8)
        L_0x04f0:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x04bd
        L_0x04f5:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r10)
            java.lang.String r10 = r13.toString()
            r13 = 0
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r12.e(r10, r14)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x045f
        L_0x050d:
            r13 = 0
            r14 = r4
            r4 = r2
            r2 = r5
            r5 = r3
            r3 = r6
            r6 = r14
            r22 = r15
            r14 = 50
            r18 = 4626885667169763328(0x4036000000000000, double:22.0)
            r20 = 4626885667169763328(0x4036000000000000, double:22.0)
        L_0x051c:
            com.blueair.core.model.Device r0 = r0.device
            boolean r9 = r0 instanceof com.blueair.core.model.DeviceDehumidifier
            if (r9 == 0) goto L_0x0573
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r1 == r0) goto L_0x05f8
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$4
            int r3 = r4.ordinal()
            r0 = r0[r3]
            if (r0 == r15) goto L_0x0550
            r10 = 2
            if (r0 == r10) goto L_0x0537
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f8
        L_0x0537:
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3
            int r1 = r5.ordinal()
            r0 = r0[r1]
            if (r0 == r15) goto L_0x0549
            if (r0 == r10) goto L_0x0546
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
            goto L_0x054b
        L_0x0546:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
            goto L_0x054b
        L_0x0549:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
        L_0x054b:
            r1 = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f8
        L_0x0550:
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$2
            int r1 = r2.ordinal()
            r0 = r0[r1]
            if (r0 == r15) goto L_0x056c
            r10 = 2
            if (r0 == r10) goto L_0x0569
            r10 = 3
            if (r0 != r10) goto L_0x0563
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS
            goto L_0x056e
        L_0x0563:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0569:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            goto L_0x056e
        L_0x056c:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DRYING
        L_0x056e:
            r1 = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f8
        L_0x0573:
            boolean r2 = r0 instanceof com.blueair.core.model.HasPetMainMode
            if (r2 == 0) goto L_0x05b0
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r1 == r0) goto L_0x05a9
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$4
            int r2 = r4.ordinal()
            r0 = r0[r2]
            r10 = 2
            if (r0 == r10) goto L_0x0591
            r2 = 3
            if (r0 == r2) goto L_0x058c
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05a9
        L_0x058c:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05a9
        L_0x0591:
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3
            int r2 = r5.ordinal()
            r0 = r0[r2]
            if (r0 == r15) goto L_0x05a5
            if (r0 == r10) goto L_0x05a0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05a9
        L_0x05a0:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05a9
        L_0x05a5:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x05a9:
            com.blueair.core.model.FanSpeedEnum r0 = com.blueair.core.model.FanSpeedEnum.OFF
            if (r7 != r0) goto L_0x05f8
            com.blueair.core.model.FanSpeedEnum r7 = com.blueair.core.model.FanSpeedEnum.ELEVEN
            goto L_0x05f8
        L_0x05b0:
            boolean r2 = r0 instanceof com.blueair.core.model.DeviceBlue40
            if (r2 == 0) goto L_0x05de
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r1 == r0) goto L_0x05f8
            int[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3
            int r1 = r5.ordinal()
            r0 = r0[r1]
            if (r0 == r15) goto L_0x05da
            r10 = 2
            if (r0 == r10) goto L_0x05d7
            r10 = 3
            if (r0 == r10) goto L_0x05d4
            r10 = 4
            if (r0 != r10) goto L_0x05ce
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO
            goto L_0x05dc
        L_0x05ce:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x05d4:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            goto L_0x05dc
        L_0x05d7:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
            goto L_0x05dc
        L_0x05da:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
        L_0x05dc:
            r1 = r0
            goto L_0x05f8
        L_0x05de:
            boolean r0 = r0 instanceof com.blueair.core.model.HasHumMainMode
            if (r0 == 0) goto L_0x05f8
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r1 == r0) goto L_0x05f8
            com.blueair.core.model.MainMode r0 = com.blueair.core.model.MainMode.AirPurify
            if (r4 != r0) goto L_0x05f1
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode$Companion r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.Companion
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = r0.fromSubMode(r5)
            goto L_0x05dc
        L_0x05f1:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode$Companion r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.Companion
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = r0.fromHumSubMode(r3)
            goto L_0x05dc
        L_0x05f8:
            r3 = r1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            java.lang.Double r10 = java.lang.Double.valueOf(r18)
            java.lang.Double r11 = java.lang.Double.valueOf(r20)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r13)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r22)
            r2 = r28
            r2.invoke(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.configureForModify$configureInstructions(com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel, java.util.List, kotlin.jvm.functions.Function11):void");
    }

    /* access modifiers changed from: private */
    public static final Unit configureForModify$lambda$41(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, PurifierMode purifierMode2, MainMode mainMode, ApSubMode apSubMode, SmartSubMode smartSubMode, FanSpeedEnum fanSpeedEnum, Object obj, int i, double d, double d2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(purifierMode2, "p");
        Intrinsics.checkNotNullParameter(mainMode, "m");
        Intrinsics.checkNotNullParameter(apSubMode, "aps");
        Intrinsics.checkNotNullParameter(smartSubMode, "sms");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "f");
        Intrinsics.checkNotNullParameter(obj, "b");
        deviceCreateEditScheduleViewModel.setPurifierMode(purifierMode2);
        deviceCreateEditScheduleViewModel.setStartMainMode(mainMode);
        deviceCreateEditScheduleViewModel.setStartApSubMode(apSubMode);
        deviceCreateEditScheduleViewModel.startSmartSubMode = smartSubMode;
        deviceCreateEditScheduleViewModel.setStartFanSpeed(fanSpeedEnum);
        deviceCreateEditScheduleViewModel.startBrightness = obj;
        deviceCreateEditScheduleViewModel.startAutoRh = i;
        deviceCreateEditScheduleViewModel.startHeatAutoTemp = d;
        deviceCreateEditScheduleViewModel.startHeatEcoTemp = d2;
        deviceCreateEditScheduleViewModel.startOscillationEnabled = z;
        deviceCreateEditScheduleViewModel.startHumMode = z2;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureForModify$lambda$42(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, PurifierMode purifierMode2, MainMode mainMode, ApSubMode apSubMode, SmartSubMode smartSubMode, FanSpeedEnum fanSpeedEnum, Object obj, int i, double d, double d2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(purifierMode2, "p");
        Intrinsics.checkNotNullParameter(mainMode, "m");
        Intrinsics.checkNotNullParameter(apSubMode, "aps");
        Intrinsics.checkNotNullParameter(smartSubMode, "sms");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "f");
        Intrinsics.checkNotNullParameter(obj, "b");
        deviceCreateEditScheduleViewModel.setScheduleEndCustomMode(purifierMode2);
        deviceCreateEditScheduleViewModel.setScheduleEndCustomMainMode(mainMode);
        deviceCreateEditScheduleViewModel.setScheduleEndCustomApSubMode(apSubMode);
        deviceCreateEditScheduleViewModel.scheduleEndCustomSmartSubMode = smartSubMode;
        deviceCreateEditScheduleViewModel.setScheduleEndCustomFanSpeed(fanSpeedEnum);
        deviceCreateEditScheduleViewModel.scheduleEndCustomBrightness = obj;
        deviceCreateEditScheduleViewModel.scheduleEndCustomAutoRh = i;
        deviceCreateEditScheduleViewModel.scheduleEndCustomHeatAutoTemp = d;
        deviceCreateEditScheduleViewModel.scheduleEndCustomHeatEcoTemp = d2;
        deviceCreateEditScheduleViewModel.scheduleEndCustomOscillationEnabled = z;
        deviceCreateEditScheduleViewModel.scheduleEndCustomHumMode = z2;
        deviceCreateEditScheduleViewModel.endFanSpeed = fanSpeedEnum;
        deviceCreateEditScheduleViewModel.endBrightness = obj;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onComplete$_onComplete(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, Function2<? super Boolean, ? super Boolean, Unit> function2, boolean z, boolean z2) {
        deviceCreateEditScheduleViewModel.requesting.postValue(false);
        function2.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final void onComplete(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        this.requesting.setValue(true);
        if (!validateModel()) {
            onComplete$_onComplete(this, function2, false, false);
            return;
        }
        Device device2 = this.device;
        if (device2 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new DeviceCreateEditScheduleViewModel$onComplete$1$1(this, device2, function2, (Continuation<? super DeviceCreateEditScheduleViewModel$onComplete$1$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean hasOverlap(List<DeviceScheduleMerged> list) {
        return DeviceScheduleUtils.INSTANCE.testOverlapOfSchedules(this.startTime, this.endTime, this.repeat, this.state, this.editingSchedule, list);
    }

    private final boolean validateModel() {
        if (this.repeat.isEmpty() || Intrinsics.areEqual((Object) this.isStartTimeSameAsEndTime.getValue(), (Object) true)) {
            this.validState.setValue(false);
            return false;
        }
        this.validState.setValue(true);
        return true;
    }

    private final List<DeviceScheduleInstruction> buildInstructions(Device device2, PurifierMode purifierMode2, FanSpeedEnum fanSpeedEnum, Object obj, int i, MainMode mainMode, ApSubMode apSubMode, SmartSubMode smartSubMode, double d, double d2, boolean z, boolean z2) {
        FanSpeedEnum fanSpeedEnum2 = fanSpeedEnum;
        Object obj2 = obj;
        ApSubMode apSubMode2 = apSubMode;
        List<DeviceScheduleInstruction> arrayList = new ArrayList<>();
        if (purifierMode2 == PurifierMode.STANDBY) {
            buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getDefaultValue());
            return arrayList;
        }
        if (device2 instanceof HasDehumidifierMainMode) {
            buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(mainMode.getValue()));
            int i2 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
            if (i2 == 1) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
                DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                buildInstructions$addInstruction(arrayList, deviceScheduleInstructionType, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i2 == 2) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
                return arrayList;
            } else if (i2 == 3) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.DRYING.getValue()));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i2 == 4) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.AUTO.getValue()));
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(i));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i2 == 5) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.CONTINUOUS.getValue()));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            }
        } else if (device2 instanceof HasPetMainMode) {
            int i3 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
            if (i3 == 1) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
                DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType2 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                buildInstructions$addInstruction(arrayList, deviceScheduleInstructionType2, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i3 == 2) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
                return arrayList;
            } else if (i3 == 6) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.SMART.getValue()));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            }
        } else if (device2 instanceof HasCombo3in1MainMode) {
            buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(mainMode.getValue()));
            if (!(!(device2 instanceof HasOscillation) || apSubMode2 == ApSubMode.ECO || (fanSpeedEnum2 == FanSpeedEnum.OFF && apSubMode2 == ApSubMode.FAN))) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.OSCILLATION_STATE, z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            if (device2 instanceof HasBrightness) {
                if (SetsKt.setOf(ApSubMode.AUTO, ApSubMode.FAN).contains(apSubMode2)) {
                    buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                }
            }
            int i4 = WhenMappings.$EnumSwitchMapping$4[mainMode.ordinal()];
            if (i4 == 2) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(apSubMode2.getValue()));
                if ((device2 instanceof HasFanSpeed) && apSubMode2 == ApSubMode.FAN) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                    return arrayList;
                }
            } else if (i4 == 4) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_SUB_MODE, String.valueOf(apSubMode2.getValue()));
                int i5 = WhenMappings.$EnumSwitchMapping$3[apSubMode2.ordinal()];
                if (i5 != 1) {
                    if (i5 == 3) {
                        buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_AUTO_TMP, String.valueOf(DeviceData.Companion.toServerValue(d)));
                        return arrayList;
                    } else if (i5 == 4) {
                        buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_ECO_TMP, String.valueOf(DeviceData.Companion.toServerValue(d2)));
                        return arrayList;
                    }
                } else if (device2 instanceof HasFanSpeed) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                    return arrayList;
                }
            } else if (i4 == 5) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_SUB_MODE, String.valueOf(apSubMode2.getValue()));
                if ((device2 instanceof HasFanSpeed) && apSubMode2 == ApSubMode.FAN) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                    return arrayList;
                }
            }
        } else if (device2 instanceof HasHumMainMode) {
            buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(mainMode.getValue()));
            if (mainMode == MainMode.Humidification) {
                int i6 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
                if (i6 == 1) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.FAN.getValue()));
                    DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType3 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                    Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                    buildInstructions$addInstruction(arrayList, deviceScheduleInstructionType3, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                } else if (i6 == 2) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.NIGHT.getValue()));
                } else if (i6 == 4) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.AUTO.getValue()));
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(i));
                } else if (i6 == 7) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.SKIN.getValue()));
                }
            } else {
                int i7 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
                if (i7 == 1) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
                    DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType4 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                    Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                    buildInstructions$addInstruction(arrayList, deviceScheduleInstructionType4, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                } else if (i7 == 2) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
                } else if (i7 == 4) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.AUTO.getValue()));
                }
            }
            if (purifierMode2 != PurifierMode.NIGHT) {
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            }
        } else if (device2 instanceof HasMainMode) {
            buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
            int i8 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
            if (i8 == 1) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
                DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType5 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                buildInstructions$addInstruction(arrayList, deviceScheduleInstructionType5, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i8 == 2) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
                return arrayList;
            } else if (i8 == 4) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.AUTO.getValue()));
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            } else if (i8 == 8) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.ECO.getValue()));
                return arrayList;
            }
        } else if (device2 instanceof HasMode) {
            boolean z3 = device2 instanceof HasHumMode;
            if (z3) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE, String.valueOf(z2));
            }
            int i9 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
            if (i9 == 1) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.FAN.getValue()));
                if (device2 instanceof HasFanSpeed) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                }
            } else if (i9 == 2) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.NIGHT.getValue()));
            } else if (i9 == 4) {
                buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.AUTO.getValue()));
                if ((device2 instanceof HasAutoRh) && (!z3 || z2)) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(i));
                }
            }
            if ((device2 instanceof HasBrightness) && purifierMode2 != PurifierMode.NIGHT) {
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                return arrayList;
            }
        } else if (device2 instanceof HasBlueCloudFunctions) {
            if (device2 instanceof HasFanSpeed) {
                int i10 = WhenMappings.$EnumSwitchMapping$5[purifierMode2.ordinal()];
                if (i10 == 1) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                } else if (i10 == 2) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getDefaultValue());
                } else if (i10 == 4) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getDefaultValue());
                    if (device2 instanceof HasAutoRh) {
                        buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(i));
                    }
                } else if (i10 == 8) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getDefaultValue());
                } else if (i10 == 9) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getDefaultValue());
                }
            }
            if (device2 instanceof HasBrightness) {
                if (!SetsKt.setOf(PurifierMode.NIGHT, PurifierMode.STANDBY, PurifierMode.DISINFECTION).contains(purifierMode2) && (purifierMode2 != PurifierMode.ECO || !(device2 instanceof DeviceNewClassic))) {
                    buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, false);
                }
            }
            if (purifierMode2 == PurifierMode.MANUAL) {
                arrayList.addAll(resetAutoAndNightInstructions());
                return arrayList;
            }
        } else {
            if (device2 instanceof HasFanSpeed) {
                if (purifierMode2 == PurifierMode.AUTO) {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getDefaultValue());
                } else {
                    buildInstructions$addInstruction(arrayList, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED, String.valueOf(fanSpeedEnum2.toServerValue((HasFanSpeed) device2)));
                }
            }
            if (device2 instanceof HasBrightness) {
                buildInstructions$addBrightnessInstruction(obj2, device2, arrayList, true);
            }
        }
        return arrayList;
    }

    private static final void buildInstructions$addInstruction(List<DeviceScheduleInstruction> list, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType deviceScheduleInstructionType, String str) {
        list.add(DeviceScheduleInstruction.Companion.newInstance(deviceScheduleInstructionType, str));
    }

    private static final void buildInstructions$addBrightnessInstruction(Object obj, Device device2, List<DeviceScheduleInstruction> list, boolean z) {
        if (obj instanceof Brightness) {
            obj = Integer.valueOf(((Brightness) obj).toServerValue(device2));
        } else if (obj instanceof Integer) {
            obj = Integer.valueOf(RangesKt.coerceIn(((Number) obj).intValue(), DeviceKt.useNewBrightnessRange(device2) ? 10 : 0, 100));
        }
        buildInstructions$addInstruction(list, z ? DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS : DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.BRIGHTNESS, obj.toString());
    }

    private final List<DeviceScheduleInstruction> buildStartInstructions(Device device2) {
        return buildInstructions(device2, this.purifierMode, this.startFanSpeed, this.startBrightness, this.startAutoRh, this.startMainMode, this.startApSubMode, this.startSmartSubMode, this.startHeatAutoTemp, this.startHeatEcoTemp, this.startOscillationEnabled, this.startHumMode);
    }

    private final List<DeviceScheduleInstruction> buildEndCustomInstructions(Device device2) {
        return buildInstructions(device2, this.scheduleEndCustomMode, this.scheduleEndCustomFanSpeed, this.scheduleEndCustomBrightness, this.scheduleEndCustomAutoRh, this.scheduleEndCustomMainMode, this.scheduleEndCustomApSubMode, this.scheduleEndCustomSmartSubMode, this.scheduleEndCustomHeatAutoTemp, this.scheduleEndCustomHeatEcoTemp, this.scheduleEndCustomOscillationEnabled, this.scheduleEndCustomHumMode);
    }

    private final List<DeviceScheduleInstruction> buildLegacyEndInstructions(Device device2) {
        List<DeviceScheduleInstruction> arrayList = new ArrayList<>();
        if (device2 instanceof HasBrightness) {
            Object obj = this.endBrightness;
            if (obj instanceof Brightness) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.blueair.core.model.Brightness");
                obj = Integer.valueOf(((Brightness) obj).toServerValue(device2));
            }
            arrayList.add(DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS, String.valueOf(obj)));
        }
        if (device2 instanceof HasFanSpeed) {
            arrayList.add(DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED, String.valueOf(this.endFanSpeed.toServerValue((HasFanSpeed) device2))));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final DeviceSchedule toDeviceSchedule() {
        Device device2 = this.device;
        if (device2 == null) {
            return null;
        }
        List<DeviceScheduleInstruction> buildStartInstructions = buildStartInstructions(device2);
        if (buildStartInstructions.isEmpty()) {
            return null;
        }
        String uid = device2.getUid();
        String displayLabel = getDisplayLabel();
        String format = this.timeFormatter.format(this.startTime.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        String format2 = this.timeFormatter.format(this.endTime.getTime());
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        boolean z = this.paused;
        Set<? extends DayOfWeek> set = this.repeat;
        String id = this.startTime.getTimeZone().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        return new DeviceSchedule((String) null, uid, displayLabel, format, format2, buildStartInstructions, z, set, id, device2 instanceof HasBlueCloudFunctions ? buildEndCustomInstructions(device2) : buildLegacyEndInstructions(device2), this.scheduleEndType.getValue());
    }

    public final void delete(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        if (this.state != State.MODIFY) {
            function1.invoke(false);
            return;
        }
        DeviceScheduleMerged deviceScheduleMerged = this.editingSchedule;
        Device device2 = this.device;
        if (deviceScheduleMerged == null) {
            function1.invoke(false);
        } else if (device2 == null) {
            function1.invoke(false);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DeviceCreateEditScheduleViewModel$delete$1(this, device2, deviceScheduleMerged, function1, (Continuation<? super DeviceCreateEditScheduleViewModel$delete$1>) null), 3, (Object) null);
        }
    }

    private final boolean isStartTimeSameAsEndTime() {
        return DeviceScheduleUtils.INSTANCE.convertCalendarTimeToMinutes(this.startTime) == DeviceScheduleUtils.INSTANCE.convertCalendarTimeToMinutes(this.endTime);
    }

    private final List<DeviceScheduleInstruction> resetAutoAndNightInstructions() {
        return CollectionsKt.listOf(DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE, "false"), DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE, "false"));
    }

    public final void initTimeFormat(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentTimeFormatter = new SimpleDateFormat(DateFormat.is24HourFormat(context) ? "HH:mm" : "hh:mm a");
    }
}
