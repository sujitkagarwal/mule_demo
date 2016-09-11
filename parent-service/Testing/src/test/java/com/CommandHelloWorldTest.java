package com;

import org.junit.Assert;
import org.junit.Test;
import rx.Observable;
import com.hystrix.CommandHelloWorld;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Anie on 6/18/2016.
 */
public class CommandHelloWorldTest {

    @Test
    public void testObservable() throws Exception {

        Observable<String> fWorld = new CommandHelloWorld("World").observe();
        Observable<String> fBob = new CommandHelloWorld("Bob").observe();

        // blocking
       // Assert.assertEquals("Hello World!", fWorld.toBlocking().single());
       // Assert.assertEquals("Hello Bob!", fBob.toBlocking().single());

        // non-blocking
        // - this is a verbose anonymous inner-class approach and doesn't do assertions
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

        // non-blocking
        // - also verbose anonymous inner-class
        // - ignore errors and onCompleted signal
        fBob.subscribe(new Action1<String>() {

            @Override
            public void call(String v) {
                System.out.println("onNext: " + v);
            }

        });
    }
}
