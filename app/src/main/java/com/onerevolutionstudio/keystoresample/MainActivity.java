package com.onerevolutionstudio.keystoresample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        try {
            KeyStoreHelper.createKeys(this, "Test");


         /*   KeyStoreHelper.getPublicKey("Test").subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Log.d("PublicKey ",s);
                }
            });
*/


            KeyStoreHelper.getPublicKeys("Test").subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Log.d("PublicKey ", s);
                }
            });

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
