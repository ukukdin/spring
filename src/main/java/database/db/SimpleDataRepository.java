package database.db;

import database.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class SimpleDataRepository<T extends Entity,ID extends Long> implements DataRepository<T,ID>{

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    //create  // update는 같이 이루어진다.

    @Override
    public T save(T data) {

        if(Objects.isNull(data)){
           throw new RuntimeException("Data is null");
        }
        //db에 데이터가 있는가?? 이전 데이터를 찾아보는 구문
        var prevData = dataList.stream()
            .filter(it -> {
                return it.getId().equals(data.getId());
            })
            .findFirst();
        if(prevData.isPresent()){
            //기존 데이터가 있는 경우
            dataList.remove(prevData);
            dataList.add(data);
        }else{
            // 없는 경우
            index++;
            data.setId(index);
            dataList.add(data);
        }

        //unique id

        index++;
        return null;
    }


    //read

    //update

    //delete

}
