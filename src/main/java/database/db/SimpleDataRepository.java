package database.db;

import database.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity,ID extends Long> implements DataRepository<T,ID>{

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;
    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {

            return Long.compare(o1.getId(), o2.getId());
        }
    };
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
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{
            // 없는 경우
            index++;
            data.setId(index);
            dataList.add(data);
        }

        //unique id

        //index++;
        return data;
    }


    //read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
            .filter(it -> {
                return(it.getId().equals(id));
            })
            .findFirst();
    }

    //전체 아이디
    @Override
    public List<T> findAll() {

        return dataList
            .stream()
            .sorted(sort)
            .collect(Collectors.toList());
    }

    //delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
            .filter(it -> {
                return(it.getId().equals(id));
            })
            .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }
}
