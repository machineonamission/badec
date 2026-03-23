package com.blueair.devicemanager;

import com.blueair.api.restapi.DeviceAttribute;
import com.blueair.api.restapi.DeviceAttributeOnAbl;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceClassicWithoutSensors;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceSense;
import com.blueair.core.model.HasAblCloudFunctions;
import com.blueair.core.model.IndoorDatapoint;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "attributes", "", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getAttributes$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getAttributes$2 extends SuspendLambda implements Function2<List<? extends DeviceAttributeOnAbl>, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasAblCloudFunctions $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getAttributes$2(HasAblCloudFunctions hasAblCloudFunctions, DeviceManager deviceManager, Continuation<? super DeviceManager$getAttributes$2> continuation) {
        super(2, continuation);
        this.$device = hasAblCloudFunctions;
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getAttributes$2 deviceManager$getAttributes$2 = new DeviceManager$getAttributes$2(this.$device, this.this$0, continuation);
        deviceManager$getAttributes$2.L$0 = obj;
        return deviceManager$getAttributes$2;
    }

    public final Object invoke(List<DeviceAttributeOnAbl> list, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getAttributes$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterator it;
        Object obj2;
        List list = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it2 = list.iterator();
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Integer num = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj12 = null;
            Object obj13 = null;
            while (it2.hasNext()) {
                DeviceAttribute<? extends Object> parsedAttribute = ((DeviceAttributeOnAbl) it2.next()).getParsedAttribute();
                if (parsedAttribute instanceof DeviceAttribute.Brightness) {
                    obj3 = ((DeviceAttribute.Brightness) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.ChildLock) {
                    obj6 = ((DeviceAttribute.ChildLock) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.FanSpeed) {
                    obj4 = ((DeviceAttribute.FanSpeed) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.FanUsage) {
                    num = Boxing.boxInt(Integer.parseInt((String) StringsKt.split$default((CharSequence) ((DeviceAttribute.FanUsage) parsedAttribute).getValue(), new String[]{";"}, false, 0, 6, (Object) null).get(4)));
                } else if (parsedAttribute instanceof DeviceAttribute.Mode) {
                    obj5 = ((DeviceAttribute.Mode) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.SerialNumber) {
                    obj7 = ((DeviceAttribute.SerialNumber) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.PurchaseDate) {
                    obj8 = ((DeviceAttribute.PurchaseDate) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.DealerName) {
                    obj9 = ((DeviceAttribute.DealerName) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.DealerCountry) {
                    obj10 = ((DeviceAttribute.DealerCountry) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.McuFirmware) {
                    obj11 = ((DeviceAttribute.McuFirmware) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.FilterType) {
                    obj12 = ((DeviceAttribute.FilterType) parsedAttribute).getValue();
                } else if (parsedAttribute instanceof DeviceAttribute.AutoModeDependency) {
                    obj13 = ((DeviceAttribute.AutoModeDependency) parsedAttribute).getValue();
                } else {
                    if (parsedAttribute instanceof DeviceAttribute.UnknownAttribute) {
                        it = it2;
                        obj2 = obj3;
                        Timber.Forest.d("Unable to parse " + parsedAttribute, new Object[0]);
                    } else {
                        it = it2;
                        obj2 = obj3;
                    }
                    obj3 = obj2;
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            Object obj14 = obj3;
            HasAblCloudFunctions hasAblCloudFunctions = this.$device;
            if (hasAblCloudFunctions instanceof DeviceClassic) {
                DeviceManager deviceManager = this.this$0;
                DeviceClassic deviceClassic = (DeviceClassic) hasAblCloudFunctions;
                Integer num2 = (Integer) obj14;
                int intValue = num2 != null ? num2.intValue() : ((DeviceClassic) hasAblCloudFunctions).getBrightness();
                Integer num3 = (Integer) obj4;
                int intValue2 = num3 != null ? num3.intValue() : ((DeviceClassic) this.$device).getFanSpeed();
                String str = (String) obj5;
                if (str == null) {
                    str = ((DeviceClassic) this.$device).getAutoModeText();
                }
                String str2 = str;
                Boolean bool = (Boolean) obj6;
                boolean booleanValue = bool != null ? bool.booleanValue() : ((DeviceClassic) this.$device).isChildLockOn();
                if (num == null) {
                    num = ((DeviceClassic) this.$device).getFilterLife();
                }
                Integer num4 = num;
                String str3 = (String) obj7;
                if (str3 == null) {
                    str3 = ((DeviceClassic) this.$device).getSerial();
                }
                String str4 = str3;
                String str5 = (String) obj8;
                if (str5 == null) {
                    str5 = ((DeviceClassic) this.$device).getPurchaseDate();
                }
                String str6 = str5;
                String str7 = (String) obj9;
                if (str7 == null) {
                    str7 = ((DeviceClassic) this.$device).getDealerName();
                }
                String str8 = str7;
                String str9 = (String) obj10;
                if (str9 == null) {
                    str9 = ((DeviceClassic) this.$device).getDealerCountry();
                }
                String str10 = str9;
                String str11 = (String) obj11;
                if (str11 == null) {
                    str11 = ((DeviceClassic) this.$device).getMcuFirmware();
                }
                String str12 = str11;
                String str13 = (String) obj12;
                if (str13 == null) {
                    str13 = ((DeviceClassic) this.$device).getFilterType();
                }
                String str14 = str13;
                String str15 = (String) obj13;
                if (str15 == null) {
                    str15 = ((DeviceClassic) this.$device).getFilterTrigger();
                }
                deviceManager.addOrUpdateDevice(DeviceClassic.copy$default(deviceClassic, (String) null, (String) null, intValue2, num4, intValue, str2, (String) null, (IndoorDatapoint) null, 0, false, booleanValue, 0, 0, (String) null, str12, (String) null, (String) null, (String) null, str4, str6, str8, str10, str14, str15, (double[]) null, (double[]) null, (double[]) null, (double[]) null, (double[]) null, 0, (String) null, false, (String) null, -16532541, 1, (Object) null));
            } else if (hasAblCloudFunctions instanceof DeviceClassicWithoutSensors) {
                DeviceManager deviceManager2 = this.this$0;
                DeviceClassicWithoutSensors deviceClassicWithoutSensors = (DeviceClassicWithoutSensors) hasAblCloudFunctions;
                Integer num5 = (Integer) obj14;
                int intValue3 = num5 != null ? num5.intValue() : ((DeviceClassicWithoutSensors) hasAblCloudFunctions).getBrightness();
                Integer num6 = (Integer) obj4;
                int intValue4 = num6 != null ? num6.intValue() : ((DeviceClassicWithoutSensors) this.$device).getFanSpeed();
                String str16 = (String) obj5;
                if (str16 == null) {
                    str16 = ((DeviceClassicWithoutSensors) this.$device).getAutoModeText();
                }
                String str17 = str16;
                Boolean bool2 = (Boolean) obj6;
                boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : ((DeviceClassicWithoutSensors) this.$device).isChildLockOn();
                if (num == null) {
                    num = ((DeviceClassicWithoutSensors) this.$device).getFilterLife();
                }
                Integer num7 = num;
                String str18 = (String) obj7;
                if (str18 == null) {
                    str18 = ((DeviceClassicWithoutSensors) this.$device).getSerial();
                }
                String str19 = str18;
                String str20 = (String) obj8;
                if (str20 == null) {
                    str20 = ((DeviceClassicWithoutSensors) this.$device).getPurchaseDate();
                }
                String str21 = str20;
                String str22 = (String) obj9;
                if (str22 == null) {
                    str22 = ((DeviceClassicWithoutSensors) this.$device).getDealerName();
                }
                String str23 = str22;
                String str24 = (String) obj10;
                if (str24 == null) {
                    str24 = ((DeviceClassicWithoutSensors) this.$device).getDealerCountry();
                }
                String str25 = str24;
                String str26 = (String) obj11;
                if (str26 == null) {
                    str26 = ((DeviceClassicWithoutSensors) this.$device).getMcuFirmware();
                }
                String str27 = str26;
                String str28 = (String) obj12;
                if (str28 == null) {
                    str28 = ((DeviceClassicWithoutSensors) this.$device).getFilterType();
                }
                String str29 = str28;
                String str30 = (String) obj13;
                if (str30 == null) {
                    str30 = ((DeviceClassicWithoutSensors) this.$device).getFilterTrigger();
                }
                deviceManager2.addOrUpdateDevice(DeviceClassicWithoutSensors.copy$default(deviceClassicWithoutSensors, (String) null, (String) null, intValue4, num7, intValue3, str17, (String) null, false, booleanValue2, (String) null, 0, 0, (String) null, str27, (String) null, (String) null, (String) null, str19, str21, str23, str25, str29, str30, 0, (String) null, (String) null, 58842819, (Object) null));
            } else if (hasAblCloudFunctions instanceof DeviceIcp) {
                DeviceManager deviceManager3 = this.this$0;
                DeviceIcp deviceIcp = (DeviceIcp) hasAblCloudFunctions;
                Integer num8 = (Integer) obj4;
                int intValue5 = num8 != null ? num8.intValue() : ((DeviceIcp) hasAblCloudFunctions).getFanSpeed();
                String str31 = (String) obj5;
                if (str31 == null) {
                    str31 = ((DeviceIcp) this.$device).getAutoModeText();
                }
                String str32 = str31;
                Boolean bool3 = (Boolean) obj6;
                boolean booleanValue3 = bool3 != null ? bool3.booleanValue() : ((DeviceIcp) this.$device).isChildLockOn();
                Integer filterLife = ((DeviceIcp) this.$device).getFilterLife();
                String str33 = (String) obj7;
                if (str33 == null) {
                    str33 = ((DeviceIcp) this.$device).getSerial();
                }
                String str34 = str33;
                String str35 = (String) obj8;
                if (str35 == null) {
                    str35 = ((DeviceIcp) this.$device).getPurchaseDate();
                }
                String str36 = str35;
                String str37 = (String) obj9;
                if (str37 == null) {
                    str37 = ((DeviceIcp) this.$device).getDealerName();
                }
                String str38 = str37;
                String str39 = (String) obj10;
                if (str39 == null) {
                    str39 = ((DeviceIcp) this.$device).getDealerCountry();
                }
                String str40 = str39;
                String str41 = (String) obj11;
                if (str41 == null) {
                    str41 = ((DeviceIcp) this.$device).getMcuFirmware();
                }
                String str42 = str41;
                String str43 = (String) obj12;
                if (str43 == null) {
                    str43 = ((DeviceIcp) this.$device).getFilterType();
                }
                String str44 = str43;
                String str45 = (String) obj13;
                if (str45 == null) {
                    str45 = ((DeviceIcp) this.$device).getFilterTrigger();
                }
                deviceManager3.addOrUpdateDevice(DeviceIcp.copy$default(deviceIcp, (String) null, (String) null, intValue5, filterLife, str32, (String) null, (IndoorDatapoint) null, 0, booleanValue3, 0, 0, (String) null, str42, (String) null, (String) null, (String) null, str34, str36, str38, str40, str44, str45, (double[]) null, (double[]) null, (double[]) null, (double[]) null, (double[]) null, 0, (String) null, 532737763, (Object) null));
            } else if (hasAblCloudFunctions instanceof DeviceSense) {
                DeviceManager deviceManager4 = this.this$0;
                DeviceSense deviceSense = (DeviceSense) hasAblCloudFunctions;
                Integer num9 = (Integer) obj14;
                int intValue6 = num9 != null ? num9.intValue() : ((DeviceSense) hasAblCloudFunctions).getBrightness();
                Integer num10 = (Integer) obj4;
                int intValue7 = num10 != null ? num10.intValue() : ((DeviceSense) this.$device).getFanSpeed();
                String str46 = (String) obj5;
                if (str46 == null) {
                    str46 = ((DeviceSense) this.$device).getAutoModeText();
                }
                String str47 = str46;
                Boolean bool4 = (Boolean) obj6;
                boolean booleanValue4 = bool4 != null ? bool4.booleanValue() : ((DeviceSense) this.$device).isChildLockOn();
                if (num == null) {
                    num = ((DeviceSense) this.$device).getFilterLife();
                }
                Integer num11 = num;
                String str48 = (String) obj7;
                if (str48 == null) {
                    str48 = ((DeviceSense) this.$device).getSerial();
                }
                String str49 = str48;
                String str50 = (String) obj8;
                if (str50 == null) {
                    str50 = ((DeviceSense) this.$device).getPurchaseDate();
                }
                String str51 = str50;
                String str52 = (String) obj9;
                if (str52 == null) {
                    str52 = ((DeviceSense) this.$device).getDealerName();
                }
                String str53 = str52;
                String str54 = (String) obj10;
                if (str54 == null) {
                    str54 = ((DeviceSense) this.$device).getDealerCountry();
                }
                String str55 = str54;
                String str56 = (String) obj11;
                if (str56 == null) {
                    str56 = ((DeviceSense) this.$device).getMcuFirmware();
                }
                String str57 = str56;
                String str58 = (String) obj12;
                if (str58 == null) {
                    str58 = ((DeviceSense) this.$device).getFilterType();
                }
                String str59 = str58;
                String str60 = (String) obj13;
                if (str60 == null) {
                    str60 = ((DeviceSense) this.$device).getFilterTrigger();
                }
                deviceManager4.addOrUpdateDevice(DeviceSense.copy$default(deviceSense, (String) null, (String) null, intValue7, num11, intValue6, str47, (String) null, booleanValue4, (String) null, false, 0, 0, (String) null, str57, (String) null, (String) null, (String) null, str49, str51, str53, str55, str59, str60, 0, (String) null, 25288515, (Object) null));
            } else if (hasAblCloudFunctions instanceof DeviceAware) {
                DeviceManager deviceManager5 = this.this$0;
                DeviceAware deviceAware = (DeviceAware) hasAblCloudFunctions;
                Integer num12 = (Integer) obj14;
                int intValue8 = num12 != null ? num12.intValue() : ((DeviceAware) hasAblCloudFunctions).getBrightness();
                String str61 = (String) obj7;
                if (str61 == null) {
                    str61 = ((DeviceAware) this.$device).getSerial();
                }
                String str62 = str61;
                String str63 = (String) obj8;
                if (str63 == null) {
                    str63 = ((DeviceAware) this.$device).getPurchaseDate();
                }
                String str64 = str63;
                String str65 = (String) obj9;
                if (str65 == null) {
                    str65 = ((DeviceAware) this.$device).getDealerName();
                }
                String str66 = str65;
                String str67 = (String) obj10;
                if (str67 == null) {
                    str67 = ((DeviceAware) this.$device).getDealerCountry();
                }
                String str68 = str67;
                String str69 = (String) obj11;
                if (str69 == null) {
                    str69 = ((DeviceAware) this.$device).getMcuFirmware();
                }
                deviceManager5.addOrUpdateDevice(DeviceAware.copy$default(deviceAware, (String) null, (String) null, intValue8, (String) null, (IndoorDatapoint) null, 0, false, 0, 0, (String) null, str69, (String) null, (String) null, (String) null, str62, str64, str66, str68, (double[]) null, (double[]) null, (double[]) null, (double[]) null, (double[]) null, 0, (String) null, 33307643, (Object) null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
