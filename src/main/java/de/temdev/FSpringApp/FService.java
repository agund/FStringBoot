package de.temdev.FSpringApp;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

@Service
public class FService {

    @PersistenceContext
    private EntityManager entityManager;

    public FService()
    {
        System.out.println("Start Konstruktor von FService");
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init()
    {
        System.out.println("Init FService");
    }

    static int counter = 0;

    @Transactional
    public HelloDto hello(String username)
    {
        counter++;
        String format = String.format("Diese Application wurde %s mal aufgerufen von ",counter);
        return new HelloDto(format + " "+ getVisitorList(username));
    }

    private String getVisitorList(String username) {
        AppVisitorList visL = entityManager.find(AppVisitorList.class, 1L);
        if (visL == null) {
            visL = new AppVisitorList();
            entityManager.persist(visL);
        }

        visL.addVisitor(username);
        return visL.getListAsString();
    }
}
