package com;

import com.hystrix.CommandWorld;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.BlockingObservable;

/**
 * Created by Anie on 6/19/2016.
 */
public class CommandWorldTest {


    @Test
    public void testSynchronous() {

        CommandWorld commandWorld=new CommandWorld("World");
        Observable<String> fWorld=commandWorld.observe();
        System.out.println("aaaa");
        CommandWorld commandWorld1=new CommandWorld("World");
        System.out.println("execute "+commandWorld1.execute());
        BlockingObservable<String> obs=fWorld.toBlocking();
        System.out.println("aaaa1111");

        //System.out.println(fWorld.toBlocking());
       //Assert.assertEquals("Hello World!", fWorld.toBlocking().single());
        Subscription fWorld2= fWorld.subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String v) {
                System.out.println("onNext: " + v);
            }

        });

        fWorld.subscribe(new Action1<String>() {

            @Override
            public void call(String v) {
                System.out.println("onNext: " + v);
            }

        });





    }
}
