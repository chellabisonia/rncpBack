package com.farukgenc.boilerplate.springboot.model.user;

import com.farukgenc.boilerplate.springboot.model.BaseEntity;
import com.farukgenc.boilerplate.springboot.model.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	private String lastname;

	@Column(unique = true)
	private String username;

	@Column(unique = true)
	private String phoneNumber;

	private String password;

	@Column(unique = true)
	private String email;

	private String address;

	private String personalDescription;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private Set<RolesUsers> roles = new HashSet<>();


	@OneToOne(mappedBy = "user")
	private UserPicture userPicture;


	public UserRole getUserRole(){
		if(roles.isEmpty())
			return UserRole.USER;

		Set<UserRole> roleEnums = roles.stream()
				.map(ru -> ru.getRole().getUserRole())
				.collect(Collectors.toSet());

		return roleEnums.contains(UserRole.ADMIN) ? UserRole.ADMIN : UserRole.USER;
	}

	public User addRole(Role role){

		if(this.roles == null)
			this.roles = new HashSet<>();

		boolean alreadyExists = this.roles.stream()
				.anyMatch(r -> r.getRole().equals(role));

		if (!alreadyExists) {
			RolesUsers rolesUsers = new RolesUsers();
			rolesUsers.setUser(this);
			rolesUsers.setRole(role);
			this.roles.add(rolesUsers);
		}

		return this;
	}

}
