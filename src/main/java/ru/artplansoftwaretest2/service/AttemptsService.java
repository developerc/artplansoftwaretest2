package ru.artplansoftwaretest2.service;

import ru.artplansoftwaretest2.entity.Attempts;

import java.util.List;

public interface AttemptsService {
    /**
     * method for add attempt to base
     *
     * @param attempts = new attempt for creation in DB
     * @return created attempt
     */
    Attempts addAttempts(Attempts attempts);

    /**
     * method for receiving all attempts
     *
     * @return all Attempts
     */
    List<Attempts> getAllAttempts();

    /**
     * method for receive specify Attempts by id
     *
     * @param id = uniq Attempts id
     * @return specify Attempts by id
     */
    Attempts getAttemptsById(long id);

    /**
     * method for attempt delete
     *
     * @param id = Attempt's id for delete
     * @return removed Attempts
     */
    Attempts deleteAttempts(long id);

    /**
     * method for update Attempts
     *
     * @param attempts = update existing attempts in DB
     * @return updated attempts
     */
    Attempts updAttempts(Attempts attempts);
}
