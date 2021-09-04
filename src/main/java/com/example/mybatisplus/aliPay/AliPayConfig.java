package com.example.mybatisplus.aliPay;


import org.springframework.context.annotation.Configuration;

/**
 * @className: AlipayConfig
 * @Description: TODO
 * @version: v1.８.0
 * @author: GONGWENXUE
 * @date: 2021/6/15 10:37
 */
@Configuration
public class AliPayConfig {
    public static String app_id = "2021000117673783";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQUsQOTLZNjEKBrt8+2U5/gKlKN5ubokBtR0tI/LLc+dTMGintOxahQqYahPwgCefSv07fB4fdOAoVBZlv0QQ9mnexDu+liye2iqABOyDoTYUyX0OnzWCas5Yl0KXY/NLKRNwCpIFwIhu8HhgYgYz0ZBbRBCuo1gRLUmh9ng6qMUxcmc3tVCiO14oPp/FS86PhObMhImM6axSOMjMssoutxRNgoqvSQTIOxfyE/MhqN4/9P64iFaJZfTD1v0/8CaBpAbbt1VgZtRFy5IoiEdalwsMH5bkrERgjK7n0SDKKPf/iYxHR0DRztCjoB+0Sa5oMEltsqRMovJvOXOLKVhUBAgMBAAECggEAM62fTGuFn9EIg31FrTCM3jUI6W1uB9WackbkG1d5CI1g+FCqEKtm2AmQhtB1o1dIrnsYV95PdRQ67/oYTiSu+wwTrc/mWgWxC7kpwCcXCnevqTDZff2ZiOujaRkEOeWV6R2tFjknrCpaegrgn+3LtjscvG1c4ND5qqrwhYKSR7hhxwznRfhtsxZtuCRW17ycTjvj/YD8RYp90oQV5x1oNpTJXozQPYqhtabFzJUCYWcEVZbt34zrNB8ryJFXF+YWYbFME6fyVLF6gejuBgLvtrOnpUXmUGSRqLLnKm8WBZ/EIOoxxSnfHUocVvZup6e0W9brdKPIpxNe8DxgSE9qHQKBgQDjHG71e1xGol04KZ3cZfA+Cv0geET1CfpEM+ar7B9Burr9wf+5wx7fWt3JoQzPBIwFfjAbIj3UGCeXarxwlzYz/xO5iPp7BeOdn2BxELmMRuCnH+Y9jeqfUKqJ4Y/I55T9YwN802A3/Sb0vTaC1CiAnZAemTc3XPh4hcHcJR4/owKBgQCirnXO4+0hQWFzHC4G39HFyFu58wYwTA3EhwA4KQfNur0GNmvj8zKbe+2SbU4IDeR3ebZr3SIN+U864Mw4+bWE37/pucUUHe7OY1LgpbqKFTB5mpfXcS15lT6tb1hrgQTz9Zye9fRGm//fJGfzm4peBWi1HNkvUPmUnu96L3LTCwKBgD8o/yrB/e2e5fHikQZkSyXWBINtLzA+cB1bmcEiT6cF+U7tDuNogkN3j8qtQVSpXQ+CAnrpUOyVMx2HD5T4WJipTaEBmTdxcdW6JyYKkq+SXpPb6TohJ6ja1DK4SjaDQQoe6S9j0ZSAkL7riCdmPUVXjGcWEScScf+Co2FH6VulAoGAO7OQsmt9E649yBO4ZHdxMYdU+knQpJrUlqIAl5ufLIXyZrxEHfSbRupVBl6su1H13U7CfpU5sS0kQXRMHkCtt+SxNmIhjD9r6zwSJzVK3u/lyUrNnJgBW1RFGzr4lQNVQP6LCt8yVVNctJRUvdcAEX8krQq4PaAW587oDcwp9H8CgYBHf0lvNfjFiadZEFwHc8a7zNIkfRZ2KgDBEGvhgxno9bXycNRIcTjgiSkQPAMbGIqRd7WZ+Yvbv+a/P5TntH2r4TQjvr3fNTQBF0vxNRF/ublfSDH9ljTRuXd1f7w6OeOg5fZHvSgd8LUF4AE0NUCsUubrYiHkg3pzPY6tEspjMA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkx4La4+uOQKH3cwU2nv4WmzPliY3kwzXBokuna+I2n2vsWkgL9jqDn87mMQ8UidIv8ggO25GlRMl8hhTqVtabyTCqwkg4ckpvuUds6YR2jy8TWkDj/E1LB4o3XKMRaBo+L8uO1d975rlNii054FFbkeHeQZw5xE45vtBgHvTGKMIavmlz4cBVm5DLNH8b4kWASNrq87HZ2nS+QBD8HagaNVg/Bku/wuWL/VsDsE21VluWtyY78G4tHcX+p/B99RCuN0T9OvtXNWESZh9WpJfoB4F0/G4A3MgJx/VrsOe8Xf1feRWm956mSElkLuIeAXo8vDOn4EkfGCkvMmPnD+MNwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:3000/#/orderinfo"; //在云时需要换成47.108.48.162，想一下怎么解决,以及index.html

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
//    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}