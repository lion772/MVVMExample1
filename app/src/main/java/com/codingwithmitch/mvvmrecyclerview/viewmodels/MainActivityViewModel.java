package com.codingwithmitch.mvvmrecyclerview.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.codingwithmitch.mvvmrecyclerview.models.NicePlace;
import com.codingwithmitch.mvvmrecyclerview.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){ //Se for diferente de nulo, não busca no repositório
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public void addNewValue(final NicePlace nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue(); //Tipo de lista não alterável
                currentPlaces.add(nicePlace); //Se a lista é não alterável, por que aqui consegue adicionar novos itens e no kotlin tenho que passar para mutableList?
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
