package com.shiro.realm;

import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuenxi on 2017/12/12.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //String userName = (String)principal.getPrimaryPrincipal();
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions = new ArrayList<>();
        /*Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }*/
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.findUserByUserName(username);
        //return new SimpleAuthenticationInfo(user, user.getfPassWord(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
       /* String password = passwordService.encryptPassword(user.getfPassWord());
        System.out.println(user.getfPassWord() + " =  db = " + password);
        System.out.println(user.getfPassWord() + " =  db = " + passwordService.encryptPassword(user.getfPassWord()));*/
        return new SimpleAuthenticationInfo(username,
                user.getfPassWord(),
                this.getClass().getName());
    }
}
