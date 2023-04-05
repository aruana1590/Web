package kz.aruana15.Web.services;

import kz.aruana15.Web.entities.Developers;
import kz.aruana15.Web.models.dto.DevelopersDtoResponse;

import java.util.List;

public interface DevService {

    Developers insert (DevelopersDtoResponse developersDtoResponse);

    Developers update (Long id, DevelopersDtoResponse developersDtoResponse);

    List<Developers> getAll();
}
