package kz.aruana15.Web.repositories;

import kz.aruana15.Web.entities.Developers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevRepository extends JpaRepository<Developers, Long> {

    public List<Developers> findAll();


}
