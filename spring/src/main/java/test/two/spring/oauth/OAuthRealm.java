package test.two.spring.oauth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import test.two.spring.bean.userInfo;
import test.two.spring.result.Code;
import test.two.spring.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class OAuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String)principals.getPrimaryPrincipal();
        userInfo user = userService.getUserByTel(account);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();

        //简单处理   只有admin一个角色
        if(user.getAdmin()){
            roles.add(Code.ROLE_ADMIN);
        }
        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String account = (String)token.getPrincipal();

        userInfo user = userService.getUserByTel(account);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        /*if(UserStatus.blocked.equals(user.getStatus())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getAccount(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );

        return authenticationInfo;
    }
}
