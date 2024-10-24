package com.example.demo.domains;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Permissao> permissaoList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> papeis = this.permissaoList.stream()
            .map(Permissao::getPermissaoEnum)
            .map(PermissaoEnum::name)
            .map(SimpleGrantedAuthority::new)
            .toList();

        List<SimpleGrantedAuthority> autoridades = new java.util.ArrayList<>(this.permissaoList.stream()
            .map(Permissao::getPermissaoEnum)
            .map(PermissaoEnum::getAutoridades)
            .flatMap(List::stream)
            .map(SimpleGrantedAuthority::new)
            .toList());
        autoridades.addAll(papeis);
        return autoridades;
    }

    @Override
    public String getPassword() {
        return "{noop}" + this.senha;
    }

}
