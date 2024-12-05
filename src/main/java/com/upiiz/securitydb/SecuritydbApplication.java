package com.upiiz.securitydb;

import com.upiiz.securitydb.entities.PermissionEntity;
import com.upiiz.securitydb.entities.RoleEntity;
import com.upiiz.securitydb.entities.RoleEnum;
import com.upiiz.securitydb.entities.UserEntity;
import com.upiiz.securitydb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecuritydbApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SecuritydbApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			//Crear Permisos
			PermissionEntity createPermission = PermissionEntity
					.builder()
					.name("CREATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity
					.builder()
					.name("DELETE")
					.build();
			PermissionEntity updatePermission = PermissionEntity
					.builder()
					.name("UPDATE")
					.build();
			PermissionEntity readPermission = PermissionEntity
					.builder()
					.name("READ")
					.build();
			PermissionEntity deployPermission = PermissionEntity
					.builder()
					.name("DEPLOY")
					.build();
			//Crear Roles
			RoleEntity adminRol = RoleEntity
					.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permission(Set.of(createPermission, deletePermission, updatePermission,readPermission))
					.build();
			RoleEntity guestRol = RoleEntity
					.builder()
					.roleEnum(RoleEnum.GUEST)
					.permission(Set.of(readPermission))
					.build();
			RoleEntity userRol = RoleEntity
					.builder()
					.roleEnum(RoleEnum.USER)
					.permission(Set.of(updatePermission,readPermission))
					.build();
			RoleEntity developerRol = RoleEntity
					.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permission(Set.of(createPermission, deletePermission, updatePermission,readPermission, deployPermission))
					.build();

			UserEntity dev = UserEntity
					.builder()
					.username("dev")
					.password("12345")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(developerRol))
					.build();
			UserEntity admin = UserEntity
					.builder()
					.username("administrador")
					.password("12345")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(adminRol))
					.build();
			UserEntity user = UserEntity
					.builder()
					.username("usuario")
					.password("12345")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(userRol))
					.build();
			UserEntity guest = UserEntity
					.builder()
					.username("invitado")
					.password("12345")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(guestRol))
					.build();
			//Guardar
			//userRepository.save(juan);
			//userRepository.save(jose);
			//userRepository.save(admin);
			//userRepository.save(guest1);

			userRepository.saveAll(List.of(user,dev,admin,guest));
		};
	}

}
