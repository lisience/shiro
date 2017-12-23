package com.shiro.httpsUrlConnection;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by liuenxi on 2017/12/16.
 */
public class HttpPost {
    private static Logger logger = LoggerFactory.getLogger(HttpPost.class);

        public static void post(String path, String token, Map<String, String> params) {
            HttpsURLConnection connection = null;
            try {
                URL url = new URL(path);
                logger.info("请求路径 : " + path );
                connection = (HttpsURLConnection) url.openConnection();
                connection.setSSLSocketFactory(createSSL());
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setUseCaches(false);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(10 * 1000);
                //添加请求头
                connection.setRequestProperty("token", token);
                connection.connect();
                //post数据
                String requestData = parseParams(params);
                logger.info("请求数据 : " + requestData );
                if(StringUtils.isNotBlank(requestData)){
                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(requestData.getBytes("UTF-8"));
                    outputStream.close();
                }
                //获取返回结果
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    String responeStr = readStream(connection.getInputStream());
                    logger.info("服务端返回的数据：" + responeStr);
                } else {
                    int responseCode = connection.getResponseCode();
                    String message = readStream(connection.getErrorStream());
                    logger.info("请求失败： code=" + responseCode + ", msg=" + message);
                }
            } catch (Exception e) {
                logger.info("请求异常：" + e.toString());
//            e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }

        /**
         * 将map转为字符串
         *
         * @param params
         * @return
         * @throws UnsupportedEncodingException
         */
        private static String parseParams(Map<String, String> params) throws UnsupportedEncodingException {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuilder.append(URLEncoder.encode(entry.getKey(), "utf-8"));
                stringBuilder.append("=");
                stringBuilder.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "utf-8"));
                stringBuilder.append("&");
            }
            String str = stringBuilder.toString();
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            return str;
        }

        /**
         * 读取流
         *
         * @param inputStream
         * @return
         * @throws IOException
         */
        private static String readStream(InputStream inputStream) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        }


        /**
         * https的SSL
         *
         * @return
         * @throws NoSuchAlgorithmException
         * @throws KeyManagementException
         */
        private static SSLSocketFactory createSSL() throws NoSuchAlgorithmException, KeyManagementException {
            TrustManager[] tm = new TrustManager[]{myX509TrustManager};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tm, null);
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            return ssf;
        }

        private static TrustManager myX509TrustManager = new X509TrustManager() {

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
            }
        };

    }