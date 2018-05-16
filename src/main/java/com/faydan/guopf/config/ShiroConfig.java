package com.faydan.guopf.config;

import com.faydan.guopf.core.shiro.AuthRealm;
import com.faydan.guopf.core.shiro.CredentialMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * ShiroConfig created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-05-16
 * Time:  11:52
 * <p>
 * Describe:
 */
@Configuration
public class ShiroConfig {

    /**
     * shiro 过滤器
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        // 配置登录url
        shiroFilter.setLoginUrl("/login");
        // 配置登录成功后跳转的url
        shiroFilter.setSuccessUrl("/");
        // 没有权限跳转的url
        shiroFilter.setUnauthorizedUrl("/error/403");

        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("login", "anon");
        filterChainDefinitionMap.put("/admin", "roles[admin]");
        filterChainDefinitionMap.put("/edit", "perms[edit]");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }

    /**
     * 安全管理器
     */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        return securityManager;
    }

    /**
     * 自定义realm
     */
    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher credentialMatcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(credentialMatcher);
        authRealm.setCacheManager(new MemoryConstrainedCacheManager());
        return authRealm;
    }

    /**
     * 自定义密码比较器
     */
    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        return new CredentialMatcher();
    }

    /**
     * 与spring关联
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;

    }



    /**
     * shiro 过滤器
     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter() {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager());
//        // 默认的登录url
//        shiroFilter.setLoginUrl("/login");
//        // 登陆成功后跳转的url
//        shiroFilter.setSuccessUrl("/");
//        // 没有权限跳转你的url
//        shiroFilter.setUnauthorizedUrl("/error/403");
//        Map<String, Filter> myFilters = new HashMap<>();
//        shiroFilter.setFilters(myFilters);
//
//        /*
//         * 配置shiro拦截器链
//         *
//         * anon  不需要认证
//         * authc 需要认证
//         * user  验证通过或RememberMe登录的都可以
//         *
//         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
//         *
//         * 顺序从上到下,优先级依次降低
//         *
//         */
//        Map<String, String> shiroIntercept = new LinkedHashMap<>();
//        shiroIntercept.put("/static/**", "anon");
//        shiroIntercept.put("/login", "anno");
//        shiroIntercept.put("/**", "user");
//        shiroFilter.setFilterChainDefinitionMap(shiroIntercept);
//        return shiroFilter;
//    }
}
