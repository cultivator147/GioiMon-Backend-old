package hust.project.gioimon.adm_client.check_permission;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Aspect
@Component
public class CheckPermissionAspect {
    public CheckPermissionAspect(){

    }
    @Around("@annotation(CheckPermissionAnno)")
    public Object beforeCheckPermission(JoinPoint joinPoint){
        System.out.println("Before checking permission");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        CheckPermissionAnno checkPermissionAnno = method.getAnnotation(CheckPermissionAnno.class);
        String uri = checkPermissionAnno.uri();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String tokenRequest = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println((tokenRequest));
        return null;
    }
}
