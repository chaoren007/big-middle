package com.morning.star.retail.admin.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//import com.morning.star.retail.entity.FreshTypeEnum;
//import com.morning.star.retail.entity.GoodsSaleStatus;
//import com.morning.star.retail.entity.ProductMarketStatus;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.AbstractConverter;

public class BeanUtils {

	private final static SimpleObjectConverter INTEGER_CONVERTER = new SimpleObjectConverter(Integer.class);
	private final static SimpleObjectConverter LONG_CONVERTER = new SimpleObjectConverter(Long.class);
	private final static SimpleObjectConverter BYTE_CONVERTER = new SimpleObjectConverter(Byte.class);


	static {
		ConvertUtils.register(INTEGER_CONVERTER, Integer.class);
		ConvertUtils.register(LONG_CONVERTER, Long.class);
		ConvertUtils.register(BYTE_CONVERTER, Byte.class);

//		registerDeserializer(new GoodsSaleStatus.BeanDeserializer(), GoodsSaleStatus.class);
//		registerSerializer(new GoodsSaleStatus.BeanSerializer(), GoodsSaleStatus.class, Integer.class);
//
//		registerDeserializer(new ProductMarketStatus.BeanDeserializer(), ProductMarketStatus.class);
//		registerSerializer(new ProductMarketStatus.BeanSerializer(), ProductMarketStatus.class, Integer.class);
//
//		registerDeserializer(new FreshTypeEnum.BeanDeserializer(), FreshTypeEnum.class);
//		registerSerializer(new FreshTypeEnum.BeanSerializer(), FreshTypeEnum.class, Integer.class);
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
