package edu.yangao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import edu.yangao.util.AgvUtil;
import edu.yangao.util.CustomServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-03 22:39
 */
@ServerEndpoint(value = "/agv/info", encoders = {})
@Component
public class AgvInfoWebsocket {

    private static final Logger log = LoggerFactory.getLogger(AgvInfoWebsocket.class);
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 线程池
     */
    private ScheduledThreadPoolExecutor threadPool;
    private static AgvUtil agvUtil;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        // 存储session
        this.session = session;
        session.getBasicRemote().sendText("测试信息open");
        // 创建线程池
        threadPool = new ScheduledThreadPoolExecutor(1);
        threadPool.scheduleWithFixedDelay(new AvgInfoSendThread(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    @OnClose
    public void onClose() throws IOException {
        // 销毁线程
        if (Objects.nonNull(threadPool)) {
            threadPool.shutdown();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        // 销毁线程
        if (Objects.nonNull(threadPool)) {
            threadPool.shutdown();
        }
        log.error(error.getMessage());
        error.printStackTrace();
    }

    private class AvgInfoSendThread extends Thread {
        @Override
        public void run() {
            ObjectMapper mapper = new ObjectMapper();
            String s;
            try {
                s = mapper.writeValueAsString(agvUtil.getAgvInfo());
                session.getBasicRemote().sendText(s);
            } catch (JsonProcessingException e) {  // json 生成错误
                session.getAsyncRemote().sendText("json 格式化错误: " + e.getLocalizedMessage());
            } catch (IOException e) {  // io错误
                session.getAsyncRemote().sendText("IO错误: " + e.getLocalizedMessage());
            } catch (ModbusTransportException | ErrorResponseException e) {  // modbus 参数错误
                session.getAsyncRemote().sendText("modbus 数据获取错误, 请检查机器与参数: " + e.getLocalizedMessage());
            } catch (CustomServiceException e) {
                session.getAsyncRemote().sendText("业务异常: " + e.getMessage());
            } catch (Exception e) {
                session.getAsyncRemote().sendText("未知错误");
            }
        }
    }

    @Autowired
    public void setAgvUtil(AgvUtil agvUtil) {
        AgvInfoWebsocket.agvUtil = agvUtil;
    }
}
