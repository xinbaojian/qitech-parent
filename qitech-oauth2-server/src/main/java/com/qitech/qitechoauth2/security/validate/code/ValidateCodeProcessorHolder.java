package com.qitech.qitechoauth2.security.validate.code;

import com.qitech.qitechoauth2.exception.ValidateCodeException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * 验证码处理分发
 * 通过传递过来的类型，从已经依赖注入容器中搜寻符合名称的组件。
 * 直接通过名称获取对应的 {@link ValidateCodeProcessor} 实现类
 *
 * @author xinbj
 * @date 2019/12/21 15:10
 */
@Component
@RequiredArgsConstructor
public class ValidateCodeProcessorHolder {

    private final @NonNull Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 通过验证码类型查找
     *
     * @param type 验证码类型
     * @return 验证码处理器
     */
    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (Objects.isNull(processor)) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
