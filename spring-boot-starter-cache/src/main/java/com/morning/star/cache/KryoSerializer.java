package com.morning.star.cache;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

/**
 * Kryo系列化工具
 * Created by liangguobin on 2017/6/7.
 */
public class KryoSerializer implements Serializer {
    private Logger logger = LoggerFactory.getLogger(KryoSerializer.class);

    private static ThreadLocal<Kryo> KryoHolder  = new ThreadLocal<>();

    private Kryo getKryo() {
        Kryo kryo = KryoHolder.get();
        if(kryo == null) {
            kryo = new Kryo();
            KryoHolder.set(kryo);
        }
        return kryo;
    }



    public byte[] serialize(Object o) {
        long start = System.currentTimeMillis();

        Output output = new Output(1000, 2147483647);

        getKryo().writeClassAndObject(output, o);

        byte[] bytes = output.toBytes();

        output.flush();
        output.close();

        logger.debug("kryo serialize time : {} , length : {}", System.currentTimeMillis() - start, bytes == null ? 0 : bytes.length);
        return bytes;
    }



    public Object deserialize(byte[] bytes, Class clazz) {
        if(bytes == null) {
            return null;
        }

        Input input = new Input(bytes);

        Object o = getKryo().readClassAndObject(input);
        return o;
    }


    @Override
    public String serializeToString(Object o) {
        byte[] bytes = this.serialize(o);

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }


}


