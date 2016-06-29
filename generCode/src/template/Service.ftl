package ${packageName};

import org.springframework.stereotype.Service;
import com.tw.sys.service.Impl.BaseService;
import ${importPackage}.I${beanName}Service;

/** 
 * @ClassName: ${beanName}Service
 * @Description: ${tableRemark} Service
 
 * @author ${authorOriginally}
 * @date ${currentTime}
 */ 
@SuppressWarnings("all")
@Service("${beanNameLower}Service")
public class ${beanName}Service extends BaseService implements I${beanName}Service{

}
