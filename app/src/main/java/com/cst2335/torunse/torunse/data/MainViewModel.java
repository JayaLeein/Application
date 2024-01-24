package com.cst2335.torunse.torunse.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class MainViewModel extends ViewModel {
    //public String editString;
    public MutableLiveData<String> editString = new MutableLiveData<>();
    public MutableLiveData<Boolean> isCoffeeDrinker = new MutableLiveData<>();
    public MutableLiveData<Boolean> drinksCoffee = new MutableLiveData<>(false);
}
