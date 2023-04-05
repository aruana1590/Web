package kz.aruana15.Web.services;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import kz.aruana15.Web.entities.Developers;
import kz.aruana15.Web.exceptions.Message;
import kz.aruana15.Web.exceptions.custom.MismatchedException;
import kz.aruana15.Web.exceptions.custom.NotFoundException;
import kz.aruana15.Web.models.dto.DevelopersDtoResponse;
import kz.aruana15.Web.repositories.DevRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
@Log4j2

public class DevServiceImpl implements DevService {

    private DevRepository devRepository;

    @Autowired
    public DevServiceImpl(DevRepository devRepository) {
        this.devRepository = devRepository;
    }

    @Override
    public Developers insert(DevelopersDtoResponse developersDtoResponse)  {
     String b1 = developersDtoResponse.getFio();//true
       Integer b2 = developersDtoResponse.getSalary();//true
        //Developers developers  = new Developers();
    /* try {
        if ((b1 instanceof String) | ){
            throw new InputMismatchException(Message.WRONG_DATA_TYPE);}
        if((b2 instanceof Integer)){
            throw new InputMismatchException(Message.WRONG_DATA_TYPE);}

      }catch(Exception e){

       }*/
        if (b1 instanceof String | b1.isBlank())
            throw new MismatchedException(Message.WRONG_DATA_TYPE);
        if(b2 instanceof Integer)
            throw new MismatchedException(Message.WRONG_DATA_TYPE);
        try {
            Developers developers = new Developers();
            developers.setFio(developersDtoResponse.getFio());
            developers.setSalary(developersDtoResponse.getSalary());
            return devRepository.save(developers);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new NotFoundException(Message.NOT_CREATED +" " + Message.WRONG_DATA_TYPE);

        }
        //developers.setFio(developersDtoResponse.getFio());
      //  developers.setSalary(developersDtoResponse.getSalary());
      //  return devRepository.save(developers);
    }
    @Override
    public Developers update(Long id, DevelopersDtoResponse developersDtoResponse) {
        Developers updatingNote = devRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_ID));
        updatingNote.setSalary(developersDtoResponse.getSalary());
        return devRepository.save(updatingNote);
    }

    @Override
    public List<Developers> getAll() {
        return devRepository.findAll();
    }
}
