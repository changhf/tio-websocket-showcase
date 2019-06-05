/**
 *
 */
package org.tio.showcase.websocket.server;

import org.tio.utils.time.Time;

/**
 * @author chang_hfeng
 */
public abstract class DeliServerConfig {
    /**
     * 协议名字(可以随便取，主要用于开发人员辨识)
     */
    public static final String PROTOCOL_NAME = "deli_edu";

    public static final String CHARSET = "utf-8";
    /**
     * 监听的ip,null表示监听所有，并不指定ip
     */
    public static final String SERVER_IP = null;

    /**
     * 监听端口
     */
    public static final int SERVER_PORT = 9326;

    /**
     * 心跳超时时间，单位：毫秒
     */
    public static final int HEARTBEAT_TIMEOUT = 1000 * 60;

    /**
     * ip数据监控统计，时间段
     *
     * @author chang_hfeng
     */
//    public static interface IpStatDuration {
//
//    }

}
