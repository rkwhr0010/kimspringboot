package kimspring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		MultiValueMap<String,Object> multiValueMap = 
				importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
		Class<?> propertiyClass = (Class<?>) multiValueMap.getFirst("value");
		return new String[] {propertiyClass.getName()};
	}

}