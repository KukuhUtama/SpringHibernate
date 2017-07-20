package org.mvc.security.validator;

import org.mvc.security.entity.Role;
import org.mvc.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RoleValidator implements Validator{

	@Autowired
    private RoleService roleService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Role.class.equals(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Role role = (Role) object;
		
		if (roleService.findByName(role.getName()) != null) {
            errors.rejectValue("name", "Duplicate.role.rolename");
        }
	}

}
