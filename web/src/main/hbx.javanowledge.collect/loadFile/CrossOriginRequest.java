package loadFile;

/**
 * Created by huangbaoxian on 2018/3/9.
 */
public class CrossOriginRequest {

    /**
     *
     * 跨域问题
     *
     *
     * 服务器端解决跨域请求问题，拦截请求并重新设置响应头
     * 服务器端拦截器
     *
     * 也可以通过nginx配置
     *
     *
     * */

    /*
    *
    *       response.setHeader("Access-Control-Allow-Origin", allowDomain);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			String headers = "Origin, Accept-Language, Accept-Encoding,X-Forwarded-For, Connection, Accept, User-Agent, Host, Referer,Cookie, Content-Type, Cache-Control";
			response.setHeader("Access-Control-Allow-Headers", headers);
			response.setHeader("Access-Control-Request-Method", "GET,POST");
    *
    * */

    /*
    * <filter>
	<filter-name>CrossOriginFilter</filter-name>
	<filter-class>com.silence.util.CrossOriginFilter</filter-class>
	<init-param>
		<param-name>domain</param-name>
		<param-value>*</param-value>
	</init-param>
    </filter>
    <filter-mapping>
	<filter-name>CrossOriginFilter</filter-name>
	<url-pattern>/*</url-pattern>
    </filter-mapping>

    *
    * */


    /**
     **
     * tomcat 配置
     *
     * */

    /*
    <filter>
    <filter-name>CorsFilter</filter-name>
    <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
    </filter>
    <filter-mapping>
    <filter-name>CorsFilter</filter-name>
    <url-pattern>/*</url-pattern>
    </filter-mapping>
    */


    /**
     *
     * Nginx配置
     *
     * */

    /*
    *
        add_header 'Access-Control-Allow-Methods' 'GET,OPTIONS,PUT,DELETE' always;
        add_header 'Access-Control-Allow-Credentials' 'true' always;
        add_header 'Access-Control-Allow-Origin' '$http_origin' always;
        add_header 'Access-Control-Allow-Headers' 'Authorization,DNT,User-Agent,
                Keep-Alive,Content-Type,accept,origin,X-Requested-With' always;

        if ($request_method = OPTIONS ) {
        return 200;
        }
    * */

    /**apache配置
    *
    * */

    /*
        Header always set Access-Control-Allow-Origin "http://waffle"
        Header always set Access-Control-Allow-Methods "POST, GET, OPTIONS"
        Header always set Access-Control-Allow-Credentials "true"
        Header always set Access-Control-Allow-Headers "Authorization,DNT,User-Agent,Keep-Alive,Content-Type,accept,origin,X-Requested-With"

        RewriteCond %{REQUEST_METHOD} OPTIONS
        RewriteRule ^(.*)$ $1 [R=200,L]
    * */



}
