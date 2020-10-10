package com.xjl.service.impl;

import com.xjl.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @Author: 玲
 * @Description:
 * 这不是传统的service,这是和rabbitmq打交道的，不需要加注解@Service
 * 这里不调dao，调消息中间件的service
 * 信道channel和exchange绑定在一起
 * 定义消息的推送管道
 * @create 2020-10-10 16:41
 * @Modified By:
 */

@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " +serial);
        return "*****serial: " +serial;
    }
}
