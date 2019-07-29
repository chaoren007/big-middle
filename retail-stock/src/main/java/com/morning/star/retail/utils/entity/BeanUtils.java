package com.morning.star.retail.utils.entity;

import com.morning.star.retail.stock.enums.*;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanUtils {

	private final static SimpleObjectConverter INTEGER_CONVERTER = new SimpleObjectConverter(Integer.class);
	private final static SimpleObjectConverter LONG_CONVERTER = new SimpleObjectConverter(Long.class);
	private final static SimpleObjectConverter BYTE_CONVERTER = new SimpleObjectConverter(Byte.class);


	static {
		ConvertUtils.register(INTEGER_CONVERTER, Integer.class);
		ConvertUtils.register(LONG_CONVERTER, Long.class);
		ConvertUtils.register(BYTE_CONVERTER, Byte.class);

		registerDeserializer(new ReplenishStatus.BeanDeserializer(), ReplenishStatus.class);
		registerDeserializer(new ReceiptStatusEnum.BeanDeserializer(), ReceiptStatusEnum.class);
		registerDeserializer(new PurchaseStatusEnum.BeanDeserializer(), PurchaseStatusEnum.class);

		registerDeserializer(new InventoryMode.BeanDeserializer(), InventoryMode.class);
		registerSerializer(new InventoryEntryStatus.BeanSerializer(), InventoryEntryStatus.class, Integer.class);
		registerSerializer(new InventoryStashStatus.BeanSerializer(), InventoryStashStatus.class, Integer.class);
		registerSerializer(new InventoryStatementStatus.BeanSerializer(), InventoryStatementStatus.class, Integer.class);
		registerSerializer(new InventoryReadStatus.BeanSerializer(), InventoryReadStatus.class, Integer.class);
		registerSerializer(new InventoryAuditStatus.BeanSerializer(), InventoryAuditStatus.class, Integer.class);
		registerSerializer(new InventoryStatus.BeanSerializer(), InventoryStatus.class, Integer.class);
		registerSerializer(new InventoryStatementType.BeanSerializer(), InventoryStatementType.class, Integer.class);

		registerSerializer(new ReplenishStatus.BeanSerializer(), ReplenishStatus.class, Integer.class);
		registerSerializer(new PurchaseStatusEnum.BeanSerializer(), PurchaseStatusEnum.class, Integer.class);

		registerSerializer(new TransferStatus.BeanConverter(), TransferStatus.class, Integer.class);
		registerSerializer(new ReceiptDiffStatusEnum.BeanSerializer(), ReceiptDiffStatusEnum.class, Integer.class);
		registerSerializer(new ReceiptDiffPlanEnum.BeanSerializer(), ReceiptDiffPlanEnum.class, Integer.class);


		registerDeserializer(new ReceiptTypeEnum.BeanDeserializer(), ReceiptTypeEnum.class);
		registerSerializer(new ReceiptTypeEnum.BeanSerializer(), ReceiptTypeEnum.class, Integer.class);
		registerDeserializer(new ReceiptStatusEnum.BeanDeserializer(), ReceiptStatusEnum.class);
		registerSerializer(new ReceiptStatusEnum.BeanSerializer(), ReceiptStatusEnum.class, Integer.class);
		registerDeserializer(new ReceiptDiffStatusEnum.BeanDeserializer(), ReceiptDiffStatusEnum.class);
		registerSerializer(new ReceiptDiffStatusEnum.BeanSerializer(), ReceiptDiffStatusEnum.class, Integer.class);
		registerDeserializer(new ReceiptDiffPlanEnum.BeanDeserializer(), ReceiptDiffPlanEnum.class);
		registerSerializer(new ReceiptDiffPlanEnum.BeanSerializer(), ReceiptDiffPlanEnum.class, Integer.class);

		registerDeserializer(new PurchaseSubmitEnum.BeanDeserializer(), PurchaseSubmitEnum.class);
		registerSerializer(new PurchaseSubmitEnum.BeanSerializer(), PurchaseSubmitEnum.class, Integer.class);

		registerDeserializer(new PurchaseInStatusEnum.BeanDeserializer(), PurchaseInStatusEnum.class);
		registerSerializer(new PurchaseInStatusEnum.BeanSerializer(), PurchaseInStatusEnum.class, Integer.class);

		registerDeserializer(new OutStockType.BeanDeserializer(), OutStockType.class);
		registerSerializer(new OutStockType.BeanSerializer(), OutStockType.class, Integer.class);

		registerDeserializer(new OutStockStatusEnum.BeanDeserializer(), OutStockStatusEnum.class);
		registerSerializer(new OutStockStatusEnum.BeanSerializer(), OutStockStatusEnum.class, Integer.class);
	}

	public static void registerSerializer(final Converter converter, final Class<?> srcClazz, final Class<?> targetClazz) {
		if (Integer.class.equals(targetClazz)) {
			INTEGER_CONVERTER.register(srcClazz, converter);
		} else if (Long.class.equals(targetClazz)) {
			LONG_CONVERTER.register(srcClazz, converter);
		} else if (Byte.class.equals(targetClazz)) {
			BYTE_CONVERTER.register(srcClazz, converter);
		} else {
			throw new RuntimeException("unsupport target type");
		}
	}

	public static void registerDeserializer(final Converter converter, final Class<?> clazz) {
		ConvertUtils.register(converter, clazz);
	}

	public static void copy(Object src, Object dest) {
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public static class SimpleObjectConverter extends AbstractConverter {
		private Map<Class<?>, Converter> holder = new ConcurrentHashMap<>();
		private Class<?> defaultType;

		public SimpleObjectConverter(Class<?> defaultType) {
			this.defaultType = defaultType;
		}

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			Converter converter = holder.get(value.getClass());
			return converter == null ? null : converter.convert(type, value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return defaultType;
		}

		public void register(Class<?> cls, Converter converter) {
			holder.put(cls, converter);
		}
	}


}
