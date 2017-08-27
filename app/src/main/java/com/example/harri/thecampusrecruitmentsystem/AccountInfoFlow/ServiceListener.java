package com.example.harri.thecampusrecruitmentsystem.AccountInfoFlow;

/**
 * Created by harri on 7/17/2017.
 */

public interface ServiceListener<T> {

    public void success(T obj);
    public void error(ServiceError serviceError);

}