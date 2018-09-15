package pe.cibertec.movierxjava.ui;

import android.support.v7.widget.SearchView;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import pe.cibertec.movierxjava.models.RespuestaPelicula;

class SearchPresenter implements SearchPresenterInterface{

    SearchViewInterface svi;

    public SearchPresenter(SearchViewInterface svi) {
        this.svi = svi;
    }

    @Override
    public void obtenerPeliculas(SearchView searchView) {


       getObservable(searchView);
       getObserver();
    }

    private Observable<String> getObservable(SearchView searchView) {

        final PublishSubject<String> publishSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                publishSubject.onNext(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                publishSubject.onNext(newText);

                return true;
            }
        });
        return publishSubject;
    }

    private DisposableObserver<RespuestaPelicula> getObserver() {
        return new DisposableObserver<RespuestaPelicula>() {
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
