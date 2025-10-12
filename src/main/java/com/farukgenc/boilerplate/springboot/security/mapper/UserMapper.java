package com.farukgenc.boilerplate.springboot.security.mapper;

import com.farukgenc.boilerplate.springboot.model.enumeration.UserRole;
import com.farukgenc.boilerplate.springboot.model.user.Role;
import com.farukgenc.boilerplate.springboot.model.user.RolesUsers;
import com.farukgenc.boilerplate.springboot.model.user.User;
import com.farukgenc.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	@Mapping(target = "userRole", source = "user", qualifiedByName = "extractUserRole")
	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);


	@Named("extractUserRole")
	static UserRole mapUserToUserRole(User user) {
		return user.getRoles().stream()
				.map(RolesUsers::getRole)
				.map(Role::getUserRole)
				.findFirst()
				.orElse(null);
	}

}
