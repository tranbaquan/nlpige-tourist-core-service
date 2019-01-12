package com.nlpige.tourist.api;

import com.nlpige.tourist.data.DataMaster;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "data")
public class DataApi {

    @PostMapping
    public void init() {
        DataMaster dataMaster = new DataMaster();
        dataMaster.init();
    }
}
