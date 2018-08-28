import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class NotDuplicateAop {

    private static final Set<String> KEY =  new ConcurrentSkipListSet<>();

    @Pointcut("@annotation(com.*.*.aop.NotDuplicate)")
    public void duplicate() {
    	
    }

    /**
     * 对方法拦截后进行参数验证
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("duplicate()")
    public Object duplicate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method currentMethod = proceedingJoinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        //拼接签名
        StringBuilder sb = new StringBuilder(currentMethod.toString());
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object object : args) {
            if(object != null){
                sb.append(object.getClass().toString());
                sb.append(object.toString());
            }
        }
        String sign = sb.toString();
        boolean success = KEY.add(sign);
        if(!success){
        	return null;
        }
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            KEY.remove(sign);
        }

    }
}