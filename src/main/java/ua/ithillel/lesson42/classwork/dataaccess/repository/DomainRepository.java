package ua.ithillel.lesson42.classwork.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.ithillel.lesson42.classwork.dataaccess.entity.DomainRole;

@NoRepositoryBean
public interface DomainRepository<T, ID> extends JpaRepository<T, ID> {
    DomainRole findDomainRole(long id);
}
