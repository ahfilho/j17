package br.com.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_AUTH_USER_DETAILS")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 20, message = "O nome deve ter entre2 a 20 caracteres")
    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @Column(name = "USER_KEY")
    private String password;

    @Column(name = "CREATED_ON")
    private LocalDate createdAt;

    @Column(name = "UPDATED_ON")
    private LocalDate updatedAt;

    @NotBlank(message = "O perfil não pode estar em branco")
    @Pattern(regexp = "usuario|admin", message = "O perfil deve ser usuario ou admin")
    @Column(name = "USER_TYPE")
    private String profile;

    @Column(name = "ENABLED")
    private boolean enabled = true;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "AUTH_USER_AUTHORITY",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID")
//    )
//    private List<Authority> authorities;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.userName;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.enabled;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.enabled;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.enabled;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
}
