/*
 * Created by lzy on 2020/4/22 4:16 PM.
 */
package com.lzy.demo.service;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import com.caucho.hessian.io.SerializerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzy.demo.service.bean.HessianMessage;
import com.lzy.demo.service.service.SimpleHessianService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Hessian test.
 *
 * @author lzy
 * @version v1.0
 */
@SpringBootTest
@ActiveProfiles("hessian")
public class HessianTest {

    @Resource
    private SimpleHessianService simpleHessianService;

    private static final SerializerFactory SERIALIZER_FACTORY = new SerializerFactory();


    /**
     * 测试序列化
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSerializable() throws IOException {
        //序列化
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianMessage hessianMessage = buildHessianMessage();
        HessianSerializerOutput hessianSerializerOutput = new HessianSerializerOutput(os);
        hessianSerializerOutput.setSerializerFactory(SERIALIZER_FACTORY);
        hessianSerializerOutput.writeObject(hessianMessage);
        hessianSerializerOutput.flush();
        hessianSerializerOutput.close();
        byte[] bytes = os.toByteArray();
        System.out.println("hessian byte size:" + bytes.length);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("json byte size:" + objectMapper.writeValueAsBytes(hessianMessage).length);

        //反序列化
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        HessianSerializerInput hessianSerializerInput = new HessianSerializerInput(is);
        hessianSerializerInput.setSerializerFactory(SERIALIZER_FACTORY);
        HessianMessage readHessianMessage = (HessianMessage) hessianSerializerInput.readObject(HessianMessage.class);
        System.out.println(readHessianMessage);
    }

    /**
     * 测试hessianRPC
     */
    @Test
    public void testHessianRPC() {
        System.out.println(simpleHessianService.simpleHessian(buildHessianMessage()));
    }

    private HessianMessage buildHessianMessage() {
        HessianMessage hessianMessage = new HessianMessage();
        hessianMessage.setBigDecimal(BigDecimal.ONE);
        hessianMessage.setString("hello world");
//        hessianMessage.setLocalDateTime(LocalDateTime.now());
        hessianMessage.setNumberLong(Long.MAX_VALUE);
        HessianMessage innerMessage = new HessianMessage();
        innerMessage.setBigDecimal(BigDecimal.valueOf(0.23));
        innerMessage.setString("hello world");
//        innerMessage.setLocalDateTime(LocalDateTime.now());
        innerMessage.setNumberLong(Long.MAX_VALUE);
        hessianMessage.setInnerMessage(innerMessage);
        hessianMessage.setInnerMessageList(Collections.singletonList(innerMessage));
        Map<String, HessianMessage> messageMap = new HashMap<>();
        messageMap.put("messageMap", innerMessage);
        hessianMessage.setInnerMessageMap(messageMap);
        return hessianMessage;
    }
}
