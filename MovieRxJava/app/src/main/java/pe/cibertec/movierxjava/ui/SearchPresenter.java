package pe.cibertec.movierxjava.ui;

import android.support.v7.widget.SearchView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pe.cibertec.movierxjava.models.RespuestaPelicula;
import pe.cibertec.movierxjava.network.ClienteNetwork;
import pe.cibertec.movierxjava.network.InterfaceNetwork;

class SearchPresenter implements SearchPresenterInterface{

    SearchViewInterface svi;

    public SearchPresenter(SearchViewInterface svi) {
        this.svi = svi;
    }

    @Override
    public void obtenerPeliculas(SearchView searchView) {


        getObservable(searchView).subscribe(getObserver());
    }

    public Observable<RespuestaPelicula> getObservable(SearchView searchView){
        return ClienteNetwork.getRetrofit()
                .create(InterfaceNetwork.class)
                .getPeliculasPorNombre("3cae426b920b29ed2fb1c0749f258325", searchView.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observer<RespuestaPelicula> getObserver(){
        return new Observer<RespuestaPelicula>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespuestaPelicula respuestaPelicula) {
                svi.mostrarPeliculas(respuestaPelicula);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }



}
