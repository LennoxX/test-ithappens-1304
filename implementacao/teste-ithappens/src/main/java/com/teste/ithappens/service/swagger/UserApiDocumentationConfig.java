package com.teste.ithappens.service.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info = @Info(description = "Detalhes da API", version = "V0.0.1-SNAPSHOP", title = "API feita para teste de seleção ItHappens", contact = @Contact(name = "Lucas", email = "lucasraphael.fernandes@hotmail.com", url = ""), license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")), consumes = {
		"application/json" }, produces = {
				"application/json" }, schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS })
public interface UserApiDocumentationConfig {

}
